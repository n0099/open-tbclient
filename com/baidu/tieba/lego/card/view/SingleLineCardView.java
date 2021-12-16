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
import c.a.d.f.p.m;
import c.a.s0.v3.w;
import c.a.s0.x1.i;
import c.a.s0.x1.o.f;
import c.a.s0.x1.o.j.c;
import c.a.s0.x1.o.k.b;
import com.baidu.android.imsdk.internal.Constants;
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
@SuppressLint({"ViewConstructor"})
/* loaded from: classes12.dex */
public class SingleLineCardView extends BaseCardView<SingleLineCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f47165f;

    /* renamed from: g  reason: collision with root package name */
    public View f47166g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f47167h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f47168i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f47169j;

    /* renamed from: k  reason: collision with root package name */
    public MoreButton f47170k;
    public ImageView l;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SingleLineCard f47171e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SingleLineCardView f47172f;

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
            this.f47172f = singleLineCardView;
            this.f47171e = singleLineCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                i.e(this.f47171e).d(TiebaStatic.Params.OBJ_URL, this.f47171e.getScheme()).b("obj_locate", this.f47172f.getStatPosition()).a(this.f47171e);
                w.c(this.f47172f.mContext, this.f47171e.getScheme());
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
        if (isNightMode()) {
            if (!b.a(singleLineCard.getBgColorNight())) {
                this.f47165f.setBackgroundColor(singleLineCard.getBgColorNight());
                z = true;
            }
            if (z) {
                if (TextUtils.isEmpty(singleLineCard.getScheme())) {
                    SkinManager.setBackgroundColor(this.f47165f, R.color.CAM_X0201);
                    return;
                } else {
                    SkinManager.setBackgroundResource(this.f47165f, R.drawable.addresslist_item_bg);
                    return;
                }
            }
            return;
        }
        if (!b.a(singleLineCard.getBgColor())) {
            this.f47165f.setBackgroundColor(singleLineCard.getBgColor());
            z = true;
        }
        if (z) {
        }
    }

    private void setMoreColor(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, cVar) == null) {
            if (cVar == null) {
                SkinManager.setViewTextColor(this.f47170k, R.color.CAM_X0302);
            } else {
                setTextColor(this.f47170k, cVar.b(), cVar.c(), R.color.CAM_X0302);
            }
        }
    }

    private void setPrefixTitle(SingleLineCard singleLineCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, singleLineCard) == null) || singleLineCard == null) {
            return;
        }
        this.f47169j.setVisibility(0);
        this.f47169j.setText(singleLineCard.getIconTitle());
        this.f47169j.setTextSize(0, getResources().getDisplayMetrics().density * (singleLineCard.getTextSize() / 2.0f));
        setPrefixTitleColor(singleLineCard);
    }

    private void setPrefixTitleColor(SingleLineCard singleLineCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, singleLineCard) == null) || singleLineCard == null) {
            return;
        }
        setTextColor(this.f47169j, singleLineCard.getIconTitleColor(), singleLineCard.getIconTitleColorNight(), R.color.CAM_X0302);
    }

    private void setTitleColor(SingleLineCard singleLineCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, this, singleLineCard) == null) || singleLineCard == null) {
            return;
        }
        setTextColor(this.f47168i, singleLineCard.getTitleColor(), singleLineCard.getTitleColorNight(), R.color.CAM_X0105);
    }

    public final String c(SingleLineCard singleLineCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, singleLineCard)) == null) ? isNightMode() ? singleLineCard.getIconUrlNight() : singleLineCard.getIconUrl() : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View initLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_single_line, (ViewGroup) null);
            this.f47165f = linearLayout;
            this.f47166g = (View) findViewById(linearLayout, R.id.leftLine);
            this.f47167h = (TbImageView) findViewById(this.f47165f, R.id.leftIcon);
            this.f47168i = (TextView) findViewById(this.f47165f, R.id.title);
            this.f47169j = (TextView) findViewById(this.f47165f, R.id.title_prefix);
            this.f47170k = (MoreButton) findViewById(this.f47165f, R.id.more);
            this.l = (ImageView) findViewById(this.f47165f, R.id.rightIcon);
            return this.f47165f;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onChangeSkinType(SingleLineCard singleLineCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, singleLineCard, i2) == null) {
            c.a.r0.w0.a.a(this.mContext, getRootView());
            SkinManager.setBackgroundColor(this.f47166g, R.color.CAM_X0308);
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
    public void onUpdateCardView(SingleLineCard singleLineCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, singleLineCard) == null) {
            int f2 = m.f(getContext(), R.dimen.ds80);
            ViewGroup.LayoutParams layoutParams = this.f47165f.getLayoutParams();
            if (singleLineCard.getMaxLines() > 1) {
                layoutParams.height = -2;
                this.f47165f.setMinimumHeight(f2);
            } else if (singleLineCard.getHeight() > 0) {
                int d2 = m.d(getContext(), singleLineCard.getHeight());
                layoutParams.height = d2;
                this.f47165f.setMinimumHeight(d2);
            } else {
                layoutParams.height = f2;
                this.f47165f.setMinimumHeight(f2);
            }
            this.f47165f.setLayoutParams(layoutParams);
            if (singleLineCard.isShowLeftIcon()) {
                this.f47167h.setVisibility(0);
                if (!TextUtils.isEmpty(c(singleLineCard))) {
                    this.f47167h.setImageDrawable(null);
                    this.f47167h.startLoad(c(singleLineCard), 10, false);
                } else if (!TextUtils.isEmpty(singleLineCard.getIconTitle())) {
                    this.f47167h.setVisibility(8);
                    setPrefixTitle(singleLineCard);
                } else {
                    this.f47169j.setVisibility(8);
                    SkinManager.setImageResource(this.f47167h, f.a(singleLineCard.getIconType()));
                }
            } else {
                this.f47169j.setVisibility(8);
                this.f47167h.setVisibility(8);
            }
            if (singleLineCard.isShowLeftLine()) {
                this.f47166g.setVisibility(0);
            } else {
                this.f47166g.setVisibility(8);
            }
            setBgColor(singleLineCard);
            setTitleColor(singleLineCard);
            setMoreColor(singleLineCard.getButtonInfo());
            this.f47168i.setTextSize(0, getResources().getDisplayMetrics().density * (singleLineCard.getTextSize() / 2.0f));
            if (singleLineCard.getMaxLines() > 1) {
                this.f47168i.setSingleLine(false);
                this.f47168i.setMaxLines(singleLineCard.getMaxLines());
            } else {
                this.f47168i.setSingleLine(true);
            }
            this.f47168i.setText(singleLineCard.getCardTitle());
            SpannableString changeParamsColor = changeParamsColor(singleLineCard.getCardTitle(), singleLineCard.getParams(), singleLineCard.getParamColor(), singleLineCard.getParamColorNight());
            if (changeParamsColor != null) {
                this.f47168i.setText(changeParamsColor);
            }
            if (singleLineCard.getGravity() == 1) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f47168i.getLayoutParams();
                layoutParams2.weight = 0.0f;
                layoutParams2.width = -2;
                this.f47168i.setLayoutParams(layoutParams2);
                this.f47165f.setGravity(17);
            } else {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f47168i.getLayoutParams();
                layoutParams3.weight = 1.0f;
                layoutParams3.width = 0;
                this.f47168i.setLayoutParams(layoutParams3);
                this.f47165f.setGravity(0);
            }
            if (!TextUtils.isEmpty(singleLineCard.getScheme())) {
                setOnClickListener(new a(this, singleLineCard));
                this.l.setVisibility(0);
                SkinManager.setImageResource(this.l, R.drawable.icon_arrow_tab);
            } else {
                setOnClickListener(null);
                this.l.setVisibility(8);
            }
            c buttonInfo = singleLineCard.getButtonInfo();
            if (buttonInfo.f()) {
                this.f47170k.setVisibility(0);
                this.l.setVisibility(8);
                this.f47170k.setData(buttonInfo, this.mContext);
                return;
            }
            this.f47170k.setVisibility(8);
        }
    }
}
