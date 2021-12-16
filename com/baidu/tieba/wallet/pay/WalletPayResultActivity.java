package com.baidu.tieba.wallet.pay;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.atomData.WalletPayResultActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.util.PageDialogHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class WalletPayResultActivity extends BaseActivity<WalletPayResultActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String PAY_RESULT_VISIT;
    public Boolean isPayDialog;
    public Handler mHandler;
    public PayConfig mPayData;
    public Boolean mPayResult;
    public IWalletPayResultView mView;
    public Runnable myTask;

    public WalletPayResultActivity() {
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
        Boolean bool = Boolean.FALSE;
        this.isPayDialog = bool;
        this.mPayResult = bool;
        this.mView = null;
        this.PAY_RESULT_VISIT = "c10484";
        this.myTask = new Runnable(this) { // from class: com.baidu.tieba.wallet.pay.WalletPayResultActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WalletPayResultActivity this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.setResult(-1, new Intent());
                    this.this$0.finish();
                }
            }
        };
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            if (this.mPayData.getPayType() == 1) {
                this.mView = new WalletPayResultView(this, this.mPayResult.booleanValue(), this.mPayData);
            } else if (this.mPayData.getPayType() == 2) {
                this.mView = new NewWalletPayResultView(this, this.mPayResult.booleanValue(), this.mPayData);
            }
        }
    }

    private void reBuyProduct() {
        PayConfig payConfig;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (payConfig = this.mPayData) == null) {
            return;
        }
        if (payConfig.getPayType() == 1) {
            Intent intent = new Intent();
            intent.putExtra("rebuy", true);
            setResult(-1, intent);
            finish();
        } else if (this.mPayData.getPayType() == 2) {
            Intent intent2 = new Intent();
            intent2.putExtra("rebuy", true);
            setResult(-1, intent2);
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            IWalletPayResultView iWalletPayResultView = this.mView;
            if (iWalletPayResultView != null) {
                iWalletPayResultView.onChangeSkinType(i2);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        PayConfig payConfig;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || (payConfig = this.mPayData) == null) {
            return;
        }
        if (payConfig.getPayType() == 2) {
            IWalletPayResultView iWalletPayResultView = this.mView;
            if (iWalletPayResultView instanceof NewWalletPayResultView) {
                NewWalletPayResultView newWalletPayResultView = (NewWalletPayResultView) iWalletPayResultView;
                if (this.mPayResult.booleanValue()) {
                    if (view == newWalletPayResultView.getLeftBtn()) {
                        sendMessage(new CustomMessage(2002001, new ConsumptionRecordsActivityConfig(this, 3)));
                        finish();
                        return;
                    } else if (view == newWalletPayResultView.getRightView()) {
                        setResult(-1, new Intent());
                        finish();
                        return;
                    } else {
                        return;
                    }
                } else if (view == newWalletPayResultView.getLeftBtn()) {
                    setResult(-1, new Intent());
                    finish();
                    return;
                } else if (view == newWalletPayResultView.getRightView()) {
                    reBuyProduct();
                    return;
                } else {
                    return;
                }
            }
        }
        if (view.getId() == R.id.pay_fail_rebuy_btn) {
            reBuyProduct();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            TiebaStatic.log(this.PAY_RESULT_VISIT);
            this.mPayResult = Boolean.valueOf(getIntent().getBooleanExtra(WalletPayResultActivityConfig.PAY_RESULT, false));
            this.isPayDialog = Boolean.valueOf(getIntent().getBooleanExtra(WalletPayResultActivityConfig.IS_DIALOG, false));
            PayConfig payConfig = (PayConfig) getIntent().getSerializableExtra(WalletPayResultActivityConfig.PAYDATA);
            this.mPayData = payConfig;
            if (payConfig.getPayType() == 1) {
                if (this.isPayDialog.booleanValue()) {
                    setTheme(16973835);
                    requestWindowFeature(1);
                } else {
                    setTheme(R.style.swipeback_activity_style);
                }
            } else if (this.mPayData.getPayType() == 2) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            initUI();
            if (this.mPayData.getPayType() == 1) {
                if (this.isPayDialog.booleanValue()) {
                    PageDialogHelper.a(getActivity());
                }
                if (this.isPayDialog.booleanValue()) {
                    findViewById(R.id.pay_result_bar).setVisibility(8);
                } else {
                    findViewById(R.id.tbean_dialog_wrapper).setVisibility(8);
                }
                this.mHandler = new Handler(Looper.getMainLooper());
                if (this.mPayResult.booleanValue()) {
                    this.mHandler.postDelayed(this.myTask, 5000L);
                }
            }
            ((ImageView) findViewById(R.id.tbean_dialog_close_btn)).setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.tieba.wallet.pay.WalletPayResultActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WalletPayResultActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.this$0.setResult(-1, new Intent());
                        this.this$0.finish();
                    }
                }
            });
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, keyEvent)) == null) {
            if (4 == i2) {
                setResult(-1, new Intent());
                finish();
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onStop();
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacks(this.myTask);
            }
        }
    }
}
