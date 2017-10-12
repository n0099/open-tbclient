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
public class d {
    private View Rt;
    private com.baidu.tbadk.core.view.a aLr;
    private View.OnClickListener aPe;
    private View dLB;
    private TbImageView dUt;
    private RelativeLayout eTl;
    private WriteUrlActivity gOe;
    private TextView gOf;
    private TbImageView gOg;
    private EditText gOh;
    private View gOi;
    private LinearLayout gOj;
    private ImageView gOk;
    private View gOl;
    private TextView gOm;
    private TextView gOn;
    private View gOo;
    private TextView gOp;
    private TextView gOq;
    private LinearLayout gOr;
    private EditText gOs;
    private View gOt;
    private TextView gOu;
    private FrameLayout gOv;
    private TextView gOw;
    private NavigationBar mNavigationBar;

    public d(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.dLB = null;
        this.aLr = null;
        if (writeUrlActivity != null) {
            this.gOe = writeUrlActivity;
            this.aPe = onClickListener;
            this.Rt = LayoutInflater.from(this.gOe.getPageContext().getPageActivity()).inflate(d.j.write_url_activity_layout, (ViewGroup) null);
            this.gOe.setContentView(this.Rt);
            this.mNavigationBar = (NavigationBar) this.Rt.findViewById(d.h.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.dLB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aPe);
            this.mNavigationBar.setmBackImageViewBg(d.g.write_close_selector, d.g.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dLB.getLayoutParams();
                layoutParams.leftMargin = l.f(this.gOe.getActivity(), d.f.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.dLB != null && (this.dLB.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dLB.getLayoutParams();
                layoutParams2.width = -2;
                this.dLB.setLayoutParams(layoutParams2);
            }
            this.Rt.setOnClickListener(this.aPe);
            this.gOf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.l.send_post));
            aj.c(this.gOf, d.e.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.gOf.getLayoutParams();
            layoutParams3.rightMargin = l.f(this.gOe.getActivity(), d.f.ds16);
            this.gOf.setLayoutParams(layoutParams3);
            this.gOf.setOnClickListener(this.aPe);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.l.post_new_thread));
            this.gOg = (TbImageView) this.Rt.findViewById(d.h.imageview_picture);
            this.gOg.setDefaultResource(d.g.ic_post_url_n);
            this.gOg.setDefaultErrorResource(d.g.ic_post_url_n);
            this.gOg.setDefaultBgResource(d.e.black_alpha0);
            this.gOj = (LinearLayout) this.Rt.findViewById(d.h.view_picture_publish);
            this.gOj.setOnClickListener(this.aPe);
            this.eTl = (RelativeLayout) this.Rt.findViewById(d.h.video_container);
            this.eTl.setOnClickListener(this.aPe);
            this.dUt = (TbImageView) this.Rt.findViewById(d.h.video_img_thumbnail);
            this.dUt.setDefaultErrorResource(0);
            this.dUt.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.dUt.setDefaultBgResource(d.e.black_alpha0);
            this.gOk = (ImageView) this.Rt.findViewById(d.h.video_img_play);
            this.gOl = this.Rt.findViewById(d.h.video_view_delete);
            this.gOl.setOnClickListener(this.aPe);
            this.gOm = (TextView) this.Rt.findViewById(d.h.textview_title);
            this.gOn = (TextView) this.Rt.findViewById(d.h.textview_abstract);
            this.gOo = this.Rt.findViewById(d.h.view_delete);
            this.gOo.setOnClickListener(this.aPe);
            this.gOi = this.Rt.findViewById(d.h.icon_invoke_link);
            this.gOi.setOnClickListener(this.aPe);
            this.gOh = (EditText) this.Rt.findViewById(d.h.post_content);
            this.gOh.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.d.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    d.this.bBV();
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }
            });
            this.gOp = (TextView) this.Rt.findViewById(d.h.textview_error_tip);
            this.gOq = (TextView) this.Rt.findViewById(d.h.textview_url);
            this.gOr = (LinearLayout) this.Rt.findViewById(d.h.url_edit_container);
            this.gOs = (EditText) this.Rt.findViewById(d.h.url_input);
            this.gOw = (TextView) this.Rt.findViewById(d.h.url_desc);
            this.gOt = this.Rt.findViewById(d.h.url_input_clear);
            this.gOu = (TextView) this.Rt.findViewById(d.h.url_add);
            this.gOu.setEnabled(false);
            this.gOv = (FrameLayout) this.Rt.findViewById(d.h.url_edit_back_view);
            this.gOs.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.d.2
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        d.this.gOt.setVisibility(8);
                        aj.i(d.this.gOu, d.e.cp_cont_e);
                        d.this.gOu.setEnabled(false);
                        return;
                    }
                    d.this.gOt.setVisibility(0);
                    aj.i(d.this.gOu, d.e.cp_link_tip_a);
                    d.this.gOu.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (d.this.gOw.getText().equals(d.this.gOe.getActivity().getString(d.l.tip_url_not_match))) {
                        d.this.bBU();
                    }
                }
            });
            this.gOt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.gOs.setText("");
                    d.this.gOt.setVisibility(8);
                    d.this.gOu.setEnabled(false);
                }
            });
            this.aLr = new com.baidu.tbadk.core.view.a(this.gOe.getPageContext());
            bBU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBU() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.gOw.setText(d.l.tip_url_post);
        } else {
            this.gOw.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        aj.i(this.gOw, d.e.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.gOe.setIsLoading(z);
        if (z) {
            this.gOj.setVisibility(0);
            this.eTl.setVisibility(8);
            this.gOg.c(null, 10, false);
            this.gOm.setVisibility(8);
            this.gOn.setVisibility(8);
            this.gOp.setVisibility(8);
            this.gOq.setVisibility(0);
            aj.i(this.gOq, d.e.cp_cont_f);
            this.gOq.setText(d.l.tip_url_loading);
        } else if (aVar == null) {
            this.gOj.setVisibility(8);
            this.eTl.setVisibility(8);
            bBV();
        } else {
            if (aVar.gIo == 1) {
                this.gOj.setVisibility(0);
                this.eTl.setVisibility(8);
                if (aVar.gIn) {
                    this.gOg.c(aVar.gIq, 10, false);
                    this.gOm.setText(aVar.WT);
                    this.gOn.setText(aVar.WU);
                    if (am.dO(aVar.WT) > 30) {
                        this.gOm.setMaxLines(2);
                        this.gOn.setMaxLines(1);
                    } else {
                        this.gOm.setMaxLines(1);
                        this.gOn.setMaxLines(2);
                    }
                    this.gOm.setVisibility(0);
                    this.gOn.setVisibility(0);
                    this.gOq.setVisibility(8);
                    this.gOp.setVisibility(8);
                } else {
                    this.gOg.reset();
                    this.gOq.setText(aVar.linkUrl);
                    aj.i(this.gOq, d.e.cp_cont_b);
                    this.gOm.setVisibility(8);
                    this.gOn.setVisibility(8);
                    this.gOq.setVisibility(0);
                    this.gOp.setVisibility(0);
                }
            } else if (aVar.gIo == 2) {
                this.gOj.setVisibility(8);
                this.eTl.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.eTl.getLayoutParams();
                layoutParams.height = ((l.ad(this.gOe.getPageContext().getPageActivity()) - ((int) this.gOe.getPageContext().getPageActivity().getResources().getDimension(d.f.ds80))) * 9) / 16;
                this.eTl.setLayoutParams(layoutParams);
                aj.c(this.gOk, d.g.icon_play_video);
                aj.j(this.gOl, d.g.btn_delete_url);
                this.dUt.c(aVar.gIt, 10, false);
            } else {
                this.gOj.setVisibility(0);
                this.eTl.setVisibility(8);
                this.gOm.setVisibility(8);
                this.gOn.setVisibility(8);
                this.gOq.setVisibility(0);
                this.gOp.setVisibility(0);
                this.gOg.reset();
                this.gOq.setText(aVar.linkUrl);
                aj.i(this.gOq, d.e.cp_cont_b);
            }
            bBV();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gOe != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.gOe.getPageContext(), i);
            }
            aj.k(this.mNavigationBar, d.e.cp_bg_line_d);
            aj.k(this.Rt, d.e.cp_bg_line_d);
            this.gOh.setHintTextColor(aj.getColor(d.e.cp_cont_e));
            this.gOh.setTextColor(aj.getColor(d.e.cp_cont_f));
            aj.k(this.gOj, d.e.cp_bg_line_e);
            aj.i(this.gOm, d.e.cp_cont_b);
            aj.i(this.gOn, d.e.cp_cont_d);
            aj.i(this.gOq, d.e.cp_cont_b);
            aj.k(this.gOp, d.e.cp_bg_line_d);
            aj.i(this.gOp, d.e.cp_cont_d);
            aj.j(this.gOi, d.g.bg_link_invoke);
            aj.k(this.gOr, d.e.cp_bg_line_d);
            this.gOs.setHintTextColor(aj.getColor(d.e.cp_cont_e));
            aj.i(this.gOs, d.e.cp_cont_b);
            aj.i(this.gOw, d.e.cp_cont_d);
            aj.i(this.gOu, d.e.cp_cont_e);
            aj.c(this.gOk, d.g.home_ic_video);
            aj.j(this.gOo, d.g.btn_delete_url);
            aj.j(this.gOt, d.g.btn_delete_url);
            aj.j(this.gOl, d.g.btn_delete_url);
            bBV();
        }
    }

    public void bBV() {
        boolean z;
        if (StringUtils.isNull(bBW())) {
            z = this.gOj.getVisibility() == 0 || this.eTl.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            aj.b(this.gOf, d.e.cp_link_tip_a, d.e.s_navbar_title_color);
            this.gOf.setEnabled(true);
            return;
        }
        aj.c(this.gOf, d.e.cp_cont_d, 1);
        this.gOf.setEnabled(false);
    }

    public String bBW() {
        if (this.gOh == null || this.gOh.getText() == null) {
            return null;
        }
        return this.gOh.getText().toString();
    }

    public View ayX() {
        return this.dLB;
    }

    public View bBX() {
        return this.gOf;
    }

    public View getRootView() {
        return this.Rt;
    }

    public View bBY() {
        return this.gOh;
    }

    public View bnV() {
        return this.gOo;
    }

    public View bBZ() {
        return this.gOl;
    }

    public View bCa() {
        return this.gOj;
    }

    public View getVideoContainer() {
        return this.eTl;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.gOs.setText(aVar.linkUrl);
            this.gOs.setSelection(aVar.linkUrl.length());
        }
        this.gOs.requestFocus();
        l.b(this.gOe.getActivity(), this.gOs);
        this.gOr.setVisibility(0);
        this.gOv.setVisibility(0);
        this.gOi.setVisibility(8);
    }

    public void bCb() {
        this.gOr.setVisibility(8);
        this.gOv.setVisibility(8);
        this.gOi.setVisibility(0);
        l.a(this.gOe.getActivity(), this.gOs);
    }

    public void T(View.OnClickListener onClickListener) {
        this.gOr.setOnClickListener(onClickListener);
        this.gOv.setOnClickListener(onClickListener);
        this.gOi.setOnClickListener(onClickListener);
    }

    public String bCc() {
        if (this.gOs == null || this.gOs.getText() == null) {
            return null;
        }
        return this.gOs.getText().toString();
    }

    public void bCd() {
        if (this.gOw != null) {
            this.gOw.setText(d.l.tip_url_not_match);
            aj.i(this.gOw, d.e.cp_other_b);
        }
    }

    public void U(View.OnClickListener onClickListener) {
        if (this.gOu != null) {
            this.gOu.setOnClickListener(onClickListener);
        }
    }

    public View bCe() {
        return this.gOr;
    }

    public void destroy() {
        if (this.gOh != null) {
            this.gOh.addTextChangedListener(null);
        }
        if (this.gOs != null) {
            this.gOs.addTextChangedListener(null);
        }
    }

    public void e(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.tG(postWriteCallBackData.getErrorCode())) {
                AntiHelper.at(this.gOe.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.gOe.getPageContext().getPageActivity().getString(d.l.error_write);
                }
                this.gOe.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.aLr.c(null);
        this.aLr.db(d.l.sending);
        this.aLr.aH(true);
    }

    public void closeLoadingDialog() {
        this.aLr.aH(false);
    }
}
