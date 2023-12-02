package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.defaultimpl.utils.MultiRatePlayUrlHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class zw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;

    public zw4() {
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

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                b(new JSONObject(str));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public final void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.optInt("switch");
            JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
            if (optJSONObject != null) {
                this.c = optJSONObject.optInt("num");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
            if (optJSONObject2 != null) {
                this.b = optJSONObject2.optInt("time");
                this.a = optJSONObject2.optInt("num");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject(MultiRatePlayUrlHelper.RANK);
            if (optJSONObject3 != null) {
                optJSONObject3.optInt("succ");
                optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                optJSONObject3.optInt("slow");
            }
            if (this.b > 0 && this.a > 0) {
                int i = this.c;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
