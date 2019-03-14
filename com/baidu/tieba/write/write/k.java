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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes3.dex */
public class k {
    private View btY;
    private com.baidu.tbadk.core.view.b csK;
    private View gDR;
    private TbImageView gIj;
    private RelativeLayout hEy;
    private WriteUrlActivity jvd;
    private TextView jve;
    private TbImageView jvf;
    private EditText jvg;
    private View jvh;
    private LinearLayout jvi;
    private ImageView jvj;
    private View jvk;
    private TextView jvl;
    private TextView jvm;
    private View jvn;
    private TextView jvo;
    private TextView jvp;
    private LinearLayout jvq;
    private EditText jvr;
    private View jvs;
    private TextView jvt;
    private FrameLayout jvu;
    private TextView jvv;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.gDR = null;
        this.csK = null;
        if (writeUrlActivity != null) {
            this.jvd = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.btY = LayoutInflater.from(this.jvd.getPageContext().getPageActivity()).inflate(d.h.write_url_activity_layout, (ViewGroup) null);
            this.jvd.setContentView(this.btY);
            this.mNavigationBar = (NavigationBar) this.btY.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.gDR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gDR.getLayoutParams();
                layoutParams.leftMargin = l.h(this.jvd.getActivity(), d.e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.gDR != null && (this.gDR.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gDR.getLayoutParams();
                layoutParams2.width = -2;
                this.gDR.setLayoutParams(layoutParams2);
            }
            this.btY.setOnClickListener(this.mClickListener);
            this.jve = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.j.send_post));
            al.d(this.jve, d.C0277d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.jve.getLayoutParams();
            layoutParams3.rightMargin = l.h(this.jvd.getActivity(), d.e.ds16);
            this.jve.setLayoutParams(layoutParams3);
            this.jve.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.j.post_new_thread));
            this.jvf = (TbImageView) this.btY.findViewById(d.g.imageview_picture);
            this.jvf.setDefaultResource(d.f.ic_post_url_n);
            this.jvf.setDefaultErrorResource(d.f.ic_post_url_n);
            this.jvf.setDefaultBgResource(d.C0277d.black_alpha0);
            this.jvi = (LinearLayout) this.btY.findViewById(d.g.view_picture_publish);
            this.jvi.setOnClickListener(this.mClickListener);
            this.hEy = (RelativeLayout) this.btY.findViewById(d.g.video_container);
            this.hEy.setOnClickListener(this.mClickListener);
            this.gIj = (TbImageView) this.btY.findViewById(d.g.video_img_thumbnail);
            this.gIj.setDefaultErrorResource(0);
            this.gIj.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.gIj.setDefaultBgResource(d.C0277d.black_alpha0);
            this.jvj = (ImageView) this.btY.findViewById(d.g.video_img_play);
            this.jvk = this.btY.findViewById(d.g.video_view_delete);
            this.jvk.setOnClickListener(this.mClickListener);
            this.jvl = (TextView) this.btY.findViewById(d.g.textview_title);
            this.jvm = (TextView) this.btY.findViewById(d.g.textview_abstract);
            this.jvn = this.btY.findViewById(d.g.view_delete);
            this.jvn.setOnClickListener(this.mClickListener);
            this.jvh = this.btY.findViewById(d.g.icon_invoke_link);
            this.jvh.setOnClickListener(this.mClickListener);
            this.jvg = (EditText) this.btY.findViewById(d.g.post_content);
            this.jvo = (TextView) this.btY.findViewById(d.g.textview_error_tip);
            this.jvp = (TextView) this.btY.findViewById(d.g.textview_url);
            this.jvq = (LinearLayout) this.btY.findViewById(d.g.url_edit_container);
            this.jvr = (EditText) this.btY.findViewById(d.g.url_input);
            this.jvv = (TextView) this.btY.findViewById(d.g.url_desc);
            this.jvs = this.btY.findViewById(d.g.url_input_clear);
            this.jvt = (TextView) this.btY.findViewById(d.g.url_add);
            this.jvt.setEnabled(false);
            this.jvu = (FrameLayout) this.btY.findViewById(d.g.url_edit_back_view);
            this.jvr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.jvs.setVisibility(8);
                        al.j(k.this.jvt, d.C0277d.cp_cont_e);
                        k.this.jvt.setEnabled(false);
                        return;
                    }
                    k.this.jvs.setVisibility(0);
                    al.j(k.this.jvt, d.C0277d.cp_link_tip_a);
                    k.this.jvt.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.jvv.getText().equals(k.this.jvd.getActivity().getString(d.j.tip_url_not_match))) {
                        k.this.crC();
                    }
                }
            });
            this.jvs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.jvr.setText("");
                    k.this.jvs.setVisibility(8);
                    k.this.jvt.setEnabled(false);
                }
            });
            this.csK = new com.baidu.tbadk.core.view.b(this.jvd.getPageContext());
            crC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crC() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.jvv.setText(d.j.tip_url_post);
        } else {
            this.jvv.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        al.j(this.jvv, d.C0277d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.jvd.setIsLoading(z);
        if (z) {
            this.jvi.setVisibility(0);
            this.hEy.setVisibility(8);
            this.jvf.startLoad(null, 10, false);
            this.jvl.setVisibility(8);
            this.jvm.setVisibility(8);
            this.jvo.setVisibility(8);
            this.jvp.setVisibility(0);
            al.j(this.jvp, d.C0277d.cp_cont_f);
            this.jvp.setText(d.j.tip_url_loading);
        } else if (aVar == null) {
            this.jvi.setVisibility(8);
            this.hEy.setVisibility(8);
            crD();
        } else {
            if (aVar.jox == 1) {
                this.jvi.setVisibility(0);
                this.hEy.setVisibility(8);
                if (aVar.jow) {
                    this.jvf.startLoad(aVar.joz, 10, false);
                    this.jvl.setText(aVar.bzi);
                    this.jvm.setText(aVar.bzj);
                    if (ap.mH(aVar.bzi) > 30) {
                        this.jvl.setMaxLines(2);
                        this.jvm.setMaxLines(1);
                    } else {
                        this.jvl.setMaxLines(1);
                        this.jvm.setMaxLines(2);
                    }
                    this.jvl.setVisibility(0);
                    this.jvm.setVisibility(0);
                    this.jvp.setVisibility(8);
                    this.jvo.setVisibility(8);
                } else {
                    this.jvf.reset();
                    this.jvp.setText(aVar.linkUrl);
                    al.j(this.jvp, d.C0277d.cp_cont_b);
                    this.jvl.setVisibility(8);
                    this.jvm.setVisibility(8);
                    this.jvp.setVisibility(0);
                    this.jvo.setVisibility(0);
                }
            } else if (aVar.jox == 2) {
                this.jvi.setVisibility(8);
                this.hEy.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.hEy.getLayoutParams();
                layoutParams.height = ((l.aO(this.jvd.getPageContext().getPageActivity()) - ((int) this.jvd.getPageContext().getPageActivity().getResources().getDimension(d.e.ds80))) * 9) / 16;
                this.hEy.setLayoutParams(layoutParams);
                al.c(this.jvj, d.f.icon_play_video);
                al.k(this.jvk, d.f.btn_delete_url);
                this.gIj.startLoad(aVar.joC, 10, false);
            } else {
                this.jvi.setVisibility(0);
                this.hEy.setVisibility(8);
                this.jvl.setVisibility(8);
                this.jvm.setVisibility(8);
                this.jvp.setVisibility(0);
                this.jvo.setVisibility(0);
                this.jvf.reset();
                this.jvp.setText(aVar.linkUrl);
                al.j(this.jvp, d.C0277d.cp_cont_b);
            }
            crD();
        }
    }

    public void f(TextWatcher textWatcher) {
        this.jvg.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.jvd != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.jvd.getPageContext(), i);
            }
            al.l(this.mNavigationBar, d.C0277d.cp_bg_line_d);
            al.l(this.btY, d.C0277d.cp_bg_line_d);
            this.jvg.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
            this.jvg.setTextColor(al.getColor(d.C0277d.cp_cont_f));
            al.l(this.jvi, d.C0277d.cp_bg_line_e);
            al.j(this.jvl, d.C0277d.cp_cont_b);
            al.j(this.jvm, d.C0277d.cp_cont_d);
            al.j(this.jvp, d.C0277d.cp_cont_b);
            al.l(this.jvo, d.C0277d.cp_bg_line_d);
            al.j(this.jvo, d.C0277d.cp_cont_d);
            al.k(this.jvh, d.f.bg_link_invoke);
            al.l(this.jvq, d.C0277d.cp_bg_line_d);
            this.jvr.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
            al.j(this.jvr, d.C0277d.cp_cont_b);
            al.j(this.jvv, d.C0277d.cp_cont_d);
            al.j(this.jvt, d.C0277d.cp_cont_e);
            al.c(this.jvj, d.f.home_ic_video);
            al.k(this.jvn, d.f.btn_delete_url);
            al.k(this.jvs, d.f.btn_delete_url);
            al.k(this.jvk, d.f.btn_delete_url);
            crD();
        }
    }

    public void crD() {
        boolean z;
        if (StringUtils.isNull(crE())) {
            z = this.jvi.getVisibility() == 0 || this.hEy.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            al.c(this.jve, d.C0277d.cp_link_tip_a, d.C0277d.s_navbar_title_color);
            this.jve.setEnabled(true);
            return;
        }
        al.d(this.jve, d.C0277d.cp_cont_d, 1);
        this.jve.setEnabled(false);
    }

    public String crE() {
        if (this.jvg == null || this.jvg.getText() == null) {
            return null;
        }
        return this.jvg.getText().toString();
    }

    public View bvU() {
        return this.gDR;
    }

    public View crF() {
        return this.jve;
    }

    public View getRootView() {
        return this.btY;
    }

    public EditText crG() {
        return this.jvg;
    }

    public View crH() {
        return this.jvn;
    }

    public View crI() {
        return this.jvk;
    }

    public View crJ() {
        return this.jvi;
    }

    public View getVideoContainer() {
        return this.hEy;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.jvr.setText(aVar.linkUrl);
            this.jvr.setSelection(aVar.linkUrl.length());
        }
        this.jvr.requestFocus();
        l.c(this.jvd.getActivity(), this.jvr);
        this.jvq.setVisibility(0);
        this.jvu.setVisibility(0);
        this.jvh.setVisibility(8);
    }

    public void crK() {
        this.jvq.setVisibility(8);
        this.jvu.setVisibility(8);
        this.jvh.setVisibility(0);
        l.b(this.jvd.getActivity(), this.jvr);
    }

    public void Z(View.OnClickListener onClickListener) {
        this.jvq.setOnClickListener(onClickListener);
        this.jvu.setOnClickListener(onClickListener);
        this.jvh.setOnClickListener(onClickListener);
    }

    public String crL() {
        if (this.jvr == null || this.jvr.getText() == null) {
            return null;
        }
        return this.jvr.getText().toString();
    }

    public void crM() {
        if (this.jvv != null) {
            this.jvv.setText(d.j.tip_url_not_match);
            al.j(this.jvv, d.C0277d.cp_other_b);
        }
    }

    public void aa(View.OnClickListener onClickListener) {
        if (this.jvt != null) {
            this.jvt.setOnClickListener(onClickListener);
        }
    }

    public View crN() {
        return this.jvq;
    }

    public void destroy() {
        if (this.jvg != null) {
            this.jvg.addTextChangedListener(null);
        }
        if (this.jvr != null) {
            this.jvr.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.aB(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aU(this.jvd.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.jvd.getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                this.jvd.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.csK.e(null);
        this.csK.hG(d.j.sending);
        this.csK.dJ(true);
    }

    public void closeLoadingDialog() {
        this.csK.dJ(false);
    }
}
