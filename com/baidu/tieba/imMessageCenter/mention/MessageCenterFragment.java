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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class MessageCenterFragment extends BaseFragment implements VoiceManager.c {
    private VoiceManager foP;
    private g gPa;
    private int gPb = 0;
    private int gPc = 0;
    private int gPd = 0;
    private int cgX = 0;
    private boolean cgY = false;
    private int cgZ = 0;
    private boolean cha = false;
    private int chb = 0;
    private boolean chc = false;
    private TbTabLayout.b gPe = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.cgY && MessageCenterFragment.this.gPd > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.amy().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.gPa.j(eVar.getId(), MessageCenterFragment.this.cgX, MessageCenterFragment.this.cgY);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.chc) {
                        MessageCenterFragment.this.bFl();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.b.amy().amF();
                    MessageCenterFragment.this.gPa.j(eVar.getId(), MessageCenterFragment.this.chb, MessageCenterFragment.this.chc);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.gPa.j(eVar.getId(), MessageCenterFragment.this.cgZ, MessageCenterFragment.this.cha);
                }
                MessageCenterFragment.this.vB(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.gPa != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.gPa.bFm());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.gPa != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(2016322, (Class) null);
                    com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.gPa.bFm());
                }
                MessageCenterFragment.this.vB(eVar.getId());
            }
        }
    };
    private CustomMessageListener gPf = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        private boolean gPi = true;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3) {
                if (!TbadkCoreApplication.getInst().checkInterrupt() || !this.gPi) {
                    if (MessageCenterFragment.this.bFi()) {
                        if (!MessageCenterFragment.this.isPrimary() && MessageCenterFragment.this.gPd <= 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (MessageCenterFragment.this.getPageContext() != null) {
                    this.gPi = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener gPg = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.i(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bFi() {
        return this.gPa != null && this.gPa.qg(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gPf);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.message_center_activity, viewGroup, false);
        this.gPa = new g(this);
        this.gPa.a(inflate, bundle);
        this.gPa.qf(2);
        this.gPa.a(this.gPe);
        this.gPg.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.gPg);
        a(getActivity().getIntent(), bundle);
        this.foP = getVoiceManager();
        this.foP.onCreate(getPageContext());
        TiebaStatic.log(new am("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.bzW().bzX();
        if (this.foP == null) {
            this.foP = getVoiceManager();
            this.foP.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.gPa != null) {
            this.gPa.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e bFn;
        if (this.gPa != null && (bFn = this.gPa.bFn()) != null) {
            bundle.putInt("Selected_Tab", bFn.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.gPa != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gPa != null) {
            this.gPa.onChangeSkinType(this.mSkinType);
        }
    }

    public void bFj() {
        getActivity().finish();
    }

    public void bFk() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage(2002001, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.cgY) {
                i = 1;
            } else if (this.cha) {
                i = 2;
            } else if (this.chc) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.gPa != null) {
            this.gPa.qf(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.gPd;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.gPb = newsRemindMessage.getMsgAgreeCount();
            this.gPc = newsRemindMessage.getMsgAtCount();
            this.gPd = newsRemindMessage.getMsgReplyCount();
            this.cgX = newsRemindMessage.getMsgCount();
            this.cgY = newsRemindMessage.hasMsgRemind();
            this.cgZ = newsRemindMessage.getChatCount();
            this.cha = newsRemindMessage.hasChatRemind();
            this.chb = newsRemindMessage.getNotificationCount();
            this.chc = newsRemindMessage.hasNotificationRemind();
            if (this.gPa != null) {
                if (i > 0 && this.gPd == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, getPageContext().getUniqueId()));
                }
                this.gPa.j(1, this.cgX, this.cgY);
                this.gPa.j(2, this.cgZ, this.cha);
                if (this.gPa.qg(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.amy().amF();
                    if (this.chc) {
                        bFl();
                        return;
                    }
                }
                this.gPa.j(3, this.chb, this.chc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFl() {
        HashSet hashSet;
        HashMap<Integer, HashSet> amW = com.baidu.tbadk.coreExtra.messageCenter.b.amy().amW();
        if (amW != null && amW.size() > 0 && (hashSet = amW.get(0)) != null && hashSet.size() > 0) {
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
    public void vB(int i) {
        if (i == 1) {
            TiebaStatic.log(new am("c12937").P("obj_type", 1));
        } else if (i == 2) {
            TiebaStatic.log(new am("c12937").P("obj_type", 2));
        } else if (i == 3) {
            TiebaStatic.log(new am("c12937").P("obj_type", 3));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.bzW().bzX();
        MessageManager.getInstance().unRegisterListener(this.gPg);
        if (this.gPa != null) {
            this.gPa.bdY();
            this.gPa.b(this.gPe);
        }
        if (this.foP != null) {
            this.foP.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.foP == null) {
            this.foP = VoiceManager.instance();
        }
        return this.foP;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.foP != null) {
            this.foP.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.foP != null) {
            this.foP.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.foP != null) {
            this.foP.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.foP != null) {
            this.foP.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.gPa != null) {
            this.gPa.setPrimary(z);
        }
    }
}
