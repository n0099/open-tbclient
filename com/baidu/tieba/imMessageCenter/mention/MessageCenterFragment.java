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
    private VoiceManager hnh;
    private g iPc;
    private int iPd = 0;
    private int iPe = 0;
    private int iPf = 0;
    private int eda = 0;
    private boolean edb = false;
    private int edc = 0;
    private boolean edd = false;
    private int ede = 0;
    private boolean edf = false;
    private TbTabLayout.b iPg = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.edb && MessageCenterFragment.this.iPf > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aZl().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.iPc.m(eVar.getId(), MessageCenterFragment.this.eda, MessageCenterFragment.this.edb);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.edf) {
                        MessageCenterFragment.this.cqR();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.b.aZl().aZs();
                    MessageCenterFragment.this.iPc.m(eVar.getId(), MessageCenterFragment.this.ede, MessageCenterFragment.this.edf);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.iPc.m(eVar.getId(), MessageCenterFragment.this.edc, MessageCenterFragment.this.edd);
                }
                MessageCenterFragment.this.yn(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.iPc != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                com.baidu.adp.lib.util.l.hideSoftKeyPad(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.iPc.cqS());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.iPc != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.iPc.cqS());
                }
                MessageCenterFragment.this.yn(eVar.getId());
            }
        }
    };
    private CustomMessageListener iPh = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        private boolean iPk = true;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3) {
                if (!TbadkCoreApplication.getInst().checkInterrupt() || !this.iPk) {
                    if (MessageCenterFragment.this.cqO()) {
                        if (!MessageCenterFragment.this.isPrimary() && MessageCenterFragment.this.iPf <= 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (MessageCenterFragment.this.getPageContext() != null) {
                    this.iPk = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener iPi = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.j(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqO() {
        return this.iPc != null && this.iPc.yq(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.iPh);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.message_center_activity, viewGroup, false);
        this.iPc = new g(this);
        this.iPc.a(inflate, bundle);
        this.iPc.yo(2);
        this.iPc.a(this.iPg);
        this.iPi.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.iPi);
        a(getActivity().getIntent(), bundle);
        this.hnh = getVoiceManager();
        this.hnh.onCreate(getPageContext());
        TiebaStatic.log(new an("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.clD().clE();
        if (this.hnh == null) {
            this.hnh = getVoiceManager();
            this.hnh.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.iPc != null) {
            this.iPc.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e cqT;
        if (this.iPc != null && (cqT = this.iPc.cqT()) != null) {
            bundle.putInt("Selected_Tab", cqT.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.iPc != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iPc != null) {
            this.iPc.onChangeSkinType(this.mSkinType);
        }
    }

    public void cqP() {
        getActivity().finish();
    }

    public void cqQ() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.edb) {
                i = 1;
            } else if (this.edd) {
                i = 2;
            } else if (this.edf) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.iPc != null) {
            this.iPc.yo(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.iPf;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.iPd = newsRemindMessage.getMsgAgreeCount();
            this.iPe = newsRemindMessage.getMsgAtCount();
            this.iPf = newsRemindMessage.getMsgReplyCount();
            this.eda = newsRemindMessage.getMsgCount();
            this.edb = newsRemindMessage.hasMsgRemind();
            this.edc = newsRemindMessage.getChatCount();
            this.edd = newsRemindMessage.hasChatRemind();
            this.ede = newsRemindMessage.getNotificationCount();
            this.edf = newsRemindMessage.hasNotificationRemind();
            if (this.iPc != null) {
                if (i > 0 && this.iPf == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY, getPageContext().getUniqueId()));
                }
                this.iPc.m(1, this.eda, this.edb);
                this.iPc.m(2, this.edc, this.edd);
                if (this.iPc.yq(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.aZl().aZs();
                    if (this.edf) {
                        cqR();
                        return;
                    }
                }
                this.iPc.m(3, this.ede, this.edf);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqR() {
        HashSet hashSet;
        HashMap<Integer, HashSet> aZJ = com.baidu.tbadk.coreExtra.messageCenter.b.aZl().aZJ();
        if (aZJ != null && aZJ.size() > 0 && (hashSet = aZJ.get(0)) != null && hashSet.size() > 0) {
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
    public void yn(int i) {
        if (i == 1) {
            TiebaStatic.log(new an("c12937").ag("obj_type", 1));
        } else if (i == 2) {
            TiebaStatic.log(new an("c12937").ag("obj_type", 2));
        } else if (i == 3) {
            TiebaStatic.log(new an("c12937").ag("obj_type", 3));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.clD().clE();
        MessageManager.getInstance().unRegisterListener(this.iPi);
        if (this.iPc != null) {
            this.iPc.TY();
            this.iPc.b(this.iPg);
        }
        if (this.hnh != null) {
            this.hnh.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hnh == null) {
            this.hnh = VoiceManager.instance();
        }
        return this.hnh;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.hnh != null) {
            this.hnh.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.hnh != null) {
            this.hnh.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hnh != null) {
            this.hnh.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.hnh != null) {
            this.hnh.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.iPc != null) {
            this.iPc.setPrimary(z);
        }
    }
}
