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
import com.baidu.card.view.HeadWorldCupFlagLayout;
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
import com.baidu.tieba.gg9;
import com.baidu.tieba.kz5;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.tieba.w05;
import com.baidu.tieba.zi9;
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
    public TbImageView B0;
    public TextView C;
    public HeadWorldCupFlagLayout C0;
    public TbLevelView D;
    public LinearLayout D0;
    public HeadPendantView E;
    public UserIconBox F;
    public UserIconBox G;
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
    public TextView f1140T;
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
    public zi9 q0;
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
            this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b1a);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f0925ec);
            this.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091ac3);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09295c);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09295d);
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092927);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092954);
            this.D = (TbLevelView) view2.findViewById(R.id.forum_level_view);
            this.D0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b06);
            this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092948);
            this.u = view2.findViewById(R.id.obfuscated_res_0x7f091b0f);
            this.y = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091cf2);
            this.z = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091cf3);
            AgreeView agreeView = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091916);
            this.o = agreeView;
            agreeView.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.o.setNormalColorResourceId(R.color.CAM_X0109);
            this.o.z(false);
            this.A = view2.findViewById(R.id.obfuscated_res_0x7f091aac);
            AgreeView agreeView2 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091a9e);
            this.B = agreeView2;
            agreeView2.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.B.setNormalColorResourceId(R.color.CAM_X0109);
            this.B.z(true);
            this.w0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09276b);
            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091f50);
            this.x0 = relativeLayout;
            EMManager.from(relativeLayout).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0204);
            RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091f37);
            this.y0 = relativeLayout2;
            EMManager.from(relativeLayout2).setCorner(R.string.J_X07).setBackGroundColor(R.color.CAM_X0905);
            this.z0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926ed);
            this.A.setVisibility(8);
            this.u.setVisibility(0);
            this.y.setVisibility(0);
            this.z.setVisibility(0);
            this.o.setVisibility(0);
            this.H = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091aa3);
            this.Z = i;
            w05 w05Var = new w05();
            w05Var.b = 5;
            w05Var.h = 8;
            w05Var.g = 2;
            w05Var.f = i;
            this.o.setStatisticData(w05Var);
            this.p = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091982);
            HeadPendantView headPendantView = (HeadPendantView) view2.findViewById(R.id.obfuscated_res_0x7f091b5a);
            this.E = headPendantView;
            headPendantView.setHasPendantStyle();
            if (this.E.getHeadView() != null) {
                this.E.getHeadView().setIsRound(true);
                this.E.getHeadView().setDrawBorder(true);
                this.E.getHeadView().setPlaceHolder(1);
            }
            this.F = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f0921d9);
            this.G = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f0921da);
            this.q = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091efe);
            this.r = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091cfc);
            this.s = (TbAlphaVideo) view2.findViewById(R.id.obfuscated_res_0x7f09015c);
            this.v = (SubPbLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b05);
            this.w = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b10);
            this.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0107), null), (Drawable) null);
            this.w.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.w.setTextSize(0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X07));
            this.x = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b0e);
            this.t = (ConstrainImageGroup) view2.findViewById(R.id.obfuscated_res_0x7f090b6f);
            this.I = view2.findViewById(R.id.obfuscated_res_0x7f091a72);
            this.C = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b71);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091caa);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cab);
            this.t.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
            this.t.setSingleImageRatio(0.75d);
            this.t.setImageProcessor(new kz5(3));
            gg9 gg9Var = new gg9(this.q.getLayoutStrategy());
            gg9Var.p(TbConfig.getPostLineSpace(), 1.0f);
            this.q.setLayoutStrategy(gg9Var);
            this.q.setIsNeedResizeEmotion(true);
            this.q.setTextSize(TbConfig.getContentSize());
            this.p.setIsRound(true);
            this.p.setGodIconWidth(R.dimen.tbds36);
            this.p.setPlaceHolder(1);
            this.q.setDisplayImage(this.d, false);
            this.q.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d0a0e);
            this.J = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091ad3);
            this.K = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f091a99);
            this.L = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a98);
            this.M = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b0b);
            this.N = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b0c);
            this.O = view2.findViewById(R.id.obfuscated_res_0x7f091b0a);
            this.P = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b0d);
            this.Q = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091b09);
            this.R = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09027c);
            this.S = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090b8b);
            this.f1140T = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b8c);
            this.W = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091c6d);
            this.X = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091c6e);
            this.U = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f091aa2);
            if (this.V.booleanValue()) {
                this.U.setVisibility(0);
            } else {
                this.U.setVisibility(8);
            }
            this.a0 = (TBLottieAnimationView) view2.findViewById(R.id.user_living_lottie);
            this.b0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091aa8);
            this.m0 = view2.findViewById(R.id.obfuscated_res_0x7f092603);
            this.c0 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091aa6);
            this.d0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091aa7);
            this.h0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090870);
            this.i0 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09086e);
            this.j0 = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090872);
            this.k0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090871);
            this.l0 = view2.findViewById(R.id.obfuscated_res_0x7f090b70);
            this.c0.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.c0.setNormalColorResourceId(R.color.CAM_X0109);
            this.c0.z(false);
            this.c0.setAgreeAlone(true);
            this.c0.setStatisticData(w05Var);
            this.e0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091b11);
            this.f0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092955);
            this.g0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0904e7);
            this.n0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091b08);
            this.o0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0927ca);
            zi9 zi9Var = new zi9(tbPageContext, this.o0);
            this.q0 = zi9Var;
            zi9Var.f = 3;
            this.p0 = (MaskView) view2.findViewById(R.id.obfuscated_res_0x7f0916ec);
            this.r0 = (FrameLayout) view2.findViewById(R.id.user_container);
            this.s0 = (VirtualImageStatusTip) view2.findViewById(R.id.obfuscated_res_0x7f092991);
            this.t0 = (HeadCustomImageView) view2.findViewById(R.id.obfuscated_res_0x7f09297a);
            this.u0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09297b);
            this.v0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09212a);
            this.j = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a7e);
            f(tbPageContext);
            this.B0 = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a9b);
            this.C0 = (HeadWorldCupFlagLayout) view2.findViewById(R.id.world_cup_flag);
        }
    }

    public void d(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (tBLottieAnimationView = this.a0) != null) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && z) {
            w05 w05Var = new w05();
            w05Var.b = 12;
            w05Var.h = 9;
            w05Var.g = 3;
            w05Var.f = this.Z;
            this.o.setStatisticData(w05Var);
        }
    }

    public void c() {
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

    public void g() {
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

    public void e(boolean z) {
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

    public final void f(@NonNull TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbPageContext) == null) {
            this.A0 = new TBLottieAnimationView(tbPageContext.getPageActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds650), BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds100));
            layoutParams.setMargins(BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds90), 0, 0, BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds10));
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f0911a3);
            this.b.addView(this.A0, layoutParams);
            g();
            this.A0.setVisibility(8);
        }
    }

    public void i(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.q0.g(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.R.getLayoutParams();
            if (z) {
                this.o0.setVisibility(0);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f0927ca);
            } else {
                this.o0.setVisibility(8);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f0911a3);
            }
            this.R.setLayoutParams(layoutParams);
            MaskView maskView = this.p0;
            if (maskView != null) {
                maskView.setVisibility(8);
            }
            c();
        }
    }
}
