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
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class MessageCenterFragment extends BaseFragment implements VoiceManager.c {
    private VoiceManager dhB;
    private g ezD;
    private int ezE = 0;
    private int ezF = 0;
    private int ezG = 0;
    private int aCX = 0;
    private boolean aCY = false;
    private int aCZ = 0;
    private boolean aDa = false;
    private int aDb = 0;
    private boolean aDc = false;
    private TbTabLayout.b ezH = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.aCY && MessageCenterFragment.this.ezG > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.CX().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.ezD.f(eVar.getId(), MessageCenterFragment.this.aCX, MessageCenterFragment.this.aCY);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.aDc) {
                        MessageCenterFragment.this.aNq();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.a.CX().De();
                    MessageCenterFragment.this.ezD.f(eVar.getId(), MessageCenterFragment.this.aDb, MessageCenterFragment.this.aDc);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.ezD.f(eVar.getId(), MessageCenterFragment.this.aCZ, MessageCenterFragment.this.aDa);
                }
                MessageCenterFragment.this.oq(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.ezD != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.ezD.aNr());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.ezD != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(2016322, (Class) null);
                    com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.ezD.aNr());
                }
                MessageCenterFragment.this.oq(eVar.getId());
            }
        }
    };
    private CustomMessageListener ezI = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3 && MessageCenterFragment.this.aNn()) {
                if ((MessageCenterFragment.this.isPrimary() || MessageCenterFragment.this.ezG > 0) && MessageCenterFragment.this.getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener ezJ = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.h(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aNn() {
        return this.ezD != null && this.ezD.os(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.ezI);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.message_center_activity, viewGroup, false);
        this.ezD = new g(this);
        this.ezD.a(inflate, bundle);
        this.ezD.selectTab(2);
        this.ezD.a(this.ezH);
        this.ezJ.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.ezJ);
        a(getActivity().getIntent(), bundle);
        this.dhB = getVoiceManager();
        this.dhB.onCreate(getPageContext());
        TiebaStatic.log(new am("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.aHT().aHU();
        if (this.dhB == null) {
            this.dhB = getVoiceManager();
            this.dhB.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.ezD != null) {
            this.ezD.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e aNs;
        if (this.ezD != null && (aNs = this.ezD.aNs()) != null) {
            bundle.putInt("Selected_Tab", aNs.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.ezD != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ezD != null) {
            this.ezD.onChangeSkinType(this.mSkinType);
        }
    }

    public void aNo() {
        getActivity().finish();
    }

    public void aNp() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage(2002001, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.aCY) {
                i = 1;
            } else if (this.aDa) {
                i = 2;
            } else if (this.aDc) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.ezD != null) {
            this.ezD.selectTab(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.ezG;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.ezE = newsRemindMessage.getMsgAgreeCount();
            this.ezF = newsRemindMessage.getMsgAtCount();
            this.ezG = newsRemindMessage.getMsgReplyCount();
            this.aCX = newsRemindMessage.getMsgCount();
            this.aCY = newsRemindMessage.hasMsgRemind();
            this.aCZ = newsRemindMessage.getChatCount();
            this.aDa = newsRemindMessage.hasChatRemind();
            this.aDb = newsRemindMessage.getNotificationCount();
            this.aDc = newsRemindMessage.hasNotificationRemind();
            if (this.ezD != null) {
                if (i > 0 && this.ezG == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, getPageContext().getUniqueId()));
                }
                this.ezD.f(1, this.aCX, this.aCY);
                this.ezD.f(2, this.aCZ, this.aDa);
                if (this.ezD.os(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.CX().De();
                    if (this.aDc) {
                        aNq();
                        return;
                    }
                }
                this.ezD.f(3, this.aDb, this.aDc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNq() {
        HashSet hashSet;
        HashMap<Integer, HashSet> Dv = com.baidu.tbadk.coreExtra.messageCenter.a.CX().Dv();
        if (Dv != null && Dv.size() > 0 && (hashSet = Dv.get(0)) != null && hashSet.size() > 0) {
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
    public void oq(int i) {
        if (i == 1) {
            TiebaStatic.log(new am("c12937").r("obj_type", 1));
        } else if (i == 2) {
            TiebaStatic.log(new am("c12937").r("obj_type", 2));
        } else if (i == 3) {
            TiebaStatic.log(new am("c12937").r("obj_type", 3));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.aHT().aHU();
        MessageManager.getInstance().unRegisterListener(this.ezJ);
        if (this.ezD != null) {
            this.ezD.aNt();
            this.ezD.b(this.ezH);
        }
        if (this.dhB != null) {
            this.dhB.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dhB == null) {
            this.dhB = VoiceManager.instance();
        }
        return this.dhB;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dhB != null) {
            this.dhB.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dhB != null) {
            this.dhB.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dhB != null) {
            this.dhB.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dhB != null) {
            this.dhB.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.ezD != null) {
            this.ezD.setPrimary(z);
        }
    }
}
