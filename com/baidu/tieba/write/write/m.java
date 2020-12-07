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
    private TextView jfS;
    private RelativeLayout lZi;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private View ofA;
    private TextView ofB;
    private TextView ofC;
    private LinearLayout ofD;
    private EditText ofE;
    private View ofF;
    private TextView ofG;
    private FrameLayout ofH;
    private TextView ofI;
    private WriteUrlActivity ofr;
    private TbImageView ofs;
    private EditText oft;
    private View ofu;
    private LinearLayout ofv;
    private ImageView ofw;
    private View ofx;
    private TextView ofy;
    private TextView ofz;

    public m(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.eAA = null;
        this.fEW = null;
        if (writeUrlActivity != null) {
            this.ofr = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.ofr.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.ofr.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.eAA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.btW().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eAA.getLayoutParams();
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.ofr.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.eAA != null && (this.eAA.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eAA.getLayoutParams();
                layoutParams2.width = -2;
                this.eAA.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.jfS = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            ap.setViewTextColor(this.jfS, R.color.CAM_X0302, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.jfS.getLayoutParams();
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.ofr.getActivity(), R.dimen.ds16);
            this.jfS.setLayoutParams(layoutParams3);
            this.jfS.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.ofs = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.ofs.setDefaultResource(R.drawable.ic_post_url_n);
            this.ofs.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.ofs.setDefaultBgResource(R.color.black_alpha0);
            this.ofv = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.ofv.setOnClickListener(this.mClickListener);
            this.lZi = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.lZi.setOnClickListener(this.mClickListener);
            this.amP = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.amP.setDefaultErrorResource(0);
            this.amP.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.amP.setDefaultBgResource(R.color.black_alpha0);
            this.ofw = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.ofx = this.mRoot.findViewById(R.id.video_view_delete);
            this.ofx.setOnClickListener(this.mClickListener);
            this.ofy = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.ofz = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.ofA = this.mRoot.findViewById(R.id.view_delete);
            this.ofA.setOnClickListener(this.mClickListener);
            this.ofu = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.ofu.setOnClickListener(this.mClickListener);
            this.oft = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.ofB = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.ofC = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.ofD = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.ofE = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.ofI = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.ofF = this.mRoot.findViewById(R.id.url_input_clear);
            this.ofG = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.ofG.setEnabled(false);
            this.ofH = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.ofE.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.m.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        m.this.ofF.setVisibility(8);
                        ap.setViewTextColor(m.this.ofG, R.color.CAM_X0110);
                        m.this.ofG.setEnabled(false);
                        return;
                    }
                    m.this.ofF.setVisibility(0);
                    ap.setViewTextColor(m.this.ofG, R.color.CAM_X0302);
                    m.this.ofG.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (m.this.ofI.getText().equals(m.this.ofr.getActivity().getString(R.string.tip_url_not_match))) {
                        m.this.eca();
                    }
                }
            });
            this.ofF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    m.this.ofE.setText("");
                    m.this.ofF.setVisibility(8);
                    m.this.ofG.setEnabled(false);
                }
            });
            this.fEW = new com.baidu.tbadk.core.view.a(this.ofr.getPageContext());
            eca();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eca() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.ofI.setText(R.string.tip_url_post);
        } else {
            this.ofI.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        ap.setViewTextColor(this.ofI, R.color.CAM_X0109);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.ofr.setIsLoading(z);
        if (z) {
            this.ofv.setVisibility(0);
            this.lZi.setVisibility(8);
            this.ofs.startLoad(null, 10, false);
            this.ofy.setVisibility(8);
            this.ofz.setVisibility(8);
            this.ofB.setVisibility(8);
            this.ofC.setVisibility(0);
            ap.setViewTextColor(this.ofC, R.color.CAM_X0106);
            this.ofC.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.ofv.setVisibility(8);
            this.lZi.setVisibility(8);
            ecb();
        } else {
            if (aVar.nWk == 1) {
                this.ofv.setVisibility(0);
                this.lZi.setVisibility(8);
                if (aVar.nWj) {
                    this.ofs.startLoad(aVar.nWm, 10, false);
                    this.ofy.setText(aVar.linkTitle);
                    this.ofz.setText(aVar.eGL);
                    if (au.getRealSize(aVar.linkTitle) > 30) {
                        this.ofy.setMaxLines(2);
                        this.ofz.setMaxLines(1);
                    } else {
                        this.ofy.setMaxLines(1);
                        this.ofz.setMaxLines(2);
                    }
                    this.ofy.setVisibility(0);
                    this.ofz.setVisibility(0);
                    this.ofC.setVisibility(8);
                    this.ofB.setVisibility(8);
                } else {
                    this.ofs.reset();
                    this.ofC.setText(aVar.linkUrl);
                    ap.setViewTextColor(this.ofC, R.color.CAM_X0105);
                    this.ofy.setVisibility(8);
                    this.ofz.setVisibility(8);
                    this.ofC.setVisibility(0);
                    this.ofB.setVisibility(0);
                }
            } else if (aVar.nWk == 2) {
                this.ofv.setVisibility(8);
                this.lZi.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.lZi.getLayoutParams();
                layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(this.ofr.getPageContext().getPageActivity()) - ((int) this.ofr.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.lZi.setLayoutParams(layoutParams);
                ap.setImageResource(this.ofw, R.drawable.icon_play_video);
                ap.setBackgroundResource(this.ofx, R.drawable.btn_delete_url);
                this.amP.startLoad(aVar.nWp, 10, false);
            } else {
                this.ofv.setVisibility(0);
                this.lZi.setVisibility(8);
                this.ofy.setVisibility(8);
                this.ofz.setVisibility(8);
                this.ofC.setVisibility(0);
                this.ofB.setVisibility(0);
                this.ofs.reset();
                this.ofC.setText(aVar.linkUrl);
                ap.setViewTextColor(this.ofC, R.color.CAM_X0105);
            }
            ecb();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.oft.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.ofr != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.ofr.getPageContext(), i);
            }
            ap.setBackgroundColor(this.mNavigationBar, R.color.CAM_X0201);
            ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
            this.oft.setHintTextColor(ap.getColor(R.color.CAM_X0110));
            this.oft.setTextColor(ap.getColor(R.color.CAM_X0106));
            ap.setBackgroundColor(this.ofv, R.color.CAM_X0205);
            ap.setViewTextColor(this.ofy, R.color.CAM_X0105);
            ap.setViewTextColor(this.ofz, R.color.CAM_X0109);
            ap.setViewTextColor(this.ofC, R.color.CAM_X0105);
            ap.setBackgroundColor(this.ofB, R.color.CAM_X0201);
            ap.setViewTextColor(this.ofB, R.color.CAM_X0109);
            ap.setBackgroundResource(this.ofu, R.drawable.bg_link_invoke);
            ap.setBackgroundColor(this.ofD, R.color.CAM_X0201);
            this.ofE.setHintTextColor(ap.getColor(R.color.CAM_X0110));
            ap.setViewTextColor(this.ofE, R.color.CAM_X0105);
            ap.setViewTextColor(this.ofI, R.color.CAM_X0109);
            ap.setViewTextColor(this.ofG, R.color.CAM_X0110);
            ap.setImageResource(this.ofw, R.drawable.home_ic_video);
            ap.setBackgroundResource(this.ofA, R.drawable.btn_delete_url);
            ap.setBackgroundResource(this.ofF, R.drawable.btn_delete_url);
            ap.setBackgroundResource(this.ofx, R.drawable.btn_delete_url);
            ecb();
        }
    }

    public void ecb() {
        boolean z;
        if (StringUtils.isNull(ecc())) {
            z = this.ofv.getVisibility() == 0 || this.lZi.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            ap.setNavbarTitleColor(this.jfS, R.color.CAM_X0302, R.color.s_navbar_title_color);
            this.jfS.setEnabled(true);
            return;
        }
        ap.setViewTextColor(this.jfS, R.color.CAM_X0109, 1);
        this.jfS.setEnabled(false);
    }

    public String ecc() {
        if (this.oft == null || this.oft.getText() == null) {
            return null;
        }
        return this.oft.getText().toString();
    }

    public View cZQ() {
        return this.eAA;
    }

    public View ecd() {
        return this.jfS;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText ece() {
        return this.oft;
    }

    public View ecf() {
        return this.ofA;
    }

    public View ecg() {
        return this.ofx;
    }

    public View ech() {
        return this.ofv;
    }

    public View getVideoContainer() {
        return this.lZi;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.ofE.setText(aVar.linkUrl);
            this.ofE.setSelection(aVar.linkUrl.length());
        }
        this.ofE.requestFocus();
        com.baidu.adp.lib.util.l.showSoftKeyPad(this.ofr.getActivity(), this.ofE);
        this.ofD.setVisibility(0);
        this.ofH.setVisibility(0);
        this.ofu.setVisibility(8);
    }

    public void eci() {
        this.ofD.setVisibility(8);
        this.ofH.setVisibility(8);
        this.ofu.setVisibility(0);
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this.ofr.getActivity(), this.ofE);
    }

    public void an(View.OnClickListener onClickListener) {
        this.ofD.setOnClickListener(onClickListener);
        this.ofH.setOnClickListener(onClickListener);
        this.ofu.setOnClickListener(onClickListener);
    }

    public String ecj() {
        if (this.ofE == null || this.ofE.getText() == null) {
            return null;
        }
        return this.ofE.getText().toString();
    }

    public void eck() {
        if (this.ofI != null) {
            this.ofI.setText(R.string.tip_url_not_match);
            ap.setViewTextColor(this.ofI, R.color.CAM_X0308);
        }
    }

    public void ao(View.OnClickListener onClickListener) {
        if (this.ofG != null) {
            this.ofG.setOnClickListener(onClickListener);
        }
    }

    public View ecl() {
        return this.ofD;
    }

    public void destroy() {
        if (this.oft != null) {
            this.oft.addTextChangedListener(null);
        }
        if (this.ofE != null) {
            this.ofE.addTextChangedListener(null);
        }
    }

    public void n(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.bP(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bn(this.ofr.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.ofr.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.ofr.showToast(errorString);
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
