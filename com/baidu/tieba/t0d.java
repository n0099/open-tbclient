package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes8.dex */
public class t0d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Page page) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, page)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, SuggestAddrField.KEY_PAGE_SIZE, page.page_size);
            qoc.a(jSONObject, "offset", page.offset);
            qoc.a(jSONObject, "current_page", page.current_page);
            qoc.a(jSONObject, "total_count", page.total_count);
            qoc.a(jSONObject, "total_page", page.total_page);
            qoc.a(jSONObject, "has_more", page.has_more);
            qoc.a(jSONObject, "has_prev", page.has_prev);
            qoc.a(jSONObject, "cur_good_id", page.cur_good_id);
            qoc.a(jSONObject, "req_num", page.req_num);
            qoc.a(jSONObject, "pnum", page.pnum);
            qoc.a(jSONObject, "tnum", page.tnum);
            qoc.a(jSONObject, "total_num", page.total_num);
            qoc.a(jSONObject, "lz_total_floor", page.lz_total_floor);
            qoc.a(jSONObject, "new_total_page", page.new_total_page);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
