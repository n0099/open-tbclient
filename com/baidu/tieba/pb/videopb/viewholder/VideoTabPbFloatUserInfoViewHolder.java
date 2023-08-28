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
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.HeadWorldCupFlagLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.level.TbLevelView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.di;
import com.baidu.tieba.fn9;
import com.baidu.tieba.g16;
import com.baidu.tieba.hg;
import com.baidu.tieba.nk9;
import com.baidu.tieba.nx5;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.pc8;
import com.baidu.tieba.px5;
import com.baidu.tieba.zfa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.HeadItem;
import tbclient.PbContent;
/* loaded from: classes7.dex */
public class VideoTabPbFloatUserInfoViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadWorldCupFlagLayout A;
    public final int B;
    public int C;
    public View.OnLayoutChangeListener D;
    public int a;
    public View b;
    public View c;
    public ImageView d;
    public HeadPendantClickableView e;
    public TBLottieAnimationView f;
    public UserIconBox g;
    public TextView h;
    public TextView i;
    public TbImageView j;
    public TbLevelView k;
    public UserIconBox l;
    public TextView m;
    public TextView n;
    public PbFirstFloorUserLikeButton o;
    public RelativeLayout p;
    public TbRichTextView q;
    public TbRichTextView r;
    public TextView s;
    public View t;
    public TextView u;
    public FrameLayout v;
    public fn9 w;
    public boolean x;
    public AbsVideoPbFragment y;
    public TbImageView z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoTabPbFloatUserInfoViewHolder a;

        /* renamed from: com.baidu.tieba.pb.videopb.viewholder.VideoTabPbFloatUserInfoViewHolder$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0450a extends hg {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0450a(a aVar) {
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

            @Override // com.baidu.tieba.hg, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                    super.onAnimationEnd(animation);
                    this.a.a.o.setVisibility(8);
                    this.a.a.o.setText("");
                    this.a.a.g();
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
                alphaAnimation.setAnimationListener(new C0450a(this));
                this.a.o.startAnimation(alphaAnimation);
            }
        }
    }

    /* loaded from: classes7.dex */
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
                this.a.f.playAnimation();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ VideoTabPbFloatUserInfoViewHolder b;

        public c(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoTabPbFloatUserInfoViewHolder, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = videoTabPbFloatUserInfoViewHolder;
            this.a = metaData;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) && i3 - i > 0) {
                this.b.o(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoTabPbFloatUserInfoViewHolder a;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public d(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
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

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                if (this.a.D != null) {
                    VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder = this.a;
                    videoTabPbFloatUserInfoViewHolder.itemView.removeOnLayoutChangeListener(videoTabPbFloatUserInfoViewHolder.D);
                }
                this.a.itemView.removeOnAttachStateChangeListener(this);
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
        this.B = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
        this.C = 0;
        this.D = null;
        this.b = view2;
        this.y = absVideoPbFragment;
        this.c = view2.findViewById(R.id.obfuscated_res_0x7f092931);
        this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092934);
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view2.findViewById(R.id.obfuscated_res_0x7f092930);
        this.e = headPendantClickableView;
        headPendantClickableView.setHasPendantStyle();
        this.e.getHeadView().setIsRound(true);
        this.e.getHeadView().setDrawBorder(true);
        this.e.getHeadView().setBorderWidth(BdUtilHelper.getDimens(context, R.dimen.L_X01));
        this.e.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.e.getHeadView().setPlaceHolder(1);
        this.e.setBigVDimenSize(R.dimen.tbds36);
        this.f = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f09293b);
        this.g = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f092942);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09293c);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092939);
        this.j = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09290b);
        this.k = (TbLevelView) view2.findViewById(R.id.obfuscated_res_0x7f092938);
        this.l = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f09293d);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09292a);
        this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09292d);
        this.u = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09292e);
        PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = (PbFirstFloorUserLikeButton) view2.findViewById(R.id.obfuscated_res_0x7f09292b);
        this.o = pbFirstFloorUserLikeButton;
        pbFirstFloorUserLikeButton.setIsShowIcon(true);
        this.o.setAfterStatusUpdateListener(new a(this));
        this.p = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09293f);
        TbRichTextView tbRichTextView = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f092935);
        this.q = tbRichTextView;
        tbRichTextView.setLayoutStrategy(new nk9(this.q.getLayoutStrategy()));
        this.q.getLayoutStrategy().o(1.0f);
        this.q.getLayoutStrategy().k(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        this.q.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X06));
        this.q.setTextBold();
        if (this.x) {
            this.r.setVisibility(0);
        }
        TbRichTextView tbRichTextView2 = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f09293e);
        this.r = tbRichTextView2;
        tbRichTextView2.setIsNeedResizeEmotion(true);
        nk9 nk9Var = new nk9(this.r.getLayoutStrategy());
        nk9Var.x(TbConfig.getContentSize());
        nk9Var.o(0.9f);
        nk9Var.k(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003));
        this.r.setLayoutStrategy(nk9Var);
        this.r.setMaxLines(3);
        this.r.setAddExpandableListener(true);
        this.v = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092937);
        fn9 fn9Var = new fn9(absVideoPbFragment, this.v);
        this.w = fn9Var;
        fn9Var.f = 2;
        this.s = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092936);
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f09290c);
        this.t = findViewById;
        findViewById.setAlpha(0.5f);
        this.z = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091ac4);
        this.A = (HeadWorldCupFlagLayout) view2.findViewById(R.id.world_cup_flag);
    }

    public void e(@NonNull MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, metaData) == null) && this.D == null) {
            c cVar = new c(this, metaData);
            this.D = cVar;
            this.itemView.addOnLayoutChangeListener(cVar);
            d();
        }
    }

    public final void h(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (tBLottieAnimationView = this.f) != null) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.k.a();
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (z) {
                SkinManager.setViewTextColor(this.h, R.color.CAM_X0301, 1);
            } else {
                SkinManager.setViewTextColor(this.h, R.color.CAM_X0105, 1);
            }
        }
    }

    public void p(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            this.e.setOnClickListener(onClickListener);
            this.g.setOnClickListener(onClickListener);
            this.h.setOnClickListener(onClickListener);
            this.l.setOnClickListener(onClickListener);
            this.j.setOnClickListener(onClickListener);
            this.k.setOnClickListener(onClickListener);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0202);
            this.m.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.n.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.u.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.o.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.q.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.r.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.w.e();
            SkinManager.setBackgroundColor(this.t, R.color.CAM_X0201);
            if (this.a != skinType) {
                h(skinType);
            }
            this.a = skinType;
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.itemView.addOnAttachStateChangeListener(new d(this));
        }
    }

    public void g() {
        TbImageView tbImageView;
        RelativeLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (tbImageView = this.z) != null && (layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams()) != null) {
            layoutParams.addRule(11);
            layoutParams.removeRule(0);
            this.z.setLayoutParams(layoutParams);
        }
    }

    public final void f(List<TbRichTextData> list, HeadItem headItem) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, list, headItem) == null) {
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
                spannableStringBuilder.append((CharSequence) g16.s(i, true));
            }
            tbRichTextData.O(spannableStringBuilder);
            ListUtils.add(list, 0, tbRichTextData);
        }
    }

    public void k(TbRichText tbRichText, List<HeadItem> list) {
        int count;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbRichText, list) == null) && (count = ListUtils.getCount(list)) != 0 && list != null) {
            ArrayList<TbRichTextData> P = tbRichText.P();
            if (count == 1) {
                TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(P, 0);
                if (tbRichTextData == null || tbRichTextData.getType() != 1) {
                    tbRichTextData = new TbRichTextData(1);
                    ListUtils.add(P, 0, tbRichTextData);
                }
                HeadItem headItem = (HeadItem) ListUtils.getItem(list, 0);
                if (headItem != null) {
                    try {
                        i = Integer.parseInt(headItem.content);
                    } catch (NumberFormatException e) {
                        BdLog.e(e);
                        i = 0;
                    }
                    tbRichTextData.x0(g16.s(i, false));
                    return;
                }
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                HeadItem headItem2 = list.get(size);
                if (headItem2 != null) {
                    f(P, headItem2);
                }
            }
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                this.f.setVisibility(0);
                if (!this.f.isAnimating()) {
                    this.f.setSpeed(0.8f);
                    this.f.setRepeatCount(-1);
                    this.f.post(new b(this));
                    return;
                }
                return;
            }
            this.f.setVisibility(8);
            if (this.f.isAnimating()) {
                this.f.cancelAnimation();
            }
        }
    }

    public void j(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, tbRichText) != null) || tbRichText == null) {
            return;
        }
        ArrayList<TbRichTextData> P = tbRichText.P();
        TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(P, 0);
        if (tbRichTextData == null || tbRichTextData.getType() != 1) {
            tbRichTextData = new TbRichTextData(1);
            ListUtils.add(P, 0, tbRichTextData);
        }
        tbRichTextData.x0(g16.u());
    }

    public void m(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z) {
                this.d.setImageResource(R.drawable.pic_frs_headlines_n);
                this.d.setVisibility(0);
            } else if (z2 && z3) {
                this.d.setImageResource(R.drawable.obfuscated_res_0x7f08121f);
                this.d.setVisibility(0);
            } else if (z2) {
                this.d.setImageResource(R.drawable.obfuscated_res_0x7f08121d);
                this.d.setVisibility(0);
            } else if (z3) {
                this.d.setImageResource(R.drawable.obfuscated_res_0x7f08121e);
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
        }
    }

    public final void o(@NonNull MetaData metaData) {
        int width;
        int right;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, metaData) == null) {
            if (this.o.getVisibility() == 0) {
                width = this.o.getLeft();
                right = this.c.getRight();
            } else {
                width = this.itemView.getWidth();
                right = this.c.getRight();
            }
            int i = (width - right) - this.B;
            if (this.C == i) {
                return;
            }
            this.C = i;
            if (di.isEmpty(metaData.getName_show())) {
                string = StringUtils.string(metaData.getUserName());
            } else {
                string = StringUtils.string(metaData.getName_show());
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.g);
            arrayList.add(this.i);
            arrayList.add(this.j);
            arrayList.add(this.k);
            nx5.c(i, string, this.h, this.k, arrayList, this.l);
            px5.a(this.h, this.g, this.j, this.k, this.l, 1);
        }
    }

    public void q(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i, str) == null) {
            this.w.h(i);
            this.w.g(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
            if (i == 8) {
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f09293a);
                layoutParams.setMargins(0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X002), 0, 0);
            } else {
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f092937);
                layoutParams.setMargins(0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4), 0, 0);
            }
            this.p.setLayoutParams(layoutParams);
        }
    }

    public void r(Context context, zfa zfaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, context, zfaVar) == null) {
            if (zfaVar != null && ListUtils.getCount(zfaVar.j0) >= 2) {
                List<PbContent> list = zfaVar.j0;
                TbRichText c0 = TbRichTextView.c0(ListUtils.subList(list, 1, list.size()), true);
                k(c0, zfaVar.X());
                this.r.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X07));
                this.r.setText(c0);
                this.x = true;
                return;
            }
            this.x = false;
        }
    }

    public void s(List<PbContent> list, String str, ThreadData threadData, boolean z, boolean z2) {
        TbRichText tbRichText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{list, str, threadData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (ListUtils.isEmpty(list) && StringUtils.isNull(str)) {
                return;
            }
            if (z) {
                this.r.setVisibility(0);
            }
            if (!ListUtils.isEmpty(list)) {
                tbRichText = TbRichTextView.d0(list, true, threadData);
            } else {
                tbRichText = new TbRichText(pc8.c(str, 1));
            }
            TbRichText tbRichText2 = tbRichText;
            k(tbRichText2, threadData.getItemStar());
            if (z2) {
                j(tbRichText2);
            }
            this.q.setText(tbRichText2, false, this.y, false, true);
        }
    }
}
