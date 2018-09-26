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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes3.dex */
public class k {
    private com.baidu.tbadk.core.view.d aZn;
    private View adA;
    private View eUf;
    private TbImageView eYz;
    private RelativeLayout fUI;
    private WriteUrlActivity hJG;
    private TextView hJH;
    private TbImageView hJI;
    private EditText hJJ;
    private View hJK;
    private LinearLayout hJL;
    private ImageView hJM;
    private View hJN;
    private TextView hJO;
    private TextView hJP;
    private View hJQ;
    private TextView hJR;
    private TextView hJS;
    private LinearLayout hJT;
    private EditText hJU;
    private View hJV;
    private TextView hJW;
    private FrameLayout hJX;
    private TextView hJY;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.eUf = null;
        this.aZn = null;
        if (writeUrlActivity != null) {
            this.hJG = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.adA = LayoutInflater.from(this.hJG.getPageContext().getPageActivity()).inflate(e.h.write_url_activity_layout, (ViewGroup) null);
            this.hJG.setContentView(this.adA);
            this.mNavigationBar = (NavigationBar) this.adA.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.eUf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(e.f.write_close_selector, e.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eUf.getLayoutParams();
                layoutParams.leftMargin = l.h(this.hJG.getActivity(), e.C0141e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.eUf != null && (this.eUf.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eUf.getLayoutParams();
                layoutParams2.width = -2;
                this.eUf.setLayoutParams(layoutParams2);
            }
            this.adA.setOnClickListener(this.mClickListener);
            this.hJH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(e.j.send_post));
            al.c(this.hJH, e.d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hJH.getLayoutParams();
            layoutParams3.rightMargin = l.h(this.hJG.getActivity(), e.C0141e.ds16);
            this.hJH.setLayoutParams(layoutParams3);
            this.hJH.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(e.j.post_new_thread));
            this.hJI = (TbImageView) this.adA.findViewById(e.g.imageview_picture);
            this.hJI.setDefaultResource(e.f.ic_post_url_n);
            this.hJI.setDefaultErrorResource(e.f.ic_post_url_n);
            this.hJI.setDefaultBgResource(e.d.black_alpha0);
            this.hJL = (LinearLayout) this.adA.findViewById(e.g.view_picture_publish);
            this.hJL.setOnClickListener(this.mClickListener);
            this.fUI = (RelativeLayout) this.adA.findViewById(e.g.video_container);
            this.fUI.setOnClickListener(this.mClickListener);
            this.eYz = (TbImageView) this.adA.findViewById(e.g.video_img_thumbnail);
            this.eYz.setDefaultErrorResource(0);
            this.eYz.setDefaultBgResource(e.f.pic_bg_video_frs);
            this.eYz.setDefaultBgResource(e.d.black_alpha0);
            this.hJM = (ImageView) this.adA.findViewById(e.g.video_img_play);
            this.hJN = this.adA.findViewById(e.g.video_view_delete);
            this.hJN.setOnClickListener(this.mClickListener);
            this.hJO = (TextView) this.adA.findViewById(e.g.textview_title);
            this.hJP = (TextView) this.adA.findViewById(e.g.textview_abstract);
            this.hJQ = this.adA.findViewById(e.g.view_delete);
            this.hJQ.setOnClickListener(this.mClickListener);
            this.hJK = this.adA.findViewById(e.g.icon_invoke_link);
            this.hJK.setOnClickListener(this.mClickListener);
            this.hJJ = (EditText) this.adA.findViewById(e.g.post_content);
            this.hJR = (TextView) this.adA.findViewById(e.g.textview_error_tip);
            this.hJS = (TextView) this.adA.findViewById(e.g.textview_url);
            this.hJT = (LinearLayout) this.adA.findViewById(e.g.url_edit_container);
            this.hJU = (EditText) this.adA.findViewById(e.g.url_input);
            this.hJY = (TextView) this.adA.findViewById(e.g.url_desc);
            this.hJV = this.adA.findViewById(e.g.url_input_clear);
            this.hJW = (TextView) this.adA.findViewById(e.g.url_add);
            this.hJW.setEnabled(false);
            this.hJX = (FrameLayout) this.adA.findViewById(e.g.url_edit_back_view);
            this.hJU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.hJV.setVisibility(8);
                        al.h(k.this.hJW, e.d.cp_cont_e);
                        k.this.hJW.setEnabled(false);
                        return;
                    }
                    k.this.hJV.setVisibility(0);
                    al.h(k.this.hJW, e.d.cp_link_tip_a);
                    k.this.hJW.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.hJY.getText().equals(k.this.hJG.getActivity().getString(e.j.tip_url_not_match))) {
                        k.this.bLs();
                    }
                }
            });
            this.hJV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.hJU.setText("");
                    k.this.hJV.setVisibility(8);
                    k.this.hJW.setEnabled(false);
                }
            });
            this.aZn = new com.baidu.tbadk.core.view.d(this.hJG.getPageContext());
            bLs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLs() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.hJY.setText(e.j.tip_url_post);
        } else {
            this.hJY.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        al.h(this.hJY, e.d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.hJG.setIsLoading(z);
        if (z) {
            this.hJL.setVisibility(0);
            this.fUI.setVisibility(8);
            this.hJI.startLoad(null, 10, false);
            this.hJO.setVisibility(8);
            this.hJP.setVisibility(8);
            this.hJR.setVisibility(8);
            this.hJS.setVisibility(0);
            al.h(this.hJS, e.d.cp_cont_f);
            this.hJS.setText(e.j.tip_url_loading);
        } else if (aVar == null) {
            this.hJL.setVisibility(8);
            this.fUI.setVisibility(8);
            bLt();
        } else {
            if (aVar.hDl == 1) {
                this.hJL.setVisibility(0);
                this.fUI.setVisibility(8);
                if (aVar.hDk) {
                    this.hJI.startLoad(aVar.hDn, 10, false);
                    this.hJO.setText(aVar.aiG);
                    this.hJP.setText(aVar.aiH);
                    if (ao.fc(aVar.aiG) > 30) {
                        this.hJO.setMaxLines(2);
                        this.hJP.setMaxLines(1);
                    } else {
                        this.hJO.setMaxLines(1);
                        this.hJP.setMaxLines(2);
                    }
                    this.hJO.setVisibility(0);
                    this.hJP.setVisibility(0);
                    this.hJS.setVisibility(8);
                    this.hJR.setVisibility(8);
                } else {
                    this.hJI.reset();
                    this.hJS.setText(aVar.linkUrl);
                    al.h(this.hJS, e.d.cp_cont_b);
                    this.hJO.setVisibility(8);
                    this.hJP.setVisibility(8);
                    this.hJS.setVisibility(0);
                    this.hJR.setVisibility(0);
                }
            } else if (aVar.hDl == 2) {
                this.hJL.setVisibility(8);
                this.fUI.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.fUI.getLayoutParams();
                layoutParams.height = ((l.aO(this.hJG.getPageContext().getPageActivity()) - ((int) this.hJG.getPageContext().getPageActivity().getResources().getDimension(e.C0141e.ds80))) * 9) / 16;
                this.fUI.setLayoutParams(layoutParams);
                al.c(this.hJM, e.f.icon_play_video);
                al.i(this.hJN, e.f.btn_delete_url);
                this.eYz.startLoad(aVar.hDq, 10, false);
            } else {
                this.hJL.setVisibility(0);
                this.fUI.setVisibility(8);
                this.hJO.setVisibility(8);
                this.hJP.setVisibility(8);
                this.hJS.setVisibility(0);
                this.hJR.setVisibility(0);
                this.hJI.reset();
                this.hJS.setText(aVar.linkUrl);
                al.h(this.hJS, e.d.cp_cont_b);
            }
            bLt();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.hJJ.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.hJG != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hJG.getPageContext(), i);
            }
            al.j(this.mNavigationBar, e.d.cp_bg_line_d);
            al.j(this.adA, e.d.cp_bg_line_d);
            this.hJJ.setHintTextColor(al.getColor(e.d.cp_cont_e));
            this.hJJ.setTextColor(al.getColor(e.d.cp_cont_f));
            al.j(this.hJL, e.d.cp_bg_line_e);
            al.h(this.hJO, e.d.cp_cont_b);
            al.h(this.hJP, e.d.cp_cont_d);
            al.h(this.hJS, e.d.cp_cont_b);
            al.j(this.hJR, e.d.cp_bg_line_d);
            al.h(this.hJR, e.d.cp_cont_d);
            al.i(this.hJK, e.f.bg_link_invoke);
            al.j(this.hJT, e.d.cp_bg_line_d);
            this.hJU.setHintTextColor(al.getColor(e.d.cp_cont_e));
            al.h(this.hJU, e.d.cp_cont_b);
            al.h(this.hJY, e.d.cp_cont_d);
            al.h(this.hJW, e.d.cp_cont_e);
            al.c(this.hJM, e.f.home_ic_video);
            al.i(this.hJQ, e.f.btn_delete_url);
            al.i(this.hJV, e.f.btn_delete_url);
            al.i(this.hJN, e.f.btn_delete_url);
            bLt();
        }
    }

    public void bLt() {
        boolean z;
        if (StringUtils.isNull(bLu())) {
            z = this.hJL.getVisibility() == 0 || this.fUI.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            al.b(this.hJH, e.d.cp_link_tip_a, e.d.s_navbar_title_color);
            this.hJH.setEnabled(true);
            return;
        }
        al.c(this.hJH, e.d.cp_cont_d, 1);
        this.hJH.setEnabled(false);
    }

    public String bLu() {
        if (this.hJJ == null || this.hJJ.getText() == null) {
            return null;
        }
        return this.hJJ.getText().toString();
    }

    public View aPz() {
        return this.eUf;
    }

    public View bLv() {
        return this.hJH;
    }

    public View getRootView() {
        return this.adA;
    }

    public EditText bLw() {
        return this.hJJ;
    }

    public View bLx() {
        return this.hJQ;
    }

    public View bLy() {
        return this.hJN;
    }

    public View bLz() {
        return this.hJL;
    }

    public View getVideoContainer() {
        return this.fUI;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.hJU.setText(aVar.linkUrl);
            this.hJU.setSelection(aVar.linkUrl.length());
        }
        this.hJU.requestFocus();
        l.b(this.hJG.getActivity(), this.hJU);
        this.hJT.setVisibility(0);
        this.hJX.setVisibility(0);
        this.hJK.setVisibility(8);
    }

    public void bLA() {
        this.hJT.setVisibility(8);
        this.hJX.setVisibility(8);
        this.hJK.setVisibility(0);
        l.a(this.hJG.getActivity(), this.hJU);
    }

    public void X(View.OnClickListener onClickListener) {
        this.hJT.setOnClickListener(onClickListener);
        this.hJX.setOnClickListener(onClickListener);
        this.hJK.setOnClickListener(onClickListener);
    }

    public String bLB() {
        if (this.hJU == null || this.hJU.getText() == null) {
            return null;
        }
        return this.hJU.getText().toString();
    }

    public void bLC() {
        if (this.hJY != null) {
            this.hJY.setText(e.j.tip_url_not_match);
            al.h(this.hJY, e.d.cp_other_b);
        }
    }

    public void Y(View.OnClickListener onClickListener) {
        if (this.hJW != null) {
            this.hJW.setOnClickListener(onClickListener);
        }
    }

    public View bLD() {
        return this.hJT;
    }

    public void destroy() {
        if (this.hJJ != null) {
            this.hJJ.addTextChangedListener(null);
        }
        if (this.hJU != null) {
            this.hJU.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.am(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aG(this.hJG.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.hJG.getPageContext().getPageActivity().getString(e.j.sand_fail);
                }
                this.hJG.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.aZn.d(null);
        this.aZn.dq(e.j.sending);
        this.aZn.aZ(true);
    }

    public void closeLoadingDialog() {
        this.aZn.aZ(false);
    }
}
