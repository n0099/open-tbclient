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
    private View Sh;
    private com.baidu.tbadk.core.view.a aMx;
    private View eaU;
    private TbImageView ehN;
    private RelativeLayout fiS;
    private TextView hkA;
    private TextView hkB;
    private LinearLayout hkC;
    private EditText hkD;
    private View hkE;
    private TextView hkF;
    private FrameLayout hkG;
    private TextView hkH;
    private WriteUrlActivity hkp;
    private TextView hkq;
    private TbImageView hkr;
    private EditText hks;
    private View hkt;
    private LinearLayout hku;
    private ImageView hkv;
    private View hkw;
    private TextView hkx;
    private TextView hky;
    private View hkz;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public j(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.eaU = null;
        this.aMx = null;
        if (writeUrlActivity != null) {
            this.hkp = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.Sh = LayoutInflater.from(this.hkp.getPageContext().getPageActivity()).inflate(d.h.write_url_activity_layout, (ViewGroup) null);
            this.hkp.setContentView(this.Sh);
            this.mNavigationBar = (NavigationBar) this.Sh.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.eaU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eaU.getLayoutParams();
                layoutParams.leftMargin = l.f(this.hkp.getActivity(), d.e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.eaU != null && (this.eaU.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eaU.getLayoutParams();
                layoutParams2.width = -2;
                this.eaU.setLayoutParams(layoutParams2);
            }
            this.Sh.setOnClickListener(this.mClickListener);
            this.hkq = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.j.send_post));
            aj.c(this.hkq, d.C0082d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hkq.getLayoutParams();
            layoutParams3.rightMargin = l.f(this.hkp.getActivity(), d.e.ds16);
            this.hkq.setLayoutParams(layoutParams3);
            this.hkq.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.j.post_new_thread));
            this.hkr = (TbImageView) this.Sh.findViewById(d.g.imageview_picture);
            this.hkr.setDefaultResource(d.f.ic_post_url_n);
            this.hkr.setDefaultErrorResource(d.f.ic_post_url_n);
            this.hkr.setDefaultBgResource(d.C0082d.black_alpha0);
            this.hku = (LinearLayout) this.Sh.findViewById(d.g.view_picture_publish);
            this.hku.setOnClickListener(this.mClickListener);
            this.fiS = (RelativeLayout) this.Sh.findViewById(d.g.video_container);
            this.fiS.setOnClickListener(this.mClickListener);
            this.ehN = (TbImageView) this.Sh.findViewById(d.g.video_img_thumbnail);
            this.ehN.setDefaultErrorResource(0);
            this.ehN.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.ehN.setDefaultBgResource(d.C0082d.black_alpha0);
            this.hkv = (ImageView) this.Sh.findViewById(d.g.video_img_play);
            this.hkw = this.Sh.findViewById(d.g.video_view_delete);
            this.hkw.setOnClickListener(this.mClickListener);
            this.hkx = (TextView) this.Sh.findViewById(d.g.textview_title);
            this.hky = (TextView) this.Sh.findViewById(d.g.textview_abstract);
            this.hkz = this.Sh.findViewById(d.g.view_delete);
            this.hkz.setOnClickListener(this.mClickListener);
            this.hkt = this.Sh.findViewById(d.g.icon_invoke_link);
            this.hkt.setOnClickListener(this.mClickListener);
            this.hks = (EditText) this.Sh.findViewById(d.g.post_content);
            this.hkA = (TextView) this.Sh.findViewById(d.g.textview_error_tip);
            this.hkB = (TextView) this.Sh.findViewById(d.g.textview_url);
            this.hkC = (LinearLayout) this.Sh.findViewById(d.g.url_edit_container);
            this.hkD = (EditText) this.Sh.findViewById(d.g.url_input);
            this.hkH = (TextView) this.Sh.findViewById(d.g.url_desc);
            this.hkE = this.Sh.findViewById(d.g.url_input_clear);
            this.hkF = (TextView) this.Sh.findViewById(d.g.url_add);
            this.hkF.setEnabled(false);
            this.hkG = (FrameLayout) this.Sh.findViewById(d.g.url_edit_back_view);
            this.hkD.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.j.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        j.this.hkE.setVisibility(8);
                        aj.i(j.this.hkF, d.C0082d.cp_cont_e);
                        j.this.hkF.setEnabled(false);
                        return;
                    }
                    j.this.hkE.setVisibility(0);
                    aj.i(j.this.hkF, d.C0082d.cp_link_tip_a);
                    j.this.hkF.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (j.this.hkH.getText().equals(j.this.hkp.getActivity().getString(d.j.tip_url_not_match))) {
                        j.this.bIv();
                    }
                }
            });
            this.hkE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.hkD.setText("");
                    j.this.hkE.setVisibility(8);
                    j.this.hkF.setEnabled(false);
                }
            });
            this.aMx = new com.baidu.tbadk.core.view.a(this.hkp.getPageContext());
            bIv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIv() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.hkH.setText(d.j.tip_url_post);
        } else {
            this.hkH.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        aj.i(this.hkH, d.C0082d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.hkp.setIsLoading(z);
        if (z) {
            this.hku.setVisibility(0);
            this.fiS.setVisibility(8);
            this.hkr.startLoad(null, 10, false);
            this.hkx.setVisibility(8);
            this.hky.setVisibility(8);
            this.hkA.setVisibility(8);
            this.hkB.setVisibility(0);
            aj.i(this.hkB, d.C0082d.cp_cont_f);
            this.hkB.setText(d.j.tip_url_loading);
        } else if (aVar == null) {
            this.hku.setVisibility(8);
            this.fiS.setVisibility(8);
            bIw();
        } else {
            if (aVar.hdQ == 1) {
                this.hku.setVisibility(0);
                this.fiS.setVisibility(8);
                if (aVar.hdP) {
                    this.hkr.startLoad(aVar.hdS, 10, false);
                    this.hkx.setText(aVar.Xr);
                    this.hky.setText(aVar.Xs);
                    if (am.dV(aVar.Xr) > 30) {
                        this.hkx.setMaxLines(2);
                        this.hky.setMaxLines(1);
                    } else {
                        this.hkx.setMaxLines(1);
                        this.hky.setMaxLines(2);
                    }
                    this.hkx.setVisibility(0);
                    this.hky.setVisibility(0);
                    this.hkB.setVisibility(8);
                    this.hkA.setVisibility(8);
                } else {
                    this.hkr.reset();
                    this.hkB.setText(aVar.linkUrl);
                    aj.i(this.hkB, d.C0082d.cp_cont_b);
                    this.hkx.setVisibility(8);
                    this.hky.setVisibility(8);
                    this.hkB.setVisibility(0);
                    this.hkA.setVisibility(0);
                }
            } else if (aVar.hdQ == 2) {
                this.hku.setVisibility(8);
                this.fiS.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.fiS.getLayoutParams();
                layoutParams.height = ((l.ac(this.hkp.getPageContext().getPageActivity()) - ((int) this.hkp.getPageContext().getPageActivity().getResources().getDimension(d.e.ds80))) * 9) / 16;
                this.fiS.setLayoutParams(layoutParams);
                aj.c(this.hkv, d.f.icon_play_video);
                aj.j(this.hkw, d.f.btn_delete_url);
                this.ehN.startLoad(aVar.hdV, 10, false);
            } else {
                this.hku.setVisibility(0);
                this.fiS.setVisibility(8);
                this.hkx.setVisibility(8);
                this.hky.setVisibility(8);
                this.hkB.setVisibility(0);
                this.hkA.setVisibility(0);
                this.hkr.reset();
                this.hkB.setText(aVar.linkUrl);
                aj.i(this.hkB, d.C0082d.cp_cont_b);
            }
            bIw();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.hks.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.hkp != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hkp.getPageContext(), i);
            }
            aj.k(this.mNavigationBar, d.C0082d.cp_bg_line_d);
            aj.k(this.Sh, d.C0082d.cp_bg_line_d);
            this.hks.setHintTextColor(aj.getColor(d.C0082d.cp_cont_e));
            this.hks.setTextColor(aj.getColor(d.C0082d.cp_cont_f));
            aj.k(this.hku, d.C0082d.cp_bg_line_e);
            aj.i(this.hkx, d.C0082d.cp_cont_b);
            aj.i(this.hky, d.C0082d.cp_cont_d);
            aj.i(this.hkB, d.C0082d.cp_cont_b);
            aj.k(this.hkA, d.C0082d.cp_bg_line_d);
            aj.i(this.hkA, d.C0082d.cp_cont_d);
            aj.j(this.hkt, d.f.bg_link_invoke);
            aj.k(this.hkC, d.C0082d.cp_bg_line_d);
            this.hkD.setHintTextColor(aj.getColor(d.C0082d.cp_cont_e));
            aj.i(this.hkD, d.C0082d.cp_cont_b);
            aj.i(this.hkH, d.C0082d.cp_cont_d);
            aj.i(this.hkF, d.C0082d.cp_cont_e);
            aj.c(this.hkv, d.f.home_ic_video);
            aj.j(this.hkz, d.f.btn_delete_url);
            aj.j(this.hkE, d.f.btn_delete_url);
            aj.j(this.hkw, d.f.btn_delete_url);
            bIw();
        }
    }

    public void bIw() {
        boolean z;
        if (StringUtils.isNull(bIx())) {
            z = this.hku.getVisibility() == 0 || this.fiS.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            aj.b(this.hkq, d.C0082d.cp_link_tip_a, d.C0082d.s_navbar_title_color);
            this.hkq.setEnabled(true);
            return;
        }
        aj.c(this.hkq, d.C0082d.cp_cont_d, 1);
        this.hkq.setEnabled(false);
    }

    public String bIx() {
        if (this.hks == null || this.hks.getText() == null) {
            return null;
        }
        return this.hks.getText().toString();
    }

    public View aCR() {
        return this.eaU;
    }

    public View bIy() {
        return this.hkq;
    }

    public View getRootView() {
        return this.Sh;
    }

    public EditText bIz() {
        return this.hks;
    }

    public View bsK() {
        return this.hkz;
    }

    public View bIA() {
        return this.hkw;
    }

    public View bIB() {
        return this.hku;
    }

    public View getVideoContainer() {
        return this.fiS;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.hkD.setText(aVar.linkUrl);
            this.hkD.setSelection(aVar.linkUrl.length());
        }
        this.hkD.requestFocus();
        l.b(this.hkp.getActivity(), this.hkD);
        this.hkC.setVisibility(0);
        this.hkG.setVisibility(0);
        this.hkt.setVisibility(8);
    }

    public void bIC() {
        this.hkC.setVisibility(8);
        this.hkG.setVisibility(8);
        this.hkt.setVisibility(0);
        l.a(this.hkp.getActivity(), this.hkD);
    }

    public void X(View.OnClickListener onClickListener) {
        this.hkC.setOnClickListener(onClickListener);
        this.hkG.setOnClickListener(onClickListener);
        this.hkt.setOnClickListener(onClickListener);
    }

    public String bID() {
        if (this.hkD == null || this.hkD.getText() == null) {
            return null;
        }
        return this.hkD.getText().toString();
    }

    public void bIE() {
        if (this.hkH != null) {
            this.hkH.setText(d.j.tip_url_not_match);
            aj.i(this.hkH, d.C0082d.cp_other_b);
        }
    }

    public void Y(View.OnClickListener onClickListener) {
        if (this.hkF != null) {
            this.hkF.setOnClickListener(onClickListener);
        }
    }

    public View bIF() {
        return this.hkC;
    }

    public void destroy() {
        if (this.hks != null) {
            this.hks.addTextChangedListener(null);
        }
        if (this.hkD != null) {
            this.hkD.addTextChangedListener(null);
        }
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.uq(postWriteCallBackData.getErrorCode())) {
                AntiHelper.an(this.hkp.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.hkp.getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                this.hkp.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.aMx.c(null);
        this.aMx.db(d.j.sending);
        this.aMx.aE(true);
    }

    public void closeLoadingDialog() {
        this.aMx.aE(false);
    }
}
