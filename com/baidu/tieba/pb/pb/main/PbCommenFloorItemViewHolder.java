package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.HeadWorldCupFlagLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadCustomImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.cc8;
import com.baidu.tieba.ej;
import com.baidu.tieba.p15;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.se8;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.tieba.vr5;
import com.baidu.tieba.yw4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes5.dex */
public class PbCommenFloorItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public FrameLayout A0;
    public View B;
    public LinearLayout B0;
    public View C;
    public TextView C0;
    public View D;
    public RelativeLayout D0;
    public ImageView E;
    public RelativeLayout E0;
    public TextView F;
    public TextView F0;
    public ImageView G;
    public TBLottieAnimationView G0;
    public TextView H;
    public TbImageView H0;
    public AgreeView I;
    public HeadWorldCupFlagLayout I0;
    public TextView J;
    public ImageView K;
    public HeadPendantView L;
    public UserIconBox M;
    public UserIconBox N;
    public ImageView O;
    public View P;
    public TextView Q;
    public SimpleDraweeView R;
    public LinearLayout S;
    public LinearLayout T;
    public TextView U;
    public View V;
    public TextView W;
    public ImageView X;
    public LinearLayout Y;
    public LinearLayout Z;
    public int a;
    public TextView a0;
    public RelativeLayout b;
    public PbFloorComplaint b0;
    public View c;
    public Boolean c0;
    public boolean d;
    public ImageView d0;
    public View e;
    public TbImageView e0;
    public LinearLayout f;
    public int f0;
    public TextView g;
    public int g0;
    public TextView h;
    public TBLottieAnimationView h0;
    public TextView i;
    public ViewGroup i0;
    public TbImageView j;
    public AgreeView j0;
    public TextView k;
    public ImageView k0;
    public TextView l;
    public ViewGroup l0;
    public TextView m;
    public TextView m0;
    public TextView n;
    public TextView n0;
    public AgreeView o;
    public LinearLayout o0;
    public HeadImageView p;
    public RelativeLayout p0;
    public TbRichTextView q;
    public EMTextView q0;
    public RelativeLayout r;
    public ImageView r0;
    public TbAlphaVideo s;
    public View s0;
    public ConstrainImageGroup t;
    public ImageView t0;
    public View u;
    public FrameLayout u0;
    public SubPbLayout v;
    public MaskView v0;
    public TextView w;
    public se8 w0;
    public TextView x;
    public FrameLayout x0;
    public ImageView y;
    public VirtualImageStatusTip y0;
    public ImageView z;
    public HeadCustomImageView z0;

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
                this.a.h0.playAnimation();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbCommenFloorItemViewHolder(TbPageContext tbPageContext, View view2, int i) {
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
        this.c0 = Boolean.FALSE;
        this.f0 = -1;
        if (tbPageContext != null && view2 != null) {
            this.c = view2;
            this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091987);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f0923e0);
            this.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091936);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09272e);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09272f);
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926fc);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092726);
            this.K = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090efd);
            this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09271a);
            this.u = view2.findViewById(R.id.obfuscated_res_0x7f09197c);
            this.y = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091b5b);
            this.z = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091b5c);
            AgreeView agreeView = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091798);
            this.o = agreeView;
            agreeView.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.o.setNormalColorResourceId(R.color.CAM_X0109);
            this.o.y(false);
            this.A = view2.findViewById(R.id.obfuscated_res_0x7f091922);
            this.B = view2.findViewById(R.id.obfuscated_res_0x7f09191f);
            this.C = view2.findViewById(R.id.obfuscated_res_0x7f091915);
            this.D = view2.findViewById(R.id.obfuscated_res_0x7f091913);
            this.E = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091920);
            this.F = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091921);
            this.G = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091916);
            this.H = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091917);
            AgreeView agreeView2 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091914);
            this.I = agreeView2;
            agreeView2.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.I.setNormalColorResourceId(R.color.CAM_X0109);
            this.I.y(true);
            this.C0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092553);
            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091d8c);
            this.D0 = relativeLayout;
            p15 d = p15.d(relativeLayout);
            d.n(R.string.J_X04);
            d.f(R.color.CAM_X0204);
            RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091d74);
            this.E0 = relativeLayout2;
            p15 d2 = p15.d(relativeLayout2);
            d2.n(R.string.J_X07);
            d2.f(R.color.CAM_X0905);
            this.F0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924d9);
            this.A.setVisibility(8);
            this.u.setVisibility(0);
            this.y.setVisibility(0);
            this.z.setVisibility(0);
            this.o.setVisibility(0);
            this.O = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091919);
            this.g0 = i;
            yw4 yw4Var = new yw4();
            yw4Var.b = 5;
            yw4Var.h = 8;
            yw4Var.g = 2;
            yw4Var.f = i;
            this.o.setStatisticData(yw4Var);
            this.p = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091805);
            HeadPendantView headPendantView = (HeadPendantView) view2.findViewById(R.id.obfuscated_res_0x7f0919d2);
            this.L = headPendantView;
            headPendantView.setHasPendantStyle();
            if (this.L.getHeadView() != null) {
                this.L.getHeadView().setIsRound(true);
                this.L.getHeadView().setDrawBorder(true);
                this.L.getHeadView().setPlaceHolder(1);
            }
            this.M = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f092003);
            this.N = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f092004);
            this.q = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091d3c);
            this.r = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b65);
            this.s = (TbAlphaVideo) view2.findViewById(R.id.obfuscated_res_0x7f09014b);
            this.v = (SubPbLayout) view2.findViewById(R.id.obfuscated_res_0x7f091973);
            this.w = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09197d);
            this.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0107), null), (Drawable) null);
            this.w.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.w.setTextSize(0, ej.g(TbadkCoreApplication.getInst(), R.dimen.T_X07));
            this.x = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09197b);
            this.t = (ConstrainImageGroup) view2.findViewById(R.id.obfuscated_res_0x7f090a9f);
            this.P = view2.findViewById(R.id.obfuscated_res_0x7f0918ea);
            this.J = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090aa1);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b18);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b19);
            this.t.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
            this.t.setSingleImageRatio(0.75d);
            this.t.setImageProcessor(new vr5(3));
            cc8 cc8Var = new cc8(this.q.getLayoutStrategy());
            cc8Var.p(TbConfig.getPostLineSpace(), 1.0f);
            this.q.setLayoutStrategy(cc8Var);
            this.q.setIsNeedResizeEmotion(true);
            this.q.setTextSize(TbConfig.getContentSize());
            this.p.setIsRound(true);
            this.p.setGodIconWidth(R.dimen.tbds36);
            this.p.setPlaceHolder(1);
            this.q.setDisplayImage(this.d, false);
            this.q.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d0941);
            this.Q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091945);
            this.R = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f09190f);
            this.S = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09190e);
            this.T = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091978);
            this.U = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091979);
            this.V = view2.findViewById(R.id.obfuscated_res_0x7f091977);
            this.W = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09197a);
            this.X = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091976);
            this.Y = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090270);
            this.Z = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090ab9);
            this.a0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090aba);
            this.d0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091adf);
            this.e0 = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091ae0);
            this.b0 = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f091918);
            if (this.c0.booleanValue()) {
                this.b0.setVisibility(0);
            } else {
                this.b0.setVisibility(8);
            }
            this.h0 = (TBLottieAnimationView) view2.findViewById(R.id.user_living_lottie);
            this.i0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f09191e);
            this.j0 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f09191c);
            this.k0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09191d);
            this.o0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0907d7);
            this.p0 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0907d4);
            this.q0 = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f0907d9);
            this.r0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0907d8);
            this.s0 = view2.findViewById(R.id.obfuscated_res_0x7f090aa0);
            this.j0.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.j0.setNormalColorResourceId(R.color.CAM_X0109);
            this.j0.y(false);
            this.j0.setAgreeAlone(true);
            this.j0.setStatisticData(yw4Var);
            this.l0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f09197e);
            this.m0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092727);
            this.n0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09046f);
            this.t0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091975);
            this.u0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0925b1);
            se8 se8Var = new se8(tbPageContext, this.u0);
            this.w0 = se8Var;
            se8Var.f = 3;
            this.v0 = (MaskView) view2.findViewById(R.id.obfuscated_res_0x7f0915c6);
            this.x0 = (FrameLayout) view2.findViewById(R.id.user_container);
            this.y0 = (VirtualImageStatusTip) view2.findViewById(R.id.obfuscated_res_0x7f092763);
            this.z0 = (HeadCustomImageView) view2.findViewById(R.id.obfuscated_res_0x7f09274c);
            this.A0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09274d);
            this.B0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091f5a);
            this.j = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0918f5);
            e(tbPageContext);
            this.H0 = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091911);
            this.I0 = (HeadWorldCupFlagLayout) view2.findViewById(R.id.world_cup_flag);
        }
    }

    public void c(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (tBLottieAnimationView = this.h0) != null) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && z) {
            yw4 yw4Var = new yw4();
            yw4Var.b = 12;
            yw4Var.h = 9;
            yw4Var.g = 3;
            yw4Var.f = this.g0;
            this.o.setStatisticData(yw4Var);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.w0.e();
            MaskView maskView = this.v0;
            if (maskView != null) {
                maskView.f();
            }
            PbFloorComplaint pbFloorComplaint = this.b0;
            if (pbFloorComplaint != null) {
                pbFloorComplaint.setBackgroundColor(R.color.CAM_X0206);
                p15 d = p15.d(this.b0);
                d.m(0);
                d.n(R.string.J_X05);
                d.f(R.color.CAM_X0206);
                this.b0.b();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.G0 != null) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                this.G0.setImageAssetsFolder("lottie_reactions_guide_left_img");
            } else {
                this.G0.setImageAssetsFolder("lottie_reactions_guide_left_img_dark");
            }
            SkinManager.setLottieAnimation(this.G0, R.raw.lottie_reactions_guide_left);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.h0.setVisibility(0);
                if (!this.h0.isAnimating()) {
                    this.h0.setSpeed(0.8f);
                    this.h0.setRepeatCount(-1);
                    this.h0.post(new a(this));
                    return;
                }
                return;
            }
            this.h0.setVisibility(8);
            if (this.h0.isAnimating()) {
                this.h0.cancelAnimation();
            }
        }
    }

    public final void e(@NonNull TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbPageContext) == null) {
            this.G0 = new TBLottieAnimationView(tbPageContext.getPageActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ej.g(tbPageContext.getPageActivity(), R.dimen.tbds650), ej.g(tbPageContext.getPageActivity(), R.dimen.tbds100));
            layoutParams.setMargins(ej.g(tbPageContext.getPageActivity(), R.dimen.tbds90), 0, 0, ej.g(tbPageContext.getPageActivity(), R.dimen.tbds10));
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f091099);
            this.b.addView(this.G0, layoutParams);
            f();
            this.G0.setVisibility(8);
        }
    }

    public void h(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.w0.g(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Y.getLayoutParams();
            if (z) {
                this.u0.setVisibility(0);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f0925b1);
            } else {
                this.u0.setVisibility(8);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f091099);
            }
            this.Y.setLayoutParams(layoutParams);
            MaskView maskView = this.v0;
            if (maskView != null) {
                maskView.setVisibility(8);
            }
            b();
        }
    }
}
