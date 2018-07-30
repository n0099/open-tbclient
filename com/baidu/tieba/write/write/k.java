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
    private com.baidu.tbadk.core.view.a aVY;
    private View aaV;
    private View eMP;
    private TbImageView eRj;
    private RelativeLayout fMV;
    private WriteUrlActivity hBh;
    private TextView hBi;
    private TbImageView hBj;
    private EditText hBk;
    private View hBl;
    private LinearLayout hBm;
    private ImageView hBn;
    private View hBo;
    private TextView hBp;
    private TextView hBq;
    private View hBr;
    private TextView hBs;
    private TextView hBt;
    private LinearLayout hBu;
    private EditText hBv;
    private View hBw;
    private TextView hBx;
    private FrameLayout hBy;
    private TextView hBz;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.eMP = null;
        this.aVY = null;
        if (writeUrlActivity != null) {
            this.hBh = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.aaV = LayoutInflater.from(this.hBh.getPageContext().getPageActivity()).inflate(d.h.write_url_activity_layout, (ViewGroup) null);
            this.hBh.setContentView(this.aaV);
            this.mNavigationBar = (NavigationBar) this.aaV.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.eMP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eMP.getLayoutParams();
                layoutParams.leftMargin = l.f(this.hBh.getActivity(), d.e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.eMP != null && (this.eMP.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eMP.getLayoutParams();
                layoutParams2.width = -2;
                this.eMP.setLayoutParams(layoutParams2);
            }
            this.aaV.setOnClickListener(this.mClickListener);
            this.hBi = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.j.send_post));
            am.c(this.hBi, d.C0140d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hBi.getLayoutParams();
            layoutParams3.rightMargin = l.f(this.hBh.getActivity(), d.e.ds16);
            this.hBi.setLayoutParams(layoutParams3);
            this.hBi.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.j.post_new_thread));
            this.hBj = (TbImageView) this.aaV.findViewById(d.g.imageview_picture);
            this.hBj.setDefaultResource(d.f.ic_post_url_n);
            this.hBj.setDefaultErrorResource(d.f.ic_post_url_n);
            this.hBj.setDefaultBgResource(d.C0140d.black_alpha0);
            this.hBm = (LinearLayout) this.aaV.findViewById(d.g.view_picture_publish);
            this.hBm.setOnClickListener(this.mClickListener);
            this.fMV = (RelativeLayout) this.aaV.findViewById(d.g.video_container);
            this.fMV.setOnClickListener(this.mClickListener);
            this.eRj = (TbImageView) this.aaV.findViewById(d.g.video_img_thumbnail);
            this.eRj.setDefaultErrorResource(0);
            this.eRj.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.eRj.setDefaultBgResource(d.C0140d.black_alpha0);
            this.hBn = (ImageView) this.aaV.findViewById(d.g.video_img_play);
            this.hBo = this.aaV.findViewById(d.g.video_view_delete);
            this.hBo.setOnClickListener(this.mClickListener);
            this.hBp = (TextView) this.aaV.findViewById(d.g.textview_title);
            this.hBq = (TextView) this.aaV.findViewById(d.g.textview_abstract);
            this.hBr = this.aaV.findViewById(d.g.view_delete);
            this.hBr.setOnClickListener(this.mClickListener);
            this.hBl = this.aaV.findViewById(d.g.icon_invoke_link);
            this.hBl.setOnClickListener(this.mClickListener);
            this.hBk = (EditText) this.aaV.findViewById(d.g.post_content);
            this.hBs = (TextView) this.aaV.findViewById(d.g.textview_error_tip);
            this.hBt = (TextView) this.aaV.findViewById(d.g.textview_url);
            this.hBu = (LinearLayout) this.aaV.findViewById(d.g.url_edit_container);
            this.hBv = (EditText) this.aaV.findViewById(d.g.url_input);
            this.hBz = (TextView) this.aaV.findViewById(d.g.url_desc);
            this.hBw = this.aaV.findViewById(d.g.url_input_clear);
            this.hBx = (TextView) this.aaV.findViewById(d.g.url_add);
            this.hBx.setEnabled(false);
            this.hBy = (FrameLayout) this.aaV.findViewById(d.g.url_edit_back_view);
            this.hBv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.hBw.setVisibility(8);
                        am.h(k.this.hBx, d.C0140d.cp_cont_e);
                        k.this.hBx.setEnabled(false);
                        return;
                    }
                    k.this.hBw.setVisibility(0);
                    am.h(k.this.hBx, d.C0140d.cp_link_tip_a);
                    k.this.hBx.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.hBz.getText().equals(k.this.hBh.getActivity().getString(d.j.tip_url_not_match))) {
                        k.this.bIx();
                    }
                }
            });
            this.hBw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.hBv.setText("");
                    k.this.hBw.setVisibility(8);
                    k.this.hBx.setEnabled(false);
                }
            });
            this.aVY = new com.baidu.tbadk.core.view.a(this.hBh.getPageContext());
            bIx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIx() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.hBz.setText(d.j.tip_url_post);
        } else {
            this.hBz.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        am.h(this.hBz, d.C0140d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.hBh.setIsLoading(z);
        if (z) {
            this.hBm.setVisibility(0);
            this.fMV.setVisibility(8);
            this.hBj.startLoad(null, 10, false);
            this.hBp.setVisibility(8);
            this.hBq.setVisibility(8);
            this.hBs.setVisibility(8);
            this.hBt.setVisibility(0);
            am.h(this.hBt, d.C0140d.cp_cont_f);
            this.hBt.setText(d.j.tip_url_loading);
        } else if (aVar == null) {
            this.hBm.setVisibility(8);
            this.fMV.setVisibility(8);
            bIy();
        } else {
            if (aVar.hvo == 1) {
                this.hBm.setVisibility(0);
                this.fMV.setVisibility(8);
                if (aVar.hvn) {
                    this.hBj.startLoad(aVar.hvq, 10, false);
                    this.hBp.setText(aVar.agg);
                    this.hBq.setText(aVar.agh);
                    if (ap.eK(aVar.agg) > 30) {
                        this.hBp.setMaxLines(2);
                        this.hBq.setMaxLines(1);
                    } else {
                        this.hBp.setMaxLines(1);
                        this.hBq.setMaxLines(2);
                    }
                    this.hBp.setVisibility(0);
                    this.hBq.setVisibility(0);
                    this.hBt.setVisibility(8);
                    this.hBs.setVisibility(8);
                } else {
                    this.hBj.reset();
                    this.hBt.setText(aVar.linkUrl);
                    am.h(this.hBt, d.C0140d.cp_cont_b);
                    this.hBp.setVisibility(8);
                    this.hBq.setVisibility(8);
                    this.hBt.setVisibility(0);
                    this.hBs.setVisibility(0);
                }
            } else if (aVar.hvo == 2) {
                this.hBm.setVisibility(8);
                this.fMV.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.fMV.getLayoutParams();
                layoutParams.height = ((l.ah(this.hBh.getPageContext().getPageActivity()) - ((int) this.hBh.getPageContext().getPageActivity().getResources().getDimension(d.e.ds80))) * 9) / 16;
                this.fMV.setLayoutParams(layoutParams);
                am.c(this.hBn, d.f.icon_play_video);
                am.i(this.hBo, d.f.btn_delete_url);
                this.eRj.startLoad(aVar.hvt, 10, false);
            } else {
                this.hBm.setVisibility(0);
                this.fMV.setVisibility(8);
                this.hBp.setVisibility(8);
                this.hBq.setVisibility(8);
                this.hBt.setVisibility(0);
                this.hBs.setVisibility(0);
                this.hBj.reset();
                this.hBt.setText(aVar.linkUrl);
                am.h(this.hBt, d.C0140d.cp_cont_b);
            }
            bIy();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.hBk.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.hBh != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hBh.getPageContext(), i);
            }
            am.j(this.mNavigationBar, d.C0140d.cp_bg_line_d);
            am.j(this.aaV, d.C0140d.cp_bg_line_d);
            this.hBk.setHintTextColor(am.getColor(d.C0140d.cp_cont_e));
            this.hBk.setTextColor(am.getColor(d.C0140d.cp_cont_f));
            am.j(this.hBm, d.C0140d.cp_bg_line_e);
            am.h(this.hBp, d.C0140d.cp_cont_b);
            am.h(this.hBq, d.C0140d.cp_cont_d);
            am.h(this.hBt, d.C0140d.cp_cont_b);
            am.j(this.hBs, d.C0140d.cp_bg_line_d);
            am.h(this.hBs, d.C0140d.cp_cont_d);
            am.i(this.hBl, d.f.bg_link_invoke);
            am.j(this.hBu, d.C0140d.cp_bg_line_d);
            this.hBv.setHintTextColor(am.getColor(d.C0140d.cp_cont_e));
            am.h(this.hBv, d.C0140d.cp_cont_b);
            am.h(this.hBz, d.C0140d.cp_cont_d);
            am.h(this.hBx, d.C0140d.cp_cont_e);
            am.c(this.hBn, d.f.home_ic_video);
            am.i(this.hBr, d.f.btn_delete_url);
            am.i(this.hBw, d.f.btn_delete_url);
            am.i(this.hBo, d.f.btn_delete_url);
            bIy();
        }
    }

    public void bIy() {
        boolean z;
        if (StringUtils.isNull(bIz())) {
            z = this.hBm.getVisibility() == 0 || this.fMV.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            am.b(this.hBi, d.C0140d.cp_link_tip_a, d.C0140d.s_navbar_title_color);
            this.hBi.setEnabled(true);
            return;
        }
        am.c(this.hBi, d.C0140d.cp_cont_d, 1);
        this.hBi.setEnabled(false);
    }

    public String bIz() {
        if (this.hBk == null || this.hBk.getText() == null) {
            return null;
        }
        return this.hBk.getText().toString();
    }

    public View aNn() {
        return this.eMP;
    }

    public View bIA() {
        return this.hBi;
    }

    public View getRootView() {
        return this.aaV;
    }

    public EditText bIB() {
        return this.hBk;
    }

    public View bIC() {
        return this.hBr;
    }

    public View bID() {
        return this.hBo;
    }

    public View bIE() {
        return this.hBm;
    }

    public View getVideoContainer() {
        return this.fMV;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.hBv.setText(aVar.linkUrl);
            this.hBv.setSelection(aVar.linkUrl.length());
        }
        this.hBv.requestFocus();
        l.b(this.hBh.getActivity(), this.hBv);
        this.hBu.setVisibility(0);
        this.hBy.setVisibility(0);
        this.hBl.setVisibility(8);
    }

    public void bIF() {
        this.hBu.setVisibility(8);
        this.hBy.setVisibility(8);
        this.hBl.setVisibility(0);
        l.a(this.hBh.getActivity(), this.hBv);
    }

    public void Y(View.OnClickListener onClickListener) {
        this.hBu.setOnClickListener(onClickListener);
        this.hBy.setOnClickListener(onClickListener);
        this.hBl.setOnClickListener(onClickListener);
    }

    public String bIG() {
        if (this.hBv == null || this.hBv.getText() == null) {
            return null;
        }
        return this.hBv.getText().toString();
    }

    public void bIH() {
        if (this.hBz != null) {
            this.hBz.setText(d.j.tip_url_not_match);
            am.h(this.hBz, d.C0140d.cp_other_b);
        }
    }

    public void Z(View.OnClickListener onClickListener) {
        if (this.hBx != null) {
            this.hBx.setOnClickListener(onClickListener);
        }
    }

    public View bII() {
        return this.hBu;
    }

    public void destroy() {
        if (this.hBk != null) {
            this.hBk.addTextChangedListener(null);
        }
        if (this.hBv != null) {
            this.hBv.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.al(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aq(this.hBh.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.hBh.getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                this.hBh.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.aVY.d(null);
        this.aVY.df(d.j.sending);
        this.aVY.aM(true);
    }

    public void closeLoadingDialog() {
        this.aVY.aM(false);
    }
}
