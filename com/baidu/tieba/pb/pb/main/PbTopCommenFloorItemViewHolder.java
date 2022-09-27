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
import com.baidu.tieba.e08;
import com.baidu.tieba.er4;
import com.baidu.tieba.fk5;
import com.baidu.tieba.hv4;
import com.baidu.tieba.qx7;
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
    public ImageView A;
    public ImageView B;
    public TextView C;
    public ImageView D;
    public TextView E;
    public AgreeView F;
    public TextView G;
    public ImageView H;
    public HeadPendantView I;
    public UserIconBox J;
    public UserIconBox K;
    public ImageView L;
    public TextView M;
    public SimpleDraweeView N;
    public LinearLayout O;
    public LinearLayout P;
    public TextView Q;
    public View R;
    public TextView S;
    public ImageView T;
    public LinearLayout U;
    public LinearLayout V;
    public TextView W;
    public PbFloorComplaint X;
    public Boolean Y;
    public ImageView Z;
    public int a;
    public TBLottieAnimationView a0;
    public View b;
    public ViewGroup b0;
    public boolean c;
    public AgreeView c0;
    public View d;
    public ImageView d0;
    public View e;
    public ViewGroup e0;
    public LinearLayout f;
    public TextView f0;
    public TextView g;
    public TextView g0;
    public TextView h;
    public FrameLayout h0;
    public TextView i;
    public e08 i0;
    public TbImageView j;
    public FrameLayout j0;
    public TextView k;
    public VirtualImageStatusTip k0;
    public TextView l;
    public HeadCustomImageView l0;
    public TextView m;
    public FrameLayout m0;
    public TextView n;
    public LinearLayout n0;
    public TextView o;
    public RelativeLayout o0;
    public HeadImageView p;
    public RelativeLayout p0;
    public TbRichTextView q;
    public RelativeLayout q0;
    public RelativeLayout r;
    public TextView r0;
    public TbAlphaVideo s;
    public TextView s0;
    public ConstrainImageGroup t;
    public TextView t0;
    public View u;
    public View v;
    public View w;
    public View x;
    public ImageView y;
    public View z;

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
                this.a.a0.playAnimation();
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
        this.c = true;
        this.Y = Boolean.FALSE;
        if (tbPageContext == null || view2 == null) {
            return;
        }
        this.b = view2;
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f09229d);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f0903e8);
        this.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091828);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925d4);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925d5);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925a2);
        this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925cc);
        this.H = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e27);
        this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925c0);
        this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923fb);
        this.u = view2.findViewById(R.id.obfuscated_res_0x7f091814);
        this.v = view2.findViewById(R.id.obfuscated_res_0x7f091811);
        this.w = view2.findViewById(R.id.obfuscated_res_0x7f091807);
        this.x = view2.findViewById(R.id.obfuscated_res_0x7f091805);
        this.y = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091812);
        this.C = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091813);
        this.D = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091808);
        this.E = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091809);
        AgreeView agreeView = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091806);
        this.F = agreeView;
        agreeView.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.F.setNormalColorResourceId(R.color.CAM_X0109);
        this.F.u(true);
        this.z = view2.findViewById(R.id.obfuscated_res_0x7f09186e);
        this.A = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a43);
        this.B = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a44);
        this.t0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092401);
        RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c68);
        this.p0 = relativeLayout;
        hv4 d = hv4.d(relativeLayout);
        d.n(R.string.J_X04);
        d.f(R.color.CAM_X0204);
        RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c51);
        this.q0 = relativeLayout2;
        hv4 d2 = hv4.d(relativeLayout2);
        d2.n(R.string.J_X07);
        d2.f(R.color.CAM_X0905);
        this.r0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09238d);
        this.s0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923df);
        this.u.setVisibility(8);
        this.z.setVisibility(8);
        this.A.setVisibility(0);
        this.B.setVisibility(0);
        this.L = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09180b);
        er4 er4Var = new er4();
        er4Var.b = 5;
        er4Var.h = 8;
        er4Var.g = 2;
        er4Var.f = i;
        this.p = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0916fa);
        HeadPendantView headPendantView = (HeadPendantView) view2.findViewById(R.id.obfuscated_res_0x7f0918c5);
        this.I = headPendantView;
        headPendantView.setHasPendantStyle();
        if (this.I.getHeadView() != null) {
            this.I.getHeadView().setIsRound(true);
            this.I.getHeadView().setDrawBorder(true);
            this.I.getHeadView().setPlaceHolder(1);
        }
        this.J = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f091ec6);
        this.K = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f091ec7);
        this.q = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091c1d);
        this.r = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a4d);
        this.s = (TbAlphaVideo) view2.findViewById(R.id.obfuscated_res_0x7f09014e);
        this.t = (ConstrainImageGroup) view2.findViewById(R.id.obfuscated_res_0x7f090a0b);
        this.G = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a0d);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a00);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a01);
        this.t.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
        this.t.setSingleImageRatio(0.75d);
        this.t.setImageProcessor(new fk5(3));
        qx7 qx7Var = new qx7(this.q.getLayoutStrategy());
        qx7Var.o(TbConfig.getPostLineSpace(), 1.0f);
        this.q.setLayoutStrategy(qx7Var);
        this.q.setIsNeedResizeEmotion(true);
        this.q.setTextSize(TbConfig.getContentSize());
        this.p.setIsRound(true);
        this.p.setGodIconWidth(R.dimen.tbds36);
        this.p.setPlaceHolder(1);
        this.q.setDisplayImage(this.c, false);
        this.q.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d0906);
        this.M = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091837);
        this.N = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f091802);
        this.O = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091801);
        this.P = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09186a);
        this.Q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09186b);
        this.R = view2.findViewById(R.id.obfuscated_res_0x7f091869);
        this.S = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09186c);
        this.T = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091868);
        this.U = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09026c);
        this.V = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a25);
        this.W = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a26);
        this.Z = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0919ca);
        this.X = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f09180a);
        if (this.Y.booleanValue()) {
            this.X.setVisibility(0);
        } else {
            this.X.setVisibility(8);
        }
        this.a0 = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f0924b4);
        this.b0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091810);
        this.c0 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f09180e);
        this.d0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09180f);
        this.c0.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.c0.setNormalColorResourceId(R.color.CAM_X0109);
        this.c0.u(false);
        this.c0.setAgreeAlone(true);
        this.c0.setStatisticData(er4Var);
        this.e0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091870);
        this.f0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925cd);
        this.g0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090457);
        this.h0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09245d);
        e08 e08Var = new e08(tbPageContext, this.h0);
        this.i0 = e08Var;
        e08Var.f = 3;
        this.j0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09248e);
        this.k0 = (VirtualImageStatusTip) view2.findViewById(R.id.obfuscated_res_0x7f09260a);
        this.l0 = (HeadCustomImageView) view2.findViewById(R.id.obfuscated_res_0x7f0925f3);
        this.m0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0925f4);
        this.n0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e25);
        this.o0 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c6a);
        this.j = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917e8);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.i0.e();
            PbFloorComplaint pbFloorComplaint = this.X;
            if (pbFloorComplaint != null) {
                pbFloorComplaint.setBackgroundColor(R.color.CAM_X0206);
                hv4 d = hv4.d(this.X);
                d.m(0);
                d.n(R.string.J_X05);
                d.f(R.color.CAM_X0206);
                this.X.b();
            }
        }
    }

    public void c(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (tBLottieAnimationView = this.a0) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.a0.setVisibility(0);
                if (this.a0.isAnimating()) {
                    return;
                }
                this.a0.setSpeed(0.8f);
                this.a0.setRepeatCount(-1);
                this.a0.post(new a(this));
                return;
            }
            this.a0.setVisibility(8);
            if (this.a0.isAnimating()) {
                this.a0.cancelAnimation();
            }
        }
    }

    public void e(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.i0.g(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.U.getLayoutParams();
            if (z) {
                this.h0.setVisibility(0);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f09245d);
            } else {
                this.h0.setVisibility(8);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f090fa9);
            }
            this.U.setLayoutParams(layoutParams);
            b();
        }
    }
}
