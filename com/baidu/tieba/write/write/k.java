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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes3.dex */
public class k {
    private View aix;
    private com.baidu.tbadk.core.view.d bdN;
    private View fbN;
    private TbImageView fgg;
    private RelativeLayout gci;
    private WriteUrlActivity hQS;
    private TextView hQT;
    private TbImageView hQU;
    private EditText hQV;
    private View hQW;
    private LinearLayout hQX;
    private ImageView hQY;
    private View hQZ;
    private TextView hRa;
    private TextView hRb;
    private View hRc;
    private TextView hRd;
    private TextView hRe;
    private LinearLayout hRf;
    private EditText hRg;
    private View hRh;
    private TextView hRi;
    private FrameLayout hRj;
    private TextView hRk;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.fbN = null;
        this.bdN = null;
        if (writeUrlActivity != null) {
            this.hQS = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.aix = LayoutInflater.from(this.hQS.getPageContext().getPageActivity()).inflate(e.h.write_url_activity_layout, (ViewGroup) null);
            this.hQS.setContentView(this.aix);
            this.mNavigationBar = (NavigationBar) this.aix.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.fbN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(e.f.write_close_selector, e.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fbN.getLayoutParams();
                layoutParams.leftMargin = l.h(this.hQS.getActivity(), e.C0175e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.fbN != null && (this.fbN.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fbN.getLayoutParams();
                layoutParams2.width = -2;
                this.fbN.setLayoutParams(layoutParams2);
            }
            this.aix.setOnClickListener(this.mClickListener);
            this.hQT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(e.j.send_post));
            al.c(this.hQT, e.d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hQT.getLayoutParams();
            layoutParams3.rightMargin = l.h(this.hQS.getActivity(), e.C0175e.ds16);
            this.hQT.setLayoutParams(layoutParams3);
            this.hQT.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(e.j.post_new_thread));
            this.hQU = (TbImageView) this.aix.findViewById(e.g.imageview_picture);
            this.hQU.setDefaultResource(e.f.ic_post_url_n);
            this.hQU.setDefaultErrorResource(e.f.ic_post_url_n);
            this.hQU.setDefaultBgResource(e.d.black_alpha0);
            this.hQX = (LinearLayout) this.aix.findViewById(e.g.view_picture_publish);
            this.hQX.setOnClickListener(this.mClickListener);
            this.gci = (RelativeLayout) this.aix.findViewById(e.g.video_container);
            this.gci.setOnClickListener(this.mClickListener);
            this.fgg = (TbImageView) this.aix.findViewById(e.g.video_img_thumbnail);
            this.fgg.setDefaultErrorResource(0);
            this.fgg.setDefaultBgResource(e.f.pic_bg_video_frs);
            this.fgg.setDefaultBgResource(e.d.black_alpha0);
            this.hQY = (ImageView) this.aix.findViewById(e.g.video_img_play);
            this.hQZ = this.aix.findViewById(e.g.video_view_delete);
            this.hQZ.setOnClickListener(this.mClickListener);
            this.hRa = (TextView) this.aix.findViewById(e.g.textview_title);
            this.hRb = (TextView) this.aix.findViewById(e.g.textview_abstract);
            this.hRc = this.aix.findViewById(e.g.view_delete);
            this.hRc.setOnClickListener(this.mClickListener);
            this.hQW = this.aix.findViewById(e.g.icon_invoke_link);
            this.hQW.setOnClickListener(this.mClickListener);
            this.hQV = (EditText) this.aix.findViewById(e.g.post_content);
            this.hRd = (TextView) this.aix.findViewById(e.g.textview_error_tip);
            this.hRe = (TextView) this.aix.findViewById(e.g.textview_url);
            this.hRf = (LinearLayout) this.aix.findViewById(e.g.url_edit_container);
            this.hRg = (EditText) this.aix.findViewById(e.g.url_input);
            this.hRk = (TextView) this.aix.findViewById(e.g.url_desc);
            this.hRh = this.aix.findViewById(e.g.url_input_clear);
            this.hRi = (TextView) this.aix.findViewById(e.g.url_add);
            this.hRi.setEnabled(false);
            this.hRj = (FrameLayout) this.aix.findViewById(e.g.url_edit_back_view);
            this.hRg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.hRh.setVisibility(8);
                        al.h(k.this.hRi, e.d.cp_cont_e);
                        k.this.hRi.setEnabled(false);
                        return;
                    }
                    k.this.hRh.setVisibility(0);
                    al.h(k.this.hRi, e.d.cp_link_tip_a);
                    k.this.hRi.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.hRk.getText().equals(k.this.hQS.getActivity().getString(e.j.tip_url_not_match))) {
                        k.this.bOD();
                    }
                }
            });
            this.hRh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.hRg.setText("");
                    k.this.hRh.setVisibility(8);
                    k.this.hRi.setEnabled(false);
                }
            });
            this.bdN = new com.baidu.tbadk.core.view.d(this.hQS.getPageContext());
            bOD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOD() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.hRk.setText(e.j.tip_url_post);
        } else {
            this.hRk.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        al.h(this.hRk, e.d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.hQS.setIsLoading(z);
        if (z) {
            this.hQX.setVisibility(0);
            this.gci.setVisibility(8);
            this.hQU.startLoad(null, 10, false);
            this.hRa.setVisibility(8);
            this.hRb.setVisibility(8);
            this.hRd.setVisibility(8);
            this.hRe.setVisibility(0);
            al.h(this.hRe, e.d.cp_cont_f);
            this.hRe.setText(e.j.tip_url_loading);
        } else if (aVar == null) {
            this.hQX.setVisibility(8);
            this.gci.setVisibility(8);
            bOE();
        } else {
            if (aVar.hKy == 1) {
                this.hQX.setVisibility(0);
                this.gci.setVisibility(8);
                if (aVar.hKx) {
                    this.hQU.startLoad(aVar.hKA, 10, false);
                    this.hRa.setText(aVar.anB);
                    this.hRb.setText(aVar.anC);
                    if (ao.fq(aVar.anB) > 30) {
                        this.hRa.setMaxLines(2);
                        this.hRb.setMaxLines(1);
                    } else {
                        this.hRa.setMaxLines(1);
                        this.hRb.setMaxLines(2);
                    }
                    this.hRa.setVisibility(0);
                    this.hRb.setVisibility(0);
                    this.hRe.setVisibility(8);
                    this.hRd.setVisibility(8);
                } else {
                    this.hQU.reset();
                    this.hRe.setText(aVar.linkUrl);
                    al.h(this.hRe, e.d.cp_cont_b);
                    this.hRa.setVisibility(8);
                    this.hRb.setVisibility(8);
                    this.hRe.setVisibility(0);
                    this.hRd.setVisibility(0);
                }
            } else if (aVar.hKy == 2) {
                this.hQX.setVisibility(8);
                this.gci.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.gci.getLayoutParams();
                layoutParams.height = ((l.aO(this.hQS.getPageContext().getPageActivity()) - ((int) this.hQS.getPageContext().getPageActivity().getResources().getDimension(e.C0175e.ds80))) * 9) / 16;
                this.gci.setLayoutParams(layoutParams);
                al.c(this.hQY, e.f.icon_play_video);
                al.i(this.hQZ, e.f.btn_delete_url);
                this.fgg.startLoad(aVar.hKD, 10, false);
            } else {
                this.hQX.setVisibility(0);
                this.gci.setVisibility(8);
                this.hRa.setVisibility(8);
                this.hRb.setVisibility(8);
                this.hRe.setVisibility(0);
                this.hRd.setVisibility(0);
                this.hQU.reset();
                this.hRe.setText(aVar.linkUrl);
                al.h(this.hRe, e.d.cp_cont_b);
            }
            bOE();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.hQV.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.hQS != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hQS.getPageContext(), i);
            }
            al.j(this.mNavigationBar, e.d.cp_bg_line_d);
            al.j(this.aix, e.d.cp_bg_line_d);
            this.hQV.setHintTextColor(al.getColor(e.d.cp_cont_e));
            this.hQV.setTextColor(al.getColor(e.d.cp_cont_f));
            al.j(this.hQX, e.d.cp_bg_line_e);
            al.h(this.hRa, e.d.cp_cont_b);
            al.h(this.hRb, e.d.cp_cont_d);
            al.h(this.hRe, e.d.cp_cont_b);
            al.j(this.hRd, e.d.cp_bg_line_d);
            al.h(this.hRd, e.d.cp_cont_d);
            al.i(this.hQW, e.f.bg_link_invoke);
            al.j(this.hRf, e.d.cp_bg_line_d);
            this.hRg.setHintTextColor(al.getColor(e.d.cp_cont_e));
            al.h(this.hRg, e.d.cp_cont_b);
            al.h(this.hRk, e.d.cp_cont_d);
            al.h(this.hRi, e.d.cp_cont_e);
            al.c(this.hQY, e.f.home_ic_video);
            al.i(this.hRc, e.f.btn_delete_url);
            al.i(this.hRh, e.f.btn_delete_url);
            al.i(this.hQZ, e.f.btn_delete_url);
            bOE();
        }
    }

    public void bOE() {
        boolean z;
        if (StringUtils.isNull(bOF())) {
            z = this.hQX.getVisibility() == 0 || this.gci.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            al.b(this.hQT, e.d.cp_link_tip_a, e.d.s_navbar_title_color);
            this.hQT.setEnabled(true);
            return;
        }
        al.c(this.hQT, e.d.cp_cont_d, 1);
        this.hQT.setEnabled(false);
    }

    public String bOF() {
        if (this.hQV == null || this.hQV.getText() == null) {
            return null;
        }
        return this.hQV.getText().toString();
    }

    public View aSN() {
        return this.fbN;
    }

    public View bOG() {
        return this.hQT;
    }

    public View getRootView() {
        return this.aix;
    }

    public EditText bOH() {
        return this.hQV;
    }

    public View bOI() {
        return this.hRc;
    }

    public View bOJ() {
        return this.hQZ;
    }

    public View bOK() {
        return this.hQX;
    }

    public View getVideoContainer() {
        return this.gci;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.hRg.setText(aVar.linkUrl);
            this.hRg.setSelection(aVar.linkUrl.length());
        }
        this.hRg.requestFocus();
        l.b(this.hQS.getActivity(), this.hRg);
        this.hRf.setVisibility(0);
        this.hRj.setVisibility(0);
        this.hQW.setVisibility(8);
    }

    public void bOL() {
        this.hRf.setVisibility(8);
        this.hRj.setVisibility(8);
        this.hQW.setVisibility(0);
        l.a(this.hQS.getActivity(), this.hRg);
    }

    public void X(View.OnClickListener onClickListener) {
        this.hRf.setOnClickListener(onClickListener);
        this.hRj.setOnClickListener(onClickListener);
        this.hQW.setOnClickListener(onClickListener);
    }

    public String bOM() {
        if (this.hRg == null || this.hRg.getText() == null) {
            return null;
        }
        return this.hRg.getText().toString();
    }

    public void bON() {
        if (this.hRk != null) {
            this.hRk.setText(e.j.tip_url_not_match);
            al.h(this.hRk, e.d.cp_other_b);
        }
    }

    public void Y(View.OnClickListener onClickListener) {
        if (this.hRi != null) {
            this.hRi.setOnClickListener(onClickListener);
        }
    }

    public View bOO() {
        return this.hRf;
    }

    public void destroy() {
        if (this.hQV != null) {
            this.hQV.addTextChangedListener(null);
        }
        if (this.hRg != null) {
            this.hRg.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.am(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aI(this.hQS.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.hQS.getPageContext().getPageActivity().getString(e.j.sand_fail);
                }
                this.hQS.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.bdN.d(null);
        this.bdN.dA(e.j.sending);
        this.bdN.bj(true);
    }

    public void closeLoadingDialog() {
        this.bdN.bj(false);
    }
}
