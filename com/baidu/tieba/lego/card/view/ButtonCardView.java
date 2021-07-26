package com.baidu.tieba.lego.card.view;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.activity.LegoListFragment;
import com.baidu.tieba.lego.card.model.ButtonCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.s.s.a;
import d.a.q0.w2.w;
/* loaded from: classes4.dex */
public class ButtonCardView extends BaseCardView<ButtonCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout r;
    public TbImageView s;
    public Button t;
    public int u;
    public final int v;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ButtonCard f18291e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ButtonCardView f18292f;

        public a(ButtonCardView buttonCardView, ButtonCard buttonCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buttonCardView, buttonCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18292f = buttonCardView;
            this.f18291e = buttonCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18292f.setDialog(this.f18291e);
                w.o().l().c(this.f18291e.getsExtras(), this.f18292f.f18286e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ButtonCard f18293e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ButtonCardView f18294f;

        public b(ButtonCardView buttonCardView, ButtonCard buttonCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buttonCardView, buttonCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18294f = buttonCardView;
            this.f18293e = buttonCard;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                UrlManager.getInstance().dealOneLink(this.f18294f.m, new String[]{this.f18293e.getBtnScheme()});
                w.o().l().e(this.f18294f.f18286e, "yes", this.f18293e.getsExtras());
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ButtonCard f18295e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ButtonCardView f18296f;

        public c(ButtonCardView buttonCardView, ButtonCard buttonCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buttonCardView, buttonCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18296f = buttonCardView;
            this.f18295e = buttonCard;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                w.o().l().e(this.f18296f.f18286e, "no", this.f18295e.getsExtras());
                aVar.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonCardView(TbPageContext tbPageContext) {
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
        this.u = -1;
        this.v = l.k(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDialog(ButtonCard buttonCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, buttonCard) == null) {
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.m.getPageActivity());
            aVar.setMessage("是否拨打电话:" + buttonCard.getPhoneNumber());
            aVar.setPositiveButton(R.string.call, new b(this, buttonCard));
            aVar.setNegativeButton(R.string.cancel, new c(this, buttonCard));
            aVar.create(this.m).show();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: I */
    public void v(ButtonCard buttonCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, buttonCard, i2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: J */
    public void w(ButtonCard buttonCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buttonCard) == null) || buttonCard == null) {
            return;
        }
        K();
        float cardWidth = (float) ((this.v * 1.0d) / buttonCard.getCardWidth());
        ViewGroup.LayoutParams layoutParams = this.r.getLayoutParams();
        layoutParams.width = this.v;
        layoutParams.height = (int) (buttonCard.getCardHeight() * cardWidth);
        this.r.setLayoutParams(layoutParams);
        int bgColor = buttonCard.getBgColor();
        this.s.setDefaultBgResource(R.color.transparent);
        if (!TextUtils.isEmpty(buttonCard.getPicUrl())) {
            this.s.M(buttonCard.getPicUrl(), 17, false);
        } else if (!d.a.q0.n1.o.k.b.a(bgColor)) {
            this.s.setBackgroundColor(bgColor);
        } else {
            this.s.setDefaultBgResource(R.color.transparent);
        }
        int dimension = layoutParams.height - ((int) (TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.button_card_padding40) * cardWidth));
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
        layoutParams2.height = dimension;
        layoutParams2.addRule(13);
        this.t.setText(buttonCard.getText());
        this.t.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
        int textColor = buttonCard.getTextColor();
        if (!d.a.q0.n1.o.k.b.a(textColor)) {
            this.t.setTextColor(textColor);
        }
        this.t.setOnClickListener(new a(this, buttonCard));
        this.u = buttonCard.getStyle();
        int buttonColor = buttonCard.getButtonColor();
        int i2 = this.u;
        if (i2 == 1) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (!d.a.q0.n1.o.k.b.a(buttonColor)) {
                gradientDrawable.setStroke(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds3), buttonColor);
            }
            gradientDrawable.setColor(0);
            this.t.setBackgroundDrawable(gradientDrawable);
        } else if (i2 != 2) {
            this.t.setBackgroundColor(0);
        } else if (!d.a.q0.n1.o.k.b.a(buttonColor)) {
            this.t.setBackgroundColor(buttonColor);
        } else {
            this.t.setBackgroundColor(0);
        }
        if (LegoListFragment.V.contains(buttonCard.toString())) {
            return;
        }
        LegoListFragment.V.add(buttonCard.toString());
        w.o().l().d(buttonCard.getShowExtra(), this.f18286e);
    }

    public void K() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tbImageView = this.s) == null) {
            return;
        }
        tbImageView.setVisibility(0);
        this.s.setAlpha(1);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.m.getPageActivity().getApplicationContext()).inflate(R.layout.card_button, (ViewGroup) null);
            this.r = relativeLayout;
            this.t = (Button) relativeLayout.findViewById(R.id.bt_phone);
            this.s = (TbImageView) this.r.findViewById(R.id.tb_phone_background);
            return this.r;
        }
        return (View) invokeV.objValue;
    }

    public void setBackgroundAlpha(float f2) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048580, this, f2) == null) || (tbImageView = this.s) == null) {
            return;
        }
        tbImageView.setAlpha(f2);
    }
}
