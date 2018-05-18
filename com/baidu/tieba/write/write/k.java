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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes3.dex */
public class k {
    private View Th;
    private com.baidu.tbadk.core.view.a aNd;
    private View etP;
    private TbImageView eyb;
    private RelativeLayout fxl;
    private WriteUrlActivity hjV;
    private TextView hjW;
    private TbImageView hjX;
    private EditText hjY;
    private View hjZ;
    private LinearLayout hka;
    private ImageView hkb;
    private View hkc;
    private TextView hkd;
    private TextView hke;
    private View hkf;
    private TextView hkg;
    private TextView hkh;
    private LinearLayout hki;
    private EditText hkj;
    private View hkk;
    private TextView hkl;
    private FrameLayout hkm;
    private TextView hkn;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.etP = null;
        this.aNd = null;
        if (writeUrlActivity != null) {
            this.hjV = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.Th = LayoutInflater.from(this.hjV.getPageContext().getPageActivity()).inflate(d.i.write_url_activity_layout, (ViewGroup) null);
            this.hjV.setContentView(this.Th);
            this.mNavigationBar = (NavigationBar) this.Th.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.etP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etP.getLayoutParams();
                layoutParams.leftMargin = l.e(this.hjV.getActivity(), d.e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.etP != null && (this.etP.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.etP.getLayoutParams();
                layoutParams2.width = -2;
                this.etP.setLayoutParams(layoutParams2);
            }
            this.Th.setOnClickListener(this.mClickListener);
            this.hjW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.k.send_post));
            ak.c(this.hjW, d.C0126d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hjW.getLayoutParams();
            layoutParams3.rightMargin = l.e(this.hjV.getActivity(), d.e.ds16);
            this.hjW.setLayoutParams(layoutParams3);
            this.hjW.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.k.post_new_thread));
            this.hjX = (TbImageView) this.Th.findViewById(d.g.imageview_picture);
            this.hjX.setDefaultResource(d.f.ic_post_url_n);
            this.hjX.setDefaultErrorResource(d.f.ic_post_url_n);
            this.hjX.setDefaultBgResource(d.C0126d.black_alpha0);
            this.hka = (LinearLayout) this.Th.findViewById(d.g.view_picture_publish);
            this.hka.setOnClickListener(this.mClickListener);
            this.fxl = (RelativeLayout) this.Th.findViewById(d.g.video_container);
            this.fxl.setOnClickListener(this.mClickListener);
            this.eyb = (TbImageView) this.Th.findViewById(d.g.video_img_thumbnail);
            this.eyb.setDefaultErrorResource(0);
            this.eyb.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.eyb.setDefaultBgResource(d.C0126d.black_alpha0);
            this.hkb = (ImageView) this.Th.findViewById(d.g.video_img_play);
            this.hkc = this.Th.findViewById(d.g.video_view_delete);
            this.hkc.setOnClickListener(this.mClickListener);
            this.hkd = (TextView) this.Th.findViewById(d.g.textview_title);
            this.hke = (TextView) this.Th.findViewById(d.g.textview_abstract);
            this.hkf = this.Th.findViewById(d.g.view_delete);
            this.hkf.setOnClickListener(this.mClickListener);
            this.hjZ = this.Th.findViewById(d.g.icon_invoke_link);
            this.hjZ.setOnClickListener(this.mClickListener);
            this.hjY = (EditText) this.Th.findViewById(d.g.post_content);
            this.hkg = (TextView) this.Th.findViewById(d.g.textview_error_tip);
            this.hkh = (TextView) this.Th.findViewById(d.g.textview_url);
            this.hki = (LinearLayout) this.Th.findViewById(d.g.url_edit_container);
            this.hkj = (EditText) this.Th.findViewById(d.g.url_input);
            this.hkn = (TextView) this.Th.findViewById(d.g.url_desc);
            this.hkk = this.Th.findViewById(d.g.url_input_clear);
            this.hkl = (TextView) this.Th.findViewById(d.g.url_add);
            this.hkl.setEnabled(false);
            this.hkm = (FrameLayout) this.Th.findViewById(d.g.url_edit_back_view);
            this.hkj.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.hkk.setVisibility(8);
                        ak.h(k.this.hkl, d.C0126d.cp_cont_e);
                        k.this.hkl.setEnabled(false);
                        return;
                    }
                    k.this.hkk.setVisibility(0);
                    ak.h(k.this.hkl, d.C0126d.cp_link_tip_a);
                    k.this.hkl.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.hkn.getText().equals(k.this.hjV.getActivity().getString(d.k.tip_url_not_match))) {
                        k.this.bEe();
                    }
                }
            });
            this.hkk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    k.this.hkj.setText("");
                    k.this.hkk.setVisibility(8);
                    k.this.hkl.setEnabled(false);
                }
            });
            this.aNd = new com.baidu.tbadk.core.view.a(this.hjV.getPageContext());
            bEe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEe() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.hkn.setText(d.k.tip_url_post);
        } else {
            this.hkn.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        ak.h(this.hkn, d.C0126d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.hjV.setIsLoading(z);
        if (z) {
            this.hka.setVisibility(0);
            this.fxl.setVisibility(8);
            this.hjX.startLoad(null, 10, false);
            this.hkd.setVisibility(8);
            this.hke.setVisibility(8);
            this.hkg.setVisibility(8);
            this.hkh.setVisibility(0);
            ak.h(this.hkh, d.C0126d.cp_cont_f);
            this.hkh.setText(d.k.tip_url_loading);
        } else if (aVar == null) {
            this.hka.setVisibility(8);
            this.fxl.setVisibility(8);
            bEf();
        } else {
            if (aVar.hed == 1) {
                this.hka.setVisibility(0);
                this.fxl.setVisibility(8);
                if (aVar.hec) {
                    this.hjX.startLoad(aVar.hef, 10, false);
                    this.hkd.setText(aVar.Yv);
                    this.hke.setText(aVar.Yw);
                    if (an.ek(aVar.Yv) > 30) {
                        this.hkd.setMaxLines(2);
                        this.hke.setMaxLines(1);
                    } else {
                        this.hkd.setMaxLines(1);
                        this.hke.setMaxLines(2);
                    }
                    this.hkd.setVisibility(0);
                    this.hke.setVisibility(0);
                    this.hkh.setVisibility(8);
                    this.hkg.setVisibility(8);
                } else {
                    this.hjX.reset();
                    this.hkh.setText(aVar.linkUrl);
                    ak.h(this.hkh, d.C0126d.cp_cont_b);
                    this.hkd.setVisibility(8);
                    this.hke.setVisibility(8);
                    this.hkh.setVisibility(0);
                    this.hkg.setVisibility(0);
                }
            } else if (aVar.hed == 2) {
                this.hka.setVisibility(8);
                this.fxl.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.fxl.getLayoutParams();
                layoutParams.height = ((l.af(this.hjV.getPageContext().getPageActivity()) - ((int) this.hjV.getPageContext().getPageActivity().getResources().getDimension(d.e.ds80))) * 9) / 16;
                this.fxl.setLayoutParams(layoutParams);
                ak.c(this.hkb, d.f.icon_play_video);
                ak.i(this.hkc, d.f.btn_delete_url);
                this.eyb.startLoad(aVar.hei, 10, false);
            } else {
                this.hka.setVisibility(0);
                this.fxl.setVisibility(8);
                this.hkd.setVisibility(8);
                this.hke.setVisibility(8);
                this.hkh.setVisibility(0);
                this.hkg.setVisibility(0);
                this.hjX.reset();
                this.hkh.setText(aVar.linkUrl);
                ak.h(this.hkh, d.C0126d.cp_cont_b);
            }
            bEf();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.hjY.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.hjV != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hjV.getPageContext(), i);
            }
            ak.j(this.mNavigationBar, d.C0126d.cp_bg_line_d);
            ak.j(this.Th, d.C0126d.cp_bg_line_d);
            this.hjY.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
            this.hjY.setTextColor(ak.getColor(d.C0126d.cp_cont_f));
            ak.j(this.hka, d.C0126d.cp_bg_line_e);
            ak.h(this.hkd, d.C0126d.cp_cont_b);
            ak.h(this.hke, d.C0126d.cp_cont_d);
            ak.h(this.hkh, d.C0126d.cp_cont_b);
            ak.j(this.hkg, d.C0126d.cp_bg_line_d);
            ak.h(this.hkg, d.C0126d.cp_cont_d);
            ak.i(this.hjZ, d.f.bg_link_invoke);
            ak.j(this.hki, d.C0126d.cp_bg_line_d);
            this.hkj.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
            ak.h(this.hkj, d.C0126d.cp_cont_b);
            ak.h(this.hkn, d.C0126d.cp_cont_d);
            ak.h(this.hkl, d.C0126d.cp_cont_e);
            ak.c(this.hkb, d.f.home_ic_video);
            ak.i(this.hkf, d.f.btn_delete_url);
            ak.i(this.hkk, d.f.btn_delete_url);
            ak.i(this.hkc, d.f.btn_delete_url);
            bEf();
        }
    }

    public void bEf() {
        boolean z;
        if (StringUtils.isNull(bEg())) {
            z = this.hka.getVisibility() == 0 || this.fxl.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            ak.b(this.hjW, d.C0126d.cp_link_tip_a, d.C0126d.s_navbar_title_color);
            this.hjW.setEnabled(true);
            return;
        }
        ak.c(this.hjW, d.C0126d.cp_cont_d, 1);
        this.hjW.setEnabled(false);
    }

    public String bEg() {
        if (this.hjY == null || this.hjY.getText() == null) {
            return null;
        }
        return this.hjY.getText().toString();
    }

    public View aGM() {
        return this.etP;
    }

    public View bEh() {
        return this.hjW;
    }

    public View getRootView() {
        return this.Th;
    }

    public EditText bEi() {
        return this.hjY;
    }

    public View bEj() {
        return this.hkf;
    }

    public View bEk() {
        return this.hkc;
    }

    public View bEl() {
        return this.hka;
    }

    public View getVideoContainer() {
        return this.fxl;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.hkj.setText(aVar.linkUrl);
            this.hkj.setSelection(aVar.linkUrl.length());
        }
        this.hkj.requestFocus();
        l.c(this.hjV.getActivity(), this.hkj);
        this.hki.setVisibility(0);
        this.hkm.setVisibility(0);
        this.hjZ.setVisibility(8);
    }

    public void bEm() {
        this.hki.setVisibility(8);
        this.hkm.setVisibility(8);
        this.hjZ.setVisibility(0);
        l.b(this.hjV.getActivity(), this.hkj);
    }

    public void W(View.OnClickListener onClickListener) {
        this.hki.setOnClickListener(onClickListener);
        this.hkm.setOnClickListener(onClickListener);
        this.hjZ.setOnClickListener(onClickListener);
    }

    public String bEn() {
        if (this.hkj == null || this.hkj.getText() == null) {
            return null;
        }
        return this.hkj.getText().toString();
    }

    public void bEo() {
        if (this.hkn != null) {
            this.hkn.setText(d.k.tip_url_not_match);
            ak.h(this.hkn, d.C0126d.cp_other_b);
        }
    }

    public void X(View.OnClickListener onClickListener) {
        if (this.hkl != null) {
            this.hkl.setOnClickListener(onClickListener);
        }
    }

    public View bEp() {
        return this.hki;
    }

    public void destroy() {
        if (this.hjY != null) {
            this.hjY.addTextChangedListener(null);
        }
        if (this.hkj != null) {
            this.hkj.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.ts(postWriteCallBackData.getErrorCode())) {
                AntiHelper.am(this.hjV.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.hjV.getPageContext().getPageActivity().getString(d.k.sand_fail);
                }
                this.hjV.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.aNd.d(null);
        this.aNd.da(d.k.sending);
        this.aNd.aI(true);
    }

    public void closeLoadingDialog() {
        this.aNd.aI(false);
    }
}
