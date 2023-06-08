package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.AdMixFloor;
import tbclient.FrsTabInfo;
/* loaded from: classes8.dex */
public class zs7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    public zs7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return UbsABTestHelper.isFrsFunAdSdkTest();
        }
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static zs7 a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) {
            if (z && d()) {
                return new zs7();
            }
            return null;
        }
        return (zs7) invokeZ.objValue;
    }

    public static boolean e(FrsTabInfo frsTabInfo, int i) {
        InterceptResult invokeLI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, frsTabInfo, i)) == null) {
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return false;
            }
            if ((frsTabInfo == null || 505 != frsTabInfo.tab_id.intValue() || 91 != frsTabInfo.tab_type.intValue()) && i != 2) {
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public void b(List<vn> list, boolean z, String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{list, Boolean.valueOf(z), str}) == null) {
            int h = ss7.m().h();
            if (z) {
                i = ss7.m().i() - 1;
                for (vn vnVar : list) {
                    if (vnVar instanceof ThreadData) {
                        if (((ThreadData) vnVar).getIs_top() != 1) {
                            break;
                        }
                        i++;
                    }
                }
            } else {
                i = this.a;
            }
            this.a = c(i, h, list, str);
        }
    }

    public final int c(int i, int i2, List<vn> list, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), list, str})) == null) {
            int i3 = 0;
            if (list != null && list.size() != 0) {
                if (i > list.size() - 1) {
                    return 0;
                }
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    if (i4 >= list.size()) {
                        break;
                    }
                    ThreadData threadData = new ThreadData();
                    hy9 hy9Var = new hy9();
                    hy9Var.n(true);
                    threadData.funAdData = hy9Var;
                    hy9Var.m(str);
                    list.add(i, threadData);
                    if (i5 == 0) {
                        i5 = i + 1;
                    }
                    i = i + i2 + 1;
                    if (i > list.size() - 1) {
                        i3 = (i - (list.size() - 1)) - 1;
                        break;
                    }
                    i4++;
                }
                if (i5 > 0 && h66.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                    h66.i().n(list, i5, 2);
                }
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    public void g(List<vn> list, List<AdMixFloor> list2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{list, list2, Boolean.valueOf(z), str}) == null) {
            if (((AdMixFloor) ListUtils.getItem(list2, 0)) == null) {
                return;
            }
            int i = 0;
            for (int i2 = 0; z && i2 < list.size(); i2++) {
                vn vnVar = list.get(i2);
                if (vnVar instanceof ThreadData) {
                    if (((ThreadData) vnVar).getIs_top() != 1) {
                        break;
                    }
                    i++;
                }
            }
            int i3 = 0;
            for (int i4 = 0; i4 < list2.size(); i4++) {
                AdMixFloor adMixFloor = list2.get(i4);
                if (adMixFloor.ad_type.intValue() != 1) {
                    ThreadData threadData = new ThreadData();
                    hy9 hy9Var = new hy9();
                    hy9Var.n(true);
                    threadData.funAdData = hy9Var;
                    hy9Var.m(str);
                    ListUtils.add(list, (adMixFloor.floor_num.intValue() + i) - 1, threadData);
                    if (i3 == 0) {
                        i3 = adMixFloor.floor_num.intValue() + i;
                    }
                }
            }
            if (i3 > 0 && h66.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                h66.i().n(list, i3, 2);
            }
        }
    }
}
