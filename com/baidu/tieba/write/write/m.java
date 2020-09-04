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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes3.dex */
public class m {
    private TbImageView akQ;
    private View dSE;
    private com.baidu.tbadk.core.view.a eUz;
    private TextView ifW;
    private RelativeLayout kUC;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private LinearLayout mXA;
    private ImageView mXB;
    private View mXC;
    private TextView mXD;
    private TextView mXE;
    private View mXF;
    private TextView mXG;
    private TextView mXH;
    private LinearLayout mXI;
    private EditText mXJ;
    private View mXK;
    private TextView mXL;
    private FrameLayout mXM;
    private TextView mXN;
    private WriteUrlActivity mXw;
    private TbImageView mXx;
    private EditText mXy;
    private View mXz;

    public m(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.dSE = null;
        this.eUz = null;
        if (writeUrlActivity != null) {
            this.mXw = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.mXw.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.mXw.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.dSE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.bjq().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dSE.getLayoutParams();
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mXw.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.dSE != null && (this.dSE.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dSE.getLayoutParams();
                layoutParams2.width = -2;
                this.dSE.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.ifW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            ap.setViewTextColor(this.ifW, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.ifW.getLayoutParams();
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mXw.getActivity(), R.dimen.ds16);
            this.ifW.setLayoutParams(layoutParams3);
            this.ifW.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.mXx = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.mXx.setDefaultResource(R.drawable.ic_post_url_n);
            this.mXx.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.mXx.setDefaultBgResource(R.color.black_alpha0);
            this.mXA = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.mXA.setOnClickListener(this.mClickListener);
            this.kUC = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.kUC.setOnClickListener(this.mClickListener);
            this.akQ = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.akQ.setDefaultErrorResource(0);
            this.akQ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.akQ.setDefaultBgResource(R.color.black_alpha0);
            this.mXB = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.mXC = this.mRoot.findViewById(R.id.video_view_delete);
            this.mXC.setOnClickListener(this.mClickListener);
            this.mXD = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.mXE = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.mXF = this.mRoot.findViewById(R.id.view_delete);
            this.mXF.setOnClickListener(this.mClickListener);
            this.mXz = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.mXz.setOnClickListener(this.mClickListener);
            this.mXy = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.mXG = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.mXH = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.mXI = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.mXJ = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.mXN = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.mXK = this.mRoot.findViewById(R.id.url_input_clear);
            this.mXL = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.mXL.setEnabled(false);
            this.mXM = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.mXJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.m.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        m.this.mXK.setVisibility(8);
                        ap.setViewTextColor(m.this.mXL, R.color.cp_cont_e);
                        m.this.mXL.setEnabled(false);
                        return;
                    }
                    m.this.mXK.setVisibility(0);
                    ap.setViewTextColor(m.this.mXL, R.color.cp_link_tip_a);
                    m.this.mXL.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (m.this.mXN.getText().equals(m.this.mXw.getActivity().getString(R.string.tip_url_not_match))) {
                        m.this.dJm();
                    }
                }
            });
            this.mXK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    m.this.mXJ.setText("");
                    m.this.mXK.setVisibility(8);
                    m.this.mXL.setEnabled(false);
                }
            });
            this.eUz = new com.baidu.tbadk.core.view.a(this.mXw.getPageContext());
            dJm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJm() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.mXN.setText(R.string.tip_url_post);
        } else {
            this.mXN.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        ap.setViewTextColor(this.mXN, R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.mXw.setIsLoading(z);
        if (z) {
            this.mXA.setVisibility(0);
            this.kUC.setVisibility(8);
            this.mXx.startLoad(null, 10, false);
            this.mXD.setVisibility(8);
            this.mXE.setVisibility(8);
            this.mXG.setVisibility(8);
            this.mXH.setVisibility(0);
            ap.setViewTextColor(this.mXH, R.color.cp_cont_f);
            this.mXH.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.mXA.setVisibility(8);
            this.kUC.setVisibility(8);
            dJn();
        } else {
            if (aVar.mON == 1) {
                this.mXA.setVisibility(0);
                this.kUC.setVisibility(8);
                if (aVar.mOM) {
                    this.mXx.startLoad(aVar.mOP, 10, false);
                    this.mXD.setText(aVar.linkTitle);
                    this.mXE.setText(aVar.dYQ);
                    if (at.getRealSize(aVar.linkTitle) > 30) {
                        this.mXD.setMaxLines(2);
                        this.mXE.setMaxLines(1);
                    } else {
                        this.mXD.setMaxLines(1);
                        this.mXE.setMaxLines(2);
                    }
                    this.mXD.setVisibility(0);
                    this.mXE.setVisibility(0);
                    this.mXH.setVisibility(8);
                    this.mXG.setVisibility(8);
                } else {
                    this.mXx.reset();
                    this.mXH.setText(aVar.linkUrl);
                    ap.setViewTextColor(this.mXH, R.color.cp_cont_b);
                    this.mXD.setVisibility(8);
                    this.mXE.setVisibility(8);
                    this.mXH.setVisibility(0);
                    this.mXG.setVisibility(0);
                }
            } else if (aVar.mON == 2) {
                this.mXA.setVisibility(8);
                this.kUC.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.kUC.getLayoutParams();
                layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mXw.getPageContext().getPageActivity()) - ((int) this.mXw.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.kUC.setLayoutParams(layoutParams);
                ap.setImageResource(this.mXB, R.drawable.icon_play_video);
                ap.setBackgroundResource(this.mXC, R.drawable.btn_delete_url);
                this.akQ.startLoad(aVar.mOS, 10, false);
            } else {
                this.mXA.setVisibility(0);
                this.kUC.setVisibility(8);
                this.mXD.setVisibility(8);
                this.mXE.setVisibility(8);
                this.mXH.setVisibility(0);
                this.mXG.setVisibility(0);
                this.mXx.reset();
                this.mXH.setText(aVar.linkUrl);
                ap.setViewTextColor(this.mXH, R.color.cp_cont_b);
            }
            dJn();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.mXy.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.mXw != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mXw.getPageContext(), i);
            }
            ap.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
            this.mXy.setHintTextColor(ap.getColor(R.color.cp_cont_e));
            this.mXy.setTextColor(ap.getColor(R.color.cp_cont_f));
            ap.setBackgroundColor(this.mXA, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.mXD, R.color.cp_cont_b);
            ap.setViewTextColor(this.mXE, R.color.cp_cont_d);
            ap.setViewTextColor(this.mXH, R.color.cp_cont_b);
            ap.setBackgroundColor(this.mXG, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.mXG, R.color.cp_cont_d);
            ap.setBackgroundResource(this.mXz, R.drawable.bg_link_invoke);
            ap.setBackgroundColor(this.mXI, R.color.cp_bg_line_d);
            this.mXJ.setHintTextColor(ap.getColor(R.color.cp_cont_e));
            ap.setViewTextColor(this.mXJ, R.color.cp_cont_b);
            ap.setViewTextColor(this.mXN, R.color.cp_cont_d);
            ap.setViewTextColor(this.mXL, R.color.cp_cont_e);
            ap.setImageResource(this.mXB, R.drawable.home_ic_video);
            ap.setBackgroundResource(this.mXF, R.drawable.btn_delete_url);
            ap.setBackgroundResource(this.mXK, R.drawable.btn_delete_url);
            ap.setBackgroundResource(this.mXC, R.drawable.btn_delete_url);
            dJn();
        }
    }

    public void dJn() {
        boolean z;
        if (StringUtils.isNull(dJo())) {
            z = this.mXA.getVisibility() == 0 || this.kUC.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            ap.setNavbarTitleColor(this.ifW, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.ifW.setEnabled(true);
            return;
        }
        ap.setViewTextColor(this.ifW, R.color.cp_cont_d, 1);
        this.ifW.setEnabled(false);
    }

    public String dJo() {
        if (this.mXy == null || this.mXy.getText() == null) {
            return null;
        }
        return this.mXy.getText().toString();
    }

    public View cIc() {
        return this.dSE;
    }

    public View dJp() {
        return this.ifW;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText dJq() {
        return this.mXy;
    }

    public View dJr() {
        return this.mXF;
    }

    public View dJs() {
        return this.mXC;
    }

    public View dJt() {
        return this.mXA;
    }

    public View getVideoContainer() {
        return this.kUC;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.mXJ.setText(aVar.linkUrl);
            this.mXJ.setSelection(aVar.linkUrl.length());
        }
        this.mXJ.requestFocus();
        com.baidu.adp.lib.util.l.showSoftKeyPad(this.mXw.getActivity(), this.mXJ);
        this.mXI.setVisibility(0);
        this.mXM.setVisibility(0);
        this.mXz.setVisibility(8);
    }

    public void dJu() {
        this.mXI.setVisibility(8);
        this.mXM.setVisibility(8);
        this.mXz.setVisibility(0);
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this.mXw.getActivity(), this.mXJ);
    }

    public void am(View.OnClickListener onClickListener) {
        this.mXI.setOnClickListener(onClickListener);
        this.mXM.setOnClickListener(onClickListener);
        this.mXz.setOnClickListener(onClickListener);
    }

    public String dJv() {
        if (this.mXJ == null || this.mXJ.getText() == null) {
            return null;
        }
        return this.mXJ.getText().toString();
    }

    public void dJw() {
        if (this.mXN != null) {
            this.mXN.setText(R.string.tip_url_not_match);
            ap.setViewTextColor(this.mXN, R.color.cp_other_b);
        }
    }

    public void an(View.OnClickListener onClickListener) {
        if (this.mXL != null) {
            this.mXL.setOnClickListener(onClickListener);
        }
    }

    public View dJx() {
        return this.mXI;
    }

    public void destroy() {
        if (this.mXy != null) {
            this.mXy.addTextChangedListener(null);
        }
        if (this.mXJ != null) {
            this.mXJ.addTextChangedListener(null);
        }
    }

    public void m(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.by(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bb(this.mXw.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.mXw.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.mXw.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.eUz.setCancelListener(null);
        this.eUz.setTipString(R.string.sending);
        this.eUz.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.eUz.setDialogVisiable(false);
    }
}
