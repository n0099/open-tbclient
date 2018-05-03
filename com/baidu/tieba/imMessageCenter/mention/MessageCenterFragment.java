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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class MessageCenterFragment extends BaseFragment implements VoiceManager.c {
    private VoiceManager cXg;
    private g ene;
    private int enf = 0;
    private int eng = 0;
    private int enh = 0;
    private int auL = 0;
    private boolean auM = false;
    private int auN = 0;
    private boolean auO = false;
    private int auP = 0;
    private boolean auQ = false;
    private TbTabLayout.b eni = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar != null) {
                if (eVar.getId() == 1) {
                    if (MessageCenterFragment.this.auM && MessageCenterFragment.this.enh > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.zx().setMsgReplyme(0);
                    }
                } else if (eVar.getId() == 3) {
                    if (MessageCenterFragment.this.auQ) {
                        MessageCenterFragment.this.aIw();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.a.zx().zE();
                }
                MessageCenterFragment.this.of(eVar.getId());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.ene != null && eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.ene.aIx());
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar != null && MessageCenterFragment.this.ene != null) {
                if (eVar.getId() == 1) {
                    MessageManager.getInstance().runTask(2016322, (Class) null);
                    com.baidu.adp.lib.util.l.b(MessageCenterFragment.this.getContext(), MessageCenterFragment.this.ene.aIx());
                }
                MessageCenterFragment.this.of(eVar.getId());
            }
        }
    };
    private final CustomMessageListener enj = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.g(customResponsedMessage);
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.message_center_activity, viewGroup, false);
        this.ene = new g(this);
        this.ene.a(inflate, bundle);
        this.ene.selectTab(2);
        this.ene.a(this.eni);
        this.enj.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(this.enj);
        a(getActivity().getIntent(), bundle);
        this.cXg = getVoiceManager();
        this.cXg.onCreate(getPageContext());
        TiebaStatic.log(new al("c11941"));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        com.baidu.tieba.im.db.e.aDa().aDb();
        if (this.cXg == null) {
            this.cXg = getVoiceManager();
            this.cXg.onCreate(getPageContext());
        }
        if (intent != null) {
            a(intent, (Bundle) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.ene != null) {
            this.ene.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e aIy;
        if (this.ene != null && (aIy = this.ene.aIy()) != null) {
            bundle.putInt("Selected_Tab", aIy.getId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.ene != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ene != null) {
            this.ene.onChangeSkinType(this.mSkinType);
        }
    }

    public void aIu() {
        getActivity().finish();
    }

    public void aIv() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage(2002001, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1) {
            if (this.auM) {
                i = 1;
            } else if (this.auO) {
                i = 2;
            } else if (this.auQ) {
                i = 3;
            }
        }
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        int i2 = i != -1 ? i : 1;
        if (this.ene != null) {
            this.ene.selectTab(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.enf = newsRemindMessage.getMsgAgreeCount();
            this.eng = newsRemindMessage.getMsgAtCount();
            this.enh = newsRemindMessage.getMsgReplyCount();
            this.auL = newsRemindMessage.getMsgCount();
            this.auM = newsRemindMessage.hasMsgRemind();
            this.auN = newsRemindMessage.getChatCount();
            this.auO = newsRemindMessage.hasChatRemind();
            this.auP = newsRemindMessage.getNotificationCount();
            this.auQ = newsRemindMessage.hasNotificationRemind();
            if (this.ene != null) {
                if (this.ene.oh(1) && this.auM && this.enh > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.zx().setMsgReplyme(0);
                    return;
                }
                this.ene.f(1, this.auL, this.auM);
                this.ene.f(2, this.auN, this.auO);
                if (this.ene.oh(3)) {
                    if (this.auQ) {
                        aIw();
                        return;
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.a.zx().zE();
                }
                this.ene.f(3, this.auP, this.auQ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIw() {
        HashSet hashSet;
        HashMap<Integer, HashSet> zV = com.baidu.tbadk.coreExtra.messageCenter.a.zx().zV();
        if (zV != null && zV.size() > 0 && (hashSet = zV.get(0)) != null && hashSet.size() > 0) {
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
    public void of(int i) {
        if (i == 1) {
            TiebaStatic.log(new al("c12937").r("obj_type", 1));
        } else if (i == 2) {
            TiebaStatic.log(new al("c12937").r("obj_type", 2));
        } else if (i == 3) {
            TiebaStatic.log(new al("c12937").r("obj_type", 3));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.aDa().aDb();
        MessageManager.getInstance().unRegisterListener(this.enj);
        if (this.ene != null) {
            this.ene.aIz();
            this.ene.b(this.eni);
        }
        if (this.cXg != null) {
            this.cXg.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cXg == null) {
            this.cXg = VoiceManager.instance();
        }
        return this.cXg;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.cXg != null) {
            this.cXg.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.cXg != null) {
            this.cXg.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cXg != null) {
            this.cXg.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.cXg != null) {
            this.cXg.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.ene != null) {
            this.ene.setPrimary(z);
        }
    }
}
