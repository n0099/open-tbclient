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
    private View fbO;
    private TbImageView fgh;
    private RelativeLayout gcj;
    private WriteUrlActivity hQT;
    private TextView hQU;
    private TbImageView hQV;
    private EditText hQW;
    private View hQX;
    private LinearLayout hQY;
    private ImageView hQZ;
    private View hRa;
    private TextView hRb;
    private TextView hRc;
    private View hRd;
    private TextView hRe;
    private TextView hRf;
    private LinearLayout hRg;
    private EditText hRh;
    private View hRi;
    private TextView hRj;
    private FrameLayout hRk;
    private TextView hRl;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.fbO = null;
        this.bdN = null;
        if (writeUrlActivity != null) {
            this.hQT = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.aix = LayoutInflater.from(this.hQT.getPageContext().getPageActivity()).inflate(e.h.write_url_activity_layout, (ViewGroup) null);
            this.hQT.setContentView(this.aix);
            this.mNavigationBar = (NavigationBar) this.aix.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.fbO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(e.f.write_close_selector, e.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fbO.getLayoutParams();
                layoutParams.leftMargin = l.h(this.hQT.getActivity(), e.C0175e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.fbO != null && (this.fbO.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fbO.getLayoutParams();
                layoutParams2.width = -2;
                this.fbO.setLayoutParams(layoutParams2);
            }
            this.aix.setOnClickListener(this.mClickListener);
            this.hQU = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(e.j.send_post));
            al.c(this.hQU, e.d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hQU.getLayoutParams();
            layoutParams3.rightMargin = l.h(this.hQT.getActivity(), e.C0175e.ds16);
            this.hQU.setLayoutParams(layoutParams3);
            this.hQU.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(e.j.post_new_thread));
            this.hQV = (TbImageView) this.aix.findViewById(e.g.imageview_picture);
            this.hQV.setDefaultResource(e.f.ic_post_url_n);
            this.hQV.setDefaultErrorResource(e.f.ic_post_url_n);
            this.hQV.setDefaultBgResource(e.d.black_alpha0);
            this.hQY = (LinearLayout) this.aix.findViewById(e.g.view_picture_publish);
            this.hQY.setOnClickListener(this.mClickListener);
            this.gcj = (RelativeLayout) this.aix.findViewById(e.g.video_container);
            this.gcj.setOnClickListener(this.mClickListener);
            this.fgh = (TbImageView) this.aix.findViewById(e.g.video_img_thumbnail);
            this.fgh.setDefaultErrorResource(0);
            this.fgh.setDefaultBgResource(e.f.pic_bg_video_frs);
            this.fgh.setDefaultBgResource(e.d.black_alpha0);
            this.hQZ = (ImageView) this.aix.findViewById(e.g.video_img_play);
            this.hRa = this.aix.findViewById(e.g.video_view_delete);
            this.hRa.setOnClickListener(this.mClickListener);
            this.hRb = (TextView) this.aix.findViewById(e.g.textview_title);
            this.hRc = (TextView) this.aix.findViewById(e.g.textview_abstract);
            this.hRd = this.aix.findViewById(e.g.view_delete);
            this.hRd.setOnClickListener(this.mClickListener);
            this.hQX = this.aix.findViewById(e.g.icon_invoke_link);
            this.hQX.setOnClickListener(this.mClickListener);
            this.hQW = (EditText) this.aix.findViewById(e.g.post_content);
            this.hRe = (TextView) this.aix.findViewById(e.g.textview_error_tip);
            this.hRf = (TextView) this.aix.findViewById(e.g.textview_url);
            this.hRg = (LinearLayout) this.aix.findViewById(e.g.url_edit_container);
            this.hRh = (EditText) this.aix.findViewById(e.g.url_input);
            this.hRl = (TextView) this.aix.findViewById(e.g.url_desc);
            this.hRi = this.aix.findViewById(e.g.url_input_clear);
            this.hRj = (TextView) this.aix.findViewById(e.g.url_add);
            this.hRj.setEnabled(false);
            this.hRk = (FrameLayout) this.aix.findViewById(e.g.url_edit_back_view);
            this.hRh.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.hRi.setVisibility(8);
                        al.h(k.this.hRj, e.d.cp_cont_e);
                        k.this.hRj.setEnabled(false);
                        return;
                    }
                    k.this.hRi.setVisibility(0);
                    al.h(k.this.hRj, e.d.cp_link_tip_a);
                    k.this.hRj.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.hRl.getText().equals(k.this.hQT.getActivity().getString(e.j.tip_url_not_match))) {
                        k.this.bOD();
                    }
                }
            });
            this.hRi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.hRh.setText("");
                    k.this.hRi.setVisibility(8);
                    k.this.hRj.setEnabled(false);
                }
            });
            this.bdN = new com.baidu.tbadk.core.view.d(this.hQT.getPageContext());
            bOD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOD() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.hRl.setText(e.j.tip_url_post);
        } else {
            this.hRl.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        al.h(this.hRl, e.d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.hQT.setIsLoading(z);
        if (z) {
            this.hQY.setVisibility(0);
            this.gcj.setVisibility(8);
            this.hQV.startLoad(null, 10, false);
            this.hRb.setVisibility(8);
            this.hRc.setVisibility(8);
            this.hRe.setVisibility(8);
            this.hRf.setVisibility(0);
            al.h(this.hRf, e.d.cp_cont_f);
            this.hRf.setText(e.j.tip_url_loading);
        } else if (aVar == null) {
            this.hQY.setVisibility(8);
            this.gcj.setVisibility(8);
            bOE();
        } else {
            if (aVar.hKz == 1) {
                this.hQY.setVisibility(0);
                this.gcj.setVisibility(8);
                if (aVar.hKy) {
                    this.hQV.startLoad(aVar.hKB, 10, false);
                    this.hRb.setText(aVar.anB);
                    this.hRc.setText(aVar.anC);
                    if (ao.fq(aVar.anB) > 30) {
                        this.hRb.setMaxLines(2);
                        this.hRc.setMaxLines(1);
                    } else {
                        this.hRb.setMaxLines(1);
                        this.hRc.setMaxLines(2);
                    }
                    this.hRb.setVisibility(0);
                    this.hRc.setVisibility(0);
                    this.hRf.setVisibility(8);
                    this.hRe.setVisibility(8);
                } else {
                    this.hQV.reset();
                    this.hRf.setText(aVar.linkUrl);
                    al.h(this.hRf, e.d.cp_cont_b);
                    this.hRb.setVisibility(8);
                    this.hRc.setVisibility(8);
                    this.hRf.setVisibility(0);
                    this.hRe.setVisibility(0);
                }
            } else if (aVar.hKz == 2) {
                this.hQY.setVisibility(8);
                this.gcj.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.gcj.getLayoutParams();
                layoutParams.height = ((l.aO(this.hQT.getPageContext().getPageActivity()) - ((int) this.hQT.getPageContext().getPageActivity().getResources().getDimension(e.C0175e.ds80))) * 9) / 16;
                this.gcj.setLayoutParams(layoutParams);
                al.c(this.hQZ, e.f.icon_play_video);
                al.i(this.hRa, e.f.btn_delete_url);
                this.fgh.startLoad(aVar.hKE, 10, false);
            } else {
                this.hQY.setVisibility(0);
                this.gcj.setVisibility(8);
                this.hRb.setVisibility(8);
                this.hRc.setVisibility(8);
                this.hRf.setVisibility(0);
                this.hRe.setVisibility(0);
                this.hQV.reset();
                this.hRf.setText(aVar.linkUrl);
                al.h(this.hRf, e.d.cp_cont_b);
            }
            bOE();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.hQW.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.hQT != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hQT.getPageContext(), i);
            }
            al.j(this.mNavigationBar, e.d.cp_bg_line_d);
            al.j(this.aix, e.d.cp_bg_line_d);
            this.hQW.setHintTextColor(al.getColor(e.d.cp_cont_e));
            this.hQW.setTextColor(al.getColor(e.d.cp_cont_f));
            al.j(this.hQY, e.d.cp_bg_line_e);
            al.h(this.hRb, e.d.cp_cont_b);
            al.h(this.hRc, e.d.cp_cont_d);
            al.h(this.hRf, e.d.cp_cont_b);
            al.j(this.hRe, e.d.cp_bg_line_d);
            al.h(this.hRe, e.d.cp_cont_d);
            al.i(this.hQX, e.f.bg_link_invoke);
            al.j(this.hRg, e.d.cp_bg_line_d);
            this.hRh.setHintTextColor(al.getColor(e.d.cp_cont_e));
            al.h(this.hRh, e.d.cp_cont_b);
            al.h(this.hRl, e.d.cp_cont_d);
            al.h(this.hRj, e.d.cp_cont_e);
            al.c(this.hQZ, e.f.home_ic_video);
            al.i(this.hRd, e.f.btn_delete_url);
            al.i(this.hRi, e.f.btn_delete_url);
            al.i(this.hRa, e.f.btn_delete_url);
            bOE();
        }
    }

    public void bOE() {
        boolean z;
        if (StringUtils.isNull(bOF())) {
            z = this.hQY.getVisibility() == 0 || this.gcj.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            al.b(this.hQU, e.d.cp_link_tip_a, e.d.s_navbar_title_color);
            this.hQU.setEnabled(true);
            return;
        }
        al.c(this.hQU, e.d.cp_cont_d, 1);
        this.hQU.setEnabled(false);
    }

    public String bOF() {
        if (this.hQW == null || this.hQW.getText() == null) {
            return null;
        }
        return this.hQW.getText().toString();
    }

    public View aSN() {
        return this.fbO;
    }

    public View bOG() {
        return this.hQU;
    }

    public View getRootView() {
        return this.aix;
    }

    public EditText bOH() {
        return this.hQW;
    }

    public View bOI() {
        return this.hRd;
    }

    public View bOJ() {
        return this.hRa;
    }

    public View bOK() {
        return this.hQY;
    }

    public View getVideoContainer() {
        return this.gcj;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.hRh.setText(aVar.linkUrl);
            this.hRh.setSelection(aVar.linkUrl.length());
        }
        this.hRh.requestFocus();
        l.b(this.hQT.getActivity(), this.hRh);
        this.hRg.setVisibility(0);
        this.hRk.setVisibility(0);
        this.hQX.setVisibility(8);
    }

    public void bOL() {
        this.hRg.setVisibility(8);
        this.hRk.setVisibility(8);
        this.hQX.setVisibility(0);
        l.a(this.hQT.getActivity(), this.hRh);
    }

    public void X(View.OnClickListener onClickListener) {
        this.hRg.setOnClickListener(onClickListener);
        this.hRk.setOnClickListener(onClickListener);
        this.hQX.setOnClickListener(onClickListener);
    }

    public String bOM() {
        if (this.hRh == null || this.hRh.getText() == null) {
            return null;
        }
        return this.hRh.getText().toString();
    }

    public void bON() {
        if (this.hRl != null) {
            this.hRl.setText(e.j.tip_url_not_match);
            al.h(this.hRl, e.d.cp_other_b);
        }
    }

    public void Y(View.OnClickListener onClickListener) {
        if (this.hRj != null) {
            this.hRj.setOnClickListener(onClickListener);
        }
    }

    public View bOO() {
        return this.hRg;
    }

    public void destroy() {
        if (this.hQW != null) {
            this.hQW.addTextChangedListener(null);
        }
        if (this.hRh != null) {
            this.hRh.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.am(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aI(this.hQT.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.hQT.getPageContext().getPageActivity().getString(e.j.sand_fail);
                }
                this.hQT.showToast(errorString);
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
