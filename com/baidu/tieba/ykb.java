package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.BaseAdRipper;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.lang.reflect.Field;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class ykb extends BaseAdRipper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ykb(Ssp.Pid pid) {
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
        ExpressResponse expressResponse;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            try {
                if (!(obj instanceof vkb) || (expressResponse = ((vkb) obj).a) == null) {
                    return null;
                }
                Field declaredField = expressResponse.getClass().getDeclaredField("f");
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(expressResponse);
                if (obj2 == null) {
                    return null;
                }
                Field declaredField2 = obj2.getClass().getSuperclass().getDeclaredField("n");
                declaredField2.setAccessible(true);
                String str = (String) declaredField2.get(obj2);
                if (!TextUtils.isEmpty(str) && (optJSONArray = new JSONObject(str).optJSONArray("ad")) != null && optJSONArray.length() > 0) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(0);
                    String optString = optJSONObject.optString("tit");
                    String optString2 = optJSONObject.optString("desc");
                    String optString3 = optJSONObject.optString("icon");
                    String optString4 = optJSONObject.optString("curl");
                    String optString5 = optJSONObject.optString("vurl");
                    String optString6 = optJSONObject.optString("w_picurl");
                    String optString7 = optJSONObject.optString("appname");
                    String optString8 = optJSONObject.optString("publisher");
                    RippedAd.Builder builder = new RippedAd.Builder();
                    builder.setCorporation(optString8).setTitle(optString).setDescription(optString2).setIconUrl(optString3).setClickUrl(optString4).setVideoUrl(optString5).setImageUrl(optString6).setAppName(optString7);
                    return builder.build();
                }
                return null;
            } catch (Exception e) {
                LogPrinter.e(e.getMessage(), new Object[0]);
                return null;
            }
        }
        return (RippedAd) invokeL.objValue;
    }
}
