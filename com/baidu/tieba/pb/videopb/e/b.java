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
    public TextView eBs;
    public TextView hsS;
    private final int jHb;
    private final int kga;
    public ImageView kgb;
    public HeadPendantClickableView kgc;
    public UserIconBox kgd;
    public TextView kge;
    public ImageView kgf;
    public UserIconBox kgg;
    public TextView kgh;
    public TextView kgi;
    public PbFirstFloorUserLikeButton kgj;
    public RelativeLayout kgk;
    public ImageView kgl;
    public RelativeLayout kgm;
    public TextView kgn;
    public TextView kgo;
    private int kgp;
    private int kgq;
    public View mRoot;
    private int mSkinType;

    public b(Context context, View view) {
        super(view);
        this.kga = 2;
        this.jHb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mSkinType = 3;
        this.mRoot = view;
        this.kgb = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.kgc = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.kgc.setHasPendantStyle();
        this.kgc.getHeadView().setIsRound(true);
        this.kgc.getHeadView().setDrawBorder(false);
        this.kgc.getHeadView().setPlaceHolder(1);
        this.agv = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        this.kgd = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.dXU = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.kge = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.kgf = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.kgg = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.kgh = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.kgi = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.kgj = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.kgk = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.hsS = (TextView) view.findViewById(R.id.title_video_info_item);
        this.hsS.setTextSize(0, TbConfig.getContentSize());
        this.hsS.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.kgl = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.kgm = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.kgp = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.kgk.getPaddingLeft()) - this.kgk.getPaddingRight();
        AX(0);
        this.eBs = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.kgn = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.kgo = (TextView) view.findViewById(R.id.publish_location_video_info_item);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_e);
        this.kgh.setTextColor(am.getColor(R.color.cp_cont_d));
        this.kgi.setTextColor(am.getColor(R.color.cp_cont_d));
        this.kgj.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hsS.setTextColor(am.getColor(R.color.cp_cont_b));
        AX(this.kgq);
        this.eBs.setTextColor(am.getColor(R.color.cp_cont_d));
        this.kgn.setTextColor(am.getColor(R.color.cp_cont_d));
        this.kgo.setTextColor(am.getColor(R.color.cp_cont_d));
        if (this.mSkinType != skinType) {
            yy(skinType);
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

    public void AW(int i) {
        if (i > 0) {
            am.setImageResource(this.kgf, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.kgb.setImageResource(R.drawable.pic_frs_headlines_n);
            this.kgb.setVisibility(0);
        } else if (z2 && z3) {
            this.kgb.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.kgb.setVisibility(0);
        } else if (z2) {
            this.kgb.setImageResource(R.drawable.pic_pb_refined_n);
            this.kgb.setVisibility(0);
        } else if (z3) {
            this.kgb.setImageResource(R.drawable.pic_pb_stick_n);
            this.kgb.setVisibility(0);
        } else {
            this.kgb.setVisibility(8);
        }
    }

    public void JV(String str) {
        StateListDrawable stateListDrawable;
        StateListDrawable stateListDrawable2 = null;
        if (Config.BAWU_TYPE_MANAGER.equals(str) || Config.BAWU_TYPE_ASSIST.equals(str)) {
            if (Config.BAWU_TYPE_MANAGER.equals(str)) {
                stateListDrawable = c.aVA().lp(0).O(this.jHb).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aVC();
                stateListDrawable2 = c.aVA().lp(0).O(this.jHb).wJ("#4D000000").aVC();
            } else if (Config.BAWU_TYPE_ASSIST.equals(str)) {
                stateListDrawable = c.aVA().lp(0).O(this.jHb).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aVC();
                stateListDrawable2 = c.aVA().lp(0).O(this.jHb).wJ("#4D000000").aVC();
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
            this.kge.setBackgroundDrawable(layerDrawable);
            am.setViewTextColor(this.kge, (int) R.color.cp_cont_a);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.kgc.setOnClickListener(onClickListener);
        this.kgm.setOnClickListener(onClickListener);
        this.kgd.setOnClickListener(onClickListener);
        this.dXU.setOnClickListener(onClickListener);
        this.kgg.setOnClickListener(onClickListener);
    }

    public void o(CharSequence charSequence) {
        int i = 1;
        if (charSequence != null) {
            if (this.hsS.getPaint().measureText(charSequence, 0, charSequence.length()) + (this.hsS.getTextSize() * 2.0f) <= this.kgp * 2) {
                i = 0;
            } else if (this.kgq == 1 || this.kgq == 2) {
                i = this.kgq;
            }
            AX(i);
            this.hsS.setText(charSequence);
        }
    }

    public int cMo() {
        return this.kgq;
    }

    public void AX(int i) {
        this.kgq = i;
        if (i == 0) {
            cMp();
        } else if (i == 1) {
            cMq();
        } else if (i == 2) {
            cMr();
        }
    }

    private void cMp() {
        this.kgm.setVisibility(8);
        this.hsS.setEllipsize(null);
        this.hsS.setMaxLines(2);
    }

    private void cMq() {
        this.kgm.setVisibility(0);
        SvgManager.aUW().a(this.kgl, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.hsS.setEllipsize(TextUtils.TruncateAt.END);
        this.hsS.setMaxLines(2);
    }

    private void cMr() {
        this.kgm.setVisibility(0);
        SvgManager.aUW().a(this.kgl, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.hsS.setEllipsize(null);
        this.hsS.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
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

    private void yy(int i) {
        if (i == 1) {
            this.agv.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.agv.setAnimation("live/card_live_bg_black.json");
        } else {
            this.agv.setAnimation("live/card_live_bg.json");
        }
    }
}
