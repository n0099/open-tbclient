package com.baidu.tieba.lego.card.view;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.RankScoreCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.h3.v;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class RankScoreCardView extends BaseCardView<RankScoreCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public final int B;
    public final int C;
    public LinearLayout r;
    public RelativeLayout s;
    public TextView t;
    public TextView u;
    public TextView v;
    public RelativeLayout w;
    public TbImageView x;
    public TextView y;
    public TextView z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RankScoreCard f18330e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RankScoreCardView f18331f;

        public a(RankScoreCardView rankScoreCardView, RankScoreCard rankScoreCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rankScoreCardView, rankScoreCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18331f = rankScoreCardView;
            this.f18330e = rankScoreCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                v.c(this.f18331f.m, this.f18330e.getD2Scheme());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RankScoreCard f18332e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RankScoreCardView f18333f;

        public b(RankScoreCardView rankScoreCardView, RankScoreCard rankScoreCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rankScoreCardView, rankScoreCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18333f = rankScoreCardView;
            this.f18332e = rankScoreCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f18333f.getContext())) {
                d.a.q0.n1.m.b a2 = d.a.q0.n1.m.b.a();
                RankScoreCard rankScoreCard = this.f18332e;
                a2.e(rankScoreCard, rankScoreCard.getPostUrl(), null, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RankScoreCard f18334e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RankScoreCardView f18335f;

        public c(RankScoreCardView rankScoreCardView, RankScoreCard rankScoreCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rankScoreCardView, rankScoreCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18335f = rankScoreCardView;
            this.f18334e = rankScoreCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18335f.o(this.f18334e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankScoreCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.B = l.k(tbPageContext.getPageActivity());
        this.C = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds24) * 2;
    }

    private void setDesc2Color(RankScoreCard rankScoreCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, rankScoreCard) == null) || rankScoreCard == null || TextUtils.isEmpty(rankScoreCard.getDesc2())) {
            return;
        }
        A(this.v, rankScoreCard.getD2Color(), rankScoreCard.getD2ColorN(), R.color.CAM_X0106);
    }

    private void setRightScoreColor(RankScoreCard rankScoreCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, rankScoreCard) == null) || rankScoreCard == null || TextUtils.isEmpty(rankScoreCard.getSubTitle())) {
            return;
        }
        A(this.z, rankScoreCard.getScoreColor(), rankScoreCard.getScoreColorNight(), R.color.CAM_X0308);
    }

    public final void H(RankScoreCard rankScoreCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, rankScoreCard) == null) || rankScoreCard == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.s.getLayoutParams();
        if (rankScoreCard.getRatio() > 0.0d) {
            layoutParams.height = (int) ((layoutParams.width * rankScoreCard.getRatio()) + 0.5d);
        } else {
            layoutParams.height = (int) ((layoutParams.width * 1.35f) + 0.5f);
        }
        this.x.setLayoutParams(layoutParams);
        layoutParams2.height = layoutParams.height;
        this.s.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: I */
    public void v(RankScoreCard rankScoreCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rankScoreCard, i2) == null) {
            d.a.p0.u0.a.a(this.m, getRootView());
            SkinManager.setBackgroundResource(this.r, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.z, R.color.CAM_X0308);
            setDesc2Color(rankScoreCard);
            setRightScoreColor(rankScoreCard);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: J */
    public void w(RankScoreCard rankScoreCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rankScoreCard) == null) {
            if (!TextUtils.isEmpty(rankScoreCard.getCardTitle())) {
                this.t.setVisibility(0);
                this.t.setText(rankScoreCard.getCardTitle());
            } else {
                this.t.setVisibility(4);
            }
            if (!TextUtils.isEmpty(rankScoreCard.getDesc())) {
                this.u.setVisibility(0);
                this.u.setText(rankScoreCard.getDesc());
            } else {
                this.u.setVisibility(4);
            }
            if (!TextUtils.isEmpty(rankScoreCard.getDesc2())) {
                this.v.setText(rankScoreCard.getDesc2());
                setDesc2Color(rankScoreCard);
                if (!TextUtils.isEmpty(rankScoreCard.getD2Scheme())) {
                    this.v.setOnClickListener(new a(this, rankScoreCard));
                } else {
                    this.v.setOnClickListener(null);
                }
            } else {
                this.v.setVisibility(4);
            }
            if (!TextUtils.isEmpty(rankScoreCard.getPostUrl()) && !TextUtils.isEmpty(rankScoreCard.getBtnText()) && !TextUtils.isEmpty(rankScoreCard.getBtnDone())) {
                this.A.setVisibility(0);
                F(this.A, rankScoreCard.isDone(), rankScoreCard.getBtnText(), rankScoreCard.getBtnDone());
                this.A.setTag(rankScoreCard.getPostUrl());
                this.A.setOnClickListener(new b(this, rankScoreCard));
                this.z.setVisibility(8);
            } else {
                this.A.setVisibility(8);
                this.z.setVisibility(0);
                SkinManager.setViewTextColor(this.z, R.color.CAM_X0301);
                try {
                    this.z.setText(StringHelper.numberUniformFormat(Long.parseLong(rankScoreCard.getSubTitle())));
                } catch (Exception unused) {
                    this.z.setText(rankScoreCard.getSubTitle());
                    setRightScoreColor(rankScoreCard);
                }
                this.z.setMaxWidth((this.B - this.C) / 2);
            }
            H(rankScoreCard);
            if (TextUtils.isEmpty(rankScoreCard.getPicUrl())) {
                this.w.setVisibility(8);
            } else {
                this.w.setVisibility(0);
                this.x.setTag(rankScoreCard.getPicUrl());
                this.x.M(rankScoreCard.getPicUrl(), 10, false);
                if (rankScoreCard.getRank() <= 0) {
                    this.y.setVisibility(8);
                } else {
                    this.y.setVisibility(0);
                    int rank = rankScoreCard.getRank() - 1;
                    int i2 = rank >= 0 ? rank > 3 ? 3 : rank : 0;
                    if (rankScoreCard.getRank() <= 3) {
                        SkinManager.setViewTextColor(this.y, R.color.CAM_X0101);
                    } else {
                        SkinManager.setViewTextColor(this.y, R.color.CAM_X0111);
                    }
                    SkinManager.setBackgroundColor(this.y, d.a.q0.n1.a.f61113a[i2]);
                    this.y.setText(rankScoreCard.getRank() + "");
                }
            }
            setCardOnClickListener(new c(this, rankScoreCard));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_rank_score, (ViewGroup) null);
            this.r = linearLayout;
            this.s = (RelativeLayout) n(linearLayout, R.id.rl_content);
            this.t = (TextView) n(this.r, R.id.score_title);
            this.u = (TextView) n(this.r, R.id.desc);
            this.v = (TextView) n(this.r, R.id.desc2);
            this.w = (RelativeLayout) n(this.r, R.id.rl_pic);
            this.x = (TbImageView) n(this.r, R.id.pic);
            this.y = (TextView) n(this.r, R.id.leftTopText);
            this.z = (TextView) n(this.r, R.id.right);
            this.A = (TextView) n(this.r, R.id.btn_post);
            return this.r;
        }
        return (View) invokeV.objValue;
    }
}
