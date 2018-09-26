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
/* loaded from: classes2.dex */
public class MessageCenterFragment extends BaseFragment implements VoiceManager.c {
    private VoiceManager dsk;
    private g eOy;
    private int eOz = 0;
    private int eOA = 0;
    private int eOB = 0;
    private int aGW = 0;
    private boolean aGX = false;
    private int aGY = 0;
    private boolean aGZ = false;
    private int aHa = 0;
    private boolean aHb = false;
    private TbTabLayout.b eOC = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.aGX && MessageCenterFragment.this.eOB > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Ey().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.eOy.f(eVar.getId(), MessageCenterFragment.this.aGW, MessageCenterFragment.this.aGX);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.aHb) {
                        MessageCenterFragment.this.aRi();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.a.Ey().EF();
                    MessageCenterFragment.this.eOy.f(eVar.getId(), MessageCenterFragment.this.aHa, MessageCenterFragment.this.aHb);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.eOy.f(eVar.getId(), MessageCenterFragment.this.aGY, MessageCenterFragment.this.aGZ);
                }
                MessageCenterFragment.this.pp(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.eOy != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.a(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.eOy.aRj());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.eOy != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(2016322, (Class) null);
                    com.baidu.adp.lib.util.l.a(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.eOy.aRj());
                }
                MessageCenterFragment.this.pp(eVar.getId());
            }
        }
    };
    private CustomMessageListener eOD = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3 && MessageCenterFragment.this.aRf()) {
                if ((MessageCenterFragment.this.isPrimary() || MessageCenterFragment.this.eOB > 0) && MessageCenterFragment.this.getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener eOE = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.h(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aRf() {
        return this.eOy != null && this.eOy.ps(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.eOD);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.message_center_activity, viewGroup, false);
        this.eOy = new g(this);
        this.eOy.a(inflate, bundle);
        this.eOy.pq(2);
        this.eOy.a(this.eOC);
        this.eOE.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.eOE);
        a(getActivity().getIntent(), bundle);
        this.dsk = getVoiceManager();
        this.dsk.onCreate(getPageContext());
        TiebaStatic.log(new am("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.aLN().aLO();
        if (this.dsk == null) {
            this.dsk = getVoiceManager();
            this.dsk.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.eOy != null) {
            this.eOy.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e aRk;
        if (this.eOy != null && (aRk = this.eOy.aRk()) != null) {
            bundle.putInt("Selected_Tab", aRk.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.eOy != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eOy != null) {
            this.eOy.onChangeSkinType(this.mSkinType);
        }
    }

    public void aRg() {
        getActivity().finish();
    }

    public void aRh() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage(2002001, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.aGX) {
                i = 1;
            } else if (this.aGZ) {
                i = 2;
            } else if (this.aHb) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.eOy != null) {
            this.eOy.pq(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.eOB;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.eOz = newsRemindMessage.getMsgAgreeCount();
            this.eOA = newsRemindMessage.getMsgAtCount();
            this.eOB = newsRemindMessage.getMsgReplyCount();
            this.aGW = newsRemindMessage.getMsgCount();
            this.aGX = newsRemindMessage.hasMsgRemind();
            this.aGY = newsRemindMessage.getChatCount();
            this.aGZ = newsRemindMessage.hasChatRemind();
            this.aHa = newsRemindMessage.getNotificationCount();
            this.aHb = newsRemindMessage.hasNotificationRemind();
            if (this.eOy != null) {
                if (i > 0 && this.eOB == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, getPageContext().getUniqueId()));
                }
                this.eOy.f(1, this.aGW, this.aGX);
                this.eOy.f(2, this.aGY, this.aGZ);
                if (this.eOy.ps(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Ey().EF();
                    if (this.aHb) {
                        aRi();
                        return;
                    }
                }
                this.eOy.f(3, this.aHa, this.aHb);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRi() {
        HashSet hashSet;
        HashMap<Integer, HashSet> EW = com.baidu.tbadk.coreExtra.messageCenter.a.Ey().EW();
        if (EW != null && EW.size() > 0 && (hashSet = EW.get(0)) != null && hashSet.size() > 0) {
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
    public void pp(int i) {
        if (i == 1) {
            TiebaStatic.log(new am("c12937").w("obj_type", 1));
        } else if (i == 2) {
            TiebaStatic.log(new am("c12937").w("obj_type", 2));
        } else if (i == 3) {
            TiebaStatic.log(new am("c12937").w("obj_type", 3));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.aLN().aLO();
        MessageManager.getInstance().unRegisterListener(this.eOE);
        if (this.eOy != null) {
            this.eOy.aRl();
            this.eOy.b(this.eOC);
        }
        if (this.dsk != null) {
            this.dsk.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dsk == null) {
            this.dsk = VoiceManager.instance();
        }
        return this.dsk;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dsk != null) {
            this.dsk.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dsk != null) {
            this.dsk.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dsk != null) {
            this.dsk.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dsk != null) {
            this.dsk.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.eOy != null) {
            this.eOy.setPrimary(z);
        }
    }
}
