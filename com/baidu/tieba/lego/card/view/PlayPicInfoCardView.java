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
import c.a.s0.s.i0.u.b;
import c.a.t0.g0.v;
import c.a.t0.w3.w;
import c.a.t0.x1.i;
import c.a.t0.x1.t.a;
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
    public View f47341f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f47342g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f47343h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f47344i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f47345j;

    /* renamed from: k  reason: collision with root package name */
    public IndicatorView f47346k;
    public TbImageView l;
    public RelativeLayout m;
    public BannerFlowView mBannerFlowView;
    public TextView n;
    public TbImageView o;
    public TextView p;
    public CommonImageButton q;

    /* loaded from: classes12.dex */
    public class a implements b.a<c.a.s0.s.i0.u.d.a, a.C1506a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PlayPicInfoCard a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f47347b;

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
            this.f47347b = playPicInfoCardView;
            this.a = playPicInfoCard;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.s.i0.u.b.a
        /* renamed from: b */
        public void a(a.C1506a c1506a, c.a.s0.s.i0.u.d.a aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1506a, aVar) == null) && (aVar.d() instanceof PlayPicInfoCard.b)) {
                PlayPicInfoCard.b bVar = (PlayPicInfoCard.b) aVar.d();
                if (TextUtils.isEmpty(bVar.f47274c)) {
                    return;
                }
                v.b().d(true);
                c.a.t0.x1.e f2 = i.f(bVar.f47280i, bVar.f47278g, this.a.getCardType(), this.a.getItemId());
                f2.d("obj_id", bVar.a);
                f2.d(TiebaStatic.Params.OBJ_URL, bVar.f47274c);
                f2.b("obj_locate", this.f47347b.getStatPosition());
                f2.a(this.a);
                w.c(this.f47347b.mContext, bVar.f47274c);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements BannerFlowView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PlayPicInfoCard a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f47348b;

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
            this.f47348b = playPicInfoCardView;
            this.a = playPicInfoCard;
        }

        @Override // c.a.t0.x1.o.l.k
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.a.getDescOnPic() == 1) {
                return;
            }
            this.f47348b.f47346k.setCount(i2);
        }

        @Override // c.a.t0.x1.o.l.k
        public void b(float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) || this.a.getDescOnPic() == 1) {
                return;
            }
            this.f47348b.f47346k.setPosition(f2);
        }

        @Override // com.baidu.tieba.lego.view.BannerFlowView.c
        public void onPageSelected(int i2) {
            List<PlayPicInfoCard.b> imageResList;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (imageResList = this.a.getImageResList()) == null || imageResList.size() <= i2) {
                return;
            }
            if (this.a.getDescOnPic() != 1) {
                this.f47348b.f47345j.setVisibility(8);
                if (!TextUtils.isEmpty(imageResList.get(i2).f47275d)) {
                    this.f47348b.f47344i.setText(imageResList.get(i2).f47275d);
                    return;
                } else {
                    this.f47348b.f47343h.setVisibility(8);
                    return;
                }
            }
            if (!TextUtils.isEmpty(imageResList.get(i2).f47275d)) {
                this.f47348b.f47345j.setText(imageResList.get(i2).f47275d);
                this.f47348b.g(imageResList.get(i2));
                this.f47348b.f47345j.setVisibility(0);
            } else {
                this.f47348b.f47345j.setVisibility(8);
            }
            BannerFlowView bannerFlowView = this.f47348b.mBannerFlowView;
            if (bannerFlowView != null) {
                bannerFlowView.setDescOnPic(true, !TextUtils.isEmpty(imageResList.get(i2).f47275d));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCard f47349e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f47350f;

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
            this.f47350f = playPicInfoCardView;
            this.f47349e = playPicInfoCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f47349e.getImageResList().get(0) == null) {
                return;
            }
            w.c(this.f47350f.mContext, this.f47349e.getImageResList().get(0).f47274c);
            v.b().d(true);
        }
    }

    /* loaded from: classes12.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCard.a f47351e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f47352f;

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
            this.f47352f = playPicInfoCardView;
            this.f47351e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f47351e.f47270b)) {
                return;
            }
            w.c(this.f47352f.mContext, this.f47351e.f47270b);
        }
    }

    /* loaded from: classes12.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCard.a f47353e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.x1.o.j.a f47354f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f47355g;

        public e(PlayPicInfoCardView playPicInfoCardView, PlayPicInfoCard.a aVar, c.a.t0.x1.o.j.a aVar2) {
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
            this.f47355g = playPicInfoCardView;
            this.f47353e = aVar;
            this.f47354f = aVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f47355g.mContext.getPageActivity())) {
                c.a.t0.x1.m.b a = c.a.t0.x1.m.b.a();
                c.a.t0.x1.o.j.a aVar = this.f47353e.f47272d;
                a.d(aVar, aVar.b());
                ((CommonImageButton) view).updateView(this.f47354f);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f extends c.a.s0.s.i0.u.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public String f47356f;

        /* renamed from: g  reason: collision with root package name */
        public PlayPicInfoCard.b f47357g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f47358h;

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
            this.f47358h = playPicInfoCardView;
        }

        @Override // c.a.s0.s.i0.u.d.a
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f47356f : (String) invokeV.objValue;
        }

        @Override // c.a.s0.s.i0.u.d.a
        public Object d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f47357g : invokeV.objValue;
        }

        public void e(PlayPicInfoCard.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
                this.f47356f = bVar.f47273b;
                this.f47357g = bVar;
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
                this.f47346k.setVisibility(8);
            } else if (showDot == 1) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f47346k.getLayoutParams();
                layoutParams.gravity = 85;
                this.f47346k.setLayoutParams(layoutParams);
                this.f47346k.setVisibility(0);
            } else if (showDot != 2) {
                this.f47346k.setVisibility(8);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f47346k.getLayoutParams();
                layoutParams2.gravity = 81;
                this.f47346k.setLayoutParams(layoutParams2);
                this.f47346k.setVisibility(0);
            }
        }
    }

    public final void g(PlayPicInfoCard.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            if (bVar == null) {
                SkinManager.setViewTextColor(this.f47345j, R.color.CAM_X0101);
            } else {
                setTextColor(this.f47345j, bVar.f47276e, bVar.f47277f, R.color.CAM_X0101);
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

    public final void i(TextView textView, TbImageView tbImageView, c.a.t0.x1.o.j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, textView, tbImageView, bVar) == null) {
            String str = isNightMode() ? bVar.f25937b : bVar.a;
            if (!TextUtils.isEmpty(str)) {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                tbImageView.setVisibility(0);
                tbImageView.startLoad(str, 10, false);
            } else {
                tbImageView.setVisibility(8);
                textView.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(c.a.t0.x1.o.f.a(bVar.f25938c)), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            textView.setText(bVar.f25939d);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View initLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.card_play_pic_info, (ViewGroup) null);
            this.f47341f = inflate;
            this.mBannerFlowView = (BannerFlowView) findViewById(inflate, R.id.banner);
            if (this.mContext.getOrignalPage() instanceof SwipeBackLayout.c) {
                this.mBannerFlowView.setSwipeControlInterface((SwipeBackLayout.c) this.mContext.getOrignalPage());
            }
            this.mBannerFlowView.setDisableParentEvent(false);
            this.mBannerFlowView.setMaxScrollCountLimit(100);
            this.l = (TbImageView) findViewById(this.f47341f, R.id.float_icon);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mBannerFlowView.getLayoutParams();
            layoutParams.height = (int) ((c.a.d.f.p.n.k(getContext()) * 0.5f) + 0.5f);
            this.mBannerFlowView.setLayoutParams(layoutParams);
            this.f47344i = (TextView) findViewById(this.f47341f, R.id.title_bottom);
            this.f47343h = (LinearLayout) findViewById(this.f47341f, R.id.ll_bottom);
            this.f47345j = (TextView) findViewById(this.f47341f, R.id.title_on);
            this.f47346k = (IndicatorView) findViewById(this.f47341f, R.id.indicator);
            this.f47342g = (TextView) findViewById(this.f47341f, R.id.title_top);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(this.f47341f, R.id.bottom_relative_layout);
            this.m = relativeLayout;
            this.n = (TextView) findViewById(relativeLayout, R.id.forum_name);
            this.o = (TbImageView) findViewById(this.m, R.id.icon);
            this.p = (TextView) findViewById(this.m, R.id.text);
            this.q = (CommonImageButton) findViewById(this.m, R.id.notice_button);
            return this.f47341f;
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
                c.a.t0.x1.o.j.b bVar = bottomInfo.f47271c;
                if (bVar != null) {
                    i(this.p, this.o, bVar);
                }
                if (bottomInfo.f47272d != null) {
                    this.q.setVisibility(0);
                    c.a.d.f.p.n.b(this.mContext.getPageActivity(), this.q, 20, 20, 20, 20);
                    c.a.t0.x1.o.j.a aVar = bottomInfo.f47272d;
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
            String str = isNightMode() ? waterMark.f47281b : waterMark.a;
            ((RelativeLayout.LayoutParams) this.l.getLayoutParams()).setMargins(c.a.d.f.p.n.d(this.mContext.getPageActivity(), waterMark.f47282c), c.a.d.f.p.n.d(this.mContext.getPageActivity(), waterMark.f47283d), 0, 0);
            this.l.startLoad(str, 10, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onChangeSkinType(PlayPicInfoCard playPicInfoCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, playPicInfoCard, i2) == null) {
            c.a.s0.x0.a.a(this.mContext, getRootView());
            SkinManager.setBackgroundResource(this.f47341f, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f47342g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f47344i, R.color.CAM_X0105);
            this.f47346k.setSelector(SkinManager.getDrawable(R.drawable.dot_live_s));
            this.f47346k.setDrawable(SkinManager.getDrawable(R.drawable.dot_live_n));
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
            this.f47342g.setMaxLines(playPicInfoCard.getMaxLineForToptitle());
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
                this.mBannerFlowView.setDescOnPic(playPicInfoCard.getDescOnPic() == 1, !TextUtils.isEmpty(playPicInfoCard.getImageResList().get(0).f47275d));
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
                this.f47345j.setVisibility(8);
                if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 1) {
                    this.f47344i.setMaxWidth(((c.a.d.f.p.n.k(getContext()) - c.a.d.f.p.n.f(getContext(), R.dimen.ds24)) - c.a.d.f.p.n.f(getContext(), R.dimen.ds20)) - (c.a.d.f.p.n.f(getContext(), R.dimen.ds24) * playPicInfoCard.getImageResList().size()));
                    this.f47344i.setText(playPicInfoCard.getImageResList().get(0).f47275d);
                    this.f47346k.setVisibility(0);
                    this.f47346k.setCount(playPicInfoCard.getImageResList().size());
                    setIndicatorViewPosition(playPicInfoCard);
                    this.f47343h.setVisibility(0);
                    this.f47342g.setVisibility(8);
                } else if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() == 1) {
                    if (playPicInfoCard.getDescOnPic() == 2) {
                        this.f47342g.setText(playPicInfoCard.getImageResList().get(0).f47275d);
                        this.f47342g.setVisibility(0);
                        this.f47343h.setVisibility(8);
                    } else {
                        this.f47343h.setVisibility(0);
                        this.f47344i.setMaxWidth(c.a.d.f.p.n.k(getContext()) - c.a.d.f.p.n.f(getContext(), R.dimen.ds24));
                        this.f47344i.setText(playPicInfoCard.getImageResList().get(0).f47275d);
                        this.f47342g.setVisibility(8);
                        this.f47346k.setVisibility(8);
                    }
                }
            } else {
                if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
                    this.f47345j.setVisibility(0);
                    if (playPicInfoCard.getImageResList().size() > 1) {
                        this.f47345j.setMaxWidth(((c.a.d.f.p.n.k(getContext()) - c.a.d.f.p.n.f(getContext(), R.dimen.ds24)) - c.a.d.f.p.n.f(getContext(), R.dimen.ds20)) - (c.a.d.f.p.n.f(getContext(), R.dimen.ds24) * playPicInfoCard.getImageResList().size()));
                    } else {
                        this.f47345j.setMaxWidth(c.a.d.f.p.n.k(getContext()) - c.a.d.f.p.n.f(getContext(), R.dimen.ds24));
                    }
                    this.f47345j.setText(playPicInfoCard.getImageResList().get(0).f47275d);
                    g(playPicInfoCard.getImageResList().get(0));
                } else {
                    this.f47345j.setVisibility(8);
                }
                this.f47342g.setVisibility(8);
                this.f47343h.setVisibility(8);
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
