package com.baidu.tieba.lego.card.view;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.repackage.f95;
import com.repackage.oi;
import com.repackage.qc7;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class RankDetailTrendCardView extends BaseCardView<RankDetailTrendCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout m;
    public TbImageView n;
    public TextView o;
    public TextView p;
    public TbImageView q;
    public TextView r;
    public TextView s;
    public HeadImageView t;
    public final int u;
    public final int v;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RankDetailTrendCard a;
        public final /* synthetic */ RankDetailTrendCardView b;

        public a(RankDetailTrendCardView rankDetailTrendCardView, RankDetailTrendCard rankDetailTrendCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rankDetailTrendCardView, rankDetailTrendCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rankDetailTrendCardView;
            this.a = rankDetailTrendCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ViewHelper.checkUpIsLogin(this.b.getContext())) {
                qc7 a = qc7.a();
                RankDetailTrendCard rankDetailTrendCard = this.a;
                a.e(rankDetailTrendCard, rankDetailTrendCard.getPostUrl(), null, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RankDetailTrendCard a;
        public final /* synthetic */ RankDetailTrendCardView b;

        public b(RankDetailTrendCardView rankDetailTrendCardView, RankDetailTrendCard rankDetailTrendCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rankDetailTrendCardView, rankDetailTrendCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rankDetailTrendCardView;
            this.a = rankDetailTrendCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.m(this.a);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = oi.k(tbPageContext.getPageActivity());
        this.v = tbPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8) * 2;
    }

    private void setTrendTextColor(RankDetailTrendCard rankDetailTrendCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, rankDetailTrendCard) == null) || rankDetailTrendCard == null || TextUtils.isEmpty(rankDetailTrendCard.getTrendText())) {
            return;
        }
        z(this.r, rankDetailTrendCard.getTrendColor(), rankDetailTrendCard.getTrendColorNight(), R.color.CAM_X0308);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: D */
    public void u(RankDetailTrendCard rankDetailTrendCard, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, rankDetailTrendCard, i) == null) {
            f95.a(this.i, getRootView());
            SkinManager.setBackgroundResource(this.m, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0105);
            setTrendTextColor(rankDetailTrendCard);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: E */
    public void v(RankDetailTrendCard rankDetailTrendCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rankDetailTrendCard) == null) {
            if (rankDetailTrendCard.getRank() == 1) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.t.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
                this.t.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.t.getLayoutParams();
                layoutParams2.topMargin = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5);
                this.t.setLayoutParams(layoutParams2);
            }
            if (!TextUtils.isEmpty(rankDetailTrendCard.getIconUrl())) {
                this.n.setVisibility(0);
                this.n.setImageDrawable(null);
                this.n.K(rankDetailTrendCard.getIconUrl(), 10, false);
                this.o.setVisibility(8);
            } else if (rankDetailTrendCard.getRank() <= 0) {
                this.n.setVisibility(8);
                this.o.setVisibility(8);
            } else {
                if (rankDetailTrendCard.getRank() <= 3) {
                    this.n.setVisibility(0);
                    this.o.setVisibility(8);
                    int rank = rankDetailTrendCard.getRank();
                    if (rank == 1) {
                        SkinManager.setImageResource(this.n, R.drawable.icon_grade_shaitu1);
                    } else if (rank == 2) {
                        SkinManager.setImageResource(this.n, R.drawable.icon_grade_shaitu2);
                    } else if (rank != 3) {
                        this.n.setVisibility(8);
                        SkinManager.setImageResource(this.n, R.drawable.icon_grade_shaitu1);
                    } else {
                        SkinManager.setImageResource(this.n, R.drawable.icon_grade_shaitu3);
                    }
                } else {
                    this.n.setVisibility(8);
                    this.o.setVisibility(0);
                }
                if (rankDetailTrendCard.getRank() <= 9) {
                    TextView textView = this.o;
                    textView.setText("0" + rankDetailTrendCard.getRank() + "");
                } else {
                    TextView textView2 = this.o;
                    textView2.setText(rankDetailTrendCard.getRank() + "");
                }
                SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0108);
            }
            if (!TextUtils.isEmpty(rankDetailTrendCard.getPostUrl()) && !TextUtils.isEmpty(rankDetailTrendCard.getBtnText()) && !TextUtils.isEmpty(rankDetailTrendCard.getBtnDone())) {
                this.s.setVisibility(0);
                B(this.s, rankDetailTrendCard.isDone(), rankDetailTrendCard.getBtnText(), rankDetailTrendCard.getBtnDone());
                this.s.setTag(rankDetailTrendCard.getPostUrl());
                this.s.setOnClickListener(new a(this, rankDetailTrendCard));
                this.q.setVisibility(8);
                this.r.setVisibility(8);
            } else {
                this.s.setVisibility(8);
                if (!TextUtils.isEmpty(rankDetailTrendCard.getPicTrendUrl())) {
                    this.q.setVisibility(0);
                    this.r.setVisibility(8);
                    this.q.setImageDrawable(null);
                    this.q.K(rankDetailTrendCard.getPicTrendUrl(), 10, false);
                } else if (!TextUtils.isEmpty(rankDetailTrendCard.getTrendText())) {
                    this.r.setVisibility(0);
                    this.q.setVisibility(8);
                    this.r.setText(rankDetailTrendCard.getTrendText());
                    setTrendTextColor(rankDetailTrendCard);
                    this.r.setMaxWidth((this.u - this.v) / 2);
                } else {
                    this.r.setVisibility(8);
                    int picTrendType = rankDetailTrendCard.getPicTrendType();
                    if (picTrendType == 1) {
                        this.q.setVisibility(0);
                        SkinManager.setImageResource(this.q, R.drawable.icon_arrow_ranking_up);
                    } else if (picTrendType == 2) {
                        this.q.setVisibility(0);
                        SkinManager.setImageResource(this.q, R.drawable.icon_arrow_ranking_keep);
                    } else if (picTrendType != 3) {
                        this.q.setVisibility(8);
                    } else {
                        this.q.setVisibility(0);
                        SkinManager.setImageResource(this.q, R.drawable.icon_arrow_ranking_down);
                    }
                }
            }
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0105);
            this.p.setText(rankDetailTrendCard.getCardTitle());
            if (TextUtils.isEmpty(rankDetailTrendCard.getPicUrl())) {
                this.t.setVisibility(8);
            } else {
                this.t.setVisibility(0);
                this.t.setTag(rankDetailTrendCard.getPicUrl());
                this.t.K(rankDetailTrendCard.getPicUrl(), 10, false);
            }
            setCardOnClickListener(new b(this, rankDetailTrendCard));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d01bc, (ViewGroup) null);
            this.m = linearLayout;
            this.n = (TbImageView) l(linearLayout, R.id.obfuscated_res_0x7f091209);
            this.o = (TextView) l(this.m, R.id.obfuscated_res_0x7f090f56);
            this.p = (TextView) l(this.m, R.id.obfuscated_res_0x7f092136);
            this.q = (TbImageView) l(this.m, R.id.obfuscated_res_0x7f092134);
            this.r = (TextView) l(this.m, R.id.obfuscated_res_0x7f092135);
            this.s = (TextView) l(this.m, R.id.obfuscated_res_0x7f09043b);
            HeadImageView headImageView = (HeadImageView) l(this.m, R.id.obfuscated_res_0x7f090d22);
            this.t = headImageView;
            headImageView.setIsRound(true);
            return this.m;
        }
        return (View) invokeV.objValue;
    }
}
