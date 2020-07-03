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
import com.baidu.adp.widget.ListView.ad;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.e.a.c;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
/* loaded from: classes9.dex */
public class b extends ad.a {
    public TBLottieAnimationView ahz;
    public TextView dEL;
    public TextView eLb;
    public TextView hFI;
    private final int igf;
    public RelativeLayout kAa;
    public TextView kAb;
    public TextView kAc;
    private int kAd;
    private int kAe;
    private final int kzO;
    public ImageView kzP;
    public HeadPendantClickableView kzQ;
    public UserIconBox kzR;
    public TextView kzS;
    public ImageView kzT;
    public UserIconBox kzU;
    public TextView kzV;
    public TextView kzW;
    public PbFirstFloorUserLikeButton kzX;
    public RelativeLayout kzY;
    public ImageView kzZ;
    public View mRoot;
    private int mSkinType;

    public b(Context context, View view) {
        super(view);
        this.kzO = 2;
        this.igf = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mSkinType = 3;
        this.mRoot = view;
        this.kzP = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.kzQ = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.kzQ.setHasPendantStyle();
        this.kzQ.getHeadView().setIsRound(true);
        this.kzQ.getHeadView().setDrawBorder(false);
        this.kzQ.getHeadView().setPlaceHolder(1);
        this.ahz = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        this.kzR = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.dEL = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.kzS = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.kzT = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.kzU = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.kzV = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.kzW = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.kzX = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.kzY = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.hFI = (TextView) view.findViewById(R.id.title_video_info_item);
        this.hFI.setTextSize(0, TbConfig.getContentSize());
        this.hFI.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.kzZ = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.kAa = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.kAd = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.kzY.getPaddingLeft()) - this.kzY.getPaddingRight();
        BZ(0);
        this.eLb = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.kAb = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.kAc = (TextView) view.findViewById(R.id.publish_location_video_info_item);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        an.setBackgroundColor(this.mRoot, R.color.cp_bg_line_e);
        this.kzV.setTextColor(an.getColor(R.color.cp_cont_d));
        this.kzW.setTextColor(an.getColor(R.color.cp_cont_d));
        this.kzX.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hFI.setTextColor(an.getColor(R.color.cp_cont_b));
        BZ(this.kAe);
        this.eLb.setTextColor(an.getColor(R.color.cp_cont_d));
        this.kAb.setTextColor(an.getColor(R.color.cp_cont_d));
        this.kAc.setTextColor(an.getColor(R.color.cp_cont_d));
        if (this.mSkinType != skinType) {
            zk(skinType);
        }
        this.mSkinType = skinType;
    }

    public void sX(boolean z) {
        if (z) {
            an.setViewTextColor(this.dEL, R.color.cp_cont_h, 1);
        } else {
            an.setViewTextColor(this.dEL, R.color.cp_cont_b, 1);
        }
    }

    public void BY(int i) {
        if (i > 0) {
            an.setImageResource(this.kzT, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.kzP.setImageResource(R.drawable.pic_frs_headlines_n);
            this.kzP.setVisibility(0);
        } else if (z2 && z3) {
            this.kzP.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.kzP.setVisibility(0);
        } else if (z2) {
            this.kzP.setImageResource(R.drawable.pic_pb_refined_n);
            this.kzP.setVisibility(0);
        } else if (z3) {
            this.kzP.setImageResource(R.drawable.pic_pb_stick_n);
            this.kzP.setVisibility(0);
        } else {
            this.kzP.setVisibility(8);
        }
    }

    public void Kx(String str) {
        StateListDrawable stateListDrawable;
        StateListDrawable stateListDrawable2 = null;
        if (Config.BAWU_TYPE_MANAGER.equals(str) || Config.BAWU_TYPE_ASSIST.equals(str)) {
            if (Config.BAWU_TYPE_MANAGER.equals(str)) {
                stateListDrawable = c.aXu().lG(0).Q(this.igf).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aXw();
                stateListDrawable2 = c.aXu().lG(0).Q(this.igf).xa("#4D000000").aXw();
            } else if (Config.BAWU_TYPE_ASSIST.equals(str)) {
                stateListDrawable = c.aXu().lG(0).Q(this.igf).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aXw();
                stateListDrawable2 = c.aXu().lG(0).Q(this.igf).xa("#4D000000").aXw();
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
            this.kzS.setBackgroundDrawable(layerDrawable);
            an.setViewTextColor(this.kzS, (int) R.color.cp_cont_a);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.kzQ.setOnClickListener(onClickListener);
        this.kAa.setOnClickListener(onClickListener);
        this.kzR.setOnClickListener(onClickListener);
        this.dEL.setOnClickListener(onClickListener);
        this.kzU.setOnClickListener(onClickListener);
    }

    public void s(CharSequence charSequence) {
        int i = 1;
        if (charSequence != null) {
            if (this.hFI.getPaint().measureText(charSequence, 0, charSequence.length()) + (this.hFI.getTextSize() * 2.0f) <= this.kAd * 2) {
                i = 0;
            } else if (this.kAe == 1 || this.kAe == 2) {
                i = this.kAe;
            }
            BZ(i);
            this.hFI.setText(charSequence);
        }
    }

    public int cQF() {
        return this.kAe;
    }

    public void BZ(int i) {
        this.kAe = i;
        if (i == 0) {
            cQG();
        } else if (i == 1) {
            cQH();
        } else if (i == 2) {
            cQI();
        }
    }

    private void cQG() {
        this.kAa.setVisibility(8);
        this.hFI.setEllipsize(null);
        this.hFI.setMaxLines(2);
    }

    private void cQH() {
        this.kAa.setVisibility(0);
        SvgManager.aWQ().a(this.kzZ, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.hFI.setEllipsize(TextUtils.TruncateAt.END);
        this.hFI.setMaxLines(2);
    }

    private void cQI() {
        this.kAa.setVisibility(0);
        SvgManager.aWQ().a(this.kzZ, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.hFI.setEllipsize(null);
        this.hFI.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public void qg(boolean z) {
        if (z) {
            this.ahz.setVisibility(0);
            if (!this.ahz.isAnimating()) {
                this.ahz.setSpeed(0.8f);
                this.ahz.setRepeatCount(-1);
                this.ahz.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.e.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.ahz.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.ahz.setVisibility(8);
        if (this.ahz.isAnimating()) {
            this.ahz.cancelAnimation();
        }
    }

    private void zk(int i) {
        if (i == 1) {
            this.ahz.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.ahz.setAnimation("live/card_live_bg_black.json");
        } else {
            this.ahz.setAnimation("live/card_live_bg.json");
        }
    }
}
