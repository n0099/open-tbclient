package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
    private VoiceManager gpi;
    private g hQy;
    private int hQz = 0;
    private int hQA = 0;
    private int hQB = 0;
    private int doM = 0;
    private boolean doN = false;
    private int doO = 0;
    private boolean doP = false;
    private int doQ = 0;
    private boolean doR = false;
    private TbTabLayout.b hQC = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.doN && MessageCenterFragment.this.hQB > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.hQy.m(eVar.getId(), MessageCenterFragment.this.doM, MessageCenterFragment.this.doN);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.doR) {
                        MessageCenterFragment.this.bZT();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().aKQ();
                    MessageCenterFragment.this.hQy.m(eVar.getId(), MessageCenterFragment.this.doQ, MessageCenterFragment.this.doR);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.hQy.m(eVar.getId(), MessageCenterFragment.this.doO, MessageCenterFragment.this.doP);
                }
                MessageCenterFragment.this.xj(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.hQy != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                com.baidu.adp.lib.util.l.hideSoftKeyPad(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.hQy.bZU());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.hQy != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.hQy.bZU());
                }
                MessageCenterFragment.this.xj(eVar.getId());
            }
        }
    };
    private CustomMessageListener hQD = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        private boolean hQG = true;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3) {
                if (!TbadkCoreApplication.getInst().checkInterrupt() || !this.hQG) {
                    if (MessageCenterFragment.this.bZQ()) {
                        if (!MessageCenterFragment.this.isPrimary() && MessageCenterFragment.this.hQB <= 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (MessageCenterFragment.this.getPageContext() != null) {
                    this.hQG = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener hQE = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.j(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bZQ() {
        return this.hQy != null && this.hQy.rR(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.hQD);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.message_center_activity, viewGroup, false);
        this.hQy = new g(this);
        this.hQy.a(inflate, bundle);
        this.hQy.rQ(2);
        this.hQy.a(this.hQC);
        this.hQE.setPriority(Integer.MAX_VALUE);
        registerListener(this.hQE);
        a(getActivity().getIntent(), bundle);
        this.gpi = getVoiceManager();
        this.gpi.onCreate(getPageContext());
        TiebaStatic.log(new an("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.bUG().bUH();
        if (this.gpi == null) {
            this.gpi = getVoiceManager();
            this.gpi.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hQy != null) {
            this.hQy.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e bZV;
        if (this.hQy != null && (bZV = this.hQy.bZV()) != null) {
            bundle.putInt("Selected_Tab", bZV.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.hQy != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hQy != null) {
            this.hQy.onChangeSkinType(this.mSkinType);
        }
    }

    public void bZR() {
        getActivity().finish();
    }

    public void bZS() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.doN) {
                i = 1;
            } else if (this.doP) {
                i = 2;
            } else if (this.doR) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.hQy != null) {
            this.hQy.rQ(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.hQB;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.hQz = newsRemindMessage.getMsgAgreeCount();
            this.hQA = newsRemindMessage.getMsgAtCount();
            this.hQB = newsRemindMessage.getMsgReplyCount();
            this.doM = newsRemindMessage.getMsgCount();
            this.doN = newsRemindMessage.hasMsgRemind();
            this.doO = newsRemindMessage.getChatCount();
            this.doP = newsRemindMessage.hasChatRemind();
            this.doQ = newsRemindMessage.getNotificationCount();
            this.doR = newsRemindMessage.hasNotificationRemind();
            if (this.hQy != null) {
                if (i > 0 && this.hQB == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY, getPageContext().getUniqueId()));
                }
                this.hQy.m(1, this.doM, this.doN);
                this.hQy.m(2, this.doO, this.doP);
                if (this.hQy.rR(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().aKQ();
                    if (this.doR) {
                        bZT();
                        return;
                    }
                }
                this.hQy.m(3, this.doQ, this.doR);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZT() {
        HashSet hashSet;
        HashMap<Integer, HashSet> aLh = com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().aLh();
        if (aLh != null && aLh.size() > 0 && (hashSet = aLh.get(0)) != null && hashSet.size() > 0) {
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
    public void xj(int i) {
        if (i == 1) {
            TiebaStatic.log(new an("c12937").X("obj_type", 1));
        } else if (i == 2) {
            TiebaStatic.log(new an("c12937").X("obj_type", 2));
        } else if (i == 3) {
            TiebaStatic.log(new an("c12937").X("obj_type", 3));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.bUG().bUH();
        MessageManager.getInstance().unRegisterListener(this.hQE);
        if (this.hQy != null) {
            this.hQy.JM();
            this.hQy.b(this.hQC);
        }
        if (this.gpi != null) {
            this.gpi.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gpi == null) {
            this.gpi = VoiceManager.instance();
        }
        return this.gpi;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gpi != null) {
            this.gpi.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gpi != null) {
            this.gpi.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gpi != null) {
            this.gpi.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.gpi != null) {
            this.gpi.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.hQy != null) {
            this.hQy.setPrimary(z);
        }
    }
}
