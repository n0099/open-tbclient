package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.player.helper.ViewOpUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class iv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, view2)) == null) {
            if (view2 != null && view2.getParent() != null && (view2.getParent() instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) view2.getParent();
                if (viewGroup.indexOfChild(view2) != -1) {
                    try {
                        c01.b(ViewOpUtils.TAG, "removeView " + view2.hashCode());
                        viewGroup.removeView(view2);
                        return true;
                    } catch (Exception e) {
                        c01.f("removeView(" + System.identityHashCode(view2) + SmallTailInfo.EMOTION_SUFFIX, e);
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
