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
import c.a.d.f.m.d;
import c.a.d.f.p.n;
import c.a.o0.e1.n.e;
import c.a.p0.w2.m.f.i;
import c.a.p0.w2.m.f.i1.g;
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
import java.util.ArrayList;
import java.util.List;
import tbclient.HeadItem;
import tbclient.PbContent;
/* loaded from: classes5.dex */
public class VideoTabPbFloatUserInfoViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public View f35231b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f35232c;

    /* renamed from: d  reason: collision with root package name */
    public HeadPendantClickableView f35233d;

    /* renamed from: e  reason: collision with root package name */
    public TBLottieAnimationView f35234e;

    /* renamed from: f  reason: collision with root package name */
    public UserIconBox f35235f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f35236g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f35237h;
    public ImageView i;
    public UserIconBox j;
    public TextView k;
    public TextView l;
    public PbFirstFloorUserLikeButton m;
    public RelativeLayout n;
    public TbRichTextView o;
    public TbRichTextView p;
    public TextView q;
    public FrameLayout r;
    public g s;
    public boolean t;
    public AbsVideoPbFragment u;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoTabPbFloatUserInfoViewHolder a;

        /* renamed from: com.baidu.tieba.pb.videopb.viewholder.VideoTabPbFloatUserInfoViewHolder$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1886a extends d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C1886a(a aVar) {
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

            @Override // c.a.d.f.m.d, android.view.animation.Animation.AnimationListener
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setStartOffset(500L);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new C1886a(this));
                this.a.m.startAnimation(alphaAnimation);
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
                this.a.f35234e.playAnimation();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoTabPbFloatUserInfoViewHolder(Context context, View view, AbsVideoPbFragment absVideoPbFragment) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view, absVideoPbFragment};
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
        this.f35231b = view;
        this.u = absVideoPbFragment;
        this.f35232c = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f092382);
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view.findViewById(R.id.obfuscated_res_0x7f09237e);
        this.f35233d = headPendantClickableView;
        headPendantClickableView.setHasPendantStyle();
        this.f35233d.getHeadView().setIsRound(true);
        this.f35233d.getHeadView().setDrawBorder(true);
        this.f35233d.getHeadView().setBorderWidth(n.f(context, R.dimen.L_X01));
        this.f35233d.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f35233d.getHeadView().setPlaceHolder(1);
        this.f35233d.setBigVDimenSize(R.dimen.tbds36);
        this.f35234e = (TBLottieAnimationView) view.findViewById(R.id.obfuscated_res_0x7f092389);
        this.f35235f = (UserIconBox) view.findViewById(R.id.obfuscated_res_0x7f092390);
        this.f35236g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09238a);
        this.f35237h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092387);
        this.i = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f092386);
        this.j = (UserIconBox) view.findViewById(R.id.obfuscated_res_0x7f09238b);
        this.k = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092379);
        this.l = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09237c);
        PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = (PbFirstFloorUserLikeButton) view.findViewById(R.id.obfuscated_res_0x7f09237a);
        this.m = pbFirstFloorUserLikeButton;
        pbFirstFloorUserLikeButton.setIsShowIcon(true);
        this.m.setAfterStatusUpdateListener(new a(this));
        this.n = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f09238d);
        TbRichTextView tbRichTextView = (TbRichTextView) view.findViewById(R.id.obfuscated_res_0x7f092383);
        this.o = tbRichTextView;
        tbRichTextView.setLayoutStrategy(new i(this.o.getLayoutStrategy()));
        this.o.getLayoutStrategy().n(1.0f);
        this.o.getLayoutStrategy().j(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        this.o.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X06));
        this.o.setTextBold();
        if (this.t) {
            this.p.setVisibility(0);
        }
        TbRichTextView tbRichTextView2 = (TbRichTextView) view.findViewById(R.id.obfuscated_res_0x7f09238c);
        this.p = tbRichTextView2;
        tbRichTextView2.setIsNeedResizeEmotion(true);
        i iVar = new i(this.p.getLayoutStrategy());
        iVar.v(TbConfig.getContentSize());
        iVar.n(0.9f);
        iVar.j(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003));
        this.p.setLayoutStrategy(iVar);
        this.p.setMaxLines(3);
        this.p.setAddExpandableListener(true);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.obfuscated_res_0x7f092385);
        this.r = frameLayout;
        g gVar = new g(absVideoPbFragment, frameLayout);
        this.s = gVar;
        gVar.f20109f = 2;
        this.q = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092384);
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
                } catch (NumberFormatException e2) {
                    BdLog.e(e2);
                    i = 0;
                }
                spannableStringBuilder.append((CharSequence) e.q(i, true));
            }
            tbRichTextData.z(spannableStringBuilder);
            ListUtils.add(list, 0, tbRichTextData);
        }
    }

    public final void d(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (tBLottieAnimationView = this.f35234e) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.f35234e.setVisibility(0);
                if (this.f35234e.isAnimating()) {
                    return;
                }
                this.f35234e.setSpeed(0.8f);
                this.f35234e.setRepeatCount(-1);
                this.f35234e.post(new b(this));
                return;
            }
            this.f35234e.setVisibility(8);
            if (this.f35234e.isAnimating()) {
                this.f35234e.cancelAnimation();
            }
        }
    }

    public void f(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tbRichText) == null) || tbRichText == null) {
            return;
        }
        ArrayList<TbRichTextData> A = tbRichText.A();
        TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(A, 0);
        if (tbRichTextData == null || tbRichTextData.getType() != 1) {
            tbRichTextData = new TbRichTextData(1);
            ListUtils.add(A, 0, tbRichTextData);
        }
        tbRichTextData.d0(e.s());
    }

    public void g(TbRichText tbRichText, List<HeadItem> list) {
        int count;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, tbRichText, list) == null) || (count = ListUtils.getCount(list)) == 0 || list == null) {
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
                } catch (NumberFormatException e2) {
                    BdLog.e(e2);
                    i = 0;
                }
                tbRichTextData.d0(e.q(i, false));
                return;
            }
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            HeadItem headItem2 = list.get(size);
            if (headItem2 != null) {
                c(A, headItem2);
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
            SkinManager.setBackgroundColor(this.f35231b, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.q, R.color.CAM_X0202);
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.l.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.m.r(TbadkCoreApplication.getInst().getSkinType());
            this.o.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.p.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.s.d();
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
                this.f35232c.setImageResource(R.drawable.obfuscated_res_0x7f080efe);
                this.f35232c.setVisibility(0);
            } else if (z2 && z3) {
                this.f35232c.setImageResource(R.drawable.obfuscated_res_0x7f080f40);
                this.f35232c.setVisibility(0);
            } else if (z2) {
                this.f35232c.setImageResource(R.drawable.obfuscated_res_0x7f080f3e);
                this.f35232c.setVisibility(0);
            } else if (z3) {
                this.f35232c.setImageResource(R.drawable.obfuscated_res_0x7f080f3f);
                this.f35232c.setVisibility(0);
            } else {
                this.f35232c.setVisibility(8);
            }
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                SkinManager.setViewTextColor(this.f35236g, R.color.CAM_X0301, 1);
            } else {
                SkinManager.setViewTextColor(this.f35236g, R.color.CAM_X0105, 1);
            }
        }
    }

    public void l(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.f35233d.setOnClickListener(onClickListener);
            this.f35235f.setOnClickListener(onClickListener);
            this.f35236g.setOnClickListener(onClickListener);
            this.j.setOnClickListener(onClickListener);
        }
    }

    public void m(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, str) == null) {
            this.s.g(i);
            this.s.f(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
            if (i == 8) {
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f092388);
                layoutParams.setMargins(0, n.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X002), 0, 0);
            } else {
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f092385);
                layoutParams.setMargins(0, n.f(TbadkCoreApplication.getInst(), R.dimen.tbds4), 0, 0);
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
                g(X, postData.I());
                this.p.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X07));
                this.p.setText(X);
                this.t = true;
                return;
            }
            this.t = false;
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
                tbRichText = new TbRichText(c.a.p0.u1.f.a.d(str, 1));
            }
            TbRichText tbRichText2 = tbRichText;
            g(tbRichText2, threadData.getItemStar());
            if (z2) {
                f(tbRichText2);
            }
            this.o.setText(tbRichText2, false, this.u, false, true);
        }
    }
}
