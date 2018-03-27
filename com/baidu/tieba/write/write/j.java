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
    private View aHT;
    private com.baidu.tbadk.core.view.b bCC;
    private View eYc;
    private TbImageView fco;
    private RelativeLayout gbZ;
    private WriteUrlActivity hNg;
    private TextView hNh;
    private TbImageView hNi;
    private EditText hNj;
    private View hNk;
    private LinearLayout hNl;
    private ImageView hNm;
    private View hNn;
    private TextView hNo;
    private TextView hNp;
    private View hNq;
    private TextView hNr;
    private TextView hNs;
    private LinearLayout hNt;
    private EditText hNu;
    private View hNv;
    private TextView hNw;
    private FrameLayout hNx;
    private TextView hNy;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public j(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.eYc = null;
        this.bCC = null;
        if (writeUrlActivity != null) {
            this.hNg = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.aHT = LayoutInflater.from(this.hNg.getPageContext().getPageActivity()).inflate(d.h.write_url_activity_layout, (ViewGroup) null);
            this.hNg.setContentView(this.aHT);
            this.mNavigationBar = (NavigationBar) this.aHT.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.eYc = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eYc.getLayoutParams();
                layoutParams.leftMargin = l.t(this.hNg.getActivity(), d.e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.eYc != null && (this.eYc.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eYc.getLayoutParams();
                layoutParams2.width = -2;
                this.eYc.setLayoutParams(layoutParams2);
            }
            this.aHT.setOnClickListener(this.mClickListener);
            this.hNh = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.j.send_post));
            aj.e(this.hNh, d.C0141d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hNh.getLayoutParams();
            layoutParams3.rightMargin = l.t(this.hNg.getActivity(), d.e.ds16);
            this.hNh.setLayoutParams(layoutParams3);
            this.hNh.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.j.post_new_thread));
            this.hNi = (TbImageView) this.aHT.findViewById(d.g.imageview_picture);
            this.hNi.setDefaultResource(d.f.ic_post_url_n);
            this.hNi.setDefaultErrorResource(d.f.ic_post_url_n);
            this.hNi.setDefaultBgResource(d.C0141d.black_alpha0);
            this.hNl = (LinearLayout) this.aHT.findViewById(d.g.view_picture_publish);
            this.hNl.setOnClickListener(this.mClickListener);
            this.gbZ = (RelativeLayout) this.aHT.findViewById(d.g.video_container);
            this.gbZ.setOnClickListener(this.mClickListener);
            this.fco = (TbImageView) this.aHT.findViewById(d.g.video_img_thumbnail);
            this.fco.setDefaultErrorResource(0);
            this.fco.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.fco.setDefaultBgResource(d.C0141d.black_alpha0);
            this.hNm = (ImageView) this.aHT.findViewById(d.g.video_img_play);
            this.hNn = this.aHT.findViewById(d.g.video_view_delete);
            this.hNn.setOnClickListener(this.mClickListener);
            this.hNo = (TextView) this.aHT.findViewById(d.g.textview_title);
            this.hNp = (TextView) this.aHT.findViewById(d.g.textview_abstract);
            this.hNq = this.aHT.findViewById(d.g.view_delete);
            this.hNq.setOnClickListener(this.mClickListener);
            this.hNk = this.aHT.findViewById(d.g.icon_invoke_link);
            this.hNk.setOnClickListener(this.mClickListener);
            this.hNj = (EditText) this.aHT.findViewById(d.g.post_content);
            this.hNr = (TextView) this.aHT.findViewById(d.g.textview_error_tip);
            this.hNs = (TextView) this.aHT.findViewById(d.g.textview_url);
            this.hNt = (LinearLayout) this.aHT.findViewById(d.g.url_edit_container);
            this.hNu = (EditText) this.aHT.findViewById(d.g.url_input);
            this.hNy = (TextView) this.aHT.findViewById(d.g.url_desc);
            this.hNv = this.aHT.findViewById(d.g.url_input_clear);
            this.hNw = (TextView) this.aHT.findViewById(d.g.url_add);
            this.hNw.setEnabled(false);
            this.hNx = (FrameLayout) this.aHT.findViewById(d.g.url_edit_back_view);
            this.hNu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.j.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        j.this.hNv.setVisibility(8);
                        aj.r(j.this.hNw, d.C0141d.cp_cont_e);
                        j.this.hNw.setEnabled(false);
                        return;
                    }
                    j.this.hNv.setVisibility(0);
                    aj.r(j.this.hNw, d.C0141d.cp_link_tip_a);
                    j.this.hNw.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (j.this.hNy.getText().equals(j.this.hNg.getActivity().getString(d.j.tip_url_not_match))) {
                        j.this.bJs();
                    }
                }
            });
            this.hNv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.hNu.setText("");
                    j.this.hNv.setVisibility(8);
                    j.this.hNw.setEnabled(false);
                }
            });
            this.bCC = new com.baidu.tbadk.core.view.b(this.hNg.getPageContext());
            bJs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJs() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.hNy.setText(d.j.tip_url_post);
        } else {
            this.hNy.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        aj.r(this.hNy, d.C0141d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.hNg.setIsLoading(z);
        if (z) {
            this.hNl.setVisibility(0);
            this.gbZ.setVisibility(8);
            this.hNi.startLoad(null, 10, false);
            this.hNo.setVisibility(8);
            this.hNp.setVisibility(8);
            this.hNr.setVisibility(8);
            this.hNs.setVisibility(0);
            aj.r(this.hNs, d.C0141d.cp_cont_f);
            this.hNs.setText(d.j.tip_url_loading);
        } else if (aVar == null) {
            this.hNl.setVisibility(8);
            this.gbZ.setVisibility(8);
            bJt();
        } else {
            if (aVar.hGx == 1) {
                this.hNl.setVisibility(0);
                this.gbZ.setVisibility(8);
                if (aVar.hGw) {
                    this.hNi.startLoad(aVar.hGz, 10, false);
                    this.hNo.setText(aVar.aMU);
                    this.hNp.setText(aVar.aMV);
                    if (am.es(aVar.aMU) > 30) {
                        this.hNo.setMaxLines(2);
                        this.hNp.setMaxLines(1);
                    } else {
                        this.hNo.setMaxLines(1);
                        this.hNp.setMaxLines(2);
                    }
                    this.hNo.setVisibility(0);
                    this.hNp.setVisibility(0);
                    this.hNs.setVisibility(8);
                    this.hNr.setVisibility(8);
                } else {
                    this.hNi.reset();
                    this.hNs.setText(aVar.linkUrl);
                    aj.r(this.hNs, d.C0141d.cp_cont_b);
                    this.hNo.setVisibility(8);
                    this.hNp.setVisibility(8);
                    this.hNs.setVisibility(0);
                    this.hNr.setVisibility(0);
                }
            } else if (aVar.hGx == 2) {
                this.hNl.setVisibility(8);
                this.gbZ.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.gbZ.getLayoutParams();
                layoutParams.height = ((l.ao(this.hNg.getPageContext().getPageActivity()) - ((int) this.hNg.getPageContext().getPageActivity().getResources().getDimension(d.e.ds80))) * 9) / 16;
                this.gbZ.setLayoutParams(layoutParams);
                aj.c(this.hNm, d.f.icon_play_video);
                aj.s(this.hNn, d.f.btn_delete_url);
                this.fco.startLoad(aVar.hGC, 10, false);
            } else {
                this.hNl.setVisibility(0);
                this.gbZ.setVisibility(8);
                this.hNo.setVisibility(8);
                this.hNp.setVisibility(8);
                this.hNs.setVisibility(0);
                this.hNr.setVisibility(0);
                this.hNi.reset();
                this.hNs.setText(aVar.linkUrl);
                aj.r(this.hNs, d.C0141d.cp_cont_b);
            }
            bJt();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.hNj.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.hNg != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hNg.getPageContext(), i);
            }
            aj.t(this.mNavigationBar, d.C0141d.cp_bg_line_d);
            aj.t(this.aHT, d.C0141d.cp_bg_line_d);
            this.hNj.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
            this.hNj.setTextColor(aj.getColor(d.C0141d.cp_cont_f));
            aj.t(this.hNl, d.C0141d.cp_bg_line_e);
            aj.r(this.hNo, d.C0141d.cp_cont_b);
            aj.r(this.hNp, d.C0141d.cp_cont_d);
            aj.r(this.hNs, d.C0141d.cp_cont_b);
            aj.t(this.hNr, d.C0141d.cp_bg_line_d);
            aj.r(this.hNr, d.C0141d.cp_cont_d);
            aj.s(this.hNk, d.f.bg_link_invoke);
            aj.t(this.hNt, d.C0141d.cp_bg_line_d);
            this.hNu.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
            aj.r(this.hNu, d.C0141d.cp_cont_b);
            aj.r(this.hNy, d.C0141d.cp_cont_d);
            aj.r(this.hNw, d.C0141d.cp_cont_e);
            aj.c(this.hNm, d.f.home_ic_video);
            aj.s(this.hNq, d.f.btn_delete_url);
            aj.s(this.hNv, d.f.btn_delete_url);
            aj.s(this.hNn, d.f.btn_delete_url);
            bJt();
        }
    }

    public void bJt() {
        boolean z;
        if (StringUtils.isNull(bJu())) {
            z = this.hNl.getVisibility() == 0 || this.gbZ.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            aj.d(this.hNh, d.C0141d.cp_link_tip_a, d.C0141d.s_navbar_title_color);
            this.hNh.setEnabled(true);
            return;
        }
        aj.e(this.hNh, d.C0141d.cp_cont_d, 1);
        this.hNh.setEnabled(false);
    }

    public String bJu() {
        if (this.hNj == null || this.hNj.getText() == null) {
            return null;
        }
        return this.hNj.getText().toString();
    }

    public View aLO() {
        return this.eYc;
    }

    public View bJv() {
        return this.hNh;
    }

    public View getRootView() {
        return this.aHT;
    }

    public EditText bJw() {
        return this.hNj;
    }

    public View bJx() {
        return this.hNq;
    }

    public View bJy() {
        return this.hNn;
    }

    public View bJz() {
        return this.hNl;
    }

    public View getVideoContainer() {
        return this.gbZ;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.hNu.setText(aVar.linkUrl);
            this.hNu.setSelection(aVar.linkUrl.length());
        }
        this.hNu.requestFocus();
        l.b(this.hNg.getActivity(), this.hNu);
        this.hNt.setVisibility(0);
        this.hNx.setVisibility(0);
        this.hNk.setVisibility(8);
    }

    public void bJA() {
        this.hNt.setVisibility(8);
        this.hNx.setVisibility(8);
        this.hNk.setVisibility(0);
        l.a(this.hNg.getActivity(), this.hNu);
    }

    public void U(View.OnClickListener onClickListener) {
        this.hNt.setOnClickListener(onClickListener);
        this.hNx.setOnClickListener(onClickListener);
        this.hNk.setOnClickListener(onClickListener);
    }

    public String bJB() {
        if (this.hNu == null || this.hNu.getText() == null) {
            return null;
        }
        return this.hNu.getText().toString();
    }

    public void bJC() {
        if (this.hNy != null) {
            this.hNy.setText(d.j.tip_url_not_match);
            aj.r(this.hNy, d.C0141d.cp_other_b);
        }
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.hNw != null) {
            this.hNw.setOnClickListener(onClickListener);
        }
    }

    public View bJD() {
        return this.hNt;
    }

    public void destroy() {
        if (this.hNj != null) {
            this.hNj.addTextChangedListener(null);
        }
        if (this.hNu != null) {
            this.hNu.addTextChangedListener(null);
        }
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.vR(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ar(this.hNg.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.hNg.getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                this.hNg.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.bCC.d(null);
        this.bCC.ga(d.j.sending);
        this.bCC.bq(true);
    }

    public void closeLoadingDialog() {
        this.bCC.bq(false);
    }
}
