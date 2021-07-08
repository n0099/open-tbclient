package com.baidu.tieba.tbean;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.pay.PayConfigModel;
import com.baidu.tieba.R;
import com.baidu.tieba.tbean.BuyTBeanModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.s.a;
/* loaded from: classes4.dex */
public class BuyTBeanActivity extends BaseActivity<BuyTBeanActivity> implements BuyTBeanModel.e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GIFT_TBEAN = "gift_tbean";
    public transient /* synthetic */ FieldHolder $fh;
    public String SCENE_ID;
    public boolean isFromAlaLiveRoom;
    public int isFromDecreaseGiftStepStrategy;
    public String mClickZone;
    public float mGiftBbean;
    public boolean mIsPayDialog;
    public BuyTBeanModel mModel;
    public PayConfigModel mPayConfigModel;
    public String mReferPage;
    public d.a.p0.j3.a mTBeanView;
    public float moneyLeft;
    public CustomMessageListener roomClosedListener;

    /* loaded from: classes4.dex */
    public class a implements d.a.o0.l0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BuyTBeanActivity f21260a;

        public a(BuyTBeanActivity buyTBeanActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyTBeanActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21260a = buyTBeanActivity;
        }

        @Override // d.a.o0.l0.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.l0.d.c().b(String.format("http://tieba.baidu.com/mo/q/tbeanget?difference=%1$s&fr=0&return_type=1&return_url=%2$s", String.valueOf(this.f21260a.mGiftBbean), d.a.o0.l0.c.f52120a) + "&refer_page=" + this.f21260a.mReferPage + "&click_zone=" + this.f21260a.mClickZone, this.f21260a.getPageContext());
                this.f21260a.finish();
            }
        }

        @Override // d.a.o0.l0.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f21260a.mModel.J();
            }
        }

        @Override // d.a.o0.l0.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f21260a.mModel.J();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BuyTBeanActivity f21261e;

        public b(BuyTBeanActivity buyTBeanActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyTBeanActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21261e = buyTBeanActivity;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BuyTBeanActivity f21262e;

        public c(BuyTBeanActivity buyTBeanActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyTBeanActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21262e = buyTBeanActivity;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f21262e.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BuyTBeanActivity f21263a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(BuyTBeanActivity buyTBeanActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyTBeanActivity, Integer.valueOf(i2)};
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
            this.f21263a = buyTBeanActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.f21263a.isFromDecreaseGiftStepStrategy == 1 || this.f21263a.isFromDecreaseGiftStepStrategy == 2 || this.f21263a.isFromDecreaseGiftStepStrategy == 3) {
                    this.f21263a.closeActivity();
                }
            }
        }
    }

    public BuyTBeanActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsPayDialog = true;
        this.SCENE_ID = "4001001000";
        this.isFromAlaLiveRoom = false;
        this.isFromDecreaseGiftStepStrategy = 0;
        this.moneyLeft = 0.0f;
        this.roomClosedListener = new d(this, 2921407);
    }

    private void getGiftTBean(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, intent) == null) {
            this.mGiftBbean = intent.getFloatExtra("gift_tbean", 0.0f);
        }
    }

    private void processClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(this);
            aVar.setAutoNight(true);
            aVar.setCancelable(true);
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.setTitle(getString(R.string.buy_tbean_exit_dialog_title));
            aVar.setMessage(getString(R.string.buy_tbean_exit_dialog_sub_title));
            aVar.setPositiveButton(getString(R.string.go_on), new b(this));
            aVar.setNegativeButton(getString(R.string.buy_tbean_exit_dialog_quit), new c(this));
            aVar.create(getPageContext()).show();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            clearAnimatable();
            clearAnimation();
            overridePendingTransition(0, 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            clearAnimatable();
            clearAnimation();
            overridePendingTransition(0, 0);
        }
    }

    public String getClickZone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mClickZone : (String) invokeV.objValue;
    }

    public String getReferPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mReferPage : (String) invokeV.objValue;
    }

    public boolean isFromAlaLiveRoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.isFromAlaLiveRoom : invokeV.booleanValue;
    }

    public int isFromDecreaseGiftStepStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.isFromDecreaseGiftStepStrategy : invokeV.intValue;
    }

    public boolean isPayDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mIsPayDialog : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (intent == null || !intent.getBooleanExtra("success", false)) {
                return;
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        d.a.p0.j3.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (aVar = this.mTBeanView) == null) {
            return;
        }
        aVar.B(i2);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.p0.j3.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            if (view.getId() != R.id.buy_tbean_use_rule && view.getId() != R.id.t_dou_introduce_activity_right_button) {
                if ((view.getId() == R.id.buy_tbean_close_image || view.getId() == R.id.buy_tbean_root_view) && (aVar = this.mTBeanView) != null) {
                    if (aVar.A()) {
                        this.mTBeanView.y();
                        return;
                    } else {
                        processClose();
                        return;
                    }
                }
                return;
            }
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            getIntent().getStringExtra("scene_id");
            this.mReferPage = getIntent().getStringExtra(MemberPayStatistic.REFER_PAGE);
            this.mClickZone = getIntent().getStringExtra(MemberPayStatistic.CLICK_ZONE);
            this.isFromAlaLiveRoom = getIntent().getBooleanExtra(BuyTBeanActivityConfig.IS_FROM_ALA, false);
            this.isFromDecreaseGiftStepStrategy = getIntent().getIntExtra(BuyTBeanActivityConfig.IS_FROM_ALA_GIFT_PANEL, 0);
            this.moneyLeft = (float) getIntent().getLongExtra(BuyTBeanActivityConfig.TBEAN_LEFT_TO_BUY_ALA_GIFT, 0L);
            this.isFromAlaLiveRoom = false;
            setIsAddSwipeBackLayout(false);
            setUseStyleImmersiveSticky(false);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            super.onCreate(bundle);
            if (bundle != null) {
                this.mGiftBbean = (float) bundle.getLong("gift_tbean");
            }
            getGiftTBean(getIntent());
            showLoadingDialog(getPageContext().getString(R.string.flist_loading));
            d.a.p0.j3.a aVar = new d.a.p0.j3.a(this);
            this.mTBeanView = aVar;
            setContentView(aVar.v());
            if (this.isFromDecreaseGiftStepStrategy != 0) {
                float f2 = this.moneyLeft;
                if (f2 > 0.0f) {
                    this.mTBeanView.H(f2);
                }
            }
            this.mTBeanView.x();
            BuyTBeanModel buyTBeanModel = new BuyTBeanModel(this, this);
            this.mModel = buyTBeanModel;
            buyTBeanModel.I();
            this.mModel.H();
            this.mModel.G();
            this.mModel.F();
            PayConfigModel payConfigModel = new PayConfigModel(this, new a(this));
            this.mPayConfigModel = payConfigModel;
            payConfigModel.B();
            registerListener(this.roomClosedListener);
            TiebaStatic.log("c10295");
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            clearAnimatable();
            clearAnimation();
            super.onDestroy();
            d.a.p0.j3.a aVar = this.mTBeanView;
            if (aVar != null) {
                aVar.C();
            }
        }
    }

    @Override // com.baidu.tieba.tbean.BuyTBeanModel.e
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            showToast(str);
            closeLoadingDialog();
            d.a.p0.j3.a aVar = this.mTBeanView;
            if (aVar != null) {
                aVar.J();
                this.mTBeanView.I();
            }
        }
    }

    @Override // com.baidu.tieba.tbean.BuyTBeanModel.e
    public void onGetWalletUrl(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2001447, str));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                processClose();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            d.a.p0.j3.a aVar = this.mTBeanView;
            if (aVar != null) {
                aVar.D(z);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            refresh();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putFloat("gift_tbean", this.mGiftBbean);
        }
    }

    @Override // com.baidu.tieba.tbean.BuyTBeanModel.e
    public void onSuccess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            closeLoadingDialog();
            d.a.p0.j3.a aVar = this.mTBeanView;
            if (aVar != null) {
                aVar.J();
                this.mTBeanView.w();
                this.mTBeanView.G(this.mModel.B(), this.mModel.D(), this.mModel.C(), this.mModel.E());
            }
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || this.mModel == null || this.mTBeanView == null) {
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.flist_loading));
        this.mTBeanView.x();
        this.mModel.J();
    }
}
