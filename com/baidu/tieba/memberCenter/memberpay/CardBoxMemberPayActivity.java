package com.baidu.tieba.memberCenter.memberpay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.p0.d;
import c.a.r0.y1.f.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.PageDialogHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class CardBoxMemberPayActivity extends BaseActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static String MEMBER_AGREEMENT_JUMP_URL = "https://tieba.baidu.com/tb/vip_eula_mobile.html";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAnimateRunning;
    public String mClickZone;
    public CustomMessageListener mCloseListener;
    public boolean mHasShowAnim;
    public String mPackedId;
    public String mReferPage;
    public HttpMessageListener mRequestMemberPayInfoListener;
    public c.a.r0.y1.f.a mView;

    /* loaded from: classes7.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CardBoxMemberPayActivity f54359a;

        public a(CardBoxMemberPayActivity cardBoxMemberPayActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardBoxMemberPayActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54359a = cardBoxMemberPayActivity;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f54359a.mAnimateRunning = false;
                this.f54359a.finish();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CardBoxMemberPayActivity f54360a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CardBoxMemberPayActivity cardBoxMemberPayActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardBoxMemberPayActivity, Integer.valueOf(i2)};
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
            this.f54360a = cardBoxMemberPayActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.f54360a.closeLoadingDialog();
                if (httpResponsedMessage instanceof ResponseCardBoxMemberPayMessage) {
                    ResponseCardBoxMemberPayMessage responseCardBoxMemberPayMessage = (ResponseCardBoxMemberPayMessage) httpResponsedMessage;
                    if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                        if (responseCardBoxMemberPayMessage.getMemberPayResult() != null) {
                            this.f54360a.mView.m(responseCardBoxMemberPayMessage.getMemberPayResult());
                            return;
                        }
                        this.f54360a.showToast(R.string.neterror);
                        return;
                    }
                    String errorString = responseCardBoxMemberPayMessage.getErrorString();
                    if (StringUtils.isNull(errorString)) {
                        errorString = this.f54360a.getResources().getString(R.string.neterror);
                    }
                    this.f54360a.showToast(errorString);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CardBoxMemberPayActivity f54361a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CardBoxMemberPayActivity cardBoxMemberPayActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardBoxMemberPayActivity, Integer.valueOf(i2)};
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
            this.f54361a = cardBoxMemberPayActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.hasError()) {
                return;
            }
            this.f54361a.finish();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(338331430, "Lcom/baidu/tieba/memberCenter/memberpay/CardBoxMemberPayActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(338331430, "Lcom/baidu/tieba/memberCenter/memberpay/CardBoxMemberPayActivity;");
        }
    }

    public CardBoxMemberPayActivity() {
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
        this.mHasShowAnim = false;
        this.mAnimateRunning = false;
        this.mRequestMemberPayInfoListener = new b(this, CmdConfigHttp.CARD_BOX_MEMBER_PAY_CMD);
        this.mCloseListener = new c(this, 2016526);
    }

    private void hideAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mAnimateRunning = true;
            this.mView.e().setBackgroundColor(SkinManager.getColor(R.color.common_color_10175));
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            this.mView.e().startAnimation(alphaAnimation);
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_down);
            loadAnimation.setDuration(300L);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new a(this));
            this.mView.g().startAnimation(loadAnimation);
        }
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, bundle) == null) {
            if (bundle != null) {
                this.mPackedId = bundle.getString(CardBoxMemberPayActivityConfig.PACKET_ID);
                this.mReferPage = bundle.getString(MemberPayStatistic.REFER_PAGE);
                this.mClickZone = bundle.getString(MemberPayStatistic.CLICK_ZONE);
            } else {
                Intent intent = getIntent();
                this.mPackedId = intent.getStringExtra(CardBoxMemberPayActivityConfig.PACKET_ID);
                this.mReferPage = intent.getStringExtra(MemberPayStatistic.REFER_PAGE);
                this.mClickZone = intent.getStringExtra(MemberPayStatistic.CLICK_ZONE);
            }
            registerListener(this.mRequestMemberPayInfoListener);
            registerListener(this.mCloseListener);
            registerGetMemberPayInfoTask();
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.mView = new c.a.r0.y1.f.a(this);
        }
    }

    private void registerGetMemberPayInfoTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CARD_BOX_MEMBER_PAY_CMD, TbConfig.SERVER_ADDRESS + TbConfig.CARD_BOX_MEMBER_PAY);
            tbHttpMessageTask.setResponsedClass(ResponseCardBoxMemberPayMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    private void requestMemberPayInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CARD_BOX_MEMBER_PAY_CMD);
            httpMessage.addParam(CardBoxMemberPayActivityConfig.PACKET_ID, this.mPackedId);
            sendMessage(httpMessage);
        }
    }

    private void showAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.mView.e().setBackgroundColor(SkinManager.getColor(R.color.common_color_10175));
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
            alphaAnimation.setDuration(300L);
            this.mView.e().startAnimation(alphaAnimation);
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_up);
            loadAnimation.setDuration(300L);
            loadAnimation.setFillAfter(true);
            this.mView.g().startAnimation(loadAnimation);
            this.mHasShowAnim = true;
        }
    }

    private void startDealIntentService(long j2, long j3, long j4, int i2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i2)}) == null) {
            PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j2), String.valueOf(j3), String.valueOf(j4), true, false, PageDialogHelper.PayForm.NOT_SET, this.mReferPage, this.mClickZone);
            payConfig.setFrom(4);
            c.a.r0.y1.f.a aVar = this.mView;
            if (aVar == null || aVar.i() == null) {
                str = "";
            } else {
                payConfig.setTitle(this.mView.i());
                str = this.mView.r;
            }
            payConfig.setOrderName(getPageContext().getPageActivity().getString(R.string.member_month, new Object[]{String.valueOf(j4)}));
            payConfig.setAutoPay(i2);
            payConfig.setPropsMon(String.valueOf(j4));
            payConfig.paymentPosKey = str;
            d.c().a(payConfig, getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.mAnimateRunning) {
            return;
        }
        hideAnimation();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            closeActivity();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mView.j(i2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.r0.y1.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || (aVar = this.mView) == null) {
            return;
        }
        if (view == aVar.h() && this.mView.d() != null) {
            f.d d2 = this.mView.d();
            startDealIntentService(d2.f28868i, d2.f28869j / 100, d2.l, d2.n);
        } else if (view == this.mView.f()) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{MEMBER_AGREEMENT_JUMP_URL});
        } else if (view == this.mView.e()) {
            closeActivity();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            requestWindowFeature(1);
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            setActivityBgTransparent();
            initData(bundle);
            initUI();
            requestMemberPayInfo();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z || this.mHasShowAnim) {
                return;
            }
            showAnimation();
        }
    }
}
