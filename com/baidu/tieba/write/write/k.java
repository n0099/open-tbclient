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
    private TextView hRG;
    private RelativeLayout kEM;
    private View.OnClickListener mClickListener;
    private WriteUrlActivity mEc;
    private TbImageView mEd;
    private EditText mEe;
    private View mEf;
    private LinearLayout mEg;
    private ImageView mEh;
    private View mEi;
    private TextView mEj;
    private TextView mEk;
    private View mEl;
    private TextView mEm;
    private TextView mEn;
    private LinearLayout mEo;
    private EditText mEp;
    private View mEq;
    private TextView mEr;
    private FrameLayout mEs;
    private TextView mEt;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.dJs = null;
        this.eJP = null;
        if (writeUrlActivity != null) {
            this.mEc = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.mEc.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.mEc.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.dJs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.baR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dJs.getLayoutParams();
                layoutParams.leftMargin = l.getDimens(this.mEc.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.dJs != null && (this.dJs.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dJs.getLayoutParams();
                layoutParams2.width = -2;
                this.dJs.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.hRG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            ao.setViewTextColor(this.hRG, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hRG.getLayoutParams();
            layoutParams3.rightMargin = l.getDimens(this.mEc.getActivity(), R.dimen.ds16);
            this.hRG.setLayoutParams(layoutParams3);
            this.hRG.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.mEd = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.mEd.setDefaultResource(R.drawable.ic_post_url_n);
            this.mEd.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.mEd.setDefaultBgResource(R.color.black_alpha0);
            this.mEg = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.mEg.setOnClickListener(this.mClickListener);
            this.kEM = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.kEM.setOnClickListener(this.mClickListener);
            this.ajz = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.ajz.setDefaultErrorResource(0);
            this.ajz.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.ajz.setDefaultBgResource(R.color.black_alpha0);
            this.mEh = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.mEi = this.mRoot.findViewById(R.id.video_view_delete);
            this.mEi.setOnClickListener(this.mClickListener);
            this.mEj = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.mEk = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.mEl = this.mRoot.findViewById(R.id.view_delete);
            this.mEl.setOnClickListener(this.mClickListener);
            this.mEf = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.mEf.setOnClickListener(this.mClickListener);
            this.mEe = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.mEm = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.mEn = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.mEo = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.mEp = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.mEt = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.mEq = this.mRoot.findViewById(R.id.url_input_clear);
            this.mEr = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.mEr.setEnabled(false);
            this.mEs = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.mEp.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.mEq.setVisibility(8);
                        ao.setViewTextColor(k.this.mEr, R.color.cp_cont_e);
                        k.this.mEr.setEnabled(false);
                        return;
                    }
                    k.this.mEq.setVisibility(0);
                    ao.setViewTextColor(k.this.mEr, R.color.cp_link_tip_a);
                    k.this.mEr.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.mEt.getText().equals(k.this.mEc.getActivity().getString(R.string.tip_url_not_match))) {
                        k.this.dxo();
                    }
                }
            });
            this.mEq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.mEp.setText("");
                    k.this.mEq.setVisibility(8);
                    k.this.mEr.setEnabled(false);
                }
            });
            this.eJP = new com.baidu.tbadk.core.view.a(this.mEc.getPageContext());
            dxo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxo() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.mEt.setText(R.string.tip_url_post);
        } else {
            this.mEt.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        ao.setViewTextColor(this.mEt, R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.mEc.setIsLoading(z);
        if (z) {
            this.mEg.setVisibility(0);
            this.kEM.setVisibility(8);
            this.mEd.startLoad(null, 10, false);
            this.mEj.setVisibility(8);
            this.mEk.setVisibility(8);
            this.mEm.setVisibility(8);
            this.mEn.setVisibility(0);
            ao.setViewTextColor(this.mEn, R.color.cp_cont_f);
            this.mEn.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.mEg.setVisibility(8);
            this.kEM.setVisibility(8);
            dxp();
        } else {
            if (aVar.mwg == 1) {
                this.mEg.setVisibility(0);
                this.kEM.setVisibility(8);
                if (aVar.mwf) {
                    this.mEd.startLoad(aVar.mwi, 10, false);
                    this.mEj.setText(aVar.linkTitle);
                    this.mEk.setText(aVar.dPt);
                    if (as.getRealSize(aVar.linkTitle) > 30) {
                        this.mEj.setMaxLines(2);
                        this.mEk.setMaxLines(1);
                    } else {
                        this.mEj.setMaxLines(1);
                        this.mEk.setMaxLines(2);
                    }
                    this.mEj.setVisibility(0);
                    this.mEk.setVisibility(0);
                    this.mEn.setVisibility(8);
                    this.mEm.setVisibility(8);
                } else {
                    this.mEd.reset();
                    this.mEn.setText(aVar.linkUrl);
                    ao.setViewTextColor(this.mEn, R.color.cp_cont_b);
                    this.mEj.setVisibility(8);
                    this.mEk.setVisibility(8);
                    this.mEn.setVisibility(0);
                    this.mEm.setVisibility(0);
                }
            } else if (aVar.mwg == 2) {
                this.mEg.setVisibility(8);
                this.kEM.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.kEM.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(this.mEc.getPageContext().getPageActivity()) - ((int) this.mEc.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.kEM.setLayoutParams(layoutParams);
                ao.setImageResource(this.mEh, R.drawable.icon_play_video);
                ao.setBackgroundResource(this.mEi, R.drawable.btn_delete_url);
                this.ajz.startLoad(aVar.mwl, 10, false);
            } else {
                this.mEg.setVisibility(0);
                this.kEM.setVisibility(8);
                this.mEj.setVisibility(8);
                this.mEk.setVisibility(8);
                this.mEn.setVisibility(0);
                this.mEm.setVisibility(0);
                this.mEd.reset();
                this.mEn.setText(aVar.linkUrl);
                ao.setViewTextColor(this.mEn, R.color.cp_cont_b);
            }
            dxp();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.mEe.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.mEc != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mEc.getPageContext(), i);
            }
            ao.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_d);
            ao.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
            this.mEe.setHintTextColor(ao.getColor(R.color.cp_cont_e));
            this.mEe.setTextColor(ao.getColor(R.color.cp_cont_f));
            ao.setBackgroundColor(this.mEg, R.color.cp_bg_line_e);
            ao.setViewTextColor(this.mEj, R.color.cp_cont_b);
            ao.setViewTextColor(this.mEk, R.color.cp_cont_d);
            ao.setViewTextColor(this.mEn, R.color.cp_cont_b);
            ao.setBackgroundColor(this.mEm, R.color.cp_bg_line_d);
            ao.setViewTextColor(this.mEm, R.color.cp_cont_d);
            ao.setBackgroundResource(this.mEf, R.drawable.bg_link_invoke);
            ao.setBackgroundColor(this.mEo, R.color.cp_bg_line_d);
            this.mEp.setHintTextColor(ao.getColor(R.color.cp_cont_e));
            ao.setViewTextColor(this.mEp, R.color.cp_cont_b);
            ao.setViewTextColor(this.mEt, R.color.cp_cont_d);
            ao.setViewTextColor(this.mEr, R.color.cp_cont_e);
            ao.setImageResource(this.mEh, R.drawable.home_ic_video);
            ao.setBackgroundResource(this.mEl, R.drawable.btn_delete_url);
            ao.setBackgroundResource(this.mEq, R.drawable.btn_delete_url);
            ao.setBackgroundResource(this.mEi, R.drawable.btn_delete_url);
            dxp();
        }
    }

    public void dxp() {
        boolean z;
        if (StringUtils.isNull(dxq())) {
            z = this.mEg.getVisibility() == 0 || this.kEM.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            ao.setNavbarTitleColor(this.hRG, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.hRG.setEnabled(true);
            return;
        }
        ao.setViewTextColor(this.hRG, R.color.cp_cont_d, 1);
        this.hRG.setEnabled(false);
    }

    public String dxq() {
        if (this.mEe == null || this.mEe.getText() == null) {
            return null;
        }
        return this.mEe.getText().toString();
    }

    public View cxk() {
        return this.dJs;
    }

    public View dxr() {
        return this.hRG;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText dxs() {
        return this.mEe;
    }

    public View dxt() {
        return this.mEl;
    }

    public View dxu() {
        return this.mEi;
    }

    public View dxv() {
        return this.mEg;
    }

    public View getVideoContainer() {
        return this.kEM;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.mEp.setText(aVar.linkUrl);
            this.mEp.setSelection(aVar.linkUrl.length());
        }
        this.mEp.requestFocus();
        l.showSoftKeyPad(this.mEc.getActivity(), this.mEp);
        this.mEo.setVisibility(0);
        this.mEs.setVisibility(0);
        this.mEf.setVisibility(8);
    }

    public void dxw() {
        this.mEo.setVisibility(8);
        this.mEs.setVisibility(8);
        this.mEf.setVisibility(0);
        l.hideSoftKeyPad(this.mEc.getActivity(), this.mEp);
    }

    public void al(View.OnClickListener onClickListener) {
        this.mEo.setOnClickListener(onClickListener);
        this.mEs.setOnClickListener(onClickListener);
        this.mEf.setOnClickListener(onClickListener);
    }

    public String dxx() {
        if (this.mEp == null || this.mEp.getText() == null) {
            return null;
        }
        return this.mEp.getText().toString();
    }

    public void dxy() {
        if (this.mEt != null) {
            this.mEt.setText(R.string.tip_url_not_match);
            ao.setViewTextColor(this.mEt, R.color.cp_other_b);
        }
    }

    public void am(View.OnClickListener onClickListener) {
        if (this.mEr != null) {
            this.mEr.setOnClickListener(onClickListener);
        }
    }

    public View dxz() {
        return this.mEo;
    }

    public void destroy() {
        if (this.mEe != null) {
            this.mEe.addTextChangedListener(null);
        }
        if (this.mEp != null) {
            this.mEp.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.bB(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aW(this.mEc.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.mEc.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.mEc.showToast(errorString);
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
