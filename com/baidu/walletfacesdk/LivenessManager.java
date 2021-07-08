package com.baidu.walletfacesdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.fsg.api.BaiduRIM;
import com.baidu.fsg.api.RimServiceCallback;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.sapi2.openbduss.PASSMethodCallTransfer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class LivenessManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public String mPassProductId;

    /* loaded from: classes5.dex */
    public interface IvoiceListener {
        public static final int RESULT_FAIL = 1;
        public static final int RESULT_SUCC = 0;

        void onResult(int i2, int i3, String str, Object obj);
    }

    public LivenessManager(Context context, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mPassProductId = str;
    }

    public void livenessRecognize(Map map, IvoiceListener ivoiceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, map, ivoiceListener) == null) {
            if (map != null && map.containsKey("stoken") && TextUtils.isEmpty((String) map.get("stoken"))) {
                PayStatisticsUtil.onEvent("wallet_face_stoken_empty", "1");
            }
            PASSMethodCallTransfer pASSMethodCallTransfer = new PASSMethodCallTransfer();
            PASSMethodCallTransfer.ParamsWap paramsWap = new PASSMethodCallTransfer.ParamsWap();
            HashMap hashMap = new HashMap();
            hashMap.put("method", "startLivenessRecognize");
            hashMap.put("recogType", "bduss");
            hashMap.put("supPro", this.mPassProductId);
            hashMap.putAll(map);
            paramsWap.param = hashMap;
            HashMap hashMap2 = new HashMap();
            paramsWap.attributes = hashMap2;
            hashMap2.put(PASSMethodCallTransfer.ParamsWap.UID, "uid");
            paramsWap.attributes.put(PASSMethodCallTransfer.ParamsWap.BDUSS, "bduss");
            pASSMethodCallTransfer.dynamicCallMethod(BaiduRIM.getInstance(), new Object[]{this.mContext, paramsWap, new RimServiceCallback(this, ivoiceListener) { // from class: com.baidu.walletfacesdk.LivenessManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ IvoiceListener f27374a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessManager f27375b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, ivoiceListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f27375b = this;
                    this.f27374a = ivoiceListener;
                }

                @Override // com.baidu.fsg.api.RimServiceCallback
                public void onResult(int i2, Map<String, Object> map2) {
                    IvoiceListener ivoiceListener2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, map2) == null) {
                        if (i2 == 0) {
                            IvoiceListener ivoiceListener3 = this.f27374a;
                            if (ivoiceListener3 != null) {
                                ivoiceListener3.onResult(0, 0, "ok", this.f27375b.toJSONObject(map2));
                            }
                        } else if (map2 == null || (ivoiceListener2 = this.f27374a) == null) {
                        } else {
                            ivoiceListener2.onResult(1, ((Integer) map2.get(BaiduRimConstants.RETCODE_KEY)).intValue(), (String) map2.get("retMsg"), null);
                        }
                    }
                }
            }}, "accessRimService", new PASSMethodCallTransfer.DynamicCallbak(this, ivoiceListener) { // from class: com.baidu.walletfacesdk.LivenessManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ IvoiceListener f27376a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessManager f27377b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, ivoiceListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f27377b = this;
                    this.f27376a = ivoiceListener;
                }

                @Override // com.baidu.sapi2.openbduss.PASSMethodCallTransfer.DynamicCallbak
                public void onFailure(int i2, String str) {
                    int i3;
                    String str2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        PayStatisticsUtil.onEventWithValue("callNativeVoiceTransferFail", String.valueOf(i2));
                        if (i2 == -1001) {
                            i3 = 101;
                            str2 = "请重新登录！";
                        } else if (i2 == -1003) {
                            i3 = 10001;
                            str2 = "参数非法";
                        } else {
                            i3 = 10003;
                            str2 = "内部错误";
                        }
                        this.f27376a.onResult(1, i3, str2, null);
                    }
                }
            }, Context.class, Map.class, RimServiceCallback.class);
        }
    }

    public JSONObject toJSONObject(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            JSONObject jSONObject = new JSONObject(map);
            try {
                jSONObject.put("result", new JSONObject((String) map.get("result")));
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
