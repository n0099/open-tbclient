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
import com.baidu.adp.widget.ListView.y;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.e.a.c;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
/* loaded from: classes9.dex */
public class b extends y.a {
    public TextView cBd;
    public TextView emC;
    public TextView hdT;
    private final int jNe;
    public ImageView jNf;
    public HeadPendantClickableView jNg;
    public UserIconBox jNh;
    public TextView jNi;
    public ImageView jNj;
    public UserIconBox jNk;
    public TextView jNl;
    public TextView jNm;
    public PbFirstFloorUserLikeButton jNn;
    public RelativeLayout jNo;
    public ImageView jNp;
    public RelativeLayout jNq;
    public TextView jNr;
    public TextView jNs;
    private int jNt;
    private int jNu;
    private final int jpm;
    public View mRoot;

    public b(Context context, View view) {
        super(view);
        this.jNe = 2;
        this.jpm = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mRoot = view;
        this.jNf = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.jNg = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.jNg.setHasPendantStyle();
        this.jNg.getHeadView().setIsRound(true);
        this.jNg.getHeadView().setDrawBorder(false);
        this.jNg.getHeadView().setPlaceHolder(1);
        this.jNh = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.cBd = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.jNi = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.jNj = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.jNk = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.jNl = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.jNm = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.jNn = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.jNo = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.hdT = (TextView) view.findViewById(R.id.title_video_info_item);
        this.hdT.setTextSize(0, TbConfig.getContentSize());
        this.hdT.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.jNp = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.jNq = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.jNt = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.jNo.getPaddingLeft()) - this.jNo.getPaddingRight();
        Ak(0);
        this.emC = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.jNr = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.jNs = (TextView) view.findViewById(R.id.publish_location_video_info_item);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_e);
        this.jNl.setTextColor(am.getColor(R.color.cp_cont_d));
        this.jNm.setTextColor(am.getColor(R.color.cp_cont_d));
        this.jNn.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hdT.setTextColor(am.getColor(R.color.cp_cont_b));
        Ak(this.jNu);
        this.emC.setTextColor(am.getColor(R.color.cp_cont_d));
        this.jNr.setTextColor(am.getColor(R.color.cp_cont_d));
        this.jNs.setTextColor(am.getColor(R.color.cp_cont_d));
    }

    public void sl(boolean z) {
        if (z) {
            am.setViewTextColor(this.cBd, R.color.cp_cont_h, 1);
        } else {
            am.setViewTextColor(this.cBd, R.color.cp_cont_b, 1);
        }
    }

    public void Aj(int i) {
        if (i > 0) {
            am.setImageResource(this.jNj, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.jNf.setImageResource(R.drawable.pic_frs_headlines_n);
            this.jNf.setVisibility(0);
        } else if (z2 && z3) {
            this.jNf.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.jNf.setVisibility(0);
        } else if (z2) {
            this.jNf.setImageResource(R.drawable.pic_pb_refined_n);
            this.jNf.setVisibility(0);
        } else if (z3) {
            this.jNf.setImageResource(R.drawable.pic_pb_stick_n);
            this.jNf.setVisibility(0);
        } else {
            this.jNf.setVisibility(8);
        }
    }

    public void Ii(String str) {
        StateListDrawable stateListDrawable;
        StateListDrawable stateListDrawable2 = null;
        if (Config.BAWU_TYPE_MANAGER.equals(str) || Config.BAWU_TYPE_ASSIST.equals(str)) {
            if (Config.BAWU_TYPE_MANAGER.equals(str)) {
                stateListDrawable = c.aPv().kL(0).P(this.jpm).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aPx();
                stateListDrawable2 = c.aPv().kL(0).P(this.jpm).vd("#4D000000").aPx();
            } else if (Config.BAWU_TYPE_ASSIST.equals(str)) {
                stateListDrawable = c.aPv().kL(0).P(this.jpm).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aPx();
                stateListDrawable2 = c.aPv().kL(0).P(this.jpm).vd("#4D000000").aPx();
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
            this.jNi.setBackgroundDrawable(layerDrawable);
            am.setViewTextColor(this.jNi, (int) R.color.cp_cont_a);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.jNg.setOnClickListener(onClickListener);
        this.jNq.setOnClickListener(onClickListener);
        this.jNh.setOnClickListener(onClickListener);
        this.cBd.setOnClickListener(onClickListener);
        this.jNk.setOnClickListener(onClickListener);
    }

    public void n(CharSequence charSequence) {
        int i = 1;
        if (charSequence != null) {
            if (this.hdT.getPaint().measureText(charSequence, 0, charSequence.length()) + (this.hdT.getTextSize() * 2.0f) <= this.jNt * 2) {
                i = 0;
            } else if (this.jNu == 1 || this.jNu == 2) {
                i = this.jNu;
            }
            Ak(i);
            this.hdT.setText(charSequence);
        }
    }

    public int cEZ() {
        return this.jNu;
    }

    public void Ak(int i) {
        this.jNu = i;
        if (i == 0) {
            cFa();
        } else if (i == 1) {
            cFb();
        } else if (i == 2) {
            cFc();
        }
    }

    private void cFa() {
        this.jNq.setVisibility(8);
        this.hdT.setEllipsize(null);
        this.hdT.setMaxLines(2);
    }

    private void cFb() {
        this.jNq.setVisibility(0);
        SvgManager.aOR().a(this.jNp, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.hdT.setEllipsize(TextUtils.TruncateAt.END);
        this.hdT.setMaxLines(2);
    }

    private void cFc() {
        this.jNq.setVisibility(0);
        SvgManager.aOR().a(this.jNp, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.hdT.setEllipsize(null);
        this.hdT.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }
}
