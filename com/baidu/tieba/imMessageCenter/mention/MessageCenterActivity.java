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
    private NoNetworkView cba;
    private VoiceManager dEn;
    private TbTabLayout dVK;
    private BdBaseViewPager dxg;
    private i eSJ;
    private ImageView eSK;
    private NavigationBar ecS;
    private List<i.a> mFragments;
    private int mSkinType = 3;
    private int eSL = 0;
    private int eSM = 0;
    private int eSN = 0;
    private int bjh = 0;
    private boolean bji = false;
    private int bjj = 0;
    private boolean bjk = false;
    private int bjl = 0;
    private boolean bjm = false;
    private TbTabLayout.b eSO = new TbTabLayout.b() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterActivity.1
        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(TbTabLayout.e eVar) {
            if (eVar.getId() == 1) {
                if (MessageCenterActivity.this.bji) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.GJ().setMsgReplyme(0);
                }
            } else if (eVar.getId() == 3 && MessageCenterActivity.this.bjm) {
                MessageCenterActivity.this.aNx();
            }
            MessageCenterActivity.this.qM(eVar.getId());
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(TbTabLayout.e eVar) {
            if (eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.a(MessageCenterActivity.this, MessageCenterActivity.this.dVK);
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(TbTabLayout.e eVar) {
            if (eVar.getId() == 1) {
                MessageManager.getInstance().runTask(2016322, (Class) null);
                com.baidu.adp.lib.util.l.a(MessageCenterActivity.this, MessageCenterActivity.this.dVK);
            }
            MessageCenterActivity.this.qM(eVar.getId());
        }
    };
    private final CustomMessageListener eSP = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterActivity.5
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
        registerListener(this.eSP);
        z(getIntent().getExtras());
        adjustResizeForSoftInput();
        TiebaStatic.log(new ak("c11941"));
        this.dEn = getVoiceManager();
        this.dEn.onCreate(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        com.baidu.tieba.im.db.e.aIb().aIc();
        if (this.dEn == null) {
            this.dEn = getVoiceManager();
            this.dEn.onCreate(getPageContext());
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
        if (this.dVK != null && this.dVK.getTabCount() > 0 && (dM = this.dVK.dM(this.dVK.getSelectedTabPosition())) != null) {
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
            if (this.ecS != null) {
                this.ecS.onChangeSkinType(getPageContext(), i);
            }
            if (this.cba != null) {
                this.cba.onChangeSkinType(getPageContext(), i);
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
            if (this.eSK != null) {
                aj.c(this.eSK, d.f.icon_tobar_friend_add);
            }
            if (this.dVK != null) {
                this.dVK.setSelectedTabIndicatorColor(aj.getColor(d.C0141d.cp_cont_f));
                this.dVK.setTabTextColors(aj.getColor(d.C0141d.cp_cont_j), aj.getColor(d.C0141d.cp_cont_b));
            }
        }
    }

    private void v(Bundle bundle) {
        setContentView(d.h.message_center_activity);
        w(bundle);
        x(bundle);
        y(bundle);
        this.cba = (NoNetworkView) findViewById(d.g.view_no_network);
        this.cba.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterActivity.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bu(boolean z) {
                MessageCenterActivity.this.ik(z);
            }
        });
    }

    private void w(Bundle bundle) {
        this.dxg = (BdBaseViewPager) findViewById(d.g.message_viewpager);
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
        this.eSJ = new i(getSupportFragmentManager(), this.mFragments);
        this.dxg.setAdapter(this.eSJ);
        this.dxg.setOffscreenPageLimit(this.mFragments.size());
        this.eSJ.notifyDataSetChanged();
    }

    private void x(Bundle bundle) {
        this.dVK = (TbTabLayout) LayoutInflater.from(this).inflate(d.h.message_center_tab_layout, (ViewGroup) null);
        this.dVK.setupWithViewPager(this.dxg);
        int tabCount = this.dVK.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                TbTabLayout.e dM = this.dVK.dM(i);
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
        this.dVK.a(this.eSO);
    }

    private void y(Bundle bundle) {
        this.ecS = (NavigationBar) findViewById(d.g.navigation_bar);
        this.ecS.showBottomLine();
        this.ecS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageCenterActivity.this.finish();
            }
        });
        this.eSK = new ImageView(this);
        this.eSK.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.l.t(this, d.e.ds88), com.baidu.adp.lib.util.l.t(this, d.e.ds88)));
        this.eSK.setScaleType(ImageView.ScaleType.CENTER);
        this.ecS.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eSK, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(MessageCenterActivity.this, 0, false);
                atListActivityConfig.setIsForChat(true);
                MessageCenterActivity.this.sendMessage(new CustomMessage(2002001, atListActivityConfig));
                TiebaStatic.log("c12929");
            }
        });
        if (this.eSK.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eSK.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, com.baidu.adp.lib.util.l.t(this, d.e.ds14), marginLayoutParams.bottomMargin);
            this.eSK.setLayoutParams(marginLayoutParams);
        }
        if (com.baidu.adp.lib.b.d.mA().an("android_message_can_friend_chat") == 1) {
            this.eSK.setVisibility(0);
        } else {
            this.eSK.setVisibility(4);
        }
        if (this.dVK != null) {
            this.ecS.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.dVK, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.dVK.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.dVK.setPadding(this.dVK.getPaddingLeft(), this.dVK.getPaddingTop(), this.dVK.getPaddingRight(), this.dVK.getBottom() + com.baidu.adp.lib.util.l.t(this, d.e.ds1));
        }
    }

    private void z(Bundle bundle) {
        if (this.dVK != null) {
            int i = bundle != null ? bundle.getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1) : -1;
            if (i == -1) {
                if (this.bji) {
                    i = 1;
                } else if (this.bjk) {
                    i = 2;
                } else if (this.bjm) {
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
        if (this.dVK != null && (tabCount = this.dVK.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.e dM = this.dVK.dM(i2);
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
        return this.dVK != null && (selectedTabPosition = this.dVK.getSelectedTabPosition()) >= 0 && selectedTabPosition <= this.dVK.getTabCount() + (-1) && (dM = this.dVK.dM(selectedTabPosition)) != null && dM.getId() == i;
    }

    public void ik(boolean z) {
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
        MessageManager.getInstance().unRegisterListener(this.eSP);
        if (this.dVK != null && this.eSO != null) {
            this.dVK.b(this.eSO);
        }
        if (this.dEn != null) {
            this.dEn.onDestory(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.mFragments != null && this.mFragments.size() > 0 && this.dxg != null) {
            i.a aVar = this.mFragments.get(this.dxg.getCurrentItem());
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
            this.eSL = newsRemindMessage.getMsgAgreeCount();
            this.eSM = newsRemindMessage.getMsgAtCount();
            this.eSN = newsRemindMessage.getMsgReplyCount();
            this.bjh = newsRemindMessage.getMsgCount();
            this.bji = newsRemindMessage.hasMsgRemind();
            this.bjj = newsRemindMessage.getChatCount();
            this.bjk = newsRemindMessage.hasChatRemind();
            this.bjl = newsRemindMessage.getNotificationCount();
            this.bjm = newsRemindMessage.hasNotificationRemind();
            if (qL(1)) {
                if (this.bji) {
                    if (this.eSN > 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.GJ().setMsgReplyme(0);
                        return;
                    }
                    i(1, this.bjh, this.bji);
                } else {
                    i(1, this.bjh, this.bji);
                }
            } else {
                i(1, this.bjh, this.bji);
            }
            i(2, this.bjj, this.bjk);
            if (qL(3)) {
                if (this.bjm) {
                    aNx();
                    return;
                } else {
                    i(3, this.bjl, this.bjm);
                    return;
                }
            }
            i(3, this.bjl, this.bjm);
        }
    }

    private void i(int i, int i2, boolean z) {
        TbTabLayout.e qK = qK(i);
        if (qK != null) {
            if (i == 1) {
                this.bji = z;
            } else if (i == 2) {
                this.bjk = z;
            } else if (i == 3) {
                this.bjm = z;
            }
            qK.r(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNx() {
        HashSet hashSet;
        HashMap<Integer, HashSet> Hh = com.baidu.tbadk.coreExtra.messageCenter.a.GJ().Hh();
        if (Hh != null && Hh.size() > 0 && (hashSet = Hh.get(0)) != null && hashSet.size() > 0) {
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
        if (this.dEn == null) {
            this.dEn = VoiceManager.instance();
        }
        return this.dEn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dEn != null) {
            this.dEn.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.dEn != null) {
            this.dEn.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dEn != null) {
            this.dEn.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dEn != null) {
            this.dEn.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int RO() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> RP() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> RQ() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> RR() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> RS() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> RT() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> RU() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Y(Context context, String str) {
        aw.Du().c(getPageContext(), new String[]{str});
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
