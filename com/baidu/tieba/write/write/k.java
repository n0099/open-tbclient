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
    private View amM;
    private com.baidu.tbadk.core.view.d bif;
    private TextView cOW;
    private View fmR;
    private TbImageView frk;
    private RelativeLayout gnp;
    private WriteUrlActivity icY;
    private TextView icZ;
    private TbImageView ida;
    private EditText idb;
    private View idc;
    private LinearLayout idd;
    private ImageView ide;
    private View idf;
    private TextView idg;
    private TextView idh;
    private View idi;
    private TextView idj;
    private LinearLayout idk;
    private EditText idm;
    private View idn;
    private TextView ido;
    private FrameLayout idp;
    private TextView idq;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.fmR = null;
        this.bif = null;
        if (writeUrlActivity != null) {
            this.icY = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.amM = LayoutInflater.from(this.icY.getPageContext().getPageActivity()).inflate(e.h.write_url_activity_layout, (ViewGroup) null);
            this.icY.setContentView(this.amM);
            this.mNavigationBar = (NavigationBar) this.amM.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.fmR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(e.f.write_close_selector, e.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fmR.getLayoutParams();
                layoutParams.leftMargin = l.h(this.icY.getActivity(), e.C0210e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.fmR != null && (this.fmR.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fmR.getLayoutParams();
                layoutParams2.width = -2;
                this.fmR.setLayoutParams(layoutParams2);
            }
            this.amM.setOnClickListener(this.mClickListener);
            this.icZ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(e.j.send_post));
            al.c(this.icZ, e.d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.icZ.getLayoutParams();
            layoutParams3.rightMargin = l.h(this.icY.getActivity(), e.C0210e.ds16);
            this.icZ.setLayoutParams(layoutParams3);
            this.icZ.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(e.j.post_new_thread));
            this.ida = (TbImageView) this.amM.findViewById(e.g.imageview_picture);
            this.ida.setDefaultResource(e.f.ic_post_url_n);
            this.ida.setDefaultErrorResource(e.f.ic_post_url_n);
            this.ida.setDefaultBgResource(e.d.black_alpha0);
            this.idd = (LinearLayout) this.amM.findViewById(e.g.view_picture_publish);
            this.idd.setOnClickListener(this.mClickListener);
            this.gnp = (RelativeLayout) this.amM.findViewById(e.g.video_container);
            this.gnp.setOnClickListener(this.mClickListener);
            this.frk = (TbImageView) this.amM.findViewById(e.g.video_img_thumbnail);
            this.frk.setDefaultErrorResource(0);
            this.frk.setDefaultBgResource(e.f.pic_bg_video_frs);
            this.frk.setDefaultBgResource(e.d.black_alpha0);
            this.ide = (ImageView) this.amM.findViewById(e.g.video_img_play);
            this.idf = this.amM.findViewById(e.g.video_view_delete);
            this.idf.setOnClickListener(this.mClickListener);
            this.idg = (TextView) this.amM.findViewById(e.g.textview_title);
            this.idh = (TextView) this.amM.findViewById(e.g.textview_abstract);
            this.idi = this.amM.findViewById(e.g.view_delete);
            this.idi.setOnClickListener(this.mClickListener);
            this.idc = this.amM.findViewById(e.g.icon_invoke_link);
            this.idc.setOnClickListener(this.mClickListener);
            this.idb = (EditText) this.amM.findViewById(e.g.post_content);
            this.cOW = (TextView) this.amM.findViewById(e.g.textview_error_tip);
            this.idj = (TextView) this.amM.findViewById(e.g.textview_url);
            this.idk = (LinearLayout) this.amM.findViewById(e.g.url_edit_container);
            this.idm = (EditText) this.amM.findViewById(e.g.url_input);
            this.idq = (TextView) this.amM.findViewById(e.g.url_desc);
            this.idn = this.amM.findViewById(e.g.url_input_clear);
            this.ido = (TextView) this.amM.findViewById(e.g.url_add);
            this.ido.setEnabled(false);
            this.idp = (FrameLayout) this.amM.findViewById(e.g.url_edit_back_view);
            this.idm.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.idn.setVisibility(8);
                        al.h(k.this.ido, e.d.cp_cont_e);
                        k.this.ido.setEnabled(false);
                        return;
                    }
                    k.this.idn.setVisibility(0);
                    al.h(k.this.ido, e.d.cp_link_tip_a);
                    k.this.ido.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.idq.getText().equals(k.this.icY.getActivity().getString(e.j.tip_url_not_match))) {
                        k.this.bQY();
                    }
                }
            });
            this.idn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.idm.setText("");
                    k.this.idn.setVisibility(8);
                    k.this.ido.setEnabled(false);
                }
            });
            this.bif = new com.baidu.tbadk.core.view.d(this.icY.getPageContext());
            bQY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQY() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.idq.setText(e.j.tip_url_post);
        } else {
            this.idq.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        al.h(this.idq, e.d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.icY.setIsLoading(z);
        if (z) {
            this.idd.setVisibility(0);
            this.gnp.setVisibility(8);
            this.ida.startLoad(null, 10, false);
            this.idg.setVisibility(8);
            this.idh.setVisibility(8);
            this.cOW.setVisibility(8);
            this.idj.setVisibility(0);
            al.h(this.idj, e.d.cp_cont_f);
            this.idj.setText(e.j.tip_url_loading);
        } else if (aVar == null) {
            this.idd.setVisibility(8);
            this.gnp.setVisibility(8);
            bQZ();
        } else {
            if (aVar.hWF == 1) {
                this.idd.setVisibility(0);
                this.gnp.setVisibility(8);
                if (aVar.hWE) {
                    this.ida.startLoad(aVar.hWH, 10, false);
                    this.idg.setText(aVar.arP);
                    this.idh.setText(aVar.arQ);
                    if (ao.fI(aVar.arP) > 30) {
                        this.idg.setMaxLines(2);
                        this.idh.setMaxLines(1);
                    } else {
                        this.idg.setMaxLines(1);
                        this.idh.setMaxLines(2);
                    }
                    this.idg.setVisibility(0);
                    this.idh.setVisibility(0);
                    this.idj.setVisibility(8);
                    this.cOW.setVisibility(8);
                } else {
                    this.ida.reset();
                    this.idj.setText(aVar.linkUrl);
                    al.h(this.idj, e.d.cp_cont_b);
                    this.idg.setVisibility(8);
                    this.idh.setVisibility(8);
                    this.idj.setVisibility(0);
                    this.cOW.setVisibility(0);
                }
            } else if (aVar.hWF == 2) {
                this.idd.setVisibility(8);
                this.gnp.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.gnp.getLayoutParams();
                layoutParams.height = ((l.aO(this.icY.getPageContext().getPageActivity()) - ((int) this.icY.getPageContext().getPageActivity().getResources().getDimension(e.C0210e.ds80))) * 9) / 16;
                this.gnp.setLayoutParams(layoutParams);
                al.c(this.ide, e.f.icon_play_video);
                al.i(this.idf, e.f.btn_delete_url);
                this.frk.startLoad(aVar.hWK, 10, false);
            } else {
                this.idd.setVisibility(0);
                this.gnp.setVisibility(8);
                this.idg.setVisibility(8);
                this.idh.setVisibility(8);
                this.idj.setVisibility(0);
                this.cOW.setVisibility(0);
                this.ida.reset();
                this.idj.setText(aVar.linkUrl);
                al.h(this.idj, e.d.cp_cont_b);
            }
            bQZ();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.idb.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.icY != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.icY.getPageContext(), i);
            }
            al.j(this.mNavigationBar, e.d.cp_bg_line_d);
            al.j(this.amM, e.d.cp_bg_line_d);
            this.idb.setHintTextColor(al.getColor(e.d.cp_cont_e));
            this.idb.setTextColor(al.getColor(e.d.cp_cont_f));
            al.j(this.idd, e.d.cp_bg_line_e);
            al.h(this.idg, e.d.cp_cont_b);
            al.h(this.idh, e.d.cp_cont_d);
            al.h(this.idj, e.d.cp_cont_b);
            al.j(this.cOW, e.d.cp_bg_line_d);
            al.h(this.cOW, e.d.cp_cont_d);
            al.i(this.idc, e.f.bg_link_invoke);
            al.j(this.idk, e.d.cp_bg_line_d);
            this.idm.setHintTextColor(al.getColor(e.d.cp_cont_e));
            al.h(this.idm, e.d.cp_cont_b);
            al.h(this.idq, e.d.cp_cont_d);
            al.h(this.ido, e.d.cp_cont_e);
            al.c(this.ide, e.f.home_ic_video);
            al.i(this.idi, e.f.btn_delete_url);
            al.i(this.idn, e.f.btn_delete_url);
            al.i(this.idf, e.f.btn_delete_url);
            bQZ();
        }
    }

    public void bQZ() {
        boolean z;
        if (StringUtils.isNull(bRa())) {
            z = this.idd.getVisibility() == 0 || this.gnp.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            al.b(this.icZ, e.d.cp_link_tip_a, e.d.s_navbar_title_color);
            this.icZ.setEnabled(true);
            return;
        }
        al.c(this.icZ, e.d.cp_cont_d, 1);
        this.icZ.setEnabled(false);
    }

    public String bRa() {
        if (this.idb == null || this.idb.getText() == null) {
            return null;
        }
        return this.idb.getText().toString();
    }

    public View aUP() {
        return this.fmR;
    }

    public View bRb() {
        return this.icZ;
    }

    public View getRootView() {
        return this.amM;
    }

    public EditText bRc() {
        return this.idb;
    }

    public View bRd() {
        return this.idi;
    }

    public View bRe() {
        return this.idf;
    }

    public View bRf() {
        return this.idd;
    }

    public View getVideoContainer() {
        return this.gnp;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.idm.setText(aVar.linkUrl);
            this.idm.setSelection(aVar.linkUrl.length());
        }
        this.idm.requestFocus();
        l.c(this.icY.getActivity(), this.idm);
        this.idk.setVisibility(0);
        this.idp.setVisibility(0);
        this.idc.setVisibility(8);
    }

    public void bRg() {
        this.idk.setVisibility(8);
        this.idp.setVisibility(8);
        this.idc.setVisibility(0);
        l.b(this.icY.getActivity(), this.idm);
    }

    public void Z(View.OnClickListener onClickListener) {
        this.idk.setOnClickListener(onClickListener);
        this.idp.setOnClickListener(onClickListener);
        this.idc.setOnClickListener(onClickListener);
    }

    public String bRh() {
        if (this.idm == null || this.idm.getText() == null) {
            return null;
        }
        return this.idm.getText().toString();
    }

    public void bRi() {
        if (this.idq != null) {
            this.idq.setText(e.j.tip_url_not_match);
            al.h(this.idq, e.d.cp_other_b);
        }
    }

    public void aa(View.OnClickListener onClickListener) {
        if (this.ido != null) {
            this.ido.setOnClickListener(onClickListener);
        }
    }

    public View bRj() {
        return this.idk;
    }

    public void destroy() {
        if (this.idb != null) {
            this.idb.addTextChangedListener(null);
        }
        if (this.idm != null) {
            this.idm.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.aj(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aJ(this.icY.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.icY.getPageContext().getPageActivity().getString(e.j.sand_fail);
                }
                this.icY.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.bif.d(null);
        this.bif.ec(e.j.sending);
        this.bif.bA(true);
    }

    public void closeLoadingDialog() {
        this.bif.bA(false);
    }
}
