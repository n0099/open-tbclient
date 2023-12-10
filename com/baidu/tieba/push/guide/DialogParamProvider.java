package com.baidu.tieba.push.guide;

import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tieba.fga;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
@Keep
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0017J\b\u0010\u0005\u001a\u00020\u0003H\u0017J\b\u0010\u0006\u001a\u00020\u0003H\u0017J\b\u0010\u0007\u001a\u00020\u0003H\u0017J\b\u0010\b\u001a\u00020\u0003H\u0017J\b\u0010\t\u001a\u00020\u0003H\u0017J\b\u0010\n\u001a\u00020\u0003H\u0017J\b\u0010\u000b\u001a\u00020\u0003H\u0017J\b\u0010\f\u001a\u00020\u0003H\u0017¨\u0006\r"}, d2 = {"Lcom/baidu/tieba/push/guide/DialogParamProvider;", "", "provideForumIcon", "", "provideForumId", "provideForumName", "provideForumSlogan", "provideNickname", "providePortrait", "provideThreadAbstract", "provideThreadId", "provideThreadTitle", "provideUserId", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface DialogParamProvider {

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @fga(paramKey = "forum_icon")
        public static String a(DialogParamProvider dialogParamProvider) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, dialogParamProvider)) == null) ? "" : (String) invokeL.objValue;
        }

        @fga(paramKey = "forum_id")
        public static String b(DialogParamProvider dialogParamProvider) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dialogParamProvider)) == null) ? "" : (String) invokeL.objValue;
        }

        @fga(paramKey = "forum_name")
        public static String c(DialogParamProvider dialogParamProvider) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dialogParamProvider)) == null) ? "" : (String) invokeL.objValue;
        }

        @fga(paramKey = "forum_slogan")
        public static String d(DialogParamProvider dialogParamProvider) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, dialogParamProvider)) == null) ? "" : (String) invokeL.objValue;
        }

        @fga(paramKey = "thread_abstract")
        public static String e(DialogParamProvider dialogParamProvider) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, dialogParamProvider)) == null) ? "" : (String) invokeL.objValue;
        }

        @fga(paramKey = "thread_id")
        public static String f(DialogParamProvider dialogParamProvider) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, dialogParamProvider)) == null) ? "" : (String) invokeL.objValue;
        }

        @fga(paramKey = MissonDetailsActivityConfig.THREAD_TITLE)
        public static String g(DialogParamProvider dialogParamProvider) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, dialogParamProvider)) == null) ? "" : (String) invokeL.objValue;
        }
    }

    @fga(paramKey = "forum_icon")
    String provideForumIcon();

    @fga(paramKey = "forum_id")
    String provideForumId();

    @fga(paramKey = "forum_name")
    String provideForumName();

    @fga(paramKey = "forum_slogan")
    String provideForumSlogan();

    @fga(paramKey = "nickname")
    String provideNickname();

    @fga(paramKey = "portrait")
    String providePortrait();

    @fga(paramKey = "thread_abstract")
    String provideThreadAbstract();

    @fga(paramKey = "thread_id")
    String provideThreadId();

    @fga(paramKey = MissonDetailsActivityConfig.THREAD_TITLE)
    String provideThreadTitle();

    @fga(paramKey = "user_id")
    String provideUserId();
}
