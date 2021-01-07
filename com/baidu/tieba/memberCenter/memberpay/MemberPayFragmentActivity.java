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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.pay.PayConfigModel;
import com.baidu.tbadk.pay.ResponseGetPayinfoMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class MemberPayFragmentActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private ImageView bNg;
    private View llA;
    private ImageView llB;
    private LinearLayout llC;
    private IndicatorView llD;
    private MemberPayListAdapter llE;
    private int lld;
    private int lle;
    private String llf;
    private int llh;
    private PayConfigModel llj;
    private RelativeLayout lly;
    private RelativeLayout llz;
    private String mClickZone;
    private int mFrom;
    private boolean mIsClose;
    private String mReferPage;
    private String mStType;
    private FragmentTabHost mTabHost;
    private TextView mTvTitle;
    private int bMx = 0;
    private boolean mHasInit = false;
    private Boolean llk = false;
    private String lll = "c10482";
    private String llm = "c10483";
    private HttpMessageListener llp = new HttpMessageListener(1001505) { // from class: com.baidu.tieba.memberCenter.memberpay.MemberPayFragmentActivity.1
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
                        if (pay_status == 0) {
                            MemberPayFragmentActivity.this.dhn();
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_RESPONSE_MEM, Integer.valueOf(MemberPayFragmentActivity.this.llh)));
                            MemberPayFragmentActivity.this.setResult(-1);
                            com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, true);
                            if (!MemberPayFragmentActivity.this.mIsClose) {
                                MemberPayFragmentActivity.this.dhc();
                                return;
                            } else {
                                MemberPayFragmentActivity.this.finish();
                                return;
                            }
                        }
                        if (pay_status == 1 || pay_status == 3) {
                        }
                    }
                }
            }
        }
    };
    public HttpMessageListener lkO = new HttpMessageListener(1001532) { // from class: com.baidu.tieba.memberCenter.memberpay.MemberPayFragmentActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            MemberPayFragmentActivity.this.closeLoadingDialog();
            if ((httpResponsedMessage instanceof ResponseMemberPayMessage) && httpResponsedMessage.getCmd() == 1001532) {
                ResponseMemberPayMessage responseMemberPayMessage = (ResponseMemberPayMessage) httpResponsedMessage;
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    String errorString = responseMemberPayMessage.getErrorString();
                    if (StringUtils.isNull(errorString)) {
                        errorString = MemberPayFragmentActivity.this.getResources().getString(R.string.neterror);
                    }
                    MemberPayFragmentActivity.this.showToast(errorString);
                } else if (responseMemberPayMessage.getMemberPayResult() != null) {
                    f memberPayResult = responseMemberPayMessage.getMemberPayResult();
                    MemberPayFragmentActivity.this.d(memberPayResult);
                    if (MemberPayFragmentActivity.this.llE != null) {
                        int count = MemberPayFragmentActivity.this.llE.getCount();
                        for (int i = 0; i < count; i++) {
                            MemberPayFragmentActivity.this.llE.getItem(i).setDataAndRefreshUI(memberPayResult);
                        }
                    }
                } else {
                    MemberPayFragmentActivity.this.showToast(R.string.neterror);
                }
            }
        }
    };
    final CustomMessageListener llq = new CustomMessageListener(CmdConfigCustom.CMD_AUTO_PAY_SUCC) { // from class: com.baidu.tieba.memberCenter.memberpay.MemberPayFragmentActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016525 && MemberPayFragmentActivity.this.llE != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                int count = MemberPayFragmentActivity.this.llE.getCount();
                for (int i = 0; i < count; i++) {
                    MemberPayFragmentActivity.this.llE.getItem(i).o(bool);
                }
                MemberPayFragmentActivity.this.showToast(R.string.tips_auto_pay_succ);
            }
        }
    };

    private void FK(int i) {
        if (i >= 2) {
            this.llC.setVisibility(0);
        } else {
            this.llC.setVisibility(4);
        }
        this.llD.setCount(i);
        Jb();
    }

    private void Jb() {
        this.llD.setPosition(this.bMx);
        this.mTvTitle.setText(FL(this.llh));
        if (this.llh == 2) {
            ao.setImageResource(this.llB, R.drawable.icon_tbvip_supervip, TbadkCoreApplication.getInst().getSkinType());
        } else {
            ao.setImageResource(this.llB, R.drawable.icon_tbvip_commonvip, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        TiebaStatic.log(this.lll);
        if (!TbadkCoreApplication.isLogin()) {
            bg.skipToLoginActivity(getActivity());
            finish();
            return;
        }
        dhl();
        t consumePathData = TbadkCoreApplication.getInst().getConsumePathData();
        if (consumePathData != null) {
            this.llk = Boolean.valueOf(consumePathData.aH(1, this.llf));
        }
        initView();
        initListener();
        initData();
        dhm();
    }

    private void dhl() {
        if (getIntent() != null && getIntent().getExtras() != null) {
            this.lld = getIntent().getExtras().getInt("member_type");
            this.mStType = getIntent().getExtras().getString("st_type");
            this.mFrom = getIntent().getExtras().getInt("from", 0);
            this.mIsClose = getIntent().getExtras().getBoolean("close");
            this.lle = getIntent().getExtras().getInt("from_scene", 0);
            this.llf = getIntent().getExtras().getString("scene_id");
        }
        if (this.lle == 3) {
            this.llf = "4001001001";
        } else if (this.lle == 4) {
            this.llf = "4001001002";
        }
        if (StringUtils.isNull(this.llf)) {
            this.llf = "4008001000";
        }
        this.mReferPage = getIntent().getExtras().getString("refer_page");
        this.mClickZone = getIntent().getExtras().getString("click_zone");
    }

    private void initView() {
        showLoadingDialog(getPageContext().getString(R.string.flist_loading));
        setContentView(R.layout.member_pay_fragment_activity);
        this.llA = findViewById(R.id.top_translate_view);
        this.llA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.memberpay.MemberPayFragmentActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MemberPayFragmentActivity.this.dho();
            }
        });
        this.lly = (RelativeLayout) findViewById(R.id.mainContainer);
        this.llz = (RelativeLayout) findViewById(R.id.navigation_bar);
        this.bNg = (ImageView) findViewById(R.id.btnClose);
        this.bNg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.memberpay.MemberPayFragmentActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MemberPayFragmentActivity.this.dho();
            }
        });
        this.llB = (ImageView) findViewById(R.id.tvIcon);
        this.mTvTitle = (TextView) findViewById(R.id.tvTitle);
        this.llC = (LinearLayout) findViewById(R.id.indicator_parent_view);
        this.llD = (IndicatorView) findViewById(R.id.member_tab_indicator);
        this.mTabHost = (FragmentTabHost) findViewById(R.id.tab_host);
        this.mTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setOnPageChangeListener(this);
        this.mTabHost.setTabWidgetViewHeight(0);
        this.mTabHost.reset();
        this.mTabHost.getFragmentTabWidget().setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.ds12));
        this.mTabHost.getFragmentTabWidget().setDviderRectWidth(-2);
        this.mTabHost.getFragmentTabWidget().setDviderRectHeight(l.getDimens(getActivity(), R.dimen.ds4));
    }

    private void initListener() {
        registerListener(this.lkO);
        registerListener(this.llp);
        registerListener(this.llq);
    }

    private void initData() {
        dhb();
        this.llj = new PayConfigModel(getPageContext(), new com.baidu.tbadk.pay.a() { // from class: com.baidu.tieba.memberCenter.memberpay.MemberPayFragmentActivity.6
            @Override // com.baidu.tbadk.pay.a
            public void onError(String str) {
                MemberPayFragmentActivity.this.dhc();
            }

            @Override // com.baidu.tbadk.pay.a
            public void onPayNative() {
                MemberPayFragmentActivity.this.dhc();
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.memberCenter.memberpay.MemberPayFragmentActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.pay.a
            public void onPayH5() {
                com.baidu.tbadk.pay.c.bHw().a("http://tieba.baidu.com/mo/q/tbeantshow?refer_page=" + MemberPayFragmentActivity.this.mReferPage + "&click_zone=" + MemberPayFragmentActivity.this.mClickZone, MemberPayFragmentActivity.this.getPageContext());
                MemberPayFragmentActivity.this.finish();
            }
        });
        this.llj.bHv();
    }

    private void dhb() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001532, TbConfig.SERVER_ADDRESS + TbConfig.MEMBER_PAY);
        tbHttpMessageTask.setResponsedClass(ResponseMemberPayMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhc() {
        HttpMessage httpMessage = new HttpMessage(1001532);
        if (this.mStType != null) {
            httpMessage.addParam("st_type", this.mStType);
        }
        httpMessage.addParam("from_scene", this.lle);
        sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.llj != null) {
            this.llj.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.llz, R.color.CAM_X0201);
        ao.setImageResource(this.bNg, R.drawable.icon_tbvip_close_black, i);
        ao.setViewTextColor(this.mTvTitle, R.color.CAM_X0105);
        ao.setBackgroundColor(this.lly, R.color.CAM_X0201);
        if (this.llh == 2) {
            ao.setImageResource(this.llB, R.drawable.icon_tbvip_supervip, i);
        } else {
            ao.setImageResource(this.llB, R.drawable.icon_tbvip_commonvip, i);
        }
        this.llD.setSelector(ao.getDrawable(R.drawable.white_circle_size15_cp_bg_line_a));
        this.llD.setDrawable(ao.getDrawable(R.drawable.white_circle_size15_cp_bg_line_c));
        ao.setBackgroundColor(this.llC, R.color.CAM_X0201);
        if (this.llE != null) {
            int count = this.llE.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                this.llE.getItem(i2).changeSkinType(i);
            }
        }
    }

    private void dhm() {
        if (this.mFrom == 6) {
            TiebaStatic.log("consume_24");
        } else if (this.mFrom == 2) {
            TiebaStatic.log(TbadkCoreStatisticKey.FRS_EXPERIENCE_SPEED);
        } else if (this.mFrom == 4) {
            TiebaStatic.log("c10751");
        } else if (this.mFrom == 5) {
            TiebaStatic.log("c10750");
        } else if (this.mFrom == 26) {
            TiebaStatic.log(new aq("c13747").an("obj_source", 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhn() {
        if (this.mFrom == 2) {
            Ou("consume_10");
        } else if (this.mFrom == 1) {
            Ou("consume_5");
        } else if (this.mFrom == 3) {
            Ou("consume_35");
        } else if (this.mFrom == 4) {
            TiebaStatic.log("c10032");
        } else if (this.mFrom == 5) {
            TiebaStatic.log("c10039");
        } else if (this.mFrom == 6) {
            TiebaStatic.log(TbadkCoreStatisticKey.TAIL_PAY_MEMBER_SUCCESS);
        } else if (this.mFrom == 7) {
            TiebaStatic.log(TbadkCoreStatisticKey.BUBBLE_PAY_MEMBER_SUCCESS);
        }
    }

    private void Ou(String str) {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), str, "click");
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.MEMBER_BUY;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.isRouteStat = true;
        }
        return pageStayDurationItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dho() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.setAutoNight(true);
        aVar.jH(true);
        aVar.setTitleShowCenter(true);
        aVar.setMessageShowCenter(true);
        aVar.Bn(getString(R.string.tb_member_confirm_dialog_title));
        aVar.Bo(getString(R.string.tb_member_confirm_dialog_msg));
        aVar.a(getString(R.string.go_on), new a.b() { // from class: com.baidu.tieba.memberCenter.memberpay.MemberPayFragmentActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                TiebaStatic.log(new aq("c13202").an("obj_locate", 1));
            }
        });
        aVar.b(getString(R.string.tb_member_confirm_dialog_quit), new a.b() { // from class: com.baidu.tieba.memberCenter.memberpay.MemberPayFragmentActivity.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new aq("c13202").an("obj_locate", 0));
                aVar2.dismiss();
                if (MemberPayFragmentActivity.this.llA != null) {
                    MemberPayFragmentActivity.this.llA.setBackgroundColor(MemberPayFragmentActivity.this.getPageContext().getPageActivity().getResources().getColor(R.color.transparent));
                }
                MemberPayFragmentActivity.this.finish();
            }
        });
        aVar.b(getPageContext()).btY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(f fVar) {
        if (!this.mHasInit) {
            this.mHasInit = true;
            boolean z = fVar.llR.lmJ.lmE == 2 || this.lld == 2;
            ArrayList arrayList = new ArrayList();
            Bundle bundle = new Bundle();
            bundle.putString("member_refer_page", this.mReferPage);
            bundle.putString("member_click_zone", this.mClickZone);
            bundle.putBoolean("member_is_pay_dialog", this.llk.booleanValue());
            bundle.putInt("member_from_type", this.mFrom);
            if (z || fVar.llS.lmt == null) {
                MemberPayFragment memberPayFragment = new MemberPayFragment();
                bundle.putInt("member_type", 2);
                this.llh = 2;
                memberPayFragment.setArguments(bundle);
                arrayList.add(memberPayFragment);
            } else if (fVar.llS.lmu == null) {
                MemberPayFragment memberPayFragment2 = new MemberPayFragment();
                bundle.putInt("member_type", 1);
                this.llh = 1;
                memberPayFragment2.setArguments(bundle);
                arrayList.add(memberPayFragment2);
            } else {
                MemberPayFragment memberPayFragment3 = new MemberPayFragment();
                Bundle bundle2 = (Bundle) bundle.clone();
                bundle2.putInt("member_type", 2);
                this.llh = 2;
                memberPayFragment3.setArguments(bundle2);
                arrayList.add(memberPayFragment3);
                MemberPayFragment memberPayFragment4 = new MemberPayFragment();
                Bundle bundle3 = (Bundle) bundle.clone();
                bundle3.putInt("member_type", 1);
                memberPayFragment4.setArguments(bundle3);
                arrayList.add(memberPayFragment4);
            }
            if (this.llE == null) {
                this.llE = new MemberPayListAdapter(getSupportFragmentManager());
                eU(arrayList);
                FK(this.llE.getCount());
                this.mTabHost.setCurrentTab(0);
            }
        }
    }

    private void eU(List<MemberPayFragment> list) {
        this.llE.cv(list);
        int count = this.llE.getCount();
        for (int i = 0; i < count; i++) {
            a(this.llE.getItem(i), i, FL(this.llE.getItem(i).getType()));
        }
        this.mTabHost.initViewPagerWithNoType();
        this.mTabHost.changeStyle(0);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            bVar.mContentFragment = fragment;
            bVar.mType = i;
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.dayTextColorResId = R.color.fragment_tab_host_indicator_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setContentWidthWrapContent();
            bVar.fbC = fragmentTabIndicator;
            this.mTabHost.a(bVar);
        }
    }

    private String FL(int i) {
        switch (i) {
            case 2:
                return getResources().getString(R.string.tb_vip_member_title);
            default:
                return getResources().getString(R.string.tb_normal_member_title);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            dho();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bMx = i;
        if (this.llE != null) {
            this.llh = this.llE.getItem(this.bMx).getType();
        }
        Jb();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.anim_alpha_0_to_1_duration_300, R.anim.anim_alpha_1_to_0_duration_300);
    }
}
