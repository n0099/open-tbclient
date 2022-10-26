package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class vc5 {
    public static /* synthetic */ Interceptable $ic;
    public static vc5 c;
    public transient /* synthetic */ FieldHolder $fh;
    public List a;
    public List b;

    public vc5() {
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
        this.a = i(ux4.k().q("key_need_add_source_stat_list", ""));
        this.b = i("c12897,c12896,c12895,c12894,c12893,c12892,c12891,c12890,c13274,c12905,c12003,c13271,c12899,c11244,c11032,c12904,c13273,c13433,c10295,c12320,c12835,c10297,c13136,c12910,c10734,c10735,common_click,c10730,c10731,c11439,c10705,c13147,c13388,c13389,c10756,c10296,c10755,c13407,c13406,c12590,c10751,c12888,c12889,consume_33,c11824,c11823,consume_34,c12902,c12898,consume_24,c12887,c12909,c12908,c12942,c12901,c12900,c12903,c13008,c13146,common_exp,c12907,c12906,c10750,consume_3,c11887,c11438,c10704,c10484,c10709,c10708,c12386,c12384");
    }

    public static void b(Context context, StatisticItem statisticItem, cd5 cd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, context, statisticItem, cd5Var) == null) && cd5Var != null && statisticItem != null && !TextUtils.isEmpty(statisticItem.getKey())) {
            tc5 k = cd5Var.k();
            if (k == null || k.f()) {
                k = TbPageExtraHelper.getCurrentVisiblePageExtra(context);
            }
            if (k != null && !k.f()) {
                c(statisticItem, k);
            }
            TbPageExtraHelper.printLog(statisticItem.toString());
        }
    }

    public static void c(StatisticItem statisticItem, tc5 tc5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, statisticItem, tc5Var) == null) && statisticItem != null && tc5Var != null && !TextUtils.isEmpty(statisticItem.getKey())) {
            String a = tc5Var.a();
            if (!TextUtils.isEmpty(a) && !statisticItem.hasParam("page_key")) {
                statisticItem.param("page_key", a);
            }
            String a2 = uc5.a(tc5Var.d(), a, 6);
            if (!TextUtils.isEmpty(a2) && !statisticItem.hasParam("page_source")) {
                statisticItem.param("page_source", a2);
            }
        }
    }

    public static vc5 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (vc5.class) {
                    if (c == null) {
                        c = new vc5();
                    }
                }
            }
            return c;
        }
        return (vc5) invokeV.objValue;
    }

    public final void a(StatisticItem statisticItem) {
        Activity currentActivity;
        tc5 currentVisiblePageExtra;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, statisticItem) != null) || statisticItem == null || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(currentActivity)) == null) {
            return;
        }
        String a = currentVisiblePageExtra.a();
        if (!TextUtils.isEmpty(a) && !statisticItem.hasParam("page_key")) {
            statisticItem.param("page_key", a);
        }
        String b = currentVisiblePageExtra.b();
        if (!TextUtils.isEmpty(b) && !statisticItem.hasParam("page_tag")) {
            statisticItem.param("page_tag", b);
        }
        ArrayList<String> d = currentVisiblePageExtra.d();
        String a2 = uc5.a(d, a, 6);
        if (statisticItem.getKey().equals("common_exp") && statisticItem.hasParam("common_exp_source_pb_comment") && d.size() == 0 && (currentActivity instanceof zc5)) {
            List currentPageSourceKeyList = ((zc5) currentActivity).getCurrentPageSourceKeyList();
            if (currentPageSourceKeyList instanceof ArrayList) {
                a2 = uc5.a((ArrayList) currentPageSourceKeyList, a, 6);
                statisticItem.delete("common_exp_source_pb_comment");
            }
        }
        if (!TextUtils.isEmpty(a2) && !statisticItem.hasParam("page_source")) {
            statisticItem.param("page_source", a2);
        }
        TbPageExtraHelper.printLog(statisticItem.toString());
    }

    public final List d(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr)) == null) {
            if (objArr != null && objArr.length != 0) {
                ArrayList arrayList = new ArrayList(objArr.length);
                for (Object obj : objArr) {
                    if (obj != null && !TextUtils.isEmpty(obj.toString())) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!ListUtils.isEmpty(this.b) && !ej.isEmpty(str)) {
                for (String str2 : this.b) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (!ListUtils.isEmpty(this.a) && !ej.isEmpty(str)) {
                for (String str2 : this.a) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void e(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, statisticItem) == null) && statisticItem != null && !statisticItem.hasParam("page_source")) {
            if (h(statisticItem.getKey()) || g(statisticItem.getKey())) {
                a(statisticItem);
            }
        }
    }

    public final List i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (ej.isEmpty(str)) {
                return null;
            }
            return d(str.split(","));
        }
        return (List) invokeL.objValue;
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.a = i(str);
            if (str == null) {
                str = "";
            }
            ux4.k().y("key_need_add_source_stat_list", str);
        }
    }
}
