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
    private WriteUrlActivity mvV;
    private TbImageView mvW;
    private EditText mvX;
    private View mvY;
    private LinearLayout mvZ;
    private ImageView mwa;
    private View mwb;
    private TextView mwc;
    private TextView mwd;
    private View mwe;
    private TextView mwf;
    private TextView mwg;
    private LinearLayout mwh;
    private EditText mwi;
    private View mwj;
    private TextView mwk;
    private FrameLayout mwl;
    private TextView mwm;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.dDv = null;
        this.eDA = null;
        if (writeUrlActivity != null) {
            this.mvV = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.mvV.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.mvV.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.dDv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.aWQ().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dDv.getLayoutParams();
                layoutParams.leftMargin = l.getDimens(this.mvV.getActivity(), R.dimen.ds10);
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
            layoutParams3.rightMargin = l.getDimens(this.mvV.getActivity(), R.dimen.ds16);
            this.hLH.setLayoutParams(layoutParams3);
            this.hLH.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.mvW = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.mvW.setDefaultResource(R.drawable.ic_post_url_n);
            this.mvW.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.mvW.setDefaultBgResource(R.color.black_alpha0);
            this.mvZ = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.mvZ.setOnClickListener(this.mClickListener);
            this.kvT = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.kvT.setOnClickListener(this.mClickListener);
            this.ajE = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.ajE.setDefaultErrorResource(0);
            this.ajE.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.ajE.setDefaultBgResource(R.color.black_alpha0);
            this.mwa = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.mwb = this.mRoot.findViewById(R.id.video_view_delete);
            this.mwb.setOnClickListener(this.mClickListener);
            this.mwc = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.mwd = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.mwe = this.mRoot.findViewById(R.id.view_delete);
            this.mwe.setOnClickListener(this.mClickListener);
            this.mvY = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.mvY.setOnClickListener(this.mClickListener);
            this.mvX = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.mwf = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.mwg = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.mwh = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.mwi = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.mwm = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.mwj = this.mRoot.findViewById(R.id.url_input_clear);
            this.mwk = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.mwk.setEnabled(false);
            this.mwl = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.mwi.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.mwj.setVisibility(8);
                        an.setViewTextColor(k.this.mwk, (int) R.color.cp_cont_e);
                        k.this.mwk.setEnabled(false);
                        return;
                    }
                    k.this.mwj.setVisibility(0);
                    an.setViewTextColor(k.this.mwk, (int) R.color.cp_link_tip_a);
                    k.this.mwk.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.mwm.getText().equals(k.this.mvV.getActivity().getString(R.string.tip_url_not_match))) {
                        k.this.dtY();
                    }
                }
            });
            this.mwj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.mwi.setText("");
                    k.this.mwj.setVisibility(8);
                    k.this.mwk.setEnabled(false);
                }
            });
            this.eDA = new com.baidu.tbadk.core.view.a(this.mvV.getPageContext());
            dtY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtY() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.mwm.setText(R.string.tip_url_post);
        } else {
            this.mwm.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        an.setViewTextColor(this.mwm, (int) R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.mvV.setIsLoading(z);
        if (z) {
            this.mvZ.setVisibility(0);
            this.kvT.setVisibility(8);
            this.mvW.startLoad(null, 10, false);
            this.mwc.setVisibility(8);
            this.mwd.setVisibility(8);
            this.mwf.setVisibility(8);
            this.mwg.setVisibility(0);
            an.setViewTextColor(this.mwg, (int) R.color.cp_cont_f);
            this.mwg.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.mvZ.setVisibility(8);
            this.kvT.setVisibility(8);
            dtZ();
        } else {
            if (aVar.mod == 1) {
                this.mvZ.setVisibility(0);
                this.kvT.setVisibility(8);
                if (aVar.moc) {
                    this.mvW.startLoad(aVar.mof, 10, false);
                    this.mwc.setText(aVar.linkTitle);
                    this.mwd.setText(aVar.dJi);
                    if (ar.getRealSize(aVar.linkTitle) > 30) {
                        this.mwc.setMaxLines(2);
                        this.mwd.setMaxLines(1);
                    } else {
                        this.mwc.setMaxLines(1);
                        this.mwd.setMaxLines(2);
                    }
                    this.mwc.setVisibility(0);
                    this.mwd.setVisibility(0);
                    this.mwg.setVisibility(8);
                    this.mwf.setVisibility(8);
                } else {
                    this.mvW.reset();
                    this.mwg.setText(aVar.linkUrl);
                    an.setViewTextColor(this.mwg, (int) R.color.cp_cont_b);
                    this.mwc.setVisibility(8);
                    this.mwd.setVisibility(8);
                    this.mwg.setVisibility(0);
                    this.mwf.setVisibility(0);
                }
            } else if (aVar.mod == 2) {
                this.mvZ.setVisibility(8);
                this.kvT.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.kvT.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(this.mvV.getPageContext().getPageActivity()) - ((int) this.mvV.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.kvT.setLayoutParams(layoutParams);
                an.setImageResource(this.mwa, R.drawable.icon_play_video);
                an.setBackgroundResource(this.mwb, R.drawable.btn_delete_url);
                this.ajE.startLoad(aVar.moi, 10, false);
            } else {
                this.mvZ.setVisibility(0);
                this.kvT.setVisibility(8);
                this.mwc.setVisibility(8);
                this.mwd.setVisibility(8);
                this.mwg.setVisibility(0);
                this.mwf.setVisibility(0);
                this.mvW.reset();
                this.mwg.setText(aVar.linkUrl);
                an.setViewTextColor(this.mwg, (int) R.color.cp_cont_b);
            }
            dtZ();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.mvX.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.mvV != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mvV.getPageContext(), i);
            }
            an.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_d);
            an.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
            this.mvX.setHintTextColor(an.getColor(R.color.cp_cont_e));
            this.mvX.setTextColor(an.getColor(R.color.cp_cont_f));
            an.setBackgroundColor(this.mvZ, R.color.cp_bg_line_e);
            an.setViewTextColor(this.mwc, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.mwd, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.mwg, (int) R.color.cp_cont_b);
            an.setBackgroundColor(this.mwf, R.color.cp_bg_line_d);
            an.setViewTextColor(this.mwf, (int) R.color.cp_cont_d);
            an.setBackgroundResource(this.mvY, R.drawable.bg_link_invoke);
            an.setBackgroundColor(this.mwh, R.color.cp_bg_line_d);
            this.mwi.setHintTextColor(an.getColor(R.color.cp_cont_e));
            an.setViewTextColor(this.mwi, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.mwm, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.mwk, (int) R.color.cp_cont_e);
            an.setImageResource(this.mwa, R.drawable.home_ic_video);
            an.setBackgroundResource(this.mwe, R.drawable.btn_delete_url);
            an.setBackgroundResource(this.mwj, R.drawable.btn_delete_url);
            an.setBackgroundResource(this.mwb, R.drawable.btn_delete_url);
            dtZ();
        }
    }

    public void dtZ() {
        boolean z;
        if (StringUtils.isNull(dua())) {
            z = this.mvZ.getVisibility() == 0 || this.kvT.getVisibility() == 0;
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

    public String dua() {
        if (this.mvX == null || this.mvX.getText() == null) {
            return null;
        }
        return this.mvX.getText().toString();
    }

    public View cth() {
        return this.dDv;
    }

    public View dub() {
        return this.hLH;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText duc() {
        return this.mvX;
    }

    public View dud() {
        return this.mwe;
    }

    public View due() {
        return this.mwb;
    }

    public View duf() {
        return this.mvZ;
    }

    public View getVideoContainer() {
        return this.kvT;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.mwi.setText(aVar.linkUrl);
            this.mwi.setSelection(aVar.linkUrl.length());
        }
        this.mwi.requestFocus();
        l.showSoftKeyPad(this.mvV.getActivity(), this.mwi);
        this.mwh.setVisibility(0);
        this.mwl.setVisibility(0);
        this.mvY.setVisibility(8);
    }

    public void dug() {
        this.mwh.setVisibility(8);
        this.mwl.setVisibility(8);
        this.mvY.setVisibility(0);
        l.hideSoftKeyPad(this.mvV.getActivity(), this.mwi);
    }

    public void ak(View.OnClickListener onClickListener) {
        this.mwh.setOnClickListener(onClickListener);
        this.mwl.setOnClickListener(onClickListener);
        this.mvY.setOnClickListener(onClickListener);
    }

    public String duh() {
        if (this.mwi == null || this.mwi.getText() == null) {
            return null;
        }
        return this.mwi.getText().toString();
    }

    public void dui() {
        if (this.mwm != null) {
            this.mwm.setText(R.string.tip_url_not_match);
            an.setViewTextColor(this.mwm, (int) R.color.cp_other_b);
        }
    }

    public void al(View.OnClickListener onClickListener) {
        if (this.mwk != null) {
            this.mwk.setOnClickListener(onClickListener);
        }
    }

    public View duj() {
        return this.mwh;
    }

    public void destroy() {
        if (this.mvX != null) {
            this.mvX.addTextChangedListener(null);
        }
        if (this.mwi != null) {
            this.mwi.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.bA(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aX(this.mvV.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.mvV.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.mvV.showToast(errorString);
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
