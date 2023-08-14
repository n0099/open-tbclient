package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.ThreadCardView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pageStayDuration.PageStayDurationFilter;
import com.baidu.tbadk.pageStayDuration.PageStayDurationHelper;
import com.baidu.tbadk.pageStayDuration.PageStayDurationItem;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pg9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pg9 f;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public boolean c;
    public int d;
    public int e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948061223, "Lcom/baidu/tieba/pg9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948061223, "Lcom/baidu/tieba/pg9;");
        }
    }

    /* loaded from: classes7.dex */
    public class a extends PageStayDurationFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tbadk.pageStayDuration.PageStayDurationFilter
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tbadk.pageStayDuration.PageStayDurationFilter
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public a(pg9 pg9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pg9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public pg9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.b = 0L;
        this.c = false;
        this.d = 0;
        this.d = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds144);
        this.e = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
    }

    public static pg9 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f == null) {
                synchronized (pg9.class) {
                    if (f == null) {
                        f = new pg9();
                    }
                }
            }
            return f;
        }
        return (pg9) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            f = null;
            this.a = 0L;
            this.c = false;
            this.b = 0L;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a == 0) {
            this.a = System.currentTimeMillis();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.b == 0) {
            this.b = System.currentTimeMillis();
        }
    }

    public final boolean b(View view2, ListView listView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, listView)) == null) {
            if (view2 != null) {
                int[] iArr = new int[2];
                view2.getLocationOnScreen(iArr);
                if (iArr[1] > 0 && iArr[1] < this.e - this.d) {
                    return true;
                }
            }
            if (listView == null || listView.getChildCount() <= 2) {
                return false;
            }
            View childAt = listView.getChildAt(listView.getChildCount() - 3);
            if (!(childAt instanceof ViewGroup)) {
                return false;
            }
            return ((ViewGroup) childAt).getChildAt(0) instanceof ThreadCardView;
        }
        return invokeLL.booleanValue;
    }

    public final boolean c(View view2, View view3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, view3)) == null) {
            if (view2 == null || view3 == null) {
                return false;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (view3.getVisibility() == 0) {
                return true;
            }
            if (i <= 0 || i >= this.e - this.d) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void e(Context context, PageStayDurationItem pageStayDurationItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048579, this, context, pageStayDurationItem, str) != null) || pageStayDurationItem == null || StringUtils.isNull(pageStayDurationItem.getCurrentPageKey()) || !new a(this).canStat(pageStayDurationItem)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_source", PageStayDurationHelper.toSourceTraceString(pageStayDurationItem.getSorceKeyList()));
        statisticItem.param("obj_type", pageStayDurationItem.getCurrentPageKey());
        statisticItem.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(pageStayDurationItem.getStayDurationTime()));
        if (pageStayDurationItem.getFid() > 0) {
            statisticItem.param("fid", String.valueOf(pageStayDurationItem.getFid()));
        }
        if (pageStayDurationItem.getTid() > 0) {
            statisticItem.param("tid", String.valueOf(pageStayDurationItem.getTid()));
        }
        if (!StringUtils.isNull(pageStayDurationItem.getNid())) {
            statisticItem.param("nid", pageStayDurationItem.getNid());
        }
        if (pageStayDurationItem.getPid() > 0) {
            statisticItem.param("pid", String.valueOf(pageStayDurationItem.getPid()));
        }
        if (!StringUtils.isNull(pageStayDurationItem.objParam1)) {
            statisticItem.param("obj_param1", pageStayDurationItem.objParam1);
        }
        if (!StringUtils.isNull(pageStayDurationItem.isVertical)) {
            statisticItem.param(TiebaStatic.Params.IS_VERTICAL, pageStayDurationItem.isVertical);
        }
        if (!StringUtils.isNull(pageStayDurationItem.isDynamic)) {
            statisticItem.param("is_dynamic", pageStayDurationItem.isDynamic);
        }
        if (!StringUtils.isNull(pageStayDurationItem.resourceId)) {
            statisticItem.param("resource_id", pageStayDurationItem.resourceId);
        }
        if (!bi.isEmpty(pageStayDurationItem.getTaskId())) {
            statisticItem.param("task_id", String.valueOf(pageStayDurationItem.getTaskId()));
        }
        if (!bi.isEmpty(pageStayDurationItem.getAbTag())) {
            statisticItem.param("ab_tag", pageStayDurationItem.getAbTag());
        }
        if (!StringUtils.isNull(pageStayDurationItem.getObjLocation())) {
            statisticItem.param("obj_location", pageStayDurationItem.getObjLocation());
        }
        dr5.b(context, statisticItem, pageStayDurationItem);
        TiebaStatic.log(statisticItem);
    }

    public void f(boolean z, View view2, View view3, PageStayDurationItem pageStayDurationItem, boolean z2, View view4, ListView listView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), view2, view3, pageStayDurationItem, Boolean.valueOf(z2), view4, listView}) == null) {
            if (this.c) {
                z = false;
            } else {
                this.c = z;
            }
            if (!c(view2, view3) && (!z || z2)) {
                if (z2) {
                    j(pageStayDurationItem);
                }
            } else {
                g();
            }
            if (b(view4, listView)) {
                h();
            } else {
                k(pageStayDurationItem);
            }
        }
    }

    public void i(AbsPbActivity absPbActivity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, absPbActivity) == null) && absPbActivity != null) {
            j(absPbActivity.getPageStayDurationItem());
            k(absPbActivity.getPageStayDurationItem());
        }
    }

    public final void j(PageStayDurationItem pageStayDurationItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pageStayDurationItem) == null) && this.a > 0) {
            this.a = 0L;
            pageStayDurationItem.setStayDurationTime(System.currentTimeMillis() - this.a);
            e(TbadkCoreApplication.getInst(), pageStayDurationItem, "c14085");
        }
    }

    public final void k(PageStayDurationItem pageStayDurationItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, pageStayDurationItem) == null) && this.b > 0) {
            this.b = 0L;
            pageStayDurationItem.setStayDurationTime(System.currentTimeMillis() - this.b);
            e(TbadkCoreApplication.getInst(), pageStayDurationItem, "rec_stime");
        }
    }
}
