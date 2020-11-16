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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes3.dex */
public class m {
    private TbImageView alP;
    private View ety;
    private com.baidu.tbadk.core.view.a fxh;
    private TextView iUW;
    private RelativeLayout lLk;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private WriteUrlActivity nQO;
    private TbImageView nQP;
    private EditText nQQ;
    private View nQR;
    private LinearLayout nQS;
    private ImageView nQT;
    private View nQU;
    private TextView nQV;
    private TextView nQW;
    private View nQX;
    private TextView nQY;
    private TextView nQZ;
    private LinearLayout nRa;
    private EditText nRb;
    private View nRc;
    private TextView nRd;
    private FrameLayout nRe;
    private TextView nRf;

    public m(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.ety = null;
        this.fxh = null;
        if (writeUrlActivity != null) {
            this.nQO = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.nQO.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.nQO.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.ety = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.bqB().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ety.getLayoutParams();
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.nQO.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.ety != null && (this.ety.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ety.getLayoutParams();
                layoutParams2.width = -2;
                this.ety.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.iUW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            ap.setViewTextColor(this.iUW, R.color.CAM_X0302, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.iUW.getLayoutParams();
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.nQO.getActivity(), R.dimen.ds16);
            this.iUW.setLayoutParams(layoutParams3);
            this.iUW.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.nQP = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.nQP.setDefaultResource(R.drawable.ic_post_url_n);
            this.nQP.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.nQP.setDefaultBgResource(R.color.black_alpha0);
            this.nQS = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.nQS.setOnClickListener(this.mClickListener);
            this.lLk = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.lLk.setOnClickListener(this.mClickListener);
            this.alP = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.alP.setDefaultErrorResource(0);
            this.alP.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.alP.setDefaultBgResource(R.color.black_alpha0);
            this.nQT = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.nQU = this.mRoot.findViewById(R.id.video_view_delete);
            this.nQU.setOnClickListener(this.mClickListener);
            this.nQV = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.nQW = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.nQX = this.mRoot.findViewById(R.id.view_delete);
            this.nQX.setOnClickListener(this.mClickListener);
            this.nQR = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.nQR.setOnClickListener(this.mClickListener);
            this.nQQ = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.nQY = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.nQZ = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.nRa = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.nRb = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.nRf = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.nRc = this.mRoot.findViewById(R.id.url_input_clear);
            this.nRd = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.nRd.setEnabled(false);
            this.nRe = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.nRb.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.m.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        m.this.nRc.setVisibility(8);
                        ap.setViewTextColor(m.this.nRd, R.color.CAM_X0110);
                        m.this.nRd.setEnabled(false);
                        return;
                    }
                    m.this.nRc.setVisibility(0);
                    ap.setViewTextColor(m.this.nRd, R.color.CAM_X0302);
                    m.this.nRd.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (m.this.nRf.getText().equals(m.this.nQO.getActivity().getString(R.string.tip_url_not_match))) {
                        m.this.dWD();
                    }
                }
            });
            this.nRc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    m.this.nRb.setText("");
                    m.this.nRc.setVisibility(8);
                    m.this.nRd.setEnabled(false);
                }
            });
            this.fxh = new com.baidu.tbadk.core.view.a(this.nQO.getPageContext());
            dWD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWD() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.nRf.setText(R.string.tip_url_post);
        } else {
            this.nRf.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        ap.setViewTextColor(this.nRf, R.color.CAM_X0109);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.nQO.setIsLoading(z);
        if (z) {
            this.nQS.setVisibility(0);
            this.lLk.setVisibility(8);
            this.nQP.startLoad(null, 10, false);
            this.nQV.setVisibility(8);
            this.nQW.setVisibility(8);
            this.nQY.setVisibility(8);
            this.nQZ.setVisibility(0);
            ap.setViewTextColor(this.nQZ, R.color.CAM_X0106);
            this.nQZ.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.nQS.setVisibility(8);
            this.lLk.setVisibility(8);
            dWE();
        } else {
            if (aVar.nIe == 1) {
                this.nQS.setVisibility(0);
                this.lLk.setVisibility(8);
                if (aVar.nId) {
                    this.nQP.startLoad(aVar.nIg, 10, false);
                    this.nQV.setText(aVar.linkTitle);
                    this.nQW.setText(aVar.ezM);
                    if (au.getRealSize(aVar.linkTitle) > 30) {
                        this.nQV.setMaxLines(2);
                        this.nQW.setMaxLines(1);
                    } else {
                        this.nQV.setMaxLines(1);
                        this.nQW.setMaxLines(2);
                    }
                    this.nQV.setVisibility(0);
                    this.nQW.setVisibility(0);
                    this.nQZ.setVisibility(8);
                    this.nQY.setVisibility(8);
                } else {
                    this.nQP.reset();
                    this.nQZ.setText(aVar.linkUrl);
                    ap.setViewTextColor(this.nQZ, R.color.CAM_X0105);
                    this.nQV.setVisibility(8);
                    this.nQW.setVisibility(8);
                    this.nQZ.setVisibility(0);
                    this.nQY.setVisibility(0);
                }
            } else if (aVar.nIe == 2) {
                this.nQS.setVisibility(8);
                this.lLk.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.lLk.getLayoutParams();
                layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(this.nQO.getPageContext().getPageActivity()) - ((int) this.nQO.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.lLk.setLayoutParams(layoutParams);
                ap.setImageResource(this.nQT, R.drawable.icon_play_video);
                ap.setBackgroundResource(this.nQU, R.drawable.btn_delete_url);
                this.alP.startLoad(aVar.nIj, 10, false);
            } else {
                this.nQS.setVisibility(0);
                this.lLk.setVisibility(8);
                this.nQV.setVisibility(8);
                this.nQW.setVisibility(8);
                this.nQZ.setVisibility(0);
                this.nQY.setVisibility(0);
                this.nQP.reset();
                this.nQZ.setText(aVar.linkUrl);
                ap.setViewTextColor(this.nQZ, R.color.CAM_X0105);
            }
            dWE();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.nQQ.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.nQO != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.nQO.getPageContext(), i);
            }
            ap.setBackgroundColor(this.mNavigationBar, R.color.CAM_X0201);
            ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
            this.nQQ.setHintTextColor(ap.getColor(R.color.CAM_X0110));
            this.nQQ.setTextColor(ap.getColor(R.color.CAM_X0106));
            ap.setBackgroundColor(this.nQS, R.color.CAM_X0205);
            ap.setViewTextColor(this.nQV, R.color.CAM_X0105);
            ap.setViewTextColor(this.nQW, R.color.CAM_X0109);
            ap.setViewTextColor(this.nQZ, R.color.CAM_X0105);
            ap.setBackgroundColor(this.nQY, R.color.CAM_X0201);
            ap.setViewTextColor(this.nQY, R.color.CAM_X0109);
            ap.setBackgroundResource(this.nQR, R.drawable.bg_link_invoke);
            ap.setBackgroundColor(this.nRa, R.color.CAM_X0201);
            this.nRb.setHintTextColor(ap.getColor(R.color.CAM_X0110));
            ap.setViewTextColor(this.nRb, R.color.CAM_X0105);
            ap.setViewTextColor(this.nRf, R.color.CAM_X0109);
            ap.setViewTextColor(this.nRd, R.color.CAM_X0110);
            ap.setImageResource(this.nQT, R.drawable.home_ic_video);
            ap.setBackgroundResource(this.nQX, R.drawable.btn_delete_url);
            ap.setBackgroundResource(this.nRc, R.drawable.btn_delete_url);
            ap.setBackgroundResource(this.nQU, R.drawable.btn_delete_url);
            dWE();
        }
    }

    public void dWE() {
        boolean z;
        if (StringUtils.isNull(dWF())) {
            z = this.nQS.getVisibility() == 0 || this.lLk.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            ap.setNavbarTitleColor(this.iUW, R.color.CAM_X0302, R.color.s_navbar_title_color);
            this.iUW.setEnabled(true);
            return;
        }
        ap.setViewTextColor(this.iUW, R.color.CAM_X0109, 1);
        this.iUW.setEnabled(false);
    }

    public String dWF() {
        if (this.nQQ == null || this.nQQ.getText() == null) {
            return null;
        }
        return this.nQQ.getText().toString();
    }

    public View cUE() {
        return this.ety;
    }

    public View dWG() {
        return this.iUW;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText dWH() {
        return this.nQQ;
    }

    public View dWI() {
        return this.nQX;
    }

    public View dWJ() {
        return this.nQU;
    }

    public View dWK() {
        return this.nQS;
    }

    public View getVideoContainer() {
        return this.lLk;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.nRb.setText(aVar.linkUrl);
            this.nRb.setSelection(aVar.linkUrl.length());
        }
        this.nRb.requestFocus();
        com.baidu.adp.lib.util.l.showSoftKeyPad(this.nQO.getActivity(), this.nRb);
        this.nRa.setVisibility(0);
        this.nRe.setVisibility(0);
        this.nQR.setVisibility(8);
    }

    public void dWL() {
        this.nRa.setVisibility(8);
        this.nRe.setVisibility(8);
        this.nQR.setVisibility(0);
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this.nQO.getActivity(), this.nRb);
    }

    public void an(View.OnClickListener onClickListener) {
        this.nRa.setOnClickListener(onClickListener);
        this.nRe.setOnClickListener(onClickListener);
        this.nQR.setOnClickListener(onClickListener);
    }

    public String dWM() {
        if (this.nRb == null || this.nRb.getText() == null) {
            return null;
        }
        return this.nRb.getText().toString();
    }

    public void dWN() {
        if (this.nRf != null) {
            this.nRf.setText(R.string.tip_url_not_match);
            ap.setViewTextColor(this.nRf, R.color.CAM_X0308);
        }
    }

    public void ao(View.OnClickListener onClickListener) {
        if (this.nRd != null) {
            this.nRd.setOnClickListener(onClickListener);
        }
    }

    public View dWO() {
        return this.nRa;
    }

    public void destroy() {
        if (this.nQQ != null) {
            this.nQQ.addTextChangedListener(null);
        }
        if (this.nRb != null) {
            this.nRb.addTextChangedListener(null);
        }
    }

    public void n(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.bP(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bj(this.nQO.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.nQO.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.nQO.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.fxh.setCancelListener(null);
        this.fxh.setTipString(R.string.sending);
        this.fxh.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.fxh.setDialogVisiable(false);
    }
}
