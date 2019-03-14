package com.baidu.tieba.post;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.p;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.PersonPolymericActivityStatic;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageHttpResponseMessage;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageSocketResponsedMessage;
/* loaded from: classes6.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener, VoiceManager.c, b, d {
    private NoNetworkView dbm;
    protected VoiceManager eYR;
    private int[] gqx;
    private String gqz;
    private String hQm;
    private RelativeLayout ibt;
    private ImageView ibu;
    private ImageView ibv;
    private PersonPostAdapter ibw;
    private NavigationBar mNavigationBar;
    private int mSex;
    private int mSkinType;
    private FragmentTabHost mTabHost;
    private String mUid;
    private int dps = -1;
    int gqy = 0;
    private boolean isHost = false;
    private View bVZ = null;
    private final CustomMessageListener gBA = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.post.PersonPostActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.post.PersonPostActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    ba.adD().c(PersonPostActivity.this.getPageContext(), new String[]{str});
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bRG();
        if (!com.baidu.adp.lib.util.j.kY()) {
            showToast(d.j.neterror);
        }
        setContentView(d.h.person_post_activity);
        this.eYR = getVoiceManager();
        if (this.eYR != null) {
            this.eYR.onCreate(getPageContext());
        }
        this.hQm = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
        this.mUid = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.gqz = getPageContext().getString(d.j.me);
            this.isHost = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.gqz = getPageContext().getString(d.j.he);
                    break;
                case 2:
                    this.gqz = getPageContext().getString(d.j.she);
                    break;
                default:
                    this.gqz = getPageContext().getString(d.j.ta);
                    break;
            }
        }
        TbadkCoreApplication.isMyLive = false;
        if (this.mUid == null) {
            finish();
        } else {
            W(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.ibw != null) {
            int count = this.ibw.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.ibw.getItem(i3);
                if (item instanceof PersonThreadFragment) {
                    ((PersonThreadFragment) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void W(Bundle bundle) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.text_post));
        this.bVZ = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.bVZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonPostActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonPostActivity.this.finish();
            }
        });
        this.ibt = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.person_post_naviagtion_bar_recycle_bin, (View.OnClickListener) null);
        this.ibt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonPostActivity.2
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.post.PersonPostActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonPostActivity.this.pf(false);
                ba.adD().c(PersonPostActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/pmc"});
            }
        });
        this.ibu = (ImageView) this.ibt.findViewById(d.g.iv_recycle_bin);
        this.ibv = (ImageView) this.ibt.findViewById(d.g.iv_recycle_bin_red_tip);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), false)) {
            this.ibv.setVisibility(0);
        } else {
            this.ibv.setVisibility(8);
        }
        this.dbm = (NoNetworkView) findViewById(d.g.person_post_no_network_view);
        this.gqx = new int[]{0, 1};
        this.ibw = new PersonPostAdapter(this);
        this.mTabHost = (FragmentTabHost) findViewById(d.g.tab_host);
        this.mTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setOnPageChangeListener(this);
        this.mTabHost.setTabWidgetViewHeight((int) getResources().getDimension(d.e.ds100));
        this.mTabHost.getFragmentTabWidget().setDviderRectWidth(com.baidu.adp.lib.util.l.h(getActivity(), d.e.ds64));
        initTabSpec();
        ((RelativeLayout.LayoutParams) this.mTabHost.getTabWrapper().getLayoutParams()).setMargins(0, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(getActivity(), d.e.ds88), 0, 0);
        if (bundle != null) {
            this.dps = bundle.getInt("CurrTabIndex");
        } else {
            this.dps = 0;
        }
        this.mTabHost.setCurrentTab(this.dps);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.bHW = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.cnR = d.C0277d.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(d.e.fontsize32));
            bVar.bHV = fragmentTabIndicator;
            this.mTabHost.a(bVar);
        }
    }

    private void initTabSpec() {
        if (this.ibw != null) {
            int count = this.ibw.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.ibw.getItem(i);
                int un = this.ibw.un(i);
                if (item != null) {
                    if (un == 0) {
                        a(item, 0, getPageContext().getString(d.j.person_post_thread_new));
                    } else if (un == 1) {
                        a(item, 1, getPageContext().getString(d.j.reply));
                    }
                }
            }
            this.mTabHost.abU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MessageManager.getInstance().registerListener(this.gBA);
        this.eYR = getVoiceManager();
        if (this.eYR != null) {
            this.eYR.onResume(getPageContext());
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
        MessageManager.getInstance().unRegisterListener(this.gBA);
        this.eYR = getVoiceManager();
        if (this.eYR != null) {
            this.eYR.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.eYR = getVoiceManager();
        if (this.eYR != null) {
            this.eYR.onDestory(getPageContext());
        }
        try {
            PersonPolymericActivityStatic.bRG();
            super.onDestroy();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.eYR = getVoiceManager();
        if (this.eYR != null) {
            this.eYR.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.eYR = getVoiceManager();
        if (this.eYR != null) {
            this.eYR.onStop(getPageContext());
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public String bvt() {
        return this.gqz;
    }

    public String getPortraitUrl() {
        return this.hQm;
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.dps);
        this.eYR = getVoiceManager();
        if (this.eYR != null) {
            this.eYR.onSaveInstanceState(getPageContext().getPageActivity());
        }
        super.onSaveInstanceState(bundle);
    }

    public String bUB() {
        if (this.isHost) {
            return getPageContext().getString(d.j.person_post_lv_empty_host);
        }
        return String.format(getPageContext().getString(d.j.person_post_lv_empty_guest), bvt());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.dps) {
            this.dps = i;
            if (this.gqx[i] == 0) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.gqx[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dbm.onChangeSkinType(getPageContext(), i);
        this.mTabHost.setNeedShowThemeStyle(false);
        this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.mTabHost.onChangeSkinType(i);
        if (this.mTabHost.getFragmentTabWidget() != null) {
            al.l(this.mTabHost.getFragmentTabWidget(), d.C0277d.cp_bg_line_d);
        }
        al.a(this.ibu, d.f.icon_recycle_bin_w, d.f.icon_recycle_bin);
        this.ibv.setImageDrawable(al.T(i, d.f.person_center_red_tip_shape));
        if (this.ibw != null) {
            int count = this.ibw.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.ibw.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public p onGetPreLoadListView() {
        if (this.ibw != null) {
            PersonThreadFragment bUC = this.ibw.bUC();
            h bUF = bUC != null ? bUC.bUF() : null;
            if (bUF == null || bUF.bUM() == null) {
                return null;
            }
            return bUF.bUM().getPreLoadHandle();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.eYR == null) {
            this.eYR = VoiceManager.instance();
        }
        return this.eYR;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    private void bRG() {
        com.baidu.tieba.tbadkCore.a.a.a(303002, UserPostPageSocketResponsedMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.USER_POST_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.br("c/u/feed/userpost", 303002));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(UserPostPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.post.d
    public void bUA() {
        if (this.ibw != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ibw.getCount()) {
                    if (this.ibw.getItem(i2) instanceof c) {
                        ((c) this.ibw.getItem(i2)).bUz();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.post.b
    public void pf(boolean z) {
        if (this.ibv != null) {
            if (z && this.ibv.getVisibility() == 8) {
                this.ibv.setVisibility(0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), true);
            } else if (!z && this.ibv.getVisibility() == 0) {
                this.ibv.setVisibility(8);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), false);
            }
        }
    }
}
