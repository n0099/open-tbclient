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
    private VoiceManager dBD;
    private g eXz;
    private int eXA = 0;
    private int eXB = 0;
    private int eXC = 0;
    private int aMp = 0;
    private boolean aMq = false;
    private int aMr = 0;
    private boolean aMs = false;
    private int aMt = 0;
    private boolean aMu = false;
    private TbTabLayout.b eXD = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.aMq && MessageCenterFragment.this.eXC > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.GL().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.eXz.g(eVar.getId(), MessageCenterFragment.this.aMp, MessageCenterFragment.this.aMq);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.aMu) {
                        MessageCenterFragment.this.aTT();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.a.GL().GS();
                    MessageCenterFragment.this.eXz.g(eVar.getId(), MessageCenterFragment.this.aMt, MessageCenterFragment.this.aMu);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.eXz.g(eVar.getId(), MessageCenterFragment.this.aMr, MessageCenterFragment.this.aMs);
                }
                MessageCenterFragment.this.qg(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.eXz != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.eXz.aTU());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.eXz != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(2016322, (Class) null);
                    com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.eXz.aTU());
                }
                MessageCenterFragment.this.qg(eVar.getId());
            }
        }
    };
    private CustomMessageListener eXE = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3 && MessageCenterFragment.this.aTQ()) {
                if ((MessageCenterFragment.this.isPrimary() || MessageCenterFragment.this.eXC > 0) && MessageCenterFragment.this.getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener eXF = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.h(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aTQ() {
        return this.eXz != null && this.eXz.qj(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.eXE);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.message_center_activity, viewGroup, false);
        this.eXz = new g(this);
        this.eXz.a(inflate, bundle);
        this.eXz.qh(2);
        this.eXz.a(this.eXD);
        this.eXF.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.eXF);
        a(getActivity().getIntent(), bundle);
        this.dBD = getVoiceManager();
        this.dBD.onCreate(getPageContext());
        TiebaStatic.log(new am("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.aOz().aOA();
        if (this.dBD == null) {
            this.dBD = getVoiceManager();
            this.dBD.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.eXz != null) {
            this.eXz.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e aTV;
        if (this.eXz != null && (aTV = this.eXz.aTV()) != null) {
            bundle.putInt("Selected_Tab", aTV.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.eXz != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eXz != null) {
            this.eXz.onChangeSkinType(this.mSkinType);
        }
    }

    public void aTR() {
        getActivity().finish();
    }

    public void aTS() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage(2002001, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.aMq) {
                i = 1;
            } else if (this.aMs) {
                i = 2;
            } else if (this.aMu) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.eXz != null) {
            this.eXz.qh(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.eXC;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.eXA = newsRemindMessage.getMsgAgreeCount();
            this.eXB = newsRemindMessage.getMsgAtCount();
            this.eXC = newsRemindMessage.getMsgReplyCount();
            this.aMp = newsRemindMessage.getMsgCount();
            this.aMq = newsRemindMessage.hasMsgRemind();
            this.aMr = newsRemindMessage.getChatCount();
            this.aMs = newsRemindMessage.hasChatRemind();
            this.aMt = newsRemindMessage.getNotificationCount();
            this.aMu = newsRemindMessage.hasNotificationRemind();
            if (this.eXz != null) {
                if (i > 0 && this.eXC == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, getPageContext().getUniqueId()));
                }
                this.eXz.g(1, this.aMp, this.aMq);
                this.eXz.g(2, this.aMr, this.aMs);
                if (this.eXz.qj(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.GL().GS();
                    if (this.aMu) {
                        aTT();
                        return;
                    }
                }
                this.eXz.g(3, this.aMt, this.aMu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTT() {
        HashSet hashSet;
        HashMap<Integer, HashSet> Hj = com.baidu.tbadk.coreExtra.messageCenter.a.GL().Hj();
        if (Hj != null && Hj.size() > 0 && (hashSet = Hj.get(0)) != null && hashSet.size() > 0) {
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
    public void qg(int i) {
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
        com.baidu.tieba.im.db.e.aOz().aOA();
        MessageManager.getInstance().unRegisterListener(this.eXF);
        if (this.eXz != null) {
            this.eXz.aTW();
            this.eXz.b(this.eXD);
        }
        if (this.dBD != null) {
            this.dBD.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dBD == null) {
            this.dBD = VoiceManager.instance();
        }
        return this.dBD;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dBD != null) {
            this.dBD.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dBD != null) {
            this.dBD.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dBD != null) {
            this.dBD.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dBD != null) {
            this.dBD.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.eXz != null) {
            this.eXz.setPrimary(z);
        }
    }
}
