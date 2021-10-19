package com.bytedance.sdk.openadsdk.core.dynamic.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.subtitle.SubtitleLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Integer> f66669a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f66670b;

    /* renamed from: c  reason: collision with root package name */
    public String f66671c;

    /* renamed from: d  reason: collision with root package name */
    public d f66672d;

    /* renamed from: e  reason: collision with root package name */
    public d f66673e;

    /* renamed from: f  reason: collision with root package name */
    public String f66674f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(702898768, "Lcom/bytedance/sdk/openadsdk/core/dynamic/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(702898768, "Lcom/bytedance/sdk/openadsdk/core/dynamic/b/c;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        f66669a = hashMap;
        hashMap.put(PrefetchEvent.EVENT_DATA_ROOT_PATH, 8);
        f66669a.put("title", 0);
        f66669a.put(SubtitleLog.TAG, 0);
        f66669a.put("source", 0);
        f66669a.put("score-count", 0);
        f66669a.put("text_star", 0);
        f66669a.put("image", 1);
        f66669a.put("image-wide", 1);
        f66669a.put("image-square", 1);
        f66669a.put("image-long", 1);
        f66669a.put("image-splash", 1);
        f66669a.put("image-cover", 1);
        f66669a.put("app-icon", 1);
        f66669a.put("icon-download", 1);
        f66669a.put(AccountConstants.LOGIN_TYPE_NATIVE_SRC_STAR, 1);
        f66669a.put("logoad", 4);
        f66669a.put("logounion", 5);
        f66669a.put("logo-union", 6);
        f66669a.put("dislike", 3);
        f66669a.put(IntentConfig.CLOSE, 3);
        f66669a.put("close-fill", 3);
        f66669a.put("text", 2);
        f66669a.put("button", 2);
        f66669a.put("downloadWithIcon", 2);
        f66669a.put("downloadButton", 2);
        f66669a.put("fillButton", 2);
        f66669a.put("laceButton", 2);
        f66669a.put("cardButton", 2);
        f66669a.put("colourMixtureButton", 2);
        f66669a.put("arrowButton", 2);
        f66669a.put("vessel", 6);
        f66669a.put("video-hd", 7);
        f66669a.put("video", 7);
        f66669a.put("video-vd", 7);
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f66670b)) {
                return 0;
            }
            if (this.f66670b.equals("logo")) {
                this.f66670b += this.f66671c;
            }
            if (f66669a.get(this.f66670b) != null) {
                return f66669a.get(this.f66670b).intValue();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f66671c : (String) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f66674f = str;
        }
    }

    public d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f66672d : (d) invokeV.objValue;
    }

    public d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f66673e : (d) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f66671c = str;
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f66674f : (String) invokeV.objValue;
    }

    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.f66673e = dVar;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f66670b = str;
        }
    }

    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            this.f66672d = dVar;
        }
    }

    public static void a(JSONObject jSONObject, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, jSONObject, cVar) == null) || jSONObject == null || cVar == null) {
            return;
        }
        cVar.a(jSONObject.optString("type", PrefetchEvent.EVENT_DATA_ROOT_PATH));
        cVar.b(jSONObject.optString("data"));
        cVar.c(jSONObject.optString("dataExtraInfo"));
        d a2 = d.a(jSONObject.optJSONObject(SavedStateHandle.VALUES));
        d a3 = d.a(jSONObject.optJSONObject("nightThemeValues"));
        cVar.a(a2);
        cVar.b(a3);
    }
}
