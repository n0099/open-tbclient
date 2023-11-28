package com.baidu.tieba;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.forum.data.ForumTabItem;
import com.baidu.tieba.forum.data.SortItem;
import com.baidu.tieba.forum.data.SubTabItem;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class wn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final ql7 a(FragmentActivity activity, Bundle bundle, BdUniqueId bdUniqueId, vl7 resultCallback) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, activity, bundle, bdUniqueId, resultCallback)) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(bdUniqueId, "bdUniqueId");
            Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
            ql7 pl7Var = new pl7();
            ForumTabItem forumTabItem = (ForumTabItem) bundle.getParcelable("forum_tab_info");
            if (forumTabItem == null) {
                return pl7Var;
            }
            oi7 oi7Var = null;
            if (bundle.getBoolean("forum_tab_current_list", false)) {
                oi7Var = ((ForumViewModel) new ViewModelProvider(activity).get(ForumViewModel.class)).a().getValue();
            }
            int netType = forumTabItem.getNetType();
            int i = -1;
            if (netType != 1) {
                if (netType != 2) {
                    if (netType != 3) {
                        do7.a("Unknown netType!!!");
                    } else {
                        pl7Var = new ol7(new yl7(activity, bdUniqueId, bundle), resultCallback);
                    }
                } else {
                    pl7Var = new ol7(new zl7(activity, bdUniqueId, bundle), resultCallback);
                }
            } else {
                i = SharedPrefHelper.getInstance().getInt("key_forum_last_sort_type", -1);
                pl7Var = new ol7(new am7(activity, bdUniqueId, bundle), resultCallback);
            }
            pl7Var.c(new sl7(b(forumTabItem, i), oi7Var));
            return pl7Var;
        }
        return (ql7) invokeLLLL.objValue;
    }

    public static final rl7 b(ForumTabItem forumTabItem, int i) {
        InterceptResult invokeLI;
        boolean z;
        xl7 xl7Var;
        boolean z2;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, forumTabItem, i)) == null) {
            List<SubTabItem> subTabList = forumTabItem.getSubTabList();
            int i2 = 0;
            if (subTabList != null && !subTabList.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            wl7 wl7Var = null;
            if (!z && forumTabItem.getSubTabList().size() > 1) {
                xl7Var = new xl7(forumTabItem.getSubTabList(), 0);
            } else {
                xl7Var = null;
            }
            List<SortItem> sortItemList = forumTabItem.getSortItemList();
            if (sortItemList != null && !sortItemList.isEmpty()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2 && forumTabItem.getSortItemList().size() > 1) {
                if (i != -1 && (size = forumTabItem.getSortItemList().size()) >= 0) {
                    int i3 = 0;
                    while (true) {
                        if (forumTabItem.getSortItemList().get(i3).getId() == i) {
                            i2 = i3;
                            break;
                        } else if (i3 == size) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                wl7Var = new wl7(forumTabItem.getSortItemList(), i2);
            }
            return new rl7(xl7Var, wl7Var);
        }
        return (rl7) invokeLI.objValue;
    }
}
