package com.baidu.tieba.lego.card.view;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.HorRankCard;
import com.baidu.tieba.lego.view.HorizontalScrollListView;
import com.baidu.tieba.lego.view.MoreButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.h3.v;
import d.a.p0.n1.i;
import d.a.p0.n1.o.j.c;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class HorRankCardView extends BaseCardView<HorRankCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout r;
    public HorizontalScrollListView s;
    public RelativeLayout t;
    public View u;
    public TextView v;
    public MoreButton w;
    public ImageView x;
    public ImageView y;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorRankCard f18244e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HorRankCardView f18245f;

        public a(HorRankCardView horRankCardView, HorRankCard horRankCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horRankCardView, horRankCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18245f = horRankCardView;
            this.f18244e = horRankCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f18244e.getScheme())) {
                return;
            }
            i.e(this.f18244e).d(TiebaStatic.Params.OBJ_URL, this.f18244e.getScheme()).b("obj_locate", this.f18245f.getStatPosition()).a(this.f18244e);
            v.c(this.f18245f.m, this.f18244e.getScheme());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorRankCardView(TbPageContext tbPageContext) {
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
    }

    private void setMoreColor(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, cVar) == null) {
            if (cVar == null) {
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0302);
            } else {
                A(this.w, cVar.b(), cVar.c(), R.color.CAM_X0302);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: H */
    public void v(HorRankCard horRankCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, horRankCard, i2) == null) {
            d.a.o0.s0.a.a(this.m, getRootView());
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0308);
            SkinManager.setBackgroundColor(this.y, R.color.CAM_X0201);
            SkinManager.setImageResource(this.y, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.t, R.drawable.addresslist_item_bg);
            this.s.i(this.n);
            setMoreColor(horRankCard.getRightText());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: I */
    public void w(HorRankCard horRankCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, horRankCard) == null) {
            List<HorRankCard.a> rankInfoList = horRankCard.getRankInfoList();
            this.u.setVisibility(horRankCard.isShowLeft() ? 0 : 8);
            this.y.setVisibility(horRankCard.isShowSep() ? 0 : 8);
            if (rankInfoList != null && rankInfoList.size() != 0) {
                this.s.setRound(horRankCard.getPicType() == 1);
                this.s.setDisplayNum(horRankCard.getDisplayNum());
                this.s.setRatio(horRankCard.getRatio());
                this.s.setVisibility(0);
                this.s.setHorizontalScrollBarEnabled(horRankCard.isScrollEnabled());
                this.s.setData(rankInfoList, this.m);
            } else {
                this.s.setVisibility(8);
            }
            if (!TextUtils.isEmpty(horRankCard.getCardTitle())) {
                this.v.setVisibility(0);
                A(this.v, horRankCard.getTitleColor(), horRankCard.getTitleColorNight(), R.color.CAM_X0105);
                this.v.setText(horRankCard.getCardTitle());
            } else {
                this.v.setVisibility(8);
            }
            setMoreColor(horRankCard.getRightText());
            if (!TextUtils.isEmpty(horRankCard.getScheme())) {
                SkinManager.setBackgroundResource(this.r, R.drawable.addresslist_item_bg);
                this.r.setOnClickListener(new a(this, horRankCard));
            } else {
                SkinManager.setBackgroundColor(this.r, R.color.CAM_X0201);
                this.r.setOnClickListener(null);
            }
            c rightText = horRankCard.getRightText();
            if (rightText.f()) {
                this.x.setVisibility(8);
                this.w.setVisibility(0);
                this.w.setData(rightText, this.m);
                return;
            }
            this.w.setVisibility(8);
            if (!TextUtils.isEmpty(horRankCard.getScheme())) {
                this.x.setVisibility(0);
                SkinManager.setImageResource(this.x, R.drawable.icon_arrow_tab);
                return;
            }
            this.x.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_horizontal, (ViewGroup) null, false);
            this.r = linearLayout;
            this.s = (HorizontalScrollListView) n(linearLayout, R.id.horizontal_view);
            this.t = (RelativeLayout) n(this.r, R.id.rlTop);
            this.u = (View) n(this.r, R.id.left);
            this.v = (TextView) n(this.r, R.id.hor_title);
            this.w = (MoreButton) n(this.r, R.id.right_textview);
            this.x = (ImageView) n(this.r, R.id.rightIcon);
            this.y = (ImageView) n(this.r, R.id.divider);
            return this.r;
        }
        return (View) invokeV.objValue;
    }
}
