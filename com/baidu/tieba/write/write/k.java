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
    private View buc;
    private com.baidu.tbadk.core.view.b csN;
    private View gDG;
    private TbImageView gHX;
    private RelativeLayout hEl;
    private WriteUrlActivity juU;
    private TextView juV;
    private TbImageView juW;
    private EditText juX;
    private View juY;
    private LinearLayout juZ;
    private ImageView jva;
    private View jvb;
    private TextView jvc;
    private TextView jvd;
    private View jve;
    private TextView jvf;
    private TextView jvg;
    private LinearLayout jvh;
    private EditText jvi;
    private View jvj;
    private TextView jvk;
    private FrameLayout jvl;
    private TextView jvm;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.gDG = null;
        this.csN = null;
        if (writeUrlActivity != null) {
            this.juU = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.buc = LayoutInflater.from(this.juU.getPageContext().getPageActivity()).inflate(d.h.write_url_activity_layout, (ViewGroup) null);
            this.juU.setContentView(this.buc);
            this.mNavigationBar = (NavigationBar) this.buc.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.gDG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gDG.getLayoutParams();
                layoutParams.leftMargin = l.h(this.juU.getActivity(), d.e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.gDG != null && (this.gDG.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gDG.getLayoutParams();
                layoutParams2.width = -2;
                this.gDG.setLayoutParams(layoutParams2);
            }
            this.buc.setOnClickListener(this.mClickListener);
            this.juV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.j.send_post));
            al.d(this.juV, d.C0277d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.juV.getLayoutParams();
            layoutParams3.rightMargin = l.h(this.juU.getActivity(), d.e.ds16);
            this.juV.setLayoutParams(layoutParams3);
            this.juV.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.j.post_new_thread));
            this.juW = (TbImageView) this.buc.findViewById(d.g.imageview_picture);
            this.juW.setDefaultResource(d.f.ic_post_url_n);
            this.juW.setDefaultErrorResource(d.f.ic_post_url_n);
            this.juW.setDefaultBgResource(d.C0277d.black_alpha0);
            this.juZ = (LinearLayout) this.buc.findViewById(d.g.view_picture_publish);
            this.juZ.setOnClickListener(this.mClickListener);
            this.hEl = (RelativeLayout) this.buc.findViewById(d.g.video_container);
            this.hEl.setOnClickListener(this.mClickListener);
            this.gHX = (TbImageView) this.buc.findViewById(d.g.video_img_thumbnail);
            this.gHX.setDefaultErrorResource(0);
            this.gHX.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.gHX.setDefaultBgResource(d.C0277d.black_alpha0);
            this.jva = (ImageView) this.buc.findViewById(d.g.video_img_play);
            this.jvb = this.buc.findViewById(d.g.video_view_delete);
            this.jvb.setOnClickListener(this.mClickListener);
            this.jvc = (TextView) this.buc.findViewById(d.g.textview_title);
            this.jvd = (TextView) this.buc.findViewById(d.g.textview_abstract);
            this.jve = this.buc.findViewById(d.g.view_delete);
            this.jve.setOnClickListener(this.mClickListener);
            this.juY = this.buc.findViewById(d.g.icon_invoke_link);
            this.juY.setOnClickListener(this.mClickListener);
            this.juX = (EditText) this.buc.findViewById(d.g.post_content);
            this.jvf = (TextView) this.buc.findViewById(d.g.textview_error_tip);
            this.jvg = (TextView) this.buc.findViewById(d.g.textview_url);
            this.jvh = (LinearLayout) this.buc.findViewById(d.g.url_edit_container);
            this.jvi = (EditText) this.buc.findViewById(d.g.url_input);
            this.jvm = (TextView) this.buc.findViewById(d.g.url_desc);
            this.jvj = this.buc.findViewById(d.g.url_input_clear);
            this.jvk = (TextView) this.buc.findViewById(d.g.url_add);
            this.jvk.setEnabled(false);
            this.jvl = (FrameLayout) this.buc.findViewById(d.g.url_edit_back_view);
            this.jvi.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.jvj.setVisibility(8);
                        al.j(k.this.jvk, d.C0277d.cp_cont_e);
                        k.this.jvk.setEnabled(false);
                        return;
                    }
                    k.this.jvj.setVisibility(0);
                    al.j(k.this.jvk, d.C0277d.cp_link_tip_a);
                    k.this.jvk.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.jvm.getText().equals(k.this.juU.getActivity().getString(d.j.tip_url_not_match))) {
                        k.this.crA();
                    }
                }
            });
            this.jvj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.jvi.setText("");
                    k.this.jvj.setVisibility(8);
                    k.this.jvk.setEnabled(false);
                }
            });
            this.csN = new com.baidu.tbadk.core.view.b(this.juU.getPageContext());
            crA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crA() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.jvm.setText(d.j.tip_url_post);
        } else {
            this.jvm.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        al.j(this.jvm, d.C0277d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.juU.setIsLoading(z);
        if (z) {
            this.juZ.setVisibility(0);
            this.hEl.setVisibility(8);
            this.juW.startLoad(null, 10, false);
            this.jvc.setVisibility(8);
            this.jvd.setVisibility(8);
            this.jvf.setVisibility(8);
            this.jvg.setVisibility(0);
            al.j(this.jvg, d.C0277d.cp_cont_f);
            this.jvg.setText(d.j.tip_url_loading);
        } else if (aVar == null) {
            this.juZ.setVisibility(8);
            this.hEl.setVisibility(8);
            crB();
        } else {
            if (aVar.jon == 1) {
                this.juZ.setVisibility(0);
                this.hEl.setVisibility(8);
                if (aVar.jom) {
                    this.juW.startLoad(aVar.jop, 10, false);
                    this.jvc.setText(aVar.bzm);
                    this.jvd.setText(aVar.bzn);
                    if (ap.mI(aVar.bzm) > 30) {
                        this.jvc.setMaxLines(2);
                        this.jvd.setMaxLines(1);
                    } else {
                        this.jvc.setMaxLines(1);
                        this.jvd.setMaxLines(2);
                    }
                    this.jvc.setVisibility(0);
                    this.jvd.setVisibility(0);
                    this.jvg.setVisibility(8);
                    this.jvf.setVisibility(8);
                } else {
                    this.juW.reset();
                    this.jvg.setText(aVar.linkUrl);
                    al.j(this.jvg, d.C0277d.cp_cont_b);
                    this.jvc.setVisibility(8);
                    this.jvd.setVisibility(8);
                    this.jvg.setVisibility(0);
                    this.jvf.setVisibility(0);
                }
            } else if (aVar.jon == 2) {
                this.juZ.setVisibility(8);
                this.hEl.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.hEl.getLayoutParams();
                layoutParams.height = ((l.aO(this.juU.getPageContext().getPageActivity()) - ((int) this.juU.getPageContext().getPageActivity().getResources().getDimension(d.e.ds80))) * 9) / 16;
                this.hEl.setLayoutParams(layoutParams);
                al.c(this.jva, d.f.icon_play_video);
                al.k(this.jvb, d.f.btn_delete_url);
                this.gHX.startLoad(aVar.jos, 10, false);
            } else {
                this.juZ.setVisibility(0);
                this.hEl.setVisibility(8);
                this.jvc.setVisibility(8);
                this.jvd.setVisibility(8);
                this.jvg.setVisibility(0);
                this.jvf.setVisibility(0);
                this.juW.reset();
                this.jvg.setText(aVar.linkUrl);
                al.j(this.jvg, d.C0277d.cp_cont_b);
            }
            crB();
        }
    }

    public void f(TextWatcher textWatcher) {
        this.juX.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.juU != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.juU.getPageContext(), i);
            }
            al.l(this.mNavigationBar, d.C0277d.cp_bg_line_d);
            al.l(this.buc, d.C0277d.cp_bg_line_d);
            this.juX.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
            this.juX.setTextColor(al.getColor(d.C0277d.cp_cont_f));
            al.l(this.juZ, d.C0277d.cp_bg_line_e);
            al.j(this.jvc, d.C0277d.cp_cont_b);
            al.j(this.jvd, d.C0277d.cp_cont_d);
            al.j(this.jvg, d.C0277d.cp_cont_b);
            al.l(this.jvf, d.C0277d.cp_bg_line_d);
            al.j(this.jvf, d.C0277d.cp_cont_d);
            al.k(this.juY, d.f.bg_link_invoke);
            al.l(this.jvh, d.C0277d.cp_bg_line_d);
            this.jvi.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
            al.j(this.jvi, d.C0277d.cp_cont_b);
            al.j(this.jvm, d.C0277d.cp_cont_d);
            al.j(this.jvk, d.C0277d.cp_cont_e);
            al.c(this.jva, d.f.home_ic_video);
            al.k(this.jve, d.f.btn_delete_url);
            al.k(this.jvj, d.f.btn_delete_url);
            al.k(this.jvb, d.f.btn_delete_url);
            crB();
        }
    }

    public void crB() {
        boolean z;
        if (StringUtils.isNull(crC())) {
            z = this.juZ.getVisibility() == 0 || this.hEl.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            al.c(this.juV, d.C0277d.cp_link_tip_a, d.C0277d.s_navbar_title_color);
            this.juV.setEnabled(true);
            return;
        }
        al.d(this.juV, d.C0277d.cp_cont_d, 1);
        this.juV.setEnabled(false);
    }

    public String crC() {
        if (this.juX == null || this.juX.getText() == null) {
            return null;
        }
        return this.juX.getText().toString();
    }

    public View bvR() {
        return this.gDG;
    }

    public View crD() {
        return this.juV;
    }

    public View getRootView() {
        return this.buc;
    }

    public EditText crE() {
        return this.juX;
    }

    public View crF() {
        return this.jve;
    }

    public View crG() {
        return this.jvb;
    }

    public View crH() {
        return this.juZ;
    }

    public View getVideoContainer() {
        return this.hEl;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.jvi.setText(aVar.linkUrl);
            this.jvi.setSelection(aVar.linkUrl.length());
        }
        this.jvi.requestFocus();
        l.c(this.juU.getActivity(), this.jvi);
        this.jvh.setVisibility(0);
        this.jvl.setVisibility(0);
        this.juY.setVisibility(8);
    }

    public void crI() {
        this.jvh.setVisibility(8);
        this.jvl.setVisibility(8);
        this.juY.setVisibility(0);
        l.b(this.juU.getActivity(), this.jvi);
    }

    public void Z(View.OnClickListener onClickListener) {
        this.jvh.setOnClickListener(onClickListener);
        this.jvl.setOnClickListener(onClickListener);
        this.juY.setOnClickListener(onClickListener);
    }

    public String crJ() {
        if (this.jvi == null || this.jvi.getText() == null) {
            return null;
        }
        return this.jvi.getText().toString();
    }

    public void crK() {
        if (this.jvm != null) {
            this.jvm.setText(d.j.tip_url_not_match);
            al.j(this.jvm, d.C0277d.cp_other_b);
        }
    }

    public void aa(View.OnClickListener onClickListener) {
        if (this.jvk != null) {
            this.jvk.setOnClickListener(onClickListener);
        }
    }

    public View crL() {
        return this.jvh;
    }

    public void destroy() {
        if (this.juX != null) {
            this.juX.addTextChangedListener(null);
        }
        if (this.jvi != null) {
            this.jvi.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.aD(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aU(this.juU.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.juU.getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                this.juU.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.csN.e(null);
        this.csN.hF(d.j.sending);
        this.csN.dJ(true);
    }

    public void closeLoadingDialog() {
        this.csN.dJ(false);
    }
}
