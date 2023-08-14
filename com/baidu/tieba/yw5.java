package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewGroupKt;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
/* loaded from: classes8.dex */
public final class yw5 {
    public static /* synthetic */ Interceptable $ic;
    public static final yw5 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948344594, "Lcom/baidu/tieba/yw5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948344594, "Lcom/baidu/tieba/yw5;");
                return;
            }
        }
        a = new yw5();
    }

    public yw5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @JvmStatic
    public static final void a(View view2, View view3, View view4, View view5, UserIconBox userIconBox, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{view2, view3, view4, view5, userIconBox, Integer.valueOf(i)}) == null) {
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(view2);
            arrayList.add(view3);
            arrayList.add(view4);
            arrayList.add(view5);
            b(arrayList, userIconBox, i);
        }
    }

    @JvmStatic
    public static final void b(List<? extends View> views, UserIconBox userIconBox, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, null, views, userIconBox, i) == null) {
            Intrinsics.checkNotNullParameter(views, "views");
            new StatisticItem("c15270").addParam("obj_locate", a.e(views).toString()).addParam("obj_type", a.d(userIconBox).toString()).addParam("obj_source", i).eventStat();
        }
    }

    @JvmStatic
    public static final void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", str2);
            statisticItem.param("obj_locate", str3);
            TiebaStatic.log(statisticItem);
        }
    }

    public final StringBuilder d(UserIconBox userIconBox) {
        InterceptResult invokeL;
        Sequence<View> children;
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, userIconBox)) == null) {
            StringBuilder sb = new StringBuilder();
            if (userIconBox != null && (children = ViewGroupKt.getChildren(userIconBox)) != null) {
                int i = 0;
                for (View view2 : children) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    View view3 = view2;
                    if (view3 instanceof TbImageView) {
                        tbImageView = (TbImageView) view3;
                    } else {
                        tbImageView = null;
                    }
                    if (tbImageView != null && tbImageView.getVisibility() == 0) {
                        sb.append(tbImageView.getUrl());
                        if (i != userIconBox.getChildCount() - 1) {
                            sb.append(",");
                        }
                    }
                    i = i2;
                }
            }
            return sb;
        }
        return (StringBuilder) invokeL.objValue;
    }

    public final StringBuilder e(List<? extends View> list) {
        InterceptResult invokeL;
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                View view2 = (View) obj;
                if (view2 != null && view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    str = "1";
                } else {
                    str = "0";
                }
                sb.append(str);
                if (i != list.size() - 1) {
                    sb.append(",");
                }
                i = i2;
            }
            return sb;
        }
        return (StringBuilder) invokeL.objValue;
    }
}
