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
    private View bub;
    private com.baidu.tbadk.core.view.b csM;
    private View gDF;
    private TbImageView gHW;
    private RelativeLayout hEk;
    private WriteUrlActivity juT;
    private TextView juU;
    private TbImageView juV;
    private EditText juW;
    private View juX;
    private LinearLayout juY;
    private ImageView juZ;
    private View jva;
    private TextView jvb;
    private TextView jvc;
    private View jvd;
    private TextView jve;
    private TextView jvf;
    private LinearLayout jvg;
    private EditText jvh;
    private View jvi;
    private TextView jvj;
    private FrameLayout jvk;
    private TextView jvl;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.gDF = null;
        this.csM = null;
        if (writeUrlActivity != null) {
            this.juT = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.bub = LayoutInflater.from(this.juT.getPageContext().getPageActivity()).inflate(d.h.write_url_activity_layout, (ViewGroup) null);
            this.juT.setContentView(this.bub);
            this.mNavigationBar = (NavigationBar) this.bub.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.gDF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gDF.getLayoutParams();
                layoutParams.leftMargin = l.h(this.juT.getActivity(), d.e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.gDF != null && (this.gDF.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gDF.getLayoutParams();
                layoutParams2.width = -2;
                this.gDF.setLayoutParams(layoutParams2);
            }
            this.bub.setOnClickListener(this.mClickListener);
            this.juU = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.j.send_post));
            al.d(this.juU, d.C0277d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.juU.getLayoutParams();
            layoutParams3.rightMargin = l.h(this.juT.getActivity(), d.e.ds16);
            this.juU.setLayoutParams(layoutParams3);
            this.juU.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.j.post_new_thread));
            this.juV = (TbImageView) this.bub.findViewById(d.g.imageview_picture);
            this.juV.setDefaultResource(d.f.ic_post_url_n);
            this.juV.setDefaultErrorResource(d.f.ic_post_url_n);
            this.juV.setDefaultBgResource(d.C0277d.black_alpha0);
            this.juY = (LinearLayout) this.bub.findViewById(d.g.view_picture_publish);
            this.juY.setOnClickListener(this.mClickListener);
            this.hEk = (RelativeLayout) this.bub.findViewById(d.g.video_container);
            this.hEk.setOnClickListener(this.mClickListener);
            this.gHW = (TbImageView) this.bub.findViewById(d.g.video_img_thumbnail);
            this.gHW.setDefaultErrorResource(0);
            this.gHW.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.gHW.setDefaultBgResource(d.C0277d.black_alpha0);
            this.juZ = (ImageView) this.bub.findViewById(d.g.video_img_play);
            this.jva = this.bub.findViewById(d.g.video_view_delete);
            this.jva.setOnClickListener(this.mClickListener);
            this.jvb = (TextView) this.bub.findViewById(d.g.textview_title);
            this.jvc = (TextView) this.bub.findViewById(d.g.textview_abstract);
            this.jvd = this.bub.findViewById(d.g.view_delete);
            this.jvd.setOnClickListener(this.mClickListener);
            this.juX = this.bub.findViewById(d.g.icon_invoke_link);
            this.juX.setOnClickListener(this.mClickListener);
            this.juW = (EditText) this.bub.findViewById(d.g.post_content);
            this.jve = (TextView) this.bub.findViewById(d.g.textview_error_tip);
            this.jvf = (TextView) this.bub.findViewById(d.g.textview_url);
            this.jvg = (LinearLayout) this.bub.findViewById(d.g.url_edit_container);
            this.jvh = (EditText) this.bub.findViewById(d.g.url_input);
            this.jvl = (TextView) this.bub.findViewById(d.g.url_desc);
            this.jvi = this.bub.findViewById(d.g.url_input_clear);
            this.jvj = (TextView) this.bub.findViewById(d.g.url_add);
            this.jvj.setEnabled(false);
            this.jvk = (FrameLayout) this.bub.findViewById(d.g.url_edit_back_view);
            this.jvh.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.jvi.setVisibility(8);
                        al.j(k.this.jvj, d.C0277d.cp_cont_e);
                        k.this.jvj.setEnabled(false);
                        return;
                    }
                    k.this.jvi.setVisibility(0);
                    al.j(k.this.jvj, d.C0277d.cp_link_tip_a);
                    k.this.jvj.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.jvl.getText().equals(k.this.juT.getActivity().getString(d.j.tip_url_not_match))) {
                        k.this.crA();
                    }
                }
            });
            this.jvi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.jvh.setText("");
                    k.this.jvi.setVisibility(8);
                    k.this.jvj.setEnabled(false);
                }
            });
            this.csM = new com.baidu.tbadk.core.view.b(this.juT.getPageContext());
            crA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crA() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.jvl.setText(d.j.tip_url_post);
        } else {
            this.jvl.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        al.j(this.jvl, d.C0277d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.juT.setIsLoading(z);
        if (z) {
            this.juY.setVisibility(0);
            this.hEk.setVisibility(8);
            this.juV.startLoad(null, 10, false);
            this.jvb.setVisibility(8);
            this.jvc.setVisibility(8);
            this.jve.setVisibility(8);
            this.jvf.setVisibility(0);
            al.j(this.jvf, d.C0277d.cp_cont_f);
            this.jvf.setText(d.j.tip_url_loading);
        } else if (aVar == null) {
            this.juY.setVisibility(8);
            this.hEk.setVisibility(8);
            crB();
        } else {
            if (aVar.jom == 1) {
                this.juY.setVisibility(0);
                this.hEk.setVisibility(8);
                if (aVar.jol) {
                    this.juV.startLoad(aVar.joo, 10, false);
                    this.jvb.setText(aVar.bzl);
                    this.jvc.setText(aVar.bzm);
                    if (ap.mI(aVar.bzl) > 30) {
                        this.jvb.setMaxLines(2);
                        this.jvc.setMaxLines(1);
                    } else {
                        this.jvb.setMaxLines(1);
                        this.jvc.setMaxLines(2);
                    }
                    this.jvb.setVisibility(0);
                    this.jvc.setVisibility(0);
                    this.jvf.setVisibility(8);
                    this.jve.setVisibility(8);
                } else {
                    this.juV.reset();
                    this.jvf.setText(aVar.linkUrl);
                    al.j(this.jvf, d.C0277d.cp_cont_b);
                    this.jvb.setVisibility(8);
                    this.jvc.setVisibility(8);
                    this.jvf.setVisibility(0);
                    this.jve.setVisibility(0);
                }
            } else if (aVar.jom == 2) {
                this.juY.setVisibility(8);
                this.hEk.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.hEk.getLayoutParams();
                layoutParams.height = ((l.aO(this.juT.getPageContext().getPageActivity()) - ((int) this.juT.getPageContext().getPageActivity().getResources().getDimension(d.e.ds80))) * 9) / 16;
                this.hEk.setLayoutParams(layoutParams);
                al.c(this.juZ, d.f.icon_play_video);
                al.k(this.jva, d.f.btn_delete_url);
                this.gHW.startLoad(aVar.jor, 10, false);
            } else {
                this.juY.setVisibility(0);
                this.hEk.setVisibility(8);
                this.jvb.setVisibility(8);
                this.jvc.setVisibility(8);
                this.jvf.setVisibility(0);
                this.jve.setVisibility(0);
                this.juV.reset();
                this.jvf.setText(aVar.linkUrl);
                al.j(this.jvf, d.C0277d.cp_cont_b);
            }
            crB();
        }
    }

    public void f(TextWatcher textWatcher) {
        this.juW.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.juT != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.juT.getPageContext(), i);
            }
            al.l(this.mNavigationBar, d.C0277d.cp_bg_line_d);
            al.l(this.bub, d.C0277d.cp_bg_line_d);
            this.juW.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
            this.juW.setTextColor(al.getColor(d.C0277d.cp_cont_f));
            al.l(this.juY, d.C0277d.cp_bg_line_e);
            al.j(this.jvb, d.C0277d.cp_cont_b);
            al.j(this.jvc, d.C0277d.cp_cont_d);
            al.j(this.jvf, d.C0277d.cp_cont_b);
            al.l(this.jve, d.C0277d.cp_bg_line_d);
            al.j(this.jve, d.C0277d.cp_cont_d);
            al.k(this.juX, d.f.bg_link_invoke);
            al.l(this.jvg, d.C0277d.cp_bg_line_d);
            this.jvh.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
            al.j(this.jvh, d.C0277d.cp_cont_b);
            al.j(this.jvl, d.C0277d.cp_cont_d);
            al.j(this.jvj, d.C0277d.cp_cont_e);
            al.c(this.juZ, d.f.home_ic_video);
            al.k(this.jvd, d.f.btn_delete_url);
            al.k(this.jvi, d.f.btn_delete_url);
            al.k(this.jva, d.f.btn_delete_url);
            crB();
        }
    }

    public void crB() {
        boolean z;
        if (StringUtils.isNull(crC())) {
            z = this.juY.getVisibility() == 0 || this.hEk.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            al.c(this.juU, d.C0277d.cp_link_tip_a, d.C0277d.s_navbar_title_color);
            this.juU.setEnabled(true);
            return;
        }
        al.d(this.juU, d.C0277d.cp_cont_d, 1);
        this.juU.setEnabled(false);
    }

    public String crC() {
        if (this.juW == null || this.juW.getText() == null) {
            return null;
        }
        return this.juW.getText().toString();
    }

    public View bvR() {
        return this.gDF;
    }

    public View crD() {
        return this.juU;
    }

    public View getRootView() {
        return this.bub;
    }

    public EditText crE() {
        return this.juW;
    }

    public View crF() {
        return this.jvd;
    }

    public View crG() {
        return this.jva;
    }

    public View crH() {
        return this.juY;
    }

    public View getVideoContainer() {
        return this.hEk;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.jvh.setText(aVar.linkUrl);
            this.jvh.setSelection(aVar.linkUrl.length());
        }
        this.jvh.requestFocus();
        l.c(this.juT.getActivity(), this.jvh);
        this.jvg.setVisibility(0);
        this.jvk.setVisibility(0);
        this.juX.setVisibility(8);
    }

    public void crI() {
        this.jvg.setVisibility(8);
        this.jvk.setVisibility(8);
        this.juX.setVisibility(0);
        l.b(this.juT.getActivity(), this.jvh);
    }

    public void Z(View.OnClickListener onClickListener) {
        this.jvg.setOnClickListener(onClickListener);
        this.jvk.setOnClickListener(onClickListener);
        this.juX.setOnClickListener(onClickListener);
    }

    public String crJ() {
        if (this.jvh == null || this.jvh.getText() == null) {
            return null;
        }
        return this.jvh.getText().toString();
    }

    public void crK() {
        if (this.jvl != null) {
            this.jvl.setText(d.j.tip_url_not_match);
            al.j(this.jvl, d.C0277d.cp_other_b);
        }
    }

    public void aa(View.OnClickListener onClickListener) {
        if (this.jvj != null) {
            this.jvj.setOnClickListener(onClickListener);
        }
    }

    public View crL() {
        return this.jvg;
    }

    public void destroy() {
        if (this.juW != null) {
            this.juW.addTextChangedListener(null);
        }
        if (this.jvh != null) {
            this.jvh.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.aD(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aU(this.juT.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.juT.getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                this.juT.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.csM.e(null);
        this.csM.hF(d.j.sending);
        this.csM.dJ(true);
    }

    public void closeLoadingDialog() {
        this.csM.dJ(false);
    }
}
