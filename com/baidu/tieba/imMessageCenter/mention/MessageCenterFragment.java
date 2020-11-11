package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ActivityChooserView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class MessageCenterFragment extends BaseFragment implements VoiceManager.c {
    private VoiceManager iHo;
    private g kuQ;
    private TbTabLayout.b kuR = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar == null) {
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
        }
    };
    private CustomMessageListener kuS = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        private boolean kuV = true;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3 && MessageCenterFragment.this.isPrimary() && MessageCenterFragment.this.kuQ != null) {
                MessageCenterFragment.this.kuQ.cJx();
            }
        }
    };
    private final CustomMessageListener kuT = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.j(customResponsedMessage);
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.kuS);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.message_center_activity, viewGroup, false);
        this.kuQ = new g(this);
        this.kuQ.a(inflate, bundle);
        this.kuQ.DI(2);
        this.kuQ.a(this.kuR);
        this.kuT.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.kuT);
        a(getActivity().getIntent(), bundle);
        this.iHo = getVoiceManager();
        this.iHo.onCreate(getPageContext());
        TiebaStatic.log(new aq("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.cQW().cQX();
        if (this.iHo == null) {
            this.iHo = getVoiceManager();
            this.iHo.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.kuQ != null) {
            this.kuQ.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e cWH;
        if (this.kuQ != null && (cWH = this.kuQ.cWH()) != null) {
            bundle.putInt("Selected_Tab", cWH.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.kuQ != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kuQ != null) {
            this.kuQ.onChangeSkinType(this.mSkinType);
        }
    }

    public void cWF() {
        getActivity().finish();
    }

    public void cWG() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        if (this.kuQ != null) {
            this.kuQ.DI(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && !(responsedMessage instanceof NewsRemindMessage)) {
            BdLog.e("transform error");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.cQW().cQX();
        MessageManager.getInstance().unRegisterListener(this.kuT);
        if (this.kuQ != null) {
            this.kuQ.ajE();
            this.kuQ.b(this.kuR);
        }
        if (this.iHo != null) {
            this.iHo.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iHo == null) {
            this.iHo = VoiceManager.instance();
        }
        return this.iHo;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.iHo != null) {
            this.iHo.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.iHo != null) {
            this.iHo.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.iHo != null) {
            this.iHo.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.iHo != null) {
            this.iHo.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.kuQ != null) {
            this.kuQ.setPrimary(z);
        }
    }
}
