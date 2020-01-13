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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.personExtra.PersonExtraStatic;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageHttpResponseMessage;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageSocketResponsedMessage;
/* loaded from: classes9.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener, VoiceManager.c, b, d {
    private NoNetworkView ehd;
    protected VoiceManager gmi;
    private int[] hFm;
    private String hFo;
    private String jlQ;
    private RelativeLayout jyR;
    private ImageView jyS;
    private ImageView jyT;
    private PersonPostAdapter jyU;
    private NavigationBar mNavigationBar;
    private int mSex;
    private int mSkinType;
    private FragmentTabHost mTabHost;
    private String mUid;
    private int ezf = -1;
    int hFn = 0;
    private boolean isHost = false;
    private View mBack = null;
    private final CustomMessageListener hQr = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.post.PersonPostActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.post.PersonPostActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    ba.aEt().b(PersonPostActivity.this.getPageContext(), new String[]{str});
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cuV();
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        }
        setContentView(R.layout.person_post_activity);
        this.gmi = getVoiceManager();
        if (this.gmi != null) {
            this.gmi.onCreate(getPageContext());
        }
        this.jlQ = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
        this.mUid = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.hFo = getPageContext().getString(R.string.me);
            this.isHost = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.hFo = getPageContext().getString(R.string.he);
                    break;
                case 2:
                    this.hFo = getPageContext().getString(R.string.she);
                    break;
                default:
                    this.hFo = getPageContext().getString(R.string.ta);
                    break;
            }
        }
        TbadkCoreApplication.isMyLive = false;
        if (this.mUid == null) {
            finish();
        } else {
            ap(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.jyU != null) {
            int count = this.jyU.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.jyU.getItem(i3);
                if (item instanceof PersonThreadFragment) {
                    ((PersonThreadFragment) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void ap(Bundle bundle) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.text_post));
        this.mBack = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonPostActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonPostActivity.this.finish();
            }
        });
        this.jyR = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.person_post_naviagtion_bar_recycle_bin, (View.OnClickListener) null);
        this.jyR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonPostActivity.2
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.post.PersonPostActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonPostActivity.this.rP(false);
                ba.aEt().b(PersonPostActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/pmc"});
            }
        });
        this.jyS = (ImageView) this.jyR.findViewById(R.id.iv_recycle_bin);
        this.jyT = (ImageView) this.jyR.findViewById(R.id.iv_recycle_bin_red_tip);
        if (com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_PERSON_POST_RECYCLE_BIN_RED_TIP_SHOW), false)) {
            this.jyT.setVisibility(0);
        } else {
            this.jyT.setVisibility(8);
        }
        this.ehd = (NoNetworkView) findViewById(R.id.person_post_no_network_view);
        this.hFm = new int[]{0, 1};
        this.jyU = new PersonPostAdapter(this);
        this.mTabHost = (FragmentTabHost) findViewById(R.id.tab_host);
        this.mTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setOnPageChangeListener(this);
        this.mTabHost.setTabWidgetViewHeight((int) getResources().getDimension(R.dimen.ds100));
        this.mTabHost.getFragmentTabWidget().setDviderRectWidth(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds64));
        initTabSpec();
        ((RelativeLayout.LayoutParams) this.mTabHost.getTabWrapper().getLayoutParams()).setMargins(0, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds88), 0, 0);
        if (bundle != null) {
            this.ezf = bundle.getInt("CurrTabIndex");
        } else {
            this.ezf = 0;
        }
        this.mTabHost.setCurrentTab(this.ezf);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.mContentFragment = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.dayTextColorResId = R.color.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
            bVar.cUe = fragmentTabIndicator;
            this.mTabHost.a(bVar);
        }
    }

    private void initTabSpec() {
        if (this.jyU != null) {
            int count = this.jyU.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.jyU.getItem(i);
                int wJ = this.jyU.wJ(i);
                if (item != null) {
                    if (wJ == 0) {
                        a(item, 0, getPageContext().getString(R.string.person_post_thread_new));
                    } else if (wJ == 1) {
                        a(item, 1, getPageContext().getString(R.string.reply));
                    }
                }
            }
            this.mTabHost.initViewPagerWithNoType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MessageManager.getInstance().registerListener(this.hQr);
        this.gmi = getVoiceManager();
        if (this.gmi != null) {
            this.gmi.onResume(getPageContext());
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
        MessageManager.getInstance().unRegisterListener(this.hQr);
        this.gmi = getVoiceManager();
        if (this.gmi != null) {
            this.gmi.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.gmi = getVoiceManager();
        if (this.gmi != null) {
            this.gmi.onDestory(getPageContext());
        }
        try {
            PersonExtraStatic.cuV();
            super.onDestroy();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.gmi = getVoiceManager();
        if (this.gmi != null) {
            this.gmi.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gmi = getVoiceManager();
        if (this.gmi != null) {
            this.gmi.onStop(getPageContext());
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public String bVQ() {
        return this.hFo;
    }

    public String getPortraitUrl() {
        return this.jlQ;
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.ezf);
        this.gmi = getVoiceManager();
        if (this.gmi != null) {
            this.gmi.onSaveInstanceState(getPageContext().getPageActivity());
        }
        super.onSaveInstanceState(bundle);
    }

    public String cyy() {
        if (this.isHost) {
            return getPageContext().getString(R.string.person_post_lv_empty_host);
        }
        return String.format(getPageContext().getString(R.string.person_post_lv_empty_guest), bVQ());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.ezf) {
            this.ezf = i;
            if (this.hFm[i] == 0) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.hFm[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ehd.onChangeSkinType(getPageContext(), i);
        this.mTabHost.setNeedShowThemeStyle(false);
        this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.mTabHost.onChangeSkinType(i);
        if (this.mTabHost.getFragmentTabWidget() != null) {
            am.setBackgroundColor(this.mTabHost.getFragmentTabWidget(), R.color.cp_bg_line_d);
        }
        SvgManager.aEp().a(this.jyS, R.drawable.icon_pure_topbar_delete44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jyT.setImageDrawable(am.getDrawable(i, (int) R.drawable.person_center_red_tip_shape));
        if (this.jyU != null) {
            int count = this.jyU.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.jyU.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public p onGetPreLoadListView() {
        if (this.jyU != null) {
            PersonThreadFragment cyz = this.jyU.cyz();
            h cyA = cyz != null ? cyz.cyA() : null;
            if (cyA == null || cyA.cyH() == null) {
                return null;
            }
            return cyA.cyH().getPreLoadHandle();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gmi == null) {
            this.gmi = VoiceManager.instance();
        }
        return this.gmi;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    private void cuV() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_USER_POST_PAGE, UserPostPageSocketResponsedMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001503, com.baidu.tieba.tbadkCore.a.a.bv(Config.USER_POST_ADDRESS, CmdConfigSocket.CMD_USER_POST_PAGE));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(UserPostPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.post.d
    public void cyx() {
        if (this.jyU != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jyU.getCount()) {
                    if (this.jyU.getItem(i2) instanceof c) {
                        ((c) this.jyU.getItem(i2)).cyw();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.post.b
    public void rP(boolean z) {
        if (this.jyT != null) {
            if (z && this.jyT.getVisibility() == 8) {
                this.jyT.setVisibility(0);
                com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_PERSON_POST_RECYCLE_BIN_RED_TIP_SHOW), true);
            } else if (!z && this.jyT.getVisibility() == 0) {
                this.jyT.setVisibility(8);
                com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_PERSON_POST_RECYCLE_BIN_RED_TIP_SHOW), false);
            }
        }
    }
}
