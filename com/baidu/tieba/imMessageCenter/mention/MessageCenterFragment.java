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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class MessageCenterFragment extends BaseFragment implements VoiceManager.c {
    private VoiceManager dLz;
    private g fhS;
    private int fhT = 0;
    private int fhU = 0;
    private int fhV = 0;
    private int aQu = 0;
    private boolean aQv = false;
    private int aQw = 0;
    private boolean aQx = false;
    private int aQy = 0;
    private boolean aQz = false;
    private TbTabLayout.b fhW = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.aQv && MessageCenterFragment.this.fhV > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.If().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.fhS.g(eVar.getId(), MessageCenterFragment.this.aQu, MessageCenterFragment.this.aQv);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.aQz) {
                        MessageCenterFragment.this.aWY();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.a.If().Im();
                    MessageCenterFragment.this.fhS.g(eVar.getId(), MessageCenterFragment.this.aQy, MessageCenterFragment.this.aQz);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.fhS.g(eVar.getId(), MessageCenterFragment.this.aQw, MessageCenterFragment.this.aQx);
                }
                MessageCenterFragment.this.qO(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.fhS != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.fhS.aWZ());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.fhS != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(2016322, (Class) null);
                    com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.fhS.aWZ());
                }
                MessageCenterFragment.this.qO(eVar.getId());
            }
        }
    };
    private CustomMessageListener fhX = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        private boolean fia = true;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3) {
                if (!TbadkCoreApplication.getInst().checkInterrupt() || !this.fia) {
                    if (MessageCenterFragment.this.aWV()) {
                        if (!MessageCenterFragment.this.isPrimary() && MessageCenterFragment.this.fhV <= 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (MessageCenterFragment.this.getPageContext() != null) {
                    this.fia = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener fhY = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.h(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aWV() {
        return this.fhS != null && this.fhS.qR(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.fhX);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.message_center_activity, viewGroup, false);
        this.fhS = new g(this);
        this.fhS.a(inflate, bundle);
        this.fhS.qP(2);
        this.fhS.a(this.fhW);
        this.fhY.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.fhY);
        a(getActivity().getIntent(), bundle);
        this.dLz = getVoiceManager();
        this.dLz.onCreate(getPageContext());
        TiebaStatic.log(new am("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.aRE().aRF();
        if (this.dLz == null) {
            this.dLz = getVoiceManager();
            this.dLz.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.fhS != null) {
            this.fhS.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e aXa;
        if (this.fhS != null && (aXa = this.fhS.aXa()) != null) {
            bundle.putInt("Selected_Tab", aXa.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.fhS != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fhS != null) {
            this.fhS.onChangeSkinType(this.mSkinType);
        }
    }

    public void aWW() {
        getActivity().finish();
    }

    public void aWX() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage(2002001, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.aQv) {
                i = 1;
            } else if (this.aQx) {
                i = 2;
            } else if (this.aQz) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.fhS != null) {
            this.fhS.qP(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.fhV;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.fhT = newsRemindMessage.getMsgAgreeCount();
            this.fhU = newsRemindMessage.getMsgAtCount();
            this.fhV = newsRemindMessage.getMsgReplyCount();
            this.aQu = newsRemindMessage.getMsgCount();
            this.aQv = newsRemindMessage.hasMsgRemind();
            this.aQw = newsRemindMessage.getChatCount();
            this.aQx = newsRemindMessage.hasChatRemind();
            this.aQy = newsRemindMessage.getNotificationCount();
            this.aQz = newsRemindMessage.hasNotificationRemind();
            if (this.fhS != null) {
                if (i > 0 && this.fhV == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, getPageContext().getUniqueId()));
                }
                this.fhS.g(1, this.aQu, this.aQv);
                this.fhS.g(2, this.aQw, this.aQx);
                if (this.fhS.qR(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.If().Im();
                    if (this.aQz) {
                        aWY();
                        return;
                    }
                }
                this.fhS.g(3, this.aQy, this.aQz);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWY() {
        HashSet hashSet;
        HashMap<Integer, HashSet> ID = com.baidu.tbadk.coreExtra.messageCenter.a.If().ID();
        if (ID != null && ID.size() > 0 && (hashSet = ID.get(0)) != null && hashSet.size() > 0) {
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
    public void qO(int i) {
        if (i == 1) {
            TiebaStatic.log(new am("c12937").y("obj_type", 1));
        } else if (i == 2) {
            TiebaStatic.log(new am("c12937").y("obj_type", 2));
        } else if (i == 3) {
            TiebaStatic.log(new am("c12937").y("obj_type", 3));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.aRE().aRF();
        MessageManager.getInstance().unRegisterListener(this.fhY);
        if (this.fhS != null) {
            this.fhS.aXb();
            this.fhS.b(this.fhW);
        }
        if (this.dLz != null) {
            this.dLz.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dLz == null) {
            this.dLz = VoiceManager.instance();
        }
        return this.dLz;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dLz != null) {
            this.dLz.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dLz != null) {
            this.dLz.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dLz != null) {
            this.dLz.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dLz != null) {
            this.dLz.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.fhS != null) {
            this.fhS.setPrimary(z);
        }
    }
}
