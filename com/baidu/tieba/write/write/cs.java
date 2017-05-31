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
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class cs {
    private View Qx;
    private com.baidu.tbadk.core.view.a aIy;
    private View.OnClickListener bhc;
    private TbImageView dwc;
    private RelativeLayout eAt;
    private View eWQ;
    private WriteUrlActivity gbL;
    private TextView gbM;
    private TbImageView gbN;
    private EditText gbO;
    private View gbP;
    private LinearLayout gbQ;
    private ImageView gbR;
    private View gbS;
    private TextView gbT;
    private TextView gbU;
    private View gbV;
    private TextView gbW;
    private TextView gbX;
    private LinearLayout gbY;
    private EditText gbZ;
    private View gca;
    private TextView gcb;
    private FrameLayout gcc;
    private TextView gcd;
    private NavigationBar mNavigationBar;

    public cs(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.eWQ = null;
        this.aIy = null;
        if (writeUrlActivity != null) {
            this.gbL = writeUrlActivity;
            this.bhc = onClickListener;
            this.Qx = LayoutInflater.from(this.gbL.getPageContext().getPageActivity()).inflate(w.j.write_url_activity_layout, (ViewGroup) null);
            this.gbL.setContentView(this.Qx);
            this.mNavigationBar = (NavigationBar) this.Qx.findViewById(w.h.view_navigation_bar);
            this.eWQ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.bhc);
            this.mNavigationBar.setmBackImageViewBg(w.g.write_close_selector, w.g.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eWQ.getLayoutParams();
                layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.gbL.getActivity(), w.f.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.eWQ != null && (this.eWQ.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eWQ.getLayoutParams();
                layoutParams2.width = -2;
                this.eWQ.setLayoutParams(layoutParams2);
            }
            this.Qx.setOnClickListener(this.bhc);
            this.gbM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(w.l.send_post));
            com.baidu.tbadk.core.util.aq.c(this.gbM, w.e.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.gbM.getLayoutParams();
            layoutParams3.rightMargin = com.baidu.adp.lib.util.k.g(this.gbL.getActivity(), w.f.ds16);
            this.gbM.setLayoutParams(layoutParams3);
            this.gbM.setOnClickListener(this.bhc);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(w.l.post_new_thread));
            this.gbN = (TbImageView) this.Qx.findViewById(w.h.imageview_picture);
            this.gbN.setDefaultResource(w.g.ic_post_url_n);
            this.gbN.setDefaultErrorResource(w.g.ic_post_url_n);
            this.gbN.setDefaultBgResource(w.e.black_alpha0);
            this.gbQ = (LinearLayout) this.Qx.findViewById(w.h.view_picture_publish);
            this.gbQ.setOnClickListener(this.bhc);
            this.eAt = (RelativeLayout) this.Qx.findViewById(w.h.video_container);
            this.eAt.setOnClickListener(this.bhc);
            this.dwc = (TbImageView) this.Qx.findViewById(w.h.video_img_thumbnail);
            this.dwc.setDefaultErrorResource(0);
            this.dwc.setDefaultBgResource(w.g.pic_bg_video_frs);
            this.dwc.setDefaultBgResource(w.e.black_alpha0);
            this.gbR = (ImageView) this.Qx.findViewById(w.h.video_img_play);
            this.gbS = this.Qx.findViewById(w.h.video_view_delete);
            this.gbS.setOnClickListener(this.bhc);
            this.gbT = (TextView) this.Qx.findViewById(w.h.textview_title);
            this.gbU = (TextView) this.Qx.findViewById(w.h.textview_abstract);
            this.gbV = this.Qx.findViewById(w.h.view_delete);
            this.gbV.setOnClickListener(this.bhc);
            this.gbP = this.Qx.findViewById(w.h.icon_invoke_link);
            this.gbP.setOnClickListener(this.bhc);
            this.gbO = (EditText) this.Qx.findViewById(w.h.post_content);
            this.gbO.addTextChangedListener(new ct(this));
            this.gbW = (TextView) this.Qx.findViewById(w.h.textview_error_tip);
            this.gbX = (TextView) this.Qx.findViewById(w.h.textview_url);
            this.gbY = (LinearLayout) this.Qx.findViewById(w.h.url_edit_container);
            this.gbZ = (EditText) this.Qx.findViewById(w.h.url_input);
            this.gcd = (TextView) this.Qx.findViewById(w.h.url_desc);
            this.gca = this.Qx.findViewById(w.h.url_input_clear);
            this.gcb = (TextView) this.Qx.findViewById(w.h.url_add);
            this.gcb.setEnabled(false);
            this.gcc = (FrameLayout) this.Qx.findViewById(w.h.url_edit_back_view);
            this.gbZ.addTextChangedListener(new cu(this));
            this.gca.setOnClickListener(new cv(this));
            this.aIy = new com.baidu.tbadk.core.view.a(this.gbL.getPageContext());
        }
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.gbL.setIsLoading(z);
        if (z) {
            this.gbQ.setVisibility(0);
            this.eAt.setVisibility(8);
            this.gbN.c(null, 10, false);
            this.gbT.setVisibility(8);
            this.gbU.setVisibility(8);
            this.gbW.setVisibility(8);
            this.gbX.setVisibility(0);
            com.baidu.tbadk.core.util.aq.i(this.gbX, w.e.cp_cont_f);
            this.gbX.setText(w.l.tip_url_loading);
        } else if (aVar == null) {
            this.gbQ.setVisibility(8);
            this.eAt.setVisibility(8);
            bqr();
        } else {
            if (aVar.fVW == 1) {
                this.gbQ.setVisibility(0);
                this.eAt.setVisibility(8);
                if (aVar.fVV) {
                    this.gbN.c(aVar.fVY, 10, false);
                    this.gbT.setText(aVar.VU);
                    this.gbU.setText(aVar.VV);
                    if (com.baidu.tbadk.core.util.au.dw(aVar.VU) > 30) {
                        this.gbT.setMaxLines(2);
                        this.gbU.setMaxLines(1);
                    } else {
                        this.gbT.setMaxLines(1);
                        this.gbU.setMaxLines(2);
                    }
                    this.gbT.setVisibility(0);
                    this.gbU.setVisibility(0);
                    this.gbX.setVisibility(8);
                    this.gbW.setVisibility(8);
                } else {
                    this.gbN.reset();
                    this.gbX.setText(aVar.linkUrl);
                    com.baidu.tbadk.core.util.aq.i(this.gbX, w.e.cp_cont_b);
                    this.gbT.setVisibility(8);
                    this.gbU.setVisibility(8);
                    this.gbX.setVisibility(0);
                    this.gbW.setVisibility(0);
                }
            } else if (aVar.fVW == 2) {
                this.gbQ.setVisibility(8);
                this.eAt.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.eAt.getLayoutParams();
                layoutParams.height = ((com.baidu.adp.lib.util.k.af(this.gbL.getPageContext().getPageActivity()) - ((int) this.gbL.getPageContext().getPageActivity().getResources().getDimension(w.f.ds80))) * 9) / 16;
                this.eAt.setLayoutParams(layoutParams);
                com.baidu.tbadk.core.util.aq.c(this.gbR, w.g.icon_play_video);
                com.baidu.tbadk.core.util.aq.j(this.gbS, w.g.btn_delete_url);
                this.dwc.c(aVar.fWc, 10, false);
            } else {
                this.gbQ.setVisibility(0);
                this.eAt.setVisibility(8);
                this.gbT.setVisibility(8);
                this.gbU.setVisibility(8);
                this.gbX.setVisibility(0);
                this.gbW.setVisibility(0);
                this.gbN.reset();
                this.gbX.setText(aVar.linkUrl);
                com.baidu.tbadk.core.util.aq.i(this.gbX, w.e.cp_cont_b);
            }
            bqr();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gbL != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.gbL.getPageContext(), i);
            }
            com.baidu.tbadk.core.util.aq.k(this.mNavigationBar, w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.k(this.Qx, w.e.cp_bg_line_d);
            this.gbO.setHintTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_e));
            this.gbO.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_f));
            com.baidu.tbadk.core.util.aq.k(this.gbQ, w.e.cp_bg_line_e);
            com.baidu.tbadk.core.util.aq.i(this.gbT, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.aq.i(this.gbU, w.e.cp_cont_d);
            com.baidu.tbadk.core.util.aq.i(this.gbX, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.aq.k(this.gbW, w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.i(this.gbW, w.e.cp_cont_d);
            com.baidu.tbadk.core.util.aq.j(this.gbP, w.g.bg_link_invoke);
            com.baidu.tbadk.core.util.aq.k(this.gbY, w.e.cp_bg_line_d);
            this.gbZ.setHintTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_e));
            com.baidu.tbadk.core.util.aq.i(this.gbZ, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.aq.i(this.gcd, w.e.cp_cont_d);
            com.baidu.tbadk.core.util.aq.i(this.gcb, w.e.cp_cont_e);
            com.baidu.tbadk.core.util.aq.c(this.gbR, w.g.home_ic_video);
            com.baidu.tbadk.core.util.aq.j(this.gbV, w.g.btn_delete_url);
            com.baidu.tbadk.core.util.aq.j(this.gca, w.g.btn_delete_url);
            com.baidu.tbadk.core.util.aq.j(this.gbS, w.g.btn_delete_url);
            bqr();
        }
    }

    public void bqr() {
        boolean z;
        if (StringUtils.isNull(bqs())) {
            z = this.gbQ.getVisibility() == 0 || this.eAt.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            com.baidu.tbadk.core.util.aq.b(this.gbM, w.e.cp_link_tip_a, w.e.s_navbar_title_color);
            this.gbM.setEnabled(true);
            return;
        }
        com.baidu.tbadk.core.util.aq.c(this.gbM, w.e.cp_cont_d, 1);
        this.gbM.setEnabled(false);
    }

    public String bqs() {
        if (this.gbO == null || this.gbO.getText() == null) {
            return null;
        }
        return this.gbO.getText().toString();
    }

    public View TZ() {
        return this.eWQ;
    }

    public View bqt() {
        return this.gbM;
    }

    public View getRootView() {
        return this.Qx;
    }

    public View bqu() {
        return this.gbO;
    }

    public View bqv() {
        return this.gbV;
    }

    public View bqw() {
        return this.gbS;
    }

    public View bqx() {
        return this.gbQ;
    }

    public View getVideoContainer() {
        return this.eAt;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.gbZ.setText(aVar.linkUrl);
            this.gbZ.setSelection(aVar.linkUrl.length());
        }
        this.gbZ.requestFocus();
        com.baidu.adp.lib.util.k.c(this.gbL.getActivity(), this.gbZ);
        this.gbY.setVisibility(0);
        this.gcc.setVisibility(0);
        this.gbP.setVisibility(8);
    }

    public void bqy() {
        this.gbY.setVisibility(8);
        this.gcc.setVisibility(8);
        this.gbP.setVisibility(0);
        com.baidu.adp.lib.util.k.b(this.gbL.getActivity(), this.gbZ);
    }

    public void Y(View.OnClickListener onClickListener) {
        this.gbY.setOnClickListener(onClickListener);
        this.gcc.setOnClickListener(onClickListener);
        this.gbP.setOnClickListener(onClickListener);
    }

    public String bqz() {
        if (this.gbZ == null || this.gbZ.getText() == null) {
            return null;
        }
        return this.gbZ.getText().toString();
    }

    public void bqA() {
        if (this.gcd != null) {
            this.gcd.setText(w.l.tip_url_not_match);
            com.baidu.tbadk.core.util.aq.i(this.gcd, w.e.cp_other_b);
        }
    }

    public void Z(View.OnClickListener onClickListener) {
        if (this.gcb != null) {
            this.gcb.setOnClickListener(onClickListener);
        }
    }

    public View bqB() {
        return this.gbY;
    }

    public void destroy() {
        if (this.gbO != null) {
            this.gbO.addTextChangedListener(null);
        }
        if (this.gbZ != null) {
            this.gbZ.addTextChangedListener(null);
        }
    }

    public void d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.sr(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ap(this.gbL.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.gbL.getPageContext().getPageActivity().getString(w.l.error_write);
                }
                this.gbL.showToast(errorString);
            }
        }
    }

    public void Pd() {
        this.aIy.c(null);
        this.aIy.cW(w.l.sending);
        this.aIy.aH(true);
    }

    public void closeLoadingDialog() {
        this.aIy.aH(false);
    }
}
