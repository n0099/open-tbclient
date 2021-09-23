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
import c.a.e.e.p.l;
import c.a.r0.j3.w;
import c.a.r0.p1.i;
import c.a.r0.p1.o.f;
import c.a.r0.p1.o.j.c;
import c.a.r0.p1.o.k.b;
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
@SuppressLint({"ViewConstructor"})
/* loaded from: classes7.dex */
public class SingleLineCardView extends BaseCardView<SingleLineCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f54058f;

    /* renamed from: g  reason: collision with root package name */
    public View f54059g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f54060h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f54061i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f54062j;
    public MoreButton k;
    public ImageView l;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SingleLineCard f54063e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SingleLineCardView f54064f;

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
            this.f54064f = singleLineCardView;
            this.f54063e = singleLineCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                i.e(this.f54063e).d(TiebaStatic.Params.OBJ_URL, this.f54063e.getScheme()).b("obj_locate", this.f54064f.getStatPosition()).a(this.f54063e);
                w.c(this.f54064f.mContext, this.f54063e.getScheme());
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
                this.f54058f.setBackgroundColor(singleLineCard.getBgColorNight());
                z = true;
            }
            if (z) {
                if (TextUtils.isEmpty(singleLineCard.getScheme())) {
                    SkinManager.setBackgroundColor(this.f54058f, R.color.CAM_X0201);
                    return;
                } else {
                    SkinManager.setBackgroundResource(this.f54058f, R.drawable.addresslist_item_bg);
                    return;
                }
            }
            return;
        }
        if (!b.a(singleLineCard.getBgColor())) {
            this.f54058f.setBackgroundColor(singleLineCard.getBgColor());
            z = true;
        }
        if (z) {
        }
    }

    private void setMoreColor(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, cVar) == null) {
            if (cVar == null) {
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0302);
            } else {
                setTextColor(this.k, cVar.b(), cVar.c(), R.color.CAM_X0302);
            }
        }
    }

    private void setPrefixTitle(SingleLineCard singleLineCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, singleLineCard) == null) || singleLineCard == null) {
            return;
        }
        this.f54062j.setVisibility(0);
        this.f54062j.setText(singleLineCard.getIconTitle());
        this.f54062j.setTextSize(0, getResources().getDisplayMetrics().density * (singleLineCard.getTextSize() / 2.0f));
        setPrefixTitleColor(singleLineCard);
    }

    private void setPrefixTitleColor(SingleLineCard singleLineCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, singleLineCard) == null) || singleLineCard == null) {
            return;
        }
        setTextColor(this.f54062j, singleLineCard.getIconTitleColor(), singleLineCard.getIconTitleColorNight(), R.color.CAM_X0302);
    }

    private void setTitleColor(SingleLineCard singleLineCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, singleLineCard) == null) || singleLineCard == null) {
            return;
        }
        setTextColor(this.f54061i, singleLineCard.getTitleColor(), singleLineCard.getTitleColorNight(), R.color.CAM_X0105);
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
            this.f54058f = linearLayout;
            this.f54059g = (View) findViewById(linearLayout, R.id.leftLine);
            this.f54060h = (TbImageView) findViewById(this.f54058f, R.id.leftIcon);
            this.f54061i = (TextView) findViewById(this.f54058f, R.id.title);
            this.f54062j = (TextView) findViewById(this.f54058f, R.id.title_prefix);
            this.k = (MoreButton) findViewById(this.f54058f, R.id.more);
            this.l = (ImageView) findViewById(this.f54058f, R.id.rightIcon);
            return this.f54058f;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onChangeSkinType(SingleLineCard singleLineCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, singleLineCard, i2) == null) {
            c.a.q0.w0.a.a(this.mContext, getRootView());
            SkinManager.setBackgroundColor(this.f54059g, R.color.CAM_X0308);
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
            int g2 = l.g(getContext(), R.dimen.ds80);
            ViewGroup.LayoutParams layoutParams = this.f54058f.getLayoutParams();
            if (singleLineCard.getMaxLines() > 1) {
                layoutParams.height = -2;
                this.f54058f.setMinimumHeight(g2);
            } else if (singleLineCard.getHeight() > 0) {
                int e2 = l.e(getContext(), singleLineCard.getHeight());
                layoutParams.height = e2;
                this.f54058f.setMinimumHeight(e2);
            } else {
                layoutParams.height = g2;
                this.f54058f.setMinimumHeight(g2);
            }
            this.f54058f.setLayoutParams(layoutParams);
            if (singleLineCard.isShowLeftIcon()) {
                this.f54060h.setVisibility(0);
                if (!TextUtils.isEmpty(c(singleLineCard))) {
                    this.f54060h.setImageDrawable(null);
                    this.f54060h.startLoad(c(singleLineCard), 10, false);
                } else if (!TextUtils.isEmpty(singleLineCard.getIconTitle())) {
                    this.f54060h.setVisibility(8);
                    setPrefixTitle(singleLineCard);
                } else {
                    this.f54062j.setVisibility(8);
                    SkinManager.setImageResource(this.f54060h, f.a(singleLineCard.getIconType()));
                }
            } else {
                this.f54062j.setVisibility(8);
                this.f54060h.setVisibility(8);
            }
            if (singleLineCard.isShowLeftLine()) {
                this.f54059g.setVisibility(0);
            } else {
                this.f54059g.setVisibility(8);
            }
            setBgColor(singleLineCard);
            setTitleColor(singleLineCard);
            setMoreColor(singleLineCard.getButtonInfo());
            this.f54061i.setTextSize(0, getResources().getDisplayMetrics().density * (singleLineCard.getTextSize() / 2.0f));
            if (singleLineCard.getMaxLines() > 1) {
                this.f54061i.setSingleLine(false);
                this.f54061i.setMaxLines(singleLineCard.getMaxLines());
            } else {
                this.f54061i.setSingleLine(true);
            }
            this.f54061i.setText(singleLineCard.getCardTitle());
            SpannableString changeParamsColor = changeParamsColor(singleLineCard.getCardTitle(), singleLineCard.getParams(), singleLineCard.getParamColor(), singleLineCard.getParamColorNight());
            if (changeParamsColor != null) {
                this.f54061i.setText(changeParamsColor);
            }
            if (singleLineCard.getGravity() == 1) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f54061i.getLayoutParams();
                layoutParams2.weight = 0.0f;
                layoutParams2.width = -2;
                this.f54061i.setLayoutParams(layoutParams2);
                this.f54058f.setGravity(17);
            } else {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f54061i.getLayoutParams();
                layoutParams3.weight = 1.0f;
                layoutParams3.width = 0;
                this.f54061i.setLayoutParams(layoutParams3);
                this.f54058f.setGravity(0);
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
                this.k.setVisibility(0);
                this.l.setVisibility(8);
                this.k.setData(buttonInfo, this.mContext);
                return;
            }
            this.k.setVisibility(8);
        }
    }
}
