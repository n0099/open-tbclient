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
    private View aGH;
    private com.baidu.tbadk.core.view.b bAA;
    private View eSi;
    private TbImageView eWC;
    private RelativeLayout fYs;
    private WriteUrlActivity hLc;
    private TextView hLd;
    private TbImageView hLe;
    private EditText hLf;
    private View hLg;
    private LinearLayout hLh;
    private ImageView hLi;
    private View hLj;
    private TextView hLk;
    private TextView hLl;
    private View hLm;
    private TextView hLn;
    private TextView hLo;
    private LinearLayout hLp;
    private EditText hLq;
    private View hLr;
    private TextView hLs;
    private FrameLayout hLt;
    private TextView hLu;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public j(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.eSi = null;
        this.bAA = null;
        if (writeUrlActivity != null) {
            this.hLc = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.aGH = LayoutInflater.from(this.hLc.getPageContext().getPageActivity()).inflate(d.h.write_url_activity_layout, (ViewGroup) null);
            this.hLc.setContentView(this.aGH);
            this.mNavigationBar = (NavigationBar) this.aGH.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.eSi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eSi.getLayoutParams();
                layoutParams.leftMargin = l.s(this.hLc.getActivity(), d.e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.eSi != null && (this.eSi.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eSi.getLayoutParams();
                layoutParams2.width = -2;
                this.eSi.setLayoutParams(layoutParams2);
            }
            this.aGH.setOnClickListener(this.mClickListener);
            this.hLd = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.j.send_post));
            aj.e(this.hLd, d.C0107d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hLd.getLayoutParams();
            layoutParams3.rightMargin = l.s(this.hLc.getActivity(), d.e.ds16);
            this.hLd.setLayoutParams(layoutParams3);
            this.hLd.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.j.post_new_thread));
            this.hLe = (TbImageView) this.aGH.findViewById(d.g.imageview_picture);
            this.hLe.setDefaultResource(d.f.ic_post_url_n);
            this.hLe.setDefaultErrorResource(d.f.ic_post_url_n);
            this.hLe.setDefaultBgResource(d.C0107d.black_alpha0);
            this.hLh = (LinearLayout) this.aGH.findViewById(d.g.view_picture_publish);
            this.hLh.setOnClickListener(this.mClickListener);
            this.fYs = (RelativeLayout) this.aGH.findViewById(d.g.video_container);
            this.fYs.setOnClickListener(this.mClickListener);
            this.eWC = (TbImageView) this.aGH.findViewById(d.g.video_img_thumbnail);
            this.eWC.setDefaultErrorResource(0);
            this.eWC.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.eWC.setDefaultBgResource(d.C0107d.black_alpha0);
            this.hLi = (ImageView) this.aGH.findViewById(d.g.video_img_play);
            this.hLj = this.aGH.findViewById(d.g.video_view_delete);
            this.hLj.setOnClickListener(this.mClickListener);
            this.hLk = (TextView) this.aGH.findViewById(d.g.textview_title);
            this.hLl = (TextView) this.aGH.findViewById(d.g.textview_abstract);
            this.hLm = this.aGH.findViewById(d.g.view_delete);
            this.hLm.setOnClickListener(this.mClickListener);
            this.hLg = this.aGH.findViewById(d.g.icon_invoke_link);
            this.hLg.setOnClickListener(this.mClickListener);
            this.hLf = (EditText) this.aGH.findViewById(d.g.post_content);
            this.hLn = (TextView) this.aGH.findViewById(d.g.textview_error_tip);
            this.hLo = (TextView) this.aGH.findViewById(d.g.textview_url);
            this.hLp = (LinearLayout) this.aGH.findViewById(d.g.url_edit_container);
            this.hLq = (EditText) this.aGH.findViewById(d.g.url_input);
            this.hLu = (TextView) this.aGH.findViewById(d.g.url_desc);
            this.hLr = this.aGH.findViewById(d.g.url_input_clear);
            this.hLs = (TextView) this.aGH.findViewById(d.g.url_add);
            this.hLs.setEnabled(false);
            this.hLt = (FrameLayout) this.aGH.findViewById(d.g.url_edit_back_view);
            this.hLq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.j.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        j.this.hLr.setVisibility(8);
                        aj.r(j.this.hLs, d.C0107d.cp_cont_e);
                        j.this.hLs.setEnabled(false);
                        return;
                    }
                    j.this.hLr.setVisibility(0);
                    aj.r(j.this.hLs, d.C0107d.cp_link_tip_a);
                    j.this.hLs.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (j.this.hLu.getText().equals(j.this.hLc.getActivity().getString(d.j.tip_url_not_match))) {
                        j.this.bIz();
                    }
                }
            });
            this.hLr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.hLq.setText("");
                    j.this.hLr.setVisibility(8);
                    j.this.hLs.setEnabled(false);
                }
            });
            this.bAA = new com.baidu.tbadk.core.view.b(this.hLc.getPageContext());
            bIz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIz() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.hLu.setText(d.j.tip_url_post);
        } else {
            this.hLu.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        aj.r(this.hLu, d.C0107d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.hLc.setIsLoading(z);
        if (z) {
            this.hLh.setVisibility(0);
            this.fYs.setVisibility(8);
            this.hLe.startLoad(null, 10, false);
            this.hLk.setVisibility(8);
            this.hLl.setVisibility(8);
            this.hLn.setVisibility(8);
            this.hLo.setVisibility(0);
            aj.r(this.hLo, d.C0107d.cp_cont_f);
            this.hLo.setText(d.j.tip_url_loading);
        } else if (aVar == null) {
            this.hLh.setVisibility(8);
            this.fYs.setVisibility(8);
            bIA();
        } else {
            if (aVar.hEu == 1) {
                this.hLh.setVisibility(0);
                this.fYs.setVisibility(8);
                if (aVar.hEt) {
                    this.hLe.startLoad(aVar.hEw, 10, false);
                    this.hLk.setText(aVar.aLI);
                    this.hLl.setText(aVar.aLJ);
                    if (am.ec(aVar.aLI) > 30) {
                        this.hLk.setMaxLines(2);
                        this.hLl.setMaxLines(1);
                    } else {
                        this.hLk.setMaxLines(1);
                        this.hLl.setMaxLines(2);
                    }
                    this.hLk.setVisibility(0);
                    this.hLl.setVisibility(0);
                    this.hLo.setVisibility(8);
                    this.hLn.setVisibility(8);
                } else {
                    this.hLe.reset();
                    this.hLo.setText(aVar.linkUrl);
                    aj.r(this.hLo, d.C0107d.cp_cont_b);
                    this.hLk.setVisibility(8);
                    this.hLl.setVisibility(8);
                    this.hLo.setVisibility(0);
                    this.hLn.setVisibility(0);
                }
            } else if (aVar.hEu == 2) {
                this.hLh.setVisibility(8);
                this.fYs.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.fYs.getLayoutParams();
                layoutParams.height = ((l.ao(this.hLc.getPageContext().getPageActivity()) - ((int) this.hLc.getPageContext().getPageActivity().getResources().getDimension(d.e.ds80))) * 9) / 16;
                this.fYs.setLayoutParams(layoutParams);
                aj.c(this.hLi, d.f.icon_play_video);
                aj.s(this.hLj, d.f.btn_delete_url);
                this.eWC.startLoad(aVar.hEz, 10, false);
            } else {
                this.hLh.setVisibility(0);
                this.fYs.setVisibility(8);
                this.hLk.setVisibility(8);
                this.hLl.setVisibility(8);
                this.hLo.setVisibility(0);
                this.hLn.setVisibility(0);
                this.hLe.reset();
                this.hLo.setText(aVar.linkUrl);
                aj.r(this.hLo, d.C0107d.cp_cont_b);
            }
            bIA();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.hLf.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.hLc != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hLc.getPageContext(), i);
            }
            aj.t(this.mNavigationBar, d.C0107d.cp_bg_line_d);
            aj.t(this.aGH, d.C0107d.cp_bg_line_d);
            this.hLf.setHintTextColor(aj.getColor(d.C0107d.cp_cont_e));
            this.hLf.setTextColor(aj.getColor(d.C0107d.cp_cont_f));
            aj.t(this.hLh, d.C0107d.cp_bg_line_e);
            aj.r(this.hLk, d.C0107d.cp_cont_b);
            aj.r(this.hLl, d.C0107d.cp_cont_d);
            aj.r(this.hLo, d.C0107d.cp_cont_b);
            aj.t(this.hLn, d.C0107d.cp_bg_line_d);
            aj.r(this.hLn, d.C0107d.cp_cont_d);
            aj.s(this.hLg, d.f.bg_link_invoke);
            aj.t(this.hLp, d.C0107d.cp_bg_line_d);
            this.hLq.setHintTextColor(aj.getColor(d.C0107d.cp_cont_e));
            aj.r(this.hLq, d.C0107d.cp_cont_b);
            aj.r(this.hLu, d.C0107d.cp_cont_d);
            aj.r(this.hLs, d.C0107d.cp_cont_e);
            aj.c(this.hLi, d.f.home_ic_video);
            aj.s(this.hLm, d.f.btn_delete_url);
            aj.s(this.hLr, d.f.btn_delete_url);
            aj.s(this.hLj, d.f.btn_delete_url);
            bIA();
        }
    }

    public void bIA() {
        boolean z;
        if (StringUtils.isNull(bIB())) {
            z = this.hLh.getVisibility() == 0 || this.fYs.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            aj.d(this.hLd, d.C0107d.cp_link_tip_a, d.C0107d.s_navbar_title_color);
            this.hLd.setEnabled(true);
            return;
        }
        aj.e(this.hLd, d.C0107d.cp_cont_d, 1);
        this.hLd.setEnabled(false);
    }

    public String bIB() {
        if (this.hLf == null || this.hLf.getText() == null) {
            return null;
        }
        return this.hLf.getText().toString();
    }

    public View aKh() {
        return this.eSi;
    }

    public View bIC() {
        return this.hLd;
    }

    public View getRootView() {
        return this.aGH;
    }

    public EditText bID() {
        return this.hLf;
    }

    public View bIE() {
        return this.hLm;
    }

    public View bIF() {
        return this.hLj;
    }

    public View bIG() {
        return this.hLh;
    }

    public View getVideoContainer() {
        return this.fYs;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.hLq.setText(aVar.linkUrl);
            this.hLq.setSelection(aVar.linkUrl.length());
        }
        this.hLq.requestFocus();
        l.b(this.hLc.getActivity(), this.hLq);
        this.hLp.setVisibility(0);
        this.hLt.setVisibility(0);
        this.hLg.setVisibility(8);
    }

    public void bIH() {
        this.hLp.setVisibility(8);
        this.hLt.setVisibility(8);
        this.hLg.setVisibility(0);
        l.a(this.hLc.getActivity(), this.hLq);
    }

    public void U(View.OnClickListener onClickListener) {
        this.hLp.setOnClickListener(onClickListener);
        this.hLt.setOnClickListener(onClickListener);
        this.hLg.setOnClickListener(onClickListener);
    }

    public String bII() {
        if (this.hLq == null || this.hLq.getText() == null) {
            return null;
        }
        return this.hLq.getText().toString();
    }

    public void bIJ() {
        if (this.hLu != null) {
            this.hLu.setText(d.j.tip_url_not_match);
            aj.r(this.hLu, d.C0107d.cp_other_b);
        }
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.hLs != null) {
            this.hLs.setOnClickListener(onClickListener);
        }
    }

    public View bIK() {
        return this.hLp;
    }

    public void destroy() {
        if (this.hLf != null) {
            this.hLf.addTextChangedListener(null);
        }
        if (this.hLq != null) {
            this.hLq.addTextChangedListener(null);
        }
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.vQ(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ao(this.hLc.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.hLc.getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                this.hLc.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.bAA.c(null);
        this.bAA.fY(d.j.sending);
        this.bAA.bm(true);
    }

    public void closeLoadingDialog() {
        this.bAA.bm(false);
    }
}
