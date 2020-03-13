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
    private TbImageView OY;
    private View cKT;
    private com.baidu.tbadk.core.view.a dGg;
    private RelativeLayout iXC;
    private WriteUrlActivity kUX;
    private TextView kUY;
    private TbImageView kUZ;
    private EditText kVa;
    private View kVb;
    private LinearLayout kVc;
    private ImageView kVd;
    private View kVe;
    private TextView kVf;
    private TextView kVg;
    private View kVh;
    private TextView kVi;
    private TextView kVj;
    private LinearLayout kVk;
    private EditText kVl;
    private View kVm;
    private TextView kVn;
    private FrameLayout kVo;
    private TextView kVp;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.cKT = null;
        this.dGg = null;
        if (writeUrlActivity != null) {
            this.kUX = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.kUX.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.kUX.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.cKT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.aGC().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cKT.getLayoutParams();
                layoutParams.leftMargin = l.getDimens(this.kUX.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.cKT != null && (this.cKT.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cKT.getLayoutParams();
                layoutParams2.width = -2;
                this.cKT.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.kUY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            am.setViewTextColor(this.kUY, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.kUY.getLayoutParams();
            layoutParams3.rightMargin = l.getDimens(this.kUX.getActivity(), R.dimen.ds16);
            this.kUY.setLayoutParams(layoutParams3);
            this.kUY.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.kUZ = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.kUZ.setDefaultResource(R.drawable.ic_post_url_n);
            this.kUZ.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.kUZ.setDefaultBgResource(R.color.black_alpha0);
            this.kVc = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.kVc.setOnClickListener(this.mClickListener);
            this.iXC = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.iXC.setOnClickListener(this.mClickListener);
            this.OY = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.OY.setDefaultErrorResource(0);
            this.OY.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.OY.setDefaultBgResource(R.color.black_alpha0);
            this.kVd = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.kVe = this.mRoot.findViewById(R.id.video_view_delete);
            this.kVe.setOnClickListener(this.mClickListener);
            this.kVf = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.kVg = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.kVh = this.mRoot.findViewById(R.id.view_delete);
            this.kVh.setOnClickListener(this.mClickListener);
            this.kVb = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.kVb.setOnClickListener(this.mClickListener);
            this.kVa = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.kVi = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.kVj = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.kVk = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.kVl = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.kVp = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.kVm = this.mRoot.findViewById(R.id.url_input_clear);
            this.kVn = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.kVn.setEnabled(false);
            this.kVo = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.kVl.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.kVm.setVisibility(8);
                        am.setViewTextColor(k.this.kVn, (int) R.color.cp_cont_e);
                        k.this.kVn.setEnabled(false);
                        return;
                    }
                    k.this.kVm.setVisibility(0);
                    am.setViewTextColor(k.this.kVn, (int) R.color.cp_link_tip_a);
                    k.this.kVn.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.kVp.getText().equals(k.this.kUX.getActivity().getString(R.string.tip_url_not_match))) {
                        k.this.cWU();
                    }
                }
            });
            this.kVm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.kVl.setText("");
                    k.this.kVm.setVisibility(8);
                    k.this.kVn.setEnabled(false);
                }
            });
            this.dGg = new com.baidu.tbadk.core.view.a(this.kUX.getPageContext());
            cWU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWU() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.kVp.setText(R.string.tip_url_post);
        } else {
            this.kVp.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        am.setViewTextColor(this.kVp, (int) R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.kUX.setIsLoading(z);
        if (z) {
            this.kVc.setVisibility(0);
            this.iXC.setVisibility(8);
            this.kUZ.startLoad(null, 10, false);
            this.kVf.setVisibility(8);
            this.kVg.setVisibility(8);
            this.kVi.setVisibility(8);
            this.kVj.setVisibility(0);
            am.setViewTextColor(this.kVj, (int) R.color.cp_cont_f);
            this.kVj.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.kVc.setVisibility(8);
            this.iXC.setVisibility(8);
            cWV();
        } else {
            if (aVar.kOg == 1) {
                this.kVc.setVisibility(0);
                this.iXC.setVisibility(8);
                if (aVar.kOf) {
                    this.kUZ.startLoad(aVar.kOi, 10, false);
                    this.kVf.setText(aVar.linkTitle);
                    this.kVg.setText(aVar.cPr);
                    if (aq.getRealSize(aVar.linkTitle) > 30) {
                        this.kVf.setMaxLines(2);
                        this.kVg.setMaxLines(1);
                    } else {
                        this.kVf.setMaxLines(1);
                        this.kVg.setMaxLines(2);
                    }
                    this.kVf.setVisibility(0);
                    this.kVg.setVisibility(0);
                    this.kVj.setVisibility(8);
                    this.kVi.setVisibility(8);
                } else {
                    this.kUZ.reset();
                    this.kVj.setText(aVar.linkUrl);
                    am.setViewTextColor(this.kVj, (int) R.color.cp_cont_b);
                    this.kVf.setVisibility(8);
                    this.kVg.setVisibility(8);
                    this.kVj.setVisibility(0);
                    this.kVi.setVisibility(0);
                }
            } else if (aVar.kOg == 2) {
                this.kVc.setVisibility(8);
                this.iXC.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.iXC.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(this.kUX.getPageContext().getPageActivity()) - ((int) this.kUX.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.iXC.setLayoutParams(layoutParams);
                am.setImageResource(this.kVd, R.drawable.icon_play_video);
                am.setBackgroundResource(this.kVe, R.drawable.btn_delete_url);
                this.OY.startLoad(aVar.kOl, 10, false);
            } else {
                this.kVc.setVisibility(0);
                this.iXC.setVisibility(8);
                this.kVf.setVisibility(8);
                this.kVg.setVisibility(8);
                this.kVj.setVisibility(0);
                this.kVi.setVisibility(0);
                this.kUZ.reset();
                this.kVj.setText(aVar.linkUrl);
                am.setViewTextColor(this.kVj, (int) R.color.cp_cont_b);
            }
            cWV();
        }
    }

    public void f(TextWatcher textWatcher) {
        this.kVa.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.kUX != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.kUX.getPageContext(), i);
            }
            am.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
            this.kVa.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.kVa.setTextColor(am.getColor(R.color.cp_cont_f));
            am.setBackgroundColor(this.kVc, R.color.cp_bg_line_e);
            am.setViewTextColor(this.kVf, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kVg, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.kVj, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.kVi, R.color.cp_bg_line_d);
            am.setViewTextColor(this.kVi, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.kVb, R.drawable.bg_link_invoke);
            am.setBackgroundColor(this.kVk, R.color.cp_bg_line_d);
            this.kVl.setHintTextColor(am.getColor(R.color.cp_cont_e));
            am.setViewTextColor(this.kVl, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kVp, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.kVn, (int) R.color.cp_cont_e);
            am.setImageResource(this.kVd, R.drawable.home_ic_video);
            am.setBackgroundResource(this.kVh, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.kVm, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.kVe, R.drawable.btn_delete_url);
            cWV();
        }
    }

    public void cWV() {
        boolean z;
        if (StringUtils.isNull(cWW())) {
            z = this.kVc.getVisibility() == 0 || this.iXC.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            am.setNavbarTitleColor(this.kUY, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.kUY.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.kUY, R.color.cp_cont_d, 1);
        this.kUY.setEnabled(false);
    }

    public String cWW() {
        if (this.kVa == null || this.kVa.getText() == null) {
            return null;
        }
        return this.kVa.getText().toString();
    }

    public View bXU() {
        return this.cKT;
    }

    public View cWX() {
        return this.kUY;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText cWY() {
        return this.kVa;
    }

    public View cWZ() {
        return this.kVh;
    }

    public View cXa() {
        return this.kVe;
    }

    public View cXb() {
        return this.kVc;
    }

    public View getVideoContainer() {
        return this.iXC;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.kVl.setText(aVar.linkUrl);
            this.kVl.setSelection(aVar.linkUrl.length());
        }
        this.kVl.requestFocus();
        l.showSoftKeyPad(this.kUX.getActivity(), this.kVl);
        this.kVk.setVisibility(0);
        this.kVo.setVisibility(0);
        this.kVb.setVisibility(8);
    }

    public void cXc() {
        this.kVk.setVisibility(8);
        this.kVo.setVisibility(8);
        this.kVb.setVisibility(0);
        l.hideSoftKeyPad(this.kUX.getActivity(), this.kVl);
    }

    public void ag(View.OnClickListener onClickListener) {
        this.kVk.setOnClickListener(onClickListener);
        this.kVo.setOnClickListener(onClickListener);
        this.kVb.setOnClickListener(onClickListener);
    }

    public String cXd() {
        if (this.kVl == null || this.kVl.getText() == null) {
            return null;
        }
        return this.kVl.getText().toString();
    }

    public void cXe() {
        if (this.kVp != null) {
            this.kVp.setText(R.string.tip_url_not_match);
            am.setViewTextColor(this.kVp, (int) R.color.cp_other_b);
        }
    }

    public void ah(View.OnClickListener onClickListener) {
        if (this.kVn != null) {
            this.kVn.setOnClickListener(onClickListener);
        }
    }

    public View cXf() {
        return this.kVk;
    }

    public void destroy() {
        if (this.kVa != null) {
            this.kVa.addTextChangedListener(null);
        }
        if (this.kVl != null) {
            this.kVl.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.bb(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bn(this.kUX.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.kUX.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.kUX.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.dGg.setCancelListener(null);
        this.dGg.setTipString(R.string.sending);
        this.dGg.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.dGg.setDialogVisiable(false);
    }
}
