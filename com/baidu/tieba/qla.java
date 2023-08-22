package com.baidu.tieba;

import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qla {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ICardInfo a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("card_type", i);
                return u19.h().b(jSONObject, i);
            } catch (CardParseException | JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (ICardInfo) invokeI.objValue;
    }

    public static String c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            return d(i, 0);
        }
        return (String) invokeI.objValue;
    }

    public static ICardInfo b(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65537, null, i, i2)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("goods_style", i2);
                jSONObject2.put("card_type", i);
                jSONObject.put("ad_common", jSONObject2);
                jSONObject.put("card_type", i);
                return u19.h().b(jSONObject, i);
            } catch (CardParseException | JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (ICardInfo) invokeII.objValue;
    }

    public static String d(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i, i2)) == null) {
            return "ad_card_" + i + "_" + i2;
        }
        return (String) invokeII.objValue;
    }
}
