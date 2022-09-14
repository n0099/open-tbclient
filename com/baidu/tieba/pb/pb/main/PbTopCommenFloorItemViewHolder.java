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
import com.baidu.tieba.cx7;
import com.baidu.tieba.qz7;
import com.baidu.tieba.rq4;
import com.baidu.tieba.sj5;
import com.baidu.tieba.uu4;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public LinearLayout N;
    public TextView O;
    public View P;
    public TextView Q;
    public ImageView R;
    public LinearLayout S;
    public LinearLayout T;
    public TextView U;
    public PbFloorComplaint V;
    public Boolean W;
    public ImageView X;
    public TBLottieAnimationView Y;
    public ViewGroup Z;
    public int a;
    public AgreeView a0;
    public View b;
    public ImageView b0;
    public boolean c;
    public ViewGroup c0;
    public View d;
    public TextView d0;
    public View e;
    public TextView e0;
    public LinearLayout f;
    public FrameLayout f0;
    public TextView g;
    public qz7 g0;
    public TextView h;
    public FrameLayout h0;
    public TextView i;
    public VirtualImageStatusTip i0;
    public TbImageView j;
    public HeadCustomImageView j0;
    public TextView k;
    public FrameLayout k0;
    public TextView l;
    public LinearLayout l0;
    public TextView m;
    public RelativeLayout m0;
    public TextView n;
    public RelativeLayout n0;
    public TextView o;
    public RelativeLayout o0;
    public HeadImageView p;
    public TextView p0;
    public TbRichTextView q;
    public TextView q0;
    public RelativeLayout r;
    public TextView r0;
    public TbAlphaVideo s;
    public ConstrainImageGroup t;
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
                this.a.Y.playAnimation();
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
        this.W = Boolean.FALSE;
        if (tbPageContext == null || view2 == null) {
            return;
        }
        this.b = view2;
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f09229b);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f0903e8);
        this.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091826);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925d2);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925d3);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925a0);
        this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925ca);
        this.H = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e28);
        this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925be);
        this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923f9);
        this.u = view2.findViewById(R.id.obfuscated_res_0x7f091812);
        this.v = view2.findViewById(R.id.obfuscated_res_0x7f09180f);
        this.w = view2.findViewById(R.id.obfuscated_res_0x7f091805);
        this.x = view2.findViewById(R.id.obfuscated_res_0x7f091803);
        this.y = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091810);
        this.C = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091811);
        this.D = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091806);
        this.E = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091807);
        AgreeView agreeView = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091804);
        this.F = agreeView;
        agreeView.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.F.setNormalColorResourceId(R.color.CAM_X0109);
        this.F.u(true);
        this.z = view2.findViewById(R.id.obfuscated_res_0x7f09186c);
        this.A = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a41);
        this.B = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a42);
        this.r0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923ff);
        RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c66);
        this.n0 = relativeLayout;
        uu4 d = uu4.d(relativeLayout);
        d.n(R.string.J_X04);
        d.f(R.color.CAM_X0204);
        RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c4f);
        this.o0 = relativeLayout2;
        uu4 d2 = uu4.d(relativeLayout2);
        d2.n(R.string.J_X07);
        d2.f(R.color.CAM_X0905);
        this.p0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09238b);
        this.q0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923dd);
        this.u.setVisibility(8);
        this.z.setVisibility(8);
        this.A.setVisibility(0);
        this.B.setVisibility(0);
        this.L = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091809);
        rq4 rq4Var = new rq4();
        rq4Var.b = 5;
        rq4Var.h = 8;
        rq4Var.g = 2;
        rq4Var.f = i;
        this.p = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0916fa);
        HeadPendantView headPendantView = (HeadPendantView) view2.findViewById(R.id.obfuscated_res_0x7f0918c3);
        this.I = headPendantView;
        headPendantView.setHasPendantStyle();
        if (this.I.getHeadView() != null) {
            this.I.getHeadView().setIsRound(true);
            this.I.getHeadView().setDrawBorder(true);
            this.I.getHeadView().setPlaceHolder(1);
        }
        this.J = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f091ec4);
        this.K = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f091ec5);
        this.q = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091c1b);
        this.r = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a4b);
        this.s = (TbAlphaVideo) view2.findViewById(R.id.obfuscated_res_0x7f09014e);
        this.t = (ConstrainImageGroup) view2.findViewById(R.id.obfuscated_res_0x7f090a0b);
        this.G = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a0d);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919fe);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919ff);
        this.t.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
        this.t.setSingleImageRatio(0.75d);
        this.t.setImageProcessor(new sj5(3));
        cx7 cx7Var = new cx7(this.q.getLayoutStrategy());
        cx7Var.o(TbConfig.getPostLineSpace(), 1.0f);
        this.q.setLayoutStrategy(cx7Var);
        this.q.setIsNeedResizeEmotion(true);
        this.q.setTextSize(TbConfig.getContentSize());
        this.p.setIsRound(true);
        this.p.setGodIconWidth(R.dimen.tbds36);
        this.p.setPlaceHolder(1);
        this.q.setDisplayImage(this.c, false);
        this.q.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d0906);
        this.M = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091835);
        this.N = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091868);
        this.O = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091869);
        this.P = view2.findViewById(R.id.obfuscated_res_0x7f091867);
        this.Q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09186a);
        this.R = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091866);
        this.S = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09026c);
        this.T = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a25);
        this.U = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a26);
        this.X = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0919c8);
        this.V = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f091808);
        if (this.W.booleanValue()) {
            this.V.setVisibility(0);
        } else {
            this.V.setVisibility(8);
        }
        this.Y = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f0924b2);
        this.Z = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f09180e);
        this.a0 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f09180c);
        this.b0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09180d);
        this.a0.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.a0.setNormalColorResourceId(R.color.CAM_X0109);
        this.a0.u(false);
        this.a0.setAgreeAlone(true);
        this.a0.setStatisticData(rq4Var);
        this.c0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f09186e);
        this.d0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925cb);
        this.e0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090457);
        this.f0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09245b);
        qz7 qz7Var = new qz7(tbPageContext, this.f0);
        this.g0 = qz7Var;
        qz7Var.f = 3;
        this.h0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09248c);
        this.i0 = (VirtualImageStatusTip) view2.findViewById(R.id.obfuscated_res_0x7f092608);
        this.j0 = (HeadCustomImageView) view2.findViewById(R.id.obfuscated_res_0x7f0925f1);
        this.k0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0925f2);
        this.l0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e23);
        this.m0 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c68);
        this.j = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917e8);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g0.e();
            PbFloorComplaint pbFloorComplaint = this.V;
            if (pbFloorComplaint != null) {
                pbFloorComplaint.setBackgroundColor(R.color.CAM_X0206);
                uu4 d = uu4.d(this.V);
                d.m(0);
                d.n(R.string.J_X05);
                d.f(R.color.CAM_X0206);
                this.V.b();
            }
        }
    }

    public void c(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (tBLottieAnimationView = this.Y) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.Y.setVisibility(0);
                if (this.Y.isAnimating()) {
                    return;
                }
                this.Y.setSpeed(0.8f);
                this.Y.setRepeatCount(-1);
                this.Y.post(new a(this));
                return;
            }
            this.Y.setVisibility(8);
            if (this.Y.isAnimating()) {
                this.Y.cancelAnimation();
            }
        }
    }

    public void e(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.g0.g(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.S.getLayoutParams();
            if (z) {
                this.f0.setVisibility(0);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f09245b);
            } else {
                this.f0.setVisibility(8);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f090fa9);
            }
            this.S.setLayoutParams(layoutParams);
            b();
        }
    }
}
