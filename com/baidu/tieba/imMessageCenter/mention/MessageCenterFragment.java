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
    private VoiceManager eYE;
    private g gxL;
    private int gxM = 0;
    private int gxN = 0;
    private int gxO = 0;
    private int bYZ = 0;
    private boolean bZa = false;
    private int bZb = 0;
    private boolean bZc = false;
    private int bZd = 0;
    private boolean bZe = false;
    private TbTabLayout.b gxP = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.bZa && MessageCenterFragment.this.gxO > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.ahx().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.gxL.h(eVar.getId(), MessageCenterFragment.this.bYZ, MessageCenterFragment.this.bZa);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.bZe) {
                        MessageCenterFragment.this.bxz();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.b.ahx().ahE();
                    MessageCenterFragment.this.gxL.h(eVar.getId(), MessageCenterFragment.this.bZd, MessageCenterFragment.this.bZe);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.gxL.h(eVar.getId(), MessageCenterFragment.this.bZb, MessageCenterFragment.this.bZc);
                }
                MessageCenterFragment.this.uu(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.gxL != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.gxL.bxA());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.gxL != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(2016322, (Class) null);
                    com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.gxL.bxA());
                }
                MessageCenterFragment.this.uu(eVar.getId());
            }
        }
    };
    private CustomMessageListener gxQ = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3 && MessageCenterFragment.this.bxw()) {
                if ((MessageCenterFragment.this.isPrimary() || MessageCenterFragment.this.gxO > 0) && MessageCenterFragment.this.getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener gxR = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.h(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bxw() {
        return this.gxL != null && this.gxL.pc(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gxQ);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.message_center_activity, viewGroup, false);
        this.gxL = new g(this);
        this.gxL.a(inflate, bundle);
        this.gxL.pb(2);
        this.gxL.a(this.gxP);
        this.gxR.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.gxR);
        a(getActivity().getIntent(), bundle);
        this.eYE = getVoiceManager();
        this.eYE.onCreate(getPageContext());
        TiebaStatic.log(new am("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.bsg().bsh();
        if (this.eYE == null) {
            this.eYE = getVoiceManager();
            this.eYE.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.gxL != null) {
            this.gxL.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e bxB;
        if (this.gxL != null && (bxB = this.gxL.bxB()) != null) {
            bundle.putInt("Selected_Tab", bxB.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.gxL != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gxL != null) {
            this.gxL.onChangeSkinType(this.mSkinType);
        }
    }

    public void bxx() {
        getActivity().finish();
    }

    public void bxy() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage(2002001, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.bZa) {
                i = 1;
            } else if (this.bZc) {
                i = 2;
            } else if (this.bZe) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.gxL != null) {
            this.gxL.pb(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.gxO;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.gxM = newsRemindMessage.getMsgAgreeCount();
            this.gxN = newsRemindMessage.getMsgAtCount();
            this.gxO = newsRemindMessage.getMsgReplyCount();
            this.bYZ = newsRemindMessage.getMsgCount();
            this.bZa = newsRemindMessage.hasMsgRemind();
            this.bZb = newsRemindMessage.getChatCount();
            this.bZc = newsRemindMessage.hasChatRemind();
            this.bZd = newsRemindMessage.getNotificationCount();
            this.bZe = newsRemindMessage.hasNotificationRemind();
            if (this.gxL != null) {
                if (i > 0 && this.gxO == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, getPageContext().getUniqueId()));
                }
                this.gxL.h(1, this.bYZ, this.bZa);
                this.gxL.h(2, this.bZb, this.bZc);
                if (this.gxL.pc(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.ahx().ahE();
                    if (this.bZe) {
                        bxz();
                        return;
                    }
                }
                this.gxL.h(3, this.bZd, this.bZe);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxz() {
        HashSet hashSet;
        HashMap<Integer, HashSet> ahV = com.baidu.tbadk.coreExtra.messageCenter.b.ahx().ahV();
        if (ahV != null && ahV.size() > 0 && (hashSet = ahV.get(0)) != null && hashSet.size() > 0) {
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
    public void uu(int i) {
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
        com.baidu.tieba.im.db.e.bsg().bsh();
        MessageManager.getInstance().unRegisterListener(this.gxR);
        if (this.gxL != null) {
            this.gxL.aWI();
            this.gxL.b(this.gxP);
        }
        if (this.eYE != null) {
            this.eYE.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.eYE == null) {
            this.eYE = VoiceManager.instance();
        }
        return this.eYE;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.eYE != null) {
            this.eYE.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.eYE != null) {
            this.eYE.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eYE != null) {
            this.eYE.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.eYE != null) {
            this.eYE.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.gxL != null) {
            this.gxL.setPrimary(z);
        }
    }
}
