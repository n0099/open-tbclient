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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
import com.baidu.tbadk.widget.level.TbLevelView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.cm9;
import com.baidu.tieba.h15;
import com.baidu.tieba.pb.feedback.AigcFeedbackView;
import com.baidu.tieba.pb.feedback.fold.AigcFeedbackFoldView;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.tieba.wo9;
import com.baidu.tieba.z06;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes7.dex */
public class PbCommenFloorItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public TBLottieAnimationView A0;
    public AgreeView B;
    public LinearLayout B0;
    public TextView C;
    public RelativeLayout C0;
    public TbLevelView D;
    public LinearLayout D0;
    public HeadPendantView E;
    public AigcFeedbackView E0;
    public UserIconBox F;
    public AigcFeedbackFoldView F0;
    public UserIconBox G;
    public LinearLayout G0;
    public ImageView H;
    public View I;
    public TextView J;
    public SimpleDraweeView K;
    public LinearLayout L;
    public LinearLayout M;
    public TextView N;
    public View O;
    public TextView P;
    public ImageView Q;
    public LinearLayout R;
    public LinearLayout S;

    /* renamed from: T  reason: collision with root package name */
    public TextView f1141T;
    public PbFloorComplaint U;
    public Boolean V;
    public ImageView W;
    public TbImageView X;
    public int Y;
    public int Z;
    public int a;
    public TBLottieAnimationView a0;
    public RelativeLayout b;
    public ViewGroup b0;
    public View c;
    public AgreeView c0;
    public boolean d;
    public ImageView d0;
    public View e;
    public ViewGroup e0;
    public LinearLayout f;
    public TextView f0;
    public TextView g;
    public TextView g0;
    public TextView h;
    public LinearLayout h0;
    public TextView i;
    public RelativeLayout i0;
    public TbImageView j;
    public EMTextView j0;
    public TextView k;
    public ImageView k0;
    public TextView l;
    public View l0;
    public TextView m;
    public View m0;
    public TextView n;
    public ImageView n0;
    public AgreeView o;
    public FrameLayout o0;
    public HeadImageView p;
    public MaskView p0;
    public TbRichTextView q;
    public wo9 q0;
    public RelativeLayout r;
    public FrameLayout r0;
    public TbAlphaVideo s;
    public VirtualImageStatusTip s0;
    public ConstrainImageGroup t;
    public HeadCustomImageView t0;
    public View u;
    public FrameLayout u0;
    public SubPbLayout v;
    public LinearLayout v0;
    public TextView w;
    public TextView w0;
    public TextView x;
    public RelativeLayout x0;
    public ImageView y;
    public RelativeLayout y0;
    public ImageView z;
    public TextView z0;

    /* loaded from: classes7.dex */
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
                this.a.a0.playAnimation();
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
        this.V = Boolean.FALSE;
        this.Y = -1;
        if (tbPageContext != null && view2 != null) {
            this.c = view2;
            this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b5c);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f092664);
            this.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b05);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0929c9);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0929ca);
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092991);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0929c1);
            this.D = (TbLevelView) view2.findViewById(R.id.forum_level_view);
            this.B0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b48);
            this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0929b5);
            this.u = view2.findViewById(R.id.obfuscated_res_0x7f091b51);
            this.y = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091d3b);
            this.z = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091d3c);
            AgreeView agreeView = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091953);
            this.o = agreeView;
            agreeView.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.o.setNormalColorResourceId(R.color.CAM_X0109);
            this.o.z(false);
            this.A = view2.findViewById(R.id.obfuscated_res_0x7f091aee);
            AgreeView agreeView2 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091ae0);
            this.B = agreeView2;
            agreeView2.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.B.setNormalColorResourceId(R.color.CAM_X0109);
            this.B.z(true);
            this.w0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927d5);
            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091fba);
            this.x0 = relativeLayout;
            EMManager.from(relativeLayout).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0204);
            RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091f9f);
            this.y0 = relativeLayout2;
            EMManager.from(relativeLayout2).setCorner(R.string.J_X07).setBackGroundColor(R.color.CAM_X0905);
            this.z0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092755);
            this.A.setVisibility(8);
            this.u.setVisibility(0);
            this.y.setVisibility(0);
            this.z.setVisibility(0);
            this.o.setVisibility(0);
            this.H = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091ae5);
            this.Z = i;
            h15 h15Var = new h15();
            h15Var.b = 5;
            h15Var.h = 8;
            h15Var.g = 2;
            h15Var.f = i;
            this.o.setStatisticData(h15Var);
            this.p = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0919bf);
            HeadPendantView headPendantView = (HeadPendantView) view2.findViewById(R.id.obfuscated_res_0x7f091b9c);
            this.E = headPendantView;
            headPendantView.setHasPendantStyle();
            if (this.E.getHeadView() != null) {
                this.E.getHeadView().setIsRound(true);
                this.E.getHeadView().setDrawBorder(true);
                this.E.getHeadView().setPlaceHolder(1);
            }
            this.F = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f092246);
            this.G = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f092247);
            this.q = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091f50);
            this.r = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091d45);
            this.s = (TbAlphaVideo) view2.findViewById(R.id.obfuscated_res_0x7f09015a);
            this.v = (SubPbLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b47);
            this.w = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b52);
            this.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0107), null), (Drawable) null);
            this.w.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.w.setTextSize(0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X07));
            this.x = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b50);
            this.t = (ConstrainImageGroup) view2.findViewById(R.id.obfuscated_res_0x7f090b77);
            this.I = view2.findViewById(R.id.obfuscated_res_0x7f091ab5);
            this.C = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b79);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cf3);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cf4);
            this.t.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
            this.t.setSingleImageRatio(0.75d);
            this.t.setImageProcessor(new z06(3));
            cm9 cm9Var = new cm9(this.q.getLayoutStrategy());
            cm9Var.p(TbConfig.getPostLineSpace(), 1.0f);
            this.q.setLayoutStrategy(cm9Var);
            this.q.setIsNeedResizeEmotion(true);
            this.q.setTextSize(TbConfig.getContentSize());
            this.p.setIsRound(true);
            this.p.setGodIconWidth(R.dimen.tbds36);
            this.p.setPlaceHolder(1);
            this.q.setDisplayImage(this.d, false);
            this.q.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d0a29);
            this.J = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b15);
            this.K = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f091adc);
            this.L = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091adb);
            this.M = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b4d);
            this.N = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b4e);
            this.O = view2.findViewById(R.id.obfuscated_res_0x7f091b4c);
            this.P = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b4f);
            this.Q = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091b4b);
            this.R = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090280);
            this.S = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090b94);
            this.f1141T = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b95);
            this.W = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091caf);
            this.X = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091cb0);
            this.U = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f091ae4);
            if (this.V.booleanValue()) {
                this.U.setVisibility(0);
            } else {
                this.U.setVisibility(8);
            }
            this.a0 = (TBLottieAnimationView) view2.findViewById(R.id.user_living_lottie);
            this.b0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091aea);
            this.m0 = view2.findViewById(R.id.obfuscated_res_0x7f09267c);
            this.c0 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091ae8);
            this.d0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091ae9);
            this.h0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09086b);
            this.i0 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090869);
            this.j0 = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f09086d);
            this.k0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09086c);
            this.l0 = view2.findViewById(R.id.obfuscated_res_0x7f090b78);
            this.c0.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.c0.setNormalColorResourceId(R.color.CAM_X0109);
            this.c0.z(false);
            this.c0.setAgreeAlone(true);
            this.c0.setStatisticData(h15Var);
            this.e0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091b53);
            this.f0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0929c2);
            this.g0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0904f3);
            this.n0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091b4a);
            this.o0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092834);
            wo9 wo9Var = new wo9(tbPageContext, this.o0);
            this.q0 = wo9Var;
            wo9Var.f = 3;
            this.p0 = (MaskView) view2.findViewById(R.id.obfuscated_res_0x7f09170c);
            this.r0 = (FrameLayout) view2.findViewById(R.id.user_container);
            this.s0 = (VirtualImageStatusTip) view2.findViewById(R.id.obfuscated_res_0x7f0929fe);
            this.t0 = (HeadCustomImageView) view2.findViewById(R.id.obfuscated_res_0x7f0929e7);
            this.u0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0929e8);
            this.v0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f092195);
            this.j = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091ac1);
            e(tbPageContext);
            this.C0 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090b76);
            this.D0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090b7e);
            this.E0 = (AigcFeedbackView) view2.findViewById(R.id.obfuscated_res_0x7f09043c);
            this.F0 = (AigcFeedbackFoldView) view2.findViewById(R.id.obfuscated_res_0x7f0901c0);
            this.G0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090281);
        }
    }

    public void c(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (tBLottieAnimationView = this.a0) != null) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && z) {
            h15 h15Var = new h15();
            h15Var.b = 12;
            h15Var.h = 9;
            h15Var.g = 3;
            h15Var.f = this.Z;
            this.o.setStatisticData(h15Var);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.q0.e();
            MaskView maskView = this.p0;
            if (maskView != null) {
                maskView.f();
            }
            PbFloorComplaint pbFloorComplaint = this.U;
            if (pbFloorComplaint != null) {
                pbFloorComplaint.setBackgroundColor(R.color.CAM_X0206);
                EMManager.from(this.U).setCardType(0).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
                this.U.b();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.A0 != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                this.A0.setImageAssetsFolder("lottie_reactions_guide_left_img_dark");
            } else {
                this.A0.setImageAssetsFolder("lottie_reactions_guide_left_img");
            }
            SkinManager.setLottieAnimation(this.A0, R.raw.lottie_reactions_guide_left);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.a0.setVisibility(0);
                if (!this.a0.isAnimating()) {
                    this.a0.setSpeed(0.8f);
                    this.a0.setRepeatCount(-1);
                    this.a0.post(new a(this));
                    return;
                }
                return;
            }
            this.a0.setVisibility(8);
            if (this.a0.isAnimating()) {
                this.a0.cancelAnimation();
            }
        }
    }

    public final void e(@NonNull TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbPageContext) == null) {
            this.A0 = new TBLottieAnimationView(tbPageContext.getPageActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds650), BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds100));
            layoutParams.setMargins(BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds90), 0, 0, BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds10));
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f0911bd);
            this.b.addView(this.A0, layoutParams);
            f();
            this.A0.setVisibility(8);
        }
    }

    public void h(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.q0.g(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.R.getLayoutParams();
            if (z) {
                this.o0.setVisibility(0);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f092834);
            } else {
                this.o0.setVisibility(8);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f0911bd);
            }
            this.R.setLayoutParams(layoutParams);
            MaskView maskView = this.p0;
            if (maskView != null) {
                maskView.setVisibility(8);
            }
            b();
        }
    }
}
