package com.baidu.tieba.memberCenter.memberpay;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.t.c.v;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class MemberPayActivity extends BaseActivity<MemberPayActivity> implements RadioGroup.OnCheckedChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static String AUTO_PAY_AGREEMENT_JUMP_URL = "https://tieba.baidu.com/tb/viprenew_eula_mobile.html";
    public static String LAW_JUMP_URL = "https://tieba.baidu.com/tb/eula_mobile.html?";
    public static String MEMBER_AGREEMENT_JUMP_URL = "https://tieba.baidu.com/tb/vip_eula_mobile.html";
    public transient /* synthetic */ FieldHolder $fh;
    public String MEMBER_PAY_CLICK;
    public String MEMBER_PAY_VISIT;
    public int fromScene;
    public final CustomMessageListener mAutoPaySuccListener;
    public String mClickZone;
    public int mCurrentShowType;
    public int mFrom;
    public HttpMessageListener mGetMemberPayinfoListener;
    public boolean mIsClose;
    public Boolean mIsPayDialog;
    public boolean mLoadFinished;
    public MemberPayView mMemberPayView;
    public NoNetworkView.b mNetworkChangeListener;
    public PayConfigModel mPayConfigModel;
    public String mReferPage;
    public HttpMessageListener mRequestMemberPayInfoListener;
    public String mSceneId;
    public String mStType;
    public int mWantedMemberType;

    /* loaded from: classes9.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MemberPayActivity f51554a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MemberPayActivity memberPayActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51554a = memberPayActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505 && (httpResponsedMessage instanceof ResponseGetPayinfoMessage)) {
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
                        this.f51554a.addPaySussStats();
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001194, Integer.valueOf(this.f51554a.mCurrentShowType)));
                        this.f51554a.setResult(-1);
                        b.a.q0.s.e0.b.j().t("show_member_deid_line", true);
                        if (this.f51554a.mIsClose) {
                            this.f51554a.closeActivity();
                        } else {
                            this.f51554a.requestMemberPayInfo();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MemberPayActivity f51555a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MemberPayActivity memberPayActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51555a = memberPayActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.f51555a.closeLoadingDialog();
                if ((httpResponsedMessage instanceof ResponseMemberPayMessage) && httpResponsedMessage.getCmd() == 1001532) {
                    ResponseMemberPayMessage responseMemberPayMessage = (ResponseMemberPayMessage) httpResponsedMessage;
                    if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                        if (responseMemberPayMessage.getMemberPayResult() != null) {
                            this.f51555a.mMemberPayView.setDataAndRefreshUI(responseMemberPayMessage.getMemberPayResult());
                            this.f51555a.mLoadFinished = true;
                            return;
                        }
                        this.f51555a.showToast(R.string.neterror);
                        return;
                    }
                    String errorString = responseMemberPayMessage.getErrorString();
                    if (StringUtils.isNull(errorString)) {
                        errorString = this.f51555a.getResources().getString(R.string.neterror);
                    }
                    this.f51555a.showToast(errorString);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MemberPayActivity f51556a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(MemberPayActivity memberPayActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51556a = memberPayActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2016525 || this.f51556a.mMemberPayView == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            this.f51556a.mMemberPayView.refreshAutoPayItemUI(((Boolean) customResponsedMessage.getData()).booleanValue());
            this.f51556a.showToast(R.string.tips_auto_pay_succ);
        }
    }

    /* loaded from: classes9.dex */
    public class d implements b.a.q0.p0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MemberPayActivity f51557a;

        public d(MemberPayActivity memberPayActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51557a = memberPayActivity;
        }

        @Override // b.a.q0.p0.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.q0.p0.d c2 = b.a.q0.p0.d.c();
                c2.b("http://tieba.baidu.com/mo/q/tbeantshow?refer_page=" + this.f51557a.mReferPage + "&click_zone=" + this.f51557a.mClickZone, this.f51557a.getPageContext());
                this.f51557a.finish();
            }
        }

        @Override // b.a.q0.p0.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f51557a.requestMemberPayInfo();
            }
        }

        @Override // b.a.q0.p0.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f51557a.requestMemberPayInfo();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MemberPayActivity f51558e;

        public e(MemberPayActivity memberPayActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51558e = memberPayActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && !this.f51558e.mLoadFinished) {
                this.f51558e.requestMemberPayInfo();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1354580849, "Lcom/baidu/tieba/memberCenter/memberpay/MemberPayActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1354580849, "Lcom/baidu/tieba/memberCenter/memberpay/MemberPayActivity;");
        }
    }

    public MemberPayActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLoadFinished = false;
        this.mIsPayDialog = Boolean.FALSE;
        this.MEMBER_PAY_VISIT = "c10482";
        this.MEMBER_PAY_CLICK = "c10483";
        this.mGetMemberPayinfoListener = new a(this, CmdConfigHttp.GETPAYINFO_CMD);
        this.mRequestMemberPayInfoListener = new b(this, CmdConfigHttp.MEMBER_PAY_CMD);
        this.mAutoPaySuccListener = new c(this, 2016525);
        this.mNetworkChangeListener = new e(this);
    }

    private void addClickPayBtnStats() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
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
    }

    private void addOpenPageStats() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPaySussStats() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
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
    }

    private void addStat(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, str) == null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), str, PrefetchEvent.STATE_CLICK);
        }
    }

    private void handleIntent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            if (getIntent() != null && getIntent().getExtras() != null) {
                this.mWantedMemberType = getIntent().getExtras().getInt("member_type");
                this.mStType = getIntent().getExtras().getString("st_type");
                this.mFrom = getIntent().getExtras().getInt("from", 0);
                this.mIsClose = getIntent().getExtras().getBoolean(IntentConfig.CLOSE);
                this.fromScene = getIntent().getExtras().getInt("from_scene", 0);
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
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            registerGetMemberPayInfoTask();
            PayConfigModel payConfigModel = new PayConfigModel(this, new d(this));
            this.mPayConfigModel = payConfigModel;
            payConfigModel.B();
        }
    }

    private void initListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            registerListener(this.mRequestMemberPayInfoListener);
            registerListener(this.mGetMemberPayinfoListener);
            registerListener(this.mAutoPaySuccListener);
            MemberPayView memberPayView = this.mMemberPayView;
            if (memberPayView == null || memberPayView.getNoNetworkView() == null) {
                return;
            }
            this.mMemberPayView.getNoNetworkView().addNetworkChangeListener(this.mNetworkChangeListener);
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            showLoadingDialog(getPageContext().getString(R.string.flist_loading));
            this.mMemberPayView = new MemberPayView(this, this.mWantedMemberType, this.mIsPayDialog.booleanValue());
        }
    }

    private void registerGetMemberPayInfoTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MEMBER_PAY_CMD, TbConfig.SERVER_ADDRESS + TbConfig.MEMBER_PAY);
            tbHttpMessageTask.setResponsedClass(ResponseMemberPayMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestMemberPayInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.MEMBER_PAY_CMD);
            String str = this.mStType;
            if (str != null) {
                httpMessage.addParam("st_type", str);
            }
            httpMessage.addParam("from_scene", this.fromScene);
            sendMessage(httpMessage);
        }
    }

    public String getClickZone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mClickZone : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, b.a.q0.o0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "b001" : (String) invokeV.objValue;
    }

    public int getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mFrom : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public b.a.q0.o0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            b.a.q0.o0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.f12779a = true;
            }
            return pageStayDurationItem;
        }
        return (b.a.q0.o0.d) invokeV.objValue;
    }

    public String getReferPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mReferPage : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onChangeSkinType(i2);
            MemberPayView memberPayView = this.mMemberPayView;
            if (memberPayView != null) {
                memberPayView.onChangeSkinType(i2);
            }
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i2) {
        MemberPayView memberPayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, radioGroup, i2) == null) || (memberPayView = this.mMemberPayView) == null) {
            return;
        }
        if (i2 == R.id.btn_mem1) {
            memberPayView.switchTab(2);
        } else if (i2 == R.id.btn_mem2) {
            memberPayView.switchTab(1);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
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
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            TiebaStatic.log(this.MEMBER_PAY_VISIT);
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(getActivity());
                finish();
                return;
            }
            handleIntent();
            v consumePathData = TbadkCoreApplication.getInst().getConsumePathData();
            if (consumePathData != null) {
                this.mIsPayDialog = Boolean.valueOf(consumePathData.b(1, this.mSceneId));
            }
            initView();
            initListener();
            initData();
            addOpenPageStats();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MemberPayView memberPayView = this.mMemberPayView;
            if (memberPayView != null && memberPayView.getNoNetworkView() != null) {
                this.mMemberPayView.getNoNetworkView().removeNetworkChangeListener(this.mNetworkChangeListener);
            }
            PayConfigModel payConfigModel = this.mPayConfigModel;
            if (payConfigModel != null) {
                payConfigModel.onDestroy();
            }
            super.onDestroy();
        }
    }
}
