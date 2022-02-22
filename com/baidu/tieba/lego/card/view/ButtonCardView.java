package com.baidu.tieba.lego.card.view;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import c.a.d.f.p.n;
import c.a.t0.s.t.a;
import c.a.u0.l3.y;
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
/* loaded from: classes13.dex */
public class ButtonCardView extends BaseCardView<ButtonCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f45705f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f45706g;

    /* renamed from: h  reason: collision with root package name */
    public Button f45707h;

    /* renamed from: i  reason: collision with root package name */
    public int f45708i;

    /* renamed from: j  reason: collision with root package name */
    public final int f45709j;

    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ButtonCard f45710e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ButtonCardView f45711f;

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
            this.f45711f = buttonCardView;
            this.f45710e = buttonCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f45711f.setDialog(this.f45710e);
                y.q().l().c(this.f45710e.getsExtras(), this.f45711f.mFrom);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ButtonCard f45712e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ButtonCardView f45713f;

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
            this.f45713f = buttonCardView;
            this.f45712e = buttonCard;
        }

        @Override // c.a.t0.s.t.a.e
        public void onClick(c.a.t0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                UrlManager.getInstance().dealOneLink(this.f45713f.mContext, new String[]{this.f45712e.getBtnScheme()});
                y.q().l().e(this.f45713f.mFrom, "yes", this.f45712e.getsExtras());
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ButtonCard f45714e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ButtonCardView f45715f;

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
            this.f45715f = buttonCardView;
            this.f45714e = buttonCard;
        }

        @Override // c.a.t0.s.t.a.e
        public void onClick(c.a.t0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                y.q().l().e(this.f45715f.mFrom, "no", this.f45714e.getsExtras());
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
        this.f45708i = -1;
        this.f45709j = n.k(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDialog(ButtonCard buttonCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, buttonCard) == null) {
            c.a.t0.s.t.a aVar = new c.a.t0.s.t.a(this.mContext.getPageActivity());
            aVar.setMessage("是否拨打电话:" + buttonCard.getPhoneNumber());
            aVar.setPositiveButton(R.string.call, new b(this, buttonCard));
            aVar.setNegativeButton(R.string.cancel, new c(this, buttonCard));
            aVar.create(this.mContext).show();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View initLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.mContext.getPageActivity().getApplicationContext()).inflate(R.layout.card_button, (ViewGroup) null);
            this.f45705f = relativeLayout;
            this.f45707h = (Button) relativeLayout.findViewById(R.id.bt_phone);
            this.f45706g = (TbImageView) this.f45705f.findViewById(R.id.tb_phone_background);
            return this.f45705f;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onChangeSkinType(ButtonCard buttonCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, buttonCard, i2) == null) {
        }
    }

    public void reset() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (tbImageView = this.f45706g) == null) {
            return;
        }
        tbImageView.setVisibility(0);
        this.f45706g.setAlpha(1);
    }

    public void setBackgroundAlpha(float f2) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048583, this, f2) == null) || (tbImageView = this.f45706g) == null) {
            return;
        }
        tbImageView.setAlpha(f2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onUpdateCardView(ButtonCard buttonCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, buttonCard) == null) || buttonCard == null) {
            return;
        }
        reset();
        float cardWidth = (float) ((this.f45709j * 1.0d) / buttonCard.getCardWidth());
        ViewGroup.LayoutParams layoutParams = this.f45705f.getLayoutParams();
        layoutParams.width = this.f45709j;
        layoutParams.height = (int) (buttonCard.getCardHeight() * cardWidth);
        this.f45705f.setLayoutParams(layoutParams);
        int bgColor = buttonCard.getBgColor();
        this.f45706g.setDefaultBgResource(R.color.transparent);
        if (!TextUtils.isEmpty(buttonCard.getPicUrl())) {
            this.f45706g.startLoad(buttonCard.getPicUrl(), 17, false);
        } else if (!c.a.u0.z1.o.k.b.a(bgColor)) {
            this.f45706g.setBackgroundColor(bgColor);
        } else {
            this.f45706g.setDefaultBgResource(R.color.transparent);
        }
        int dimension = layoutParams.height - ((int) (TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.button_card_padding40) * cardWidth));
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f45707h.getLayoutParams();
        layoutParams2.height = dimension;
        layoutParams2.addRule(13);
        this.f45707h.setText(buttonCard.getText());
        this.f45707h.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
        int textColor = buttonCard.getTextColor();
        if (!c.a.u0.z1.o.k.b.a(textColor)) {
            this.f45707h.setTextColor(textColor);
        }
        this.f45707h.setOnClickListener(new a(this, buttonCard));
        this.f45708i = buttonCard.getStyle();
        int buttonColor = buttonCard.getButtonColor();
        int i2 = this.f45708i;
        if (i2 == 1) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (!c.a.u0.z1.o.k.b.a(buttonColor)) {
                gradientDrawable.setStroke(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds3), buttonColor);
            }
            gradientDrawable.setColor(0);
            this.f45707h.setBackgroundDrawable(gradientDrawable);
        } else if (i2 != 2) {
            this.f45707h.setBackgroundColor(0);
        } else if (!c.a.u0.z1.o.k.b.a(buttonColor)) {
            this.f45707h.setBackgroundColor(buttonColor);
        } else {
            this.f45707h.setBackgroundColor(0);
        }
        if (LegoListFragment.sHasShown.contains(buttonCard.toString())) {
            return;
        }
        LegoListFragment.sHasShown.add(buttonCard.toString());
        y.q().l().d(buttonCard.getShowExtra(), this.mFrom);
    }
}
