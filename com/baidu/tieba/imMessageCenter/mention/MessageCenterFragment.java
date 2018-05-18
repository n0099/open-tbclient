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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class MessageCenterFragment extends BaseFragment implements VoiceManager.c {
    private VoiceManager cYn;
    private g eom;
    private int eon = 0;
    private int eoo = 0;
    private int eop = 0;
    private int auM = 0;
    private boolean auN = false;
    private int auO = 0;
    private boolean auP = false;
    private int auQ = 0;
    private boolean auR = false;
    private TbTabLayout.b eoq = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.auN && MessageCenterFragment.this.eop > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.zw().setMsgReplyme(0);
                    }
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.auR) {
                        MessageCenterFragment.this.aIv();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.a.zw().zD();
                }
                MessageCenterFragment.this.oe(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.eom != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.eom.aIw());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.eom != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(2016322, (Class) null);
                    com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.eom.aIw());
                }
                MessageCenterFragment.this.oe(eVar.getId());
            }
        }
    };
    private CustomMessageListener eor = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3 && MessageCenterFragment.this.aIs()) {
                if ((MessageCenterFragment.this.isPrimary() || MessageCenterFragment.this.eop > 0) && MessageCenterFragment.this.getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener eos = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.g(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aIs() {
        return this.eom != null && this.eom.og(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.eor);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.message_center_activity, viewGroup, false);
        this.eom = new g(this);
        this.eom.a(inflate, bundle);
        this.eom.selectTab(2);
        this.eom.a(this.eoq);
        this.eos.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.eos);
        a(getActivity().getIntent(), bundle);
        this.cYn = getVoiceManager();
        this.cYn.onCreate(getPageContext());
        TiebaStatic.log(new al("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.aCY().aCZ();
        if (this.cYn == null) {
            this.cYn = getVoiceManager();
            this.cYn.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.eom != null) {
            this.eom.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e aIx;
        if (this.eom != null && (aIx = this.eom.aIx()) != null) {
            bundle.putInt("Selected_Tab", aIx.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.eom != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eom != null) {
            this.eom.onChangeSkinType(this.mSkinType);
        }
    }

    public void aIt() {
        getActivity().finish();
    }

    public void aIu() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage(2002001, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.auN) {
                i = 1;
            } else if (this.auP) {
                i = 2;
            } else if (this.auR) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.eom != null) {
            this.eom.selectTab(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.eop;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.eon = newsRemindMessage.getMsgAgreeCount();
            this.eoo = newsRemindMessage.getMsgAtCount();
            this.eop = newsRemindMessage.getMsgReplyCount();
            this.auM = newsRemindMessage.getMsgCount();
            this.auN = newsRemindMessage.hasMsgRemind();
            this.auO = newsRemindMessage.getChatCount();
            this.auP = newsRemindMessage.hasChatRemind();
            this.auQ = newsRemindMessage.getNotificationCount();
            this.auR = newsRemindMessage.hasNotificationRemind();
            if (this.eom != null) {
                if (i > 0 && this.eop == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, getPageContext().getUniqueId()));
                }
                this.eom.f(1, this.auM, this.auN);
                this.eom.f(2, this.auO, this.auP);
                if (this.eom.og(3)) {
                    if (this.auR) {
                        aIv();
                        return;
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.a.zw().zD();
                }
                this.eom.f(3, this.auQ, this.auR);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIv() {
        HashSet hashSet;
        HashMap<Integer, HashSet> zU = com.baidu.tbadk.coreExtra.messageCenter.a.zw().zU();
        if (zU != null && zU.size() > 0 && (hashSet = zU.get(0)) != null && hashSet.size() > 0) {
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
    public void oe(int i) {
        if (i == 1) {
            TiebaStatic.log(new al("c12937").r("obj_type", 1));
        } else if (i == 2) {
            TiebaStatic.log(new al("c12937").r("obj_type", 2));
        } else if (i == 3) {
            TiebaStatic.log(new al("c12937").r("obj_type", 3));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.aCY().aCZ();
        MessageManager.getInstance().unRegisterListener(this.eos);
        if (this.eom != null) {
            this.eom.aIy();
            this.eom.b(this.eoq);
        }
        if (this.cYn != null) {
            this.cYn.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cYn == null) {
            this.cYn = VoiceManager.instance();
        }
        return this.cYn;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.cYn != null) {
            this.cYn.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.cYn != null) {
            this.cYn.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cYn != null) {
            this.cYn.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.cYn != null) {
            this.cYn.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.eom != null) {
            this.eom.setPrimary(z);
        }
    }
}
