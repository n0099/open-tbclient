package com.baidu.tieba.lego.card.view;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
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
/* loaded from: classes5.dex */
public class RankDetailTrendCardView extends BaseCardView<RankDetailTrendCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f44181f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f44182g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f44183h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f44184i;

    /* renamed from: j  reason: collision with root package name */
    public TbImageView f44185j;
    public TextView k;
    public TextView l;
    public HeadImageView m;
    public final int n;
    public final int o;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RankDetailTrendCard f44186e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RankDetailTrendCardView f44187f;

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
            this.f44187f = rankDetailTrendCardView;
            this.f44186e = rankDetailTrendCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f44187f.getContext())) {
                c.a.r0.z1.m.b a = c.a.r0.z1.m.b.a();
                RankDetailTrendCard rankDetailTrendCard = this.f44186e;
                a.e(rankDetailTrendCard, rankDetailTrendCard.getPostUrl(), null, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RankDetailTrendCard f44188e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RankDetailTrendCardView f44189f;

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
            this.f44189f = rankDetailTrendCardView;
            this.f44188e = rankDetailTrendCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f44189f.handleClickEvent(this.f44188e);
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
        this.n = n.k(tbPageContext.getPageActivity());
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
            this.f44181f = linearLayout;
            this.f44182g = (TbImageView) findViewById(linearLayout, R.id.leftIcon);
            this.f44183h = (TextView) findViewById(this.f44181f, R.id.item);
            this.f44184i = (TextView) findViewById(this.f44181f, R.id.trend_title);
            this.f44185j = (TbImageView) findViewById(this.f44181f, R.id.trend);
            this.k = (TextView) findViewById(this.f44181f, R.id.trend_text);
            this.l = (TextView) findViewById(this.f44181f, R.id.btn_post);
            HeadImageView headImageView = (HeadImageView) findViewById(this.f44181f, R.id.head);
            this.m = headImageView;
            headImageView.setIsRound(true);
            return this.f44181f;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onChangeSkinType(RankDetailTrendCard rankDetailTrendCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, rankDetailTrendCard, i2) == null) {
            c.a.q0.w0.a.a(this.mContext, getRootView());
            SkinManager.setBackgroundResource(this.f44181f, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f44183h, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.f44184i, (int) R.color.CAM_X0105);
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
                this.f44182g.setVisibility(0);
                this.f44182g.setImageDrawable(null);
                this.f44182g.startLoad(rankDetailTrendCard.getIconUrl(), 10, false);
                this.f44183h.setVisibility(8);
            } else if (rankDetailTrendCard.getRank() <= 0) {
                this.f44182g.setVisibility(8);
                this.f44183h.setVisibility(8);
            } else {
                if (rankDetailTrendCard.getRank() <= 3) {
                    this.f44182g.setVisibility(0);
                    this.f44183h.setVisibility(8);
                    int rank = rankDetailTrendCard.getRank();
                    if (rank == 1) {
                        SkinManager.setImageResource(this.f44182g, R.drawable.icon_grade_shaitu1);
                    } else if (rank == 2) {
                        SkinManager.setImageResource(this.f44182g, R.drawable.icon_grade_shaitu2);
                    } else if (rank != 3) {
                        this.f44182g.setVisibility(8);
                        SkinManager.setImageResource(this.f44182g, R.drawable.icon_grade_shaitu1);
                    } else {
                        SkinManager.setImageResource(this.f44182g, R.drawable.icon_grade_shaitu3);
                    }
                } else {
                    this.f44182g.setVisibility(8);
                    this.f44183h.setVisibility(0);
                }
                if (rankDetailTrendCard.getRank() <= 9) {
                    TextView textView = this.f44183h;
                    textView.setText("0" + rankDetailTrendCard.getRank() + "");
                } else {
                    TextView textView2 = this.f44183h;
                    textView2.setText(rankDetailTrendCard.getRank() + "");
                }
                SkinManager.setViewTextColor(this.f44183h, (int) R.color.CAM_X0108);
            }
            if (!TextUtils.isEmpty(rankDetailTrendCard.getPostUrl()) && !TextUtils.isEmpty(rankDetailTrendCard.getBtnText()) && !TextUtils.isEmpty(rankDetailTrendCard.getBtnDone())) {
                this.l.setVisibility(0);
                showIsDone(this.l, rankDetailTrendCard.isDone(), rankDetailTrendCard.getBtnText(), rankDetailTrendCard.getBtnDone());
                this.l.setTag(rankDetailTrendCard.getPostUrl());
                this.l.setOnClickListener(new a(this, rankDetailTrendCard));
                this.f44185j.setVisibility(8);
                this.k.setVisibility(8);
            } else {
                this.l.setVisibility(8);
                if (!TextUtils.isEmpty(rankDetailTrendCard.getPicTrendUrl())) {
                    this.f44185j.setVisibility(0);
                    this.k.setVisibility(8);
                    this.f44185j.setImageDrawable(null);
                    this.f44185j.startLoad(rankDetailTrendCard.getPicTrendUrl(), 10, false);
                } else if (!TextUtils.isEmpty(rankDetailTrendCard.getTrendText())) {
                    this.k.setVisibility(0);
                    this.f44185j.setVisibility(8);
                    this.k.setText(rankDetailTrendCard.getTrendText());
                    setTrendTextColor(rankDetailTrendCard);
                    this.k.setMaxWidth((this.n - this.o) / 2);
                } else {
                    this.k.setVisibility(8);
                    int picTrendType = rankDetailTrendCard.getPicTrendType();
                    if (picTrendType == 1) {
                        this.f44185j.setVisibility(0);
                        SkinManager.setImageResource(this.f44185j, R.drawable.icon_arrow_ranking_up);
                    } else if (picTrendType == 2) {
                        this.f44185j.setVisibility(0);
                        SkinManager.setImageResource(this.f44185j, R.drawable.icon_arrow_ranking_keep);
                    } else if (picTrendType != 3) {
                        this.f44185j.setVisibility(8);
                    } else {
                        this.f44185j.setVisibility(0);
                        SkinManager.setImageResource(this.f44185j, R.drawable.icon_arrow_ranking_down);
                    }
                }
            }
            SkinManager.setViewTextColor(this.f44184i, (int) R.color.CAM_X0105);
            this.f44184i.setText(rankDetailTrendCard.getCardTitle());
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
