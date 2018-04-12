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
    private View Tl;
    private com.baidu.tbadk.core.view.a aNc;
    private View esJ;
    private TbImageView ewV;
    private RelativeLayout fwi;
    private WriteUrlActivity hiU;
    private TextView hiV;
    private TbImageView hiW;
    private EditText hiX;
    private View hiY;
    private LinearLayout hiZ;
    private ImageView hja;
    private View hjb;
    private TextView hjc;
    private TextView hjd;
    private View hje;
    private TextView hjf;
    private TextView hjg;
    private LinearLayout hjh;
    private EditText hji;
    private View hjj;
    private TextView hjk;
    private FrameLayout hjl;
    private TextView hjm;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.esJ = null;
        this.aNc = null;
        if (writeUrlActivity != null) {
            this.hiU = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.Tl = LayoutInflater.from(this.hiU.getPageContext().getPageActivity()).inflate(d.i.write_url_activity_layout, (ViewGroup) null);
            this.hiU.setContentView(this.Tl);
            this.mNavigationBar = (NavigationBar) this.Tl.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.esJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.esJ.getLayoutParams();
                layoutParams.leftMargin = l.e(this.hiU.getActivity(), d.e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.esJ != null && (this.esJ.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.esJ.getLayoutParams();
                layoutParams2.width = -2;
                this.esJ.setLayoutParams(layoutParams2);
            }
            this.Tl.setOnClickListener(this.mClickListener);
            this.hiV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.k.send_post));
            ak.c(this.hiV, d.C0126d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hiV.getLayoutParams();
            layoutParams3.rightMargin = l.e(this.hiU.getActivity(), d.e.ds16);
            this.hiV.setLayoutParams(layoutParams3);
            this.hiV.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.k.post_new_thread));
            this.hiW = (TbImageView) this.Tl.findViewById(d.g.imageview_picture);
            this.hiW.setDefaultResource(d.f.ic_post_url_n);
            this.hiW.setDefaultErrorResource(d.f.ic_post_url_n);
            this.hiW.setDefaultBgResource(d.C0126d.black_alpha0);
            this.hiZ = (LinearLayout) this.Tl.findViewById(d.g.view_picture_publish);
            this.hiZ.setOnClickListener(this.mClickListener);
            this.fwi = (RelativeLayout) this.Tl.findViewById(d.g.video_container);
            this.fwi.setOnClickListener(this.mClickListener);
            this.ewV = (TbImageView) this.Tl.findViewById(d.g.video_img_thumbnail);
            this.ewV.setDefaultErrorResource(0);
            this.ewV.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.ewV.setDefaultBgResource(d.C0126d.black_alpha0);
            this.hja = (ImageView) this.Tl.findViewById(d.g.video_img_play);
            this.hjb = this.Tl.findViewById(d.g.video_view_delete);
            this.hjb.setOnClickListener(this.mClickListener);
            this.hjc = (TextView) this.Tl.findViewById(d.g.textview_title);
            this.hjd = (TextView) this.Tl.findViewById(d.g.textview_abstract);
            this.hje = this.Tl.findViewById(d.g.view_delete);
            this.hje.setOnClickListener(this.mClickListener);
            this.hiY = this.Tl.findViewById(d.g.icon_invoke_link);
            this.hiY.setOnClickListener(this.mClickListener);
            this.hiX = (EditText) this.Tl.findViewById(d.g.post_content);
            this.hjf = (TextView) this.Tl.findViewById(d.g.textview_error_tip);
            this.hjg = (TextView) this.Tl.findViewById(d.g.textview_url);
            this.hjh = (LinearLayout) this.Tl.findViewById(d.g.url_edit_container);
            this.hji = (EditText) this.Tl.findViewById(d.g.url_input);
            this.hjm = (TextView) this.Tl.findViewById(d.g.url_desc);
            this.hjj = this.Tl.findViewById(d.g.url_input_clear);
            this.hjk = (TextView) this.Tl.findViewById(d.g.url_add);
            this.hjk.setEnabled(false);
            this.hjl = (FrameLayout) this.Tl.findViewById(d.g.url_edit_back_view);
            this.hji.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.hjj.setVisibility(8);
                        ak.h(k.this.hjk, d.C0126d.cp_cont_e);
                        k.this.hjk.setEnabled(false);
                        return;
                    }
                    k.this.hjj.setVisibility(0);
                    ak.h(k.this.hjk, d.C0126d.cp_link_tip_a);
                    k.this.hjk.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.hjm.getText().equals(k.this.hiU.getActivity().getString(d.k.tip_url_not_match))) {
                        k.this.bEg();
                    }
                }
            });
            this.hjj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    k.this.hji.setText("");
                    k.this.hjj.setVisibility(8);
                    k.this.hjk.setEnabled(false);
                }
            });
            this.aNc = new com.baidu.tbadk.core.view.a(this.hiU.getPageContext());
            bEg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEg() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.hjm.setText(d.k.tip_url_post);
        } else {
            this.hjm.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        ak.h(this.hjm, d.C0126d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.hiU.setIsLoading(z);
        if (z) {
            this.hiZ.setVisibility(0);
            this.fwi.setVisibility(8);
            this.hiW.startLoad(null, 10, false);
            this.hjc.setVisibility(8);
            this.hjd.setVisibility(8);
            this.hjf.setVisibility(8);
            this.hjg.setVisibility(0);
            ak.h(this.hjg, d.C0126d.cp_cont_f);
            this.hjg.setText(d.k.tip_url_loading);
        } else if (aVar == null) {
            this.hiZ.setVisibility(8);
            this.fwi.setVisibility(8);
            bEh();
        } else {
            if (aVar.hdc == 1) {
                this.hiZ.setVisibility(0);
                this.fwi.setVisibility(8);
                if (aVar.hdb) {
                    this.hiW.startLoad(aVar.hde, 10, false);
                    this.hjc.setText(aVar.Yv);
                    this.hjd.setText(aVar.Yw);
                    if (an.ek(aVar.Yv) > 30) {
                        this.hjc.setMaxLines(2);
                        this.hjd.setMaxLines(1);
                    } else {
                        this.hjc.setMaxLines(1);
                        this.hjd.setMaxLines(2);
                    }
                    this.hjc.setVisibility(0);
                    this.hjd.setVisibility(0);
                    this.hjg.setVisibility(8);
                    this.hjf.setVisibility(8);
                } else {
                    this.hiW.reset();
                    this.hjg.setText(aVar.linkUrl);
                    ak.h(this.hjg, d.C0126d.cp_cont_b);
                    this.hjc.setVisibility(8);
                    this.hjd.setVisibility(8);
                    this.hjg.setVisibility(0);
                    this.hjf.setVisibility(0);
                }
            } else if (aVar.hdc == 2) {
                this.hiZ.setVisibility(8);
                this.fwi.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.fwi.getLayoutParams();
                layoutParams.height = ((l.af(this.hiU.getPageContext().getPageActivity()) - ((int) this.hiU.getPageContext().getPageActivity().getResources().getDimension(d.e.ds80))) * 9) / 16;
                this.fwi.setLayoutParams(layoutParams);
                ak.c(this.hja, d.f.icon_play_video);
                ak.i(this.hjb, d.f.btn_delete_url);
                this.ewV.startLoad(aVar.hdh, 10, false);
            } else {
                this.hiZ.setVisibility(0);
                this.fwi.setVisibility(8);
                this.hjc.setVisibility(8);
                this.hjd.setVisibility(8);
                this.hjg.setVisibility(0);
                this.hjf.setVisibility(0);
                this.hiW.reset();
                this.hjg.setText(aVar.linkUrl);
                ak.h(this.hjg, d.C0126d.cp_cont_b);
            }
            bEh();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.hiX.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.hiU != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hiU.getPageContext(), i);
            }
            ak.j(this.mNavigationBar, d.C0126d.cp_bg_line_d);
            ak.j(this.Tl, d.C0126d.cp_bg_line_d);
            this.hiX.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
            this.hiX.setTextColor(ak.getColor(d.C0126d.cp_cont_f));
            ak.j(this.hiZ, d.C0126d.cp_bg_line_e);
            ak.h(this.hjc, d.C0126d.cp_cont_b);
            ak.h(this.hjd, d.C0126d.cp_cont_d);
            ak.h(this.hjg, d.C0126d.cp_cont_b);
            ak.j(this.hjf, d.C0126d.cp_bg_line_d);
            ak.h(this.hjf, d.C0126d.cp_cont_d);
            ak.i(this.hiY, d.f.bg_link_invoke);
            ak.j(this.hjh, d.C0126d.cp_bg_line_d);
            this.hji.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
            ak.h(this.hji, d.C0126d.cp_cont_b);
            ak.h(this.hjm, d.C0126d.cp_cont_d);
            ak.h(this.hjk, d.C0126d.cp_cont_e);
            ak.c(this.hja, d.f.home_ic_video);
            ak.i(this.hje, d.f.btn_delete_url);
            ak.i(this.hjj, d.f.btn_delete_url);
            ak.i(this.hjb, d.f.btn_delete_url);
            bEh();
        }
    }

    public void bEh() {
        boolean z;
        if (StringUtils.isNull(bEi())) {
            z = this.hiZ.getVisibility() == 0 || this.fwi.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            ak.b(this.hiV, d.C0126d.cp_link_tip_a, d.C0126d.s_navbar_title_color);
            this.hiV.setEnabled(true);
            return;
        }
        ak.c(this.hiV, d.C0126d.cp_cont_d, 1);
        this.hiV.setEnabled(false);
    }

    public String bEi() {
        if (this.hiX == null || this.hiX.getText() == null) {
            return null;
        }
        return this.hiX.getText().toString();
    }

    public View aGO() {
        return this.esJ;
    }

    public View bEj() {
        return this.hiV;
    }

    public View getRootView() {
        return this.Tl;
    }

    public EditText bEk() {
        return this.hiX;
    }

    public View bEl() {
        return this.hje;
    }

    public View bEm() {
        return this.hjb;
    }

    public View bEn() {
        return this.hiZ;
    }

    public View getVideoContainer() {
        return this.fwi;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.hji.setText(aVar.linkUrl);
            this.hji.setSelection(aVar.linkUrl.length());
        }
        this.hji.requestFocus();
        l.c(this.hiU.getActivity(), this.hji);
        this.hjh.setVisibility(0);
        this.hjl.setVisibility(0);
        this.hiY.setVisibility(8);
    }

    public void bEo() {
        this.hjh.setVisibility(8);
        this.hjl.setVisibility(8);
        this.hiY.setVisibility(0);
        l.b(this.hiU.getActivity(), this.hji);
    }

    public void W(View.OnClickListener onClickListener) {
        this.hjh.setOnClickListener(onClickListener);
        this.hjl.setOnClickListener(onClickListener);
        this.hiY.setOnClickListener(onClickListener);
    }

    public String bEp() {
        if (this.hji == null || this.hji.getText() == null) {
            return null;
        }
        return this.hji.getText().toString();
    }

    public void bEq() {
        if (this.hjm != null) {
            this.hjm.setText(d.k.tip_url_not_match);
            ak.h(this.hjm, d.C0126d.cp_other_b);
        }
    }

    public void X(View.OnClickListener onClickListener) {
        if (this.hjk != null) {
            this.hjk.setOnClickListener(onClickListener);
        }
    }

    public View bEr() {
        return this.hjh;
    }

    public void destroy() {
        if (this.hiX != null) {
            this.hiX.addTextChangedListener(null);
        }
        if (this.hji != null) {
            this.hji.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.tu(postWriteCallBackData.getErrorCode())) {
                AntiHelper.am(this.hiU.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.hiU.getPageContext().getPageActivity().getString(d.k.sand_fail);
                }
                this.hiU.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.aNc.d(null);
        this.aNc.da(d.k.sending);
        this.aNc.aI(true);
    }

    public void closeLoadingDialog() {
        this.aNc.aI(false);
    }
}
