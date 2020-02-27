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
    private VoiceManager goj;
    private g hOK;
    private int hOL = 0;
    private int hOM = 0;
    private int hON = 0;
    private int dok = 0;
    private boolean dol = false;
    private int dom = 0;
    private boolean don = false;
    private int doo = 0;
    private boolean dop = false;
    private TbTabLayout.b hOO = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.dol && MessageCenterFragment.this.hON > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aKC().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.hOK.m(eVar.getId(), MessageCenterFragment.this.dok, MessageCenterFragment.this.dol);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.dop) {
                        MessageCenterFragment.this.bZy();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.b.aKC().aKJ();
                    MessageCenterFragment.this.hOK.m(eVar.getId(), MessageCenterFragment.this.doo, MessageCenterFragment.this.dop);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.hOK.m(eVar.getId(), MessageCenterFragment.this.dom, MessageCenterFragment.this.don);
                }
                MessageCenterFragment.this.xb(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.hOK != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                com.baidu.adp.lib.util.l.hideSoftKeyPad(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.hOK.bZz());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.hOK != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.hOK.bZz());
                }
                MessageCenterFragment.this.xb(eVar.getId());
            }
        }
    };
    private CustomMessageListener hOP = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        private boolean hOS = true;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3) {
                if (!TbadkCoreApplication.getInst().checkInterrupt() || !this.hOS) {
                    if (MessageCenterFragment.this.bZv()) {
                        if (!MessageCenterFragment.this.isPrimary() && MessageCenterFragment.this.hON <= 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (MessageCenterFragment.this.getPageContext() != null) {
                    this.hOS = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener hOQ = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.j(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bZv() {
        return this.hOK != null && this.hOK.rP(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.hOP);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.message_center_activity, viewGroup, false);
        this.hOK = new g(this);
        this.hOK.a(inflate, bundle);
        this.hOK.rO(2);
        this.hOK.a(this.hOO);
        this.hOQ.setPriority(Integer.MAX_VALUE);
        registerListener(this.hOQ);
        a(getActivity().getIntent(), bundle);
        this.goj = getVoiceManager();
        this.goj.onCreate(getPageContext());
        TiebaStatic.log(new an("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.bUl().bUm();
        if (this.goj == null) {
            this.goj = getVoiceManager();
            this.goj.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hOK != null) {
            this.hOK.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e bZA;
        if (this.hOK != null && (bZA = this.hOK.bZA()) != null) {
            bundle.putInt("Selected_Tab", bZA.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.hOK != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hOK != null) {
            this.hOK.onChangeSkinType(this.mSkinType);
        }
    }

    public void bZw() {
        getActivity().finish();
    }

    public void bZx() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.dol) {
                i = 1;
            } else if (this.don) {
                i = 2;
            } else if (this.dop) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.hOK != null) {
            this.hOK.rO(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.hON;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.hOL = newsRemindMessage.getMsgAgreeCount();
            this.hOM = newsRemindMessage.getMsgAtCount();
            this.hON = newsRemindMessage.getMsgReplyCount();
            this.dok = newsRemindMessage.getMsgCount();
            this.dol = newsRemindMessage.hasMsgRemind();
            this.dom = newsRemindMessage.getChatCount();
            this.don = newsRemindMessage.hasChatRemind();
            this.doo = newsRemindMessage.getNotificationCount();
            this.dop = newsRemindMessage.hasNotificationRemind();
            if (this.hOK != null) {
                if (i > 0 && this.hON == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY, getPageContext().getUniqueId()));
                }
                this.hOK.m(1, this.dok, this.dol);
                this.hOK.m(2, this.dom, this.don);
                if (this.hOK.rP(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.aKC().aKJ();
                    if (this.dop) {
                        bZy();
                        return;
                    }
                }
                this.hOK.m(3, this.doo, this.dop);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZy() {
        HashSet hashSet;
        HashMap<Integer, HashSet> aLa = com.baidu.tbadk.coreExtra.messageCenter.b.aKC().aLa();
        if (aLa != null && aLa.size() > 0 && (hashSet = aLa.get(0)) != null && hashSet.size() > 0) {
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
        com.baidu.tieba.im.db.e.bUl().bUm();
        MessageManager.getInstance().unRegisterListener(this.hOQ);
        if (this.hOK != null) {
            this.hOK.JH();
            this.hOK.b(this.hOO);
        }
        if (this.goj != null) {
            this.goj.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.goj == null) {
            this.goj = VoiceManager.instance();
        }
        return this.goj;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.goj != null) {
            this.goj.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.goj != null) {
            this.goj.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.goj != null) {
            this.goj.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.goj != null) {
            this.goj.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.hOK != null) {
            this.hOK.setPrimary(z);
        }
    }
}
