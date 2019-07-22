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
    private VoiceManager ftO;
    private g gVk;
    private int gVl = 0;
    private int gVm = 0;
    private int gVn = 0;
    private int cic = 0;
    private boolean cie = false;
    private int cif = 0;
    private boolean cig = false;
    private int cih = 0;
    private boolean cii = false;
    private TbTabLayout.b gVo = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.cie && MessageCenterFragment.this.gVn > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.anD().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.gVk.k(eVar.getId(), MessageCenterFragment.this.cic, MessageCenterFragment.this.cie);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.cii) {
                        MessageCenterFragment.this.bHS();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.b.anD().anK();
                    MessageCenterFragment.this.gVk.k(eVar.getId(), MessageCenterFragment.this.cih, MessageCenterFragment.this.cii);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.gVk.k(eVar.getId(), MessageCenterFragment.this.cif, MessageCenterFragment.this.cig);
                }
                MessageCenterFragment.this.wd(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.gVk != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.gVk.bHT());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.gVk != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(2016322, (Class) null);
                    com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.gVk.bHT());
                }
                MessageCenterFragment.this.wd(eVar.getId());
            }
        }
    };
    private CustomMessageListener gVp = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        private boolean gVs = true;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3) {
                if (!TbadkCoreApplication.getInst().checkInterrupt() || !this.gVs) {
                    if (MessageCenterFragment.this.bHP()) {
                        if (!MessageCenterFragment.this.isPrimary() && MessageCenterFragment.this.gVn <= 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (MessageCenterFragment.this.getPageContext() != null) {
                    this.gVs = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener gVq = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.i(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bHP() {
        return this.gVk != null && this.gVk.qy(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gVp);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.message_center_activity, viewGroup, false);
        this.gVk = new g(this);
        this.gVk.a(inflate, bundle);
        this.gVk.qx(2);
        this.gVk.a(this.gVo);
        this.gVq.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.gVq);
        a(getActivity().getIntent(), bundle);
        this.ftO = getVoiceManager();
        this.ftO.onCreate(getPageContext());
        TiebaStatic.log(new an("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.bCB().bCC();
        if (this.ftO == null) {
            this.ftO = getVoiceManager();
            this.ftO.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.gVk != null) {
            this.gVk.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e bHU;
        if (this.gVk != null && (bHU = this.gVk.bHU()) != null) {
            bundle.putInt("Selected_Tab", bHU.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.gVk != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gVk != null) {
            this.gVk.onChangeSkinType(this.mSkinType);
        }
    }

    public void bHQ() {
        getActivity().finish();
    }

    public void bHR() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage(2002001, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.cie) {
                i = 1;
            } else if (this.cig) {
                i = 2;
            } else if (this.cii) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.gVk != null) {
            this.gVk.qx(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.gVn;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.gVl = newsRemindMessage.getMsgAgreeCount();
            this.gVm = newsRemindMessage.getMsgAtCount();
            this.gVn = newsRemindMessage.getMsgReplyCount();
            this.cic = newsRemindMessage.getMsgCount();
            this.cie = newsRemindMessage.hasMsgRemind();
            this.cif = newsRemindMessage.getChatCount();
            this.cig = newsRemindMessage.hasChatRemind();
            this.cih = newsRemindMessage.getNotificationCount();
            this.cii = newsRemindMessage.hasNotificationRemind();
            if (this.gVk != null) {
                if (i > 0 && this.gVn == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, getPageContext().getUniqueId()));
                }
                this.gVk.k(1, this.cic, this.cie);
                this.gVk.k(2, this.cif, this.cig);
                if (this.gVk.qy(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.anD().anK();
                    if (this.cii) {
                        bHS();
                        return;
                    }
                }
                this.gVk.k(3, this.cih, this.cii);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHS() {
        HashSet hashSet;
        HashMap<Integer, HashSet> aob = com.baidu.tbadk.coreExtra.messageCenter.b.anD().aob();
        if (aob != null && aob.size() > 0 && (hashSet = aob.get(0)) != null && hashSet.size() > 0) {
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
    public void wd(int i) {
        if (i == 1) {
            TiebaStatic.log(new an("c12937").P("obj_type", 1));
        } else if (i == 2) {
            TiebaStatic.log(new an("c12937").P("obj_type", 2));
        } else if (i == 3) {
            TiebaStatic.log(new an("c12937").P("obj_type", 3));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.bCB().bCC();
        MessageManager.getInstance().unRegisterListener(this.gVq);
        if (this.gVk != null) {
            this.gVk.bgb();
            this.gVk.b(this.gVo);
        }
        if (this.ftO != null) {
            this.ftO.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.ftO == null) {
            this.ftO = VoiceManager.instance();
        }
        return this.ftO;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.ftO != null) {
            this.ftO.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ftO != null) {
            this.ftO.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ftO != null) {
            this.ftO.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.ftO != null) {
            this.ftO.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.gVk != null) {
            this.gVk.setPrimary(z);
        }
    }
}
