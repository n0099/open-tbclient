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
/* loaded from: classes7.dex */
public class MessageCenterFragment extends BaseFragment implements VoiceManager.c {
    private VoiceManager gmi;
    private g hMM;
    private int hMN = 0;
    private int hMO = 0;
    private int hMP = 0;
    private int dke = 0;
    private boolean dkf = false;
    private int dkg = 0;
    private boolean dkh = false;
    private int dki = 0;
    private boolean dkj = false;
    private TbTabLayout.b hMQ = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.dkf && MessageCenterFragment.this.hMP > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aIj().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.hMM.m(eVar.getId(), MessageCenterFragment.this.dke, MessageCenterFragment.this.dkf);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.dkj) {
                        MessageCenterFragment.this.bXX();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.b.aIj().aIq();
                    MessageCenterFragment.this.hMM.m(eVar.getId(), MessageCenterFragment.this.dki, MessageCenterFragment.this.dkj);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.hMM.m(eVar.getId(), MessageCenterFragment.this.dkg, MessageCenterFragment.this.dkh);
                }
                MessageCenterFragment.this.wV(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.hMM != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                com.baidu.adp.lib.util.l.hideSoftKeyPad(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.hMM.bXY());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.hMM != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.hMM.bXY());
                }
                MessageCenterFragment.this.wV(eVar.getId());
            }
        }
    };
    private CustomMessageListener hMR = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        private boolean hMU = true;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3) {
                if (!TbadkCoreApplication.getInst().checkInterrupt() || !this.hMU) {
                    if (MessageCenterFragment.this.bXU()) {
                        if (!MessageCenterFragment.this.isPrimary() && MessageCenterFragment.this.hMP <= 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (MessageCenterFragment.this.getPageContext() != null) {
                    this.hMU = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener hMS = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.j(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bXU() {
        return this.hMM != null && this.hMM.rI(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.hMR);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.message_center_activity, viewGroup, false);
        this.hMM = new g(this);
        this.hMM.a(inflate, bundle);
        this.hMM.rH(2);
        this.hMM.a(this.hMQ);
        this.hMS.setPriority(Integer.MAX_VALUE);
        registerListener(this.hMS);
        a(getActivity().getIntent(), bundle);
        this.gmi = getVoiceManager();
        this.gmi.onCreate(getPageContext());
        TiebaStatic.log(new an("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.bSK().bSL();
        if (this.gmi == null) {
            this.gmi = getVoiceManager();
            this.gmi.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hMM != null) {
            this.hMM.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e bXZ;
        if (this.hMM != null && (bXZ = this.hMM.bXZ()) != null) {
            bundle.putInt("Selected_Tab", bXZ.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.hMM != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hMM != null) {
            this.hMM.onChangeSkinType(this.mSkinType);
        }
    }

    public void bXV() {
        getActivity().finish();
    }

    public void bXW() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.dkf) {
                i = 1;
            } else if (this.dkh) {
                i = 2;
            } else if (this.dkj) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.hMM != null) {
            this.hMM.rH(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.hMP;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.hMN = newsRemindMessage.getMsgAgreeCount();
            this.hMO = newsRemindMessage.getMsgAtCount();
            this.hMP = newsRemindMessage.getMsgReplyCount();
            this.dke = newsRemindMessage.getMsgCount();
            this.dkf = newsRemindMessage.hasMsgRemind();
            this.dkg = newsRemindMessage.getChatCount();
            this.dkh = newsRemindMessage.hasChatRemind();
            this.dki = newsRemindMessage.getNotificationCount();
            this.dkj = newsRemindMessage.hasNotificationRemind();
            if (this.hMM != null) {
                if (i > 0 && this.hMP == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY, getPageContext().getUniqueId()));
                }
                this.hMM.m(1, this.dke, this.dkf);
                this.hMM.m(2, this.dkg, this.dkh);
                if (this.hMM.rI(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.aIj().aIq();
                    if (this.dkj) {
                        bXX();
                        return;
                    }
                }
                this.hMM.m(3, this.dki, this.dkj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXX() {
        HashSet hashSet;
        HashMap<Integer, HashSet> aIH = com.baidu.tbadk.coreExtra.messageCenter.b.aIj().aIH();
        if (aIH != null && aIH.size() > 0 && (hashSet = aIH.get(0)) != null && hashSet.size() > 0) {
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
    public void wV(int i) {
        if (i == 1) {
            TiebaStatic.log(new an("c12937").Z("obj_type", 1));
        } else if (i == 2) {
            TiebaStatic.log(new an("c12937").Z("obj_type", 2));
        } else if (i == 3) {
            TiebaStatic.log(new an("c12937").Z("obj_type", 3));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.bSK().bSL();
        MessageManager.getInstance().unRegisterListener(this.hMS);
        if (this.hMM != null) {
            this.hMM.Hs();
            this.hMM.b(this.hMQ);
        }
        if (this.gmi != null) {
            this.gmi.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gmi == null) {
            this.gmi = VoiceManager.instance();
        }
        return this.gmi;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gmi != null) {
            this.gmi.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gmi != null) {
            this.gmi.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gmi != null) {
            this.gmi.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.gmi != null) {
            this.gmi.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.hMM != null) {
            this.hMM.setPrimary(z);
        }
    }
}
