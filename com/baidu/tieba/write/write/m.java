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
    private TbImageView akO;
    private View dSA;
    private com.baidu.tbadk.core.view.a eUv;
    private TextView ifQ;
    private RelativeLayout kUv;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private WriteUrlActivity mXe;
    private TbImageView mXf;
    private EditText mXg;
    private View mXh;
    private LinearLayout mXi;
    private ImageView mXj;
    private View mXk;
    private TextView mXl;
    private TextView mXm;
    private View mXn;
    private TextView mXo;
    private TextView mXp;
    private LinearLayout mXq;
    private EditText mXr;
    private View mXs;
    private TextView mXt;
    private FrameLayout mXu;
    private TextView mXv;

    public m(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.dSA = null;
        this.eUv = null;
        if (writeUrlActivity != null) {
            this.mXe = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.mXe.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.mXe.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.dSA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.bjq().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dSA.getLayoutParams();
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mXe.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.dSA != null && (this.dSA.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dSA.getLayoutParams();
                layoutParams2.width = -2;
                this.dSA.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.ifQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            ap.setViewTextColor(this.ifQ, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.ifQ.getLayoutParams();
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mXe.getActivity(), R.dimen.ds16);
            this.ifQ.setLayoutParams(layoutParams3);
            this.ifQ.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.mXf = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.mXf.setDefaultResource(R.drawable.ic_post_url_n);
            this.mXf.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.mXf.setDefaultBgResource(R.color.black_alpha0);
            this.mXi = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.mXi.setOnClickListener(this.mClickListener);
            this.kUv = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.kUv.setOnClickListener(this.mClickListener);
            this.akO = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.akO.setDefaultErrorResource(0);
            this.akO.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.akO.setDefaultBgResource(R.color.black_alpha0);
            this.mXj = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.mXk = this.mRoot.findViewById(R.id.video_view_delete);
            this.mXk.setOnClickListener(this.mClickListener);
            this.mXl = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.mXm = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.mXn = this.mRoot.findViewById(R.id.view_delete);
            this.mXn.setOnClickListener(this.mClickListener);
            this.mXh = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.mXh.setOnClickListener(this.mClickListener);
            this.mXg = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.mXo = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.mXp = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.mXq = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.mXr = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.mXv = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.mXs = this.mRoot.findViewById(R.id.url_input_clear);
            this.mXt = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.mXt.setEnabled(false);
            this.mXu = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.mXr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.m.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        m.this.mXs.setVisibility(8);
                        ap.setViewTextColor(m.this.mXt, R.color.cp_cont_e);
                        m.this.mXt.setEnabled(false);
                        return;
                    }
                    m.this.mXs.setVisibility(0);
                    ap.setViewTextColor(m.this.mXt, R.color.cp_link_tip_a);
                    m.this.mXt.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (m.this.mXv.getText().equals(m.this.mXe.getActivity().getString(R.string.tip_url_not_match))) {
                        m.this.dJd();
                    }
                }
            });
            this.mXs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    m.this.mXr.setText("");
                    m.this.mXs.setVisibility(8);
                    m.this.mXt.setEnabled(false);
                }
            });
            this.eUv = new com.baidu.tbadk.core.view.a(this.mXe.getPageContext());
            dJd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJd() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.mXv.setText(R.string.tip_url_post);
        } else {
            this.mXv.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        ap.setViewTextColor(this.mXv, R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.mXe.setIsLoading(z);
        if (z) {
            this.mXi.setVisibility(0);
            this.kUv.setVisibility(8);
            this.mXf.startLoad(null, 10, false);
            this.mXl.setVisibility(8);
            this.mXm.setVisibility(8);
            this.mXo.setVisibility(8);
            this.mXp.setVisibility(0);
            ap.setViewTextColor(this.mXp, R.color.cp_cont_f);
            this.mXp.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.mXi.setVisibility(8);
            this.kUv.setVisibility(8);
            dJe();
        } else {
            if (aVar.mOv == 1) {
                this.mXi.setVisibility(0);
                this.kUv.setVisibility(8);
                if (aVar.mOu) {
                    this.mXf.startLoad(aVar.mOx, 10, false);
                    this.mXl.setText(aVar.linkTitle);
                    this.mXm.setText(aVar.dYM);
                    if (at.getRealSize(aVar.linkTitle) > 30) {
                        this.mXl.setMaxLines(2);
                        this.mXm.setMaxLines(1);
                    } else {
                        this.mXl.setMaxLines(1);
                        this.mXm.setMaxLines(2);
                    }
                    this.mXl.setVisibility(0);
                    this.mXm.setVisibility(0);
                    this.mXp.setVisibility(8);
                    this.mXo.setVisibility(8);
                } else {
                    this.mXf.reset();
                    this.mXp.setText(aVar.linkUrl);
                    ap.setViewTextColor(this.mXp, R.color.cp_cont_b);
                    this.mXl.setVisibility(8);
                    this.mXm.setVisibility(8);
                    this.mXp.setVisibility(0);
                    this.mXo.setVisibility(0);
                }
            } else if (aVar.mOv == 2) {
                this.mXi.setVisibility(8);
                this.kUv.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.kUv.getLayoutParams();
                layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mXe.getPageContext().getPageActivity()) - ((int) this.mXe.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.kUv.setLayoutParams(layoutParams);
                ap.setImageResource(this.mXj, R.drawable.icon_play_video);
                ap.setBackgroundResource(this.mXk, R.drawable.btn_delete_url);
                this.akO.startLoad(aVar.mOA, 10, false);
            } else {
                this.mXi.setVisibility(0);
                this.kUv.setVisibility(8);
                this.mXl.setVisibility(8);
                this.mXm.setVisibility(8);
                this.mXp.setVisibility(0);
                this.mXo.setVisibility(0);
                this.mXf.reset();
                this.mXp.setText(aVar.linkUrl);
                ap.setViewTextColor(this.mXp, R.color.cp_cont_b);
            }
            dJe();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.mXg.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.mXe != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mXe.getPageContext(), i);
            }
            ap.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
            this.mXg.setHintTextColor(ap.getColor(R.color.cp_cont_e));
            this.mXg.setTextColor(ap.getColor(R.color.cp_cont_f));
            ap.setBackgroundColor(this.mXi, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.mXl, R.color.cp_cont_b);
            ap.setViewTextColor(this.mXm, R.color.cp_cont_d);
            ap.setViewTextColor(this.mXp, R.color.cp_cont_b);
            ap.setBackgroundColor(this.mXo, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.mXo, R.color.cp_cont_d);
            ap.setBackgroundResource(this.mXh, R.drawable.bg_link_invoke);
            ap.setBackgroundColor(this.mXq, R.color.cp_bg_line_d);
            this.mXr.setHintTextColor(ap.getColor(R.color.cp_cont_e));
            ap.setViewTextColor(this.mXr, R.color.cp_cont_b);
            ap.setViewTextColor(this.mXv, R.color.cp_cont_d);
            ap.setViewTextColor(this.mXt, R.color.cp_cont_e);
            ap.setImageResource(this.mXj, R.drawable.home_ic_video);
            ap.setBackgroundResource(this.mXn, R.drawable.btn_delete_url);
            ap.setBackgroundResource(this.mXs, R.drawable.btn_delete_url);
            ap.setBackgroundResource(this.mXk, R.drawable.btn_delete_url);
            dJe();
        }
    }

    public void dJe() {
        boolean z;
        if (StringUtils.isNull(dJf())) {
            z = this.mXi.getVisibility() == 0 || this.kUv.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            ap.setNavbarTitleColor(this.ifQ, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.ifQ.setEnabled(true);
            return;
        }
        ap.setViewTextColor(this.ifQ, R.color.cp_cont_d, 1);
        this.ifQ.setEnabled(false);
    }

    public String dJf() {
        if (this.mXg == null || this.mXg.getText() == null) {
            return null;
        }
        return this.mXg.getText().toString();
    }

    public View cIb() {
        return this.dSA;
    }

    public View dJg() {
        return this.ifQ;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText dJh() {
        return this.mXg;
    }

    public View dJi() {
        return this.mXn;
    }

    public View dJj() {
        return this.mXk;
    }

    public View dJk() {
        return this.mXi;
    }

    public View getVideoContainer() {
        return this.kUv;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.mXr.setText(aVar.linkUrl);
            this.mXr.setSelection(aVar.linkUrl.length());
        }
        this.mXr.requestFocus();
        com.baidu.adp.lib.util.l.showSoftKeyPad(this.mXe.getActivity(), this.mXr);
        this.mXq.setVisibility(0);
        this.mXu.setVisibility(0);
        this.mXh.setVisibility(8);
    }

    public void dJl() {
        this.mXq.setVisibility(8);
        this.mXu.setVisibility(8);
        this.mXh.setVisibility(0);
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this.mXe.getActivity(), this.mXr);
    }

    public void am(View.OnClickListener onClickListener) {
        this.mXq.setOnClickListener(onClickListener);
        this.mXu.setOnClickListener(onClickListener);
        this.mXh.setOnClickListener(onClickListener);
    }

    public String dJm() {
        if (this.mXr == null || this.mXr.getText() == null) {
            return null;
        }
        return this.mXr.getText().toString();
    }

    public void dJn() {
        if (this.mXv != null) {
            this.mXv.setText(R.string.tip_url_not_match);
            ap.setViewTextColor(this.mXv, R.color.cp_other_b);
        }
    }

    public void an(View.OnClickListener onClickListener) {
        if (this.mXt != null) {
            this.mXt.setOnClickListener(onClickListener);
        }
    }

    public View dJo() {
        return this.mXq;
    }

    public void destroy() {
        if (this.mXg != null) {
            this.mXg.addTextChangedListener(null);
        }
        if (this.mXr != null) {
            this.mXr.addTextChangedListener(null);
        }
    }

    public void m(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.bz(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bb(this.mXe.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.mXe.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.mXe.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.eUv.setCancelListener(null);
        this.eUv.setTipString(R.string.sending);
        this.eUv.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.eUv.setDialogVisiable(false);
    }
}
