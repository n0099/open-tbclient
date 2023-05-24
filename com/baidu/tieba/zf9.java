package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.recapp.activity.AdVideoBrowserConfig;
import com.baidu.tieba.recapp.activity.AdVideoWebBrowserActivity;
import com.baidu.tieba.recapp.activity.AdWebVideoActivity;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class zf9 implements uf9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<AdvertAppInfo> a;

    @Override // com.baidu.tieba.uf9
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-233556801, "Lcom/baidu/tieba/zf9$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-233556801, "Lcom/baidu/tieba/zf9$a;");
                    return;
                }
            }
            int[] iArr = new int[IAdBaseAsyncController.Type.values().length];
            a = iArr;
            try {
                iArr[IAdBaseAsyncController.Type.PIC_PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[IAdBaseAsyncController.Type.VIDEO_FLOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public zf9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.uf9
    public pf9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ef9.t();
        }
        return (pf9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uf9
    public kf9 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return o16.l();
        }
        return (kf9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uf9
    public List<AdvertAppInfo> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new ArrayList();
            }
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uf9
    public rf9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return ef9.t();
        }
        return (rf9) invokeV.objValue;
    }

    public static void l(IntentConfig intentConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, intentConfig) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, intentConfig));
        }
    }

    @Override // com.baidu.tieba.uf9
    public void j(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, advertAppInfo) == null) {
            AdWebVideoActivity.b bVar = new AdWebVideoActivity.b();
            AdVideoWebBrowserActivity.P = bVar;
            bVar.a = advertAppInfo;
            bVar.c = "DETAIL";
            bVar.b = 0;
            AdWebVideoActivity.P = bVar;
        }
    }

    @Override // com.baidu.tieba.uf9
    public en<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.z) {
                return new fg9(baseFragmentActivity, bdUniqueId);
            }
            if (bdUniqueId != AdvertAppInfo.x) {
                return null;
            }
            return new eg9(baseFragmentActivity, bdUniqueId);
        }
        return (en) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.uf9
    public en<?, ?> d(tf9 tf9Var, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, tf9Var, bdUniqueId)) == null) {
            if (tf9Var == null || bdUniqueId == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.w) {
                return new cg9(tf9Var, bdUniqueId);
            }
            return new dg9(tf9Var, bdUniqueId, null);
        }
        return (en) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.uf9
    @Nullable
    public IAdBaseAsyncController h(IAdBaseAsyncController.Type type, IAdBaseAsyncController.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, type, aVar)) == null) {
            int i = a.a[type.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return new sh9(aVar);
            }
            return new ih9(aVar);
        }
        return (IAdBaseAsyncController) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.uf9
    public en<?, ?> g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, tbPageContext, bdUniqueId, str)) == null) {
            if (bdUniqueId == AdvertAppInfo.y) {
                return new ag9(tbPageContext, bdUniqueId, str);
            }
            if (bdUniqueId != null) {
                return new bg9(tbPageContext, bdUniqueId, str);
            }
            return null;
        }
        return (en) invokeLLL.objValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0144  */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v14 */
    @Override // com.baidu.tieba.uf9
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k(@NonNull HashMap<String, String> hashMap, Context context) {
        IntentConfig adWebVideoActivityConfig;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, hashMap, context) == null) {
            Bundle bundle = new Bundle();
            JSONObject jSONObject4 = null;
            try {
                if (hashMap.get(WriteActivityConfig.VIDEO_INFO) != null) {
                    jSONObject = new JSONObject(hashMap.get(WriteActivityConfig.VIDEO_INFO));
                } else {
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    bundle.putString("video_url", jSONObject.optString("video_url", ""));
                    bundle.putString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL, jSONObject.optString("poster_image", ""));
                    float floatValue = Float.valueOf(jSONObject.optString("video_aspect_ratio", "1")).floatValue();
                    bundle.putFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, floatValue);
                    if (floatValue < 1.0f) {
                        bundle.putInt(AdWebVideoActivityConfig.KEY_GOOD_STYLE, 14);
                    } else {
                        bundle.putInt(AdWebVideoActivityConfig.KEY_GOOD_STYLE, 7);
                    }
                    bundle.putInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, jSONObject.optInt("duration", 0));
                    bundle.putString(WebViewActivityConfig.TAG_AD_DEEPLINK_URL, jSONObject.optString("page_url", ""));
                    String str = hashMap.get("url");
                    try {
                        if (TextUtils.isEmpty(str)) {
                            str = jSONObject.optString("page_url", "");
                        }
                        if (jSONObject.get(AdWebVideoActivityConfig.KEY_TAIL_FRAME) != null) {
                            jSONObject2 = new JSONObject(jSONObject.optString(AdWebVideoActivityConfig.KEY_TAIL_FRAME));
                        } else {
                            jSONObject2 = null;
                        }
                        if (hashMap.get("download") != null) {
                            jSONObject3 = new JSONObject(hashMap.get("download"));
                        } else {
                            jSONObject3 = null;
                        }
                        if (jSONObject3 != null) {
                            bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, jSONObject3.optString("key", ""));
                            jSONObject4 = new JSONObject();
                            jSONObject4.put("pkgname", jSONObject3.optString("key", ""));
                            jSONObject4.put("download_url", jSONObject3.optString("download_url", ""));
                        }
                        if (jSONObject2 != null) {
                            jSONObject2.put("style", TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                            jSONObject2.put("button_scheme", jSONObject2.optString("button_scheme", ""));
                            jSONObject2.put("scheme", jSONObject.optString("page_url", ""));
                            jSONObject2.put("ext_data", jSONObject4);
                            if (jSONObject3 != null) {
                                jSONObject2.put("pkgname", jSONObject3.optString("key", ""));
                                jSONObject2.put("style", "apk_download");
                            }
                        }
                        bh9 bh9Var = new bh9();
                        bh9Var.b(jSONObject2);
                        bundle.putString(AdWebVideoActivityConfig.KEY_TAIL_FRAME, bh9Var.d());
                        jSONObject4 = str;
                    } catch (JSONException e) {
                        e = e;
                        jSONObject4 = str;
                        e.printStackTrace();
                        ?? r13 = jSONObject4;
                        bundle.putString(WebViewActivityConfig.TAG_AD_EXT_INFO, hashMap.get("ext_info"));
                        if (!gh6.e("https://ad-tmp/")) {
                        }
                        l(adWebVideoActivityConfig);
                    }
                }
            } catch (JSONException e2) {
                e = e2;
            }
            ?? r132 = jSONObject4;
            bundle.putString(WebViewActivityConfig.TAG_AD_EXT_INFO, hashMap.get("ext_info"));
            if (!gh6.e("https://ad-tmp/")) {
                adWebVideoActivityConfig = new AdVideoBrowserConfig(context, "", r132, true, true, true, bundle);
            } else {
                adWebVideoActivityConfig = new AdWebVideoActivityConfig(context, "", r132, true, true, true, bundle);
            }
            l(adWebVideoActivityConfig);
        }
    }
}
