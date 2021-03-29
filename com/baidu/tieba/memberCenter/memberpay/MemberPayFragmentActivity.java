package com.baidu.tieba.memberCenter.memberpay;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.pay.PayConfigModel;
import com.baidu.tbadk.pay.ResponseGetPayinfoMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.h0.r.s.a;
import d.b.h0.s.c.s;
import d.b.i0.q1.f.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MemberPayFragmentActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    public int fromScene;
    public ImageView mBtnClose;
    public String mClickZone;
    public int mCurrentShowType;
    public MemberPayListAdapter mFragmentAdapter;
    public int mFrom;
    public IndicatorView mIndicator;
    public LinearLayout mIndicatorLayout;
    public boolean mIsClose;
    public RelativeLayout mNavigationBar;
    public PayConfigModel mPayConfigModel;
    public String mReferPage;
    public String mSceneId;
    public String mStType;
    public FragmentTabHost mTabHost;
    public View mTopTranslateView;
    public ImageView mTvIcon;
    public TextView mTvTitle;
    public int mWantedMemberType;
    public RelativeLayout mainContainer;
    public int mCurrentIndex = 0;
    public boolean mHasInit = false;
    public Boolean mIsPayDialog = Boolean.FALSE;
    public String MEMBER_PAY_VISIT = "c10482";
    public String MEMBER_PAY_CLICK = "c10483";
    public HttpMessageListener mGetMemberPayinfoListener = new a(CmdConfigHttp.GETPAYINFO_CMD);
    public HttpMessageListener mRequestMemberPayInfoListener = new b(CmdConfigHttp.MEMBER_PAY_CMD);
    public final CustomMessageListener mAutoPaySuccListener = new c(2016525);

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505 && (httpResponsedMessage instanceof ResponseGetPayinfoMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0) {
                    ResponseGetPayinfoMessage responseGetPayinfoMessage = (ResponseGetPayinfoMessage) httpResponsedMessage;
                    if (responseGetPayinfoMessage.getPayInfoResultData() != null) {
                        int pay_status = responseGetPayinfoMessage.getPayInfoResultData().getPay_status();
                        if (pay_status != 0) {
                            if (pay_status != 1 && pay_status == 3) {
                            }
                            return;
                        }
                        MemberPayFragmentActivity.this.addPaySussStats();
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001194, Integer.valueOf(MemberPayFragmentActivity.this.mCurrentShowType)));
                        MemberPayFragmentActivity.this.setResult(-1);
                        d.b.h0.r.d0.b.i().s("show_member_deid_line", true);
                        if (!MemberPayFragmentActivity.this.mIsClose) {
                            MemberPayFragmentActivity.this.requestMemberPayInfo();
                        } else {
                            MemberPayFragmentActivity.this.finish();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends HttpMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            MemberPayFragmentActivity.this.closeLoadingDialog();
            if ((httpResponsedMessage instanceof ResponseMemberPayMessage) && httpResponsedMessage.getCmd() == 1001532) {
                ResponseMemberPayMessage responseMemberPayMessage = (ResponseMemberPayMessage) httpResponsedMessage;
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (responseMemberPayMessage.getMemberPayResult() != null) {
                        d.b.i0.q1.f.f memberPayResult = responseMemberPayMessage.getMemberPayResult();
                        MemberPayFragmentActivity.this.initFragment(memberPayResult);
                        if (MemberPayFragmentActivity.this.mFragmentAdapter != null) {
                            int count = MemberPayFragmentActivity.this.mFragmentAdapter.getCount();
                            for (int i = 0; i < count; i++) {
                                MemberPayFragmentActivity.this.mFragmentAdapter.getItem(i).G0(memberPayResult);
                            }
                            return;
                        }
                        return;
                    }
                    MemberPayFragmentActivity.this.showToast(R.string.neterror);
                    return;
                }
                String errorString = responseMemberPayMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = MemberPayFragmentActivity.this.getResources().getString(R.string.neterror);
                }
                MemberPayFragmentActivity.this.showToast(errorString);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2016525 || MemberPayFragmentActivity.this.mFragmentAdapter == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            Boolean bool = (Boolean) customResponsedMessage.getData();
            int count = MemberPayFragmentActivity.this.mFragmentAdapter.getCount();
            for (int i = 0; i < count; i++) {
                MemberPayFragmentActivity.this.mFragmentAdapter.getItem(i).F0(bool);
            }
            MemberPayFragmentActivity.this.showToast(R.string.tips_auto_pay_succ);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MemberPayFragmentActivity.this.userConfirmDialog();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MemberPayFragmentActivity.this.userConfirmDialog();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.b.h0.l0.a {
        public f() {
        }

        @Override // d.b.h0.l0.a
        public void a() {
            d.b.h0.l0.c c2 = d.b.h0.l0.c.c();
            c2.b("http://tieba.baidu.com/mo/q/tbeantshow?refer_page=" + MemberPayFragmentActivity.this.mReferPage + "&click_zone=" + MemberPayFragmentActivity.this.mClickZone, MemberPayFragmentActivity.this.getPageContext());
            MemberPayFragmentActivity.this.finish();
        }

        @Override // d.b.h0.l0.a
        public void b() {
            MemberPayFragmentActivity.this.requestMemberPayInfo();
        }

        @Override // d.b.h0.l0.a
        public void onError(String str) {
            MemberPayFragmentActivity.this.requestMemberPayInfo();
        }
    }

    /* loaded from: classes3.dex */
    public class g implements a.e {
        public g() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            TiebaStatic.log(new StatisticItem("c13202").param("obj_locate", 1));
        }
    }

    /* loaded from: classes3.dex */
    public class h implements a.e {
        public h() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem("c13202").param("obj_locate", 0));
            aVar.dismiss();
            if (MemberPayFragmentActivity.this.mTopTranslateView != null) {
                MemberPayFragmentActivity.this.mTopTranslateView.setBackgroundColor(MemberPayFragmentActivity.this.getPageContext().getPageActivity().getResources().getColor(R.color.transparent));
            }
            MemberPayFragmentActivity.this.finish();
        }
    }

    private void addOpenPageStats() {
        int i = this.mFrom;
        if (i == 6) {
            TiebaStatic.log("consume_24");
        } else if (i == 2) {
            TiebaStatic.log(TbadkCoreStatisticKey.FRS_EXPERIENCE_SPEED);
        } else if (i == 4) {
            TiebaStatic.log("c10751");
        } else if (i == 5) {
            TiebaStatic.log("c10750");
        } else if (i == 26) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.MEMBER_PAY_PAGE_SHOW).param("obj_source", 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPaySussStats() {
        int i = this.mFrom;
        if (i == 2) {
            addStat("consume_10");
        } else if (i == 1) {
            addStat("consume_5");
        } else if (i == 3) {
            addStat("consume_35");
        } else if (i == 4) {
            TiebaStatic.log("c10032");
        } else if (i == 5) {
            TiebaStatic.log("c10039");
        } else if (i == 6) {
            TiebaStatic.log(TbadkCoreStatisticKey.TAIL_PAY_MEMBER_SUCCESS);
        } else if (i == 7) {
            TiebaStatic.log(TbadkCoreStatisticKey.BUBBLE_PAY_MEMBER_SUCCESS);
        }
    }

    private void addStat(String str) {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), str, PrefetchEvent.STATE_CLICK);
    }

    private void createAndAddTabSpec(Fragment fragment, int i, String str) {
        if (fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        bVar.f13313c = fragment;
        bVar.f13311a = i;
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.l = R.color.fragment_tab_host_indicator_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        fragmentTabIndicator.setContentWidthWrapContent();
        bVar.f13312b = fragmentTabIndicator;
        this.mTabHost.a(bVar);
    }

    private String getTabNameByType(int i) {
        if (i != 2) {
            return getResources().getString(R.string.tb_normal_member_title);
        }
        return getResources().getString(R.string.tb_vip_member_title);
    }

    private void handleIntent() {
        if (getIntent() != null && getIntent().getExtras() != null) {
            this.mWantedMemberType = getIntent().getExtras().getInt("member_type");
            this.mStType = getIntent().getExtras().getString("st_type");
            this.mFrom = getIntent().getExtras().getInt("from", 0);
            this.mIsClose = getIntent().getExtras().getBoolean(IntentConfig.CLOSE);
            this.fromScene = getIntent().getExtras().getInt(MemberPayActivityConfig.FROM_SCENE, 0);
            this.mSceneId = getIntent().getExtras().getString("scene_id");
        }
        int i = this.fromScene;
        if (i == 3) {
            this.mSceneId = "4001001001";
        } else if (i == 4) {
            this.mSceneId = "4001001002";
        }
        if (StringUtils.isNull(this.mSceneId)) {
            this.mSceneId = "4008001000";
        }
        this.mReferPage = getIntent().getExtras().getString(MemberPayStatistic.REFER_PAGE);
        this.mClickZone = getIntent().getExtras().getString(MemberPayStatistic.CLICK_ZONE);
    }

    private void initData() {
        registerGetMemberPayInfoTask();
        PayConfigModel payConfigModel = new PayConfigModel(getPageContext(), new f());
        this.mPayConfigModel = payConfigModel;
        payConfigModel.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void initFragment(d.b.i0.q1.f.f fVar) {
        if (this.mHasInit) {
            return;
        }
        this.mHasInit = true;
        boolean z = fVar.f59404a.f59430c.f59426a == 2 || this.mWantedMemberType == 2;
        ArrayList arrayList = new ArrayList();
        Bundle bundle = new Bundle();
        bundle.putString("member_refer_page", this.mReferPage);
        bundle.putString("member_click_zone", this.mClickZone);
        bundle.putBoolean("member_is_pay_dialog", this.mIsPayDialog.booleanValue());
        bundle.putInt("member_from_type", this.mFrom);
        if (!z) {
            f.b bVar = fVar.f59405b;
            if (bVar.f59411a != null) {
                if (bVar.f59412b == null) {
                    MemberPayFragment memberPayFragment = new MemberPayFragment();
                    bundle.putInt("member_type", 1);
                    this.mCurrentShowType = 1;
                    memberPayFragment.setArguments(bundle);
                    arrayList.add(memberPayFragment);
                } else {
                    MemberPayFragment memberPayFragment2 = new MemberPayFragment();
                    Bundle bundle2 = (Bundle) bundle.clone();
                    bundle2.putInt("member_type", 2);
                    this.mCurrentShowType = 2;
                    memberPayFragment2.setArguments(bundle2);
                    arrayList.add(memberPayFragment2);
                    MemberPayFragment memberPayFragment3 = new MemberPayFragment();
                    Bundle bundle3 = (Bundle) bundle.clone();
                    bundle3.putInt("member_type", 1);
                    memberPayFragment3.setArguments(bundle3);
                    arrayList.add(memberPayFragment3);
                }
                if (this.mFragmentAdapter != null) {
                    this.mFragmentAdapter = new MemberPayListAdapter(getSupportFragmentManager());
                    initTabSpec(arrayList);
                    initIndicator(this.mFragmentAdapter.getCount());
                    this.mTabHost.setCurrentTab(0);
                    return;
                }
                return;
            }
        }
        MemberPayFragment memberPayFragment4 = new MemberPayFragment();
        bundle.putInt("member_type", 2);
        this.mCurrentShowType = 2;
        memberPayFragment4.setArguments(bundle);
        arrayList.add(memberPayFragment4);
        if (this.mFragmentAdapter != null) {
        }
    }

    private void initIndicator(int i) {
        if (i >= 2) {
            this.mIndicatorLayout.setVisibility(0);
        } else {
            this.mIndicatorLayout.setVisibility(4);
        }
        this.mIndicator.setCount(i);
        updateIndicatorAndTabs();
    }

    private void initListener() {
        registerListener(this.mRequestMemberPayInfoListener);
        registerListener(this.mGetMemberPayinfoListener);
        registerListener(this.mAutoPaySuccListener);
    }

    private void initTabSpec(List<MemberPayFragment> list) {
        this.mFragmentAdapter.j(list);
        int count = this.mFragmentAdapter.getCount();
        for (int i = 0; i < count; i++) {
            createAndAddTabSpec(this.mFragmentAdapter.getItem(i), i, getTabNameByType(this.mFragmentAdapter.getItem(i).E0()));
        }
        this.mTabHost.l();
        this.mTabHost.d(0);
    }

    private void initView() {
        showLoadingDialog(getPageContext().getString(R.string.flist_loading));
        setContentView(R.layout.member_pay_fragment_activity);
        View findViewById = findViewById(R.id.top_translate_view);
        this.mTopTranslateView = findViewById;
        findViewById.setOnClickListener(new d());
        this.mainContainer = (RelativeLayout) findViewById(R.id.mainContainer);
        this.mNavigationBar = (RelativeLayout) findViewById(R.id.navigation_bar);
        ImageView imageView = (ImageView) findViewById(R.id.btnClose);
        this.mBtnClose = imageView;
        imageView.setOnClickListener(new e());
        this.mTvIcon = (ImageView) findViewById(R.id.tvIcon);
        this.mTvTitle = (TextView) findViewById(R.id.tvTitle);
        this.mIndicatorLayout = (LinearLayout) findViewById(R.id.indicator_parent_view);
        this.mIndicator = (IndicatorView) findViewById(R.id.member_tab_indicator);
        FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.tab_host);
        this.mTabHost = fragmentTabHost;
        fragmentTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setOnPageChangeListener(this);
        this.mTabHost.setTabWidgetViewHeight(0);
        this.mTabHost.p();
        this.mTabHost.getFragmentTabWidget().setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.ds12));
        this.mTabHost.getFragmentTabWidget().setDviderRectWidth(-2);
        this.mTabHost.getFragmentTabWidget().setDviderRectHeight(l.g(getActivity(), R.dimen.ds4));
    }

    private void registerGetMemberPayInfoTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MEMBER_PAY_CMD, TbConfig.SERVER_ADDRESS + TbConfig.MEMBER_PAY);
        tbHttpMessageTask.setResponsedClass(ResponseMemberPayMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestMemberPayInfo() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.MEMBER_PAY_CMD);
        String str = this.mStType;
        if (str != null) {
            httpMessage.addParam("st_type", str);
        }
        httpMessage.addParam(MemberPayActivityConfig.FROM_SCENE, this.fromScene);
        sendMessage(httpMessage);
    }

    private void updateIndicatorAndTabs() {
        this.mIndicator.setPosition(this.mCurrentIndex);
        this.mTvTitle.setText(getTabNameByType(this.mCurrentShowType));
        if (this.mCurrentShowType == 2) {
            SkinManager.setImageResource(this.mTvIcon, R.drawable.icon_tbvip_supervip, TbadkCoreApplication.getInst().getSkinType());
        } else {
            SkinManager.setImageResource(this.mTvIcon, R.drawable.icon_tbvip_commonvip, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void userConfirmDialog() {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(getPageContext().getPageActivity());
        aVar.setAutoNight(true);
        aVar.setCancelable(true);
        aVar.setTitleShowCenter(true);
        aVar.setMessageShowCenter(true);
        aVar.setTitle(getString(R.string.tb_member_confirm_dialog_title));
        aVar.setMessage(getString(R.string.tb_member_confirm_dialog_msg));
        aVar.setPositiveButton(getString(R.string.go_on), new g());
        aVar.setNegativeButton(getString(R.string.tb_member_confirm_dialog_quit), new h());
        aVar.create(getPageContext()).show();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "b001";
    }

    public int getFrom() {
        return this.mFrom;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public d.b.h0.k0.d getPageStayDurationItem() {
        d.b.h0.k0.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.f50239a = true;
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        SkinManager.setBackgroundColor(this.mNavigationBar, R.color.CAM_X0201);
        SkinManager.setImageResource(this.mBtnClose, R.drawable.icon_tbvip_close_black, i);
        SkinManager.setViewTextColor(this.mTvTitle, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.mainContainer, R.color.CAM_X0201);
        if (this.mCurrentShowType == 2) {
            SkinManager.setImageResource(this.mTvIcon, R.drawable.icon_tbvip_supervip, i);
        } else {
            SkinManager.setImageResource(this.mTvIcon, R.drawable.icon_tbvip_commonvip, i);
        }
        this.mIndicator.setSelector(SkinManager.getDrawable(R.drawable.white_circle_size15_cp_bg_line_a));
        this.mIndicator.setDrawable(SkinManager.getDrawable(R.drawable.white_circle_size15_cp_bg_line_c));
        SkinManager.setBackgroundColor(this.mIndicatorLayout, R.color.CAM_X0201);
        MemberPayListAdapter memberPayListAdapter = this.mFragmentAdapter;
        if (memberPayListAdapter != null) {
            int count = memberPayListAdapter.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                this.mFragmentAdapter.getItem(i2).changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        TiebaStatic.log(this.MEMBER_PAY_VISIT);
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getActivity());
            finish();
            return;
        }
        handleIntent();
        s consumePathData = TbadkCoreApplication.getInst().getConsumePathData();
        if (consumePathData != null) {
            this.mIsPayDialog = Boolean.valueOf(consumePathData.b(1, this.mSceneId));
        }
        initView();
        initListener();
        initData();
        addOpenPageStats();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        PayConfigModel payConfigModel = this.mPayConfigModel;
        if (payConfigModel != null) {
            payConfigModel.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            userConfirmDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        MemberPayListAdapter memberPayListAdapter = this.mFragmentAdapter;
        if (memberPayListAdapter != null) {
            this.mCurrentShowType = memberPayListAdapter.getItem(i).E0();
        }
        updateIndicatorAndTabs();
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.anim_alpha_0_to_1_duration_300, R.anim.anim_alpha_1_to_0_duration_300);
    }
}
