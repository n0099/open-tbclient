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
    private View cKS;
    private com.baidu.tbadk.core.view.a dFT;
    private RelativeLayout iXq;
    private WriteUrlActivity kUL;
    private TextView kUM;
    private TbImageView kUN;
    private EditText kUO;
    private View kUP;
    private LinearLayout kUQ;
    private ImageView kUR;
    private View kUS;
    private TextView kUT;
    private TextView kUU;
    private View kUV;
    private TextView kUW;
    private TextView kUX;
    private LinearLayout kUY;
    private EditText kUZ;
    private View kVa;
    private TextView kVb;
    private FrameLayout kVc;
    private TextView kVd;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.cKS = null;
        this.dFT = null;
        if (writeUrlActivity != null) {
            this.kUL = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.kUL.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.kUL.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.cKS = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.aGC().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cKS.getLayoutParams();
                layoutParams.leftMargin = l.getDimens(this.kUL.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.cKS != null && (this.cKS.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cKS.getLayoutParams();
                layoutParams2.width = -2;
                this.cKS.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.kUM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            am.setViewTextColor(this.kUM, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.kUM.getLayoutParams();
            layoutParams3.rightMargin = l.getDimens(this.kUL.getActivity(), R.dimen.ds16);
            this.kUM.setLayoutParams(layoutParams3);
            this.kUM.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.kUN = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.kUN.setDefaultResource(R.drawable.ic_post_url_n);
            this.kUN.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.kUN.setDefaultBgResource(R.color.black_alpha0);
            this.kUQ = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.kUQ.setOnClickListener(this.mClickListener);
            this.iXq = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.iXq.setOnClickListener(this.mClickListener);
            this.OY = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.OY.setDefaultErrorResource(0);
            this.OY.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.OY.setDefaultBgResource(R.color.black_alpha0);
            this.kUR = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.kUS = this.mRoot.findViewById(R.id.video_view_delete);
            this.kUS.setOnClickListener(this.mClickListener);
            this.kUT = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.kUU = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.kUV = this.mRoot.findViewById(R.id.view_delete);
            this.kUV.setOnClickListener(this.mClickListener);
            this.kUP = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.kUP.setOnClickListener(this.mClickListener);
            this.kUO = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.kUW = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.kUX = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.kUY = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.kUZ = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.kVd = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.kVa = this.mRoot.findViewById(R.id.url_input_clear);
            this.kVb = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.kVb.setEnabled(false);
            this.kVc = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.kUZ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.kVa.setVisibility(8);
                        am.setViewTextColor(k.this.kVb, (int) R.color.cp_cont_e);
                        k.this.kVb.setEnabled(false);
                        return;
                    }
                    k.this.kVa.setVisibility(0);
                    am.setViewTextColor(k.this.kVb, (int) R.color.cp_link_tip_a);
                    k.this.kVb.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.kVd.getText().equals(k.this.kUL.getActivity().getString(R.string.tip_url_not_match))) {
                        k.this.cWT();
                    }
                }
            });
            this.kVa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.kUZ.setText("");
                    k.this.kVa.setVisibility(8);
                    k.this.kVb.setEnabled(false);
                }
            });
            this.dFT = new com.baidu.tbadk.core.view.a(this.kUL.getPageContext());
            cWT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWT() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.kVd.setText(R.string.tip_url_post);
        } else {
            this.kVd.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        am.setViewTextColor(this.kVd, (int) R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.kUL.setIsLoading(z);
        if (z) {
            this.kUQ.setVisibility(0);
            this.iXq.setVisibility(8);
            this.kUN.startLoad(null, 10, false);
            this.kUT.setVisibility(8);
            this.kUU.setVisibility(8);
            this.kUW.setVisibility(8);
            this.kUX.setVisibility(0);
            am.setViewTextColor(this.kUX, (int) R.color.cp_cont_f);
            this.kUX.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.kUQ.setVisibility(8);
            this.iXq.setVisibility(8);
            cWU();
        } else {
            if (aVar.kNU == 1) {
                this.kUQ.setVisibility(0);
                this.iXq.setVisibility(8);
                if (aVar.kNT) {
                    this.kUN.startLoad(aVar.kNW, 10, false);
                    this.kUT.setText(aVar.linkTitle);
                    this.kUU.setText(aVar.cPq);
                    if (aq.getRealSize(aVar.linkTitle) > 30) {
                        this.kUT.setMaxLines(2);
                        this.kUU.setMaxLines(1);
                    } else {
                        this.kUT.setMaxLines(1);
                        this.kUU.setMaxLines(2);
                    }
                    this.kUT.setVisibility(0);
                    this.kUU.setVisibility(0);
                    this.kUX.setVisibility(8);
                    this.kUW.setVisibility(8);
                } else {
                    this.kUN.reset();
                    this.kUX.setText(aVar.linkUrl);
                    am.setViewTextColor(this.kUX, (int) R.color.cp_cont_b);
                    this.kUT.setVisibility(8);
                    this.kUU.setVisibility(8);
                    this.kUX.setVisibility(0);
                    this.kUW.setVisibility(0);
                }
            } else if (aVar.kNU == 2) {
                this.kUQ.setVisibility(8);
                this.iXq.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.iXq.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(this.kUL.getPageContext().getPageActivity()) - ((int) this.kUL.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.iXq.setLayoutParams(layoutParams);
                am.setImageResource(this.kUR, R.drawable.icon_play_video);
                am.setBackgroundResource(this.kUS, R.drawable.btn_delete_url);
                this.OY.startLoad(aVar.kNZ, 10, false);
            } else {
                this.kUQ.setVisibility(0);
                this.iXq.setVisibility(8);
                this.kUT.setVisibility(8);
                this.kUU.setVisibility(8);
                this.kUX.setVisibility(0);
                this.kUW.setVisibility(0);
                this.kUN.reset();
                this.kUX.setText(aVar.linkUrl);
                am.setViewTextColor(this.kUX, (int) R.color.cp_cont_b);
            }
            cWU();
        }
    }

    public void f(TextWatcher textWatcher) {
        this.kUO.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.kUL != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.kUL.getPageContext(), i);
            }
            am.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
            this.kUO.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.kUO.setTextColor(am.getColor(R.color.cp_cont_f));
            am.setBackgroundColor(this.kUQ, R.color.cp_bg_line_e);
            am.setViewTextColor(this.kUT, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kUU, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.kUX, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.kUW, R.color.cp_bg_line_d);
            am.setViewTextColor(this.kUW, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.kUP, R.drawable.bg_link_invoke);
            am.setBackgroundColor(this.kUY, R.color.cp_bg_line_d);
            this.kUZ.setHintTextColor(am.getColor(R.color.cp_cont_e));
            am.setViewTextColor(this.kUZ, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kVd, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.kVb, (int) R.color.cp_cont_e);
            am.setImageResource(this.kUR, R.drawable.home_ic_video);
            am.setBackgroundResource(this.kUV, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.kVa, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.kUS, R.drawable.btn_delete_url);
            cWU();
        }
    }

    public void cWU() {
        boolean z;
        if (StringUtils.isNull(cWV())) {
            z = this.kUQ.getVisibility() == 0 || this.iXq.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            am.setNavbarTitleColor(this.kUM, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.kUM.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.kUM, R.color.cp_cont_d, 1);
        this.kUM.setEnabled(false);
    }

    public String cWV() {
        if (this.kUO == null || this.kUO.getText() == null) {
            return null;
        }
        return this.kUO.getText().toString();
    }

    public View bXT() {
        return this.cKS;
    }

    public View cWW() {
        return this.kUM;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText cWX() {
        return this.kUO;
    }

    public View cWY() {
        return this.kUV;
    }

    public View cWZ() {
        return this.kUS;
    }

    public View cXa() {
        return this.kUQ;
    }

    public View getVideoContainer() {
        return this.iXq;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.kUZ.setText(aVar.linkUrl);
            this.kUZ.setSelection(aVar.linkUrl.length());
        }
        this.kUZ.requestFocus();
        l.showSoftKeyPad(this.kUL.getActivity(), this.kUZ);
        this.kUY.setVisibility(0);
        this.kVc.setVisibility(0);
        this.kUP.setVisibility(8);
    }

    public void cXb() {
        this.kUY.setVisibility(8);
        this.kVc.setVisibility(8);
        this.kUP.setVisibility(0);
        l.hideSoftKeyPad(this.kUL.getActivity(), this.kUZ);
    }

    public void ag(View.OnClickListener onClickListener) {
        this.kUY.setOnClickListener(onClickListener);
        this.kVc.setOnClickListener(onClickListener);
        this.kUP.setOnClickListener(onClickListener);
    }

    public String cXc() {
        if (this.kUZ == null || this.kUZ.getText() == null) {
            return null;
        }
        return this.kUZ.getText().toString();
    }

    public void cXd() {
        if (this.kVd != null) {
            this.kVd.setText(R.string.tip_url_not_match);
            am.setViewTextColor(this.kVd, (int) R.color.cp_other_b);
        }
    }

    public void ah(View.OnClickListener onClickListener) {
        if (this.kVb != null) {
            this.kVb.setOnClickListener(onClickListener);
        }
    }

    public View cXe() {
        return this.kUY;
    }

    public void destroy() {
        if (this.kUO != null) {
            this.kUO.addTextChangedListener(null);
        }
        if (this.kUZ != null) {
            this.kUZ.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.bb(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bn(this.kUL.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.kUL.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.kUL.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.dFT.setCancelListener(null);
        this.dFT.setTipString(R.string.sending);
        this.dFT.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.dFT.setDialogVisiable(false);
    }
}
