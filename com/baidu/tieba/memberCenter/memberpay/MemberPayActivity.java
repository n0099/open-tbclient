package com.baidu.tieba.memberCenter.memberpay;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.pay.PayConfigModel;
import com.baidu.tbadk.pay.ResponseGetPayinfoMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import d.a.m0.s.c.u;
/* loaded from: classes3.dex */
public class MemberPayActivity extends BaseActivity<MemberPayActivity> implements RadioGroup.OnCheckedChangeListener {
    public static String AUTO_PAY_AGREEMENT_JUMP_URL = "https://tieba.baidu.com/tb/viprenew_eula_mobile.html";
    public static String LAW_JUMP_URL = "https://tieba.baidu.com/tb/eula_mobile.html?";
    public static String MEMBER_AGREEMENT_JUMP_URL = "https://tieba.baidu.com/tb/vip_eula_mobile.html";
    public int fromScene;
    public String mClickZone;
    public int mCurrentShowType;
    public int mFrom;
    public boolean mIsClose;
    public MemberPayView mMemberPayView;
    public PayConfigModel mPayConfigModel;
    public String mReferPage;
    public String mSceneId;
    public String mStType;
    public int mWantedMemberType;
    public boolean mLoadFinished = false;
    public Boolean mIsPayDialog = Boolean.FALSE;
    public String MEMBER_PAY_VISIT = "c10482";
    public String MEMBER_PAY_CLICK = "c10483";
    public HttpMessageListener mGetMemberPayinfoListener = new a(CmdConfigHttp.GETPAYINFO_CMD);
    public HttpMessageListener mRequestMemberPayInfoListener = new b(CmdConfigHttp.MEMBER_PAY_CMD);
    public final CustomMessageListener mAutoPaySuccListener = new c(2016525);
    public NoNetworkView.b mNetworkChangeListener = new e();

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
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
                        MemberPayActivity.this.addPaySussStats();
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001194, Integer.valueOf(MemberPayActivity.this.mCurrentShowType)));
                        MemberPayActivity.this.setResult(-1);
                        d.a.m0.r.d0.b.j().t("show_member_deid_line", true);
                        if (MemberPayActivity.this.mIsClose) {
                            MemberPayActivity.this.closeActivity();
                        } else {
                            MemberPayActivity.this.requestMemberPayInfo();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends HttpMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            MemberPayActivity.this.closeLoadingDialog();
            if ((httpResponsedMessage instanceof ResponseMemberPayMessage) && httpResponsedMessage.getCmd() == 1001532) {
                ResponseMemberPayMessage responseMemberPayMessage = (ResponseMemberPayMessage) httpResponsedMessage;
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (responseMemberPayMessage.getMemberPayResult() != null) {
                        MemberPayActivity.this.mMemberPayView.setDataAndRefreshUI(responseMemberPayMessage.getMemberPayResult());
                        MemberPayActivity.this.mLoadFinished = true;
                        return;
                    }
                    MemberPayActivity.this.showToast(R.string.neterror);
                    return;
                }
                String errorString = responseMemberPayMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = MemberPayActivity.this.getResources().getString(R.string.neterror);
                }
                MemberPayActivity.this.showToast(errorString);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2016525 || MemberPayActivity.this.mMemberPayView == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            MemberPayActivity.this.mMemberPayView.g(((Boolean) customResponsedMessage.getData()).booleanValue());
            MemberPayActivity.this.showToast(R.string.tips_auto_pay_succ);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.m0.l0.a {
        public d() {
        }

        @Override // d.a.m0.l0.a
        public void a() {
            d.a.m0.l0.d c2 = d.a.m0.l0.d.c();
            c2.b("http://tieba.baidu.com/mo/q/tbeantshow?refer_page=" + MemberPayActivity.this.mReferPage + "&click_zone=" + MemberPayActivity.this.mClickZone, MemberPayActivity.this.getPageContext());
            MemberPayActivity.this.finish();
        }

        @Override // d.a.m0.l0.a
        public void b() {
            MemberPayActivity.this.requestMemberPayInfo();
        }

        @Override // d.a.m0.l0.a
        public void onError(String str) {
            MemberPayActivity.this.requestMemberPayInfo();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements NoNetworkView.b {
        public e() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (!z || MemberPayActivity.this.mLoadFinished) {
                return;
            }
            MemberPayActivity.this.requestMemberPayInfo();
        }
    }

    private void addClickPayBtnStats() {
        int i2 = this.mFrom;
        if (i2 == 2) {
            TiebaStatic.log(TbadkCoreStatisticKey.FRS_EXPERIENCE_SPEED_BUY_MEMBER);
        } else if (i2 == 1) {
            addStat("consume_4");
        } else if (i2 == 7) {
            TiebaStatic.log(TbadkCoreStatisticKey.BUBBLE_PAY_MEMBER_CLICK);
        } else if (i2 == 6) {
            TiebaStatic.log("consume_25");
        } else if (i2 == 8) {
            TiebaStatic.log("c10216");
        } else if (i2 == 9) {
            TiebaStatic.log("c10217");
        } else if (i2 == 10) {
            TiebaStatic.log("c10218");
        } else if (i2 == 11) {
            TiebaStatic.log("c10219");
        } else if (i2 == 12) {
            TiebaStatic.log("c10222");
        } else if (i2 == 13) {
            TiebaStatic.log("c10223");
        } else if (i2 == 14) {
            TiebaStatic.log("c10224");
        } else if (i2 == 16) {
            addStat("c10476");
        } else if (i2 == 15) {
            addStat("c10440");
        } else if (i2 == 21) {
            TiebaStatic.log(new StatisticItem("c11216").param("uid", TbadkCoreApplication.getCurrentAccount()));
        } else if (i2 == 4) {
            TiebaStatic.log("c10763");
        } else if (i2 == 5) {
            TiebaStatic.log("c10753");
        } else if (i2 == 18) {
            TiebaStatic.log("c10766");
        } else if (i2 == 19) {
            TiebaStatic.log("c10765");
        } else if (i2 == 20) {
            TiebaStatic.log("c11142");
        } else if (i2 != 0 || StringUtils.isNull(this.mStType)) {
        } else {
            TiebaStatic.log(this.mStType);
        }
    }

    private void addOpenPageStats() {
        int i2 = this.mFrom;
        if (i2 == 6) {
            TiebaStatic.log("consume_24");
        } else if (i2 == 2) {
            TiebaStatic.log(TbadkCoreStatisticKey.FRS_EXPERIENCE_SPEED);
        } else if (i2 == 4) {
            TiebaStatic.log("c10751");
        } else if (i2 == 5) {
            TiebaStatic.log("c10750");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPaySussStats() {
        int i2 = this.mFrom;
        if (i2 == 2) {
            addStat("consume_10");
        } else if (i2 == 1) {
            addStat("consume_5");
        } else if (i2 == 3) {
            addStat("consume_35");
        } else if (i2 == 4) {
            TiebaStatic.log("c10032");
        } else if (i2 == 5) {
            TiebaStatic.log("c10039");
        } else if (i2 == 6) {
            TiebaStatic.log(TbadkCoreStatisticKey.TAIL_PAY_MEMBER_SUCCESS);
        } else if (i2 == 7) {
            TiebaStatic.log(TbadkCoreStatisticKey.BUBBLE_PAY_MEMBER_SUCCESS);
        }
    }

    private void addStat(String str) {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), str, PrefetchEvent.STATE_CLICK);
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
        int i2 = this.fromScene;
        if (i2 == 3) {
            this.mSceneId = "4001001001";
        } else if (i2 == 4) {
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
        PayConfigModel payConfigModel = new PayConfigModel(this, new d());
        this.mPayConfigModel = payConfigModel;
        payConfigModel.x();
    }

    private void initListener() {
        registerListener(this.mRequestMemberPayInfoListener);
        registerListener(this.mGetMemberPayinfoListener);
        registerListener(this.mAutoPaySuccListener);
        MemberPayView memberPayView = this.mMemberPayView;
        if (memberPayView == null || memberPayView.getNoNetworkView() == null) {
            return;
        }
        this.mMemberPayView.getNoNetworkView().a(this.mNetworkChangeListener);
    }

    private void initView() {
        showLoadingDialog(getPageContext().getString(R.string.flist_loading));
        this.mMemberPayView = new MemberPayView(this, this.mWantedMemberType, this.mIsPayDialog.booleanValue());
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

    public String getClickZone() {
        return this.mClickZone;
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.m0.k0.a
    public String getCurrentPageKey() {
        return "b001";
    }

    public int getFrom() {
        return this.mFrom;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public d.a.m0.k0.d getPageStayDurationItem() {
        d.a.m0.k0.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.f49436a = true;
        }
        return pageStayDurationItem;
    }

    public String getReferPage() {
        return this.mReferPage;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        MemberPayView memberPayView = this.mMemberPayView;
        if (memberPayView != null) {
            memberPayView.f(i2);
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i2) {
        MemberPayView memberPayView = this.mMemberPayView;
        if (memberPayView == null) {
            return;
        }
        if (i2 == R.id.btn_mem1) {
            memberPayView.k(2);
        } else if (i2 == R.id.btn_mem2) {
            memberPayView.k(1);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == R.id.aotu_pay_law) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{LAW_JUMP_URL + TbadkCoreApplication.getCurrentVerson(getPageContext().getPageActivity())});
        }
        if (view.getId() == R.id.tv_member_agreement_normal || view.getId() == R.id.tv_member_agreement_auto_pay) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{MEMBER_AGREEMENT_JUMP_URL});
        }
        if (view.getId() == R.id.tv_auto_pay_agreement_auto_pay) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{AUTO_PAY_AGREEMENT_JUMP_URL});
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaStatic.log(this.MEMBER_PAY_VISIT);
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getActivity());
            finish();
            return;
        }
        handleIntent();
        u consumePathData = TbadkCoreApplication.getInst().getConsumePathData();
        if (consumePathData != null) {
            this.mIsPayDialog = Boolean.valueOf(consumePathData.b(1, this.mSceneId));
        }
        initView();
        initListener();
        initData();
        addOpenPageStats();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MemberPayView memberPayView = this.mMemberPayView;
        if (memberPayView != null && memberPayView.getNoNetworkView() != null) {
            this.mMemberPayView.getNoNetworkView().d(this.mNetworkChangeListener);
        }
        PayConfigModel payConfigModel = this.mPayConfigModel;
        if (payConfigModel != null) {
            payConfigModel.onDestroy();
        }
        super.onDestroy();
    }
}
