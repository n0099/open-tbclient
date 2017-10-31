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
public class f {
    private View Ry;
    private com.baidu.tbadk.core.view.a aLO;
    private View dTa;
    private TbImageView ebS;
    private RelativeLayout fbD;
    private WriteUrlActivity gXZ;
    private TextView gYa;
    private TbImageView gYb;
    private EditText gYc;
    private View gYd;
    private LinearLayout gYe;
    private ImageView gYf;
    private View gYg;
    private TextView gYh;
    private TextView gYi;
    private View gYj;
    private TextView gYk;
    private TextView gYl;
    private LinearLayout gYm;
    private EditText gYn;
    private View gYo;
    private TextView gYp;
    private FrameLayout gYq;
    private TextView gYr;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public f(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.dTa = null;
        this.aLO = null;
        if (writeUrlActivity != null) {
            this.gXZ = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.Ry = LayoutInflater.from(this.gXZ.getPageContext().getPageActivity()).inflate(d.h.write_url_activity_layout, (ViewGroup) null);
            this.gXZ.setContentView(this.Ry);
            this.mNavigationBar = (NavigationBar) this.Ry.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.dTa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dTa.getLayoutParams();
                layoutParams.leftMargin = l.f(this.gXZ.getActivity(), d.e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.dTa != null && (this.dTa.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dTa.getLayoutParams();
                layoutParams2.width = -2;
                this.dTa.setLayoutParams(layoutParams2);
            }
            this.Ry.setOnClickListener(this.mClickListener);
            this.gYa = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.j.send_post));
            aj.c(this.gYa, d.C0080d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.gYa.getLayoutParams();
            layoutParams3.rightMargin = l.f(this.gXZ.getActivity(), d.e.ds16);
            this.gYa.setLayoutParams(layoutParams3);
            this.gYa.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.j.post_new_thread));
            this.gYb = (TbImageView) this.Ry.findViewById(d.g.imageview_picture);
            this.gYb.setDefaultResource(d.f.ic_post_url_n);
            this.gYb.setDefaultErrorResource(d.f.ic_post_url_n);
            this.gYb.setDefaultBgResource(d.C0080d.black_alpha0);
            this.gYe = (LinearLayout) this.Ry.findViewById(d.g.view_picture_publish);
            this.gYe.setOnClickListener(this.mClickListener);
            this.fbD = (RelativeLayout) this.Ry.findViewById(d.g.video_container);
            this.fbD.setOnClickListener(this.mClickListener);
            this.ebS = (TbImageView) this.Ry.findViewById(d.g.video_img_thumbnail);
            this.ebS.setDefaultErrorResource(0);
            this.ebS.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.ebS.setDefaultBgResource(d.C0080d.black_alpha0);
            this.gYf = (ImageView) this.Ry.findViewById(d.g.video_img_play);
            this.gYg = this.Ry.findViewById(d.g.video_view_delete);
            this.gYg.setOnClickListener(this.mClickListener);
            this.gYh = (TextView) this.Ry.findViewById(d.g.textview_title);
            this.gYi = (TextView) this.Ry.findViewById(d.g.textview_abstract);
            this.gYj = this.Ry.findViewById(d.g.view_delete);
            this.gYj.setOnClickListener(this.mClickListener);
            this.gYd = this.Ry.findViewById(d.g.icon_invoke_link);
            this.gYd.setOnClickListener(this.mClickListener);
            this.gYc = (EditText) this.Ry.findViewById(d.g.post_content);
            this.gYk = (TextView) this.Ry.findViewById(d.g.textview_error_tip);
            this.gYl = (TextView) this.Ry.findViewById(d.g.textview_url);
            this.gYm = (LinearLayout) this.Ry.findViewById(d.g.url_edit_container);
            this.gYn = (EditText) this.Ry.findViewById(d.g.url_input);
            this.gYr = (TextView) this.Ry.findViewById(d.g.url_desc);
            this.gYo = this.Ry.findViewById(d.g.url_input_clear);
            this.gYp = (TextView) this.Ry.findViewById(d.g.url_add);
            this.gYp.setEnabled(false);
            this.gYq = (FrameLayout) this.Ry.findViewById(d.g.url_edit_back_view);
            this.gYn.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.f.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        f.this.gYo.setVisibility(8);
                        aj.i(f.this.gYp, d.C0080d.cp_cont_e);
                        f.this.gYp.setEnabled(false);
                        return;
                    }
                    f.this.gYo.setVisibility(0);
                    aj.i(f.this.gYp, d.C0080d.cp_link_tip_a);
                    f.this.gYp.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (f.this.gYr.getText().equals(f.this.gXZ.getActivity().getString(d.j.tip_url_not_match))) {
                        f.this.bFm();
                    }
                }
            });
            this.gYo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.gYn.setText("");
                    f.this.gYo.setVisibility(8);
                    f.this.gYp.setEnabled(false);
                }
            });
            this.aLO = new com.baidu.tbadk.core.view.a(this.gXZ.getPageContext());
            bFm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFm() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.gYr.setText(d.j.tip_url_post);
        } else {
            this.gYr.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        aj.i(this.gYr, d.C0080d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.gXZ.setIsLoading(z);
        if (z) {
            this.gYe.setVisibility(0);
            this.fbD.setVisibility(8);
            this.gYb.startLoad(null, 10, false);
            this.gYh.setVisibility(8);
            this.gYi.setVisibility(8);
            this.gYk.setVisibility(8);
            this.gYl.setVisibility(0);
            aj.i(this.gYl, d.C0080d.cp_cont_f);
            this.gYl.setText(d.j.tip_url_loading);
        } else if (aVar == null) {
            this.gYe.setVisibility(8);
            this.fbD.setVisibility(8);
            bFn();
        } else {
            if (aVar.gRX == 1) {
                this.gYe.setVisibility(0);
                this.fbD.setVisibility(8);
                if (aVar.gRW) {
                    this.gYb.startLoad(aVar.gRZ, 10, false);
                    this.gYh.setText(aVar.WY);
                    this.gYi.setText(aVar.WZ);
                    if (am.dT(aVar.WY) > 30) {
                        this.gYh.setMaxLines(2);
                        this.gYi.setMaxLines(1);
                    } else {
                        this.gYh.setMaxLines(1);
                        this.gYi.setMaxLines(2);
                    }
                    this.gYh.setVisibility(0);
                    this.gYi.setVisibility(0);
                    this.gYl.setVisibility(8);
                    this.gYk.setVisibility(8);
                } else {
                    this.gYb.reset();
                    this.gYl.setText(aVar.linkUrl);
                    aj.i(this.gYl, d.C0080d.cp_cont_b);
                    this.gYh.setVisibility(8);
                    this.gYi.setVisibility(8);
                    this.gYl.setVisibility(0);
                    this.gYk.setVisibility(0);
                }
            } else if (aVar.gRX == 2) {
                this.gYe.setVisibility(8);
                this.fbD.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.fbD.getLayoutParams();
                layoutParams.height = ((l.ac(this.gXZ.getPageContext().getPageActivity()) - ((int) this.gXZ.getPageContext().getPageActivity().getResources().getDimension(d.e.ds80))) * 9) / 16;
                this.fbD.setLayoutParams(layoutParams);
                aj.c(this.gYf, d.f.icon_play_video);
                aj.j(this.gYg, d.f.btn_delete_url);
                this.ebS.startLoad(aVar.gSc, 10, false);
            } else {
                this.gYe.setVisibility(0);
                this.fbD.setVisibility(8);
                this.gYh.setVisibility(8);
                this.gYi.setVisibility(8);
                this.gYl.setVisibility(0);
                this.gYk.setVisibility(0);
                this.gYb.reset();
                this.gYl.setText(aVar.linkUrl);
                aj.i(this.gYl, d.C0080d.cp_cont_b);
            }
            bFn();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.gYc.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.gXZ != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.gXZ.getPageContext(), i);
            }
            aj.k(this.mNavigationBar, d.C0080d.cp_bg_line_d);
            aj.k(this.Ry, d.C0080d.cp_bg_line_d);
            this.gYc.setHintTextColor(aj.getColor(d.C0080d.cp_cont_e));
            this.gYc.setTextColor(aj.getColor(d.C0080d.cp_cont_f));
            aj.k(this.gYe, d.C0080d.cp_bg_line_e);
            aj.i(this.gYh, d.C0080d.cp_cont_b);
            aj.i(this.gYi, d.C0080d.cp_cont_d);
            aj.i(this.gYl, d.C0080d.cp_cont_b);
            aj.k(this.gYk, d.C0080d.cp_bg_line_d);
            aj.i(this.gYk, d.C0080d.cp_cont_d);
            aj.j(this.gYd, d.f.bg_link_invoke);
            aj.k(this.gYm, d.C0080d.cp_bg_line_d);
            this.gYn.setHintTextColor(aj.getColor(d.C0080d.cp_cont_e));
            aj.i(this.gYn, d.C0080d.cp_cont_b);
            aj.i(this.gYr, d.C0080d.cp_cont_d);
            aj.i(this.gYp, d.C0080d.cp_cont_e);
            aj.c(this.gYf, d.f.home_ic_video);
            aj.j(this.gYj, d.f.btn_delete_url);
            aj.j(this.gYo, d.f.btn_delete_url);
            aj.j(this.gYg, d.f.btn_delete_url);
            bFn();
        }
    }

    public void bFn() {
        boolean z;
        if (StringUtils.isNull(bFo())) {
            z = this.gYe.getVisibility() == 0 || this.fbD.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            aj.b(this.gYa, d.C0080d.cp_link_tip_a, d.C0080d.s_navbar_title_color);
            this.gYa.setEnabled(true);
            return;
        }
        aj.c(this.gYa, d.C0080d.cp_cont_d, 1);
        this.gYa.setEnabled(false);
    }

    public String bFo() {
        if (this.gYc == null || this.gYc.getText() == null) {
            return null;
        }
        return this.gYc.getText().toString();
    }

    public View aBn() {
        return this.dTa;
    }

    public View bFp() {
        return this.gYa;
    }

    public View getRootView() {
        return this.Ry;
    }

    public EditText bFq() {
        return this.gYc;
    }

    public View bqS() {
        return this.gYj;
    }

    public View bFr() {
        return this.gYg;
    }

    public View bFs() {
        return this.gYe;
    }

    public View getVideoContainer() {
        return this.fbD;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.gYn.setText(aVar.linkUrl);
            this.gYn.setSelection(aVar.linkUrl.length());
        }
        this.gYn.requestFocus();
        l.b(this.gXZ.getActivity(), this.gYn);
        this.gYm.setVisibility(0);
        this.gYq.setVisibility(0);
        this.gYd.setVisibility(8);
    }

    public void bFt() {
        this.gYm.setVisibility(8);
        this.gYq.setVisibility(8);
        this.gYd.setVisibility(0);
        l.a(this.gXZ.getActivity(), this.gYn);
    }

    public void V(View.OnClickListener onClickListener) {
        this.gYm.setOnClickListener(onClickListener);
        this.gYq.setOnClickListener(onClickListener);
        this.gYd.setOnClickListener(onClickListener);
    }

    public String bFu() {
        if (this.gYn == null || this.gYn.getText() == null) {
            return null;
        }
        return this.gYn.getText().toString();
    }

    public void bFv() {
        if (this.gYr != null) {
            this.gYr.setText(d.j.tip_url_not_match);
            aj.i(this.gYr, d.C0080d.cp_other_b);
        }
    }

    public void W(View.OnClickListener onClickListener) {
        if (this.gYp != null) {
            this.gYp.setOnClickListener(onClickListener);
        }
    }

    public View bFw() {
        return this.gYm;
    }

    public void destroy() {
        if (this.gYc != null) {
            this.gYc.addTextChangedListener(null);
        }
        if (this.gYn != null) {
            this.gYn.addTextChangedListener(null);
        }
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.tW(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ao(this.gXZ.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.gXZ.getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                this.gXZ.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.aLO.c(null);
        this.aLO.db(d.j.sending);
        this.aLO.aE(true);
    }

    public void closeLoadingDialog() {
        this.aLO.aE(false);
    }
}
