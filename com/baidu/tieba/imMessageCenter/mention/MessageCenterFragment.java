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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class MessageCenterFragment extends BaseFragment implements VoiceManager.c {
    private VoiceManager fun;
    private g gWc;
    private int gWd = 0;
    private int gWe = 0;
    private int gWf = 0;
    private int cik = 0;
    private boolean cil = false;
    private int cim = 0;
    private boolean cin = false;
    private int cio = 0;
    private boolean cip = false;
    private TbTabLayout.b gWg = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.cil && MessageCenterFragment.this.gWf > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.anF().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.gWc.k(eVar.getId(), MessageCenterFragment.this.cik, MessageCenterFragment.this.cil);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.cip) {
                        MessageCenterFragment.this.bIg();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.b.anF().anM();
                    MessageCenterFragment.this.gWc.k(eVar.getId(), MessageCenterFragment.this.cio, MessageCenterFragment.this.cip);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.gWc.k(eVar.getId(), MessageCenterFragment.this.cim, MessageCenterFragment.this.cin);
                }
                MessageCenterFragment.this.wf(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.gWc != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.gWc.bIh());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.gWc != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(2016322, (Class) null);
                    com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.gWc.bIh());
                }
                MessageCenterFragment.this.wf(eVar.getId());
            }
        }
    };
    private CustomMessageListener gWh = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        private boolean gWk = true;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3) {
                if (!TbadkCoreApplication.getInst().checkInterrupt() || !this.gWk) {
                    if (MessageCenterFragment.this.bId()) {
                        if (!MessageCenterFragment.this.isPrimary() && MessageCenterFragment.this.gWf <= 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (MessageCenterFragment.this.getPageContext() != null) {
                    this.gWk = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener gWi = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.i(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bId() {
        return this.gWc != null && this.gWc.qz(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gWh);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.message_center_activity, viewGroup, false);
        this.gWc = new g(this);
        this.gWc.a(inflate, bundle);
        this.gWc.qy(2);
        this.gWc.a(this.gWg);
        this.gWi.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.gWi);
        a(getActivity().getIntent(), bundle);
        this.fun = getVoiceManager();
        this.fun.onCreate(getPageContext());
        TiebaStatic.log(new an("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.bCP().bCQ();
        if (this.fun == null) {
            this.fun = getVoiceManager();
            this.fun.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.gWc != null) {
            this.gWc.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e bIi;
        if (this.gWc != null && (bIi = this.gWc.bIi()) != null) {
            bundle.putInt("Selected_Tab", bIi.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.gWc != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gWc != null) {
            this.gWc.onChangeSkinType(this.mSkinType);
        }
    }

    public void bIe() {
        getActivity().finish();
    }

    public void bIf() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage(2002001, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.cil) {
                i = 1;
            } else if (this.cin) {
                i = 2;
            } else if (this.cip) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.gWc != null) {
            this.gWc.qy(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.gWf;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.gWd = newsRemindMessage.getMsgAgreeCount();
            this.gWe = newsRemindMessage.getMsgAtCount();
            this.gWf = newsRemindMessage.getMsgReplyCount();
            this.cik = newsRemindMessage.getMsgCount();
            this.cil = newsRemindMessage.hasMsgRemind();
            this.cim = newsRemindMessage.getChatCount();
            this.cin = newsRemindMessage.hasChatRemind();
            this.cio = newsRemindMessage.getNotificationCount();
            this.cip = newsRemindMessage.hasNotificationRemind();
            if (this.gWc != null) {
                if (i > 0 && this.gWf == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, getPageContext().getUniqueId()));
                }
                this.gWc.k(1, this.cik, this.cil);
                this.gWc.k(2, this.cim, this.cin);
                if (this.gWc.qz(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.anF().anM();
                    if (this.cip) {
                        bIg();
                        return;
                    }
                }
                this.gWc.k(3, this.cio, this.cip);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIg() {
        HashSet hashSet;
        HashMap<Integer, HashSet> aod = com.baidu.tbadk.coreExtra.messageCenter.b.anF().aod();
        if (aod != null && aod.size() > 0 && (hashSet = aod.get(0)) != null && hashSet.size() > 0) {
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
    public void wf(int i) {
        if (i == 1) {
            TiebaStatic.log(new an("c12937").P("obj_type", 1));
        } else if (i == 2) {
            TiebaStatic.log(new an("c12937").P("obj_type", 2));
        } else if (i == 3) {
            TiebaStatic.log(new an("c12937").P("obj_type", 3));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.bCP().bCQ();
        MessageManager.getInstance().unRegisterListener(this.gWi);
        if (this.gWc != null) {
            this.gWc.bgd();
            this.gWc.b(this.gWg);
        }
        if (this.fun != null) {
            this.fun.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fun == null) {
            this.fun = VoiceManager.instance();
        }
        return this.fun;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.fun != null) {
            this.fun.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fun != null) {
            this.fun.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fun != null) {
            this.fun.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.fun != null) {
            this.fun.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.gWc != null) {
            this.gWc.setPrimary(z);
        }
    }
}
