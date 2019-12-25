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
/* loaded from: classes6.dex */
public class MessageCenterFragment extends BaseFragment implements VoiceManager.c {
    private VoiceManager giZ;
    private g hJj;
    private int hJk = 0;
    private int hJl = 0;
    private int hJm = 0;
    private int djO = 0;
    private boolean djP = false;
    private int djQ = 0;
    private boolean djR = false;
    private int djS = 0;
    private boolean djT = false;
    private TbTabLayout.b hJn = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.djP && MessageCenterFragment.this.hJm > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aHP().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.hJj.m(eVar.getId(), MessageCenterFragment.this.djO, MessageCenterFragment.this.djP);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.djT) {
                        MessageCenterFragment.this.bWO();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.b.aHP().aHW();
                    MessageCenterFragment.this.hJj.m(eVar.getId(), MessageCenterFragment.this.djS, MessageCenterFragment.this.djT);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.hJj.m(eVar.getId(), MessageCenterFragment.this.djQ, MessageCenterFragment.this.djR);
                }
                MessageCenterFragment.this.wQ(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.hJj != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                com.baidu.adp.lib.util.l.hideSoftKeyPad(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.hJj.bWP());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.hJj != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.hJj.bWP());
                }
                MessageCenterFragment.this.wQ(eVar.getId());
            }
        }
    };
    private CustomMessageListener hJo = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        private boolean hJr = true;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3) {
                if (!TbadkCoreApplication.getInst().checkInterrupt() || !this.hJr) {
                    if (MessageCenterFragment.this.bWL()) {
                        if (!MessageCenterFragment.this.isPrimary() && MessageCenterFragment.this.hJm <= 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (MessageCenterFragment.this.getPageContext() != null) {
                    this.hJr = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener hJp = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.j(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bWL() {
        return this.hJj != null && this.hJj.rD(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.hJo);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.message_center_activity, viewGroup, false);
        this.hJj = new g(this);
        this.hJj.a(inflate, bundle);
        this.hJj.rC(2);
        this.hJj.a(this.hJn);
        this.hJp.setPriority(Integer.MAX_VALUE);
        registerListener(this.hJp);
        a(getActivity().getIntent(), bundle);
        this.giZ = getVoiceManager();
        this.giZ.onCreate(getPageContext());
        TiebaStatic.log(new an("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.bRB().bRC();
        if (this.giZ == null) {
            this.giZ = getVoiceManager();
            this.giZ.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hJj != null) {
            this.hJj.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e bWQ;
        if (this.hJj != null && (bWQ = this.hJj.bWQ()) != null) {
            bundle.putInt("Selected_Tab", bWQ.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.hJj != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hJj != null) {
            this.hJj.onChangeSkinType(this.mSkinType);
        }
    }

    public void bWM() {
        getActivity().finish();
    }

    public void bWN() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.djP) {
                i = 1;
            } else if (this.djR) {
                i = 2;
            } else if (this.djT) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.hJj != null) {
            this.hJj.rC(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.hJm;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.hJk = newsRemindMessage.getMsgAgreeCount();
            this.hJl = newsRemindMessage.getMsgAtCount();
            this.hJm = newsRemindMessage.getMsgReplyCount();
            this.djO = newsRemindMessage.getMsgCount();
            this.djP = newsRemindMessage.hasMsgRemind();
            this.djQ = newsRemindMessage.getChatCount();
            this.djR = newsRemindMessage.hasChatRemind();
            this.djS = newsRemindMessage.getNotificationCount();
            this.djT = newsRemindMessage.hasNotificationRemind();
            if (this.hJj != null) {
                if (i > 0 && this.hJm == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY, getPageContext().getUniqueId()));
                }
                this.hJj.m(1, this.djO, this.djP);
                this.hJj.m(2, this.djQ, this.djR);
                if (this.hJj.rD(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.aHP().aHW();
                    if (this.djT) {
                        bWO();
                        return;
                    }
                }
                this.hJj.m(3, this.djS, this.djT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWO() {
        HashSet hashSet;
        HashMap<Integer, HashSet> aIn = com.baidu.tbadk.coreExtra.messageCenter.b.aHP().aIn();
        if (aIn != null && aIn.size() > 0 && (hashSet = aIn.get(0)) != null && hashSet.size() > 0) {
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
    public void wQ(int i) {
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
        com.baidu.tieba.im.db.e.bRB().bRC();
        MessageManager.getInstance().unRegisterListener(this.hJp);
        if (this.hJj != null) {
            this.hJj.GW();
            this.hJj.b(this.hJn);
        }
        if (this.giZ != null) {
            this.giZ.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.giZ == null) {
            this.giZ = VoiceManager.instance();
        }
        return this.giZ;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.giZ != null) {
            this.giZ.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.giZ != null) {
            this.giZ.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.giZ != null) {
            this.giZ.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.giZ != null) {
            this.giZ.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.hJj != null) {
            this.hJj.setPrimary(z);
        }
    }
}
