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
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b47;
import com.repackage.ew7;
import com.repackage.pg;
import com.repackage.pi;
import com.repackage.rg5;
import com.repackage.ut7;
import java.util.ArrayList;
import java.util.List;
import tbclient.HeadItem;
import tbclient.PbContent;
/* loaded from: classes3.dex */
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
    public ImageView i;
    public UserIconBox j;
    public TextView k;
    public TextView l;
    public PbFirstFloorUserLikeButton m;
    public RelativeLayout n;
    public TbRichTextView o;
    public TbRichTextView p;
    public TextView q;
    public TextView r;
    public FrameLayout s;
    public ew7 t;
    public boolean u;
    public AbsVideoPbFragment v;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoTabPbFloatUserInfoViewHolder a;

        /* renamed from: com.baidu.tieba.pb.videopb.viewholder.VideoTabPbFloatUserInfoViewHolder$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0236a extends pg {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0236a(a aVar) {
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

            @Override // com.repackage.pg, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                    super.onAnimationEnd(animation);
                    this.a.a.m.setVisibility(8);
                    this.a.a.m.setText("");
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
                alphaAnimation.setAnimationListener(new C0236a(this));
                this.a.m.startAnimation(alphaAnimation);
            }
        }
    }

    /* loaded from: classes3.dex */
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
        this.v = absVideoPbFragment;
        this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0923eb);
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view2.findViewById(R.id.obfuscated_res_0x7f0923e7);
        this.d = headPendantClickableView;
        headPendantClickableView.setHasPendantStyle();
        this.d.getHeadView().setIsRound(true);
        this.d.getHeadView().setDrawBorder(true);
        this.d.getHeadView().setBorderWidth(pi.f(context, R.dimen.L_X01));
        this.d.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.d.getHeadView().setPlaceHolder(1);
        this.d.setBigVDimenSize(R.dimen.tbds36);
        this.e = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f0923f2);
        this.f = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f0923f9);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923f3);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923f0);
        this.i = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0923ef);
        this.j = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f0923f4);
        this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923e1);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923e4);
        this.r = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923e5);
        PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = (PbFirstFloorUserLikeButton) view2.findViewById(R.id.obfuscated_res_0x7f0923e2);
        this.m = pbFirstFloorUserLikeButton;
        pbFirstFloorUserLikeButton.setIsShowIcon(true);
        this.m.setAfterStatusUpdateListener(new a(this));
        this.n = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0923f6);
        TbRichTextView tbRichTextView = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f0923ec);
        this.o = tbRichTextView;
        tbRichTextView.setLayoutStrategy(new ut7(this.o.getLayoutStrategy()));
        this.o.getLayoutStrategy().n(1.0f);
        this.o.getLayoutStrategy().j(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        this.o.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X06));
        this.o.setTextBold();
        if (this.u) {
            this.p.setVisibility(0);
        }
        TbRichTextView tbRichTextView2 = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f0923f5);
        this.p = tbRichTextView2;
        tbRichTextView2.setIsNeedResizeEmotion(true);
        ut7 ut7Var = new ut7(this.p.getLayoutStrategy());
        ut7Var.v(TbConfig.getContentSize());
        ut7Var.n(0.9f);
        ut7Var.j(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003));
        this.p.setLayoutStrategy(ut7Var);
        this.p.setMaxLines(3);
        this.p.setAddExpandableListener(true);
        FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0923ee);
        this.s = frameLayout;
        ew7 ew7Var = new ew7(absVideoPbFragment, frameLayout);
        this.t = ew7Var;
        ew7Var.f = 2;
        this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923ed);
    }

    public final void c(List<TbRichTextData> list, HeadItem headItem) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, list, headItem) == null) {
            TbRichTextData tbRichTextData = new TbRichTextData(1);
            StringBuilder sb = new StringBuilder();
            sb.append(headItem.name);
            sb.append(": ");
            sb.append(headItem.type.intValue() == 1 ? headItem.content : " ");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new SpannableString(sb.toString()));
            if (headItem.type.intValue() == 2) {
                try {
                    i = Integer.parseInt(headItem.content);
                } catch (NumberFormatException e) {
                    BdLog.e(e);
                    i = 0;
                }
                spannableStringBuilder.append((CharSequence) rg5.q(i, true));
            }
            tbRichTextData.B(spannableStringBuilder);
            ListUtils.add(list, 0, tbRichTextData);
        }
    }

    public final void d(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (tBLottieAnimationView = this.e) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.e.setVisibility(0);
                if (this.e.isAnimating()) {
                    return;
                }
                this.e.setSpeed(0.8f);
                this.e.setRepeatCount(-1);
                this.e.post(new b(this));
                return;
            }
            this.e.setVisibility(8);
            if (this.e.isAnimating()) {
                this.e.cancelAnimation();
            }
        }
    }

    public void f(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tbRichText) == null) || tbRichText == null) {
            return;
        }
        ArrayList<TbRichTextData> C = tbRichText.C();
        TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(C, 0);
        if (tbRichTextData == null || tbRichTextData.getType() != 1) {
            tbRichTextData = new TbRichTextData(1);
            ListUtils.add(C, 0, tbRichTextData);
        }
        tbRichTextData.f0(rg5.s());
    }

    public void g(TbRichText tbRichText, List<HeadItem> list) {
        int count;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, tbRichText, list) == null) || (count = ListUtils.getCount(list)) == 0 || list == null) {
            return;
        }
        ArrayList<TbRichTextData> C = tbRichText.C();
        if (count == 1) {
            TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(C, 0);
            if (tbRichTextData == null || tbRichTextData.getType() != 1) {
                tbRichTextData = new TbRichTextData(1);
                ListUtils.add(C, 0, tbRichTextData);
            }
            HeadItem headItem = (HeadItem) ListUtils.getItem(list, 0);
            if (headItem != null) {
                try {
                    i = Integer.parseInt(headItem.content);
                } catch (NumberFormatException e) {
                    BdLog.e(e);
                    i = 0;
                }
                tbRichTextData.f0(rg5.q(i, false));
                return;
            }
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            HeadItem headItem2 = list.get(size);
            if (headItem2 != null) {
                c(C, headItem2);
            }
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || i <= 0) {
            return;
        }
        SkinManager.setImageResource(this.i, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.q, R.color.CAM_X0202);
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.l.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.r.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.m.r(TbadkCoreApplication.getInst().getSkinType());
            this.o.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.p.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.t.d();
            if (this.a != skinType) {
                d(skinType);
            }
            this.a = skinType;
        }
    }

    public void j(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080ea6);
                this.c.setVisibility(0);
            } else if (z2 && z3) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080ee6);
                this.c.setVisibility(0);
            } else if (z2) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080ee4);
                this.c.setVisibility(0);
            } else if (z3) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080ee5);
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                SkinManager.setViewTextColor(this.g, R.color.CAM_X0301, 1);
            } else {
                SkinManager.setViewTextColor(this.g, R.color.CAM_X0105, 1);
            }
        }
    }

    public void l(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.d.setOnClickListener(onClickListener);
            this.f.setOnClickListener(onClickListener);
            this.g.setOnClickListener(onClickListener);
            this.j.setOnClickListener(onClickListener);
        }
    }

    public void m(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, str) == null) {
            this.t.g(i);
            this.t.f(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
            if (i == 8) {
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f0923f1);
                layoutParams.setMargins(0, pi.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X002), 0, 0);
            } else {
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f0923ee);
                layoutParams.setMargins(0, pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds4), 0, 0);
            }
            this.n.setLayoutParams(layoutParams);
        }
    }

    public void n(Context context, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, context, postData) == null) {
            if (postData != null && ListUtils.getCount(postData.m0) >= 2) {
                List<PbContent> list = postData.m0;
                TbRichText X = TbRichTextView.X(ListUtils.subList(list, 1, list.size()), true);
                g(X, postData.L());
                this.p.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X07));
                this.p.setText(X);
                this.u = true;
                return;
            }
            this.u = false;
        }
    }

    public void o(List<PbContent> list, String str, ThreadData threadData, boolean z, boolean z2) {
        TbRichText tbRichText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{list, str, threadData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (ListUtils.isEmpty(list) && StringUtils.isNull(str)) {
                return;
            }
            if (z) {
                this.p.setVisibility(0);
            }
            if (!ListUtils.isEmpty(list)) {
                tbRichText = TbRichTextView.Y(list, true, threadData);
            } else {
                tbRichText = new TbRichText(b47.c(str, 1));
            }
            TbRichText tbRichText2 = tbRichText;
            g(tbRichText2, threadData.getItemStar());
            if (z2) {
                f(tbRichText2);
            }
            this.o.setText(tbRichText2, false, this.v, false, true);
        }
    }
}
