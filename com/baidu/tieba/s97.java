package com.baidu.tieba;

import com.baidu.tieba.feed.data.ThreadManageType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.LayoutManageInfo;
/* loaded from: classes8.dex */
public final class s97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final d87 a(LayoutManageInfo layoutManageInfo) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, layoutManageInfo)) == null) {
            String str = layoutManageInfo.text;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return null;
            }
            String text = layoutManageInfo.text;
            Intrinsics.checkNotNullExpressionValue(text, "text");
            Integer type = layoutManageInfo.type;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            d87 d87Var = new d87(text, type.intValue());
            try {
                String ext = layoutManageInfo.ext;
                Intrinsics.checkNotNullExpressionValue(ext, "ext");
                Integer type2 = layoutManageInfo.type;
                Intrinsics.checkNotNullExpressionValue(type2, "type");
                Object c = c(ext, type2.intValue());
                if (c == null) {
                    return null;
                }
                d87Var.d(c);
                return d87Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (d87) invokeL.objValue;
    }

    public static final List<d87> b(List<LayoutManageInfo> list) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (LayoutManageInfo layoutManageInfo : list) {
                d87 a = a(layoutManageInfo);
                if (a != null) {
                    arrayList.add(a);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static final Object c(String str, int i) throws Exception {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            JSONObject jSONObject = new JSONObject(str);
            int i2 = 0;
            if (i == ThreadManageType.ID_DEL.getValue()) {
                JSONArray jSONArray = jSONObject.getJSONArray("reason_list");
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                while (i2 < length) {
                    e67 a = f67.a(jSONArray.optJSONObject(i2));
                    if (a != null) {
                        arrayList.add(a);
                    }
                    i2++;
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                return d67.a(arrayList, ra7.a.b(jSONObject.optJSONArray("business_info")));
            } else if (i == ThreadManageType.ID_FORBID.getValue()) {
                return v67.a(ra7.a.b(jSONObject.optJSONArray("business_info")));
            } else {
                if (i == ThreadManageType.ID_TOP.getValue()) {
                    return g87.a(ra7.a.b(jSONObject.optJSONArray("business_info")));
                }
                if (i == ThreadManageType.ID_GOOD.getValue()) {
                    return y67.a(ra7.a.b(jSONObject.optJSONArray("business_info")));
                }
                if (i == ThreadManageType.ID_MULTI_DEL.getValue()) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("reason_list");
                    ArrayList arrayList2 = new ArrayList();
                    int length2 = jSONArray2.length();
                    while (i2 < length2) {
                        e67 a2 = f67.a(jSONArray2.optJSONObject(i2));
                        if (a2 != null) {
                            arrayList2.add(a2);
                        }
                        i2++;
                    }
                    if (arrayList2.isEmpty()) {
                        return null;
                    }
                    return d67.a(arrayList2, ra7.a.b(jSONObject.optJSONArray("business_info")));
                } else if (i == ThreadManageType.ID_RECOMMEND.getValue()) {
                    return v77.a(n57.a(jSONObject.optJSONObject("bawu_thrones")), ra7.a.b(jSONObject.optJSONArray("business_info")));
                } else {
                    if (i == ThreadManageType.ID_MOVE_AREA.getValue()) {
                        JSONArray jSONArray3 = jSONObject.getJSONArray("tab_list");
                        ArrayList arrayList3 = new ArrayList();
                        int length3 = jSONArray3.length();
                        while (i2 < length3) {
                            n77 a3 = m77.a(jSONArray3.optJSONObject(i2));
                            if (a3 != null) {
                                arrayList3.add(a3);
                            }
                            i2++;
                        }
                        if (arrayList3.isEmpty()) {
                            return null;
                        }
                        return o77.a(arrayList3, ra7.a.b(jSONObject.optJSONArray("business_info")));
                    } else if (i != ThreadManageType.ID_BROADCAST.getValue()) {
                        return null;
                    } else {
                        return p57.a(ra7.a.b(jSONObject.optJSONArray("business_info")));
                    }
                }
            }
        }
        return invokeLI.objValue;
    }
}
