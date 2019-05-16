package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class MessageCenterFragment extends BaseFragment implements VoiceManager.c {
    private VoiceManager foO;
    private g gOX;
    private int gOY = 0;
    private int gOZ = 0;
    private int gPa = 0;
    private int cgW = 0;
    private boolean cgX = false;
    private int cgY = 0;
    private boolean cgZ = false;
    private int cha = 0;
    private boolean chb = false;
    private TbTabLayout.b gPb = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.cgX && MessageCenterFragment.this.gPa > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.amy().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.gOX.j(eVar.getId(), MessageCenterFragment.this.cgW, MessageCenterFragment.this.cgX);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.chb) {
                        MessageCenterFragment.this.bFh();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.b.amy().amF();
                    MessageCenterFragment.this.gOX.j(eVar.getId(), MessageCenterFragment.this.cha, MessageCenterFragment.this.chb);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.gOX.j(eVar.getId(), MessageCenterFragment.this.cgY, MessageCenterFragment.this.cgZ);
                }
                MessageCenterFragment.this.vB(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.gOX != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.gOX.bFi());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.gOX != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(2016322, (Class) null);
                    com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.gOX.bFi());
                }
                MessageCenterFragment.this.vB(eVar.getId());
            }
        }
    };
    private CustomMessageListener gPc = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3 && MessageCenterFragment.this.bFe()) {
                if ((MessageCenterFragment.this.isPrimary() || MessageCenterFragment.this.gPa > 0) && MessageCenterFragment.this.getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener gPd = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.i(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bFe() {
        return this.gOX != null && this.gOX.qg(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gPc);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.message_center_activity, viewGroup, false);
        this.gOX = new g(this);
        this.gOX.a(inflate, bundle);
        this.gOX.qf(2);
        this.gOX.a(this.gPb);
        this.gPd.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.gPd);
        a(getActivity().getIntent(), bundle);
        this.foO = getVoiceManager();
        this.foO.onCreate(getPageContext());
        TiebaStatic.log(new am("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.bzS().bzT();
        if (this.foO == null) {
            this.foO = getVoiceManager();
            this.foO.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.gOX != null) {
            this.gOX.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e bFj;
        if (this.gOX != null && (bFj = this.gOX.bFj()) != null) {
            bundle.putInt("Selected_Tab", bFj.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.gOX != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gOX != null) {
            this.gOX.onChangeSkinType(this.mSkinType);
        }
    }

    public void bFf() {
        getActivity().finish();
    }

    public void bFg() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage(2002001, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.cgX) {
                i = 1;
            } else if (this.cgZ) {
                i = 2;
            } else if (this.chb) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.gOX != null) {
            this.gOX.qf(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.gPa;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.gOY = newsRemindMessage.getMsgAgreeCount();
            this.gOZ = newsRemindMessage.getMsgAtCount();
            this.gPa = newsRemindMessage.getMsgReplyCount();
            this.cgW = newsRemindMessage.getMsgCount();
            this.cgX = newsRemindMessage.hasMsgRemind();
            this.cgY = newsRemindMessage.getChatCount();
            this.cgZ = newsRemindMessage.hasChatRemind();
            this.cha = newsRemindMessage.getNotificationCount();
            this.chb = newsRemindMessage.hasNotificationRemind();
            if (this.gOX != null) {
                if (i > 0 && this.gPa == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, getPageContext().getUniqueId()));
                }
                this.gOX.j(1, this.cgW, this.cgX);
                this.gOX.j(2, this.cgY, this.cgZ);
                if (this.gOX.qg(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.amy().amF();
                    if (this.chb) {
                        bFh();
                        return;
                    }
                }
                this.gOX.j(3, this.cha, this.chb);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFh() {
        HashSet hashSet;
        HashMap<Integer, HashSet> amW = com.baidu.tbadk.coreExtra.messageCenter.b.amy().amW();
        if (amW != null && amW.size() > 0 && (hashSet = amW.get(0)) != null && hashSet.size() > 0) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!TextUtils.isEmpty(str)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(str, 4)));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vB(int i) {
        if (i == 1) {
            TiebaStatic.log(new am("c12937").P("obj_type", 1));
        } else if (i == 2) {
            TiebaStatic.log(new am("c12937").P("obj_type", 2));
        } else if (i == 3) {
            TiebaStatic.log(new am("c12937").P("obj_type", 3));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.bzS().bzT();
        MessageManager.getInstance().unRegisterListener(this.gPd);
        if (this.gOX != null) {
            this.gOX.bdV();
            this.gOX.b(this.gPb);
        }
        if (this.foO != null) {
            this.foO.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.foO == null) {
            this.foO = VoiceManager.instance();
        }
        return this.foO;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.foO != null) {
            this.foO.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.foO != null) {
            this.foO.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.foO != null) {
            this.foO.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.foO != null) {
            this.foO.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.gOX != null) {
            this.gOX.setPrimary(z);
        }
    }
}
