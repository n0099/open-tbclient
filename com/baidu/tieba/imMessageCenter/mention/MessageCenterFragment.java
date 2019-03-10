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
    private VoiceManager eYS;
    private g gxY;
    private int gxZ = 0;
    private int gya = 0;
    private int gyb = 0;
    private int bYV = 0;
    private boolean bYW = false;
    private int bYX = 0;
    private boolean bYY = false;
    private int bYZ = 0;
    private boolean bZa = false;
    private TbTabLayout.b gyc = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.bYW && MessageCenterFragment.this.gyb > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.ahA().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.gxY.h(eVar.getId(), MessageCenterFragment.this.bYV, MessageCenterFragment.this.bYW);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.bZa) {
                        MessageCenterFragment.this.bxD();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.b.ahA().ahH();
                    MessageCenterFragment.this.gxY.h(eVar.getId(), MessageCenterFragment.this.bYZ, MessageCenterFragment.this.bZa);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.gxY.h(eVar.getId(), MessageCenterFragment.this.bYX, MessageCenterFragment.this.bYY);
                }
                MessageCenterFragment.this.uy(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.gxY != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.gxY.bxE());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.gxY != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(2016322, (Class) null);
                    com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.gxY.bxE());
                }
                MessageCenterFragment.this.uy(eVar.getId());
            }
        }
    };
    private CustomMessageListener gyd = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3 && MessageCenterFragment.this.bxA()) {
                if ((MessageCenterFragment.this.isPrimary() || MessageCenterFragment.this.gyb > 0) && MessageCenterFragment.this.getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener gye = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.h(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bxA() {
        return this.gxY != null && this.gxY.pg(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gyd);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.message_center_activity, viewGroup, false);
        this.gxY = new g(this);
        this.gxY.a(inflate, bundle);
        this.gxY.pf(2);
        this.gxY.a(this.gyc);
        this.gye.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.gye);
        a(getActivity().getIntent(), bundle);
        this.eYS = getVoiceManager();
        this.eYS.onCreate(getPageContext());
        TiebaStatic.log(new am("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.bsk().bsl();
        if (this.eYS == null) {
            this.eYS = getVoiceManager();
            this.eYS.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.gxY != null) {
            this.gxY.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e bxF;
        if (this.gxY != null && (bxF = this.gxY.bxF()) != null) {
            bundle.putInt("Selected_Tab", bxF.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.gxY != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gxY != null) {
            this.gxY.onChangeSkinType(this.mSkinType);
        }
    }

    public void bxB() {
        getActivity().finish();
    }

    public void bxC() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage(2002001, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.bYW) {
                i = 1;
            } else if (this.bYY) {
                i = 2;
            } else if (this.bZa) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.gxY != null) {
            this.gxY.pf(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.gyb;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.gxZ = newsRemindMessage.getMsgAgreeCount();
            this.gya = newsRemindMessage.getMsgAtCount();
            this.gyb = newsRemindMessage.getMsgReplyCount();
            this.bYV = newsRemindMessage.getMsgCount();
            this.bYW = newsRemindMessage.hasMsgRemind();
            this.bYX = newsRemindMessage.getChatCount();
            this.bYY = newsRemindMessage.hasChatRemind();
            this.bYZ = newsRemindMessage.getNotificationCount();
            this.bZa = newsRemindMessage.hasNotificationRemind();
            if (this.gxY != null) {
                if (i > 0 && this.gyb == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, getPageContext().getUniqueId()));
                }
                this.gxY.h(1, this.bYV, this.bYW);
                this.gxY.h(2, this.bYX, this.bYY);
                if (this.gxY.pg(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.ahA().ahH();
                    if (this.bZa) {
                        bxD();
                        return;
                    }
                }
                this.gxY.h(3, this.bYZ, this.bZa);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxD() {
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
        com.baidu.tieba.im.db.e.bsk().bsl();
        MessageManager.getInstance().unRegisterListener(this.gye);
        if (this.gxY != null) {
            this.gxY.aWL();
            this.gxY.b(this.gyc);
        }
        if (this.eYS != null) {
            this.eYS.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.eYS == null) {
            this.eYS = VoiceManager.instance();
        }
        return this.eYS;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.eYS != null) {
            this.eYS.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.eYS != null) {
            this.eYS.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eYS != null) {
            this.eYS.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.eYS != null) {
            this.eYS.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.gxY != null) {
            this.gxY.setPrimary(z);
        }
    }
}
