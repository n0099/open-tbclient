package com.baidu.tieba.pb.videopb.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
/* loaded from: classes16.dex */
public class b extends af.a {
    public TBLottieAnimationView aiE;
    public TextView dTQ;
    public TextView fcd;
    public TextView hZL;
    private final int iAn;
    private final int kYF;
    public ImageView kYG;
    public HeadPendantClickableView kYH;
    public UserIconBox kYI;
    public TextView kYJ;
    public ImageView kYK;
    public UserIconBox kYL;
    public TextView kYM;
    public TextView kYN;
    public PbFirstFloorUserLikeButton kYO;
    public RelativeLayout kYP;
    public ImageView kYQ;
    public RelativeLayout kYR;
    public TextView kYS;
    public TextView kYT;
    public VoteView kYU;
    private int kYV;
    private int kYW;
    public View mRoot;
    private int mSkinType;

    public b(Context context, View view) {
        super(view);
        this.kYF = 2;
        this.iAn = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mSkinType = 3;
        this.mRoot = view;
        this.kYG = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.kYH = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.kYH.setHasPendantStyle();
        this.kYH.getHeadView().setIsRound(true);
        this.kYH.getHeadView().setDrawBorder(false);
        this.kYH.getHeadView().setPlaceHolder(1);
        this.aiE = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        this.kYI = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.dTQ = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.kYJ = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.kYK = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.kYL = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.kYM = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.kYN = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.kYO = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.kYP = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.hZL = (TextView) view.findViewById(R.id.title_video_info_item);
        this.hZL.setTextSize(0, TbConfig.getContentSize());
        this.hZL.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.kYQ = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.kYR = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.kYV = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.kYP.getPaddingLeft()) - this.kYP.getPaddingRight();
        ET(0);
        this.fcd = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.kYS = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.kYT = (TextView) view.findViewById(R.id.publish_location_video_info_item);
        this.kYU = (VoteView) view.findViewById(R.id.pb_video_vote_view);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_e);
        this.kYM.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.kYN.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.kYO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hZL.setTextColor(ap.getColor(R.color.cp_cont_b));
        ET(this.kYW);
        this.fcd.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.kYS.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.kYT.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.kYU.onChangeSkinType(skinType);
        if (this.mSkinType != skinType) {
            Cc(skinType);
        }
        this.mSkinType = skinType;
    }

    public void um(boolean z) {
        if (z) {
            ap.setViewTextColor(this.dTQ, R.color.cp_cont_h, 1);
        } else {
            ap.setViewTextColor(this.dTQ, R.color.cp_cont_b, 1);
        }
    }

    public void ES(int i) {
        if (i > 0) {
            ap.setImageResource(this.kYK, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.kYG.setImageResource(R.drawable.pic_frs_headlines_n);
            this.kYG.setVisibility(0);
        } else if (z2 && z3) {
            this.kYG.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.kYG.setVisibility(0);
        } else if (z2) {
            this.kYG.setImageResource(R.drawable.pic_pb_refined_n);
            this.kYG.setVisibility(0);
        } else if (z3) {
            this.kYG.setImageResource(R.drawable.pic_pb_stick_n);
            this.kYG.setVisibility(0);
        } else {
            this.kYG.setVisibility(8);
        }
    }

    public void Oe(String str) {
        StateListDrawable stateListDrawable;
        StateListDrawable stateListDrawable2 = null;
        if (Config.BAWU_TYPE_MANAGER.equals(str) || Config.BAWU_TYPE_ASSIST.equals(str)) {
            if (Config.BAWU_TYPE_MANAGER.equals(str)) {
                stateListDrawable = com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(this.iAn).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bjT();
                stateListDrawable2 = com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(this.iAn).Aw("#4D000000").bjT();
            } else if (Config.BAWU_TYPE_ASSIST.equals(str)) {
                stateListDrawable = com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(this.iAn).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bjT();
                stateListDrawable2 = com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(this.iAn).Aw("#4D000000").bjT();
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
            this.kYJ.setBackgroundDrawable(layerDrawable);
            ap.setViewTextColor(this.kYJ, R.color.cp_cont_a);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.kYH.setOnClickListener(onClickListener);
        this.kYR.setOnClickListener(onClickListener);
        this.kYI.setOnClickListener(onClickListener);
        this.dTQ.setOnClickListener(onClickListener);
        this.kYL.setOnClickListener(onClickListener);
    }

    public void s(CharSequence charSequence) {
        int i = 1;
        if (charSequence != null) {
            if (this.hZL.getPaint().measureText(charSequence, 0, charSequence.length()) + (this.hZL.getTextSize() * 2.0f) <= this.kYV * 2) {
                i = 0;
            } else if (this.kYW == 1 || this.kYW == 2) {
                i = this.kYW;
            }
            ET(i);
            this.hZL.setText(charSequence);
        }
    }

    public int dft() {
        return this.kYW;
    }

    public void ET(int i) {
        this.kYW = i;
        if (i == 0) {
            dfu();
        } else if (i == 1) {
            dfv();
        } else if (i == 2) {
            dfw();
        }
    }

    private void dfu() {
        this.kYR.setVisibility(8);
        this.hZL.setEllipsize(null);
        this.hZL.setMaxLines(2);
    }

    private void dfv() {
        this.kYR.setVisibility(0);
        SvgManager.bjq().a(this.kYQ, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.hZL.setEllipsize(TextUtils.TruncateAt.END);
        this.hZL.setMaxLines(2);
    }

    private void dfw() {
        this.kYR.setVisibility(0);
        SvgManager.bjq().a(this.kYQ, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.hZL.setEllipsize(null);
        this.hZL.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public void rt(boolean z) {
        if (z) {
            this.aiE.setVisibility(0);
            if (!this.aiE.isAnimating()) {
                this.aiE.setSpeed(0.8f);
                this.aiE.setRepeatCount(-1);
                this.aiE.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.e.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.aiE.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.aiE.setVisibility(8);
        if (this.aiE.isAnimating()) {
            this.aiE.cancelAnimation();
        }
    }

    private void Cc(int i) {
        if (i == 1) {
            this.aiE.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.aiE.setAnimation("live/card_live_bg_black.json");
        } else {
            this.aiE.setAnimation("live/card_live_bg.json");
        }
    }
}
