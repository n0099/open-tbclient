package com.baidu.tieba.post;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.personExtra.PersonExtraStatic;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageHttpResponseMessage;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageSocketResponsedMessage;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.k.e.q;
import d.a.n0.n2.d;
import d.a.n0.n2.h;
/* loaded from: classes5.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener, VoiceManager.j, d, d.a.n0.n2.b {
    public static final String CURRTABINDEX = "CurrTabIndex";
    public static final String KEY_EMPTYVIEW_TXT = "key_empty_view_text";
    public static final int PAGE_TYPE_AMOUNT = 2;
    public static final int PAGE_TYPE_MYREPLY = 1;
    public static final int PAGE_TYPE_MYTHEME = 0;
    public static final String THREAD_RECYCLE_BIN_URL = "http://tieba.baidu.com/mo/q/wise-bawu-core/recycle-station?noshare=1#/recycle-post";
    public NavigationBar mNavigationBar;
    public NoNetworkView mNoNetworkView;
    public PersonPostAdapter mPersonPostAdapter;
    public String mPortraitUrl;
    public RelativeLayout mRecycleBinLayout;
    public ImageView mRecycleBinRedTip;
    public TextView mRecycleBinTitle;
    public int mSex;
    public int mSkinType;
    public FragmentTabHost mTabHost;
    public int[] mTypes;
    public String mUid;
    public String mUtype;
    public VoiceManager mVoiceManager;
    public int mCurrTabIndex = -1;
    public boolean isHost = false;
    public View mBack = null;
    public final CustomMessageListener mToHotTopicListener = new c(2016493);

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonPostActivity.this.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_UEG_POST_CLICKED).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", PersonPostActivity.this.mRecycleBinRedTip.getVisibility() == 0 ? "1" : "2").param("obj_locate", 1));
            PersonPostActivity.this.showRecycleBinRedTip(false);
            UrlManager.getInstance().dealOneLink(PersonPostActivity.this.getPageContext(), new String[]{PersonPostActivity.THREAD_RECYCLE_BIN_URL});
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(PersonPostActivity.this.getPageContext(), new String[]{str});
        }
    }

    private void createAndAddTabSpec(Fragment fragment, int i2, String str) {
        if (fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        bVar.f12213c = fragment;
        bVar.f12211a = i2;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.l = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        bVar.f12212b = fragmentTabIndicator;
        this.mTabHost.a(bVar);
    }

    private void initPersonPostTasks() {
        d.a.n0.e3.d0.a.h(303002, UserPostPageSocketResponsedMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.USER_POST_HTTP_CMD, d.a.n0.e3.d0.a.a("c/u/feed/userpost", 303002));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(UserPostPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void initTabSpec() {
        PersonPostAdapter personPostAdapter = this.mPersonPostAdapter;
        if (personPostAdapter != null) {
            int count = personPostAdapter.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.mPersonPostAdapter.getItem(i2);
                int i3 = this.mPersonPostAdapter.i(i2);
                if (item != null) {
                    if (i3 == 0) {
                        createAndAddTabSpec(item, 0, getPageContext().getString(R.string.person_post_thread_new));
                    } else if (i3 == 1) {
                        createAndAddTabSpec(item, 1, getPageContext().getString(R.string.reply));
                    }
                }
            }
            this.mTabHost.l();
        }
    }

    private void initUI(Bundle bundle) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.setCenterTextTitle(getPageContext().getString(R.string.text_post));
        View view = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.mBack = view;
        view.setOnClickListener(new a());
        RelativeLayout relativeLayout = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.person_post_naviagtion_bar_recycle_bin, (View.OnClickListener) null);
        this.mRecycleBinLayout = relativeLayout;
        relativeLayout.setOnClickListener(new b());
        this.mRecycleBinTitle = (TextView) this.mRecycleBinLayout.findViewById(R.id.tv_recycle_bin);
        this.mRecycleBinRedTip = (ImageView) this.mRecycleBinLayout.findViewById(R.id.iv_recycle_bin_red_tip);
        if (d.a.m0.r.d0.b.j().g(d.a.m0.r.d0.b.n("key_person_post_recycle_bin_red_tip_show"), false)) {
            this.mRecycleBinRedTip.setVisibility(0);
        } else {
            this.mRecycleBinRedTip.setVisibility(8);
        }
        this.mNoNetworkView = (NoNetworkView) findViewById(R.id.person_post_no_network_view);
        this.mTypes = new int[]{0, 1};
        this.mPersonPostAdapter = new PersonPostAdapter(this);
        FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.tab_host);
        this.mTabHost = fragmentTabHost;
        fragmentTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setOnPageChangeListener(this);
        this.mTabHost.setTabWidgetViewHeight((int) getResources().getDimension(R.dimen.ds100));
        this.mTabHost.getFragmentTabWidget().setDviderRectWidth(l.g(getActivity(), R.dimen.ds64));
        initTabSpec();
        ((RelativeLayout.LayoutParams) this.mTabHost.getTabWrapper().getLayoutParams()).setMargins(0, UtilHelper.getLightStatusBarHeight() + l.g(getActivity(), R.dimen.ds88), 0, 0);
        if (bundle != null) {
            this.mCurrTabIndex = bundle.getInt("CurrTabIndex");
        } else {
            this.mCurrTabIndex = 0;
        }
        this.mTabHost.setCurrentTab(this.mCurrTabIndex);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.a.m0.k0.a
    public String getCurrentPageKey() {
        return "a080";
    }

    public String getEmptyViewText() {
        if (this.isHost) {
            return getPageContext().getString(R.string.person_post_lv_empty_host);
        }
        return String.format(getPageContext().getString(R.string.person_post_lv_empty_guest), getUtype());
    }

    public String getPortraitUrl() {
        return this.mPortraitUrl;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    public int getSex() {
        return this.mSex;
    }

    public String getUid() {
        return this.mUid;
    }

    public String getUtype() {
        return this.mUtype;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        if (this.mVoiceManager == null) {
            this.mVoiceManager = VoiceManager.instance();
        }
        return this.mVoiceManager;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        PersonPostAdapter personPostAdapter = this.mPersonPostAdapter;
        if (personPostAdapter != null) {
            int count = personPostAdapter.getCount();
            for (int i4 = 0; i4 < count; i4++) {
                Fragment item = this.mPersonPostAdapter.getItem(i4);
                if (item instanceof PersonThreadFragment) {
                    item.onActivityResult(i2, i3, intent);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        this.mNoNetworkView.c(getPageContext(), i2);
        this.mTabHost.setNeedShowThemeStyle(false);
        this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.mTabHost.p(i2);
        if (this.mTabHost.getFragmentTabWidget() != null) {
            SkinManager.setBackgroundColor(this.mTabHost.getFragmentTabWidget(), R.color.CAM_X0201);
        }
        SkinManager.setViewTextColor(this.mRecycleBinTitle, R.color.CAM_X0105);
        this.mRecycleBinRedTip.setImageDrawable(SkinManager.getDrawable(i2, R.drawable.person_center_red_tip_shape));
        PersonPostAdapter personPostAdapter = this.mPersonPostAdapter;
        if (personPostAdapter != null) {
            int count = personPostAdapter.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.mPersonPostAdapter.getItem(i3);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i2);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initPersonPostTasks();
        if (!j.z()) {
            showToast(R.string.neterror);
        }
        setContentView(R.layout.person_post_activity);
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        if (voiceManager != null) {
            voiceManager.onCreate(getPageContext());
        }
        this.mPortraitUrl = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
        this.mUid = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        String str = this.mUid;
        if (str == null) {
            str = "";
        }
        this.mUid = str;
        if (str.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.mUtype = getPageContext().getString(R.string.me);
            this.isHost = true;
        } else {
            int intExtra = getIntent().getIntExtra("key_sex", 0);
            if (intExtra == 1) {
                this.mUtype = getPageContext().getString(R.string.he);
            } else if (intExtra != 2) {
                this.mUtype = getPageContext().getString(R.string.ta);
            } else {
                this.mUtype = getPageContext().getString(R.string.she);
            }
        }
        TbadkCoreApplication.isMyLive = false;
        if (this.mUid == null) {
            finish();
        } else {
            initUI(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        if (voiceManager != null) {
            voiceManager.onDestory(getPageContext());
        }
        try {
            PersonExtraStatic.f();
            super.onDestroy();
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public q onGetPreLoadListView() {
        PersonPostAdapter personPostAdapter = this.mPersonPostAdapter;
        if (personPostAdapter != null) {
            PersonThreadFragment j = personPostAdapter.j();
            h Q0 = j != null ? j.Q0() : null;
            if (Q0 != null && Q0.f() != null) {
                return Q0.f().getPreLoadHandle();
            }
        }
        return null;
    }

    @Override // d.a.n0.n2.d
    public void onNoNetRefresh() {
        if (this.mPersonPostAdapter != null) {
            for (int i2 = 0; i2 < this.mPersonPostAdapter.getCount(); i2++) {
                if (this.mPersonPostAdapter.getItem(i2) instanceof d.a.n0.n2.c) {
                    ((d.a.n0.n2.c) this.mPersonPostAdapter.getItem(i2)).b0();
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        if (i2 < 0 || i2 >= 2 || i2 == this.mCurrTabIndex) {
            return;
        }
        this.mCurrTabIndex = i2;
        int[] iArr = this.mTypes;
        if (iArr[i2] == 0) {
            TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_thread" : "pp_his_thread", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
        } else if (iArr[i2] == 1) {
            TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_reply" : "pp_his_reply", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.mToHotTopicListener);
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        if (voiceManager != null) {
            voiceManager.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MessageManager.getInstance().registerListener(this.mToHotTopicListener);
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        if (voiceManager != null) {
            voiceManager.onResume(getPageContext());
        }
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.mSkinType = skinType;
            onChangeSkinType(skinType);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.mCurrTabIndex);
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        if (voiceManager != null) {
            voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        if (voiceManager != null) {
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        if (voiceManager != null) {
            voiceManager.onStop(getPageContext());
        }
    }

    @Override // d.a.n0.n2.b
    public void showRecycleBinRedTip(boolean z) {
        ImageView imageView = this.mRecycleBinRedTip;
        if (imageView == null) {
            return;
        }
        if (z && imageView.getVisibility() == 8) {
            this.mRecycleBinRedTip.setVisibility(0);
            d.a.m0.r.d0.b.j().t(d.a.m0.r.d0.b.n("key_person_post_recycle_bin_red_tip_show"), true);
        } else if (z || this.mRecycleBinRedTip.getVisibility() != 0) {
        } else {
            this.mRecycleBinRedTip.setVisibility(8);
            d.a.m0.r.d0.b.j().t(d.a.m0.r.d0.b.n("key_person_post_recycle_bin_red_tip_show"), false);
        }
    }
}
