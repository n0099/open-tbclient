package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadCustomImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.by7;
import com.baidu.tieba.fj;
import com.baidu.tieba.gr4;
import com.baidu.tieba.mk5;
import com.baidu.tieba.nv4;
import com.baidu.tieba.p08;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes5.dex */
public class PbTopCommenFloorItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public ImageView B;
    public ImageView C;
    public TextView D;
    public ImageView E;
    public TextView F;
    public AgreeView G;
    public TextView H;
    public ImageView I;
    public HeadPendantView J;
    public UserIconBox K;
    public UserIconBox L;
    public ImageView M;
    public TextView N;
    public SimpleDraweeView O;
    public LinearLayout P;
    public LinearLayout Q;
    public TextView R;
    public View S;
    public TextView T;
    public ImageView U;
    public LinearLayout V;
    public LinearLayout W;
    public TextView X;
    public PbFloorComplaint Y;
    public Boolean Z;
    public int a;
    public ImageView a0;
    public RelativeLayout b;
    public TBLottieAnimationView b0;
    public View c;
    public ViewGroup c0;
    public boolean d;
    public AgreeView d0;
    public View e;
    public ImageView e0;
    public View f;
    public ViewGroup f0;
    public LinearLayout g;
    public TextView g0;
    public TextView h;
    public TextView h0;
    public TextView i;
    public FrameLayout i0;
    public TextView j;
    public p08 j0;
    public TbImageView k;
    public FrameLayout k0;
    public TextView l;
    public VirtualImageStatusTip l0;
    public TextView m;
    public HeadCustomImageView m0;
    public TextView n;
    public FrameLayout n0;
    public TextView o;
    public LinearLayout o0;
    public TextView p;
    public RelativeLayout p0;
    public HeadImageView q;
    public RelativeLayout q0;
    public TbRichTextView r;
    public RelativeLayout r0;
    public RelativeLayout s;
    public TextView s0;
    public TbAlphaVideo t;
    public TextView t0;
    public ConstrainImageGroup u;
    public TextView u0;
    public View v;
    public TBLottieAnimationView v0;
    public View w;
    public View x;
    public View y;
    public ImageView z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;

        public a(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbTopCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbTopCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b0.playAnimation();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbTopCommenFloorItemViewHolder(TbPageContext tbPageContext, View view2, int i) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, Integer.valueOf(i)};
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
        this.d = true;
        this.Z = Boolean.FALSE;
        if (tbPageContext != null && view2 != null) {
            this.c = view2;
            this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917fe);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f092288);
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f0903f0);
            this.g = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09181a);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925bd);
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925be);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09258d);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925b5);
            this.I = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e1b);
            this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925a9);
            this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923e7);
            this.v = view2.findViewById(R.id.obfuscated_res_0x7f091806);
            this.w = view2.findViewById(R.id.obfuscated_res_0x7f091803);
            this.x = view2.findViewById(R.id.obfuscated_res_0x7f0917f9);
            this.y = view2.findViewById(R.id.obfuscated_res_0x7f0917f7);
            this.z = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091804);
            this.D = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091805);
            this.E = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917fa);
            this.F = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917fb);
            AgreeView agreeView = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f0917f8);
            this.G = agreeView;
            agreeView.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.G.setNormalColorResourceId(R.color.CAM_X0109);
            this.G.u(true);
            this.A = view2.findViewById(R.id.obfuscated_res_0x7f091860);
            this.B = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a3f);
            this.C = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a40);
            this.u0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923ed);
            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c65);
            this.q0 = relativeLayout;
            nv4 d = nv4.d(relativeLayout);
            d.n(R.string.J_X04);
            d.f(R.color.CAM_X0204);
            RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c4e);
            this.r0 = relativeLayout2;
            nv4 d2 = nv4.d(relativeLayout2);
            d2.n(R.string.J_X07);
            d2.f(R.color.CAM_X0905);
            this.s0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092379);
            this.t0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923cb);
            this.v.setVisibility(8);
            this.A.setVisibility(8);
            this.B.setVisibility(0);
            this.C.setVisibility(0);
            this.M = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917fd);
            gr4 gr4Var = new gr4();
            gr4Var.b = 5;
            gr4Var.h = 8;
            gr4Var.g = 2;
            gr4Var.f = i;
            this.q = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0916ec);
            HeadPendantView headPendantView = (HeadPendantView) view2.findViewById(R.id.obfuscated_res_0x7f0918b8);
            this.J = headPendantView;
            headPendantView.setHasPendantStyle();
            if (this.J.getHeadView() != null) {
                this.J.getHeadView().setIsRound(true);
                this.J.getHeadView().setDrawBorder(true);
                this.J.getHeadView().setPlaceHolder(1);
            }
            this.K = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f091ec6);
            this.L = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f091ec7);
            this.r = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091c1a);
            this.s = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a49);
            this.t = (TbAlphaVideo) view2.findViewById(R.id.obfuscated_res_0x7f09014e);
            this.u = (ConstrainImageGroup) view2.findViewById(R.id.obfuscated_res_0x7f090a15);
            this.H = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a17);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919fc);
            this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919fd);
            this.u.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
            this.u.setSingleImageRatio(0.75d);
            this.u.setImageProcessor(new mk5(3));
            by7 by7Var = new by7(this.r.getLayoutStrategy());
            by7Var.o(TbConfig.getPostLineSpace(), 1.0f);
            this.r.setLayoutStrategy(by7Var);
            this.r.setIsNeedResizeEmotion(true);
            this.r.setTextSize(TbConfig.getContentSize());
            this.q.setIsRound(true);
            this.q.setGodIconWidth(R.dimen.tbds36);
            this.q.setPlaceHolder(1);
            this.r.setDisplayImage(this.d, false);
            this.r.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d0907);
            this.N = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091829);
            this.O = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f0917f4);
            this.P = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917f3);
            this.Q = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09185c);
            this.R = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09185d);
            this.S = view2.findViewById(R.id.obfuscated_res_0x7f09185b);
            this.T = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09185e);
            this.U = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09185a);
            this.V = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09026c);
            this.W = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a2f);
            this.X = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a30);
            this.a0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0919c6);
            this.Y = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f0917fc);
            if (this.Z.booleanValue()) {
                this.Y.setVisibility(0);
            } else {
                this.Y.setVisibility(8);
            }
            this.b0 = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f09249f);
            this.c0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091802);
            this.d0 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091800);
            this.e0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091801);
            this.d0.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.d0.setNormalColorResourceId(R.color.CAM_X0109);
            this.d0.u(false);
            this.d0.setAgreeAlone(true);
            this.d0.setStatisticData(gr4Var);
            this.f0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091862);
            this.g0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925b6);
            this.h0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090460);
            this.i0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092448);
            p08 p08Var = new p08(tbPageContext, this.i0);
            this.j0 = p08Var;
            p08Var.f = 3;
            this.k0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092479);
            this.l0 = (VirtualImageStatusTip) view2.findViewById(R.id.obfuscated_res_0x7f0925f3);
            this.m0 = (HeadCustomImageView) view2.findViewById(R.id.obfuscated_res_0x7f0925dc);
            this.n0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0925dd);
            this.o0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e22);
            this.p0 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c67);
            this.k = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917da);
            e(tbPageContext);
        }
    }

    public void c(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (tBLottieAnimationView = this.b0) != null) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.j0.e();
            PbFloorComplaint pbFloorComplaint = this.Y;
            if (pbFloorComplaint != null) {
                pbFloorComplaint.setBackgroundColor(R.color.CAM_X0206);
                nv4 d = nv4.d(this.Y);
                d.m(0);
                d.n(R.string.J_X05);
                d.f(R.color.CAM_X0206);
                this.Y.b();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.v0 != null) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                this.v0.setImageAssetsFolder("lottie_reactions_guide_left_img");
            } else {
                this.v0.setImageAssetsFolder("lottie_reactions_guide_left_img_dark");
            }
            SkinManager.setLottieAnimation(this.v0, R.raw.obfuscated_res_0x7f11004c);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.b0.setVisibility(0);
                if (!this.b0.isAnimating()) {
                    this.b0.setSpeed(0.8f);
                    this.b0.setRepeatCount(-1);
                    this.b0.post(new a(this));
                    return;
                }
                return;
            }
            this.b0.setVisibility(8);
            if (this.b0.isAnimating()) {
                this.b0.cancelAnimation();
            }
        }
    }

    public final void e(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbPageContext) == null) {
            this.v0 = new TBLottieAnimationView(tbPageContext.getPageActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(fj.f(tbPageContext.getPageActivity(), R.dimen.tbds650), fj.f(tbPageContext.getPageActivity(), R.dimen.tbds100));
            layoutParams.setMargins(fj.f(tbPageContext.getPageActivity(), R.dimen.tbds90), 0, 0, fj.f(tbPageContext.getPageActivity(), R.dimen.tbds10));
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f090f9d);
            this.b.addView(this.v0, layoutParams);
            f();
            this.v0.setVisibility(8);
        }
    }

    public void g(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.j0.g(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.V.getLayoutParams();
            if (z) {
                this.i0.setVisibility(0);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f092448);
            } else {
                this.i0.setVisibility(8);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f090f9d);
            }
            this.V.setLayoutParams(layoutParams);
            b();
        }
    }
}
