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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes3.dex */
public class k {
    private com.baidu.tbadk.core.view.a aVW;
    private View abt;
    private View eIV;
    private TbImageView eNn;
    private RelativeLayout fMH;
    private TextView hAa;
    private TbImageView hAb;
    private EditText hAc;
    private View hAd;
    private LinearLayout hAe;
    private ImageView hAf;
    private View hAg;
    private TextView hAh;
    private TextView hAi;
    private View hAj;
    private TextView hAk;
    private TextView hAl;
    private LinearLayout hAm;
    private EditText hAn;
    private View hAo;
    private TextView hAp;
    private FrameLayout hAq;
    private TextView hAr;
    private WriteUrlActivity hzZ;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.eIV = null;
        this.aVW = null;
        if (writeUrlActivity != null) {
            this.hzZ = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.abt = LayoutInflater.from(this.hzZ.getPageContext().getPageActivity()).inflate(d.i.write_url_activity_layout, (ViewGroup) null);
            this.hzZ.setContentView(this.abt);
            this.mNavigationBar = (NavigationBar) this.abt.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.eIV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eIV.getLayoutParams();
                layoutParams.leftMargin = l.e(this.hzZ.getActivity(), d.e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.eIV != null && (this.eIV.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eIV.getLayoutParams();
                layoutParams2.width = -2;
                this.eIV.setLayoutParams(layoutParams2);
            }
            this.abt.setOnClickListener(this.mClickListener);
            this.hAa = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.k.send_post));
            am.c(this.hAa, d.C0142d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hAa.getLayoutParams();
            layoutParams3.rightMargin = l.e(this.hzZ.getActivity(), d.e.ds16);
            this.hAa.setLayoutParams(layoutParams3);
            this.hAa.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.k.post_new_thread));
            this.hAb = (TbImageView) this.abt.findViewById(d.g.imageview_picture);
            this.hAb.setDefaultResource(d.f.ic_post_url_n);
            this.hAb.setDefaultErrorResource(d.f.ic_post_url_n);
            this.hAb.setDefaultBgResource(d.C0142d.black_alpha0);
            this.hAe = (LinearLayout) this.abt.findViewById(d.g.view_picture_publish);
            this.hAe.setOnClickListener(this.mClickListener);
            this.fMH = (RelativeLayout) this.abt.findViewById(d.g.video_container);
            this.fMH.setOnClickListener(this.mClickListener);
            this.eNn = (TbImageView) this.abt.findViewById(d.g.video_img_thumbnail);
            this.eNn.setDefaultErrorResource(0);
            this.eNn.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.eNn.setDefaultBgResource(d.C0142d.black_alpha0);
            this.hAf = (ImageView) this.abt.findViewById(d.g.video_img_play);
            this.hAg = this.abt.findViewById(d.g.video_view_delete);
            this.hAg.setOnClickListener(this.mClickListener);
            this.hAh = (TextView) this.abt.findViewById(d.g.textview_title);
            this.hAi = (TextView) this.abt.findViewById(d.g.textview_abstract);
            this.hAj = this.abt.findViewById(d.g.view_delete);
            this.hAj.setOnClickListener(this.mClickListener);
            this.hAd = this.abt.findViewById(d.g.icon_invoke_link);
            this.hAd.setOnClickListener(this.mClickListener);
            this.hAc = (EditText) this.abt.findViewById(d.g.post_content);
            this.hAk = (TextView) this.abt.findViewById(d.g.textview_error_tip);
            this.hAl = (TextView) this.abt.findViewById(d.g.textview_url);
            this.hAm = (LinearLayout) this.abt.findViewById(d.g.url_edit_container);
            this.hAn = (EditText) this.abt.findViewById(d.g.url_input);
            this.hAr = (TextView) this.abt.findViewById(d.g.url_desc);
            this.hAo = this.abt.findViewById(d.g.url_input_clear);
            this.hAp = (TextView) this.abt.findViewById(d.g.url_add);
            this.hAp.setEnabled(false);
            this.hAq = (FrameLayout) this.abt.findViewById(d.g.url_edit_back_view);
            this.hAn.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.hAo.setVisibility(8);
                        am.h(k.this.hAp, d.C0142d.cp_cont_e);
                        k.this.hAp.setEnabled(false);
                        return;
                    }
                    k.this.hAo.setVisibility(0);
                    am.h(k.this.hAp, d.C0142d.cp_link_tip_a);
                    k.this.hAp.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.hAr.getText().equals(k.this.hzZ.getActivity().getString(d.k.tip_url_not_match))) {
                        k.this.bJK();
                    }
                }
            });
            this.hAo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.hAn.setText("");
                    k.this.hAo.setVisibility(8);
                    k.this.hAp.setEnabled(false);
                }
            });
            this.aVW = new com.baidu.tbadk.core.view.a(this.hzZ.getPageContext());
            bJK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJK() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.hAr.setText(d.k.tip_url_post);
        } else {
            this.hAr.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        am.h(this.hAr, d.C0142d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.hzZ.setIsLoading(z);
        if (z) {
            this.hAe.setVisibility(0);
            this.fMH.setVisibility(8);
            this.hAb.startLoad(null, 10, false);
            this.hAh.setVisibility(8);
            this.hAi.setVisibility(8);
            this.hAk.setVisibility(8);
            this.hAl.setVisibility(0);
            am.h(this.hAl, d.C0142d.cp_cont_f);
            this.hAl.setText(d.k.tip_url_loading);
        } else if (aVar == null) {
            this.hAe.setVisibility(8);
            this.fMH.setVisibility(8);
            bJL();
        } else {
            if (aVar.hui == 1) {
                this.hAe.setVisibility(0);
                this.fMH.setVisibility(8);
                if (aVar.huh) {
                    this.hAb.startLoad(aVar.huk, 10, false);
                    this.hAh.setText(aVar.agM);
                    this.hAi.setText(aVar.agN);
                    if (ap.eM(aVar.agM) > 30) {
                        this.hAh.setMaxLines(2);
                        this.hAi.setMaxLines(1);
                    } else {
                        this.hAh.setMaxLines(1);
                        this.hAi.setMaxLines(2);
                    }
                    this.hAh.setVisibility(0);
                    this.hAi.setVisibility(0);
                    this.hAl.setVisibility(8);
                    this.hAk.setVisibility(8);
                } else {
                    this.hAb.reset();
                    this.hAl.setText(aVar.linkUrl);
                    am.h(this.hAl, d.C0142d.cp_cont_b);
                    this.hAh.setVisibility(8);
                    this.hAi.setVisibility(8);
                    this.hAl.setVisibility(0);
                    this.hAk.setVisibility(0);
                }
            } else if (aVar.hui == 2) {
                this.hAe.setVisibility(8);
                this.fMH.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.fMH.getLayoutParams();
                layoutParams.height = ((l.ah(this.hzZ.getPageContext().getPageActivity()) - ((int) this.hzZ.getPageContext().getPageActivity().getResources().getDimension(d.e.ds80))) * 9) / 16;
                this.fMH.setLayoutParams(layoutParams);
                am.c(this.hAf, d.f.icon_play_video);
                am.i(this.hAg, d.f.btn_delete_url);
                this.eNn.startLoad(aVar.hun, 10, false);
            } else {
                this.hAe.setVisibility(0);
                this.fMH.setVisibility(8);
                this.hAh.setVisibility(8);
                this.hAi.setVisibility(8);
                this.hAl.setVisibility(0);
                this.hAk.setVisibility(0);
                this.hAb.reset();
                this.hAl.setText(aVar.linkUrl);
                am.h(this.hAl, d.C0142d.cp_cont_b);
            }
            bJL();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.hAc.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.hzZ != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hzZ.getPageContext(), i);
            }
            am.j(this.mNavigationBar, d.C0142d.cp_bg_line_d);
            am.j(this.abt, d.C0142d.cp_bg_line_d);
            this.hAc.setHintTextColor(am.getColor(d.C0142d.cp_cont_e));
            this.hAc.setTextColor(am.getColor(d.C0142d.cp_cont_f));
            am.j(this.hAe, d.C0142d.cp_bg_line_e);
            am.h(this.hAh, d.C0142d.cp_cont_b);
            am.h(this.hAi, d.C0142d.cp_cont_d);
            am.h(this.hAl, d.C0142d.cp_cont_b);
            am.j(this.hAk, d.C0142d.cp_bg_line_d);
            am.h(this.hAk, d.C0142d.cp_cont_d);
            am.i(this.hAd, d.f.bg_link_invoke);
            am.j(this.hAm, d.C0142d.cp_bg_line_d);
            this.hAn.setHintTextColor(am.getColor(d.C0142d.cp_cont_e));
            am.h(this.hAn, d.C0142d.cp_cont_b);
            am.h(this.hAr, d.C0142d.cp_cont_d);
            am.h(this.hAp, d.C0142d.cp_cont_e);
            am.c(this.hAf, d.f.home_ic_video);
            am.i(this.hAj, d.f.btn_delete_url);
            am.i(this.hAo, d.f.btn_delete_url);
            am.i(this.hAg, d.f.btn_delete_url);
            bJL();
        }
    }

    public void bJL() {
        boolean z;
        if (StringUtils.isNull(bJM())) {
            z = this.hAe.getVisibility() == 0 || this.fMH.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            am.b(this.hAa, d.C0142d.cp_link_tip_a, d.C0142d.s_navbar_title_color);
            this.hAa.setEnabled(true);
            return;
        }
        am.c(this.hAa, d.C0142d.cp_cont_d, 1);
        this.hAa.setEnabled(false);
    }

    public String bJM() {
        if (this.hAc == null || this.hAc.getText() == null) {
            return null;
        }
        return this.hAc.getText().toString();
    }

    public View aMn() {
        return this.eIV;
    }

    public View bJN() {
        return this.hAa;
    }

    public View getRootView() {
        return this.abt;
    }

    public EditText bJO() {
        return this.hAc;
    }

    public View bJP() {
        return this.hAj;
    }

    public View bJQ() {
        return this.hAg;
    }

    public View bJR() {
        return this.hAe;
    }

    public View getVideoContainer() {
        return this.fMH;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.hAn.setText(aVar.linkUrl);
            this.hAn.setSelection(aVar.linkUrl.length());
        }
        this.hAn.requestFocus();
        l.c(this.hzZ.getActivity(), this.hAn);
        this.hAm.setVisibility(0);
        this.hAq.setVisibility(0);
        this.hAd.setVisibility(8);
    }

    public void bJS() {
        this.hAm.setVisibility(8);
        this.hAq.setVisibility(8);
        this.hAd.setVisibility(0);
        l.b(this.hzZ.getActivity(), this.hAn);
    }

    public void aa(View.OnClickListener onClickListener) {
        this.hAm.setOnClickListener(onClickListener);
        this.hAq.setOnClickListener(onClickListener);
        this.hAd.setOnClickListener(onClickListener);
    }

    public String bJT() {
        if (this.hAn == null || this.hAn.getText() == null) {
            return null;
        }
        return this.hAn.getText().toString();
    }

    public void bJU() {
        if (this.hAr != null) {
            this.hAr.setText(d.k.tip_url_not_match);
            am.h(this.hAr, d.C0142d.cp_other_b);
        }
    }

    public void ab(View.OnClickListener onClickListener) {
        if (this.hAp != null) {
            this.hAp.setOnClickListener(onClickListener);
        }
    }

    public View bJV() {
        return this.hAm;
    }

    public void destroy() {
        if (this.hAc != null) {
            this.hAc.addTextChangedListener(null);
        }
        if (this.hAn != null) {
            this.hAn.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.tQ(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ao(this.hzZ.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.hzZ.getPageContext().getPageActivity().getString(d.k.sand_fail);
                }
                this.hzZ.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.aVW.d(null);
        this.aVW.dd(d.k.sending);
        this.aVW.aO(true);
    }

    public void closeLoadingDialog() {
        this.aVW.aO(false);
    }
}
