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
import d.a.d.e.m.d;
import d.a.d.e.p.l;
import d.a.p0.s.q.b2;
import d.a.q0.h2.k.e.b1.e;
import d.a.q0.h2.k.e.f;
import java.util.ArrayList;
import java.util.List;
import tbclient.HeadItem;
import tbclient.PbContent;
/* loaded from: classes4.dex */
public class VideoTabPbFloatUserInfoViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f19976a;

    /* renamed from: b  reason: collision with root package name */
    public View f19977b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f19978c;

    /* renamed from: d  reason: collision with root package name */
    public HeadPendantClickableView f19979d;

    /* renamed from: e  reason: collision with root package name */
    public TBLottieAnimationView f19980e;

    /* renamed from: f  reason: collision with root package name */
    public UserIconBox f19981f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19982g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19983h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f19984i;
    public UserIconBox j;
    public TextView k;
    public TextView l;
    public PbFirstFloorUserLikeButton m;
    public RelativeLayout n;
    public TbRichTextView o;
    public TbRichTextView p;
    public TextView q;
    public FrameLayout r;
    public e s;
    public boolean t;
    public AbsVideoPbFragment u;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoTabPbFloatUserInfoViewHolder f19985e;

        /* renamed from: com.baidu.tieba.pb.videopb.viewholder.VideoTabPbFloatUserInfoViewHolder$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0235a extends d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f19986a;

            public C0235a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19986a = aVar;
            }

            @Override // d.a.d.e.m.d, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                    super.onAnimationEnd(animation);
                    this.f19986a.f19985e.m.setVisibility(8);
                    this.f19986a.f19985e.m.setText("");
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19985e = videoTabPbFloatUserInfoViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setStartOffset(500L);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new C0235a(this));
                this.f19985e.m.startAnimation(alphaAnimation);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoTabPbFloatUserInfoViewHolder f19987e;

        public b(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoTabPbFloatUserInfoViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19987e = videoTabPbFloatUserInfoViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19987e.f19980e.playAnimation();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19976a = 3;
        this.f19977b = view;
        this.u = absVideoPbFragment;
        this.f19978c = (ImageView) view.findViewById(R.id.video_tab_thread_stamp_video_info_item);
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view.findViewById(R.id.video_tab_head_view_video_info_item);
        this.f19979d = headPendantClickableView;
        headPendantClickableView.setHasPendantStyle();
        this.f19979d.getHeadView().setIsRound(true);
        this.f19979d.getHeadView().setDrawBorder(true);
        this.f19979d.getHeadView().setBorderWidth(l.g(context, R.dimen.L_X01));
        this.f19979d.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f19979d.getHeadView().setPlaceHolder(1);
        this.f19979d.setBigVDimenSize(R.dimen.tbds27);
        this.f19980e = (TBLottieAnimationView) view.findViewById(R.id.video_tab_user_living_lottie);
        this.f19981f = (UserIconBox) view.findViewById(R.id.video_tab_vip_icon_video_info_item);
        this.f19982g = (TextView) view.findViewById(R.id.video_tab_user_name_video_info_item);
        this.f19983h = (TextView) view.findViewById(R.id.video_tab_user_identity_video_info_item);
        this.f19984i = (ImageView) view.findViewById(R.id.video_tab_user_forum_level_video_info_item);
        this.j = (UserIconBox) view.findViewById(R.id.video_tab_user_yinji_video_info_item);
        this.k = (TextView) view.findViewById(R.id.video_tab_bjh_author_auth_video_info_item);
        this.l = (TextView) view.findViewById(R.id.video_tab_fans_count_video_info_item);
        PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = (PbFirstFloorUserLikeButton) view.findViewById(R.id.video_tab_concern_video_info_item);
        this.m = pbFirstFloorUserLikeButton;
        pbFirstFloorUserLikeButton.setAfterStatusUpdateListener(new a(this));
        this.n = (RelativeLayout) view.findViewById(R.id.video_tab_video_info_area_video_info_item);
        TbRichTextView tbRichTextView = (TbRichTextView) view.findViewById(R.id.video_tab_title_video_info_item);
        this.o = tbRichTextView;
        tbRichTextView.setLayoutStrategy(new f(this.o.getLayoutStrategy()));
        this.o.getLayoutStrategy().n(1.0f);
        this.o.getLayoutStrategy().j(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        this.o.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X06));
        this.o.setTextBold();
        if (this.t) {
            this.p.setVisibility(0);
        }
        TbRichTextView tbRichTextView2 = (TbRichTextView) view.findViewById(R.id.video_tab_video_abstract_item);
        this.p = tbRichTextView2;
        tbRichTextView2.setIsNeedResizeEmotion(true);
        f fVar = new f(this.p.getLayoutStrategy());
        fVar.v(TbConfig.getContentSize());
        fVar.n(0.9f);
        fVar.j(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003));
        this.p.setLayoutStrategy(fVar);
        this.p.setMaxLines(3);
        this.p.setAddExpandableListener(true);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.video_tab_ueg_root);
        this.r = frameLayout;
        e eVar = new e(absVideoPbFragment, frameLayout);
        this.s = eVar;
        eVar.f57662f = 2;
        this.q = (TextView) view.findViewById(R.id.video_tab_tv_youngster_tip);
    }

    public final void b(List<TbRichTextData> list, HeadItem headItem) {
        int i2;
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
                    i2 = Integer.parseInt(headItem.content);
                } catch (NumberFormatException e2) {
                    BdLog.e(e2);
                    i2 = 0;
                }
                spannableStringBuilder.append((CharSequence) d.a.p0.d1.m.e.p(i2, true));
            }
            tbRichTextData.w(spannableStringBuilder);
            ListUtils.add(list, 0, tbRichTextData);
        }
    }

    public final void c(int i2) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (tBLottieAnimationView = this.f19980e) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.f19980e.setVisibility(0);
                if (this.f19980e.isAnimating()) {
                    return;
                }
                this.f19980e.setSpeed(0.8f);
                this.f19980e.setRepeatCount(-1);
                this.f19980e.post(new b(this));
                return;
            }
            this.f19980e.setVisibility(8);
            if (this.f19980e.isAnimating()) {
                this.f19980e.cancelAnimation();
            }
        }
    }

    public void e(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tbRichText) == null) || tbRichText == null) {
            return;
        }
        ArrayList<TbRichTextData> y = tbRichText.y();
        TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(y, 0);
        if (tbRichTextData == null || tbRichTextData.getType() != 1) {
            tbRichTextData = new TbRichTextData(1);
            ListUtils.add(y, 0, tbRichTextData);
        }
        tbRichTextData.V(d.a.p0.d1.m.e.r());
    }

    public void f(TbRichText tbRichText, List<HeadItem> list) {
        int count;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, tbRichText, list) == null) || (count = ListUtils.getCount(list)) == 0 || list == null) {
            return;
        }
        ArrayList<TbRichTextData> y = tbRichText.y();
        if (count == 1) {
            TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(y, 0);
            if (tbRichTextData == null || tbRichTextData.getType() != 1) {
                tbRichTextData = new TbRichTextData(1);
                ListUtils.add(y, 0, tbRichTextData);
            }
            HeadItem headItem = (HeadItem) ListUtils.getItem(list, 0);
            if (headItem != null) {
                try {
                    i2 = Integer.parseInt(headItem.content);
                } catch (NumberFormatException e2) {
                    BdLog.e(e2);
                    i2 = 0;
                }
                tbRichTextData.V(d.a.p0.d1.m.e.p(i2, false));
                return;
            }
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            HeadItem headItem2 = list.get(size);
            if (headItem2 != null) {
                b(y, headItem2);
            }
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || i2 <= 0) {
            return;
        }
        SkinManager.setImageResource(this.f19984i, BitmapHelper.getGradeResourceIdInEnterForum(i2));
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.f19977b, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.q, R.color.CAM_X0202);
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.l.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.m.r(TbadkCoreApplication.getInst().getSkinType());
            this.o.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.p.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.s.d();
            if (this.f19976a != skinType) {
                c(skinType);
            }
            this.f19976a = skinType;
        }
    }

    public void i(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z) {
                this.f19978c.setImageResource(R.drawable.pic_frs_headlines_n);
                this.f19978c.setVisibility(0);
            } else if (z2 && z3) {
                this.f19978c.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.f19978c.setVisibility(0);
            } else if (z2) {
                this.f19978c.setImageResource(R.drawable.pic_pb_refined_n);
                this.f19978c.setVisibility(0);
            } else if (z3) {
                this.f19978c.setImageResource(R.drawable.pic_pb_stick_n);
                this.f19978c.setVisibility(0);
            } else {
                this.f19978c.setVisibility(8);
            }
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                SkinManager.setViewTextColor(this.f19982g, R.color.CAM_X0301, 1);
            } else {
                SkinManager.setViewTextColor(this.f19982g, R.color.CAM_X0105, 1);
            }
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.f19979d.setOnClickListener(onClickListener);
            this.f19981f.setOnClickListener(onClickListener);
            this.f19982g.setOnClickListener(onClickListener);
            this.j.setOnClickListener(onClickListener);
        }
    }

    public void l(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, str) == null) {
            this.s.g(i2);
            this.s.f(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
            if (i2 == 8) {
                layoutParams.addRule(3, R.id.video_tab_user_info_area_video_info_item);
                layoutParams.setMargins(0, l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002), 0, 0);
            } else {
                layoutParams.addRule(3, R.id.video_tab_ueg_root);
                layoutParams.setMargins(0, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4), 0, 0);
            }
            this.n.setLayoutParams(layoutParams);
        }
    }

    public void m(Context context, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, context, postData) == null) {
            if (postData != null && ListUtils.getCount(postData.n0) >= 2) {
                List<PbContent> list = postData.n0;
                TbRichText V = TbRichTextView.V(context, ListUtils.subList(list, 1, list.size()), true);
                f(V, postData.G());
                this.p.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X07));
                this.p.setText(V);
                this.t = true;
                return;
            }
            this.t = false;
        }
    }

    public void n(Context context, List<PbContent> list, String str, b2 b2Var, boolean z, boolean z2) {
        TbRichText tbRichText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{context, list, str, b2Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (ListUtils.isEmpty(list) && StringUtils.isNull(str)) {
                return;
            }
            if (z) {
                this.p.setVisibility(0);
            }
            if (!ListUtils.isEmpty(list)) {
                tbRichText = TbRichTextView.V(context, list, true);
            } else {
                tbRichText = new TbRichText(context, d.a.q0.i1.f.a.d(context, str, 1));
            }
            f(tbRichText, b2Var.p0());
            if (z2) {
                e(tbRichText);
            }
            this.o.setText(tbRichText, false, this.u, false, true);
        }
    }
}
