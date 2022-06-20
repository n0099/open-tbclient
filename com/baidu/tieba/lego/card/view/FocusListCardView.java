package com.baidu.tieba.lego.card.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.FocusListCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d95;
import com.repackage.fx5;
import com.repackage.nb7;
import com.repackage.pi;
import com.repackage.rb7;
import com.repackage.sg8;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class FocusListCardView extends BaseCardView<FocusListCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View m;
    public TextView n;
    public View o;
    public View p;
    public View q;
    public LinearLayout r;
    public List<LinearLayout> s;
    public List<View> t;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FocusListCard a;
        public final /* synthetic */ int b;
        public final /* synthetic */ FocusListCardView c;

        public a(FocusListCardView focusListCardView, FocusListCard focusListCard, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {focusListCardView, focusListCard, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = focusListCardView;
            this.a = focusListCard;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || TextUtils.isEmpty(this.a.getFocusItemList().get(this.b).f)) {
                return;
            }
            fx5.b().d(true);
            nb7 e = rb7.e(this.a);
            e.b("obj_locate", this.b + 1);
            e.d(TiebaStatic.Params.OBJ_URL, this.a.getFocusItemList().get(this.b).f);
            e.c("obj_id", this.a.getFocusItemList().get(this.b).g);
            e.a(this.a);
            sg8.c(this.c.i, this.a.getFocusItemList().get(this.b).f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusListCardView(TbPageContext tbPageContext) {
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

    public final void C(FocusListCard focusListCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, focusListCard) == null) {
            if (focusListCard == null) {
                SkinManager.setBackgroundColor(this.n, R.color.CAM_X0308);
                SkinManager.setBackgroundColor(this.o, R.color.CAM_X0308);
                SkinManager.setBackgroundColor(this.p, R.color.CAM_X0308);
                SkinManager.setBackgroundColor(this.q, R.color.CAM_X0308);
            } else {
                int bgColor = focusListCard.getBgColor();
                int bgColorNight = focusListCard.getBgColorNight();
                x(this.n, bgColor, bgColorNight, R.color.CAM_X0308);
                x(this.o, bgColor, bgColorNight, R.color.CAM_X0308);
                x(this.p, bgColor, bgColorNight, R.color.CAM_X0308);
                x(this.q, bgColor, bgColorNight, R.color.CAM_X0308);
            }
            if (focusListCard == null) {
                SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0101);
            } else {
                y(this.n, focusListCard.getTitleColor(), focusListCard.getTitleColorNight(), R.color.CAM_X0101);
            }
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0201);
            List<LinearLayout> list = this.s;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (int i = 0; i < this.s.size(); i++) {
                SkinManager.setBackgroundResource(this.s.get(i), R.drawable.addresslist_item_bg);
            }
        }
    }

    public final void D(TextView textView, TextView textView2, TextView textView3, FocusListCard.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, textView2, textView3, aVar) == null) {
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            E(textView2, aVar);
            SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0109);
        }
    }

    public final void E(TextView textView, FocusListCard.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, textView, aVar) == null) || textView == null || aVar == null) {
            return;
        }
        y(textView, aVar.d, aVar.e, R.color.CAM_X0308);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: F */
    public void t(FocusListCard focusListCard, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, focusListCard, i) == null) {
            d95.a(this.i, getRootView());
            if (focusListCard != null) {
                C(focusListCard);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: G */
    public void u(FocusListCard focusListCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, focusListCard) == null) {
            if (focusListCard.getFocusItemList() != null && focusListCard.getFocusItemList().size() > 0) {
                this.n.setText(focusListCard.getCardTitle());
                int size = focusListCard.getFocusItemList().size();
                for (int i = 0; i < size && i < 5; i++) {
                    this.s.get(i).setVisibility(0);
                    if (i < size - 1 && i < 4) {
                        this.t.get(i).setVisibility(0);
                        SkinManager.setBackgroundColor(this.t.get(i), R.color.CAM_X0204);
                    } else {
                        this.t.get(i).setVisibility(8);
                    }
                    TextView textView = (TextView) l(this.s.get(i), R.id.obfuscated_res_0x7f0909c2);
                    TextView textView2 = (TextView) l(this.s.get(i), R.id.obfuscated_res_0x7f091dba);
                    TextView textView3 = (TextView) l(this.s.get(i), R.id.obfuscated_res_0x7f091a7f);
                    ImageView imageView = (ImageView) l(this.s.get(i), R.id.obfuscated_res_0x7f091a85);
                    D(textView, textView2, textView3, focusListCard.getFocusItemList().get(i));
                    textView.setText(focusListCard.getFocusItemList().get(i).a);
                    textView2.setText(focusListCard.getFocusItemList().get(i).b);
                    textView3.setText(focusListCard.getFocusItemList().get(i).c);
                    if (!TextUtils.isEmpty(focusListCard.getFocusItemList().get(i).f)) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView3.getLayoutParams();
                        layoutParams.setMargins(0, 0, 0, 0);
                        textView3.setLayoutParams(layoutParams);
                        imageView.setVisibility(0);
                        SkinManager.setImageResource(imageView, R.drawable.icon_arrow_tab);
                        this.s.get(i).setOnClickListener(new a(this, focusListCard, i));
                    } else {
                        imageView.setVisibility(8);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView3.getLayoutParams();
                        layoutParams2.setMargins(0, 0, pi.f(getContext(), R.dimen.obfuscated_res_0x7f0701be), 0);
                        textView3.setLayoutParams(layoutParams2);
                        this.s.get(i).setOnClickListener(null);
                    }
                }
                for (int size2 = focusListCard.getFocusItemList().size(); size2 < 5; size2++) {
                    this.s.get(size2).setVisibility(8);
                }
            }
            C(focusListCard);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d017e, (ViewGroup) null);
            this.m = inflate;
            this.n = (TextView) l(inflate, R.id.obfuscated_res_0x7f0911e3);
            this.o = (View) l(this.m, R.id.obfuscated_res_0x7f092087);
            this.p = (View) l(this.m, R.id.obfuscated_res_0x7f0903b3);
            this.q = (View) l(this.m, R.id.obfuscated_res_0x7f091a88);
            this.r = (LinearLayout) l(this.m, R.id.obfuscated_res_0x7f09069b);
            this.s = new ArrayList();
            this.s.add((LinearLayout) l(this.r, R.id.obfuscated_res_0x7f0915b5));
            this.s.add((LinearLayout) l(this.r, R.id.obfuscated_res_0x7f092210));
            this.s.add((LinearLayout) l(this.r, R.id.obfuscated_res_0x7f091fd3));
            this.s.add((LinearLayout) l(this.r, R.id.obfuscated_res_0x7f090a70));
            this.s.add((LinearLayout) l(this.r, R.id.obfuscated_res_0x7f09098e));
            this.t = new ArrayList();
            this.t.add((View) l(this.r, R.id.obfuscated_res_0x7f0915b6));
            this.t.add((View) l(this.r, R.id.obfuscated_res_0x7f092212));
            this.t.add((View) l(this.r, R.id.obfuscated_res_0x7f091fd4));
            this.t.add((View) l(this.r, R.id.obfuscated_res_0x7f090a71));
            this.t.add((View) l(this.r, R.id.obfuscated_res_0x7f09098f));
            return this.m;
        }
        return (View) invokeV.objValue;
    }
}
