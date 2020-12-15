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
    private TbImageView amP;
    private View eAA;
    private com.baidu.tbadk.core.view.a fEW;
    private TextView jfU;
    private RelativeLayout lZk;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView ofA;
    private TextView ofB;
    private View ofC;
    private TextView ofD;
    private TextView ofE;
    private LinearLayout ofF;
    private EditText ofG;
    private View ofH;
    private TextView ofI;
    private FrameLayout ofJ;
    private TextView ofK;
    private WriteUrlActivity oft;
    private TbImageView ofu;
    private EditText ofv;
    private View ofw;
    private LinearLayout ofx;
    private ImageView ofy;
    private View ofz;

    public m(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.eAA = null;
        this.fEW = null;
        if (writeUrlActivity != null) {
            this.oft = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.oft.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.oft.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.eAA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.btW().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eAA.getLayoutParams();
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.oft.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.eAA != null && (this.eAA.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eAA.getLayoutParams();
                layoutParams2.width = -2;
                this.eAA.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.jfU = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            ap.setViewTextColor(this.jfU, R.color.CAM_X0302, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.jfU.getLayoutParams();
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.oft.getActivity(), R.dimen.ds16);
            this.jfU.setLayoutParams(layoutParams3);
            this.jfU.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.ofu = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.ofu.setDefaultResource(R.drawable.ic_post_url_n);
            this.ofu.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.ofu.setDefaultBgResource(R.color.black_alpha0);
            this.ofx = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.ofx.setOnClickListener(this.mClickListener);
            this.lZk = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.lZk.setOnClickListener(this.mClickListener);
            this.amP = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.amP.setDefaultErrorResource(0);
            this.amP.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.amP.setDefaultBgResource(R.color.black_alpha0);
            this.ofy = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.ofz = this.mRoot.findViewById(R.id.video_view_delete);
            this.ofz.setOnClickListener(this.mClickListener);
            this.ofA = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.ofB = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.ofC = this.mRoot.findViewById(R.id.view_delete);
            this.ofC.setOnClickListener(this.mClickListener);
            this.ofw = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.ofw.setOnClickListener(this.mClickListener);
            this.ofv = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.ofD = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.ofE = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.ofF = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.ofG = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.ofK = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.ofH = this.mRoot.findViewById(R.id.url_input_clear);
            this.ofI = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.ofI.setEnabled(false);
            this.ofJ = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.ofG.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.m.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        m.this.ofH.setVisibility(8);
                        ap.setViewTextColor(m.this.ofI, R.color.CAM_X0110);
                        m.this.ofI.setEnabled(false);
                        return;
                    }
                    m.this.ofH.setVisibility(0);
                    ap.setViewTextColor(m.this.ofI, R.color.CAM_X0302);
                    m.this.ofI.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (m.this.ofK.getText().equals(m.this.oft.getActivity().getString(R.string.tip_url_not_match))) {
                        m.this.ecb();
                    }
                }
            });
            this.ofH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    m.this.ofG.setText("");
                    m.this.ofH.setVisibility(8);
                    m.this.ofI.setEnabled(false);
                }
            });
            this.fEW = new com.baidu.tbadk.core.view.a(this.oft.getPageContext());
            ecb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecb() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.ofK.setText(R.string.tip_url_post);
        } else {
            this.ofK.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        ap.setViewTextColor(this.ofK, R.color.CAM_X0109);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.oft.setIsLoading(z);
        if (z) {
            this.ofx.setVisibility(0);
            this.lZk.setVisibility(8);
            this.ofu.startLoad(null, 10, false);
            this.ofA.setVisibility(8);
            this.ofB.setVisibility(8);
            this.ofD.setVisibility(8);
            this.ofE.setVisibility(0);
            ap.setViewTextColor(this.ofE, R.color.CAM_X0106);
            this.ofE.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.ofx.setVisibility(8);
            this.lZk.setVisibility(8);
            ecc();
        } else {
            if (aVar.nWm == 1) {
                this.ofx.setVisibility(0);
                this.lZk.setVisibility(8);
                if (aVar.nWl) {
                    this.ofu.startLoad(aVar.nWo, 10, false);
                    this.ofA.setText(aVar.linkTitle);
                    this.ofB.setText(aVar.eGL);
                    if (au.getRealSize(aVar.linkTitle) > 30) {
                        this.ofA.setMaxLines(2);
                        this.ofB.setMaxLines(1);
                    } else {
                        this.ofA.setMaxLines(1);
                        this.ofB.setMaxLines(2);
                    }
                    this.ofA.setVisibility(0);
                    this.ofB.setVisibility(0);
                    this.ofE.setVisibility(8);
                    this.ofD.setVisibility(8);
                } else {
                    this.ofu.reset();
                    this.ofE.setText(aVar.linkUrl);
                    ap.setViewTextColor(this.ofE, R.color.CAM_X0105);
                    this.ofA.setVisibility(8);
                    this.ofB.setVisibility(8);
                    this.ofE.setVisibility(0);
                    this.ofD.setVisibility(0);
                }
            } else if (aVar.nWm == 2) {
                this.ofx.setVisibility(8);
                this.lZk.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.lZk.getLayoutParams();
                layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(this.oft.getPageContext().getPageActivity()) - ((int) this.oft.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.lZk.setLayoutParams(layoutParams);
                ap.setImageResource(this.ofy, R.drawable.icon_play_video);
                ap.setBackgroundResource(this.ofz, R.drawable.btn_delete_url);
                this.amP.startLoad(aVar.nWr, 10, false);
            } else {
                this.ofx.setVisibility(0);
                this.lZk.setVisibility(8);
                this.ofA.setVisibility(8);
                this.ofB.setVisibility(8);
                this.ofE.setVisibility(0);
                this.ofD.setVisibility(0);
                this.ofu.reset();
                this.ofE.setText(aVar.linkUrl);
                ap.setViewTextColor(this.ofE, R.color.CAM_X0105);
            }
            ecc();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.ofv.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.oft != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.oft.getPageContext(), i);
            }
            ap.setBackgroundColor(this.mNavigationBar, R.color.CAM_X0201);
            ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
            this.ofv.setHintTextColor(ap.getColor(R.color.CAM_X0110));
            this.ofv.setTextColor(ap.getColor(R.color.CAM_X0106));
            ap.setBackgroundColor(this.ofx, R.color.CAM_X0205);
            ap.setViewTextColor(this.ofA, R.color.CAM_X0105);
            ap.setViewTextColor(this.ofB, R.color.CAM_X0109);
            ap.setViewTextColor(this.ofE, R.color.CAM_X0105);
            ap.setBackgroundColor(this.ofD, R.color.CAM_X0201);
            ap.setViewTextColor(this.ofD, R.color.CAM_X0109);
            ap.setBackgroundResource(this.ofw, R.drawable.bg_link_invoke);
            ap.setBackgroundColor(this.ofF, R.color.CAM_X0201);
            this.ofG.setHintTextColor(ap.getColor(R.color.CAM_X0110));
            ap.setViewTextColor(this.ofG, R.color.CAM_X0105);
            ap.setViewTextColor(this.ofK, R.color.CAM_X0109);
            ap.setViewTextColor(this.ofI, R.color.CAM_X0110);
            ap.setImageResource(this.ofy, R.drawable.home_ic_video);
            ap.setBackgroundResource(this.ofC, R.drawable.btn_delete_url);
            ap.setBackgroundResource(this.ofH, R.drawable.btn_delete_url);
            ap.setBackgroundResource(this.ofz, R.drawable.btn_delete_url);
            ecc();
        }
    }

    public void ecc() {
        boolean z;
        if (StringUtils.isNull(ecd())) {
            z = this.ofx.getVisibility() == 0 || this.lZk.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            ap.setNavbarTitleColor(this.jfU, R.color.CAM_X0302, R.color.s_navbar_title_color);
            this.jfU.setEnabled(true);
            return;
        }
        ap.setViewTextColor(this.jfU, R.color.CAM_X0109, 1);
        this.jfU.setEnabled(false);
    }

    public String ecd() {
        if (this.ofv == null || this.ofv.getText() == null) {
            return null;
        }
        return this.ofv.getText().toString();
    }

    public View cZR() {
        return this.eAA;
    }

    public View ece() {
        return this.jfU;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText ecf() {
        return this.ofv;
    }

    public View ecg() {
        return this.ofC;
    }

    public View ech() {
        return this.ofz;
    }

    public View eci() {
        return this.ofx;
    }

    public View getVideoContainer() {
        return this.lZk;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.ofG.setText(aVar.linkUrl);
            this.ofG.setSelection(aVar.linkUrl.length());
        }
        this.ofG.requestFocus();
        com.baidu.adp.lib.util.l.showSoftKeyPad(this.oft.getActivity(), this.ofG);
        this.ofF.setVisibility(0);
        this.ofJ.setVisibility(0);
        this.ofw.setVisibility(8);
    }

    public void ecj() {
        this.ofF.setVisibility(8);
        this.ofJ.setVisibility(8);
        this.ofw.setVisibility(0);
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this.oft.getActivity(), this.ofG);
    }

    public void an(View.OnClickListener onClickListener) {
        this.ofF.setOnClickListener(onClickListener);
        this.ofJ.setOnClickListener(onClickListener);
        this.ofw.setOnClickListener(onClickListener);
    }

    public String eck() {
        if (this.ofG == null || this.ofG.getText() == null) {
            return null;
        }
        return this.ofG.getText().toString();
    }

    public void ecl() {
        if (this.ofK != null) {
            this.ofK.setText(R.string.tip_url_not_match);
            ap.setViewTextColor(this.ofK, R.color.CAM_X0308);
        }
    }

    public void ao(View.OnClickListener onClickListener) {
        if (this.ofI != null) {
            this.ofI.setOnClickListener(onClickListener);
        }
    }

    public View ecm() {
        return this.ofF;
    }

    public void destroy() {
        if (this.ofv != null) {
            this.ofv.addTextChangedListener(null);
        }
        if (this.ofG != null) {
            this.ofG.addTextChangedListener(null);
        }
    }

    public void n(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.bP(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bn(this.oft.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.oft.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.oft.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.fEW.setCancelListener(null);
        this.fEW.setTipString(R.string.sending);
        this.fEW.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.fEW.setDialogVisiable(false);
    }
}
