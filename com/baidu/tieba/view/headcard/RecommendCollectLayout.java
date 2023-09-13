package com.baidu.tieba.view.headcard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.exa;
import com.baidu.tieba.vx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes8.dex */
public class RecommendCollectLayout extends RelativeLayout implements vx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext a;
    public ContentCollectListAdapter b;
    public int c;
    public int d;
    public LinearLayout e;
    public ArrayList<RecyclerView.ViewHolder> f;

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendCollectLayout(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 3;
        this.f = new ArrayList<>();
        this.a = tbPageContext;
        a();
    }

    public void setData(exa exaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exaVar) == null) && exaVar != null && !ListUtils.isEmpty(exaVar.getDataList())) {
            this.e.removeAllViews();
            this.f.clear();
            this.b.t(exaVar.getDataList());
            this.b.u(this.c);
            for (int i = 0; i < exaVar.getDataList().size(); i++) {
                ContentCollectListAdapter contentCollectListAdapter = this.b;
                RecyclerView.ViewHolder onCreateViewHolder = contentCollectListAdapter.onCreateViewHolder(null, contentCollectListAdapter.getItemViewType(i));
                this.e.addView(onCreateViewHolder.itemView);
                this.b.onBindViewHolder(onCreateViewHolder, i);
                this.f.add(onCreateViewHolder);
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            setLayoutParams(layoutParams);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.e = linearLayout;
            linearLayout.setOrientation(1);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
            addView(this.e, layoutParams2);
            this.b = new ContentCollectListAdapter(this.a);
        }
    }

    @Override // com.baidu.tieba.vx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) && this.d != i) {
            EMManager.from(this.e).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            this.d = i;
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                this.b.onBindViewHolder(this.f.get(i2), i2);
            }
        }
    }

    public void setSourceForPb(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.c = i;
        }
    }
}
