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
    private g gOY;
    private int gOZ = 0;
    private int gPa = 0;
    private int gPb = 0;
    private int cgW = 0;
    private boolean cgX = false;
    private int cgY = 0;
    private boolean cgZ = false;
    private int cha = 0;
    private boolean chb = false;
    private TbTabLayout.b gPc = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.cgX && MessageCenterFragment.this.gPb > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.amy().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.gOY.j(eVar.getId(), MessageCenterFragment.this.cgW, MessageCenterFragment.this.cgX);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.chb) {
                        MessageCenterFragment.this.bFk();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.b.amy().amF();
                    MessageCenterFragment.this.gOY.j(eVar.getId(), MessageCenterFragment.this.cha, MessageCenterFragment.this.chb);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.gOY.j(eVar.getId(), MessageCenterFragment.this.cgY, MessageCenterFragment.this.cgZ);
                }
                MessageCenterFragment.this.vB(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.gOY != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.gOY.bFl());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.gOY != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(2016322, (Class) null);
                    com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.gOY.bFl());
                }
                MessageCenterFragment.this.vB(eVar.getId());
            }
        }
    };
    private CustomMessageListener gPd = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        private boolean gPg = true;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3) {
                if (!TbadkCoreApplication.getInst().checkInterrupt() || !this.gPg) {
                    if (MessageCenterFragment.this.bFh()) {
                        if (!MessageCenterFragment.this.isPrimary() && MessageCenterFragment.this.gPb <= 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (MessageCenterFragment.this.getPageContext() != null) {
                    this.gPg = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener gPe = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.i(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bFh() {
        return this.gOY != null && this.gOY.qg(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gPd);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.message_center_activity, viewGroup, false);
        this.gOY = new g(this);
        this.gOY.a(inflate, bundle);
        this.gOY.qf(2);
        this.gOY.a(this.gPc);
        this.gPe.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.gPe);
        a(getActivity().getIntent(), bundle);
        this.foP = getVoiceManager();
        this.foP.onCreate(getPageContext());
        TiebaStatic.log(new am("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.bzV().bzW();
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
        if (this.gOY != null) {
            this.gOY.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e bFm;
        if (this.gOY != null && (bFm = this.gOY.bFm()) != null) {
            bundle.putInt("Selected_Tab", bFm.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.gOY != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gOY != null) {
            this.gOY.onChangeSkinType(this.mSkinType);
        }
    }

    public void bFi() {
        getActivity().finish();
    }

    public void bFj() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage(2002001, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.cgX) {
                i = 1;
            } else if (this.cgZ) {
                i = 2;
            } else if (this.chb) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.gOY != null) {
            this.gOY.qf(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.gPb;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.gOZ = newsRemindMessage.getMsgAgreeCount();
            this.gPa = newsRemindMessage.getMsgAtCount();
            this.gPb = newsRemindMessage.getMsgReplyCount();
            this.cgW = newsRemindMessage.getMsgCount();
            this.cgX = newsRemindMessage.hasMsgRemind();
            this.cgY = newsRemindMessage.getChatCount();
            this.cgZ = newsRemindMessage.hasChatRemind();
            this.cha = newsRemindMessage.getNotificationCount();
            this.chb = newsRemindMessage.hasNotificationRemind();
            if (this.gOY != null) {
                if (i > 0 && this.gPb == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, getPageContext().getUniqueId()));
                }
                this.gOY.j(1, this.cgW, this.cgX);
                this.gOY.j(2, this.cgY, this.cgZ);
                if (this.gOY.qg(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.amy().amF();
                    if (this.chb) {
                        bFk();
                        return;
                    }
                }
                this.gOY.j(3, this.cha, this.chb);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFk() {
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
        com.baidu.tieba.im.db.e.bzV().bzW();
        MessageManager.getInstance().unRegisterListener(this.gPe);
        if (this.gOY != null) {
            this.gOY.bdY();
            this.gOY.b(this.gPc);
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
        if (this.gOY != null) {
            this.gOY.setPrimary(z);
        }
    }
}
