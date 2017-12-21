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
    private View Sf;
    private com.baidu.tbadk.core.view.b aME;
    private View ecd;
    private TbImageView eiW;
    private RelativeLayout fjV;
    private EditText hnA;
    private View hnB;
    private TextView hnC;
    private FrameLayout hnD;
    private TextView hnE;
    private WriteUrlActivity hnm;
    private TextView hnn;
    private TbImageView hno;
    private EditText hnp;
    private View hnq;
    private LinearLayout hnr;
    private ImageView hns;
    private View hnt;
    private TextView hnu;
    private TextView hnv;
    private View hnw;
    private TextView hnx;
    private TextView hny;
    private LinearLayout hnz;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public j(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.ecd = null;
        this.aME = null;
        if (writeUrlActivity != null) {
            this.hnm = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.Sf = LayoutInflater.from(this.hnm.getPageContext().getPageActivity()).inflate(d.h.write_url_activity_layout, (ViewGroup) null);
            this.hnm.setContentView(this.Sf);
            this.mNavigationBar = (NavigationBar) this.Sf.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.ecd = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ecd.getLayoutParams();
                layoutParams.leftMargin = l.f(this.hnm.getActivity(), d.e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.ecd != null && (this.ecd.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ecd.getLayoutParams();
                layoutParams2.width = -2;
                this.ecd.setLayoutParams(layoutParams2);
            }
            this.Sf.setOnClickListener(this.mClickListener);
            this.hnn = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.j.send_post));
            aj.c(this.hnn, d.C0095d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hnn.getLayoutParams();
            layoutParams3.rightMargin = l.f(this.hnm.getActivity(), d.e.ds16);
            this.hnn.setLayoutParams(layoutParams3);
            this.hnn.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.j.post_new_thread));
            this.hno = (TbImageView) this.Sf.findViewById(d.g.imageview_picture);
            this.hno.setDefaultResource(d.f.ic_post_url_n);
            this.hno.setDefaultErrorResource(d.f.ic_post_url_n);
            this.hno.setDefaultBgResource(d.C0095d.black_alpha0);
            this.hnr = (LinearLayout) this.Sf.findViewById(d.g.view_picture_publish);
            this.hnr.setOnClickListener(this.mClickListener);
            this.fjV = (RelativeLayout) this.Sf.findViewById(d.g.video_container);
            this.fjV.setOnClickListener(this.mClickListener);
            this.eiW = (TbImageView) this.Sf.findViewById(d.g.video_img_thumbnail);
            this.eiW.setDefaultErrorResource(0);
            this.eiW.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.eiW.setDefaultBgResource(d.C0095d.black_alpha0);
            this.hns = (ImageView) this.Sf.findViewById(d.g.video_img_play);
            this.hnt = this.Sf.findViewById(d.g.video_view_delete);
            this.hnt.setOnClickListener(this.mClickListener);
            this.hnu = (TextView) this.Sf.findViewById(d.g.textview_title);
            this.hnv = (TextView) this.Sf.findViewById(d.g.textview_abstract);
            this.hnw = this.Sf.findViewById(d.g.view_delete);
            this.hnw.setOnClickListener(this.mClickListener);
            this.hnq = this.Sf.findViewById(d.g.icon_invoke_link);
            this.hnq.setOnClickListener(this.mClickListener);
            this.hnp = (EditText) this.Sf.findViewById(d.g.post_content);
            this.hnx = (TextView) this.Sf.findViewById(d.g.textview_error_tip);
            this.hny = (TextView) this.Sf.findViewById(d.g.textview_url);
            this.hnz = (LinearLayout) this.Sf.findViewById(d.g.url_edit_container);
            this.hnA = (EditText) this.Sf.findViewById(d.g.url_input);
            this.hnE = (TextView) this.Sf.findViewById(d.g.url_desc);
            this.hnB = this.Sf.findViewById(d.g.url_input_clear);
            this.hnC = (TextView) this.Sf.findViewById(d.g.url_add);
            this.hnC.setEnabled(false);
            this.hnD = (FrameLayout) this.Sf.findViewById(d.g.url_edit_back_view);
            this.hnA.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.j.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        j.this.hnB.setVisibility(8);
                        aj.i(j.this.hnC, d.C0095d.cp_cont_e);
                        j.this.hnC.setEnabled(false);
                        return;
                    }
                    j.this.hnB.setVisibility(0);
                    aj.i(j.this.hnC, d.C0095d.cp_link_tip_a);
                    j.this.hnC.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (j.this.hnE.getText().equals(j.this.hnm.getActivity().getString(d.j.tip_url_not_match))) {
                        j.this.bJi();
                    }
                }
            });
            this.hnB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.hnA.setText("");
                    j.this.hnB.setVisibility(8);
                    j.this.hnC.setEnabled(false);
                }
            });
            this.aME = new com.baidu.tbadk.core.view.b(this.hnm.getPageContext());
            bJi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJi() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.hnE.setText(d.j.tip_url_post);
        } else {
            this.hnE.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        aj.i(this.hnE, d.C0095d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.hnm.setIsLoading(z);
        if (z) {
            this.hnr.setVisibility(0);
            this.fjV.setVisibility(8);
            this.hno.startLoad(null, 10, false);
            this.hnu.setVisibility(8);
            this.hnv.setVisibility(8);
            this.hnx.setVisibility(8);
            this.hny.setVisibility(0);
            aj.i(this.hny, d.C0095d.cp_cont_f);
            this.hny.setText(d.j.tip_url_loading);
        } else if (aVar == null) {
            this.hnr.setVisibility(8);
            this.fjV.setVisibility(8);
            bJj();
        } else {
            if (aVar.hgL == 1) {
                this.hnr.setVisibility(0);
                this.fjV.setVisibility(8);
                if (aVar.hgK) {
                    this.hno.startLoad(aVar.hgN, 10, false);
                    this.hnu.setText(aVar.Xo);
                    this.hnv.setText(aVar.Xp);
                    if (am.dV(aVar.Xo) > 30) {
                        this.hnu.setMaxLines(2);
                        this.hnv.setMaxLines(1);
                    } else {
                        this.hnu.setMaxLines(1);
                        this.hnv.setMaxLines(2);
                    }
                    this.hnu.setVisibility(0);
                    this.hnv.setVisibility(0);
                    this.hny.setVisibility(8);
                    this.hnx.setVisibility(8);
                } else {
                    this.hno.reset();
                    this.hny.setText(aVar.linkUrl);
                    aj.i(this.hny, d.C0095d.cp_cont_b);
                    this.hnu.setVisibility(8);
                    this.hnv.setVisibility(8);
                    this.hny.setVisibility(0);
                    this.hnx.setVisibility(0);
                }
            } else if (aVar.hgL == 2) {
                this.hnr.setVisibility(8);
                this.fjV.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.fjV.getLayoutParams();
                layoutParams.height = ((l.ac(this.hnm.getPageContext().getPageActivity()) - ((int) this.hnm.getPageContext().getPageActivity().getResources().getDimension(d.e.ds80))) * 9) / 16;
                this.fjV.setLayoutParams(layoutParams);
                aj.c(this.hns, d.f.icon_play_video);
                aj.j(this.hnt, d.f.btn_delete_url);
                this.eiW.startLoad(aVar.hgQ, 10, false);
            } else {
                this.hnr.setVisibility(0);
                this.fjV.setVisibility(8);
                this.hnu.setVisibility(8);
                this.hnv.setVisibility(8);
                this.hny.setVisibility(0);
                this.hnx.setVisibility(0);
                this.hno.reset();
                this.hny.setText(aVar.linkUrl);
                aj.i(this.hny, d.C0095d.cp_cont_b);
            }
            bJj();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.hnp.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.hnm != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hnm.getPageContext(), i);
            }
            aj.k(this.mNavigationBar, d.C0095d.cp_bg_line_d);
            aj.k(this.Sf, d.C0095d.cp_bg_line_d);
            this.hnp.setHintTextColor(aj.getColor(d.C0095d.cp_cont_e));
            this.hnp.setTextColor(aj.getColor(d.C0095d.cp_cont_f));
            aj.k(this.hnr, d.C0095d.cp_bg_line_e);
            aj.i(this.hnu, d.C0095d.cp_cont_b);
            aj.i(this.hnv, d.C0095d.cp_cont_d);
            aj.i(this.hny, d.C0095d.cp_cont_b);
            aj.k(this.hnx, d.C0095d.cp_bg_line_d);
            aj.i(this.hnx, d.C0095d.cp_cont_d);
            aj.j(this.hnq, d.f.bg_link_invoke);
            aj.k(this.hnz, d.C0095d.cp_bg_line_d);
            this.hnA.setHintTextColor(aj.getColor(d.C0095d.cp_cont_e));
            aj.i(this.hnA, d.C0095d.cp_cont_b);
            aj.i(this.hnE, d.C0095d.cp_cont_d);
            aj.i(this.hnC, d.C0095d.cp_cont_e);
            aj.c(this.hns, d.f.home_ic_video);
            aj.j(this.hnw, d.f.btn_delete_url);
            aj.j(this.hnB, d.f.btn_delete_url);
            aj.j(this.hnt, d.f.btn_delete_url);
            bJj();
        }
    }

    public void bJj() {
        boolean z;
        if (StringUtils.isNull(bJk())) {
            z = this.hnr.getVisibility() == 0 || this.fjV.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            aj.b(this.hnn, d.C0095d.cp_link_tip_a, d.C0095d.s_navbar_title_color);
            this.hnn.setEnabled(true);
            return;
        }
        aj.c(this.hnn, d.C0095d.cp_cont_d, 1);
        this.hnn.setEnabled(false);
    }

    public String bJk() {
        if (this.hnp == null || this.hnp.getText() == null) {
            return null;
        }
        return this.hnp.getText().toString();
    }

    public View aDa() {
        return this.ecd;
    }

    public View bJl() {
        return this.hnn;
    }

    public View getRootView() {
        return this.Sf;
    }

    public EditText bJm() {
        return this.hnp;
    }

    public View btq() {
        return this.hnw;
    }

    public View bJn() {
        return this.hnt;
    }

    public View bJo() {
        return this.hnr;
    }

    public View getVideoContainer() {
        return this.fjV;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.hnA.setText(aVar.linkUrl);
            this.hnA.setSelection(aVar.linkUrl.length());
        }
        this.hnA.requestFocus();
        l.b(this.hnm.getActivity(), this.hnA);
        this.hnz.setVisibility(0);
        this.hnD.setVisibility(0);
        this.hnq.setVisibility(8);
    }

    public void bJp() {
        this.hnz.setVisibility(8);
        this.hnD.setVisibility(8);
        this.hnq.setVisibility(0);
        l.a(this.hnm.getActivity(), this.hnA);
    }

    public void X(View.OnClickListener onClickListener) {
        this.hnz.setOnClickListener(onClickListener);
        this.hnD.setOnClickListener(onClickListener);
        this.hnq.setOnClickListener(onClickListener);
    }

    public String bJq() {
        if (this.hnA == null || this.hnA.getText() == null) {
            return null;
        }
        return this.hnA.getText().toString();
    }

    public void bJr() {
        if (this.hnE != null) {
            this.hnE.setText(d.j.tip_url_not_match);
            aj.i(this.hnE, d.C0095d.cp_other_b);
        }
    }

    public void Y(View.OnClickListener onClickListener) {
        if (this.hnC != null) {
            this.hnC.setOnClickListener(onClickListener);
        }
    }

    public View bJs() {
        return this.hnz;
    }

    public void destroy() {
        if (this.hnp != null) {
            this.hnp.addTextChangedListener(null);
        }
        if (this.hnA != null) {
            this.hnA.addTextChangedListener(null);
        }
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.uB(postWriteCallBackData.getErrorCode())) {
                AntiHelper.am(this.hnm.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.hnm.getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                this.hnm.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.aME.c(null);
        this.aME.db(d.j.sending);
        this.aME.aE(true);
    }

    public void closeLoadingDialog() {
        this.aME.aE(false);
    }
}
