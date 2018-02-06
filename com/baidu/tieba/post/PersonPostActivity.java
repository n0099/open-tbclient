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
    private FragmentTabHost bWZ;
    private NoNetworkView cbj;
    protected VoiceManager dEw;
    private int[] eKV;
    private String eKX;
    private String gnP;
    private RelativeLayout gxe;
    private ImageView gxf;
    private ImageView gxg;
    private f gxh;
    private NavigationBar mNavigationBar;
    private int mSex;
    private int mSkinType;
    private String mUid;
    private int clm = -1;
    int eKW = 0;
    private boolean isHost = false;
    private View bgK = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bjQ();
        if (!com.baidu.adp.lib.util.j.oJ()) {
            showToast(d.j.neterror);
        }
        setContentView(d.h.person_post_activity);
        this.dEw = getVoiceManager();
        if (this.dEw != null) {
            this.dEw.onCreate(getPageContext());
        }
        this.gnP = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
        this.mUid = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.eKX = getPageContext().getString(d.j.me);
            this.isHost = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.eKX = getPageContext().getString(d.j.he);
                    break;
                case 2:
                    this.eKX = getPageContext().getString(d.j.she);
                    break;
                default:
                    this.eKX = getPageContext().getString(d.j.ta);
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
        if (this.gxh != null) {
            int count = this.gxh.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.gxh.getItem(i3);
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
        this.bgK = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.bgK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonPostActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonPostActivity.this.finish();
            }
        });
        this.gxe = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.person_post_naviagtion_bar_recycle_bin, (View.OnClickListener) null);
        this.gxe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonPostActivity.2
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.post.PersonPostActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonPostActivity.this.lR(false);
                aw.Du().c(PersonPostActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/pmc"});
            }
        });
        this.gxf = (ImageView) this.gxe.findViewById(d.g.iv_recycle_bin);
        this.gxg = (ImageView) this.gxe.findViewById(d.g.iv_recycle_bin_red_tip);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), false)) {
            this.gxg.setVisibility(0);
        } else {
            this.gxg.setVisibility(8);
        }
        this.cbj = (NoNetworkView) findViewById(d.g.person_post_no_network_view);
        this.eKV = new int[]{0, 1};
        this.gxh = new f(this);
        this.bWZ = (FragmentTabHost) findViewById(d.g.tab_host);
        this.bWZ.setup(getSupportFragmentManager());
        this.bWZ.setOnPageChangeListener(this);
        this.bWZ.setTabWidgetViewHeight((int) getResources().getDimension(d.e.ds100));
        this.bWZ.getFragmentTabWidget().setDviderRectWidth(com.baidu.adp.lib.util.l.t(getActivity(), d.e.ds64));
        VR();
        ((RelativeLayout.LayoutParams) this.bWZ.getTabWrapper().getLayoutParams()).setMargins(0, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.t(getActivity(), d.e.ds88), 0, 0);
        if (bundle != null) {
            this.clm = bundle.getInt("CurrTabIndex");
        } else {
            this.clm = 0;
        }
        this.bWZ.setCurrentTab(this.clm);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            cVar.aUz = fragment;
            cVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.bxS = d.C0140d.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(d.e.fontsize32));
            cVar.aUy = fragmentTabIndicator;
            this.bWZ.a(cVar);
        }
    }

    private void VR() {
        if (this.gxh != null) {
            int count = this.gxh.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.gxh.getItem(i);
                int qx = this.gxh.qx(i);
                if (item != null) {
                    if (qx == 0) {
                        a(item, 0, getPageContext().getString(d.j.person_post_thread_new));
                    } else if (qx == 1) {
                        a(item, 1, getPageContext().getString(d.j.reply));
                    }
                }
            }
            this.bWZ.BO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dEw = getVoiceManager();
        if (this.dEw != null) {
            this.dEw.onResume(getPageContext());
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
        this.dEw = getVoiceManager();
        if (this.dEw != null) {
            this.dEw.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.dEw = getVoiceManager();
        if (this.dEw != null) {
            this.dEw.onDestory(getPageContext());
        }
        try {
            PersonPolymericActivityStatic.bjQ();
            super.onDestroy();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.dEw = getVoiceManager();
        if (this.dEw != null) {
            this.dEw.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.dEw = getVoiceManager();
        if (this.dEw != null) {
            this.dEw.onStop(getPageContext());
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public String aLp() {
        return this.eKX;
    }

    public String getPortraitUrl() {
        return this.gnP;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.clm);
        this.dEw = getVoiceManager();
        if (this.dEw != null) {
            this.dEw.onSaveInstanceState(getPageContext().getPageActivity());
        }
        super.onSaveInstanceState(bundle);
    }

    public String bmk() {
        if (this.isHost) {
            return getPageContext().getString(d.j.person_post_lv_empty_host);
        }
        return String.format(getPageContext().getString(d.j.person_post_lv_empty_guest), aLp());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.clm) {
            this.clm = i;
            if (this.eKV[i] == 0) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.eKV[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cbj.onChangeSkinType(getPageContext(), i);
        this.bWZ.setNeedShowThemeStyle(false);
        this.bWZ.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.bWZ.onChangeSkinType(i);
        aj.a(this.gxf, d.f.icon_recycle_bin_w, d.f.icon_recycle_bin);
        this.gxg.setImageDrawable(aj.au(i, d.f.person_center_red_tip_shape));
        if (this.gxh != null) {
            int count = this.gxh.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.gxh.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        if (this.gxh != null) {
            j bml = this.gxh.bml();
            k bmo = bml != null ? bml.bmo() : null;
            if (bmo == null || bmo.bmv() == null) {
                return null;
            }
            return bmo.bmv().getPreLoadHandle();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dEw == null) {
            this.dEw = VoiceManager.instance();
        }
        return this.dEw;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    private void bjQ() {
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
    public void bmj() {
        if (this.gxh != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gxh.getCount()) {
                    if (this.gxh.getItem(i2) instanceof c) {
                        ((c) this.gxh.getItem(i2)).bmi();
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
        if (this.gxg != null) {
            if (z && this.gxg.getVisibility() == 8) {
                this.gxg.setVisibility(0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), true);
            } else if (!z && this.gxg.getVisibility() == 0) {
                this.gxg.setVisibility(8);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), false);
            }
        }
    }
}
