package com.baidu.tieba.lego.card.view;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.RankDetailTrendCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes7.dex */
public class RankDetailTrendCardView extends BaseCardView<RankDetailTrendCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f53772f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f53773g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f53774h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f53775i;

    /* renamed from: j  reason: collision with root package name */
    public TbImageView f53776j;
    public TextView k;
    public TextView l;
    public HeadImageView m;
    public final int n;
    public final int o;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RankDetailTrendCard f53777e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RankDetailTrendCardView f53778f;

        public a(RankDetailTrendCardView rankDetailTrendCardView, RankDetailTrendCard rankDetailTrendCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rankDetailTrendCardView, rankDetailTrendCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53778f = rankDetailTrendCardView;
            this.f53777e = rankDetailTrendCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f53778f.getContext())) {
                c.a.q0.o1.m.b a2 = c.a.q0.o1.m.b.a();
                RankDetailTrendCard rankDetailTrendCard = this.f53777e;
                a2.e(rankDetailTrendCard, rankDetailTrendCard.getPostUrl(), null, null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RankDetailTrendCard f53779e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RankDetailTrendCardView f53780f;

        public b(RankDetailTrendCardView rankDetailTrendCardView, RankDetailTrendCard rankDetailTrendCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rankDetailTrendCardView, rankDetailTrendCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53780f = rankDetailTrendCardView;
            this.f53779e = rankDetailTrendCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f53780f.handleClickEvent(this.f53779e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankDetailTrendCardView(TbPageContext tbPageContext) {
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
        this.n = l.k(tbPageContext.getPageActivity());
        this.o = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds24) * 2;
    }

    private void setTrendTextColor(RankDetailTrendCard rankDetailTrendCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, rankDetailTrendCard) == null) || rankDetailTrendCard == null || TextUtils.isEmpty(rankDetailTrendCard.getTrendText())) {
            return;
        }
        setTextColor(this.k, rankDetailTrendCard.getTrendColor(), rankDetailTrendCard.getTrendColorNight(), R.color.CAM_X0308);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View initLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_rank_trend, (ViewGroup) null);
            this.f53772f = linearLayout;
            this.f53773g = (TbImageView) findViewById(linearLayout, R.id.leftIcon);
            this.f53774h = (TextView) findViewById(this.f53772f, R.id.item);
            this.f53775i = (TextView) findViewById(this.f53772f, R.id.trend_title);
            this.f53776j = (TbImageView) findViewById(this.f53772f, R.id.trend);
            this.k = (TextView) findViewById(this.f53772f, R.id.trend_text);
            this.l = (TextView) findViewById(this.f53772f, R.id.btn_post);
            HeadImageView headImageView = (HeadImageView) findViewById(this.f53772f, R.id.head);
            this.m = headImageView;
            headImageView.setIsRound(true);
            return this.f53772f;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onChangeSkinType(RankDetailTrendCard rankDetailTrendCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, rankDetailTrendCard, i2) == null) {
            c.a.p0.u0.a.a(this.mContext, getRootView());
            SkinManager.setBackgroundResource(this.f53772f, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f53774h, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.f53775i, R.color.CAM_X0105);
            setTrendTextColor(rankDetailTrendCard);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onUpdateCardView(RankDetailTrendCard rankDetailTrendCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, rankDetailTrendCard) == null) {
            if (rankDetailTrendCard.getRank() == 1) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.ds24);
                this.m.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams2.topMargin = getResources().getDimensionPixelSize(R.dimen.ds20);
                this.m.setLayoutParams(layoutParams2);
            }
            if (!TextUtils.isEmpty(rankDetailTrendCard.getIconUrl())) {
                this.f53773g.setVisibility(0);
                this.f53773g.setImageDrawable(null);
                this.f53773g.startLoad(rankDetailTrendCard.getIconUrl(), 10, false);
                this.f53774h.setVisibility(8);
            } else if (rankDetailTrendCard.getRank() <= 0) {
                this.f53773g.setVisibility(8);
                this.f53774h.setVisibility(8);
            } else {
                if (rankDetailTrendCard.getRank() <= 3) {
                    this.f53773g.setVisibility(0);
                    this.f53774h.setVisibility(8);
                    int rank = rankDetailTrendCard.getRank();
                    if (rank == 1) {
                        SkinManager.setImageResource(this.f53773g, R.drawable.icon_grade_shaitu1);
                    } else if (rank == 2) {
                        SkinManager.setImageResource(this.f53773g, R.drawable.icon_grade_shaitu2);
                    } else if (rank != 3) {
                        this.f53773g.setVisibility(8);
                        SkinManager.setImageResource(this.f53773g, R.drawable.icon_grade_shaitu1);
                    } else {
                        SkinManager.setImageResource(this.f53773g, R.drawable.icon_grade_shaitu3);
                    }
                } else {
                    this.f53773g.setVisibility(8);
                    this.f53774h.setVisibility(0);
                }
                if (rankDetailTrendCard.getRank() <= 9) {
                    TextView textView = this.f53774h;
                    textView.setText("0" + rankDetailTrendCard.getRank() + "");
                } else {
                    TextView textView2 = this.f53774h;
                    textView2.setText(rankDetailTrendCard.getRank() + "");
                }
                SkinManager.setViewTextColor(this.f53774h, R.color.CAM_X0108);
            }
            if (!TextUtils.isEmpty(rankDetailTrendCard.getPostUrl()) && !TextUtils.isEmpty(rankDetailTrendCard.getBtnText()) && !TextUtils.isEmpty(rankDetailTrendCard.getBtnDone())) {
                this.l.setVisibility(0);
                showIsDone(this.l, rankDetailTrendCard.isDone(), rankDetailTrendCard.getBtnText(), rankDetailTrendCard.getBtnDone());
                this.l.setTag(rankDetailTrendCard.getPostUrl());
                this.l.setOnClickListener(new a(this, rankDetailTrendCard));
                this.f53776j.setVisibility(8);
                this.k.setVisibility(8);
            } else {
                this.l.setVisibility(8);
                if (!TextUtils.isEmpty(rankDetailTrendCard.getPicTrendUrl())) {
                    this.f53776j.setVisibility(0);
                    this.k.setVisibility(8);
                    this.f53776j.setImageDrawable(null);
                    this.f53776j.startLoad(rankDetailTrendCard.getPicTrendUrl(), 10, false);
                } else if (!TextUtils.isEmpty(rankDetailTrendCard.getTrendText())) {
                    this.k.setVisibility(0);
                    this.f53776j.setVisibility(8);
                    this.k.setText(rankDetailTrendCard.getTrendText());
                    setTrendTextColor(rankDetailTrendCard);
                    this.k.setMaxWidth((this.n - this.o) / 2);
                } else {
                    this.k.setVisibility(8);
                    int picTrendType = rankDetailTrendCard.getPicTrendType();
                    if (picTrendType == 1) {
                        this.f53776j.setVisibility(0);
                        SkinManager.setImageResource(this.f53776j, R.drawable.icon_arrow_ranking_up);
                    } else if (picTrendType == 2) {
                        this.f53776j.setVisibility(0);
                        SkinManager.setImageResource(this.f53776j, R.drawable.icon_arrow_ranking_keep);
                    } else if (picTrendType != 3) {
                        this.f53776j.setVisibility(8);
                    } else {
                        this.f53776j.setVisibility(0);
                        SkinManager.setImageResource(this.f53776j, R.drawable.icon_arrow_ranking_down);
                    }
                }
            }
            SkinManager.setViewTextColor(this.f53775i, R.color.CAM_X0105);
            this.f53775i.setText(rankDetailTrendCard.getCardTitle());
            if (TextUtils.isEmpty(rankDetailTrendCard.getPicUrl())) {
                this.m.setVisibility(8);
            } else {
                this.m.setVisibility(0);
                this.m.setTag(rankDetailTrendCard.getPicUrl());
                this.m.startLoad(rankDetailTrendCard.getPicUrl(), 10, false);
            }
            setCardOnClickListener(new b(this, rankDetailTrendCard));
        }
    }
}
