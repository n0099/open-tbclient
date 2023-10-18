package com.baidu.tieba.lego.card.view;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.bz8;
import com.baidu.tieba.co5;
import com.baidu.tieba.cz8;
import com.baidu.tieba.dy8;
import com.baidu.tieba.e09;
import com.baidu.tieba.e65;
import com.baidu.tieba.g65;
import com.baidu.tieba.hy8;
import com.baidu.tieba.lego.card.model.PlayPicInfoCard;
import com.baidu.tieba.lego.view.BannerFlowView;
import com.baidu.tieba.lego.view.CommonImageButton;
import com.baidu.tieba.my8;
import com.baidu.tieba.pda;
import com.baidu.tieba.tj6;
import com.baidu.tieba.vy8;
import com.baidu.tieba.yh;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes7.dex */
public class PlayPicInfoCardView extends BaseCardView<PlayPicInfoCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BannerFlowView m;
    public View n;
    public TextView o;
    public LinearLayout p;
    public TextView q;
    public TextView r;
    public IndicatorView s;
    public TbImageView t;
    public RelativeLayout u;
    public TextView v;
    public TbImageView w;
    public TextView x;
    public CommonImageButton y;

    /* loaded from: classes7.dex */
    public class a implements e65.a<g65, e09.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PlayPicInfoCard a;
        public final /* synthetic */ PlayPicInfoCardView b;

        public a(PlayPicInfoCardView playPicInfoCardView, PlayPicInfoCard playPicInfoCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playPicInfoCardView, playPicInfoCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = playPicInfoCardView;
            this.a = playPicInfoCard;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.e65.a
        /* renamed from: b */
        public void a(e09.a aVar, g65 g65Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, g65Var) == null) && (g65Var.b() instanceof PlayPicInfoCard.b)) {
                PlayPicInfoCard.b bVar = (PlayPicInfoCard.b) g65Var.b();
                if (TextUtils.isEmpty(bVar.c)) {
                    return;
                }
                tj6.b().d(true);
                dy8 f = hy8.f(bVar.i, bVar.g, this.a.getCardType(), this.a.getItemId());
                f.d("obj_id", bVar.a);
                f.d(TiebaStatic.Params.OBJ_URL, bVar.c);
                f.b("obj_locate", this.b.getStatPosition());
                f.a(this.a);
                pda.c(this.b.i, bVar.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BannerFlowView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PlayPicInfoCard a;
        public final /* synthetic */ PlayPicInfoCardView b;

        public b(PlayPicInfoCardView playPicInfoCardView, PlayPicInfoCard playPicInfoCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playPicInfoCardView, playPicInfoCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = playPicInfoCardView;
            this.a = playPicInfoCard;
        }

        @Override // com.baidu.tieba.nz8
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.a.getDescOnPic() == 1) {
                return;
            }
            this.b.s.setCount(i);
        }

        @Override // com.baidu.tieba.nz8
        public void b(float f) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) != null) || this.a.getDescOnPic() == 1) {
                return;
            }
            this.b.s.setPosition(f);
        }

        @Override // com.baidu.tieba.lego.view.BannerFlowView.c
        public void onPageSelected(int i) {
            List<PlayPicInfoCard.b> imageResList;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (imageResList = this.a.getImageResList()) != null && imageResList.size() > i) {
                if (this.a.getDescOnPic() == 1) {
                    if (!TextUtils.isEmpty(imageResList.get(i).d)) {
                        this.b.r.setText(imageResList.get(i).d);
                        this.b.I(imageResList.get(i));
                        this.b.r.setVisibility(0);
                    } else {
                        this.b.r.setVisibility(8);
                    }
                    BannerFlowView bannerFlowView = this.b.m;
                    if (bannerFlowView != null) {
                        bannerFlowView.setDescOnPic(true, !TextUtils.isEmpty(imageResList.get(i).d));
                        return;
                    }
                    return;
                }
                this.b.r.setVisibility(8);
                if (!TextUtils.isEmpty(imageResList.get(i).d)) {
                    this.b.q.setText(imageResList.get(i).d);
                } else {
                    this.b.p.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PlayPicInfoCard a;
        public final /* synthetic */ PlayPicInfoCardView b;

        public c(PlayPicInfoCardView playPicInfoCardView, PlayPicInfoCard playPicInfoCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playPicInfoCardView, playPicInfoCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = playPicInfoCardView;
            this.a = playPicInfoCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.getImageResList().get(0) != null) {
                pda.c(this.b.i, this.a.getImageResList().get(0).c);
                tj6.b().d(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PlayPicInfoCard.a a;
        public final /* synthetic */ PlayPicInfoCardView b;

        public d(PlayPicInfoCardView playPicInfoCardView, PlayPicInfoCard.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playPicInfoCardView, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = playPicInfoCardView;
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || TextUtils.isEmpty(this.a.b)) {
                return;
            }
            pda.c(this.b.i, this.a.b);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PlayPicInfoCard.a a;
        public final /* synthetic */ bz8 b;
        public final /* synthetic */ PlayPicInfoCardView c;

        public e(PlayPicInfoCardView playPicInfoCardView, PlayPicInfoCard.a aVar, bz8 bz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playPicInfoCardView, aVar, bz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = playPicInfoCardView;
            this.a = aVar;
            this.b = bz8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !ViewHelper.checkUpIsLogin(this.c.i.getPageActivity())) {
                return;
            }
            my8 a = my8.a();
            bz8 bz8Var = this.a.d;
            a.d(bz8Var, bz8Var.b());
            ((CommonImageButton) view2).b(this.b);
        }
    }

    /* loaded from: classes7.dex */
    public class f extends g65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String b;
        public PlayPicInfoCard.b c;
        public final /* synthetic */ PlayPicInfoCardView d;

        public f(PlayPicInfoCardView playPicInfoCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playPicInfoCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = playPicInfoCardView;
        }

        public void c(PlayPicInfoCard.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
                this.b = bVar.b;
                this.c = bVar;
            }
        }

        @Override // com.baidu.tieba.g65
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.g65
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.c;
            }
            return invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayPicInfoCardView(TbPageContext tbPageContext) {
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

    public final void I(PlayPicInfoCard.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            if (bVar == null) {
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0101);
            } else {
                A(this.r, bVar.e, bVar.f, R.color.CAM_X0101);
            }
        }
    }

    private void setIndicatorViewPosition(PlayPicInfoCard playPicInfoCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, playPicInfoCard) == null) {
            int showDot = playPicInfoCard.getShowDot();
            if (showDot != 0) {
                if (showDot != 1) {
                    if (showDot != 2) {
                        this.s.setVisibility(8);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.s.getLayoutParams();
                    layoutParams.gravity = 81;
                    this.s.setLayoutParams(layoutParams);
                    this.s.setVisibility(0);
                    return;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.s.getLayoutParams();
                layoutParams2.gravity = 85;
                this.s.setLayoutParams(layoutParams2);
                this.s.setVisibility(0);
                return;
            }
            this.s.setVisibility(8);
        }
    }

    public final List<yh> J(PlayPicInfoCard playPicInfoCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, playPicInfoCard)) == null) {
            ArrayList arrayList = new ArrayList();
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() != 0) {
                int size = playPicInfoCard.getImageResList().size();
                for (int i = 0; i < size; i++) {
                    f fVar = new f(this);
                    fVar.c(playPicInfoCard.getImageResList().get(i));
                    arrayList.add(fVar);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void O(PlayPicInfoCard playPicInfoCard) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, playPicInfoCard) == null) {
            PlayPicInfoCard.c waterMark = playPicInfoCard.getWaterMark();
            if (waterMark == null) {
                this.t.setVisibility(8);
                return;
            }
            this.t.setVisibility(0);
            if (t()) {
                str = waterMark.b;
            } else {
                str = waterMark.a;
            }
            ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).setMargins(BdUtilHelper.dip2px(this.i.getPageActivity(), waterMark.c), BdUtilHelper.dip2px(this.i.getPageActivity(), waterMark.d), 0, 0);
            this.t.startLoad(str, 10, false);
        }
    }

    public final void K(TextView textView, TbImageView tbImageView, cz8 cz8Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, textView, tbImageView, cz8Var) == null) {
            if (t()) {
                str = cz8Var.b;
            } else {
                str = cz8Var.a;
            }
            if (!TextUtils.isEmpty(str)) {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                tbImageView.setVisibility(0);
                tbImageView.startLoad(str, 10, false);
            } else {
                tbImageView.setVisibility(8);
                textView.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(vy8.a(cz8Var.c)), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            textView.setText(cz8Var.d);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: L */
    public void v(PlayPicInfoCard playPicInfoCard, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, playPicInfoCard, i) == null) {
            co5.a(this.i, getRootView());
            SkinManager.setBackgroundResource(this.n, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0105);
            this.s.setSelector(SkinManager.getDrawable(R.drawable.dot_live_s));
            this.s.setDrawable(SkinManager.getDrawable(R.drawable.dot_live_n));
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0111);
            SkinManager.setBackgroundResource(this.v, R.drawable.label_bg_tie_n);
            SkinManager.setViewTextColor(this.x, (int) R.color.CAM_X0110);
            I(null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: M */
    public void w(PlayPicInfoCard playPicInfoCard) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, playPicInfoCard) == null) {
            this.o.setMaxLines(playPicInfoCard.getMaxLineForToptitle());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            if (playPicInfoCard.getRatio() > 0.0d) {
                int ratio = (int) (playPicInfoCard.getRatio() * BdUtilHelper.getEquipmentWidth(getContext()));
                if (Math.abs(ratio - layoutParams.height) > 10) {
                    layoutParams.height = ratio;
                    this.m.setLayoutParams(layoutParams);
                }
            } else {
                layoutParams.height = (int) ((BdUtilHelper.getEquipmentWidth(getContext()) * 0.5f) + 0.5f);
                this.m.setLayoutParams(layoutParams);
            }
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
                BannerFlowView bannerFlowView = this.m;
                if (playPicInfoCard.getDescOnPic() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                bannerFlowView.setDescOnPic(z2, !TextUtils.isEmpty(playPicInfoCard.getImageResList().get(0).d));
            } else {
                BannerFlowView bannerFlowView2 = this.m;
                if (playPicInfoCard.getDescOnPic() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                bannerFlowView2.setDescOnPic(z, false);
            }
            if (playPicInfoCard.getDuration() >= 5000) {
                this.m.setAutoScrollIntervalTime(playPicInfoCard.getDuration());
            } else {
                this.m.setAutoScrollIntervalTime(5000L);
            }
            this.m.setData(J(playPicInfoCard));
            if (playPicInfoCard.getDescOnPic() != 1) {
                this.r.setVisibility(8);
                if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 1) {
                    this.q.setMaxWidth(((BdUtilHelper.getEquipmentWidth(getContext()) - BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0701e8)) - BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0701d5)) - (BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0701e8) * playPicInfoCard.getImageResList().size()));
                    this.q.setText(playPicInfoCard.getImageResList().get(0).d);
                    this.s.setVisibility(0);
                    this.s.setCount(playPicInfoCard.getImageResList().size());
                    setIndicatorViewPosition(playPicInfoCard);
                    this.p.setVisibility(0);
                    this.o.setVisibility(8);
                } else if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() == 1) {
                    if (playPicInfoCard.getDescOnPic() == 2) {
                        this.o.setText(playPicInfoCard.getImageResList().get(0).d);
                        this.o.setVisibility(0);
                        this.p.setVisibility(8);
                    } else {
                        this.p.setVisibility(0);
                        this.q.setMaxWidth(BdUtilHelper.getEquipmentWidth(getContext()) - BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0701e8));
                        this.q.setText(playPicInfoCard.getImageResList().get(0).d);
                        this.o.setVisibility(8);
                        this.s.setVisibility(8);
                    }
                }
            } else {
                if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
                    this.r.setVisibility(0);
                    if (playPicInfoCard.getImageResList().size() > 1) {
                        this.r.setMaxWidth(((BdUtilHelper.getEquipmentWidth(getContext()) - BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0701e8)) - BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0701d5)) - (BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0701e8) * playPicInfoCard.getImageResList().size()));
                    } else {
                        this.r.setMaxWidth(BdUtilHelper.getEquipmentWidth(getContext()) - BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0701e8));
                    }
                    this.r.setText(playPicInfoCard.getImageResList().get(0).d);
                    I(playPicInfoCard.getImageResList().get(0));
                } else {
                    this.r.setVisibility(8);
                }
                this.o.setVisibility(8);
                this.p.setVisibility(8);
            }
            this.m.setOnItemClickListener(new a(this, playPicInfoCard));
            this.m.setOnPageSelected(new b(this, playPicInfoCard));
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() == 1) {
                setCardOnClickListener(new c(this, playPicInfoCard));
            } else {
                setCardOnClickListener(null);
            }
            N(playPicInfoCard);
            O(playPicInfoCard);
            this.m.setIndicatorViewPosition(playPicInfoCard.getShowDot());
        }
    }

    public final void N(PlayPicInfoCard playPicInfoCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, playPicInfoCard) == null) {
            PlayPicInfoCard.a bottomInfo = playPicInfoCard.getBottomInfo();
            if (bottomInfo != null && bottomInfo.b()) {
                this.u.setVisibility(0);
                if (TextUtils.isEmpty(bottomInfo.a)) {
                    this.v.setVisibility(8);
                } else {
                    this.v.setVisibility(0);
                    this.v.setText(bottomInfo.a);
                    this.v.setOnClickListener(new d(this, bottomInfo));
                }
                cz8 cz8Var = bottomInfo.c;
                if (cz8Var != null) {
                    K(this.x, this.w, cz8Var);
                }
                if (bottomInfo.d != null) {
                    this.y.setVisibility(0);
                    BdUtilHelper.addToParentArea(this.i.getPageActivity(), this.y, 20, 20, 20, 20);
                    bz8 bz8Var = bottomInfo.d;
                    this.y.b(bz8Var);
                    this.y.setOnClickListener(new e(this, bottomInfo, bz8Var));
                    return;
                }
                this.y.setVisibility(8);
                return;
            }
            this.u.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            View inflate = LayoutInflater.from(this.i.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01da, (ViewGroup) null);
            this.n = inflate;
            this.m = (BannerFlowView) n(inflate, R.id.obfuscated_res_0x7f090332);
            if (this.i.getOrignalPage() instanceof SwipeBackLayout.b) {
                this.m.setSwipeControlInterface((SwipeBackLayout.b) this.i.getOrignalPage());
            }
            this.m.setDisableParentEvent(false);
            this.m.setMaxScrollCountLimit(100);
            this.t = (TbImageView) n(this.n, R.id.obfuscated_res_0x7f090b66);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams.height = (int) ((BdUtilHelper.getEquipmentWidth(getContext()) * 0.5f) + 0.5f);
            this.m.setLayoutParams(layoutParams);
            this.q = (TextView) n(this.n, R.id.obfuscated_res_0x7f0925b1);
            this.p = (LinearLayout) n(this.n, R.id.obfuscated_res_0x7f09161e);
            this.r = (TextView) n(this.n, R.id.obfuscated_res_0x7f0925c8);
            this.s = (IndicatorView) n(this.n, R.id.obfuscated_res_0x7f09113b);
            this.o = (TextView) n(this.n, R.id.obfuscated_res_0x7f0925d8);
            RelativeLayout relativeLayout = (RelativeLayout) n(this.n, R.id.obfuscated_res_0x7f09047e);
            this.u = relativeLayout;
            this.v = (TextView) n(relativeLayout, R.id.forum_name);
            this.w = (TbImageView) n(this.u, R.id.obfuscated_res_0x7f09100b);
            this.x = (TextView) n(this.u, R.id.obfuscated_res_0x7f09249e);
            this.y = (CommonImageButton) n(this.u, R.id.obfuscated_res_0x7f0919d9);
            return this.n;
        }
        return (View) invokeV.objValue;
    }
}
