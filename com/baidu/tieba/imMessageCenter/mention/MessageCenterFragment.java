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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class MessageCenterFragment extends BaseFragment implements VoiceManager.c {
    private VoiceManager djz;
    private g eDt;
    private int eDu = 0;
    private int eDv = 0;
    private int eDw = 0;
    private int aDR = 0;
    private boolean aDS = false;
    private int aDT = 0;
    private boolean aDU = false;
    private int aDV = 0;
    private boolean aDW = false;
    private TbTabLayout.b eDx = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.aDS && MessageCenterFragment.this.eDw > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Dp().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.eDt.f(eVar.getId(), MessageCenterFragment.this.aDR, MessageCenterFragment.this.aDS);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.aDW) {
                        MessageCenterFragment.this.aNW();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dp().Dw();
                    MessageCenterFragment.this.eDt.f(eVar.getId(), MessageCenterFragment.this.aDV, MessageCenterFragment.this.aDW);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.eDt.f(eVar.getId(), MessageCenterFragment.this.aDT, MessageCenterFragment.this.aDU);
                }
                MessageCenterFragment.this.ox(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.eDt != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.eDt.aNX());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.eDt != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(2016322, (Class) null);
                    com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.eDt.aNX());
                }
                MessageCenterFragment.this.ox(eVar.getId());
            }
        }
    };
    private CustomMessageListener eDy = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3 && MessageCenterFragment.this.aNT()) {
                if ((MessageCenterFragment.this.isPrimary() || MessageCenterFragment.this.eDw > 0) && MessageCenterFragment.this.getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener eDz = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.h(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aNT() {
        return this.eDt != null && this.eDt.oz(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.eDy);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.message_center_activity, viewGroup, false);
        this.eDt = new g(this);
        this.eDt.a(inflate, bundle);
        this.eDt.selectTab(2);
        this.eDt.a(this.eDx);
        this.eDz.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.eDz);
        a(getActivity().getIntent(), bundle);
        this.djz = getVoiceManager();
        this.djz.onCreate(getPageContext());
        TiebaStatic.log(new an("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.aIA().aIB();
        if (this.djz == null) {
            this.djz = getVoiceManager();
            this.djz.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.eDt != null) {
            this.eDt.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e aNY;
        if (this.eDt != null && (aNY = this.eDt.aNY()) != null) {
            bundle.putInt("Selected_Tab", aNY.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.eDt != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eDt != null) {
            this.eDt.onChangeSkinType(this.mSkinType);
        }
    }

    public void aNU() {
        getActivity().finish();
    }

    public void aNV() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage(2002001, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.aDS) {
                i = 1;
            } else if (this.aDU) {
                i = 2;
            } else if (this.aDW) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.eDt != null) {
            this.eDt.selectTab(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.eDw;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.eDu = newsRemindMessage.getMsgAgreeCount();
            this.eDv = newsRemindMessage.getMsgAtCount();
            this.eDw = newsRemindMessage.getMsgReplyCount();
            this.aDR = newsRemindMessage.getMsgCount();
            this.aDS = newsRemindMessage.hasMsgRemind();
            this.aDT = newsRemindMessage.getChatCount();
            this.aDU = newsRemindMessage.hasChatRemind();
            this.aDV = newsRemindMessage.getNotificationCount();
            this.aDW = newsRemindMessage.hasNotificationRemind();
            if (this.eDt != null) {
                if (i > 0 && this.eDw == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, getPageContext().getUniqueId()));
                }
                this.eDt.f(1, this.aDR, this.aDS);
                this.eDt.f(2, this.aDT, this.aDU);
                if (this.eDt.oz(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dp().Dw();
                    if (this.aDW) {
                        aNW();
                        return;
                    }
                }
                this.eDt.f(3, this.aDV, this.aDW);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNW() {
        HashSet hashSet;
        HashMap<Integer, HashSet> DN = com.baidu.tbadk.coreExtra.messageCenter.a.Dp().DN();
        if (DN != null && DN.size() > 0 && (hashSet = DN.get(0)) != null && hashSet.size() > 0) {
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
    public void ox(int i) {
        if (i == 1) {
            TiebaStatic.log(new an("c12937").r("obj_type", 1));
        } else if (i == 2) {
            TiebaStatic.log(new an("c12937").r("obj_type", 2));
        } else if (i == 3) {
            TiebaStatic.log(new an("c12937").r("obj_type", 3));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.aIA().aIB();
        MessageManager.getInstance().unRegisterListener(this.eDz);
        if (this.eDt != null) {
            this.eDt.aNZ();
            this.eDt.b(this.eDx);
        }
        if (this.djz != null) {
            this.djz.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.djz == null) {
            this.djz = VoiceManager.instance();
        }
        return this.djz;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.djz != null) {
            this.djz.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.djz != null) {
            this.djz.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.djz != null) {
            this.djz.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.djz != null) {
            this.djz.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.eDt != null) {
            this.eDt.setPrimary(z);
        }
    }
}
