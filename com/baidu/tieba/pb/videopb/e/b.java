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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.e.a.c;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
/* loaded from: classes16.dex */
public class b extends ad.a {
    public TBLottieAnimationView ahq;
    public TextView dKI;
    public TextView eRx;
    public TextView hLE;
    private final int imj;
    private final int kIQ;
    public ImageView kIR;
    public HeadPendantClickableView kIS;
    public UserIconBox kIT;
    public TextView kIU;
    public ImageView kIV;
    public UserIconBox kIW;
    public TextView kIX;
    public TextView kIY;
    public PbFirstFloorUserLikeButton kIZ;
    public RelativeLayout kJa;
    public ImageView kJb;
    public RelativeLayout kJc;
    public TextView kJd;
    public TextView kJe;
    private int kJf;
    private int kJg;
    public View mRoot;
    private int mSkinType;

    public b(Context context, View view) {
        super(view);
        this.kIQ = 2;
        this.imj = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mSkinType = 3;
        this.mRoot = view;
        this.kIR = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.kIS = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.kIS.setHasPendantStyle();
        this.kIS.getHeadView().setIsRound(true);
        this.kIS.getHeadView().setDrawBorder(false);
        this.kIS.getHeadView().setPlaceHolder(1);
        this.ahq = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        this.kIT = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.dKI = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.kIU = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.kIV = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.kIW = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.kIX = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.kIY = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.kIZ = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.kJa = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.hLE = (TextView) view.findViewById(R.id.title_video_info_item);
        this.hLE.setTextSize(0, TbConfig.getContentSize());
        this.hLE.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.kJb = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.kJc = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.kJf = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.kJa.getPaddingLeft()) - this.kJa.getPaddingRight();
        Cz(0);
        this.eRx = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.kJd = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.kJe = (TextView) view.findViewById(R.id.publish_location_video_info_item);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ao.setBackgroundColor(this.mRoot, R.color.cp_bg_line_e);
        this.kIX.setTextColor(ao.getColor(R.color.cp_cont_d));
        this.kIY.setTextColor(ao.getColor(R.color.cp_cont_d));
        this.kIZ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hLE.setTextColor(ao.getColor(R.color.cp_cont_b));
        Cz(this.kJg);
        this.eRx.setTextColor(ao.getColor(R.color.cp_cont_d));
        this.kJd.setTextColor(ao.getColor(R.color.cp_cont_d));
        this.kJe.setTextColor(ao.getColor(R.color.cp_cont_d));
        if (this.mSkinType != skinType) {
            zJ(skinType);
        }
        this.mSkinType = skinType;
    }

    public void tD(boolean z) {
        if (z) {
            ao.setViewTextColor(this.dKI, R.color.cp_cont_h, 1);
        } else {
            ao.setViewTextColor(this.dKI, R.color.cp_cont_b, 1);
        }
    }

    public void Cy(int i) {
        if (i > 0) {
            ao.setImageResource(this.kIV, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.kIR.setImageResource(R.drawable.pic_frs_headlines_n);
            this.kIR.setVisibility(0);
        } else if (z2 && z3) {
            this.kIR.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.kIR.setVisibility(0);
        } else if (z2) {
            this.kIR.setImageResource(R.drawable.pic_pb_refined_n);
            this.kIR.setVisibility(0);
        } else if (z3) {
            this.kIR.setImageResource(R.drawable.pic_pb_stick_n);
            this.kIR.setVisibility(0);
        } else {
            this.kIR.setVisibility(8);
        }
    }

    public void Ll(String str) {
        StateListDrawable stateListDrawable;
        StateListDrawable stateListDrawable2 = null;
        if (Config.BAWU_TYPE_MANAGER.equals(str) || Config.BAWU_TYPE_ASSIST.equals(str)) {
            if (Config.BAWU_TYPE_MANAGER.equals(str)) {
                stateListDrawable = c.bbv().ma(0).Q(this.imj).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bbx();
                stateListDrawable2 = c.bbv().ma(0).Q(this.imj).yi("#4D000000").bbx();
            } else if (Config.BAWU_TYPE_ASSIST.equals(str)) {
                stateListDrawable = c.bbv().ma(0).Q(this.imj).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bbx();
                stateListDrawable2 = c.bbv().ma(0).Q(this.imj).yi("#4D000000").bbx();
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
            this.kIU.setBackgroundDrawable(layerDrawable);
            ao.setViewTextColor(this.kIU, R.color.cp_cont_a);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.kIS.setOnClickListener(onClickListener);
        this.kJc.setOnClickListener(onClickListener);
        this.kIT.setOnClickListener(onClickListener);
        this.dKI.setOnClickListener(onClickListener);
        this.kIW.setOnClickListener(onClickListener);
    }

    public void s(CharSequence charSequence) {
        int i = 1;
        if (charSequence != null) {
            if (this.hLE.getPaint().measureText(charSequence, 0, charSequence.length()) + (this.hLE.getTextSize() * 2.0f) <= this.kJf * 2) {
                i = 0;
            } else if (this.kJg == 1 || this.kJg == 2) {
                i = this.kJg;
            }
            Cz(i);
            this.hLE.setText(charSequence);
        }
    }

    public int cUw() {
        return this.kJg;
    }

    public void Cz(int i) {
        this.kJg = i;
        if (i == 0) {
            cUx();
        } else if (i == 1) {
            cUy();
        } else if (i == 2) {
            cUz();
        }
    }

    private void cUx() {
        this.kJc.setVisibility(8);
        this.hLE.setEllipsize(null);
        this.hLE.setMaxLines(2);
    }

    private void cUy() {
        this.kJc.setVisibility(0);
        SvgManager.baR().a(this.kJb, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.hLE.setEllipsize(TextUtils.TruncateAt.END);
        this.hLE.setMaxLines(2);
    }

    private void cUz() {
        this.kJc.setVisibility(0);
        SvgManager.baR().a(this.kJb, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.hLE.setEllipsize(null);
        this.hLE.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public void qN(boolean z) {
        if (z) {
            this.ahq.setVisibility(0);
            if (!this.ahq.isAnimating()) {
                this.ahq.setSpeed(0.8f);
                this.ahq.setRepeatCount(-1);
                this.ahq.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.e.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.ahq.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.ahq.setVisibility(8);
        if (this.ahq.isAnimating()) {
            this.ahq.cancelAnimation();
        }
    }

    private void zJ(int i) {
        if (i == 1) {
            this.ahq.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.ahq.setAnimation("live/card_live_bg_black.json");
        } else {
            this.ahq.setAnimation("live/card_live_bg.json");
        }
    }
}
