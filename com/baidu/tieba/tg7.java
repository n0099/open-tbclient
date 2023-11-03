package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.forum.controller.AdVideoController;
import com.baidu.tieba.forum.controller.BottomController;
import com.baidu.tieba.forum.controller.LinkageController;
import com.baidu.tieba.forum.controller.MainController;
import com.baidu.tieba.forum.controller.TimeoutController;
import com.baidu.tieba.forum.controller.TopController;
import com.baidu.tieba.forum.controller.VoicePlayController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* loaded from: classes8.dex */
public final class tg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final BdUniqueId a(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if (fragmentActivity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) fragmentActivity).getUniqueId();
            }
            return null;
        }
        return (BdUniqueId) invokeL.objValue;
    }

    public static final AdVideoController b(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        AdVideoController adVideoController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof wg7) && (adVideoController = (AdVideoController) ((wg7) fragmentActivity).X1(Reflection.getOrCreateKotlinClass(AdVideoController.class))) != null) {
                return adVideoController;
            }
            throw new IllegalStateException("AdVideoController must not be null!!!");
        }
        return (AdVideoController) invokeL.objValue;
    }

    public static final BottomController c(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        BottomController bottomController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof wg7) && (bottomController = (BottomController) ((wg7) fragmentActivity).X1(Reflection.getOrCreateKotlinClass(BottomController.class))) != null) {
                return bottomController;
            }
            throw new IllegalStateException("BottomController must not be null!!!");
        }
        return (BottomController) invokeL.objValue;
    }

    public static final qg7 d(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        qg7 qg7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof wg7) && (qg7Var = (qg7) ((wg7) fragmentActivity).X1(Reflection.getOrCreateKotlinClass(qg7.class))) != null) {
                return qg7Var;
            }
            throw new IllegalStateException("ForumDIalogController must not be null!!!");
        }
        return (qg7) invokeL.objValue;
    }

    public static final LinkageController e(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        LinkageController linkageController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof wg7) && (linkageController = (LinkageController) ((wg7) fragmentActivity).X1(Reflection.getOrCreateKotlinClass(LinkageController.class))) != null) {
                return linkageController;
            }
            throw new IllegalStateException("LinkageController must not be null!!!");
        }
        return (LinkageController) invokeL.objValue;
    }

    public static final xg7 f(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        xg7 xg7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof wg7) && (xg7Var = (xg7) ((wg7) fragmentActivity).X1(Reflection.getOrCreateKotlinClass(xg7.class))) != null) {
                return xg7Var;
            }
            throw new IllegalStateException("LinkageStatisticController must not be null!!!");
        }
        return (xg7) invokeL.objValue;
    }

    public static final MainController g(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        MainController mainController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof wg7) && (mainController = (MainController) ((wg7) fragmentActivity).X1(Reflection.getOrCreateKotlinClass(MainController.class))) != null) {
                return mainController;
            }
            throw new IllegalStateException("MainController must not be null!!!");
        }
        return (MainController) invokeL.objValue;
    }

    public static final zg7 h(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        zg7 zg7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof wg7) && (zg7Var = (zg7) ((wg7) fragmentActivity).X1(Reflection.getOrCreateKotlinClass(zg7.class))) != null) {
                return zg7Var;
            }
            throw new IllegalStateException("NavigationBarController must not be null!!!");
        }
        return (zg7) invokeL.objValue;
    }

    public static final ch7 i(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        ch7 ch7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof wg7) && (ch7Var = (ch7) ((wg7) fragmentActivity).X1(Reflection.getOrCreateKotlinClass(ch7.class))) != null) {
                return ch7Var;
            }
            throw new IllegalStateException("PushPermissionController must not be null!!!");
        }
        return (ch7) invokeL.objValue;
    }

    public static final TimeoutController j(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        TimeoutController timeoutController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof wg7) && (timeoutController = (TimeoutController) ((wg7) fragmentActivity).X1(Reflection.getOrCreateKotlinClass(TimeoutController.class))) != null) {
                return timeoutController;
            }
            throw new IllegalStateException("TimeoutController must not be null!!!");
        }
        return (TimeoutController) invokeL.objValue;
    }

    public static final TopController k(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        TopController topController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof wg7) && (topController = (TopController) ((wg7) fragmentActivity).X1(Reflection.getOrCreateKotlinClass(TopController.class))) != null) {
                return topController;
            }
            throw new IllegalStateException("TopController must not be null!!!");
        }
        return (TopController) invokeL.objValue;
    }

    public static final VoicePlayController l(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        VoicePlayController voicePlayController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof wg7) && (voicePlayController = (VoicePlayController) ((wg7) fragmentActivity).X1(Reflection.getOrCreateKotlinClass(VoicePlayController.class))) != null) {
                return voicePlayController;
            }
            throw new IllegalStateException("VoicePlayController must not be null!!!");
        }
        return (VoicePlayController) invokeL.objValue;
    }
}
