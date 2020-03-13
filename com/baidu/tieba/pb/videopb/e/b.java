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
/* loaded from: classes9.dex */
public class b extends v.a {
    private final int aqJ;
    public TextView cbL;
    public TextView dMq;
    public TextView gtY;
    public TextView jbA;
    public TextView jbB;
    public PbFirstFloorUserLikeButton jbC;
    public RelativeLayout jbD;
    public ImageView jbE;
    public RelativeLayout jbF;
    public TextView jbG;
    public TextView jbH;
    private int jbI;
    private int jbJ;
    private final int jbt;
    public ImageView jbu;
    public HeadPendantClickableView jbv;
    public UserIconBox jbw;
    public TextView jbx;
    public ImageView jby;
    public UserIconBox jbz;
    public View mRoot;

    public b(Context context, View view) {
        super(view);
        this.jbt = 2;
        this.aqJ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mRoot = view;
        this.jbu = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.jbv = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.jbv.setHasPendantStyle();
        this.jbv.getHeadView().setIsRound(true);
        this.jbv.getHeadView().setDrawBorder(false);
        this.jbv.getHeadView().setPlaceHolder(1);
        this.jbw = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.cbL = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.jbx = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.jby = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.jbz = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.jbA = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.jbB = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.jbC = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.jbD = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.gtY = (TextView) view.findViewById(R.id.title_video_info_item);
        this.gtY.setTextSize(0, TbConfig.getContentSize());
        this.gtY.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.jbE = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.jbF = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.jbI = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.jbD.getPaddingLeft()) - this.jbD.getPaddingRight();
        zB(0);
        this.dMq = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.jbG = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.jbH = (TextView) view.findViewById(R.id.publish_location_video_info_item);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_e);
        this.jbA.setTextColor(am.getColor(R.color.cp_cont_d));
        this.jbB.setTextColor(am.getColor(R.color.cp_cont_d));
        this.jbC.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gtY.setTextColor(am.getColor(R.color.cp_cont_b));
        zB(this.jbJ);
        this.dMq.setTextColor(am.getColor(R.color.cp_cont_d));
        this.jbG.setTextColor(am.getColor(R.color.cp_cont_d));
        this.jbH.setTextColor(am.getColor(R.color.cp_cont_d));
    }

    public void rb(boolean z) {
        if (z) {
            am.setViewTextColor(this.cbL, R.color.cp_cont_h, 1);
        } else {
            am.setViewTextColor(this.cbL, R.color.cp_cont_b, 1);
        }
    }

    public void zA(int i) {
        if (i > 0) {
            am.setImageResource(this.jby, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.jbu.setImageResource(R.drawable.pic_frs_headlines_n);
            this.jbu.setVisibility(0);
        } else if (z2 && z3) {
            this.jbu.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.jbu.setVisibility(0);
        } else if (z2) {
            this.jbu.setImageResource(R.drawable.pic_pb_refined_n);
            this.jbu.setVisibility(0);
        } else if (z3) {
            this.jbu.setImageResource(R.drawable.pic_pb_stick_n);
            this.jbu.setVisibility(0);
        } else {
            this.jbu.setVisibility(8);
        }
    }

    public void Gy(String str) {
        StateListDrawable stateListDrawable;
        StateListDrawable stateListDrawable2 = null;
        if (Config.BAWU_TYPE_MANAGER.equals(str) || Config.BAWU_TYPE_ASSIST.equals(str)) {
            if (Config.BAWU_TYPE_MANAGER.equals(str)) {
                stateListDrawable = com.baidu.tbadk.core.util.e.a.b.aHc().kB(0).af(this.aqJ).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aHe();
                stateListDrawable2 = com.baidu.tbadk.core.util.e.a.b.aHc().kB(0).af(this.aqJ).tN("#4D000000").aHe();
            } else if (Config.BAWU_TYPE_ASSIST.equals(str)) {
                stateListDrawable = com.baidu.tbadk.core.util.e.a.b.aHc().kB(0).af(this.aqJ).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aHe();
                stateListDrawable2 = com.baidu.tbadk.core.util.e.a.b.aHc().kB(0).af(this.aqJ).tN("#4D000000").aHe();
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
            this.jbx.setBackgroundDrawable(layerDrawable);
            am.setViewTextColor(this.jbx, (int) R.color.cp_cont_a);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.jbv.setOnClickListener(onClickListener);
        this.jbF.setOnClickListener(onClickListener);
        this.jbw.setOnClickListener(onClickListener);
        this.cbL.setOnClickListener(onClickListener);
        this.jbz.setOnClickListener(onClickListener);
    }

    public void m(CharSequence charSequence) {
        int i = 1;
        if (charSequence != null) {
            if (this.gtY.getPaint().measureText(charSequence, 0, charSequence.length()) + (this.gtY.getTextSize() * 2.0f) <= this.jbI * 2) {
                i = 0;
            } else if (this.jbJ == 1 || this.jbJ == 2) {
                i = this.jbJ;
            }
            zB(i);
            this.gtY.setText(charSequence);
        }
    }

    public int cud() {
        return this.jbJ;
    }

    public void zB(int i) {
        this.jbJ = i;
        if (i == 0) {
            cue();
        } else if (i == 1) {
            cuf();
        } else if (i == 2) {
            cug();
        }
    }

    private void cue() {
        this.jbF.setVisibility(8);
        this.gtY.setEllipsize(null);
        this.gtY.setMaxLines(2);
    }

    private void cuf() {
        this.jbF.setVisibility(0);
        SvgManager.aGC().a(this.jbE, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.gtY.setEllipsize(TextUtils.TruncateAt.END);
        this.gtY.setMaxLines(2);
    }

    private void cug() {
        this.jbF.setVisibility(0);
        SvgManager.aGC().a(this.jbE, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.gtY.setEllipsize(null);
        this.gtY.setMaxLines(Integer.MAX_VALUE);
    }
}
