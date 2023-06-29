package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.player.helper.NetUtils;
import com.baidu.nadcore.video.plugin.videoplayer.model.ClarityUrlList;
import com.baidu.tieba.su0;
import com.baidu.tieba.to0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Pair;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
@JvmName(name = "VideoClarity")
/* loaded from: classes7.dex */
public final class p21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final Pair<Integer, Integer> a(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65536, null, i, i2, i3)) == null) {
            if (i <= 0) {
                return new Pair<>(0, Integer.valueOf(i2));
            }
            if (i >= i3) {
                return new Pair<>(Integer.valueOf(i3 - 1), Integer.valueOf(i2));
            }
            return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
        }
        return (Pair) invokeIII.objValue;
    }

    public static final Pair<Integer, Integer> b(int i, Pair<Integer, Integer> pair, int i2, int i3, double d, ClarityUrlList clarityUrlList, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), pair, Integer.valueOf(i2), Integer.valueOf(i3), Double.valueOf(d), clarityUrlList, Integer.valueOf(i4)})) == null) {
            if (i < 0) {
                return c(pair, i2, i3, d);
            }
            return e(clarityUrlList.size(), i, i4, i2);
        }
        return (Pair) invokeCommon.objValue;
    }

    public static final Pair<Integer, Integer> c(Pair<Integer, Integer> defaultClarity, int i, int i2, double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{defaultClarity, Integer.valueOf(i), Integer.valueOf(i2), Double.valueOf(d)})) == null) {
            Intrinsics.checkNotNullParameter(defaultClarity, "defaultClarity");
            if (!NetUtils.c()) {
                return a(defaultClarity.getFirst().intValue(), 2, i);
            }
            return d(i2, i, d, defaultClarity.getSecond().intValue());
        }
        return (Pair) invokeCommon.objValue;
    }

    public static final Pair<Integer, Integer> d(int i, int i2, double d, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Double.valueOf(d), Integer.valueOf(i3)})) == null) {
            if (!tu0.g()) {
                return a(i3, 4, i2);
            }
            to0 a = to0.a.a();
            Intrinsics.checkNotNullExpressionValue(a, "IPlayerSpeedScoreManager.Impl.getInstance()");
            float staticDeviceScore = a.getStaticDeviceScore();
            boolean z = false;
            if (staticDeviceScore > 0 && staticDeviceScore < 0.3d) {
                z = true;
            }
            if (z) {
                return a(i, 3, i2);
            }
            if (d > 5.6f) {
                return a(i, 6, i2);
            }
            return a(i3, 4, i2);
        }
        return (Pair) invokeCommon.objValue;
    }

    public static final o01 g(ClarityUrlList list, int i, double d, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{list, Integer.valueOf(i), Double.valueOf(d), Boolean.valueOf(z)})) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            Pair<Integer, Integer> a = tu0.a(list);
            int size = list.size();
            Pair<Integer, Integer> h = h(z, list, b(i, a, size, size - 1, d, list, 0));
            o01 o01Var = new o01();
            o01Var.a = h.getFirst().intValue();
            o01Var.b = h.getSecond().intValue();
            return o01Var;
        }
        return (o01) invokeCommon.objValue;
    }

    public static final Pair<Integer, Integer> e(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2, i3, i4)) == null) {
            if (i <= i2) {
                return a(i3, 4, i4);
            }
            return a((i4 - i2) - 1, 1, i4);
        }
        return (Pair) invokeIIII.objValue;
    }

    public static final int f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            if (i != -2) {
                return i;
            }
            if (Intrinsics.areEqual(tu0.c(), su0.a.a)) {
                return q21.f();
            }
            return i;
        }
        return invokeI.intValue;
    }

    public static final Pair<Integer, Integer> h(boolean z, ClarityUrlList list, Pair<Integer, Integer> selectedClarity) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), list, selectedClarity})) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(selectedClarity, "selectedClarity");
            if (!z) {
                ClarityUrlList.c cVar = list.get(selectedClarity.getFirst().intValue());
                Intrinsics.checkNotNullExpressionValue(cVar, "list[result.first]");
                String selectKey = cVar.c();
                String d = tu0.d();
                Intrinsics.checkNotNullExpressionValue(selectKey, "selectKey");
                if (StringsKt__StringsKt.contains$default((CharSequence) d, (CharSequence) selectKey, false, 2, (Object) null)) {
                    int i = 0;
                    for (ClarityUrlList.c entity : list) {
                        String d2 = tu0.d();
                        Intrinsics.checkNotNullExpressionValue(entity, "entity");
                        String c = entity.c();
                        Intrinsics.checkNotNullExpressionValue(c, "entity.key");
                        if (!StringsKt__StringsKt.contains$default((CharSequence) d2, (CharSequence) c, false, 2, (Object) null)) {
                            return new Pair<>(Integer.valueOf(i), 0);
                        }
                        i++;
                    }
                    return selectedClarity;
                }
                return selectedClarity;
            }
            return selectedClarity;
        }
        return (Pair) invokeCommon.objValue;
    }
}
