package com.baidu.tieba.lego.card.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
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
/* loaded from: classes6.dex */
public class LPBigImgCardView extends BaseCardView<LPBigImgCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout m;
    public TbImageView n;
    public TbImageView o;
    public TextView p;
    public int q;
    public final int r;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: E */
    public void u(LPBigImgCard lPBigImgCard, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lPBigImgCard, i) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LPBigImgCard a;
        public final /* synthetic */ LPBigImgCardView b;

        public a(LPBigImgCardView lPBigImgCardView, LPBigImgCard lPBigImgCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lPBigImgCardView, lPBigImgCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lPBigImgCardView;
            this.a = lPBigImgCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                UrlManager.getInstance().dealOneLink(this.b.i, new String[]{this.a.getBtnLink()});
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LPBigImgCard a;
        public final /* synthetic */ LPBigImgCardView b;

        public b(LPBigImgCardView lPBigImgCardView, LPBigImgCard lPBigImgCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lPBigImgCardView, lPBigImgCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lPBigImgCardView;
            this.a = lPBigImgCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                UrlManager.getInstance().dealOneLink(this.b.i, new String[]{this.a.getBtnLink()});
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = BdUtilHelper.getEquipmentWidth(getContext());
    }

    public final int D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return BdUtilHelper.dip2px(this.i.getPageActivity(), (int) (i / 2.0d));
        }
        return invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: F */
    public void v(LPBigImgCard lPBigImgCard) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lPBigImgCard) == null) && lPBigImgCard.getPicWidth() > 0 && lPBigImgCard.getPicHeight() > 0) {
            int picHeight = (int) ((lPBigImgCard.getPicHeight() / lPBigImgCard.getPicWidth()) * this.r);
            this.q = picHeight;
            G(this.n, picHeight);
            if (!TextUtils.isEmpty(lPBigImgCard.getPicUrl())) {
                this.n.startLoad(lPBigImgCard.getPicUrl(), 17, this.r, this.q, false);
            } else {
                y(this.n, lPBigImgCard.getBgColor(), lPBigImgCard.getBgColorNight(), R.color.CAM_X0201);
            }
            int i = this.q;
            if (!TextUtils.isEmpty(lPBigImgCard.getBtnImgUrl()) && lPBigImgCard.getBtnWidth() > 0 && lPBigImgCard.getBtnHeight() > 0) {
                int btnHeight = lPBigImgCard.getBtnHeight();
                H(this.o, lPBigImgCard.getBtnWidth(), lPBigImgCard.getBtnHeight());
                this.o.startLoad(lPBigImgCard.getBtnImgUrl(), 17, false);
                int btnPosRatio = (int) ((i * lPBigImgCard.getBtnPosRatio()) - (btnHeight * 0.5d));
                if (btnPosRatio < 0) {
                    btnPosRatio = 0;
                } else {
                    int i2 = i - btnHeight;
                    if (btnPosRatio > i2) {
                        btnPosRatio = i2;
                    }
                }
                ((RelativeLayout.LayoutParams) this.o.getLayoutParams()).topMargin = btnPosRatio;
                this.o.setOnClickListener(new a(this, lPBigImgCard));
                this.o.setVisibility(0);
                this.p.setVisibility(8);
            } else if (!TextUtils.isEmpty(lPBigImgCard.getBtnText()) && lPBigImgCard.getBtnWidth() > 0 && lPBigImgCard.getBtnHeight() > 0) {
                int btnHeight2 = lPBigImgCard.getBtnHeight();
                this.p.setText(lPBigImgCard.getBtnText());
                H(this.p, lPBigImgCard.getBtnWidth(), lPBigImgCard.getBtnHeight());
                z(this.p, lPBigImgCard.getBtnColor(), lPBigImgCard.getBtnColorNight(), R.color.black_alpha100);
                int btnPosRatio2 = (int) ((i * lPBigImgCard.getBtnPosRatio()) - (btnHeight2 * 0.5d));
                if (btnPosRatio2 < 0) {
                    btnPosRatio2 = 0;
                } else {
                    int i3 = i - btnHeight2;
                    if (btnPosRatio2 > i3) {
                        btnPosRatio2 = i3;
                    }
                }
                ((RelativeLayout.LayoutParams) this.p.getLayoutParams()).topMargin = btnPosRatio2;
                this.p.setOnClickListener(new b(this, lPBigImgCard));
                this.p.setVisibility(0);
                this.o.setVisibility(8);
            } else {
                this.p.setVisibility(8);
                this.o.setVisibility(8);
            }
            if (!lPBigImgCard.mHasShown) {
                lPBigImgCard.mHasShown = true;
            }
        }
    }

    public final void G(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, view2, i) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
            layoutParams.width = this.r;
            layoutParams.height = i;
            view2.setLayoutParams(layoutParams);
        }
    }

    public final void H(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, view2, i, i2) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
            layoutParams.height = D(i2);
            layoutParams.width = D(i);
            view2.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d019f, (ViewGroup) null);
            this.m = relativeLayout;
            this.n = (TbImageView) m(relativeLayout, R.id.obfuscated_res_0x7f09242e);
            this.o = (TbImageView) m(this.m, R.id.obfuscated_res_0x7f09242f);
            this.p = (TextView) m(this.m, R.id.obfuscated_res_0x7f0926d3);
            return this.m;
        }
        return (View) invokeV.objValue;
    }
}
