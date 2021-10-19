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
import c.a.r0.k3.w;
import c.a.r0.q1.i;
import c.a.r0.q1.o.j.c;
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
/* loaded from: classes7.dex */
public class HorRankCardView extends BaseCardView<HorRankCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f53911f;

    /* renamed from: g  reason: collision with root package name */
    public HorizontalScrollListView f53912g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f53913h;

    /* renamed from: i  reason: collision with root package name */
    public View f53914i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f53915j;
    public MoreButton k;
    public ImageView l;
    public ImageView m;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorRankCard f53916e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HorRankCardView f53917f;

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
            this.f53917f = horRankCardView;
            this.f53916e = horRankCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f53916e.getScheme())) {
                return;
            }
            i.e(this.f53916e).d(TiebaStatic.Params.OBJ_URL, this.f53916e.getScheme()).b("obj_locate", this.f53917f.getStatPosition()).a(this.f53916e);
            w.c(this.f53917f.mContext, this.f53916e.getScheme());
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
            this.f53911f = linearLayout;
            this.f53912g = (HorizontalScrollListView) findViewById(linearLayout, R.id.horizontal_view);
            this.f53913h = (RelativeLayout) findViewById(this.f53911f, R.id.rlTop);
            this.f53914i = (View) findViewById(this.f53911f, R.id.left);
            this.f53915j = (TextView) findViewById(this.f53911f, R.id.hor_title);
            this.k = (MoreButton) findViewById(this.f53911f, R.id.right_textview);
            this.l = (ImageView) findViewById(this.f53911f, R.id.rightIcon);
            this.m = (ImageView) findViewById(this.f53911f, R.id.divider);
            return this.f53911f;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onChangeSkinType(HorRankCard horRankCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, horRankCard, i2) == null) {
            c.a.q0.w0.a.a(this.mContext, getRootView());
            SkinManager.setBackgroundColor(this.f53914i, R.color.CAM_X0308);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0201);
            SkinManager.setImageResource(this.m, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f53911f, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.f53913h, R.drawable.addresslist_item_bg);
            this.f53912g.onSkinTypeChanged(this.mSkinType);
            setMoreColor(horRankCard.getRightText());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onUpdateCardView(HorRankCard horRankCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, horRankCard) == null) {
            List<HorRankCard.a> rankInfoList = horRankCard.getRankInfoList();
            this.f53914i.setVisibility(horRankCard.isShowLeft() ? 0 : 8);
            this.m.setVisibility(horRankCard.isShowSep() ? 0 : 8);
            if (rankInfoList != null && rankInfoList.size() != 0) {
                this.f53912g.setRound(horRankCard.getPicType() == 1);
                this.f53912g.setDisplayNum(horRankCard.getDisplayNum());
                this.f53912g.setRatio(horRankCard.getRatio());
                this.f53912g.setVisibility(0);
                this.f53912g.setHorizontalScrollBarEnabled(horRankCard.isScrollEnabled());
                this.f53912g.setData(rankInfoList, this.mContext);
            } else {
                this.f53912g.setVisibility(8);
            }
            if (!TextUtils.isEmpty(horRankCard.getCardTitle())) {
                this.f53915j.setVisibility(0);
                setTextColor(this.f53915j, horRankCard.getTitleColor(), horRankCard.getTitleColorNight(), R.color.CAM_X0105);
                this.f53915j.setText(horRankCard.getCardTitle());
            } else {
                this.f53915j.setVisibility(8);
            }
            setMoreColor(horRankCard.getRightText());
            if (!TextUtils.isEmpty(horRankCard.getScheme())) {
                SkinManager.setBackgroundResource(this.f53911f, R.drawable.addresslist_item_bg);
                this.f53911f.setOnClickListener(new a(this, horRankCard));
            } else {
                SkinManager.setBackgroundColor(this.f53911f, R.color.CAM_X0201);
                this.f53911f.setOnClickListener(null);
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
