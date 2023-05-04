package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class y02 extends u02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y02(u83 u83Var) {
        super(u83Var, "/swanAPI/canvas/measureTextSync");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u83Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((u83) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.u93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, x73 x73Var) {
        InterceptResult invokeLLLL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, x73Var)) == null) {
            unitedSchemeEntity.result = l(201);
            x22 m = m(unitedSchemeEntity);
            if (m == null) {
                return false;
            }
            String str = m.k;
            if (str != null && str.length() > 0) {
                if (m.n && m.o) {
                    i2 = 3;
                } else if (m.n) {
                    i2 = 1;
                } else if (m.o) {
                    i2 = 2;
                } else {
                    i2 = 0;
                }
                TextPaint textPaint = new TextPaint();
                textPaint.setTypeface(Typeface.create(m.l, i2));
                textPaint.setTextSize(m.m);
                Rect rect = new Rect();
                String str2 = m.k;
                textPaint.getTextBounds(str2, 0, str2.length(), rect);
                i = ol3.O(rect.width());
            } else {
                i = 0;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("width", Integer.valueOf(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public x22 m(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity)) == null) {
            String str = unitedSchemeEntity.getParams().get("params");
            if (!TextUtils.isEmpty(str)) {
                return new x22(str);
            }
            return null;
        }
        return (x22) invokeL.objValue;
    }
}
