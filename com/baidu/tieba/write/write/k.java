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
/* loaded from: classes10.dex */
public class k {
    private TbImageView Os;
    private View cGC;
    private com.baidu.tbadk.core.view.a dBH;
    private RelativeLayout iSr;
    private EditText kQA;
    private View kQB;
    private LinearLayout kQC;
    private ImageView kQD;
    private View kQE;
    private TextView kQF;
    private TextView kQG;
    private View kQH;
    private TextView kQI;
    private TextView kQJ;
    private LinearLayout kQK;
    private EditText kQL;
    private View kQM;
    private TextView kQN;
    private FrameLayout kQO;
    private TextView kQP;
    private WriteUrlActivity kQx;
    private TextView kQy;
    private TbImageView kQz;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.cGC = null;
        this.dBH = null;
        if (writeUrlActivity != null) {
            this.kQx = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.kQx.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.kQx.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.cGC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.aDW().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cGC.getLayoutParams();
                layoutParams.leftMargin = l.getDimens(this.kQx.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.cGC != null && (this.cGC.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cGC.getLayoutParams();
                layoutParams2.width = -2;
                this.cGC.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.kQy = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            am.setViewTextColor(this.kQy, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.kQy.getLayoutParams();
            layoutParams3.rightMargin = l.getDimens(this.kQx.getActivity(), R.dimen.ds16);
            this.kQy.setLayoutParams(layoutParams3);
            this.kQy.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.kQz = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.kQz.setDefaultResource(R.drawable.ic_post_url_n);
            this.kQz.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.kQz.setDefaultBgResource(R.color.black_alpha0);
            this.kQC = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.kQC.setOnClickListener(this.mClickListener);
            this.iSr = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.iSr.setOnClickListener(this.mClickListener);
            this.Os = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.Os.setDefaultErrorResource(0);
            this.Os.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.Os.setDefaultBgResource(R.color.black_alpha0);
            this.kQD = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.kQE = this.mRoot.findViewById(R.id.video_view_delete);
            this.kQE.setOnClickListener(this.mClickListener);
            this.kQF = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.kQG = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.kQH = this.mRoot.findViewById(R.id.view_delete);
            this.kQH.setOnClickListener(this.mClickListener);
            this.kQB = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.kQB.setOnClickListener(this.mClickListener);
            this.kQA = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.kQI = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.kQJ = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.kQK = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.kQL = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.kQP = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.kQM = this.mRoot.findViewById(R.id.url_input_clear);
            this.kQN = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.kQN.setEnabled(false);
            this.kQO = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.kQL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.kQM.setVisibility(8);
                        am.setViewTextColor(k.this.kQN, (int) R.color.cp_cont_e);
                        k.this.kQN.setEnabled(false);
                        return;
                    }
                    k.this.kQM.setVisibility(0);
                    am.setViewTextColor(k.this.kQN, (int) R.color.cp_link_tip_a);
                    k.this.kQN.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.kQP.getText().equals(k.this.kQx.getActivity().getString(R.string.tip_url_not_match))) {
                        k.this.cUy();
                    }
                }
            });
            this.kQM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.kQL.setText("");
                    k.this.kQM.setVisibility(8);
                    k.this.kQN.setEnabled(false);
                }
            });
            this.dBH = new com.baidu.tbadk.core.view.a(this.kQx.getPageContext());
            cUy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUy() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.kQP.setText(R.string.tip_url_post);
        } else {
            this.kQP.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        am.setViewTextColor(this.kQP, (int) R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.kQx.setIsLoading(z);
        if (z) {
            this.kQC.setVisibility(0);
            this.iSr.setVisibility(8);
            this.kQz.startLoad(null, 10, false);
            this.kQF.setVisibility(8);
            this.kQG.setVisibility(8);
            this.kQI.setVisibility(8);
            this.kQJ.setVisibility(0);
            am.setViewTextColor(this.kQJ, (int) R.color.cp_cont_f);
            this.kQJ.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.kQC.setVisibility(8);
            this.iSr.setVisibility(8);
            cUz();
        } else {
            if (aVar.kJG == 1) {
                this.kQC.setVisibility(0);
                this.iSr.setVisibility(8);
                if (aVar.kJF) {
                    this.kQz.startLoad(aVar.kJI, 10, false);
                    this.kQF.setText(aVar.linkTitle);
                    this.kQG.setText(aVar.cLc);
                    if (aq.getRealSize(aVar.linkTitle) > 30) {
                        this.kQF.setMaxLines(2);
                        this.kQG.setMaxLines(1);
                    } else {
                        this.kQF.setMaxLines(1);
                        this.kQG.setMaxLines(2);
                    }
                    this.kQF.setVisibility(0);
                    this.kQG.setVisibility(0);
                    this.kQJ.setVisibility(8);
                    this.kQI.setVisibility(8);
                } else {
                    this.kQz.reset();
                    this.kQJ.setText(aVar.linkUrl);
                    am.setViewTextColor(this.kQJ, (int) R.color.cp_cont_b);
                    this.kQF.setVisibility(8);
                    this.kQG.setVisibility(8);
                    this.kQJ.setVisibility(0);
                    this.kQI.setVisibility(0);
                }
            } else if (aVar.kJG == 2) {
                this.kQC.setVisibility(8);
                this.iSr.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.iSr.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(this.kQx.getPageContext().getPageActivity()) - ((int) this.kQx.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.iSr.setLayoutParams(layoutParams);
                am.setImageResource(this.kQD, R.drawable.icon_play_video);
                am.setBackgroundResource(this.kQE, R.drawable.btn_delete_url);
                this.Os.startLoad(aVar.kJL, 10, false);
            } else {
                this.kQC.setVisibility(0);
                this.iSr.setVisibility(8);
                this.kQF.setVisibility(8);
                this.kQG.setVisibility(8);
                this.kQJ.setVisibility(0);
                this.kQI.setVisibility(0);
                this.kQz.reset();
                this.kQJ.setText(aVar.linkUrl);
                am.setViewTextColor(this.kQJ, (int) R.color.cp_cont_b);
            }
            cUz();
        }
    }

    public void f(TextWatcher textWatcher) {
        this.kQA.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.kQx != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.kQx.getPageContext(), i);
            }
            am.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
            this.kQA.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.kQA.setTextColor(am.getColor(R.color.cp_cont_f));
            am.setBackgroundColor(this.kQC, R.color.cp_bg_line_e);
            am.setViewTextColor(this.kQF, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kQG, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.kQJ, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.kQI, R.color.cp_bg_line_d);
            am.setViewTextColor(this.kQI, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.kQB, R.drawable.bg_link_invoke);
            am.setBackgroundColor(this.kQK, R.color.cp_bg_line_d);
            this.kQL.setHintTextColor(am.getColor(R.color.cp_cont_e));
            am.setViewTextColor(this.kQL, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kQP, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.kQN, (int) R.color.cp_cont_e);
            am.setImageResource(this.kQD, R.drawable.home_ic_video);
            am.setBackgroundResource(this.kQH, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.kQM, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.kQE, R.drawable.btn_delete_url);
            cUz();
        }
    }

    public void cUz() {
        boolean z;
        if (StringUtils.isNull(cUA())) {
            z = this.kQC.getVisibility() == 0 || this.iSr.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            am.setNavbarTitleColor(this.kQy, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.kQy.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.kQy, R.color.cp_cont_d, 1);
        this.kQy.setEnabled(false);
    }

    public String cUA() {
        if (this.kQA == null || this.kQA.getText() == null) {
            return null;
        }
        return this.kQA.getText().toString();
    }

    public View bVh() {
        return this.cGC;
    }

    public View cUB() {
        return this.kQy;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText cUC() {
        return this.kQA;
    }

    public View cUD() {
        return this.kQH;
    }

    public View cUE() {
        return this.kQE;
    }

    public View cUF() {
        return this.kQC;
    }

    public View getVideoContainer() {
        return this.iSr;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.kQL.setText(aVar.linkUrl);
            this.kQL.setSelection(aVar.linkUrl.length());
        }
        this.kQL.requestFocus();
        l.showSoftKeyPad(this.kQx.getActivity(), this.kQL);
        this.kQK.setVisibility(0);
        this.kQO.setVisibility(0);
        this.kQB.setVisibility(8);
    }

    public void cUG() {
        this.kQK.setVisibility(8);
        this.kQO.setVisibility(8);
        this.kQB.setVisibility(0);
        l.hideSoftKeyPad(this.kQx.getActivity(), this.kQL);
    }

    public void ah(View.OnClickListener onClickListener) {
        this.kQK.setOnClickListener(onClickListener);
        this.kQO.setOnClickListener(onClickListener);
        this.kQB.setOnClickListener(onClickListener);
    }

    public String cUH() {
        if (this.kQL == null || this.kQL.getText() == null) {
            return null;
        }
        return this.kQL.getText().toString();
    }

    public void cUI() {
        if (this.kQP != null) {
            this.kQP.setText(R.string.tip_url_not_match);
            am.setViewTextColor(this.kQP, (int) R.color.cp_other_b);
        }
    }

    public void ai(View.OnClickListener onClickListener) {
        if (this.kQN != null) {
            this.kQN.setOnClickListener(onClickListener);
        }
    }

    public View cUJ() {
        return this.kQK;
    }

    public void destroy() {
        if (this.kQA != null) {
            this.kQA.addTextChangedListener(null);
        }
        if (this.kQL != null) {
            this.kQL.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.aW(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bj(this.kQx.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.kQx.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.kQx.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.dBH.setCancelListener(null);
        this.dBH.setTipString(R.string.sending);
        this.dBH.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.dBH.setDialogVisiable(false);
    }
}
