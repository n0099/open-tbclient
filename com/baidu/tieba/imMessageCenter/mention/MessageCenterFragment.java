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
    private VoiceManager goy;
    private g hOY;
    private int hOZ = 0;
    private int hPa = 0;
    private int hPb = 0;
    private int doz = 0;
    private boolean doA = false;
    private int doB = 0;
    private boolean doC = false;
    private int doD = 0;
    private boolean doE = false;
    private TbTabLayout.b hPc = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.doA && MessageCenterFragment.this.hPb > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aKF().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.hOY.m(eVar.getId(), MessageCenterFragment.this.doz, MessageCenterFragment.this.doA);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.doE) {
                        MessageCenterFragment.this.bZB();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.b.aKF().aKM();
                    MessageCenterFragment.this.hOY.m(eVar.getId(), MessageCenterFragment.this.doD, MessageCenterFragment.this.doE);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.hOY.m(eVar.getId(), MessageCenterFragment.this.doB, MessageCenterFragment.this.doC);
                }
                MessageCenterFragment.this.xb(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.hOY != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                com.baidu.adp.lib.util.l.hideSoftKeyPad(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.hOY.bZC());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.hOY != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.hOY.bZC());
                }
                MessageCenterFragment.this.xb(eVar.getId());
            }
        }
    };
    private CustomMessageListener hPd = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        private boolean hPg = true;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3) {
                if (!TbadkCoreApplication.getInst().checkInterrupt() || !this.hPg) {
                    if (MessageCenterFragment.this.bZy()) {
                        if (!MessageCenterFragment.this.isPrimary() && MessageCenterFragment.this.hPb <= 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (MessageCenterFragment.this.getPageContext() != null) {
                    this.hPg = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener hPe = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.j(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bZy() {
        return this.hOY != null && this.hOY.rP(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.hPd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.message_center_activity, viewGroup, false);
        this.hOY = new g(this);
        this.hOY.a(inflate, bundle);
        this.hOY.rO(2);
        this.hOY.a(this.hPc);
        this.hPe.setPriority(Integer.MAX_VALUE);
        registerListener(this.hPe);
        a(getActivity().getIntent(), bundle);
        this.goy = getVoiceManager();
        this.goy.onCreate(getPageContext());
        TiebaStatic.log(new an("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.bUo().bUp();
        if (this.goy == null) {
            this.goy = getVoiceManager();
            this.goy.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hOY != null) {
            this.hOY.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e bZD;
        if (this.hOY != null && (bZD = this.hOY.bZD()) != null) {
            bundle.putInt("Selected_Tab", bZD.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.hOY != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hOY != null) {
            this.hOY.onChangeSkinType(this.mSkinType);
        }
    }

    public void bZz() {
        getActivity().finish();
    }

    public void bZA() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.doA) {
                i = 1;
            } else if (this.doC) {
                i = 2;
            } else if (this.doE) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.hOY != null) {
            this.hOY.rO(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.hPb;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.hOZ = newsRemindMessage.getMsgAgreeCount();
            this.hPa = newsRemindMessage.getMsgAtCount();
            this.hPb = newsRemindMessage.getMsgReplyCount();
            this.doz = newsRemindMessage.getMsgCount();
            this.doA = newsRemindMessage.hasMsgRemind();
            this.doB = newsRemindMessage.getChatCount();
            this.doC = newsRemindMessage.hasChatRemind();
            this.doD = newsRemindMessage.getNotificationCount();
            this.doE = newsRemindMessage.hasNotificationRemind();
            if (this.hOY != null) {
                if (i > 0 && this.hPb == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY, getPageContext().getUniqueId()));
                }
                this.hOY.m(1, this.doz, this.doA);
                this.hOY.m(2, this.doB, this.doC);
                if (this.hOY.rP(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.aKF().aKM();
                    if (this.doE) {
                        bZB();
                        return;
                    }
                }
                this.hOY.m(3, this.doD, this.doE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZB() {
        HashSet hashSet;
        HashMap<Integer, HashSet> aLd = com.baidu.tbadk.coreExtra.messageCenter.b.aKF().aLd();
        if (aLd != null && aLd.size() > 0 && (hashSet = aLd.get(0)) != null && hashSet.size() > 0) {
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
    public void xb(int i) {
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
        com.baidu.tieba.im.db.e.bUo().bUp();
        MessageManager.getInstance().unRegisterListener(this.hPe);
        if (this.hOY != null) {
            this.hOY.JJ();
            this.hOY.b(this.hPc);
        }
        if (this.goy != null) {
            this.goy.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.goy == null) {
            this.goy = VoiceManager.instance();
        }
        return this.goy;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.goy != null) {
            this.goy.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.goy != null) {
            this.goy.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.goy != null) {
            this.goy.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.goy != null) {
            this.goy.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.hOY != null) {
            this.hOY.setPrimary(z);
        }
    }
}
