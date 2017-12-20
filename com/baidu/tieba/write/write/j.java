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
    private View Se;
    private com.baidu.tbadk.core.view.b aMB;
    private View ebZ;
    private TbImageView eiS;
    private RelativeLayout fjQ;
    private WriteUrlActivity hnh;
    private TextView hni;
    private TbImageView hnj;
    private EditText hnk;
    private View hnl;
    private LinearLayout hnm;
    private ImageView hnn;
    private View hno;
    private TextView hnp;
    private TextView hnq;
    private View hnr;
    private TextView hns;
    private TextView hnt;
    private LinearLayout hnu;
    private EditText hnv;
    private View hnw;
    private TextView hnx;
    private FrameLayout hny;
    private TextView hnz;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public j(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.ebZ = null;
        this.aMB = null;
        if (writeUrlActivity != null) {
            this.hnh = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.Se = LayoutInflater.from(this.hnh.getPageContext().getPageActivity()).inflate(d.h.write_url_activity_layout, (ViewGroup) null);
            this.hnh.setContentView(this.Se);
            this.mNavigationBar = (NavigationBar) this.Se.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.ebZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ebZ.getLayoutParams();
                layoutParams.leftMargin = l.f(this.hnh.getActivity(), d.e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.ebZ != null && (this.ebZ.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ebZ.getLayoutParams();
                layoutParams2.width = -2;
                this.ebZ.setLayoutParams(layoutParams2);
            }
            this.Se.setOnClickListener(this.mClickListener);
            this.hni = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.j.send_post));
            aj.c(this.hni, d.C0096d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hni.getLayoutParams();
            layoutParams3.rightMargin = l.f(this.hnh.getActivity(), d.e.ds16);
            this.hni.setLayoutParams(layoutParams3);
            this.hni.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.j.post_new_thread));
            this.hnj = (TbImageView) this.Se.findViewById(d.g.imageview_picture);
            this.hnj.setDefaultResource(d.f.ic_post_url_n);
            this.hnj.setDefaultErrorResource(d.f.ic_post_url_n);
            this.hnj.setDefaultBgResource(d.C0096d.black_alpha0);
            this.hnm = (LinearLayout) this.Se.findViewById(d.g.view_picture_publish);
            this.hnm.setOnClickListener(this.mClickListener);
            this.fjQ = (RelativeLayout) this.Se.findViewById(d.g.video_container);
            this.fjQ.setOnClickListener(this.mClickListener);
            this.eiS = (TbImageView) this.Se.findViewById(d.g.video_img_thumbnail);
            this.eiS.setDefaultErrorResource(0);
            this.eiS.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.eiS.setDefaultBgResource(d.C0096d.black_alpha0);
            this.hnn = (ImageView) this.Se.findViewById(d.g.video_img_play);
            this.hno = this.Se.findViewById(d.g.video_view_delete);
            this.hno.setOnClickListener(this.mClickListener);
            this.hnp = (TextView) this.Se.findViewById(d.g.textview_title);
            this.hnq = (TextView) this.Se.findViewById(d.g.textview_abstract);
            this.hnr = this.Se.findViewById(d.g.view_delete);
            this.hnr.setOnClickListener(this.mClickListener);
            this.hnl = this.Se.findViewById(d.g.icon_invoke_link);
            this.hnl.setOnClickListener(this.mClickListener);
            this.hnk = (EditText) this.Se.findViewById(d.g.post_content);
            this.hns = (TextView) this.Se.findViewById(d.g.textview_error_tip);
            this.hnt = (TextView) this.Se.findViewById(d.g.textview_url);
            this.hnu = (LinearLayout) this.Se.findViewById(d.g.url_edit_container);
            this.hnv = (EditText) this.Se.findViewById(d.g.url_input);
            this.hnz = (TextView) this.Se.findViewById(d.g.url_desc);
            this.hnw = this.Se.findViewById(d.g.url_input_clear);
            this.hnx = (TextView) this.Se.findViewById(d.g.url_add);
            this.hnx.setEnabled(false);
            this.hny = (FrameLayout) this.Se.findViewById(d.g.url_edit_back_view);
            this.hnv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.j.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        j.this.hnw.setVisibility(8);
                        aj.i(j.this.hnx, d.C0096d.cp_cont_e);
                        j.this.hnx.setEnabled(false);
                        return;
                    }
                    j.this.hnw.setVisibility(0);
                    aj.i(j.this.hnx, d.C0096d.cp_link_tip_a);
                    j.this.hnx.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (j.this.hnz.getText().equals(j.this.hnh.getActivity().getString(d.j.tip_url_not_match))) {
                        j.this.bJh();
                    }
                }
            });
            this.hnw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.hnv.setText("");
                    j.this.hnw.setVisibility(8);
                    j.this.hnx.setEnabled(false);
                }
            });
            this.aMB = new com.baidu.tbadk.core.view.b(this.hnh.getPageContext());
            bJh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJh() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.hnz.setText(d.j.tip_url_post);
        } else {
            this.hnz.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        aj.i(this.hnz, d.C0096d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.hnh.setIsLoading(z);
        if (z) {
            this.hnm.setVisibility(0);
            this.fjQ.setVisibility(8);
            this.hnj.startLoad(null, 10, false);
            this.hnp.setVisibility(8);
            this.hnq.setVisibility(8);
            this.hns.setVisibility(8);
            this.hnt.setVisibility(0);
            aj.i(this.hnt, d.C0096d.cp_cont_f);
            this.hnt.setText(d.j.tip_url_loading);
        } else if (aVar == null) {
            this.hnm.setVisibility(8);
            this.fjQ.setVisibility(8);
            bJi();
        } else {
            if (aVar.hgG == 1) {
                this.hnm.setVisibility(0);
                this.fjQ.setVisibility(8);
                if (aVar.hgF) {
                    this.hnj.startLoad(aVar.hgI, 10, false);
                    this.hnp.setText(aVar.Xl);
                    this.hnq.setText(aVar.Xm);
                    if (am.dV(aVar.Xl) > 30) {
                        this.hnp.setMaxLines(2);
                        this.hnq.setMaxLines(1);
                    } else {
                        this.hnp.setMaxLines(1);
                        this.hnq.setMaxLines(2);
                    }
                    this.hnp.setVisibility(0);
                    this.hnq.setVisibility(0);
                    this.hnt.setVisibility(8);
                    this.hns.setVisibility(8);
                } else {
                    this.hnj.reset();
                    this.hnt.setText(aVar.linkUrl);
                    aj.i(this.hnt, d.C0096d.cp_cont_b);
                    this.hnp.setVisibility(8);
                    this.hnq.setVisibility(8);
                    this.hnt.setVisibility(0);
                    this.hns.setVisibility(0);
                }
            } else if (aVar.hgG == 2) {
                this.hnm.setVisibility(8);
                this.fjQ.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.fjQ.getLayoutParams();
                layoutParams.height = ((l.ac(this.hnh.getPageContext().getPageActivity()) - ((int) this.hnh.getPageContext().getPageActivity().getResources().getDimension(d.e.ds80))) * 9) / 16;
                this.fjQ.setLayoutParams(layoutParams);
                aj.c(this.hnn, d.f.icon_play_video);
                aj.j(this.hno, d.f.btn_delete_url);
                this.eiS.startLoad(aVar.hgL, 10, false);
            } else {
                this.hnm.setVisibility(0);
                this.fjQ.setVisibility(8);
                this.hnp.setVisibility(8);
                this.hnq.setVisibility(8);
                this.hnt.setVisibility(0);
                this.hns.setVisibility(0);
                this.hnj.reset();
                this.hnt.setText(aVar.linkUrl);
                aj.i(this.hnt, d.C0096d.cp_cont_b);
            }
            bJi();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.hnk.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.hnh != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hnh.getPageContext(), i);
            }
            aj.k(this.mNavigationBar, d.C0096d.cp_bg_line_d);
            aj.k(this.Se, d.C0096d.cp_bg_line_d);
            this.hnk.setHintTextColor(aj.getColor(d.C0096d.cp_cont_e));
            this.hnk.setTextColor(aj.getColor(d.C0096d.cp_cont_f));
            aj.k(this.hnm, d.C0096d.cp_bg_line_e);
            aj.i(this.hnp, d.C0096d.cp_cont_b);
            aj.i(this.hnq, d.C0096d.cp_cont_d);
            aj.i(this.hnt, d.C0096d.cp_cont_b);
            aj.k(this.hns, d.C0096d.cp_bg_line_d);
            aj.i(this.hns, d.C0096d.cp_cont_d);
            aj.j(this.hnl, d.f.bg_link_invoke);
            aj.k(this.hnu, d.C0096d.cp_bg_line_d);
            this.hnv.setHintTextColor(aj.getColor(d.C0096d.cp_cont_e));
            aj.i(this.hnv, d.C0096d.cp_cont_b);
            aj.i(this.hnz, d.C0096d.cp_cont_d);
            aj.i(this.hnx, d.C0096d.cp_cont_e);
            aj.c(this.hnn, d.f.home_ic_video);
            aj.j(this.hnr, d.f.btn_delete_url);
            aj.j(this.hnw, d.f.btn_delete_url);
            aj.j(this.hno, d.f.btn_delete_url);
            bJi();
        }
    }

    public void bJi() {
        boolean z;
        if (StringUtils.isNull(bJj())) {
            z = this.hnm.getVisibility() == 0 || this.fjQ.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            aj.b(this.hni, d.C0096d.cp_link_tip_a, d.C0096d.s_navbar_title_color);
            this.hni.setEnabled(true);
            return;
        }
        aj.c(this.hni, d.C0096d.cp_cont_d, 1);
        this.hni.setEnabled(false);
    }

    public String bJj() {
        if (this.hnk == null || this.hnk.getText() == null) {
            return null;
        }
        return this.hnk.getText().toString();
    }

    public View aCZ() {
        return this.ebZ;
    }

    public View bJk() {
        return this.hni;
    }

    public View getRootView() {
        return this.Se;
    }

    public EditText bJl() {
        return this.hnk;
    }

    public View btp() {
        return this.hnr;
    }

    public View bJm() {
        return this.hno;
    }

    public View bJn() {
        return this.hnm;
    }

    public View getVideoContainer() {
        return this.fjQ;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.hnv.setText(aVar.linkUrl);
            this.hnv.setSelection(aVar.linkUrl.length());
        }
        this.hnv.requestFocus();
        l.b(this.hnh.getActivity(), this.hnv);
        this.hnu.setVisibility(0);
        this.hny.setVisibility(0);
        this.hnl.setVisibility(8);
    }

    public void bJo() {
        this.hnu.setVisibility(8);
        this.hny.setVisibility(8);
        this.hnl.setVisibility(0);
        l.a(this.hnh.getActivity(), this.hnv);
    }

    public void X(View.OnClickListener onClickListener) {
        this.hnu.setOnClickListener(onClickListener);
        this.hny.setOnClickListener(onClickListener);
        this.hnl.setOnClickListener(onClickListener);
    }

    public String bJp() {
        if (this.hnv == null || this.hnv.getText() == null) {
            return null;
        }
        return this.hnv.getText().toString();
    }

    public void bJq() {
        if (this.hnz != null) {
            this.hnz.setText(d.j.tip_url_not_match);
            aj.i(this.hnz, d.C0096d.cp_other_b);
        }
    }

    public void Y(View.OnClickListener onClickListener) {
        if (this.hnx != null) {
            this.hnx.setOnClickListener(onClickListener);
        }
    }

    public View bJr() {
        return this.hnu;
    }

    public void destroy() {
        if (this.hnk != null) {
            this.hnk.addTextChangedListener(null);
        }
        if (this.hnv != null) {
            this.hnv.addTextChangedListener(null);
        }
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.uB(postWriteCallBackData.getErrorCode())) {
                AntiHelper.am(this.hnh.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.hnh.getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                this.hnh.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.aMB.c(null);
        this.aMB.db(d.j.sending);
        this.aMB.aE(true);
    }

    public void closeLoadingDialog() {
        this.aMB.aE(false);
    }
}
