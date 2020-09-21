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
/* loaded from: classes21.dex */
public class b extends af.a {
    public TBLottieAnimationView aja;
    public TextView dWe;
    public TextView ffa;
    private final int iHO;
    public LinearLayout kLd;
    public TextView lhA;
    public PbFirstFloorUserLikeButton lhB;
    public RelativeLayout lhC;
    public TbRichTextView lhD;
    private final TextView lhE;
    public ImageView lhF;
    public RelativeLayout lhG;
    public View lhH;
    public final View lhI;
    public TextView lhJ;
    public TextView lhK;
    public View lhL;
    public VoteView lhM;
    public TbRichTextView lhN;
    public TextView lhO;
    public TextView lhP;
    public TextView lhQ;
    public TextView lhR;
    public TextView lhS;
    private int lhT;
    private int lhU;
    private boolean lhV;
    private final int lhs;
    public ImageView lht;
    public HeadPendantClickableView lhu;
    public UserIconBox lhv;
    public TextView lhw;
    public ImageView lhx;
    public UserIconBox lhy;
    public TextView lhz;
    public View mRoot;
    private int mSkinType;

    public b(Context context, View view) {
        super(view);
        this.lhs = 2;
        this.iHO = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mSkinType = 3;
        this.mRoot = view;
        this.lht = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.lhu = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.lhu.setHasPendantStyle();
        this.lhu.getHeadView().setIsRound(true);
        this.lhu.getHeadView().setDrawBorder(false);
        this.lhu.getHeadView().setPlaceHolder(1);
        this.aja = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        this.lhv = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.dWe = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.lhw = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.lhx = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.lhy = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.lhz = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.lhA = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.lhB = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.lhC = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.lhD = (TbRichTextView) view.findViewById(R.id.title_video_info_item);
        this.lhE = (TextView) view.findViewById(R.id.title_measure_text);
        this.lhL = view.findViewById(R.id.video_info_item_layout);
        this.lhH = view.findViewById(R.id.video_title_area_video_info_item);
        this.lhI = view.findViewById(R.id.video_info_item_collapsible_layout);
        this.lhD.setLayoutStrategy(new d(this.lhD.getLayoutStrategy()));
        this.lhD.setTextSize(TbConfig.getContentSize());
        this.lhE.setTextSize(0, TbConfig.getContentSize());
        this.lhE.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.lhF = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.lhG = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.lhT = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.lhC.getPaddingLeft()) - this.lhC.getPaddingRight();
        Fu(0);
        this.ffa = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.lhJ = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.lhK = (TextView) view.findViewById(R.id.publish_location_video_info_item);
        this.lhO = (TextView) view.findViewById(R.id.publish_distance_video_info_item);
        this.lhP = (TextView) view.findViewById(R.id.play_count_video_info_item_collapsible);
        this.lhQ = (TextView) view.findViewById(R.id.publish_time_video_info_item_collapsible);
        this.lhR = (TextView) view.findViewById(R.id.publish_location_video_info_item_collapsible);
        this.lhS = (TextView) view.findViewById(R.id.publish_distance_video_info_item_collapsible);
        this.lhM = (VoteView) view.findViewById(R.id.pb_video_vote_view);
        this.lhN = (TbRichTextView) view.findViewById(R.id.video_abstract_item);
        this.kLd = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        d dVar = new d(this.lhN.getLayoutStrategy());
        dVar.setTextSize(l.getDimens(context, R.dimen.tbds40));
        this.lhN.setLayoutStrategy(dVar);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_e);
        this.lhz.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lhA.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lhB.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lhD.setTextColor(ap.getColor(R.color.cp_cont_b));
        Fu(this.lhU);
        this.ffa.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lhJ.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lhK.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lhO.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lhP.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lhQ.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lhR.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lhS.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lhM.onChangeSkinType(skinType);
        this.lhN.setTextColor(ap.getColor(R.color.cp_cont_j));
        if (this.mSkinType != skinType) {
            CD(skinType);
        }
        this.mSkinType = skinType;
    }

    public void uw(boolean z) {
        if (z) {
            ap.setViewTextColor(this.dWe, R.color.cp_cont_h, 1);
        } else {
            ap.setViewTextColor(this.dWe, R.color.cp_cont_b, 1);
        }
    }

    public void Ft(int i) {
        if (i > 0) {
            ap.setImageResource(this.lhx, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void k(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.lht.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lht.setVisibility(0);
        } else if (z2 && z3) {
            this.lht.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lht.setVisibility(0);
        } else if (z2) {
            this.lht.setImageResource(R.drawable.pic_pb_refined_n);
            this.lht.setVisibility(0);
        } else if (z3) {
            this.lht.setImageResource(R.drawable.pic_pb_stick_n);
            this.lht.setVisibility(0);
        } else {
            this.lht.setVisibility(8);
        }
    }

    public void OG(String str) {
        StateListDrawable stateListDrawable;
        StateListDrawable stateListDrawable2 = null;
        if (Config.BAWU_TYPE_MANAGER.equals(str) || Config.BAWU_TYPE_ASSIST.equals(str)) {
            if (Config.BAWU_TYPE_MANAGER.equals(str)) {
                stateListDrawable = com.baidu.tbadk.core.util.e.a.b.bkM().oq(0).V(this.iHO).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bkO();
                stateListDrawable2 = com.baidu.tbadk.core.util.e.a.b.bkM().oq(0).V(this.iHO).AT("#4D000000").bkO();
            } else if (Config.BAWU_TYPE_ASSIST.equals(str)) {
                stateListDrawable = com.baidu.tbadk.core.util.e.a.b.bkM().oq(0).V(this.iHO).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bkO();
                stateListDrawable2 = com.baidu.tbadk.core.util.e.a.b.bkM().oq(0).V(this.iHO).AT("#4D000000").bkO();
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
            this.lhw.setBackgroundDrawable(layerDrawable);
            ap.setViewTextColor(this.lhw, R.color.cp_cont_a);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.lhu.setOnClickListener(onClickListener);
        this.lhG.setOnClickListener(onClickListener);
        this.lhH.setOnClickListener(onClickListener);
        this.lhv.setOnClickListener(onClickListener);
        this.dWe.setOnClickListener(onClickListener);
        this.lhy.setOnClickListener(onClickListener);
    }

    public void a(Context context, List<PbContent> list, String str, boolean z) {
        int i;
        if (!y.isEmpty(list) || !StringUtils.isNull(str)) {
            String spannableStringBuilder = !y.isEmpty(list) ? e.bl(list).toString() : str;
            if (this.lhE.getPaint().measureText(spannableStringBuilder, 0, spannableStringBuilder.length()) + (this.lhE.getTextSize() * 2.0f) > this.lhT * 2 || z) {
                i = (this.lhU == 1 || this.lhU == 2) ? this.lhU : 1;
            } else {
                i = 0;
            }
            Fu(i);
            if (!y.isEmpty(list)) {
                this.lhD.setText(TbRichTextView.a(context, list, true));
            } else {
                this.lhD.setText(new TbRichText(context, com.baidu.tieba.im.chat.a.d(context, str, 1)));
            }
        }
    }

    public int diY() {
        return this.lhU;
    }

    public void Fu(int i) {
        this.lhU = i;
        if (i == 0) {
            diZ();
        } else if (i == 1) {
            dja();
        } else if (i == 2) {
            djb();
        }
    }

    private void diZ() {
        this.lhG.setVisibility(8);
        this.lhD.setTextEllipsize(null);
        this.lhD.setMaxLines(2);
    }

    private void dja() {
        this.lhG.setVisibility(0);
        SvgManager.bkl().a(this.lhF, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.lhD.setTextEllipsize(TextUtils.TruncateAt.END);
        this.lhD.setMaxLines(2);
        this.lhI.setVisibility(8);
        this.lhN.setVisibility(8);
        this.ffa.setVisibility(0);
        this.lhJ.setVisibility(0);
        this.lhK.setVisibility(0);
        this.lhO.setVisibility(0);
    }

    private void djb() {
        this.lhG.setVisibility(0);
        SvgManager.bkl().a(this.lhF, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.lhD.setTextEllipsize(null);
        this.lhD.setMaxLines(3);
        if (this.lhV) {
            this.lhN.setVisibility(0);
        }
        this.lhI.setVisibility(0);
        this.ffa.setVisibility(8);
        this.lhJ.setVisibility(8);
        this.lhK.setVisibility(8);
        this.lhO.setVisibility(8);
    }

    public void rD(boolean z) {
        if (z) {
            this.aja.setVisibility(0);
            if (!this.aja.isAnimating()) {
                this.aja.setSpeed(0.8f);
                this.aja.setRepeatCount(-1);
                this.aja.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.e.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.aja.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.aja.setVisibility(8);
        if (this.aja.isAnimating()) {
            this.aja.cancelAnimation();
        }
    }

    private void CD(int i) {
        if (i == 1) {
            this.aja.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.aja.setAnimation("live/card_live_bg_black.json");
        } else {
            this.aja.setAnimation("live/card_live_bg.json");
        }
    }

    public void a(Context context, f fVar) {
        if (fVar == null || !fVar.isValid()) {
            this.lhV = false;
            return;
        }
        PostData postData = fVar.cYT().get(0);
        if (postData == null || y.getCount(postData.mpz) < 2) {
            this.lhV = false;
            return;
        }
        List<PbContent> list = postData.mpz;
        this.lhN.setText(TbRichTextView.a(context, (List<PbContent>) y.subList(list, 1, list.size()), true));
        this.lhV = true;
    }
}
