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
    private WriteUrlActivity gOf;
    private TextView gOg;
    private TbImageView gOh;
    private EditText gOi;
    private View gOj;
    private LinearLayout gOk;
    private ImageView gOl;
    private View gOm;
    private TextView gOn;
    private TextView gOo;
    private View gOp;
    private TextView gOq;
    private TextView gOr;
    private LinearLayout gOs;
    private EditText gOt;
    private View gOu;
    private TextView gOv;
    private FrameLayout gOw;
    private TextView gOx;
    private NavigationBar mNavigationBar;

    public d(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.dLB = null;
        this.aLr = null;
        if (writeUrlActivity != null) {
            this.gOf = writeUrlActivity;
            this.aPe = onClickListener;
            this.Rt = LayoutInflater.from(this.gOf.getPageContext().getPageActivity()).inflate(d.j.write_url_activity_layout, (ViewGroup) null);
            this.gOf.setContentView(this.Rt);
            this.mNavigationBar = (NavigationBar) this.Rt.findViewById(d.h.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.dLB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aPe);
            this.mNavigationBar.setmBackImageViewBg(d.g.write_close_selector, d.g.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dLB.getLayoutParams();
                layoutParams.leftMargin = l.f(this.gOf.getActivity(), d.f.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.dLB != null && (this.dLB.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dLB.getLayoutParams();
                layoutParams2.width = -2;
                this.dLB.setLayoutParams(layoutParams2);
            }
            this.Rt.setOnClickListener(this.aPe);
            this.gOg = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.l.send_post));
            aj.c(this.gOg, d.e.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.gOg.getLayoutParams();
            layoutParams3.rightMargin = l.f(this.gOf.getActivity(), d.f.ds16);
            this.gOg.setLayoutParams(layoutParams3);
            this.gOg.setOnClickListener(this.aPe);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.l.post_new_thread));
            this.gOh = (TbImageView) this.Rt.findViewById(d.h.imageview_picture);
            this.gOh.setDefaultResource(d.g.ic_post_url_n);
            this.gOh.setDefaultErrorResource(d.g.ic_post_url_n);
            this.gOh.setDefaultBgResource(d.e.black_alpha0);
            this.gOk = (LinearLayout) this.Rt.findViewById(d.h.view_picture_publish);
            this.gOk.setOnClickListener(this.aPe);
            this.eTl = (RelativeLayout) this.Rt.findViewById(d.h.video_container);
            this.eTl.setOnClickListener(this.aPe);
            this.dUt = (TbImageView) this.Rt.findViewById(d.h.video_img_thumbnail);
            this.dUt.setDefaultErrorResource(0);
            this.dUt.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.dUt.setDefaultBgResource(d.e.black_alpha0);
            this.gOl = (ImageView) this.Rt.findViewById(d.h.video_img_play);
            this.gOm = this.Rt.findViewById(d.h.video_view_delete);
            this.gOm.setOnClickListener(this.aPe);
            this.gOn = (TextView) this.Rt.findViewById(d.h.textview_title);
            this.gOo = (TextView) this.Rt.findViewById(d.h.textview_abstract);
            this.gOp = this.Rt.findViewById(d.h.view_delete);
            this.gOp.setOnClickListener(this.aPe);
            this.gOj = this.Rt.findViewById(d.h.icon_invoke_link);
            this.gOj.setOnClickListener(this.aPe);
            this.gOi = (EditText) this.Rt.findViewById(d.h.post_content);
            this.gOi.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.d.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    d.this.bBW();
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }
            });
            this.gOq = (TextView) this.Rt.findViewById(d.h.textview_error_tip);
            this.gOr = (TextView) this.Rt.findViewById(d.h.textview_url);
            this.gOs = (LinearLayout) this.Rt.findViewById(d.h.url_edit_container);
            this.gOt = (EditText) this.Rt.findViewById(d.h.url_input);
            this.gOx = (TextView) this.Rt.findViewById(d.h.url_desc);
            this.gOu = this.Rt.findViewById(d.h.url_input_clear);
            this.gOv = (TextView) this.Rt.findViewById(d.h.url_add);
            this.gOv.setEnabled(false);
            this.gOw = (FrameLayout) this.Rt.findViewById(d.h.url_edit_back_view);
            this.gOt.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.d.2
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        d.this.gOu.setVisibility(8);
                        aj.i(d.this.gOv, d.e.cp_cont_e);
                        d.this.gOv.setEnabled(false);
                        return;
                    }
                    d.this.gOu.setVisibility(0);
                    aj.i(d.this.gOv, d.e.cp_link_tip_a);
                    d.this.gOv.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (d.this.gOx.getText().equals(d.this.gOf.getActivity().getString(d.l.tip_url_not_match))) {
                        d.this.bBV();
                    }
                }
            });
            this.gOu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.gOt.setText("");
                    d.this.gOu.setVisibility(8);
                    d.this.gOv.setEnabled(false);
                }
            });
            this.aLr = new com.baidu.tbadk.core.view.a(this.gOf.getPageContext());
            bBV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBV() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.gOx.setText(d.l.tip_url_post);
        } else {
            this.gOx.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        aj.i(this.gOx, d.e.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.gOf.setIsLoading(z);
        if (z) {
            this.gOk.setVisibility(0);
            this.eTl.setVisibility(8);
            this.gOh.c(null, 10, false);
            this.gOn.setVisibility(8);
            this.gOo.setVisibility(8);
            this.gOq.setVisibility(8);
            this.gOr.setVisibility(0);
            aj.i(this.gOr, d.e.cp_cont_f);
            this.gOr.setText(d.l.tip_url_loading);
        } else if (aVar == null) {
            this.gOk.setVisibility(8);
            this.eTl.setVisibility(8);
            bBW();
        } else {
            if (aVar.gIp == 1) {
                this.gOk.setVisibility(0);
                this.eTl.setVisibility(8);
                if (aVar.gIo) {
                    this.gOh.c(aVar.gIr, 10, false);
                    this.gOn.setText(aVar.WT);
                    this.gOo.setText(aVar.WU);
                    if (am.dO(aVar.WT) > 30) {
                        this.gOn.setMaxLines(2);
                        this.gOo.setMaxLines(1);
                    } else {
                        this.gOn.setMaxLines(1);
                        this.gOo.setMaxLines(2);
                    }
                    this.gOn.setVisibility(0);
                    this.gOo.setVisibility(0);
                    this.gOr.setVisibility(8);
                    this.gOq.setVisibility(8);
                } else {
                    this.gOh.reset();
                    this.gOr.setText(aVar.linkUrl);
                    aj.i(this.gOr, d.e.cp_cont_b);
                    this.gOn.setVisibility(8);
                    this.gOo.setVisibility(8);
                    this.gOr.setVisibility(0);
                    this.gOq.setVisibility(0);
                }
            } else if (aVar.gIp == 2) {
                this.gOk.setVisibility(8);
                this.eTl.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.eTl.getLayoutParams();
                layoutParams.height = ((l.ad(this.gOf.getPageContext().getPageActivity()) - ((int) this.gOf.getPageContext().getPageActivity().getResources().getDimension(d.f.ds80))) * 9) / 16;
                this.eTl.setLayoutParams(layoutParams);
                aj.c(this.gOl, d.g.icon_play_video);
                aj.j(this.gOm, d.g.btn_delete_url);
                this.dUt.c(aVar.gIu, 10, false);
            } else {
                this.gOk.setVisibility(0);
                this.eTl.setVisibility(8);
                this.gOn.setVisibility(8);
                this.gOo.setVisibility(8);
                this.gOr.setVisibility(0);
                this.gOq.setVisibility(0);
                this.gOh.reset();
                this.gOr.setText(aVar.linkUrl);
                aj.i(this.gOr, d.e.cp_cont_b);
            }
            bBW();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gOf != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.gOf.getPageContext(), i);
            }
            aj.k(this.mNavigationBar, d.e.cp_bg_line_d);
            aj.k(this.Rt, d.e.cp_bg_line_d);
            this.gOi.setHintTextColor(aj.getColor(d.e.cp_cont_e));
            this.gOi.setTextColor(aj.getColor(d.e.cp_cont_f));
            aj.k(this.gOk, d.e.cp_bg_line_e);
            aj.i(this.gOn, d.e.cp_cont_b);
            aj.i(this.gOo, d.e.cp_cont_d);
            aj.i(this.gOr, d.e.cp_cont_b);
            aj.k(this.gOq, d.e.cp_bg_line_d);
            aj.i(this.gOq, d.e.cp_cont_d);
            aj.j(this.gOj, d.g.bg_link_invoke);
            aj.k(this.gOs, d.e.cp_bg_line_d);
            this.gOt.setHintTextColor(aj.getColor(d.e.cp_cont_e));
            aj.i(this.gOt, d.e.cp_cont_b);
            aj.i(this.gOx, d.e.cp_cont_d);
            aj.i(this.gOv, d.e.cp_cont_e);
            aj.c(this.gOl, d.g.home_ic_video);
            aj.j(this.gOp, d.g.btn_delete_url);
            aj.j(this.gOu, d.g.btn_delete_url);
            aj.j(this.gOm, d.g.btn_delete_url);
            bBW();
        }
    }

    public void bBW() {
        boolean z;
        if (StringUtils.isNull(bBX())) {
            z = this.gOk.getVisibility() == 0 || this.eTl.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            aj.b(this.gOg, d.e.cp_link_tip_a, d.e.s_navbar_title_color);
            this.gOg.setEnabled(true);
            return;
        }
        aj.c(this.gOg, d.e.cp_cont_d, 1);
        this.gOg.setEnabled(false);
    }

    public String bBX() {
        if (this.gOi == null || this.gOi.getText() == null) {
            return null;
        }
        return this.gOi.getText().toString();
    }

    public View ayX() {
        return this.dLB;
    }

    public View bBY() {
        return this.gOg;
    }

    public View getRootView() {
        return this.Rt;
    }

    public View bBZ() {
        return this.gOi;
    }

    public View bnW() {
        return this.gOp;
    }

    public View bCa() {
        return this.gOm;
    }

    public View bCb() {
        return this.gOk;
    }

    public View getVideoContainer() {
        return this.eTl;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.gOt.setText(aVar.linkUrl);
            this.gOt.setSelection(aVar.linkUrl.length());
        }
        this.gOt.requestFocus();
        l.b(this.gOf.getActivity(), this.gOt);
        this.gOs.setVisibility(0);
        this.gOw.setVisibility(0);
        this.gOj.setVisibility(8);
    }

    public void bCc() {
        this.gOs.setVisibility(8);
        this.gOw.setVisibility(8);
        this.gOj.setVisibility(0);
        l.a(this.gOf.getActivity(), this.gOt);
    }

    public void T(View.OnClickListener onClickListener) {
        this.gOs.setOnClickListener(onClickListener);
        this.gOw.setOnClickListener(onClickListener);
        this.gOj.setOnClickListener(onClickListener);
    }

    public String bCd() {
        if (this.gOt == null || this.gOt.getText() == null) {
            return null;
        }
        return this.gOt.getText().toString();
    }

    public void bCe() {
        if (this.gOx != null) {
            this.gOx.setText(d.l.tip_url_not_match);
            aj.i(this.gOx, d.e.cp_other_b);
        }
    }

    public void U(View.OnClickListener onClickListener) {
        if (this.gOv != null) {
            this.gOv.setOnClickListener(onClickListener);
        }
    }

    public View bCf() {
        return this.gOs;
    }

    public void destroy() {
        if (this.gOi != null) {
            this.gOi.addTextChangedListener(null);
        }
        if (this.gOt != null) {
            this.gOt.addTextChangedListener(null);
        }
    }

    public void e(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.tG(postWriteCallBackData.getErrorCode())) {
                AntiHelper.at(this.gOf.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.gOf.getPageContext().getPageActivity().getString(d.l.error_write);
                }
                this.gOf.showToast(errorString);
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
