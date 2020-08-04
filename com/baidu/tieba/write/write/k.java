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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes3.dex */
public class k {
    private TbImageView ajz;
    private View dJs;
    private com.baidu.tbadk.core.view.a eJP;
    private TextView hRI;
    private RelativeLayout kEO;
    private View.OnClickListener mClickListener;
    private WriteUrlActivity mEe;
    private TbImageView mEf;
    private EditText mEg;
    private View mEh;
    private LinearLayout mEi;
    private ImageView mEj;
    private View mEk;
    private TextView mEl;
    private TextView mEm;
    private View mEn;
    private TextView mEo;
    private TextView mEp;
    private LinearLayout mEq;
    private EditText mEr;
    private View mEs;
    private TextView mEt;
    private FrameLayout mEu;
    private TextView mEv;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.dJs = null;
        this.eJP = null;
        if (writeUrlActivity != null) {
            this.mEe = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.mEe.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.mEe.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.dJs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.baR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dJs.getLayoutParams();
                layoutParams.leftMargin = l.getDimens(this.mEe.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.dJs != null && (this.dJs.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dJs.getLayoutParams();
                layoutParams2.width = -2;
                this.dJs.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.hRI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            ao.setViewTextColor(this.hRI, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hRI.getLayoutParams();
            layoutParams3.rightMargin = l.getDimens(this.mEe.getActivity(), R.dimen.ds16);
            this.hRI.setLayoutParams(layoutParams3);
            this.hRI.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.mEf = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.mEf.setDefaultResource(R.drawable.ic_post_url_n);
            this.mEf.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.mEf.setDefaultBgResource(R.color.black_alpha0);
            this.mEi = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.mEi.setOnClickListener(this.mClickListener);
            this.kEO = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.kEO.setOnClickListener(this.mClickListener);
            this.ajz = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.ajz.setDefaultErrorResource(0);
            this.ajz.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.ajz.setDefaultBgResource(R.color.black_alpha0);
            this.mEj = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.mEk = this.mRoot.findViewById(R.id.video_view_delete);
            this.mEk.setOnClickListener(this.mClickListener);
            this.mEl = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.mEm = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.mEn = this.mRoot.findViewById(R.id.view_delete);
            this.mEn.setOnClickListener(this.mClickListener);
            this.mEh = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.mEh.setOnClickListener(this.mClickListener);
            this.mEg = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.mEo = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.mEp = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.mEq = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.mEr = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.mEv = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.mEs = this.mRoot.findViewById(R.id.url_input_clear);
            this.mEt = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.mEt.setEnabled(false);
            this.mEu = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.mEr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.mEs.setVisibility(8);
                        ao.setViewTextColor(k.this.mEt, R.color.cp_cont_e);
                        k.this.mEt.setEnabled(false);
                        return;
                    }
                    k.this.mEs.setVisibility(0);
                    ao.setViewTextColor(k.this.mEt, R.color.cp_link_tip_a);
                    k.this.mEt.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.mEv.getText().equals(k.this.mEe.getActivity().getString(R.string.tip_url_not_match))) {
                        k.this.dxp();
                    }
                }
            });
            this.mEs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.mEr.setText("");
                    k.this.mEs.setVisibility(8);
                    k.this.mEt.setEnabled(false);
                }
            });
            this.eJP = new com.baidu.tbadk.core.view.a(this.mEe.getPageContext());
            dxp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxp() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.mEv.setText(R.string.tip_url_post);
        } else {
            this.mEv.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        ao.setViewTextColor(this.mEv, R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.mEe.setIsLoading(z);
        if (z) {
            this.mEi.setVisibility(0);
            this.kEO.setVisibility(8);
            this.mEf.startLoad(null, 10, false);
            this.mEl.setVisibility(8);
            this.mEm.setVisibility(8);
            this.mEo.setVisibility(8);
            this.mEp.setVisibility(0);
            ao.setViewTextColor(this.mEp, R.color.cp_cont_f);
            this.mEp.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.mEi.setVisibility(8);
            this.kEO.setVisibility(8);
            dxq();
        } else {
            if (aVar.mwi == 1) {
                this.mEi.setVisibility(0);
                this.kEO.setVisibility(8);
                if (aVar.mwh) {
                    this.mEf.startLoad(aVar.mwk, 10, false);
                    this.mEl.setText(aVar.linkTitle);
                    this.mEm.setText(aVar.dPt);
                    if (as.getRealSize(aVar.linkTitle) > 30) {
                        this.mEl.setMaxLines(2);
                        this.mEm.setMaxLines(1);
                    } else {
                        this.mEl.setMaxLines(1);
                        this.mEm.setMaxLines(2);
                    }
                    this.mEl.setVisibility(0);
                    this.mEm.setVisibility(0);
                    this.mEp.setVisibility(8);
                    this.mEo.setVisibility(8);
                } else {
                    this.mEf.reset();
                    this.mEp.setText(aVar.linkUrl);
                    ao.setViewTextColor(this.mEp, R.color.cp_cont_b);
                    this.mEl.setVisibility(8);
                    this.mEm.setVisibility(8);
                    this.mEp.setVisibility(0);
                    this.mEo.setVisibility(0);
                }
            } else if (aVar.mwi == 2) {
                this.mEi.setVisibility(8);
                this.kEO.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.kEO.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(this.mEe.getPageContext().getPageActivity()) - ((int) this.mEe.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.kEO.setLayoutParams(layoutParams);
                ao.setImageResource(this.mEj, R.drawable.icon_play_video);
                ao.setBackgroundResource(this.mEk, R.drawable.btn_delete_url);
                this.ajz.startLoad(aVar.mwn, 10, false);
            } else {
                this.mEi.setVisibility(0);
                this.kEO.setVisibility(8);
                this.mEl.setVisibility(8);
                this.mEm.setVisibility(8);
                this.mEp.setVisibility(0);
                this.mEo.setVisibility(0);
                this.mEf.reset();
                this.mEp.setText(aVar.linkUrl);
                ao.setViewTextColor(this.mEp, R.color.cp_cont_b);
            }
            dxq();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.mEg.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.mEe != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mEe.getPageContext(), i);
            }
            ao.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_d);
            ao.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
            this.mEg.setHintTextColor(ao.getColor(R.color.cp_cont_e));
            this.mEg.setTextColor(ao.getColor(R.color.cp_cont_f));
            ao.setBackgroundColor(this.mEi, R.color.cp_bg_line_e);
            ao.setViewTextColor(this.mEl, R.color.cp_cont_b);
            ao.setViewTextColor(this.mEm, R.color.cp_cont_d);
            ao.setViewTextColor(this.mEp, R.color.cp_cont_b);
            ao.setBackgroundColor(this.mEo, R.color.cp_bg_line_d);
            ao.setViewTextColor(this.mEo, R.color.cp_cont_d);
            ao.setBackgroundResource(this.mEh, R.drawable.bg_link_invoke);
            ao.setBackgroundColor(this.mEq, R.color.cp_bg_line_d);
            this.mEr.setHintTextColor(ao.getColor(R.color.cp_cont_e));
            ao.setViewTextColor(this.mEr, R.color.cp_cont_b);
            ao.setViewTextColor(this.mEv, R.color.cp_cont_d);
            ao.setViewTextColor(this.mEt, R.color.cp_cont_e);
            ao.setImageResource(this.mEj, R.drawable.home_ic_video);
            ao.setBackgroundResource(this.mEn, R.drawable.btn_delete_url);
            ao.setBackgroundResource(this.mEs, R.drawable.btn_delete_url);
            ao.setBackgroundResource(this.mEk, R.drawable.btn_delete_url);
            dxq();
        }
    }

    public void dxq() {
        boolean z;
        if (StringUtils.isNull(dxr())) {
            z = this.mEi.getVisibility() == 0 || this.kEO.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            ao.setNavbarTitleColor(this.hRI, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.hRI.setEnabled(true);
            return;
        }
        ao.setViewTextColor(this.hRI, R.color.cp_cont_d, 1);
        this.hRI.setEnabled(false);
    }

    public String dxr() {
        if (this.mEg == null || this.mEg.getText() == null) {
            return null;
        }
        return this.mEg.getText().toString();
    }

    public View cxk() {
        return this.dJs;
    }

    public View dxs() {
        return this.hRI;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText dxt() {
        return this.mEg;
    }

    public View dxu() {
        return this.mEn;
    }

    public View dxv() {
        return this.mEk;
    }

    public View dxw() {
        return this.mEi;
    }

    public View getVideoContainer() {
        return this.kEO;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.mEr.setText(aVar.linkUrl);
            this.mEr.setSelection(aVar.linkUrl.length());
        }
        this.mEr.requestFocus();
        l.showSoftKeyPad(this.mEe.getActivity(), this.mEr);
        this.mEq.setVisibility(0);
        this.mEu.setVisibility(0);
        this.mEh.setVisibility(8);
    }

    public void dxx() {
        this.mEq.setVisibility(8);
        this.mEu.setVisibility(8);
        this.mEh.setVisibility(0);
        l.hideSoftKeyPad(this.mEe.getActivity(), this.mEr);
    }

    public void al(View.OnClickListener onClickListener) {
        this.mEq.setOnClickListener(onClickListener);
        this.mEu.setOnClickListener(onClickListener);
        this.mEh.setOnClickListener(onClickListener);
    }

    public String dxy() {
        if (this.mEr == null || this.mEr.getText() == null) {
            return null;
        }
        return this.mEr.getText().toString();
    }

    public void dxz() {
        if (this.mEv != null) {
            this.mEv.setText(R.string.tip_url_not_match);
            ao.setViewTextColor(this.mEv, R.color.cp_other_b);
        }
    }

    public void am(View.OnClickListener onClickListener) {
        if (this.mEt != null) {
            this.mEt.setOnClickListener(onClickListener);
        }
    }

    public View dxA() {
        return this.mEq;
    }

    public void destroy() {
        if (this.mEg != null) {
            this.mEg.addTextChangedListener(null);
        }
        if (this.mEr != null) {
            this.mEr.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.bB(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aW(this.mEe.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.mEe.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.mEe.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.eJP.setCancelListener(null);
        this.eJP.setTipString(R.string.sending);
        this.eJP.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.eJP.setDialogVisiable(false);
    }
}
