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
import com.baidu.tieba.dx7;
import com.baidu.tieba.lz7;
import com.baidu.tieba.mm5;
import com.baidu.tieba.n97;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.v18;
import com.baidu.tieba.xi;
import com.baidu.tieba.z18;
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
    public z18 I;
    public FrameLayout J;
    public v18 K;
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
        xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
        this.a = 3;
        this.b = view2;
        this.P = absVideoPbFragment;
        this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0921fe);
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view2.findViewById(R.id.obfuscated_res_0x7f090d6a);
        this.d = headPendantClickableView;
        headPendantClickableView.setHasPendantStyle();
        this.d.getHeadView().setIsRound(true);
        this.d.getHeadView().setDrawBorder(true);
        this.d.getHeadView().setBorderWidth(xi.g(context, R.dimen.L_X01));
        this.d.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.d.getHeadView().setPlaceHolder(1);
        this.d.setBigVDimenSize(R.dimen.tbds36);
        this.e = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f0924f4);
        this.f = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f09262e);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924fc);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924e8);
        this.i = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0924d1);
        this.j = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f09251e);
        this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903ae);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0909b0);
        this.m = (PbFirstFloorUserLikeButton) view2.findViewById(R.id.obfuscated_res_0x7f0906db);
        this.n = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091734);
        this.o = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f092576);
        this.p = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f092287);
        this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092272);
        this.y = view2.findViewById(R.id.obfuscated_res_0x7f092578);
        this.t = view2.findViewById(R.id.obfuscated_res_0x7f0925cb);
        this.u = view2.findViewById(R.id.obfuscated_res_0x7f092577);
        this.p.setLayoutStrategy(new lz7(this.p.getLayoutStrategy()));
        this.p.setTextSize(TbConfig.getContentSize());
        this.p.setTextBold();
        this.q.setTextSize(0, TbConfig.getContentSize());
        this.q.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.r = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090474);
        this.s = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090479);
        this.L = (xi.l(TbadkCoreApplication.getInst()) - this.o.getPaddingLeft()) - this.o.getPaddingRight();
        a(0);
        this.v = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a30);
        this.w = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b2b);
        this.x = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b24);
        this.B = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b21);
        this.C = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a31);
        this.D = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b2c);
        this.E = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b25);
        this.F = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b22);
        this.z = (VoteView) view2.findViewById(R.id.obfuscated_res_0x7f0918de);
        TbRichTextView tbRichTextView = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f092539);
        this.A = tbRichTextView;
        tbRichTextView.setIsShowOrderOrDownloadBtn(true);
        this.A.setIsNeedResizeEmotion(true);
        this.N = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091870);
        lz7 lz7Var = new lz7(this.A.getLayoutStrategy());
        lz7Var.v(TbConfig.getContentSize());
        lz7Var.n(0.9f);
        this.A.setLayoutStrategy(lz7Var);
        this.H = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09249d);
        z18 z18Var = new z18(absVideoPbFragment, this.H);
        this.I = z18Var;
        z18Var.f = 2;
        FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090f4a);
        this.J = frameLayout;
        this.K = new v18(frameLayout);
        this.G = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09246c);
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
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.r, R.drawable.obfuscated_res_0x7f080968, R.color.CAM_X0105, null);
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
                spannableStringBuilder.append((CharSequence) mm5.q(i, true));
            }
            tbRichTextData.A(spannableStringBuilder);
            ListUtils.add(list, 0, tbRichTextData);
        }
    }

    public void j(TbRichText tbRichText, List<HeadItem> list) {
        int count;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, tbRichText, list) == null) && (count = ListUtils.getCount(list)) != 0 && list != null) {
            ArrayList<TbRichTextData> B = tbRichText.B();
            if (count == 1) {
                TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(B, 0);
                if (tbRichTextData == null || tbRichTextData.getType() != 1) {
                    tbRichTextData = new TbRichTextData(1);
                    ListUtils.add(B, 0, tbRichTextData);
                }
                HeadItem headItem = (HeadItem) ListUtils.getItem(list, 0);
                if (headItem != null) {
                    try {
                        i = Integer.parseInt(headItem.content);
                    } catch (NumberFormatException unused) {
                        i = 0;
                    }
                    tbRichTextData.e0(mm5.q(i, false));
                    return;
                }
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                HeadItem headItem2 = list.get(size);
                if (headItem2 != null) {
                    e(B, headItem2);
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
        ArrayList<TbRichTextData> B = tbRichText.B();
        TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(B, 0);
        if (tbRichTextData == null || tbRichTextData.getType() != 1) {
            tbRichTextData = new TbRichTextData(1);
            ListUtils.add(B, 0, tbRichTextData);
        }
        tbRichTextData.e0(mm5.s());
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.G, R.color.CAM_X0202);
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.l.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.m.r(TbadkCoreApplication.getInst().getSkinType());
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
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080f68);
                this.c.setVisibility(0);
            } else if (z2 && z3) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080fa9);
                this.c.setVisibility(0);
            } else if (z2) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080fa7);
                this.c.setVisibility(0);
            } else if (z3) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080fa8);
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
        }
    }

    public void o(@NonNull dx7 dx7Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, dx7Var, i) == null) {
            this.K.e(dx7Var, i, null);
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
            if (postData != null && ListUtils.getCount(postData.h0) >= 2) {
                List<PbContent> list = postData.h0;
                TbRichText X = TbRichTextView.X(ListUtils.subList(list, 1, list.size()), true);
                j(X, postData.R());
                this.A.setText(X);
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
                str2 = mm5.E(list).toString();
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
                tbRichText = TbRichTextView.Y(list, true, threadData);
            } else {
                tbRichText = new TbRichText(n97.c(str, 1));
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
