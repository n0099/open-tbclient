package com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.adapter;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.topbubble.TopBubbleData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.topbubble.TopBubbleView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class PinnedOverlayAdapter extends RecyclerView.Adapter<PinnedOverlayHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<TopBubbleData> a;
    @Nullable
    public TopBubbleView.b b;

    /* loaded from: classes6.dex */
    public static class PinnedOverlayHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PinnedOverlayHolder(@NonNull View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public PinnedOverlayAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a.size();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"SetTextI18n"})
    /* renamed from: l */
    public void onBindViewHolder(@NonNull PinnedOverlayHolder pinnedOverlayHolder, @SuppressLint({"RecyclerView"}) int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pinnedOverlayHolder, i) == null) {
            TopBubbleView topBubbleView = (TopBubbleView) pinnedOverlayHolder.itemView;
            topBubbleView.c(this.a.get(i));
            TopBubbleView.b bVar = this.b;
            if (bVar != null) {
                topBubbleView.setEventCallback(bVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: m */
    public PinnedOverlayHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
            TopBubbleView topBubbleView = new TopBubbleView(viewGroup.getContext());
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds109));
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            topBubbleView.setLayoutParams(layoutParams);
            return new PinnedOverlayHolder(topBubbleView);
        }
        return (PinnedOverlayHolder) invokeLI.objValue;
    }

    public void n(@NonNull TopBubbleView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.b = bVar;
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void setData(List<TopBubbleData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.a.clear();
            this.a.addAll(list);
            notifyDataSetChanged();
        }
    }
}
