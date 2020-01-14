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
/* loaded from: classes11.dex */
public class k {
    private TbImageView Ow;
    private View cGO;
    private com.baidu.tbadk.core.view.a dBR;
    private RelativeLayout iVZ;
    private WriteUrlActivity kUd;
    private TextView kUe;
    private TbImageView kUf;
    private EditText kUg;
    private View kUh;
    private LinearLayout kUi;
    private ImageView kUj;
    private View kUk;
    private TextView kUl;
    private TextView kUm;
    private View kUn;
    private TextView kUo;
    private TextView kUp;
    private LinearLayout kUq;
    private EditText kUr;
    private View kUs;
    private TextView kUt;
    private FrameLayout kUu;
    private TextView kUv;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.cGO = null;
        this.dBR = null;
        if (writeUrlActivity != null) {
            this.kUd = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.kUd.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.kUd.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.cGO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.aEp().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cGO.getLayoutParams();
                layoutParams.leftMargin = l.getDimens(this.kUd.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.cGO != null && (this.cGO.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cGO.getLayoutParams();
                layoutParams2.width = -2;
                this.cGO.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.kUe = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            am.setViewTextColor(this.kUe, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.kUe.getLayoutParams();
            layoutParams3.rightMargin = l.getDimens(this.kUd.getActivity(), R.dimen.ds16);
            this.kUe.setLayoutParams(layoutParams3);
            this.kUe.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.kUf = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.kUf.setDefaultResource(R.drawable.ic_post_url_n);
            this.kUf.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.kUf.setDefaultBgResource(R.color.black_alpha0);
            this.kUi = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.kUi.setOnClickListener(this.mClickListener);
            this.iVZ = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.iVZ.setOnClickListener(this.mClickListener);
            this.Ow = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.Ow.setDefaultErrorResource(0);
            this.Ow.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.Ow.setDefaultBgResource(R.color.black_alpha0);
            this.kUj = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.kUk = this.mRoot.findViewById(R.id.video_view_delete);
            this.kUk.setOnClickListener(this.mClickListener);
            this.kUl = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.kUm = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.kUn = this.mRoot.findViewById(R.id.view_delete);
            this.kUn.setOnClickListener(this.mClickListener);
            this.kUh = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.kUh.setOnClickListener(this.mClickListener);
            this.kUg = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.kUo = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.kUp = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.kUq = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.kUr = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.kUv = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.kUs = this.mRoot.findViewById(R.id.url_input_clear);
            this.kUt = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.kUt.setEnabled(false);
            this.kUu = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.kUr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.kUs.setVisibility(8);
                        am.setViewTextColor(k.this.kUt, (int) R.color.cp_cont_e);
                        k.this.kUt.setEnabled(false);
                        return;
                    }
                    k.this.kUs.setVisibility(0);
                    am.setViewTextColor(k.this.kUt, (int) R.color.cp_link_tip_a);
                    k.this.kUt.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.kUv.getText().equals(k.this.kUd.getActivity().getString(R.string.tip_url_not_match))) {
                        k.this.cVD();
                    }
                }
            });
            this.kUs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.kUr.setText("");
                    k.this.kUs.setVisibility(8);
                    k.this.kUt.setEnabled(false);
                }
            });
            this.dBR = new com.baidu.tbadk.core.view.a(this.kUd.getPageContext());
            cVD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVD() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.kUv.setText(R.string.tip_url_post);
        } else {
            this.kUv.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        am.setViewTextColor(this.kUv, (int) R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.kUd.setIsLoading(z);
        if (z) {
            this.kUi.setVisibility(0);
            this.iVZ.setVisibility(8);
            this.kUf.startLoad(null, 10, false);
            this.kUl.setVisibility(8);
            this.kUm.setVisibility(8);
            this.kUo.setVisibility(8);
            this.kUp.setVisibility(0);
            am.setViewTextColor(this.kUp, (int) R.color.cp_cont_f);
            this.kUp.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.kUi.setVisibility(8);
            this.iVZ.setVisibility(8);
            cVE();
        } else {
            if (aVar.kNm == 1) {
                this.kUi.setVisibility(0);
                this.iVZ.setVisibility(8);
                if (aVar.kNl) {
                    this.kUf.startLoad(aVar.kNo, 10, false);
                    this.kUl.setText(aVar.linkTitle);
                    this.kUm.setText(aVar.cLm);
                    if (aq.getRealSize(aVar.linkTitle) > 30) {
                        this.kUl.setMaxLines(2);
                        this.kUm.setMaxLines(1);
                    } else {
                        this.kUl.setMaxLines(1);
                        this.kUm.setMaxLines(2);
                    }
                    this.kUl.setVisibility(0);
                    this.kUm.setVisibility(0);
                    this.kUp.setVisibility(8);
                    this.kUo.setVisibility(8);
                } else {
                    this.kUf.reset();
                    this.kUp.setText(aVar.linkUrl);
                    am.setViewTextColor(this.kUp, (int) R.color.cp_cont_b);
                    this.kUl.setVisibility(8);
                    this.kUm.setVisibility(8);
                    this.kUp.setVisibility(0);
                    this.kUo.setVisibility(0);
                }
            } else if (aVar.kNm == 2) {
                this.kUi.setVisibility(8);
                this.iVZ.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.iVZ.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(this.kUd.getPageContext().getPageActivity()) - ((int) this.kUd.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.iVZ.setLayoutParams(layoutParams);
                am.setImageResource(this.kUj, R.drawable.icon_play_video);
                am.setBackgroundResource(this.kUk, R.drawable.btn_delete_url);
                this.Ow.startLoad(aVar.kNr, 10, false);
            } else {
                this.kUi.setVisibility(0);
                this.iVZ.setVisibility(8);
                this.kUl.setVisibility(8);
                this.kUm.setVisibility(8);
                this.kUp.setVisibility(0);
                this.kUo.setVisibility(0);
                this.kUf.reset();
                this.kUp.setText(aVar.linkUrl);
                am.setViewTextColor(this.kUp, (int) R.color.cp_cont_b);
            }
            cVE();
        }
    }

    public void f(TextWatcher textWatcher) {
        this.kUg.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.kUd != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.kUd.getPageContext(), i);
            }
            am.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
            this.kUg.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.kUg.setTextColor(am.getColor(R.color.cp_cont_f));
            am.setBackgroundColor(this.kUi, R.color.cp_bg_line_e);
            am.setViewTextColor(this.kUl, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kUm, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.kUp, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.kUo, R.color.cp_bg_line_d);
            am.setViewTextColor(this.kUo, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.kUh, R.drawable.bg_link_invoke);
            am.setBackgroundColor(this.kUq, R.color.cp_bg_line_d);
            this.kUr.setHintTextColor(am.getColor(R.color.cp_cont_e));
            am.setViewTextColor(this.kUr, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kUv, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.kUt, (int) R.color.cp_cont_e);
            am.setImageResource(this.kUj, R.drawable.home_ic_video);
            am.setBackgroundResource(this.kUn, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.kUs, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.kUk, R.drawable.btn_delete_url);
            cVE();
        }
    }

    public void cVE() {
        boolean z;
        if (StringUtils.isNull(cVF())) {
            z = this.kUi.getVisibility() == 0 || this.iVZ.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            am.setNavbarTitleColor(this.kUe, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.kUe.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.kUe, R.color.cp_cont_d, 1);
        this.kUe.setEnabled(false);
    }

    public String cVF() {
        if (this.kUg == null || this.kUg.getText() == null) {
            return null;
        }
        return this.kUg.getText().toString();
    }

    public View bWq() {
        return this.cGO;
    }

    public View cVG() {
        return this.kUe;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText cVH() {
        return this.kUg;
    }

    public View cVI() {
        return this.kUn;
    }

    public View cVJ() {
        return this.kUk;
    }

    public View cVK() {
        return this.kUi;
    }

    public View getVideoContainer() {
        return this.iVZ;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.kUr.setText(aVar.linkUrl);
            this.kUr.setSelection(aVar.linkUrl.length());
        }
        this.kUr.requestFocus();
        l.showSoftKeyPad(this.kUd.getActivity(), this.kUr);
        this.kUq.setVisibility(0);
        this.kUu.setVisibility(0);
        this.kUh.setVisibility(8);
    }

    public void cVL() {
        this.kUq.setVisibility(8);
        this.kUu.setVisibility(8);
        this.kUh.setVisibility(0);
        l.hideSoftKeyPad(this.kUd.getActivity(), this.kUr);
    }

    public void ag(View.OnClickListener onClickListener) {
        this.kUq.setOnClickListener(onClickListener);
        this.kUu.setOnClickListener(onClickListener);
        this.kUh.setOnClickListener(onClickListener);
    }

    public String cVM() {
        if (this.kUr == null || this.kUr.getText() == null) {
            return null;
        }
        return this.kUr.getText().toString();
    }

    public void cVN() {
        if (this.kUv != null) {
            this.kUv.setText(R.string.tip_url_not_match);
            am.setViewTextColor(this.kUv, (int) R.color.cp_other_b);
        }
    }

    public void ah(View.OnClickListener onClickListener) {
        if (this.kUt != null) {
            this.kUt.setOnClickListener(onClickListener);
        }
    }

    public View cVO() {
        return this.kUq;
    }

    public void destroy() {
        if (this.kUg != null) {
            this.kUg.addTextChangedListener(null);
        }
        if (this.kUr != null) {
            this.kUr.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.bc(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bn(this.kUd.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.kUd.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.kUd.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.dBR.setCancelListener(null);
        this.dBR.setTipString(R.string.sending);
        this.dBR.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.dBR.setDialogVisiable(false);
    }
}
