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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes3.dex */
public class k {
    private View ajk;
    private com.baidu.tbadk.core.view.d beC;
    private View fdi;
    private TbImageView fhA;
    private RelativeLayout gdG;
    private WriteUrlActivity hSD;
    private TextView hSE;
    private TbImageView hSF;
    private EditText hSG;
    private View hSH;
    private LinearLayout hSI;
    private ImageView hSJ;
    private View hSK;
    private TextView hSL;
    private TextView hSM;
    private View hSN;
    private TextView hSO;
    private TextView hSP;
    private LinearLayout hSQ;
    private EditText hSR;
    private View hSS;
    private TextView hST;
    private FrameLayout hSU;
    private TextView hSV;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.fdi = null;
        this.beC = null;
        if (writeUrlActivity != null) {
            this.hSD = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.ajk = LayoutInflater.from(this.hSD.getPageContext().getPageActivity()).inflate(e.h.write_url_activity_layout, (ViewGroup) null);
            this.hSD.setContentView(this.ajk);
            this.mNavigationBar = (NavigationBar) this.ajk.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.fdi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(e.f.write_close_selector, e.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fdi.getLayoutParams();
                layoutParams.leftMargin = l.h(this.hSD.getActivity(), e.C0200e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.fdi != null && (this.fdi.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fdi.getLayoutParams();
                layoutParams2.width = -2;
                this.fdi.setLayoutParams(layoutParams2);
            }
            this.ajk.setOnClickListener(this.mClickListener);
            this.hSE = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(e.j.send_post));
            al.c(this.hSE, e.d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hSE.getLayoutParams();
            layoutParams3.rightMargin = l.h(this.hSD.getActivity(), e.C0200e.ds16);
            this.hSE.setLayoutParams(layoutParams3);
            this.hSE.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(e.j.post_new_thread));
            this.hSF = (TbImageView) this.ajk.findViewById(e.g.imageview_picture);
            this.hSF.setDefaultResource(e.f.ic_post_url_n);
            this.hSF.setDefaultErrorResource(e.f.ic_post_url_n);
            this.hSF.setDefaultBgResource(e.d.black_alpha0);
            this.hSI = (LinearLayout) this.ajk.findViewById(e.g.view_picture_publish);
            this.hSI.setOnClickListener(this.mClickListener);
            this.gdG = (RelativeLayout) this.ajk.findViewById(e.g.video_container);
            this.gdG.setOnClickListener(this.mClickListener);
            this.fhA = (TbImageView) this.ajk.findViewById(e.g.video_img_thumbnail);
            this.fhA.setDefaultErrorResource(0);
            this.fhA.setDefaultBgResource(e.f.pic_bg_video_frs);
            this.fhA.setDefaultBgResource(e.d.black_alpha0);
            this.hSJ = (ImageView) this.ajk.findViewById(e.g.video_img_play);
            this.hSK = this.ajk.findViewById(e.g.video_view_delete);
            this.hSK.setOnClickListener(this.mClickListener);
            this.hSL = (TextView) this.ajk.findViewById(e.g.textview_title);
            this.hSM = (TextView) this.ajk.findViewById(e.g.textview_abstract);
            this.hSN = this.ajk.findViewById(e.g.view_delete);
            this.hSN.setOnClickListener(this.mClickListener);
            this.hSH = this.ajk.findViewById(e.g.icon_invoke_link);
            this.hSH.setOnClickListener(this.mClickListener);
            this.hSG = (EditText) this.ajk.findViewById(e.g.post_content);
            this.hSO = (TextView) this.ajk.findViewById(e.g.textview_error_tip);
            this.hSP = (TextView) this.ajk.findViewById(e.g.textview_url);
            this.hSQ = (LinearLayout) this.ajk.findViewById(e.g.url_edit_container);
            this.hSR = (EditText) this.ajk.findViewById(e.g.url_input);
            this.hSV = (TextView) this.ajk.findViewById(e.g.url_desc);
            this.hSS = this.ajk.findViewById(e.g.url_input_clear);
            this.hST = (TextView) this.ajk.findViewById(e.g.url_add);
            this.hST.setEnabled(false);
            this.hSU = (FrameLayout) this.ajk.findViewById(e.g.url_edit_back_view);
            this.hSR.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.hSS.setVisibility(8);
                        al.h(k.this.hST, e.d.cp_cont_e);
                        k.this.hST.setEnabled(false);
                        return;
                    }
                    k.this.hSS.setVisibility(0);
                    al.h(k.this.hST, e.d.cp_link_tip_a);
                    k.this.hST.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.hSV.getText().equals(k.this.hSD.getActivity().getString(e.j.tip_url_not_match))) {
                        k.this.bOc();
                    }
                }
            });
            this.hSS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.hSR.setText("");
                    k.this.hSS.setVisibility(8);
                    k.this.hST.setEnabled(false);
                }
            });
            this.beC = new com.baidu.tbadk.core.view.d(this.hSD.getPageContext());
            bOc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOc() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.hSV.setText(e.j.tip_url_post);
        } else {
            this.hSV.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        al.h(this.hSV, e.d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.hSD.setIsLoading(z);
        if (z) {
            this.hSI.setVisibility(0);
            this.gdG.setVisibility(8);
            this.hSF.startLoad(null, 10, false);
            this.hSL.setVisibility(8);
            this.hSM.setVisibility(8);
            this.hSO.setVisibility(8);
            this.hSP.setVisibility(0);
            al.h(this.hSP, e.d.cp_cont_f);
            this.hSP.setText(e.j.tip_url_loading);
        } else if (aVar == null) {
            this.hSI.setVisibility(8);
            this.gdG.setVisibility(8);
            bOd();
        } else {
            if (aVar.hMj == 1) {
                this.hSI.setVisibility(0);
                this.gdG.setVisibility(8);
                if (aVar.hMi) {
                    this.hSF.startLoad(aVar.hMl, 10, false);
                    this.hSL.setText(aVar.aoo);
                    this.hSM.setText(aVar.aop);
                    if (ao.fq(aVar.aoo) > 30) {
                        this.hSL.setMaxLines(2);
                        this.hSM.setMaxLines(1);
                    } else {
                        this.hSL.setMaxLines(1);
                        this.hSM.setMaxLines(2);
                    }
                    this.hSL.setVisibility(0);
                    this.hSM.setVisibility(0);
                    this.hSP.setVisibility(8);
                    this.hSO.setVisibility(8);
                } else {
                    this.hSF.reset();
                    this.hSP.setText(aVar.linkUrl);
                    al.h(this.hSP, e.d.cp_cont_b);
                    this.hSL.setVisibility(8);
                    this.hSM.setVisibility(8);
                    this.hSP.setVisibility(0);
                    this.hSO.setVisibility(0);
                }
            } else if (aVar.hMj == 2) {
                this.hSI.setVisibility(8);
                this.gdG.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.gdG.getLayoutParams();
                layoutParams.height = ((l.aO(this.hSD.getPageContext().getPageActivity()) - ((int) this.hSD.getPageContext().getPageActivity().getResources().getDimension(e.C0200e.ds80))) * 9) / 16;
                this.gdG.setLayoutParams(layoutParams);
                al.c(this.hSJ, e.f.icon_play_video);
                al.i(this.hSK, e.f.btn_delete_url);
                this.fhA.startLoad(aVar.hMo, 10, false);
            } else {
                this.hSI.setVisibility(0);
                this.gdG.setVisibility(8);
                this.hSL.setVisibility(8);
                this.hSM.setVisibility(8);
                this.hSP.setVisibility(0);
                this.hSO.setVisibility(0);
                this.hSF.reset();
                this.hSP.setText(aVar.linkUrl);
                al.h(this.hSP, e.d.cp_cont_b);
            }
            bOd();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.hSG.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.hSD != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hSD.getPageContext(), i);
            }
            al.j(this.mNavigationBar, e.d.cp_bg_line_d);
            al.j(this.ajk, e.d.cp_bg_line_d);
            this.hSG.setHintTextColor(al.getColor(e.d.cp_cont_e));
            this.hSG.setTextColor(al.getColor(e.d.cp_cont_f));
            al.j(this.hSI, e.d.cp_bg_line_e);
            al.h(this.hSL, e.d.cp_cont_b);
            al.h(this.hSM, e.d.cp_cont_d);
            al.h(this.hSP, e.d.cp_cont_b);
            al.j(this.hSO, e.d.cp_bg_line_d);
            al.h(this.hSO, e.d.cp_cont_d);
            al.i(this.hSH, e.f.bg_link_invoke);
            al.j(this.hSQ, e.d.cp_bg_line_d);
            this.hSR.setHintTextColor(al.getColor(e.d.cp_cont_e));
            al.h(this.hSR, e.d.cp_cont_b);
            al.h(this.hSV, e.d.cp_cont_d);
            al.h(this.hST, e.d.cp_cont_e);
            al.c(this.hSJ, e.f.home_ic_video);
            al.i(this.hSN, e.f.btn_delete_url);
            al.i(this.hSS, e.f.btn_delete_url);
            al.i(this.hSK, e.f.btn_delete_url);
            bOd();
        }
    }

    public void bOd() {
        boolean z;
        if (StringUtils.isNull(bOe())) {
            z = this.hSI.getVisibility() == 0 || this.gdG.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            al.b(this.hSE, e.d.cp_link_tip_a, e.d.s_navbar_title_color);
            this.hSE.setEnabled(true);
            return;
        }
        al.c(this.hSE, e.d.cp_cont_d, 1);
        this.hSE.setEnabled(false);
    }

    public String bOe() {
        if (this.hSG == null || this.hSG.getText() == null) {
            return null;
        }
        return this.hSG.getText().toString();
    }

    public View aSk() {
        return this.fdi;
    }

    public View bOf() {
        return this.hSE;
    }

    public View getRootView() {
        return this.ajk;
    }

    public EditText bOg() {
        return this.hSG;
    }

    public View bOh() {
        return this.hSN;
    }

    public View bOi() {
        return this.hSK;
    }

    public View bOj() {
        return this.hSI;
    }

    public View getVideoContainer() {
        return this.gdG;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.hSR.setText(aVar.linkUrl);
            this.hSR.setSelection(aVar.linkUrl.length());
        }
        this.hSR.requestFocus();
        l.c(this.hSD.getActivity(), this.hSR);
        this.hSQ.setVisibility(0);
        this.hSU.setVisibility(0);
        this.hSH.setVisibility(8);
    }

    public void bOk() {
        this.hSQ.setVisibility(8);
        this.hSU.setVisibility(8);
        this.hSH.setVisibility(0);
        l.b(this.hSD.getActivity(), this.hSR);
    }

    public void Z(View.OnClickListener onClickListener) {
        this.hSQ.setOnClickListener(onClickListener);
        this.hSU.setOnClickListener(onClickListener);
        this.hSH.setOnClickListener(onClickListener);
    }

    public String bOl() {
        if (this.hSR == null || this.hSR.getText() == null) {
            return null;
        }
        return this.hSR.getText().toString();
    }

    public void bOm() {
        if (this.hSV != null) {
            this.hSV.setText(e.j.tip_url_not_match);
            al.h(this.hSV, e.d.cp_other_b);
        }
    }

    public void aa(View.OnClickListener onClickListener) {
        if (this.hST != null) {
            this.hST.setOnClickListener(onClickListener);
        }
    }

    public View bOn() {
        return this.hSQ;
    }

    public void destroy() {
        if (this.hSG != null) {
            this.hSG.addTextChangedListener(null);
        }
        if (this.hSR != null) {
            this.hSR.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.ai(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aG(this.hSD.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.hSD.getPageContext().getPageActivity().getString(e.j.sand_fail);
                }
                this.hSD.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.beC.d(null);
        this.beC.dO(e.j.sending);
        this.beC.bz(true);
    }

    public void closeLoadingDialog() {
        this.beC.bz(false);
    }
}
