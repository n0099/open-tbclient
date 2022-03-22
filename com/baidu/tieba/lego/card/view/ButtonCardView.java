package com.baidu.tieba.lego.card.view;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import c.a.d.f.p.n;
import c.a.o0.r.t.a;
import c.a.p0.l3.z;
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
/* loaded from: classes5.dex */
public class ButtonCardView extends BaseCardView<ButtonCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout m;
    public TbImageView n;
    public Button o;
    public int p;
    public final int q;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ButtonCard a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ButtonCardView f34247b;

        public a(ButtonCardView buttonCardView, ButtonCard buttonCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buttonCardView, buttonCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34247b = buttonCardView;
            this.a = buttonCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f34247b.setDialog(this.a);
                z.q().l().c(this.a.getsExtras(), this.f34247b.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ButtonCard a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ButtonCardView f34248b;

        public b(ButtonCardView buttonCardView, ButtonCard buttonCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buttonCardView, buttonCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34248b = buttonCardView;
            this.a = buttonCard;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                UrlManager.getInstance().dealOneLink(this.f34248b.i, new String[]{this.a.getBtnScheme()});
                z.q().l().e(this.f34248b.a, "yes", this.a.getsExtras());
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ButtonCard a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ButtonCardView f34249b;

        public c(ButtonCardView buttonCardView, ButtonCard buttonCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buttonCardView, buttonCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34249b = buttonCardView;
            this.a = buttonCard;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                z.q().l().e(this.f34249b.a, "no", this.a.getsExtras());
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = -1;
        this.q = n.k(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDialog(ButtonCard buttonCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, buttonCard) == null) {
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.i.getPageActivity());
            aVar.setMessage("是否拨打电话:" + buttonCard.getPhoneNumber());
            aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f035e, new b(this, buttonCard));
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new c(this, buttonCard));
            aVar.create(this.i).show();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: D */
    public void t(ButtonCard buttonCard, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, buttonCard, i) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: E */
    public void u(ButtonCard buttonCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buttonCard) == null) || buttonCard == null) {
            return;
        }
        F();
        float cardWidth = (float) ((this.q * 1.0d) / buttonCard.getCardWidth());
        ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
        layoutParams.width = this.q;
        layoutParams.height = (int) (buttonCard.getCardHeight() * cardWidth);
        this.m.setLayoutParams(layoutParams);
        int bgColor = buttonCard.getBgColor();
        this.n.setDefaultBgResource(R.color.transparent);
        if (!TextUtils.isEmpty(buttonCard.getPicUrl())) {
            this.n.J(buttonCard.getPicUrl(), 17, false);
        } else if (!c.a.p0.b2.o.k.b.a(bgColor)) {
            this.n.setBackgroundColor(bgColor);
        } else {
            this.n.setDefaultBgResource(R.color.transparent);
        }
        int dimension = layoutParams.height - ((int) (TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f0701ad) * cardWidth));
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
        layoutParams2.height = dimension;
        layoutParams2.addRule(13);
        this.o.setText(buttonCard.getText());
        this.o.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b5));
        int textColor = buttonCard.getTextColor();
        if (!c.a.p0.b2.o.k.b.a(textColor)) {
            this.o.setTextColor(textColor);
        }
        this.o.setOnClickListener(new a(this, buttonCard));
        this.p = buttonCard.getStyle();
        int buttonColor = buttonCard.getButtonColor();
        int i = this.p;
        if (i == 1) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (!c.a.p0.b2.o.k.b.a(buttonColor)) {
                gradientDrawable.setStroke(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070291), buttonColor);
            }
            gradientDrawable.setColor(0);
            this.o.setBackgroundDrawable(gradientDrawable);
        } else if (i != 2) {
            this.o.setBackgroundColor(0);
        } else if (!c.a.p0.b2.o.k.b.a(buttonColor)) {
            this.o.setBackgroundColor(buttonColor);
        } else {
            this.o.setBackgroundColor(0);
        }
        if (LegoListFragment.R.contains(buttonCard.toString())) {
            return;
        }
        LegoListFragment.R.add(buttonCard.toString());
        z.q().l().d(buttonCard.getShowExtra(), this.a);
    }

    public void F() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tbImageView = this.n) == null) {
            return;
        }
        tbImageView.setVisibility(0);
        this.n.setAlpha(1);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.i.getPageActivity().getApplicationContext()).inflate(R.layout.obfuscated_res_0x7f0d017d, (ViewGroup) null);
            this.m = relativeLayout;
            this.o = (Button) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0903f5);
            this.n = (TbImageView) this.m.findViewById(R.id.obfuscated_res_0x7f091f02);
            return this.m;
        }
        return (View) invokeV.objValue;
    }

    public void setBackgroundAlpha(float f2) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048580, this, f2) == null) || (tbImageView = this.n) == null) {
            return;
        }
        tbImageView.setAlpha(f2);
    }
}
