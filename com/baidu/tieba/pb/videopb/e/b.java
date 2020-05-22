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
import com.baidu.adp.widget.ListView.aa;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.e.a.c;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
/* loaded from: classes9.dex */
public class b extends aa.a {
    public TBLottieAnimationView agv;
    public TextView dXU;
    public TextView eBh;
    public TextView hsH;
    private final int jFV;
    private final int keU;
    public ImageView keV;
    public HeadPendantClickableView keW;
    public UserIconBox keX;
    public TextView keY;
    public ImageView keZ;
    public UserIconBox kfa;
    public TextView kfb;
    public TextView kfc;
    public PbFirstFloorUserLikeButton kfd;
    public RelativeLayout kfe;
    public ImageView kff;
    public RelativeLayout kfg;
    public TextView kfh;
    public TextView kfi;
    private int kfj;
    private int kfk;
    public View mRoot;
    private int mSkinType;

    public b(Context context, View view) {
        super(view);
        this.keU = 2;
        this.jFV = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mSkinType = 3;
        this.mRoot = view;
        this.keV = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.keW = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.keW.setHasPendantStyle();
        this.keW.getHeadView().setIsRound(true);
        this.keW.getHeadView().setDrawBorder(false);
        this.keW.getHeadView().setPlaceHolder(1);
        this.agv = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        this.keX = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.dXU = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.keY = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.keZ = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.kfa = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.kfb = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.kfc = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.kfd = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.kfe = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.hsH = (TextView) view.findViewById(R.id.title_video_info_item);
        this.hsH.setTextSize(0, TbConfig.getContentSize());
        this.hsH.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.kff = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.kfg = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.kfj = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.kfe.getPaddingLeft()) - this.kfe.getPaddingRight();
        AV(0);
        this.eBh = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.kfh = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.kfi = (TextView) view.findViewById(R.id.publish_location_video_info_item);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_e);
        this.kfb.setTextColor(am.getColor(R.color.cp_cont_d));
        this.kfc.setTextColor(am.getColor(R.color.cp_cont_d));
        this.kfd.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hsH.setTextColor(am.getColor(R.color.cp_cont_b));
        AV(this.kfk);
        this.eBh.setTextColor(am.getColor(R.color.cp_cont_d));
        this.kfh.setTextColor(am.getColor(R.color.cp_cont_d));
        this.kfi.setTextColor(am.getColor(R.color.cp_cont_d));
        if (this.mSkinType != skinType) {
            yw(skinType);
        }
        this.mSkinType = skinType;
    }

    public void sJ(boolean z) {
        if (z) {
            am.setViewTextColor(this.dXU, R.color.cp_cont_h, 1);
        } else {
            am.setViewTextColor(this.dXU, R.color.cp_cont_b, 1);
        }
    }

    public void AU(int i) {
        if (i > 0) {
            am.setImageResource(this.keZ, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.keV.setImageResource(R.drawable.pic_frs_headlines_n);
            this.keV.setVisibility(0);
        } else if (z2 && z3) {
            this.keV.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.keV.setVisibility(0);
        } else if (z2) {
            this.keV.setImageResource(R.drawable.pic_pb_refined_n);
            this.keV.setVisibility(0);
        } else if (z3) {
            this.keV.setImageResource(R.drawable.pic_pb_stick_n);
            this.keV.setVisibility(0);
        } else {
            this.keV.setVisibility(8);
        }
    }

    public void JU(String str) {
        StateListDrawable stateListDrawable;
        StateListDrawable stateListDrawable2 = null;
        if (Config.BAWU_TYPE_MANAGER.equals(str) || Config.BAWU_TYPE_ASSIST.equals(str)) {
            if (Config.BAWU_TYPE_MANAGER.equals(str)) {
                stateListDrawable = c.aVz().ln(0).O(this.jFV).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aVB();
                stateListDrawable2 = c.aVz().ln(0).O(this.jFV).wJ("#4D000000").aVB();
            } else if (Config.BAWU_TYPE_ASSIST.equals(str)) {
                stateListDrawable = c.aVz().ln(0).O(this.jFV).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aVB();
                stateListDrawable2 = c.aVz().ln(0).O(this.jFV).wJ("#4D000000").aVB();
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
            this.keY.setBackgroundDrawable(layerDrawable);
            am.setViewTextColor(this.keY, (int) R.color.cp_cont_a);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.keW.setOnClickListener(onClickListener);
        this.kfg.setOnClickListener(onClickListener);
        this.keX.setOnClickListener(onClickListener);
        this.dXU.setOnClickListener(onClickListener);
        this.kfa.setOnClickListener(onClickListener);
    }

    public void o(CharSequence charSequence) {
        int i = 1;
        if (charSequence != null) {
            if (this.hsH.getPaint().measureText(charSequence, 0, charSequence.length()) + (this.hsH.getTextSize() * 2.0f) <= this.kfj * 2) {
                i = 0;
            } else if (this.kfk == 1 || this.kfk == 2) {
                i = this.kfk;
            }
            AV(i);
            this.hsH.setText(charSequence);
        }
    }

    public int cLY() {
        return this.kfk;
    }

    public void AV(int i) {
        this.kfk = i;
        if (i == 0) {
            cLZ();
        } else if (i == 1) {
            cMa();
        } else if (i == 2) {
            cMb();
        }
    }

    private void cLZ() {
        this.kfg.setVisibility(8);
        this.hsH.setEllipsize(null);
        this.hsH.setMaxLines(2);
    }

    private void cMa() {
        this.kfg.setVisibility(0);
        SvgManager.aUV().a(this.kff, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.hsH.setEllipsize(TextUtils.TruncateAt.END);
        this.hsH.setMaxLines(2);
    }

    private void cMb() {
        this.kfg.setVisibility(0);
        SvgManager.aUV().a(this.kff, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.hsH.setEllipsize(null);
        this.hsH.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public void pW(boolean z) {
        if (z) {
            this.agv.setVisibility(0);
            if (!this.agv.isAnimating()) {
                this.agv.setSpeed(0.8f);
                this.agv.setRepeatCount(-1);
                this.agv.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.e.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.agv.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.agv.setVisibility(8);
        if (this.agv.isAnimating()) {
            this.agv.cancelAnimation();
        }
    }

    private void yw(int i) {
        if (i == 1) {
            this.agv.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.agv.setAnimation("live/card_live_bg_black.json");
        } else {
            this.agv.setAnimation("live/card_live_bg.json");
        }
    }
}
