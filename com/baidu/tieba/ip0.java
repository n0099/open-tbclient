package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.ParseError;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ip0 extends AdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final lp0 r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ip0(@NonNull sp0 sp0Var, @NonNull JSONObject jSONObject) throws ParseError {
        super(sp0Var, jSONObject);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sp0Var, jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((sp0) objArr2[0], (JSONObject) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (sp0Var.k.size() >= 1) {
            this.r = sp0Var.k.get(0);
            return;
        }
        throw ParseError.contentError(3, sp0Var.a.value);
    }
}
