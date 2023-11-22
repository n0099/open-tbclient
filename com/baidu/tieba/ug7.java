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
public final class ug7 {
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
            if ((fragmentActivity instanceof xg7) && (adVideoController = (AdVideoController) ((xg7) fragmentActivity).X1(Reflection.getOrCreateKotlinClass(AdVideoController.class))) != null) {
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
            if ((fragmentActivity instanceof xg7) && (bottomController = (BottomController) ((xg7) fragmentActivity).X1(Reflection.getOrCreateKotlinClass(BottomController.class))) != null) {
                return bottomController;
            }
            throw new IllegalStateException("BottomController must not be null!!!");
        }
        return (BottomController) invokeL.objValue;
    }

    public static final rg7 d(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        rg7 rg7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof xg7) && (rg7Var = (rg7) ((xg7) fragmentActivity).X1(Reflection.getOrCreateKotlinClass(rg7.class))) != null) {
                return rg7Var;
            }
            throw new IllegalStateException("ForumDIalogController must not be null!!!");
        }
        return (rg7) invokeL.objValue;
    }

    public static final LinkageController e(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        LinkageController linkageController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof xg7) && (linkageController = (LinkageController) ((xg7) fragmentActivity).X1(Reflection.getOrCreateKotlinClass(LinkageController.class))) != null) {
                return linkageController;
            }
            throw new IllegalStateException("LinkageController must not be null!!!");
        }
        return (LinkageController) invokeL.objValue;
    }

    public static final yg7 f(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        yg7 yg7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof xg7) && (yg7Var = (yg7) ((xg7) fragmentActivity).X1(Reflection.getOrCreateKotlinClass(yg7.class))) != null) {
                return yg7Var;
            }
            throw new IllegalStateException("LinkageStatisticController must not be null!!!");
        }
        return (yg7) invokeL.objValue;
    }

    public static final MainController g(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        MainController mainController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof xg7) && (mainController = (MainController) ((xg7) fragmentActivity).X1(Reflection.getOrCreateKotlinClass(MainController.class))) != null) {
                return mainController;
            }
            throw new IllegalStateException("MainController must not be null!!!");
        }
        return (MainController) invokeL.objValue;
    }

    public static final ah7 h(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        ah7 ah7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof xg7) && (ah7Var = (ah7) ((xg7) fragmentActivity).X1(Reflection.getOrCreateKotlinClass(ah7.class))) != null) {
                return ah7Var;
            }
            throw new IllegalStateException("NavigationBarController must not be null!!!");
        }
        return (ah7) invokeL.objValue;
    }

    public static final dh7 i(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        dh7 dh7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof xg7) && (dh7Var = (dh7) ((xg7) fragmentActivity).X1(Reflection.getOrCreateKotlinClass(dh7.class))) != null) {
                return dh7Var;
            }
            throw new IllegalStateException("PushPermissionController must not be null!!!");
        }
        return (dh7) invokeL.objValue;
    }

    public static final TimeoutController j(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        TimeoutController timeoutController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, fragmentActivity)) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if ((fragmentActivity instanceof xg7) && (timeoutController = (TimeoutController) ((xg7) fragmentActivity).X1(Reflection.getOrCreateKotlinClass(TimeoutController.class))) != null) {
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
            if ((fragmentActivity instanceof xg7) && (topController = (TopController) ((xg7) fragmentActivity).X1(Reflection.getOrCreateKotlinClass(TopController.class))) != null) {
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
            if ((fragmentActivity instanceof xg7) && (voicePlayController = (VoicePlayController) ((xg7) fragmentActivity).X1(Reflection.getOrCreateKotlinClass(VoicePlayController.class))) != null) {
                return voicePlayController;
            }
            throw new IllegalStateException("VoicePlayController must not be null!!!");
        }
        return (VoicePlayController) invokeL.objValue;
    }
}
