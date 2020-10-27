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
    public TextView eqE;
    public TextView fzM;
    private final int jjb;
    public View lJA;
    public VoteView lJB;
    public TbRichTextView lJC;
    public TextView lJD;
    public TextView lJE;
    public TextView lJF;
    public TextView lJG;
    public TextView lJH;
    private int lJI;
    private int lJJ;
    private boolean lJK;
    private final int lJh;
    public ImageView lJi;
    public HeadPendantClickableView lJj;
    public UserIconBox lJk;
    public TextView lJl;
    public ImageView lJm;
    public UserIconBox lJn;
    public TextView lJo;
    public TextView lJp;
    public PbFirstFloorUserLikeButton lJq;
    public RelativeLayout lJr;
    public TbRichTextView lJs;
    private final TextView lJt;
    public ImageView lJu;
    public RelativeLayout lJv;
    public View lJw;
    public final View lJx;
    public TextView lJy;
    public TextView lJz;
    public LinearLayout lmN;
    public View mRoot;
    private int mSkinType;

    public b(Context context, View view) {
        super(view);
        this.lJh = 2;
        this.jjb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mSkinType = 3;
        this.mRoot = view;
        this.lJi = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.lJj = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.lJj.setHasPendantStyle();
        this.lJj.getHeadView().setIsRound(true);
        this.lJj.getHeadView().setDrawBorder(false);
        this.lJj.getHeadView().setPlaceHolder(1);
        this.ajt = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        this.lJk = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.eqE = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.lJl = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.lJm = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.lJn = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.lJo = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.lJp = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.lJq = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.lJr = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.lJs = (TbRichTextView) view.findViewById(R.id.title_video_info_item);
        this.lJt = (TextView) view.findViewById(R.id.title_measure_text);
        this.lJA = view.findViewById(R.id.video_info_item_layout);
        this.lJw = view.findViewById(R.id.video_title_area_video_info_item);
        this.lJx = view.findViewById(R.id.video_info_item_collapsible_layout);
        this.lJs.setLayoutStrategy(new d(this.lJs.getLayoutStrategy()));
        this.lJs.setTextSize(TbConfig.getContentSize());
        this.lJt.setTextSize(0, TbConfig.getContentSize());
        this.lJt.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.lJu = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.lJv = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.lJI = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.lJr.getPaddingLeft()) - this.lJr.getPaddingRight();
        Gt(0);
        this.fzM = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.lJy = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.lJz = (TextView) view.findViewById(R.id.publish_location_video_info_item);
        this.lJD = (TextView) view.findViewById(R.id.publish_distance_video_info_item);
        this.lJE = (TextView) view.findViewById(R.id.play_count_video_info_item_collapsible);
        this.lJF = (TextView) view.findViewById(R.id.publish_time_video_info_item_collapsible);
        this.lJG = (TextView) view.findViewById(R.id.publish_location_video_info_item_collapsible);
        this.lJH = (TextView) view.findViewById(R.id.publish_distance_video_info_item_collapsible);
        this.lJB = (VoteView) view.findViewById(R.id.pb_video_vote_view);
        this.lJC = (TbRichTextView) view.findViewById(R.id.video_abstract_item);
        this.lmN = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        d dVar = new d(this.lJC.getLayoutStrategy());
        dVar.setTextSize(l.getDimens(context, R.dimen.tbds40));
        this.lJC.setLayoutStrategy(dVar);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_e);
        this.lJo.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lJp.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lJq.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lJs.setTextColor(ap.getColor(R.color.cp_cont_b));
        Gt(this.lJJ);
        this.fzM.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lJy.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lJz.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lJD.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lJE.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lJF.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lJG.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lJH.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lJB.onChangeSkinType(skinType);
        this.lJC.setTextColor(ap.getColor(R.color.cp_cont_j));
        if (this.mSkinType != skinType) {
            DC(skinType);
        }
        this.mSkinType = skinType;
    }

    public void vu(boolean z) {
        if (z) {
            ap.setViewTextColor(this.eqE, R.color.cp_cont_h, 1);
        } else {
            ap.setViewTextColor(this.eqE, R.color.cp_cont_b, 1);
        }
    }

    public void Gs(int i) {
        if (i > 0) {
            ap.setImageResource(this.lJm, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void k(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.lJi.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lJi.setVisibility(0);
        } else if (z2 && z3) {
            this.lJi.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lJi.setVisibility(0);
        } else if (z2) {
            this.lJi.setImageResource(R.drawable.pic_pb_refined_n);
            this.lJi.setVisibility(0);
        } else if (z3) {
            this.lJi.setImageResource(R.drawable.pic_pb_stick_n);
            this.lJi.setVisibility(0);
        } else {
            this.lJi.setVisibility(8);
        }
    }

    public void PT(String str) {
        StateListDrawable stateListDrawable;
        StateListDrawable stateListDrawable2 = null;
        if (Config.BAWU_TYPE_MANAGER.equals(str) || Config.BAWU_TYPE_ASSIST.equals(str)) {
            if (Config.BAWU_TYPE_MANAGER.equals(str)) {
                stateListDrawable = com.baidu.tbadk.core.util.e.a.b.bpp().oZ(0).Z(this.jjb).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bpr();
                stateListDrawable2 = com.baidu.tbadk.core.util.e.a.b.bpp().oZ(0).Z(this.jjb).BY("#4D000000").bpr();
            } else if (Config.BAWU_TYPE_ASSIST.equals(str)) {
                stateListDrawable = com.baidu.tbadk.core.util.e.a.b.bpp().oZ(0).Z(this.jjb).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bpr();
                stateListDrawable2 = com.baidu.tbadk.core.util.e.a.b.bpp().oZ(0).Z(this.jjb).BY("#4D000000").bpr();
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
            this.lJl.setBackgroundDrawable(layerDrawable);
            ap.setViewTextColor(this.lJl, R.color.cp_cont_a);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.lJj.setOnClickListener(onClickListener);
        this.lJv.setOnClickListener(onClickListener);
        this.lJw.setOnClickListener(onClickListener);
        this.lJk.setOnClickListener(onClickListener);
        this.eqE.setOnClickListener(onClickListener);
        this.lJn.setOnClickListener(onClickListener);
    }

    public void a(Context context, List<PbContent> list, String str, boolean z) {
        int i;
        if (!y.isEmpty(list) || !StringUtils.isNull(str)) {
            String spannableStringBuilder = !y.isEmpty(list) ? e.bx(list).toString() : str;
            if (this.lJt.getPaint().measureText(spannableStringBuilder, 0, spannableStringBuilder.length()) + (this.lJt.getTextSize() * 2.0f) > this.lJI * 2 || z) {
                i = (this.lJJ == 1 || this.lJJ == 2) ? this.lJJ : 1;
            } else {
                i = 0;
            }
            Gt(i);
            if (!y.isEmpty(list)) {
                this.lJs.setText(TbRichTextView.a(context, list, true));
            } else {
                this.lJs.setText(new TbRichText(context, com.baidu.tieba.im.chat.a.d(context, str, 1)));
            }
        }
    }

    public int dpP() {
        return this.lJJ;
    }

    public void Gt(int i) {
        this.lJJ = i;
        if (i == 0) {
            dpQ();
        } else if (i == 1) {
            dpR();
        } else if (i == 2) {
            dpS();
        }
    }

    private void dpQ() {
        this.lJv.setVisibility(8);
        this.lJs.setTextEllipsize(null);
        this.lJs.setMaxLines(2);
    }

    private void dpR() {
        this.lJv.setVisibility(0);
        SvgManager.boN().a(this.lJu, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.lJs.setTextEllipsize(TextUtils.TruncateAt.END);
        this.lJs.setMaxLines(2);
        this.lJx.setVisibility(8);
        this.lJC.setVisibility(8);
        this.fzM.setVisibility(0);
        this.lJy.setVisibility(0);
        this.lJz.setVisibility(0);
        this.lJD.setVisibility(0);
    }

    private void dpS() {
        this.lJv.setVisibility(0);
        SvgManager.boN().a(this.lJu, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.lJs.setTextEllipsize(null);
        this.lJs.setMaxLines(3);
        if (this.lJK) {
            this.lJC.setVisibility(0);
        }
        this.lJx.setVisibility(0);
        this.fzM.setVisibility(8);
        this.lJy.setVisibility(8);
        this.lJz.setVisibility(8);
        this.lJD.setVisibility(8);
    }

    public void sB(boolean z) {
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

    private void DC(int i) {
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
            this.lJK = false;
            return;
        }
        PostData postData = fVar.dfK().get(0);
        if (postData == null || y.getCount(postData.mRM) < 2) {
            this.lJK = false;
            return;
        }
        List<PbContent> list = postData.mRM;
        this.lJC.setText(TbRichTextView.a(context, (List<PbContent>) y.subList(list, 1, list.size()), true));
        this.lJK = true;
    }
}
