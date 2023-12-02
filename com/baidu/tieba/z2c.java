package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.BaseAdRipper;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.lang.reflect.Field;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class z2c extends BaseAdRipper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z2c(Ssp.Pid pid) {
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
        NativeResponse nativeResponse;
        JSONObject optJSONObject;
        String str;
        JSONObject optJSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            try {
                if (!(obj instanceof w2c) || (nativeResponse = ((w2c) obj).a) == null) {
                    return null;
                }
                Field declaredField = nativeResponse.getClass().getDeclaredField("mFeedsProd");
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(nativeResponse);
                if (obj2 == null) {
                    return null;
                }
                Field declaredField2 = obj2.getClass().getSuperclass().getDeclaredField("n");
                declaredField2.setAccessible(true);
                Object obj3 = declaredField2.get(obj2);
                if (obj3 == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(obj3.toString());
                String brandName = nativeResponse.getBrandName();
                JSONArray optJSONArray = jSONObject.optJSONArray("ad");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    int i = 0;
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(0);
                    if (optJSONArray.length() > 1) {
                        Field declaredField3 = nativeResponse.getClass().getDeclaredField("mAdInstanceInfo");
                        declaredField3.setAccessible(true);
                        Object obj4 = declaredField3.get(nativeResponse);
                        if (obj4 == null) {
                            return null;
                        }
                        Field declaredField4 = obj4.getClass().getDeclaredField("P");
                        declaredField4.setAccessible(true);
                        try {
                            str = (String) declaredField4.get(obj4);
                        } catch (Exception unused) {
                            Field declaredField5 = obj4.getClass().getDeclaredField("Q");
                            declaredField5.setAccessible(true);
                            str = (String) declaredField5.get(obj4);
                        }
                        while (true) {
                            if (i >= optJSONArray.length()) {
                                break;
                            }
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                            if (jSONObject2 != null && (optJSONObject2 = jSONObject2.optJSONObject("remoteParams")) != null && optJSONObject2.optString("uniqueId").equals(str)) {
                                optJSONObject3 = jSONObject2;
                                break;
                            }
                            i++;
                        }
                    }
                    String optString = optJSONObject3.optString("deepLinkUrl");
                    if (TextUtils.isEmpty(optString) && (optJSONObject = optJSONObject3.optJSONObject("apo")) != null) {
                        optString = optJSONObject.optString("page");
                    }
                    RippedAd.Builder builder = new RippedAd.Builder();
                    builder.setCorporation(brandName).setTitle(optJSONObject3.optString("tit")).setDescription(optJSONObject3.optString("desc")).setIconUrl(optJSONObject3.optString("icon")).setAppName(optJSONObject3.optString("appname")).setAppPkg(optJSONObject3.optString(PushConstants.URI_PACKAGE_NAME)).setAppUrl(null).setImageUrl(optJSONObject3.optString("w_picurl")).setVideoImageUrl(null).setVideoUrl(null).setClickUrl(optJSONObject3.optString("curl")).setDeepLinkUrl(optString);
                    return builder.build();
                }
                return null;
            } catch (Exception unused2) {
                LogPrinter.d();
                return null;
            }
        }
        return (RippedAd) invokeL.objValue;
    }
}
