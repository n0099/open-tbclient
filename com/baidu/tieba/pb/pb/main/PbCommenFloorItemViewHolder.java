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
import com.baidu.tieba.hi;
import com.baidu.tieba.hn8;
import com.baidu.tieba.n15;
import com.baidu.tieba.nw4;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.rk8;
import com.baidu.tieba.ss5;
import com.baidu.tieba.view.VirtualImageStatusTip;
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
    public hn8 w0;
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
            this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a09);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f092486);
            this.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0919b8);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927ea);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927eb);
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927b6);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927e2);
            this.K = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f6e);
            this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927d6);
            this.u = view2.findViewById(R.id.obfuscated_res_0x7f0919fe);
            this.y = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091bde);
            this.z = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091bdf);
            AgreeView agreeView = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091817);
            this.o = agreeView;
            agreeView.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.o.setNormalColorResourceId(R.color.CAM_X0109);
            this.o.y(false);
            this.A = view2.findViewById(R.id.obfuscated_res_0x7f0919a4);
            this.B = view2.findViewById(R.id.obfuscated_res_0x7f0919a1);
            this.C = view2.findViewById(R.id.obfuscated_res_0x7f091997);
            this.D = view2.findViewById(R.id.obfuscated_res_0x7f091995);
            this.E = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0919a2);
            this.F = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919a3);
            this.G = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091998);
            this.H = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091999);
            AgreeView agreeView2 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091996);
            this.I = agreeView2;
            agreeView2.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.I.setNormalColorResourceId(R.color.CAM_X0109);
            this.I.y(true);
            this.C0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925fd);
            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e16);
            this.D0 = relativeLayout;
            n15 d = n15.d(relativeLayout);
            d.o(R.string.J_X04);
            d.f(R.color.CAM_X0204);
            RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091dfe);
            this.E0 = relativeLayout2;
            n15 d2 = n15.d(relativeLayout2);
            d2.o(R.string.J_X07);
            d2.f(R.color.CAM_X0905);
            this.F0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092581);
            this.A.setVisibility(8);
            this.u.setVisibility(0);
            this.y.setVisibility(0);
            this.z.setVisibility(0);
            this.o.setVisibility(0);
            this.O = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09199b);
            this.g0 = i;
            nw4 nw4Var = new nw4();
            nw4Var.b = 5;
            nw4Var.h = 8;
            nw4Var.g = 2;
            nw4Var.f = i;
            this.o.setStatisticData(nw4Var);
            this.p = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091884);
            HeadPendantView headPendantView = (HeadPendantView) view2.findViewById(R.id.obfuscated_res_0x7f091a54);
            this.L = headPendantView;
            headPendantView.setHasPendantStyle();
            if (this.L.getHeadView() != null) {
                this.L.getHeadView().setIsRound(true);
                this.L.getHeadView().setDrawBorder(true);
                this.L.getHeadView().setPlaceHolder(1);
            }
            this.M = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f092093);
            this.N = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f092094);
            this.q = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091dc7);
            this.r = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091be8);
            this.s = (TbAlphaVideo) view2.findViewById(R.id.obfuscated_res_0x7f090150);
            this.v = (SubPbLayout) view2.findViewById(R.id.obfuscated_res_0x7f0919f5);
            this.w = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919ff);
            this.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0107), null), (Drawable) null);
            this.w.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.w.setTextSize(0, hi.g(TbadkCoreApplication.getInst(), R.dimen.T_X07));
            this.x = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919fd);
            this.t = (ConstrainImageGroup) view2.findViewById(R.id.obfuscated_res_0x7f090b03);
            this.P = view2.findViewById(R.id.obfuscated_res_0x7f09196c);
            this.J = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b05);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b9a);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b9b);
            this.t.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
            this.t.setSingleImageRatio(0.75d);
            this.t.setImageProcessor(new ss5(3));
            rk8 rk8Var = new rk8(this.q.getLayoutStrategy());
            rk8Var.p(TbConfig.getPostLineSpace(), 1.0f);
            this.q.setLayoutStrategy(rk8Var);
            this.q.setIsNeedResizeEmotion(true);
            this.q.setTextSize(TbConfig.getContentSize());
            this.p.setIsRound(true);
            this.p.setGodIconWidth(R.dimen.tbds36);
            this.p.setPlaceHolder(1);
            this.q.setDisplayImage(this.d, false);
            this.q.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d0981);
            this.Q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919c7);
            this.R = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f091991);
            this.S = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091990);
            this.T = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0919fa);
            this.U = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919fb);
            this.V = view2.findViewById(R.id.obfuscated_res_0x7f0919f9);
            this.W = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919fc);
            this.X = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0919f8);
            this.Y = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090279);
            this.Z = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090b21);
            this.a0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b22);
            this.d0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091b61);
            this.e0 = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091b62);
            this.b0 = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f09199a);
            if (this.c0.booleanValue()) {
                this.b0.setVisibility(0);
            } else {
                this.b0.setVisibility(8);
            }
            this.h0 = (TBLottieAnimationView) view2.findViewById(R.id.user_living_lottie);
            this.i0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f0919a0);
            this.j0 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f09199e);
            this.k0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09199f);
            this.o0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09082e);
            this.p0 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09082b);
            this.q0 = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090830);
            this.r0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09082f);
            this.s0 = view2.findViewById(R.id.obfuscated_res_0x7f090b04);
            this.j0.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.j0.setNormalColorResourceId(R.color.CAM_X0109);
            this.j0.y(false);
            this.j0.setAgreeAlone(true);
            this.j0.setStatisticData(nw4Var);
            this.l0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091a00);
            this.m0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927e3);
            this.n0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0904bc);
            this.t0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0919f7);
            this.u0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09265b);
            hn8 hn8Var = new hn8(tbPageContext, this.u0);
            this.w0 = hn8Var;
            hn8Var.f = 3;
            this.v0 = (MaskView) view2.findViewById(R.id.obfuscated_res_0x7f091639);
            this.x0 = (FrameLayout) view2.findViewById(R.id.user_container);
            this.y0 = (VirtualImageStatusTip) view2.findViewById(R.id.obfuscated_res_0x7f09281f);
            this.z0 = (HeadCustomImageView) view2.findViewById(R.id.obfuscated_res_0x7f092808);
            this.A0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092809);
            this.B0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091fea);
            this.j = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091977);
            e(tbPageContext);
            this.H0 = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091993);
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
            nw4 nw4Var = new nw4();
            nw4Var.b = 12;
            nw4Var.h = 9;
            nw4Var.g = 3;
            nw4Var.f = this.g0;
            this.o.setStatisticData(nw4Var);
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
                n15 d = n15.d(this.b0);
                d.n(0);
                d.o(R.string.J_X05);
                d.f(R.color.CAM_X0206);
                this.b0.b();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.G0 != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                this.G0.setImageAssetsFolder("lottie_reactions_guide_left_img_dark");
            } else {
                this.G0.setImageAssetsFolder("lottie_reactions_guide_left_img");
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
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(hi.g(tbPageContext.getPageActivity(), R.dimen.tbds650), hi.g(tbPageContext.getPageActivity(), R.dimen.tbds100));
            layoutParams.setMargins(hi.g(tbPageContext.getPageActivity(), R.dimen.tbds90), 0, 0, hi.g(tbPageContext.getPageActivity(), R.dimen.tbds10));
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f09110f);
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
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f09265b);
            } else {
                this.u0.setVisibility(8);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f09110f);
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
