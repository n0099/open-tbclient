package com.baidu.tieba.lego.card.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.r0.g0.v;
import c.a.r0.t3.w;
import c.a.r0.w1.e;
import c.a.r0.w1.i;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class FocusListCardView extends BaseCardView<FocusListCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public View f46578f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f46579g;

    /* renamed from: h  reason: collision with root package name */
    public View f46580h;

    /* renamed from: i  reason: collision with root package name */
    public View f46581i;

    /* renamed from: j  reason: collision with root package name */
    public View f46582j;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f46583k;
    public List<LinearLayout> l;
    public List<View> m;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FocusListCard f46584e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46585f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FocusListCardView f46586g;

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
            this.f46586g = focusListCardView;
            this.f46584e = focusListCard;
            this.f46585f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f46584e.getFocusItemList().get(this.f46585f).f46531f)) {
                return;
            }
            v.b().d(true);
            e e2 = i.e(this.f46584e);
            e2.b("obj_locate", this.f46585f + 1);
            e2.d(TiebaStatic.Params.OBJ_URL, this.f46584e.getFocusItemList().get(this.f46585f).f46531f);
            e2.c("obj_id", this.f46584e.getFocusItemList().get(this.f46585f).f46532g);
            e2.a(this.f46584e);
            w.c(this.f46586g.mContext, this.f46584e.getFocusItemList().get(this.f46585f).f46531f);
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

    public final void c(FocusListCard focusListCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, focusListCard) == null) {
            if (focusListCard == null) {
                SkinManager.setBackgroundColor(this.f46579g, R.color.CAM_X0308);
                SkinManager.setBackgroundColor(this.f46580h, R.color.CAM_X0308);
                SkinManager.setBackgroundColor(this.f46581i, R.color.CAM_X0308);
                SkinManager.setBackgroundColor(this.f46582j, R.color.CAM_X0308);
            } else {
                int bgColor = focusListCard.getBgColor();
                int bgColorNight = focusListCard.getBgColorNight();
                setBackgroundColor(this.f46579g, bgColor, bgColorNight, R.color.CAM_X0308);
                setBackgroundColor(this.f46580h, bgColor, bgColorNight, R.color.CAM_X0308);
                setBackgroundColor(this.f46581i, bgColor, bgColorNight, R.color.CAM_X0308);
                setBackgroundColor(this.f46582j, bgColor, bgColorNight, R.color.CAM_X0308);
            }
            if (focusListCard == null) {
                SkinManager.setViewTextColor(this.f46579g, R.color.CAM_X0101);
            } else {
                setTextColor(this.f46579g, focusListCard.getTitleColor(), focusListCard.getTitleColorNight(), R.color.CAM_X0101);
            }
            SkinManager.setBackgroundColor(this.f46583k, R.color.CAM_X0201);
            List<LinearLayout> list = this.l;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < this.l.size(); i2++) {
                SkinManager.setBackgroundResource(this.l.get(i2), R.drawable.addresslist_item_bg);
            }
        }
    }

    public final void d(TextView textView, TextView textView2, TextView textView3, FocusListCard.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, textView2, textView3, aVar) == null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            e(textView2, aVar);
            SkinManager.setViewTextColor(textView3, R.color.CAM_X0109);
        }
    }

    public final void e(TextView textView, FocusListCard.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, textView, aVar) == null) || textView == null || aVar == null) {
            return;
        }
        setTextColor(textView, aVar.f46529d, aVar.f46530e, R.color.CAM_X0308);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View initLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.card_focus_list, (ViewGroup) null);
            this.f46578f = inflate;
            this.f46579g = (TextView) findViewById(inflate, R.id.left_title);
            this.f46580h = (View) findViewById(this.f46578f, R.id.topView);
            this.f46581i = (View) findViewById(this.f46578f, R.id.bottomView);
            this.f46582j = (View) findViewById(this.f46578f, R.id.rightView);
            this.f46583k = (LinearLayout) findViewById(this.f46578f, R.id.container);
            this.l = new ArrayList();
            this.l.add((LinearLayout) findViewById(this.f46583k, R.id.one));
            this.l.add((LinearLayout) findViewById(this.f46583k, R.id.two));
            this.l.add((LinearLayout) findViewById(this.f46583k, R.id.three));
            this.l.add((LinearLayout) findViewById(this.f46583k, R.id.four));
            this.l.add((LinearLayout) findViewById(this.f46583k, R.id.five));
            this.m = new ArrayList();
            this.m.add((View) findViewById(this.f46583k, R.id.one_line));
            this.m.add((View) findViewById(this.f46583k, R.id.two_line));
            this.m.add((View) findViewById(this.f46583k, R.id.three_line));
            this.m.add((View) findViewById(this.f46583k, R.id.four_line));
            this.m.add((View) findViewById(this.f46583k, R.id.five_line));
            return this.f46578f;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onChangeSkinType(FocusListCard focusListCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, focusListCard, i2) == null) {
            c.a.q0.w0.a.a(this.mContext, getRootView());
            if (focusListCard != null) {
                c(focusListCard);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onUpdateCardView(FocusListCard focusListCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, focusListCard) == null) {
            if (focusListCard.getFocusItemList() != null && focusListCard.getFocusItemList().size() > 0) {
                this.f46579g.setText(focusListCard.getCardTitle());
                int size = focusListCard.getFocusItemList().size();
                for (int i2 = 0; i2 < size && i2 < 5; i2++) {
                    this.l.get(i2).setVisibility(0);
                    if (i2 < size - 1 && i2 < 4) {
                        this.m.get(i2).setVisibility(0);
                        SkinManager.setBackgroundColor(this.m.get(i2), R.color.CAM_X0204);
                    } else {
                        this.m.get(i2).setVisibility(8);
                    }
                    TextView textView = (TextView) findViewById(this.l.get(i2), R.id.focus_title);
                    TextView textView2 = (TextView) findViewById(this.l.get(i2), R.id.subtitle);
                    TextView textView3 = (TextView) findViewById(this.l.get(i2), R.id.right);
                    ImageView imageView = (ImageView) findViewById(this.l.get(i2), R.id.rightIcon);
                    d(textView, textView2, textView3, focusListCard.getFocusItemList().get(i2));
                    textView.setText(focusListCard.getFocusItemList().get(i2).a);
                    textView2.setText(focusListCard.getFocusItemList().get(i2).f46527b);
                    textView3.setText(focusListCard.getFocusItemList().get(i2).f46528c);
                    if (!TextUtils.isEmpty(focusListCard.getFocusItemList().get(i2).f46531f)) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView3.getLayoutParams();
                        layoutParams.setMargins(0, 0, 0, 0);
                        textView3.setLayoutParams(layoutParams);
                        imageView.setVisibility(0);
                        SkinManager.setImageResource(imageView, R.drawable.icon_arrow_tab);
                        this.l.get(i2).setOnClickListener(new a(this, focusListCard, i2));
                    } else {
                        imageView.setVisibility(8);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView3.getLayoutParams();
                        layoutParams2.setMargins(0, 0, l.f(getContext(), R.dimen.ds16), 0);
                        textView3.setLayoutParams(layoutParams2);
                        this.l.get(i2).setOnClickListener(null);
                    }
                }
                for (int size2 = focusListCard.getFocusItemList().size(); size2 < 5; size2++) {
                    this.l.get(size2).setVisibility(8);
                }
            }
            c(focusListCard);
        }
    }
}
