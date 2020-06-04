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
/* loaded from: classes2.dex */
public class k {
    private TbImageView aii;
    private View dyp;
    private com.baidu.tbadk.core.view.a euw;
    private TextView hyS;
    private RelativeLayout kcg;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private WriteUrlActivity mbh;
    private TbImageView mbi;
    private EditText mbj;
    private View mbk;
    private LinearLayout mbl;
    private ImageView mbm;
    private View mbn;
    private TextView mbo;
    private TextView mbp;
    private View mbq;
    private TextView mbr;
    private TextView mbs;
    private LinearLayout mbt;
    private EditText mbu;
    private View mbv;
    private TextView mbw;
    private FrameLayout mbx;
    private TextView mby;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.dyp = null;
        this.euw = null;
        if (writeUrlActivity != null) {
            this.mbh = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.mbh.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.mbh.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.dyp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.aUW().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dyp.getLayoutParams();
                layoutParams.leftMargin = l.getDimens(this.mbh.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.dyp != null && (this.dyp.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dyp.getLayoutParams();
                layoutParams2.width = -2;
                this.dyp.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.hyS = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            am.setViewTextColor(this.hyS, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hyS.getLayoutParams();
            layoutParams3.rightMargin = l.getDimens(this.mbh.getActivity(), R.dimen.ds16);
            this.hyS.setLayoutParams(layoutParams3);
            this.hyS.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.mbi = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.mbi.setDefaultResource(R.drawable.ic_post_url_n);
            this.mbi.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.mbi.setDefaultBgResource(R.color.black_alpha0);
            this.mbl = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.mbl.setOnClickListener(this.mClickListener);
            this.kcg = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.kcg.setOnClickListener(this.mClickListener);
            this.aii = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.aii.setDefaultErrorResource(0);
            this.aii.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.aii.setDefaultBgResource(R.color.black_alpha0);
            this.mbm = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.mbn = this.mRoot.findViewById(R.id.video_view_delete);
            this.mbn.setOnClickListener(this.mClickListener);
            this.mbo = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.mbp = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.mbq = this.mRoot.findViewById(R.id.view_delete);
            this.mbq.setOnClickListener(this.mClickListener);
            this.mbk = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.mbk.setOnClickListener(this.mClickListener);
            this.mbj = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.mbr = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.mbs = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.mbt = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.mbu = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.mby = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.mbv = this.mRoot.findViewById(R.id.url_input_clear);
            this.mbw = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.mbw.setEnabled(false);
            this.mbx = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.mbu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.mbv.setVisibility(8);
                        am.setViewTextColor(k.this.mbw, (int) R.color.cp_cont_e);
                        k.this.mbw.setEnabled(false);
                        return;
                    }
                    k.this.mbv.setVisibility(0);
                    am.setViewTextColor(k.this.mbw, (int) R.color.cp_link_tip_a);
                    k.this.mbw.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.mby.getText().equals(k.this.mbh.getActivity().getString(R.string.tip_url_not_match))) {
                        k.this.dpD();
                    }
                }
            });
            this.mbv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.mbu.setText("");
                    k.this.mbv.setVisibility(8);
                    k.this.mbw.setEnabled(false);
                }
            });
            this.euw = new com.baidu.tbadk.core.view.a(this.mbh.getPageContext());
            dpD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpD() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.mby.setText(R.string.tip_url_post);
        } else {
            this.mby.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        am.setViewTextColor(this.mby, (int) R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.mbh.setIsLoading(z);
        if (z) {
            this.mbl.setVisibility(0);
            this.kcg.setVisibility(8);
            this.mbi.startLoad(null, 10, false);
            this.mbo.setVisibility(8);
            this.mbp.setVisibility(8);
            this.mbr.setVisibility(8);
            this.mbs.setVisibility(0);
            am.setViewTextColor(this.mbs, (int) R.color.cp_cont_f);
            this.mbs.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.mbl.setVisibility(8);
            this.kcg.setVisibility(8);
            dpE();
        } else {
            if (aVar.lTM == 1) {
                this.mbl.setVisibility(0);
                this.kcg.setVisibility(8);
                if (aVar.lTL) {
                    this.mbi.startLoad(aVar.lTO, 10, false);
                    this.mbo.setText(aVar.linkTitle);
                    this.mbp.setText(aVar.dCN);
                    if (aq.getRealSize(aVar.linkTitle) > 30) {
                        this.mbo.setMaxLines(2);
                        this.mbp.setMaxLines(1);
                    } else {
                        this.mbo.setMaxLines(1);
                        this.mbp.setMaxLines(2);
                    }
                    this.mbo.setVisibility(0);
                    this.mbp.setVisibility(0);
                    this.mbs.setVisibility(8);
                    this.mbr.setVisibility(8);
                } else {
                    this.mbi.reset();
                    this.mbs.setText(aVar.linkUrl);
                    am.setViewTextColor(this.mbs, (int) R.color.cp_cont_b);
                    this.mbo.setVisibility(8);
                    this.mbp.setVisibility(8);
                    this.mbs.setVisibility(0);
                    this.mbr.setVisibility(0);
                }
            } else if (aVar.lTM == 2) {
                this.mbl.setVisibility(8);
                this.kcg.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.kcg.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(this.mbh.getPageContext().getPageActivity()) - ((int) this.mbh.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.kcg.setLayoutParams(layoutParams);
                am.setImageResource(this.mbm, R.drawable.icon_play_video);
                am.setBackgroundResource(this.mbn, R.drawable.btn_delete_url);
                this.aii.startLoad(aVar.lTR, 10, false);
            } else {
                this.mbl.setVisibility(0);
                this.kcg.setVisibility(8);
                this.mbo.setVisibility(8);
                this.mbp.setVisibility(8);
                this.mbs.setVisibility(0);
                this.mbr.setVisibility(0);
                this.mbi.reset();
                this.mbs.setText(aVar.linkUrl);
                am.setViewTextColor(this.mbs, (int) R.color.cp_cont_b);
            }
            dpE();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.mbj.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.mbh != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mbh.getPageContext(), i);
            }
            am.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
            this.mbj.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.mbj.setTextColor(am.getColor(R.color.cp_cont_f));
            am.setBackgroundColor(this.mbl, R.color.cp_bg_line_e);
            am.setViewTextColor(this.mbo, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.mbp, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.mbs, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.mbr, R.color.cp_bg_line_d);
            am.setViewTextColor(this.mbr, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.mbk, R.drawable.bg_link_invoke);
            am.setBackgroundColor(this.mbt, R.color.cp_bg_line_d);
            this.mbu.setHintTextColor(am.getColor(R.color.cp_cont_e));
            am.setViewTextColor(this.mbu, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.mby, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.mbw, (int) R.color.cp_cont_e);
            am.setImageResource(this.mbm, R.drawable.home_ic_video);
            am.setBackgroundResource(this.mbq, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.mbv, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.mbn, R.drawable.btn_delete_url);
            dpE();
        }
    }

    public void dpE() {
        boolean z;
        if (StringUtils.isNull(dpF())) {
            z = this.mbl.getVisibility() == 0 || this.kcg.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            am.setNavbarTitleColor(this.hyS, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.hyS.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.hyS, R.color.cp_cont_d, 1);
        this.hyS.setEnabled(false);
    }

    public String dpF() {
        if (this.mbj == null || this.mbj.getText() == null) {
            return null;
        }
        return this.mbj.getText().toString();
    }

    public View cps() {
        return this.dyp;
    }

    public View dpG() {
        return this.hyS;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText dpH() {
        return this.mbj;
    }

    public View dpI() {
        return this.mbq;
    }

    public View dpJ() {
        return this.mbn;
    }

    public View dpK() {
        return this.mbl;
    }

    public View getVideoContainer() {
        return this.kcg;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.mbu.setText(aVar.linkUrl);
            this.mbu.setSelection(aVar.linkUrl.length());
        }
        this.mbu.requestFocus();
        l.showSoftKeyPad(this.mbh.getActivity(), this.mbu);
        this.mbt.setVisibility(0);
        this.mbx.setVisibility(0);
        this.mbk.setVisibility(8);
    }

    public void dpL() {
        this.mbt.setVisibility(8);
        this.mbx.setVisibility(8);
        this.mbk.setVisibility(0);
        l.hideSoftKeyPad(this.mbh.getActivity(), this.mbu);
    }

    public void aj(View.OnClickListener onClickListener) {
        this.mbt.setOnClickListener(onClickListener);
        this.mbx.setOnClickListener(onClickListener);
        this.mbk.setOnClickListener(onClickListener);
    }

    public String dpM() {
        if (this.mbu == null || this.mbu.getText() == null) {
            return null;
        }
        return this.mbu.getText().toString();
    }

    public void dpN() {
        if (this.mby != null) {
            this.mby.setText(R.string.tip_url_not_match);
            am.setViewTextColor(this.mby, (int) R.color.cp_other_b);
        }
    }

    public void ak(View.OnClickListener onClickListener) {
        if (this.mbw != null) {
            this.mbw.setOnClickListener(onClickListener);
        }
    }

    public View dpO() {
        return this.mbt;
    }

    public void destroy() {
        if (this.mbj != null) {
            this.mbj.addTextChangedListener(null);
        }
        if (this.mbu != null) {
            this.mbu.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.bv(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aX(this.mbh.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.mbh.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.mbh.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.euw.setCancelListener(null);
        this.euw.setTipString(R.string.sending);
        this.euw.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.euw.setDialogVisiable(false);
    }
}
