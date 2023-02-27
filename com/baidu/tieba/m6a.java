package com.baidu.tieba;

import com.baidu.android.imsdk.chatmessage.messages.NetDiskFileMsg;
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
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class m6a extends BaseAdRipper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m6a(Ssp.Pid pid) {
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

    /* JADX WARN: Removed duplicated region for block: B:42:0x00bc A[Catch: Exception -> 0x0121, TryCatch #0 {Exception -> 0x0121, blocks: (B:5:0x0005, B:7:0x0017, B:10:0x0020, B:11:0x0023, B:14:0x0032, B:17:0x003f, B:20:0x0045, B:22:0x004d, B:24:0x0055, B:26:0x0069, B:28:0x0078, B:34:0x0089, B:36:0x0091, B:42:0x00bc, B:44:0x00c4, B:45:0x00cc, B:37:0x00a3, B:39:0x00ab), top: B:54:0x0005 }] */
    @Override // com.fun.ad.sdk.internal.api.ripper.BaseAdRipper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RippedAd getRippedAdInternal(Object obj) {
        InterceptResult invokeL;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String optString;
        String str6;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            try {
                A a = ((f7a) obj).a;
                String[] strArr = {"com.bytedance.sdk.openadsdk.core.r.w", "com.bytedance.sdk.openadsdk.core.s.y"};
                Object obj2 = null;
                for (int i = 0; i < 2; i++) {
                    obj2 = ReflectionUtils.findField(strArr[i], a);
                    if (obj2 != null) {
                        break;
                    }
                }
                String[] strArr2 = {"bY", "ce", "ca"};
                JSONObject jSONObject = null;
                for (int i2 = 0; i2 < 3 && (jSONObject = (JSONObject) ReflectionUtils.invoke(obj2, strArr2[i2], null, new Object[0])) == null; i2++) {
                }
                if (jSONObject == null) {
                    return null;
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("icon");
                if (optJSONObject3 != null) {
                    str = optJSONObject3.optString("url");
                } else {
                    str = null;
                }
                String combineStrWithComma = RippedAd.combineStrWithComma(jSONObject.optJSONArray("image"), new RippedAd.Acceptor() { // from class: com.baidu.tieba.k6a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.fun.ad.sdk.internal.api.ripper.RippedAd.Acceptor
                    public final String accept(Object obj3) {
                        InterceptResult invokeL2;
                        String optString2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, obj3)) == null) {
                            optString2 = ((JSONObject) obj3).optString("url");
                            return optString2;
                        }
                        return (String) invokeL2.objValue;
                    }
                });
                JSONObject optJSONObject4 = jSONObject.optJSONObject("video");
                if (optJSONObject4 != null) {
                    str3 = optJSONObject4.optString("video_url");
                    str2 = optJSONObject4.optString(NetDiskFileMsg.NetDiskFile.JSON_KEY_COVER_URL);
                } else {
                    str2 = null;
                    str3 = null;
                }
                int optInt = jSONObject.optInt("interaction_type", -1);
                if (optInt != 3) {
                    if (optInt == 4 && (optJSONObject2 = jSONObject.optJSONObject("app")) != null) {
                        String optString2 = optJSONObject2.optString("app_name");
                        String optString3 = optJSONObject2.optString("package_name");
                        str6 = optJSONObject2.optString("download_url");
                        str5 = optString3;
                        str4 = optString2;
                        optString = null;
                        if (str4 == null && (optJSONObject = jSONObject.optJSONObject("app_manage")) != null) {
                            str4 = optJSONObject.optString("app_name");
                            str5 = optJSONObject.optString("package_name");
                        }
                        RippedAd.Builder builder = new RippedAd.Builder();
                        builder.setCorporation(jSONObject.optString("source")).setTitle(jSONObject.optString("title")).setDescription(jSONObject.optString("description")).setAppName(str4).setAppPkg(str5).setAppUrl(str6).setIconUrl(str).setImageUrl(combineStrWithComma).setVideoImageUrl(str2).setVideoUrl(str3).setClickUrl(jSONObject.optString("target_url")).setDeepLinkUrl(optString).setConvUrl(null);
                        return builder.build();
                    }
                    str6 = null;
                    optString = null;
                    str4 = null;
                    str5 = null;
                    if (str4 == null) {
                        str4 = optJSONObject.optString("app_name");
                        str5 = optJSONObject.optString("package_name");
                    }
                    RippedAd.Builder builder2 = new RippedAd.Builder();
                    builder2.setCorporation(jSONObject.optString("source")).setTitle(jSONObject.optString("title")).setDescription(jSONObject.optString("description")).setAppName(str4).setAppPkg(str5).setAppUrl(str6).setIconUrl(str).setImageUrl(combineStrWithComma).setVideoImageUrl(str2).setVideoUrl(str3).setClickUrl(jSONObject.optString("target_url")).setDeepLinkUrl(optString).setConvUrl(null);
                    return builder2.build();
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("deep_link");
                if (optJSONObject5 != null) {
                    str4 = null;
                    str5 = null;
                    optString = optJSONObject5.optString("deeplink_url");
                    str6 = null;
                    if (str4 == null) {
                    }
                    RippedAd.Builder builder22 = new RippedAd.Builder();
                    builder22.setCorporation(jSONObject.optString("source")).setTitle(jSONObject.optString("title")).setDescription(jSONObject.optString("description")).setAppName(str4).setAppPkg(str5).setAppUrl(str6).setIconUrl(str).setImageUrl(combineStrWithComma).setVideoImageUrl(str2).setVideoUrl(str3).setClickUrl(jSONObject.optString("target_url")).setDeepLinkUrl(optString).setConvUrl(null);
                    return builder22.build();
                }
                str6 = null;
                optString = null;
                str4 = null;
                str5 = null;
                if (str4 == null) {
                }
                RippedAd.Builder builder222 = new RippedAd.Builder();
                builder222.setCorporation(jSONObject.optString("source")).setTitle(jSONObject.optString("title")).setDescription(jSONObject.optString("description")).setAppName(str4).setAppPkg(str5).setAppUrl(str6).setIconUrl(str).setImageUrl(combineStrWithComma).setVideoImageUrl(str2).setVideoUrl(str3).setClickUrl(jSONObject.optString("target_url")).setDeepLinkUrl(optString).setConvUrl(null);
                return builder222.build();
            } catch (Exception e) {
                LogPrinter.e(e);
                return null;
            }
        }
        return (RippedAd) invokeL.objValue;
    }
}
