package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PbGoodsInfo;
/* loaded from: classes9.dex */
public class y0d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PbGoodsInfo pbGoodsInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pbGoodsInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "goods_title", pbGoodsInfo.goods_title);
            qoc.a(jSONObject, "goods_image", pbGoodsInfo.goods_image);
            qoc.a(jSONObject, "goods_price", pbGoodsInfo.goods_price);
            qoc.a(jSONObject, "goods_url", pbGoodsInfo.goods_url);
            qoc.a(jSONObject, QuickPersistConfigConst.KEY_SPLASH_SORT, pbGoodsInfo.sort);
            qoc.a(jSONObject, "goods_from", pbGoodsInfo.goods_from);
            qoc.a(jSONObject, "goods_url_h5", pbGoodsInfo.goods_url_h5);
            qoc.a(jSONObject, "goods_id", pbGoodsInfo.goods_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
