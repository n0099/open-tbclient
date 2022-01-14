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
import c.a.t0.w3.w;
import c.a.t0.x1.i;
import c.a.t0.x1.o.j.c;
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
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes12.dex */
public class HorRankCardView extends BaseCardView<HorRankCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f45554f;

    /* renamed from: g  reason: collision with root package name */
    public HorizontalScrollListView f45555g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f45556h;

    /* renamed from: i  reason: collision with root package name */
    public View f45557i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f45558j;
    public MoreButton k;
    public ImageView l;
    public ImageView m;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorRankCard f45559e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HorRankCardView f45560f;

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
            this.f45560f = horRankCardView;
            this.f45559e = horRankCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f45559e.getScheme())) {
                return;
            }
            i.e(this.f45559e).d(TiebaStatic.Params.OBJ_URL, this.f45559e.getScheme()).b("obj_locate", this.f45560f.getStatPosition()).a(this.f45559e);
            w.c(this.f45560f.mContext, this.f45559e.getScheme());
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
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0302);
            } else {
                setTextColor(this.k, cVar.b(), cVar.c(), R.color.CAM_X0302);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View initLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_horizontal, (ViewGroup) null, false);
            this.f45554f = linearLayout;
            this.f45555g = (HorizontalScrollListView) findViewById(linearLayout, R.id.horizontal_view);
            this.f45556h = (RelativeLayout) findViewById(this.f45554f, R.id.rlTop);
            this.f45557i = (View) findViewById(this.f45554f, R.id.left);
            this.f45558j = (TextView) findViewById(this.f45554f, R.id.hor_title);
            this.k = (MoreButton) findViewById(this.f45554f, R.id.right_textview);
            this.l = (ImageView) findViewById(this.f45554f, R.id.rightIcon);
            this.m = (ImageView) findViewById(this.f45554f, R.id.divider);
            return this.f45554f;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onChangeSkinType(HorRankCard horRankCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, horRankCard, i2) == null) {
            c.a.s0.x0.a.a(this.mContext, getRootView());
            SkinManager.setBackgroundColor(this.f45557i, R.color.CAM_X0308);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0201);
            SkinManager.setImageResource(this.m, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f45554f, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.f45556h, R.drawable.addresslist_item_bg);
            this.f45555g.onSkinTypeChanged(this.mSkinType);
            setMoreColor(horRankCard.getRightText());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onUpdateCardView(HorRankCard horRankCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, horRankCard) == null) {
            List<HorRankCard.a> rankInfoList = horRankCard.getRankInfoList();
            this.f45557i.setVisibility(horRankCard.isShowLeft() ? 0 : 8);
            this.m.setVisibility(horRankCard.isShowSep() ? 0 : 8);
            if (rankInfoList != null && rankInfoList.size() != 0) {
                this.f45555g.setRound(horRankCard.getPicType() == 1);
                this.f45555g.setDisplayNum(horRankCard.getDisplayNum());
                this.f45555g.setRatio(horRankCard.getRatio());
                this.f45555g.setVisibility(0);
                this.f45555g.setHorizontalScrollBarEnabled(horRankCard.isScrollEnabled());
                this.f45555g.setData(rankInfoList, this.mContext);
            } else {
                this.f45555g.setVisibility(8);
            }
            if (!TextUtils.isEmpty(horRankCard.getCardTitle())) {
                this.f45558j.setVisibility(0);
                setTextColor(this.f45558j, horRankCard.getTitleColor(), horRankCard.getTitleColorNight(), R.color.CAM_X0105);
                this.f45558j.setText(horRankCard.getCardTitle());
            } else {
                this.f45558j.setVisibility(8);
            }
            setMoreColor(horRankCard.getRightText());
            if (!TextUtils.isEmpty(horRankCard.getScheme())) {
                SkinManager.setBackgroundResource(this.f45554f, R.drawable.addresslist_item_bg);
                this.f45554f.setOnClickListener(new a(this, horRankCard));
            } else {
                SkinManager.setBackgroundColor(this.f45554f, R.color.CAM_X0201);
                this.f45554f.setOnClickListener(null);
            }
            c rightText = horRankCard.getRightText();
            if (rightText.f()) {
                this.l.setVisibility(8);
                this.k.setVisibility(0);
                this.k.setData(rightText, this.mContext);
                return;
            }
            this.k.setVisibility(8);
            if (!TextUtils.isEmpty(horRankCard.getScheme())) {
                this.l.setVisibility(0);
                SkinManager.setImageResource(this.l, R.drawable.icon_arrow_tab);
                return;
            }
            this.l.setVisibility(8);
        }
    }
}
