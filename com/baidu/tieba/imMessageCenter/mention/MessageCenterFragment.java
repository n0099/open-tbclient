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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
/* loaded from: classes9.dex */
public class MessageCenterFragment extends BaseFragment implements VoiceManager.c {
    private VoiceManager gYv;
    private g iAv;
    private int iAw = 0;
    private int iAx = 0;
    private int iAy = 0;
    private int dOJ = 0;
    private boolean dOK = false;
    private int dOL = 0;
    private boolean dOM = false;
    private int dON = 0;
    private boolean dOO = false;
    private TbTabLayout.b iAz = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.dOK && MessageCenterFragment.this.iAy > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aTe().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.iAv.m(eVar.getId(), MessageCenterFragment.this.dOJ, MessageCenterFragment.this.dOK);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.dOO) {
                        MessageCenterFragment.this.cks();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.b.aTe().aTl();
                    MessageCenterFragment.this.iAv.m(eVar.getId(), MessageCenterFragment.this.dON, MessageCenterFragment.this.dOO);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.iAv.m(eVar.getId(), MessageCenterFragment.this.dOL, MessageCenterFragment.this.dOM);
                }
                MessageCenterFragment.this.xH(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.iAv != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                com.baidu.adp.lib.util.l.hideSoftKeyPad(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.iAv.ckt());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.iAv != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.iAv.ckt());
                }
                MessageCenterFragment.this.xH(eVar.getId());
            }
        }
    };
    private CustomMessageListener iAA = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        private boolean iAD = true;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3) {
                if (!TbadkCoreApplication.getInst().checkInterrupt() || !this.iAD) {
                    if (MessageCenterFragment.this.ckp()) {
                        if (!MessageCenterFragment.this.isPrimary() && MessageCenterFragment.this.iAy <= 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (MessageCenterFragment.this.getPageContext() != null) {
                    this.iAD = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener iAB = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.j(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ckp() {
        return this.iAv != null && this.iAv.xK(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.iAA);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.message_center_activity, viewGroup, false);
        this.iAv = new g(this);
        this.iAv.a(inflate, bundle);
        this.iAv.xI(2);
        this.iAv.a(this.iAz);
        this.iAB.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.iAB);
        a(getActivity().getIntent(), bundle);
        this.gYv = getVoiceManager();
        this.gYv.onCreate(getPageContext());
        TiebaStatic.log(new an("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.cff().cfg();
        if (this.gYv == null) {
            this.gYv = getVoiceManager();
            this.gYv.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.iAv != null) {
            this.iAv.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e cku;
        if (this.iAv != null && (cku = this.iAv.cku()) != null) {
            bundle.putInt("Selected_Tab", cku.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.iAv != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iAv != null) {
            this.iAv.onChangeSkinType(this.mSkinType);
        }
    }

    public void ckq() {
        getActivity().finish();
    }

    public void ckr() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.dOK) {
                i = 1;
            } else if (this.dOM) {
                i = 2;
            } else if (this.dOO) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.iAv != null) {
            this.iAv.xI(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.iAy;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.iAw = newsRemindMessage.getMsgAgreeCount();
            this.iAx = newsRemindMessage.getMsgAtCount();
            this.iAy = newsRemindMessage.getMsgReplyCount();
            this.dOJ = newsRemindMessage.getMsgCount();
            this.dOK = newsRemindMessage.hasMsgRemind();
            this.dOL = newsRemindMessage.getChatCount();
            this.dOM = newsRemindMessage.hasChatRemind();
            this.dON = newsRemindMessage.getNotificationCount();
            this.dOO = newsRemindMessage.hasNotificationRemind();
            if (this.iAv != null) {
                if (i > 0 && this.iAy == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY, getPageContext().getUniqueId()));
                }
                this.iAv.m(1, this.dOJ, this.dOK);
                this.iAv.m(2, this.dOL, this.dOM);
                if (this.iAv.xK(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.aTe().aTl();
                    if (this.dOO) {
                        cks();
                        return;
                    }
                }
                this.iAv.m(3, this.dON, this.dOO);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cks() {
        HashSet hashSet;
        HashMap<Integer, HashSet> aTC = com.baidu.tbadk.coreExtra.messageCenter.b.aTe().aTC();
        if (aTC != null && aTC.size() > 0 && (hashSet = aTC.get(0)) != null && hashSet.size() > 0) {
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
    public void xH(int i) {
        if (i == 1) {
            TiebaStatic.log(new an("c12937").af("obj_type", 1));
        } else if (i == 2) {
            TiebaStatic.log(new an("c12937").af("obj_type", 2));
        } else if (i == 3) {
            TiebaStatic.log(new an("c12937").af("obj_type", 3));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.cff().cfg();
        MessageManager.getInstance().unRegisterListener(this.iAB);
        if (this.iAv != null) {
            this.iAv.Rx();
            this.iAv.b(this.iAz);
        }
        if (this.gYv != null) {
            this.gYv.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gYv == null) {
            this.gYv = VoiceManager.instance();
        }
        return this.gYv;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gYv != null) {
            this.gYv.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gYv != null) {
            this.gYv.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gYv != null) {
            this.gYv.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.gYv != null) {
            this.gYv.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.iAv != null) {
            this.iAv.setPrimary(z);
        }
    }
}
