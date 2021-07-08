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
import d.a.c.e.p.l;
import d.a.p0.a0.t;
import d.a.p0.h3.v;
import d.a.p0.n1.e;
import d.a.p0.n1.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FocusListCardView extends BaseCardView<FocusListCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View r;
    public TextView s;
    public View t;
    public View u;
    public View v;
    public LinearLayout w;
    public List<LinearLayout> x;
    public List<View> y;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FocusListCard f18241e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f18242f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FocusListCardView f18243g;

        public a(FocusListCardView focusListCardView, FocusListCard focusListCard, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {focusListCardView, focusListCard, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18243g = focusListCardView;
            this.f18241e = focusListCard;
            this.f18242f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f18241e.getFocusItemList().get(this.f18242f).f18193f)) {
                return;
            }
            t.b().d(true);
            e e2 = i.e(this.f18241e);
            e2.b("obj_locate", this.f18242f + 1);
            e2.d(TiebaStatic.Params.OBJ_URL, this.f18241e.getFocusItemList().get(this.f18242f).f18193f);
            e2.c("obj_id", this.f18241e.getFocusItemList().get(this.f18242f).f18194g);
            e2.a(this.f18241e);
            v.c(this.f18243g.m, this.f18241e.getFocusItemList().get(this.f18242f).f18193f);
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

    public final void H(FocusListCard focusListCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, focusListCard) == null) {
            if (focusListCard == null) {
                SkinManager.setBackgroundColor(this.s, R.color.CAM_X0308);
                SkinManager.setBackgroundColor(this.t, R.color.CAM_X0308);
                SkinManager.setBackgroundColor(this.u, R.color.CAM_X0308);
                SkinManager.setBackgroundColor(this.v, R.color.CAM_X0308);
            } else {
                int bgColor = focusListCard.getBgColor();
                int bgColorNight = focusListCard.getBgColorNight();
                z(this.s, bgColor, bgColorNight, R.color.CAM_X0308);
                z(this.t, bgColor, bgColorNight, R.color.CAM_X0308);
                z(this.u, bgColor, bgColorNight, R.color.CAM_X0308);
                z(this.v, bgColor, bgColorNight, R.color.CAM_X0308);
            }
            if (focusListCard == null) {
                SkinManager.setViewTextColor(this.s, R.color.CAM_X0101);
            } else {
                A(this.s, focusListCard.getTitleColor(), focusListCard.getTitleColorNight(), R.color.CAM_X0101);
            }
            SkinManager.setBackgroundColor(this.w, R.color.CAM_X0201);
            List<LinearLayout> list = this.x;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < this.x.size(); i2++) {
                SkinManager.setBackgroundResource(this.x.get(i2), R.drawable.addresslist_item_bg);
            }
        }
    }

    public final void I(TextView textView, TextView textView2, TextView textView3, FocusListCard.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, textView2, textView3, aVar) == null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            J(textView2, aVar);
            SkinManager.setViewTextColor(textView3, R.color.CAM_X0109);
        }
    }

    public final void J(TextView textView, FocusListCard.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, textView, aVar) == null) || textView == null || aVar == null) {
            return;
        }
        A(textView, aVar.f18191d, aVar.f18192e, R.color.CAM_X0308);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: K */
    public void v(FocusListCard focusListCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, focusListCard, i2) == null) {
            d.a.o0.s0.a.a(this.m, getRootView());
            if (focusListCard != null) {
                H(focusListCard);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: L */
    public void w(FocusListCard focusListCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, focusListCard) == null) {
            if (focusListCard.getFocusItemList() != null && focusListCard.getFocusItemList().size() > 0) {
                this.s.setText(focusListCard.getCardTitle());
                int size = focusListCard.getFocusItemList().size();
                for (int i2 = 0; i2 < size && i2 < 5; i2++) {
                    this.x.get(i2).setVisibility(0);
                    if (i2 < size - 1 && i2 < 4) {
                        this.y.get(i2).setVisibility(0);
                        SkinManager.setBackgroundColor(this.y.get(i2), R.color.CAM_X0204);
                    } else {
                        this.y.get(i2).setVisibility(8);
                    }
                    TextView textView = (TextView) n(this.x.get(i2), R.id.focus_title);
                    TextView textView2 = (TextView) n(this.x.get(i2), R.id.subtitle);
                    TextView textView3 = (TextView) n(this.x.get(i2), R.id.right);
                    ImageView imageView = (ImageView) n(this.x.get(i2), R.id.rightIcon);
                    I(textView, textView2, textView3, focusListCard.getFocusItemList().get(i2));
                    textView.setText(focusListCard.getFocusItemList().get(i2).f18188a);
                    textView2.setText(focusListCard.getFocusItemList().get(i2).f18189b);
                    textView3.setText(focusListCard.getFocusItemList().get(i2).f18190c);
                    if (!TextUtils.isEmpty(focusListCard.getFocusItemList().get(i2).f18193f)) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView3.getLayoutParams();
                        layoutParams.setMargins(0, 0, 0, 0);
                        textView3.setLayoutParams(layoutParams);
                        imageView.setVisibility(0);
                        SkinManager.setImageResource(imageView, R.drawable.icon_arrow_tab);
                        this.x.get(i2).setOnClickListener(new a(this, focusListCard, i2));
                    } else {
                        imageView.setVisibility(8);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView3.getLayoutParams();
                        layoutParams2.setMargins(0, 0, l.g(getContext(), R.dimen.ds16), 0);
                        textView3.setLayoutParams(layoutParams2);
                        this.x.get(i2).setOnClickListener(null);
                    }
                }
                for (int size2 = focusListCard.getFocusItemList().size(); size2 < 5; size2++) {
                    this.x.get(size2).setVisibility(8);
                }
            }
            H(focusListCard);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.card_focus_list, (ViewGroup) null);
            this.r = inflate;
            this.s = (TextView) n(inflate, R.id.left_title);
            this.t = (View) n(this.r, R.id.topView);
            this.u = (View) n(this.r, R.id.bottomView);
            this.v = (View) n(this.r, R.id.rightView);
            this.w = (LinearLayout) n(this.r, R.id.container);
            this.x = new ArrayList();
            this.x.add((LinearLayout) n(this.w, R.id.one));
            this.x.add((LinearLayout) n(this.w, R.id.two));
            this.x.add((LinearLayout) n(this.w, R.id.three));
            this.x.add((LinearLayout) n(this.w, R.id.four));
            this.x.add((LinearLayout) n(this.w, R.id.five));
            this.y = new ArrayList();
            this.y.add((View) n(this.w, R.id.one_line));
            this.y.add((View) n(this.w, R.id.two_line));
            this.y.add((View) n(this.w, R.id.three_line));
            this.y.add((View) n(this.w, R.id.four_line));
            this.y.add((View) n(this.w, R.id.five_line));
            return this.r;
        }
        return (View) invokeV.objValue;
    }
}
