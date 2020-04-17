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
    public TextView cAX;
    public TextView emx;
    public TextView hdN;
    private final int jNa;
    public ImageView jNb;
    public HeadPendantClickableView jNc;
    public UserIconBox jNd;
    public TextView jNe;
    public ImageView jNf;
    public UserIconBox jNg;
    public TextView jNh;
    public TextView jNi;
    public PbFirstFloorUserLikeButton jNj;
    public RelativeLayout jNk;
    public ImageView jNl;
    public RelativeLayout jNm;
    public TextView jNn;
    public TextView jNo;
    private int jNp;
    private int jNq;
    private final int jpi;
    public View mRoot;

    public b(Context context, View view) {
        super(view);
        this.jNa = 2;
        this.jpi = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mRoot = view;
        this.jNb = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.jNc = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.jNc.setHasPendantStyle();
        this.jNc.getHeadView().setIsRound(true);
        this.jNc.getHeadView().setDrawBorder(false);
        this.jNc.getHeadView().setPlaceHolder(1);
        this.jNd = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.cAX = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.jNe = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.jNf = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.jNg = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.jNh = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.jNi = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.jNj = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.jNk = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.hdN = (TextView) view.findViewById(R.id.title_video_info_item);
        this.hdN.setTextSize(0, TbConfig.getContentSize());
        this.hdN.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.jNl = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.jNm = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.jNp = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.jNk.getPaddingLeft()) - this.jNk.getPaddingRight();
        Ak(0);
        this.emx = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.jNn = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.jNo = (TextView) view.findViewById(R.id.publish_location_video_info_item);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_e);
        this.jNh.setTextColor(am.getColor(R.color.cp_cont_d));
        this.jNi.setTextColor(am.getColor(R.color.cp_cont_d));
        this.jNj.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hdN.setTextColor(am.getColor(R.color.cp_cont_b));
        Ak(this.jNq);
        this.emx.setTextColor(am.getColor(R.color.cp_cont_d));
        this.jNn.setTextColor(am.getColor(R.color.cp_cont_d));
        this.jNo.setTextColor(am.getColor(R.color.cp_cont_d));
    }

    public void sl(boolean z) {
        if (z) {
            am.setViewTextColor(this.cAX, R.color.cp_cont_h, 1);
        } else {
            am.setViewTextColor(this.cAX, R.color.cp_cont_b, 1);
        }
    }

    public void Aj(int i) {
        if (i > 0) {
            am.setImageResource(this.jNf, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.jNb.setImageResource(R.drawable.pic_frs_headlines_n);
            this.jNb.setVisibility(0);
        } else if (z2 && z3) {
            this.jNb.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.jNb.setVisibility(0);
        } else if (z2) {
            this.jNb.setImageResource(R.drawable.pic_pb_refined_n);
            this.jNb.setVisibility(0);
        } else if (z3) {
            this.jNb.setImageResource(R.drawable.pic_pb_stick_n);
            this.jNb.setVisibility(0);
        } else {
            this.jNb.setVisibility(8);
        }
    }

    public void If(String str) {
        StateListDrawable stateListDrawable;
        StateListDrawable stateListDrawable2 = null;
        if (Config.BAWU_TYPE_MANAGER.equals(str) || Config.BAWU_TYPE_ASSIST.equals(str)) {
            if (Config.BAWU_TYPE_MANAGER.equals(str)) {
                stateListDrawable = c.aPy().kL(0).P(this.jpi).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aPA();
                stateListDrawable2 = c.aPy().kL(0).P(this.jpi).va("#4D000000").aPA();
            } else if (Config.BAWU_TYPE_ASSIST.equals(str)) {
                stateListDrawable = c.aPy().kL(0).P(this.jpi).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aPA();
                stateListDrawable2 = c.aPy().kL(0).P(this.jpi).va("#4D000000").aPA();
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
            this.jNe.setBackgroundDrawable(layerDrawable);
            am.setViewTextColor(this.jNe, (int) R.color.cp_cont_a);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.jNc.setOnClickListener(onClickListener);
        this.jNm.setOnClickListener(onClickListener);
        this.jNd.setOnClickListener(onClickListener);
        this.cAX.setOnClickListener(onClickListener);
        this.jNg.setOnClickListener(onClickListener);
    }

    public void n(CharSequence charSequence) {
        int i = 1;
        if (charSequence != null) {
            if (this.hdN.getPaint().measureText(charSequence, 0, charSequence.length()) + (this.hdN.getTextSize() * 2.0f) <= this.jNp * 2) {
                i = 0;
            } else if (this.jNq == 1 || this.jNq == 2) {
                i = this.jNq;
            }
            Ak(i);
            this.hdN.setText(charSequence);
        }
    }

    public int cFc() {
        return this.jNq;
    }

    public void Ak(int i) {
        this.jNq = i;
        if (i == 0) {
            cFd();
        } else if (i == 1) {
            cFe();
        } else if (i == 2) {
            cFf();
        }
    }

    private void cFd() {
        this.jNm.setVisibility(8);
        this.hdN.setEllipsize(null);
        this.hdN.setMaxLines(2);
    }

    private void cFe() {
        this.jNm.setVisibility(0);
        SvgManager.aOU().a(this.jNl, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.hdN.setEllipsize(TextUtils.TruncateAt.END);
        this.hdN.setMaxLines(2);
    }

    private void cFf() {
        this.jNm.setVisibility(0);
        SvgManager.aOU().a(this.jNl, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.hdN.setEllipsize(null);
        this.hdN.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }
}
