package com.baidu.tieba.lego.card.view;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.q0.i3.v;
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
@SuppressLint({"ViewConstructor"})
/* loaded from: classes7.dex */
public class RankScoreCardView extends BaseCardView<RankScoreCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f53781f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f53782g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f53783h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f53784i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f53785j;
    public RelativeLayout k;
    public TbImageView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public final int p;
    public final int q;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RankScoreCard f53786e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RankScoreCardView f53787f;

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
            this.f53787f = rankScoreCardView;
            this.f53786e = rankScoreCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                v.c(this.f53787f.mContext, this.f53786e.getD2Scheme());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RankScoreCard f53788e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RankScoreCardView f53789f;

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
            this.f53789f = rankScoreCardView;
            this.f53788e = rankScoreCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f53789f.getContext())) {
                c.a.q0.o1.m.b a2 = c.a.q0.o1.m.b.a();
                RankScoreCard rankScoreCard = this.f53788e;
                a2.e(rankScoreCard, rankScoreCard.getPostUrl(), null, null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RankScoreCard f53790e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RankScoreCardView f53791f;

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
            this.f53791f = rankScoreCardView;
            this.f53790e = rankScoreCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f53791f.handleClickEvent(this.f53790e);
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
        this.p = l.k(tbPageContext.getPageActivity());
        this.q = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds24) * 2;
    }

    private void setDesc2Color(RankScoreCard rankScoreCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, rankScoreCard) == null) || rankScoreCard == null || TextUtils.isEmpty(rankScoreCard.getDesc2())) {
            return;
        }
        setTextColor(this.f53785j, rankScoreCard.getD2Color(), rankScoreCard.getD2ColorN(), R.color.CAM_X0106);
    }

    private void setRightScoreColor(RankScoreCard rankScoreCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, rankScoreCard) == null) || rankScoreCard == null || TextUtils.isEmpty(rankScoreCard.getSubTitle())) {
            return;
        }
        setTextColor(this.n, rankScoreCard.getScoreColor(), rankScoreCard.getScoreColorNight(), R.color.CAM_X0308);
    }

    public final void c(RankScoreCard rankScoreCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, rankScoreCard) == null) || rankScoreCard == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f53782g.getLayoutParams();
        if (rankScoreCard.getRatio() > 0.0d) {
            layoutParams.height = (int) ((layoutParams.width * rankScoreCard.getRatio()) + 0.5d);
        } else {
            layoutParams.height = (int) ((layoutParams.width * 1.35f) + 0.5f);
        }
        this.l.setLayoutParams(layoutParams);
        layoutParams2.height = layoutParams.height;
        this.f53782g.setLayoutParams(layoutParams2);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View initLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_rank_score, (ViewGroup) null);
            this.f53781f = linearLayout;
            this.f53782g = (RelativeLayout) findViewById(linearLayout, R.id.rl_content);
            this.f53783h = (TextView) findViewById(this.f53781f, R.id.score_title);
            this.f53784i = (TextView) findViewById(this.f53781f, R.id.desc);
            this.f53785j = (TextView) findViewById(this.f53781f, R.id.desc2);
            this.k = (RelativeLayout) findViewById(this.f53781f, R.id.rl_pic);
            this.l = (TbImageView) findViewById(this.f53781f, R.id.pic);
            this.m = (TextView) findViewById(this.f53781f, R.id.leftTopText);
            this.n = (TextView) findViewById(this.f53781f, R.id.right);
            this.o = (TextView) findViewById(this.f53781f, R.id.btn_post);
            return this.f53781f;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onChangeSkinType(RankScoreCard rankScoreCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, rankScoreCard, i2) == null) {
            c.a.p0.u0.a.a(this.mContext, getRootView());
            SkinManager.setBackgroundResource(this.f53781f, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f53783h, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.f53784i, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0308);
            setDesc2Color(rankScoreCard);
            setRightScoreColor(rankScoreCard);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onUpdateCardView(RankScoreCard rankScoreCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, rankScoreCard) == null) {
            if (!TextUtils.isEmpty(rankScoreCard.getCardTitle())) {
                this.f53783h.setVisibility(0);
                this.f53783h.setText(rankScoreCard.getCardTitle());
            } else {
                this.f53783h.setVisibility(4);
            }
            if (!TextUtils.isEmpty(rankScoreCard.getDesc())) {
                this.f53784i.setVisibility(0);
                this.f53784i.setText(rankScoreCard.getDesc());
            } else {
                this.f53784i.setVisibility(4);
            }
            if (!TextUtils.isEmpty(rankScoreCard.getDesc2())) {
                this.f53785j.setText(rankScoreCard.getDesc2());
                setDesc2Color(rankScoreCard);
                if (!TextUtils.isEmpty(rankScoreCard.getD2Scheme())) {
                    this.f53785j.setOnClickListener(new a(this, rankScoreCard));
                } else {
                    this.f53785j.setOnClickListener(null);
                }
            } else {
                this.f53785j.setVisibility(4);
            }
            if (!TextUtils.isEmpty(rankScoreCard.getPostUrl()) && !TextUtils.isEmpty(rankScoreCard.getBtnText()) && !TextUtils.isEmpty(rankScoreCard.getBtnDone())) {
                this.o.setVisibility(0);
                showIsDone(this.o, rankScoreCard.isDone(), rankScoreCard.getBtnText(), rankScoreCard.getBtnDone());
                this.o.setTag(rankScoreCard.getPostUrl());
                this.o.setOnClickListener(new b(this, rankScoreCard));
                this.n.setVisibility(8);
            } else {
                this.o.setVisibility(8);
                this.n.setVisibility(0);
                SkinManager.setViewTextColor(this.n, R.color.CAM_X0301);
                try {
                    this.n.setText(StringHelper.numberUniformFormat(Long.parseLong(rankScoreCard.getSubTitle())));
                } catch (Exception unused) {
                    this.n.setText(rankScoreCard.getSubTitle());
                    setRightScoreColor(rankScoreCard);
                }
                this.n.setMaxWidth((this.p - this.q) / 2);
            }
            c(rankScoreCard);
            if (TextUtils.isEmpty(rankScoreCard.getPicUrl())) {
                this.k.setVisibility(8);
            } else {
                this.k.setVisibility(0);
                this.l.setTag(rankScoreCard.getPicUrl());
                this.l.startLoad(rankScoreCard.getPicUrl(), 10, false);
                if (rankScoreCard.getRank() <= 0) {
                    this.m.setVisibility(8);
                } else {
                    this.m.setVisibility(0);
                    int rank = rankScoreCard.getRank() - 1;
                    int i2 = rank >= 0 ? rank > 3 ? 3 : rank : 0;
                    if (rankScoreCard.getRank() <= 3) {
                        SkinManager.setViewTextColor(this.m, R.color.CAM_X0101);
                    } else {
                        SkinManager.setViewTextColor(this.m, R.color.CAM_X0111);
                    }
                    SkinManager.setBackgroundColor(this.m, c.a.q0.o1.a.f22894a[i2]);
                    this.m.setText(rankScoreCard.getRank() + "");
                }
            }
            setCardOnClickListener(new c(this, rankScoreCard));
        }
    }
}
