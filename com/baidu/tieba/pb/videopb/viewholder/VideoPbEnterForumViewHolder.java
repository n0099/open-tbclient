package com.baidu.tieba.pb.videopb.viewholder;

import android.view.View;
import android.view.ViewGroup;
import b.a.e.e.p.l;
import b.a.q0.s.q.d2;
import b.a.r0.k2.f;
import b.a.r0.k2.g;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class VideoPbEnterForumViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public CardForumHeadLayout f52842e;

    /* renamed from: f  reason: collision with root package name */
    public d2 f52843f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPbEnterForumViewHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        CardForumHeadLayout cardForumHeadLayout = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
        this.f52842e = cardForumHeadLayout;
        if (cardForumHeadLayout != null) {
            cardForumHeadLayout.setOnClickListener(cardForumHeadLayout);
            this.f52842e.setAfterClickListener(this);
        }
    }

    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f52842e.onChangeSkinType();
            CardForumHeadLayout cardForumHeadLayout = this.f52842e;
            int g2 = l.g(this.itemView.getContext(), g.tbds10);
            int i2 = f.CAM_X0206;
            SkinManager.setBackgroundShapeDrawable(cardForumHeadLayout, g2, i2, i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f52843f == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13399").param("tid", this.f52843f.s1()).param("fid", this.f52843f.T()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("nid", this.f52843f.F0()));
    }

    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var) == null) {
            this.f52843f = d2Var;
            this.f52842e.setData(d2Var);
        }
    }
}
