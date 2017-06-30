package com.baidu.tieba.write.write;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class cq {
    private View Qr;
    private com.baidu.tbadk.core.view.a aJN;
    private View.OnClickListener bkk;
    private TbImageView dEP;
    private View dyF;
    private RelativeLayout eJR;
    private WriteUrlActivity gmJ;
    private TextView gmK;
    private TbImageView gmL;
    private EditText gmM;
    private View gmN;
    private LinearLayout gmO;
    private ImageView gmP;
    private View gmQ;
    private TextView gmR;
    private TextView gmS;
    private View gmT;
    private TextView gmU;
    private TextView gmV;
    private LinearLayout gmW;
    private EditText gmX;
    private View gmY;
    private TextView gmZ;
    private FrameLayout gna;
    private TextView gnb;
    private NavigationBar mNavigationBar;

    public cq(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.dyF = null;
        this.aJN = null;
        if (writeUrlActivity != null) {
            this.gmJ = writeUrlActivity;
            this.bkk = onClickListener;
            this.Qr = LayoutInflater.from(this.gmJ.getPageContext().getPageActivity()).inflate(w.j.write_url_activity_layout, (ViewGroup) null);
            this.gmJ.setContentView(this.Qr);
            this.mNavigationBar = (NavigationBar) this.Qr.findViewById(w.h.view_navigation_bar);
            this.dyF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.bkk);
            this.mNavigationBar.setmBackImageViewBg(w.g.write_close_selector, w.g.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dyF.getLayoutParams();
                layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.gmJ.getActivity(), w.f.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.dyF != null && (this.dyF.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dyF.getLayoutParams();
                layoutParams2.width = -2;
                this.dyF.setLayoutParams(layoutParams2);
            }
            this.Qr.setOnClickListener(this.bkk);
            this.gmK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(w.l.send_post));
            com.baidu.tbadk.core.util.as.c(this.gmK, w.e.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.gmK.getLayoutParams();
            layoutParams3.rightMargin = com.baidu.adp.lib.util.k.g(this.gmJ.getActivity(), w.f.ds16);
            this.gmK.setLayoutParams(layoutParams3);
            this.gmK.setOnClickListener(this.bkk);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(w.l.post_new_thread));
            this.gmL = (TbImageView) this.Qr.findViewById(w.h.imageview_picture);
            this.gmL.setDefaultResource(w.g.ic_post_url_n);
            this.gmL.setDefaultErrorResource(w.g.ic_post_url_n);
            this.gmL.setDefaultBgResource(w.e.black_alpha0);
            this.gmO = (LinearLayout) this.Qr.findViewById(w.h.view_picture_publish);
            this.gmO.setOnClickListener(this.bkk);
            this.eJR = (RelativeLayout) this.Qr.findViewById(w.h.video_container);
            this.eJR.setOnClickListener(this.bkk);
            this.dEP = (TbImageView) this.Qr.findViewById(w.h.video_img_thumbnail);
            this.dEP.setDefaultErrorResource(0);
            this.dEP.setDefaultBgResource(w.g.pic_bg_video_frs);
            this.dEP.setDefaultBgResource(w.e.black_alpha0);
            this.gmP = (ImageView) this.Qr.findViewById(w.h.video_img_play);
            this.gmQ = this.Qr.findViewById(w.h.video_view_delete);
            this.gmQ.setOnClickListener(this.bkk);
            this.gmR = (TextView) this.Qr.findViewById(w.h.textview_title);
            this.gmS = (TextView) this.Qr.findViewById(w.h.textview_abstract);
            this.gmT = this.Qr.findViewById(w.h.view_delete);
            this.gmT.setOnClickListener(this.bkk);
            this.gmN = this.Qr.findViewById(w.h.icon_invoke_link);
            this.gmN.setOnClickListener(this.bkk);
            this.gmM = (EditText) this.Qr.findViewById(w.h.post_content);
            this.gmM.addTextChangedListener(new cr(this));
            this.gmU = (TextView) this.Qr.findViewById(w.h.textview_error_tip);
            this.gmV = (TextView) this.Qr.findViewById(w.h.textview_url);
            this.gmW = (LinearLayout) this.Qr.findViewById(w.h.url_edit_container);
            this.gmX = (EditText) this.Qr.findViewById(w.h.url_input);
            this.gnb = (TextView) this.Qr.findViewById(w.h.url_desc);
            this.gmY = this.Qr.findViewById(w.h.url_input_clear);
            this.gmZ = (TextView) this.Qr.findViewById(w.h.url_add);
            this.gmZ.setEnabled(false);
            this.gna = (FrameLayout) this.Qr.findViewById(w.h.url_edit_back_view);
            this.gmX.addTextChangedListener(new cs(this));
            this.gmY.setOnClickListener(new ct(this));
            this.aJN = new com.baidu.tbadk.core.view.a(this.gmJ.getPageContext());
            buR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buR() {
        if (StringUtils.isNull(TbadkCoreApplication.m9getInst().getUrlText())) {
            this.gnb.setText(w.l.tip_url_post);
        } else {
            this.gnb.setText(TbadkCoreApplication.m9getInst().getUrlText());
        }
        com.baidu.tbadk.core.util.as.i(this.gnb, w.e.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.gmJ.setIsLoading(z);
        if (z) {
            this.gmO.setVisibility(0);
            this.eJR.setVisibility(8);
            this.gmL.c(null, 10, false);
            this.gmR.setVisibility(8);
            this.gmS.setVisibility(8);
            this.gmU.setVisibility(8);
            this.gmV.setVisibility(0);
            com.baidu.tbadk.core.util.as.i(this.gmV, w.e.cp_cont_f);
            this.gmV.setText(w.l.tip_url_loading);
        } else if (aVar == null) {
            this.gmO.setVisibility(8);
            this.eJR.setVisibility(8);
            buS();
        } else {
            if (aVar.ggH == 1) {
                this.gmO.setVisibility(0);
                this.eJR.setVisibility(8);
                if (aVar.ggG) {
                    this.gmL.c(aVar.ggJ, 10, false);
                    this.gmR.setText(aVar.VU);
                    this.gmS.setText(aVar.VV);
                    if (com.baidu.tbadk.core.util.aw.dQ(aVar.VU) > 30) {
                        this.gmR.setMaxLines(2);
                        this.gmS.setMaxLines(1);
                    } else {
                        this.gmR.setMaxLines(1);
                        this.gmS.setMaxLines(2);
                    }
                    this.gmR.setVisibility(0);
                    this.gmS.setVisibility(0);
                    this.gmV.setVisibility(8);
                    this.gmU.setVisibility(8);
                } else {
                    this.gmL.reset();
                    this.gmV.setText(aVar.linkUrl);
                    com.baidu.tbadk.core.util.as.i(this.gmV, w.e.cp_cont_b);
                    this.gmR.setVisibility(8);
                    this.gmS.setVisibility(8);
                    this.gmV.setVisibility(0);
                    this.gmU.setVisibility(0);
                }
            } else if (aVar.ggH == 2) {
                this.gmO.setVisibility(8);
                this.eJR.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.eJR.getLayoutParams();
                layoutParams.height = ((com.baidu.adp.lib.util.k.af(this.gmJ.getPageContext().getPageActivity()) - ((int) this.gmJ.getPageContext().getPageActivity().getResources().getDimension(w.f.ds80))) * 9) / 16;
                this.eJR.setLayoutParams(layoutParams);
                com.baidu.tbadk.core.util.as.c(this.gmP, w.g.icon_play_video);
                com.baidu.tbadk.core.util.as.j(this.gmQ, w.g.btn_delete_url);
                this.dEP.c(aVar.ggN, 10, false);
            } else {
                this.gmO.setVisibility(0);
                this.eJR.setVisibility(8);
                this.gmR.setVisibility(8);
                this.gmS.setVisibility(8);
                this.gmV.setVisibility(0);
                this.gmU.setVisibility(0);
                this.gmL.reset();
                this.gmV.setText(aVar.linkUrl);
                com.baidu.tbadk.core.util.as.i(this.gmV, w.e.cp_cont_b);
            }
            buS();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gmJ != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.gmJ.getPageContext(), i);
            }
            com.baidu.tbadk.core.util.as.k(this.mNavigationBar, w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.as.k(this.Qr, w.e.cp_bg_line_d);
            this.gmM.setHintTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_e));
            this.gmM.setTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_f));
            com.baidu.tbadk.core.util.as.k(this.gmO, w.e.cp_bg_line_e);
            com.baidu.tbadk.core.util.as.i(this.gmR, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.as.i(this.gmS, w.e.cp_cont_d);
            com.baidu.tbadk.core.util.as.i(this.gmV, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.as.k(this.gmU, w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.as.i(this.gmU, w.e.cp_cont_d);
            com.baidu.tbadk.core.util.as.j(this.gmN, w.g.bg_link_invoke);
            com.baidu.tbadk.core.util.as.k(this.gmW, w.e.cp_bg_line_d);
            this.gmX.setHintTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_e));
            com.baidu.tbadk.core.util.as.i(this.gmX, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.as.i(this.gnb, w.e.cp_cont_d);
            com.baidu.tbadk.core.util.as.i(this.gmZ, w.e.cp_cont_e);
            com.baidu.tbadk.core.util.as.c(this.gmP, w.g.home_ic_video);
            com.baidu.tbadk.core.util.as.j(this.gmT, w.g.btn_delete_url);
            com.baidu.tbadk.core.util.as.j(this.gmY, w.g.btn_delete_url);
            com.baidu.tbadk.core.util.as.j(this.gmQ, w.g.btn_delete_url);
            buS();
        }
    }

    public void buS() {
        boolean z;
        if (StringUtils.isNull(buT())) {
            z = this.gmO.getVisibility() == 0 || this.eJR.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            com.baidu.tbadk.core.util.as.b(this.gmK, w.e.cp_link_tip_a, w.e.s_navbar_title_color);
            this.gmK.setEnabled(true);
            return;
        }
        com.baidu.tbadk.core.util.as.c(this.gmK, w.e.cp_cont_d, 1);
        this.gmK.setEnabled(false);
    }

    public String buT() {
        if (this.gmM == null || this.gmM.getText() == null) {
            return null;
        }
        return this.gmM.getText().toString();
    }

    public View Vo() {
        return this.dyF;
    }

    public View buU() {
        return this.gmK;
    }

    public View getRootView() {
        return this.Qr;
    }

    public View buV() {
        return this.gmM;
    }

    public View buW() {
        return this.gmT;
    }

    public View buX() {
        return this.gmQ;
    }

    public View buY() {
        return this.gmO;
    }

    public View getVideoContainer() {
        return this.eJR;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.gmX.setText(aVar.linkUrl);
            this.gmX.setSelection(aVar.linkUrl.length());
        }
        this.gmX.requestFocus();
        com.baidu.adp.lib.util.k.c(this.gmJ.getActivity(), this.gmX);
        this.gmW.setVisibility(0);
        this.gna.setVisibility(0);
        this.gmN.setVisibility(8);
    }

    public void buZ() {
        this.gmW.setVisibility(8);
        this.gna.setVisibility(8);
        this.gmN.setVisibility(0);
        com.baidu.adp.lib.util.k.b(this.gmJ.getActivity(), this.gmX);
    }

    public void Z(View.OnClickListener onClickListener) {
        this.gmW.setOnClickListener(onClickListener);
        this.gna.setOnClickListener(onClickListener);
        this.gmN.setOnClickListener(onClickListener);
    }

    public String bva() {
        if (this.gmX == null || this.gmX.getText() == null) {
            return null;
        }
        return this.gmX.getText().toString();
    }

    public void bvb() {
        if (this.gnb != null) {
            this.gnb.setText(w.l.tip_url_not_match);
            com.baidu.tbadk.core.util.as.i(this.gnb, w.e.cp_other_b);
        }
    }

    public void aa(View.OnClickListener onClickListener) {
        if (this.gmZ != null) {
            this.gmZ.setOnClickListener(onClickListener);
        }
    }

    public View bvc() {
        return this.gmW;
    }

    public void destroy() {
        if (this.gmM != null) {
            this.gmM.addTextChangedListener(null);
        }
        if (this.gmX != null) {
            this.gmX.addTextChangedListener(null);
        }
    }

    public void d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.sK(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ar(this.gmJ.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.gmJ.getPageContext().getPageActivity().getString(w.l.error_write);
                }
                this.gmJ.showToast(errorString);
            }
        }
    }

    public void Qx() {
        this.aJN.c(null);
        this.aJN.cY(w.l.sending);
        this.aJN.aI(true);
    }

    public void closeLoadingDialog() {
        this.aJN.aI(false);
    }
}
