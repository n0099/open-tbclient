package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes8.dex */
public class s0d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Page page) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, page)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, SuggestAddrField.KEY_PAGE_SIZE, page.page_size);
            poc.a(jSONObject, "offset", page.offset);
            poc.a(jSONObject, "current_page", page.current_page);
            poc.a(jSONObject, "total_count", page.total_count);
            poc.a(jSONObject, "total_page", page.total_page);
            poc.a(jSONObject, "has_more", page.has_more);
            poc.a(jSONObject, "has_prev", page.has_prev);
            poc.a(jSONObject, "cur_good_id", page.cur_good_id);
            poc.a(jSONObject, "req_num", page.req_num);
            poc.a(jSONObject, "pnum", page.pnum);
            poc.a(jSONObject, "tnum", page.tnum);
            poc.a(jSONObject, "total_num", page.total_num);
            poc.a(jSONObject, "lz_total_floor", page.lz_total_floor);
            poc.a(jSONObject, "new_total_page", page.new_total_page);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
