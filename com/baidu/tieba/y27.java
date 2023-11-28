package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class y27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? "frs_empty_advert" : (String) invokeV.objValue;
    }

    public static ICardInfo a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("card_type", i);
                return nf9.h().b(jSONObject, i);
            } catch (CardParseException | JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (ICardInfo) invokeI.objValue;
    }

    public static String d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            return e(i, 0);
        }
        return (String) invokeI.objValue;
    }

    public static boolean h(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, advertAppInfo)) == null) {
            if (advertAppInfo == null) {
                return true;
            }
            return advertAppInfo.b();
        }
        return invokeL.booleanValue;
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
                return nf9.h().b(jSONObject, i);
            } catch (CardParseException | JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (ICardInfo) invokeII.objValue;
    }

    public static String e(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2)) == null) {
            return "ad_card_" + i + "_" + i2;
        }
        return (String) invokeII.objValue;
    }

    public static int f(@NonNull List<nb7<?>> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            int i = 0;
            if (zf9.e(list)) {
                return 0;
            }
            for (int i2 = zf9.i(list) - 1; i2 >= 0; i2--) {
                nb7 nb7Var = (nb7) zf9.d(list, i2);
                if (nb7Var != null) {
                    if (nb7Var.b() instanceof vx4) {
                        break;
                    }
                    i++;
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static String g(List<nb7<?>> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !zf9.e(list)) {
                int i = 0;
                for (int i2 = zf9.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    nb7 nb7Var = (nb7) zf9.d(list, i2);
                    if (nb7Var != null && (nb7Var.b() instanceof vx4)) {
                        vx4 vx4Var = (vx4) nb7Var.b();
                        if (!h(vx4Var.w())) {
                            sb.append(vx4Var.m() + 1);
                            sb.append(",");
                            i++;
                        }
                    }
                }
                if (sb.length() <= 1) {
                    return sb.toString();
                }
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }
}
