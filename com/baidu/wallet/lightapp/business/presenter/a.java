package com.baidu.wallet.lightapp.business.presenter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.wallet.utils.ImageBase64Utils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f59064a = "a";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Activity f59065b;

    /* renamed from: c  reason: collision with root package name */
    public LightappBusinessClient f59066c;

    /* renamed from: d  reason: collision with root package name */
    public String f59067d;

    /* renamed from: e  reason: collision with root package name */
    public int f59068e;

    /* renamed from: f  reason: collision with root package name */
    public String f59069f;

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
        this.f59068e = -1;
        this.f59065b = activity;
        this.f59066c = lightappBusinessClient;
        this.f59067d = str;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[RETURN, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION, RETURN, INVOKE, INVOKE, INVOKE, IGET, INVOKE, RETURN, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION] complete} */
    public void a(Intent intent, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048576, this, intent, jSONObject) != null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(this.f59067d);
            String optString = jSONObject2.optString("fixedWidth");
            if (!TextUtils.isEmpty(optString)) {
                this.f59068e = Integer.parseInt(optString);
                String str = f59064a;
                LogUtil.d(str, "fixedWidth = " + this.f59068e);
            }
            this.f59069f = jSONObject2.optString(LightappConstants.LIGHT_APP_NATIVE_INVOKER_FROM_URL);
            Uri data = intent.getData();
            if (data == null) {
                jSONObject.put("errCode", LightappConstants.ERRCODE_INNER_ERROR);
                jSONObject.put("des", "内部错误");
                this.f59066c.setAlubmPhotoData(1, jSONObject);
                return;
            }
            ImageBase64Utils.getInstance().getImageBase64(this.f59065b, data, this.f59068e, new ImageBase64Utils.ImageBase64Listener(this, jSONObject) { // from class: com.baidu.wallet.lightapp.business.presenter.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ JSONObject f59070a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f59071b;

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
                    this.f59071b = this;
                    this.f59070a = jSONObject;
                }

                @Override // com.baidu.wallet.utils.ImageBase64Utils.ImageBase64Listener
                public void onBase64Result(String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str2) == null) {
                        if (TextUtils.isEmpty(str2)) {
                            try {
                                this.f59070a.put("errCode", LightappConstants.ERRCODE_INNER_ERROR);
                                this.f59070a.put("des", "内部错误");
                                this.f59071b.f59066c.setAlubmPhotoData(1, this.f59070a);
                                return;
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                        try {
                            try {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("image", str2);
                                this.f59070a.put("errCode", 0);
                                this.f59070a.put("des", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                                this.f59070a.put("data", jSONObject3);
                                this.f59071b.f59066c.setAlubmPhotoData(0, this.f59070a);
                            } catch (JSONException unused) {
                                this.f59070a.put("errCode", LightappConstants.ERRCODE_INNER_ERROR);
                                this.f59070a.put("des", "内部错误");
                                this.f59071b.f59066c.setAlubmPhotoData(1, this.f59070a);
                            }
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            });
        } finally {
        }
    }
}
