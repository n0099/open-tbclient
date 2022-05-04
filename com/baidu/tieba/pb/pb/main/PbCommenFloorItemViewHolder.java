package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
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
import com.repackage.mu7;
import com.repackage.oi;
import com.repackage.re5;
import com.repackage.vn4;
import com.repackage.vr4;
import com.repackage.ww7;
/* loaded from: classes3.dex */
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
    public View b;
    public AgreeView b0;
    public boolean c;
    public ImageView c0;
    public View d;
    public ViewGroup d0;
    public LinearLayout e;
    public TextView e0;
    public TextView f;
    public TextView f0;
    public TextView g;
    public ImageView g0;
    public TextView h;
    public FrameLayout h0;
    public TextView i;
    public MaskView i0;
    public TextView j;
    public ww7 j0;
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

    /* loaded from: classes3.dex */
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
        this.c = true;
        this.V = Boolean.FALSE;
        this.X = -1;
        if (tbPageContext == null || view2 == null) {
            return;
        }
        this.b = view2;
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f092098);
        this.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0916cd);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923bd);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09238a);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923b4);
        this.F = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e16);
        this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923a9);
        this.p = view2.findViewById(R.id.obfuscated_res_0x7f091712);
        this.t = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0918a6);
        this.u = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0918a7);
        AgreeView agreeView = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f09154a);
        this.l = agreeView;
        agreeView.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.l.setNormalColorResourceId(R.color.CAM_X0109);
        this.l.t(false);
        this.v = view2.findViewById(R.id.obfuscated_res_0x7f0916ba);
        this.w = view2.findViewById(R.id.obfuscated_res_0x7f0916b7);
        this.x = view2.findViewById(R.id.obfuscated_res_0x7f0916ad);
        this.y = view2.findViewById(R.id.obfuscated_res_0x7f0916ab);
        this.z = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0916b8);
        this.A = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0916b9);
        this.B = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0916ae);
        this.C = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0916af);
        AgreeView agreeView2 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f0916ac);
        this.D = agreeView2;
        agreeView2.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.D.setNormalColorResourceId(R.color.CAM_X0109);
        this.D.t(true);
        this.v.setVisibility(8);
        this.p.setVisibility(0);
        this.t.setVisibility(0);
        this.u.setVisibility(0);
        this.l.setVisibility(0);
        this.J = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0916b1);
        this.Y = i;
        vn4 vn4Var = new vn4();
        vn4Var.b = 5;
        vn4Var.h = 8;
        vn4Var.g = 2;
        vn4Var.f = i;
        this.l.setStatisticData(vn4Var);
        this.m = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0915b3);
        HeadPendantView headPendantView = (HeadPendantView) view2.findViewById(R.id.obfuscated_res_0x7f09175f);
        this.G = headPendantView;
        headPendantView.setHasPendantStyle();
        if (this.G.getHeadView() != null) {
            this.G.getHeadView().setIsRound(true);
            this.G.getHeadView().setDrawBorder(true);
            this.G.getHeadView().setPlaceHolder(1);
        }
        this.H = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f091ce4);
        this.I = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f091ce5);
        this.n = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091a7a);
        this.q = (SubPbLayout) view2.findViewById(R.id.obfuscated_res_0x7f091709);
        this.r = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091713);
        this.r.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0107), null), (Drawable) null);
        this.r.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        this.r.setTextSize(0, oi.f(TbadkCoreApplication.getInst(), R.dimen.T_X07));
        this.s = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091711);
        this.o = (ConstrainImageGroup) view2.findViewById(R.id.obfuscated_res_0x7f0909e5);
        this.K = view2.findViewById(R.id.obfuscated_res_0x7f091689);
        this.E = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0909e6);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091864);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091865);
        this.o.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
        this.o.setSingleImageRatio(0.75d);
        this.o.setImageProcessor(new re5(3));
        mu7 mu7Var = new mu7(this.n.getLayoutStrategy());
        mu7Var.j(oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        mu7Var.o(TbConfig.getPostLineSpace(), 1.0f);
        this.n.setLayoutStrategy(mu7Var);
        this.n.setIsNeedResizeEmotion(true);
        this.n.setTextSize(TbConfig.getContentSize());
        this.m.setIsRound(true);
        this.m.setGodIconWidth(R.dimen.tbds36);
        this.m.setPlaceHolder(1);
        this.n.setDisplayImage(this.c, false);
        this.n.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d08a8);
        this.L = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0916db);
        this.M = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09170e);
        this.N = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09170f);
        this.O = view2.findViewById(R.id.obfuscated_res_0x7f09170d);
        this.P = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091710);
        this.Q = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09170c);
        this.R = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090266);
        this.S = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0909fd);
        this.T = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0909fe);
        this.W = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09182f);
        this.U = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f0916b0);
        if (this.V.booleanValue()) {
            this.U.setVisibility(0);
        } else {
            this.U.setVisibility(8);
        }
        this.Z = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f09229b);
        this.a0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f0916b6);
        this.b0 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f0916b4);
        this.c0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0916b5);
        this.b0.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.b0.setNormalColorResourceId(R.color.CAM_X0109);
        this.b0.t(false);
        this.b0.setAgreeAlone(true);
        this.b0.setStatisticData(vn4Var);
        this.d0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091714);
        this.e0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923b5);
        this.f0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09043c);
        this.g0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09170b);
        FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092243);
        this.h0 = frameLayout;
        ww7 ww7Var = new ww7(tbPageContext, frameLayout);
        this.j0 = ww7Var;
        ww7Var.f = 3;
        this.i0 = (MaskView) view2.findViewById(R.id.obfuscated_res_0x7f0913ac);
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
                vr4 d = vr4.d(this.U);
                d.m(0);
                d.n(R.string.J_X05);
                d.f(R.color.CAM_X0206);
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
            vn4 vn4Var = new vn4();
            vn4Var.b = 12;
            vn4Var.h = 9;
            vn4Var.g = 3;
            vn4Var.f = this.Y;
            this.l.setStatisticData(vn4Var);
        }
    }

    public void h(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.j0.f(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.R.getLayoutParams();
            if (z) {
                this.h0.setVisibility(0);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f092243);
            } else {
                this.h0.setVisibility(8);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f090f71);
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
