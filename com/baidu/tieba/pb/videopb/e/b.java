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
    public TBLottieAnimationView aiG;
    public TextView dTU;
    public TextView fch;
    public TextView hZR;
    private final int iAt;
    private final int kYM;
    public ImageView kYN;
    public HeadPendantClickableView kYO;
    public UserIconBox kYP;
    public TextView kYQ;
    public ImageView kYR;
    public UserIconBox kYS;
    public TextView kYT;
    public TextView kYU;
    public PbFirstFloorUserLikeButton kYV;
    public RelativeLayout kYW;
    public ImageView kYX;
    public RelativeLayout kYY;
    public TextView kYZ;
    public TextView kZa;
    public VoteView kZb;
    private int kZc;
    private int kZd;
    public View mRoot;
    private int mSkinType;

    public b(Context context, View view) {
        super(view);
        this.kYM = 2;
        this.iAt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mSkinType = 3;
        this.mRoot = view;
        this.kYN = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.kYO = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.kYO.setHasPendantStyle();
        this.kYO.getHeadView().setIsRound(true);
        this.kYO.getHeadView().setDrawBorder(false);
        this.kYO.getHeadView().setPlaceHolder(1);
        this.aiG = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        this.kYP = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.dTU = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.kYQ = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.kYR = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.kYS = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.kYT = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.kYU = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.kYV = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.kYW = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.hZR = (TextView) view.findViewById(R.id.title_video_info_item);
        this.hZR.setTextSize(0, TbConfig.getContentSize());
        this.hZR.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.kYX = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.kYY = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.kZc = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.kYW.getPaddingLeft()) - this.kYW.getPaddingRight();
        ET(0);
        this.fch = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.kYZ = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.kZa = (TextView) view.findViewById(R.id.publish_location_video_info_item);
        this.kZb = (VoteView) view.findViewById(R.id.pb_video_vote_view);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_e);
        this.kYT.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.kYU.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.kYV.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hZR.setTextColor(ap.getColor(R.color.cp_cont_b));
        ET(this.kZd);
        this.fch.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.kYZ.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.kZa.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.kZb.onChangeSkinType(skinType);
        if (this.mSkinType != skinType) {
            Cc(skinType);
        }
        this.mSkinType = skinType;
    }

    public void uo(boolean z) {
        if (z) {
            ap.setViewTextColor(this.dTU, R.color.cp_cont_h, 1);
        } else {
            ap.setViewTextColor(this.dTU, R.color.cp_cont_b, 1);
        }
    }

    public void ES(int i) {
        if (i > 0) {
            ap.setImageResource(this.kYR, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.kYN.setImageResource(R.drawable.pic_frs_headlines_n);
            this.kYN.setVisibility(0);
        } else if (z2 && z3) {
            this.kYN.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.kYN.setVisibility(0);
        } else if (z2) {
            this.kYN.setImageResource(R.drawable.pic_pb_refined_n);
            this.kYN.setVisibility(0);
        } else if (z3) {
            this.kYN.setImageResource(R.drawable.pic_pb_stick_n);
            this.kYN.setVisibility(0);
        } else {
            this.kYN.setVisibility(8);
        }
    }

    public void Of(String str) {
        StateListDrawable stateListDrawable;
        StateListDrawable stateListDrawable2 = null;
        if (Config.BAWU_TYPE_MANAGER.equals(str) || Config.BAWU_TYPE_ASSIST.equals(str)) {
            if (Config.BAWU_TYPE_MANAGER.equals(str)) {
                stateListDrawable = com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(this.iAt).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bjT();
                stateListDrawable2 = com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(this.iAt).Ax("#4D000000").bjT();
            } else if (Config.BAWU_TYPE_ASSIST.equals(str)) {
                stateListDrawable = com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(this.iAt).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bjT();
                stateListDrawable2 = com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(this.iAt).Ax("#4D000000").bjT();
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
            this.kYQ.setBackgroundDrawable(layerDrawable);
            ap.setViewTextColor(this.kYQ, R.color.cp_cont_a);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.kYO.setOnClickListener(onClickListener);
        this.kYY.setOnClickListener(onClickListener);
        this.kYP.setOnClickListener(onClickListener);
        this.dTU.setOnClickListener(onClickListener);
        this.kYS.setOnClickListener(onClickListener);
    }

    public void s(CharSequence charSequence) {
        int i = 1;
        if (charSequence != null) {
            if (this.hZR.getPaint().measureText(charSequence, 0, charSequence.length()) + (this.hZR.getTextSize() * 2.0f) <= this.kZc * 2) {
                i = 0;
            } else if (this.kZd == 1 || this.kZd == 2) {
                i = this.kZd;
            }
            ET(i);
            this.hZR.setText(charSequence);
        }
    }

    public int dfu() {
        return this.kZd;
    }

    public void ET(int i) {
        this.kZd = i;
        if (i == 0) {
            dfv();
        } else if (i == 1) {
            dfw();
        } else if (i == 2) {
            dfx();
        }
    }

    private void dfv() {
        this.kYY.setVisibility(8);
        this.hZR.setEllipsize(null);
        this.hZR.setMaxLines(2);
    }

    private void dfw() {
        this.kYY.setVisibility(0);
        SvgManager.bjq().a(this.kYX, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.hZR.setEllipsize(TextUtils.TruncateAt.END);
        this.hZR.setMaxLines(2);
    }

    private void dfx() {
        this.kYY.setVisibility(0);
        SvgManager.bjq().a(this.kYX, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.hZR.setEllipsize(null);
        this.hZR.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public void rv(boolean z) {
        if (z) {
            this.aiG.setVisibility(0);
            if (!this.aiG.isAnimating()) {
                this.aiG.setSpeed(0.8f);
                this.aiG.setRepeatCount(-1);
                this.aiG.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.e.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.aiG.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.aiG.setVisibility(8);
        if (this.aiG.isAnimating()) {
            this.aiG.cancelAnimation();
        }
    }

    private void Cc(int i) {
        if (i == 1) {
            this.aiG.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.aiG.setAnimation("live/card_live_bg_black.json");
        } else {
            this.aiG.setAnimation("live/card_live_bg.json");
        }
    }
}
