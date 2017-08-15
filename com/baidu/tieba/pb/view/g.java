package com.baidu.tieba.pb.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.ao;
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.pb.pb.main.view.PbFirstFloorUserLikeButton;
/* loaded from: classes.dex */
public class g extends FrameLayout {
    private View cWS;
    private PbFirstFloorUserLikeButton eQI;
    private ao eQJ;
    private TextView eQv;
    private TextView eQw;
    private View fcb;
    private ClickableHeaderImageView fcc;
    private HeadPendantClickableView fcd;
    private boolean fce;
    private LinearLayout fcf;
    private TextView fcg;
    private TextView fch;
    private TextView fci;
    private TextView fcj;
    private TextView fck;
    private TextView fcl;
    private View fcm;
    private View fcn;
    private View fco;
    private View.OnClickListener fcp;
    private View mRootView;
    private TbPageContext<?> oV;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.fcp = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.fcc.getVisibility() == 0) {
                    g.this.fcc.mOnClickListener.onClick(view);
                } else {
                    g.this.fcd.mOnClickListener.onClick(view);
                }
                TiebaStatic.log(new aj("c12151").r("obj_locate", 2));
            }
        };
        this.oV = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(d.j.new_pb_header_user_item_simple, (ViewGroup) this, true);
        this.fcd = (HeadPendantClickableView) this.mRootView.findViewById(d.h.pb_pendant_head_owner_photo);
        this.fcc = (ClickableHeaderImageView) this.mRootView.findViewById(d.h.pb_head_owner_photo);
        this.eQI = (PbFirstFloorUserLikeButton) this.mRootView.findViewById(d.h.pb_like_button);
        this.eQw = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_user_intro);
        this.eQv = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_user_name);
        this.fcf = (LinearLayout) this.mRootView.findViewById(d.h.pb_head_user_info_content);
        this.fcg = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_fan_number);
        this.fch = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_zan_number);
        this.fci = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_thread_number);
        this.fcj = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_fan_number_string);
        this.fck = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_zan_number_string);
        this.fcl = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_thread_number_string);
        this.fcb = this.mRootView.findViewById(d.h.pb_head_owner_root);
        this.cWS = this.mRootView.findViewById(d.h.bottom_divider_line);
        this.fcm = this.mRootView.findViewById(d.h.middle_divider_line);
        this.fcn = this.mRootView.findViewById(d.h.left_vertical_divider_line);
        this.fco = this.mRootView.findViewById(d.h.middle_vertical_divider_line);
        this.fcd.wD();
        if (this.fcd.getHeadView() != null) {
            this.fcd.getHeadView().setIsRound(true);
            this.fcd.getHeadView().setDrawBorder(false);
        }
        if (this.fcd.getPendantView() != null) {
            this.fcd.getPendantView().setIsRound(true);
            this.fcd.getPendantView().setDrawBorder(false);
        }
        this.fcc.setDefaultResource(17170445);
        this.fcc.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.fcc.setDefaultBgResource(d.e.cp_bg_line_e);
        this.fcc.setIsRound(true);
        this.eQJ = new ao(this.oV, this.eQI, 2);
    }

    public void setData(com.baidu.tieba.pb.data.j jVar) {
        if (jVar != null && jVar.eGp != null) {
            MetaData metaData = jVar.eGp;
            this.fce = metaData.isBigV();
            if (this.eQJ != null) {
                this.eQJ.isBigV = this.fce;
            }
            if (this.fce) {
                this.fcc.setVisibility(0);
                this.fcd.setVisibility(8);
                this.fcc.setData(metaData);
                this.fcc.setShowV(this.fce);
                this.mRootView.setOnClickListener(this.fcp);
            } else if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().pV())) {
                this.fcc.setVisibility(8);
                this.fcd.setVisibility(0);
                this.fcd.setData(metaData);
                UtilHelper.showHeadImageViewBigV(this.fcd.getHeadView(), metaData);
                this.mRootView.setOnClickListener(this.fcp);
            }
            String string = metaData.getName_show() == null ? StringUtils.string(metaData.getUserName()) : StringUtils.string(metaData.getName_show());
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.j.aS(metaData.getSealPrefix()) + 2 : 0) > 0) {
                if (com.baidu.adp.lib.util.j.aS(string) > 12) {
                    string = al.d(string, 12, "...");
                }
            } else if (com.baidu.adp.lib.util.j.aS(string) > 14) {
                string = al.d(string, 14, "...");
            }
            this.eQv.setText(ap.i(getContext(), metaData.getSealPrefix(), string));
            if (metaData != null && !TextUtils.isEmpty(metaData.getGodIntro())) {
                this.eQw.setVisibility(0);
                this.eQw.setText(ap.a(metaData));
            } else {
                this.eQw.setVisibility(8);
            }
            if (metaData != null && metaData.getFansNum() > 0) {
                this.fcg.setText(al.w(metaData.getFansNum()));
            } else {
                this.fcg.setText("0");
            }
            if (metaData != null && metaData.getLikeNum() > 0) {
                this.fch.setText(al.w(metaData.getLikeNum()));
            } else {
                this.fch.setText("0");
            }
            if (metaData != null && metaData.getThreadNum() > 0) {
                this.fci.setText(al.w(metaData.getThreadNum()));
            } else {
                this.fci.setText("1");
            }
            GodUserData godUserData = metaData.getGodUserData();
            if (godUserData == null || !jVar.eGr) {
                this.eQI.setVisibility(8);
            } else if (godUserData.getIsLike() && godUserData.getIsFromNetWork()) {
                this.eQI.setVisibility(8);
            } else {
                this.eQI.setVisibility(0);
                this.eQI.setTextSize(0, k.g(getContext(), d.f.ds24));
                this.eQJ.a(metaData);
                this.eQI.aQ(metaData.getGodUserData().getIsLike());
                ai.j(this.eQI, d.g.btn_recomend_card_rounded_corner_blue_frame);
            }
            if (jVar.eGq) {
                this.cWS.setVisibility(0);
            } else {
                this.cWS.setVisibility(8);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        ai.k(this, d.e.cp_bg_line_d);
        ai.k(this.cWS, d.e.cp_bg_line_c);
        ai.j(this.fcf, d.g.bg_gray_border_shape_selector);
        ai.i(this.fcg, d.e.cp_cont_b);
        ai.i(this.fch, d.e.cp_cont_b);
        ai.i(this.fci, d.e.cp_cont_b);
        ai.i(this.fcj, d.e.cp_cont_f);
        ai.i(this.fck, d.e.cp_cont_f);
        ai.i(this.fcl, d.e.cp_cont_f);
        ai.k(this.fcm, d.e.cp_bg_line_c);
        ai.k(this.fcn, d.e.cp_bg_line_c);
        ai.k(this.fco, d.e.cp_bg_line_c);
        ai.i(this.eQw, d.e.cp_cont_f);
        if (this.fce) {
            ai.i(this.eQv, d.e.cp_cont_r);
        } else {
            ai.i(this.eQv, d.e.cp_cont_f);
        }
        if (this.eQI != null) {
            this.eQI.onChangeSkinType(i);
        }
    }
}
