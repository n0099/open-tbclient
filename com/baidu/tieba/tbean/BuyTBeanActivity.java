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
import com.repackage.dm8;
import com.repackage.nr4;
import com.repackage.s85;
import com.repackage.u85;
import com.repackage.v85;
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
    public dm8 mTBeanView;
    public float moneyLeft;
    public CustomMessageListener roomClosedListener;

    /* loaded from: classes4.dex */
    public class a implements s85 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyTBeanActivity a;

        public a(BuyTBeanActivity buyTBeanActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyTBeanActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = buyTBeanActivity;
        }

        @Override // com.repackage.s85
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v85.c().b(String.format("http://tieba.baidu.com/mo/q/tbeanget?difference=%1$s&fr=0&return_type=1&return_url=%2$s", String.valueOf(this.a.mGiftBbean), u85.a) + "&refer_page=" + this.a.mReferPage + "&click_zone=" + this.a.mClickZone, this.a.getPageContext());
                this.a.finish();
            }
        }

        @Override // com.repackage.s85
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.mModel.L();
            }
        }

        @Override // com.repackage.s85
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.a.mModel.L();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyTBeanActivity a;

        public b(BuyTBeanActivity buyTBeanActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyTBeanActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = buyTBeanActivity;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyTBeanActivity a;

        public c(BuyTBeanActivity buyTBeanActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyTBeanActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = buyTBeanActivity;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyTBeanActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(BuyTBeanActivity buyTBeanActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyTBeanActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = buyTBeanActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.a.isFromDecreaseGiftStepStrategy == 1 || this.a.isFromDecreaseGiftStepStrategy == 2 || this.a.isFromDecreaseGiftStepStrategy == 3) {
                    this.a.closeActivity();
                }
            }
        }
    }

    public BuyTBeanActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            nr4 nr4Var = new nr4(this);
            nr4Var.setAutoNight(true);
            nr4Var.setCancelable(true);
            nr4Var.setTitleShowCenter(true);
            nr4Var.setMessageShowCenter(true);
            nr4Var.setTitle(getString(R.string.obfuscated_res_0x7f0f0358));
            nr4Var.setMessage(getString(R.string.obfuscated_res_0x7f0f0357));
            nr4Var.setPositiveButton(getString(R.string.obfuscated_res_0x7f0f07b3), new b(this));
            nr4Var.setNegativeButton(getString(R.string.obfuscated_res_0x7f0f0356), new c(this));
            nr4Var.create(getPageContext()).show();
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
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (intent == null || !intent.getBooleanExtra("success", false)) {
                return;
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        dm8 dm8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || (dm8Var = this.mTBeanView) == null) {
            return;
        }
        dm8Var.B(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        dm8 dm8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            if (view2.getId() != R.id.obfuscated_res_0x7f09047e && view2.getId() != R.id.obfuscated_res_0x7f091e79) {
                if ((view2.getId() == R.id.obfuscated_res_0x7f090468 || view2.getId() == R.id.obfuscated_res_0x7f09047b) && (dm8Var = this.mTBeanView) != null) {
                    if (dm8Var.A()) {
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
            showLoadingDialog(getPageContext().getString(R.string.obfuscated_res_0x7f0f0627));
            dm8 dm8Var = new dm8(this);
            this.mTBeanView = dm8Var;
            setContentView(dm8Var.v());
            if (this.isFromDecreaseGiftStepStrategy != 0) {
                float f = this.moneyLeft;
                if (f > 0.0f) {
                    this.mTBeanView.H(f);
                }
            }
            this.mTBeanView.x();
            BuyTBeanModel buyTBeanModel = new BuyTBeanModel(this, this);
            this.mModel = buyTBeanModel;
            buyTBeanModel.K();
            this.mModel.J();
            this.mModel.I();
            this.mModel.H();
            PayConfigModel payConfigModel = new PayConfigModel(this, new a(this));
            this.mPayConfigModel = payConfigModel;
            payConfigModel.D();
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
            dm8 dm8Var = this.mTBeanView;
            if (dm8Var != null) {
                dm8Var.C();
            }
        }
    }

    @Override // com.baidu.tieba.tbean.BuyTBeanModel.e
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            showToast(str);
            closeLoadingDialog();
            dm8 dm8Var = this.mTBeanView;
            if (dm8Var != null) {
                dm8Var.J();
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
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i, keyEvent)) == null) {
            if (i == 4) {
                processClose();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            dm8 dm8Var = this.mTBeanView;
            if (dm8Var != null) {
                dm8Var.D(z);
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
            dm8 dm8Var = this.mTBeanView;
            if (dm8Var != null) {
                dm8Var.J();
                this.mTBeanView.w();
                this.mTBeanView.G(this.mModel.D(), this.mModel.F(), this.mModel.E(), this.mModel.G());
            }
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || this.mModel == null || this.mTBeanView == null) {
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.obfuscated_res_0x7f0f0627));
        this.mTBeanView.x();
        this.mModel.L();
    }
}
