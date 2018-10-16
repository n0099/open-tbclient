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
import com.baidu.tieba.e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class MessageCenterFragment extends BaseFragment implements VoiceManager.c {
    private VoiceManager dAm;
    private g eWg;
    private int eWh = 0;
    private int eWi = 0;
    private int eWj = 0;
    private int aLz = 0;
    private boolean aLA = false;
    private int aLB = 0;
    private boolean aLC = false;
    private int aLD = 0;
    private boolean aLE = false;
    private TbTabLayout.b eWk = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.aLA && MessageCenterFragment.this.eWj > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gz().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.eWg.f(eVar.getId(), MessageCenterFragment.this.aLz, MessageCenterFragment.this.aLA);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.aLE) {
                        MessageCenterFragment.this.aUw();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.a.Gz().GG();
                    MessageCenterFragment.this.eWg.f(eVar.getId(), MessageCenterFragment.this.aLD, MessageCenterFragment.this.aLE);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.eWg.f(eVar.getId(), MessageCenterFragment.this.aLB, MessageCenterFragment.this.aLC);
                }
                MessageCenterFragment.this.pN(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.eWg != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.a(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.eWg.aUx());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.eWg != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(2016322, (Class) null);
                    com.baidu.adp.lib.util.l.a(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.eWg.aUx());
                }
                MessageCenterFragment.this.pN(eVar.getId());
            }
        }
    };
    private CustomMessageListener eWl = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3 && MessageCenterFragment.this.aUt()) {
                if ((MessageCenterFragment.this.isPrimary() || MessageCenterFragment.this.eWj > 0) && MessageCenterFragment.this.getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener eWm = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.h(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aUt() {
        return this.eWg != null && this.eWg.pQ(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.eWl);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.message_center_activity, viewGroup, false);
        this.eWg = new g(this);
        this.eWg.a(inflate, bundle);
        this.eWg.pO(2);
        this.eWg.a(this.eWk);
        this.eWm.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.eWm);
        a(getActivity().getIntent(), bundle);
        this.dAm = getVoiceManager();
        this.dAm.onCreate(getPageContext());
        TiebaStatic.log(new am("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.aPc().aPd();
        if (this.dAm == null) {
            this.dAm = getVoiceManager();
            this.dAm.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.eWg != null) {
            this.eWg.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e aUy;
        if (this.eWg != null && (aUy = this.eWg.aUy()) != null) {
            bundle.putInt("Selected_Tab", aUy.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.eWg != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eWg != null) {
            this.eWg.onChangeSkinType(this.mSkinType);
        }
    }

    public void aUu() {
        getActivity().finish();
    }

    public void aUv() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage(2002001, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.aLA) {
                i = 1;
            } else if (this.aLC) {
                i = 2;
            } else if (this.aLE) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.eWg != null) {
            this.eWg.pO(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.eWj;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.eWh = newsRemindMessage.getMsgAgreeCount();
            this.eWi = newsRemindMessage.getMsgAtCount();
            this.eWj = newsRemindMessage.getMsgReplyCount();
            this.aLz = newsRemindMessage.getMsgCount();
            this.aLA = newsRemindMessage.hasMsgRemind();
            this.aLB = newsRemindMessage.getChatCount();
            this.aLC = newsRemindMessage.hasChatRemind();
            this.aLD = newsRemindMessage.getNotificationCount();
            this.aLE = newsRemindMessage.hasNotificationRemind();
            if (this.eWg != null) {
                if (i > 0 && this.eWj == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, getPageContext().getUniqueId()));
                }
                this.eWg.f(1, this.aLz, this.aLA);
                this.eWg.f(2, this.aLB, this.aLC);
                if (this.eWg.pQ(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Gz().GG();
                    if (this.aLE) {
                        aUw();
                        return;
                    }
                }
                this.eWg.f(3, this.aLD, this.aLE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUw() {
        HashSet hashSet;
        HashMap<Integer, HashSet> GX = com.baidu.tbadk.coreExtra.messageCenter.a.Gz().GX();
        if (GX != null && GX.size() > 0 && (hashSet = GX.get(0)) != null && hashSet.size() > 0) {
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
    public void pN(int i) {
        if (i == 1) {
            TiebaStatic.log(new am("c12937").x("obj_type", 1));
        } else if (i == 2) {
            TiebaStatic.log(new am("c12937").x("obj_type", 2));
        } else if (i == 3) {
            TiebaStatic.log(new am("c12937").x("obj_type", 3));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.aPc().aPd();
        MessageManager.getInstance().unRegisterListener(this.eWm);
        if (this.eWg != null) {
            this.eWg.aUz();
            this.eWg.b(this.eWk);
        }
        if (this.dAm != null) {
            this.dAm.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dAm == null) {
            this.dAm = VoiceManager.instance();
        }
        return this.dAm;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dAm != null) {
            this.dAm.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dAm != null) {
            this.dAm.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dAm != null) {
            this.dAm.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dAm != null) {
            this.dAm.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.eWg != null) {
            this.eWg.setPrimary(z);
        }
    }
}
