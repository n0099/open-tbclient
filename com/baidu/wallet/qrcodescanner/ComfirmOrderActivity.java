package com.baidu.wallet.qrcodescanner;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pay.PayCallBack;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.qrcodescanner.datamodel.QRCodeShortUrlResponse;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class ComfirmOrderActivity extends BeanActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static a f27343g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public QRCodeShortUrlResponse.OrderParam f27344a;

    /* renamed from: b  reason: collision with root package name */
    public Button f27345b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27346c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f27347d;

    /* renamed from: e  reason: collision with root package name */
    public String f27348e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f27349f;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();
    }

    public ComfirmOrderActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void ComfirmScanOrderInfo(Context context, QRCodeShortUrlResponse.OrderParam orderParam, String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, context, orderParam, str, aVar) == null) {
            Intent intent = new Intent();
            f27343g = aVar;
            intent.setClass(context, ComfirmOrderActivity.class);
            intent.putExtra("orderinfo", orderParam);
            intent.putExtra(IMConstants.SERVICE_TYPE_ORDER, str);
            context.startActivity(intent);
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.f27344a == null) {
            return;
        }
        TextView textView = this.f27346c;
        textView.setText(ResUtils.getString(getActivity(), "wallet_base_unit") + StringUtils.fen2Yuan(this.f27344a.total_amount));
        this.f27347d.setText(this.f27344a.goods_name);
        this.f27349f.setText(this.f27344a.sp_name);
    }

    public static void onOrderComfirm(boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65539, null, z) == null) || (aVar = f27343g) == null) {
            return;
        }
        if (!z) {
            aVar.b();
        } else {
            aVar.a();
        }
        f27343g = null;
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, obj, str) == null) {
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            onOrderComfirm(false);
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) && view == this.f27345b) {
            BaiduPayDelegate.getInstance().doPay(getActivity(), this.f27348e, new PayCallBack(this) { // from class: com.baidu.wallet.qrcodescanner.ComfirmOrderActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ComfirmOrderActivity f27350a;

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
                    this.f27350a = this;
                }

                @Override // com.baidu.android.pay.PayCallBack
                public boolean isHideLoadingDialog() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // com.baidu.android.pay.PayCallBack
                public void onPayResult(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        if (i2 == 0) {
                            this.f27350a.finish();
                            ComfirmOrderActivity.onOrderComfirm(true);
                            return;
                        }
                        this.f27350a.finish();
                        ComfirmOrderActivity.onOrderComfirm(false);
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(ResUtils.layout(getActivity(), "wallet_qrscanner_confirm_pay"));
            initActionBar("wallet_confirm_order_title");
            if (bundle != null) {
                Serializable serializable = bundle.getSerializable("orderinfo");
                if (serializable != null && (serializable instanceof QRCodeShortUrlResponse.OrderParam)) {
                    this.f27344a = (QRCodeShortUrlResponse.OrderParam) serializable;
                }
                this.f27348e = bundle.getString(IMConstants.SERVICE_TYPE_ORDER);
            } else if (getIntent() != null) {
                Serializable serializableExtra = getIntent().getSerializableExtra("orderinfo");
                if (serializableExtra != null && (serializableExtra instanceof QRCodeShortUrlResponse.OrderParam)) {
                    this.f27344a = (QRCodeShortUrlResponse.OrderParam) serializableExtra;
                }
                this.f27348e = getIntent().getStringExtra(IMConstants.SERVICE_TYPE_ORDER);
            }
            this.f27346c = (TextView) findViewById(ResUtils.id(getActivity(), "wallet_order_price"));
            this.f27347d = (TextView) findViewById(ResUtils.id(getActivity(), "wallet_order_sp"));
            this.f27349f = (TextView) findViewById(ResUtils.id(getActivity(), "wallet_order_pay"));
            Button button = (Button) findViewById(ResUtils.id(getActivity(), "ebpay_to_pay"));
            this.f27345b = button;
            button.setOnClickListener(this);
            a();
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            bundle.putSerializable("orderinfo", this.f27344a);
            bundle.putString(IMConstants.SERVICE_TYPE_ORDER, this.f27348e);
            super.onSaveInstanceState(bundle);
        }
    }
}
