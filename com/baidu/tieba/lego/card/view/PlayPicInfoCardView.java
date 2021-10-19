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
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.q0.s.f0.u.b;
import c.a.r0.b0.u;
import c.a.r0.k3.w;
import c.a.r0.q1.i;
import c.a.r0.q1.t.a;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.PlayPicInfoCard;
import com.baidu.tieba.lego.view.BannerFlowView;
import com.baidu.tieba.lego.view.CommonImageButton;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DESC_BOTTOM_PIC = 3;
    public static final int DESC_ON_PIC = 1;
    public static final int DESC_TOP_PIC = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public View f53945f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f53946g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f53947h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f53948i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f53949j;
    public IndicatorView k;
    public TbImageView l;
    public RelativeLayout m;
    public BannerFlowView mBannerFlowView;
    public TextView n;
    public TbImageView o;
    public TextView p;
    public CommonImageButton q;

    /* loaded from: classes7.dex */
    public class a implements b.a<c.a.q0.s.f0.u.d.a, a.C1113a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCard f53950a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f53951b;

        public a(PlayPicInfoCardView playPicInfoCardView, PlayPicInfoCard playPicInfoCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playPicInfoCardView, playPicInfoCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53951b = playPicInfoCardView;
            this.f53950a = playPicInfoCard;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.s.f0.u.b.a
        /* renamed from: b */
        public void a(a.C1113a c1113a, c.a.q0.s.f0.u.d.a aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1113a, aVar) == null) && (aVar.c() instanceof PlayPicInfoCard.b)) {
                PlayPicInfoCard.b bVar = (PlayPicInfoCard.b) aVar.c();
                if (TextUtils.isEmpty(bVar.f53879c)) {
                    return;
                }
                u.b().d(true);
                c.a.r0.q1.e f2 = i.f(bVar.f53885i, bVar.f53883g, this.f53950a.getCardType(), this.f53950a.getItemId());
                f2.d("obj_id", bVar.f53877a);
                f2.d(TiebaStatic.Params.OBJ_URL, bVar.f53879c);
                f2.b("obj_locate", this.f53951b.getStatPosition());
                f2.a(this.f53950a);
                w.c(this.f53951b.mContext, bVar.f53879c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BannerFlowView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCard f53952a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f53953b;

        public b(PlayPicInfoCardView playPicInfoCardView, PlayPicInfoCard playPicInfoCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playPicInfoCardView, playPicInfoCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53953b = playPicInfoCardView;
            this.f53952a = playPicInfoCard;
        }

        @Override // c.a.r0.q1.o.l.k
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f53952a.getDescOnPic() == 1) {
                return;
            }
            this.f53953b.k.setCount(i2);
        }

        @Override // c.a.r0.q1.o.l.k
        public void b(float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) || this.f53952a.getDescOnPic() == 1) {
                return;
            }
            this.f53953b.k.setPosition(f2);
        }

        @Override // com.baidu.tieba.lego.view.BannerFlowView.c
        public void onPageSelected(int i2) {
            List<PlayPicInfoCard.b> imageResList;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (imageResList = this.f53952a.getImageResList()) == null || imageResList.size() <= i2) {
                return;
            }
            if (this.f53952a.getDescOnPic() != 1) {
                this.f53953b.f53949j.setVisibility(8);
                if (!TextUtils.isEmpty(imageResList.get(i2).f53880d)) {
                    this.f53953b.f53948i.setText(imageResList.get(i2).f53880d);
                    return;
                } else {
                    this.f53953b.f53947h.setVisibility(8);
                    return;
                }
            }
            if (!TextUtils.isEmpty(imageResList.get(i2).f53880d)) {
                this.f53953b.f53949j.setText(imageResList.get(i2).f53880d);
                this.f53953b.g(imageResList.get(i2));
                this.f53953b.f53949j.setVisibility(0);
            } else {
                this.f53953b.f53949j.setVisibility(8);
            }
            BannerFlowView bannerFlowView = this.f53953b.mBannerFlowView;
            if (bannerFlowView != null) {
                bannerFlowView.setDescOnPic(true, !TextUtils.isEmpty(imageResList.get(i2).f53880d));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCard f53954e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f53955f;

        public c(PlayPicInfoCardView playPicInfoCardView, PlayPicInfoCard playPicInfoCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playPicInfoCardView, playPicInfoCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53955f = playPicInfoCardView;
            this.f53954e = playPicInfoCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f53954e.getImageResList().get(0) == null) {
                return;
            }
            w.c(this.f53955f.mContext, this.f53954e.getImageResList().get(0).f53879c);
            u.b().d(true);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCard.a f53956e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f53957f;

        public d(PlayPicInfoCardView playPicInfoCardView, PlayPicInfoCard.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playPicInfoCardView, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53957f = playPicInfoCardView;
            this.f53956e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f53956e.f53874b)) {
                return;
            }
            w.c(this.f53957f.mContext, this.f53956e.f53874b);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCard.a f53958e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.q1.o.j.a f53959f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f53960g;

        public e(PlayPicInfoCardView playPicInfoCardView, PlayPicInfoCard.a aVar, c.a.r0.q1.o.j.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playPicInfoCardView, aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53960g = playPicInfoCardView;
            this.f53958e = aVar;
            this.f53959f = aVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f53960g.mContext.getPageActivity())) {
                c.a.r0.q1.m.b a2 = c.a.r0.q1.m.b.a();
                c.a.r0.q1.o.j.a aVar = this.f53958e.f53876d;
                a2.d(aVar, aVar.b());
                ((CommonImageButton) view).updateView(this.f53959f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends c.a.q0.s.f0.u.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public String f53961f;

        /* renamed from: g  reason: collision with root package name */
        public PlayPicInfoCard.b f53962g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f53963h;

        public f(PlayPicInfoCardView playPicInfoCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playPicInfoCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53963h = playPicInfoCardView;
        }

        @Override // c.a.q0.s.f0.u.d.a
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f53961f : (String) invokeV.objValue;
        }

        @Override // c.a.q0.s.f0.u.d.a
        public Object c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f53962g : invokeV.objValue;
        }

        public void d(PlayPicInfoCard.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
                this.f53961f = bVar.f53878b;
                this.f53962g = bVar;
            }
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

    private void setIndicatorViewPosition(PlayPicInfoCard playPicInfoCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, playPicInfoCard) == null) {
            int showDot = playPicInfoCard.getShowDot();
            if (showDot == 0) {
                this.k.setVisibility(8);
            } else if (showDot == 1) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
                layoutParams.gravity = 85;
                this.k.setLayoutParams(layoutParams);
                this.k.setVisibility(0);
            } else if (showDot != 2) {
                this.k.setVisibility(8);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.k.getLayoutParams();
                layoutParams2.gravity = 81;
                this.k.setLayoutParams(layoutParams2);
                this.k.setVisibility(0);
            }
        }
    }

    public final void g(PlayPicInfoCard.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            if (bVar == null) {
                SkinManager.setViewTextColor(this.f53949j, R.color.CAM_X0101);
            } else {
                setTextColor(this.f53949j, bVar.f53881e, bVar.f53882f, R.color.CAM_X0101);
            }
        }
    }

    public final List<n> h(PlayPicInfoCard playPicInfoCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, playPicInfoCard)) == null) {
            ArrayList arrayList = new ArrayList();
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() != 0) {
                int size = playPicInfoCard.getImageResList().size();
                for (int i2 = 0; i2 < size; i2++) {
                    f fVar = new f(this);
                    fVar.d(playPicInfoCard.getImageResList().get(i2));
                    arrayList.add(fVar);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void i(TextView textView, TbImageView tbImageView, c.a.r0.q1.o.j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, textView, tbImageView, bVar) == null) {
            String str = isNightMode() ? bVar.f23750b : bVar.f23749a;
            if (!TextUtils.isEmpty(str)) {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                tbImageView.setVisibility(0);
                tbImageView.startLoad(str, 10, false);
            } else {
                tbImageView.setVisibility(8);
                textView.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(c.a.r0.q1.o.f.a(bVar.f23751c)), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            textView.setText(bVar.f23752d);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View initLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.card_play_pic_info, (ViewGroup) null);
            this.f53945f = inflate;
            this.mBannerFlowView = (BannerFlowView) findViewById(inflate, R.id.banner);
            if (this.mContext.getOrignalPage() instanceof SwipeBackLayout.c) {
                this.mBannerFlowView.setSwipeControlInterface((SwipeBackLayout.c) this.mContext.getOrignalPage());
            }
            this.mBannerFlowView.setDisableParentEvent(false);
            this.mBannerFlowView.setMaxScrollCountLimit(100);
            this.l = (TbImageView) findViewById(this.f53945f, R.id.float_icon);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mBannerFlowView.getLayoutParams();
            layoutParams.height = (int) ((l.k(getContext()) * 0.5f) + 0.5f);
            this.mBannerFlowView.setLayoutParams(layoutParams);
            this.f53948i = (TextView) findViewById(this.f53945f, R.id.title_bottom);
            this.f53947h = (LinearLayout) findViewById(this.f53945f, R.id.ll_bottom);
            this.f53949j = (TextView) findViewById(this.f53945f, R.id.title_on);
            this.k = (IndicatorView) findViewById(this.f53945f, R.id.indicator);
            this.f53946g = (TextView) findViewById(this.f53945f, R.id.title_top);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(this.f53945f, R.id.bottom_relative_layout);
            this.m = relativeLayout;
            this.n = (TextView) findViewById(relativeLayout, R.id.forum_name);
            this.o = (TbImageView) findViewById(this.m, R.id.icon);
            this.p = (TextView) findViewById(this.m, R.id.text);
            this.q = (CommonImageButton) findViewById(this.m, R.id.notice_button);
            return this.f53945f;
        }
        return (View) invokeV.objValue;
    }

    public final void j(PlayPicInfoCard playPicInfoCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, playPicInfoCard) == null) {
            PlayPicInfoCard.a bottomInfo = playPicInfoCard.getBottomInfo();
            if (bottomInfo != null && bottomInfo.b()) {
                this.m.setVisibility(0);
                if (TextUtils.isEmpty(bottomInfo.f53873a)) {
                    this.n.setVisibility(8);
                } else {
                    this.n.setVisibility(0);
                    this.n.setText(bottomInfo.f53873a);
                    this.n.setOnClickListener(new d(this, bottomInfo));
                }
                c.a.r0.q1.o.j.b bVar = bottomInfo.f53875c;
                if (bVar != null) {
                    i(this.p, this.o, bVar);
                }
                if (bottomInfo.f53876d != null) {
                    this.q.setVisibility(0);
                    l.c(this.mContext.getPageActivity(), this.q, 20, 20, 20, 20);
                    c.a.r0.q1.o.j.a aVar = bottomInfo.f53876d;
                    this.q.updateView(aVar);
                    this.q.setOnClickListener(new e(this, bottomInfo, aVar));
                    return;
                }
                this.q.setVisibility(8);
                return;
            }
            this.m.setVisibility(8);
        }
    }

    public final void k(PlayPicInfoCard playPicInfoCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, playPicInfoCard) == null) {
            PlayPicInfoCard.c waterMark = playPicInfoCard.getWaterMark();
            if (waterMark == null) {
                this.l.setVisibility(8);
                return;
            }
            this.l.setVisibility(0);
            String str = isNightMode() ? waterMark.f53887b : waterMark.f53886a;
            ((RelativeLayout.LayoutParams) this.l.getLayoutParams()).setMargins(l.e(this.mContext.getPageActivity(), waterMark.f53888c), l.e(this.mContext.getPageActivity(), waterMark.f53889d), 0, 0);
            this.l.startLoad(str, 10, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onChangeSkinType(PlayPicInfoCard playPicInfoCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, playPicInfoCard, i2) == null) {
            c.a.q0.w0.a.a(this.mContext, getRootView());
            SkinManager.setBackgroundResource(this.f53945f, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f53946g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f53948i, R.color.CAM_X0105);
            this.k.setSelector(SkinManager.getDrawable(R.drawable.dot_live_s));
            this.k.setDrawable(SkinManager.getDrawable(R.drawable.dot_live_n));
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0111);
            SkinManager.setBackgroundResource(this.n, R.drawable.label_bg_tie_n);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0110);
            g(null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onUpdateCardView(PlayPicInfoCard playPicInfoCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, playPicInfoCard) == null) {
            this.f53946g.setMaxLines(playPicInfoCard.getMaxLineForToptitle());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mBannerFlowView.getLayoutParams();
            if (playPicInfoCard.getRatio() > 0.0d) {
                int ratio = (int) (playPicInfoCard.getRatio() * l.k(getContext()));
                if (Math.abs(ratio - layoutParams.height) > 10) {
                    layoutParams.height = ratio;
                    this.mBannerFlowView.setLayoutParams(layoutParams);
                }
            } else {
                layoutParams.height = (int) ((l.k(getContext()) * 0.5f) + 0.5f);
                this.mBannerFlowView.setLayoutParams(layoutParams);
            }
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
                this.mBannerFlowView.setDescOnPic(playPicInfoCard.getDescOnPic() == 1, !TextUtils.isEmpty(playPicInfoCard.getImageResList().get(0).f53880d));
            } else {
                this.mBannerFlowView.setDescOnPic(playPicInfoCard.getDescOnPic() == 1, false);
            }
            if (playPicInfoCard.getDuration() >= 5000) {
                this.mBannerFlowView.setAutoScrollIntervalTime(playPicInfoCard.getDuration());
            } else {
                this.mBannerFlowView.setAutoScrollIntervalTime(5000L);
            }
            this.mBannerFlowView.setData(h(playPicInfoCard));
            if (playPicInfoCard.getDescOnPic() != 1) {
                this.f53949j.setVisibility(8);
                if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 1) {
                    this.f53948i.setMaxWidth(((l.k(getContext()) - l.g(getContext(), R.dimen.ds24)) - l.g(getContext(), R.dimen.ds20)) - (l.g(getContext(), R.dimen.ds24) * playPicInfoCard.getImageResList().size()));
                    this.f53948i.setText(playPicInfoCard.getImageResList().get(0).f53880d);
                    this.k.setVisibility(0);
                    this.k.setCount(playPicInfoCard.getImageResList().size());
                    setIndicatorViewPosition(playPicInfoCard);
                    this.f53947h.setVisibility(0);
                    this.f53946g.setVisibility(8);
                } else if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() == 1) {
                    if (playPicInfoCard.getDescOnPic() == 2) {
                        this.f53946g.setText(playPicInfoCard.getImageResList().get(0).f53880d);
                        this.f53946g.setVisibility(0);
                        this.f53947h.setVisibility(8);
                    } else {
                        this.f53947h.setVisibility(0);
                        this.f53948i.setMaxWidth(l.k(getContext()) - l.g(getContext(), R.dimen.ds24));
                        this.f53948i.setText(playPicInfoCard.getImageResList().get(0).f53880d);
                        this.f53946g.setVisibility(8);
                        this.k.setVisibility(8);
                    }
                }
            } else {
                if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
                    this.f53949j.setVisibility(0);
                    if (playPicInfoCard.getImageResList().size() > 1) {
                        this.f53949j.setMaxWidth(((l.k(getContext()) - l.g(getContext(), R.dimen.ds24)) - l.g(getContext(), R.dimen.ds20)) - (l.g(getContext(), R.dimen.ds24) * playPicInfoCard.getImageResList().size()));
                    } else {
                        this.f53949j.setMaxWidth(l.k(getContext()) - l.g(getContext(), R.dimen.ds24));
                    }
                    this.f53949j.setText(playPicInfoCard.getImageResList().get(0).f53880d);
                    g(playPicInfoCard.getImageResList().get(0));
                } else {
                    this.f53949j.setVisibility(8);
                }
                this.f53946g.setVisibility(8);
                this.f53947h.setVisibility(8);
            }
            this.mBannerFlowView.setOnItemClickListener(new a(this, playPicInfoCard));
            this.mBannerFlowView.setOnPageSelected(new b(this, playPicInfoCard));
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() == 1) {
                setCardOnClickListener(new c(this, playPicInfoCard));
            } else {
                setCardOnClickListener(null);
            }
            j(playPicInfoCard);
            k(playPicInfoCard);
            this.mBannerFlowView.setIndicatorViewPosition(playPicInfoCard.getShowDot());
        }
    }
}
