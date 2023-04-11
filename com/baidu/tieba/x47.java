package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import tbclient.ForumToolPerm;
/* loaded from: classes6.dex */
public class x47 {
    public static /* synthetic */ Interceptable $ic;
    public static UserData a;
    public static boolean b;
    public static String c;
    public transient /* synthetic */ FieldHolder $fh;

    public static UserData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return a;
        }
        return (UserData) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return c;
        }
        return (String) invokeV.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            UserData a2 = a();
            if (a2 == null || a2.getIs_manager() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            UserData a2 = a();
            if (a2 == null || a2.getIs_manager() != 3) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return b;
        }
        return invokeV.booleanValue;
    }

    public static UserData b(FrsViewData frsViewData) {
        InterceptResult invokeL;
        UserData userData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, frsViewData)) == null) {
            if (frsViewData != null) {
                userData = frsViewData.getUserData();
            } else {
                userData = null;
            }
            a = userData;
            return userData;
        }
        return (UserData) invokeL.objValue;
    }

    public static boolean d(UserData userData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, userData)) == null) {
            if (userData == null) {
                return false;
            }
            int is_manager = userData.getIs_manager();
            if (is_manager != 1 && is_manager != 2 && is_manager != 3 && is_manager != 4) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            UserData a2 = a();
            if (a2 != null && (forumToolAuth = a2.getForumToolAuth()) != null) {
                for (int i = 0; i < forumToolAuth.size(); i++) {
                    ForumToolPerm forumToolPerm = forumToolAuth.get(i);
                    if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void i(pw pwVar, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65544, null, pwVar, frsViewData) != null) || pwVar == null) {
            return;
        }
        if (frsViewData != null && frsViewData.getForum() != null) {
            b = frsViewData.getForum().isFrsMask();
            c = frsViewData.getForum().getId();
        }
        if (frsViewData != null && (d(b(frsViewData)) || h())) {
            pwVar.f(4);
        } else {
            pwVar.g(4);
        }
    }

    public static void j(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65545, null, threadCommentAndPraiseInfoLayout, frsViewData) != null) || threadCommentAndPraiseInfoLayout == null) {
            return;
        }
        if (frsViewData != null && frsViewData.getForum() != null) {
            b = frsViewData.getForum().isFrsMask();
            c = frsViewData.getForum().getId();
        }
        if (frsViewData != null && d(b(frsViewData))) {
            threadCommentAndPraiseInfoLayout.setManageVisible(true);
        } else {
            threadCommentAndPraiseInfoLayout.setManageVisible(false);
        }
    }
}
