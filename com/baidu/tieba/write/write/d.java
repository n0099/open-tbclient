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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class d {
    private View Rh;
    private com.baidu.tbadk.core.view.a aLS;
    private View.OnClickListener aYK;
    private View dQZ;
    private TbImageView dXr;
    private RelativeLayout eYi;
    private TextView gIA;
    private LinearLayout gIB;
    private EditText gIC;
    private View gID;
    private TextView gIE;
    private FrameLayout gIF;
    private TextView gIG;
    private WriteUrlActivity gIo;
    private TextView gIp;
    private TbImageView gIq;
    private EditText gIr;
    private View gIs;
    private LinearLayout gIt;
    private ImageView gIu;
    private View gIv;
    private TextView gIw;
    private TextView gIx;
    private View gIy;
    private TextView gIz;
    private NavigationBar mNavigationBar;

    public d(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.dQZ = null;
        this.aLS = null;
        if (writeUrlActivity != null) {
            this.gIo = writeUrlActivity;
            this.aYK = onClickListener;
            this.Rh = LayoutInflater.from(this.gIo.getPageContext().getPageActivity()).inflate(d.j.write_url_activity_layout, (ViewGroup) null);
            this.gIo.setContentView(this.Rh);
            this.mNavigationBar = (NavigationBar) this.Rh.findViewById(d.h.view_navigation_bar);
            this.dQZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aYK);
            this.mNavigationBar.setmBackImageViewBg(d.g.write_close_selector, d.g.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dQZ.getLayoutParams();
                layoutParams.leftMargin = k.g(this.gIo.getActivity(), d.f.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.dQZ != null && (this.dQZ.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dQZ.getLayoutParams();
                layoutParams2.width = -2;
                this.dQZ.setLayoutParams(layoutParams2);
            }
            this.Rh.setOnClickListener(this.aYK);
            this.gIp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.l.send_post));
            aj.c(this.gIp, d.e.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.gIp.getLayoutParams();
            layoutParams3.rightMargin = k.g(this.gIo.getActivity(), d.f.ds16);
            this.gIp.setLayoutParams(layoutParams3);
            this.gIp.setOnClickListener(this.aYK);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.l.post_new_thread));
            this.gIq = (TbImageView) this.Rh.findViewById(d.h.imageview_picture);
            this.gIq.setDefaultResource(d.g.ic_post_url_n);
            this.gIq.setDefaultErrorResource(d.g.ic_post_url_n);
            this.gIq.setDefaultBgResource(d.e.black_alpha0);
            this.gIt = (LinearLayout) this.Rh.findViewById(d.h.view_picture_publish);
            this.gIt.setOnClickListener(this.aYK);
            this.eYi = (RelativeLayout) this.Rh.findViewById(d.h.video_container);
            this.eYi.setOnClickListener(this.aYK);
            this.dXr = (TbImageView) this.Rh.findViewById(d.h.video_img_thumbnail);
            this.dXr.setDefaultErrorResource(0);
            this.dXr.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.dXr.setDefaultBgResource(d.e.black_alpha0);
            this.gIu = (ImageView) this.Rh.findViewById(d.h.video_img_play);
            this.gIv = this.Rh.findViewById(d.h.video_view_delete);
            this.gIv.setOnClickListener(this.aYK);
            this.gIw = (TextView) this.Rh.findViewById(d.h.textview_title);
            this.gIx = (TextView) this.Rh.findViewById(d.h.textview_abstract);
            this.gIy = this.Rh.findViewById(d.h.view_delete);
            this.gIy.setOnClickListener(this.aYK);
            this.gIs = this.Rh.findViewById(d.h.icon_invoke_link);
            this.gIs.setOnClickListener(this.aYK);
            this.gIr = (EditText) this.Rh.findViewById(d.h.post_content);
            this.gIr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.d.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    d.this.bAx();
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }
            });
            this.gIz = (TextView) this.Rh.findViewById(d.h.textview_error_tip);
            this.gIA = (TextView) this.Rh.findViewById(d.h.textview_url);
            this.gIB = (LinearLayout) this.Rh.findViewById(d.h.url_edit_container);
            this.gIC = (EditText) this.Rh.findViewById(d.h.url_input);
            this.gIG = (TextView) this.Rh.findViewById(d.h.url_desc);
            this.gID = this.Rh.findViewById(d.h.url_input_clear);
            this.gIE = (TextView) this.Rh.findViewById(d.h.url_add);
            this.gIE.setEnabled(false);
            this.gIF = (FrameLayout) this.Rh.findViewById(d.h.url_edit_back_view);
            this.gIC.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.d.2
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        d.this.gID.setVisibility(8);
                        aj.i(d.this.gIE, d.e.cp_cont_e);
                        d.this.gIE.setEnabled(false);
                        return;
                    }
                    d.this.gID.setVisibility(0);
                    aj.i(d.this.gIE, d.e.cp_link_tip_a);
                    d.this.gIE.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (d.this.gIG.getText().equals(d.this.gIo.getActivity().getString(d.l.tip_url_not_match))) {
                        d.this.bAw();
                    }
                }
            });
            this.gID.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.gIC.setText("");
                    d.this.gID.setVisibility(8);
                    d.this.gIE.setEnabled(false);
                }
            });
            this.aLS = new com.baidu.tbadk.core.view.a(this.gIo.getPageContext());
            bAw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAw() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.gIG.setText(d.l.tip_url_post);
        } else {
            this.gIG.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        aj.i(this.gIG, d.e.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.gIo.setIsLoading(z);
        if (z) {
            this.gIt.setVisibility(0);
            this.eYi.setVisibility(8);
            this.gIq.c(null, 10, false);
            this.gIw.setVisibility(8);
            this.gIx.setVisibility(8);
            this.gIz.setVisibility(8);
            this.gIA.setVisibility(0);
            aj.i(this.gIA, d.e.cp_cont_f);
            this.gIA.setText(d.l.tip_url_loading);
        } else if (aVar == null) {
            this.gIt.setVisibility(8);
            this.eYi.setVisibility(8);
            bAx();
        } else {
            if (aVar.gCz == 1) {
                this.gIt.setVisibility(0);
                this.eYi.setVisibility(8);
                if (aVar.gCy) {
                    this.gIq.c(aVar.gCB, 10, false);
                    this.gIw.setText(aVar.WS);
                    this.gIx.setText(aVar.WT);
                    if (am.dV(aVar.WS) > 30) {
                        this.gIw.setMaxLines(2);
                        this.gIx.setMaxLines(1);
                    } else {
                        this.gIw.setMaxLines(1);
                        this.gIx.setMaxLines(2);
                    }
                    this.gIw.setVisibility(0);
                    this.gIx.setVisibility(0);
                    this.gIA.setVisibility(8);
                    this.gIz.setVisibility(8);
                } else {
                    this.gIq.reset();
                    this.gIA.setText(aVar.linkUrl);
                    aj.i(this.gIA, d.e.cp_cont_b);
                    this.gIw.setVisibility(8);
                    this.gIx.setVisibility(8);
                    this.gIA.setVisibility(0);
                    this.gIz.setVisibility(0);
                }
            } else if (aVar.gCz == 2) {
                this.gIt.setVisibility(8);
                this.eYi.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.eYi.getLayoutParams();
                layoutParams.height = ((k.ad(this.gIo.getPageContext().getPageActivity()) - ((int) this.gIo.getPageContext().getPageActivity().getResources().getDimension(d.f.ds80))) * 9) / 16;
                this.eYi.setLayoutParams(layoutParams);
                aj.c(this.gIu, d.g.icon_play_video);
                aj.j(this.gIv, d.g.btn_delete_url);
                this.dXr.c(aVar.gCE, 10, false);
            } else {
                this.gIt.setVisibility(0);
                this.eYi.setVisibility(8);
                this.gIw.setVisibility(8);
                this.gIx.setVisibility(8);
                this.gIA.setVisibility(0);
                this.gIz.setVisibility(0);
                this.gIq.reset();
                this.gIA.setText(aVar.linkUrl);
                aj.i(this.gIA, d.e.cp_cont_b);
            }
            bAx();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gIo != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.gIo.getPageContext(), i);
            }
            aj.k(this.mNavigationBar, d.e.cp_bg_line_d);
            aj.k(this.Rh, d.e.cp_bg_line_d);
            this.gIr.setHintTextColor(aj.getColor(d.e.cp_cont_e));
            this.gIr.setTextColor(aj.getColor(d.e.cp_cont_f));
            aj.k(this.gIt, d.e.cp_bg_line_e);
            aj.i(this.gIw, d.e.cp_cont_b);
            aj.i(this.gIx, d.e.cp_cont_d);
            aj.i(this.gIA, d.e.cp_cont_b);
            aj.k(this.gIz, d.e.cp_bg_line_d);
            aj.i(this.gIz, d.e.cp_cont_d);
            aj.j(this.gIs, d.g.bg_link_invoke);
            aj.k(this.gIB, d.e.cp_bg_line_d);
            this.gIC.setHintTextColor(aj.getColor(d.e.cp_cont_e));
            aj.i(this.gIC, d.e.cp_cont_b);
            aj.i(this.gIG, d.e.cp_cont_d);
            aj.i(this.gIE, d.e.cp_cont_e);
            aj.c(this.gIu, d.g.home_ic_video);
            aj.j(this.gIy, d.g.btn_delete_url);
            aj.j(this.gID, d.g.btn_delete_url);
            aj.j(this.gIv, d.g.btn_delete_url);
            bAx();
        }
    }

    public void bAx() {
        boolean z;
        if (StringUtils.isNull(bAy())) {
            z = this.gIt.getVisibility() == 0 || this.eYi.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            aj.b(this.gIp, d.e.cp_link_tip_a, d.e.s_navbar_title_color);
            this.gIp.setEnabled(true);
            return;
        }
        aj.c(this.gIp, d.e.cp_cont_d, 1);
        this.gIp.setEnabled(false);
    }

    public String bAy() {
        if (this.gIr == null || this.gIr.getText() == null) {
            return null;
        }
        return this.gIr.getText().toString();
    }

    public View Xw() {
        return this.dQZ;
    }

    public View bAz() {
        return this.gIp;
    }

    public View getRootView() {
        return this.Rh;
    }

    public View bAA() {
        return this.gIr;
    }

    public View boQ() {
        return this.gIy;
    }

    public View bAB() {
        return this.gIv;
    }

    public View bAC() {
        return this.gIt;
    }

    public View getVideoContainer() {
        return this.eYi;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.gIC.setText(aVar.linkUrl);
            this.gIC.setSelection(aVar.linkUrl.length());
        }
        this.gIC.requestFocus();
        k.b(this.gIo.getActivity(), this.gIC);
        this.gIB.setVisibility(0);
        this.gIF.setVisibility(0);
        this.gIs.setVisibility(8);
    }

    public void bAD() {
        this.gIB.setVisibility(8);
        this.gIF.setVisibility(8);
        this.gIs.setVisibility(0);
        k.a(this.gIo.getActivity(), this.gIC);
    }

    public void S(View.OnClickListener onClickListener) {
        this.gIB.setOnClickListener(onClickListener);
        this.gIF.setOnClickListener(onClickListener);
        this.gIs.setOnClickListener(onClickListener);
    }

    public String bAE() {
        if (this.gIC == null || this.gIC.getText() == null) {
            return null;
        }
        return this.gIC.getText().toString();
    }

    public void bAF() {
        if (this.gIG != null) {
            this.gIG.setText(d.l.tip_url_not_match);
            aj.i(this.gIG, d.e.cp_other_b);
        }
    }

    public void T(View.OnClickListener onClickListener) {
        if (this.gIE != null) {
            this.gIE.setOnClickListener(onClickListener);
        }
    }

    public View bAG() {
        return this.gIB;
    }

    public void destroy() {
        if (this.gIr != null) {
            this.gIr.addTextChangedListener(null);
        }
        if (this.gIC != null) {
            this.gIC.addTextChangedListener(null);
        }
    }

    public void d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.tz(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ar(this.gIo.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.gIo.getPageContext().getPageActivity().getString(d.l.error_write);
                }
                this.gIo.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.aLS.c(null);
        this.aLS.dd(d.l.sending);
        this.aLS.aH(true);
    }

    public void closeLoadingDialog() {
        this.aLS.aH(false);
    }
}
