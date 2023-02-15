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
import com.baidu.tieba.dc8;
import com.baidu.tieba.ej;
import com.baidu.tieba.hj7;
import com.baidu.tieba.oe8;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.se8;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.v98;
import com.baidu.tieba.xs5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.HeadItem;
import tbclient.PbContent;
/* loaded from: classes5.dex */
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
    public se8 I;
    public FrameLayout J;
    public oe8 K;
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

    /* loaded from: classes5.dex */
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
        ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
        this.a = 3;
        this.b = view2;
        this.P = absVideoPbFragment;
        this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092301);
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view2.findViewById(R.id.obfuscated_res_0x7f090e1c);
        this.d = headPendantClickableView;
        headPendantClickableView.setHasPendantStyle();
        this.d.getHeadView().setIsRound(true);
        this.d.getHeadView().setDrawBorder(true);
        this.d.getHeadView().setBorderWidth(ej.g(context, R.dimen.L_X01));
        this.d.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.d.getHeadView().setPlaceHolder(1);
        this.d.setBigVDimenSize(R.dimen.tbds36);
        this.e = (TBLottieAnimationView) view2.findViewById(R.id.user_living_lottie);
        this.f = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f092747);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092612);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925fc);
        this.i = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0925e5);
        this.j = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f092638);
        this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903a5);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a20);
        this.m = (PbFirstFloorUserLikeButton) view2.findViewById(R.id.obfuscated_res_0x7f090709);
        this.n = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f09180c);
        this.o = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f092690);
        this.p = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f09238b);
        this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092376);
        this.y = view2.findViewById(R.id.obfuscated_res_0x7f092692);
        this.t = view2.findViewById(R.id.obfuscated_res_0x7f0926e5);
        this.u = view2.findViewById(R.id.obfuscated_res_0x7f092691);
        this.p.setLayoutStrategy(new dc8(this.p.getLayoutStrategy()));
        this.p.setTextSize(TbConfig.getContentSize());
        this.p.setTextBold();
        this.q.setTextSize(0, TbConfig.getContentSize());
        this.q.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.r = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09047c);
        this.s = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090482);
        this.L = (ej.l(TbadkCoreApplication.getInst()) - this.o.getPaddingLeft()) - this.o.getPaddingRight();
        a(0);
        this.v = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b08);
        this.w = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091c03);
        this.x = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091bfc);
        this.B = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091bf9);
        this.C = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b09);
        this.D = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091c04);
        this.E = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091bfd);
        this.F = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091bfa);
        this.z = (VoteView) view2.findViewById(R.id.obfuscated_res_0x7f0919b7);
        TbRichTextView tbRichTextView = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f092653);
        this.A = tbRichTextView;
        tbRichTextView.setIsShowOrderOrDownloadBtn(true);
        this.A.setIsNeedResizeEmotion(true);
        this.N = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091949);
        dc8 dc8Var = new dc8(this.A.getLayoutStrategy());
        dc8Var.x(TbConfig.getContentSize());
        dc8Var.o(0.9f);
        this.A.setLayoutStrategy(dc8Var);
        this.H = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0925b1);
        se8 se8Var = new se8(absVideoPbFragment, this.H);
        this.I = se8Var;
        se8Var.f = 2;
        FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09100d);
        this.J = frameLayout;
        this.K = new oe8(frameLayout);
        this.G = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092580);
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.M = i;
            if (i == 0) {
                d();
            } else if (i == 1) {
                b();
            } else if (i == 2) {
                c();
            }
        }
    }

    public final void g(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && (tBLottieAnimationView = this.e) != null) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && i > 0) {
            SkinManager.setImageResource(this.i, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                SkinManager.setViewTextColor(this.g, R.color.CAM_X0301, 1);
            } else {
                SkinManager.setViewTextColor(this.g, R.color.CAM_X0105, 1);
            }
        }
    }

    public void p(View.OnClickListener onClickListener) {
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

    public final void b() {
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

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.s.setVisibility(0);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.r, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, null);
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

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.s.setVisibility(8);
            this.p.setTextEllipsize(null);
            this.p.setMaxLines(2);
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.M;
        }
        return invokeV.intValue;
    }

    public final void e(List<TbRichTextData> list, HeadItem headItem) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, headItem) == null) {
            TbRichTextData tbRichTextData = new TbRichTextData(1);
            StringBuilder sb = new StringBuilder();
            sb.append(headItem.name);
            sb.append(": ");
            if (headItem.type.intValue() == 1) {
                str = headItem.content;
            } else {
                str = " ";
            }
            sb.append(str);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new SpannableString(sb.toString()));
            if (headItem.type.intValue() == 2) {
                try {
                    i = Integer.parseInt(headItem.content);
                } catch (NumberFormatException unused) {
                    i = 0;
                }
                spannableStringBuilder.append((CharSequence) xs5.r(i, true));
            }
            tbRichTextData.H(spannableStringBuilder);
            ListUtils.add(list, 0, tbRichTextData);
        }
    }

    public void j(TbRichText tbRichText, List<HeadItem> list) {
        int count;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, tbRichText, list) == null) && (count = ListUtils.getCount(list)) != 0 && list != null) {
            ArrayList<TbRichTextData> I = tbRichText.I();
            if (count == 1) {
                TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(I, 0);
                if (tbRichTextData == null || tbRichTextData.getType() != 1) {
                    tbRichTextData = new TbRichTextData(1);
                    ListUtils.add(I, 0, tbRichTextData);
                }
                HeadItem headItem = (HeadItem) ListUtils.getItem(list, 0);
                if (headItem != null) {
                    try {
                        i = Integer.parseInt(headItem.content);
                    } catch (NumberFormatException unused) {
                        i = 0;
                    }
                    tbRichTextData.q0(xs5.r(i, false));
                    return;
                }
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                HeadItem headItem2 = list.get(size);
                if (headItem2 != null) {
                    e(I, headItem2);
                }
            }
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                this.e.setVisibility(0);
                if (!this.e.isAnimating()) {
                    this.e.setSpeed(0.8f);
                    this.e.setRepeatCount(-1);
                    this.e.post(new a(this));
                    return;
                }
                return;
            }
            this.e.setVisibility(8);
            if (this.e.isAnimating()) {
                this.e.cancelAnimation();
            }
        }
    }

    public void i(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbRichText) != null) || tbRichText == null) {
            return;
        }
        ArrayList<TbRichTextData> I = tbRichText.I();
        TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(I, 0);
        if (tbRichTextData == null || tbRichTextData.getType() != 1) {
            tbRichTextData = new TbRichTextData(1);
            ListUtils.add(I, 0, tbRichTextData);
        }
        tbRichTextData.q0(xs5.t());
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.G, R.color.CAM_X0202);
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.l.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.m.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.p.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            a(this.M);
            this.v.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.w.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.x.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.B.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.C.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.D.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.E.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.F.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.z.D(skinType);
            this.A.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            this.I.e();
            this.K.c();
            if (this.a != skinType) {
                g(skinType);
            }
            this.a = skinType;
        }
    }

    public void m(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z) {
                this.c.setImageResource(R.drawable.pic_frs_headlines_n);
                this.c.setVisibility(0);
            } else if (z2 && z3) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080fff);
                this.c.setVisibility(0);
            } else if (z2) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080ffd);
                this.c.setVisibility(0);
            } else if (z3) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080ffe);
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
        }
    }

    public void o(@NonNull v98 v98Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, v98Var, i) == null) {
            this.K.e(v98Var, i, null);
        }
    }

    public void q(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i, str) == null) {
            this.I.h(i);
            this.I.g(str);
        }
    }

    public void r(Context context, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, context, postData) == null) {
            if (postData != null && ListUtils.getCount(postData.i0) >= 2) {
                List<PbContent> list = postData.i0;
                TbRichText c0 = TbRichTextView.c0(ListUtils.subList(list, 1, list.size()), true);
                j(c0, postData.T());
                this.A.setText(c0);
                this.O = true;
                return;
            }
            this.O = false;
        }
    }

    public void s(List<PbContent> list, String str, ThreadData threadData, boolean z, boolean z2) {
        String str2;
        TbRichText tbRichText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{list, str, threadData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (ListUtils.isEmpty(list) && StringUtils.isNull(str)) {
                return;
            }
            if (!ListUtils.isEmpty(list)) {
                str2 = xs5.G(list).toString();
            } else {
                str2 = str;
            }
            int i = 0;
            if (this.q.getPaint().measureText(str2, 0, str2.length()) + (this.q.getTextSize() * 2.0f) > this.L * 2 || z) {
                int i2 = this.M;
                if (i2 != 1 && i2 != 2) {
                    i = 1;
                } else {
                    i = this.M;
                }
            }
            a(i);
            if (!ListUtils.isEmpty(list)) {
                tbRichText = TbRichTextView.d0(list, true, threadData);
            } else {
                tbRichText = new TbRichText(hj7.c(str, 1));
            }
            TbRichText tbRichText2 = tbRichText;
            j(tbRichText2, threadData.getItemStar());
            if (z2) {
                i(tbRichText2);
            }
            this.p.setText(tbRichText2, false, this.P, false, true);
        }
    }
}
