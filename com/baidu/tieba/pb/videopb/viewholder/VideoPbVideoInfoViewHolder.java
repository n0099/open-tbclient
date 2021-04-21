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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
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
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.b.c.e.p.l;
import d.b.i0.b1.m.e;
import d.b.i0.r.q.a2;
import d.b.j0.d2.k.e.f;
import d.b.j0.d2.k.e.z0.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.HeadItem;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class VideoPbVideoInfoViewHolder extends TypeAdapter.ViewHolder {
    public VoteView A;
    public TbRichTextView B;
    public TextView C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView G;
    public FrameLayout H;
    public d I;
    public int J;
    public int K;
    public LinearLayout L;
    public boolean M;
    public VideoPbFragment N;

    /* renamed from: a  reason: collision with root package name */
    public final int f19811a;

    /* renamed from: b  reason: collision with root package name */
    public final int f19812b;

    /* renamed from: c  reason: collision with root package name */
    public int f19813c;

    /* renamed from: d  reason: collision with root package name */
    public View f19814d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f19815e;

    /* renamed from: f  reason: collision with root package name */
    public HeadPendantClickableView f19816f;

    /* renamed from: g  reason: collision with root package name */
    public TBLottieAnimationView f19817g;

    /* renamed from: h  reason: collision with root package name */
    public UserIconBox f19818h;
    public TextView i;
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

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoPbVideoInfoViewHolder.this.f19817g.playAnimation();
        }
    }

    public VideoPbVideoInfoViewHolder(Context context, View view, VideoPbFragment videoPbFragment) {
        super(view);
        this.f19811a = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.f19812b = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
        this.f19813c = 3;
        this.f19814d = view;
        this.N = videoPbFragment;
        this.f19815e = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.f19816f = headPendantClickableView;
        headPendantClickableView.setHasPendantStyle();
        this.f19816f.getHeadView().setIsRound(true);
        this.f19816f.getHeadView().setDrawBorder(true);
        this.f19816f.getHeadView().setBorderWidth(l.g(context, R.dimen.L_X01));
        this.f19816f.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f19816f.getHeadView().setPlaceHolder(1);
        this.f19816f.setBigVDimenSize(R.dimen.tbds27);
        this.f19817g = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        this.f19818h = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.i = (TextView) view.findViewById(R.id.user_name_video_info_item);
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
        this.J = (l.k(TbadkCoreApplication.getInst()) - this.p.getPaddingLeft()) - this.p.getPaddingRight();
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
        this.B = (TbRichTextView) view.findViewById(R.id.video_abstract_item);
        this.L = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        f fVar = new f(this.B.getLayoutStrategy());
        fVar.v(l.g(context, R.dimen.T_X06));
        fVar.n(0.9f);
        this.B.setLayoutStrategy(fVar);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.ueg_root);
        this.H = frameLayout;
        d dVar = new d(videoPbFragment, frameLayout);
        this.I = dVar;
        dVar.f54827f = 2;
    }

    public void b(int i) {
        this.K = i;
        if (i == 0) {
            e();
        } else if (i == 1) {
            c();
        } else if (i == 2) {
            d();
        }
    }

    public final void c() {
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

    public final void d() {
        this.t.setVisibility(0);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.s, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, null);
        this.q.setTextEllipsize(null);
        this.q.setMaxLines(3);
        if (this.M) {
            this.B.setVisibility(0);
        }
        this.v.setVisibility(0);
        this.w.setVisibility(8);
        this.x.setVisibility(8);
        this.y.setVisibility(8);
        this.C.setVisibility(8);
        this.z.setVisibility(8);
    }

    public final void e() {
        this.t.setVisibility(8);
        this.q.setTextEllipsize(null);
        this.q.setMaxLines(2);
    }

    public final void f(List<TbRichTextData> list, HeadItem headItem) {
        int i;
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
            spannableStringBuilder.append((CharSequence) e.o(i, true));
        }
        tbRichTextData.s(spannableStringBuilder);
        ListUtils.add(list, 0, tbRichTextData);
    }

    public int h() {
        return this.K;
    }

    public final void i(int i) {
        TBLottieAnimationView tBLottieAnimationView = this.f19817g;
        if (tBLottieAnimationView != null) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
    }

    public void j(boolean z) {
        if (z) {
            this.f19817g.setVisibility(0);
            if (this.f19817g.isAnimating()) {
                return;
            }
            this.f19817g.setSpeed(0.8f);
            this.f19817g.setRepeatCount(-1);
            this.f19817g.post(new a());
            return;
        }
        this.f19817g.setVisibility(8);
        if (this.f19817g.isAnimating()) {
            this.f19817g.cancelAnimation();
        }
    }

    public void k(TbRichText tbRichText) {
        if (tbRichText == null) {
            return;
        }
        ArrayList<TbRichTextData> u = tbRichText.u();
        TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(u, 0);
        if (tbRichTextData == null || tbRichTextData.getType() != 1) {
            tbRichTextData = new TbRichTextData(1);
            ListUtils.add(u, 0, tbRichTextData);
        }
        tbRichTextData.R(e.q());
    }

    public void l(TbRichText tbRichText, List<HeadItem> list) {
        int i;
        int count = ListUtils.getCount(list);
        if (count == 0 || list == null) {
            return;
        }
        ArrayList<TbRichTextData> u = tbRichText.u();
        if (count == 1) {
            TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(u, 0);
            if (tbRichTextData == null || tbRichTextData.getType() != 1) {
                tbRichTextData = new TbRichTextData(1);
                ListUtils.add(u, 0, tbRichTextData);
            }
            HeadItem headItem = (HeadItem) ListUtils.getItem(list, 0);
            if (headItem != null) {
                try {
                    i = Integer.parseInt(headItem.content);
                } catch (NumberFormatException unused) {
                    i = 0;
                }
                tbRichTextData.R(e.o(i, false));
                return;
            }
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            HeadItem headItem2 = list.get(size);
            if (headItem2 != null) {
                f(u, headItem2);
            }
        }
    }

    public void m(int i) {
        if (i > 0) {
            SkinManager.setImageResource(this.k, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void n() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setBackgroundColor(this.f19814d, R.color.CAM_X0205);
        this.m.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
        this.n.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
        this.o.r(TbadkCoreApplication.getInst().getSkinType());
        this.q.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        b(this.K);
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
        this.I.d();
        if (this.f19813c != skinType) {
            i(skinType);
        }
        this.f19813c = skinType;
    }

    public void o(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.f19815e.setImageResource(R.drawable.pic_frs_headlines_n);
            this.f19815e.setVisibility(0);
        } else if (z2 && z3) {
            this.f19815e.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.f19815e.setVisibility(0);
        } else if (z2) {
            this.f19815e.setImageResource(R.drawable.pic_pb_refined_n);
            this.f19815e.setVisibility(0);
        } else if (z3) {
            this.f19815e.setImageResource(R.drawable.pic_pb_stick_n);
            this.f19815e.setVisibility(0);
        } else {
            this.f19815e.setVisibility(8);
        }
    }

    public void p(boolean z) {
        if (z) {
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0301, 1);
        } else {
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0105, 1);
        }
    }

    public void q(View.OnClickListener onClickListener) {
        this.f19816f.setOnClickListener(onClickListener);
        this.t.setOnClickListener(onClickListener);
        this.u.setOnClickListener(onClickListener);
        this.f19818h.setOnClickListener(onClickListener);
        this.i.setOnClickListener(onClickListener);
        this.l.setOnClickListener(onClickListener);
    }

    public void r(int i, String str) {
        this.I.g(i);
        this.I.f(str);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
        if (i == 8) {
            layoutParams.addRule(3, R.id.user_info_area_video_info_item);
            layoutParams.setMargins(0, this.f19812b, 0, 0);
        } else {
            layoutParams.addRule(3, R.id.ueg_root);
            layoutParams.setMargins(0, this.f19811a, 0, 0);
        }
        this.p.setLayoutParams(layoutParams);
    }

    public void s(Context context, PostData postData) {
        if (postData != null && ListUtils.getCount(postData.i0) >= 2) {
            List<PbContent> list = postData.i0;
            TbRichText U = TbRichTextView.U(context, ListUtils.subList(list, 1, list.size()), true);
            l(U, postData.G());
            this.B.setText(U);
            this.M = true;
            return;
        }
        this.M = false;
    }

    public void u(Context context, List<PbContent> list, String str, a2 a2Var, boolean z, boolean z2) {
        TbRichText tbRichText;
        if (ListUtils.isEmpty(list) && StringUtils.isNull(str)) {
            return;
        }
        String spannableStringBuilder = !ListUtils.isEmpty(list) ? e.x(list).toString() : str;
        int i = 0;
        if (this.r.getPaint().measureText(spannableStringBuilder, 0, spannableStringBuilder.length()) + (this.r.getTextSize() * 2.0f) > this.J * 2 || z) {
            int i2 = this.K;
            i = (i2 == 1 || i2 == 2) ? this.K : 1;
        }
        b(i);
        if (!ListUtils.isEmpty(list)) {
            tbRichText = TbRichTextView.U(context, list, true);
        } else {
            tbRichText = new TbRichText(context, d.b.j0.e1.f.a.d(context, str, 1));
        }
        l(tbRichText, a2Var.z0());
        if (z2) {
            k(tbRichText);
        }
        this.q.setText(tbRichText, false, this.N, false, true);
    }
}
