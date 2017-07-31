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
    private View Sd;
    private com.baidu.tbadk.core.view.a aMk;
    private View.OnClickListener aYW;
    private View dIy;
    private TbImageView dOJ;
    private RelativeLayout eXD;
    private WriteUrlActivity gHQ;
    private TextView gHR;
    private TbImageView gHS;
    private EditText gHT;
    private View gHU;
    private LinearLayout gHV;
    private ImageView gHW;
    private View gHX;
    private TextView gHY;
    private TextView gHZ;
    private View gIa;
    private TextView gIb;
    private TextView gIc;
    private LinearLayout gId;
    private EditText gIe;
    private View gIf;
    private TextView gIg;
    private FrameLayout gIh;
    private TextView gIi;
    private NavigationBar mNavigationBar;

    public d(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.dIy = null;
        this.aMk = null;
        if (writeUrlActivity != null) {
            this.gHQ = writeUrlActivity;
            this.aYW = onClickListener;
            this.Sd = LayoutInflater.from(this.gHQ.getPageContext().getPageActivity()).inflate(d.j.write_url_activity_layout, (ViewGroup) null);
            this.gHQ.setContentView(this.Sd);
            this.mNavigationBar = (NavigationBar) this.Sd.findViewById(d.h.view_navigation_bar);
            this.dIy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aYW);
            this.mNavigationBar.setmBackImageViewBg(d.g.write_close_selector, d.g.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dIy.getLayoutParams();
                layoutParams.leftMargin = k.g(this.gHQ.getActivity(), d.f.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.dIy != null && (this.dIy.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dIy.getLayoutParams();
                layoutParams2.width = -2;
                this.dIy.setLayoutParams(layoutParams2);
            }
            this.Sd.setOnClickListener(this.aYW);
            this.gHR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.l.send_post));
            ai.c(this.gHR, d.e.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.gHR.getLayoutParams();
            layoutParams3.rightMargin = k.g(this.gHQ.getActivity(), d.f.ds16);
            this.gHR.setLayoutParams(layoutParams3);
            this.gHR.setOnClickListener(this.aYW);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.l.post_new_thread));
            this.gHS = (TbImageView) this.Sd.findViewById(d.h.imageview_picture);
            this.gHS.setDefaultResource(d.g.ic_post_url_n);
            this.gHS.setDefaultErrorResource(d.g.ic_post_url_n);
            this.gHS.setDefaultBgResource(d.e.black_alpha0);
            this.gHV = (LinearLayout) this.Sd.findViewById(d.h.view_picture_publish);
            this.gHV.setOnClickListener(this.aYW);
            this.eXD = (RelativeLayout) this.Sd.findViewById(d.h.video_container);
            this.eXD.setOnClickListener(this.aYW);
            this.dOJ = (TbImageView) this.Sd.findViewById(d.h.video_img_thumbnail);
            this.dOJ.setDefaultErrorResource(0);
            this.dOJ.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.dOJ.setDefaultBgResource(d.e.black_alpha0);
            this.gHW = (ImageView) this.Sd.findViewById(d.h.video_img_play);
            this.gHX = this.Sd.findViewById(d.h.video_view_delete);
            this.gHX.setOnClickListener(this.aYW);
            this.gHY = (TextView) this.Sd.findViewById(d.h.textview_title);
            this.gHZ = (TextView) this.Sd.findViewById(d.h.textview_abstract);
            this.gIa = this.Sd.findViewById(d.h.view_delete);
            this.gIa.setOnClickListener(this.aYW);
            this.gHU = this.Sd.findViewById(d.h.icon_invoke_link);
            this.gHU.setOnClickListener(this.aYW);
            this.gHT = (EditText) this.Sd.findViewById(d.h.post_content);
            this.gHT.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.d.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    d.this.bAI();
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }
            });
            this.gIb = (TextView) this.Sd.findViewById(d.h.textview_error_tip);
            this.gIc = (TextView) this.Sd.findViewById(d.h.textview_url);
            this.gId = (LinearLayout) this.Sd.findViewById(d.h.url_edit_container);
            this.gIe = (EditText) this.Sd.findViewById(d.h.url_input);
            this.gIi = (TextView) this.Sd.findViewById(d.h.url_desc);
            this.gIf = this.Sd.findViewById(d.h.url_input_clear);
            this.gIg = (TextView) this.Sd.findViewById(d.h.url_add);
            this.gIg.setEnabled(false);
            this.gIh = (FrameLayout) this.Sd.findViewById(d.h.url_edit_back_view);
            this.gIe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.d.2
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        d.this.gIf.setVisibility(8);
                        ai.i(d.this.gIg, d.e.cp_cont_e);
                        d.this.gIg.setEnabled(false);
                        return;
                    }
                    d.this.gIf.setVisibility(0);
                    ai.i(d.this.gIg, d.e.cp_link_tip_a);
                    d.this.gIg.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (d.this.gIi.getText().equals(d.this.gHQ.getActivity().getString(d.l.tip_url_not_match))) {
                        d.this.bAH();
                    }
                }
            });
            this.gIf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.gIe.setText("");
                    d.this.gIf.setVisibility(8);
                    d.this.gIg.setEnabled(false);
                }
            });
            this.aMk = new com.baidu.tbadk.core.view.a(this.gHQ.getPageContext());
            bAH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAH() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.gIi.setText(d.l.tip_url_post);
        } else {
            this.gIi.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        ai.i(this.gIi, d.e.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.gHQ.setIsLoading(z);
        if (z) {
            this.gHV.setVisibility(0);
            this.eXD.setVisibility(8);
            this.gHS.c(null, 10, false);
            this.gHY.setVisibility(8);
            this.gHZ.setVisibility(8);
            this.gIb.setVisibility(8);
            this.gIc.setVisibility(0);
            ai.i(this.gIc, d.e.cp_cont_f);
            this.gIc.setText(d.l.tip_url_loading);
        } else if (aVar == null) {
            this.gHV.setVisibility(8);
            this.eXD.setVisibility(8);
            bAI();
        } else {
            if (aVar.gBT == 1) {
                this.gHV.setVisibility(0);
                this.eXD.setVisibility(8);
                if (aVar.gBS) {
                    this.gHS.c(aVar.gBV, 10, false);
                    this.gHY.setText(aVar.XG);
                    this.gHZ.setText(aVar.XH);
                    if (al.dZ(aVar.XG) > 30) {
                        this.gHY.setMaxLines(2);
                        this.gHZ.setMaxLines(1);
                    } else {
                        this.gHY.setMaxLines(1);
                        this.gHZ.setMaxLines(2);
                    }
                    this.gHY.setVisibility(0);
                    this.gHZ.setVisibility(0);
                    this.gIc.setVisibility(8);
                    this.gIb.setVisibility(8);
                } else {
                    this.gHS.reset();
                    this.gIc.setText(aVar.linkUrl);
                    ai.i(this.gIc, d.e.cp_cont_b);
                    this.gHY.setVisibility(8);
                    this.gHZ.setVisibility(8);
                    this.gIc.setVisibility(0);
                    this.gIb.setVisibility(0);
                }
            } else if (aVar.gBT == 2) {
                this.gHV.setVisibility(8);
                this.eXD.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.eXD.getLayoutParams();
                layoutParams.height = ((k.ag(this.gHQ.getPageContext().getPageActivity()) - ((int) this.gHQ.getPageContext().getPageActivity().getResources().getDimension(d.f.ds80))) * 9) / 16;
                this.eXD.setLayoutParams(layoutParams);
                ai.c(this.gHW, d.g.icon_play_video);
                ai.j(this.gHX, d.g.btn_delete_url);
                this.dOJ.c(aVar.gBZ, 10, false);
            } else {
                this.gHV.setVisibility(0);
                this.eXD.setVisibility(8);
                this.gHY.setVisibility(8);
                this.gHZ.setVisibility(8);
                this.gIc.setVisibility(0);
                this.gIb.setVisibility(0);
                this.gHS.reset();
                this.gIc.setText(aVar.linkUrl);
                ai.i(this.gIc, d.e.cp_cont_b);
            }
            bAI();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gHQ != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.gHQ.getPageContext(), i);
            }
            ai.k(this.mNavigationBar, d.e.cp_bg_line_d);
            ai.k(this.Sd, d.e.cp_bg_line_d);
            this.gHT.setHintTextColor(ai.getColor(d.e.cp_cont_e));
            this.gHT.setTextColor(ai.getColor(d.e.cp_cont_f));
            ai.k(this.gHV, d.e.cp_bg_line_e);
            ai.i(this.gHY, d.e.cp_cont_b);
            ai.i(this.gHZ, d.e.cp_cont_d);
            ai.i(this.gIc, d.e.cp_cont_b);
            ai.k(this.gIb, d.e.cp_bg_line_d);
            ai.i(this.gIb, d.e.cp_cont_d);
            ai.j(this.gHU, d.g.bg_link_invoke);
            ai.k(this.gId, d.e.cp_bg_line_d);
            this.gIe.setHintTextColor(ai.getColor(d.e.cp_cont_e));
            ai.i(this.gIe, d.e.cp_cont_b);
            ai.i(this.gIi, d.e.cp_cont_d);
            ai.i(this.gIg, d.e.cp_cont_e);
            ai.c(this.gHW, d.g.home_ic_video);
            ai.j(this.gIa, d.g.btn_delete_url);
            ai.j(this.gIf, d.g.btn_delete_url);
            ai.j(this.gHX, d.g.btn_delete_url);
            bAI();
        }
    }

    public void bAI() {
        boolean z;
        if (StringUtils.isNull(bAJ())) {
            z = this.gHV.getVisibility() == 0 || this.eXD.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            ai.b(this.gHR, d.e.cp_link_tip_a, d.e.s_navbar_title_color);
            this.gHR.setEnabled(true);
            return;
        }
        ai.c(this.gHR, d.e.cp_cont_d, 1);
        this.gHR.setEnabled(false);
    }

    public String bAJ() {
        if (this.gHT == null || this.gHT.getText() == null) {
            return null;
        }
        return this.gHT.getText().toString();
    }

    public View Wa() {
        return this.dIy;
    }

    public View bAK() {
        return this.gHR;
    }

    public View getRootView() {
        return this.Sd;
    }

    public View bAL() {
        return this.gHT;
    }

    public View boZ() {
        return this.gIa;
    }

    public View bAM() {
        return this.gHX;
    }

    public View bAN() {
        return this.gHV;
    }

    public View getVideoContainer() {
        return this.eXD;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.gIe.setText(aVar.linkUrl);
            this.gIe.setSelection(aVar.linkUrl.length());
        }
        this.gIe.requestFocus();
        k.c(this.gHQ.getActivity(), this.gIe);
        this.gId.setVisibility(0);
        this.gIh.setVisibility(0);
        this.gHU.setVisibility(8);
    }

    public void bAO() {
        this.gId.setVisibility(8);
        this.gIh.setVisibility(8);
        this.gHU.setVisibility(0);
        k.b(this.gHQ.getActivity(), this.gIe);
    }

    public void Y(View.OnClickListener onClickListener) {
        this.gId.setOnClickListener(onClickListener);
        this.gIh.setOnClickListener(onClickListener);
        this.gHU.setOnClickListener(onClickListener);
    }

    public String bAP() {
        if (this.gIe == null || this.gIe.getText() == null) {
            return null;
        }
        return this.gIe.getText().toString();
    }

    public void bAQ() {
        if (this.gIi != null) {
            this.gIi.setText(d.l.tip_url_not_match);
            ai.i(this.gIi, d.e.cp_other_b);
        }
    }

    public void Z(View.OnClickListener onClickListener) {
        if (this.gIg != null) {
            this.gIg.setOnClickListener(onClickListener);
        }
    }

    public View bAR() {
        return this.gId;
    }

    public void destroy() {
        if (this.gHT != null) {
            this.gHT.addTextChangedListener(null);
        }
        if (this.gIe != null) {
            this.gIe.addTextChangedListener(null);
        }
    }

    public void d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.tn(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ar(this.gHQ.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.gHQ.getPageContext().getPageActivity().getString(d.l.error_write);
                }
                this.gHQ.showToast(errorString);
            }
        }
    }

    public void QX() {
        this.aMk.c(null);
        this.aMk.dc(d.l.sending);
        this.aMk.aH(true);
    }

    public void closeLoadingDialog() {
        this.aMk.aH(false);
    }
}
