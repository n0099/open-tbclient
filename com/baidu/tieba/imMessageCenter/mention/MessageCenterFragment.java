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
    private VoiceManager fwa;
    private g gXW;
    private int gXX = 0;
    private int gXY = 0;
    private int gXZ = 0;
    private int cjf = 0;
    private boolean cjg = false;
    private int cjh = 0;
    private boolean cji = false;
    private int cjj = 0;
    private boolean cjk = false;
    private TbTabLayout.b gYa = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.cjg && MessageCenterFragment.this.gXZ > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.anR().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.gXW.l(eVar.getId(), MessageCenterFragment.this.cjf, MessageCenterFragment.this.cjg);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.cjk) {
                        MessageCenterFragment.this.bIU();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.b.anR().anY();
                    MessageCenterFragment.this.gXW.l(eVar.getId(), MessageCenterFragment.this.cjj, MessageCenterFragment.this.cjk);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.gXW.l(eVar.getId(), MessageCenterFragment.this.cjh, MessageCenterFragment.this.cji);
                }
                MessageCenterFragment.this.wj(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.gXW != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.gXW.bIV());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.gXW != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(2016322, (Class) null);
                    com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.gXW.bIV());
                }
                MessageCenterFragment.this.wj(eVar.getId());
            }
        }
    };
    private CustomMessageListener gYb = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        private boolean gYe = true;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3) {
                if (!TbadkCoreApplication.getInst().checkInterrupt() || !this.gYe) {
                    if (MessageCenterFragment.this.bIR()) {
                        if (!MessageCenterFragment.this.isPrimary() && MessageCenterFragment.this.gXZ <= 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (MessageCenterFragment.this.getPageContext() != null) {
                    this.gYe = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener gYc = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.i(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIR() {
        return this.gXW != null && this.gXW.qC(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gYb);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.message_center_activity, viewGroup, false);
        this.gXW = new g(this);
        this.gXW.a(inflate, bundle);
        this.gXW.qB(2);
        this.gXW.a(this.gYa);
        this.gYc.setPriority(Integer.MAX_VALUE);
        registerListener(this.gYc);
        a(getActivity().getIntent(), bundle);
        this.fwa = getVoiceManager();
        this.fwa.onCreate(getPageContext());
        TiebaStatic.log(new an("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.bDD().bDE();
        if (this.fwa == null) {
            this.fwa = getVoiceManager();
            this.fwa.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.gXW != null) {
            this.gXW.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e bIW;
        if (this.gXW != null && (bIW = this.gXW.bIW()) != null) {
            bundle.putInt("Selected_Tab", bIW.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.gXW != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gXW != null) {
            this.gXW.onChangeSkinType(this.mSkinType);
        }
    }

    public void bIS() {
        getActivity().finish();
    }

    public void bIT() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage(2002001, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.cjg) {
                i = 1;
            } else if (this.cji) {
                i = 2;
            } else if (this.cjk) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.gXW != null) {
            this.gXW.qB(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.gXZ;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.gXX = newsRemindMessage.getMsgAgreeCount();
            this.gXY = newsRemindMessage.getMsgAtCount();
            this.gXZ = newsRemindMessage.getMsgReplyCount();
            this.cjf = newsRemindMessage.getMsgCount();
            this.cjg = newsRemindMessage.hasMsgRemind();
            this.cjh = newsRemindMessage.getChatCount();
            this.cji = newsRemindMessage.hasChatRemind();
            this.cjj = newsRemindMessage.getNotificationCount();
            this.cjk = newsRemindMessage.hasNotificationRemind();
            if (this.gXW != null) {
                if (i > 0 && this.gXZ == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, getPageContext().getUniqueId()));
                }
                this.gXW.l(1, this.cjf, this.cjg);
                this.gXW.l(2, this.cjh, this.cji);
                if (this.gXW.qC(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.anR().anY();
                    if (this.cjk) {
                        bIU();
                        return;
                    }
                }
                this.gXW.l(3, this.cjj, this.cjk);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIU() {
        HashSet hashSet;
        HashMap<Integer, HashSet> aop = com.baidu.tbadk.coreExtra.messageCenter.b.anR().aop();
        if (aop != null && aop.size() > 0 && (hashSet = aop.get(0)) != null && hashSet.size() > 0) {
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
    public void wj(int i) {
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
        com.baidu.tieba.im.db.e.bDD().bDE();
        MessageManager.getInstance().unRegisterListener(this.gYc);
        if (this.gXW != null) {
            this.gXW.bgI();
            this.gXW.b(this.gYa);
        }
        if (this.fwa != null) {
            this.fwa.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fwa == null) {
            this.fwa = VoiceManager.instance();
        }
        return this.fwa;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.fwa != null) {
            this.fwa.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fwa != null) {
            this.fwa.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fwa != null) {
            this.fwa.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.fwa != null) {
            this.fwa.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.gXW != null) {
            this.gXW.setPrimary(z);
        }
    }
}
