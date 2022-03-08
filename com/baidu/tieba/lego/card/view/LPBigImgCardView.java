package com.baidu.tieba.lego.card.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.r0.j3.z;
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
/* loaded from: classes5.dex */
public class LPBigImgCardView extends BaseCardView<LPBigImgCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f44147f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f44148g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f44149h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f44150i;

    /* renamed from: j  reason: collision with root package name */
    public int f44151j;
    public final int k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LPBigImgCard f44152e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LPBigImgCardView f44153f;

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
            this.f44153f = lPBigImgCardView;
            this.f44152e = lPBigImgCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f44153f.mContext, new String[]{this.f44152e.getBtnLink()});
                z.q().l().c(this.f44152e.getsExtras(), this.f44153f.mFrom);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LPBigImgCard f44154e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LPBigImgCardView f44155f;

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
            this.f44155f = lPBigImgCardView;
            this.f44154e = lPBigImgCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f44155f.mContext, new String[]{this.f44154e.getBtnLink()});
                z.q().l().c(this.f44154e.getsExtras(), this.f44155f.mFrom);
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
        this.k = n.k(getContext());
    }

    public final int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? n.d(this.mContext.getPageActivity(), (int) (i2 / 2.0d)) : invokeI.intValue;
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
            this.f44147f = relativeLayout;
            this.f44148g = (TbImageView) findViewById(relativeLayout, R.id.tb_img_background);
            this.f44149h = (TbImageView) findViewById(this.f44147f, R.id.tb_img_button);
            this.f44150i = (TextView) findViewById(this.f44147f, R.id.tv_button);
            return this.f44147f;
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
        this.f44151j = picHeight;
        d(this.f44148g, picHeight);
        if (!TextUtils.isEmpty(lPBigImgCard.getPicUrl())) {
            this.f44148g.startLoad(lPBigImgCard.getPicUrl(), 17, this.k, this.f44151j, false);
        } else {
            setBackgroundColor(this.f44148g, lPBigImgCard.getBgColor(), lPBigImgCard.getBgColorNight(), R.color.CAM_X0201);
        }
        int i2 = this.f44151j;
        if (!TextUtils.isEmpty(lPBigImgCard.getBtnImgUrl()) && lPBigImgCard.getBtnWidth() > 0 && lPBigImgCard.getBtnHeight() > 0) {
            int btnHeight = lPBigImgCard.getBtnHeight();
            e(this.f44149h, lPBigImgCard.getBtnWidth(), lPBigImgCard.getBtnHeight());
            this.f44149h.startLoad(lPBigImgCard.getBtnImgUrl(), 17, false);
            int btnPosRatio = (int) ((i2 * lPBigImgCard.getBtnPosRatio()) - (btnHeight * 0.5d));
            if (btnPosRatio < 0) {
                btnPosRatio = 0;
            } else {
                int i3 = i2 - btnHeight;
                if (btnPosRatio > i3) {
                    btnPosRatio = i3;
                }
            }
            ((RelativeLayout.LayoutParams) this.f44149h.getLayoutParams()).topMargin = btnPosRatio;
            this.f44149h.setOnClickListener(new a(this, lPBigImgCard));
            this.f44149h.setVisibility(0);
            this.f44150i.setVisibility(8);
        } else if (!TextUtils.isEmpty(lPBigImgCard.getBtnText()) && lPBigImgCard.getBtnWidth() > 0 && lPBigImgCard.getBtnHeight() > 0) {
            int btnHeight2 = lPBigImgCard.getBtnHeight();
            this.f44150i.setText(lPBigImgCard.getBtnText());
            e(this.f44150i, lPBigImgCard.getBtnWidth(), lPBigImgCard.getBtnHeight());
            setTextColor(this.f44150i, lPBigImgCard.getBtnColor(), lPBigImgCard.getBtnColorNight(), R.color.black_alpha100);
            int btnPosRatio2 = (int) ((i2 * lPBigImgCard.getBtnPosRatio()) - (btnHeight2 * 0.5d));
            if (btnPosRatio2 < 0) {
                btnPosRatio2 = 0;
            } else {
                int i4 = i2 - btnHeight2;
                if (btnPosRatio2 > i4) {
                    btnPosRatio2 = i4;
                }
            }
            ((RelativeLayout.LayoutParams) this.f44150i.getLayoutParams()).topMargin = btnPosRatio2;
            this.f44150i.setOnClickListener(new b(this, lPBigImgCard));
            this.f44150i.setVisibility(0);
            this.f44149h.setVisibility(8);
        } else {
            this.f44150i.setVisibility(8);
            this.f44149h.setVisibility(8);
        }
        if (lPBigImgCard.mHasShown) {
            return;
        }
        z.q().l().d(lPBigImgCard.getShowExtra(), this.mFrom);
        lPBigImgCard.mHasShown = true;
    }
}
