package com.baidu.tieba.lego.card.view;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import c.a.e.e.p.l;
import c.a.q0.s.s.a;
import c.a.r0.y2.y;
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
/* loaded from: classes7.dex */
public class ButtonCardView extends BaseCardView<ButtonCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f53961f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f53962g;

    /* renamed from: h  reason: collision with root package name */
    public Button f53963h;

    /* renamed from: i  reason: collision with root package name */
    public int f53964i;

    /* renamed from: j  reason: collision with root package name */
    public final int f53965j;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ButtonCard f53966e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ButtonCardView f53967f;

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
            this.f53967f = buttonCardView;
            this.f53966e = buttonCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f53967f.setDialog(this.f53966e);
                y.o().l().c(this.f53966e.getsExtras(), this.f53967f.mFrom);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ButtonCard f53968e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ButtonCardView f53969f;

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
            this.f53969f = buttonCardView;
            this.f53968e = buttonCard;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                UrlManager.getInstance().dealOneLink(this.f53969f.mContext, new String[]{this.f53968e.getBtnScheme()});
                y.o().l().e(this.f53969f.mFrom, "yes", this.f53968e.getsExtras());
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ButtonCard f53970e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ButtonCardView f53971f;

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
            this.f53971f = buttonCardView;
            this.f53970e = buttonCard;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                y.o().l().e(this.f53971f.mFrom, "no", this.f53970e.getsExtras());
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
        this.f53964i = -1;
        this.f53965j = l.k(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDialog(ButtonCard buttonCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, buttonCard) == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.mContext.getPageActivity());
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
            this.f53961f = relativeLayout;
            this.f53963h = (Button) relativeLayout.findViewById(R.id.bt_phone);
            this.f53962g = (TbImageView) this.f53961f.findViewById(R.id.tb_phone_background);
            return this.f53961f;
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
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (tbImageView = this.f53962g) == null) {
            return;
        }
        tbImageView.setVisibility(0);
        this.f53962g.setAlpha(1);
    }

    public void setBackgroundAlpha(float f2) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048583, this, f2) == null) || (tbImageView = this.f53962g) == null) {
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
        float cardWidth = (float) ((this.f53965j * 1.0d) / buttonCard.getCardWidth());
        ViewGroup.LayoutParams layoutParams = this.f53961f.getLayoutParams();
        layoutParams.width = this.f53965j;
        layoutParams.height = (int) (buttonCard.getCardHeight() * cardWidth);
        this.f53961f.setLayoutParams(layoutParams);
        int bgColor = buttonCard.getBgColor();
        this.f53962g.setDefaultBgResource(R.color.transparent);
        if (!TextUtils.isEmpty(buttonCard.getPicUrl())) {
            this.f53962g.startLoad(buttonCard.getPicUrl(), 17, false);
        } else if (!c.a.r0.p1.o.k.b.a(bgColor)) {
            this.f53962g.setBackgroundColor(bgColor);
        } else {
            this.f53962g.setDefaultBgResource(R.color.transparent);
        }
        int dimension = layoutParams.height - ((int) (TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.button_card_padding40) * cardWidth));
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f53963h.getLayoutParams();
        layoutParams2.height = dimension;
        layoutParams2.addRule(13);
        this.f53963h.setText(buttonCard.getText());
        this.f53963h.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
        int textColor = buttonCard.getTextColor();
        if (!c.a.r0.p1.o.k.b.a(textColor)) {
            this.f53963h.setTextColor(textColor);
        }
        this.f53963h.setOnClickListener(new a(this, buttonCard));
        this.f53964i = buttonCard.getStyle();
        int buttonColor = buttonCard.getButtonColor();
        int i2 = this.f53964i;
        if (i2 == 1) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (!c.a.r0.p1.o.k.b.a(buttonColor)) {
                gradientDrawable.setStroke(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds3), buttonColor);
            }
            gradientDrawable.setColor(0);
            this.f53963h.setBackgroundDrawable(gradientDrawable);
        } else if (i2 != 2) {
            this.f53963h.setBackgroundColor(0);
        } else if (!c.a.r0.p1.o.k.b.a(buttonColor)) {
            this.f53963h.setBackgroundColor(buttonColor);
        } else {
            this.f53963h.setBackgroundColor(0);
        }
        if (LegoListFragment.sHasShown.contains(buttonCard.toString())) {
            return;
        }
        LegoListFragment.sHasShown.add(buttonCard.toString());
        y.o().l().d(buttonCard.getShowExtra(), this.mFrom);
    }
}
