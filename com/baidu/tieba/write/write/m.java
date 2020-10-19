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
    private TbImageView alI;
    private View egQ;
    private com.baidu.tbadk.core.view.a fjB;
    private TextView iBR;
    private RelativeLayout lsx;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private WriteUrlActivity nwT;
    private TbImageView nwU;
    private EditText nwV;
    private View nwW;
    private LinearLayout nwX;
    private ImageView nwY;
    private View nwZ;
    private TextView nxa;
    private TextView nxb;
    private View nxc;
    private TextView nxd;
    private TextView nxe;
    private LinearLayout nxf;
    private EditText nxg;
    private View nxh;
    private TextView nxi;
    private FrameLayout nxj;
    private TextView nxk;

    public m(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.egQ = null;
        this.fjB = null;
        if (writeUrlActivity != null) {
            this.nwT = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.nwT.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.nwT.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.egQ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.bmU().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.egQ.getLayoutParams();
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.nwT.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.egQ != null && (this.egQ.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.egQ.getLayoutParams();
                layoutParams2.width = -2;
                this.egQ.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.iBR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            ap.setViewTextColor(this.iBR, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.iBR.getLayoutParams();
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.nwT.getActivity(), R.dimen.ds16);
            this.iBR.setLayoutParams(layoutParams3);
            this.iBR.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.nwU = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.nwU.setDefaultResource(R.drawable.ic_post_url_n);
            this.nwU.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.nwU.setDefaultBgResource(R.color.black_alpha0);
            this.nwX = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.nwX.setOnClickListener(this.mClickListener);
            this.lsx = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.lsx.setOnClickListener(this.mClickListener);
            this.alI = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.alI.setDefaultErrorResource(0);
            this.alI.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.alI.setDefaultBgResource(R.color.black_alpha0);
            this.nwY = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.nwZ = this.mRoot.findViewById(R.id.video_view_delete);
            this.nwZ.setOnClickListener(this.mClickListener);
            this.nxa = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.nxb = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.nxc = this.mRoot.findViewById(R.id.view_delete);
            this.nxc.setOnClickListener(this.mClickListener);
            this.nwW = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.nwW.setOnClickListener(this.mClickListener);
            this.nwV = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.nxd = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.nxe = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.nxf = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.nxg = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.nxk = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.nxh = this.mRoot.findViewById(R.id.url_input_clear);
            this.nxi = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.nxi.setEnabled(false);
            this.nxj = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.nxg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.m.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        m.this.nxh.setVisibility(8);
                        ap.setViewTextColor(m.this.nxi, R.color.cp_cont_e);
                        m.this.nxi.setEnabled(false);
                        return;
                    }
                    m.this.nxh.setVisibility(0);
                    ap.setViewTextColor(m.this.nxi, R.color.cp_link_tip_a);
                    m.this.nxi.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (m.this.nxk.getText().equals(m.this.nwT.getActivity().getString(R.string.tip_url_not_match))) {
                        m.this.dQW();
                    }
                }
            });
            this.nxh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    m.this.nxg.setText("");
                    m.this.nxh.setVisibility(8);
                    m.this.nxi.setEnabled(false);
                }
            });
            this.fjB = new com.baidu.tbadk.core.view.a(this.nwT.getPageContext());
            dQW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQW() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.nxk.setText(R.string.tip_url_post);
        } else {
            this.nxk.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        ap.setViewTextColor(this.nxk, R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.nwT.setIsLoading(z);
        if (z) {
            this.nwX.setVisibility(0);
            this.lsx.setVisibility(8);
            this.nwU.startLoad(null, 10, false);
            this.nxa.setVisibility(8);
            this.nxb.setVisibility(8);
            this.nxd.setVisibility(8);
            this.nxe.setVisibility(0);
            ap.setViewTextColor(this.nxe, R.color.cp_cont_f);
            this.nxe.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.nwX.setVisibility(8);
            this.lsx.setVisibility(8);
            dQX();
        } else {
            if (aVar.noi == 1) {
                this.nwX.setVisibility(0);
                this.lsx.setVisibility(8);
                if (aVar.noh) {
                    this.nwU.startLoad(aVar.nok, 10, false);
                    this.nxa.setText(aVar.linkTitle);
                    this.nxb.setText(aVar.enc);
                    if (at.getRealSize(aVar.linkTitle) > 30) {
                        this.nxa.setMaxLines(2);
                        this.nxb.setMaxLines(1);
                    } else {
                        this.nxa.setMaxLines(1);
                        this.nxb.setMaxLines(2);
                    }
                    this.nxa.setVisibility(0);
                    this.nxb.setVisibility(0);
                    this.nxe.setVisibility(8);
                    this.nxd.setVisibility(8);
                } else {
                    this.nwU.reset();
                    this.nxe.setText(aVar.linkUrl);
                    ap.setViewTextColor(this.nxe, R.color.cp_cont_b);
                    this.nxa.setVisibility(8);
                    this.nxb.setVisibility(8);
                    this.nxe.setVisibility(0);
                    this.nxd.setVisibility(0);
                }
            } else if (aVar.noi == 2) {
                this.nwX.setVisibility(8);
                this.lsx.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.lsx.getLayoutParams();
                layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(this.nwT.getPageContext().getPageActivity()) - ((int) this.nwT.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.lsx.setLayoutParams(layoutParams);
                ap.setImageResource(this.nwY, R.drawable.icon_play_video);
                ap.setBackgroundResource(this.nwZ, R.drawable.btn_delete_url);
                this.alI.startLoad(aVar.non, 10, false);
            } else {
                this.nwX.setVisibility(0);
                this.lsx.setVisibility(8);
                this.nxa.setVisibility(8);
                this.nxb.setVisibility(8);
                this.nxe.setVisibility(0);
                this.nxd.setVisibility(0);
                this.nwU.reset();
                this.nxe.setText(aVar.linkUrl);
                ap.setViewTextColor(this.nxe, R.color.cp_cont_b);
            }
            dQX();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.nwV.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.nwT != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.nwT.getPageContext(), i);
            }
            ap.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
            this.nwV.setHintTextColor(ap.getColor(R.color.cp_cont_e));
            this.nwV.setTextColor(ap.getColor(R.color.cp_cont_f));
            ap.setBackgroundColor(this.nwX, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.nxa, R.color.cp_cont_b);
            ap.setViewTextColor(this.nxb, R.color.cp_cont_d);
            ap.setViewTextColor(this.nxe, R.color.cp_cont_b);
            ap.setBackgroundColor(this.nxd, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.nxd, R.color.cp_cont_d);
            ap.setBackgroundResource(this.nwW, R.drawable.bg_link_invoke);
            ap.setBackgroundColor(this.nxf, R.color.cp_bg_line_d);
            this.nxg.setHintTextColor(ap.getColor(R.color.cp_cont_e));
            ap.setViewTextColor(this.nxg, R.color.cp_cont_b);
            ap.setViewTextColor(this.nxk, R.color.cp_cont_d);
            ap.setViewTextColor(this.nxi, R.color.cp_cont_e);
            ap.setImageResource(this.nwY, R.drawable.home_ic_video);
            ap.setBackgroundResource(this.nxc, R.drawable.btn_delete_url);
            ap.setBackgroundResource(this.nxh, R.drawable.btn_delete_url);
            ap.setBackgroundResource(this.nwZ, R.drawable.btn_delete_url);
            dQX();
        }
    }

    public void dQX() {
        boolean z;
        if (StringUtils.isNull(dQY())) {
            z = this.nwX.getVisibility() == 0 || this.lsx.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            ap.setNavbarTitleColor(this.iBR, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.iBR.setEnabled(true);
            return;
        }
        ap.setViewTextColor(this.iBR, R.color.cp_cont_d, 1);
        this.iBR.setEnabled(false);
    }

    public String dQY() {
        if (this.nwV == null || this.nwV.getText() == null) {
            return null;
        }
        return this.nwV.getText().toString();
    }

    public View cPq() {
        return this.egQ;
    }

    public View dQZ() {
        return this.iBR;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText dRa() {
        return this.nwV;
    }

    public View dRb() {
        return this.nxc;
    }

    public View dRc() {
        return this.nwZ;
    }

    public View dRd() {
        return this.nwX;
    }

    public View getVideoContainer() {
        return this.lsx;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.nxg.setText(aVar.linkUrl);
            this.nxg.setSelection(aVar.linkUrl.length());
        }
        this.nxg.requestFocus();
        com.baidu.adp.lib.util.l.showSoftKeyPad(this.nwT.getActivity(), this.nxg);
        this.nxf.setVisibility(0);
        this.nxj.setVisibility(0);
        this.nwW.setVisibility(8);
    }

    public void dRe() {
        this.nxf.setVisibility(8);
        this.nxj.setVisibility(8);
        this.nwW.setVisibility(0);
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this.nwT.getActivity(), this.nxg);
    }

    public void am(View.OnClickListener onClickListener) {
        this.nxf.setOnClickListener(onClickListener);
        this.nxj.setOnClickListener(onClickListener);
        this.nwW.setOnClickListener(onClickListener);
    }

    public String dRf() {
        if (this.nxg == null || this.nxg.getText() == null) {
            return null;
        }
        return this.nxg.getText().toString();
    }

    public void dRg() {
        if (this.nxk != null) {
            this.nxk.setText(R.string.tip_url_not_match);
            ap.setViewTextColor(this.nxk, R.color.cp_other_b);
        }
    }

    public void an(View.OnClickListener onClickListener) {
        if (this.nxi != null) {
            this.nxi.setOnClickListener(onClickListener);
        }
    }

    public View dRh() {
        return this.nxf;
    }

    public void destroy() {
        if (this.nwV != null) {
            this.nwV.addTextChangedListener(null);
        }
        if (this.nxg != null) {
            this.nxg.addTextChangedListener(null);
        }
    }

    public void n(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.bM(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bk(this.nwT.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.nwT.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.nwT.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.fjB.setCancelListener(null);
        this.fjB.setTipString(R.string.sending);
        this.fjB.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.fjB.setDialogVisiable(false);
    }
}
