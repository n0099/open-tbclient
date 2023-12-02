package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes8.dex */
public class v5d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Page page) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, page)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, SuggestAddrField.KEY_PAGE_SIZE, page.page_size);
            ktc.a(jSONObject, "offset", page.offset);
            ktc.a(jSONObject, "current_page", page.current_page);
            ktc.a(jSONObject, "total_count", page.total_count);
            ktc.a(jSONObject, "total_page", page.total_page);
            ktc.a(jSONObject, "has_more", page.has_more);
            ktc.a(jSONObject, "has_prev", page.has_prev);
            ktc.a(jSONObject, "cur_good_id", page.cur_good_id);
            ktc.a(jSONObject, "req_num", page.req_num);
            ktc.a(jSONObject, "pnum", page.pnum);
            ktc.a(jSONObject, "tnum", page.tnum);
            ktc.a(jSONObject, "total_num", page.total_num);
            ktc.a(jSONObject, "lz_total_floor", page.lz_total_floor);
            ktc.a(jSONObject, "new_total_page", page.new_total_page);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
