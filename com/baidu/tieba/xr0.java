package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.ParseError;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class xr0 extends AdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xr0(@NonNull nr0 nr0Var, @NonNull JSONObject jSONObject) throws ParseError {
        super(nr0Var, jSONObject);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nr0Var, jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((nr0) objArr2[0], (JSONObject) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xr0(@NonNull nr0 nr0Var, @NonNull JSONObject jSONObject, boolean z) throws ParseError {
        super(nr0Var, jSONObject, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nr0Var, jSONObject, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((nr0) objArr2[0], (JSONObject) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
