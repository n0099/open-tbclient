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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.SingleLineCard;
import com.baidu.tieba.lego.view.MoreButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.h3.v;
import d.a.q0.n1.i;
import d.a.q0.n1.o.f;
import d.a.q0.n1.o.j.c;
import d.a.q0.n1.o.k.b;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class SingleLineCardView extends BaseCardView<SingleLineCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout r;
    public View s;
    public TbImageView t;
    public TextView u;
    public TextView v;
    public MoreButton w;
    public ImageView x;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SingleLineCard f18341e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SingleLineCardView f18342f;

        public a(SingleLineCardView singleLineCardView, SingleLineCard singleLineCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleLineCardView, singleLineCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18342f = singleLineCardView;
            this.f18341e = singleLineCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                i.e(this.f18341e).d(TiebaStatic.Params.OBJ_URL, this.f18341e.getScheme()).b("obj_locate", this.f18342f.getStatPosition()).a(this.f18341e);
                v.c(this.f18342f.m, this.f18341e.getScheme());
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

    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setBgColor(SingleLineCard singleLineCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, singleLineCard) == null) || singleLineCard == null) {
            return;
        }
        boolean z = false;
        if (t()) {
            if (!b.a(singleLineCard.getBgColorNight())) {
                this.r.setBackgroundColor(singleLineCard.getBgColorNight());
                z = true;
            }
            if (z) {
                if (TextUtils.isEmpty(singleLineCard.getScheme())) {
                    SkinManager.setBackgroundColor(this.r, R.color.CAM_X0201);
                    return;
                } else {
                    SkinManager.setBackgroundResource(this.r, R.drawable.addresslist_item_bg);
                    return;
                }
            }
            return;
        }
        if (!b.a(singleLineCard.getBgColor())) {
            this.r.setBackgroundColor(singleLineCard.getBgColor());
            z = true;
        }
        if (z) {
        }
    }

    private void setMoreColor(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, cVar) == null) {
            if (cVar == null) {
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0302);
            } else {
                A(this.w, cVar.b(), cVar.c(), R.color.CAM_X0302);
            }
        }
    }

    private void setPrefixTitle(SingleLineCard singleLineCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, singleLineCard) == null) || singleLineCard == null) {
            return;
        }
        this.v.setVisibility(0);
        this.v.setText(singleLineCard.getIconTitle());
        this.v.setTextSize(0, getResources().getDisplayMetrics().density * (singleLineCard.getTextSize() / 2.0f));
        setPrefixTitleColor(singleLineCard);
    }

    private void setPrefixTitleColor(SingleLineCard singleLineCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, singleLineCard) == null) || singleLineCard == null) {
            return;
        }
        A(this.v, singleLineCard.getIconTitleColor(), singleLineCard.getIconTitleColorNight(), R.color.CAM_X0302);
    }

    private void setTitleColor(SingleLineCard singleLineCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, singleLineCard) == null) || singleLineCard == null) {
            return;
        }
        A(this.u, singleLineCard.getTitleColor(), singleLineCard.getTitleColorNight(), R.color.CAM_X0105);
    }

    public final String H(SingleLineCard singleLineCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, singleLineCard)) == null) ? t() ? singleLineCard.getIconUrlNight() : singleLineCard.getIconUrl() : (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: I */
    public void v(SingleLineCard singleLineCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, singleLineCard, i2) == null) {
            d.a.p0.u0.a.a(this.m, getRootView());
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0308);
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
    /* renamed from: J */
    public void w(SingleLineCard singleLineCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, singleLineCard) == null) {
            int g2 = l.g(getContext(), R.dimen.ds80);
            ViewGroup.LayoutParams layoutParams = this.r.getLayoutParams();
            if (singleLineCard.getMaxLines() > 1) {
                layoutParams.height = -2;
                this.r.setMinimumHeight(g2);
            } else if (singleLineCard.getHeight() > 0) {
                int e2 = l.e(getContext(), singleLineCard.getHeight());
                layoutParams.height = e2;
                this.r.setMinimumHeight(e2);
            } else {
                layoutParams.height = g2;
                this.r.setMinimumHeight(g2);
            }
            this.r.setLayoutParams(layoutParams);
            if (singleLineCard.isShowLeftIcon()) {
                this.t.setVisibility(0);
                if (!TextUtils.isEmpty(H(singleLineCard))) {
                    this.t.setImageDrawable(null);
                    this.t.M(H(singleLineCard), 10, false);
                } else if (!TextUtils.isEmpty(singleLineCard.getIconTitle())) {
                    this.t.setVisibility(8);
                    setPrefixTitle(singleLineCard);
                } else {
                    this.v.setVisibility(8);
                    SkinManager.setImageResource(this.t, f.a(singleLineCard.getIconType()));
                }
            } else {
                this.v.setVisibility(8);
                this.t.setVisibility(8);
            }
            if (singleLineCard.isShowLeftLine()) {
                this.s.setVisibility(0);
            } else {
                this.s.setVisibility(8);
            }
            setBgColor(singleLineCard);
            setTitleColor(singleLineCard);
            setMoreColor(singleLineCard.getButtonInfo());
            this.u.setTextSize(0, getResources().getDisplayMetrics().density * (singleLineCard.getTextSize() / 2.0f));
            if (singleLineCard.getMaxLines() > 1) {
                this.u.setSingleLine(false);
                this.u.setMaxLines(singleLineCard.getMaxLines());
            } else {
                this.u.setSingleLine(true);
            }
            this.u.setText(singleLineCard.getCardTitle());
            SpannableString m = m(singleLineCard.getCardTitle(), singleLineCard.getParams(), singleLineCard.getParamColor(), singleLineCard.getParamColorNight());
            if (m != null) {
                this.u.setText(m);
            }
            if (singleLineCard.getGravity() == 1) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.u.getLayoutParams();
                layoutParams2.weight = 0.0f;
                layoutParams2.width = -2;
                this.u.setLayoutParams(layoutParams2);
                this.r.setGravity(17);
            } else {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.u.getLayoutParams();
                layoutParams3.weight = 1.0f;
                layoutParams3.width = 0;
                this.u.setLayoutParams(layoutParams3);
                this.r.setGravity(0);
            }
            if (!TextUtils.isEmpty(singleLineCard.getScheme())) {
                setOnClickListener(new a(this, singleLineCard));
                this.x.setVisibility(0);
                SkinManager.setImageResource(this.x, R.drawable.icon_arrow_tab);
            } else {
                setOnClickListener(null);
                this.x.setVisibility(8);
            }
            c buttonInfo = singleLineCard.getButtonInfo();
            if (buttonInfo.f()) {
                this.w.setVisibility(0);
                this.x.setVisibility(8);
                this.w.setData(buttonInfo, this.m);
                return;
            }
            this.w.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_single_line, (ViewGroup) null);
            this.r = linearLayout;
            this.s = (View) n(linearLayout, R.id.leftLine);
            this.t = (TbImageView) n(this.r, R.id.leftIcon);
            this.u = (TextView) n(this.r, R.id.title);
            this.v = (TextView) n(this.r, R.id.title_prefix);
            this.w = (MoreButton) n(this.r, R.id.more);
            this.x = (ImageView) n(this.r, R.id.rightIcon);
            return this.r;
        }
        return (View) invokeV.objValue;
    }
}
