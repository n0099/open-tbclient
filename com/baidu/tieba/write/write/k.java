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
/* loaded from: classes3.dex */
public class k {
    private View bUg;
    private com.baidu.tbadk.core.view.b cNJ;
    private TbImageView hfH;
    private RelativeLayout idu;
    private WriteUrlActivity jVK;
    private TextView jVL;
    private TbImageView jVM;
    private EditText jVN;
    private View jVO;
    private LinearLayout jVP;
    private ImageView jVQ;
    private View jVR;
    private TextView jVS;
    private TextView jVT;
    private View jVU;
    private TextView jVV;
    private TextView jVW;
    private LinearLayout jVX;
    private EditText jVY;
    private View jVZ;
    private TextView jWa;
    private FrameLayout jWb;
    private TextView jWc;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.bUg = null;
        this.cNJ = null;
        if (writeUrlActivity != null) {
            this.jVK = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.jVK.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.jVK.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.bUg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.amL().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bUg.getLayoutParams();
                layoutParams.leftMargin = l.getDimens(this.jVK.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.bUg != null && (this.bUg.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bUg.getLayoutParams();
                layoutParams2.width = -2;
                this.bUg.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.jVL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            am.setViewTextColor(this.jVL, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.jVL.getLayoutParams();
            layoutParams3.rightMargin = l.getDimens(this.jVK.getActivity(), R.dimen.ds16);
            this.jVL.setLayoutParams(layoutParams3);
            this.jVL.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.jVM = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.jVM.setDefaultResource(R.drawable.ic_post_url_n);
            this.jVM.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.jVM.setDefaultBgResource(R.color.black_alpha0);
            this.jVP = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.jVP.setOnClickListener(this.mClickListener);
            this.idu = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.idu.setOnClickListener(this.mClickListener);
            this.hfH = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.hfH.setDefaultErrorResource(0);
            this.hfH.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.hfH.setDefaultBgResource(R.color.black_alpha0);
            this.jVQ = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.jVR = this.mRoot.findViewById(R.id.video_view_delete);
            this.jVR.setOnClickListener(this.mClickListener);
            this.jVS = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.jVT = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.jVU = this.mRoot.findViewById(R.id.view_delete);
            this.jVU.setOnClickListener(this.mClickListener);
            this.jVO = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.jVO.setOnClickListener(this.mClickListener);
            this.jVN = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.jVV = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.jVW = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.jVX = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.jVY = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.jWc = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.jVZ = this.mRoot.findViewById(R.id.url_input_clear);
            this.jWa = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.jWa.setEnabled(false);
            this.jWb = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.jVY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.jVZ.setVisibility(8);
                        am.setViewTextColor(k.this.jWa, (int) R.color.cp_cont_e);
                        k.this.jWa.setEnabled(false);
                        return;
                    }
                    k.this.jVZ.setVisibility(0);
                    am.setViewTextColor(k.this.jWa, (int) R.color.cp_link_tip_a);
                    k.this.jWa.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.jWc.getText().equals(k.this.jVK.getActivity().getString(R.string.tip_url_not_match))) {
                        k.this.cAx();
                    }
                }
            });
            this.jVZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.jVY.setText("");
                    k.this.jVZ.setVisibility(8);
                    k.this.jWa.setEnabled(false);
                }
            });
            this.cNJ = new com.baidu.tbadk.core.view.b(this.jVK.getPageContext());
            cAx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAx() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.jWc.setText(R.string.tip_url_post);
        } else {
            this.jWc.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        am.setViewTextColor(this.jWc, (int) R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.jVK.setIsLoading(z);
        if (z) {
            this.jVP.setVisibility(0);
            this.idu.setVisibility(8);
            this.jVM.startLoad(null, 10, false);
            this.jVS.setVisibility(8);
            this.jVT.setVisibility(8);
            this.jVV.setVisibility(8);
            this.jVW.setVisibility(0);
            am.setViewTextColor(this.jVW, (int) R.color.cp_cont_f);
            this.jVW.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.jVP.setVisibility(8);
            this.idu.setVisibility(8);
            cAy();
        } else {
            if (aVar.jOT == 1) {
                this.jVP.setVisibility(0);
                this.idu.setVisibility(8);
                if (aVar.jOS) {
                    this.jVM.startLoad(aVar.jOV, 10, false);
                    this.jVS.setText(aVar.bYR);
                    this.jVT.setText(aVar.bYS);
                    if (aq.getRealSize(aVar.bYR) > 30) {
                        this.jVS.setMaxLines(2);
                        this.jVT.setMaxLines(1);
                    } else {
                        this.jVS.setMaxLines(1);
                        this.jVT.setMaxLines(2);
                    }
                    this.jVS.setVisibility(0);
                    this.jVT.setVisibility(0);
                    this.jVW.setVisibility(8);
                    this.jVV.setVisibility(8);
                } else {
                    this.jVM.reset();
                    this.jVW.setText(aVar.linkUrl);
                    am.setViewTextColor(this.jVW, (int) R.color.cp_cont_b);
                    this.jVS.setVisibility(8);
                    this.jVT.setVisibility(8);
                    this.jVW.setVisibility(0);
                    this.jVV.setVisibility(0);
                }
            } else if (aVar.jOT == 2) {
                this.jVP.setVisibility(8);
                this.idu.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.idu.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(this.jVK.getPageContext().getPageActivity()) - ((int) this.jVK.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.idu.setLayoutParams(layoutParams);
                am.setImageResource(this.jVQ, R.drawable.icon_play_video);
                am.setBackgroundResource(this.jVR, R.drawable.btn_delete_url);
                this.hfH.startLoad(aVar.jOY, 10, false);
            } else {
                this.jVP.setVisibility(0);
                this.idu.setVisibility(8);
                this.jVS.setVisibility(8);
                this.jVT.setVisibility(8);
                this.jVW.setVisibility(0);
                this.jVV.setVisibility(0);
                this.jVM.reset();
                this.jVW.setText(aVar.linkUrl);
                am.setViewTextColor(this.jVW, (int) R.color.cp_cont_b);
            }
            cAy();
        }
    }

    public void g(TextWatcher textWatcher) {
        this.jVN.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.jVK != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.jVK.getPageContext(), i);
            }
            am.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
            this.jVN.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.jVN.setTextColor(am.getColor(R.color.cp_cont_f));
            am.setBackgroundColor(this.jVP, R.color.cp_bg_line_e);
            am.setViewTextColor(this.jVS, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jVT, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jVW, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.jVV, R.color.cp_bg_line_d);
            am.setViewTextColor(this.jVV, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.jVO, R.drawable.bg_link_invoke);
            am.setBackgroundColor(this.jVX, R.color.cp_bg_line_d);
            this.jVY.setHintTextColor(am.getColor(R.color.cp_cont_e));
            am.setViewTextColor(this.jVY, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jWc, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jWa, (int) R.color.cp_cont_e);
            am.setImageResource(this.jVQ, R.drawable.home_ic_video);
            am.setBackgroundResource(this.jVU, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.jVZ, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.jVR, R.drawable.btn_delete_url);
            cAy();
        }
    }

    public void cAy() {
        boolean z;
        if (StringUtils.isNull(cAz())) {
            z = this.jVP.getVisibility() == 0 || this.idu.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            am.setNavbarTitleColor(this.jVL, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.jVL.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.jVL, R.color.cp_cont_d, 1);
        this.jVL.setEnabled(false);
    }

    public String cAz() {
        if (this.jVN == null || this.jVN.getText() == null) {
            return null;
        }
        return this.jVN.getText().toString();
    }

    public View bDV() {
        return this.bUg;
    }

    public View cAA() {
        return this.jVL;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText cAB() {
        return this.jVN;
    }

    public View cAC() {
        return this.jVU;
    }

    public View cAD() {
        return this.jVR;
    }

    public View cAE() {
        return this.jVP;
    }

    public View getVideoContainer() {
        return this.idu;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.jVY.setText(aVar.linkUrl);
            this.jVY.setSelection(aVar.linkUrl.length());
        }
        this.jVY.requestFocus();
        l.showSoftKeyPad(this.jVK.getActivity(), this.jVY);
        this.jVX.setVisibility(0);
        this.jWb.setVisibility(0);
        this.jVO.setVisibility(8);
    }

    public void cAF() {
        this.jVX.setVisibility(8);
        this.jWb.setVisibility(8);
        this.jVO.setVisibility(0);
        l.hideSoftKeyPad(this.jVK.getActivity(), this.jVY);
    }

    public void af(View.OnClickListener onClickListener) {
        this.jVX.setOnClickListener(onClickListener);
        this.jWb.setOnClickListener(onClickListener);
        this.jVO.setOnClickListener(onClickListener);
    }

    public String cAG() {
        if (this.jVY == null || this.jVY.getText() == null) {
            return null;
        }
        return this.jVY.getText().toString();
    }

    public void cAH() {
        if (this.jWc != null) {
            this.jWc.setText(R.string.tip_url_not_match);
            am.setViewTextColor(this.jWc, (int) R.color.cp_other_b);
        }
    }

    public void ag(View.OnClickListener onClickListener) {
        if (this.jWa != null) {
            this.jWa.setOnClickListener(onClickListener);
        }
    }

    public View cAI() {
        return this.jVX;
    }

    public void destroy() {
        if (this.jVN != null) {
            this.jVN.addTextChangedListener(null);
        }
        if (this.jVY != null) {
            this.jVY.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aS(this.jVK.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.jVK.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.jVK.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.cNJ.setCancelListener(null);
        this.cNJ.setTipString(R.string.sending);
        this.cNJ.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.cNJ.setDialogVisiable(false);
    }
}
