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
    private View aGK;
    private com.baidu.tbadk.core.view.b bAI;
    private View eSD;
    private TbImageView eWX;
    private RelativeLayout fYN;
    private View hLA;
    private LinearLayout hLB;
    private ImageView hLC;
    private View hLD;
    private TextView hLE;
    private TextView hLF;
    private View hLG;
    private TextView hLH;
    private TextView hLI;
    private LinearLayout hLJ;
    private EditText hLK;
    private View hLL;
    private TextView hLM;
    private FrameLayout hLN;
    private TextView hLO;
    private WriteUrlActivity hLw;
    private TextView hLx;
    private TbImageView hLy;
    private EditText hLz;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public j(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.eSD = null;
        this.bAI = null;
        if (writeUrlActivity != null) {
            this.hLw = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.aGK = LayoutInflater.from(this.hLw.getPageContext().getPageActivity()).inflate(d.h.write_url_activity_layout, (ViewGroup) null);
            this.hLw.setContentView(this.aGK);
            this.mNavigationBar = (NavigationBar) this.aGK.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.eSD = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eSD.getLayoutParams();
                layoutParams.leftMargin = l.s(this.hLw.getActivity(), d.e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.eSD != null && (this.eSD.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eSD.getLayoutParams();
                layoutParams2.width = -2;
                this.eSD.setLayoutParams(layoutParams2);
            }
            this.aGK.setOnClickListener(this.mClickListener);
            this.hLx = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.j.send_post));
            aj.e(this.hLx, d.C0108d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hLx.getLayoutParams();
            layoutParams3.rightMargin = l.s(this.hLw.getActivity(), d.e.ds16);
            this.hLx.setLayoutParams(layoutParams3);
            this.hLx.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.j.post_new_thread));
            this.hLy = (TbImageView) this.aGK.findViewById(d.g.imageview_picture);
            this.hLy.setDefaultResource(d.f.ic_post_url_n);
            this.hLy.setDefaultErrorResource(d.f.ic_post_url_n);
            this.hLy.setDefaultBgResource(d.C0108d.black_alpha0);
            this.hLB = (LinearLayout) this.aGK.findViewById(d.g.view_picture_publish);
            this.hLB.setOnClickListener(this.mClickListener);
            this.fYN = (RelativeLayout) this.aGK.findViewById(d.g.video_container);
            this.fYN.setOnClickListener(this.mClickListener);
            this.eWX = (TbImageView) this.aGK.findViewById(d.g.video_img_thumbnail);
            this.eWX.setDefaultErrorResource(0);
            this.eWX.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.eWX.setDefaultBgResource(d.C0108d.black_alpha0);
            this.hLC = (ImageView) this.aGK.findViewById(d.g.video_img_play);
            this.hLD = this.aGK.findViewById(d.g.video_view_delete);
            this.hLD.setOnClickListener(this.mClickListener);
            this.hLE = (TextView) this.aGK.findViewById(d.g.textview_title);
            this.hLF = (TextView) this.aGK.findViewById(d.g.textview_abstract);
            this.hLG = this.aGK.findViewById(d.g.view_delete);
            this.hLG.setOnClickListener(this.mClickListener);
            this.hLA = this.aGK.findViewById(d.g.icon_invoke_link);
            this.hLA.setOnClickListener(this.mClickListener);
            this.hLz = (EditText) this.aGK.findViewById(d.g.post_content);
            this.hLH = (TextView) this.aGK.findViewById(d.g.textview_error_tip);
            this.hLI = (TextView) this.aGK.findViewById(d.g.textview_url);
            this.hLJ = (LinearLayout) this.aGK.findViewById(d.g.url_edit_container);
            this.hLK = (EditText) this.aGK.findViewById(d.g.url_input);
            this.hLO = (TextView) this.aGK.findViewById(d.g.url_desc);
            this.hLL = this.aGK.findViewById(d.g.url_input_clear);
            this.hLM = (TextView) this.aGK.findViewById(d.g.url_add);
            this.hLM.setEnabled(false);
            this.hLN = (FrameLayout) this.aGK.findViewById(d.g.url_edit_back_view);
            this.hLK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.j.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        j.this.hLL.setVisibility(8);
                        aj.r(j.this.hLM, d.C0108d.cp_cont_e);
                        j.this.hLM.setEnabled(false);
                        return;
                    }
                    j.this.hLL.setVisibility(0);
                    aj.r(j.this.hLM, d.C0108d.cp_link_tip_a);
                    j.this.hLM.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (j.this.hLO.getText().equals(j.this.hLw.getActivity().getString(d.j.tip_url_not_match))) {
                        j.this.bIB();
                    }
                }
            });
            this.hLL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.hLK.setText("");
                    j.this.hLL.setVisibility(8);
                    j.this.hLM.setEnabled(false);
                }
            });
            this.bAI = new com.baidu.tbadk.core.view.b(this.hLw.getPageContext());
            bIB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIB() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.hLO.setText(d.j.tip_url_post);
        } else {
            this.hLO.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        aj.r(this.hLO, d.C0108d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.hLw.setIsLoading(z);
        if (z) {
            this.hLB.setVisibility(0);
            this.fYN.setVisibility(8);
            this.hLy.startLoad(null, 10, false);
            this.hLE.setVisibility(8);
            this.hLF.setVisibility(8);
            this.hLH.setVisibility(8);
            this.hLI.setVisibility(0);
            aj.r(this.hLI, d.C0108d.cp_cont_f);
            this.hLI.setText(d.j.tip_url_loading);
        } else if (aVar == null) {
            this.hLB.setVisibility(8);
            this.fYN.setVisibility(8);
            bIC();
        } else {
            if (aVar.hEO == 1) {
                this.hLB.setVisibility(0);
                this.fYN.setVisibility(8);
                if (aVar.hEN) {
                    this.hLy.startLoad(aVar.hEQ, 10, false);
                    this.hLE.setText(aVar.aLL);
                    this.hLF.setText(aVar.aLM);
                    if (am.eg(aVar.aLL) > 30) {
                        this.hLE.setMaxLines(2);
                        this.hLF.setMaxLines(1);
                    } else {
                        this.hLE.setMaxLines(1);
                        this.hLF.setMaxLines(2);
                    }
                    this.hLE.setVisibility(0);
                    this.hLF.setVisibility(0);
                    this.hLI.setVisibility(8);
                    this.hLH.setVisibility(8);
                } else {
                    this.hLy.reset();
                    this.hLI.setText(aVar.linkUrl);
                    aj.r(this.hLI, d.C0108d.cp_cont_b);
                    this.hLE.setVisibility(8);
                    this.hLF.setVisibility(8);
                    this.hLI.setVisibility(0);
                    this.hLH.setVisibility(0);
                }
            } else if (aVar.hEO == 2) {
                this.hLB.setVisibility(8);
                this.fYN.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.fYN.getLayoutParams();
                layoutParams.height = ((l.ao(this.hLw.getPageContext().getPageActivity()) - ((int) this.hLw.getPageContext().getPageActivity().getResources().getDimension(d.e.ds80))) * 9) / 16;
                this.fYN.setLayoutParams(layoutParams);
                aj.c(this.hLC, d.f.icon_play_video);
                aj.s(this.hLD, d.f.btn_delete_url);
                this.eWX.startLoad(aVar.hET, 10, false);
            } else {
                this.hLB.setVisibility(0);
                this.fYN.setVisibility(8);
                this.hLE.setVisibility(8);
                this.hLF.setVisibility(8);
                this.hLI.setVisibility(0);
                this.hLH.setVisibility(0);
                this.hLy.reset();
                this.hLI.setText(aVar.linkUrl);
                aj.r(this.hLI, d.C0108d.cp_cont_b);
            }
            bIC();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.hLz.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.hLw != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hLw.getPageContext(), i);
            }
            aj.t(this.mNavigationBar, d.C0108d.cp_bg_line_d);
            aj.t(this.aGK, d.C0108d.cp_bg_line_d);
            this.hLz.setHintTextColor(aj.getColor(d.C0108d.cp_cont_e));
            this.hLz.setTextColor(aj.getColor(d.C0108d.cp_cont_f));
            aj.t(this.hLB, d.C0108d.cp_bg_line_e);
            aj.r(this.hLE, d.C0108d.cp_cont_b);
            aj.r(this.hLF, d.C0108d.cp_cont_d);
            aj.r(this.hLI, d.C0108d.cp_cont_b);
            aj.t(this.hLH, d.C0108d.cp_bg_line_d);
            aj.r(this.hLH, d.C0108d.cp_cont_d);
            aj.s(this.hLA, d.f.bg_link_invoke);
            aj.t(this.hLJ, d.C0108d.cp_bg_line_d);
            this.hLK.setHintTextColor(aj.getColor(d.C0108d.cp_cont_e));
            aj.r(this.hLK, d.C0108d.cp_cont_b);
            aj.r(this.hLO, d.C0108d.cp_cont_d);
            aj.r(this.hLM, d.C0108d.cp_cont_e);
            aj.c(this.hLC, d.f.home_ic_video);
            aj.s(this.hLG, d.f.btn_delete_url);
            aj.s(this.hLL, d.f.btn_delete_url);
            aj.s(this.hLD, d.f.btn_delete_url);
            bIC();
        }
    }

    public void bIC() {
        boolean z;
        if (StringUtils.isNull(bID())) {
            z = this.hLB.getVisibility() == 0 || this.fYN.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            aj.d(this.hLx, d.C0108d.cp_link_tip_a, d.C0108d.s_navbar_title_color);
            this.hLx.setEnabled(true);
            return;
        }
        aj.e(this.hLx, d.C0108d.cp_cont_d, 1);
        this.hLx.setEnabled(false);
    }

    public String bID() {
        if (this.hLz == null || this.hLz.getText() == null) {
            return null;
        }
        return this.hLz.getText().toString();
    }

    public View aKm() {
        return this.eSD;
    }

    public View bIE() {
        return this.hLx;
    }

    public View getRootView() {
        return this.aGK;
    }

    public EditText bIF() {
        return this.hLz;
    }

    public View bIG() {
        return this.hLG;
    }

    public View bIH() {
        return this.hLD;
    }

    public View bII() {
        return this.hLB;
    }

    public View getVideoContainer() {
        return this.fYN;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.hLK.setText(aVar.linkUrl);
            this.hLK.setSelection(aVar.linkUrl.length());
        }
        this.hLK.requestFocus();
        l.b(this.hLw.getActivity(), this.hLK);
        this.hLJ.setVisibility(0);
        this.hLN.setVisibility(0);
        this.hLA.setVisibility(8);
    }

    public void bIJ() {
        this.hLJ.setVisibility(8);
        this.hLN.setVisibility(8);
        this.hLA.setVisibility(0);
        l.a(this.hLw.getActivity(), this.hLK);
    }

    public void U(View.OnClickListener onClickListener) {
        this.hLJ.setOnClickListener(onClickListener);
        this.hLN.setOnClickListener(onClickListener);
        this.hLA.setOnClickListener(onClickListener);
    }

    public String bIK() {
        if (this.hLK == null || this.hLK.getText() == null) {
            return null;
        }
        return this.hLK.getText().toString();
    }

    public void bIL() {
        if (this.hLO != null) {
            this.hLO.setText(d.j.tip_url_not_match);
            aj.r(this.hLO, d.C0108d.cp_other_b);
        }
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.hLM != null) {
            this.hLM.setOnClickListener(onClickListener);
        }
    }

    public View bIM() {
        return this.hLJ;
    }

    public void destroy() {
        if (this.hLz != null) {
            this.hLz.addTextChangedListener(null);
        }
        if (this.hLK != null) {
            this.hLK.addTextChangedListener(null);
        }
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.vQ(postWriteCallBackData.getErrorCode())) {
                AntiHelper.an(this.hLw.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.hLw.getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                this.hLw.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.bAI.c(null);
        this.bAI.fY(d.j.sending);
        this.bAI.bn(true);
    }

    public void closeLoadingDialog() {
        this.bAI.bn(false);
    }
}
