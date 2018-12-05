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
    private VoiceManager dIc;
    private g feo;
    private int fep = 0;
    private int feq = 0;
    private int fer = 0;
    private int aPO = 0;
    private boolean aPP = false;
    private int aPQ = 0;
    private boolean aPR = false;
    private int aPS = 0;
    private boolean aPT = false;
    private TbTabLayout.b fes = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.aPP && MessageCenterFragment.this.fer > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.HP().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.feo.g(eVar.getId(), MessageCenterFragment.this.aPO, MessageCenterFragment.this.aPP);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.aPT) {
                        MessageCenterFragment.this.aVL();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.a.HP().HW();
                    MessageCenterFragment.this.feo.g(eVar.getId(), MessageCenterFragment.this.aPS, MessageCenterFragment.this.aPT);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.feo.g(eVar.getId(), MessageCenterFragment.this.aPQ, MessageCenterFragment.this.aPR);
                }
                MessageCenterFragment.this.qA(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.feo != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.feo.aVM());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.feo != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(2016322, (Class) null);
                    com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.feo.aVM());
                }
                MessageCenterFragment.this.qA(eVar.getId());
            }
        }
    };
    private CustomMessageListener fet = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3 && MessageCenterFragment.this.aVI()) {
                if ((MessageCenterFragment.this.isPrimary() || MessageCenterFragment.this.fer > 0) && MessageCenterFragment.this.getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener feu = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.h(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aVI() {
        return this.feo != null && this.feo.qD(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.fet);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.message_center_activity, viewGroup, false);
        this.feo = new g(this);
        this.feo.a(inflate, bundle);
        this.feo.qB(2);
        this.feo.a(this.fes);
        this.feu.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.feu);
        a(getActivity().getIntent(), bundle);
        this.dIc = getVoiceManager();
        this.dIc.onCreate(getPageContext());
        TiebaStatic.log(new am("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.aQr().aQs();
        if (this.dIc == null) {
            this.dIc = getVoiceManager();
            this.dIc.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.feo != null) {
            this.feo.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e aVN;
        if (this.feo != null && (aVN = this.feo.aVN()) != null) {
            bundle.putInt("Selected_Tab", aVN.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.feo != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.feo != null) {
            this.feo.onChangeSkinType(this.mSkinType);
        }
    }

    public void aVJ() {
        getActivity().finish();
    }

    public void aVK() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage(2002001, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.aPP) {
                i = 1;
            } else if (this.aPR) {
                i = 2;
            } else if (this.aPT) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.feo != null) {
            this.feo.qB(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.fer;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.fep = newsRemindMessage.getMsgAgreeCount();
            this.feq = newsRemindMessage.getMsgAtCount();
            this.fer = newsRemindMessage.getMsgReplyCount();
            this.aPO = newsRemindMessage.getMsgCount();
            this.aPP = newsRemindMessage.hasMsgRemind();
            this.aPQ = newsRemindMessage.getChatCount();
            this.aPR = newsRemindMessage.hasChatRemind();
            this.aPS = newsRemindMessage.getNotificationCount();
            this.aPT = newsRemindMessage.hasNotificationRemind();
            if (this.feo != null) {
                if (i > 0 && this.fer == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, getPageContext().getUniqueId()));
                }
                this.feo.g(1, this.aPO, this.aPP);
                this.feo.g(2, this.aPQ, this.aPR);
                if (this.feo.qD(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.HP().HW();
                    if (this.aPT) {
                        aVL();
                        return;
                    }
                }
                this.feo.g(3, this.aPS, this.aPT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVL() {
        HashSet hashSet;
        HashMap<Integer, HashSet> In = com.baidu.tbadk.coreExtra.messageCenter.a.HP().In();
        if (In != null && In.size() > 0 && (hashSet = In.get(0)) != null && hashSet.size() > 0) {
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
    public void qA(int i) {
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
        com.baidu.tieba.im.db.e.aQr().aQs();
        MessageManager.getInstance().unRegisterListener(this.feu);
        if (this.feo != null) {
            this.feo.aVO();
            this.feo.b(this.fes);
        }
        if (this.dIc != null) {
            this.dIc.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dIc == null) {
            this.dIc = VoiceManager.instance();
        }
        return this.dIc;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dIc != null) {
            this.dIc.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dIc != null) {
            this.dIc.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dIc != null) {
            this.dIc.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dIc != null) {
            this.dIc.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.feo != null) {
            this.feo.setPrimary(z);
        }
    }
}
