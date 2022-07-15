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
import com.repackage.cr4;
import com.repackage.hd7;
import com.repackage.pi;
/* loaded from: classes3.dex */
public class ButtonCardView extends BaseCardView<ButtonCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout m;
    public TbImageView n;
    public Button o;
    public int p;
    public final int q;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ButtonCard a;
        public final /* synthetic */ ButtonCardView b;

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
            this.b = buttonCardView;
            this.a = buttonCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.setDialog(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ButtonCard a;
        public final /* synthetic */ ButtonCardView b;

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
            this.b = buttonCardView;
            this.a = buttonCard;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                UrlManager.getInstance().dealOneLink(this.b.i, new String[]{this.a.getBtnScheme()});
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ButtonCardView a;

        public c(ButtonCardView buttonCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buttonCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = buttonCardView;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
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
        this.q = pi.k(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDialog(ButtonCard buttonCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, buttonCard) == null) {
            cr4 cr4Var = new cr4(this.i.getPageActivity());
            cr4Var.setMessage("是否拨打电话:" + buttonCard.getPhoneNumber());
            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f035c, new b(this, buttonCard));
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new c(this));
            cr4Var.create(this.i).show();
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
        } else if (!hd7.a(bgColor)) {
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
        if (!hd7.a(textColor)) {
            this.o.setTextColor(textColor);
        }
        this.o.setOnClickListener(new a(this, buttonCard));
        this.p = buttonCard.getStyle();
        int buttonColor = buttonCard.getButtonColor();
        int i = this.p;
        if (i == 1) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (!hd7.a(buttonColor)) {
                gradientDrawable.setStroke(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07029a), buttonColor);
            }
            gradientDrawable.setColor(0);
            this.o.setBackgroundDrawable(gradientDrawable);
        } else if (i != 2) {
            this.o.setBackgroundColor(0);
        } else if (!hd7.a(buttonColor)) {
            this.o.setBackgroundColor(buttonColor);
        } else {
            this.o.setBackgroundColor(0);
        }
        if (LegoListFragment.R.contains(buttonCard.toString())) {
            return;
        }
        LegoListFragment.R.add(buttonCard.toString());
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
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.i.getPageActivity().getApplicationContext()).inflate(R.layout.obfuscated_res_0x7f0d0177, (ViewGroup) null);
            this.m = relativeLayout;
            this.o = (Button) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0903f0);
            this.n = (TbImageView) this.m.findViewById(R.id.obfuscated_res_0x7f091f90);
            return this.m;
        }
        return (View) invokeV.objValue;
    }

    public void setBackgroundAlpha(float f) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048580, this, f) == null) || (tbImageView = this.n) == null) {
            return;
        }
        tbImageView.setAlpha(f);
    }
}
