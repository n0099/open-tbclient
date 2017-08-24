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
    private PbFirstFloorUserLikeButton eQK;
    private ao eQL;
    private TextView eQx;
    private TextView eQy;
    private View fcd;
    private ClickableHeaderImageView fce;
    private HeadPendantClickableView fcf;
    private boolean fcg;
    private LinearLayout fch;
    private TextView fci;
    private TextView fcj;
    private TextView fck;
    private TextView fcl;
    private TextView fcm;
    private TextView fcn;
    private View fco;
    private View fcp;
    private View fcq;
    private View.OnClickListener fcr;
    private View mRootView;
    private TbPageContext<?> oW;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.fcr = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.fce.getVisibility() == 0) {
                    g.this.fce.mOnClickListener.onClick(view);
                } else {
                    g.this.fcf.mOnClickListener.onClick(view);
                }
                TiebaStatic.log(new aj("c12151").r("obj_locate", 2));
            }
        };
        this.oW = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(d.j.new_pb_header_user_item_simple, (ViewGroup) this, true);
        this.fcf = (HeadPendantClickableView) this.mRootView.findViewById(d.h.pb_pendant_head_owner_photo);
        this.fce = (ClickableHeaderImageView) this.mRootView.findViewById(d.h.pb_head_owner_photo);
        this.eQK = (PbFirstFloorUserLikeButton) this.mRootView.findViewById(d.h.pb_like_button);
        this.eQy = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_user_intro);
        this.eQx = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_user_name);
        this.fch = (LinearLayout) this.mRootView.findViewById(d.h.pb_head_user_info_content);
        this.fci = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_fan_number);
        this.fcj = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_zan_number);
        this.fck = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_thread_number);
        this.fcl = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_fan_number_string);
        this.fcm = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_zan_number_string);
        this.fcn = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_thread_number_string);
        this.fcd = this.mRootView.findViewById(d.h.pb_head_owner_root);
        this.cWS = this.mRootView.findViewById(d.h.bottom_divider_line);
        this.fco = this.mRootView.findViewById(d.h.middle_divider_line);
        this.fcp = this.mRootView.findViewById(d.h.left_vertical_divider_line);
        this.fcq = this.mRootView.findViewById(d.h.middle_vertical_divider_line);
        this.fcf.wE();
        if (this.fcf.getHeadView() != null) {
            this.fcf.getHeadView().setIsRound(true);
            this.fcf.getHeadView().setDrawBorder(false);
        }
        if (this.fcf.getPendantView() != null) {
            this.fcf.getPendantView().setIsRound(true);
            this.fcf.getPendantView().setDrawBorder(false);
        }
        this.fce.setDefaultResource(17170445);
        this.fce.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.fce.setDefaultBgResource(d.e.cp_bg_line_e);
        this.fce.setIsRound(true);
        this.eQL = new ao(this.oW, this.eQK, 2);
    }

    public void setData(com.baidu.tieba.pb.data.j jVar) {
        if (jVar != null && jVar.eGr != null) {
            MetaData metaData = jVar.eGr;
            this.fcg = metaData.isBigV();
            if (this.eQL != null) {
                this.eQL.isBigV = this.fcg;
            }
            if (this.fcg) {
                this.fce.setVisibility(0);
                this.fcf.setVisibility(8);
                this.fce.setData(metaData);
                this.fce.setShowV(this.fcg);
                this.mRootView.setOnClickListener(this.fcr);
            } else if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().pW())) {
                this.fce.setVisibility(8);
                this.fcf.setVisibility(0);
                this.fcf.setData(metaData);
                UtilHelper.showHeadImageViewBigV(this.fcf.getHeadView(), metaData);
                this.mRootView.setOnClickListener(this.fcr);
            }
            String string = metaData.getName_show() == null ? StringUtils.string(metaData.getUserName()) : StringUtils.string(metaData.getName_show());
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.j.aT(metaData.getSealPrefix()) + 2 : 0) > 0) {
                if (com.baidu.adp.lib.util.j.aT(string) > 12) {
                    string = al.e(string, 12, "...");
                }
            } else if (com.baidu.adp.lib.util.j.aT(string) > 14) {
                string = al.e(string, 14, "...");
            }
            this.eQx.setText(ap.i(getContext(), metaData.getSealPrefix(), string));
            if (metaData != null && !TextUtils.isEmpty(metaData.getGodIntro())) {
                this.eQy.setVisibility(0);
                this.eQy.setText(ap.a(metaData));
            } else {
                this.eQy.setVisibility(8);
            }
            if (metaData != null && metaData.getFansNum() > 0) {
                this.fci.setText(al.w(metaData.getFansNum()));
            } else {
                this.fci.setText("0");
            }
            if (metaData != null && metaData.getLikeNum() > 0) {
                this.fcj.setText(al.w(metaData.getLikeNum()));
            } else {
                this.fcj.setText("0");
            }
            if (metaData != null && metaData.getThreadNum() > 0) {
                this.fck.setText(al.w(metaData.getThreadNum()));
            } else {
                this.fck.setText("1");
            }
            GodUserData godUserData = metaData.getGodUserData();
            if (godUserData == null || !jVar.eGt) {
                this.eQK.setVisibility(8);
            } else if (godUserData.getIsLike() && godUserData.getIsFromNetWork()) {
                this.eQK.setVisibility(8);
            } else {
                this.eQK.setVisibility(0);
                this.eQK.setTextSize(0, k.g(getContext(), d.f.ds24));
                this.eQL.a(metaData);
                this.eQK.aQ(metaData.getGodUserData().getIsLike());
                ai.j(this.eQK, d.g.btn_recomend_card_rounded_corner_blue_frame);
            }
            if (jVar.eGs) {
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
        ai.j(this.fch, d.g.bg_gray_border_shape_selector);
        ai.i(this.fci, d.e.cp_cont_b);
        ai.i(this.fcj, d.e.cp_cont_b);
        ai.i(this.fck, d.e.cp_cont_b);
        ai.i(this.fcl, d.e.cp_cont_f);
        ai.i(this.fcm, d.e.cp_cont_f);
        ai.i(this.fcn, d.e.cp_cont_f);
        ai.k(this.fco, d.e.cp_bg_line_c);
        ai.k(this.fcp, d.e.cp_bg_line_c);
        ai.k(this.fcq, d.e.cp_bg_line_c);
        ai.i(this.eQy, d.e.cp_cont_f);
        if (this.fcg) {
            ai.i(this.eQx, d.e.cp_cont_r);
        } else {
            ai.i(this.eQx, d.e.cp_cont_f);
        }
        if (this.eQK != null) {
            this.eQK.onChangeSkinType(i);
        }
    }
}
