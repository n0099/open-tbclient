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
    private VoiceManager gol;
    private g hOM;
    private int hON = 0;
    private int hOO = 0;
    private int hOP = 0;
    private int dol = 0;
    private boolean dom = false;
    private int don = 0;
    private boolean doo = false;
    private int dop = 0;
    private boolean doq = false;
    private TbTabLayout.b hOQ = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.dom && MessageCenterFragment.this.hOP > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aKE().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.hOM.m(eVar.getId(), MessageCenterFragment.this.dol, MessageCenterFragment.this.dom);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.doq) {
                        MessageCenterFragment.this.bZA();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.b.aKE().aKL();
                    MessageCenterFragment.this.hOM.m(eVar.getId(), MessageCenterFragment.this.dop, MessageCenterFragment.this.doq);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.hOM.m(eVar.getId(), MessageCenterFragment.this.don, MessageCenterFragment.this.doo);
                }
                MessageCenterFragment.this.xb(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.hOM != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                com.baidu.adp.lib.util.l.hideSoftKeyPad(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.hOM.bZB());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.hOM != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.hOM.bZB());
                }
                MessageCenterFragment.this.xb(eVar.getId());
            }
        }
    };
    private CustomMessageListener hOR = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        private boolean hOU = true;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3) {
                if (!TbadkCoreApplication.getInst().checkInterrupt() || !this.hOU) {
                    if (MessageCenterFragment.this.bZx()) {
                        if (!MessageCenterFragment.this.isPrimary() && MessageCenterFragment.this.hOP <= 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (MessageCenterFragment.this.getPageContext() != null) {
                    this.hOU = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener hOS = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.j(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bZx() {
        return this.hOM != null && this.hOM.rP(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.hOR);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.message_center_activity, viewGroup, false);
        this.hOM = new g(this);
        this.hOM.a(inflate, bundle);
        this.hOM.rO(2);
        this.hOM.a(this.hOQ);
        this.hOS.setPriority(Integer.MAX_VALUE);
        registerListener(this.hOS);
        a(getActivity().getIntent(), bundle);
        this.gol = getVoiceManager();
        this.gol.onCreate(getPageContext());
        TiebaStatic.log(new an("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.bUn().bUo();
        if (this.gol == null) {
            this.gol = getVoiceManager();
            this.gol.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hOM != null) {
            this.hOM.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e bZC;
        if (this.hOM != null && (bZC = this.hOM.bZC()) != null) {
            bundle.putInt("Selected_Tab", bZC.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.hOM != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hOM != null) {
            this.hOM.onChangeSkinType(this.mSkinType);
        }
    }

    public void bZy() {
        getActivity().finish();
    }

    public void bZz() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.dom) {
                i = 1;
            } else if (this.doo) {
                i = 2;
            } else if (this.doq) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.hOM != null) {
            this.hOM.rO(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.hOP;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.hON = newsRemindMessage.getMsgAgreeCount();
            this.hOO = newsRemindMessage.getMsgAtCount();
            this.hOP = newsRemindMessage.getMsgReplyCount();
            this.dol = newsRemindMessage.getMsgCount();
            this.dom = newsRemindMessage.hasMsgRemind();
            this.don = newsRemindMessage.getChatCount();
            this.doo = newsRemindMessage.hasChatRemind();
            this.dop = newsRemindMessage.getNotificationCount();
            this.doq = newsRemindMessage.hasNotificationRemind();
            if (this.hOM != null) {
                if (i > 0 && this.hOP == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY, getPageContext().getUniqueId()));
                }
                this.hOM.m(1, this.dol, this.dom);
                this.hOM.m(2, this.don, this.doo);
                if (this.hOM.rP(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.aKE().aKL();
                    if (this.doq) {
                        bZA();
                        return;
                    }
                }
                this.hOM.m(3, this.dop, this.doq);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZA() {
        HashSet hashSet;
        HashMap<Integer, HashSet> aLc = com.baidu.tbadk.coreExtra.messageCenter.b.aKE().aLc();
        if (aLc != null && aLc.size() > 0 && (hashSet = aLc.get(0)) != null && hashSet.size() > 0) {
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
        com.baidu.tieba.im.db.e.bUn().bUo();
        MessageManager.getInstance().unRegisterListener(this.hOS);
        if (this.hOM != null) {
            this.hOM.JJ();
            this.hOM.b(this.hOQ);
        }
        if (this.gol != null) {
            this.gol.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gol == null) {
            this.gol = VoiceManager.instance();
        }
        return this.gol;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gol != null) {
            this.gol.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gol != null) {
            this.gol.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gol != null) {
            this.gol.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.gol != null) {
            this.gol.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.hOM != null) {
            this.hOM.setPrimary(z);
        }
    }
}
