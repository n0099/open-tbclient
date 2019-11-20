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
/* loaded from: classes4.dex */
public class MessageCenterFragment extends BaseFragment implements VoiceManager.c {
    private VoiceManager fuw;
    private g gVg;
    private int gVh = 0;
    private int gVi = 0;
    private int gVj = 0;
    private int cwc = 0;
    private boolean cwd = false;
    private int cwe = 0;
    private boolean cwf = false;
    private int cwg = 0;
    private boolean cwh = false;
    private TbTabLayout.b gVk = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.cwd && MessageCenterFragment.this.gVj > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aqr().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.gVg.k(eVar.getId(), MessageCenterFragment.this.cwc, MessageCenterFragment.this.cwd);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.cwh) {
                        MessageCenterFragment.this.bFC();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.b.aqr().aqy();
                    MessageCenterFragment.this.gVg.k(eVar.getId(), MessageCenterFragment.this.cwg, MessageCenterFragment.this.cwh);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.gVg.k(eVar.getId(), MessageCenterFragment.this.cwe, MessageCenterFragment.this.cwf);
                }
                MessageCenterFragment.this.uO(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.gVg != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                com.baidu.adp.lib.util.l.hideSoftKeyPad(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.gVg.bFD());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.gVg != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.gVg.bFD());
                }
                MessageCenterFragment.this.uO(eVar.getId());
            }
        }
    };
    private CustomMessageListener gVl = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        private boolean gVo = true;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3) {
                if (!TbadkCoreApplication.getInst().checkInterrupt() || !this.gVo) {
                    if (MessageCenterFragment.this.bFz()) {
                        if (!MessageCenterFragment.this.isPrimary() && MessageCenterFragment.this.gVj <= 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (MessageCenterFragment.this.getPageContext() != null) {
                    this.gVo = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener gVm = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.i(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bFz() {
        return this.gVg != null && this.gVg.px(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gVl);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.message_center_activity, viewGroup, false);
        this.gVg = new g(this);
        this.gVg.a(inflate, bundle);
        this.gVg.pw(2);
        this.gVg.a(this.gVk);
        this.gVm.setPriority(Integer.MAX_VALUE);
        registerListener(this.gVm);
        a(getActivity().getIntent(), bundle);
        this.fuw = getVoiceManager();
        this.fuw.onCreate(getPageContext());
        TiebaStatic.log(new an("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.bAl().bAm();
        if (this.fuw == null) {
            this.fuw = getVoiceManager();
            this.fuw.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.gVg != null) {
            this.gVg.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e bFE;
        if (this.gVg != null && (bFE = this.gVg.bFE()) != null) {
            bundle.putInt("Selected_Tab", bFE.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.gVg != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gVg != null) {
            this.gVg.onChangeSkinType(this.mSkinType);
        }
    }

    public void bFA() {
        getActivity().finish();
    }

    public void bFB() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.cwd) {
                i = 1;
            } else if (this.cwf) {
                i = 2;
            } else if (this.cwh) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.gVg != null) {
            this.gVg.pw(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.gVj;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.gVh = newsRemindMessage.getMsgAgreeCount();
            this.gVi = newsRemindMessage.getMsgAtCount();
            this.gVj = newsRemindMessage.getMsgReplyCount();
            this.cwc = newsRemindMessage.getMsgCount();
            this.cwd = newsRemindMessage.hasMsgRemind();
            this.cwe = newsRemindMessage.getChatCount();
            this.cwf = newsRemindMessage.hasChatRemind();
            this.cwg = newsRemindMessage.getNotificationCount();
            this.cwh = newsRemindMessage.hasNotificationRemind();
            if (this.gVg != null) {
                if (i > 0 && this.gVj == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY, getPageContext().getUniqueId()));
                }
                this.gVg.k(1, this.cwc, this.cwd);
                this.gVg.k(2, this.cwe, this.cwf);
                if (this.gVg.px(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.aqr().aqy();
                    if (this.cwh) {
                        bFC();
                        return;
                    }
                }
                this.gVg.k(3, this.cwg, this.cwh);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFC() {
        HashSet hashSet;
        HashMap<Integer, HashSet> aqP = com.baidu.tbadk.coreExtra.messageCenter.b.aqr().aqP();
        if (aqP != null && aqP.size() > 0 && (hashSet = aqP.get(0)) != null && hashSet.size() > 0) {
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
    public void uO(int i) {
        if (i == 1) {
            TiebaStatic.log(new an("c12937").O("obj_type", 1));
        } else if (i == 2) {
            TiebaStatic.log(new an("c12937").O("obj_type", 2));
        } else if (i == 3) {
            TiebaStatic.log(new an("c12937").O("obj_type", 3));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.bAl().bAm();
        MessageManager.getInstance().unRegisterListener(this.gVm);
        if (this.gVg != null) {
            this.gVg.bez();
            this.gVg.b(this.gVk);
        }
        if (this.fuw != null) {
            this.fuw.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fuw == null) {
            this.fuw = VoiceManager.instance();
        }
        return this.fuw;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.fuw != null) {
            this.fuw.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fuw != null) {
            this.fuw.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fuw != null) {
            this.fuw.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.fuw != null) {
            this.fuw.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.gVg != null) {
            this.gVg.setPrimary(z);
        }
    }
}
