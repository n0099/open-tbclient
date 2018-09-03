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
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes3.dex */
public class k {
    private com.baidu.tbadk.core.view.a aVY;
    private View aaW;
    private View eMK;
    private TbImageView eRe;
    private RelativeLayout fMO;
    private FrameLayout hBA;
    private TextView hBB;
    private WriteUrlActivity hBj;
    private TextView hBk;
    private TbImageView hBl;
    private EditText hBm;
    private View hBn;
    private LinearLayout hBo;
    private ImageView hBp;
    private View hBq;
    private TextView hBr;
    private TextView hBs;
    private View hBt;
    private TextView hBu;
    private TextView hBv;
    private LinearLayout hBw;
    private EditText hBx;
    private View hBy;
    private TextView hBz;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.eMK = null;
        this.aVY = null;
        if (writeUrlActivity != null) {
            this.hBj = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.aaW = LayoutInflater.from(this.hBj.getPageContext().getPageActivity()).inflate(f.h.write_url_activity_layout, (ViewGroup) null);
            this.hBj.setContentView(this.aaW);
            this.mNavigationBar = (NavigationBar) this.aaW.findViewById(f.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.eMK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(f.C0146f.write_close_selector, f.C0146f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eMK.getLayoutParams();
                layoutParams.leftMargin = l.f(this.hBj.getActivity(), f.e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.eMK != null && (this.eMK.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eMK.getLayoutParams();
                layoutParams2.width = -2;
                this.eMK.setLayoutParams(layoutParams2);
            }
            this.aaW.setOnClickListener(this.mClickListener);
            this.hBk = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(f.j.send_post));
            am.c(this.hBk, f.d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hBk.getLayoutParams();
            layoutParams3.rightMargin = l.f(this.hBj.getActivity(), f.e.ds16);
            this.hBk.setLayoutParams(layoutParams3);
            this.hBk.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(f.j.post_new_thread));
            this.hBl = (TbImageView) this.aaW.findViewById(f.g.imageview_picture);
            this.hBl.setDefaultResource(f.C0146f.ic_post_url_n);
            this.hBl.setDefaultErrorResource(f.C0146f.ic_post_url_n);
            this.hBl.setDefaultBgResource(f.d.black_alpha0);
            this.hBo = (LinearLayout) this.aaW.findViewById(f.g.view_picture_publish);
            this.hBo.setOnClickListener(this.mClickListener);
            this.fMO = (RelativeLayout) this.aaW.findViewById(f.g.video_container);
            this.fMO.setOnClickListener(this.mClickListener);
            this.eRe = (TbImageView) this.aaW.findViewById(f.g.video_img_thumbnail);
            this.eRe.setDefaultErrorResource(0);
            this.eRe.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
            this.eRe.setDefaultBgResource(f.d.black_alpha0);
            this.hBp = (ImageView) this.aaW.findViewById(f.g.video_img_play);
            this.hBq = this.aaW.findViewById(f.g.video_view_delete);
            this.hBq.setOnClickListener(this.mClickListener);
            this.hBr = (TextView) this.aaW.findViewById(f.g.textview_title);
            this.hBs = (TextView) this.aaW.findViewById(f.g.textview_abstract);
            this.hBt = this.aaW.findViewById(f.g.view_delete);
            this.hBt.setOnClickListener(this.mClickListener);
            this.hBn = this.aaW.findViewById(f.g.icon_invoke_link);
            this.hBn.setOnClickListener(this.mClickListener);
            this.hBm = (EditText) this.aaW.findViewById(f.g.post_content);
            this.hBu = (TextView) this.aaW.findViewById(f.g.textview_error_tip);
            this.hBv = (TextView) this.aaW.findViewById(f.g.textview_url);
            this.hBw = (LinearLayout) this.aaW.findViewById(f.g.url_edit_container);
            this.hBx = (EditText) this.aaW.findViewById(f.g.url_input);
            this.hBB = (TextView) this.aaW.findViewById(f.g.url_desc);
            this.hBy = this.aaW.findViewById(f.g.url_input_clear);
            this.hBz = (TextView) this.aaW.findViewById(f.g.url_add);
            this.hBz.setEnabled(false);
            this.hBA = (FrameLayout) this.aaW.findViewById(f.g.url_edit_back_view);
            this.hBx.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.hBy.setVisibility(8);
                        am.h(k.this.hBz, f.d.cp_cont_e);
                        k.this.hBz.setEnabled(false);
                        return;
                    }
                    k.this.hBy.setVisibility(0);
                    am.h(k.this.hBz, f.d.cp_link_tip_a);
                    k.this.hBz.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.hBB.getText().equals(k.this.hBj.getActivity().getString(f.j.tip_url_not_match))) {
                        k.this.bIB();
                    }
                }
            });
            this.hBy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.hBx.setText("");
                    k.this.hBy.setVisibility(8);
                    k.this.hBz.setEnabled(false);
                }
            });
            this.aVY = new com.baidu.tbadk.core.view.a(this.hBj.getPageContext());
            bIB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIB() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.hBB.setText(f.j.tip_url_post);
        } else {
            this.hBB.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        am.h(this.hBB, f.d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.hBj.setIsLoading(z);
        if (z) {
            this.hBo.setVisibility(0);
            this.fMO.setVisibility(8);
            this.hBl.startLoad(null, 10, false);
            this.hBr.setVisibility(8);
            this.hBs.setVisibility(8);
            this.hBu.setVisibility(8);
            this.hBv.setVisibility(0);
            am.h(this.hBv, f.d.cp_cont_f);
            this.hBv.setText(f.j.tip_url_loading);
        } else if (aVar == null) {
            this.hBo.setVisibility(8);
            this.fMO.setVisibility(8);
            bIC();
        } else {
            if (aVar.hvq == 1) {
                this.hBo.setVisibility(0);
                this.fMO.setVisibility(8);
                if (aVar.hvp) {
                    this.hBl.startLoad(aVar.hvs, 10, false);
                    this.hBr.setText(aVar.agg);
                    this.hBs.setText(aVar.agh);
                    if (ap.eK(aVar.agg) > 30) {
                        this.hBr.setMaxLines(2);
                        this.hBs.setMaxLines(1);
                    } else {
                        this.hBr.setMaxLines(1);
                        this.hBs.setMaxLines(2);
                    }
                    this.hBr.setVisibility(0);
                    this.hBs.setVisibility(0);
                    this.hBv.setVisibility(8);
                    this.hBu.setVisibility(8);
                } else {
                    this.hBl.reset();
                    this.hBv.setText(aVar.linkUrl);
                    am.h(this.hBv, f.d.cp_cont_b);
                    this.hBr.setVisibility(8);
                    this.hBs.setVisibility(8);
                    this.hBv.setVisibility(0);
                    this.hBu.setVisibility(0);
                }
            } else if (aVar.hvq == 2) {
                this.hBo.setVisibility(8);
                this.fMO.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.fMO.getLayoutParams();
                layoutParams.height = ((l.ah(this.hBj.getPageContext().getPageActivity()) - ((int) this.hBj.getPageContext().getPageActivity().getResources().getDimension(f.e.ds80))) * 9) / 16;
                this.fMO.setLayoutParams(layoutParams);
                am.c(this.hBp, f.C0146f.icon_play_video);
                am.i(this.hBq, f.C0146f.btn_delete_url);
                this.eRe.startLoad(aVar.hvv, 10, false);
            } else {
                this.hBo.setVisibility(0);
                this.fMO.setVisibility(8);
                this.hBr.setVisibility(8);
                this.hBs.setVisibility(8);
                this.hBv.setVisibility(0);
                this.hBu.setVisibility(0);
                this.hBl.reset();
                this.hBv.setText(aVar.linkUrl);
                am.h(this.hBv, f.d.cp_cont_b);
            }
            bIC();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.hBm.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.hBj != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hBj.getPageContext(), i);
            }
            am.j(this.mNavigationBar, f.d.cp_bg_line_d);
            am.j(this.aaW, f.d.cp_bg_line_d);
            this.hBm.setHintTextColor(am.getColor(f.d.cp_cont_e));
            this.hBm.setTextColor(am.getColor(f.d.cp_cont_f));
            am.j(this.hBo, f.d.cp_bg_line_e);
            am.h(this.hBr, f.d.cp_cont_b);
            am.h(this.hBs, f.d.cp_cont_d);
            am.h(this.hBv, f.d.cp_cont_b);
            am.j(this.hBu, f.d.cp_bg_line_d);
            am.h(this.hBu, f.d.cp_cont_d);
            am.i(this.hBn, f.C0146f.bg_link_invoke);
            am.j(this.hBw, f.d.cp_bg_line_d);
            this.hBx.setHintTextColor(am.getColor(f.d.cp_cont_e));
            am.h(this.hBx, f.d.cp_cont_b);
            am.h(this.hBB, f.d.cp_cont_d);
            am.h(this.hBz, f.d.cp_cont_e);
            am.c(this.hBp, f.C0146f.home_ic_video);
            am.i(this.hBt, f.C0146f.btn_delete_url);
            am.i(this.hBy, f.C0146f.btn_delete_url);
            am.i(this.hBq, f.C0146f.btn_delete_url);
            bIC();
        }
    }

    public void bIC() {
        boolean z;
        if (StringUtils.isNull(bID())) {
            z = this.hBo.getVisibility() == 0 || this.fMO.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            am.b(this.hBk, f.d.cp_link_tip_a, f.d.s_navbar_title_color);
            this.hBk.setEnabled(true);
            return;
        }
        am.c(this.hBk, f.d.cp_cont_d, 1);
        this.hBk.setEnabled(false);
    }

    public String bID() {
        if (this.hBm == null || this.hBm.getText() == null) {
            return null;
        }
        return this.hBm.getText().toString();
    }

    public View aNk() {
        return this.eMK;
    }

    public View bIE() {
        return this.hBk;
    }

    public View getRootView() {
        return this.aaW;
    }

    public EditText bIF() {
        return this.hBm;
    }

    public View bIG() {
        return this.hBt;
    }

    public View bIH() {
        return this.hBq;
    }

    public View bII() {
        return this.hBo;
    }

    public View getVideoContainer() {
        return this.fMO;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.hBx.setText(aVar.linkUrl);
            this.hBx.setSelection(aVar.linkUrl.length());
        }
        this.hBx.requestFocus();
        l.b(this.hBj.getActivity(), this.hBx);
        this.hBw.setVisibility(0);
        this.hBA.setVisibility(0);
        this.hBn.setVisibility(8);
    }

    public void bIJ() {
        this.hBw.setVisibility(8);
        this.hBA.setVisibility(8);
        this.hBn.setVisibility(0);
        l.a(this.hBj.getActivity(), this.hBx);
    }

    public void Y(View.OnClickListener onClickListener) {
        this.hBw.setOnClickListener(onClickListener);
        this.hBA.setOnClickListener(onClickListener);
        this.hBn.setOnClickListener(onClickListener);
    }

    public String bIK() {
        if (this.hBx == null || this.hBx.getText() == null) {
            return null;
        }
        return this.hBx.getText().toString();
    }

    public void bIL() {
        if (this.hBB != null) {
            this.hBB.setText(f.j.tip_url_not_match);
            am.h(this.hBB, f.d.cp_other_b);
        }
    }

    public void Z(View.OnClickListener onClickListener) {
        if (this.hBz != null) {
            this.hBz.setOnClickListener(onClickListener);
        }
    }

    public View bIM() {
        return this.hBw;
    }

    public void destroy() {
        if (this.hBm != null) {
            this.hBm.addTextChangedListener(null);
        }
        if (this.hBx != null) {
            this.hBx.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.al(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aq(this.hBj.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.hBj.getPageContext().getPageActivity().getString(f.j.sand_fail);
                }
                this.hBj.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.aVY.d(null);
        this.aVY.df(f.j.sending);
        this.aVY.aN(true);
    }

    public void closeLoadingDialog() {
        this.aVY.aN(false);
    }
}
