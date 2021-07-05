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
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.r0.r.f0.t.b;
import d.a.s0.a0.t;
import d.a.s0.h3.v;
import d.a.s0.n1.i;
import d.a.s0.n1.t.a;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes5.dex */
public class PlayPicInfoCardView extends BaseCardView<PlayPicInfoCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TbImageView B;
    public TextView C;
    public CommonImageButton D;
    public BannerFlowView r;
    public View s;
    public TextView t;
    public LinearLayout u;
    public TextView v;
    public TextView w;
    public IndicatorView x;
    public TbImageView y;
    public RelativeLayout z;

    /* loaded from: classes5.dex */
    public class a implements b.a<d.a.r0.r.f0.t.d.a, a.C1611a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCard f18216a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f18217b;

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
            this.f18217b = playPicInfoCardView;
            this.f18216a = playPicInfoCard;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.r.f0.t.b.a
        /* renamed from: b */
        public void a(a.C1611a c1611a, d.a.r0.r.f0.t.d.a aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1611a, aVar) == null) && (aVar.c() instanceof PlayPicInfoCard.b)) {
                PlayPicInfoCard.b bVar = (PlayPicInfoCard.b) aVar.c();
                if (TextUtils.isEmpty(bVar.f18179c)) {
                    return;
                }
                t.b().d(true);
                d.a.s0.n1.e f2 = i.f(bVar.f18185i, bVar.f18183g, this.f18216a.getCardType(), this.f18216a.getItemId());
                f2.d("obj_id", bVar.f18177a);
                f2.d(TiebaStatic.Params.OBJ_URL, bVar.f18179c);
                f2.b("obj_locate", this.f18217b.getStatPosition());
                f2.a(this.f18216a);
                v.c(this.f18217b.m, bVar.f18179c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BannerFlowView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCard f18218a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f18219b;

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
            this.f18219b = playPicInfoCardView;
            this.f18218a = playPicInfoCard;
        }

        @Override // d.a.s0.n1.o.l.l
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f18218a.getDescOnPic() == 1) {
                return;
            }
            this.f18219b.x.setCount(i2);
        }

        @Override // d.a.s0.n1.o.l.l
        public void b(float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) || this.f18218a.getDescOnPic() == 1) {
                return;
            }
            this.f18219b.x.setPosition(f2);
        }

        @Override // com.baidu.tieba.lego.view.BannerFlowView.c
        public void onPageSelected(int i2) {
            List<PlayPicInfoCard.b> imageResList;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (imageResList = this.f18218a.getImageResList()) == null || imageResList.size() <= i2) {
                return;
            }
            if (this.f18218a.getDescOnPic() != 1) {
                this.f18219b.w.setVisibility(8);
                if (!TextUtils.isEmpty(imageResList.get(i2).f18180d)) {
                    this.f18219b.v.setText(imageResList.get(i2).f18180d);
                    return;
                } else {
                    this.f18219b.u.setVisibility(8);
                    return;
                }
            }
            if (!TextUtils.isEmpty(imageResList.get(i2).f18180d)) {
                this.f18219b.w.setText(imageResList.get(i2).f18180d);
                this.f18219b.L(imageResList.get(i2));
                this.f18219b.w.setVisibility(0);
            } else {
                this.f18219b.w.setVisibility(8);
            }
            BannerFlowView bannerFlowView = this.f18219b.r;
            if (bannerFlowView != null) {
                bannerFlowView.setDescOnPic(true, !TextUtils.isEmpty(imageResList.get(i2).f18180d));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCard f18220e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f18221f;

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
            this.f18221f = playPicInfoCardView;
            this.f18220e = playPicInfoCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f18220e.getImageResList().get(0) == null) {
                return;
            }
            v.c(this.f18221f.m, this.f18220e.getImageResList().get(0).f18179c);
            t.b().d(true);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCard.a f18222e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f18223f;

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
            this.f18223f = playPicInfoCardView;
            this.f18222e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f18222e.f18174b)) {
                return;
            }
            v.c(this.f18223f.m, this.f18222e.f18174b);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCard.a f18224e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.n1.o.j.a f18225f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f18226g;

        public e(PlayPicInfoCardView playPicInfoCardView, PlayPicInfoCard.a aVar, d.a.s0.n1.o.j.a aVar2) {
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
            this.f18226g = playPicInfoCardView;
            this.f18224e = aVar;
            this.f18225f = aVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f18226g.m.getPageActivity())) {
                d.a.s0.n1.m.b a2 = d.a.s0.n1.m.b.a();
                d.a.s0.n1.o.j.a aVar = this.f18224e.f18176d;
                a2.d(aVar, aVar.b());
                ((CommonImageButton) view).b(this.f18225f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends d.a.r0.r.f0.t.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public String f18227f;

        /* renamed from: g  reason: collision with root package name */
        public PlayPicInfoCard.b f18228g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f18229h;

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
            this.f18229h = playPicInfoCardView;
        }

        @Override // d.a.r0.r.f0.t.d.a
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18227f : (String) invokeV.objValue;
        }

        @Override // d.a.r0.r.f0.t.d.a
        public Object c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18228g : invokeV.objValue;
        }

        public void d(PlayPicInfoCard.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
                this.f18227f = bVar.f18178b;
                this.f18228g = bVar;
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
                this.x.setVisibility(8);
            } else if (showDot == 1) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.x.getLayoutParams();
                layoutParams.gravity = 85;
                this.x.setLayoutParams(layoutParams);
                this.x.setVisibility(0);
            } else if (showDot != 2) {
                this.x.setVisibility(8);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.x.getLayoutParams();
                layoutParams2.gravity = 81;
                this.x.setLayoutParams(layoutParams2);
                this.x.setVisibility(0);
            }
        }
    }

    public final void L(PlayPicInfoCard.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            if (bVar == null) {
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0101);
            } else {
                A(this.w, bVar.f18181e, bVar.f18182f, R.color.CAM_X0101);
            }
        }
    }

    public final List<n> M(PlayPicInfoCard playPicInfoCard) {
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

    public final void N(TextView textView, TbImageView tbImageView, d.a.s0.n1.o.j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, textView, tbImageView, bVar) == null) {
            String str = t() ? bVar.f63805b : bVar.f63804a;
            if (!TextUtils.isEmpty(str)) {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                tbImageView.setVisibility(0);
                tbImageView.M(str, 10, false);
            } else {
                tbImageView.setVisibility(8);
                textView.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(d.a.s0.n1.o.f.a(bVar.f63806c)), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            textView.setText(bVar.f63807d);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: O */
    public void v(PlayPicInfoCard playPicInfoCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, playPicInfoCard, i2) == null) {
            d.a.r0.s0.a.a(this.m, getRootView());
            SkinManager.setBackgroundResource(this.s, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0105);
            this.x.setSelector(SkinManager.getDrawable(R.drawable.dot_live_s));
            this.x.setDrawable(SkinManager.getDrawable(R.drawable.dot_live_n));
            SkinManager.setViewTextColor(this.A, R.color.CAM_X0111);
            SkinManager.setBackgroundResource(this.A, R.drawable.label_bg_tie_n);
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0110);
            L(null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: P */
    public void w(PlayPicInfoCard playPicInfoCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, playPicInfoCard) == null) {
            this.t.setMaxLines(playPicInfoCard.getMaxLineForToptitle());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
            if (playPicInfoCard.getRatio() > 0.0d) {
                int ratio = (int) (playPicInfoCard.getRatio() * l.k(getContext()));
                if (Math.abs(ratio - layoutParams.height) > 10) {
                    layoutParams.height = ratio;
                    this.r.setLayoutParams(layoutParams);
                }
            } else {
                layoutParams.height = (int) ((l.k(getContext()) * 0.5f) + 0.5f);
                this.r.setLayoutParams(layoutParams);
            }
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
                this.r.setDescOnPic(playPicInfoCard.getDescOnPic() == 1, !TextUtils.isEmpty(playPicInfoCard.getImageResList().get(0).f18180d));
            } else {
                this.r.setDescOnPic(playPicInfoCard.getDescOnPic() == 1, false);
            }
            if (playPicInfoCard.getDuration() >= 5000) {
                this.r.setAutoScrollIntervalTime(playPicInfoCard.getDuration());
            } else {
                this.r.setAutoScrollIntervalTime(5000L);
            }
            this.r.setData(M(playPicInfoCard));
            if (playPicInfoCard.getDescOnPic() != 1) {
                this.w.setVisibility(8);
                if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 1) {
                    this.v.setMaxWidth(((l.k(getContext()) - l.g(getContext(), R.dimen.ds24)) - l.g(getContext(), R.dimen.ds20)) - (l.g(getContext(), R.dimen.ds24) * playPicInfoCard.getImageResList().size()));
                    this.v.setText(playPicInfoCard.getImageResList().get(0).f18180d);
                    this.x.setVisibility(0);
                    this.x.setCount(playPicInfoCard.getImageResList().size());
                    setIndicatorViewPosition(playPicInfoCard);
                    this.u.setVisibility(0);
                    this.t.setVisibility(8);
                } else if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() == 1) {
                    if (playPicInfoCard.getDescOnPic() == 2) {
                        this.t.setText(playPicInfoCard.getImageResList().get(0).f18180d);
                        this.t.setVisibility(0);
                        this.u.setVisibility(8);
                    } else {
                        this.u.setVisibility(0);
                        this.v.setMaxWidth(l.k(getContext()) - l.g(getContext(), R.dimen.ds24));
                        this.v.setText(playPicInfoCard.getImageResList().get(0).f18180d);
                        this.t.setVisibility(8);
                        this.x.setVisibility(8);
                    }
                }
            } else {
                if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
                    this.w.setVisibility(0);
                    if (playPicInfoCard.getImageResList().size() > 1) {
                        this.w.setMaxWidth(((l.k(getContext()) - l.g(getContext(), R.dimen.ds24)) - l.g(getContext(), R.dimen.ds20)) - (l.g(getContext(), R.dimen.ds24) * playPicInfoCard.getImageResList().size()));
                    } else {
                        this.w.setMaxWidth(l.k(getContext()) - l.g(getContext(), R.dimen.ds24));
                    }
                    this.w.setText(playPicInfoCard.getImageResList().get(0).f18180d);
                    L(playPicInfoCard.getImageResList().get(0));
                } else {
                    this.w.setVisibility(8);
                }
                this.t.setVisibility(8);
                this.u.setVisibility(8);
            }
            this.r.setOnItemClickListener(new a(this, playPicInfoCard));
            this.r.setOnPageSelected(new b(this, playPicInfoCard));
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() == 1) {
                setCardOnClickListener(new c(this, playPicInfoCard));
            } else {
                setCardOnClickListener(null);
            }
            Q(playPicInfoCard);
            R(playPicInfoCard);
            this.r.setIndicatorViewPosition(playPicInfoCard.getShowDot());
        }
    }

    public final void Q(PlayPicInfoCard playPicInfoCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, playPicInfoCard) == null) {
            PlayPicInfoCard.a bottomInfo = playPicInfoCard.getBottomInfo();
            if (bottomInfo != null && bottomInfo.b()) {
                this.z.setVisibility(0);
                if (TextUtils.isEmpty(bottomInfo.f18173a)) {
                    this.A.setVisibility(8);
                } else {
                    this.A.setVisibility(0);
                    this.A.setText(bottomInfo.f18173a);
                    this.A.setOnClickListener(new d(this, bottomInfo));
                }
                d.a.s0.n1.o.j.b bVar = bottomInfo.f18175c;
                if (bVar != null) {
                    N(this.C, this.B, bVar);
                }
                if (bottomInfo.f18176d != null) {
                    this.D.setVisibility(0);
                    l.c(this.m.getPageActivity(), this.D, 20, 20, 20, 20);
                    d.a.s0.n1.o.j.a aVar = bottomInfo.f18176d;
                    this.D.b(aVar);
                    this.D.setOnClickListener(new e(this, bottomInfo, aVar));
                    return;
                }
                this.D.setVisibility(8);
                return;
            }
            this.z.setVisibility(8);
        }
    }

    public final void R(PlayPicInfoCard playPicInfoCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, playPicInfoCard) == null) {
            PlayPicInfoCard.c waterMark = playPicInfoCard.getWaterMark();
            if (waterMark == null) {
                this.y.setVisibility(8);
                return;
            }
            this.y.setVisibility(0);
            String str = t() ? waterMark.f18187b : waterMark.f18186a;
            ((RelativeLayout.LayoutParams) this.y.getLayoutParams()).setMargins(l.e(this.m.getPageActivity(), waterMark.f18188c), l.e(this.m.getPageActivity(), waterMark.f18189d), 0, 0);
            this.y.M(str, 10, false);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            View inflate = LayoutInflater.from(this.m.getPageActivity()).inflate(R.layout.card_play_pic_info, (ViewGroup) null);
            this.s = inflate;
            this.r = (BannerFlowView) n(inflate, R.id.banner);
            if (this.m.getOrignalPage() instanceof SwipeBackLayout.c) {
                this.r.setSwipeControlInterface((SwipeBackLayout.c) this.m.getOrignalPage());
            }
            this.r.setDisableParentEvent(false);
            this.r.setMaxScrollCountLimit(100);
            this.y = (TbImageView) n(this.s, R.id.float_icon);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
            layoutParams.height = (int) ((l.k(getContext()) * 0.5f) + 0.5f);
            this.r.setLayoutParams(layoutParams);
            this.v = (TextView) n(this.s, R.id.title_bottom);
            this.u = (LinearLayout) n(this.s, R.id.ll_bottom);
            this.w = (TextView) n(this.s, R.id.title_on);
            this.x = (IndicatorView) n(this.s, R.id.indicator);
            this.t = (TextView) n(this.s, R.id.title_top);
            RelativeLayout relativeLayout = (RelativeLayout) n(this.s, R.id.bottom_relative_layout);
            this.z = relativeLayout;
            this.A = (TextView) n(relativeLayout, R.id.forum_name);
            this.B = (TbImageView) n(this.z, R.id.icon);
            this.C = (TextView) n(this.z, R.id.text);
            this.D = (CommonImageButton) n(this.z, R.id.notice_button);
            return this.s;
        }
        return (View) invokeV.objValue;
    }
}
