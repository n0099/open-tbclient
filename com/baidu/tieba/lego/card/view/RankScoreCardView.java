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
import com.repackage.bk8;
import com.repackage.fb5;
import com.repackage.je7;
import com.repackage.qi;
import com.repackage.wd7;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class RankScoreCardView extends BaseCardView<RankScoreCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout m;
    public RelativeLayout n;
    public TextView o;
    public TextView p;
    public TextView q;
    public RelativeLayout r;
    public TbImageView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public final int w;
    public final int x;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RankScoreCard a;
        public final /* synthetic */ RankScoreCardView b;

        public a(RankScoreCardView rankScoreCardView, RankScoreCard rankScoreCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rankScoreCardView, rankScoreCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rankScoreCardView;
            this.a = rankScoreCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                bk8.c(this.b.i, this.a.getD2Scheme());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RankScoreCard a;
        public final /* synthetic */ RankScoreCardView b;

        public b(RankScoreCardView rankScoreCardView, RankScoreCard rankScoreCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rankScoreCardView, rankScoreCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rankScoreCardView;
            this.a = rankScoreCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ViewHelper.checkUpIsLogin(this.b.getContext())) {
                je7 a = je7.a();
                RankScoreCard rankScoreCard = this.a;
                a.e(rankScoreCard, rankScoreCard.getPostUrl(), null, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RankScoreCard a;
        public final /* synthetic */ RankScoreCardView b;

        public c(RankScoreCardView rankScoreCardView, RankScoreCard rankScoreCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rankScoreCardView, rankScoreCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rankScoreCardView;
            this.a = rankScoreCard;
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
    public RankScoreCardView(TbPageContext tbPageContext) {
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
        this.w = qi.k(tbPageContext.getPageActivity());
        this.x = tbPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8) * 2;
    }

    private void setDesc2Color(RankScoreCard rankScoreCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, rankScoreCard) == null) || rankScoreCard == null || TextUtils.isEmpty(rankScoreCard.getDesc2())) {
            return;
        }
        y(this.q, rankScoreCard.getD2Color(), rankScoreCard.getD2ColorN(), R.color.CAM_X0106);
    }

    private void setRightScoreColor(RankScoreCard rankScoreCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, rankScoreCard) == null) || rankScoreCard == null || TextUtils.isEmpty(rankScoreCard.getSubTitle())) {
            return;
        }
        y(this.u, rankScoreCard.getScoreColor(), rankScoreCard.getScoreColorNight(), R.color.CAM_X0308);
    }

    public final void C(RankScoreCard rankScoreCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, rankScoreCard) == null) || rankScoreCard == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.s.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.n.getLayoutParams();
        if (rankScoreCard.getRatio() > 0.0d) {
            layoutParams.height = (int) ((layoutParams.width * rankScoreCard.getRatio()) + 0.5d);
        } else {
            layoutParams.height = (int) ((layoutParams.width * 1.35f) + 0.5f);
        }
        this.s.setLayoutParams(layoutParams);
        layoutParams2.height = layoutParams.height;
        this.n.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: D */
    public void t(RankScoreCard rankScoreCard, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rankScoreCard, i) == null) {
            fb5.a(this.i, getRootView());
            SkinManager.setBackgroundResource(this.m, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.u, (int) R.color.CAM_X0308);
            setDesc2Color(rankScoreCard);
            setRightScoreColor(rankScoreCard);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: E */
    public void u(RankScoreCard rankScoreCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rankScoreCard) == null) {
            if (!TextUtils.isEmpty(rankScoreCard.getCardTitle())) {
                this.o.setVisibility(0);
                this.o.setText(rankScoreCard.getCardTitle());
            } else {
                this.o.setVisibility(4);
            }
            if (!TextUtils.isEmpty(rankScoreCard.getDesc())) {
                this.p.setVisibility(0);
                this.p.setText(rankScoreCard.getDesc());
            } else {
                this.p.setVisibility(4);
            }
            if (!TextUtils.isEmpty(rankScoreCard.getDesc2())) {
                this.q.setText(rankScoreCard.getDesc2());
                setDesc2Color(rankScoreCard);
                if (!TextUtils.isEmpty(rankScoreCard.getD2Scheme())) {
                    this.q.setOnClickListener(new a(this, rankScoreCard));
                } else {
                    this.q.setOnClickListener(null);
                }
            } else {
                this.q.setVisibility(4);
            }
            if (!TextUtils.isEmpty(rankScoreCard.getPostUrl()) && !TextUtils.isEmpty(rankScoreCard.getBtnText()) && !TextUtils.isEmpty(rankScoreCard.getBtnDone())) {
                this.v.setVisibility(0);
                A(this.v, rankScoreCard.isDone(), rankScoreCard.getBtnText(), rankScoreCard.getBtnDone());
                this.v.setTag(rankScoreCard.getPostUrl());
                this.v.setOnClickListener(new b(this, rankScoreCard));
                this.u.setVisibility(8);
            } else {
                this.v.setVisibility(8);
                this.u.setVisibility(0);
                SkinManager.setViewTextColor(this.u, (int) R.color.CAM_X0301);
                try {
                    this.u.setText(StringHelper.numberUniformFormat(Long.parseLong(rankScoreCard.getSubTitle())));
                } catch (Exception unused) {
                    this.u.setText(rankScoreCard.getSubTitle());
                    setRightScoreColor(rankScoreCard);
                }
                this.u.setMaxWidth((this.w - this.x) / 2);
            }
            C(rankScoreCard);
            if (TextUtils.isEmpty(rankScoreCard.getPicUrl())) {
                this.r.setVisibility(8);
            } else {
                this.r.setVisibility(0);
                this.s.setTag(rankScoreCard.getPicUrl());
                this.s.K(rankScoreCard.getPicUrl(), 10, false);
                if (rankScoreCard.getRank() <= 0) {
                    this.t.setVisibility(8);
                } else {
                    this.t.setVisibility(0);
                    int rank = rankScoreCard.getRank() - 1;
                    int i = rank >= 0 ? rank > 3 ? 3 : rank : 0;
                    if (rankScoreCard.getRank() <= 3) {
                        SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0101);
                    } else {
                        SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0111);
                    }
                    SkinManager.setBackgroundColor(this.t, wd7.a[i]);
                    this.t.setText(rankScoreCard.getRank() + "");
                }
            }
            setCardOnClickListener(new c(this, rankScoreCard));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d01b1, (ViewGroup) null);
            this.m = linearLayout;
            this.n = (RelativeLayout) l(linearLayout, R.id.obfuscated_res_0x7f091c08);
            this.o = (TextView) l(this.m, R.id.obfuscated_res_0x7f091d6d);
            this.p = (TextView) l(this.m, R.id.obfuscated_res_0x7f09077f);
            this.q = (TextView) l(this.m, R.id.obfuscated_res_0x7f090780);
            this.r = (RelativeLayout) l(this.m, R.id.obfuscated_res_0x7f091c16);
            this.s = (TbImageView) l(this.m, R.id.obfuscated_res_0x7f091986);
            this.t = (TextView) l(this.m, R.id.obfuscated_res_0x7f0912a9);
            this.u = (TextView) l(this.m, R.id.obfuscated_res_0x7f091bd8);
            this.v = (TextView) l(this.m, R.id.obfuscated_res_0x7f090448);
            return this.m;
        }
        return (View) invokeV.objValue;
    }
}
