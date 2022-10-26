package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tieba.jo2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class la3 extends oa3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String k;

    public la3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = "";
    }

    @Override // com.baidu.tieba.oa3
    public JSONObject f() {
        InterceptResult invokeV;
        m33 D;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.h == null) {
                this.h = new JSONObject();
            }
            if (TextUtils.isEmpty(this.k) && (D = zo2.U().D()) != null) {
                jo2.a Y = D.Y();
                if (Y != null) {
                    str = Y.T();
                } else {
                    str = "";
                }
                this.k = str;
            }
            try {
                this.h.put("source", this.k);
                String b = mx2.b();
                if (b != null) {
                    this.h.put("launchid", b);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return super.f();
        }
        return (JSONObject) invokeV.objValue;
    }
}
