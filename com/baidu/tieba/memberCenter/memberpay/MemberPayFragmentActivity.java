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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.pay.PayConfigModel;
import com.baidu.tbadk.pay.ResponseGetPayinfoMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class MemberPayFragmentActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private ImageView bNE;
    private int lqV;
    private int lqW;
    private String lqX;
    private int lqZ;
    private PayConfigModel lrb;
    private RelativeLayout lrq;
    private RelativeLayout lrr;
    private View lrs;
    private ImageView lrt;
    private LinearLayout lru;
    private IndicatorView lrv;
    private MemberPayListAdapter lrw;
    private String mClickZone;
    private int mFrom;
    private boolean mIsClose;
    private String mReferPage;
    private String mStType;
    private FragmentTabHost mTabHost;
    private TextView mTvTitle;
    private int bMV = 0;
    private boolean mHasInit = false;
    private Boolean lrc = false;
    private String lrd = "c10482";
    private String lre = "c10483";
    private HttpMessageListener lrh = new HttpMessageListener(1001505) { // from class: com.baidu.tieba.memberCenter.memberpay.MemberPayFragmentActivity.1
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
                            MemberPayFragmentActivity.this.dfL();
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_RESPONSE_MEM, Integer.valueOf(MemberPayFragmentActivity.this.lqZ)));
                            MemberPayFragmentActivity.this.setResult(-1);
                            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, true);
                            if (!MemberPayFragmentActivity.this.mIsClose) {
                                MemberPayFragmentActivity.this.dfA();
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
    public HttpMessageListener lqG = new HttpMessageListener(1001532) { // from class: com.baidu.tieba.memberCenter.memberpay.MemberPayFragmentActivity.2
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
                    if (MemberPayFragmentActivity.this.lrw != null) {
                        int count = MemberPayFragmentActivity.this.lrw.getCount();
                        for (int i = 0; i < count; i++) {
                            MemberPayFragmentActivity.this.lrw.getItem(i).setDataAndRefreshUI(memberPayResult);
                        }
                    }
                } else {
                    MemberPayFragmentActivity.this.showToast(R.string.neterror);
                }
            }
        }
    };
    final CustomMessageListener lri = new CustomMessageListener(CmdConfigCustom.CMD_AUTO_PAY_SUCC) { // from class: com.baidu.tieba.memberCenter.memberpay.MemberPayFragmentActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016525 && MemberPayFragmentActivity.this.lrw != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                int count = MemberPayFragmentActivity.this.lrw.getCount();
                for (int i = 0; i < count; i++) {
                    MemberPayFragmentActivity.this.lrw.getItem(i).n(bool);
                }
                MemberPayFragmentActivity.this.showToast(R.string.tips_auto_pay_succ);
            }
        }
    };

    private void Ez(int i) {
        if (i >= 2) {
            this.lru.setVisibility(0);
        } else {
            this.lru.setVisibility(4);
        }
        this.lrv.setCount(i);
        Gz();
    }

    private void Gz() {
        this.lrv.setPosition(this.bMV);
        this.mTvTitle.setText(EA(this.lqZ));
        if (this.lqZ == 2) {
            ap.setImageResource(this.lrt, R.drawable.icon_tbvip_supervip, TbadkCoreApplication.getInst().getSkinType());
        } else {
            ap.setImageResource(this.lrt, R.drawable.icon_tbvip_commonvip, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        TiebaStatic.log(this.lrd);
        if (!TbadkCoreApplication.isLogin()) {
            bh.skipToLoginActivity(getActivity());
            finish();
            return;
        }
        dfJ();
        t consumePathData = TbadkCoreApplication.getInst().getConsumePathData();
        if (consumePathData != null) {
            this.lrc = Boolean.valueOf(consumePathData.aM(1, this.lqX));
        }
        initView();
        initListener();
        initData();
        dfK();
    }

    private void dfJ() {
        if (getIntent() != null && getIntent().getExtras() != null) {
            this.lqV = getIntent().getExtras().getInt("member_type");
            this.mStType = getIntent().getExtras().getString("st_type");
            this.mFrom = getIntent().getExtras().getInt("from", 0);
            this.mIsClose = getIntent().getExtras().getBoolean("close");
            this.lqW = getIntent().getExtras().getInt("from_scene", 0);
            this.lqX = getIntent().getExtras().getString("scene_id");
        }
        if (this.lqW == 3) {
            this.lqX = "4001001001";
        } else if (this.lqW == 4) {
            this.lqX = "4001001002";
        }
        if (StringUtils.isNull(this.lqX)) {
            this.lqX = "4008001000";
        }
        this.mReferPage = getIntent().getExtras().getString("refer_page");
        this.mClickZone = getIntent().getExtras().getString("click_zone");
    }

    private void initView() {
        showLoadingDialog(getPageContext().getString(R.string.flist_loading));
        setContentView(R.layout.member_pay_fragment_activity);
        this.lrs = findViewById(R.id.top_translate_view);
        this.lrs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.memberpay.MemberPayFragmentActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MemberPayFragmentActivity.this.dfM();
            }
        });
        this.lrq = (RelativeLayout) findViewById(R.id.mainContainer);
        this.lrr = (RelativeLayout) findViewById(R.id.navigation_bar);
        this.bNE = (ImageView) findViewById(R.id.btnClose);
        this.bNE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.memberpay.MemberPayFragmentActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MemberPayFragmentActivity.this.dfM();
            }
        });
        this.lrt = (ImageView) findViewById(R.id.tvIcon);
        this.mTvTitle = (TextView) findViewById(R.id.tvTitle);
        this.lru = (LinearLayout) findViewById(R.id.indicator_parent_view);
        this.lrv = (IndicatorView) findViewById(R.id.member_tab_indicator);
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
        registerListener(this.lqG);
        registerListener(this.lrh);
        registerListener(this.lri);
    }

    private void initData() {
        dfz();
        this.lrb = new PayConfigModel(getPageContext(), new com.baidu.tbadk.pay.a() { // from class: com.baidu.tieba.memberCenter.memberpay.MemberPayFragmentActivity.6
            @Override // com.baidu.tbadk.pay.a
            public void onError(String str) {
                MemberPayFragmentActivity.this.dfA();
            }

            @Override // com.baidu.tbadk.pay.a
            public void onPayNative() {
                MemberPayFragmentActivity.this.dfA();
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.memberCenter.memberpay.MemberPayFragmentActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.pay.a
            public void onPayH5() {
                com.baidu.tbadk.pay.c.bDZ().a("http://tieba.baidu.com/mo/q/tbeantshow?refer_page=" + MemberPayFragmentActivity.this.mReferPage + "&click_zone=" + MemberPayFragmentActivity.this.mClickZone, MemberPayFragmentActivity.this.getPageContext());
                MemberPayFragmentActivity.this.finish();
            }
        });
        this.lrb.bDY();
    }

    private void dfz() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001532, TbConfig.SERVER_ADDRESS + TbConfig.MEMBER_PAY);
        tbHttpMessageTask.setResponsedClass(ResponseMemberPayMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfA() {
        HttpMessage httpMessage = new HttpMessage(1001532);
        if (this.mStType != null) {
            httpMessage.addParam("st_type", this.mStType);
        }
        httpMessage.addParam("from_scene", this.lqW);
        sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.lrb != null) {
            this.lrb.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.lrr, R.color.CAM_X0201);
        ap.setImageResource(this.bNE, R.drawable.icon_tbvip_close_black, i);
        ap.setViewTextColor(this.mTvTitle, R.color.CAM_X0105);
        ap.setBackgroundColor(this.lrq, R.color.CAM_X0201);
        if (this.lqZ == 2) {
            ap.setImageResource(this.lrt, R.drawable.icon_tbvip_supervip, i);
        } else {
            ap.setImageResource(this.lrt, R.drawable.icon_tbvip_commonvip, i);
        }
        this.lrv.setSelector(ap.getDrawable(R.drawable.white_circle_size15_cp_bg_line_a));
        this.lrv.setDrawable(ap.getDrawable(R.drawable.white_circle_size15_cp_bg_line_c));
        ap.setBackgroundColor(this.lru, R.color.CAM_X0201);
        if (this.lrw != null) {
            int count = this.lrw.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                this.lrw.getItem(i2).changeSkinType(i);
            }
        }
    }

    private void dfK() {
        if (this.mFrom == 6) {
            TiebaStatic.log("consume_24");
        } else if (this.mFrom == 2) {
            TiebaStatic.log(TbadkCoreStatisticKey.FRS_EXPERIENCE_SPEED);
        } else if (this.mFrom == 4) {
            TiebaStatic.log("c10751");
        } else if (this.mFrom == 5) {
            TiebaStatic.log("c10750");
        } else if (this.mFrom == 26) {
            TiebaStatic.log(new ar("c13747").aq("obj_source", 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfL() {
        if (this.mFrom == 2) {
            Oi("consume_10");
        } else if (this.mFrom == 1) {
            Oi("consume_5");
        } else if (this.mFrom == 3) {
            Oi("consume_35");
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

    private void Oi(String str) {
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
    public void dfM() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.setAutoNight(true);
        aVar.jF(true);
        aVar.setTitleShowCenter(true);
        aVar.setMessageShowCenter(true);
        aVar.AA(getString(R.string.tb_member_confirm_dialog_title));
        aVar.AB(getString(R.string.tb_member_confirm_dialog_msg));
        aVar.a(getString(R.string.go_on), new a.b() { // from class: com.baidu.tieba.memberCenter.memberpay.MemberPayFragmentActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                TiebaStatic.log(new ar("c13202").aq("obj_locate", 1));
            }
        });
        aVar.b(getString(R.string.tb_member_confirm_dialog_quit), new a.b() { // from class: com.baidu.tieba.memberCenter.memberpay.MemberPayFragmentActivity.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ar("c13202").aq("obj_locate", 0));
                aVar2.dismiss();
                if (MemberPayFragmentActivity.this.lrs != null) {
                    MemberPayFragmentActivity.this.lrs.setBackgroundColor(MemberPayFragmentActivity.this.getPageContext().getPageActivity().getResources().getColor(R.color.transparent));
                }
                MemberPayFragmentActivity.this.finish();
            }
        });
        aVar.b(getPageContext()).bqz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(f fVar) {
        if (!this.mHasInit) {
            this.mHasInit = true;
            boolean z = fVar.lrJ.lsB.lsw == 2 || this.lqV == 2;
            ArrayList arrayList = new ArrayList();
            Bundle bundle = new Bundle();
            bundle.putString("member_refer_page", this.mReferPage);
            bundle.putString("member_click_zone", this.mClickZone);
            bundle.putBoolean("member_is_pay_dialog", this.lrc.booleanValue());
            bundle.putInt("member_from_type", this.mFrom);
            if (z || fVar.lrK.lsl == null) {
                MemberPayFragment memberPayFragment = new MemberPayFragment();
                bundle.putInt("member_type", 2);
                this.lqZ = 2;
                memberPayFragment.setArguments(bundle);
                arrayList.add(memberPayFragment);
            } else if (fVar.lrK.lsm == null) {
                MemberPayFragment memberPayFragment2 = new MemberPayFragment();
                bundle.putInt("member_type", 1);
                this.lqZ = 1;
                memberPayFragment2.setArguments(bundle);
                arrayList.add(memberPayFragment2);
            } else {
                MemberPayFragment memberPayFragment3 = new MemberPayFragment();
                Bundle bundle2 = (Bundle) bundle.clone();
                bundle2.putInt("member_type", 2);
                this.lqZ = 2;
                memberPayFragment3.setArguments(bundle2);
                arrayList.add(memberPayFragment3);
                MemberPayFragment memberPayFragment4 = new MemberPayFragment();
                Bundle bundle3 = (Bundle) bundle.clone();
                bundle3.putInt("member_type", 1);
                memberPayFragment4.setArguments(bundle3);
                arrayList.add(memberPayFragment4);
            }
            if (this.lrw == null) {
                this.lrw = new MemberPayListAdapter(getSupportFragmentManager());
                eS(arrayList);
                Ez(this.lrw.getCount());
                this.mTabHost.setCurrentTab(0);
            }
        }
    }

    private void eS(List<MemberPayFragment> list) {
        this.lrw.cq(list);
        int count = this.lrw.getCount();
        for (int i = 0; i < count; i++) {
            a(this.lrw.getItem(i), i, EA(this.lrw.getItem(i).getType()));
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
            bVar.faJ = fragmentTabIndicator;
            this.mTabHost.a(bVar);
        }
    }

    private String EA(int i) {
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
            dfM();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bMV = i;
        if (this.lrw != null) {
            this.lqZ = this.lrw.getItem(this.bMV).getType();
        }
        Gz();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.anim_alpha_0_to_1_duration_300, R.anim.anim_alpha_1_to_0_duration_300);
    }
}
