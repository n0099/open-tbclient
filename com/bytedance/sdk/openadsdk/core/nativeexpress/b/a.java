package com.bytedance.sdk.openadsdk.core.nativeexpress.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.core.e.l;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.tencent.connect.common.Constants;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f66876a = "{\"id\":0,\"tplId\":0,\"title\":\"\",\"data\":{\"id\":\"root\",\"type\":\"vessel\",\"values\":{\"widthMode\":\"fixed\",\"width\":320,\"height\":320},\"children\":[[{\"type\":\"text\",\"values\":{\"fontSize\":19,\"fontWeight\":500,\"color\":\"#222222\",\"lineHeight\":1.3,\"data\":\"title\"}}],[{\"type\":\"text\",\"values\":{\"fontSize\":15,\"fontWeight\":500,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"subtitle\"}}],[{\"type\":\"image\",\"values\":{},\"children\":[]}],[{\"type\":\"vessel\",\"values\":{\"height\":40,\"paddingTop\":10,\"paddingRight\":15,\"paddingBottom\":10,\"paddingLeft\":15},\"children\":[[{\"type\":\"logo\",\"values\":{}},{\"type\":\"text\",\"values\":{\"widthMode\":\"auto\",\"paddingTop\":3,\"paddingRight\":0,\"paddingBottom\":3,\"paddingLeft\":6,\"fontSize\":12,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"source\"}},{\"type\":\"text\",\"values\":{\"widthMode\":\"auto\",\"paddingTop\":3,\"paddingRight\":0,\"paddingBottom\":3,\"paddingLeft\":10,\"fontSize\":12,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"time\"}},{\"type\":\"empty\",\"values\":{\"height\":18}},{\"type\":\"dislike\",\"values\":{}}]]}]]}}";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1497016024, "Lcom/bytedance/sdk/openadsdk/core/nativeexpress/b/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1497016024, "Lcom/bytedance/sdk/openadsdk/core/nativeexpress/b/a;");
        }
    }

    public static boolean a(m.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aVar)) == null) ? (aVar == null || TextUtils.isEmpty(aVar.b()) || TextUtils.isEmpty(aVar.e())) ? false : true : invokeL.booleanValue;
    }

    public static JSONObject b(float f2, float f3, boolean z, @NonNull m mVar) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z), mVar})) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Constants.PARAM_PLATFORM, "android");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("width", f2);
                jSONObject2.put("height", f3);
                if (z) {
                    jSONObject2.put("isLandscape", true);
                }
                jSONObject.put("AdSize", jSONObject2);
                jSONObject.put("creative", a(true, mVar));
                String str2 = null;
                if (mVar.Q() != null) {
                    str2 = mVar.Q().e();
                    str = mVar.Q().f();
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str2)) {
                    f66876a = str2;
                } else if (com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d(mVar) != null) {
                    f66876a = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d(mVar).e();
                }
                jSONObject.put("template_Plugin", f66876a);
                jSONObject.put("diff_template_Plugin", str);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject a(float f2, float f3, boolean z, @NonNull m mVar) {
        InterceptResult invokeCommon;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z), mVar})) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Constants.PARAM_PLATFORM, "android");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("width", f2);
                jSONObject2.put("height", f3);
                if (z) {
                    jSONObject2.put("isLandscape", true);
                }
                jSONObject.put("AdSize", jSONObject2);
                jSONObject.put("creative", a(false, mVar));
                if (mVar.P() != null) {
                    str = mVar.P().e();
                    str2 = mVar.P().f();
                } else {
                    str = null;
                    str2 = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    f66876a = str;
                } else if (com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c(mVar) != null) {
                    f66876a = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c(mVar).e();
                }
                jSONObject.put("template_Plugin", f66876a);
                jSONObject.put("diff_template_Plugin", str2);
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject a(boolean z, @NonNull m mVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65538, null, z, mVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, mVar.aj());
                if (mVar.Y() != null) {
                    jSONObject.put("icon", mVar.Y().a());
                }
                JSONArray jSONArray = new JSONArray();
                if (mVar.ad() != null) {
                    for (int i2 = 0; i2 < mVar.ad().size(); i2++) {
                        l lVar = mVar.ad().get(i2);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("height", lVar.c());
                        jSONObject2.put("width", lVar.b());
                        jSONObject2.put("url", lVar.a());
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("image", jSONArray);
                jSONObject.put("image_mode", mVar.ap());
                jSONObject.put("interaction_type", mVar.X());
                jSONObject.put("is_compliance_template", a(mVar));
                jSONObject.put("title", mVar.ah());
                jSONObject.put("description", mVar.ai());
                jSONObject.put("source", mVar.W());
                if (mVar.al() != null) {
                    jSONObject.put("comment_num", mVar.al().f());
                    jSONObject.put("score", mVar.al().e());
                    jSONObject.put("app_size", mVar.al().g());
                    jSONObject.put("app", mVar.al().h());
                }
                if (mVar.V() != null) {
                    jSONObject.put("video", mVar.V().p());
                }
                if (z) {
                    if (mVar.Q() != null) {
                        jSONObject.put("dynamic_creative", mVar.Q().g());
                    }
                } else if (mVar.P() != null) {
                    jSONObject.put("dynamic_creative", mVar.P().g());
                }
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeZL.objValue;
    }

    public static boolean a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, mVar)) == null) ? mVar != null && mVar.B() == 2 : invokeL.booleanValue;
    }
}
