package com.baidu.wallet.scheme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class WalletSchemeActivity extends PayBaseBeanActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String order;

    /* loaded from: classes5.dex */
    public static class SchemeOrder implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -237137357302783447L;
        public transient /* synthetic */ FieldHolder $fh;
        public Orderinfo kBWParameters;

        /* loaded from: classes5.dex */
        public static class Orderinfo implements NoProguard, Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 7620618282105798227L;
            public transient /* synthetic */ FieldHolder $fh;
            public String kBWPayInfoOrder;

            public Orderinfo() {
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
        }

        public SchemeOrder() {
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
    }

    public WalletSchemeActivity() {
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

    private void a(Intent intent) {
        Uri uri;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, intent) == null) {
            if (intent == null) {
                finish();
                return;
            }
            try {
                uri = intent.getData();
            } catch (Exception unused) {
                uri = null;
            }
            if (uri == null) {
                finish();
                return;
            }
            String fragment = uri.getFragment();
            if (fragment == null) {
                finish();
                return;
            }
            String replace = fragment.replace("www.baifubao.com/pay#", "").replace("www.dxmpay.com/pay#", "");
            LogUtil.d("King", "fragment: " + uri.getFragment());
            LogUtil.d("King", "scheme: " + uri.getScheme());
            LogUtil.d("King", "scheme specific part : " + uri.getSchemeSpecificPart());
            LogUtil.d("King", "path : " + uri.getPath());
            LogUtil.d("King", "last path segment : " + uri.getLastPathSegment());
            LogUtil.d("King", "host : " + uri.getHost());
            LogUtil.d("King", "uri : " + uri.toString());
            if (TextUtils.isEmpty(replace)) {
                finish();
                return;
            }
            try {
                String str = new String(Base64Utils.decode(replace));
                if (TextUtils.isEmpty(str)) {
                    finish();
                    return;
                }
                SchemeOrder schemeOrder = (SchemeOrder) JsonUtils.fromJson(str, SchemeOrder.class);
                if (schemeOrder == null || schemeOrder.kBWParameters == null || TextUtils.isEmpty(schemeOrder.kBWParameters.kBWPayInfoOrder)) {
                    return;
                }
                BaiduPayDelegate.getInstance().doPay(this, schemeOrder.kBWParameters.kBWPayInfoOrder, null);
                finish();
            } catch (Exception unused2) {
                finish();
            }
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, obj, str) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            a(getIntent());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) {
            super.onNewIntent(intent);
            a(intent);
        }
    }
}
