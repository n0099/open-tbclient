package com.baidu.tieba.pb.videopb.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.e;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.d;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbContent;
/* loaded from: classes22.dex */
public class b extends af.a {
    public TBLottieAnimationView ajt;
    public TextView ewx;
    public TextView fFC;
    private final int joZ;
    public TextView lPA;
    public TextView lPB;
    public TextView lPC;
    public TextView lPD;
    private int lPE;
    private int lPF;
    private boolean lPG;
    private final int lPd;
    public ImageView lPe;
    public HeadPendantClickableView lPf;
    public UserIconBox lPg;
    public TextView lPh;
    public ImageView lPi;
    public UserIconBox lPj;
    public TextView lPk;
    public TextView lPl;
    public PbFirstFloorUserLikeButton lPm;
    public RelativeLayout lPn;
    public TbRichTextView lPo;
    private final TextView lPp;
    public ImageView lPq;
    public RelativeLayout lPr;
    public View lPs;
    public final View lPt;
    public TextView lPu;
    public TextView lPv;
    public View lPw;
    public VoteView lPx;
    public TbRichTextView lPy;
    public TextView lPz;
    public LinearLayout lsO;
    public View mRoot;
    private int mSkinType;

    public b(Context context, View view) {
        super(view);
        this.lPd = 2;
        this.joZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mSkinType = 3;
        this.mRoot = view;
        this.lPe = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.lPf = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.lPf.setHasPendantStyle();
        this.lPf.getHeadView().setIsRound(true);
        this.lPf.getHeadView().setDrawBorder(false);
        this.lPf.getHeadView().setPlaceHolder(1);
        this.ajt = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        this.lPg = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.ewx = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.lPh = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.lPi = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.lPj = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.lPk = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.lPl = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.lPm = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.lPn = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.lPo = (TbRichTextView) view.findViewById(R.id.title_video_info_item);
        this.lPp = (TextView) view.findViewById(R.id.title_measure_text);
        this.lPw = view.findViewById(R.id.video_info_item_layout);
        this.lPs = view.findViewById(R.id.video_title_area_video_info_item);
        this.lPt = view.findViewById(R.id.video_info_item_collapsible_layout);
        this.lPo.setLayoutStrategy(new d(this.lPo.getLayoutStrategy()));
        this.lPo.setTextSize(TbConfig.getContentSize());
        this.lPp.setTextSize(0, TbConfig.getContentSize());
        this.lPp.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.lPq = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.lPr = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.lPE = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.lPn.getPaddingLeft()) - this.lPn.getPaddingRight();
        GG(0);
        this.fFC = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.lPu = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.lPv = (TextView) view.findViewById(R.id.publish_location_video_info_item);
        this.lPz = (TextView) view.findViewById(R.id.publish_distance_video_info_item);
        this.lPA = (TextView) view.findViewById(R.id.play_count_video_info_item_collapsible);
        this.lPB = (TextView) view.findViewById(R.id.publish_time_video_info_item_collapsible);
        this.lPC = (TextView) view.findViewById(R.id.publish_location_video_info_item_collapsible);
        this.lPD = (TextView) view.findViewById(R.id.publish_distance_video_info_item_collapsible);
        this.lPx = (VoteView) view.findViewById(R.id.pb_video_vote_view);
        this.lPy = (TbRichTextView) view.findViewById(R.id.video_abstract_item);
        this.lsO = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        d dVar = new d(this.lPy.getLayoutStrategy());
        dVar.setTextSize(l.getDimens(context, R.dimen.tbds40));
        this.lPy.setLayoutStrategy(dVar);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_e);
        this.lPk.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lPl.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lPm.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lPo.setTextColor(ap.getColor(R.color.cp_cont_b));
        GG(this.lPF);
        this.fFC.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lPu.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lPv.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lPz.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lPA.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lPB.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lPC.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lPD.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lPx.onChangeSkinType(skinType);
        this.lPy.setTextColor(ap.getColor(R.color.cp_cont_j));
        if (this.mSkinType != skinType) {
            DP(skinType);
        }
        this.mSkinType = skinType;
    }

    public void vD(boolean z) {
        if (z) {
            ap.setViewTextColor(this.ewx, R.color.cp_cont_h, 1);
        } else {
            ap.setViewTextColor(this.ewx, R.color.cp_cont_b, 1);
        }
    }

    public void GF(int i) {
        if (i > 0) {
            ap.setImageResource(this.lPi, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void k(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.lPe.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lPe.setVisibility(0);
        } else if (z2 && z3) {
            this.lPe.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lPe.setVisibility(0);
        } else if (z2) {
            this.lPe.setImageResource(R.drawable.pic_pb_refined_n);
            this.lPe.setVisibility(0);
        } else if (z3) {
            this.lPe.setImageResource(R.drawable.pic_pb_stick_n);
            this.lPe.setVisibility(0);
        } else {
            this.lPe.setVisibility(8);
        }
    }

    public void Qk(String str) {
        StateListDrawable stateListDrawable;
        StateListDrawable stateListDrawable2 = null;
        if (Config.BAWU_TYPE_MANAGER.equals(str) || Config.BAWU_TYPE_ASSIST.equals(str)) {
            if (Config.BAWU_TYPE_MANAGER.equals(str)) {
                stateListDrawable = com.baidu.tbadk.core.util.e.a.b.brP().pj(0).ab(this.joZ).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).brR();
                stateListDrawable2 = com.baidu.tbadk.core.util.e.a.b.brP().pj(0).ab(this.joZ).Cm("#4D000000").brR();
            } else if (Config.BAWU_TYPE_ASSIST.equals(str)) {
                stateListDrawable = com.baidu.tbadk.core.util.e.a.b.brP().pj(0).ab(this.joZ).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).brR();
                stateListDrawable2 = com.baidu.tbadk.core.util.e.a.b.brP().pj(0).ab(this.joZ).Cm("#4D000000").brR();
            } else {
                stateListDrawable = null;
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{stateListDrawable, stateListDrawable2});
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                if (layerDrawable.getDrawable(1) != null) {
                    layerDrawable.getDrawable(1).setAlpha(255);
                }
            } else if (layerDrawable.getDrawable(1) != null) {
                layerDrawable.getDrawable(1).setAlpha(0);
            }
            this.lPh.setBackgroundDrawable(layerDrawable);
            ap.setViewTextColor(this.lPh, R.color.cp_cont_a);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.lPf.setOnClickListener(onClickListener);
        this.lPr.setOnClickListener(onClickListener);
        this.lPs.setOnClickListener(onClickListener);
        this.lPg.setOnClickListener(onClickListener);
        this.ewx.setOnClickListener(onClickListener);
        this.lPj.setOnClickListener(onClickListener);
    }

    public void a(Context context, List<PbContent> list, String str, boolean z) {
        int i;
        if (!y.isEmpty(list) || !StringUtils.isNull(str)) {
            String spannableStringBuilder = !y.isEmpty(list) ? e.bE(list).toString() : str;
            if (this.lPp.getPaint().measureText(spannableStringBuilder, 0, spannableStringBuilder.length()) + (this.lPp.getTextSize() * 2.0f) > this.lPE * 2 || z) {
                i = (this.lPF == 1 || this.lPF == 2) ? this.lPF : 1;
            } else {
                i = 0;
            }
            GG(i);
            if (!y.isEmpty(list)) {
                this.lPo.setText(TbRichTextView.a(context, list, true));
            } else {
                this.lPo.setText(new TbRichText(context, com.baidu.tieba.im.chat.a.d(context, str, 1)));
            }
        }
    }

    public int dsr() {
        return this.lPF;
    }

    public void GG(int i) {
        this.lPF = i;
        if (i == 0) {
            dss();
        } else if (i == 1) {
            dst();
        } else if (i == 2) {
            dsu();
        }
    }

    private void dss() {
        this.lPr.setVisibility(8);
        this.lPo.setTextEllipsize(null);
        this.lPo.setMaxLines(2);
    }

    private void dst() {
        this.lPr.setVisibility(0);
        SvgManager.brn().a(this.lPq, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.lPo.setTextEllipsize(TextUtils.TruncateAt.END);
        this.lPo.setMaxLines(2);
        this.lPt.setVisibility(8);
        this.lPy.setVisibility(8);
        this.fFC.setVisibility(0);
        this.lPu.setVisibility(0);
        this.lPv.setVisibility(0);
        this.lPz.setVisibility(0);
    }

    private void dsu() {
        this.lPr.setVisibility(0);
        SvgManager.brn().a(this.lPq, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.lPo.setTextEllipsize(null);
        this.lPo.setMaxLines(3);
        if (this.lPG) {
            this.lPy.setVisibility(0);
        }
        this.lPt.setVisibility(0);
        this.fFC.setVisibility(8);
        this.lPu.setVisibility(8);
        this.lPv.setVisibility(8);
        this.lPz.setVisibility(8);
    }

    public void sK(boolean z) {
        if (z) {
            this.ajt.setVisibility(0);
            if (!this.ajt.isAnimating()) {
                this.ajt.setSpeed(0.8f);
                this.ajt.setRepeatCount(-1);
                this.ajt.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.e.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.ajt.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.ajt.setVisibility(8);
        if (this.ajt.isAnimating()) {
            this.ajt.cancelAnimation();
        }
    }

    private void DP(int i) {
        if (i == 1) {
            this.ajt.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.ajt.setAnimation("live/card_live_bg_black.json");
        } else {
            this.ajt.setAnimation("live/card_live_bg.json");
        }
    }

    public void a(Context context, f fVar) {
        if (fVar == null || !fVar.isValid()) {
            this.lPG = false;
            return;
        }
        PostData postData = fVar.dim().get(0);
        if (postData == null || y.getCount(postData.mXP) < 2) {
            this.lPG = false;
            return;
        }
        List<PbContent> list = postData.mXP;
        this.lPy.setText(TbRichTextView.a(context, (List<PbContent>) y.subList(list, 1, list.size()), true));
        this.lPG = true;
    }
}
