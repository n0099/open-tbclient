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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class k {
    private TbImageView ajE;
    private View dDv;
    private com.baidu.tbadk.core.view.a eDA;
    private TextView hLH;
    private RelativeLayout kvT;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private WriteUrlActivity mvY;
    private TbImageView mvZ;
    private EditText mwa;
    private View mwb;
    private LinearLayout mwc;
    private ImageView mwd;
    private View mwe;
    private TextView mwf;
    private TextView mwg;
    private View mwh;
    private TextView mwi;
    private TextView mwj;
    private LinearLayout mwk;
    private EditText mwl;
    private View mwm;
    private TextView mwn;
    private FrameLayout mwo;
    private TextView mwp;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.dDv = null;
        this.eDA = null;
        if (writeUrlActivity != null) {
            this.mvY = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.mvY.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.mvY.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.dDv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.aWQ().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dDv.getLayoutParams();
                layoutParams.leftMargin = l.getDimens(this.mvY.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.dDv != null && (this.dDv.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dDv.getLayoutParams();
                layoutParams2.width = -2;
                this.dDv.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.hLH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            an.setViewTextColor(this.hLH, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hLH.getLayoutParams();
            layoutParams3.rightMargin = l.getDimens(this.mvY.getActivity(), R.dimen.ds16);
            this.hLH.setLayoutParams(layoutParams3);
            this.hLH.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.mvZ = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.mvZ.setDefaultResource(R.drawable.ic_post_url_n);
            this.mvZ.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.mvZ.setDefaultBgResource(R.color.black_alpha0);
            this.mwc = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.mwc.setOnClickListener(this.mClickListener);
            this.kvT = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.kvT.setOnClickListener(this.mClickListener);
            this.ajE = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.ajE.setDefaultErrorResource(0);
            this.ajE.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.ajE.setDefaultBgResource(R.color.black_alpha0);
            this.mwd = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.mwe = this.mRoot.findViewById(R.id.video_view_delete);
            this.mwe.setOnClickListener(this.mClickListener);
            this.mwf = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.mwg = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.mwh = this.mRoot.findViewById(R.id.view_delete);
            this.mwh.setOnClickListener(this.mClickListener);
            this.mwb = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.mwb.setOnClickListener(this.mClickListener);
            this.mwa = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.mwi = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.mwj = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.mwk = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.mwl = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.mwp = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.mwm = this.mRoot.findViewById(R.id.url_input_clear);
            this.mwn = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.mwn.setEnabled(false);
            this.mwo = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.mwl.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.mwm.setVisibility(8);
                        an.setViewTextColor(k.this.mwn, (int) R.color.cp_cont_e);
                        k.this.mwn.setEnabled(false);
                        return;
                    }
                    k.this.mwm.setVisibility(0);
                    an.setViewTextColor(k.this.mwn, (int) R.color.cp_link_tip_a);
                    k.this.mwn.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.mwp.getText().equals(k.this.mvY.getActivity().getString(R.string.tip_url_not_match))) {
                        k.this.duc();
                    }
                }
            });
            this.mwm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.mwl.setText("");
                    k.this.mwm.setVisibility(8);
                    k.this.mwn.setEnabled(false);
                }
            });
            this.eDA = new com.baidu.tbadk.core.view.a(this.mvY.getPageContext());
            duc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duc() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.mwp.setText(R.string.tip_url_post);
        } else {
            this.mwp.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        an.setViewTextColor(this.mwp, (int) R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.mvY.setIsLoading(z);
        if (z) {
            this.mwc.setVisibility(0);
            this.kvT.setVisibility(8);
            this.mvZ.startLoad(null, 10, false);
            this.mwf.setVisibility(8);
            this.mwg.setVisibility(8);
            this.mwi.setVisibility(8);
            this.mwj.setVisibility(0);
            an.setViewTextColor(this.mwj, (int) R.color.cp_cont_f);
            this.mwj.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.mwc.setVisibility(8);
            this.kvT.setVisibility(8);
            dud();
        } else {
            if (aVar.mog == 1) {
                this.mwc.setVisibility(0);
                this.kvT.setVisibility(8);
                if (aVar.mof) {
                    this.mvZ.startLoad(aVar.moi, 10, false);
                    this.mwf.setText(aVar.linkTitle);
                    this.mwg.setText(aVar.dJi);
                    if (ar.getRealSize(aVar.linkTitle) > 30) {
                        this.mwf.setMaxLines(2);
                        this.mwg.setMaxLines(1);
                    } else {
                        this.mwf.setMaxLines(1);
                        this.mwg.setMaxLines(2);
                    }
                    this.mwf.setVisibility(0);
                    this.mwg.setVisibility(0);
                    this.mwj.setVisibility(8);
                    this.mwi.setVisibility(8);
                } else {
                    this.mvZ.reset();
                    this.mwj.setText(aVar.linkUrl);
                    an.setViewTextColor(this.mwj, (int) R.color.cp_cont_b);
                    this.mwf.setVisibility(8);
                    this.mwg.setVisibility(8);
                    this.mwj.setVisibility(0);
                    this.mwi.setVisibility(0);
                }
            } else if (aVar.mog == 2) {
                this.mwc.setVisibility(8);
                this.kvT.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.kvT.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(this.mvY.getPageContext().getPageActivity()) - ((int) this.mvY.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.kvT.setLayoutParams(layoutParams);
                an.setImageResource(this.mwd, R.drawable.icon_play_video);
                an.setBackgroundResource(this.mwe, R.drawable.btn_delete_url);
                this.ajE.startLoad(aVar.mol, 10, false);
            } else {
                this.mwc.setVisibility(0);
                this.kvT.setVisibility(8);
                this.mwf.setVisibility(8);
                this.mwg.setVisibility(8);
                this.mwj.setVisibility(0);
                this.mwi.setVisibility(0);
                this.mvZ.reset();
                this.mwj.setText(aVar.linkUrl);
                an.setViewTextColor(this.mwj, (int) R.color.cp_cont_b);
            }
            dud();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.mwa.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.mvY != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mvY.getPageContext(), i);
            }
            an.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_d);
            an.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
            this.mwa.setHintTextColor(an.getColor(R.color.cp_cont_e));
            this.mwa.setTextColor(an.getColor(R.color.cp_cont_f));
            an.setBackgroundColor(this.mwc, R.color.cp_bg_line_e);
            an.setViewTextColor(this.mwf, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.mwg, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.mwj, (int) R.color.cp_cont_b);
            an.setBackgroundColor(this.mwi, R.color.cp_bg_line_d);
            an.setViewTextColor(this.mwi, (int) R.color.cp_cont_d);
            an.setBackgroundResource(this.mwb, R.drawable.bg_link_invoke);
            an.setBackgroundColor(this.mwk, R.color.cp_bg_line_d);
            this.mwl.setHintTextColor(an.getColor(R.color.cp_cont_e));
            an.setViewTextColor(this.mwl, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.mwp, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.mwn, (int) R.color.cp_cont_e);
            an.setImageResource(this.mwd, R.drawable.home_ic_video);
            an.setBackgroundResource(this.mwh, R.drawable.btn_delete_url);
            an.setBackgroundResource(this.mwm, R.drawable.btn_delete_url);
            an.setBackgroundResource(this.mwe, R.drawable.btn_delete_url);
            dud();
        }
    }

    public void dud() {
        boolean z;
        if (StringUtils.isNull(due())) {
            z = this.mwc.getVisibility() == 0 || this.kvT.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            an.setNavbarTitleColor(this.hLH, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.hLH.setEnabled(true);
            return;
        }
        an.setViewTextColor(this.hLH, R.color.cp_cont_d, 1);
        this.hLH.setEnabled(false);
    }

    public String due() {
        if (this.mwa == null || this.mwa.getText() == null) {
            return null;
        }
        return this.mwa.getText().toString();
    }

    public View cti() {
        return this.dDv;
    }

    public View duf() {
        return this.hLH;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText dug() {
        return this.mwa;
    }

    public View duh() {
        return this.mwh;
    }

    public View dui() {
        return this.mwe;
    }

    public View duj() {
        return this.mwc;
    }

    public View getVideoContainer() {
        return this.kvT;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.mwl.setText(aVar.linkUrl);
            this.mwl.setSelection(aVar.linkUrl.length());
        }
        this.mwl.requestFocus();
        l.showSoftKeyPad(this.mvY.getActivity(), this.mwl);
        this.mwk.setVisibility(0);
        this.mwo.setVisibility(0);
        this.mwb.setVisibility(8);
    }

    public void duk() {
        this.mwk.setVisibility(8);
        this.mwo.setVisibility(8);
        this.mwb.setVisibility(0);
        l.hideSoftKeyPad(this.mvY.getActivity(), this.mwl);
    }

    public void ak(View.OnClickListener onClickListener) {
        this.mwk.setOnClickListener(onClickListener);
        this.mwo.setOnClickListener(onClickListener);
        this.mwb.setOnClickListener(onClickListener);
    }

    public String dul() {
        if (this.mwl == null || this.mwl.getText() == null) {
            return null;
        }
        return this.mwl.getText().toString();
    }

    public void dum() {
        if (this.mwp != null) {
            this.mwp.setText(R.string.tip_url_not_match);
            an.setViewTextColor(this.mwp, (int) R.color.cp_other_b);
        }
    }

    public void al(View.OnClickListener onClickListener) {
        if (this.mwn != null) {
            this.mwn.setOnClickListener(onClickListener);
        }
    }

    public View dun() {
        return this.mwk;
    }

    public void destroy() {
        if (this.mwa != null) {
            this.mwa.addTextChangedListener(null);
        }
        if (this.mwl != null) {
            this.mwl.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.bA(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aX(this.mvY.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.mvY.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.mvY.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.eDA.setCancelListener(null);
        this.eDA.setTipString(R.string.sending);
        this.eDA.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.eDA.setDialogVisiable(false);
    }
}
