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
    private VoiceManager gYp;
    private g iAp;
    private int iAq = 0;
    private int iAr = 0;
    private int iAs = 0;
    private int dOE = 0;
    private boolean dOF = false;
    private int dOG = 0;
    private boolean dOH = false;
    private int dOI = 0;
    private boolean dOJ = false;
    private TbTabLayout.b iAt = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.dOF && MessageCenterFragment.this.iAs > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aTg().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.iAp.m(eVar.getId(), MessageCenterFragment.this.dOE, MessageCenterFragment.this.dOF);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.dOJ) {
                        MessageCenterFragment.this.cku();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.b.aTg().aTn();
                    MessageCenterFragment.this.iAp.m(eVar.getId(), MessageCenterFragment.this.dOI, MessageCenterFragment.this.dOJ);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.iAp.m(eVar.getId(), MessageCenterFragment.this.dOG, MessageCenterFragment.this.dOH);
                }
                MessageCenterFragment.this.xH(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.iAp != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                com.baidu.adp.lib.util.l.hideSoftKeyPad(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.iAp.ckv());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.iAp != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.iAp.ckv());
                }
                MessageCenterFragment.this.xH(eVar.getId());
            }
        }
    };
    private CustomMessageListener iAu = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        private boolean iAx = true;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3) {
                if (!TbadkCoreApplication.getInst().checkInterrupt() || !this.iAx) {
                    if (MessageCenterFragment.this.ckr()) {
                        if (!MessageCenterFragment.this.isPrimary() && MessageCenterFragment.this.iAs <= 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (MessageCenterFragment.this.getPageContext() != null) {
                    this.iAx = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener iAv = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.j(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ckr() {
        return this.iAp != null && this.iAp.xK(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.iAu);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.message_center_activity, viewGroup, false);
        this.iAp = new g(this);
        this.iAp.a(inflate, bundle);
        this.iAp.xI(2);
        this.iAp.a(this.iAt);
        this.iAv.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.iAv);
        a(getActivity().getIntent(), bundle);
        this.gYp = getVoiceManager();
        this.gYp.onCreate(getPageContext());
        TiebaStatic.log(new an("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.cfh().cfi();
        if (this.gYp == null) {
            this.gYp = getVoiceManager();
            this.gYp.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.iAp != null) {
            this.iAp.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e ckw;
        if (this.iAp != null && (ckw = this.iAp.ckw()) != null) {
            bundle.putInt("Selected_Tab", ckw.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.iAp != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iAp != null) {
            this.iAp.onChangeSkinType(this.mSkinType);
        }
    }

    public void cks() {
        getActivity().finish();
    }

    public void ckt() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.dOF) {
                i = 1;
            } else if (this.dOH) {
                i = 2;
            } else if (this.dOJ) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.iAp != null) {
            this.iAp.xI(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.iAs;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.iAq = newsRemindMessage.getMsgAgreeCount();
            this.iAr = newsRemindMessage.getMsgAtCount();
            this.iAs = newsRemindMessage.getMsgReplyCount();
            this.dOE = newsRemindMessage.getMsgCount();
            this.dOF = newsRemindMessage.hasMsgRemind();
            this.dOG = newsRemindMessage.getChatCount();
            this.dOH = newsRemindMessage.hasChatRemind();
            this.dOI = newsRemindMessage.getNotificationCount();
            this.dOJ = newsRemindMessage.hasNotificationRemind();
            if (this.iAp != null) {
                if (i > 0 && this.iAs == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY, getPageContext().getUniqueId()));
                }
                this.iAp.m(1, this.dOE, this.dOF);
                this.iAp.m(2, this.dOG, this.dOH);
                if (this.iAp.xK(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.aTg().aTn();
                    if (this.dOJ) {
                        cku();
                        return;
                    }
                }
                this.iAp.m(3, this.dOI, this.dOJ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cku() {
        HashSet hashSet;
        HashMap<Integer, HashSet> aTE = com.baidu.tbadk.coreExtra.messageCenter.b.aTg().aTE();
        if (aTE != null && aTE.size() > 0 && (hashSet = aTE.get(0)) != null && hashSet.size() > 0) {
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
        com.baidu.tieba.im.db.e.cfh().cfi();
        MessageManager.getInstance().unRegisterListener(this.iAv);
        if (this.iAp != null) {
            this.iAp.Ry();
            this.iAp.b(this.iAt);
        }
        if (this.gYp != null) {
            this.gYp.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gYp == null) {
            this.gYp = VoiceManager.instance();
        }
        return this.gYp;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gYp != null) {
            this.gYp.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gYp != null) {
            this.gYp.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gYp != null) {
            this.gYp.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.gYp != null) {
            this.gYp.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.iAp != null) {
            this.iAp.setPrimary(z);
        }
    }
}
