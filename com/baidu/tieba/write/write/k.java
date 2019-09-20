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
    private View bCC;
    private com.baidu.tbadk.core.view.b cDr;
    private TbImageView hiu;
    private RelativeLayout ifB;
    private WriteUrlActivity jYC;
    private TextView jYD;
    private TbImageView jYE;
    private EditText jYF;
    private View jYG;
    private LinearLayout jYH;
    private ImageView jYI;
    private View jYJ;
    private TextView jYK;
    private TextView jYL;
    private View jYM;
    private TextView jYN;
    private TextView jYO;
    private LinearLayout jYP;
    private EditText jYQ;
    private View jYR;
    private TextView jYS;
    private FrameLayout jYT;
    private TextView jYU;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.bCC = null;
        this.cDr = null;
        if (writeUrlActivity != null) {
            this.jYC = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.jYC.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.jYC.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.bCC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.ajv().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bCC.getLayoutParams();
                layoutParams.leftMargin = l.g(this.jYC.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.bCC != null && (this.bCC.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bCC.getLayoutParams();
                layoutParams2.width = -2;
                this.bCC.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.jYD = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            am.f(this.jYD, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.jYD.getLayoutParams();
            layoutParams3.rightMargin = l.g(this.jYC.getActivity(), R.dimen.ds16);
            this.jYD.setLayoutParams(layoutParams3);
            this.jYD.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.jYE = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.jYE.setDefaultResource(R.drawable.ic_post_url_n);
            this.jYE.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.jYE.setDefaultBgResource(R.color.black_alpha0);
            this.jYH = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.jYH.setOnClickListener(this.mClickListener);
            this.ifB = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.ifB.setOnClickListener(this.mClickListener);
            this.hiu = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.hiu.setDefaultErrorResource(0);
            this.hiu.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.hiu.setDefaultBgResource(R.color.black_alpha0);
            this.jYI = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.jYJ = this.mRoot.findViewById(R.id.video_view_delete);
            this.jYJ.setOnClickListener(this.mClickListener);
            this.jYK = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.jYL = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.jYM = this.mRoot.findViewById(R.id.view_delete);
            this.jYM.setOnClickListener(this.mClickListener);
            this.jYG = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.jYG.setOnClickListener(this.mClickListener);
            this.jYF = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.jYN = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.jYO = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.jYP = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.jYQ = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.jYU = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.jYR = this.mRoot.findViewById(R.id.url_input_clear);
            this.jYS = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.jYS.setEnabled(false);
            this.jYT = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.jYQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.jYR.setVisibility(8);
                        am.j(k.this.jYS, R.color.cp_cont_e);
                        k.this.jYS.setEnabled(false);
                        return;
                    }
                    k.this.jYR.setVisibility(0);
                    am.j(k.this.jYS, R.color.cp_link_tip_a);
                    k.this.jYS.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.jYU.getText().equals(k.this.jYC.getActivity().getString(R.string.tip_url_not_match))) {
                        k.this.cDP();
                    }
                }
            });
            this.jYR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.jYQ.setText("");
                    k.this.jYR.setVisibility(8);
                    k.this.jYS.setEnabled(false);
                }
            });
            this.cDr = new com.baidu.tbadk.core.view.b(this.jYC.getPageContext());
            cDP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDP() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.jYU.setText(R.string.tip_url_post);
        } else {
            this.jYU.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        am.j(this.jYU, R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.jYC.setIsLoading(z);
        if (z) {
            this.jYH.setVisibility(0);
            this.ifB.setVisibility(8);
            this.jYE.startLoad(null, 10, false);
            this.jYK.setVisibility(8);
            this.jYL.setVisibility(8);
            this.jYN.setVisibility(8);
            this.jYO.setVisibility(0);
            am.j(this.jYO, R.color.cp_cont_f);
            this.jYO.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.jYH.setVisibility(8);
            this.ifB.setVisibility(8);
            cDQ();
        } else {
            if (aVar.jRY == 1) {
                this.jYH.setVisibility(0);
                this.ifB.setVisibility(8);
                if (aVar.jRX) {
                    this.jYE.startLoad(aVar.jSa, 10, false);
                    this.jYK.setText(aVar.bHX);
                    this.jYL.setText(aVar.bHY);
                    if (aq.oe(aVar.bHX) > 30) {
                        this.jYK.setMaxLines(2);
                        this.jYL.setMaxLines(1);
                    } else {
                        this.jYK.setMaxLines(1);
                        this.jYL.setMaxLines(2);
                    }
                    this.jYK.setVisibility(0);
                    this.jYL.setVisibility(0);
                    this.jYO.setVisibility(8);
                    this.jYN.setVisibility(8);
                } else {
                    this.jYE.reset();
                    this.jYO.setText(aVar.linkUrl);
                    am.j(this.jYO, R.color.cp_cont_b);
                    this.jYK.setVisibility(8);
                    this.jYL.setVisibility(8);
                    this.jYO.setVisibility(0);
                    this.jYN.setVisibility(0);
                }
            } else if (aVar.jRY == 2) {
                this.jYH.setVisibility(8);
                this.ifB.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.ifB.getLayoutParams();
                layoutParams.height = ((l.af(this.jYC.getPageContext().getPageActivity()) - ((int) this.jYC.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.ifB.setLayoutParams(layoutParams);
                am.c(this.jYI, (int) R.drawable.icon_play_video);
                am.k(this.jYJ, R.drawable.btn_delete_url);
                this.hiu.startLoad(aVar.jSd, 10, false);
            } else {
                this.jYH.setVisibility(0);
                this.ifB.setVisibility(8);
                this.jYK.setVisibility(8);
                this.jYL.setVisibility(8);
                this.jYO.setVisibility(0);
                this.jYN.setVisibility(0);
                this.jYE.reset();
                this.jYO.setText(aVar.linkUrl);
                am.j(this.jYO, R.color.cp_cont_b);
            }
            cDQ();
        }
    }

    public void g(TextWatcher textWatcher) {
        this.jYF.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.jYC != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.jYC.getPageContext(), i);
            }
            am.l(this.mNavigationBar, R.color.cp_bg_line_d);
            am.l(this.mRoot, R.color.cp_bg_line_d);
            this.jYF.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.jYF.setTextColor(am.getColor(R.color.cp_cont_f));
            am.l(this.jYH, R.color.cp_bg_line_e);
            am.j(this.jYK, R.color.cp_cont_b);
            am.j(this.jYL, R.color.cp_cont_d);
            am.j(this.jYO, R.color.cp_cont_b);
            am.l(this.jYN, R.color.cp_bg_line_d);
            am.j(this.jYN, R.color.cp_cont_d);
            am.k(this.jYG, R.drawable.bg_link_invoke);
            am.l(this.jYP, R.color.cp_bg_line_d);
            this.jYQ.setHintTextColor(am.getColor(R.color.cp_cont_e));
            am.j(this.jYQ, R.color.cp_cont_b);
            am.j(this.jYU, R.color.cp_cont_d);
            am.j(this.jYS, R.color.cp_cont_e);
            am.c(this.jYI, (int) R.drawable.home_ic_video);
            am.k(this.jYM, R.drawable.btn_delete_url);
            am.k(this.jYR, R.drawable.btn_delete_url);
            am.k(this.jYJ, R.drawable.btn_delete_url);
            cDQ();
        }
    }

    public void cDQ() {
        boolean z;
        if (StringUtils.isNull(cDR())) {
            z = this.jYH.getVisibility() == 0 || this.ifB.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            am.e(this.jYD, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.jYD.setEnabled(true);
            return;
        }
        am.f(this.jYD, R.color.cp_cont_d, 1);
        this.jYD.setEnabled(false);
    }

    public String cDR() {
        if (this.jYF == null || this.jYF.getText() == null) {
            return null;
        }
        return this.jYF.getText().toString();
    }

    public View bHm() {
        return this.bCC;
    }

    public View cDS() {
        return this.jYD;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText cDT() {
        return this.jYF;
    }

    public View cDU() {
        return this.jYM;
    }

    public View cDV() {
        return this.jYJ;
    }

    public View cDW() {
        return this.jYH;
    }

    public View getVideoContainer() {
        return this.ifB;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.jYQ.setText(aVar.linkUrl);
            this.jYQ.setSelection(aVar.linkUrl.length());
        }
        this.jYQ.requestFocus();
        l.c(this.jYC.getActivity(), this.jYQ);
        this.jYP.setVisibility(0);
        this.jYT.setVisibility(0);
        this.jYG.setVisibility(8);
    }

    public void cDX() {
        this.jYP.setVisibility(8);
        this.jYT.setVisibility(8);
        this.jYG.setVisibility(0);
        l.b(this.jYC.getActivity(), this.jYQ);
    }

    public void ae(View.OnClickListener onClickListener) {
        this.jYP.setOnClickListener(onClickListener);
        this.jYT.setOnClickListener(onClickListener);
        this.jYG.setOnClickListener(onClickListener);
    }

    public String cDY() {
        if (this.jYQ == null || this.jYQ.getText() == null) {
            return null;
        }
        return this.jYQ.getText().toString();
    }

    public void cDZ() {
        if (this.jYU != null) {
            this.jYU.setText(R.string.tip_url_not_match);
            am.j(this.jYU, R.color.cp_other_b);
        }
    }

    public void af(View.OnClickListener onClickListener) {
        if (this.jYS != null) {
            this.jYS.setOnClickListener(onClickListener);
        }
    }

    public View cEa() {
        return this.jYP;
    }

    public void destroy() {
        if (this.jYF != null) {
            this.jYF.addTextChangedListener(null);
        }
        if (this.jYQ != null) {
            this.jYQ.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aQ(this.jYC.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.jYC.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.jYC.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.cDr.e(null);
        this.cDr.iC(R.string.sending);
        this.cDr.em(true);
    }

    public void closeLoadingDialog() {
        this.cDr.em(false);
    }
}
