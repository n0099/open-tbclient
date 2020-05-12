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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class k {
    private TbImageView ahE;
    private View dkp;
    private com.baidu.tbadk.core.view.a egi;
    private RelativeLayout jJp;
    private WriteUrlActivity lGF;
    private TextView lGG;
    private TbImageView lGH;
    private EditText lGI;
    private View lGJ;
    private LinearLayout lGK;
    private ImageView lGL;
    private View lGM;
    private TextView lGN;
    private TextView lGO;
    private View lGP;
    private TextView lGQ;
    private TextView lGR;
    private LinearLayout lGS;
    private EditText lGT;
    private View lGU;
    private TextView lGV;
    private FrameLayout lGW;
    private TextView lGX;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.dkp = null;
        this.egi = null;
        if (writeUrlActivity != null) {
            this.lGF = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.lGF.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.lGF.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.dkp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.aOR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dkp.getLayoutParams();
                layoutParams.leftMargin = l.getDimens(this.lGF.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.dkp != null && (this.dkp.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dkp.getLayoutParams();
                layoutParams2.width = -2;
                this.dkp.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.lGG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            am.setViewTextColor(this.lGG, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.lGG.getLayoutParams();
            layoutParams3.rightMargin = l.getDimens(this.lGF.getActivity(), R.dimen.ds16);
            this.lGG.setLayoutParams(layoutParams3);
            this.lGG.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.lGH = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.lGH.setDefaultResource(R.drawable.ic_post_url_n);
            this.lGH.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.lGH.setDefaultBgResource(R.color.black_alpha0);
            this.lGK = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.lGK.setOnClickListener(this.mClickListener);
            this.jJp = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.jJp.setOnClickListener(this.mClickListener);
            this.ahE = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.ahE.setDefaultErrorResource(0);
            this.ahE.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.ahE.setDefaultBgResource(R.color.black_alpha0);
            this.lGL = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.lGM = this.mRoot.findViewById(R.id.video_view_delete);
            this.lGM.setOnClickListener(this.mClickListener);
            this.lGN = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.lGO = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.lGP = this.mRoot.findViewById(R.id.view_delete);
            this.lGP.setOnClickListener(this.mClickListener);
            this.lGJ = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.lGJ.setOnClickListener(this.mClickListener);
            this.lGI = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.lGQ = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.lGR = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.lGS = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.lGT = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.lGX = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.lGU = this.mRoot.findViewById(R.id.url_input_clear);
            this.lGV = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.lGV.setEnabled(false);
            this.lGW = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.lGT.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.lGU.setVisibility(8);
                        am.setViewTextColor(k.this.lGV, (int) R.color.cp_cont_e);
                        k.this.lGV.setEnabled(false);
                        return;
                    }
                    k.this.lGU.setVisibility(0);
                    am.setViewTextColor(k.this.lGV, (int) R.color.cp_link_tip_a);
                    k.this.lGV.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.lGX.getText().equals(k.this.lGF.getActivity().getString(R.string.tip_url_not_match))) {
                        k.this.dhY();
                    }
                }
            });
            this.lGU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.lGT.setText("");
                    k.this.lGU.setVisibility(8);
                    k.this.lGV.setEnabled(false);
                }
            });
            this.egi = new com.baidu.tbadk.core.view.a(this.lGF.getPageContext());
            dhY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhY() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.lGX.setText(R.string.tip_url_post);
        } else {
            this.lGX.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        am.setViewTextColor(this.lGX, (int) R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.lGF.setIsLoading(z);
        if (z) {
            this.lGK.setVisibility(0);
            this.jJp.setVisibility(8);
            this.lGH.startLoad(null, 10, false);
            this.lGN.setVisibility(8);
            this.lGO.setVisibility(8);
            this.lGQ.setVisibility(8);
            this.lGR.setVisibility(0);
            am.setViewTextColor(this.lGR, (int) R.color.cp_cont_f);
            this.lGR.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.lGK.setVisibility(8);
            this.jJp.setVisibility(8);
            dhZ();
        } else {
            if (aVar.lzm == 1) {
                this.lGK.setVisibility(0);
                this.jJp.setVisibility(8);
                if (aVar.lzl) {
                    this.lGH.startLoad(aVar.lzo, 10, false);
                    this.lGN.setText(aVar.linkTitle);
                    this.lGO.setText(aVar.doO);
                    if (aq.getRealSize(aVar.linkTitle) > 30) {
                        this.lGN.setMaxLines(2);
                        this.lGO.setMaxLines(1);
                    } else {
                        this.lGN.setMaxLines(1);
                        this.lGO.setMaxLines(2);
                    }
                    this.lGN.setVisibility(0);
                    this.lGO.setVisibility(0);
                    this.lGR.setVisibility(8);
                    this.lGQ.setVisibility(8);
                } else {
                    this.lGH.reset();
                    this.lGR.setText(aVar.linkUrl);
                    am.setViewTextColor(this.lGR, (int) R.color.cp_cont_b);
                    this.lGN.setVisibility(8);
                    this.lGO.setVisibility(8);
                    this.lGR.setVisibility(0);
                    this.lGQ.setVisibility(0);
                }
            } else if (aVar.lzm == 2) {
                this.lGK.setVisibility(8);
                this.jJp.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.jJp.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(this.lGF.getPageContext().getPageActivity()) - ((int) this.lGF.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.jJp.setLayoutParams(layoutParams);
                am.setImageResource(this.lGL, R.drawable.icon_play_video);
                am.setBackgroundResource(this.lGM, R.drawable.btn_delete_url);
                this.ahE.startLoad(aVar.lzr, 10, false);
            } else {
                this.lGK.setVisibility(0);
                this.jJp.setVisibility(8);
                this.lGN.setVisibility(8);
                this.lGO.setVisibility(8);
                this.lGR.setVisibility(0);
                this.lGQ.setVisibility(0);
                this.lGH.reset();
                this.lGR.setText(aVar.linkUrl);
                am.setViewTextColor(this.lGR, (int) R.color.cp_cont_b);
            }
            dhZ();
        }
    }

    public void f(TextWatcher textWatcher) {
        this.lGI.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.lGF != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.lGF.getPageContext(), i);
            }
            am.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
            this.lGI.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.lGI.setTextColor(am.getColor(R.color.cp_cont_f));
            am.setBackgroundColor(this.lGK, R.color.cp_bg_line_e);
            am.setViewTextColor(this.lGN, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lGO, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.lGR, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.lGQ, R.color.cp_bg_line_d);
            am.setViewTextColor(this.lGQ, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.lGJ, R.drawable.bg_link_invoke);
            am.setBackgroundColor(this.lGS, R.color.cp_bg_line_d);
            this.lGT.setHintTextColor(am.getColor(R.color.cp_cont_e));
            am.setViewTextColor(this.lGT, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lGX, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.lGV, (int) R.color.cp_cont_e);
            am.setImageResource(this.lGL, R.drawable.home_ic_video);
            am.setBackgroundResource(this.lGP, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.lGU, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.lGM, R.drawable.btn_delete_url);
            dhZ();
        }
    }

    public void dhZ() {
        boolean z;
        if (StringUtils.isNull(dia())) {
            z = this.lGK.getVisibility() == 0 || this.jJp.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            am.setNavbarTitleColor(this.lGG, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.lGG.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.lGG, R.color.cp_cont_d, 1);
        this.lGG.setEnabled(false);
    }

    public String dia() {
        if (this.lGI == null || this.lGI.getText() == null) {
            return null;
        }
        return this.lGI.getText().toString();
    }

    public View ciM() {
        return this.dkp;
    }

    public View dib() {
        return this.lGG;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText dic() {
        return this.lGI;
    }

    public View did() {
        return this.lGP;
    }

    public View die() {
        return this.lGM;
    }

    public View dif() {
        return this.lGK;
    }

    public View getVideoContainer() {
        return this.jJp;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.lGT.setText(aVar.linkUrl);
            this.lGT.setSelection(aVar.linkUrl.length());
        }
        this.lGT.requestFocus();
        l.showSoftKeyPad(this.lGF.getActivity(), this.lGT);
        this.lGS.setVisibility(0);
        this.lGW.setVisibility(0);
        this.lGJ.setVisibility(8);
    }

    public void dig() {
        this.lGS.setVisibility(8);
        this.lGW.setVisibility(8);
        this.lGJ.setVisibility(0);
        l.hideSoftKeyPad(this.lGF.getActivity(), this.lGT);
    }

    public void aj(View.OnClickListener onClickListener) {
        this.lGS.setOnClickListener(onClickListener);
        this.lGW.setOnClickListener(onClickListener);
        this.lGJ.setOnClickListener(onClickListener);
    }

    public String dih() {
        if (this.lGT == null || this.lGT.getText() == null) {
            return null;
        }
        return this.lGT.getText().toString();
    }

    public void dii() {
        if (this.lGX != null) {
            this.lGX.setText(R.string.tip_url_not_match);
            am.setViewTextColor(this.lGX, (int) R.color.cp_other_b);
        }
    }

    public void ak(View.OnClickListener onClickListener) {
        if (this.lGV != null) {
            this.lGV.setOnClickListener(onClickListener);
        }
    }

    public View dij() {
        return this.lGS;
    }

    public void destroy() {
        if (this.lGI != null) {
            this.lGI.addTextChangedListener(null);
        }
        if (this.lGT != null) {
            this.lGT.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.bq(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aW(this.lGF.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.lGF.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.lGF.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.egi.setCancelListener(null);
        this.egi.setTipString(R.string.sending);
        this.egi.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.egi.setDialogVisiable(false);
    }
}
