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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.f;
import com.baidu.tieba.personPolymeric.PersonPolymericActivityStatic;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageHttpResponseMessage;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageSocketResponsedMessage;
/* loaded from: classes3.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener, VoiceManager.c, b, d {
    private NoNetworkView bvB;
    protected VoiceManager dmn;
    private int[] ezE;
    private String ezG;
    private String fZj;
    private RelativeLayout giN;
    private ImageView giO;
    private ImageView giP;
    private PersonPostAdapter giQ;
    private NavigationBar mNavigationBar;
    private int mSex;
    private int mSkinType;
    private FragmentTabHost mTabHost;
    private String mUid;
    private int bGI = -1;
    int ezF = 0;
    private boolean isHost = false;
    private View aAW = null;
    private final CustomMessageListener giR = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.post.PersonPostActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.post.PersonPostActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    az.zI().c(PersonPostActivity.this.getPageContext(), new String[]{str});
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        biP();
        if (!com.baidu.adp.lib.util.j.jE()) {
            showToast(f.j.neterror);
        }
        setContentView(f.h.person_post_activity);
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onCreate(getPageContext());
        }
        this.fZj = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
        this.mUid = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.ezG = getPageContext().getString(f.j.me);
            this.isHost = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.ezG = getPageContext().getString(f.j.he);
                    break;
                case 2:
                    this.ezG = getPageContext().getString(f.j.she);
                    break;
                default:
                    this.ezG = getPageContext().getString(f.j.ta);
                    break;
            }
        }
        TbadkCoreApplication.isMyLive = false;
        if (this.mUid == null) {
            finish();
        } else {
            r(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.giQ != null) {
            int count = this.giQ.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.giQ.getItem(i3);
                if (item instanceof PersonThreadFragment) {
                    ((PersonThreadFragment) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void r(Bundle bundle) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.mNavigationBar = (NavigationBar) findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(f.j.text_post));
        this.aAW = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.aAW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonPostActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonPostActivity.this.finish();
            }
        });
        this.giN = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.person_post_naviagtion_bar_recycle_bin, (View.OnClickListener) null);
        this.giN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonPostActivity.2
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.post.PersonPostActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonPostActivity.this.ly(false);
                az.zI().c(PersonPostActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/pmc"});
            }
        });
        this.giO = (ImageView) this.giN.findViewById(f.g.iv_recycle_bin);
        this.giP = (ImageView) this.giN.findViewById(f.g.iv_recycle_bin_red_tip);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), false)) {
            this.giP.setVisibility(0);
        } else {
            this.giP.setVisibility(8);
        }
        this.bvB = (NoNetworkView) findViewById(f.g.person_post_no_network_view);
        this.ezE = new int[]{0, 1};
        this.giQ = new PersonPostAdapter(this);
        this.mTabHost = (FragmentTabHost) findViewById(f.g.tab_host);
        this.mTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setOnPageChangeListener(this);
        this.mTabHost.setTabWidgetViewHeight((int) getResources().getDimension(f.e.ds100));
        this.mTabHost.getFragmentTabWidget().setDviderRectWidth(com.baidu.adp.lib.util.l.f(getActivity(), f.e.ds64));
        initTabSpec();
        ((RelativeLayout.LayoutParams) this.mTabHost.getTabWrapper().getLayoutParams()).setMargins(0, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(getActivity(), f.e.ds88), 0, 0);
        if (bundle != null) {
            this.bGI = bundle.getInt("CurrTabIndex");
        } else {
            this.bGI = 0;
        }
        this.mTabHost.setCurrentTab(this.bGI);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.anP = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.aRw = f.d.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(f.e.fontsize32));
            bVar.anO = fragmentTabIndicator;
            this.mTabHost.a(bVar);
        }
    }

    private void initTabSpec() {
        if (this.giQ != null) {
            int count = this.giQ.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.giQ.getItem(i);
                int oA = this.giQ.oA(i);
                if (item != null) {
                    if (oA == 0) {
                        a(item, 0, getPageContext().getString(f.j.person_post_thread_new));
                    } else if (oA == 1) {
                        a(item, 1, getPageContext().getString(f.j.reply));
                    }
                }
            }
            this.mTabHost.xX();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MessageManager.getInstance().registerListener(this.giR);
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onResume(getPageContext());
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
        MessageManager.getInstance().unRegisterListener(this.giR);
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onDestory(getPageContext());
        }
        try {
            PersonPolymericActivityStatic.biP();
            super.onDestroy();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onStop(getPageContext());
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public String aMJ() {
        return this.ezG;
    }

    public String getPortraitUrl() {
        return this.fZj;
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bGI);
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onSaveInstanceState(getPageContext().getPageActivity());
        }
        super.onSaveInstanceState(bundle);
    }

    public String bli() {
        if (this.isHost) {
            return getPageContext().getString(f.j.person_post_lv_empty_host);
        }
        return String.format(getPageContext().getString(f.j.person_post_lv_empty_guest), aMJ());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.bGI) {
            this.bGI = i;
            if (this.ezE[i] == 0) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.ezE[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bvB.onChangeSkinType(getPageContext(), i);
        this.mTabHost.setNeedShowThemeStyle(false);
        this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.mTabHost.onChangeSkinType(i);
        am.a(this.giO, f.C0146f.icon_recycle_bin_w, f.C0146f.icon_recycle_bin);
        this.giP.setImageDrawable(am.v(i, f.C0146f.person_center_red_tip_shape));
        if (this.giQ != null) {
            int count = this.giQ.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.giQ.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.giQ != null) {
            PersonThreadFragment blj = this.giQ.blj();
            h blm = blj != null ? blj.blm() : null;
            if (blm == null || blm.blt() == null) {
                return null;
            }
            return blm.blt().getPreLoadHandle();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dmn == null) {
            this.dmn = VoiceManager.instance();
        }
        return this.dmn;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    private void biP() {
        com.baidu.tieba.tbadkCore.a.a.a(303002, UserPostPageSocketResponsedMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.USER_POST_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.aK("c/u/feed/userpost", 303002));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(UserPostPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.post.d
    public void blh() {
        if (this.giQ != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.giQ.getCount()) {
                    if (this.giQ.getItem(i2) instanceof c) {
                        ((c) this.giQ.getItem(i2)).blg();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.post.b
    public void ly(boolean z) {
        if (this.giP != null) {
            if (z && this.giP.getVisibility() == 8) {
                this.giP.setVisibility(0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), true);
            } else if (!z && this.giP.getVisibility() == 0) {
                this.giP.setVisibility(8);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), false);
            }
        }
    }
}
