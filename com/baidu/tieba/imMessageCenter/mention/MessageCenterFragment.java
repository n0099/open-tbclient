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
    private VoiceManager dKQ;
    private g fhf;
    private int fhg = 0;
    private int fhh = 0;
    private int fhi = 0;
    private int aPQ = 0;
    private boolean aPR = false;
    private int aPS = 0;
    private boolean aPT = false;
    private int aPU = 0;
    private boolean aPV = false;
    private TbTabLayout.b fhj = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.aPR && MessageCenterFragment.this.fhi > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.HQ().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.fhf.g(eVar.getId(), MessageCenterFragment.this.aPQ, MessageCenterFragment.this.aPR);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.aPV) {
                        MessageCenterFragment.this.aWy();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.a.HQ().HX();
                    MessageCenterFragment.this.fhf.g(eVar.getId(), MessageCenterFragment.this.aPU, MessageCenterFragment.this.aPV);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.fhf.g(eVar.getId(), MessageCenterFragment.this.aPS, MessageCenterFragment.this.aPT);
                }
                MessageCenterFragment.this.qN(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.fhf != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.fhf.aWz());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.fhf != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(2016322, (Class) null);
                    com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.fhf.aWz());
                }
                MessageCenterFragment.this.qN(eVar.getId());
            }
        }
    };
    private CustomMessageListener fhk = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3 && MessageCenterFragment.this.aWv()) {
                if ((MessageCenterFragment.this.isPrimary() || MessageCenterFragment.this.fhi > 0) && MessageCenterFragment.this.getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener fhl = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.h(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aWv() {
        return this.fhf != null && this.fhf.qQ(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.fhk);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.message_center_activity, viewGroup, false);
        this.fhf = new g(this);
        this.fhf.a(inflate, bundle);
        this.fhf.qO(2);
        this.fhf.a(this.fhj);
        this.fhl.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.fhl);
        a(getActivity().getIntent(), bundle);
        this.dKQ = getVoiceManager();
        this.dKQ.onCreate(getPageContext());
        TiebaStatic.log(new am("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.aRe().aRf();
        if (this.dKQ == null) {
            this.dKQ = getVoiceManager();
            this.dKQ.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.fhf != null) {
            this.fhf.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e aWA;
        if (this.fhf != null && (aWA = this.fhf.aWA()) != null) {
            bundle.putInt("Selected_Tab", aWA.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.fhf != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fhf != null) {
            this.fhf.onChangeSkinType(this.mSkinType);
        }
    }

    public void aWw() {
        getActivity().finish();
    }

    public void aWx() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage(2002001, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.aPR) {
                i = 1;
            } else if (this.aPT) {
                i = 2;
            } else if (this.aPV) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.fhf != null) {
            this.fhf.qO(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.fhi;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.fhg = newsRemindMessage.getMsgAgreeCount();
            this.fhh = newsRemindMessage.getMsgAtCount();
            this.fhi = newsRemindMessage.getMsgReplyCount();
            this.aPQ = newsRemindMessage.getMsgCount();
            this.aPR = newsRemindMessage.hasMsgRemind();
            this.aPS = newsRemindMessage.getChatCount();
            this.aPT = newsRemindMessage.hasChatRemind();
            this.aPU = newsRemindMessage.getNotificationCount();
            this.aPV = newsRemindMessage.hasNotificationRemind();
            if (this.fhf != null) {
                if (i > 0 && this.fhi == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, getPageContext().getUniqueId()));
                }
                this.fhf.g(1, this.aPQ, this.aPR);
                this.fhf.g(2, this.aPS, this.aPT);
                if (this.fhf.qQ(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.HQ().HX();
                    if (this.aPV) {
                        aWy();
                        return;
                    }
                }
                this.fhf.g(3, this.aPU, this.aPV);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWy() {
        HashSet hashSet;
        HashMap<Integer, HashSet> Io = com.baidu.tbadk.coreExtra.messageCenter.a.HQ().Io();
        if (Io != null && Io.size() > 0 && (hashSet = Io.get(0)) != null && hashSet.size() > 0) {
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
    public void qN(int i) {
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
        com.baidu.tieba.im.db.e.aRe().aRf();
        MessageManager.getInstance().unRegisterListener(this.fhl);
        if (this.fhf != null) {
            this.fhf.aWB();
            this.fhf.b(this.fhj);
        }
        if (this.dKQ != null) {
            this.dKQ.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dKQ == null) {
            this.dKQ = VoiceManager.instance();
        }
        return this.dKQ;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dKQ != null) {
            this.dKQ.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dKQ != null) {
            this.dKQ.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dKQ != null) {
            this.dKQ.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dKQ != null) {
            this.dKQ.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.fhf != null) {
            this.fhf.setPrimary(z);
        }
    }
}
