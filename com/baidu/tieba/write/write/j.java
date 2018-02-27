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
    private View aHS;
    private com.baidu.tbadk.core.view.b bCz;
    private View eXO;
    private TbImageView fca;
    private RelativeLayout gbJ;
    private WriteUrlActivity hMI;
    private TextView hMJ;
    private TbImageView hMK;
    private EditText hML;
    private View hMM;
    private LinearLayout hMN;
    private ImageView hMO;
    private View hMP;
    private TextView hMQ;
    private TextView hMR;
    private View hMS;
    private TextView hMT;
    private TextView hMU;
    private LinearLayout hMV;
    private EditText hMW;
    private View hMX;
    private TextView hMY;
    private FrameLayout hMZ;
    private TextView hNa;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public j(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.eXO = null;
        this.bCz = null;
        if (writeUrlActivity != null) {
            this.hMI = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.aHS = LayoutInflater.from(this.hMI.getPageContext().getPageActivity()).inflate(d.h.write_url_activity_layout, (ViewGroup) null);
            this.hMI.setContentView(this.aHS);
            this.mNavigationBar = (NavigationBar) this.aHS.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.eXO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eXO.getLayoutParams();
                layoutParams.leftMargin = l.t(this.hMI.getActivity(), d.e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.eXO != null && (this.eXO.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eXO.getLayoutParams();
                layoutParams2.width = -2;
                this.eXO.setLayoutParams(layoutParams2);
            }
            this.aHS.setOnClickListener(this.mClickListener);
            this.hMJ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.j.send_post));
            aj.e(this.hMJ, d.C0141d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hMJ.getLayoutParams();
            layoutParams3.rightMargin = l.t(this.hMI.getActivity(), d.e.ds16);
            this.hMJ.setLayoutParams(layoutParams3);
            this.hMJ.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.j.post_new_thread));
            this.hMK = (TbImageView) this.aHS.findViewById(d.g.imageview_picture);
            this.hMK.setDefaultResource(d.f.ic_post_url_n);
            this.hMK.setDefaultErrorResource(d.f.ic_post_url_n);
            this.hMK.setDefaultBgResource(d.C0141d.black_alpha0);
            this.hMN = (LinearLayout) this.aHS.findViewById(d.g.view_picture_publish);
            this.hMN.setOnClickListener(this.mClickListener);
            this.gbJ = (RelativeLayout) this.aHS.findViewById(d.g.video_container);
            this.gbJ.setOnClickListener(this.mClickListener);
            this.fca = (TbImageView) this.aHS.findViewById(d.g.video_img_thumbnail);
            this.fca.setDefaultErrorResource(0);
            this.fca.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.fca.setDefaultBgResource(d.C0141d.black_alpha0);
            this.hMO = (ImageView) this.aHS.findViewById(d.g.video_img_play);
            this.hMP = this.aHS.findViewById(d.g.video_view_delete);
            this.hMP.setOnClickListener(this.mClickListener);
            this.hMQ = (TextView) this.aHS.findViewById(d.g.textview_title);
            this.hMR = (TextView) this.aHS.findViewById(d.g.textview_abstract);
            this.hMS = this.aHS.findViewById(d.g.view_delete);
            this.hMS.setOnClickListener(this.mClickListener);
            this.hMM = this.aHS.findViewById(d.g.icon_invoke_link);
            this.hMM.setOnClickListener(this.mClickListener);
            this.hML = (EditText) this.aHS.findViewById(d.g.post_content);
            this.hMT = (TextView) this.aHS.findViewById(d.g.textview_error_tip);
            this.hMU = (TextView) this.aHS.findViewById(d.g.textview_url);
            this.hMV = (LinearLayout) this.aHS.findViewById(d.g.url_edit_container);
            this.hMW = (EditText) this.aHS.findViewById(d.g.url_input);
            this.hNa = (TextView) this.aHS.findViewById(d.g.url_desc);
            this.hMX = this.aHS.findViewById(d.g.url_input_clear);
            this.hMY = (TextView) this.aHS.findViewById(d.g.url_add);
            this.hMY.setEnabled(false);
            this.hMZ = (FrameLayout) this.aHS.findViewById(d.g.url_edit_back_view);
            this.hMW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.j.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        j.this.hMX.setVisibility(8);
                        aj.r(j.this.hMY, d.C0141d.cp_cont_e);
                        j.this.hMY.setEnabled(false);
                        return;
                    }
                    j.this.hMX.setVisibility(0);
                    aj.r(j.this.hMY, d.C0141d.cp_link_tip_a);
                    j.this.hMY.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (j.this.hNa.getText().equals(j.this.hMI.getActivity().getString(d.j.tip_url_not_match))) {
                        j.this.bJn();
                    }
                }
            });
            this.hMX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.hMW.setText("");
                    j.this.hMX.setVisibility(8);
                    j.this.hMY.setEnabled(false);
                }
            });
            this.bCz = new com.baidu.tbadk.core.view.b(this.hMI.getPageContext());
            bJn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJn() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.hNa.setText(d.j.tip_url_post);
        } else {
            this.hNa.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        aj.r(this.hNa, d.C0141d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.hMI.setIsLoading(z);
        if (z) {
            this.hMN.setVisibility(0);
            this.gbJ.setVisibility(8);
            this.hMK.startLoad(null, 10, false);
            this.hMQ.setVisibility(8);
            this.hMR.setVisibility(8);
            this.hMT.setVisibility(8);
            this.hMU.setVisibility(0);
            aj.r(this.hMU, d.C0141d.cp_cont_f);
            this.hMU.setText(d.j.tip_url_loading);
        } else if (aVar == null) {
            this.hMN.setVisibility(8);
            this.gbJ.setVisibility(8);
            bJo();
        } else {
            if (aVar.hFZ == 1) {
                this.hMN.setVisibility(0);
                this.gbJ.setVisibility(8);
                if (aVar.hFY) {
                    this.hMK.startLoad(aVar.hGb, 10, false);
                    this.hMQ.setText(aVar.aMT);
                    this.hMR.setText(aVar.aMU);
                    if (am.es(aVar.aMT) > 30) {
                        this.hMQ.setMaxLines(2);
                        this.hMR.setMaxLines(1);
                    } else {
                        this.hMQ.setMaxLines(1);
                        this.hMR.setMaxLines(2);
                    }
                    this.hMQ.setVisibility(0);
                    this.hMR.setVisibility(0);
                    this.hMU.setVisibility(8);
                    this.hMT.setVisibility(8);
                } else {
                    this.hMK.reset();
                    this.hMU.setText(aVar.linkUrl);
                    aj.r(this.hMU, d.C0141d.cp_cont_b);
                    this.hMQ.setVisibility(8);
                    this.hMR.setVisibility(8);
                    this.hMU.setVisibility(0);
                    this.hMT.setVisibility(0);
                }
            } else if (aVar.hFZ == 2) {
                this.hMN.setVisibility(8);
                this.gbJ.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.gbJ.getLayoutParams();
                layoutParams.height = ((l.ao(this.hMI.getPageContext().getPageActivity()) - ((int) this.hMI.getPageContext().getPageActivity().getResources().getDimension(d.e.ds80))) * 9) / 16;
                this.gbJ.setLayoutParams(layoutParams);
                aj.c(this.hMO, d.f.icon_play_video);
                aj.s(this.hMP, d.f.btn_delete_url);
                this.fca.startLoad(aVar.hGe, 10, false);
            } else {
                this.hMN.setVisibility(0);
                this.gbJ.setVisibility(8);
                this.hMQ.setVisibility(8);
                this.hMR.setVisibility(8);
                this.hMU.setVisibility(0);
                this.hMT.setVisibility(0);
                this.hMK.reset();
                this.hMU.setText(aVar.linkUrl);
                aj.r(this.hMU, d.C0141d.cp_cont_b);
            }
            bJo();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.hML.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.hMI != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hMI.getPageContext(), i);
            }
            aj.t(this.mNavigationBar, d.C0141d.cp_bg_line_d);
            aj.t(this.aHS, d.C0141d.cp_bg_line_d);
            this.hML.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
            this.hML.setTextColor(aj.getColor(d.C0141d.cp_cont_f));
            aj.t(this.hMN, d.C0141d.cp_bg_line_e);
            aj.r(this.hMQ, d.C0141d.cp_cont_b);
            aj.r(this.hMR, d.C0141d.cp_cont_d);
            aj.r(this.hMU, d.C0141d.cp_cont_b);
            aj.t(this.hMT, d.C0141d.cp_bg_line_d);
            aj.r(this.hMT, d.C0141d.cp_cont_d);
            aj.s(this.hMM, d.f.bg_link_invoke);
            aj.t(this.hMV, d.C0141d.cp_bg_line_d);
            this.hMW.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
            aj.r(this.hMW, d.C0141d.cp_cont_b);
            aj.r(this.hNa, d.C0141d.cp_cont_d);
            aj.r(this.hMY, d.C0141d.cp_cont_e);
            aj.c(this.hMO, d.f.home_ic_video);
            aj.s(this.hMS, d.f.btn_delete_url);
            aj.s(this.hMX, d.f.btn_delete_url);
            aj.s(this.hMP, d.f.btn_delete_url);
            bJo();
        }
    }

    public void bJo() {
        boolean z;
        if (StringUtils.isNull(bJp())) {
            z = this.hMN.getVisibility() == 0 || this.gbJ.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            aj.d(this.hMJ, d.C0141d.cp_link_tip_a, d.C0141d.s_navbar_title_color);
            this.hMJ.setEnabled(true);
            return;
        }
        aj.e(this.hMJ, d.C0141d.cp_cont_d, 1);
        this.hMJ.setEnabled(false);
    }

    public String bJp() {
        if (this.hML == null || this.hML.getText() == null) {
            return null;
        }
        return this.hML.getText().toString();
    }

    public View aLN() {
        return this.eXO;
    }

    public View bJq() {
        return this.hMJ;
    }

    public View getRootView() {
        return this.aHS;
    }

    public EditText bJr() {
        return this.hML;
    }

    public View bJs() {
        return this.hMS;
    }

    public View bJt() {
        return this.hMP;
    }

    public View bJu() {
        return this.hMN;
    }

    public View getVideoContainer() {
        return this.gbJ;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.hMW.setText(aVar.linkUrl);
            this.hMW.setSelection(aVar.linkUrl.length());
        }
        this.hMW.requestFocus();
        l.b(this.hMI.getActivity(), this.hMW);
        this.hMV.setVisibility(0);
        this.hMZ.setVisibility(0);
        this.hMM.setVisibility(8);
    }

    public void bJv() {
        this.hMV.setVisibility(8);
        this.hMZ.setVisibility(8);
        this.hMM.setVisibility(0);
        l.a(this.hMI.getActivity(), this.hMW);
    }

    public void U(View.OnClickListener onClickListener) {
        this.hMV.setOnClickListener(onClickListener);
        this.hMZ.setOnClickListener(onClickListener);
        this.hMM.setOnClickListener(onClickListener);
    }

    public String bJw() {
        if (this.hMW == null || this.hMW.getText() == null) {
            return null;
        }
        return this.hMW.getText().toString();
    }

    public void bJx() {
        if (this.hNa != null) {
            this.hNa.setText(d.j.tip_url_not_match);
            aj.r(this.hNa, d.C0141d.cp_other_b);
        }
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.hMY != null) {
            this.hMY.setOnClickListener(onClickListener);
        }
    }

    public View bJy() {
        return this.hMV;
    }

    public void destroy() {
        if (this.hML != null) {
            this.hML.addTextChangedListener(null);
        }
        if (this.hMW != null) {
            this.hMW.addTextChangedListener(null);
        }
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.vR(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ar(this.hMI.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.hMI.getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                this.hMI.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.bCz.d(null);
        this.bCz.ga(d.j.sending);
        this.bCz.bq(true);
    }

    public void closeLoadingDialog() {
        this.bCz.bq(false);
    }
}
