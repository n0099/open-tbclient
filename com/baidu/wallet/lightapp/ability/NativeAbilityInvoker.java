package com.baidu.wallet.lightapp.ability;

import android.app.Activity;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.sapi2.openbduss.PASSMethodCallTransfer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.lightapp.ability.a.c;
import com.baidu.wallet.lightapp.ability.a.d;
import com.baidu.wallet.lightapp.ability.a.e;
import com.baidu.wallet.lightapp.ability.a.f;
import com.baidu.wallet.lightapp.ability.a.g;
import com.baidu.wallet.lightapp.ability.a.h;
import com.baidu.wallet.lightapp.ability.a.i;
import com.baidu.wallet.lightapp.ability.a.j;
import com.baidu.wallet.lightapp.ability.a.k;
import com.baidu.wallet.lightapp.ability.a.l;
import com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityCommonModel;
import com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityErrorModel;
import com.baidu.wallet.lightapp.base.LightappConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class NativeAbilityInvoker {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, com.baidu.wallet.lightapp.ability.a> f58586a;

    /* renamed from: com.baidu.wallet.lightapp.ability.NativeAbilityInvoker$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static class NativeAbilityInvokerCallback implements ILightappInvokerCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ILightappInvokerCallback f58587a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<String> f58588b;

        public NativeAbilityInvokerCallback(ILightappInvokerCallback iLightappInvokerCallback, ArrayList<String> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iLightappInvokerCallback, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58587a = iLightappInvokerCallback;
            this.f58588b = arrayList;
        }

        public void addStatics(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            if (this.f58588b == null) {
                this.f58588b = new ArrayList<>();
            }
            this.f58588b.add(str);
        }

        @Override // com.baidu.wallet.api.ILightappInvokerCallback
        public void onResult(int i2, String str) {
            ILightappInvokerCallback iLightappInvokerCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (iLightappInvokerCallback = this.f58587a) == null) {
                return;
            }
            if (i2 == 0) {
                DXMSdkSAUtils.onEventWithValues("NA#invokeBdWalletNativeSuccess", this.f58588b);
                this.f58587a.onResult(i2, str);
            } else if (i2 != 1) {
                iLightappInvokerCallback.onResult(i2, str);
            } else {
                String str2 = "";
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                if (this.f58588b.size() >= 2) {
                    this.f58588b.add(1, str);
                } else {
                    this.f58588b.add(str);
                }
                try {
                    str2 = ((NativeAbilityCommonModel) JsonUtils.fromJson(str, NativeAbilityCommonModel.class)).cnt.errCode;
                } catch (Exception unused) {
                }
                this.f58588b.add(str2);
                DXMSdkSAUtils.onEventWithValues("NA#invokeBdWalletNativeFail", this.f58588b);
                this.f58587a.onResult(i2, str);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static NativeAbilityInvoker f58589a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(67437846, "Lcom/baidu/wallet/lightapp/ability/NativeAbilityInvoker$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(67437846, "Lcom/baidu/wallet/lightapp/ability/NativeAbilityInvoker$a;");
                    return;
                }
            }
            f58589a = new NativeAbilityInvoker(null);
        }
    }

    public /* synthetic */ NativeAbilityInvoker(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static NativeAbilityInvoker a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f58589a : (NativeAbilityInvoker) invokeV.objValue;
    }

    public NativeAbilityInvoker() {
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
        this.f58586a = new HashMap();
        a(new h());
        a(new e());
        a(new j());
        a(new c());
        a(new com.baidu.wallet.lightapp.ability.a.b());
        a(new i());
        a(new f());
        a(new k());
        a(new com.baidu.wallet.lightapp.ability.a.a());
        a(new d());
        a(new g());
        a(new l());
    }

    private void a(com.baidu.wallet.lightapp.ability.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar) == null) || aVar == null || TextUtils.isEmpty(aVar.a()) || this.f58586a.containsKey(aVar.a())) {
            return;
        }
        this.f58586a.put(aVar.a(), aVar);
    }

    public void a(Activity activity, String str, String str2, ILightappInvokerCallback iLightappInvokerCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, activity, str, str2, iLightappInvokerCallback) == null) || iLightappInvokerCallback == null) {
            return;
        }
        if (activity != null && !TextUtils.isEmpty(str2)) {
            try {
                String str3 = (String) new JSONObject(str2).get("method_name");
                if (TextUtils.isEmpty(str3)) {
                    a(iLightappInvokerCallback);
                    return;
                }
                String str4 = "";
                JSONObject jSONObject = new JSONObject(str2);
                try {
                    jSONObject.remove("method_name");
                    if (jSONObject.length() > 0) {
                        str4 = jSONObject.toString();
                    }
                } catch (Exception unused) {
                }
                ArrayList arrayList = new ArrayList();
                try {
                    arrayList.add(CheckUtils.stripUrlParams(str));
                } catch (Exception unused2) {
                }
                arrayList.add(str3);
                arrayList.add(str4);
                DXMSdkSAUtils.onEventWithValues("NA#invokeBdWalletNative", arrayList);
                NativeAbilityInvokerCallback nativeAbilityInvokerCallback = new NativeAbilityInvokerCallback(iLightappInvokerCallback, arrayList);
                com.baidu.wallet.lightapp.ability.a aVar = this.f58586a.get(str3);
                if (aVar != null) {
                    aVar.a(activity, str2, nativeAbilityInvokerCallback, str);
                    return;
                }
                NativeAbilityErrorModel nativeAbilityErrorModel = new NativeAbilityErrorModel(1);
                nativeAbilityErrorModel.cnt.errCode = "10004";
                nativeAbilityErrorModel.cnt.des = "没有找到对应的方法";
                nativeAbilityInvokerCallback.onResult(1, nativeAbilityErrorModel.toJson());
                return;
            } catch (JSONException e2) {
                a(iLightappInvokerCallback);
                e2.printStackTrace();
                return;
            }
        }
        a(iLightappInvokerCallback);
    }

    private void a(ILightappInvokerCallback iLightappInvokerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, iLightappInvokerCallback) == null) {
            NativeAbilityErrorModel nativeAbilityErrorModel = new NativeAbilityErrorModel(1);
            NativeAbilityErrorModel.Data data = nativeAbilityErrorModel.cnt;
            data.errCode = LightappConstants.ERRCODE_INVALID_PARAMETER;
            data.des = PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR;
            iLightappInvokerCallback.onResult(1, nativeAbilityErrorModel.toJson());
        }
    }
}
