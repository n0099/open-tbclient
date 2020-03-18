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
    private final int aqT;
    public TextView cbW;
    public TextView dMG;
    public TextView guC;
    private final int jcS;
    public ImageView jcT;
    public HeadPendantClickableView jcU;
    public UserIconBox jcV;
    public TextView jcW;
    public ImageView jcX;
    public UserIconBox jcY;
    public TextView jcZ;
    public TextView jda;
    public PbFirstFloorUserLikeButton jdb;
    public RelativeLayout jdc;
    public ImageView jdd;
    public RelativeLayout jde;
    public TextView jdf;
    public TextView jdg;
    private int jdh;
    private int jdi;
    public View mRoot;

    public b(Context context, View view) {
        super(view);
        this.jcS = 2;
        this.aqT = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mRoot = view;
        this.jcT = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.jcU = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.jcU.setHasPendantStyle();
        this.jcU.getHeadView().setIsRound(true);
        this.jcU.getHeadView().setDrawBorder(false);
        this.jcU.getHeadView().setPlaceHolder(1);
        this.jcV = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.cbW = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.jcW = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.jcX = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.jcY = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.jcZ = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.jda = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.jdb = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.jdc = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.guC = (TextView) view.findViewById(R.id.title_video_info_item);
        this.guC.setTextSize(0, TbConfig.getContentSize());
        this.guC.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.jdd = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.jde = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.jdh = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.jdc.getPaddingLeft()) - this.jdc.getPaddingRight();
        zJ(0);
        this.dMG = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.jdf = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.jdg = (TextView) view.findViewById(R.id.publish_location_video_info_item);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_e);
        this.jcZ.setTextColor(am.getColor(R.color.cp_cont_d));
        this.jda.setTextColor(am.getColor(R.color.cp_cont_d));
        this.jdb.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.guC.setTextColor(am.getColor(R.color.cp_cont_b));
        zJ(this.jdi);
        this.dMG.setTextColor(am.getColor(R.color.cp_cont_d));
        this.jdf.setTextColor(am.getColor(R.color.cp_cont_d));
        this.jdg.setTextColor(am.getColor(R.color.cp_cont_d));
    }

    public void rh(boolean z) {
        if (z) {
            am.setViewTextColor(this.cbW, R.color.cp_cont_h, 1);
        } else {
            am.setViewTextColor(this.cbW, R.color.cp_cont_b, 1);
        }
    }

    public void zI(int i) {
        if (i > 0) {
            am.setImageResource(this.jcX, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.jcT.setImageResource(R.drawable.pic_frs_headlines_n);
            this.jcT.setVisibility(0);
        } else if (z2 && z3) {
            this.jcT.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.jcT.setVisibility(0);
        } else if (z2) {
            this.jcT.setImageResource(R.drawable.pic_pb_refined_n);
            this.jcT.setVisibility(0);
        } else if (z3) {
            this.jcT.setImageResource(R.drawable.pic_pb_stick_n);
            this.jcT.setVisibility(0);
        } else {
            this.jcT.setVisibility(8);
        }
    }

    public void Gx(String str) {
        StateListDrawable stateListDrawable;
        StateListDrawable stateListDrawable2 = null;
        if (Config.BAWU_TYPE_MANAGER.equals(str) || Config.BAWU_TYPE_ASSIST.equals(str)) {
            if (Config.BAWU_TYPE_MANAGER.equals(str)) {
                stateListDrawable = com.baidu.tbadk.core.util.e.a.b.aHg().kB(0).af(this.aqT).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aHi();
                stateListDrawable2 = com.baidu.tbadk.core.util.e.a.b.aHg().kB(0).af(this.aqT).tM("#4D000000").aHi();
            } else if (Config.BAWU_TYPE_ASSIST.equals(str)) {
                stateListDrawable = com.baidu.tbadk.core.util.e.a.b.aHg().kB(0).af(this.aqT).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aHi();
                stateListDrawable2 = com.baidu.tbadk.core.util.e.a.b.aHg().kB(0).af(this.aqT).tM("#4D000000").aHi();
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
            this.jcW.setBackgroundDrawable(layerDrawable);
            am.setViewTextColor(this.jcW, (int) R.color.cp_cont_a);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.jcU.setOnClickListener(onClickListener);
        this.jde.setOnClickListener(onClickListener);
        this.jcV.setOnClickListener(onClickListener);
        this.cbW.setOnClickListener(onClickListener);
        this.jcY.setOnClickListener(onClickListener);
    }

    public void m(CharSequence charSequence) {
        int i = 1;
        if (charSequence != null) {
            if (this.guC.getPaint().measureText(charSequence, 0, charSequence.length()) + (this.guC.getTextSize() * 2.0f) <= this.jdh * 2) {
                i = 0;
            } else if (this.jdi == 1 || this.jdi == 2) {
                i = this.jdi;
            }
            zJ(i);
            this.guC.setText(charSequence);
        }
    }

    public int cuw() {
        return this.jdi;
    }

    public void zJ(int i) {
        this.jdi = i;
        if (i == 0) {
            cux();
        } else if (i == 1) {
            cuy();
        } else if (i == 2) {
            cuz();
        }
    }

    private void cux() {
        this.jde.setVisibility(8);
        this.guC.setEllipsize(null);
        this.guC.setMaxLines(2);
    }

    private void cuy() {
        this.jde.setVisibility(0);
        SvgManager.aGG().a(this.jdd, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.guC.setEllipsize(TextUtils.TruncateAt.END);
        this.guC.setMaxLines(2);
    }

    private void cuz() {
        this.jde.setVisibility(0);
        SvgManager.aGG().a(this.jdd, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.guC.setEllipsize(null);
        this.guC.setMaxLines(Integer.MAX_VALUE);
    }
}
