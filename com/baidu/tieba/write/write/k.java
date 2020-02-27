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
    private View cKR;
    private com.baidu.tbadk.core.view.a dFS;
    private RelativeLayout iXo;
    private WriteUrlActivity kUJ;
    private TextView kUK;
    private TbImageView kUL;
    private EditText kUM;
    private View kUN;
    private LinearLayout kUO;
    private ImageView kUP;
    private View kUQ;
    private TextView kUR;
    private TextView kUS;
    private View kUT;
    private TextView kUU;
    private TextView kUV;
    private LinearLayout kUW;
    private EditText kUX;
    private View kUY;
    private TextView kUZ;
    private FrameLayout kVa;
    private TextView kVb;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.cKR = null;
        this.dFS = null;
        if (writeUrlActivity != null) {
            this.kUJ = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.kUJ.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.kUJ.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.cKR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.aGA().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cKR.getLayoutParams();
                layoutParams.leftMargin = l.getDimens(this.kUJ.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.cKR != null && (this.cKR.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cKR.getLayoutParams();
                layoutParams2.width = -2;
                this.cKR.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.kUK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            am.setViewTextColor(this.kUK, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.kUK.getLayoutParams();
            layoutParams3.rightMargin = l.getDimens(this.kUJ.getActivity(), R.dimen.ds16);
            this.kUK.setLayoutParams(layoutParams3);
            this.kUK.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.kUL = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.kUL.setDefaultResource(R.drawable.ic_post_url_n);
            this.kUL.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.kUL.setDefaultBgResource(R.color.black_alpha0);
            this.kUO = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.kUO.setOnClickListener(this.mClickListener);
            this.iXo = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.iXo.setOnClickListener(this.mClickListener);
            this.OY = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.OY.setDefaultErrorResource(0);
            this.OY.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.OY.setDefaultBgResource(R.color.black_alpha0);
            this.kUP = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.kUQ = this.mRoot.findViewById(R.id.video_view_delete);
            this.kUQ.setOnClickListener(this.mClickListener);
            this.kUR = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.kUS = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.kUT = this.mRoot.findViewById(R.id.view_delete);
            this.kUT.setOnClickListener(this.mClickListener);
            this.kUN = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.kUN.setOnClickListener(this.mClickListener);
            this.kUM = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.kUU = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.kUV = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.kUW = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.kUX = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.kVb = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.kUY = this.mRoot.findViewById(R.id.url_input_clear);
            this.kUZ = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.kUZ.setEnabled(false);
            this.kVa = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.kUX.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.kUY.setVisibility(8);
                        am.setViewTextColor(k.this.kUZ, (int) R.color.cp_cont_e);
                        k.this.kUZ.setEnabled(false);
                        return;
                    }
                    k.this.kUY.setVisibility(0);
                    am.setViewTextColor(k.this.kUZ, (int) R.color.cp_link_tip_a);
                    k.this.kUZ.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.kVb.getText().equals(k.this.kUJ.getActivity().getString(R.string.tip_url_not_match))) {
                        k.this.cWR();
                    }
                }
            });
            this.kUY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.kUX.setText("");
                    k.this.kUY.setVisibility(8);
                    k.this.kUZ.setEnabled(false);
                }
            });
            this.dFS = new com.baidu.tbadk.core.view.a(this.kUJ.getPageContext());
            cWR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWR() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.kVb.setText(R.string.tip_url_post);
        } else {
            this.kVb.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        am.setViewTextColor(this.kVb, (int) R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.kUJ.setIsLoading(z);
        if (z) {
            this.kUO.setVisibility(0);
            this.iXo.setVisibility(8);
            this.kUL.startLoad(null, 10, false);
            this.kUR.setVisibility(8);
            this.kUS.setVisibility(8);
            this.kUU.setVisibility(8);
            this.kUV.setVisibility(0);
            am.setViewTextColor(this.kUV, (int) R.color.cp_cont_f);
            this.kUV.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.kUO.setVisibility(8);
            this.iXo.setVisibility(8);
            cWS();
        } else {
            if (aVar.kNS == 1) {
                this.kUO.setVisibility(0);
                this.iXo.setVisibility(8);
                if (aVar.kNR) {
                    this.kUL.startLoad(aVar.kNU, 10, false);
                    this.kUR.setText(aVar.linkTitle);
                    this.kUS.setText(aVar.cPp);
                    if (aq.getRealSize(aVar.linkTitle) > 30) {
                        this.kUR.setMaxLines(2);
                        this.kUS.setMaxLines(1);
                    } else {
                        this.kUR.setMaxLines(1);
                        this.kUS.setMaxLines(2);
                    }
                    this.kUR.setVisibility(0);
                    this.kUS.setVisibility(0);
                    this.kUV.setVisibility(8);
                    this.kUU.setVisibility(8);
                } else {
                    this.kUL.reset();
                    this.kUV.setText(aVar.linkUrl);
                    am.setViewTextColor(this.kUV, (int) R.color.cp_cont_b);
                    this.kUR.setVisibility(8);
                    this.kUS.setVisibility(8);
                    this.kUV.setVisibility(0);
                    this.kUU.setVisibility(0);
                }
            } else if (aVar.kNS == 2) {
                this.kUO.setVisibility(8);
                this.iXo.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.iXo.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(this.kUJ.getPageContext().getPageActivity()) - ((int) this.kUJ.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.iXo.setLayoutParams(layoutParams);
                am.setImageResource(this.kUP, R.drawable.icon_play_video);
                am.setBackgroundResource(this.kUQ, R.drawable.btn_delete_url);
                this.OY.startLoad(aVar.kNX, 10, false);
            } else {
                this.kUO.setVisibility(0);
                this.iXo.setVisibility(8);
                this.kUR.setVisibility(8);
                this.kUS.setVisibility(8);
                this.kUV.setVisibility(0);
                this.kUU.setVisibility(0);
                this.kUL.reset();
                this.kUV.setText(aVar.linkUrl);
                am.setViewTextColor(this.kUV, (int) R.color.cp_cont_b);
            }
            cWS();
        }
    }

    public void f(TextWatcher textWatcher) {
        this.kUM.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.kUJ != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.kUJ.getPageContext(), i);
            }
            am.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
            this.kUM.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.kUM.setTextColor(am.getColor(R.color.cp_cont_f));
            am.setBackgroundColor(this.kUO, R.color.cp_bg_line_e);
            am.setViewTextColor(this.kUR, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kUS, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.kUV, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.kUU, R.color.cp_bg_line_d);
            am.setViewTextColor(this.kUU, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.kUN, R.drawable.bg_link_invoke);
            am.setBackgroundColor(this.kUW, R.color.cp_bg_line_d);
            this.kUX.setHintTextColor(am.getColor(R.color.cp_cont_e));
            am.setViewTextColor(this.kUX, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kVb, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.kUZ, (int) R.color.cp_cont_e);
            am.setImageResource(this.kUP, R.drawable.home_ic_video);
            am.setBackgroundResource(this.kUT, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.kUY, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.kUQ, R.drawable.btn_delete_url);
            cWS();
        }
    }

    public void cWS() {
        boolean z;
        if (StringUtils.isNull(cWT())) {
            z = this.kUO.getVisibility() == 0 || this.iXo.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            am.setNavbarTitleColor(this.kUK, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.kUK.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.kUK, R.color.cp_cont_d, 1);
        this.kUK.setEnabled(false);
    }

    public String cWT() {
        if (this.kUM == null || this.kUM.getText() == null) {
            return null;
        }
        return this.kUM.getText().toString();
    }

    public View bXR() {
        return this.cKR;
    }

    public View cWU() {
        return this.kUK;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText cWV() {
        return this.kUM;
    }

    public View cWW() {
        return this.kUT;
    }

    public View cWX() {
        return this.kUQ;
    }

    public View cWY() {
        return this.kUO;
    }

    public View getVideoContainer() {
        return this.iXo;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.kUX.setText(aVar.linkUrl);
            this.kUX.setSelection(aVar.linkUrl.length());
        }
        this.kUX.requestFocus();
        l.showSoftKeyPad(this.kUJ.getActivity(), this.kUX);
        this.kUW.setVisibility(0);
        this.kVa.setVisibility(0);
        this.kUN.setVisibility(8);
    }

    public void cWZ() {
        this.kUW.setVisibility(8);
        this.kVa.setVisibility(8);
        this.kUN.setVisibility(0);
        l.hideSoftKeyPad(this.kUJ.getActivity(), this.kUX);
    }

    public void ag(View.OnClickListener onClickListener) {
        this.kUW.setOnClickListener(onClickListener);
        this.kVa.setOnClickListener(onClickListener);
        this.kUN.setOnClickListener(onClickListener);
    }

    public String cXa() {
        if (this.kUX == null || this.kUX.getText() == null) {
            return null;
        }
        return this.kUX.getText().toString();
    }

    public void cXb() {
        if (this.kVb != null) {
            this.kVb.setText(R.string.tip_url_not_match);
            am.setViewTextColor(this.kVb, (int) R.color.cp_other_b);
        }
    }

    public void ah(View.OnClickListener onClickListener) {
        if (this.kUZ != null) {
            this.kUZ.setOnClickListener(onClickListener);
        }
    }

    public View cXc() {
        return this.kUW;
    }

    public void destroy() {
        if (this.kUM != null) {
            this.kUM.addTextChangedListener(null);
        }
        if (this.kUX != null) {
            this.kUX.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.bb(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bn(this.kUJ.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.kUJ.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.kUJ.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.dFS.setCancelListener(null);
        this.dFS.setTipString(R.string.sending);
        this.dFS.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.dFS.setDialogVisiable(false);
    }
}
