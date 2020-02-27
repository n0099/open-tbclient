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
    public TextView cbJ;
    public TextView dMc;
    public TextView gtK;
    private final int jbf;
    public ImageView jbg;
    public HeadPendantClickableView jbh;
    public UserIconBox jbi;
    public TextView jbj;
    public ImageView jbk;
    public UserIconBox jbl;
    public TextView jbm;
    public TextView jbn;
    public PbFirstFloorUserLikeButton jbo;
    public RelativeLayout jbp;
    public ImageView jbq;
    public RelativeLayout jbr;
    public TextView jbs;
    public TextView jbt;
    private int jbu;
    private int jbv;
    public View mRoot;

    public b(Context context, View view) {
        super(view);
        this.jbf = 2;
        this.aqI = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mRoot = view;
        this.jbg = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.jbh = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.jbh.setHasPendantStyle();
        this.jbh.getHeadView().setIsRound(true);
        this.jbh.getHeadView().setDrawBorder(false);
        this.jbh.getHeadView().setPlaceHolder(1);
        this.jbi = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.cbJ = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.jbj = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.jbk = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.jbl = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.jbm = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.jbn = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.jbo = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.jbp = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.gtK = (TextView) view.findViewById(R.id.title_video_info_item);
        this.gtK.setTextSize(0, TbConfig.getContentSize());
        this.gtK.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.jbq = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.jbr = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.jbu = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.jbp.getPaddingLeft()) - this.jbp.getPaddingRight();
        zB(0);
        this.dMc = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.jbs = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.jbt = (TextView) view.findViewById(R.id.publish_location_video_info_item);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_e);
        this.jbm.setTextColor(am.getColor(R.color.cp_cont_d));
        this.jbn.setTextColor(am.getColor(R.color.cp_cont_d));
        this.jbo.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gtK.setTextColor(am.getColor(R.color.cp_cont_b));
        zB(this.jbv);
        this.dMc.setTextColor(am.getColor(R.color.cp_cont_d));
        this.jbs.setTextColor(am.getColor(R.color.cp_cont_d));
        this.jbt.setTextColor(am.getColor(R.color.cp_cont_d));
    }

    public void rb(boolean z) {
        if (z) {
            am.setViewTextColor(this.cbJ, R.color.cp_cont_h, 1);
        } else {
            am.setViewTextColor(this.cbJ, R.color.cp_cont_b, 1);
        }
    }

    public void zA(int i) {
        if (i > 0) {
            am.setImageResource(this.jbk, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.jbg.setImageResource(R.drawable.pic_frs_headlines_n);
            this.jbg.setVisibility(0);
        } else if (z2 && z3) {
            this.jbg.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.jbg.setVisibility(0);
        } else if (z2) {
            this.jbg.setImageResource(R.drawable.pic_pb_refined_n);
            this.jbg.setVisibility(0);
        } else if (z3) {
            this.jbg.setImageResource(R.drawable.pic_pb_stick_n);
            this.jbg.setVisibility(0);
        } else {
            this.jbg.setVisibility(8);
        }
    }

    public void Gx(String str) {
        StateListDrawable stateListDrawable;
        StateListDrawable stateListDrawable2 = null;
        if (Config.BAWU_TYPE_MANAGER.equals(str) || Config.BAWU_TYPE_ASSIST.equals(str)) {
            if (Config.BAWU_TYPE_MANAGER.equals(str)) {
                stateListDrawable = com.baidu.tbadk.core.util.f.a.b.aGZ().kB(0).af(this.aqI).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aHb();
                stateListDrawable2 = com.baidu.tbadk.core.util.f.a.b.aGZ().kB(0).af(this.aqI).tM("#4D000000").aHb();
            } else if (Config.BAWU_TYPE_ASSIST.equals(str)) {
                stateListDrawable = com.baidu.tbadk.core.util.f.a.b.aGZ().kB(0).af(this.aqI).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aHb();
                stateListDrawable2 = com.baidu.tbadk.core.util.f.a.b.aGZ().kB(0).af(this.aqI).tM("#4D000000").aHb();
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
            this.jbj.setBackgroundDrawable(layerDrawable);
            am.setViewTextColor(this.jbj, (int) R.color.cp_cont_a);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.jbh.setOnClickListener(onClickListener);
        this.jbr.setOnClickListener(onClickListener);
        this.jbi.setOnClickListener(onClickListener);
        this.cbJ.setOnClickListener(onClickListener);
        this.jbl.setOnClickListener(onClickListener);
    }

    public void m(CharSequence charSequence) {
        int i = 1;
        if (charSequence != null) {
            if (this.gtK.getPaint().measureText(charSequence, 0, charSequence.length()) + (this.gtK.getTextSize() * 2.0f) <= this.jbu * 2) {
                i = 0;
            } else if (this.jbv == 1 || this.jbv == 2) {
                i = this.jbv;
            }
            zB(i);
            this.gtK.setText(charSequence);
        }
    }

    public int cua() {
        return this.jbv;
    }

    public void zB(int i) {
        this.jbv = i;
        if (i == 0) {
            cub();
        } else if (i == 1) {
            cuc();
        } else if (i == 2) {
            cud();
        }
    }

    private void cub() {
        this.jbr.setVisibility(8);
        this.gtK.setEllipsize(null);
        this.gtK.setMaxLines(2);
    }

    private void cuc() {
        this.jbr.setVisibility(0);
        SvgManager.aGA().a(this.jbq, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.gtK.setEllipsize(TextUtils.TruncateAt.END);
        this.gtK.setMaxLines(2);
    }

    private void cud() {
        this.jbr.setVisibility(0);
        SvgManager.aGA().a(this.jbq, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.gtK.setEllipsize(null);
        this.gtK.setMaxLines(Integer.MAX_VALUE);
    }
}
