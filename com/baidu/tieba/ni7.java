package com.baidu.tieba;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.forum.data.ForumTabItem;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class ni7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FragmentActivity fragmentActivity, int i) {
        gh7 value;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65536, null, fragmentActivity, i) != null) || fragmentActivity == null || (value = ((ForumViewModel) new ViewModelProvider(fragmentActivity).get(ForumViewModel.class)).c().getValue()) == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c15555").param("fid", String.valueOf(value.d())).param("fname", value.e()).param("obj_type", i));
    }

    public static final void b(FragmentActivity fragmentActivity, int i) {
        gh7 value;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65537, null, fragmentActivity, i) != null) || fragmentActivity == null || (value = ((ForumViewModel) new ViewModelProvider(fragmentActivity).get(ForumViewModel.class)).c().getValue()) == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c15554").param("fid", String.valueOf(value.d())).param("fname", value.e()).param("obj_type", i));
    }

    public static final void c(FragmentActivity activity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, activity, i) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            gh7 value = ((ForumViewModel) new ViewModelProvider(activity).get(ForumViewModel.class)).c().getValue();
            if (value == null) {
                return;
            }
            List<ForumTabItem> k = value.k();
            if (i >= 0 && i < k.size()) {
                TiebaStatic.log(new StatisticItem("c15550").param("fid", value.d()).param("fname", value.e()).param("obj_type", k.get(i).getTabId()));
            }
        }
    }

    public static final void d(FragmentActivity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, activity) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            gh7 value = ((ForumViewModel) new ViewModelProvider(activity).get(ForumViewModel.class)).c().getValue();
            if (value == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c15549").param("fid", value.d()).param("fname", value.e()));
        }
    }
}
