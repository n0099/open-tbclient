package com.baidu.tieba.pb.videopb.viewholder;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bs7;
import com.repackage.ef5;
import com.repackage.nu7;
import com.repackage.oi;
import com.repackage.sw7;
import com.repackage.ww7;
import com.repackage.z47;
import java.util.ArrayList;
import java.util.List;
import tbclient.HeadItem;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class VideoPbVideoInfoViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbRichTextView A;
    public TextView B;
    public TextView C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView G;
    public FrameLayout H;
    public ww7 I;
    public FrameLayout J;
    public sw7 K;
    public int L;
    public int M;
    public LinearLayout N;
    public boolean O;
    public AbsVideoPbFragment P;
    public int a;
    public View b;
    public ImageView c;
    public HeadPendantClickableView d;
    public TBLottieAnimationView e;
    public UserIconBox f;
    public TextView g;
    public TextView h;
    public ImageView i;
    public UserIconBox j;
    public TextView k;
    public TextView l;
    public PbFirstFloorUserLikeButton m;
    public ViewGroup n;
    public RelativeLayout o;
    public TbRichTextView p;
    public final TextView q;
    public ImageView r;
    public RelativeLayout s;
    public View t;
    public final View u;
    public TextView v;
    public TextView w;
    public TextView x;
    public View y;
    public VoteView z;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbVideoInfoViewHolder a;

        public a(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbVideoInfoViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbVideoInfoViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e.playAnimation();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPbVideoInfoViewHolder(Context context, View view2, AbsVideoPbFragment absVideoPbFragment) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, absVideoPbFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds14);
        this.a = 3;
        this.b = view2;
        this.P = absVideoPbFragment;
        this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091fb4);
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view2.findViewById(R.id.obfuscated_res_0x7f090d37);
        this.d = headPendantClickableView;
        headPendantClickableView.setHasPendantStyle();
        this.d.getHeadView().setIsRound(true);
        this.d.getHeadView().setDrawBorder(true);
        this.d.getHeadView().setBorderWidth(oi.f(context, R.dimen.L_X01));
        this.d.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.d.getHeadView().setPlaceHolder(1);
        this.d.setBigVDimenSize(R.dimen.tbds36);
        this.e = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f09229b);
        this.f = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f0923d4);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922a3);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09228f);
        this.i = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092285);
        this.j = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f0922c5);
        this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09037d);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090977);
        this.m = (PbFirstFloorUserLikeButton) view2.findViewById(R.id.obfuscated_res_0x7f0906c2);
        this.n = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f0915ba);
        this.o = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09231d);
        this.p = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f092044);
        this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092030);
        this.y = view2.findViewById(R.id.obfuscated_res_0x7f09231f);
        this.t = view2.findViewById(R.id.obfuscated_res_0x7f092374);
        this.u = view2.findViewById(R.id.obfuscated_res_0x7f09231e);
        this.p.setLayoutStrategy(new nu7(this.p.getLayoutStrategy()));
        this.p.setTextSize(TbConfig.getContentSize());
        this.p.setTextBold();
        this.q.setTextSize(0, TbConfig.getContentSize());
        this.q.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.r = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090442);
        this.s = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090447);
        this.L = (oi.k(TbadkCoreApplication.getInst()) - this.o.getPaddingLeft()) - this.o.getPaddingRight();
        c(0);
        this.v = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091855);
        this.w = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09194d);
        this.x = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091946);
        this.B = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091943);
        this.C = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091856);
        this.D = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09194e);
        this.E = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091947);
        this.F = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091944);
        this.z = (VoteView) view2.findViewById(R.id.obfuscated_res_0x7f09174b);
        TbRichTextView tbRichTextView = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f0922e0);
        this.A = tbRichTextView;
        tbRichTextView.setIsShowOrderOrDownloadBtn(true);
        this.A.setIsNeedResizeEmotion(true);
        this.N = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0916df);
        nu7 nu7Var = new nu7(this.A.getLayoutStrategy());
        nu7Var.v(TbConfig.getContentSize());
        nu7Var.n(0.9f);
        this.A.setLayoutStrategy(nu7Var);
        FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092243);
        this.H = frameLayout;
        ww7 ww7Var = new ww7(absVideoPbFragment, frameLayout);
        this.I = ww7Var;
        ww7Var.f = 2;
        FrameLayout frameLayout2 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090ee8);
        this.J = frameLayout2;
        this.K = new sw7(frameLayout2);
        this.G = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092215);
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.M = i;
            if (i == 0) {
                f();
            } else if (i == 1) {
                d();
            } else if (i == 2) {
                e();
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.s.setVisibility(0);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.r, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
            this.p.setTextEllipsize(TextUtils.TruncateAt.END);
            this.p.setMaxLines(2);
            this.u.setVisibility(8);
            this.A.setVisibility(8);
            this.v.setVisibility(0);
            this.w.setVisibility(0);
            this.x.setVisibility(0);
            this.B.setVisibility(0);
            this.y.setVisibility(0);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.s.setVisibility(0);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.r, R.drawable.obfuscated_res_0x7f080909, R.color.CAM_X0105, null);
            this.p.setTextEllipsize(null);
            this.p.setMaxLines(3);
            if (this.O) {
                this.A.setVisibility(0);
            }
            this.u.setVisibility(0);
            this.v.setVisibility(8);
            this.w.setVisibility(8);
            this.x.setVisibility(8);
            this.B.setVisibility(8);
            this.y.setVisibility(8);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.s.setVisibility(8);
            this.p.setTextEllipsize(null);
            this.p.setMaxLines(2);
        }
    }

    public final void g(List<TbRichTextData> list, HeadItem headItem) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, headItem) == null) {
            TbRichTextData tbRichTextData = new TbRichTextData(1);
            StringBuilder sb = new StringBuilder();
            sb.append(headItem.name);
            sb.append(": ");
            sb.append(headItem.type.intValue() == 1 ? headItem.content : " ");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new SpannableString(sb.toString()));
            if (headItem.type.intValue() == 2) {
                try {
                    i = Integer.parseInt(headItem.content);
                } catch (NumberFormatException unused) {
                    i = 0;
                }
                spannableStringBuilder.append((CharSequence) ef5.q(i, true));
            }
            tbRichTextData.z(spannableStringBuilder);
            ListUtils.add(list, 0, tbRichTextData);
        }
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.M : invokeV.intValue;
    }

    public final void i(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || (tBLottieAnimationView = this.e) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                this.e.setVisibility(0);
                if (this.e.isAnimating()) {
                    return;
                }
                this.e.setSpeed(0.8f);
                this.e.setRepeatCount(-1);
                this.e.post(new a(this));
                return;
            }
            this.e.setVisibility(8);
            if (this.e.isAnimating()) {
                this.e.cancelAnimation();
            }
        }
    }

    public void k(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbRichText) == null) || tbRichText == null) {
            return;
        }
        ArrayList<TbRichTextData> A = tbRichText.A();
        TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(A, 0);
        if (tbRichTextData == null || tbRichTextData.getType() != 1) {
            tbRichTextData = new TbRichTextData(1);
            ListUtils.add(A, 0, tbRichTextData);
        }
        tbRichTextData.d0(ef5.s());
    }

    public void l(TbRichText tbRichText, List<HeadItem> list) {
        int count;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, tbRichText, list) == null) || (count = ListUtils.getCount(list)) == 0 || list == null) {
            return;
        }
        ArrayList<TbRichTextData> A = tbRichText.A();
        if (count == 1) {
            TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(A, 0);
            if (tbRichTextData == null || tbRichTextData.getType() != 1) {
                tbRichTextData = new TbRichTextData(1);
                ListUtils.add(A, 0, tbRichTextData);
            }
            HeadItem headItem = (HeadItem) ListUtils.getItem(list, 0);
            if (headItem != null) {
                try {
                    i = Integer.parseInt(headItem.content);
                } catch (NumberFormatException unused) {
                    i = 0;
                }
                tbRichTextData.d0(ef5.q(i, false));
                return;
            }
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            HeadItem headItem2 = list.get(size);
            if (headItem2 != null) {
                g(A, headItem2);
            }
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i) == null) || i <= 0) {
            return;
        }
        SkinManager.setImageResource(this.i, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.G, R.color.CAM_X0202);
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.l.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.m.s(TbadkCoreApplication.getInst().getSkinType());
            this.p.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            c(this.M);
            this.v.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.w.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.x.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.B.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.C.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.D.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.E.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.F.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.z.C(skinType);
            this.A.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            this.I.d();
            this.K.c();
            if (this.a != skinType) {
                i(skinType);
            }
            this.a = skinType;
        }
    }

    public void o(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080f0c);
                this.c.setVisibility(0);
            } else if (z2 && z3) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080f4e);
                this.c.setVisibility(0);
            } else if (z2) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080f4c);
                this.c.setVisibility(0);
            } else if (z3) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080f4d);
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                SkinManager.setViewTextColor(this.g, R.color.CAM_X0301, 1);
            } else {
                SkinManager.setViewTextColor(this.g, R.color.CAM_X0105, 1);
            }
        }
    }

    public void r(@NonNull bs7 bs7Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, bs7Var, i) == null) {
            this.K.e(bs7Var, i, null);
        }
    }

    public void s(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            this.d.setOnClickListener(onClickListener);
            this.s.setOnClickListener(onClickListener);
            this.t.setOnClickListener(onClickListener);
            this.f.setOnClickListener(onClickListener);
            this.g.setOnClickListener(onClickListener);
            this.j.setOnClickListener(onClickListener);
        }
    }

    public void t(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i, str) == null) {
            this.I.g(i);
            this.I.f(str);
        }
    }

    public void u(Context context, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, context, postData) == null) {
            if (postData != null && ListUtils.getCount(postData.m0) >= 2) {
                List<PbContent> list = postData.m0;
                TbRichText X = TbRichTextView.X(ListUtils.subList(list, 1, list.size()), true);
                l(X, postData.K());
                this.A.setText(X);
                this.O = true;
                return;
            }
            this.O = false;
        }
    }

    public void v(List<PbContent> list, String str, ThreadData threadData, boolean z, boolean z2) {
        TbRichText tbRichText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{list, str, threadData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (ListUtils.isEmpty(list) && StringUtils.isNull(str)) {
                return;
            }
            String spannableStringBuilder = !ListUtils.isEmpty(list) ? ef5.E(list).toString() : str;
            int i = 0;
            if (this.q.getPaint().measureText(spannableStringBuilder, 0, spannableStringBuilder.length()) + (this.q.getTextSize() * 2.0f) > this.L * 2 || z) {
                int i2 = this.M;
                i = (i2 == 1 || i2 == 2) ? this.M : 1;
            }
            c(i);
            if (!ListUtils.isEmpty(list)) {
                tbRichText = TbRichTextView.Y(list, true, threadData);
            } else {
                tbRichText = new TbRichText(z47.d(str, 1));
            }
            TbRichText tbRichText2 = tbRichText;
            l(tbRichText2, threadData.getItemStar());
            if (z2) {
                k(tbRichText2);
            }
            this.p.setText(tbRichText2, false, this.P, false, true);
        }
    }
}
