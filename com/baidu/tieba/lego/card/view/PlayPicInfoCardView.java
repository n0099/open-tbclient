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
import c.a.d.o.e.n;
import c.a.o0.r.l0.u.b;
import c.a.p0.a4.x;
import c.a.p0.b2.i;
import c.a.p0.b2.t.a;
import c.a.p0.h0.u;
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
/* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class a implements b.a<c.a.o0.r.l0.u.d.a, a.C0949a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PlayPicInfoCard a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f34257b;

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
            this.f34257b = playPicInfoCardView;
            this.a = playPicInfoCard;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.r.l0.u.b.a
        /* renamed from: b */
        public void a(a.C0949a c0949a, c.a.o0.r.l0.u.d.a aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0949a, aVar) == null) && (aVar.b() instanceof PlayPicInfoCard.b)) {
                PlayPicInfoCard.b bVar = (PlayPicInfoCard.b) aVar.b();
                if (TextUtils.isEmpty(bVar.f34231c)) {
                    return;
                }
                u.b().d(true);
                c.a.p0.b2.e f2 = i.f(bVar.i, bVar.f34235g, this.a.getCardType(), this.a.getItemId());
                f2.d("obj_id", bVar.a);
                f2.d(TiebaStatic.Params.OBJ_URL, bVar.f34231c);
                f2.b("obj_locate", this.f34257b.getStatPosition());
                f2.a(this.a);
                x.c(this.f34257b.i, bVar.f34231c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BannerFlowView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PlayPicInfoCard a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f34258b;

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
            this.f34258b = playPicInfoCardView;
            this.a = playPicInfoCard;
        }

        @Override // c.a.p0.b2.o.l.k
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.getDescOnPic() == 1) {
                return;
            }
            this.f34258b.s.setCount(i);
        }

        @Override // c.a.p0.b2.o.l.k
        public void b(float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) || this.a.getDescOnPic() == 1) {
                return;
            }
            this.f34258b.s.setPosition(f2);
        }

        @Override // com.baidu.tieba.lego.view.BannerFlowView.c
        public void onPageSelected(int i) {
            List<PlayPicInfoCard.b> imageResList;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || (imageResList = this.a.getImageResList()) == null || imageResList.size() <= i) {
                return;
            }
            if (this.a.getDescOnPic() != 1) {
                this.f34258b.r.setVisibility(8);
                if (!TextUtils.isEmpty(imageResList.get(i).f34232d)) {
                    this.f34258b.q.setText(imageResList.get(i).f34232d);
                    return;
                } else {
                    this.f34258b.p.setVisibility(8);
                    return;
                }
            }
            if (!TextUtils.isEmpty(imageResList.get(i).f34232d)) {
                this.f34258b.r.setText(imageResList.get(i).f34232d);
                this.f34258b.G(imageResList.get(i));
                this.f34258b.r.setVisibility(0);
            } else {
                this.f34258b.r.setVisibility(8);
            }
            BannerFlowView bannerFlowView = this.f34258b.m;
            if (bannerFlowView != null) {
                bannerFlowView.setDescOnPic(true, !TextUtils.isEmpty(imageResList.get(i).f34232d));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PlayPicInfoCard a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f34259b;

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
            this.f34259b = playPicInfoCardView;
            this.a = playPicInfoCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.getImageResList().get(0) == null) {
                return;
            }
            x.c(this.f34259b.i, this.a.getImageResList().get(0).f34231c);
            u.b().d(true);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PlayPicInfoCard.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f34260b;

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
            this.f34260b = playPicInfoCardView;
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.a.f34227b)) {
                return;
            }
            x.c(this.f34260b.i, this.a.f34227b);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PlayPicInfoCard.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.b2.o.j.a f34261b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f34262c;

        public e(PlayPicInfoCardView playPicInfoCardView, PlayPicInfoCard.a aVar, c.a.p0.b2.o.j.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playPicInfoCardView, aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34262c = playPicInfoCardView;
            this.a = aVar;
            this.f34261b = aVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f34262c.i.getPageActivity())) {
                c.a.p0.b2.m.b a = c.a.p0.b2.m.b.a();
                c.a.p0.b2.o.j.a aVar = this.a.f34229d;
                a.d(aVar, aVar.b());
                ((CommonImageButton) view).b(this.f34261b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends c.a.o0.r.l0.u.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public String f34263b;

        /* renamed from: c  reason: collision with root package name */
        public PlayPicInfoCard.b f34264c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCardView f34265d;

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
            this.f34265d = playPicInfoCardView;
        }

        @Override // c.a.o0.r.l0.u.d.a
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34263b : (String) invokeV.objValue;
        }

        @Override // c.a.o0.r.l0.u.d.a
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34264c : invokeV.objValue;
        }

        public void e(PlayPicInfoCard.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
                this.f34263b = bVar.f34230b;
                this.f34264c = bVar;
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

    private void setIndicatorViewPosition(PlayPicInfoCard playPicInfoCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, playPicInfoCard) == null) {
            int showDot = playPicInfoCard.getShowDot();
            if (showDot == 0) {
                this.s.setVisibility(8);
            } else if (showDot == 1) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.s.getLayoutParams();
                layoutParams.gravity = 85;
                this.s.setLayoutParams(layoutParams);
                this.s.setVisibility(0);
            } else if (showDot != 2) {
                this.s.setVisibility(8);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.s.getLayoutParams();
                layoutParams2.gravity = 81;
                this.s.setLayoutParams(layoutParams2);
                this.s.setVisibility(0);
            }
        }
    }

    public final void G(PlayPicInfoCard.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            if (bVar == null) {
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0101);
            } else {
                y(this.r, bVar.f34233e, bVar.f34234f, R.color.CAM_X0101);
            }
        }
    }

    public final List<n> H(PlayPicInfoCard playPicInfoCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, playPicInfoCard)) == null) {
            ArrayList arrayList = new ArrayList();
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() != 0) {
                int size = playPicInfoCard.getImageResList().size();
                for (int i = 0; i < size; i++) {
                    f fVar = new f(this);
                    fVar.e(playPicInfoCard.getImageResList().get(i));
                    arrayList.add(fVar);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void I(TextView textView, TbImageView tbImageView, c.a.p0.b2.o.j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, textView, tbImageView, bVar) == null) {
            String str = r() ? bVar.f12518b : bVar.a;
            if (!TextUtils.isEmpty(str)) {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                tbImageView.setVisibility(0);
                tbImageView.J(str, 10, false);
            } else {
                tbImageView.setVisibility(8);
                textView.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(c.a.p0.b2.o.f.a(bVar.f12519c)), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            textView.setText(bVar.f12520d);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: J */
    public void t(PlayPicInfoCard playPicInfoCard, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, playPicInfoCard, i) == null) {
            c.a.o0.w0.a.a(this.i, getRootView());
            SkinManager.setBackgroundResource(this.n, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0105);
            this.s.setSelector(SkinManager.getDrawable(R.drawable.dot_live_s));
            this.s.setDrawable(SkinManager.getDrawable(R.drawable.dot_live_n));
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0111);
            SkinManager.setBackgroundResource(this.v, R.drawable.label_bg_tie_n);
            SkinManager.setViewTextColor(this.x, (int) R.color.CAM_X0110);
            G(null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: K */
    public void u(PlayPicInfoCard playPicInfoCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, playPicInfoCard) == null) {
            this.o.setMaxLines(playPicInfoCard.getMaxLineForToptitle());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            if (playPicInfoCard.getRatio() > 0.0d) {
                int ratio = (int) (playPicInfoCard.getRatio() * c.a.d.f.p.n.k(getContext()));
                if (Math.abs(ratio - layoutParams.height) > 10) {
                    layoutParams.height = ratio;
                    this.m.setLayoutParams(layoutParams);
                }
            } else {
                layoutParams.height = (int) ((c.a.d.f.p.n.k(getContext()) * 0.5f) + 0.5f);
                this.m.setLayoutParams(layoutParams);
            }
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
                this.m.setDescOnPic(playPicInfoCard.getDescOnPic() == 1, !TextUtils.isEmpty(playPicInfoCard.getImageResList().get(0).f34232d));
            } else {
                this.m.setDescOnPic(playPicInfoCard.getDescOnPic() == 1, false);
            }
            if (playPicInfoCard.getDuration() >= 5000) {
                this.m.setAutoScrollIntervalTime(playPicInfoCard.getDuration());
            } else {
                this.m.setAutoScrollIntervalTime(5000L);
            }
            this.m.setData(H(playPicInfoCard));
            if (playPicInfoCard.getDescOnPic() != 1) {
                this.r.setVisibility(8);
                if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 1) {
                    this.q.setMaxWidth(((c.a.d.f.p.n.k(getContext()) - c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f0701e8)) - c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f0701d5)) - (c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f0701e8) * playPicInfoCard.getImageResList().size()));
                    this.q.setText(playPicInfoCard.getImageResList().get(0).f34232d);
                    this.s.setVisibility(0);
                    this.s.setCount(playPicInfoCard.getImageResList().size());
                    setIndicatorViewPosition(playPicInfoCard);
                    this.p.setVisibility(0);
                    this.o.setVisibility(8);
                } else if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() == 1) {
                    if (playPicInfoCard.getDescOnPic() == 2) {
                        this.o.setText(playPicInfoCard.getImageResList().get(0).f34232d);
                        this.o.setVisibility(0);
                        this.p.setVisibility(8);
                    } else {
                        this.p.setVisibility(0);
                        this.q.setMaxWidth(c.a.d.f.p.n.k(getContext()) - c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f0701e8));
                        this.q.setText(playPicInfoCard.getImageResList().get(0).f34232d);
                        this.o.setVisibility(8);
                        this.s.setVisibility(8);
                    }
                }
            } else {
                if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
                    this.r.setVisibility(0);
                    if (playPicInfoCard.getImageResList().size() > 1) {
                        this.r.setMaxWidth(((c.a.d.f.p.n.k(getContext()) - c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f0701e8)) - c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f0701d5)) - (c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f0701e8) * playPicInfoCard.getImageResList().size()));
                    } else {
                        this.r.setMaxWidth(c.a.d.f.p.n.k(getContext()) - c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f0701e8));
                    }
                    this.r.setText(playPicInfoCard.getImageResList().get(0).f34232d);
                    G(playPicInfoCard.getImageResList().get(0));
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
            L(playPicInfoCard);
            M(playPicInfoCard);
            this.m.setIndicatorViewPosition(playPicInfoCard.getShowDot());
        }
    }

    public final void L(PlayPicInfoCard playPicInfoCard) {
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
                c.a.p0.b2.o.j.b bVar = bottomInfo.f34228c;
                if (bVar != null) {
                    I(this.x, this.w, bVar);
                }
                if (bottomInfo.f34229d != null) {
                    this.y.setVisibility(0);
                    c.a.d.f.p.n.b(this.i.getPageActivity(), this.y, 20, 20, 20, 20);
                    c.a.p0.b2.o.j.a aVar = bottomInfo.f34229d;
                    this.y.b(aVar);
                    this.y.setOnClickListener(new e(this, bottomInfo, aVar));
                    return;
                }
                this.y.setVisibility(8);
                return;
            }
            this.u.setVisibility(8);
        }
    }

    public final void M(PlayPicInfoCard playPicInfoCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, playPicInfoCard) == null) {
            PlayPicInfoCard.c waterMark = playPicInfoCard.getWaterMark();
            if (waterMark == null) {
                this.t.setVisibility(8);
                return;
            }
            this.t.setVisibility(0);
            String str = r() ? waterMark.f34237b : waterMark.a;
            ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).setMargins(c.a.d.f.p.n.d(this.i.getPageActivity(), waterMark.f34238c), c.a.d.f.p.n.d(this.i.getPageActivity(), waterMark.f34239d), 0, 0);
            this.t.J(str, 10, false);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            View inflate = LayoutInflater.from(this.i.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01b4, (ViewGroup) null);
            this.n = inflate;
            this.m = (BannerFlowView) l(inflate, R.id.obfuscated_res_0x7f0902f6);
            if (this.i.getOrignalPage() instanceof SwipeBackLayout.c) {
                this.m.setSwipeControlInterface((SwipeBackLayout.c) this.i.getOrignalPage());
            }
            this.m.setDisableParentEvent(false);
            this.m.setMaxScrollCountLimit(100);
            this.t = (TbImageView) l(this.n, R.id.obfuscated_res_0x7f0909c7);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams.height = (int) ((c.a.d.f.p.n.k(getContext()) * 0.5f) + 0.5f);
            this.m.setLayoutParams(layoutParams);
            this.q = (TextView) l(this.n, R.id.obfuscated_res_0x7f092038);
            this.p = (LinearLayout) l(this.n, R.id.obfuscated_res_0x7f0912e5);
            this.r = (TextView) l(this.n, R.id.obfuscated_res_0x7f09204f);
            this.s = (IndicatorView) l(this.n, R.id.obfuscated_res_0x7f090ef1);
            this.o = (TextView) l(this.n, R.id.obfuscated_res_0x7f09205d);
            RelativeLayout relativeLayout = (RelativeLayout) l(this.n, R.id.obfuscated_res_0x7f0903d7);
            this.u = relativeLayout;
            this.v = (TextView) l(relativeLayout, R.id.obfuscated_res_0x7f090a67);
            this.w = (TbImageView) l(this.u, R.id.obfuscated_res_0x7f090e06);
            this.x = (TextView) l(this.u, R.id.obfuscated_res_0x7f091f1b);
            this.y = (CommonImageButton) l(this.u, R.id.obfuscated_res_0x7f0915bd);
            return this.n;
        }
        return (View) invokeV.objValue;
    }
}
