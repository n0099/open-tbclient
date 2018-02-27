package com.baidu.tieba.imMessageCenter.mention;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class MessageCenterActivity extends BaseFragmentActivity implements VoiceManager.c, com.baidu.tbadk.widget.richText.e {
    private NoNetworkView caX;
    private VoiceManager dEk;
    private TbTabLayout dVE;
    private BdBaseViewPager dxd;
    private i eSu;
    private ImageView eSv;
    private NavigationBar ecC;
    private List<i.a> mFragments;
    private int mSkinType = 3;
    private int eSw = 0;
    private int eSx = 0;
    private int eSy = 0;
    private int bje = 0;
    private boolean bjf = false;
    private int bjg = 0;
    private boolean bjh = false;
    private int bji = 0;
    private boolean bjj = false;
    private TbTabLayout.b eSz = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterActivity.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar.getId() == 1) {
                if (MessageCenterActivity.this.bjf) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.GI().setMsgReplyme(0);
                }
            } else if (eVar.getId() == 3 && MessageCenterActivity.this.bjj) {
                MessageCenterActivity.this.aNw();
            }
            MessageCenterActivity.this.qM(eVar.getId());
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.a(MessageCenterActivity.this, MessageCenterActivity.this.dVE);
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.a(MessageCenterActivity.this, MessageCenterActivity.this.dVE);
            }
            MessageCenterActivity.this.qM(eVar.getId());
        }
    };
    private final CustomMessageListener eSA = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterActivity.this.i(customResponsedMessage);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!ay.ba(this)) {
            finish();
            return;
        }
        v(bundle);
        registerListener(this.eSA);
        z(getIntent().getExtras());
        adjustResizeForSoftInput();
        TiebaStatic.log(new ak("c11941"));
        this.dEk = getVoiceManager();
        this.dEk.onCreate(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        com.baidu.tieba.im.db.e.aIa().aIb();
        if (this.dEk == null) {
            this.dEk = getVoiceManager();
            this.dEk.onCreate(getPageContext());
        }
        if (intent != null) {
            z(intent.getExtras());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.e dM;
        int i;
        if (this.dVE != null && this.dVE.getTabCount() > 0 && (dM = this.dVE.dM(this.dVE.getSelectedTabPosition())) != null) {
            try {
                i = dM.getId();
            } catch (NumberFormatException e) {
                i = -1;
            }
            if (i != -1) {
                bundle.putInt("Selected_Tab", i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.ecC != null) {
                this.ecC.onChangeSkinType(getPageContext(), i);
            }
            if (this.caX != null) {
                this.caX.onChangeSkinType(getPageContext(), i);
            }
            if (this.mFragments != null && this.mFragments.size() > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= this.mFragments.size()) {
                        break;
                    }
                    i.a aVar = this.mFragments.get(i3);
                    if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                        ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                    }
                    i2 = i3 + 1;
                }
            }
            if (this.eSv != null) {
                aj.c(this.eSv, d.f.icon_tobar_friend_add);
            }
            if (this.dVE != null) {
                this.dVE.setSelectedTabIndicatorColor(aj.getColor(d.C0141d.cp_cont_f));
                this.dVE.setTabTextColors(aj.getColor(d.C0141d.cp_cont_j), aj.getColor(d.C0141d.cp_cont_b));
            }
        }
    }

    private void v(Bundle bundle) {
        setContentView(d.h.message_center_activity);
        w(bundle);
        x(bundle);
        y(bundle);
        this.caX = (NoNetworkView) findViewById(d.g.view_no_network);
        this.caX.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterActivity.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bu(boolean z) {
                MessageCenterActivity.this.m15if(z);
            }
        });
    }

    private void w(Bundle bundle) {
        this.dxd = (BdBaseViewPager) findViewById(d.g.message_viewpager);
        i.a aVar = new i.a();
        aVar.fragment = new p();
        aVar.title = getResources().getString(d.j.message_center_message_tab);
        i.a aVar2 = new i.a();
        aVar2.fragment = new g();
        aVar2.title = getResources().getString(d.j.message_center_chat_tab);
        i.a aVar3 = new i.a();
        aVar3.fragment = new l();
        aVar3.title = getResources().getString(d.j.message_center_notification_tab);
        this.mFragments = new ArrayList();
        this.mFragments.add(aVar);
        this.mFragments.add(aVar2);
        this.mFragments.add(aVar3);
        this.eSu = new i(getSupportFragmentManager(), this.mFragments);
        this.dxd.setAdapter(this.eSu);
        this.dxd.setOffscreenPageLimit(this.mFragments.size());
        this.eSu.notifyDataSetChanged();
    }

    private void x(Bundle bundle) {
        this.dVE = (TbTabLayout) LayoutInflater.from(this).inflate(d.h.message_center_tab_layout, (ViewGroup) null);
        this.dVE.setupWithViewPager(this.dxd);
        int tabCount = this.dVE.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e dM = this.dVE.dM(i);
                if (dM != null && !TextUtils.isEmpty(dM.getText())) {
                    if (dM.getText().equals(getResources().getString(d.j.message_center_message_tab))) {
                        dM.dO(1);
                    } else if (dM.getText().equals(getResources().getString(d.j.message_center_chat_tab))) {
                        dM.dO(2);
                    } else if (dM.getText().equals(getResources().getString(d.j.message_center_notification_tab))) {
                        dM.dO(3);
                    }
                }
            }
        }
        TbTabLayout.e qK = qK(2);
        if (qK != null) {
            qK.select();
        }
        this.dVE.a(this.eSz);
    }

    private void y(Bundle bundle) {
        this.ecC = (NavigationBar) findViewById(d.g.navigation_bar);
        this.ecC.showBottomLine();
        this.ecC.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageCenterActivity.this.finish();
            }
        });
        this.eSv = new ImageView(this);
        this.eSv.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.t(this, d.e.ds88), com.baidu.adp.lib.util.l.t(this, d.e.ds88)));
        this.eSv.setScaleType(ImageView.ScaleType.CENTER);
        this.ecC.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eSv, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(MessageCenterActivity.this, 0, false);
                atListActivityConfig.setIsForChat(true);
                MessageCenterActivity.this.sendMessage(new CustomMessage(2002001, atListActivityConfig));
                TiebaStatic.log("c12929");
            }
        });
        if (this.eSv.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eSv.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.t(this, d.e.ds14), marginLayoutParams.bottomMargin);
            this.eSv.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.mA().an("android_message_can_friend_chat") == 1) {
            this.eSv.setVisibility(0);
        } else {
            this.eSv.setVisibility(4);
        }
        if (this.dVE != null) {
            this.ecC.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.dVE, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.dVE.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.dVE.setPadding(this.dVE.getPaddingLeft(), this.dVE.getPaddingTop(), this.dVE.getPaddingRight(), this.dVE.getBottom() + com.baidu.adp.lib.util.l.t(this, d.e.ds1));
        }
    }

    private void z(Bundle bundle) {
        if (this.dVE != null) {
            int i = bundle != null ? bundle.getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1) : -1;
            if (i == -1) {
                if (this.bjf) {
                    i = 1;
                } else if (this.bjh) {
                    i = 2;
                } else if (this.bjj) {
                    i = 3;
                }
            }
            if (i == -1 && bundle != null) {
                i = bundle.getInt("Selected_Tab", -1);
            }
            TbTabLayout.e qK = qK(i != -1 ? i : 1);
            if (qK != null) {
                qK.select();
            }
        }
    }

    private TbTabLayout.e qK(int i) {
        int tabCount;
        if (this.dVE != null && (tabCount = this.dVE.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e dM = this.dVE.dM(i2);
                if (dM != null && dM.getId() != -1 && dM.getId() == i) {
                    return dM;
                }
            }
            return null;
        }
        return null;
    }

    private boolean qL(int i) {
        int selectedTabPosition;
        TbTabLayout.e dM;
        return this.dVE != null && (selectedTabPosition = this.dVE.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.dVE.getTabCount() + (-1) && (dM = this.dVE.dM(selectedTabPosition)) != null && dM.getId() == i;
    }

    /* renamed from: if  reason: not valid java name */
    public void m15if(boolean z) {
        if (this.mFragments != null && this.mFragments.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mFragments.size()) {
                    i.a aVar = this.mFragments.get(i2);
                    if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                        ((NoNetworkView.a) aVar.fragment).bu(z);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.eSA);
        if (this.dVE != null && this.eSz != null) {
            this.dVE.b(this.eSz);
        }
        if (this.dEk != null) {
            this.dEk.onDestory(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.mFragments != null && this.mFragments.size() > 0 && this.dxd != null) {
            i.a aVar = this.mFragments.get(this.dxd.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsRemindMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) responsedMessage;
            this.eSw = newsRemindMessage.getMsgAgreeCount();
            this.eSx = newsRemindMessage.getMsgAtCount();
            this.eSy = newsRemindMessage.getMsgReplyCount();
            this.bje = newsRemindMessage.getMsgCount();
            this.bjf = newsRemindMessage.hasMsgRemind();
            this.bjg = newsRemindMessage.getChatCount();
            this.bjh = newsRemindMessage.hasChatRemind();
            this.bji = newsRemindMessage.getNotificationCount();
            this.bjj = newsRemindMessage.hasNotificationRemind();
            if (qL(1)) {
                if (this.bjf) {
                    if (this.eSy > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.GI().setMsgReplyme(0);
                        return;
                    }
                    i(1, this.bje, this.bjf);
                } else {
                    i(1, this.bje, this.bjf);
                }
            } else {
                i(1, this.bje, this.bjf);
            }
            i(2, this.bjg, this.bjh);
            if (qL(3)) {
                if (this.bjj) {
                    aNw();
                    return;
                } else {
                    i(3, this.bji, this.bjj);
                    return;
                }
            }
            i(3, this.bji, this.bjj);
        }
    }

    private void i(int i, int i2, boolean z) {
        TbTabLayout.e qK = qK(i);
        if (qK != null) {
            if (i == 1) {
                this.bjf = z;
            } else if (i == 2) {
                this.bjh = z;
            } else if (i == 3) {
                this.bjj = z;
            }
            qK.r(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNw() {
        HashSet hashSet;
        HashMap<Integer, HashSet> Hg = com.baidu.tbadk.coreExtra.messageCenter.a.GI().Hg();
        if (Hg != null && Hg.size() > 0 && (hashSet = Hg.get(0)) != null && hashSet.size() > 0) {
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
    public void qM(int i) {
        if (i == 1) {
            TiebaStatic.log(new ak("c12937").s("obj_type", 1));
        } else if (i == 2) {
            TiebaStatic.log(new ak("c12937").s("obj_type", 2));
        } else if (i == 3) {
            TiebaStatic.log(new ak("c12937").s("obj_type", 3));
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dEk == null) {
            this.dEk = VoiceManager.instance();
        }
        return this.dEk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dEk != null) {
            this.dEk.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.dEk != null) {
            this.dEk.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dEk != null) {
            this.dEk.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dEk != null) {
            this.dEk.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int RN() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> RO() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> RP() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> RQ() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> RR() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> RS() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> RT() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Y(Context context, String str) {
        aw.Dt().c(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aa(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ab(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void h(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ac(Context context, String str) {
    }
}
