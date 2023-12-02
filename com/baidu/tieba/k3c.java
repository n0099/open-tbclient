package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class k3c extends BaseAdRipper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k3c(Ssp.Pid pid) {
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

    public abstract JSONObject c(Object obj);

    @Override // com.fun.ad.sdk.internal.api.ripper.BaseAdRipper
    public final RippedAd getRippedAdInternal(Object obj) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            JSONObject c = c(obj);
            if (c == null) {
                return null;
            }
            try {
                JSONArray optJSONArray = c.optJSONArray("ad");
                if (optJSONArray == null) {
                    return null;
                }
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(0);
                String optString = optJSONObject2.optString("deepLinkUrl");
                if (TextUtils.isEmpty(optString) && (optJSONObject = optJSONObject2.optJSONObject("apo")) != null) {
                    optString = optJSONObject.optString("page");
                }
                RippedAd.Builder builder = new RippedAd.Builder();
                builder.setCorporation(optJSONObject2.optString("publisher")).setTitle(optJSONObject2.optString("tit")).setDescription(optJSONObject2.optString("desc")).setIconUrl(optJSONObject2.optString("icon")).setAppName(optJSONObject2.optString("appname")).setAppPkg(optJSONObject2.optString(PushConstants.URI_PACKAGE_NAME)).setAppUrl(optJSONObject2.optString("apk_name")).setImageUrl(optJSONObject2.optString("w_picurl")).setVideoImageUrl(optJSONObject2.optString("w_picurl")).setVideoUrl(optJSONObject2.optString("vurl")).setClickUrl(optJSONObject2.optString("curl")).setDeepLinkUrl(optString);
                return builder.build();
            } catch (Exception unused) {
                LogPrinter.d();
                return null;
            }
        }
        return (RippedAd) invokeL.objValue;
    }
}
