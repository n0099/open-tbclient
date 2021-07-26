package com.baidu.wallet.paysdk.fingerprint.datamodel;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class StatusResponse extends a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f26275a = "StatusResponse";
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject fingerprint;
    public JSONObject user_info;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(319571256, "Lcom/baidu/wallet/paysdk/fingerprint/datamodel/StatusResponse;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(319571256, "Lcom/baidu/wallet/paysdk/fingerprint/datamodel/StatusResponse;");
        }
    }

    public StatusResponse() {
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

    @Override // com.baidu.wallet.paysdk.fingerprint.datamodel.a, com.baidu.apollon.beans.IBeanResponse
    public /* bridge */ /* synthetic */ boolean checkResponseValidity() {
        return super.checkResponseValidity();
    }

    public void print() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String str = "test\n";
            try {
                if (this.fingerprint != null) {
                    str = "test\n" + this.fingerprint.toString(2);
                }
                if (this.user_info != null) {
                    str = str + this.user_info.toString(2);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            LogUtil.d(f26275a, str);
        }
    }

    @Override // com.baidu.wallet.paysdk.fingerprint.datamodel.a, com.baidu.apollon.beans.IBeanResponse
    public /* bridge */ /* synthetic */ void storeResponse(Context context) {
        super.storeResponse(context);
    }
}
