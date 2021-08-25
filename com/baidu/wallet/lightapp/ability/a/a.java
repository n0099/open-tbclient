package com.baidu.wallet.lightapp.ability.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends com.baidu.wallet.lightapp.ability.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f61379a;

    public a() {
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
        this.f61379a = false;
    }

    @Override // com.baidu.wallet.lightapp.ability.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? LightappBusinessClient.MTD_BINDCARD_INITIATIVE : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.ability.a
    public void a(Activity activity, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, iLightappInvokerCallback, str2) == null) {
            this.f61379a = false;
            String str3 = "";
            if (!TextUtils.isEmpty(str)) {
                try {
                    str = URLDecoder.decode(str, "gbk");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    try {
                        str3 = (String) jSONObject.get("orderInfo");
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    try {
                        this.f61379a = ((Boolean) jSONObject.get("showDialog")).booleanValue();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(activity)).route(activity, new RouterRequest().provider("dxmPay").action("enterDoInnerBind").data("showDialog", Boolean.valueOf(this.f61379a)).data("orderInfo", str3), new RouterCallback(this, iLightappInvokerCallback, str2) { // from class: com.baidu.wallet.lightapp.ability.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ILightappInvokerCallback f61380a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f61381b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f61382c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iLightappInvokerCallback, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61382c = this;
                    this.f61380a = iLightappInvokerCallback;
                    this.f61381b = str2;
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
                            String str4 = (String) hashMap.get("params");
                            if (intValue != 0) {
                                this.f61382c.a(this.f61380a, this.f61381b, LightappConstants.ERRCODE_CANCEL, str4, "#bindCardInitiativeFail");
                                return;
                            } else {
                                this.f61380a.onResult(0, str4);
                                return;
                            }
                        }
                        String str5 = (String) hashMap.get("errorMsg");
                        a aVar = this.f61382c;
                        ILightappInvokerCallback iLightappInvokerCallback2 = this.f61380a;
                        String str6 = this.f61381b;
                        String num = Integer.toString(i2);
                        if (!TextUtils.isEmpty(str5)) {
                            str5 = LightappConstants.ROUTER_INVOKE_FAIL;
                        }
                        aVar.a(iLightappInvokerCallback2, str6, num, str5, "#bindCardInitiativeFail");
                    }
                }
            });
        }
    }
}
