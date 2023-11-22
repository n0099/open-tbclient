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
import com.baidu.tieba.ic9;
import com.baidu.tieba.lego.card.model.HorRankCard;
import com.baidu.tieba.lego.view.HorizontalScrollListView;
import com.baidu.tieba.lego.view.MoreButton;
import com.baidu.tieba.mb9;
import com.baidu.tieba.vqa;
import com.baidu.tieba.xp5;
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
    public LinearLayout m;
    public HorizontalScrollListView n;
    public RelativeLayout o;
    public View p;
    public TextView q;
    public MoreButton r;
    public ImageView s;
    public ImageView t;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HorRankCard a;
        public final /* synthetic */ HorRankCardView b;

        public a(HorRankCardView horRankCardView, HorRankCard horRankCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horRankCardView, horRankCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = horRankCardView;
            this.a = horRankCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || TextUtils.isEmpty(this.a.getScheme())) {
                return;
            }
            mb9.e(this.a).d(TiebaStatic.Params.OBJ_URL, this.a.getScheme()).b("obj_locate", this.b.getStatPosition()).a(this.a);
            vqa.c(this.b.i, this.a.getScheme());
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void setMoreColor(ic9 ic9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, ic9Var) == null) {
            if (ic9Var == null) {
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
            } else {
                A(this.r, ic9Var.b(), ic9Var.c(), R.color.CAM_X0302);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: E */
    public void v(HorRankCard horRankCard, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, horRankCard, i) == null) {
            xp5.a(this.i, getRootView());
            SkinManager.setBackgroundColor(this.p, R.color.CAM_X0308);
            SkinManager.setBackgroundColor(this.t, R.color.CAM_X0201);
            SkinManager.setImageResource(this.t, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.o, R.drawable.addresslist_item_bg);
            this.n.i(this.j);
            setMoreColor(horRankCard.getRightText());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: F */
    public void w(HorRankCard horRankCard) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, horRankCard) == null) {
            List<HorRankCard.a> rankInfoList = horRankCard.getRankInfoList();
            View view2 = this.p;
            if (horRankCard.isShowLeft()) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
            ImageView imageView = this.t;
            if (horRankCard.isShowSep()) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
            if (rankInfoList != null && rankInfoList.size() != 0) {
                HorizontalScrollListView horizontalScrollListView = this.n;
                boolean z = true;
                if (horRankCard.getPicType() != 1) {
                    z = false;
                }
                horizontalScrollListView.setRound(z);
                this.n.setDisplayNum(horRankCard.getDisplayNum());
                this.n.setRatio(horRankCard.getRatio());
                this.n.setVisibility(0);
                this.n.setHorizontalScrollBarEnabled(horRankCard.isScrollEnabled());
                this.n.setData(rankInfoList, this.i);
            } else {
                this.n.setVisibility(8);
            }
            if (!TextUtils.isEmpty(horRankCard.getCardTitle())) {
                this.q.setVisibility(0);
                A(this.q, horRankCard.getTitleColor(), horRankCard.getTitleColorNight(), R.color.CAM_X0105);
                this.q.setText(horRankCard.getCardTitle());
            } else {
                this.q.setVisibility(8);
            }
            setMoreColor(horRankCard.getRightText());
            if (!TextUtils.isEmpty(horRankCard.getScheme())) {
                SkinManager.setBackgroundResource(this.m, R.drawable.addresslist_item_bg);
                this.m.setOnClickListener(new a(this, horRankCard));
            } else {
                SkinManager.setBackgroundColor(this.m, R.color.CAM_X0201);
                this.m.setOnClickListener(null);
            }
            ic9 rightText = horRankCard.getRightText();
            if (rightText.f()) {
                this.s.setVisibility(8);
                this.r.setVisibility(0);
                this.r.setData(rightText, this.i);
                return;
            }
            this.r.setVisibility(8);
            if (!TextUtils.isEmpty(horRankCard.getScheme())) {
                this.s.setVisibility(0);
                SkinManager.setImageResource(this.s, R.drawable.icon_arrow_tab);
                return;
            }
            this.s.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d01cb, (ViewGroup) null, false);
            this.m = linearLayout;
            this.n = (HorizontalScrollListView) n(linearLayout, R.id.obfuscated_res_0x7f090fdd);
            this.o = (RelativeLayout) n(this.m, R.id.obfuscated_res_0x7f091fb8);
            this.p = (View) n(this.m, R.id.obfuscated_res_0x7f091527);
            this.q = (TextView) n(this.m, R.id.obfuscated_res_0x7f090fd8);
            this.r = (MoreButton) n(this.m, R.id.right_textview);
            this.s = (ImageView) n(this.m, R.id.obfuscated_res_0x7f091f8c);
            this.t = (ImageView) n(this.m, R.id.obfuscated_res_0x7f090925);
            return this.m;
        }
        return (View) invokeV.objValue;
    }
}
