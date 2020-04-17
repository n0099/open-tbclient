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
    private TbImageView ahB;
    private View dkl;
    private com.baidu.tbadk.core.view.a egd;
    private RelativeLayout jJl;
    private WriteUrlActivity lGB;
    private TextView lGC;
    private TbImageView lGD;
    private EditText lGE;
    private View lGF;
    private LinearLayout lGG;
    private ImageView lGH;
    private View lGI;
    private TextView lGJ;
    private TextView lGK;
    private View lGL;
    private TextView lGM;
    private TextView lGN;
    private LinearLayout lGO;
    private EditText lGP;
    private View lGQ;
    private TextView lGR;
    private FrameLayout lGS;
    private TextView lGT;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.dkl = null;
        this.egd = null;
        if (writeUrlActivity != null) {
            this.lGB = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.lGB.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.lGB.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.dkl = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.aOU().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dkl.getLayoutParams();
                layoutParams.leftMargin = l.getDimens(this.lGB.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.dkl != null && (this.dkl.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dkl.getLayoutParams();
                layoutParams2.width = -2;
                this.dkl.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.lGC = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            am.setViewTextColor(this.lGC, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.lGC.getLayoutParams();
            layoutParams3.rightMargin = l.getDimens(this.lGB.getActivity(), R.dimen.ds16);
            this.lGC.setLayoutParams(layoutParams3);
            this.lGC.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.lGD = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.lGD.setDefaultResource(R.drawable.ic_post_url_n);
            this.lGD.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.lGD.setDefaultBgResource(R.color.black_alpha0);
            this.lGG = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.lGG.setOnClickListener(this.mClickListener);
            this.jJl = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.jJl.setOnClickListener(this.mClickListener);
            this.ahB = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.ahB.setDefaultErrorResource(0);
            this.ahB.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.ahB.setDefaultBgResource(R.color.black_alpha0);
            this.lGH = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.lGI = this.mRoot.findViewById(R.id.video_view_delete);
            this.lGI.setOnClickListener(this.mClickListener);
            this.lGJ = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.lGK = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.lGL = this.mRoot.findViewById(R.id.view_delete);
            this.lGL.setOnClickListener(this.mClickListener);
            this.lGF = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.lGF.setOnClickListener(this.mClickListener);
            this.lGE = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.lGM = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.lGN = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.lGO = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.lGP = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.lGT = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.lGQ = this.mRoot.findViewById(R.id.url_input_clear);
            this.lGR = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.lGR.setEnabled(false);
            this.lGS = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.lGP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.lGQ.setVisibility(8);
                        am.setViewTextColor(k.this.lGR, (int) R.color.cp_cont_e);
                        k.this.lGR.setEnabled(false);
                        return;
                    }
                    k.this.lGQ.setVisibility(0);
                    am.setViewTextColor(k.this.lGR, (int) R.color.cp_link_tip_a);
                    k.this.lGR.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.lGT.getText().equals(k.this.lGB.getActivity().getString(R.string.tip_url_not_match))) {
                        k.this.dia();
                    }
                }
            });
            this.lGQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.lGP.setText("");
                    k.this.lGQ.setVisibility(8);
                    k.this.lGR.setEnabled(false);
                }
            });
            this.egd = new com.baidu.tbadk.core.view.a(this.lGB.getPageContext());
            dia();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dia() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.lGT.setText(R.string.tip_url_post);
        } else {
            this.lGT.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        am.setViewTextColor(this.lGT, (int) R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.lGB.setIsLoading(z);
        if (z) {
            this.lGG.setVisibility(0);
            this.jJl.setVisibility(8);
            this.lGD.startLoad(null, 10, false);
            this.lGJ.setVisibility(8);
            this.lGK.setVisibility(8);
            this.lGM.setVisibility(8);
            this.lGN.setVisibility(0);
            am.setViewTextColor(this.lGN, (int) R.color.cp_cont_f);
            this.lGN.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.lGG.setVisibility(8);
            this.jJl.setVisibility(8);
            dib();
        } else {
            if (aVar.lzi == 1) {
                this.lGG.setVisibility(0);
                this.jJl.setVisibility(8);
                if (aVar.lzh) {
                    this.lGD.startLoad(aVar.lzk, 10, false);
                    this.lGJ.setText(aVar.linkTitle);
                    this.lGK.setText(aVar.doK);
                    if (aq.getRealSize(aVar.linkTitle) > 30) {
                        this.lGJ.setMaxLines(2);
                        this.lGK.setMaxLines(1);
                    } else {
                        this.lGJ.setMaxLines(1);
                        this.lGK.setMaxLines(2);
                    }
                    this.lGJ.setVisibility(0);
                    this.lGK.setVisibility(0);
                    this.lGN.setVisibility(8);
                    this.lGM.setVisibility(8);
                } else {
                    this.lGD.reset();
                    this.lGN.setText(aVar.linkUrl);
                    am.setViewTextColor(this.lGN, (int) R.color.cp_cont_b);
                    this.lGJ.setVisibility(8);
                    this.lGK.setVisibility(8);
                    this.lGN.setVisibility(0);
                    this.lGM.setVisibility(0);
                }
            } else if (aVar.lzi == 2) {
                this.lGG.setVisibility(8);
                this.jJl.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.jJl.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(this.lGB.getPageContext().getPageActivity()) - ((int) this.lGB.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.jJl.setLayoutParams(layoutParams);
                am.setImageResource(this.lGH, R.drawable.icon_play_video);
                am.setBackgroundResource(this.lGI, R.drawable.btn_delete_url);
                this.ahB.startLoad(aVar.lzn, 10, false);
            } else {
                this.lGG.setVisibility(0);
                this.jJl.setVisibility(8);
                this.lGJ.setVisibility(8);
                this.lGK.setVisibility(8);
                this.lGN.setVisibility(0);
                this.lGM.setVisibility(0);
                this.lGD.reset();
                this.lGN.setText(aVar.linkUrl);
                am.setViewTextColor(this.lGN, (int) R.color.cp_cont_b);
            }
            dib();
        }
    }

    public void f(TextWatcher textWatcher) {
        this.lGE.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.lGB != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.lGB.getPageContext(), i);
            }
            am.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
            this.lGE.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.lGE.setTextColor(am.getColor(R.color.cp_cont_f));
            am.setBackgroundColor(this.lGG, R.color.cp_bg_line_e);
            am.setViewTextColor(this.lGJ, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lGK, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.lGN, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.lGM, R.color.cp_bg_line_d);
            am.setViewTextColor(this.lGM, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.lGF, R.drawable.bg_link_invoke);
            am.setBackgroundColor(this.lGO, R.color.cp_bg_line_d);
            this.lGP.setHintTextColor(am.getColor(R.color.cp_cont_e));
            am.setViewTextColor(this.lGP, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lGT, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.lGR, (int) R.color.cp_cont_e);
            am.setImageResource(this.lGH, R.drawable.home_ic_video);
            am.setBackgroundResource(this.lGL, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.lGQ, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.lGI, R.drawable.btn_delete_url);
            dib();
        }
    }

    public void dib() {
        boolean z;
        if (StringUtils.isNull(dic())) {
            z = this.lGG.getVisibility() == 0 || this.jJl.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            am.setNavbarTitleColor(this.lGC, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.lGC.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.lGC, R.color.cp_cont_d, 1);
        this.lGC.setEnabled(false);
    }

    public String dic() {
        if (this.lGE == null || this.lGE.getText() == null) {
            return null;
        }
        return this.lGE.getText().toString();
    }

    public View ciN() {
        return this.dkl;
    }

    public View did() {
        return this.lGC;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText die() {
        return this.lGE;
    }

    public View dif() {
        return this.lGL;
    }

    public View dig() {
        return this.lGI;
    }

    public View dih() {
        return this.lGG;
    }

    public View getVideoContainer() {
        return this.jJl;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.lGP.setText(aVar.linkUrl);
            this.lGP.setSelection(aVar.linkUrl.length());
        }
        this.lGP.requestFocus();
        l.showSoftKeyPad(this.lGB.getActivity(), this.lGP);
        this.lGO.setVisibility(0);
        this.lGS.setVisibility(0);
        this.lGF.setVisibility(8);
    }

    public void dii() {
        this.lGO.setVisibility(8);
        this.lGS.setVisibility(8);
        this.lGF.setVisibility(0);
        l.hideSoftKeyPad(this.lGB.getActivity(), this.lGP);
    }

    public void aj(View.OnClickListener onClickListener) {
        this.lGO.setOnClickListener(onClickListener);
        this.lGS.setOnClickListener(onClickListener);
        this.lGF.setOnClickListener(onClickListener);
    }

    public String dij() {
        if (this.lGP == null || this.lGP.getText() == null) {
            return null;
        }
        return this.lGP.getText().toString();
    }

    public void dik() {
        if (this.lGT != null) {
            this.lGT.setText(R.string.tip_url_not_match);
            am.setViewTextColor(this.lGT, (int) R.color.cp_other_b);
        }
    }

    public void ak(View.OnClickListener onClickListener) {
        if (this.lGR != null) {
            this.lGR.setOnClickListener(onClickListener);
        }
    }

    public View dil() {
        return this.lGO;
    }

    public void destroy() {
        if (this.lGE != null) {
            this.lGE.addTextChangedListener(null);
        }
        if (this.lGP != null) {
            this.lGP.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.bq(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bi(this.lGB.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.lGB.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.lGB.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.egd.setCancelListener(null);
        this.egd.setTipString(R.string.sending);
        this.egd.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.egd.setDialogVisiable(false);
    }
}
