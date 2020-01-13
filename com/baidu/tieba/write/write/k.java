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
    private RelativeLayout iVU;
    private WriteUrlActivity kTY;
    private TextView kTZ;
    private TbImageView kUa;
    private EditText kUb;
    private View kUc;
    private LinearLayout kUd;
    private ImageView kUe;
    private View kUf;
    private TextView kUg;
    private TextView kUh;
    private View kUi;
    private TextView kUj;
    private TextView kUk;
    private LinearLayout kUl;
    private EditText kUm;
    private View kUn;
    private TextView kUo;
    private FrameLayout kUp;
    private TextView kUq;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.cGO = null;
        this.dBR = null;
        if (writeUrlActivity != null) {
            this.kTY = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.kTY.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.kTY.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.cGO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.aEp().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cGO.getLayoutParams();
                layoutParams.leftMargin = l.getDimens(this.kTY.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.cGO != null && (this.cGO.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cGO.getLayoutParams();
                layoutParams2.width = -2;
                this.cGO.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.kTZ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            am.setViewTextColor(this.kTZ, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.kTZ.getLayoutParams();
            layoutParams3.rightMargin = l.getDimens(this.kTY.getActivity(), R.dimen.ds16);
            this.kTZ.setLayoutParams(layoutParams3);
            this.kTZ.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.kUa = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.kUa.setDefaultResource(R.drawable.ic_post_url_n);
            this.kUa.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.kUa.setDefaultBgResource(R.color.black_alpha0);
            this.kUd = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.kUd.setOnClickListener(this.mClickListener);
            this.iVU = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.iVU.setOnClickListener(this.mClickListener);
            this.Ow = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.Ow.setDefaultErrorResource(0);
            this.Ow.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.Ow.setDefaultBgResource(R.color.black_alpha0);
            this.kUe = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.kUf = this.mRoot.findViewById(R.id.video_view_delete);
            this.kUf.setOnClickListener(this.mClickListener);
            this.kUg = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.kUh = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.kUi = this.mRoot.findViewById(R.id.view_delete);
            this.kUi.setOnClickListener(this.mClickListener);
            this.kUc = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.kUc.setOnClickListener(this.mClickListener);
            this.kUb = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.kUj = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.kUk = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.kUl = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.kUm = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.kUq = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.kUn = this.mRoot.findViewById(R.id.url_input_clear);
            this.kUo = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.kUo.setEnabled(false);
            this.kUp = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.kUm.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.kUn.setVisibility(8);
                        am.setViewTextColor(k.this.kUo, (int) R.color.cp_cont_e);
                        k.this.kUo.setEnabled(false);
                        return;
                    }
                    k.this.kUn.setVisibility(0);
                    am.setViewTextColor(k.this.kUo, (int) R.color.cp_link_tip_a);
                    k.this.kUo.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.kUq.getText().equals(k.this.kTY.getActivity().getString(R.string.tip_url_not_match))) {
                        k.this.cVB();
                    }
                }
            });
            this.kUn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.kUm.setText("");
                    k.this.kUn.setVisibility(8);
                    k.this.kUo.setEnabled(false);
                }
            });
            this.dBR = new com.baidu.tbadk.core.view.a(this.kTY.getPageContext());
            cVB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVB() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.kUq.setText(R.string.tip_url_post);
        } else {
            this.kUq.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        am.setViewTextColor(this.kUq, (int) R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.kTY.setIsLoading(z);
        if (z) {
            this.kUd.setVisibility(0);
            this.iVU.setVisibility(8);
            this.kUa.startLoad(null, 10, false);
            this.kUg.setVisibility(8);
            this.kUh.setVisibility(8);
            this.kUj.setVisibility(8);
            this.kUk.setVisibility(0);
            am.setViewTextColor(this.kUk, (int) R.color.cp_cont_f);
            this.kUk.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.kUd.setVisibility(8);
            this.iVU.setVisibility(8);
            cVC();
        } else {
            if (aVar.kNh == 1) {
                this.kUd.setVisibility(0);
                this.iVU.setVisibility(8);
                if (aVar.kNg) {
                    this.kUa.startLoad(aVar.kNj, 10, false);
                    this.kUg.setText(aVar.linkTitle);
                    this.kUh.setText(aVar.cLm);
                    if (aq.getRealSize(aVar.linkTitle) > 30) {
                        this.kUg.setMaxLines(2);
                        this.kUh.setMaxLines(1);
                    } else {
                        this.kUg.setMaxLines(1);
                        this.kUh.setMaxLines(2);
                    }
                    this.kUg.setVisibility(0);
                    this.kUh.setVisibility(0);
                    this.kUk.setVisibility(8);
                    this.kUj.setVisibility(8);
                } else {
                    this.kUa.reset();
                    this.kUk.setText(aVar.linkUrl);
                    am.setViewTextColor(this.kUk, (int) R.color.cp_cont_b);
                    this.kUg.setVisibility(8);
                    this.kUh.setVisibility(8);
                    this.kUk.setVisibility(0);
                    this.kUj.setVisibility(0);
                }
            } else if (aVar.kNh == 2) {
                this.kUd.setVisibility(8);
                this.iVU.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.iVU.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(this.kTY.getPageContext().getPageActivity()) - ((int) this.kTY.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.iVU.setLayoutParams(layoutParams);
                am.setImageResource(this.kUe, R.drawable.icon_play_video);
                am.setBackgroundResource(this.kUf, R.drawable.btn_delete_url);
                this.Ow.startLoad(aVar.kNm, 10, false);
            } else {
                this.kUd.setVisibility(0);
                this.iVU.setVisibility(8);
                this.kUg.setVisibility(8);
                this.kUh.setVisibility(8);
                this.kUk.setVisibility(0);
                this.kUj.setVisibility(0);
                this.kUa.reset();
                this.kUk.setText(aVar.linkUrl);
                am.setViewTextColor(this.kUk, (int) R.color.cp_cont_b);
            }
            cVC();
        }
    }

    public void f(TextWatcher textWatcher) {
        this.kUb.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.kTY != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.kTY.getPageContext(), i);
            }
            am.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
            this.kUb.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.kUb.setTextColor(am.getColor(R.color.cp_cont_f));
            am.setBackgroundColor(this.kUd, R.color.cp_bg_line_e);
            am.setViewTextColor(this.kUg, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kUh, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.kUk, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.kUj, R.color.cp_bg_line_d);
            am.setViewTextColor(this.kUj, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.kUc, R.drawable.bg_link_invoke);
            am.setBackgroundColor(this.kUl, R.color.cp_bg_line_d);
            this.kUm.setHintTextColor(am.getColor(R.color.cp_cont_e));
            am.setViewTextColor(this.kUm, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kUq, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.kUo, (int) R.color.cp_cont_e);
            am.setImageResource(this.kUe, R.drawable.home_ic_video);
            am.setBackgroundResource(this.kUi, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.kUn, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.kUf, R.drawable.btn_delete_url);
            cVC();
        }
    }

    public void cVC() {
        boolean z;
        if (StringUtils.isNull(cVD())) {
            z = this.kUd.getVisibility() == 0 || this.iVU.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            am.setNavbarTitleColor(this.kTZ, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.kTZ.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.kTZ, R.color.cp_cont_d, 1);
        this.kTZ.setEnabled(false);
    }

    public String cVD() {
        if (this.kUb == null || this.kUb.getText() == null) {
            return null;
        }
        return this.kUb.getText().toString();
    }

    public View bWq() {
        return this.cGO;
    }

    public View cVE() {
        return this.kTZ;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText cVF() {
        return this.kUb;
    }

    public View cVG() {
        return this.kUi;
    }

    public View cVH() {
        return this.kUf;
    }

    public View cVI() {
        return this.kUd;
    }

    public View getVideoContainer() {
        return this.iVU;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.kUm.setText(aVar.linkUrl);
            this.kUm.setSelection(aVar.linkUrl.length());
        }
        this.kUm.requestFocus();
        l.showSoftKeyPad(this.kTY.getActivity(), this.kUm);
        this.kUl.setVisibility(0);
        this.kUp.setVisibility(0);
        this.kUc.setVisibility(8);
    }

    public void cVJ() {
        this.kUl.setVisibility(8);
        this.kUp.setVisibility(8);
        this.kUc.setVisibility(0);
        l.hideSoftKeyPad(this.kTY.getActivity(), this.kUm);
    }

    public void ag(View.OnClickListener onClickListener) {
        this.kUl.setOnClickListener(onClickListener);
        this.kUp.setOnClickListener(onClickListener);
        this.kUc.setOnClickListener(onClickListener);
    }

    public String cVK() {
        if (this.kUm == null || this.kUm.getText() == null) {
            return null;
        }
        return this.kUm.getText().toString();
    }

    public void cVL() {
        if (this.kUq != null) {
            this.kUq.setText(R.string.tip_url_not_match);
            am.setViewTextColor(this.kUq, (int) R.color.cp_other_b);
        }
    }

    public void ah(View.OnClickListener onClickListener) {
        if (this.kUo != null) {
            this.kUo.setOnClickListener(onClickListener);
        }
    }

    public View cVM() {
        return this.kUl;
    }

    public void destroy() {
        if (this.kUb != null) {
            this.kUb.addTextChangedListener(null);
        }
        if (this.kUm != null) {
            this.kUm.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.bc(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bn(this.kTY.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.kTY.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.kTY.showToast(errorString);
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
