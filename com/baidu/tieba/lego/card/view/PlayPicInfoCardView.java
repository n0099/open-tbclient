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
import c.a.d.n.e.n;
import c.a.s0.s.k0.u.b;
import c.a.t0.g0.v;
import c.a.t0.x3.w;
import c.a.t0.y1.i;
import c.a.t0.y1.t.a;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes12.dex */
public class PlayPicInfoCardView extends BaseCardView<PlayPicInfoCard> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DESC_BOTTOM_PIC = 3;
    public static final int DESC_ON_PIC = 1;
    public static final int DESC_TOP_PIC = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public View f45614f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f45615g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f45616h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f45617i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f45618j;
    public IndicatorView k;
    public TbImageView l;
    public RelativeLayout m;
    public BannerFlowView mBannerFlowView;
    public TextView n;
    public TbImageView o;
    public TextView p;
    public CommonImageButton q;

    /* loaded from: classes12.dex */
    public class a implements b.a<c.a.s0.s.k0.u.d.a, a.C1542a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PlayPicInfoCard a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f45619b;

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
            this.f45619b = playPicInfoCardView;
            this.a = playPicInfoCard;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.s.k0.u.b.a
        /* renamed from: b */
        public void a(a.C1542a c1542a, c.a.s0.s.k0.u.d.a aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1542a, aVar) == null) && (aVar.d() instanceof PlayPicInfoCard.b)) {
                PlayPicInfoCard.b bVar = (PlayPicInfoCard.b) aVar.d();
                if (TextUtils.isEmpty(bVar.f45551c)) {
                    return;
                }
                v.b().d(true);
                c.a.t0.y1.e f2 = i.f(bVar.f45557i, bVar.f45555g, this.a.getCardType(), this.a.getItemId());
                f2.d("obj_id", bVar.a);
                f2.d(TiebaStatic.Params.OBJ_URL, bVar.f45551c);
                f2.b("obj_locate", this.f45619b.getStatPosition());
                f2.a(this.a);
                w.c(this.f45619b.mContext, bVar.f45551c);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements BannerFlowView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PlayPicInfoCard a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f45620b;

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
            this.f45620b = playPicInfoCardView;
            this.a = playPicInfoCard;
        }

        @Override // c.a.t0.y1.o.l.k
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.a.getDescOnPic() == 1) {
                return;
            }
            this.f45620b.k.setCount(i2);
        }

        @Override // c.a.t0.y1.o.l.k
        public void b(float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) || this.a.getDescOnPic() == 1) {
                return;
            }
            this.f45620b.k.setPosition(f2);
        }

        @Override // com.baidu.tieba.lego.view.BannerFlowView.c
        public void onPageSelected(int i2) {
            List<PlayPicInfoCard.b> imageResList;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (imageResList = this.a.getImageResList()) == null || imageResList.size() <= i2) {
                return;
            }
            if (this.a.getDescOnPic() != 1) {
                this.f45620b.f45618j.setVisibility(8);
                if (!TextUtils.isEmpty(imageResList.get(i2).f45552d)) {
                    this.f45620b.f45617i.setText(imageResList.get(i2).f45552d);
                    return;
                } else {
                    this.f45620b.f45616h.setVisibility(8);
                    return;
                }
            }
            if (!TextUtils.isEmpty(imageResList.get(i2).f45552d)) {
                this.f45620b.f45618j.setText(imageResList.get(i2).f45552d);
                this.f45620b.g(imageResList.get(i2));
                this.f45620b.f45618j.setVisibility(0);
            } else {
                this.f45620b.f45618j.setVisibility(8);
            }
            BannerFlowView bannerFlowView = this.f45620b.mBannerFlowView;
            if (bannerFlowView != null) {
                bannerFlowView.setDescOnPic(true, !TextUtils.isEmpty(imageResList.get(i2).f45552d));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCard f45621e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f45622f;

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
            this.f45622f = playPicInfoCardView;
            this.f45621e = playPicInfoCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f45621e.getImageResList().get(0) == null) {
                return;
            }
            w.c(this.f45622f.mContext, this.f45621e.getImageResList().get(0).f45551c);
            v.b().d(true);
        }
    }

    /* loaded from: classes12.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCard.a f45623e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f45624f;

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
            this.f45624f = playPicInfoCardView;
            this.f45623e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f45623e.f45547b)) {
                return;
            }
            w.c(this.f45624f.mContext, this.f45623e.f45547b);
        }
    }

    /* loaded from: classes12.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCard.a f45625e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.y1.o.j.a f45626f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f45627g;

        public e(PlayPicInfoCardView playPicInfoCardView, PlayPicInfoCard.a aVar, c.a.t0.y1.o.j.a aVar2) {
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
            this.f45627g = playPicInfoCardView;
            this.f45625e = aVar;
            this.f45626f = aVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f45627g.mContext.getPageActivity())) {
                c.a.t0.y1.m.b a = c.a.t0.y1.m.b.a();
                c.a.t0.y1.o.j.a aVar = this.f45625e.f45549d;
                a.d(aVar, aVar.b());
                ((CommonImageButton) view).updateView(this.f45626f);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f extends c.a.s0.s.k0.u.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public String f45628f;

        /* renamed from: g  reason: collision with root package name */
        public PlayPicInfoCard.b f45629g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f45630h;

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
            this.f45630h = playPicInfoCardView;
        }

        @Override // c.a.s0.s.k0.u.d.a
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f45628f : (String) invokeV.objValue;
        }

        @Override // c.a.s0.s.k0.u.d.a
        public Object d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f45629g : invokeV.objValue;
        }

        public void e(PlayPicInfoCard.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
                this.f45628f = bVar.f45550b;
                this.f45629g = bVar;
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
        if (interceptable == null || interceptable.invokeL(65541, this, playPicInfoCard) == null) {
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
                SkinManager.setViewTextColor(this.f45618j, R.color.CAM_X0101);
            } else {
                setTextColor(this.f45618j, bVar.f45553e, bVar.f45554f, R.color.CAM_X0101);
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
                    fVar.e(playPicInfoCard.getImageResList().get(i2));
                    arrayList.add(fVar);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void i(TextView textView, TbImageView tbImageView, c.a.t0.y1.o.j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, textView, tbImageView, bVar) == null) {
            String str = isNightMode() ? bVar.f25455b : bVar.a;
            if (!TextUtils.isEmpty(str)) {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                tbImageView.setVisibility(0);
                tbImageView.startLoad(str, 10, false);
            } else {
                tbImageView.setVisibility(8);
                textView.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(c.a.t0.y1.o.f.a(bVar.f25456c)), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            textView.setText(bVar.f25457d);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View initLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.card_play_pic_info, (ViewGroup) null);
            this.f45614f = inflate;
            this.mBannerFlowView = (BannerFlowView) findViewById(inflate, R.id.banner);
            if (this.mContext.getOrignalPage() instanceof SwipeBackLayout.c) {
                this.mBannerFlowView.setSwipeControlInterface((SwipeBackLayout.c) this.mContext.getOrignalPage());
            }
            this.mBannerFlowView.setDisableParentEvent(false);
            this.mBannerFlowView.setMaxScrollCountLimit(100);
            this.l = (TbImageView) findViewById(this.f45614f, R.id.float_icon);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mBannerFlowView.getLayoutParams();
            layoutParams.height = (int) ((c.a.d.f.p.n.k(getContext()) * 0.5f) + 0.5f);
            this.mBannerFlowView.setLayoutParams(layoutParams);
            this.f45617i = (TextView) findViewById(this.f45614f, R.id.title_bottom);
            this.f45616h = (LinearLayout) findViewById(this.f45614f, R.id.ll_bottom);
            this.f45618j = (TextView) findViewById(this.f45614f, R.id.title_on);
            this.k = (IndicatorView) findViewById(this.f45614f, R.id.indicator);
            this.f45615g = (TextView) findViewById(this.f45614f, R.id.title_top);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(this.f45614f, R.id.bottom_relative_layout);
            this.m = relativeLayout;
            this.n = (TextView) findViewById(relativeLayout, R.id.forum_name);
            this.o = (TbImageView) findViewById(this.m, R.id.icon);
            this.p = (TextView) findViewById(this.m, R.id.text);
            this.q = (CommonImageButton) findViewById(this.m, R.id.notice_button);
            return this.f45614f;
        }
        return (View) invokeV.objValue;
    }

    public final void j(PlayPicInfoCard playPicInfoCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, playPicInfoCard) == null) {
            PlayPicInfoCard.a bottomInfo = playPicInfoCard.getBottomInfo();
            if (bottomInfo != null && bottomInfo.b()) {
                this.m.setVisibility(0);
                if (TextUtils.isEmpty(bottomInfo.a)) {
                    this.n.setVisibility(8);
                } else {
                    this.n.setVisibility(0);
                    this.n.setText(bottomInfo.a);
                    this.n.setOnClickListener(new d(this, bottomInfo));
                }
                c.a.t0.y1.o.j.b bVar = bottomInfo.f45548c;
                if (bVar != null) {
                    i(this.p, this.o, bVar);
                }
                if (bottomInfo.f45549d != null) {
                    this.q.setVisibility(0);
                    c.a.d.f.p.n.b(this.mContext.getPageActivity(), this.q, 20, 20, 20, 20);
                    c.a.t0.y1.o.j.a aVar = bottomInfo.f45549d;
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
            String str = isNightMode() ? waterMark.f45558b : waterMark.a;
            ((RelativeLayout.LayoutParams) this.l.getLayoutParams()).setMargins(c.a.d.f.p.n.d(this.mContext.getPageActivity(), waterMark.f45559c), c.a.d.f.p.n.d(this.mContext.getPageActivity(), waterMark.f45560d), 0, 0);
            this.l.startLoad(str, 10, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onChangeSkinType(PlayPicInfoCard playPicInfoCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, playPicInfoCard, i2) == null) {
            c.a.s0.x0.a.a(this.mContext, getRootView());
            SkinManager.setBackgroundResource(this.f45614f, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f45615g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f45617i, R.color.CAM_X0105);
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
            this.f45615g.setMaxLines(playPicInfoCard.getMaxLineForToptitle());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mBannerFlowView.getLayoutParams();
            if (playPicInfoCard.getRatio() > 0.0d) {
                int ratio = (int) (playPicInfoCard.getRatio() * c.a.d.f.p.n.k(getContext()));
                if (Math.abs(ratio - layoutParams.height) > 10) {
                    layoutParams.height = ratio;
                    this.mBannerFlowView.setLayoutParams(layoutParams);
                }
            } else {
                layoutParams.height = (int) ((c.a.d.f.p.n.k(getContext()) * 0.5f) + 0.5f);
                this.mBannerFlowView.setLayoutParams(layoutParams);
            }
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
                this.mBannerFlowView.setDescOnPic(playPicInfoCard.getDescOnPic() == 1, !TextUtils.isEmpty(playPicInfoCard.getImageResList().get(0).f45552d));
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
                this.f45618j.setVisibility(8);
                if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 1) {
                    this.f45617i.setMaxWidth(((c.a.d.f.p.n.k(getContext()) - c.a.d.f.p.n.f(getContext(), R.dimen.ds24)) - c.a.d.f.p.n.f(getContext(), R.dimen.ds20)) - (c.a.d.f.p.n.f(getContext(), R.dimen.ds24) * playPicInfoCard.getImageResList().size()));
                    this.f45617i.setText(playPicInfoCard.getImageResList().get(0).f45552d);
                    this.k.setVisibility(0);
                    this.k.setCount(playPicInfoCard.getImageResList().size());
                    setIndicatorViewPosition(playPicInfoCard);
                    this.f45616h.setVisibility(0);
                    this.f45615g.setVisibility(8);
                } else if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() == 1) {
                    if (playPicInfoCard.getDescOnPic() == 2) {
                        this.f45615g.setText(playPicInfoCard.getImageResList().get(0).f45552d);
                        this.f45615g.setVisibility(0);
                        this.f45616h.setVisibility(8);
                    } else {
                        this.f45616h.setVisibility(0);
                        this.f45617i.setMaxWidth(c.a.d.f.p.n.k(getContext()) - c.a.d.f.p.n.f(getContext(), R.dimen.ds24));
                        this.f45617i.setText(playPicInfoCard.getImageResList().get(0).f45552d);
                        this.f45615g.setVisibility(8);
                        this.k.setVisibility(8);
                    }
                }
            } else {
                if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
                    this.f45618j.setVisibility(0);
                    if (playPicInfoCard.getImageResList().size() > 1) {
                        this.f45618j.setMaxWidth(((c.a.d.f.p.n.k(getContext()) - c.a.d.f.p.n.f(getContext(), R.dimen.ds24)) - c.a.d.f.p.n.f(getContext(), R.dimen.ds20)) - (c.a.d.f.p.n.f(getContext(), R.dimen.ds24) * playPicInfoCard.getImageResList().size()));
                    } else {
                        this.f45618j.setMaxWidth(c.a.d.f.p.n.k(getContext()) - c.a.d.f.p.n.f(getContext(), R.dimen.ds24));
                    }
                    this.f45618j.setText(playPicInfoCard.getImageResList().get(0).f45552d);
                    g(playPicInfoCard.getImageResList().get(0));
                } else {
                    this.f45618j.setVisibility(8);
                }
                this.f45615g.setVisibility(8);
                this.f45616h.setVisibility(8);
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
