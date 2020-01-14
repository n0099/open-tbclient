package com.baidu.tieba.pb.videopb.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
/* loaded from: classes7.dex */
public class b extends v.a {
    private final int anq;
    public TextView bXF;
    public TextView dHX;
    public TextView grJ;
    private final int iZE;
    public ImageView iZF;
    public HeadPendantClickableView iZG;
    public UserIconBox iZH;
    public TextView iZI;
    public ImageView iZJ;
    public UserIconBox iZK;
    public TextView iZL;
    public TextView iZM;
    public PbFirstFloorUserLikeButton iZN;
    public RelativeLayout iZO;
    public ImageView iZP;
    public RelativeLayout iZQ;
    public TextView iZR;
    public TextView iZS;
    private int iZT;
    private int iZU;
    public View mRoot;

    public b(Context context, View view) {
        super(view);
        this.iZE = 2;
        this.anq = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mRoot = view;
        this.iZF = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.iZG = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.iZG.setHasPendantStyle();
        this.iZG.getHeadView().setIsRound(true);
        this.iZG.getHeadView().setDrawBorder(false);
        this.iZG.getHeadView().setPlaceHolder(1);
        this.iZH = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.bXF = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.iZI = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.iZJ = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.iZK = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.iZL = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.iZM = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.iZN = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.iZO = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.grJ = (TextView) view.findViewById(R.id.title_video_info_item);
        this.grJ.setTextSize(0, TbConfig.getContentSize());
        this.grJ.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.iZP = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.iZQ = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.iZT = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.iZO.getPaddingLeft()) - this.iZO.getPaddingRight();
        zu(0);
        this.dHX = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.iZR = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.iZS = (TextView) view.findViewById(R.id.publish_location_video_info_item);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_e);
        this.iZL.setTextColor(am.getColor(R.color.cp_cont_d));
        this.iZM.setTextColor(am.getColor(R.color.cp_cont_d));
        this.iZN.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.grJ.setTextColor(am.getColor(R.color.cp_cont_b));
        zu(this.iZU);
        this.dHX.setTextColor(am.getColor(R.color.cp_cont_d));
        this.iZR.setTextColor(am.getColor(R.color.cp_cont_d));
        this.iZS.setTextColor(am.getColor(R.color.cp_cont_d));
    }

    public void qW(boolean z) {
        if (z) {
            am.setViewTextColor(this.bXF, R.color.cp_cont_h, 1);
        } else {
            am.setViewTextColor(this.bXF, R.color.cp_cont_b, 1);
        }
    }

    public void zt(int i) {
        if (i > 0) {
            am.setImageResource(this.iZJ, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.iZF.setImageResource(R.drawable.pic_frs_headlines_n);
            this.iZF.setVisibility(0);
        } else if (z2 && z3) {
            this.iZF.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.iZF.setVisibility(0);
        } else if (z2) {
            this.iZF.setImageResource(R.drawable.pic_pb_refined_n);
            this.iZF.setVisibility(0);
        } else if (z3) {
            this.iZF.setImageResource(R.drawable.pic_pb_stick_n);
            this.iZF.setVisibility(0);
        } else {
            this.iZF.setVisibility(8);
        }
    }

    public void Gi(String str) {
        StateListDrawable stateListDrawable;
        StateListDrawable stateListDrawable2 = null;
        if (Config.BAWU_TYPE_MANAGER.equals(str) || Config.BAWU_TYPE_ASSIST.equals(str)) {
            if (Config.BAWU_TYPE_MANAGER.equals(str)) {
                stateListDrawable = com.baidu.tbadk.core.util.f.a.b.aEN().kk(0).ag(this.anq).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aEP();
                stateListDrawable2 = com.baidu.tbadk.core.util.f.a.b.aEN().kk(0).ag(this.anq).tw("#4D000000").aEP();
            } else if (Config.BAWU_TYPE_ASSIST.equals(str)) {
                stateListDrawable = com.baidu.tbadk.core.util.f.a.b.aEN().kk(0).ag(this.anq).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aEP();
                stateListDrawable2 = com.baidu.tbadk.core.util.f.a.b.aEN().kk(0).ag(this.anq).tw("#4D000000").aEP();
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
            this.iZI.setBackgroundDrawable(layerDrawable);
            am.setViewTextColor(this.iZI, (int) R.color.cp_cont_a);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.iZG.setOnClickListener(onClickListener);
        this.iZQ.setOnClickListener(onClickListener);
        this.iZH.setOnClickListener(onClickListener);
        this.bXF.setOnClickListener(onClickListener);
        this.iZK.setOnClickListener(onClickListener);
    }

    public void m(CharSequence charSequence) {
        int i = 1;
        if (charSequence != null) {
            if (this.grJ.getPaint().measureText(charSequence, 0, charSequence.length()) + (this.grJ.getTextSize() * 2.0f) <= this.iZT * 2) {
                i = 0;
            } else if (this.iZU == 1 || this.iZU == 2) {
                i = this.iZU;
            }
            zu(i);
            this.grJ.setText(charSequence);
        }
    }

    public int csF() {
        return this.iZU;
    }

    public void zu(int i) {
        this.iZU = i;
        if (i == 0) {
            csG();
        } else if (i == 1) {
            csH();
        } else if (i == 2) {
            csI();
        }
    }

    private void csG() {
        this.iZQ.setVisibility(8);
        this.grJ.setEllipsize(null);
        this.grJ.setMaxLines(2);
    }

    private void csH() {
        this.iZQ.setVisibility(0);
        SvgManager.aEp().a(this.iZP, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.grJ.setEllipsize(TextUtils.TruncateAt.END);
        this.grJ.setMaxLines(2);
    }

    private void csI() {
        this.iZQ.setVisibility(0);
        SvgManager.aEp().a(this.iZP, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.grJ.setEllipsize(null);
        this.grJ.setMaxLines(Integer.MAX_VALUE);
    }
}
