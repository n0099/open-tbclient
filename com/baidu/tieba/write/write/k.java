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
/* loaded from: classes3.dex */
public class k {
    private View bUX;
    private com.baidu.tbadk.core.view.b cOA;
    private TbImageView hgy;
    private RelativeLayout iel;
    private WriteUrlActivity jWB;
    private TextView jWC;
    private TbImageView jWD;
    private EditText jWE;
    private View jWF;
    private LinearLayout jWG;
    private ImageView jWH;
    private View jWI;
    private TextView jWJ;
    private TextView jWK;
    private View jWL;
    private TextView jWM;
    private TextView jWN;
    private LinearLayout jWO;
    private EditText jWP;
    private View jWQ;
    private TextView jWR;
    private FrameLayout jWS;
    private TextView jWT;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.bUX = null;
        this.cOA = null;
        if (writeUrlActivity != null) {
            this.jWB = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.jWB.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.jWB.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.bUX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.amN().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bUX.getLayoutParams();
                layoutParams.leftMargin = l.getDimens(this.jWB.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.bUX != null && (this.bUX.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bUX.getLayoutParams();
                layoutParams2.width = -2;
                this.bUX.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.jWC = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            am.setViewTextColor(this.jWC, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.jWC.getLayoutParams();
            layoutParams3.rightMargin = l.getDimens(this.jWB.getActivity(), R.dimen.ds16);
            this.jWC.setLayoutParams(layoutParams3);
            this.jWC.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.jWD = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.jWD.setDefaultResource(R.drawable.ic_post_url_n);
            this.jWD.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.jWD.setDefaultBgResource(R.color.black_alpha0);
            this.jWG = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.jWG.setOnClickListener(this.mClickListener);
            this.iel = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.iel.setOnClickListener(this.mClickListener);
            this.hgy = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.hgy.setDefaultErrorResource(0);
            this.hgy.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.hgy.setDefaultBgResource(R.color.black_alpha0);
            this.jWH = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.jWI = this.mRoot.findViewById(R.id.video_view_delete);
            this.jWI.setOnClickListener(this.mClickListener);
            this.jWJ = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.jWK = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.jWL = this.mRoot.findViewById(R.id.view_delete);
            this.jWL.setOnClickListener(this.mClickListener);
            this.jWF = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.jWF.setOnClickListener(this.mClickListener);
            this.jWE = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.jWM = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.jWN = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.jWO = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.jWP = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.jWT = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.jWQ = this.mRoot.findViewById(R.id.url_input_clear);
            this.jWR = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.jWR.setEnabled(false);
            this.jWS = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.jWP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.jWQ.setVisibility(8);
                        am.setViewTextColor(k.this.jWR, (int) R.color.cp_cont_e);
                        k.this.jWR.setEnabled(false);
                        return;
                    }
                    k.this.jWQ.setVisibility(0);
                    am.setViewTextColor(k.this.jWR, (int) R.color.cp_link_tip_a);
                    k.this.jWR.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.jWT.getText().equals(k.this.jWB.getActivity().getString(R.string.tip_url_not_match))) {
                        k.this.cAz();
                    }
                }
            });
            this.jWQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.jWP.setText("");
                    k.this.jWQ.setVisibility(8);
                    k.this.jWR.setEnabled(false);
                }
            });
            this.cOA = new com.baidu.tbadk.core.view.b(this.jWB.getPageContext());
            cAz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAz() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.jWT.setText(R.string.tip_url_post);
        } else {
            this.jWT.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        am.setViewTextColor(this.jWT, (int) R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.jWB.setIsLoading(z);
        if (z) {
            this.jWG.setVisibility(0);
            this.iel.setVisibility(8);
            this.jWD.startLoad(null, 10, false);
            this.jWJ.setVisibility(8);
            this.jWK.setVisibility(8);
            this.jWM.setVisibility(8);
            this.jWN.setVisibility(0);
            am.setViewTextColor(this.jWN, (int) R.color.cp_cont_f);
            this.jWN.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.jWG.setVisibility(8);
            this.iel.setVisibility(8);
            cAA();
        } else {
            if (aVar.jPK == 1) {
                this.jWG.setVisibility(0);
                this.iel.setVisibility(8);
                if (aVar.jPJ) {
                    this.jWD.startLoad(aVar.jPM, 10, false);
                    this.jWJ.setText(aVar.bZI);
                    this.jWK.setText(aVar.bZJ);
                    if (aq.getRealSize(aVar.bZI) > 30) {
                        this.jWJ.setMaxLines(2);
                        this.jWK.setMaxLines(1);
                    } else {
                        this.jWJ.setMaxLines(1);
                        this.jWK.setMaxLines(2);
                    }
                    this.jWJ.setVisibility(0);
                    this.jWK.setVisibility(0);
                    this.jWN.setVisibility(8);
                    this.jWM.setVisibility(8);
                } else {
                    this.jWD.reset();
                    this.jWN.setText(aVar.linkUrl);
                    am.setViewTextColor(this.jWN, (int) R.color.cp_cont_b);
                    this.jWJ.setVisibility(8);
                    this.jWK.setVisibility(8);
                    this.jWN.setVisibility(0);
                    this.jWM.setVisibility(0);
                }
            } else if (aVar.jPK == 2) {
                this.jWG.setVisibility(8);
                this.iel.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.iel.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(this.jWB.getPageContext().getPageActivity()) - ((int) this.jWB.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.iel.setLayoutParams(layoutParams);
                am.setImageResource(this.jWH, R.drawable.icon_play_video);
                am.setBackgroundResource(this.jWI, R.drawable.btn_delete_url);
                this.hgy.startLoad(aVar.jPP, 10, false);
            } else {
                this.jWG.setVisibility(0);
                this.iel.setVisibility(8);
                this.jWJ.setVisibility(8);
                this.jWK.setVisibility(8);
                this.jWN.setVisibility(0);
                this.jWM.setVisibility(0);
                this.jWD.reset();
                this.jWN.setText(aVar.linkUrl);
                am.setViewTextColor(this.jWN, (int) R.color.cp_cont_b);
            }
            cAA();
        }
    }

    public void g(TextWatcher textWatcher) {
        this.jWE.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.jWB != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.jWB.getPageContext(), i);
            }
            am.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
            this.jWE.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.jWE.setTextColor(am.getColor(R.color.cp_cont_f));
            am.setBackgroundColor(this.jWG, R.color.cp_bg_line_e);
            am.setViewTextColor(this.jWJ, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jWK, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jWN, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.jWM, R.color.cp_bg_line_d);
            am.setViewTextColor(this.jWM, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.jWF, R.drawable.bg_link_invoke);
            am.setBackgroundColor(this.jWO, R.color.cp_bg_line_d);
            this.jWP.setHintTextColor(am.getColor(R.color.cp_cont_e));
            am.setViewTextColor(this.jWP, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jWT, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jWR, (int) R.color.cp_cont_e);
            am.setImageResource(this.jWH, R.drawable.home_ic_video);
            am.setBackgroundResource(this.jWL, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.jWQ, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.jWI, R.drawable.btn_delete_url);
            cAA();
        }
    }

    public void cAA() {
        boolean z;
        if (StringUtils.isNull(cAB())) {
            z = this.jWG.getVisibility() == 0 || this.iel.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            am.setNavbarTitleColor(this.jWC, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.jWC.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.jWC, R.color.cp_cont_d, 1);
        this.jWC.setEnabled(false);
    }

    public String cAB() {
        if (this.jWE == null || this.jWE.getText() == null) {
            return null;
        }
        return this.jWE.getText().toString();
    }

    public View bDX() {
        return this.bUX;
    }

    public View cAC() {
        return this.jWC;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText cAD() {
        return this.jWE;
    }

    public View cAE() {
        return this.jWL;
    }

    public View cAF() {
        return this.jWI;
    }

    public View cAG() {
        return this.jWG;
    }

    public View getVideoContainer() {
        return this.iel;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.jWP.setText(aVar.linkUrl);
            this.jWP.setSelection(aVar.linkUrl.length());
        }
        this.jWP.requestFocus();
        l.showSoftKeyPad(this.jWB.getActivity(), this.jWP);
        this.jWO.setVisibility(0);
        this.jWS.setVisibility(0);
        this.jWF.setVisibility(8);
    }

    public void cAH() {
        this.jWO.setVisibility(8);
        this.jWS.setVisibility(8);
        this.jWF.setVisibility(0);
        l.hideSoftKeyPad(this.jWB.getActivity(), this.jWP);
    }

    public void af(View.OnClickListener onClickListener) {
        this.jWO.setOnClickListener(onClickListener);
        this.jWS.setOnClickListener(onClickListener);
        this.jWF.setOnClickListener(onClickListener);
    }

    public String cAI() {
        if (this.jWP == null || this.jWP.getText() == null) {
            return null;
        }
        return this.jWP.getText().toString();
    }

    public void cAJ() {
        if (this.jWT != null) {
            this.jWT.setText(R.string.tip_url_not_match);
            am.setViewTextColor(this.jWT, (int) R.color.cp_other_b);
        }
    }

    public void ag(View.OnClickListener onClickListener) {
        if (this.jWR != null) {
            this.jWR.setOnClickListener(onClickListener);
        }
    }

    public View cAK() {
        return this.jWO;
    }

    public void destroy() {
        if (this.jWE != null) {
            this.jWE.addTextChangedListener(null);
        }
        if (this.jWP != null) {
            this.jWP.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.aH(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aS(this.jWB.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.jWB.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.jWB.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.cOA.setCancelListener(null);
        this.cOA.setTipString(R.string.sending);
        this.cOA.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.cOA.setDialogVisiable(false);
    }
}
