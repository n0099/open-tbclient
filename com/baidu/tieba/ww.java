package com.baidu.tieba;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.sina.weibo.sdk.utils.ResourceManager;
import java.util.List;
/* loaded from: classes6.dex */
public class ww {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Rect a(vn vnVar, View view2, int i) {
        InterceptResult invokeLLI;
        BdTypeRecyclerView bdTypeRecyclerView;
        RecyclerView.LayoutManager layoutManager;
        View findViewByPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, vnVar, view2, i)) == null) {
            if (view2.getTag() instanceof AutoVideoCardViewHolder) {
                return ThreadCardUtils.computeViewArea(((AutoVideoCardViewHolder) view2.getTag()).t().getVideoContainer());
            }
            if (!(vnVar instanceof BdTypeRecyclerView) || (layoutManager = (bdTypeRecyclerView = (BdTypeRecyclerView) vnVar).getLayoutManager()) == null) {
                return null;
            }
            int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
            List<pn> data = vnVar.getData();
            Object item = ListUtils.getItem(data, i);
            if (item instanceof BaseCardInfo) {
                BaseCardInfo baseCardInfo = (BaseCardInfo) item;
                int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
                for (int i2 = firstVisiblePosition > headerViewsCount ? firstVisiblePosition - headerViewsCount : headerViewsCount; i2 <= lastVisiblePosition; i2++) {
                    Object item2 = ListUtils.getItem(data, i2 - headerViewsCount);
                    if ((item2 instanceof BaseCardInfo) && baseCardInfo.position == ((BaseCardInfo) item2).position && (findViewByPosition = layoutManager.findViewByPosition(i2)) != null && (findViewByPosition.getTag() instanceof AutoVideoCardViewHolder)) {
                        return ThreadCardUtils.computeViewArea(((AutoVideoCardViewHolder) findViewByPosition.getTag()).t().getVideoContainer());
                    }
                }
                return null;
            }
            return null;
        }
        return (Rect) invokeLLI.objValue;
    }

    public static int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            Resources resources = TbadkCoreApplication.getInst().getResources();
            return resources.getIdentifier("icon_mask_level_usergrouth_" + i, ResourceManager.DRAWABLE, TbadkCoreApplication.getInst().getPackageName());
        }
        return invokeI.intValue;
    }
}
