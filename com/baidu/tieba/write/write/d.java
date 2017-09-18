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
    private com.baidu.tbadk.core.view.a aLP;
    private View.OnClickListener aYH;
    private View dRT;
    private TbImageView dYl;
    private RelativeLayout eZc;
    private WriteUrlActivity gJh;
    private TextView gJi;
    private TbImageView gJj;
    private EditText gJk;
    private View gJl;
    private LinearLayout gJm;
    private ImageView gJn;
    private View gJo;
    private TextView gJp;
    private TextView gJq;
    private View gJr;
    private TextView gJs;
    private TextView gJt;
    private LinearLayout gJu;
    private EditText gJv;
    private View gJw;
    private TextView gJx;
    private FrameLayout gJy;
    private TextView gJz;
    private NavigationBar mNavigationBar;

    public d(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.dRT = null;
        this.aLP = null;
        if (writeUrlActivity != null) {
            this.gJh = writeUrlActivity;
            this.aYH = onClickListener;
            this.Rh = LayoutInflater.from(this.gJh.getPageContext().getPageActivity()).inflate(d.j.write_url_activity_layout, (ViewGroup) null);
            this.gJh.setContentView(this.Rh);
            this.mNavigationBar = (NavigationBar) this.Rh.findViewById(d.h.view_navigation_bar);
            this.dRT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aYH);
            this.mNavigationBar.setmBackImageViewBg(d.g.write_close_selector, d.g.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dRT.getLayoutParams();
                layoutParams.leftMargin = k.f(this.gJh.getActivity(), d.f.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.dRT != null && (this.dRT.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dRT.getLayoutParams();
                layoutParams2.width = -2;
                this.dRT.setLayoutParams(layoutParams2);
            }
            this.Rh.setOnClickListener(this.aYH);
            this.gJi = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.l.send_post));
            aj.c(this.gJi, d.e.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.gJi.getLayoutParams();
            layoutParams3.rightMargin = k.f(this.gJh.getActivity(), d.f.ds16);
            this.gJi.setLayoutParams(layoutParams3);
            this.gJi.setOnClickListener(this.aYH);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.l.post_new_thread));
            this.gJj = (TbImageView) this.Rh.findViewById(d.h.imageview_picture);
            this.gJj.setDefaultResource(d.g.ic_post_url_n);
            this.gJj.setDefaultErrorResource(d.g.ic_post_url_n);
            this.gJj.setDefaultBgResource(d.e.black_alpha0);
            this.gJm = (LinearLayout) this.Rh.findViewById(d.h.view_picture_publish);
            this.gJm.setOnClickListener(this.aYH);
            this.eZc = (RelativeLayout) this.Rh.findViewById(d.h.video_container);
            this.eZc.setOnClickListener(this.aYH);
            this.dYl = (TbImageView) this.Rh.findViewById(d.h.video_img_thumbnail);
            this.dYl.setDefaultErrorResource(0);
            this.dYl.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.dYl.setDefaultBgResource(d.e.black_alpha0);
            this.gJn = (ImageView) this.Rh.findViewById(d.h.video_img_play);
            this.gJo = this.Rh.findViewById(d.h.video_view_delete);
            this.gJo.setOnClickListener(this.aYH);
            this.gJp = (TextView) this.Rh.findViewById(d.h.textview_title);
            this.gJq = (TextView) this.Rh.findViewById(d.h.textview_abstract);
            this.gJr = this.Rh.findViewById(d.h.view_delete);
            this.gJr.setOnClickListener(this.aYH);
            this.gJl = this.Rh.findViewById(d.h.icon_invoke_link);
            this.gJl.setOnClickListener(this.aYH);
            this.gJk = (EditText) this.Rh.findViewById(d.h.post_content);
            this.gJk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.d.1
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
            this.gJs = (TextView) this.Rh.findViewById(d.h.textview_error_tip);
            this.gJt = (TextView) this.Rh.findViewById(d.h.textview_url);
            this.gJu = (LinearLayout) this.Rh.findViewById(d.h.url_edit_container);
            this.gJv = (EditText) this.Rh.findViewById(d.h.url_input);
            this.gJz = (TextView) this.Rh.findViewById(d.h.url_desc);
            this.gJw = this.Rh.findViewById(d.h.url_input_clear);
            this.gJx = (TextView) this.Rh.findViewById(d.h.url_add);
            this.gJx.setEnabled(false);
            this.gJy = (FrameLayout) this.Rh.findViewById(d.h.url_edit_back_view);
            this.gJv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.d.2
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        d.this.gJw.setVisibility(8);
                        aj.i(d.this.gJx, d.e.cp_cont_e);
                        d.this.gJx.setEnabled(false);
                        return;
                    }
                    d.this.gJw.setVisibility(0);
                    aj.i(d.this.gJx, d.e.cp_link_tip_a);
                    d.this.gJx.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (d.this.gJz.getText().equals(d.this.gJh.getActivity().getString(d.l.tip_url_not_match))) {
                        d.this.bAH();
                    }
                }
            });
            this.gJw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.gJv.setText("");
                    d.this.gJw.setVisibility(8);
                    d.this.gJx.setEnabled(false);
                }
            });
            this.aLP = new com.baidu.tbadk.core.view.a(this.gJh.getPageContext());
            bAH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAH() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.gJz.setText(d.l.tip_url_post);
        } else {
            this.gJz.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        aj.i(this.gJz, d.e.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.gJh.setIsLoading(z);
        if (z) {
            this.gJm.setVisibility(0);
            this.eZc.setVisibility(8);
            this.gJj.c(null, 10, false);
            this.gJp.setVisibility(8);
            this.gJq.setVisibility(8);
            this.gJs.setVisibility(8);
            this.gJt.setVisibility(0);
            aj.i(this.gJt, d.e.cp_cont_f);
            this.gJt.setText(d.l.tip_url_loading);
        } else if (aVar == null) {
            this.gJm.setVisibility(8);
            this.eZc.setVisibility(8);
            bAI();
        } else {
            if (aVar.gDs == 1) {
                this.gJm.setVisibility(0);
                this.eZc.setVisibility(8);
                if (aVar.gDr) {
                    this.gJj.c(aVar.gDu, 10, false);
                    this.gJp.setText(aVar.WS);
                    this.gJq.setText(aVar.WT);
                    if (am.dV(aVar.WS) > 30) {
                        this.gJp.setMaxLines(2);
                        this.gJq.setMaxLines(1);
                    } else {
                        this.gJp.setMaxLines(1);
                        this.gJq.setMaxLines(2);
                    }
                    this.gJp.setVisibility(0);
                    this.gJq.setVisibility(0);
                    this.gJt.setVisibility(8);
                    this.gJs.setVisibility(8);
                } else {
                    this.gJj.reset();
                    this.gJt.setText(aVar.linkUrl);
                    aj.i(this.gJt, d.e.cp_cont_b);
                    this.gJp.setVisibility(8);
                    this.gJq.setVisibility(8);
                    this.gJt.setVisibility(0);
                    this.gJs.setVisibility(0);
                }
            } else if (aVar.gDs == 2) {
                this.gJm.setVisibility(8);
                this.eZc.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.eZc.getLayoutParams();
                layoutParams.height = ((k.ae(this.gJh.getPageContext().getPageActivity()) - ((int) this.gJh.getPageContext().getPageActivity().getResources().getDimension(d.f.ds80))) * 9) / 16;
                this.eZc.setLayoutParams(layoutParams);
                aj.c(this.gJn, d.g.icon_play_video);
                aj.j(this.gJo, d.g.btn_delete_url);
                this.dYl.c(aVar.gDx, 10, false);
            } else {
                this.gJm.setVisibility(0);
                this.eZc.setVisibility(8);
                this.gJp.setVisibility(8);
                this.gJq.setVisibility(8);
                this.gJt.setVisibility(0);
                this.gJs.setVisibility(0);
                this.gJj.reset();
                this.gJt.setText(aVar.linkUrl);
                aj.i(this.gJt, d.e.cp_cont_b);
            }
            bAI();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gJh != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.gJh.getPageContext(), i);
            }
            aj.k(this.mNavigationBar, d.e.cp_bg_line_d);
            aj.k(this.Rh, d.e.cp_bg_line_d);
            this.gJk.setHintTextColor(aj.getColor(d.e.cp_cont_e));
            this.gJk.setTextColor(aj.getColor(d.e.cp_cont_f));
            aj.k(this.gJm, d.e.cp_bg_line_e);
            aj.i(this.gJp, d.e.cp_cont_b);
            aj.i(this.gJq, d.e.cp_cont_d);
            aj.i(this.gJt, d.e.cp_cont_b);
            aj.k(this.gJs, d.e.cp_bg_line_d);
            aj.i(this.gJs, d.e.cp_cont_d);
            aj.j(this.gJl, d.g.bg_link_invoke);
            aj.k(this.gJu, d.e.cp_bg_line_d);
            this.gJv.setHintTextColor(aj.getColor(d.e.cp_cont_e));
            aj.i(this.gJv, d.e.cp_cont_b);
            aj.i(this.gJz, d.e.cp_cont_d);
            aj.i(this.gJx, d.e.cp_cont_e);
            aj.c(this.gJn, d.g.home_ic_video);
            aj.j(this.gJr, d.g.btn_delete_url);
            aj.j(this.gJw, d.g.btn_delete_url);
            aj.j(this.gJo, d.g.btn_delete_url);
            bAI();
        }
    }

    public void bAI() {
        boolean z;
        if (StringUtils.isNull(bAJ())) {
            z = this.gJm.getVisibility() == 0 || this.eZc.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            aj.b(this.gJi, d.e.cp_link_tip_a, d.e.s_navbar_title_color);
            this.gJi.setEnabled(true);
            return;
        }
        aj.c(this.gJi, d.e.cp_cont_d, 1);
        this.gJi.setEnabled(false);
    }

    public String bAJ() {
        if (this.gJk == null || this.gJk.getText() == null) {
            return null;
        }
        return this.gJk.getText().toString();
    }

    public View XH() {
        return this.dRT;
    }

    public View bAK() {
        return this.gJi;
    }

    public View getRootView() {
        return this.Rh;
    }

    public View bAL() {
        return this.gJk;
    }

    public View bpb() {
        return this.gJr;
    }

    public View bAM() {
        return this.gJo;
    }

    public View bAN() {
        return this.gJm;
    }

    public View getVideoContainer() {
        return this.eZc;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.gJv.setText(aVar.linkUrl);
            this.gJv.setSelection(aVar.linkUrl.length());
        }
        this.gJv.requestFocus();
        k.b(this.gJh.getActivity(), this.gJv);
        this.gJu.setVisibility(0);
        this.gJy.setVisibility(0);
        this.gJl.setVisibility(8);
    }

    public void bAO() {
        this.gJu.setVisibility(8);
        this.gJy.setVisibility(8);
        this.gJl.setVisibility(0);
        k.a(this.gJh.getActivity(), this.gJv);
    }

    public void S(View.OnClickListener onClickListener) {
        this.gJu.setOnClickListener(onClickListener);
        this.gJy.setOnClickListener(onClickListener);
        this.gJl.setOnClickListener(onClickListener);
    }

    public String bAP() {
        if (this.gJv == null || this.gJv.getText() == null) {
            return null;
        }
        return this.gJv.getText().toString();
    }

    public void bAQ() {
        if (this.gJz != null) {
            this.gJz.setText(d.l.tip_url_not_match);
            aj.i(this.gJz, d.e.cp_other_b);
        }
    }

    public void T(View.OnClickListener onClickListener) {
        if (this.gJx != null) {
            this.gJx.setOnClickListener(onClickListener);
        }
    }

    public View bAR() {
        return this.gJu;
    }

    public void destroy() {
        if (this.gJk != null) {
            this.gJk.addTextChangedListener(null);
        }
        if (this.gJv != null) {
            this.gJv.addTextChangedListener(null);
        }
    }

    public void d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.tB(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ar(this.gJh.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.gJh.getPageContext().getPageActivity().getString(d.l.error_write);
                }
                this.gJh.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.aLP.c(null);
        this.aLP.dd(d.l.sending);
        this.aLP.aH(true);
    }

    public void closeLoadingDialog() {
        this.aLP.aH(false);
    }
}
