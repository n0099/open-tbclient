package com.baidu.tieba.post;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.PersonPolymericActivityStatic;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageHttpResponseMessage;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageSocketResponsedMessage;
/* loaded from: classes3.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener, VoiceManager.c, b, d {
    private FragmentTabHost bWN;
    private NoNetworkView caX;
    protected VoiceManager dEk;
    private int[] eKJ;
    private String eKL;
    private String gnE;
    private RelativeLayout gwT;
    private ImageView gwU;
    private ImageView gwV;
    private f gwW;
    private NavigationBar mNavigationBar;
    private int mSex;
    private int mSkinType;
    private String mUid;
    private int cla = -1;
    int eKK = 0;
    private boolean isHost = false;
    private View bgy = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bjP();
        if (!com.baidu.adp.lib.util.j.oJ()) {
            showToast(d.j.neterror);
        }
        setContentView(d.h.person_post_activity);
        this.dEk = getVoiceManager();
        if (this.dEk != null) {
            this.dEk.onCreate(getPageContext());
        }
        this.gnE = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
        this.mUid = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.eKL = getPageContext().getString(d.j.me);
            this.isHost = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.eKL = getPageContext().getString(d.j.he);
                    break;
                case 2:
                    this.eKL = getPageContext().getString(d.j.she);
                    break;
                default:
                    this.eKL = getPageContext().getString(d.j.ta);
                    break;
            }
        }
        TbadkCoreApplication.isMyLive = false;
        if (this.mUid == null) {
            finish();
        } else {
            t(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gwW != null) {
            int count = this.gwW.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.gwW.getItem(i3);
                if (item instanceof j) {
                    ((j) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void t(Bundle bundle) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.text_post));
        this.bgy = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.bgy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonPostActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonPostActivity.this.finish();
            }
        });
        this.gwT = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.person_post_naviagtion_bar_recycle_bin, (View.OnClickListener) null);
        this.gwT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonPostActivity.2
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.post.PersonPostActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonPostActivity.this.lR(false);
                aw.Dt().c(PersonPostActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/pmc"});
            }
        });
        this.gwU = (ImageView) this.gwT.findViewById(d.g.iv_recycle_bin);
        this.gwV = (ImageView) this.gwT.findViewById(d.g.iv_recycle_bin_red_tip);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), false)) {
            this.gwV.setVisibility(0);
        } else {
            this.gwV.setVisibility(8);
        }
        this.caX = (NoNetworkView) findViewById(d.g.person_post_no_network_view);
        this.eKJ = new int[]{0, 1};
        this.gwW = new f(this);
        this.bWN = (FragmentTabHost) findViewById(d.g.tab_host);
        this.bWN.setup(getSupportFragmentManager());
        this.bWN.setOnPageChangeListener(this);
        this.bWN.setTabWidgetViewHeight((int) getResources().getDimension(d.e.ds100));
        this.bWN.getFragmentTabWidget().setDviderRectWidth(com.baidu.adp.lib.util.l.t(getActivity(), d.e.ds64));
        VQ();
        ((RelativeLayout.LayoutParams) this.bWN.getTabWrapper().getLayoutParams()).setMargins(0, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.t(getActivity(), d.e.ds88), 0, 0);
        if (bundle != null) {
            this.cla = bundle.getInt("CurrTabIndex");
        } else {
            this.cla = 0;
        }
        this.bWN.setCurrentTab(this.cla);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            cVar.aUn = fragment;
            cVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.bxF = d.C0141d.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(d.e.fontsize32));
            cVar.aUm = fragmentTabIndicator;
            this.bWN.a(cVar);
        }
    }

    private void VQ() {
        if (this.gwW != null) {
            int count = this.gwW.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.gwW.getItem(i);
                int qx = this.gwW.qx(i);
                if (item != null) {
                    if (qx == 0) {
                        a(item, 0, getPageContext().getString(d.j.person_post_thread_new));
                    } else if (qx == 1) {
                        a(item, 1, getPageContext().getString(d.j.reply));
                    }
                }
            }
            this.bWN.BN();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dEk = getVoiceManager();
        if (this.dEk != null) {
            this.dEk.onResume(getPageContext());
        }
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.dEk = getVoiceManager();
        if (this.dEk != null) {
            this.dEk.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.dEk = getVoiceManager();
        if (this.dEk != null) {
            this.dEk.onDestory(getPageContext());
        }
        try {
            PersonPolymericActivityStatic.bjP();
            super.onDestroy();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.dEk = getVoiceManager();
        if (this.dEk != null) {
            this.dEk.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.dEk = getVoiceManager();
        if (this.dEk != null) {
            this.dEk.onStop(getPageContext());
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public String aLo() {
        return this.eKL;
    }

    public String getPortraitUrl() {
        return this.gnE;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.cla);
        this.dEk = getVoiceManager();
        if (this.dEk != null) {
            this.dEk.onSaveInstanceState(getPageContext().getPageActivity());
        }
        super.onSaveInstanceState(bundle);
    }

    public String bmj() {
        if (this.isHost) {
            return getPageContext().getString(d.j.person_post_lv_empty_host);
        }
        return String.format(getPageContext().getString(d.j.person_post_lv_empty_guest), aLo());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.cla) {
            this.cla = i;
            if (this.eKJ[i] == 0) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.eKJ[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.caX.onChangeSkinType(getPageContext(), i);
        this.bWN.setNeedShowThemeStyle(false);
        this.bWN.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.bWN.onChangeSkinType(i);
        aj.a(this.gwU, d.f.icon_recycle_bin_w, d.f.icon_recycle_bin);
        this.gwV.setImageDrawable(aj.au(i, d.f.person_center_red_tip_shape));
        if (this.gwW != null) {
            int count = this.gwW.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.gwW.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        if (this.gwW != null) {
            j bmk = this.gwW.bmk();
            k bmn = bmk != null ? bmk.bmn() : null;
            if (bmn == null || bmn.bmu() == null) {
                return null;
            }
            return bmn.bmu().getPreLoadHandle();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dEk == null) {
            this.dEk = VoiceManager.instance();
        }
        return this.dEk;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    private void bjP() {
        com.baidu.tieba.tbadkCore.a.a.a(303002, UserPostPageSocketResponsedMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.USER_POST_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.aJ("c/u/feed/userpost", 303002));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(UserPostPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.post.d
    public void bmi() {
        if (this.gwW != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gwW.getCount()) {
                    if (this.gwW.getItem(i2) instanceof c) {
                        ((c) this.gwW.getItem(i2)).bmh();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.post.b
    public void lR(boolean z) {
        if (this.gwV != null) {
            if (z && this.gwV.getVisibility() == 8) {
                this.gwV.setVisibility(0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), true);
            } else if (!z && this.gwV.getVisibility() == 0) {
                this.gwV.setVisibility(8);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), false);
            }
        }
    }
}
