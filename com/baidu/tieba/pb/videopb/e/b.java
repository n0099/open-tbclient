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
    private final int aqI;
    public TextView cbK;
    public TextView dMd;
    public TextView gtM;
    private final int jbh;
    public ImageView jbi;
    public HeadPendantClickableView jbj;
    public UserIconBox jbk;
    public TextView jbl;
    public ImageView jbm;
    public UserIconBox jbn;
    public TextView jbo;
    public TextView jbp;
    public PbFirstFloorUserLikeButton jbq;
    public RelativeLayout jbr;
    public ImageView jbs;
    public RelativeLayout jbt;
    public TextView jbu;
    public TextView jbv;
    private int jbw;
    private int jbx;
    public View mRoot;

    public b(Context context, View view) {
        super(view);
        this.jbh = 2;
        this.aqI = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mRoot = view;
        this.jbi = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.jbj = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.jbj.setHasPendantStyle();
        this.jbj.getHeadView().setIsRound(true);
        this.jbj.getHeadView().setDrawBorder(false);
        this.jbj.getHeadView().setPlaceHolder(1);
        this.jbk = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.cbK = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.jbl = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.jbm = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.jbn = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.jbo = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.jbp = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.jbq = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.jbr = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.gtM = (TextView) view.findViewById(R.id.title_video_info_item);
        this.gtM.setTextSize(0, TbConfig.getContentSize());
        this.gtM.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.jbs = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.jbt = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.jbw = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.jbr.getPaddingLeft()) - this.jbr.getPaddingRight();
        zB(0);
        this.dMd = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.jbu = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.jbv = (TextView) view.findViewById(R.id.publish_location_video_info_item);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_e);
        this.jbo.setTextColor(am.getColor(R.color.cp_cont_d));
        this.jbp.setTextColor(am.getColor(R.color.cp_cont_d));
        this.jbq.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gtM.setTextColor(am.getColor(R.color.cp_cont_b));
        zB(this.jbx);
        this.dMd.setTextColor(am.getColor(R.color.cp_cont_d));
        this.jbu.setTextColor(am.getColor(R.color.cp_cont_d));
        this.jbv.setTextColor(am.getColor(R.color.cp_cont_d));
    }

    public void rb(boolean z) {
        if (z) {
            am.setViewTextColor(this.cbK, R.color.cp_cont_h, 1);
        } else {
            am.setViewTextColor(this.cbK, R.color.cp_cont_b, 1);
        }
    }

    public void zA(int i) {
        if (i > 0) {
            am.setImageResource(this.jbm, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.jbi.setImageResource(R.drawable.pic_frs_headlines_n);
            this.jbi.setVisibility(0);
        } else if (z2 && z3) {
            this.jbi.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.jbi.setVisibility(0);
        } else if (z2) {
            this.jbi.setImageResource(R.drawable.pic_pb_refined_n);
            this.jbi.setVisibility(0);
        } else if (z3) {
            this.jbi.setImageResource(R.drawable.pic_pb_stick_n);
            this.jbi.setVisibility(0);
        } else {
            this.jbi.setVisibility(8);
        }
    }

    public void Gx(String str) {
        StateListDrawable stateListDrawable;
        StateListDrawable stateListDrawable2 = null;
        if (Config.BAWU_TYPE_MANAGER.equals(str) || Config.BAWU_TYPE_ASSIST.equals(str)) {
            if (Config.BAWU_TYPE_MANAGER.equals(str)) {
                stateListDrawable = com.baidu.tbadk.core.util.f.a.b.aHb().kB(0).af(this.aqI).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aHd();
                stateListDrawable2 = com.baidu.tbadk.core.util.f.a.b.aHb().kB(0).af(this.aqI).tM("#4D000000").aHd();
            } else if (Config.BAWU_TYPE_ASSIST.equals(str)) {
                stateListDrawable = com.baidu.tbadk.core.util.f.a.b.aHb().kB(0).af(this.aqI).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aHd();
                stateListDrawable2 = com.baidu.tbadk.core.util.f.a.b.aHb().kB(0).af(this.aqI).tM("#4D000000").aHd();
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
            this.jbl.setBackgroundDrawable(layerDrawable);
            am.setViewTextColor(this.jbl, (int) R.color.cp_cont_a);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.jbj.setOnClickListener(onClickListener);
        this.jbt.setOnClickListener(onClickListener);
        this.jbk.setOnClickListener(onClickListener);
        this.cbK.setOnClickListener(onClickListener);
        this.jbn.setOnClickListener(onClickListener);
    }

    public void m(CharSequence charSequence) {
        int i = 1;
        if (charSequence != null) {
            if (this.gtM.getPaint().measureText(charSequence, 0, charSequence.length()) + (this.gtM.getTextSize() * 2.0f) <= this.jbw * 2) {
                i = 0;
            } else if (this.jbx == 1 || this.jbx == 2) {
                i = this.jbx;
            }
            zB(i);
            this.gtM.setText(charSequence);
        }
    }

    public int cuc() {
        return this.jbx;
    }

    public void zB(int i) {
        this.jbx = i;
        if (i == 0) {
            cud();
        } else if (i == 1) {
            cue();
        } else if (i == 2) {
            cuf();
        }
    }

    private void cud() {
        this.jbt.setVisibility(8);
        this.gtM.setEllipsize(null);
        this.gtM.setMaxLines(2);
    }

    private void cue() {
        this.jbt.setVisibility(0);
        SvgManager.aGC().a(this.jbs, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.gtM.setEllipsize(TextUtils.TruncateAt.END);
        this.gtM.setMaxLines(2);
    }

    private void cuf() {
        this.jbt.setVisibility(0);
        SvgManager.aGC().a(this.jbs, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.gtM.setEllipsize(null);
        this.gtM.setMaxLines(Integer.MAX_VALUE);
    }
}
