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
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class MessageCenterFragment extends BaseFragment implements VoiceManager.c {
    private VoiceManager eYR;
    private g gxX;
    private int gxY = 0;
    private int gxZ = 0;
    private int gya = 0;
    private int bYW = 0;
    private boolean bYX = false;
    private int bYY = 0;
    private boolean bYZ = false;
    private int bZa = 0;
    private boolean bZb = false;
    private TbTabLayout.b gyb = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.bYX && MessageCenterFragment.this.gya > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.ahA().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.gxX.h(eVar.getId(), MessageCenterFragment.this.bYW, MessageCenterFragment.this.bYX);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.bZb) {
                        MessageCenterFragment.this.bxC();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.b.ahA().ahH();
                    MessageCenterFragment.this.gxX.h(eVar.getId(), MessageCenterFragment.this.bZa, MessageCenterFragment.this.bZb);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.gxX.h(eVar.getId(), MessageCenterFragment.this.bYY, MessageCenterFragment.this.bYZ);
                }
                MessageCenterFragment.this.uy(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.gxX != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.gxX.bxD());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.gxX != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(2016322, (Class) null);
                    com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.gxX.bxD());
                }
                MessageCenterFragment.this.uy(eVar.getId());
            }
        }
    };
    private CustomMessageListener gyc = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3 && MessageCenterFragment.this.bxz()) {
                if ((MessageCenterFragment.this.isPrimary() || MessageCenterFragment.this.gya > 0) && MessageCenterFragment.this.getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener gyd = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.h(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bxz() {
        return this.gxX != null && this.gxX.pg(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gyc);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.message_center_activity, viewGroup, false);
        this.gxX = new g(this);
        this.gxX.a(inflate, bundle);
        this.gxX.pf(2);
        this.gxX.a(this.gyb);
        this.gyd.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.gyd);
        a(getActivity().getIntent(), bundle);
        this.eYR = getVoiceManager();
        this.eYR.onCreate(getPageContext());
        TiebaStatic.log(new am("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.bsj().bsk();
        if (this.eYR == null) {
            this.eYR = getVoiceManager();
            this.eYR.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.gxX != null) {
            this.gxX.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e bxE;
        if (this.gxX != null && (bxE = this.gxX.bxE()) != null) {
            bundle.putInt("Selected_Tab", bxE.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.gxX != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gxX != null) {
            this.gxX.onChangeSkinType(this.mSkinType);
        }
    }

    public void bxA() {
        getActivity().finish();
    }

    public void bxB() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage(2002001, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.bYX) {
                i = 1;
            } else if (this.bYZ) {
                i = 2;
            } else if (this.bZb) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.gxX != null) {
            this.gxX.pf(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.gya;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.gxY = newsRemindMessage.getMsgAgreeCount();
            this.gxZ = newsRemindMessage.getMsgAtCount();
            this.gya = newsRemindMessage.getMsgReplyCount();
            this.bYW = newsRemindMessage.getMsgCount();
            this.bYX = newsRemindMessage.hasMsgRemind();
            this.bYY = newsRemindMessage.getChatCount();
            this.bYZ = newsRemindMessage.hasChatRemind();
            this.bZa = newsRemindMessage.getNotificationCount();
            this.bZb = newsRemindMessage.hasNotificationRemind();
            if (this.gxX != null) {
                if (i > 0 && this.gya == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, getPageContext().getUniqueId()));
                }
                this.gxX.h(1, this.bYW, this.bYX);
                this.gxX.h(2, this.bYY, this.bYZ);
                if (this.gxX.pg(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.ahA().ahH();
                    if (this.bZb) {
                        bxC();
                        return;
                    }
                }
                this.gxX.h(3, this.bZa, this.bZb);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxC() {
        HashSet hashSet;
        HashMap<Integer, HashSet> ahY = com.baidu.tbadk.coreExtra.messageCenter.b.ahA().ahY();
        if (ahY != null && ahY.size() > 0 && (hashSet = ahY.get(0)) != null && hashSet.size() > 0) {
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
    public void uy(int i) {
        if (i == 1) {
            TiebaStatic.log(new am("c12937").T("obj_type", 1));
        } else if (i == 2) {
            TiebaStatic.log(new am("c12937").T("obj_type", 2));
        } else if (i == 3) {
            TiebaStatic.log(new am("c12937").T("obj_type", 3));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.bsj().bsk();
        MessageManager.getInstance().unRegisterListener(this.gyd);
        if (this.gxX != null) {
            this.gxX.aWK();
            this.gxX.b(this.gyb);
        }
        if (this.eYR != null) {
            this.eYR.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.eYR == null) {
            this.eYR = VoiceManager.instance();
        }
        return this.eYR;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.eYR != null) {
            this.eYR.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.eYR != null) {
            this.eYR.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eYR != null) {
            this.eYR.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.eYR != null) {
            this.eYR.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.gxX != null) {
            this.gxX.setPrimary(z);
        }
    }
}
