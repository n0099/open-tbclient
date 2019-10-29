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
    private VoiceManager fvn;
    private g gVX;
    private int gVY = 0;
    private int gVZ = 0;
    private int gWa = 0;
    private int cwT = 0;
    private boolean cwU = false;
    private int cwV = 0;
    private boolean cwW = false;
    private int cwX = 0;
    private boolean cwY = false;
    private TbTabLayout.b gWb = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.cwU && MessageCenterFragment.this.gWa > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aqt().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.gVX.k(eVar.getId(), MessageCenterFragment.this.cwT, MessageCenterFragment.this.cwU);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.cwY) {
                        MessageCenterFragment.this.bFE();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.b.aqt().aqA();
                    MessageCenterFragment.this.gVX.k(eVar.getId(), MessageCenterFragment.this.cwX, MessageCenterFragment.this.cwY);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.gVX.k(eVar.getId(), MessageCenterFragment.this.cwV, MessageCenterFragment.this.cwW);
                }
                MessageCenterFragment.this.uP(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.gVX != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                com.baidu.adp.lib.util.l.hideSoftKeyPad(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.gVX.bFF());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.gVX != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.gVX.bFF());
                }
                MessageCenterFragment.this.uP(eVar.getId());
            }
        }
    };
    private CustomMessageListener gWc = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        private boolean gWf = true;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3) {
                if (!TbadkCoreApplication.getInst().checkInterrupt() || !this.gWf) {
                    if (MessageCenterFragment.this.bFB()) {
                        if (!MessageCenterFragment.this.isPrimary() && MessageCenterFragment.this.gWa <= 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (MessageCenterFragment.this.getPageContext() != null) {
                    this.gWf = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener gWd = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.i(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bFB() {
        return this.gVX != null && this.gVX.py(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gWc);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.message_center_activity, viewGroup, false);
        this.gVX = new g(this);
        this.gVX.a(inflate, bundle);
        this.gVX.px(2);
        this.gVX.a(this.gWb);
        this.gWd.setPriority(Integer.MAX_VALUE);
        registerListener(this.gWd);
        a(getActivity().getIntent(), bundle);
        this.fvn = getVoiceManager();
        this.fvn.onCreate(getPageContext());
        TiebaStatic.log(new an("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.bAn().bAo();
        if (this.fvn == null) {
            this.fvn = getVoiceManager();
            this.fvn.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.gVX != null) {
            this.gVX.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e bFG;
        if (this.gVX != null && (bFG = this.gVX.bFG()) != null) {
            bundle.putInt("Selected_Tab", bFG.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.gVX != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gVX != null) {
            this.gVX.onChangeSkinType(this.mSkinType);
        }
    }

    public void bFC() {
        getActivity().finish();
    }

    public void bFD() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.cwU) {
                i = 1;
            } else if (this.cwW) {
                i = 2;
            } else if (this.cwY) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.gVX != null) {
            this.gVX.px(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.gWa;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.gVY = newsRemindMessage.getMsgAgreeCount();
            this.gVZ = newsRemindMessage.getMsgAtCount();
            this.gWa = newsRemindMessage.getMsgReplyCount();
            this.cwT = newsRemindMessage.getMsgCount();
            this.cwU = newsRemindMessage.hasMsgRemind();
            this.cwV = newsRemindMessage.getChatCount();
            this.cwW = newsRemindMessage.hasChatRemind();
            this.cwX = newsRemindMessage.getNotificationCount();
            this.cwY = newsRemindMessage.hasNotificationRemind();
            if (this.gVX != null) {
                if (i > 0 && this.gWa == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY, getPageContext().getUniqueId()));
                }
                this.gVX.k(1, this.cwT, this.cwU);
                this.gVX.k(2, this.cwV, this.cwW);
                if (this.gVX.py(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.aqt().aqA();
                    if (this.cwY) {
                        bFE();
                        return;
                    }
                }
                this.gVX.k(3, this.cwX, this.cwY);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFE() {
        HashSet hashSet;
        HashMap<Integer, HashSet> aqR = com.baidu.tbadk.coreExtra.messageCenter.b.aqt().aqR();
        if (aqR != null && aqR.size() > 0 && (hashSet = aqR.get(0)) != null && hashSet.size() > 0) {
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
    public void uP(int i) {
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
        com.baidu.tieba.im.db.e.bAn().bAo();
        MessageManager.getInstance().unRegisterListener(this.gWd);
        if (this.gVX != null) {
            this.gVX.beB();
            this.gVX.b(this.gWb);
        }
        if (this.fvn != null) {
            this.fvn.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fvn == null) {
            this.fvn = VoiceManager.instance();
        }
        return this.fvn;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.fvn != null) {
            this.fvn.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fvn != null) {
            this.fvn.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fvn != null) {
            this.fvn.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.fvn != null) {
            this.fvn.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.gVX != null) {
            this.gVX.setPrimary(z);
        }
    }
}
