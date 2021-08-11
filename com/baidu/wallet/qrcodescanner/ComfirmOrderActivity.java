package com.baidu.wallet.qrcodescanner;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.qrcodescanner.datamodel.QRCodeShortUrlResponse;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class ComfirmOrderActivity extends BeanActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static a f63180g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public QRCodeShortUrlResponse.OrderParam f63181a;

    /* renamed from: b  reason: collision with root package name */
    public Button f63182b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f63183c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f63184d;

    /* renamed from: e  reason: collision with root package name */
    public String f63185e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f63186f;

    /* loaded from: classes8.dex */
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
            f63180g = aVar;
            intent.setClass(context, ComfirmOrderActivity.class);
            intent.putExtra("orderinfo", orderParam);
            intent.putExtra(IMConstants.SERVICE_TYPE_ORDER, str);
            context.startActivity(intent);
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.f63181a == null) {
            return;
        }
        TextView textView = this.f63183c;
        textView.setText(ResUtils.getString(getActivity(), "wallet_base_unit") + StringUtils.fen2Yuan(this.f63181a.total_amount));
        this.f63184d.setText(this.f63181a.goods_name);
        this.f63186f.setText(this.f63181a.sp_name);
    }

    public static void onOrderComfirm(boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65539, null, z) == null) || (aVar = f63180g) == null) {
            return;
        }
        if (!z) {
            aVar.b();
        } else {
            aVar.a();
        }
        f63180g = null;
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
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) && view == this.f63182b) {
            LocalRouter.getInstance(getActivity()).route(getActivity(), new RouterRequest().provider("dxmPay").action("enterDoPayWithParams").data("orderInfo", this.f63185e).data("showDialog", Boolean.TRUE), new RouterCallback(this) { // from class: com.baidu.wallet.qrcodescanner.ComfirmOrderActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ComfirmOrderActivity f63187a;

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
                    this.f63187a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                        if (i2 == 0) {
                            if (hashMap == null || hashMap.size() <= 0) {
                                return;
                            }
                            int intValue = ((Integer) hashMap.get("statusCode")).intValue();
                            String str = (String) hashMap.get("payDesc");
                            if (intValue == 0) {
                                this.f63187a.finish();
                                ComfirmOrderActivity.onOrderComfirm(true);
                                return;
                            }
                            this.f63187a.finish();
                            ComfirmOrderActivity.onOrderComfirm(false);
                            return;
                        }
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("provider", "dxmPay");
                        hashMap2.put("action", "enterDoPayWithParams");
                        hashMap2.put("errMsg", (String) hashMap.get("errorMsg"));
                        DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
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
                Bundle bundle2 = bundle.getBundle("saveInfo");
                bundle2.setClassLoader(getClassLoader());
                Serializable serializable = bundle2.getSerializable("orderinfo");
                if (serializable != null && (serializable instanceof QRCodeShortUrlResponse.OrderParam)) {
                    this.f63181a = (QRCodeShortUrlResponse.OrderParam) serializable;
                }
                this.f63185e = bundle.getString(IMConstants.SERVICE_TYPE_ORDER);
            } else if (getIntent() != null) {
                Serializable serializableExtra = getIntent().getSerializableExtra("orderinfo");
                if (serializableExtra != null && (serializableExtra instanceof QRCodeShortUrlResponse.OrderParam)) {
                    this.f63181a = (QRCodeShortUrlResponse.OrderParam) serializableExtra;
                }
                this.f63185e = getIntent().getStringExtra(IMConstants.SERVICE_TYPE_ORDER);
            }
            this.f63183c = (TextView) findViewById(ResUtils.id(getActivity(), "wallet_order_price"));
            this.f63184d = (TextView) findViewById(ResUtils.id(getActivity(), "wallet_order_sp"));
            this.f63186f = (TextView) findViewById(ResUtils.id(getActivity(), "wallet_order_pay"));
            Button button = (Button) findViewById(ResUtils.id(getActivity(), "ebpay_to_pay"));
            this.f63182b = button;
            button.setOnClickListener(this);
            a();
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("orderinfo", this.f63181a);
            bundle2.putString(IMConstants.SERVICE_TYPE_ORDER, this.f63185e);
            bundle.putBundle("saveInfo", bundle2);
            super.onSaveInstanceState(bundle);
        }
    }
}
