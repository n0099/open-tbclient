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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class j {
    private View aGJ;
    private com.baidu.tbadk.core.view.b bAr;
    private View eQI;
    private TbImageView eVc;
    private RelativeLayout fWR;
    private TextView hVA;
    private TextView hVB;
    private View hVC;
    private TextView hVD;
    private TextView hVE;
    private LinearLayout hVF;
    private EditText hVG;
    private View hVH;
    private TextView hVI;
    private FrameLayout hVJ;
    private TextView hVK;
    private WriteUrlActivity hVs;
    private TextView hVt;
    private TbImageView hVu;
    private EditText hVv;
    private View hVw;
    private LinearLayout hVx;
    private ImageView hVy;
    private View hVz;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public j(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.eQI = null;
        this.bAr = null;
        if (writeUrlActivity != null) {
            this.hVs = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.aGJ = LayoutInflater.from(this.hVs.getPageContext().getPageActivity()).inflate(d.h.write_url_activity_layout, (ViewGroup) null);
            this.hVs.setContentView(this.aGJ);
            this.mNavigationBar = (NavigationBar) this.aGJ.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.eQI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eQI.getLayoutParams();
                layoutParams.leftMargin = l.s(this.hVs.getActivity(), d.e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.eQI != null && (this.eQI.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eQI.getLayoutParams();
                layoutParams2.width = -2;
                this.eQI.setLayoutParams(layoutParams2);
            }
            this.aGJ.setOnClickListener(this.mClickListener);
            this.hVt = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.j.send_post));
            aj.e(this.hVt, d.C0108d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hVt.getLayoutParams();
            layoutParams3.rightMargin = l.s(this.hVs.getActivity(), d.e.ds16);
            this.hVt.setLayoutParams(layoutParams3);
            this.hVt.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.j.post_new_thread));
            this.hVu = (TbImageView) this.aGJ.findViewById(d.g.imageview_picture);
            this.hVu.setDefaultResource(d.f.ic_post_url_n);
            this.hVu.setDefaultErrorResource(d.f.ic_post_url_n);
            this.hVu.setDefaultBgResource(d.C0108d.black_alpha0);
            this.hVx = (LinearLayout) this.aGJ.findViewById(d.g.view_picture_publish);
            this.hVx.setOnClickListener(this.mClickListener);
            this.fWR = (RelativeLayout) this.aGJ.findViewById(d.g.video_container);
            this.fWR.setOnClickListener(this.mClickListener);
            this.eVc = (TbImageView) this.aGJ.findViewById(d.g.video_img_thumbnail);
            this.eVc.setDefaultErrorResource(0);
            this.eVc.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.eVc.setDefaultBgResource(d.C0108d.black_alpha0);
            this.hVy = (ImageView) this.aGJ.findViewById(d.g.video_img_play);
            this.hVz = this.aGJ.findViewById(d.g.video_view_delete);
            this.hVz.setOnClickListener(this.mClickListener);
            this.hVA = (TextView) this.aGJ.findViewById(d.g.textview_title);
            this.hVB = (TextView) this.aGJ.findViewById(d.g.textview_abstract);
            this.hVC = this.aGJ.findViewById(d.g.view_delete);
            this.hVC.setOnClickListener(this.mClickListener);
            this.hVw = this.aGJ.findViewById(d.g.icon_invoke_link);
            this.hVw.setOnClickListener(this.mClickListener);
            this.hVv = (EditText) this.aGJ.findViewById(d.g.post_content);
            this.hVD = (TextView) this.aGJ.findViewById(d.g.textview_error_tip);
            this.hVE = (TextView) this.aGJ.findViewById(d.g.textview_url);
            this.hVF = (LinearLayout) this.aGJ.findViewById(d.g.url_edit_container);
            this.hVG = (EditText) this.aGJ.findViewById(d.g.url_input);
            this.hVK = (TextView) this.aGJ.findViewById(d.g.url_desc);
            this.hVH = this.aGJ.findViewById(d.g.url_input_clear);
            this.hVI = (TextView) this.aGJ.findViewById(d.g.url_add);
            this.hVI.setEnabled(false);
            this.hVJ = (FrameLayout) this.aGJ.findViewById(d.g.url_edit_back_view);
            this.hVG.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.j.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        j.this.hVH.setVisibility(8);
                        aj.r(j.this.hVI, d.C0108d.cp_cont_e);
                        j.this.hVI.setEnabled(false);
                        return;
                    }
                    j.this.hVH.setVisibility(0);
                    aj.r(j.this.hVI, d.C0108d.cp_link_tip_a);
                    j.this.hVI.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (j.this.hVK.getText().equals(j.this.hVs.getActivity().getString(d.j.tip_url_not_match))) {
                        j.this.bOW();
                    }
                }
            });
            this.hVH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.hVG.setText("");
                    j.this.hVH.setVisibility(8);
                    j.this.hVI.setEnabled(false);
                }
            });
            this.bAr = new com.baidu.tbadk.core.view.b(this.hVs.getPageContext());
            bOW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOW() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.hVK.setText(d.j.tip_url_post);
        } else {
            this.hVK.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        aj.r(this.hVK, d.C0108d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.hVs.setIsLoading(z);
        if (z) {
            this.hVx.setVisibility(0);
            this.fWR.setVisibility(8);
            this.hVu.startLoad(null, 10, false);
            this.hVA.setVisibility(8);
            this.hVB.setVisibility(8);
            this.hVD.setVisibility(8);
            this.hVE.setVisibility(0);
            aj.r(this.hVE, d.C0108d.cp_cont_f);
            this.hVE.setText(d.j.tip_url_loading);
        } else if (aVar == null) {
            this.hVx.setVisibility(8);
            this.fWR.setVisibility(8);
            bOX();
        } else {
            if (aVar.hOM == 1) {
                this.hVx.setVisibility(0);
                this.fWR.setVisibility(8);
                if (aVar.hOL) {
                    this.hVu.startLoad(aVar.hOO, 10, false);
                    this.hVA.setText(aVar.aLM);
                    this.hVB.setText(aVar.aLN);
                    if (am.ec(aVar.aLM) > 30) {
                        this.hVA.setMaxLines(2);
                        this.hVB.setMaxLines(1);
                    } else {
                        this.hVA.setMaxLines(1);
                        this.hVB.setMaxLines(2);
                    }
                    this.hVA.setVisibility(0);
                    this.hVB.setVisibility(0);
                    this.hVE.setVisibility(8);
                    this.hVD.setVisibility(8);
                } else {
                    this.hVu.reset();
                    this.hVE.setText(aVar.linkUrl);
                    aj.r(this.hVE, d.C0108d.cp_cont_b);
                    this.hVA.setVisibility(8);
                    this.hVB.setVisibility(8);
                    this.hVE.setVisibility(0);
                    this.hVD.setVisibility(0);
                }
            } else if (aVar.hOM == 2) {
                this.hVx.setVisibility(8);
                this.fWR.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.fWR.getLayoutParams();
                layoutParams.height = ((l.ao(this.hVs.getPageContext().getPageActivity()) - ((int) this.hVs.getPageContext().getPageActivity().getResources().getDimension(d.e.ds80))) * 9) / 16;
                this.fWR.setLayoutParams(layoutParams);
                aj.c(this.hVy, d.f.icon_play_video);
                aj.s(this.hVz, d.f.btn_delete_url);
                this.eVc.startLoad(aVar.hOR, 10, false);
            } else {
                this.hVx.setVisibility(0);
                this.fWR.setVisibility(8);
                this.hVA.setVisibility(8);
                this.hVB.setVisibility(8);
                this.hVE.setVisibility(0);
                this.hVD.setVisibility(0);
                this.hVu.reset();
                this.hVE.setText(aVar.linkUrl);
                aj.r(this.hVE, d.C0108d.cp_cont_b);
            }
            bOX();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.hVv.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.hVs != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hVs.getPageContext(), i);
            }
            aj.t(this.mNavigationBar, d.C0108d.cp_bg_line_d);
            aj.t(this.aGJ, d.C0108d.cp_bg_line_d);
            this.hVv.setHintTextColor(aj.getColor(d.C0108d.cp_cont_e));
            this.hVv.setTextColor(aj.getColor(d.C0108d.cp_cont_f));
            aj.t(this.hVx, d.C0108d.cp_bg_line_e);
            aj.r(this.hVA, d.C0108d.cp_cont_b);
            aj.r(this.hVB, d.C0108d.cp_cont_d);
            aj.r(this.hVE, d.C0108d.cp_cont_b);
            aj.t(this.hVD, d.C0108d.cp_bg_line_d);
            aj.r(this.hVD, d.C0108d.cp_cont_d);
            aj.s(this.hVw, d.f.bg_link_invoke);
            aj.t(this.hVF, d.C0108d.cp_bg_line_d);
            this.hVG.setHintTextColor(aj.getColor(d.C0108d.cp_cont_e));
            aj.r(this.hVG, d.C0108d.cp_cont_b);
            aj.r(this.hVK, d.C0108d.cp_cont_d);
            aj.r(this.hVI, d.C0108d.cp_cont_e);
            aj.c(this.hVy, d.f.home_ic_video);
            aj.s(this.hVC, d.f.btn_delete_url);
            aj.s(this.hVH, d.f.btn_delete_url);
            aj.s(this.hVz, d.f.btn_delete_url);
            bOX();
        }
    }

    public void bOX() {
        boolean z;
        if (StringUtils.isNull(bOY())) {
            z = this.hVx.getVisibility() == 0 || this.fWR.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            aj.d(this.hVt, d.C0108d.cp_link_tip_a, d.C0108d.s_navbar_title_color);
            this.hVt.setEnabled(true);
            return;
        }
        aj.e(this.hVt, d.C0108d.cp_cont_d, 1);
        this.hVt.setEnabled(false);
    }

    public String bOY() {
        if (this.hVv == null || this.hVv.getText() == null) {
            return null;
        }
        return this.hVv.getText().toString();
    }

    public View aKc() {
        return this.eQI;
    }

    public View bOZ() {
        return this.hVt;
    }

    public View getRootView() {
        return this.aGJ;
    }

    public EditText bPa() {
        return this.hVv;
    }

    public View bPb() {
        return this.hVC;
    }

    public View bPc() {
        return this.hVz;
    }

    public View bPd() {
        return this.hVx;
    }

    public View getVideoContainer() {
        return this.fWR;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.hVG.setText(aVar.linkUrl);
            this.hVG.setSelection(aVar.linkUrl.length());
        }
        this.hVG.requestFocus();
        l.b(this.hVs.getActivity(), this.hVG);
        this.hVF.setVisibility(0);
        this.hVJ.setVisibility(0);
        this.hVw.setVisibility(8);
    }

    public void bPe() {
        this.hVF.setVisibility(8);
        this.hVJ.setVisibility(8);
        this.hVw.setVisibility(0);
        l.a(this.hVs.getActivity(), this.hVG);
    }

    public void W(View.OnClickListener onClickListener) {
        this.hVF.setOnClickListener(onClickListener);
        this.hVJ.setOnClickListener(onClickListener);
        this.hVw.setOnClickListener(onClickListener);
    }

    public String bPf() {
        if (this.hVG == null || this.hVG.getText() == null) {
            return null;
        }
        return this.hVG.getText().toString();
    }

    public void bPg() {
        if (this.hVK != null) {
            this.hVK.setText(d.j.tip_url_not_match);
            aj.r(this.hVK, d.C0108d.cp_other_b);
        }
    }

    public void X(View.OnClickListener onClickListener) {
        if (this.hVI != null) {
            this.hVI.setOnClickListener(onClickListener);
        }
    }

    public View bPh() {
        return this.hVF;
    }

    public void destroy() {
        if (this.hVv != null) {
            this.hVv.addTextChangedListener(null);
        }
        if (this.hVG != null) {
            this.hVG.addTextChangedListener(null);
        }
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.xo(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ap(this.hVs.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.hVs.getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                this.hVs.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.bAr.c(null);
        this.bAr.ga(d.j.sending);
        this.bAr.bm(true);
    }

    public void closeLoadingDialog() {
        this.bAr.bm(false);
    }
}
