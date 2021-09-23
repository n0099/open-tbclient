package com.baidu.tieba.pb.videopb.viewholder;

import android.view.View;
import android.view.ViewGroup;
import c.a.e.e.p.l;
import c.a.q0.s.q.d2;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class VideoPbEnterForumViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public CardForumHeadLayout f55744e;

    /* renamed from: f  reason: collision with root package name */
    public d2 f55745f;

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
        this.f55744e = cardForumHeadLayout;
        if (cardForumHeadLayout != null) {
            cardForumHeadLayout.setOnClickListener(cardForumHeadLayout);
            this.f55744e.setAfterClickListener(this);
        }
    }

    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f55744e.onChangeSkinType();
            CardForumHeadLayout cardForumHeadLayout = this.f55744e;
            int g2 = l.g(this.itemView.getContext(), R.dimen.tbds10);
            int i2 = R.color.CAM_X0206;
            SkinManager.setBackgroundShapeDrawable(cardForumHeadLayout, g2, i2, i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f55745f == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13399").param("tid", this.f55745f.s1()).param("fid", this.f55745f.T()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("nid", this.f55745f.F0()));
    }

    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var) == null) {
            this.f55745f = d2Var;
            this.f55744e.setData(d2Var);
        }
    }
}
