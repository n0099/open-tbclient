package com.baidu.tieba.pb.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.pb.pb.main.ge;
import com.baidu.tieba.pb.pb.main.gf;
import com.baidu.tieba.pb.pb.main.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class y extends FrameLayout {
    private TbPageContext<?> ajP;
    private View cKW;
    private TextView eCh;
    private TextView eCi;
    private PbFirstFloorUserLikeButton eCu;
    private ge eCv;
    private TextView eMA;
    private TextView eMB;
    private TextView eMC;
    private TextView eMD;
    private TextView eME;
    private TextView eMF;
    private View eMG;
    private View eMH;
    private View eMI;
    private View.OnClickListener eMJ;
    private View eMv;
    private ClickableHeaderImageView eMw;
    private HeadPendantClickableView eMx;
    private boolean eMy;
    private LinearLayout eMz;
    private View mRootView;

    public y(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.eMJ = new z(this);
        this.ajP = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(w.j.new_pb_header_user_item_simple, (ViewGroup) this, true);
        this.eMx = (HeadPendantClickableView) this.mRootView.findViewById(w.h.pb_pendant_head_owner_photo);
        this.eMw = (ClickableHeaderImageView) this.mRootView.findViewById(w.h.pb_head_owner_photo);
        this.eCu = (PbFirstFloorUserLikeButton) this.mRootView.findViewById(w.h.pb_like_button);
        this.eCi = (TextView) this.mRootView.findViewById(w.h.pb_head_owner_info_user_intro);
        this.eCh = (TextView) this.mRootView.findViewById(w.h.pb_head_owner_info_user_name);
        this.eMz = (LinearLayout) this.mRootView.findViewById(w.h.pb_head_user_info_content);
        this.eMA = (TextView) this.mRootView.findViewById(w.h.pb_head_owner_info_fan_number);
        this.eMB = (TextView) this.mRootView.findViewById(w.h.pb_head_owner_info_zan_number);
        this.eMC = (TextView) this.mRootView.findViewById(w.h.pb_head_owner_info_thread_number);
        this.eMD = (TextView) this.mRootView.findViewById(w.h.pb_head_owner_info_fan_number_string);
        this.eME = (TextView) this.mRootView.findViewById(w.h.pb_head_owner_info_zan_number_string);
        this.eMF = (TextView) this.mRootView.findViewById(w.h.pb_head_owner_info_thread_number_string);
        this.eMv = this.mRootView.findViewById(w.h.pb_head_owner_root);
        this.cKW = this.mRootView.findViewById(w.h.bottom_divider_line);
        this.eMG = this.mRootView.findViewById(w.h.middle_divider_line);
        this.eMH = this.mRootView.findViewById(w.h.left_vertical_divider_line);
        this.eMI = this.mRootView.findViewById(w.h.middle_vertical_divider_line);
        this.eMx.wm();
        if (this.eMx.getHeadView() != null) {
            this.eMx.getHeadView().setIsRound(true);
            this.eMx.getHeadView().setDrawBorder(false);
        }
        if (this.eMx.getPendantView() != null) {
            this.eMx.getPendantView().setIsRound(true);
            this.eMx.getPendantView().setDrawBorder(false);
        }
        this.eMw.setDefaultResource(17170445);
        this.eMw.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.eMw.setDefaultBgResource(w.e.cp_bg_line_e);
        this.eMw.setIsRound(true);
        this.eCv = new ge(this.ajP, this.eCu, 2);
    }

    public void setData(com.baidu.tieba.pb.data.j jVar) {
        if (jVar != null && jVar.erZ != null) {
            MetaData metaData = jVar.erZ;
            this.eMy = metaData.isBigV();
            if (this.eCv != null) {
                this.eCv.isBigV = this.eMy;
            }
            if (this.eMy) {
                this.eMw.setVisibility(0);
                this.eMx.setVisibility(8);
                this.eMw.setData(metaData);
                this.eMw.setShowV(this.eMy);
                this.mRootView.setOnClickListener(this.eMJ);
            } else if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().pI())) {
                this.eMw.setVisibility(8);
                this.eMx.setVisibility(0);
                this.eMx.setData(metaData);
                UtilHelper.showHeadImageViewBigV(this.eMx.getHeadView(), metaData);
                this.mRootView.setOnClickListener(this.eMJ);
            }
            String string = metaData.getName_show() == null ? StringUtils.string(metaData.getUserName()) : StringUtils.string(metaData.getName_show());
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.j.aK(metaData.getSealPrefix()) + 2 : 0) > 0) {
                if (com.baidu.adp.lib.util.j.aK(string) > 12) {
                    string = aw.d(string, 12, "...");
                }
            } else if (com.baidu.adp.lib.util.j.aK(string) > 14) {
                string = aw.d(string, 14, "...");
            }
            this.eCh.setText(gf.i(getContext(), metaData.getSealPrefix(), string));
            if (metaData != null && !TextUtils.isEmpty(metaData.getGodIntro())) {
                this.eCi.setVisibility(0);
                this.eCi.setText(gf.a(metaData));
            } else {
                this.eCi.setVisibility(8);
            }
            if (metaData != null && metaData.getFansNum() > 0) {
                this.eMA.setText(aw.v(metaData.getFansNum()));
            } else {
                this.eMA.setText("0");
            }
            if (metaData != null && metaData.getLikeNum() > 0) {
                this.eMB.setText(aw.v(metaData.getLikeNum()));
            } else {
                this.eMB.setText("0");
            }
            if (metaData != null && metaData.getThreadNum() > 0) {
                this.eMC.setText(aw.v(metaData.getThreadNum()));
            } else {
                this.eMC.setText("1");
            }
            GodUserData godUserData = metaData.getGodUserData();
            if (godUserData == null || !jVar.esb) {
                this.eCu.setVisibility(8);
            } else if (godUserData.getIsLike() && godUserData.getIsFromNetWork()) {
                this.eCu.setVisibility(8);
            } else {
                this.eCu.setVisibility(0);
                this.eCu.setTextSize(0, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds24));
                this.eCv.a(metaData);
                this.eCu.aP(metaData.getGodUserData().getIsLike());
                as.j(this.eCu, w.g.btn_recomend_card_rounded_corner_blue_frame);
            }
            if (jVar.esa) {
                this.cKW.setVisibility(0);
            } else {
                this.cKW.setVisibility(8);
            }
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        as.k(this, w.e.cp_bg_line_d);
        as.k(this.cKW, w.e.cp_bg_line_c);
        as.j(this.eMz, w.g.bg_gray_border_shape_selector);
        as.i(this.eMA, w.e.cp_cont_b);
        as.i(this.eMB, w.e.cp_cont_b);
        as.i(this.eMC, w.e.cp_cont_b);
        as.i(this.eMD, w.e.cp_cont_f);
        as.i(this.eME, w.e.cp_cont_f);
        as.i(this.eMF, w.e.cp_cont_f);
        as.k(this.eMG, w.e.cp_bg_line_c);
        as.k(this.eMH, w.e.cp_bg_line_c);
        as.k(this.eMI, w.e.cp_bg_line_c);
        as.i(this.eCi, w.e.cp_cont_f);
        if (this.eMy) {
            as.i(this.eCh, w.e.cp_cont_r);
        } else {
            as.i(this.eCh, w.e.cp_cont_f);
        }
        if (this.eCu != null) {
            this.eCu.onChangeSkinType(i);
        }
    }
}
