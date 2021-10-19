package com.baidu.tieba.lego.card.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.r0.z2.y;
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
/* loaded from: classes7.dex */
public class LPBigImgCardView extends BaseCardView<LPBigImgCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f53927f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f53928g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f53929h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f53930i;

    /* renamed from: j  reason: collision with root package name */
    public int f53931j;
    public final int k;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LPBigImgCard f53932e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LPBigImgCardView f53933f;

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
            this.f53933f = lPBigImgCardView;
            this.f53932e = lPBigImgCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f53933f.mContext, new String[]{this.f53932e.getBtnLink()});
                y.o().l().c(this.f53932e.getsExtras(), this.f53933f.mFrom);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LPBigImgCard f53934e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LPBigImgCardView f53935f;

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
            this.f53935f = lPBigImgCardView;
            this.f53934e = lPBigImgCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f53935f.mContext, new String[]{this.f53934e.getBtnLink()});
                y.o().l().c(this.f53934e.getsExtras(), this.f53935f.mFrom);
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
        this.k = l.k(getContext());
    }

    public final int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? l.e(this.mContext.getPageActivity(), (int) (i2 / 2.0d)) : invokeI.intValue;
    }

    public final void d(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = this.k;
            layoutParams.height = i2;
            view.setLayoutParams(layoutParams);
        }
    }

    public final void e(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, view, i2, i3) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.height = c(i3);
            layoutParams.width = c(i2);
            view.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View initLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_bigimg, (ViewGroup) null);
            this.f53927f = relativeLayout;
            this.f53928g = (TbImageView) findViewById(relativeLayout, R.id.tb_img_background);
            this.f53929h = (TbImageView) findViewById(this.f53927f, R.id.tb_img_button);
            this.f53930i = (TextView) findViewById(this.f53927f, R.id.tv_button);
            return this.f53927f;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onChangeSkinType(LPBigImgCard lPBigImgCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, lPBigImgCard, i2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onUpdateCardView(LPBigImgCard lPBigImgCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lPBigImgCard) == null) || lPBigImgCard.getPicWidth() <= 0 || lPBigImgCard.getPicHeight() <= 0) {
            return;
        }
        int picHeight = (int) ((lPBigImgCard.getPicHeight() / lPBigImgCard.getPicWidth()) * this.k);
        this.f53931j = picHeight;
        d(this.f53928g, picHeight);
        if (!TextUtils.isEmpty(lPBigImgCard.getPicUrl())) {
            this.f53928g.startLoad(lPBigImgCard.getPicUrl(), 17, this.k, this.f53931j, false);
        } else {
            setBackgroundColor(this.f53928g, lPBigImgCard.getBgColor(), lPBigImgCard.getBgColorNight(), R.color.CAM_X0201);
        }
        int i2 = this.f53931j;
        if (!TextUtils.isEmpty(lPBigImgCard.getBtnImgUrl()) && lPBigImgCard.getBtnWidth() > 0 && lPBigImgCard.getBtnHeight() > 0) {
            int btnHeight = lPBigImgCard.getBtnHeight();
            e(this.f53929h, lPBigImgCard.getBtnWidth(), lPBigImgCard.getBtnHeight());
            this.f53929h.startLoad(lPBigImgCard.getBtnImgUrl(), 17, false);
            int btnPosRatio = (int) ((i2 * lPBigImgCard.getBtnPosRatio()) - (btnHeight * 0.5d));
            if (btnPosRatio < 0) {
                btnPosRatio = 0;
            } else {
                int i3 = i2 - btnHeight;
                if (btnPosRatio > i3) {
                    btnPosRatio = i3;
                }
            }
            ((RelativeLayout.LayoutParams) this.f53929h.getLayoutParams()).topMargin = btnPosRatio;
            this.f53929h.setOnClickListener(new a(this, lPBigImgCard));
            this.f53929h.setVisibility(0);
            this.f53930i.setVisibility(8);
        } else if (!TextUtils.isEmpty(lPBigImgCard.getBtnText()) && lPBigImgCard.getBtnWidth() > 0 && lPBigImgCard.getBtnHeight() > 0) {
            int btnHeight2 = lPBigImgCard.getBtnHeight();
            this.f53930i.setText(lPBigImgCard.getBtnText());
            e(this.f53930i, lPBigImgCard.getBtnWidth(), lPBigImgCard.getBtnHeight());
            setTextColor(this.f53930i, lPBigImgCard.getBtnColor(), lPBigImgCard.getBtnColorNight(), R.color.black_alpha100);
            int btnPosRatio2 = (int) ((i2 * lPBigImgCard.getBtnPosRatio()) - (btnHeight2 * 0.5d));
            if (btnPosRatio2 < 0) {
                btnPosRatio2 = 0;
            } else {
                int i4 = i2 - btnHeight2;
                if (btnPosRatio2 > i4) {
                    btnPosRatio2 = i4;
                }
            }
            ((RelativeLayout.LayoutParams) this.f53930i.getLayoutParams()).topMargin = btnPosRatio2;
            this.f53930i.setOnClickListener(new b(this, lPBigImgCard));
            this.f53930i.setVisibility(0);
            this.f53929h.setVisibility(8);
        } else {
            this.f53930i.setVisibility(8);
            this.f53929h.setVisibility(8);
        }
        if (lPBigImgCard.mHasShown) {
            return;
        }
        y.o().l().d(lPBigImgCard.getShowExtra(), this.mFrom);
        lPBigImgCard.mHasShown = true;
    }
}
