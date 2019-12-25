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
/* loaded from: classes6.dex */
public class b extends v.a {
    private final int amD;
    public TextView bXt;
    public TextView dHO;
    public TextView goA;
    private final int iVW;
    public ImageView iVX;
    public HeadPendantClickableView iVY;
    public UserIconBox iVZ;
    public TextView iWa;
    public ImageView iWb;
    public UserIconBox iWc;
    public TextView iWd;
    public TextView iWe;
    public PbFirstFloorUserLikeButton iWf;
    public RelativeLayout iWg;
    public ImageView iWh;
    public RelativeLayout iWi;
    public TextView iWj;
    public TextView iWk;
    private int iWl;
    private int iWm;
    public View mRoot;

    public b(Context context, View view) {
        super(view);
        this.iVW = 2;
        this.amD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mRoot = view;
        this.iVX = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.iVY = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.iVY.setHasPendantStyle();
        this.iVY.getHeadView().setIsRound(true);
        this.iVY.getHeadView().setDrawBorder(false);
        this.iVY.getHeadView().setPlaceHolder(1);
        this.iVZ = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.bXt = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.iWa = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.iWb = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.iWc = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.iWd = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.iWe = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.iWf = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.iWg = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.goA = (TextView) view.findViewById(R.id.title_video_info_item);
        this.goA.setTextSize(0, TbConfig.getContentSize());
        this.goA.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.iWh = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.iWi = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.iWl = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.iWg.getPaddingLeft()) - this.iWg.getPaddingRight();
        zp(0);
        this.dHO = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.iWj = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.iWk = (TextView) view.findViewById(R.id.publish_location_video_info_item);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_e);
        this.iWd.setTextColor(am.getColor(R.color.cp_cont_d));
        this.iWe.setTextColor(am.getColor(R.color.cp_cont_d));
        this.iWf.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.goA.setTextColor(am.getColor(R.color.cp_cont_b));
        zp(this.iWm);
        this.dHO.setTextColor(am.getColor(R.color.cp_cont_d));
        this.iWj.setTextColor(am.getColor(R.color.cp_cont_d));
        this.iWk.setTextColor(am.getColor(R.color.cp_cont_d));
    }

    public void qJ(boolean z) {
        if (z) {
            am.setViewTextColor(this.bXt, R.color.cp_cont_h, 1);
        } else {
            am.setViewTextColor(this.bXt, R.color.cp_cont_b, 1);
        }
    }

    public void zo(int i) {
        if (i > 0) {
            am.setImageResource(this.iWb, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.iVX.setImageResource(R.drawable.pic_frs_headlines_n);
            this.iVX.setVisibility(0);
        } else if (z2 && z3) {
            this.iVX.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.iVX.setVisibility(0);
        } else if (z2) {
            this.iVX.setImageResource(R.drawable.pic_pb_refined_n);
            this.iVX.setVisibility(0);
        } else if (z3) {
            this.iVX.setImageResource(R.drawable.pic_pb_stick_n);
            this.iVX.setVisibility(0);
        } else {
            this.iVX.setVisibility(8);
        }
    }

    public void FY(String str) {
        StateListDrawable stateListDrawable;
        StateListDrawable stateListDrawable2 = null;
        if (Config.BAWU_TYPE_MANAGER.equals(str) || Config.BAWU_TYPE_ASSIST.equals(str)) {
            if (Config.BAWU_TYPE_MANAGER.equals(str)) {
                stateListDrawable = com.baidu.tbadk.core.util.f.a.b.aEu().kk(0).ah(this.amD).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aEw();
                stateListDrawable2 = com.baidu.tbadk.core.util.f.a.b.aEu().kk(0).ah(this.amD).ts("#4D000000").aEw();
            } else if (Config.BAWU_TYPE_ASSIST.equals(str)) {
                stateListDrawable = com.baidu.tbadk.core.util.f.a.b.aEu().kk(0).ah(this.amD).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aEw();
                stateListDrawable2 = com.baidu.tbadk.core.util.f.a.b.aEu().kk(0).ah(this.amD).ts("#4D000000").aEw();
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
            this.iWa.setBackgroundDrawable(layerDrawable);
            am.setViewTextColor(this.iWa, (int) R.color.cp_cont_a);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.iVY.setOnClickListener(onClickListener);
        this.iWi.setOnClickListener(onClickListener);
        this.iVZ.setOnClickListener(onClickListener);
        this.bXt.setOnClickListener(onClickListener);
        this.iWc.setOnClickListener(onClickListener);
    }

    public void m(CharSequence charSequence) {
        int i = 1;
        if (charSequence != null) {
            if (this.goA.getPaint().measureText(charSequence, 0, charSequence.length()) + (this.goA.getTextSize() * 2.0f) <= this.iWl * 2) {
                i = 0;
            } else if (this.iWm == 1 || this.iWm == 2) {
                i = this.iWm;
            }
            zp(i);
            this.goA.setText(charSequence);
        }
    }

    public int crw() {
        return this.iWm;
    }

    public void zp(int i) {
        this.iWm = i;
        if (i == 0) {
            crx();
        } else if (i == 1) {
            cry();
        } else if (i == 2) {
            crz();
        }
    }

    private void crx() {
        this.iWi.setVisibility(8);
        this.goA.setEllipsize(null);
        this.goA.setMaxLines(2);
    }

    private void cry() {
        this.iWi.setVisibility(0);
        SvgManager.aDW().a(this.iWh, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.goA.setEllipsize(TextUtils.TruncateAt.END);
        this.goA.setMaxLines(2);
    }

    private void crz() {
        this.iWi.setVisibility(0);
        SvgManager.aDW().a(this.iWh, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.goA.setEllipsize(null);
        this.goA.setMaxLines(Integer.MAX_VALUE);
    }
}
