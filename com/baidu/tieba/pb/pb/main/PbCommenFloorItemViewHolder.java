package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.o0.r.r.f;
import c.a.o0.r.v.c;
import c.a.p0.w2.m.f.h;
import c.a.p0.w2.m.f.i1.g;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PbCommenFloorItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public ImageView B;
    public TextView C;
    public AgreeView D;
    public TextView E;
    public ImageView F;
    public HeadPendantView G;
    public UserIconBox H;
    public UserIconBox I;
    public ImageView J;
    public View K;
    public TextView L;
    public LinearLayout M;
    public TextView N;
    public View O;
    public TextView P;
    public ImageView Q;
    public LinearLayout R;
    public LinearLayout S;
    public TextView T;
    public PbFloorComplaint U;
    public Boolean V;
    public ImageView W;
    public int X;
    public int Y;
    public TBLottieAnimationView Z;
    public int a;
    public ViewGroup a0;

    /* renamed from: b  reason: collision with root package name */
    public View f34870b;
    public AgreeView b0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34871c;
    public ImageView c0;

    /* renamed from: d  reason: collision with root package name */
    public View f34872d;
    public ViewGroup d0;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f34873e;
    public TextView e0;

    /* renamed from: f  reason: collision with root package name */
    public TextView f34874f;
    public TextView f0;

    /* renamed from: g  reason: collision with root package name */
    public TextView f34875g;
    public ImageView g0;

    /* renamed from: h  reason: collision with root package name */
    public TextView f34876h;
    public FrameLayout h0;
    public TextView i;
    public MaskView i0;
    public TextView j;
    public g j0;
    public TextView k;
    public AgreeView l;
    public HeadImageView m;
    public TbRichTextView n;
    public ConstrainImageGroup o;
    public View p;
    public SubPbLayout q;
    public TextView r;
    public TextView s;
    public ImageView t;
    public ImageView u;
    public View v;
    public View w;
    public View x;
    public View y;
    public ImageView z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.Z.playAnimation();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbCommenFloorItemViewHolder(TbPageContext tbPageContext, View view, int i) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.f34871c = true;
        this.V = Boolean.FALSE;
        this.X = -1;
        if (tbPageContext == null || view == null) {
            return;
        }
        this.f34870b = view;
        this.f34872d = view.findViewById(R.id.obfuscated_res_0x7f0920b2);
        this.f34873e = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0916d0);
        this.f34874f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0923e0);
        this.f34875g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0923ab);
        this.f34876h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0923d7);
        this.F = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090e17);
        this.k = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0923cb);
        this.p = view.findViewById(R.id.obfuscated_res_0x7f091714);
        this.t = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0918b2);
        this.u = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0918b3);
        AgreeView agreeView = (AgreeView) view.findViewById(R.id.obfuscated_res_0x7f09154e);
        this.l = agreeView;
        agreeView.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.l.setNormalColorResourceId(R.color.CAM_X0109);
        this.l.i(false);
        this.v = view.findViewById(R.id.obfuscated_res_0x7f0916bd);
        this.w = view.findViewById(R.id.obfuscated_res_0x7f0916ba);
        this.x = view.findViewById(R.id.obfuscated_res_0x7f0916b0);
        this.y = view.findViewById(R.id.obfuscated_res_0x7f0916ae);
        this.z = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0916bb);
        this.A = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0916bc);
        this.B = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0916b1);
        this.C = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0916b2);
        AgreeView agreeView2 = (AgreeView) view.findViewById(R.id.obfuscated_res_0x7f0916af);
        this.D = agreeView2;
        agreeView2.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.D.setNormalColorResourceId(R.color.CAM_X0109);
        this.D.i(true);
        this.v.setVisibility(8);
        this.p.setVisibility(0);
        this.t.setVisibility(0);
        this.u.setVisibility(0);
        this.l.setVisibility(0);
        this.J = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0916b4);
        this.Y = i;
        f fVar = new f();
        fVar.f10852b = 5;
        fVar.f10858h = 8;
        fVar.f10857g = 2;
        fVar.f10856f = i;
        this.l.setStatisticData(fVar);
        this.m = (HeadImageView) view.findViewById(R.id.obfuscated_res_0x7f0915b7);
        HeadPendantView headPendantView = (HeadPendantView) view.findViewById(R.id.obfuscated_res_0x7f091761);
        this.G = headPendantView;
        headPendantView.setHasPendantStyle();
        if (this.G.getHeadView() != null) {
            this.G.getHeadView().setIsRound(true);
            this.G.getHeadView().setDrawBorder(true);
            this.G.getHeadView().setPlaceHolder(1);
        }
        this.H = (UserIconBox) view.findViewById(R.id.obfuscated_res_0x7f091cf5);
        this.I = (UserIconBox) view.findViewById(R.id.obfuscated_res_0x7f091cf6);
        this.n = (TbRichTextView) view.findViewById(R.id.obfuscated_res_0x7f091a8a);
        this.q = (SubPbLayout) view.findViewById(R.id.obfuscated_res_0x7f09170b);
        this.r = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091715);
        this.r.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0107), null), (Drawable) null);
        this.r.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        this.r.setTextSize(0, n.f(TbadkCoreApplication.getInst(), R.dimen.T_X07));
        this.s = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091713);
        this.o = (ConstrainImageGroup) view.findViewById(R.id.obfuscated_res_0x7f0909dd);
        this.K = view.findViewById(R.id.obfuscated_res_0x7f09168e);
        this.E = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0909de);
        this.i = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091870);
        this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091871);
        this.o.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
        this.o.setSingleImageRatio(0.75d);
        this.o.setImageProcessor(new c.a.o0.e1.j.f(3));
        h hVar = new h(this.n.getLayoutStrategy());
        hVar.j(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        hVar.o(TbConfig.getPostLineSpace(), 1.0f);
        this.n.setLayoutStrategy(hVar);
        this.n.setIsNeedResizeEmotion(true);
        this.n.setTextSize(TbConfig.getContentSize());
        this.m.setIsRound(true);
        this.m.setGodIconWidth(R.dimen.tbds36);
        this.m.setPlaceHolder(1);
        this.n.setDisplayImage(this.f34871c, false);
        this.n.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d08b2);
        this.L = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0916de);
        this.M = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f091710);
        this.N = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091711);
        this.O = view.findViewById(R.id.obfuscated_res_0x7f09170f);
        this.P = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091712);
        this.Q = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f09170e);
        this.R = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f09025e);
        this.S = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0909f5);
        this.T = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0909f6);
        this.W = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f091832);
        this.U = (PbFloorComplaint) view.findViewById(R.id.obfuscated_res_0x7f0916b3);
        if (this.V.booleanValue()) {
            this.U.setVisibility(0);
        } else {
            this.U.setVisibility(8);
        }
        this.Z = (TBLottieAnimationView) view.findViewById(R.id.obfuscated_res_0x7f0922b9);
        this.a0 = (ViewGroup) view.findViewById(R.id.obfuscated_res_0x7f0916b9);
        this.b0 = (AgreeView) view.findViewById(R.id.obfuscated_res_0x7f0916b7);
        this.c0 = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0916b8);
        this.b0.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.b0.setNormalColorResourceId(R.color.CAM_X0109);
        this.b0.i(false);
        this.b0.setAgreeAlone(true);
        this.b0.setStatisticData(fVar);
        this.d0 = (ViewGroup) view.findViewById(R.id.obfuscated_res_0x7f091716);
        this.e0 = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0923d8);
        this.f0 = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090434);
        this.g0 = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f09170d);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.obfuscated_res_0x7f09225e);
        this.h0 = frameLayout;
        g gVar = new g(tbPageContext, frameLayout);
        this.j0 = gVar;
        gVar.f20109f = 3;
        this.i0 = (MaskView) view.findViewById(R.id.obfuscated_res_0x7f0913b6);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.j0.d();
            MaskView maskView = this.i0;
            if (maskView != null) {
                maskView.f();
            }
            PbFloorComplaint pbFloorComplaint = this.U;
            if (pbFloorComplaint != null) {
                pbFloorComplaint.setBackgroundColor(R.color.CAM_X0206);
                c d2 = c.d(this.U);
                d2.m(0);
                d2.n(R.string.J_X05);
                d2.f(R.color.CAM_X0206);
                this.U.b();
            }
        }
    }

    public void e(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (tBLottieAnimationView = this.Z) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.Z.setVisibility(0);
                if (this.Z.isAnimating()) {
                    return;
                }
                this.Z.setSpeed(0.8f);
                this.Z.setRepeatCount(-1);
                this.Z.post(new a(this));
                return;
            }
            this.Z.setVisibility(8);
            if (this.Z.isAnimating()) {
                this.Z.cancelAnimation();
            }
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && z) {
            f fVar = new f();
            fVar.f10852b = 12;
            fVar.f10858h = 9;
            fVar.f10857g = 3;
            fVar.f10856f = this.Y;
            this.l.setStatisticData(fVar);
        }
    }

    public void h(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.j0.f(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.R.getLayoutParams();
            if (z) {
                this.h0.setVisibility(0);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f09225e);
            } else {
                this.h0.setVisibility(8);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f090f76);
            }
            this.R.setLayoutParams(layoutParams);
            MaskView maskView = this.i0;
            if (maskView != null) {
                maskView.setVisibility(8);
            }
            d();
        }
    }
}
