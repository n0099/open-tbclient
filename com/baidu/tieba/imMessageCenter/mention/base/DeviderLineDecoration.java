package com.baidu.tieba.imMessageCenter.mention.base;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class DeviderLineDecoration extends RecyclerView.ItemDecoration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f53608a;

    public DeviderLineDecoration() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (this.f53608a <= 0) {
            this.f53608a = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds16);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view, recyclerView, state) == null) {
            int viewLayoutPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
            if (recyclerView instanceof BdRecyclerView) {
                int headerViewsCount = ((BdRecyclerView) recyclerView).getHeaderViewsCount();
                if (viewLayoutPosition >= 0 && viewLayoutPosition < headerViewsCount - 1) {
                    rect.set(0, 0, 0, 0);
                    return;
                }
            }
            rect.set(0, 0, 0, this.f53608a);
        }
    }

    public void setDividerHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f53608a = i2;
        }
    }
}
