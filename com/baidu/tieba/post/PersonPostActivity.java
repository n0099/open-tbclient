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
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.e;
import com.baidu.tieba.personPolymeric.PersonPolymericActivityStatic;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageHttpResponseMessage;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageSocketResponsedMessage;
/* loaded from: classes3.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener, VoiceManager.c, b, d {
    private NoNetworkView bKI;
    protected VoiceManager dBD;
    private int[] ePX;
    private String ePZ;
    private String gpB;
    private RelativeLayout gzi;
    private ImageView gzj;
    private ImageView gzk;
    private PersonPostAdapter gzl;
    private NavigationBar mNavigationBar;
    private int mSex;
    private int mSkinType;
    private FragmentTabHost mTabHost;
    private String mUid;
    private int bVN = -1;
    int ePY = 0;
    private boolean isHost = false;
    private View aJu = null;
    private final CustomMessageListener gzm = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.post.PersonPostActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.post.PersonPostActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    ay.Db().c(PersonPostActivity.this.getPageContext(), new String[]{str});
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bnW();
        if (!com.baidu.adp.lib.util.j.kV()) {
            showToast(e.j.neterror);
        }
        setContentView(e.h.person_post_activity);
        this.dBD = getVoiceManager();
        if (this.dBD != null) {
            this.dBD.onCreate(getPageContext());
        }
        this.gpB = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
        this.mUid = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.ePZ = getPageContext().getString(e.j.me);
            this.isHost = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.ePZ = getPageContext().getString(e.j.he);
                    break;
                case 2:
                    this.ePZ = getPageContext().getString(e.j.she);
                    break;
                default:
                    this.ePZ = getPageContext().getString(e.j.ta);
                    break;
            }
        }
        TbadkCoreApplication.isMyLive = false;
        if (this.mUid == null) {
            finish();
        } else {
            v(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gzl != null) {
            int count = this.gzl.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.gzl.getItem(i3);
                if (item instanceof PersonThreadFragment) {
                    ((PersonThreadFragment) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void v(Bundle bundle) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(e.j.text_post));
        this.aJu = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.aJu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonPostActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonPostActivity.this.finish();
            }
        });
        this.gzi = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.person_post_naviagtion_bar_recycle_bin, (View.OnClickListener) null);
        this.gzi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonPostActivity.2
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.post.PersonPostActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonPostActivity.this.mA(false);
                ay.Db().c(PersonPostActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/pmc"});
            }
        });
        this.gzj = (ImageView) this.gzi.findViewById(e.g.iv_recycle_bin);
        this.gzk = (ImageView) this.gzi.findViewById(e.g.iv_recycle_bin_red_tip);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), false)) {
            this.gzk.setVisibility(0);
        } else {
            this.gzk.setVisibility(8);
        }
        this.bKI = (NoNetworkView) findViewById(e.g.person_post_no_network_view);
        this.ePX = new int[]{0, 1};
        this.gzl = new PersonPostAdapter(this);
        this.mTabHost = (FragmentTabHost) findViewById(e.g.tab_host);
        this.mTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setOnPageChangeListener(this);
        this.mTabHost.setTabWidgetViewHeight((int) getResources().getDimension(e.C0200e.ds100));
        this.mTabHost.getFragmentTabWidget().setDviderRectWidth(com.baidu.adp.lib.util.l.h(getActivity(), e.C0200e.ds64));
        initTabSpec();
        ((RelativeLayout.LayoutParams) this.mTabHost.getTabWrapper().getLayoutParams()).setMargins(0, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(getActivity(), e.C0200e.ds88), 0, 0);
        if (bundle != null) {
            this.bVN = bundle.getInt("CurrTabIndex");
        } else {
            this.bVN = 0;
        }
        this.mTabHost.setCurrentTab(this.bVN);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.avZ = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.baa = e.d.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(e.C0200e.fontsize32));
            bVar.avY = fragmentTabIndicator;
            this.mTabHost.a(bVar);
        }
    }

    private void initTabSpec() {
        if (this.gzl != null) {
            int count = this.gzl.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.gzl.getItem(i);
                int pV = this.gzl.pV(i);
                if (item != null) {
                    if (pV == 0) {
                        a(item, 0, getPageContext().getString(e.j.person_post_thread_new));
                    } else if (pV == 1) {
                        a(item, 1, getPageContext().getString(e.j.reply));
                    }
                }
            }
            this.mTabHost.Bt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MessageManager.getInstance().registerListener(this.gzm);
        this.dBD = getVoiceManager();
        if (this.dBD != null) {
            this.dBD.onResume(getPageContext());
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
        MessageManager.getInstance().unRegisterListener(this.gzm);
        this.dBD = getVoiceManager();
        if (this.dBD != null) {
            this.dBD.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.dBD = getVoiceManager();
        if (this.dBD != null) {
            this.dBD.onDestory(getPageContext());
        }
        try {
            PersonPolymericActivityStatic.bnW();
            super.onDestroy();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.dBD = getVoiceManager();
        if (this.dBD != null) {
            this.dBD.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.dBD = getVoiceManager();
        if (this.dBD != null) {
            this.dBD.onStop(getPageContext());
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public String aRJ() {
        return this.ePZ;
    }

    public String getPortraitUrl() {
        return this.gpB;
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bVN);
        this.dBD = getVoiceManager();
        if (this.dBD != null) {
            this.dBD.onSaveInstanceState(getPageContext().getPageActivity());
        }
        super.onSaveInstanceState(bundle);
    }

    public String bqz() {
        if (this.isHost) {
            return getPageContext().getString(e.j.person_post_lv_empty_host);
        }
        return String.format(getPageContext().getString(e.j.person_post_lv_empty_guest), aRJ());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.bVN) {
            this.bVN = i;
            if (this.ePX[i] == 0) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_thread" : "pp_his_thread", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            } else if (this.ePX[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_reply" : "pp_his_reply", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bKI.onChangeSkinType(getPageContext(), i);
        this.mTabHost.setNeedShowThemeStyle(false);
        this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.mTabHost.onChangeSkinType(i);
        al.a(this.gzj, e.f.icon_recycle_bin_w, e.f.icon_recycle_bin);
        this.gzk.setImageDrawable(al.x(i, e.f.person_center_red_tip_shape));
        if (this.gzl != null) {
            int count = this.gzl.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.gzl.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.gzl != null) {
            PersonThreadFragment bqA = this.gzl.bqA();
            h bqD = bqA != null ? bqA.bqD() : null;
            if (bqD == null || bqD.bqK() == null) {
                return null;
            }
            return bqD.bqK().getPreLoadHandle();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dBD == null) {
            this.dBD = VoiceManager.instance();
        }
        return this.dBD;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    private void bnW() {
        com.baidu.tieba.tbadkCore.a.a.a(303002, UserPostPageSocketResponsedMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.USER_POST_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.aT("c/u/feed/userpost", 303002));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(UserPostPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.post.d
    public void bqy() {
        if (this.gzl != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gzl.getCount()) {
                    if (this.gzl.getItem(i2) instanceof c) {
                        ((c) this.gzl.getItem(i2)).bqx();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.post.b
    public void mA(boolean z) {
        if (this.gzk != null) {
            if (z && this.gzk.getVisibility() == 8) {
                this.gzk.setVisibility(0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), true);
            } else if (!z && this.gzk.getVisibility() == 0) {
                this.gzk.setVisibility(8);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), false);
            }
        }
    }
}
