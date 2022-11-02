package com.baidu.tieba.pb.videopb.viewholder;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.lz7;
import com.baidu.tieba.mm5;
import com.baidu.tieba.n97;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.xi;
import com.baidu.tieba.yg;
import com.baidu.tieba.z18;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.HeadItem;
import tbclient.PbContent;
/* loaded from: classes5.dex */
public class VideoTabPbFloatUserInfoViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public View b;
    public ImageView c;
    public HeadPendantClickableView d;
    public TBLottieAnimationView e;
    public UserIconBox f;
    public TextView g;
    public TextView h;
    public TbImageView i;
    public ImageView j;
    public UserIconBox k;
    public TextView l;
    public TextView m;
    public PbFirstFloorUserLikeButton n;
    public RelativeLayout o;
    public TbRichTextView p;
    public TbRichTextView q;
    public TextView r;
    public View s;
    public TextView t;
    public FrameLayout u;
    public z18 v;
    public boolean w;
    public AbsVideoPbFragment x;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoTabPbFloatUserInfoViewHolder a;

        /* renamed from: com.baidu.tieba.pb.videopb.viewholder.VideoTabPbFloatUserInfoViewHolder$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0391a extends yg {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0391a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.yg, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                    super.onAnimationEnd(animation);
                    this.a.a.n.setVisibility(8);
                    this.a.a.n.setText("");
                }
            }
        }

        public a(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoTabPbFloatUserInfoViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoTabPbFloatUserInfoViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setStartOffset(500L);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new C0391a(this));
                this.a.n.startAnimation(alphaAnimation);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoTabPbFloatUserInfoViewHolder a;

        public b(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoTabPbFloatUserInfoViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoTabPbFloatUserInfoViewHolder;
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
    public VideoTabPbFloatUserInfoViewHolder(Context context, View view2, AbsVideoPbFragment absVideoPbFragment) {
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
        this.a = 3;
        this.b = view2;
        this.x = absVideoPbFragment;
        this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0925b8);
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view2.findViewById(R.id.obfuscated_res_0x7f0925b4);
        this.d = headPendantClickableView;
        headPendantClickableView.setHasPendantStyle();
        this.d.getHeadView().setIsRound(true);
        this.d.getHeadView().setDrawBorder(true);
        this.d.getHeadView().setBorderWidth(xi.g(context, R.dimen.L_X01));
        this.d.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.d.getHeadView().setPlaceHolder(1);
        this.d.setBigVDimenSize(R.dimen.tbds36);
        this.e = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f0925bf);
        this.f = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f0925c6);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925c0);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925bd);
        this.i = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09258c);
        this.j = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0925bc);
        this.k = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f0925c1);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925ae);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925b1);
        this.t = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925b2);
        PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = (PbFirstFloorUserLikeButton) view2.findViewById(R.id.obfuscated_res_0x7f0925af);
        this.n = pbFirstFloorUserLikeButton;
        pbFirstFloorUserLikeButton.setIsShowIcon(true);
        this.n.setAfterStatusUpdateListener(new a(this));
        this.o = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0925c3);
        TbRichTextView tbRichTextView = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f0925b9);
        this.p = tbRichTextView;
        tbRichTextView.setLayoutStrategy(new lz7(this.p.getLayoutStrategy()));
        this.p.getLayoutStrategy().n(1.0f);
        this.p.getLayoutStrategy().j(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        this.p.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X06));
        this.p.setTextBold();
        if (this.w) {
            this.q.setVisibility(0);
        }
        TbRichTextView tbRichTextView2 = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f0925c2);
        this.q = tbRichTextView2;
        tbRichTextView2.setIsNeedResizeEmotion(true);
        lz7 lz7Var = new lz7(this.q.getLayoutStrategy());
        lz7Var.v(TbConfig.getContentSize());
        lz7Var.n(0.9f);
        lz7Var.j(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003));
        this.q.setLayoutStrategy(lz7Var);
        this.q.setMaxLines(3);
        this.q.setAddExpandableListener(true);
        this.u = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0925bb);
        z18 z18Var = new z18(absVideoPbFragment, this.u);
        this.v = z18Var;
        z18Var.f = 2;
        this.r = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925ba);
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f09258d);
        this.s = findViewById;
        findViewById.setAlpha(0.5f);
    }

    public final void a(List<TbRichTextData> list, HeadItem headItem) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, list, headItem) == null) {
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
                } catch (NumberFormatException e) {
                    BdLog.e(e);
                    i = 0;
                }
                spannableStringBuilder.append((CharSequence) mm5.q(i, true));
            }
            tbRichTextData.A(spannableStringBuilder);
            ListUtils.add(list, 0, tbRichTextData);
        }
    }

    public void e(TbRichText tbRichText, List<HeadItem> list) {
        int count;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, tbRichText, list) == null) && (count = ListUtils.getCount(list)) != 0 && list != null) {
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
                    } catch (NumberFormatException e) {
                        BdLog.e(e);
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
                    a(B, headItem2);
                }
            }
        }
    }

    public final void b(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (tBLottieAnimationView = this.e) != null) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && i > 0) {
            SkinManager.setImageResource(this.j, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                SkinManager.setViewTextColor(this.g, R.color.CAM_X0301, 1);
            } else {
                SkinManager.setViewTextColor(this.g, R.color.CAM_X0105, 1);
            }
        }
    }

    public void j(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.d.setOnClickListener(onClickListener);
            this.f.setOnClickListener(onClickListener);
            this.g.setOnClickListener(onClickListener);
            this.k.setOnClickListener(onClickListener);
            this.i.setOnClickListener(onClickListener);
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.e.setVisibility(0);
                if (!this.e.isAnimating()) {
                    this.e.setSpeed(0.8f);
                    this.e.setRepeatCount(-1);
                    this.e.post(new b(this));
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

    public void d(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, tbRichText) != null) || tbRichText == null) {
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

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0202);
            this.l.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.m.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.t.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.n.r(TbadkCoreApplication.getInst().getSkinType());
            this.p.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.q.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.v.e();
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0201);
            if (this.a != skinType) {
                b(skinType);
            }
            this.a = skinType;
        }
    }

    public void h(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
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

    public void k(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, str) == null) {
            this.v.h(i);
            this.v.g(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
            if (i == 8) {
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f0925be);
                layoutParams.setMargins(0, xi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002), 0, 0);
            } else {
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f0925bb);
                layoutParams.setMargins(0, xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds4), 0, 0);
            }
            this.o.setLayoutParams(layoutParams);
        }
    }

    public void l(Context context, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, context, postData) == null) {
            if (postData != null && ListUtils.getCount(postData.h0) >= 2) {
                List<PbContent> list = postData.h0;
                TbRichText X = TbRichTextView.X(ListUtils.subList(list, 1, list.size()), true);
                e(X, postData.R());
                this.q.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X07));
                this.q.setText(X);
                this.w = true;
                return;
            }
            this.w = false;
        }
    }

    public void m(List<PbContent> list, String str, ThreadData threadData, boolean z, boolean z2) {
        TbRichText tbRichText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{list, str, threadData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (ListUtils.isEmpty(list) && StringUtils.isNull(str)) {
                return;
            }
            if (z) {
                this.q.setVisibility(0);
            }
            if (!ListUtils.isEmpty(list)) {
                tbRichText = TbRichTextView.Y(list, true, threadData);
            } else {
                tbRichText = new TbRichText(n97.c(str, 1));
            }
            TbRichText tbRichText2 = tbRichText;
            e(tbRichText2, threadData.getItemStar());
            if (z2) {
                d(tbRichText2);
            }
            this.p.setText(tbRichText2, false, this.x, false, true);
        }
    }
}
