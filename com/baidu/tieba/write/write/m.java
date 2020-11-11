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
    private TbImageView alJ;
    private View evh;
    private com.baidu.tbadk.core.view.a fxS;
    private TextView iUk;
    private RelativeLayout lKS;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView nPA;
    private FrameLayout nPB;
    private TextView nPC;
    private WriteUrlActivity nPl;
    private TbImageView nPm;
    private EditText nPn;
    private View nPo;
    private LinearLayout nPp;
    private ImageView nPq;
    private View nPr;
    private TextView nPs;
    private TextView nPt;
    private View nPu;
    private TextView nPv;
    private TextView nPw;
    private LinearLayout nPx;
    private EditText nPy;
    private View nPz;

    public m(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.evh = null;
        this.fxS = null;
        if (writeUrlActivity != null) {
            this.nPl = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.nPl.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.nPl.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.evh = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.brn().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.evh.getLayoutParams();
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.nPl.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.evh != null && (this.evh.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.evh.getLayoutParams();
                layoutParams2.width = -2;
                this.evh.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.iUk = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            ap.setViewTextColor(this.iUk, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.iUk.getLayoutParams();
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.nPl.getActivity(), R.dimen.ds16);
            this.iUk.setLayoutParams(layoutParams3);
            this.iUk.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.nPm = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.nPm.setDefaultResource(R.drawable.ic_post_url_n);
            this.nPm.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.nPm.setDefaultBgResource(R.color.black_alpha0);
            this.nPp = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.nPp.setOnClickListener(this.mClickListener);
            this.lKS = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.lKS.setOnClickListener(this.mClickListener);
            this.alJ = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.alJ.setDefaultErrorResource(0);
            this.alJ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.alJ.setDefaultBgResource(R.color.black_alpha0);
            this.nPq = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.nPr = this.mRoot.findViewById(R.id.video_view_delete);
            this.nPr.setOnClickListener(this.mClickListener);
            this.nPs = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.nPt = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.nPu = this.mRoot.findViewById(R.id.view_delete);
            this.nPu.setOnClickListener(this.mClickListener);
            this.nPo = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.nPo.setOnClickListener(this.mClickListener);
            this.nPn = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.nPv = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.nPw = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.nPx = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.nPy = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.nPC = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.nPz = this.mRoot.findViewById(R.id.url_input_clear);
            this.nPA = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.nPA.setEnabled(false);
            this.nPB = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.nPy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.m.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        m.this.nPz.setVisibility(8);
                        ap.setViewTextColor(m.this.nPA, R.color.cp_cont_e);
                        m.this.nPA.setEnabled(false);
                        return;
                    }
                    m.this.nPz.setVisibility(0);
                    ap.setViewTextColor(m.this.nPA, R.color.cp_link_tip_a);
                    m.this.nPA.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (m.this.nPC.getText().equals(m.this.nPl.getActivity().getString(R.string.tip_url_not_match))) {
                        m.this.dWE();
                    }
                }
            });
            this.nPz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    m.this.nPy.setText("");
                    m.this.nPz.setVisibility(8);
                    m.this.nPA.setEnabled(false);
                }
            });
            this.fxS = new com.baidu.tbadk.core.view.a(this.nPl.getPageContext());
            dWE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWE() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.nPC.setText(R.string.tip_url_post);
        } else {
            this.nPC.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        ap.setViewTextColor(this.nPC, R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.nPl.setIsLoading(z);
        if (z) {
            this.nPp.setVisibility(0);
            this.lKS.setVisibility(8);
            this.nPm.startLoad(null, 10, false);
            this.nPs.setVisibility(8);
            this.nPt.setVisibility(8);
            this.nPv.setVisibility(8);
            this.nPw.setVisibility(0);
            ap.setViewTextColor(this.nPw, R.color.cp_cont_f);
            this.nPw.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.nPp.setVisibility(8);
            this.lKS.setVisibility(8);
            dWF();
        } else {
            if (aVar.nGD == 1) {
                this.nPp.setVisibility(0);
                this.lKS.setVisibility(8);
                if (aVar.nGC) {
                    this.nPm.startLoad(aVar.nGF, 10, false);
                    this.nPs.setText(aVar.linkTitle);
                    this.nPt.setText(aVar.eBv);
                    if (at.getRealSize(aVar.linkTitle) > 30) {
                        this.nPs.setMaxLines(2);
                        this.nPt.setMaxLines(1);
                    } else {
                        this.nPs.setMaxLines(1);
                        this.nPt.setMaxLines(2);
                    }
                    this.nPs.setVisibility(0);
                    this.nPt.setVisibility(0);
                    this.nPw.setVisibility(8);
                    this.nPv.setVisibility(8);
                } else {
                    this.nPm.reset();
                    this.nPw.setText(aVar.linkUrl);
                    ap.setViewTextColor(this.nPw, R.color.cp_cont_b);
                    this.nPs.setVisibility(8);
                    this.nPt.setVisibility(8);
                    this.nPw.setVisibility(0);
                    this.nPv.setVisibility(0);
                }
            } else if (aVar.nGD == 2) {
                this.nPp.setVisibility(8);
                this.lKS.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.lKS.getLayoutParams();
                layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(this.nPl.getPageContext().getPageActivity()) - ((int) this.nPl.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.lKS.setLayoutParams(layoutParams);
                ap.setImageResource(this.nPq, R.drawable.icon_play_video);
                ap.setBackgroundResource(this.nPr, R.drawable.btn_delete_url);
                this.alJ.startLoad(aVar.nGI, 10, false);
            } else {
                this.nPp.setVisibility(0);
                this.lKS.setVisibility(8);
                this.nPs.setVisibility(8);
                this.nPt.setVisibility(8);
                this.nPw.setVisibility(0);
                this.nPv.setVisibility(0);
                this.nPm.reset();
                this.nPw.setText(aVar.linkUrl);
                ap.setViewTextColor(this.nPw, R.color.cp_cont_b);
            }
            dWF();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.nPn.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.nPl != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.nPl.getPageContext(), i);
            }
            ap.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
            this.nPn.setHintTextColor(ap.getColor(R.color.cp_cont_e));
            this.nPn.setTextColor(ap.getColor(R.color.cp_cont_f));
            ap.setBackgroundColor(this.nPp, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.nPs, R.color.cp_cont_b);
            ap.setViewTextColor(this.nPt, R.color.cp_cont_d);
            ap.setViewTextColor(this.nPw, R.color.cp_cont_b);
            ap.setBackgroundColor(this.nPv, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.nPv, R.color.cp_cont_d);
            ap.setBackgroundResource(this.nPo, R.drawable.bg_link_invoke);
            ap.setBackgroundColor(this.nPx, R.color.cp_bg_line_d);
            this.nPy.setHintTextColor(ap.getColor(R.color.cp_cont_e));
            ap.setViewTextColor(this.nPy, R.color.cp_cont_b);
            ap.setViewTextColor(this.nPC, R.color.cp_cont_d);
            ap.setViewTextColor(this.nPA, R.color.cp_cont_e);
            ap.setImageResource(this.nPq, R.drawable.home_ic_video);
            ap.setBackgroundResource(this.nPu, R.drawable.btn_delete_url);
            ap.setBackgroundResource(this.nPz, R.drawable.btn_delete_url);
            ap.setBackgroundResource(this.nPr, R.drawable.btn_delete_url);
            dWF();
        }
    }

    public void dWF() {
        boolean z;
        if (StringUtils.isNull(dWG())) {
            z = this.nPp.getVisibility() == 0 || this.lKS.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            ap.setNavbarTitleColor(this.iUk, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.iUk.setEnabled(true);
            return;
        }
        ap.setViewTextColor(this.iUk, R.color.cp_cont_d, 1);
        this.iUk.setEnabled(false);
    }

    public String dWG() {
        if (this.nPn == null || this.nPn.getText() == null) {
            return null;
        }
        return this.nPn.getText().toString();
    }

    public View cUY() {
        return this.evh;
    }

    public View dWH() {
        return this.iUk;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText dWI() {
        return this.nPn;
    }

    public View dWJ() {
        return this.nPu;
    }

    public View dWK() {
        return this.nPr;
    }

    public View dWL() {
        return this.nPp;
    }

    public View getVideoContainer() {
        return this.lKS;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.nPy.setText(aVar.linkUrl);
            this.nPy.setSelection(aVar.linkUrl.length());
        }
        this.nPy.requestFocus();
        com.baidu.adp.lib.util.l.showSoftKeyPad(this.nPl.getActivity(), this.nPy);
        this.nPx.setVisibility(0);
        this.nPB.setVisibility(0);
        this.nPo.setVisibility(8);
    }

    public void dWM() {
        this.nPx.setVisibility(8);
        this.nPB.setVisibility(8);
        this.nPo.setVisibility(0);
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this.nPl.getActivity(), this.nPy);
    }

    public void an(View.OnClickListener onClickListener) {
        this.nPx.setOnClickListener(onClickListener);
        this.nPB.setOnClickListener(onClickListener);
        this.nPo.setOnClickListener(onClickListener);
    }

    public String dWN() {
        if (this.nPy == null || this.nPy.getText() == null) {
            return null;
        }
        return this.nPy.getText().toString();
    }

    public void dWO() {
        if (this.nPC != null) {
            this.nPC.setText(R.string.tip_url_not_match);
            ap.setViewTextColor(this.nPC, R.color.cp_other_b);
        }
    }

    public void ao(View.OnClickListener onClickListener) {
        if (this.nPA != null) {
            this.nPA.setOnClickListener(onClickListener);
        }
    }

    public View dWP() {
        return this.nPx;
    }

    public void destroy() {
        if (this.nPn != null) {
            this.nPn.addTextChangedListener(null);
        }
        if (this.nPy != null) {
            this.nPy.addTextChangedListener(null);
        }
    }

    public void n(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.bR(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bm(this.nPl.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.nPl.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.nPl.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.fxS.setCancelListener(null);
        this.fxS.setTipString(R.string.sending);
        this.fxS.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.fxS.setDialogVisiable(false);
    }
}
