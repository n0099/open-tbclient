package com.baidu.tieba.lego.card.view;

import android.annotation.SuppressLint;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.cg9;
import com.baidu.tieba.gf9;
import com.baidu.tieba.jq5;
import com.baidu.tieba.lego.card.model.SingleLineCard;
import com.baidu.tieba.lego.card.utils.ColorUtils;
import com.baidu.tieba.lego.view.MoreButton;
import com.baidu.tieba.nva;
import com.baidu.tieba.uf9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes7.dex */
public class SingleLineCardView extends BaseCardView<SingleLineCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout m;
    public View n;
    public TbImageView o;
    public TextView p;
    public TextView q;
    public MoreButton r;
    public ImageView s;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SingleLineCard a;
        public final /* synthetic */ SingleLineCardView b;

        public a(SingleLineCardView singleLineCardView, SingleLineCard singleLineCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleLineCardView, singleLineCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = singleLineCardView;
            this.a = singleLineCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                gf9.e(this.a).d(TiebaStatic.Params.OBJ_URL, this.a.getScheme()).b("obj_locate", this.b.getStatPosition()).a(this.a);
                nva.c(this.b.i, this.a.getScheme());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleLineCardView(TbPageContext tbPageContext) {
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

    private void setPrefixTitle(SingleLineCard singleLineCard) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, this, singleLineCard) != null) || singleLineCard == null) {
            return;
        }
        this.q.setVisibility(0);
        this.q.setText(singleLineCard.getIconTitle());
        this.q.setTextSize(0, getResources().getDisplayMetrics().density * (singleLineCard.getTextSize() / 2.0f));
        setPrefixTitleColor(singleLineCard);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setBgColor(SingleLineCard singleLineCard) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, this, singleLineCard) != null) || singleLineCard == null) {
            return;
        }
        boolean z = false;
        if (t()) {
            if (!ColorUtils.isColorInvalid(singleLineCard.getBgColorNight())) {
                this.m.setBackgroundColor(singleLineCard.getBgColorNight());
                z = true;
            }
            if (z) {
                if (TextUtils.isEmpty(singleLineCard.getScheme())) {
                    SkinManager.setBackgroundColor(this.m, R.color.CAM_X0201);
                    return;
                } else {
                    SkinManager.setBackgroundResource(this.m, R.drawable.addresslist_item_bg);
                    return;
                }
            }
            return;
        }
        if (!ColorUtils.isColorInvalid(singleLineCard.getBgColor())) {
            this.m.setBackgroundColor(singleLineCard.getBgColor());
            z = true;
        }
        if (z) {
        }
    }

    private void setMoreColor(cg9 cg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, cg9Var) == null) {
            if (cg9Var == null) {
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
            } else {
                A(this.r, cg9Var.b(), cg9Var.c(), R.color.CAM_X0302);
            }
        }
    }

    private void setPrefixTitleColor(SingleLineCard singleLineCard) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, singleLineCard) != null) || singleLineCard == null) {
            return;
        }
        A(this.q, singleLineCard.getIconTitleColor(), singleLineCard.getIconTitleColorNight(), R.color.CAM_X0302);
    }

    private void setTitleColor(SingleLineCard singleLineCard) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, this, singleLineCard) != null) || singleLineCard == null) {
            return;
        }
        A(this.p, singleLineCard.getTitleColor(), singleLineCard.getTitleColorNight(), R.color.CAM_X0105);
    }

    public final String E(SingleLineCard singleLineCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, singleLineCard)) == null) {
            if (t()) {
                return singleLineCard.getIconUrlNight();
            }
            return singleLineCard.getIconUrl();
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: F */
    public void v(SingleLineCard singleLineCard, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, singleLineCard, i) == null) {
            jq5.a(this.i, getRootView());
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0308);
            if (singleLineCard != null) {
                setBgColor(singleLineCard);
                setTitleColor(singleLineCard);
                setMoreColor(singleLineCard.getButtonInfo());
                setPrefixTitleColor(singleLineCard);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: G */
    public void w(SingleLineCard singleLineCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, singleLineCard) == null) {
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f070275);
            ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
            if (singleLineCard.getMaxLines() > 1) {
                layoutParams.height = -2;
                this.m.setMinimumHeight(dimens);
            } else if (singleLineCard.getHeight() > 0) {
                int dip2px = BdUtilHelper.dip2px(getContext(), singleLineCard.getHeight());
                layoutParams.height = dip2px;
                this.m.setMinimumHeight(dip2px);
            } else {
                layoutParams.height = dimens;
                this.m.setMinimumHeight(dimens);
            }
            this.m.setLayoutParams(layoutParams);
            if (singleLineCard.isShowLeftIcon()) {
                this.o.setVisibility(0);
                if (!TextUtils.isEmpty(E(singleLineCard))) {
                    this.o.setImageDrawable(null);
                    this.o.startLoad(E(singleLineCard), 10, false);
                } else if (!TextUtils.isEmpty(singleLineCard.getIconTitle())) {
                    this.o.setVisibility(8);
                    setPrefixTitle(singleLineCard);
                } else {
                    this.q.setVisibility(8);
                    SkinManager.setImageResource(this.o, uf9.a(singleLineCard.getIconType()));
                }
            } else {
                this.q.setVisibility(8);
                this.o.setVisibility(8);
            }
            if (singleLineCard.isShowLeftLine()) {
                this.n.setVisibility(0);
            } else {
                this.n.setVisibility(8);
            }
            setBgColor(singleLineCard);
            setTitleColor(singleLineCard);
            setMoreColor(singleLineCard.getButtonInfo());
            this.p.setTextSize(0, getResources().getDisplayMetrics().density * (singleLineCard.getTextSize() / 2.0f));
            if (singleLineCard.getMaxLines() > 1) {
                this.p.setSingleLine(false);
                this.p.setMaxLines(singleLineCard.getMaxLines());
            } else {
                this.p.setSingleLine(true);
            }
            this.p.setText(singleLineCard.getCardTitle());
            SpannableString m = m(singleLineCard.getCardTitle(), singleLineCard.getParams(), singleLineCard.getParamColor(), singleLineCard.getParamColorNight());
            if (m != null) {
                this.p.setText(m);
            }
            if (singleLineCard.getGravity() == 1) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.p.getLayoutParams();
                layoutParams2.weight = 0.0f;
                layoutParams2.width = -2;
                this.p.setLayoutParams(layoutParams2);
                this.m.setGravity(17);
            } else {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.p.getLayoutParams();
                layoutParams3.weight = 1.0f;
                layoutParams3.width = 0;
                this.p.setLayoutParams(layoutParams3);
                this.m.setGravity(0);
            }
            if (!TextUtils.isEmpty(singleLineCard.getScheme())) {
                setOnClickListener(new a(this, singleLineCard));
                this.s.setVisibility(0);
                SkinManager.setImageResource(this.s, R.drawable.icon_arrow_tab);
            } else {
                setOnClickListener(null);
                this.s.setVisibility(8);
            }
            cg9 buttonInfo = singleLineCard.getButtonInfo();
            if (buttonInfo.f()) {
                this.r.setVisibility(0);
                this.s.setVisibility(8);
                this.r.setData(buttonInfo, this.i);
                return;
            }
            this.r.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d01f0, (ViewGroup) null);
            this.m = linearLayout;
            this.n = (View) n(linearLayout, R.id.obfuscated_res_0x7f0915a1);
            this.o = (TbImageView) n(this.m, R.id.obfuscated_res_0x7f0915a0);
            this.p = (TextView) n(this.m, R.id.obfuscated_res_0x7f092685);
            this.q = (TextView) n(this.m, R.id.obfuscated_res_0x7f0926ab);
            this.r = (MoreButton) n(this.m, R.id.obfuscated_res_0x7f09185c);
            this.s = (ImageView) n(this.m, R.id.obfuscated_res_0x7f092006);
            return this.m;
        }
        return (View) invokeV.objValue;
    }
}
