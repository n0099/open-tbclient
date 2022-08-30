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
import com.baidu.tieba.kh5;
import com.baidu.tieba.ly7;
import com.baidu.tieba.no4;
import com.baidu.tieba.os4;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.tieba.yv7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PbTopCommenFloorItemViewHolder extends TypeAdapter.ViewHolder {
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
    public TextView K;
    public LinearLayout L;
    public TextView M;
    public View N;
    public TextView O;
    public ImageView P;
    public LinearLayout Q;
    public LinearLayout R;
    public TextView S;
    public PbFloorComplaint T;
    public Boolean U;
    public ImageView V;
    public TBLottieAnimationView W;
    public ViewGroup X;
    public AgreeView Y;
    public ImageView Z;
    public int a;
    public ViewGroup a0;
    public View b;
    public TextView b0;
    public boolean c;
    public TextView c0;
    public View d;
    public FrameLayout d0;
    public View e;
    public ly7 e0;
    public LinearLayout f;
    public FrameLayout f0;
    public TextView g;
    public VirtualImageStatusTip g0;
    public TextView h;
    public HeadCustomImageView h0;
    public TextView i;
    public FrameLayout i0;
    public TbImageView j;
    public LinearLayout j0;
    public TextView k;
    public RelativeLayout k0;
    public TextView l;
    public RelativeLayout l0;
    public TextView m;
    public RelativeLayout m0;
    public TextView n;
    public TextView n0;
    public TextView o;
    public TextView o0;
    public HeadImageView p;
    public TextView p0;
    public TbRichTextView q;
    public ConstrainImageGroup r;
    public View s;
    public View t;
    public View u;
    public View v;
    public ImageView w;
    public View x;
    public ImageView y;
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
                this.a.W.playAnimation();
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
        this.U = Boolean.FALSE;
        if (tbPageContext == null || view2 == null) {
            return;
        }
        this.b = view2;
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f092247);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f0903dc);
        this.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917f0);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092576);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092577);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092544);
        this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09256e);
        this.F = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e0d);
        this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092562);
        this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923a0);
        this.s = view2.findViewById(R.id.obfuscated_res_0x7f0917dc);
        this.t = view2.findViewById(R.id.obfuscated_res_0x7f0917d9);
        this.u = view2.findViewById(R.id.obfuscated_res_0x7f0917cf);
        this.v = view2.findViewById(R.id.obfuscated_res_0x7f0917cd);
        this.w = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917da);
        this.A = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917db);
        this.B = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917d0);
        this.C = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917d1);
        AgreeView agreeView = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f0917ce);
        this.D = agreeView;
        agreeView.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.D.setNormalColorResourceId(R.color.CAM_X0109);
        this.D.u(true);
        this.x = view2.findViewById(R.id.obfuscated_res_0x7f091836);
        this.y = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a03);
        this.z = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a04);
        this.p0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923a6);
        RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c1a);
        this.l0 = relativeLayout;
        os4 d = os4.d(relativeLayout);
        d.n(R.string.J_X04);
        d.f(R.color.CAM_X0204);
        RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c08);
        this.m0 = relativeLayout2;
        os4 d2 = os4.d(relativeLayout2);
        d2.n(R.string.J_X07);
        d2.f(R.color.CAM_X0905);
        this.n0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092333);
        this.o0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092384);
        this.s.setVisibility(8);
        this.x.setVisibility(8);
        this.y.setVisibility(0);
        this.z.setVisibility(0);
        this.J = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917d3);
        no4 no4Var = new no4();
        no4Var.b = 5;
        no4Var.h = 8;
        no4Var.g = 2;
        no4Var.f = i;
        this.p = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0916c5);
        HeadPendantView headPendantView = (HeadPendantView) view2.findViewById(R.id.obfuscated_res_0x7f09188d);
        this.G = headPendantView;
        headPendantView.setHasPendantStyle();
        if (this.G.getHeadView() != null) {
            this.G.getHeadView().setIsRound(true);
            this.G.getHeadView().setDrawBorder(true);
            this.G.getHeadView().setPlaceHolder(1);
        }
        this.H = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f091e74);
        this.I = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f091e75);
        this.q = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091bd4);
        this.r = (ConstrainImageGroup) view2.findViewById(R.id.obfuscated_res_0x7f0909f1);
        this.E = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0909f3);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919c0);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919c1);
        this.r.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
        this.r.setSingleImageRatio(0.75d);
        this.r.setImageProcessor(new kh5(3));
        yv7 yv7Var = new yv7(this.q.getLayoutStrategy());
        yv7Var.o(TbConfig.getPostLineSpace(), 1.0f);
        this.q.setLayoutStrategy(yv7Var);
        this.q.setIsNeedResizeEmotion(true);
        this.q.setTextSize(TbConfig.getContentSize());
        this.p.setIsRound(true);
        this.p.setGodIconWidth(R.dimen.tbds36);
        this.p.setPlaceHolder(1);
        this.q.setDisplayImage(this.c, false);
        this.q.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d08e7);
        this.K = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917ff);
        this.L = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091832);
        this.M = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091833);
        this.N = view2.findViewById(R.id.obfuscated_res_0x7f091831);
        this.O = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091834);
        this.P = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091830);
        this.Q = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090265);
        this.R = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a0b);
        this.S = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a0c);
        this.V = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09198b);
        this.T = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f0917d2);
        if (this.U.booleanValue()) {
            this.T.setVisibility(0);
        } else {
            this.T.setVisibility(8);
        }
        this.W = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f092457);
        this.X = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f0917d8);
        this.Y = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f0917d6);
        this.Z = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917d7);
        this.Y.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.Y.setNormalColorResourceId(R.color.CAM_X0109);
        this.Y.u(false);
        this.Y.setAgreeAlone(true);
        this.Y.setStatisticData(no4Var);
        this.a0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091838);
        this.b0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09256f);
        this.c0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090449);
        FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092401);
        this.d0 = frameLayout;
        ly7 ly7Var = new ly7(tbPageContext, frameLayout);
        this.e0 = ly7Var;
        ly7Var.f = 3;
        this.f0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092431);
        this.g0 = (VirtualImageStatusTip) view2.findViewById(R.id.obfuscated_res_0x7f0925ac);
        this.h0 = (HeadCustomImageView) view2.findViewById(R.id.obfuscated_res_0x7f092595);
        this.i0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092596);
        this.j0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091dd4);
        this.k0 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c1b);
        this.j = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917b3);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e0.d();
            PbFloorComplaint pbFloorComplaint = this.T;
            if (pbFloorComplaint != null) {
                pbFloorComplaint.setBackgroundColor(R.color.CAM_X0206);
                os4 d = os4.d(this.T);
                d.m(0);
                d.n(R.string.J_X05);
                d.f(R.color.CAM_X0206);
                this.T.b();
            }
        }
    }

    public void c(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (tBLottieAnimationView = this.W) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.W.setVisibility(0);
                if (this.W.isAnimating()) {
                    return;
                }
                this.W.setSpeed(0.8f);
                this.W.setRepeatCount(-1);
                this.W.post(new a(this));
                return;
            }
            this.W.setVisibility(8);
            if (this.W.isAnimating()) {
                this.W.cancelAnimation();
            }
        }
    }

    public void e(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.e0.f(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Q.getLayoutParams();
            if (z) {
                this.d0.setVisibility(0);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f092401);
            } else {
                this.d0.setVisibility(8);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f090f8e);
            }
            this.Q.setLayoutParams(layoutParams);
            b();
        }
    }
}
