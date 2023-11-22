package com.baidu.tieba;

import com.baidu.mobads.sdk.api.IBasicCPUData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.BaseAdRipper;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.ReflectionUtils;
import java.lang.reflect.Field;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jyb extends BaseAdRipper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jyb(Ssp.Pid pid) {
        super(pid);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Ssp.Pid) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.ripper.BaseAdRipper
    public RippedAd getRippedAdInternal(Object obj) {
        InterceptResult invokeL;
        Object invoke;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            try {
                if (obj instanceof IBasicCPUData) {
                    Object findField = ReflectionUtils.findField("java.lang.Object", obj);
                    Object findField2 = ReflectionUtils.findField("com.baidu.mobads.sdk.internal.aq", obj);
                    if (findField2 == null) {
                        findField2 = ReflectionUtils.findField("com.baidu.mobads.sdk.internal.ap", obj);
                    }
                    if (findField == null || findField2 == null || (invoke = ReflectionUtils.invoke(findField2, "b", new Class[]{Object.class, String.class, Object[].class}, findField, "getNativeResonse", new Object[0])) == null) {
                        return null;
                    }
                    Field declaredField = invoke.getClass().getDeclaredField("x");
                    declaredField.setAccessible(true);
                    Object obj2 = declaredField.get(invoke);
                    if (obj2 instanceof JSONObject) {
                        JSONObject jSONObject = (JSONObject) obj2;
                        JSONObject optJSONObject = jSONObject.optJSONObject("apo");
                        RippedAd.Builder builder = new RippedAd.Builder();
                        builder.setCorporation(jSONObject.optString("publisher")).setTitle(jSONObject.optString("tit")).setDescription(jSONObject.optString("desc")).setImageUrl(jSONObject.optString("w_picurl")).setIconUrl(jSONObject.optString("icon")).setClickUrl(jSONObject.optString("curl")).setVideoUrl(jSONObject.optString("vurl")).setAppName(jSONObject.optString("appname")).setAppPkg(jSONObject.optString("apk_name")).setAppUrl(jSONObject.optString("app_store_link"));
                        if (optJSONObject != null) {
                            builder.setDeepLinkUrl(optJSONObject.optString("page"));
                        }
                        return builder.build();
                    }
                    return null;
                }
                return null;
            } catch (Exception e) {
                LogPrinter.e(e);
                return null;
            }
        }
        return (RippedAd) invokeL.objValue;
    }
}
