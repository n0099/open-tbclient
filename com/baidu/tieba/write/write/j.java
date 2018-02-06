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
    private View aId;
    private com.baidu.tbadk.core.view.b bCM;
    private View eYa;
    private TbImageView fcm;
    private RelativeLayout gbU;
    private WriteUrlActivity hMV;
    private TextView hMW;
    private TbImageView hMX;
    private EditText hMY;
    private View hMZ;
    private LinearLayout hNa;
    private ImageView hNb;
    private View hNc;
    private TextView hNd;
    private TextView hNe;
    private View hNf;
    private TextView hNg;
    private TextView hNh;
    private LinearLayout hNi;
    private EditText hNj;
    private View hNk;
    private TextView hNl;
    private FrameLayout hNm;
    private TextView hNn;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public j(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.eYa = null;
        this.bCM = null;
        if (writeUrlActivity != null) {
            this.hMV = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.aId = LayoutInflater.from(this.hMV.getPageContext().getPageActivity()).inflate(d.h.write_url_activity_layout, (ViewGroup) null);
            this.hMV.setContentView(this.aId);
            this.mNavigationBar = (NavigationBar) this.aId.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.eYa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eYa.getLayoutParams();
                layoutParams.leftMargin = l.t(this.hMV.getActivity(), d.e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.eYa != null && (this.eYa.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eYa.getLayoutParams();
                layoutParams2.width = -2;
                this.eYa.setLayoutParams(layoutParams2);
            }
            this.aId.setOnClickListener(this.mClickListener);
            this.hMW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.j.send_post));
            aj.e(this.hMW, d.C0140d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hMW.getLayoutParams();
            layoutParams3.rightMargin = l.t(this.hMV.getActivity(), d.e.ds16);
            this.hMW.setLayoutParams(layoutParams3);
            this.hMW.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.j.post_new_thread));
            this.hMX = (TbImageView) this.aId.findViewById(d.g.imageview_picture);
            this.hMX.setDefaultResource(d.f.ic_post_url_n);
            this.hMX.setDefaultErrorResource(d.f.ic_post_url_n);
            this.hMX.setDefaultBgResource(d.C0140d.black_alpha0);
            this.hNa = (LinearLayout) this.aId.findViewById(d.g.view_picture_publish);
            this.hNa.setOnClickListener(this.mClickListener);
            this.gbU = (RelativeLayout) this.aId.findViewById(d.g.video_container);
            this.gbU.setOnClickListener(this.mClickListener);
            this.fcm = (TbImageView) this.aId.findViewById(d.g.video_img_thumbnail);
            this.fcm.setDefaultErrorResource(0);
            this.fcm.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.fcm.setDefaultBgResource(d.C0140d.black_alpha0);
            this.hNb = (ImageView) this.aId.findViewById(d.g.video_img_play);
            this.hNc = this.aId.findViewById(d.g.video_view_delete);
            this.hNc.setOnClickListener(this.mClickListener);
            this.hNd = (TextView) this.aId.findViewById(d.g.textview_title);
            this.hNe = (TextView) this.aId.findViewById(d.g.textview_abstract);
            this.hNf = this.aId.findViewById(d.g.view_delete);
            this.hNf.setOnClickListener(this.mClickListener);
            this.hMZ = this.aId.findViewById(d.g.icon_invoke_link);
            this.hMZ.setOnClickListener(this.mClickListener);
            this.hMY = (EditText) this.aId.findViewById(d.g.post_content);
            this.hNg = (TextView) this.aId.findViewById(d.g.textview_error_tip);
            this.hNh = (TextView) this.aId.findViewById(d.g.textview_url);
            this.hNi = (LinearLayout) this.aId.findViewById(d.g.url_edit_container);
            this.hNj = (EditText) this.aId.findViewById(d.g.url_input);
            this.hNn = (TextView) this.aId.findViewById(d.g.url_desc);
            this.hNk = this.aId.findViewById(d.g.url_input_clear);
            this.hNl = (TextView) this.aId.findViewById(d.g.url_add);
            this.hNl.setEnabled(false);
            this.hNm = (FrameLayout) this.aId.findViewById(d.g.url_edit_back_view);
            this.hNj.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.j.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        j.this.hNk.setVisibility(8);
                        aj.r(j.this.hNl, d.C0140d.cp_cont_e);
                        j.this.hNl.setEnabled(false);
                        return;
                    }
                    j.this.hNk.setVisibility(0);
                    aj.r(j.this.hNl, d.C0140d.cp_link_tip_a);
                    j.this.hNl.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (j.this.hNn.getText().equals(j.this.hMV.getActivity().getString(d.j.tip_url_not_match))) {
                        j.this.bJo();
                    }
                }
            });
            this.hNk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.hNj.setText("");
                    j.this.hNk.setVisibility(8);
                    j.this.hNl.setEnabled(false);
                }
            });
            this.bCM = new com.baidu.tbadk.core.view.b(this.hMV.getPageContext());
            bJo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJo() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.hNn.setText(d.j.tip_url_post);
        } else {
            this.hNn.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        aj.r(this.hNn, d.C0140d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.hMV.setIsLoading(z);
        if (z) {
            this.hNa.setVisibility(0);
            this.gbU.setVisibility(8);
            this.hMX.startLoad(null, 10, false);
            this.hNd.setVisibility(8);
            this.hNe.setVisibility(8);
            this.hNg.setVisibility(8);
            this.hNh.setVisibility(0);
            aj.r(this.hNh, d.C0140d.cp_cont_f);
            this.hNh.setText(d.j.tip_url_loading);
        } else if (aVar == null) {
            this.hNa.setVisibility(8);
            this.gbU.setVisibility(8);
            bJp();
        } else {
            if (aVar.hGm == 1) {
                this.hNa.setVisibility(0);
                this.gbU.setVisibility(8);
                if (aVar.hGl) {
                    this.hMX.startLoad(aVar.hGo, 10, false);
                    this.hNd.setText(aVar.aNe);
                    this.hNe.setText(aVar.aNf);
                    if (am.es(aVar.aNe) > 30) {
                        this.hNd.setMaxLines(2);
                        this.hNe.setMaxLines(1);
                    } else {
                        this.hNd.setMaxLines(1);
                        this.hNe.setMaxLines(2);
                    }
                    this.hNd.setVisibility(0);
                    this.hNe.setVisibility(0);
                    this.hNh.setVisibility(8);
                    this.hNg.setVisibility(8);
                } else {
                    this.hMX.reset();
                    this.hNh.setText(aVar.linkUrl);
                    aj.r(this.hNh, d.C0140d.cp_cont_b);
                    this.hNd.setVisibility(8);
                    this.hNe.setVisibility(8);
                    this.hNh.setVisibility(0);
                    this.hNg.setVisibility(0);
                }
            } else if (aVar.hGm == 2) {
                this.hNa.setVisibility(8);
                this.gbU.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.gbU.getLayoutParams();
                layoutParams.height = ((l.ao(this.hMV.getPageContext().getPageActivity()) - ((int) this.hMV.getPageContext().getPageActivity().getResources().getDimension(d.e.ds80))) * 9) / 16;
                this.gbU.setLayoutParams(layoutParams);
                aj.c(this.hNb, d.f.icon_play_video);
                aj.s(this.hNc, d.f.btn_delete_url);
                this.fcm.startLoad(aVar.hGr, 10, false);
            } else {
                this.hNa.setVisibility(0);
                this.gbU.setVisibility(8);
                this.hNd.setVisibility(8);
                this.hNe.setVisibility(8);
                this.hNh.setVisibility(0);
                this.hNg.setVisibility(0);
                this.hMX.reset();
                this.hNh.setText(aVar.linkUrl);
                aj.r(this.hNh, d.C0140d.cp_cont_b);
            }
            bJp();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.hMY.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.hMV != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hMV.getPageContext(), i);
            }
            aj.t(this.mNavigationBar, d.C0140d.cp_bg_line_d);
            aj.t(this.aId, d.C0140d.cp_bg_line_d);
            this.hMY.setHintTextColor(aj.getColor(d.C0140d.cp_cont_e));
            this.hMY.setTextColor(aj.getColor(d.C0140d.cp_cont_f));
            aj.t(this.hNa, d.C0140d.cp_bg_line_e);
            aj.r(this.hNd, d.C0140d.cp_cont_b);
            aj.r(this.hNe, d.C0140d.cp_cont_d);
            aj.r(this.hNh, d.C0140d.cp_cont_b);
            aj.t(this.hNg, d.C0140d.cp_bg_line_d);
            aj.r(this.hNg, d.C0140d.cp_cont_d);
            aj.s(this.hMZ, d.f.bg_link_invoke);
            aj.t(this.hNi, d.C0140d.cp_bg_line_d);
            this.hNj.setHintTextColor(aj.getColor(d.C0140d.cp_cont_e));
            aj.r(this.hNj, d.C0140d.cp_cont_b);
            aj.r(this.hNn, d.C0140d.cp_cont_d);
            aj.r(this.hNl, d.C0140d.cp_cont_e);
            aj.c(this.hNb, d.f.home_ic_video);
            aj.s(this.hNf, d.f.btn_delete_url);
            aj.s(this.hNk, d.f.btn_delete_url);
            aj.s(this.hNc, d.f.btn_delete_url);
            bJp();
        }
    }

    public void bJp() {
        boolean z;
        if (StringUtils.isNull(bJq())) {
            z = this.hNa.getVisibility() == 0 || this.gbU.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            aj.d(this.hMW, d.C0140d.cp_link_tip_a, d.C0140d.s_navbar_title_color);
            this.hMW.setEnabled(true);
            return;
        }
        aj.e(this.hMW, d.C0140d.cp_cont_d, 1);
        this.hMW.setEnabled(false);
    }

    public String bJq() {
        if (this.hMY == null || this.hMY.getText() == null) {
            return null;
        }
        return this.hMY.getText().toString();
    }

    public View aLO() {
        return this.eYa;
    }

    public View bJr() {
        return this.hMW;
    }

    public View getRootView() {
        return this.aId;
    }

    public EditText bJs() {
        return this.hMY;
    }

    public View bJt() {
        return this.hNf;
    }

    public View bJu() {
        return this.hNc;
    }

    public View bJv() {
        return this.hNa;
    }

    public View getVideoContainer() {
        return this.gbU;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.hNj.setText(aVar.linkUrl);
            this.hNj.setSelection(aVar.linkUrl.length());
        }
        this.hNj.requestFocus();
        l.b(this.hMV.getActivity(), this.hNj);
        this.hNi.setVisibility(0);
        this.hNm.setVisibility(0);
        this.hMZ.setVisibility(8);
    }

    public void bJw() {
        this.hNi.setVisibility(8);
        this.hNm.setVisibility(8);
        this.hMZ.setVisibility(0);
        l.a(this.hMV.getActivity(), this.hNj);
    }

    public void U(View.OnClickListener onClickListener) {
        this.hNi.setOnClickListener(onClickListener);
        this.hNm.setOnClickListener(onClickListener);
        this.hMZ.setOnClickListener(onClickListener);
    }

    public String bJx() {
        if (this.hNj == null || this.hNj.getText() == null) {
            return null;
        }
        return this.hNj.getText().toString();
    }

    public void bJy() {
        if (this.hNn != null) {
            this.hNn.setText(d.j.tip_url_not_match);
            aj.r(this.hNn, d.C0140d.cp_other_b);
        }
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.hNl != null) {
            this.hNl.setOnClickListener(onClickListener);
        }
    }

    public View bJz() {
        return this.hNi;
    }

    public void destroy() {
        if (this.hMY != null) {
            this.hMY.addTextChangedListener(null);
        }
        if (this.hNj != null) {
            this.hNj.addTextChangedListener(null);
        }
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.vQ(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ar(this.hMV.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.hMV.getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                this.hMV.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.bCM.d(null);
        this.bCM.ga(d.j.sending);
        this.bCM.bq(true);
    }

    public void closeLoadingDialog() {
        this.bCM.bq(false);
    }
}
