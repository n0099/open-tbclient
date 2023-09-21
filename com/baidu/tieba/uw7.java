package com.baidu.tieba;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class uw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 5) {
                        if (i != 6) {
                            if (i != 7) {
                                return i != 8 ? -1 : 4;
                            }
                            return 3;
                        }
                        return 2;
                    }
                    return 0;
                }
                return 1;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public static int f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return i != 4 ? -1 : 8;
                        }
                        return 7;
                    }
                    return 6;
                }
                return 3;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    public static int g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return 1;
                        }
                        if (i != 4) {
                            return -1;
                        }
                    }
                    return 4;
                }
                return 3;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            try {
                SharedPreferences.Editor edit = c().edit();
                edit.clear();
                edit.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return "pref_name_frs_sortType_" + TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeV.objValue;
    }

    public static SharedPreferences c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return TbadkCoreApplication.getInst().getSharedPreferences(b(), 0);
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public static int e(int i, FrsRequestData frsRequestData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, frsRequestData)) == null) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 5) {
                        if (i != 6) {
                            if (i != 7) {
                                if (i == 8 && frsRequestData != null) {
                                    frsRequestData.setSortType(4);
                                    frsRequestData.b0(0);
                                }
                            } else if (frsRequestData != null) {
                                frsRequestData.setSortType(3);
                                frsRequestData.b0(0);
                            }
                        } else if (frsRequestData != null) {
                            frsRequestData.setSortType(2);
                            frsRequestData.b0(0);
                        }
                    } else if (frsRequestData != null) {
                        frsRequestData.setSortType(0);
                        frsRequestData.b0(1);
                    }
                } else if (frsRequestData != null) {
                    frsRequestData.setSortType(1);
                    frsRequestData.b0(0);
                }
            } else if (frsRequestData != null) {
                frsRequestData.setSortType(0);
                frsRequestData.b0(0);
            }
            return 1;
        }
        return invokeIL.intValue;
    }

    public static int h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            try {
                return c().getInt(str, -1);
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static void i(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65544, null, str, i) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            SharedPreferences.Editor edit = c().edit();
            edit.putInt(str, i);
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
