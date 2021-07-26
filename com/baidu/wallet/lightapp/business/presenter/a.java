package com.baidu.wallet.lightapp.business.presenter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.utils.ImageBase64Utils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f25763a = "a";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Activity f25764b;

    /* renamed from: c  reason: collision with root package name */
    public LightappBusinessClient f25765c;

    /* renamed from: d  reason: collision with root package name */
    public String f25766d;

    /* renamed from: e  reason: collision with root package name */
    public int f25767e;

    /* renamed from: f  reason: collision with root package name */
    public String f25768f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(281857908, "Lcom/baidu/wallet/lightapp/business/presenter/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(281857908, "Lcom/baidu/wallet/lightapp/business/presenter/a;");
        }
    }

    public a(Activity activity, LightappBusinessClient lightappBusinessClient, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, lightappBusinessClient, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f25767e = -1;
        this.f25764b = activity;
        this.f25765c = lightappBusinessClient;
        this.f25766d = str;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[RETURN, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION, RETURN, INVOKE, INVOKE, INVOKE, IGET, INVOKE, RETURN, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION] complete} */
    public void a(Intent intent, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048576, this, intent, jSONObject) != null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(this.f25766d);
            String optString = jSONObject2.optString("fixedWidth");
            if (!TextUtils.isEmpty(optString)) {
                this.f25767e = Integer.parseInt(optString);
                String str = f25763a;
                LogUtil.d(str, "fixedWidth = " + this.f25767e);
            }
            this.f25768f = jSONObject2.optString(LightappConstants.LIGHT_APP_NATIVE_INVOKER_FROM_URL);
            Uri data = intent.getData();
            if (data == null) {
                jSONObject.put(RouterCallback.KEY_ERROR_CODE, LightappConstants.ERRCODE_INNER_ERROR);
                jSONObject.put("des", "内部错误");
                this.f25765c.setAlubmPhotoData(1, jSONObject);
                a("#callNativePhoto Fail", "图片报错");
                return;
            }
            ImageBase64Utils.getInstance().getImageBase64(this.f25764b, data, this.f25767e, new ImageBase64Utils.ImageBase64Listener(this, jSONObject) { // from class: com.baidu.wallet.lightapp.business.presenter.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ JSONObject f25769a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f25770b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, jSONObject};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25770b = this;
                    this.f25769a = jSONObject;
                }

                @Override // com.baidu.wallet.utils.ImageBase64Utils.ImageBase64Listener
                public void onBase64Result(String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str2) == null) {
                        if (TextUtils.isEmpty(str2)) {
                            try {
                                this.f25769a.put(RouterCallback.KEY_ERROR_CODE, LightappConstants.ERRCODE_INNER_ERROR);
                                this.f25769a.put("des", "内部错误");
                                this.f25770b.f25765c.setAlubmPhotoData(1, this.f25769a);
                                this.f25770b.a("#callNativePhoto Fail", "Base64失败");
                                return;
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("image", str2);
                            this.f25769a.put(RouterCallback.KEY_ERROR_CODE, 0);
                            this.f25769a.put("des", "ok");
                            this.f25769a.put("data", jSONObject3);
                            this.f25770b.f25765c.setAlubmPhotoData(0, this.f25769a);
                        } catch (JSONException e3) {
                            try {
                                this.f25769a.put(RouterCallback.KEY_ERROR_CODE, LightappConstants.ERRCODE_INNER_ERROR);
                                this.f25769a.put("des", "内部错误");
                                this.f25770b.f25765c.setAlubmPhotoData(1, this.f25769a);
                                this.f25770b.a("#callNativePhoto Fail", e3.getMessage());
                            } catch (JSONException e4) {
                                e4.printStackTrace();
                            }
                        }
                    }
                }
            });
        } finally {
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(CheckUtils.stripUrlParams(this.f25768f));
            arrayList.add(str2);
            DXMSdkSAUtils.onEventWithValues(str, arrayList);
            PayStatisticsUtil.onEventWithValues(str, arrayList);
        }
    }
}
