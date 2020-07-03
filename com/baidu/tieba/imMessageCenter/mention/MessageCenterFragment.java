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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class MessageCenterFragment extends BaseFragment implements VoiceManager.c {
    private VoiceManager hzJ;
    private g jgY;
    private int jgZ = 0;
    private int jha = 0;
    private int jhb = 0;
    private int elI = 0;
    private boolean elJ = false;
    private int elK = 0;
    private boolean elL = false;
    private int elM = 0;
    private boolean elN = false;
    private TbTabLayout.b jhc = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.elJ && MessageCenterFragment.this.jhb > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.bbo().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.jgY.m(eVar.getId(), MessageCenterFragment.this.elI, MessageCenterFragment.this.elJ);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.elN) {
                        MessageCenterFragment.this.cuR();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.b.bbo().bbv();
                    MessageCenterFragment.this.jgY.m(eVar.getId(), MessageCenterFragment.this.elM, MessageCenterFragment.this.elN);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.jgY.m(eVar.getId(), MessageCenterFragment.this.elK, MessageCenterFragment.this.elL);
                }
                MessageCenterFragment.this.yZ(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.jgY != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                com.baidu.adp.lib.util.l.hideSoftKeyPad(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.jgY.cuS());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.jgY != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.jgY.cuS());
                }
                MessageCenterFragment.this.yZ(eVar.getId());
            }
        }
    };
    private CustomMessageListener jhd = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        private boolean jhg = true;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3) {
                if (!TbadkCoreApplication.getInst().checkInterrupt() || !this.jhg) {
                    if (MessageCenterFragment.this.cuO()) {
                        if (!MessageCenterFragment.this.isPrimary() && MessageCenterFragment.this.jhb <= 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (MessageCenterFragment.this.getPageContext() != null) {
                    this.jhg = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener jhe = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.j(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cuO() {
        return this.jgY != null && this.jgY.zc(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.jhd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.message_center_activity, viewGroup, false);
        this.jgY = new g(this);
        this.jgY.a(inflate, bundle);
        this.jgY.za(2);
        this.jgY.a(this.jhc);
        this.jhe.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.jhe);
        a(getActivity().getIntent(), bundle);
        this.hzJ = getVoiceManager();
        this.hzJ.onCreate(getPageContext());
        TiebaStatic.log(new ao("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.cpB().cpC();
        if (this.hzJ == null) {
            this.hzJ = getVoiceManager();
            this.hzJ.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.jgY != null) {
            this.jgY.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e cuT;
        if (this.jgY != null && (cuT = this.jgY.cuT()) != null) {
            bundle.putInt("Selected_Tab", cuT.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.jgY != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jgY != null) {
            this.jgY.onChangeSkinType(this.mSkinType);
        }
    }

    public void cuP() {
        getActivity().finish();
    }

    public void cuQ() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.elJ) {
                i = 1;
            } else if (this.elL) {
                i = 2;
            } else if (this.elN) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.jgY != null) {
            this.jgY.za(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.jhb;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.jgZ = newsRemindMessage.getMsgAgreeCount();
            this.jha = newsRemindMessage.getMsgAtCount();
            this.jhb = newsRemindMessage.getMsgReplyCount();
            this.elI = newsRemindMessage.getMsgCount();
            this.elJ = newsRemindMessage.hasMsgRemind();
            this.elK = newsRemindMessage.getChatCount();
            this.elL = newsRemindMessage.hasChatRemind();
            this.elM = newsRemindMessage.getNotificationCount();
            this.elN = newsRemindMessage.hasNotificationRemind();
            if (this.jgY != null) {
                if (i > 0 && this.jhb == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY, getPageContext().getUniqueId()));
                }
                this.jgY.m(1, this.elI, this.elJ);
                this.jgY.m(2, this.elK, this.elL);
                if (this.jgY.zc(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bbo().bbv();
                    if (this.elN) {
                        cuR();
                        return;
                    }
                }
                this.jgY.m(3, this.elM, this.elN);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuR() {
        HashSet hashSet;
        HashMap<Integer, HashSet> bbM = com.baidu.tbadk.coreExtra.messageCenter.b.bbo().bbM();
        if (bbM != null && bbM.size() > 0 && (hashSet = bbM.get(0)) != null && hashSet.size() > 0) {
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
    public void yZ(int i) {
        if (i == 1) {
            TiebaStatic.log(new ao("c12937").ag("obj_type", 1));
        } else if (i == 2) {
            TiebaStatic.log(new ao("c12937").ag("obj_type", 2));
        } else if (i == 3) {
            TiebaStatic.log(new ao("c12937").ag("obj_type", 3));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.cpB().cpC();
        MessageManager.getInstance().unRegisterListener(this.jhe);
        if (this.jgY != null) {
            this.jgY.Ve();
            this.jgY.b(this.jhc);
        }
        if (this.hzJ != null) {
            this.hzJ.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hzJ == null) {
            this.hzJ = VoiceManager.instance();
        }
        return this.hzJ;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.hzJ != null) {
            this.hzJ.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.hzJ != null) {
            this.hzJ.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hzJ != null) {
            this.hzJ.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.hzJ != null) {
            this.hzJ.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.jgY != null) {
            this.jgY.setPrimary(z);
        }
    }
}
