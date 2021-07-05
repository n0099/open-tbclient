package com.baidu.tieba.lego.card.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.LPBigImgCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.s0.w2.w;
/* loaded from: classes5.dex */
public class LPBigImgCardView extends BaseCardView<LPBigImgCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout r;
    public TbImageView s;
    public TbImageView t;
    public TextView u;
    public int v;
    public final int w;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LPBigImgCard f18208e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LPBigImgCardView f18209f;

        public a(LPBigImgCardView lPBigImgCardView, LPBigImgCard lPBigImgCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lPBigImgCardView, lPBigImgCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18209f = lPBigImgCardView;
            this.f18208e = lPBigImgCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f18209f.m, new String[]{this.f18208e.getBtnLink()});
                w.p().m().c(this.f18208e.getsExtras(), this.f18209f.f18190e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LPBigImgCard f18210e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LPBigImgCardView f18211f;

        public b(LPBigImgCardView lPBigImgCardView, LPBigImgCard lPBigImgCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lPBigImgCardView, lPBigImgCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18211f = lPBigImgCardView;
            this.f18210e = lPBigImgCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f18211f.m, new String[]{this.f18210e.getBtnLink()});
                w.p().m().c(this.f18210e.getsExtras(), this.f18211f.f18190e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LPBigImgCardView(TbPageContext tbPageContext) {
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
        this.w = l.k(getContext());
    }

    public final int H(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? l.e(this.m.getPageActivity(), (int) (i2 / 2.0d)) : invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: I */
    public void v(LPBigImgCard lPBigImgCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lPBigImgCard, i2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: J */
    public void w(LPBigImgCard lPBigImgCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lPBigImgCard) == null) || lPBigImgCard.getPicWidth() <= 0 || lPBigImgCard.getPicHeight() <= 0) {
            return;
        }
        int picHeight = (int) ((lPBigImgCard.getPicHeight() / lPBigImgCard.getPicWidth()) * this.w);
        this.v = picHeight;
        K(this.s, picHeight);
        if (!TextUtils.isEmpty(lPBigImgCard.getPicUrl())) {
            this.s.J(lPBigImgCard.getPicUrl(), 17, this.w, this.v, false);
        } else {
            z(this.s, lPBigImgCard.getBgColor(), lPBigImgCard.getBgColorNight(), R.color.CAM_X0201);
        }
        int i2 = this.v;
        if (!TextUtils.isEmpty(lPBigImgCard.getBtnImgUrl()) && lPBigImgCard.getBtnWidth() > 0 && lPBigImgCard.getBtnHeight() > 0) {
            int btnHeight = lPBigImgCard.getBtnHeight();
            L(this.t, lPBigImgCard.getBtnWidth(), lPBigImgCard.getBtnHeight());
            this.t.M(lPBigImgCard.getBtnImgUrl(), 17, false);
            int btnPosRatio = (int) ((i2 * lPBigImgCard.getBtnPosRatio()) - (btnHeight * 0.5d));
            if (btnPosRatio < 0) {
                btnPosRatio = 0;
            } else {
                int i3 = i2 - btnHeight;
                if (btnPosRatio > i3) {
                    btnPosRatio = i3;
                }
            }
            ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = btnPosRatio;
            this.t.setOnClickListener(new a(this, lPBigImgCard));
            this.t.setVisibility(0);
            this.u.setVisibility(8);
        } else if (!TextUtils.isEmpty(lPBigImgCard.getBtnText()) && lPBigImgCard.getBtnWidth() > 0 && lPBigImgCard.getBtnHeight() > 0) {
            int btnHeight2 = lPBigImgCard.getBtnHeight();
            this.u.setText(lPBigImgCard.getBtnText());
            L(this.u, lPBigImgCard.getBtnWidth(), lPBigImgCard.getBtnHeight());
            A(this.u, lPBigImgCard.getBtnColor(), lPBigImgCard.getBtnColorNight(), R.color.black_alpha100);
            int btnPosRatio2 = (int) ((i2 * lPBigImgCard.getBtnPosRatio()) - (btnHeight2 * 0.5d));
            if (btnPosRatio2 < 0) {
                btnPosRatio2 = 0;
            } else {
                int i4 = i2 - btnHeight2;
                if (btnPosRatio2 > i4) {
                    btnPosRatio2 = i4;
                }
            }
            ((RelativeLayout.LayoutParams) this.u.getLayoutParams()).topMargin = btnPosRatio2;
            this.u.setOnClickListener(new b(this, lPBigImgCard));
            this.u.setVisibility(0);
            this.t.setVisibility(8);
        } else {
            this.u.setVisibility(8);
            this.t.setVisibility(8);
        }
        if (lPBigImgCard.mHasShown) {
            return;
        }
        w.p().m().d(lPBigImgCard.getShowExtra(), this.f18190e);
        lPBigImgCard.mHasShown = true;
    }

    public final void K(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, view, i2) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = this.w;
            layoutParams.height = i2;
            view.setLayoutParams(layoutParams);
        }
    }

    public final void L(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, view, i2, i3) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.height = H(i3);
            layoutParams.width = H(i2);
            view.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_bigimg, (ViewGroup) null);
            this.r = relativeLayout;
            this.s = (TbImageView) n(relativeLayout, R.id.tb_img_background);
            this.t = (TbImageView) n(this.r, R.id.tb_img_button);
            this.u = (TextView) n(this.r, R.id.tv_button);
            return this.r;
        }
        return (View) invokeV.objValue;
    }
}
