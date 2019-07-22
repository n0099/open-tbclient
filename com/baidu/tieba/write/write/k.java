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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes3.dex */
public class k {
    private View bCe;
    private com.baidu.tbadk.core.view.b cCo;
    private TbImageView hfH;
    private RelativeLayout icC;
    private WriteUrlActivity jUZ;
    private TextView jVa;
    private TbImageView jVb;
    private EditText jVc;
    private View jVd;
    private LinearLayout jVe;
    private ImageView jVf;
    private View jVg;
    private TextView jVh;
    private TextView jVi;
    private View jVj;
    private TextView jVk;
    private TextView jVl;
    private LinearLayout jVm;
    private EditText jVn;
    private View jVo;
    private TextView jVp;
    private FrameLayout jVq;
    private TextView jVr;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.bCe = null;
        this.cCo = null;
        if (writeUrlActivity != null) {
            this.jUZ = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.jUZ.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.jUZ.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.bCe = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.write_close_selector, R.drawable.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bCe.getLayoutParams();
                layoutParams.leftMargin = l.g(this.jUZ.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.bCe != null && (this.bCe.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bCe.getLayoutParams();
                layoutParams2.width = -2;
                this.bCe.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.jVa = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            am.f(this.jVa, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.jVa.getLayoutParams();
            layoutParams3.rightMargin = l.g(this.jUZ.getActivity(), R.dimen.ds16);
            this.jVa.setLayoutParams(layoutParams3);
            this.jVa.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.jVb = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.jVb.setDefaultResource(R.drawable.ic_post_url_n);
            this.jVb.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.jVb.setDefaultBgResource(R.color.black_alpha0);
            this.jVe = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.jVe.setOnClickListener(this.mClickListener);
            this.icC = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.icC.setOnClickListener(this.mClickListener);
            this.hfH = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.hfH.setDefaultErrorResource(0);
            this.hfH.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.hfH.setDefaultBgResource(R.color.black_alpha0);
            this.jVf = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.jVg = this.mRoot.findViewById(R.id.video_view_delete);
            this.jVg.setOnClickListener(this.mClickListener);
            this.jVh = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.jVi = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.jVj = this.mRoot.findViewById(R.id.view_delete);
            this.jVj.setOnClickListener(this.mClickListener);
            this.jVd = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.jVd.setOnClickListener(this.mClickListener);
            this.jVc = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.jVk = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.jVl = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.jVm = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.jVn = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.jVr = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.jVo = this.mRoot.findViewById(R.id.url_input_clear);
            this.jVp = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.jVp.setEnabled(false);
            this.jVq = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.jVn.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.jVo.setVisibility(8);
                        am.j(k.this.jVp, R.color.cp_cont_e);
                        k.this.jVp.setEnabled(false);
                        return;
                    }
                    k.this.jVo.setVisibility(0);
                    am.j(k.this.jVp, R.color.cp_link_tip_a);
                    k.this.jVp.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.jVr.getText().equals(k.this.jUZ.getActivity().getString(R.string.tip_url_not_match))) {
                        k.this.cCG();
                    }
                }
            });
            this.jVo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.jVn.setText("");
                    k.this.jVo.setVisibility(8);
                    k.this.jVp.setEnabled(false);
                }
            });
            this.cCo = new com.baidu.tbadk.core.view.b(this.jUZ.getPageContext());
            cCG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCG() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.jVr.setText(R.string.tip_url_post);
        } else {
            this.jVr.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        am.j(this.jVr, R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.jUZ.setIsLoading(z);
        if (z) {
            this.jVe.setVisibility(0);
            this.icC.setVisibility(8);
            this.jVb.startLoad(null, 10, false);
            this.jVh.setVisibility(8);
            this.jVi.setVisibility(8);
            this.jVk.setVisibility(8);
            this.jVl.setVisibility(0);
            am.j(this.jVl, R.color.cp_cont_f);
            this.jVl.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.jVe.setVisibility(8);
            this.icC.setVisibility(8);
            cCH();
        } else {
            if (aVar.jOw == 1) {
                this.jVe.setVisibility(0);
                this.icC.setVisibility(8);
                if (aVar.jOv) {
                    this.jVb.startLoad(aVar.jOy, 10, false);
                    this.jVh.setText(aVar.bHy);
                    this.jVi.setText(aVar.bHz);
                    if (aq.oc(aVar.bHy) > 30) {
                        this.jVh.setMaxLines(2);
                        this.jVi.setMaxLines(1);
                    } else {
                        this.jVh.setMaxLines(1);
                        this.jVi.setMaxLines(2);
                    }
                    this.jVh.setVisibility(0);
                    this.jVi.setVisibility(0);
                    this.jVl.setVisibility(8);
                    this.jVk.setVisibility(8);
                } else {
                    this.jVb.reset();
                    this.jVl.setText(aVar.linkUrl);
                    am.j(this.jVl, R.color.cp_cont_b);
                    this.jVh.setVisibility(8);
                    this.jVi.setVisibility(8);
                    this.jVl.setVisibility(0);
                    this.jVk.setVisibility(0);
                }
            } else if (aVar.jOw == 2) {
                this.jVe.setVisibility(8);
                this.icC.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.icC.getLayoutParams();
                layoutParams.height = ((l.af(this.jUZ.getPageContext().getPageActivity()) - ((int) this.jUZ.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.icC.setLayoutParams(layoutParams);
                am.c(this.jVf, (int) R.drawable.icon_play_video);
                am.k(this.jVg, R.drawable.btn_delete_url);
                this.hfH.startLoad(aVar.jOB, 10, false);
            } else {
                this.jVe.setVisibility(0);
                this.icC.setVisibility(8);
                this.jVh.setVisibility(8);
                this.jVi.setVisibility(8);
                this.jVl.setVisibility(0);
                this.jVk.setVisibility(0);
                this.jVb.reset();
                this.jVl.setText(aVar.linkUrl);
                am.j(this.jVl, R.color.cp_cont_b);
            }
            cCH();
        }
    }

    public void g(TextWatcher textWatcher) {
        this.jVc.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.jUZ != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.jUZ.getPageContext(), i);
            }
            am.l(this.mNavigationBar, R.color.cp_bg_line_d);
            am.l(this.mRoot, R.color.cp_bg_line_d);
            this.jVc.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.jVc.setTextColor(am.getColor(R.color.cp_cont_f));
            am.l(this.jVe, R.color.cp_bg_line_e);
            am.j(this.jVh, R.color.cp_cont_b);
            am.j(this.jVi, R.color.cp_cont_d);
            am.j(this.jVl, R.color.cp_cont_b);
            am.l(this.jVk, R.color.cp_bg_line_d);
            am.j(this.jVk, R.color.cp_cont_d);
            am.k(this.jVd, R.drawable.bg_link_invoke);
            am.l(this.jVm, R.color.cp_bg_line_d);
            this.jVn.setHintTextColor(am.getColor(R.color.cp_cont_e));
            am.j(this.jVn, R.color.cp_cont_b);
            am.j(this.jVr, R.color.cp_cont_d);
            am.j(this.jVp, R.color.cp_cont_e);
            am.c(this.jVf, (int) R.drawable.home_ic_video);
            am.k(this.jVj, R.drawable.btn_delete_url);
            am.k(this.jVo, R.drawable.btn_delete_url);
            am.k(this.jVg, R.drawable.btn_delete_url);
            cCH();
        }
    }

    public void cCH() {
        boolean z;
        if (StringUtils.isNull(cCI())) {
            z = this.jVe.getVisibility() == 0 || this.icC.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            am.e(this.jVa, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.jVa.setEnabled(true);
            return;
        }
        am.f(this.jVa, R.color.cp_cont_d, 1);
        this.jVa.setEnabled(false);
    }

    public String cCI() {
        if (this.jVc == null || this.jVc.getText() == null) {
            return null;
        }
        return this.jVc.getText().toString();
    }

    public View bGk() {
        return this.bCe;
    }

    public View cCJ() {
        return this.jVa;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText cCK() {
        return this.jVc;
    }

    public View cCL() {
        return this.jVj;
    }

    public View cCM() {
        return this.jVg;
    }

    public View cCN() {
        return this.jVe;
    }

    public View getVideoContainer() {
        return this.icC;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.jVn.setText(aVar.linkUrl);
            this.jVn.setSelection(aVar.linkUrl.length());
        }
        this.jVn.requestFocus();
        l.c(this.jUZ.getActivity(), this.jVn);
        this.jVm.setVisibility(0);
        this.jVq.setVisibility(0);
        this.jVd.setVisibility(8);
    }

    public void cCO() {
        this.jVm.setVisibility(8);
        this.jVq.setVisibility(8);
        this.jVd.setVisibility(0);
        l.b(this.jUZ.getActivity(), this.jVn);
    }

    public void ae(View.OnClickListener onClickListener) {
        this.jVm.setOnClickListener(onClickListener);
        this.jVq.setOnClickListener(onClickListener);
        this.jVd.setOnClickListener(onClickListener);
    }

    public String cCP() {
        if (this.jVn == null || this.jVn.getText() == null) {
            return null;
        }
        return this.jVn.getText().toString();
    }

    public void cCQ() {
        if (this.jVr != null) {
            this.jVr.setText(R.string.tip_url_not_match);
            am.j(this.jVr, R.color.cp_other_b);
        }
    }

    public void af(View.OnClickListener onClickListener) {
        if (this.jVp != null) {
            this.jVp.setOnClickListener(onClickListener);
        }
    }

    public View cCR() {
        return this.jVm;
    }

    public void destroy() {
        if (this.jVc != null) {
            this.jVc.addTextChangedListener(null);
        }
        if (this.jVn != null) {
            this.jVn.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aJ(this.jUZ.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.jUZ.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.jUZ.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.cCo.e(null);
        this.cCo.iz(R.string.sending);
        this.cCo.ej(true);
    }

    public void closeLoadingDialog() {
        this.cCo.ej(false);
    }
}
