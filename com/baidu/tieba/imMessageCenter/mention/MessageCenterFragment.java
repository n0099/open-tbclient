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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.f;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class MessageCenterFragment extends BaseFragment implements VoiceManager.c {
    private VoiceManager dmn;
    private g eHi;
    private int eHj = 0;
    private int eHk = 0;
    private int eHl = 0;
    private int aDQ = 0;
    private boolean aDR = false;
    private int aDS = 0;
    private boolean aDT = false;
    private int aDU = 0;
    private boolean aDV = false;
    private TbTabLayout.b eHm = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.aDR && MessageCenterFragment.this.eHl > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Dl().setMsgReplyme(0);
                    }
                    MessageCenterFragment.this.eHi.f(eVar.getId(), MessageCenterFragment.this.aDQ, MessageCenterFragment.this.aDR);
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.aDV) {
                        MessageCenterFragment.this.aOT();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dl().Ds();
                    MessageCenterFragment.this.eHi.f(eVar.getId(), MessageCenterFragment.this.aDU, MessageCenterFragment.this.aDV);
                } else if (eVar.getId() == 2) {
                    MessageCenterFragment.this.eHi.f(eVar.getId(), MessageCenterFragment.this.aDS, MessageCenterFragment.this.aDT);
                }
                MessageCenterFragment.this.oL(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.eHi != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.a(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.eHi.aOU());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.eHi != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(2016322, (Class) null);
                    com.baidu.adp.lib.util.l.a(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.eHi.aOU());
                }
                MessageCenterFragment.this.oL(eVar.getId());
            }
        }
    };
    private CustomMessageListener eHn = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3 && MessageCenterFragment.this.aOQ()) {
                if ((MessageCenterFragment.this.isPrimary() || MessageCenterFragment.this.eHl > 0) && MessageCenterFragment.this.getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, MessageCenterFragment.this.getPageContext().getUniqueId()));
                }
            }
        }
    };
    private final CustomMessageListener eHo = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.h(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aOQ() {
        return this.eHi != null && this.eHi.oO(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.eHn);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(f.h.message_center_activity, viewGroup, false);
        this.eHi = new g(this);
        this.eHi.a(inflate, bundle);
        this.eHi.oM(2);
        this.eHi.a(this.eHm);
        this.eHo.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.eHo);
        a(getActivity().getIntent(), bundle);
        this.dmn = getVoiceManager();
        this.dmn.onCreate(getPageContext());
        TiebaStatic.log(new an("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.aJy().aJz();
        if (this.dmn == null) {
            this.dmn = getVoiceManager();
            this.dmn.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.eHi != null) {
            this.eHi.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e aOV;
        if (this.eHi != null && (aOV = this.eHi.aOV()) != null) {
            bundle.putInt("Selected_Tab", aOV.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.eHi != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eHi != null) {
            this.eHi.onChangeSkinType(this.mSkinType);
        }
    }

    public void aOR() {
        getActivity().finish();
    }

    public void aOS() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage(2002001, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.aDR) {
                i = 1;
            } else if (this.aDT) {
                i = 2;
            } else if (this.aDV) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.eHi != null) {
            this.eHi.oM(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            int i = this.eHl;
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.eHj = newsRemindMessage.getMsgAgreeCount();
            this.eHk = newsRemindMessage.getMsgAtCount();
            this.eHl = newsRemindMessage.getMsgReplyCount();
            this.aDQ = newsRemindMessage.getMsgCount();
            this.aDR = newsRemindMessage.hasMsgRemind();
            this.aDS = newsRemindMessage.getChatCount();
            this.aDT = newsRemindMessage.hasChatRemind();
            this.aDU = newsRemindMessage.getNotificationCount();
            this.aDV = newsRemindMessage.hasNotificationRemind();
            if (this.eHi != null) {
                if (i > 0 && this.eHl == 0 && getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001628, getPageContext().getUniqueId()));
                }
                this.eHi.f(1, this.aDQ, this.aDR);
                this.eHi.f(2, this.aDS, this.aDT);
                if (this.eHi.oO(3)) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dl().Ds();
                    if (this.aDV) {
                        aOT();
                        return;
                    }
                }
                this.eHi.f(3, this.aDU, this.aDV);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOT() {
        HashSet hashSet;
        HashMap<Integer, HashSet> DJ = com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DJ();
        if (DJ != null && DJ.size() > 0 && (hashSet = DJ.get(0)) != null && hashSet.size() > 0) {
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
    public void oL(int i) {
        if (i == 1) {
            TiebaStatic.log(new an("c12937").r("obj_type", 1));
        } else if (i == 2) {
            TiebaStatic.log(new an("c12937").r("obj_type", 2));
        } else if (i == 3) {
            TiebaStatic.log(new an("c12937").r("obj_type", 3));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.aJy().aJz();
        MessageManager.getInstance().unRegisterListener(this.eHo);
        if (this.eHi != null) {
            this.eHi.aOW();
            this.eHi.b(this.eHm);
        }
        if (this.dmn != null) {
            this.dmn.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dmn == null) {
            this.dmn = VoiceManager.instance();
        }
        return this.dmn;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dmn != null) {
            this.dmn.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dmn != null) {
            this.dmn.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dmn != null) {
            this.dmn.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dmn != null) {
            this.dmn.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.eHi != null) {
            this.eHi.setPrimary(z);
        }
    }
}
