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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class d {
    private View Sg;
    private com.baidu.tbadk.core.view.a aMm;
    private View.OnClickListener aYY;
    private View dKu;
    private TbImageView dQF;
    private RelativeLayout eZy;
    private WriteUrlActivity gJI;
    private TextView gJJ;
    private TbImageView gJK;
    private EditText gJL;
    private View gJM;
    private LinearLayout gJN;
    private ImageView gJO;
    private View gJP;
    private TextView gJQ;
    private TextView gJR;
    private View gJS;
    private TextView gJT;
    private TextView gJU;
    private LinearLayout gJV;
    private EditText gJW;
    private View gJX;
    private TextView gJY;
    private FrameLayout gJZ;
    private TextView gKa;
    private NavigationBar mNavigationBar;

    public d(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.dKu = null;
        this.aMm = null;
        if (writeUrlActivity != null) {
            this.gJI = writeUrlActivity;
            this.aYY = onClickListener;
            this.Sg = LayoutInflater.from(this.gJI.getPageContext().getPageActivity()).inflate(d.j.write_url_activity_layout, (ViewGroup) null);
            this.gJI.setContentView(this.Sg);
            this.mNavigationBar = (NavigationBar) this.Sg.findViewById(d.h.view_navigation_bar);
            this.dKu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aYY);
            this.mNavigationBar.setmBackImageViewBg(d.g.write_close_selector, d.g.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dKu.getLayoutParams();
                layoutParams.leftMargin = k.g(this.gJI.getActivity(), d.f.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.dKu != null && (this.dKu.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dKu.getLayoutParams();
                layoutParams2.width = -2;
                this.dKu.setLayoutParams(layoutParams2);
            }
            this.Sg.setOnClickListener(this.aYY);
            this.gJJ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.l.send_post));
            ai.c(this.gJJ, d.e.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.gJJ.getLayoutParams();
            layoutParams3.rightMargin = k.g(this.gJI.getActivity(), d.f.ds16);
            this.gJJ.setLayoutParams(layoutParams3);
            this.gJJ.setOnClickListener(this.aYY);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.l.post_new_thread));
            this.gJK = (TbImageView) this.Sg.findViewById(d.h.imageview_picture);
            this.gJK.setDefaultResource(d.g.ic_post_url_n);
            this.gJK.setDefaultErrorResource(d.g.ic_post_url_n);
            this.gJK.setDefaultBgResource(d.e.black_alpha0);
            this.gJN = (LinearLayout) this.Sg.findViewById(d.h.view_picture_publish);
            this.gJN.setOnClickListener(this.aYY);
            this.eZy = (RelativeLayout) this.Sg.findViewById(d.h.video_container);
            this.eZy.setOnClickListener(this.aYY);
            this.dQF = (TbImageView) this.Sg.findViewById(d.h.video_img_thumbnail);
            this.dQF.setDefaultErrorResource(0);
            this.dQF.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.dQF.setDefaultBgResource(d.e.black_alpha0);
            this.gJO = (ImageView) this.Sg.findViewById(d.h.video_img_play);
            this.gJP = this.Sg.findViewById(d.h.video_view_delete);
            this.gJP.setOnClickListener(this.aYY);
            this.gJQ = (TextView) this.Sg.findViewById(d.h.textview_title);
            this.gJR = (TextView) this.Sg.findViewById(d.h.textview_abstract);
            this.gJS = this.Sg.findViewById(d.h.view_delete);
            this.gJS.setOnClickListener(this.aYY);
            this.gJM = this.Sg.findViewById(d.h.icon_invoke_link);
            this.gJM.setOnClickListener(this.aYY);
            this.gJL = (EditText) this.Sg.findViewById(d.h.post_content);
            this.gJL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.d.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    d.this.bBh();
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }
            });
            this.gJT = (TextView) this.Sg.findViewById(d.h.textview_error_tip);
            this.gJU = (TextView) this.Sg.findViewById(d.h.textview_url);
            this.gJV = (LinearLayout) this.Sg.findViewById(d.h.url_edit_container);
            this.gJW = (EditText) this.Sg.findViewById(d.h.url_input);
            this.gKa = (TextView) this.Sg.findViewById(d.h.url_desc);
            this.gJX = this.Sg.findViewById(d.h.url_input_clear);
            this.gJY = (TextView) this.Sg.findViewById(d.h.url_add);
            this.gJY.setEnabled(false);
            this.gJZ = (FrameLayout) this.Sg.findViewById(d.h.url_edit_back_view);
            this.gJW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.d.2
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        d.this.gJX.setVisibility(8);
                        ai.i(d.this.gJY, d.e.cp_cont_e);
                        d.this.gJY.setEnabled(false);
                        return;
                    }
                    d.this.gJX.setVisibility(0);
                    ai.i(d.this.gJY, d.e.cp_link_tip_a);
                    d.this.gJY.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (d.this.gKa.getText().equals(d.this.gJI.getActivity().getString(d.l.tip_url_not_match))) {
                        d.this.bBg();
                    }
                }
            });
            this.gJX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.gJW.setText("");
                    d.this.gJX.setVisibility(8);
                    d.this.gJY.setEnabled(false);
                }
            });
            this.aMm = new com.baidu.tbadk.core.view.a(this.gJI.getPageContext());
            bBg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBg() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.gKa.setText(d.l.tip_url_post);
        } else {
            this.gKa.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        ai.i(this.gKa, d.e.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.gJI.setIsLoading(z);
        if (z) {
            this.gJN.setVisibility(0);
            this.eZy.setVisibility(8);
            this.gJK.c(null, 10, false);
            this.gJQ.setVisibility(8);
            this.gJR.setVisibility(8);
            this.gJT.setVisibility(8);
            this.gJU.setVisibility(0);
            ai.i(this.gJU, d.e.cp_cont_f);
            this.gJU.setText(d.l.tip_url_loading);
        } else if (aVar == null) {
            this.gJN.setVisibility(8);
            this.eZy.setVisibility(8);
            bBh();
        } else {
            if (aVar.gDL == 1) {
                this.gJN.setVisibility(0);
                this.eZy.setVisibility(8);
                if (aVar.gDK) {
                    this.gJK.c(aVar.gDN, 10, false);
                    this.gJQ.setText(aVar.XJ);
                    this.gJR.setText(aVar.XK);
                    if (al.ed(aVar.XJ) > 30) {
                        this.gJQ.setMaxLines(2);
                        this.gJR.setMaxLines(1);
                    } else {
                        this.gJQ.setMaxLines(1);
                        this.gJR.setMaxLines(2);
                    }
                    this.gJQ.setVisibility(0);
                    this.gJR.setVisibility(0);
                    this.gJU.setVisibility(8);
                    this.gJT.setVisibility(8);
                } else {
                    this.gJK.reset();
                    this.gJU.setText(aVar.linkUrl);
                    ai.i(this.gJU, d.e.cp_cont_b);
                    this.gJQ.setVisibility(8);
                    this.gJR.setVisibility(8);
                    this.gJU.setVisibility(0);
                    this.gJT.setVisibility(0);
                }
            } else if (aVar.gDL == 2) {
                this.gJN.setVisibility(8);
                this.eZy.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.eZy.getLayoutParams();
                layoutParams.height = ((k.ag(this.gJI.getPageContext().getPageActivity()) - ((int) this.gJI.getPageContext().getPageActivity().getResources().getDimension(d.f.ds80))) * 9) / 16;
                this.eZy.setLayoutParams(layoutParams);
                ai.c(this.gJO, d.g.icon_play_video);
                ai.j(this.gJP, d.g.btn_delete_url);
                this.dQF.c(aVar.gDR, 10, false);
            } else {
                this.gJN.setVisibility(0);
                this.eZy.setVisibility(8);
                this.gJQ.setVisibility(8);
                this.gJR.setVisibility(8);
                this.gJU.setVisibility(0);
                this.gJT.setVisibility(0);
                this.gJK.reset();
                this.gJU.setText(aVar.linkUrl);
                ai.i(this.gJU, d.e.cp_cont_b);
            }
            bBh();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gJI != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.gJI.getPageContext(), i);
            }
            ai.k(this.mNavigationBar, d.e.cp_bg_line_d);
            ai.k(this.Sg, d.e.cp_bg_line_d);
            this.gJL.setHintTextColor(ai.getColor(d.e.cp_cont_e));
            this.gJL.setTextColor(ai.getColor(d.e.cp_cont_f));
            ai.k(this.gJN, d.e.cp_bg_line_e);
            ai.i(this.gJQ, d.e.cp_cont_b);
            ai.i(this.gJR, d.e.cp_cont_d);
            ai.i(this.gJU, d.e.cp_cont_b);
            ai.k(this.gJT, d.e.cp_bg_line_d);
            ai.i(this.gJT, d.e.cp_cont_d);
            ai.j(this.gJM, d.g.bg_link_invoke);
            ai.k(this.gJV, d.e.cp_bg_line_d);
            this.gJW.setHintTextColor(ai.getColor(d.e.cp_cont_e));
            ai.i(this.gJW, d.e.cp_cont_b);
            ai.i(this.gKa, d.e.cp_cont_d);
            ai.i(this.gJY, d.e.cp_cont_e);
            ai.c(this.gJO, d.g.home_ic_video);
            ai.j(this.gJS, d.g.btn_delete_url);
            ai.j(this.gJX, d.g.btn_delete_url);
            ai.j(this.gJP, d.g.btn_delete_url);
            bBh();
        }
    }

    public void bBh() {
        boolean z;
        if (StringUtils.isNull(bBi())) {
            z = this.gJN.getVisibility() == 0 || this.eZy.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            ai.b(this.gJJ, d.e.cp_link_tip_a, d.e.s_navbar_title_color);
            this.gJJ.setEnabled(true);
            return;
        }
        ai.c(this.gJJ, d.e.cp_cont_d, 1);
        this.gJJ.setEnabled(false);
    }

    public String bBi() {
        if (this.gJL == null || this.gJL.getText() == null) {
            return null;
        }
        return this.gJL.getText().toString();
    }

    public View Wt() {
        return this.dKu;
    }

    public View bBj() {
        return this.gJJ;
    }

    public View getRootView() {
        return this.Sg;
    }

    public View bBk() {
        return this.gJL;
    }

    public View bpA() {
        return this.gJS;
    }

    public View bBl() {
        return this.gJP;
    }

    public View bBm() {
        return this.gJN;
    }

    public View getVideoContainer() {
        return this.eZy;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.gJW.setText(aVar.linkUrl);
            this.gJW.setSelection(aVar.linkUrl.length());
        }
        this.gJW.requestFocus();
        k.c(this.gJI.getActivity(), this.gJW);
        this.gJV.setVisibility(0);
        this.gJZ.setVisibility(0);
        this.gJM.setVisibility(8);
    }

    public void bBn() {
        this.gJV.setVisibility(8);
        this.gJZ.setVisibility(8);
        this.gJM.setVisibility(0);
        k.b(this.gJI.getActivity(), this.gJW);
    }

    public void U(View.OnClickListener onClickListener) {
        this.gJV.setOnClickListener(onClickListener);
        this.gJZ.setOnClickListener(onClickListener);
        this.gJM.setOnClickListener(onClickListener);
    }

    public String bBo() {
        if (this.gJW == null || this.gJW.getText() == null) {
            return null;
        }
        return this.gJW.getText().toString();
    }

    public void bBp() {
        if (this.gKa != null) {
            this.gKa.setText(d.l.tip_url_not_match);
            ai.i(this.gKa, d.e.cp_other_b);
        }
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.gJY != null) {
            this.gJY.setOnClickListener(onClickListener);
        }
    }

    public View bBq() {
        return this.gJV;
    }

    public void destroy() {
        if (this.gJL != null) {
            this.gJL.addTextChangedListener(null);
        }
        if (this.gJW != null) {
            this.gJW.addTextChangedListener(null);
        }
    }

    public void d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.tx(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ar(this.gJI.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.gJI.getPageContext().getPageActivity().getString(d.l.error_write);
                }
                this.gJI.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.aMm.c(null);
        this.aMm.dc(d.l.sending);
        this.aMm.aH(true);
    }

    public void closeLoadingDialog() {
        this.aMm.aH(false);
    }
}
