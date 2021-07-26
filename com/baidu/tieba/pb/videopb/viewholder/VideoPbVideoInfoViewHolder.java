package com.baidu.tieba.pb.videopb.viewholder;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import d.a.d.e.p.l;
import d.a.p0.s.q.b2;
import d.a.q0.h2.k.e.b1.e;
import d.a.q0.h2.k.e.f;
import java.util.ArrayList;
import java.util.List;
import tbclient.HeadItem;
import tbclient.PbContent;
/* loaded from: classes4.dex */
public class VideoPbVideoInfoViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VoteView A;
    public TbRichTextView B;
    public TextView C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView G;
    public TextView H;
    public FrameLayout I;
    public e J;
    public int K;
    public int L;
    public LinearLayout M;
    public boolean N;
    public AbsVideoPbFragment O;

    /* renamed from: a  reason: collision with root package name */
    public final int f19963a;

    /* renamed from: b  reason: collision with root package name */
    public final int f19964b;

    /* renamed from: c  reason: collision with root package name */
    public int f19965c;

    /* renamed from: d  reason: collision with root package name */
    public View f19966d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f19967e;

    /* renamed from: f  reason: collision with root package name */
    public HeadPendantClickableView f19968f;

    /* renamed from: g  reason: collision with root package name */
    public TBLottieAnimationView f19969g;

    /* renamed from: h  reason: collision with root package name */
    public UserIconBox f19970h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f19971i;
    public TextView j;
    public ImageView k;
    public UserIconBox l;
    public TextView m;
    public TextView n;
    public PbFirstFloorUserLikeButton o;
    public RelativeLayout p;
    public TbRichTextView q;
    public final TextView r;
    public ImageView s;
    public RelativeLayout t;
    public View u;
    public final View v;
    public TextView w;
    public TextView x;
    public TextView y;
    public View z;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbVideoInfoViewHolder f19972e;

        public a(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbVideoInfoViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19972e = videoPbVideoInfoViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19972e.f19969g.playAnimation();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPbVideoInfoViewHolder(Context context, View view, AbsVideoPbFragment absVideoPbFragment) {
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
        this.f19963a = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.f19964b = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
        this.f19965c = 3;
        this.f19966d = view;
        this.O = absVideoPbFragment;
        this.f19967e = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.f19968f = headPendantClickableView;
        headPendantClickableView.setHasPendantStyle();
        this.f19968f.getHeadView().setIsRound(true);
        this.f19968f.getHeadView().setDrawBorder(true);
        this.f19968f.getHeadView().setBorderWidth(l.g(context, R.dimen.L_X01));
        this.f19968f.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f19968f.getHeadView().setPlaceHolder(1);
        this.f19968f.setBigVDimenSize(R.dimen.tbds27);
        this.f19969g = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        this.f19970h = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.f19971i = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.j = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.k = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.l = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.m = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.n = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.o = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.p = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.q = (TbRichTextView) view.findViewById(R.id.title_video_info_item);
        this.r = (TextView) view.findViewById(R.id.title_measure_text);
        this.z = view.findViewById(R.id.video_info_item_layout);
        this.u = view.findViewById(R.id.video_title_area_video_info_item);
        this.v = view.findViewById(R.id.video_info_item_collapsible_layout);
        this.q.setLayoutStrategy(new f(this.q.getLayoutStrategy()));
        this.q.setTextSize(TbConfig.getContentSize());
        this.q.setTextBold();
        this.r.setTextSize(0, TbConfig.getContentSize());
        this.r.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.s = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.t = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.K = (l.k(TbadkCoreApplication.getInst()) - this.p.getPaddingLeft()) - this.p.getPaddingRight();
        b(0);
        this.w = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.x = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.y = (TextView) view.findViewById(R.id.publish_location_video_info_item);
        this.C = (TextView) view.findViewById(R.id.publish_distance_video_info_item);
        this.D = (TextView) view.findViewById(R.id.play_count_video_info_item_collapsible);
        this.E = (TextView) view.findViewById(R.id.publish_time_video_info_item_collapsible);
        this.F = (TextView) view.findViewById(R.id.publish_location_video_info_item_collapsible);
        this.G = (TextView) view.findViewById(R.id.publish_distance_video_info_item_collapsible);
        this.A = (VoteView) view.findViewById(R.id.pb_video_vote_view);
        TbRichTextView tbRichTextView = (TbRichTextView) view.findViewById(R.id.video_abstract_item);
        this.B = tbRichTextView;
        tbRichTextView.setIsShowOrderOrDownloadBtn(true);
        this.B.setIsNeedResizeEmotion(true);
        this.M = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        f fVar = new f(this.B.getLayoutStrategy());
        fVar.v(TbConfig.getContentSize());
        fVar.n(0.9f);
        this.B.setLayoutStrategy(fVar);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.ueg_root);
        this.I = frameLayout;
        e eVar = new e(absVideoPbFragment, frameLayout);
        this.J = eVar;
        eVar.f57662f = 2;
        this.H = (TextView) view.findViewById(R.id.tv_youngster_tip);
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.L = i2;
            if (i2 == 0) {
                e();
            } else if (i2 == 1) {
                c();
            } else if (i2 == 2) {
                d();
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.t.setVisibility(0);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.s, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
            this.q.setTextEllipsize(TextUtils.TruncateAt.END);
            this.q.setMaxLines(2);
            this.v.setVisibility(8);
            this.B.setVisibility(8);
            this.w.setVisibility(0);
            this.x.setVisibility(0);
            this.y.setVisibility(0);
            this.C.setVisibility(0);
            this.z.setVisibility(0);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.t.setVisibility(0);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.s, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, null);
            this.q.setTextEllipsize(null);
            this.q.setMaxLines(3);
            if (this.N) {
                this.B.setVisibility(0);
            }
            this.v.setVisibility(0);
            this.w.setVisibility(8);
            this.x.setVisibility(8);
            this.y.setVisibility(8);
            this.C.setVisibility(8);
            this.z.setVisibility(8);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.t.setVisibility(8);
            this.q.setTextEllipsize(null);
            this.q.setMaxLines(2);
        }
    }

    public final void f(List<TbRichTextData> list, HeadItem headItem) {
        int i2;
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
                    i2 = Integer.parseInt(headItem.content);
                } catch (NumberFormatException unused) {
                    i2 = 0;
                }
                spannableStringBuilder.append((CharSequence) d.a.p0.d1.m.e.p(i2, true));
            }
            tbRichTextData.w(spannableStringBuilder);
            ListUtils.add(list, 0, tbRichTextData);
        }
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.L : invokeV.intValue;
    }

    public final void h(int i2) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (tBLottieAnimationView = this.f19969g) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                this.f19969g.setVisibility(0);
                if (this.f19969g.isAnimating()) {
                    return;
                }
                this.f19969g.setSpeed(0.8f);
                this.f19969g.setRepeatCount(-1);
                this.f19969g.post(new a(this));
                return;
            }
            this.f19969g.setVisibility(8);
            if (this.f19969g.isAnimating()) {
                this.f19969g.cancelAnimation();
            }
        }
    }

    public void j(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbRichText) == null) || tbRichText == null) {
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

    public void k(TbRichText tbRichText, List<HeadItem> list) {
        int count;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, tbRichText, list) == null) || (count = ListUtils.getCount(list)) == 0 || list == null) {
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
                } catch (NumberFormatException unused) {
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
                f(y, headItem2);
            }
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || i2 <= 0) {
            return;
        }
        SkinManager.setImageResource(this.k, BitmapHelper.getGradeResourceIdInEnterForum(i2));
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.f19966d, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.H, R.color.CAM_X0202);
            this.m.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.n.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.o.r(TbadkCoreApplication.getInst().getSkinType());
            this.q.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            b(this.L);
            this.w.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.x.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.y.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.C.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.D.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.E.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.F.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.G.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.A.C(skinType);
            this.B.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            this.J.d();
            if (this.f19965c != skinType) {
                h(skinType);
            }
            this.f19965c = skinType;
        }
    }

    public void n(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z) {
                this.f19967e.setImageResource(R.drawable.pic_frs_headlines_n);
                this.f19967e.setVisibility(0);
            } else if (z2 && z3) {
                this.f19967e.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.f19967e.setVisibility(0);
            } else if (z2) {
                this.f19967e.setImageResource(R.drawable.pic_pb_refined_n);
                this.f19967e.setVisibility(0);
            } else if (z3) {
                this.f19967e.setImageResource(R.drawable.pic_pb_stick_n);
                this.f19967e.setVisibility(0);
            } else {
                this.f19967e.setVisibility(8);
            }
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                SkinManager.setViewTextColor(this.f19971i, R.color.CAM_X0301, 1);
            } else {
                SkinManager.setViewTextColor(this.f19971i, R.color.CAM_X0105, 1);
            }
        }
    }

    public void p(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) {
            this.f19968f.setOnClickListener(onClickListener);
            this.t.setOnClickListener(onClickListener);
            this.u.setOnClickListener(onClickListener);
            this.f19970h.setOnClickListener(onClickListener);
            this.f19971i.setOnClickListener(onClickListener);
            this.l.setOnClickListener(onClickListener);
        }
    }

    public void q(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i2, str) == null) {
            this.J.g(i2);
            this.J.f(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
            if (i2 == 8) {
                layoutParams.addRule(3, R.id.user_info_area_video_info_item);
                layoutParams.setMargins(0, this.f19964b, 0, 0);
            } else {
                layoutParams.addRule(3, R.id.ueg_root);
                layoutParams.setMargins(0, this.f19963a, 0, 0);
            }
            this.p.setLayoutParams(layoutParams);
        }
    }

    public void r(Context context, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, context, postData) == null) {
            if (postData != null && ListUtils.getCount(postData.n0) >= 2) {
                List<PbContent> list = postData.n0;
                TbRichText V = TbRichTextView.V(context, ListUtils.subList(list, 1, list.size()), true);
                k(V, postData.G());
                this.B.setText(V);
                this.N = true;
                return;
            }
            this.N = false;
        }
    }

    public void s(Context context, List<PbContent> list, String str, b2 b2Var, boolean z, boolean z2) {
        TbRichText tbRichText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{context, list, str, b2Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (ListUtils.isEmpty(list) && StringUtils.isNull(str)) {
                return;
            }
            String spannableStringBuilder = !ListUtils.isEmpty(list) ? d.a.p0.d1.m.e.y(list).toString() : str;
            int i2 = 0;
            if (this.r.getPaint().measureText(spannableStringBuilder, 0, spannableStringBuilder.length()) + (this.r.getTextSize() * 2.0f) > this.K * 2 || z) {
                int i3 = this.L;
                i2 = (i3 == 1 || i3 == 2) ? this.L : 1;
            }
            b(i2);
            if (!ListUtils.isEmpty(list)) {
                tbRichText = TbRichTextView.V(context, list, true);
            } else {
                tbRichText = new TbRichText(context, d.a.q0.i1.f.a.d(context, str, 1));
            }
            k(tbRichText, b2Var.p0());
            if (z2) {
                j(tbRichText);
            }
            this.q.setText(tbRichText, false, this.O, false, true);
        }
    }
}
