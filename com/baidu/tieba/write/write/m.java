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
    private TbImageView alq;
    private View dUO;
    private com.baidu.tbadk.core.view.a eXp;
    private TextView imX;
    private RelativeLayout ldg;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private View nhA;
    private TextView nhB;
    private TextView nhC;
    private View nhD;
    private TextView nhE;
    private TextView nhF;
    private LinearLayout nhG;
    private EditText nhH;
    private View nhI;
    private TextView nhJ;
    private FrameLayout nhK;
    private TextView nhL;
    private WriteUrlActivity nhu;
    private TbImageView nhv;
    private EditText nhw;
    private View nhx;
    private LinearLayout nhy;
    private ImageView nhz;

    public m(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.dUO = null;
        this.eXp = null;
        if (writeUrlActivity != null) {
            this.nhu = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.nhu.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.nhu.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.dUO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.bkl().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dUO.getLayoutParams();
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.nhu.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.dUO != null && (this.dUO.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dUO.getLayoutParams();
                layoutParams2.width = -2;
                this.dUO.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.imX = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            ap.setViewTextColor(this.imX, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.imX.getLayoutParams();
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.nhu.getActivity(), R.dimen.ds16);
            this.imX.setLayoutParams(layoutParams3);
            this.imX.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.nhv = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.nhv.setDefaultResource(R.drawable.ic_post_url_n);
            this.nhv.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.nhv.setDefaultBgResource(R.color.black_alpha0);
            this.nhy = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.nhy.setOnClickListener(this.mClickListener);
            this.ldg = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.ldg.setOnClickListener(this.mClickListener);
            this.alq = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.alq.setDefaultErrorResource(0);
            this.alq.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.alq.setDefaultBgResource(R.color.black_alpha0);
            this.nhz = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.nhA = this.mRoot.findViewById(R.id.video_view_delete);
            this.nhA.setOnClickListener(this.mClickListener);
            this.nhB = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.nhC = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.nhD = this.mRoot.findViewById(R.id.view_delete);
            this.nhD.setOnClickListener(this.mClickListener);
            this.nhx = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.nhx.setOnClickListener(this.mClickListener);
            this.nhw = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.nhE = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.nhF = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.nhG = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.nhH = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.nhL = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.nhI = this.mRoot.findViewById(R.id.url_input_clear);
            this.nhJ = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.nhJ.setEnabled(false);
            this.nhK = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.nhH.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.m.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        m.this.nhI.setVisibility(8);
                        ap.setViewTextColor(m.this.nhJ, R.color.cp_cont_e);
                        m.this.nhJ.setEnabled(false);
                        return;
                    }
                    m.this.nhI.setVisibility(0);
                    ap.setViewTextColor(m.this.nhJ, R.color.cp_link_tip_a);
                    m.this.nhJ.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (m.this.nhL.getText().equals(m.this.nhu.getActivity().getString(R.string.tip_url_not_match))) {
                        m.this.dNk();
                    }
                }
            });
            this.nhI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    m.this.nhH.setText("");
                    m.this.nhI.setVisibility(8);
                    m.this.nhJ.setEnabled(false);
                }
            });
            this.eXp = new com.baidu.tbadk.core.view.a(this.nhu.getPageContext());
            dNk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNk() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.nhL.setText(R.string.tip_url_post);
        } else {
            this.nhL.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        ap.setViewTextColor(this.nhL, R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.nhu.setIsLoading(z);
        if (z) {
            this.nhy.setVisibility(0);
            this.ldg.setVisibility(8);
            this.nhv.startLoad(null, 10, false);
            this.nhB.setVisibility(8);
            this.nhC.setVisibility(8);
            this.nhE.setVisibility(8);
            this.nhF.setVisibility(0);
            ap.setViewTextColor(this.nhF, R.color.cp_cont_f);
            this.nhF.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.nhy.setVisibility(8);
            this.ldg.setVisibility(8);
            dNl();
        } else {
            if (aVar.mYK == 1) {
                this.nhy.setVisibility(0);
                this.ldg.setVisibility(8);
                if (aVar.mYJ) {
                    this.nhv.startLoad(aVar.mYM, 10, false);
                    this.nhB.setText(aVar.linkTitle);
                    this.nhC.setText(aVar.eba);
                    if (at.getRealSize(aVar.linkTitle) > 30) {
                        this.nhB.setMaxLines(2);
                        this.nhC.setMaxLines(1);
                    } else {
                        this.nhB.setMaxLines(1);
                        this.nhC.setMaxLines(2);
                    }
                    this.nhB.setVisibility(0);
                    this.nhC.setVisibility(0);
                    this.nhF.setVisibility(8);
                    this.nhE.setVisibility(8);
                } else {
                    this.nhv.reset();
                    this.nhF.setText(aVar.linkUrl);
                    ap.setViewTextColor(this.nhF, R.color.cp_cont_b);
                    this.nhB.setVisibility(8);
                    this.nhC.setVisibility(8);
                    this.nhF.setVisibility(0);
                    this.nhE.setVisibility(0);
                }
            } else if (aVar.mYK == 2) {
                this.nhy.setVisibility(8);
                this.ldg.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.ldg.getLayoutParams();
                layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(this.nhu.getPageContext().getPageActivity()) - ((int) this.nhu.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.ldg.setLayoutParams(layoutParams);
                ap.setImageResource(this.nhz, R.drawable.icon_play_video);
                ap.setBackgroundResource(this.nhA, R.drawable.btn_delete_url);
                this.alq.startLoad(aVar.mYP, 10, false);
            } else {
                this.nhy.setVisibility(0);
                this.ldg.setVisibility(8);
                this.nhB.setVisibility(8);
                this.nhC.setVisibility(8);
                this.nhF.setVisibility(0);
                this.nhE.setVisibility(0);
                this.nhv.reset();
                this.nhF.setText(aVar.linkUrl);
                ap.setViewTextColor(this.nhF, R.color.cp_cont_b);
            }
            dNl();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.nhw.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.nhu != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.nhu.getPageContext(), i);
            }
            ap.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
            this.nhw.setHintTextColor(ap.getColor(R.color.cp_cont_e));
            this.nhw.setTextColor(ap.getColor(R.color.cp_cont_f));
            ap.setBackgroundColor(this.nhy, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.nhB, R.color.cp_cont_b);
            ap.setViewTextColor(this.nhC, R.color.cp_cont_d);
            ap.setViewTextColor(this.nhF, R.color.cp_cont_b);
            ap.setBackgroundColor(this.nhE, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.nhE, R.color.cp_cont_d);
            ap.setBackgroundResource(this.nhx, R.drawable.bg_link_invoke);
            ap.setBackgroundColor(this.nhG, R.color.cp_bg_line_d);
            this.nhH.setHintTextColor(ap.getColor(R.color.cp_cont_e));
            ap.setViewTextColor(this.nhH, R.color.cp_cont_b);
            ap.setViewTextColor(this.nhL, R.color.cp_cont_d);
            ap.setViewTextColor(this.nhJ, R.color.cp_cont_e);
            ap.setImageResource(this.nhz, R.drawable.home_ic_video);
            ap.setBackgroundResource(this.nhD, R.drawable.btn_delete_url);
            ap.setBackgroundResource(this.nhI, R.drawable.btn_delete_url);
            ap.setBackgroundResource(this.nhA, R.drawable.btn_delete_url);
            dNl();
        }
    }

    public void dNl() {
        boolean z;
        if (StringUtils.isNull(dNm())) {
            z = this.nhy.getVisibility() == 0 || this.ldg.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            ap.setNavbarTitleColor(this.imX, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.imX.setEnabled(true);
            return;
        }
        ap.setViewTextColor(this.imX, R.color.cp_cont_d, 1);
        this.imX.setEnabled(false);
    }

    public String dNm() {
        if (this.nhw == null || this.nhw.getText() == null) {
            return null;
        }
        return this.nhw.getText().toString();
    }

    public View cLI() {
        return this.dUO;
    }

    public View dNn() {
        return this.imX;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText dNo() {
        return this.nhw;
    }

    public View dNp() {
        return this.nhD;
    }

    public View dNq() {
        return this.nhA;
    }

    public View dNr() {
        return this.nhy;
    }

    public View getVideoContainer() {
        return this.ldg;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.nhH.setText(aVar.linkUrl);
            this.nhH.setSelection(aVar.linkUrl.length());
        }
        this.nhH.requestFocus();
        com.baidu.adp.lib.util.l.showSoftKeyPad(this.nhu.getActivity(), this.nhH);
        this.nhG.setVisibility(0);
        this.nhK.setVisibility(0);
        this.nhx.setVisibility(8);
    }

    public void dNs() {
        this.nhG.setVisibility(8);
        this.nhK.setVisibility(8);
        this.nhx.setVisibility(0);
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this.nhu.getActivity(), this.nhH);
    }

    public void am(View.OnClickListener onClickListener) {
        this.nhG.setOnClickListener(onClickListener);
        this.nhK.setOnClickListener(onClickListener);
        this.nhx.setOnClickListener(onClickListener);
    }

    public String dNt() {
        if (this.nhH == null || this.nhH.getText() == null) {
            return null;
        }
        return this.nhH.getText().toString();
    }

    public void dNu() {
        if (this.nhL != null) {
            this.nhL.setText(R.string.tip_url_not_match);
            ap.setViewTextColor(this.nhL, R.color.cp_other_b);
        }
    }

    public void an(View.OnClickListener onClickListener) {
        if (this.nhJ != null) {
            this.nhJ.setOnClickListener(onClickListener);
        }
    }

    public View dNv() {
        return this.nhG;
    }

    public void destroy() {
        if (this.nhw != null) {
            this.nhw.addTextChangedListener(null);
        }
        if (this.nhH != null) {
            this.nhH.addTextChangedListener(null);
        }
    }

    public void n(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.bC(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bh(this.nhu.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.nhu.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.nhu.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.eXp.setCancelListener(null);
        this.eXp.setTipString(R.string.sending);
        this.eXp.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.eXp.setDialogVisiable(false);
    }
}
