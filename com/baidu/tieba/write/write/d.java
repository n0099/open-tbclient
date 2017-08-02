package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class d {
    private View QE;
    private com.baidu.tbadk.core.view.a aKV;
    private View.OnClickListener aXL;
    private View dHh;
    private TbImageView dNs;
    private RelativeLayout eWr;
    private WriteUrlActivity gGF;
    private TextView gGG;
    private TbImageView gGH;
    private EditText gGI;
    private View gGJ;
    private LinearLayout gGK;
    private ImageView gGL;
    private View gGM;
    private TextView gGN;
    private TextView gGO;
    private View gGP;
    private TextView gGQ;
    private TextView gGR;
    private LinearLayout gGS;
    private EditText gGT;
    private View gGU;
    private TextView gGV;
    private FrameLayout gGW;
    private TextView gGX;
    private NavigationBar mNavigationBar;

    public d(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.dHh = null;
        this.aKV = null;
        if (writeUrlActivity != null) {
            this.gGF = writeUrlActivity;
            this.aXL = onClickListener;
            this.QE = LayoutInflater.from(this.gGF.getPageContext().getPageActivity()).inflate(d.j.write_url_activity_layout, (ViewGroup) null);
            this.gGF.setContentView(this.QE);
            this.mNavigationBar = (NavigationBar) this.QE.findViewById(d.h.view_navigation_bar);
            this.dHh = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aXL);
            this.mNavigationBar.setmBackImageViewBg(d.g.write_close_selector, d.g.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dHh.getLayoutParams();
                layoutParams.leftMargin = k.g(this.gGF.getActivity(), d.f.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.dHh != null && (this.dHh.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dHh.getLayoutParams();
                layoutParams2.width = -2;
                this.dHh.setLayoutParams(layoutParams2);
            }
            this.QE.setOnClickListener(this.aXL);
            this.gGG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.l.send_post));
            ai.c(this.gGG, d.e.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.gGG.getLayoutParams();
            layoutParams3.rightMargin = k.g(this.gGF.getActivity(), d.f.ds16);
            this.gGG.setLayoutParams(layoutParams3);
            this.gGG.setOnClickListener(this.aXL);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.l.post_new_thread));
            this.gGH = (TbImageView) this.QE.findViewById(d.h.imageview_picture);
            this.gGH.setDefaultResource(d.g.ic_post_url_n);
            this.gGH.setDefaultErrorResource(d.g.ic_post_url_n);
            this.gGH.setDefaultBgResource(d.e.black_alpha0);
            this.gGK = (LinearLayout) this.QE.findViewById(d.h.view_picture_publish);
            this.gGK.setOnClickListener(this.aXL);
            this.eWr = (RelativeLayout) this.QE.findViewById(d.h.video_container);
            this.eWr.setOnClickListener(this.aXL);
            this.dNs = (TbImageView) this.QE.findViewById(d.h.video_img_thumbnail);
            this.dNs.setDefaultErrorResource(0);
            this.dNs.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.dNs.setDefaultBgResource(d.e.black_alpha0);
            this.gGL = (ImageView) this.QE.findViewById(d.h.video_img_play);
            this.gGM = this.QE.findViewById(d.h.video_view_delete);
            this.gGM.setOnClickListener(this.aXL);
            this.gGN = (TextView) this.QE.findViewById(d.h.textview_title);
            this.gGO = (TextView) this.QE.findViewById(d.h.textview_abstract);
            this.gGP = this.QE.findViewById(d.h.view_delete);
            this.gGP.setOnClickListener(this.aXL);
            this.gGJ = this.QE.findViewById(d.h.icon_invoke_link);
            this.gGJ.setOnClickListener(this.aXL);
            this.gGI = (EditText) this.QE.findViewById(d.h.post_content);
            this.gGI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.d.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    d.this.bAB();
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }
            });
            this.gGQ = (TextView) this.QE.findViewById(d.h.textview_error_tip);
            this.gGR = (TextView) this.QE.findViewById(d.h.textview_url);
            this.gGS = (LinearLayout) this.QE.findViewById(d.h.url_edit_container);
            this.gGT = (EditText) this.QE.findViewById(d.h.url_input);
            this.gGX = (TextView) this.QE.findViewById(d.h.url_desc);
            this.gGU = this.QE.findViewById(d.h.url_input_clear);
            this.gGV = (TextView) this.QE.findViewById(d.h.url_add);
            this.gGV.setEnabled(false);
            this.gGW = (FrameLayout) this.QE.findViewById(d.h.url_edit_back_view);
            this.gGT.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.d.2
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        d.this.gGU.setVisibility(8);
                        ai.i(d.this.gGV, d.e.cp_cont_e);
                        d.this.gGV.setEnabled(false);
                        return;
                    }
                    d.this.gGU.setVisibility(0);
                    ai.i(d.this.gGV, d.e.cp_link_tip_a);
                    d.this.gGV.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (d.this.gGX.getText().equals(d.this.gGF.getActivity().getString(d.l.tip_url_not_match))) {
                        d.this.bAA();
                    }
                }
            });
            this.gGU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.gGT.setText("");
                    d.this.gGU.setVisibility(8);
                    d.this.gGV.setEnabled(false);
                }
            });
            this.aKV = new com.baidu.tbadk.core.view.a(this.gGF.getPageContext());
            bAA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAA() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.gGX.setText(d.l.tip_url_post);
        } else {
            this.gGX.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        ai.i(this.gGX, d.e.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.gGF.setIsLoading(z);
        if (z) {
            this.gGK.setVisibility(0);
            this.eWr.setVisibility(8);
            this.gGH.c(null, 10, false);
            this.gGN.setVisibility(8);
            this.gGO.setVisibility(8);
            this.gGQ.setVisibility(8);
            this.gGR.setVisibility(0);
            ai.i(this.gGR, d.e.cp_cont_f);
            this.gGR.setText(d.l.tip_url_loading);
        } else if (aVar == null) {
            this.gGK.setVisibility(8);
            this.eWr.setVisibility(8);
            bAB();
        } else {
            if (aVar.gAI == 1) {
                this.gGK.setVisibility(0);
                this.eWr.setVisibility(8);
                if (aVar.gAH) {
                    this.gGH.c(aVar.gAK, 10, false);
                    this.gGN.setText(aVar.Wk);
                    this.gGO.setText(aVar.Wl);
                    if (al.dT(aVar.Wk) > 30) {
                        this.gGN.setMaxLines(2);
                        this.gGO.setMaxLines(1);
                    } else {
                        this.gGN.setMaxLines(1);
                        this.gGO.setMaxLines(2);
                    }
                    this.gGN.setVisibility(0);
                    this.gGO.setVisibility(0);
                    this.gGR.setVisibility(8);
                    this.gGQ.setVisibility(8);
                } else {
                    this.gGH.reset();
                    this.gGR.setText(aVar.linkUrl);
                    ai.i(this.gGR, d.e.cp_cont_b);
                    this.gGN.setVisibility(8);
                    this.gGO.setVisibility(8);
                    this.gGR.setVisibility(0);
                    this.gGQ.setVisibility(0);
                }
            } else if (aVar.gAI == 2) {
                this.gGK.setVisibility(8);
                this.eWr.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.eWr.getLayoutParams();
                layoutParams.height = ((k.af(this.gGF.getPageContext().getPageActivity()) - ((int) this.gGF.getPageContext().getPageActivity().getResources().getDimension(d.f.ds80))) * 9) / 16;
                this.eWr.setLayoutParams(layoutParams);
                ai.c(this.gGL, d.g.icon_play_video);
                ai.j(this.gGM, d.g.btn_delete_url);
                this.dNs.c(aVar.gAO, 10, false);
            } else {
                this.gGK.setVisibility(0);
                this.eWr.setVisibility(8);
                this.gGN.setVisibility(8);
                this.gGO.setVisibility(8);
                this.gGR.setVisibility(0);
                this.gGQ.setVisibility(0);
                this.gGH.reset();
                this.gGR.setText(aVar.linkUrl);
                ai.i(this.gGR, d.e.cp_cont_b);
            }
            bAB();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gGF != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.gGF.getPageContext(), i);
            }
            ai.k(this.mNavigationBar, d.e.cp_bg_line_d);
            ai.k(this.QE, d.e.cp_bg_line_d);
            this.gGI.setHintTextColor(ai.getColor(d.e.cp_cont_e));
            this.gGI.setTextColor(ai.getColor(d.e.cp_cont_f));
            ai.k(this.gGK, d.e.cp_bg_line_e);
            ai.i(this.gGN, d.e.cp_cont_b);
            ai.i(this.gGO, d.e.cp_cont_d);
            ai.i(this.gGR, d.e.cp_cont_b);
            ai.k(this.gGQ, d.e.cp_bg_line_d);
            ai.i(this.gGQ, d.e.cp_cont_d);
            ai.j(this.gGJ, d.g.bg_link_invoke);
            ai.k(this.gGS, d.e.cp_bg_line_d);
            this.gGT.setHintTextColor(ai.getColor(d.e.cp_cont_e));
            ai.i(this.gGT, d.e.cp_cont_b);
            ai.i(this.gGX, d.e.cp_cont_d);
            ai.i(this.gGV, d.e.cp_cont_e);
            ai.c(this.gGL, d.g.home_ic_video);
            ai.j(this.gGP, d.g.btn_delete_url);
            ai.j(this.gGU, d.g.btn_delete_url);
            ai.j(this.gGM, d.g.btn_delete_url);
            bAB();
        }
    }

    public void bAB() {
        boolean z;
        if (StringUtils.isNull(bAC())) {
            z = this.gGK.getVisibility() == 0 || this.eWr.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            ai.b(this.gGG, d.e.cp_link_tip_a, d.e.s_navbar_title_color);
            this.gGG.setEnabled(true);
            return;
        }
        ai.c(this.gGG, d.e.cp_cont_d, 1);
        this.gGG.setEnabled(false);
    }

    public String bAC() {
        if (this.gGI == null || this.gGI.getText() == null) {
            return null;
        }
        return this.gGI.getText().toString();
    }

    public View VV() {
        return this.dHh;
    }

    public View bAD() {
        return this.gGG;
    }

    public View getRootView() {
        return this.QE;
    }

    public View bAE() {
        return this.gGI;
    }

    public View boS() {
        return this.gGP;
    }

    public View bAF() {
        return this.gGM;
    }

    public View bAG() {
        return this.gGK;
    }

    public View getVideoContainer() {
        return this.eWr;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.gGT.setText(aVar.linkUrl);
            this.gGT.setSelection(aVar.linkUrl.length());
        }
        this.gGT.requestFocus();
        k.c(this.gGF.getActivity(), this.gGT);
        this.gGS.setVisibility(0);
        this.gGW.setVisibility(0);
        this.gGJ.setVisibility(8);
    }

    public void bAH() {
        this.gGS.setVisibility(8);
        this.gGW.setVisibility(8);
        this.gGJ.setVisibility(0);
        k.b(this.gGF.getActivity(), this.gGT);
    }

    public void Y(View.OnClickListener onClickListener) {
        this.gGS.setOnClickListener(onClickListener);
        this.gGW.setOnClickListener(onClickListener);
        this.gGJ.setOnClickListener(onClickListener);
    }

    public String bAI() {
        if (this.gGT == null || this.gGT.getText() == null) {
            return null;
        }
        return this.gGT.getText().toString();
    }

    public void bAJ() {
        if (this.gGX != null) {
            this.gGX.setText(d.l.tip_url_not_match);
            ai.i(this.gGX, d.e.cp_other_b);
        }
    }

    public void Z(View.OnClickListener onClickListener) {
        if (this.gGV != null) {
            this.gGV.setOnClickListener(onClickListener);
        }
    }

    public View bAK() {
        return this.gGS;
    }

    public void destroy() {
        if (this.gGI != null) {
            this.gGI.addTextChangedListener(null);
        }
        if (this.gGT != null) {
            this.gGT.addTextChangedListener(null);
        }
    }

    public void d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.to(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ar(this.gGF.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.gGF.getPageContext().getPageActivity().getString(d.l.error_write);
                }
                this.gGF.showToast(errorString);
            }
        }
    }

    public void QS() {
        this.aKV.c(null);
        this.aKV.da(d.l.sending);
        this.aKV.aH(true);
    }

    public void closeLoadingDialog() {
        this.aKV.aH(false);
    }
}
