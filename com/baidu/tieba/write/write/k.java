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
/* loaded from: classes13.dex */
public class k {
    private TbImageView OZ;
    private View cLe;
    private com.baidu.tbadk.core.view.a dGw;
    private RelativeLayout iZd;
    private WriteUrlActivity kWA;
    private TextView kWB;
    private TbImageView kWC;
    private EditText kWD;
    private View kWE;
    private LinearLayout kWF;
    private ImageView kWG;
    private View kWH;
    private TextView kWI;
    private TextView kWJ;
    private View kWK;
    private TextView kWL;
    private TextView kWM;
    private LinearLayout kWN;
    private EditText kWO;
    private View kWP;
    private TextView kWQ;
    private FrameLayout kWR;
    private TextView kWS;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.cLe = null;
        this.dGw = null;
        if (writeUrlActivity != null) {
            this.kWA = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.kWA.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.kWA.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.cLe = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.aGG().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cLe.getLayoutParams();
                layoutParams.leftMargin = l.getDimens(this.kWA.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.cLe != null && (this.cLe.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cLe.getLayoutParams();
                layoutParams2.width = -2;
                this.cLe.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.kWB = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            am.setViewTextColor(this.kWB, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.kWB.getLayoutParams();
            layoutParams3.rightMargin = l.getDimens(this.kWA.getActivity(), R.dimen.ds16);
            this.kWB.setLayoutParams(layoutParams3);
            this.kWB.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.kWC = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.kWC.setDefaultResource(R.drawable.ic_post_url_n);
            this.kWC.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.kWC.setDefaultBgResource(R.color.black_alpha0);
            this.kWF = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.kWF.setOnClickListener(this.mClickListener);
            this.iZd = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.iZd.setOnClickListener(this.mClickListener);
            this.OZ = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.OZ.setDefaultErrorResource(0);
            this.OZ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.OZ.setDefaultBgResource(R.color.black_alpha0);
            this.kWG = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.kWH = this.mRoot.findViewById(R.id.video_view_delete);
            this.kWH.setOnClickListener(this.mClickListener);
            this.kWI = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.kWJ = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.kWK = this.mRoot.findViewById(R.id.view_delete);
            this.kWK.setOnClickListener(this.mClickListener);
            this.kWE = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.kWE.setOnClickListener(this.mClickListener);
            this.kWD = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.kWL = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.kWM = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.kWN = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.kWO = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.kWS = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.kWP = this.mRoot.findViewById(R.id.url_input_clear);
            this.kWQ = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.kWQ.setEnabled(false);
            this.kWR = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.kWO.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.kWP.setVisibility(8);
                        am.setViewTextColor(k.this.kWQ, (int) R.color.cp_cont_e);
                        k.this.kWQ.setEnabled(false);
                        return;
                    }
                    k.this.kWP.setVisibility(0);
                    am.setViewTextColor(k.this.kWQ, (int) R.color.cp_link_tip_a);
                    k.this.kWQ.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.kWS.getText().equals(k.this.kWA.getActivity().getString(R.string.tip_url_not_match))) {
                        k.this.cXs();
                    }
                }
            });
            this.kWP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.kWO.setText("");
                    k.this.kWP.setVisibility(8);
                    k.this.kWQ.setEnabled(false);
                }
            });
            this.dGw = new com.baidu.tbadk.core.view.a(this.kWA.getPageContext());
            cXs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXs() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.kWS.setText(R.string.tip_url_post);
        } else {
            this.kWS.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        am.setViewTextColor(this.kWS, (int) R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.kWA.setIsLoading(z);
        if (z) {
            this.kWF.setVisibility(0);
            this.iZd.setVisibility(8);
            this.kWC.startLoad(null, 10, false);
            this.kWI.setVisibility(8);
            this.kWJ.setVisibility(8);
            this.kWL.setVisibility(8);
            this.kWM.setVisibility(0);
            am.setViewTextColor(this.kWM, (int) R.color.cp_cont_f);
            this.kWM.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.kWF.setVisibility(8);
            this.iZd.setVisibility(8);
            cXt();
        } else {
            if (aVar.kPQ == 1) {
                this.kWF.setVisibility(0);
                this.iZd.setVisibility(8);
                if (aVar.kPP) {
                    this.kWC.startLoad(aVar.kPS, 10, false);
                    this.kWI.setText(aVar.linkTitle);
                    this.kWJ.setText(aVar.cPE);
                    if (aq.getRealSize(aVar.linkTitle) > 30) {
                        this.kWI.setMaxLines(2);
                        this.kWJ.setMaxLines(1);
                    } else {
                        this.kWI.setMaxLines(1);
                        this.kWJ.setMaxLines(2);
                    }
                    this.kWI.setVisibility(0);
                    this.kWJ.setVisibility(0);
                    this.kWM.setVisibility(8);
                    this.kWL.setVisibility(8);
                } else {
                    this.kWC.reset();
                    this.kWM.setText(aVar.linkUrl);
                    am.setViewTextColor(this.kWM, (int) R.color.cp_cont_b);
                    this.kWI.setVisibility(8);
                    this.kWJ.setVisibility(8);
                    this.kWM.setVisibility(0);
                    this.kWL.setVisibility(0);
                }
            } else if (aVar.kPQ == 2) {
                this.kWF.setVisibility(8);
                this.iZd.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.iZd.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(this.kWA.getPageContext().getPageActivity()) - ((int) this.kWA.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.iZd.setLayoutParams(layoutParams);
                am.setImageResource(this.kWG, R.drawable.icon_play_video);
                am.setBackgroundResource(this.kWH, R.drawable.btn_delete_url);
                this.OZ.startLoad(aVar.kPV, 10, false);
            } else {
                this.kWF.setVisibility(0);
                this.iZd.setVisibility(8);
                this.kWI.setVisibility(8);
                this.kWJ.setVisibility(8);
                this.kWM.setVisibility(0);
                this.kWL.setVisibility(0);
                this.kWC.reset();
                this.kWM.setText(aVar.linkUrl);
                am.setViewTextColor(this.kWM, (int) R.color.cp_cont_b);
            }
            cXt();
        }
    }

    public void f(TextWatcher textWatcher) {
        this.kWD.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.kWA != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.kWA.getPageContext(), i);
            }
            am.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
            this.kWD.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.kWD.setTextColor(am.getColor(R.color.cp_cont_f));
            am.setBackgroundColor(this.kWF, R.color.cp_bg_line_e);
            am.setViewTextColor(this.kWI, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kWJ, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.kWM, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.kWL, R.color.cp_bg_line_d);
            am.setViewTextColor(this.kWL, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.kWE, R.drawable.bg_link_invoke);
            am.setBackgroundColor(this.kWN, R.color.cp_bg_line_d);
            this.kWO.setHintTextColor(am.getColor(R.color.cp_cont_e));
            am.setViewTextColor(this.kWO, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kWS, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.kWQ, (int) R.color.cp_cont_e);
            am.setImageResource(this.kWG, R.drawable.home_ic_video);
            am.setBackgroundResource(this.kWK, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.kWP, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.kWH, R.drawable.btn_delete_url);
            cXt();
        }
    }

    public void cXt() {
        boolean z;
        if (StringUtils.isNull(cXu())) {
            z = this.kWF.getVisibility() == 0 || this.iZd.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            am.setNavbarTitleColor(this.kWB, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.kWB.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.kWB, R.color.cp_cont_d, 1);
        this.kWB.setEnabled(false);
    }

    public String cXu() {
        if (this.kWD == null || this.kWD.getText() == null) {
            return null;
        }
        return this.kWD.getText().toString();
    }

    public View bYm() {
        return this.cLe;
    }

    public View cXv() {
        return this.kWB;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText cXw() {
        return this.kWD;
    }

    public View cXx() {
        return this.kWK;
    }

    public View cXy() {
        return this.kWH;
    }

    public View cXz() {
        return this.kWF;
    }

    public View getVideoContainer() {
        return this.iZd;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.kWO.setText(aVar.linkUrl);
            this.kWO.setSelection(aVar.linkUrl.length());
        }
        this.kWO.requestFocus();
        l.showSoftKeyPad(this.kWA.getActivity(), this.kWO);
        this.kWN.setVisibility(0);
        this.kWR.setVisibility(0);
        this.kWE.setVisibility(8);
    }

    public void cXA() {
        this.kWN.setVisibility(8);
        this.kWR.setVisibility(8);
        this.kWE.setVisibility(0);
        l.hideSoftKeyPad(this.kWA.getActivity(), this.kWO);
    }

    public void ag(View.OnClickListener onClickListener) {
        this.kWN.setOnClickListener(onClickListener);
        this.kWR.setOnClickListener(onClickListener);
        this.kWE.setOnClickListener(onClickListener);
    }

    public String cXB() {
        if (this.kWO == null || this.kWO.getText() == null) {
            return null;
        }
        return this.kWO.getText().toString();
    }

    public void cXC() {
        if (this.kWS != null) {
            this.kWS.setText(R.string.tip_url_not_match);
            am.setViewTextColor(this.kWS, (int) R.color.cp_other_b);
        }
    }

    public void ah(View.OnClickListener onClickListener) {
        if (this.kWQ != null) {
            this.kWQ.setOnClickListener(onClickListener);
        }
    }

    public View cXD() {
        return this.kWN;
    }

    public void destroy() {
        if (this.kWD != null) {
            this.kWD.addTextChangedListener(null);
        }
        if (this.kWO != null) {
            this.kWO.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.bb(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bn(this.kWA.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.kWA.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.kWA.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.dGw.setCancelListener(null);
        this.dGw.setTipString(R.string.sending);
        this.dGw.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.dGw.setDialogVisiable(false);
    }
}
