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
    private VoiceManager dmp;
    private g eHn;
    private int eHo = 0;
    private int eHp = 0;
    private int eHq = 0;
    private int aDR = 0;
    private boolean aDS = false;
    private int aDT = 0;
    private boolean aDU = false;
    private int aDV = 0;
    private boolean aDW = false;
    private TbTabLayout.b eHr = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.aDS && MessageCenterFragment.this.eHq > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Dl().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.eHn.f(eVar.getId(), MessageCenterFragment.this.aDR, MessageCenterFragment.this.aDS);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.aDW) {
                        MessageCenterFragment.this.aOW();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dl().Ds();
                    MessageCenterFragment.this.eHn.f(eVar.getId(), MessageCenterFragment.this.aDV, MessageCenterFragment.this.aDW);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.eHn.f(eVar.getId(), MessageCenterFragment.this.aDT, MessageCenterFragment.this.aDU);
                }
                MessageCenterFragment.this.oL(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.eHn != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.a(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.eHn.aOX());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.eHn != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(2016322, (Class) null);
                    com.baidu.adp.lib.util.l.a(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.eHn.aOX());
                }
                MessageCenterFragment.this.oL(eVar.getId());
            }
        }
    };
    private CustomMessageListener eHs = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3 && MessageCenterFragment.this.aOT()) {
                if ((MessageCenterFragment.this.isPrimary() || MessageCenterFragment.this.eHq > 0) && MessageCenterFragment.this.getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener eHt = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.h(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aOT() {
        return this.eHn != null && this.eHn.oO(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.eHs);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.message_center_activity, viewGroup, false);
        this.eHn = new g(this);
        this.eHn.a(inflate, bundle);
        this.eHn.oM(2);
        this.eHn.a(this.eHr);
        this.eHt.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.eHt);
        a(getActivity().getIntent(), bundle);
        this.dmp = getVoiceManager();
        this.dmp.onCreate(getPageContext());
        TiebaStatic.log(new an("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.aJB().aJC();
        if (this.dmp == null) {
            this.dmp = getVoiceManager();
            this.dmp.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.eHn != null) {
            this.eHn.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e aOY;
        if (this.eHn != null && (aOY = this.eHn.aOY()) != null) {
            bundle.putInt("Selected_Tab", aOY.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.eHn != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eHn != null) {
            this.eHn.onChangeSkinType(this.mSkinType);
        }
    }

    public void aOU() {
        getActivity().finish();
    }

    public void aOV() {
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
        if (this.eHn != null) {
            this.eHn.oM(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.eHq;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.eHo = newsRemindMessage.getMsgAgreeCount();
            this.eHp = newsRemindMessage.getMsgAtCount();
            this.eHq = newsRemindMessage.getMsgReplyCount();
            this.aDR = newsRemindMessage.getMsgCount();
            this.aDS = newsRemindMessage.hasMsgRemind();
            this.aDT = newsRemindMessage.getChatCount();
            this.aDU = newsRemindMessage.hasChatRemind();
            this.aDV = newsRemindMessage.getNotificationCount();
            this.aDW = newsRemindMessage.hasNotificationRemind();
            if (this.eHn != null) {
                if (i > 0 && this.eHq == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, getPageContext().getUniqueId()));
                }
                this.eHn.f(1, this.aDR, this.aDS);
                this.eHn.f(2, this.aDT, this.aDU);
                if (this.eHn.oO(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dl().Ds();
                    if (this.aDW) {
                        aOW();
                        return;
                    }
                }
                this.eHn.f(3, this.aDV, this.aDW);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOW() {
        HashSet hashSet;
        HashMap<Integer, HashSet> DJ = com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DJ();
        if (DJ != null && DJ.size() > 0 && (hashSet = DJ.get(0)) != null && hashSet.size() > 0) {
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
    public void oL(int i) {
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
        com.baidu.tieba.im.db.e.aJB().aJC();
        MessageManager.getInstance().unRegisterListener(this.eHt);
        if (this.eHn != null) {
            this.eHn.aOZ();
            this.eHn.b(this.eHr);
        }
        if (this.dmp != null) {
            this.dmp.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dmp == null) {
            this.dmp = VoiceManager.instance();
        }
        return this.dmp;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dmp != null) {
            this.dmp.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dmp != null) {
            this.dmp.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dmp != null) {
            this.dmp.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dmp != null) {
            this.dmp.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.eHn != null) {
            this.eHn.setPrimary(z);
        }
    }
}
