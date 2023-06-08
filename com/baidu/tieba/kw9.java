package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class kw9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<BdUniqueId, ArrayList<StatisticItem>> a;
    public String[] b;

    public kw9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new String[]{TiebaStatic.Params.OBJ_FLOOR, TiebaStatic.Params.OBJ_ISAD, "obj_id", "tid", "pid", "thread_type", "fid", TiebaStatic.Params.POST_TYPE, TiebaStatic.Params.IS_OFFICIAL, TiebaStatic.Params.OBJ_AD_LOCATE, TiebaStatic.Params.RECOM_WEIGHT, "recom_source", TiebaStatic.Params.RECOM_AB_TAG, TiebaStatic.Params.RECOM_EXTRA, TiebaStatic.Params.RECOM_TYPE, TiebaStatic.Params.UGC_VID, TiebaStatic.Params.UGC_NID, TiebaStatic.Params.UGC_TYPE, "obj_locate", TiebaStatic.Params.LIST_ORDER, TiebaStatic.Params.IS_SPECIAL_THREAD, TiebaStatic.Params.OBJ_PARAM3};
        if (this.a == null) {
            this.a = new LinkedHashMap();
        }
    }

    public void a(BdUniqueId bdUniqueId, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, bdUniqueId, statisticItem) == null) && statisticItem != null && bdUniqueId != null) {
            ArrayList<StatisticItem> arrayList = this.a.get(bdUniqueId);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.a.put(bdUniqueId, arrayList);
            }
            arrayList.add(statisticItem);
        }
    }

    public void d(BdUniqueId bdUniqueId, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048579, this, bdUniqueId, z) != null) || bdUniqueId == null) {
            return;
        }
        ArrayList<StatisticItem> arrayList = this.a.get(bdUniqueId);
        if (ListUtils.getCount(arrayList) == 0) {
            return;
        }
        e(arrayList);
        arrayList.clear();
    }

    public final String b(List<Object> list, String str) {
        InterceptResult invokeLL;
        int indexOf;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, str)) == null) {
            if (ListUtils.getCount(list) == 0 || StringUtils.isNull(str) || (indexOf = list.indexOf(str)) < 0 || list.size() <= (i = indexOf + 1)) {
                return "";
            }
            String valueOf = String.valueOf(list.get(i));
            if (StringUtils.isNull(valueOf, true)) {
                return "";
            }
            return valueOf;
        }
        return (String) invokeLL.objValue;
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            return this.a.containsKey(bdUniqueId);
        }
        return invokeL.booleanValue;
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        this.a.put(bdUniqueId, null);
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        this.a.remove(bdUniqueId);
    }

    public final void e(ArrayList<StatisticItem> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) && arrayList != null && ListUtils.getCount(arrayList) != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (ListUtils.getCount(arrayList) == 1) {
                TiebaStatic.log((StatisticItem) ListUtils.getItem(arrayList, 0));
            } else {
                HashMap hashMap = new HashMap();
                for (int i = 0; i < arrayList.size(); i++) {
                    StatisticItem statisticItem = arrayList.get(i);
                    if (hashMap.containsKey(statisticItem.getKey())) {
                        ((List) hashMap.get(statisticItem.getKey())).add(statisticItem);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(statisticItem);
                        hashMap.put(statisticItem.getKey(), arrayList2);
                    }
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    List list = (List) entry.getValue();
                    if (ListUtils.getCount(list) != 0) {
                        StatisticItem statisticItem2 = (StatisticItem) list.get(0);
                        for (int i2 = 0; i2 < this.b.length; i2++) {
                            StringBuilder sb = new StringBuilder();
                            for (int i3 = 0; i3 < list.size(); i3++) {
                                sb.append(b(((StatisticItem) list.get(i3)).getParams(), this.b[i2]));
                                sb.append("|");
                            }
                            if (sb.length() > 0) {
                                sb.deleteCharAt(sb.length() - 1);
                            }
                            statisticItem2.delete(this.b[i2]);
                            statisticItem2.param(this.b[i2] + "s", sb.toString());
                        }
                        TiebaStatic.log(statisticItem2);
                    }
                }
                if (!hashMap.isEmpty()) {
                    hashMap.clear();
                }
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("logStatisticByKey->" + (System.currentTimeMillis() - currentTimeMillis) + "|size=" + arrayList.size());
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || this.a.size() == 0) {
            return;
        }
        for (Map.Entry<BdUniqueId, ArrayList<StatisticItem>> entry : this.a.entrySet()) {
            ArrayList<StatisticItem> value = entry.getValue();
            if (value != null) {
                value.clear();
            }
        }
    }
}
