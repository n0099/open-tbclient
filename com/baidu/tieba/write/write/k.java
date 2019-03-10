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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes3.dex */
public class k {
    private View btW;
    private com.baidu.tbadk.core.view.b csN;
    private View gDS;
    private TbImageView gIk;
    private RelativeLayout hEE;
    private View jvA;
    private TextView jvB;
    private FrameLayout jvC;
    private TextView jvD;
    private WriteUrlActivity jvl;
    private TextView jvm;
    private TbImageView jvn;
    private EditText jvo;
    private View jvp;
    private LinearLayout jvq;
    private ImageView jvr;
    private View jvs;
    private TextView jvt;
    private TextView jvu;
    private View jvv;
    private TextView jvw;
    private TextView jvx;
    private LinearLayout jvy;
    private EditText jvz;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.gDS = null;
        this.csN = null;
        if (writeUrlActivity != null) {
            this.jvl = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.btW = LayoutInflater.from(this.jvl.getPageContext().getPageActivity()).inflate(d.h.write_url_activity_layout, (ViewGroup) null);
            this.jvl.setContentView(this.btW);
            this.mNavigationBar = (NavigationBar) this.btW.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.gDS = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gDS.getLayoutParams();
                layoutParams.leftMargin = l.h(this.jvl.getActivity(), d.e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.gDS != null && (this.gDS.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gDS.getLayoutParams();
                layoutParams2.width = -2;
                this.gDS.setLayoutParams(layoutParams2);
            }
            this.btW.setOnClickListener(this.mClickListener);
            this.jvm = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.j.send_post));
            al.d(this.jvm, d.C0236d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.jvm.getLayoutParams();
            layoutParams3.rightMargin = l.h(this.jvl.getActivity(), d.e.ds16);
            this.jvm.setLayoutParams(layoutParams3);
            this.jvm.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.j.post_new_thread));
            this.jvn = (TbImageView) this.btW.findViewById(d.g.imageview_picture);
            this.jvn.setDefaultResource(d.f.ic_post_url_n);
            this.jvn.setDefaultErrorResource(d.f.ic_post_url_n);
            this.jvn.setDefaultBgResource(d.C0236d.black_alpha0);
            this.jvq = (LinearLayout) this.btW.findViewById(d.g.view_picture_publish);
            this.jvq.setOnClickListener(this.mClickListener);
            this.hEE = (RelativeLayout) this.btW.findViewById(d.g.video_container);
            this.hEE.setOnClickListener(this.mClickListener);
            this.gIk = (TbImageView) this.btW.findViewById(d.g.video_img_thumbnail);
            this.gIk.setDefaultErrorResource(0);
            this.gIk.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.gIk.setDefaultBgResource(d.C0236d.black_alpha0);
            this.jvr = (ImageView) this.btW.findViewById(d.g.video_img_play);
            this.jvs = this.btW.findViewById(d.g.video_view_delete);
            this.jvs.setOnClickListener(this.mClickListener);
            this.jvt = (TextView) this.btW.findViewById(d.g.textview_title);
            this.jvu = (TextView) this.btW.findViewById(d.g.textview_abstract);
            this.jvv = this.btW.findViewById(d.g.view_delete);
            this.jvv.setOnClickListener(this.mClickListener);
            this.jvp = this.btW.findViewById(d.g.icon_invoke_link);
            this.jvp.setOnClickListener(this.mClickListener);
            this.jvo = (EditText) this.btW.findViewById(d.g.post_content);
            this.jvw = (TextView) this.btW.findViewById(d.g.textview_error_tip);
            this.jvx = (TextView) this.btW.findViewById(d.g.textview_url);
            this.jvy = (LinearLayout) this.btW.findViewById(d.g.url_edit_container);
            this.jvz = (EditText) this.btW.findViewById(d.g.url_input);
            this.jvD = (TextView) this.btW.findViewById(d.g.url_desc);
            this.jvA = this.btW.findViewById(d.g.url_input_clear);
            this.jvB = (TextView) this.btW.findViewById(d.g.url_add);
            this.jvB.setEnabled(false);
            this.jvC = (FrameLayout) this.btW.findViewById(d.g.url_edit_back_view);
            this.jvz.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.jvA.setVisibility(8);
                        al.j(k.this.jvB, d.C0236d.cp_cont_e);
                        k.this.jvB.setEnabled(false);
                        return;
                    }
                    k.this.jvA.setVisibility(0);
                    al.j(k.this.jvB, d.C0236d.cp_link_tip_a);
                    k.this.jvB.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.jvD.getText().equals(k.this.jvl.getActivity().getString(d.j.tip_url_not_match))) {
                        k.this.crz();
                    }
                }
            });
            this.jvA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.jvz.setText("");
                    k.this.jvA.setVisibility(8);
                    k.this.jvB.setEnabled(false);
                }
            });
            this.csN = new com.baidu.tbadk.core.view.b(this.jvl.getPageContext());
            crz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crz() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.jvD.setText(d.j.tip_url_post);
        } else {
            this.jvD.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        al.j(this.jvD, d.C0236d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.jvl.setIsLoading(z);
        if (z) {
            this.jvq.setVisibility(0);
            this.hEE.setVisibility(8);
            this.jvn.startLoad(null, 10, false);
            this.jvt.setVisibility(8);
            this.jvu.setVisibility(8);
            this.jvw.setVisibility(8);
            this.jvx.setVisibility(0);
            al.j(this.jvx, d.C0236d.cp_cont_f);
            this.jvx.setText(d.j.tip_url_loading);
        } else if (aVar == null) {
            this.jvq.setVisibility(8);
            this.hEE.setVisibility(8);
            crA();
        } else {
            if (aVar.joF == 1) {
                this.jvq.setVisibility(0);
                this.hEE.setVisibility(8);
                if (aVar.joE) {
                    this.jvn.startLoad(aVar.joH, 10, false);
                    this.jvt.setText(aVar.bzg);
                    this.jvu.setText(aVar.bzh);
                    if (ap.mH(aVar.bzg) > 30) {
                        this.jvt.setMaxLines(2);
                        this.jvu.setMaxLines(1);
                    } else {
                        this.jvt.setMaxLines(1);
                        this.jvu.setMaxLines(2);
                    }
                    this.jvt.setVisibility(0);
                    this.jvu.setVisibility(0);
                    this.jvx.setVisibility(8);
                    this.jvw.setVisibility(8);
                } else {
                    this.jvn.reset();
                    this.jvx.setText(aVar.linkUrl);
                    al.j(this.jvx, d.C0236d.cp_cont_b);
                    this.jvt.setVisibility(8);
                    this.jvu.setVisibility(8);
                    this.jvx.setVisibility(0);
                    this.jvw.setVisibility(0);
                }
            } else if (aVar.joF == 2) {
                this.jvq.setVisibility(8);
                this.hEE.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.hEE.getLayoutParams();
                layoutParams.height = ((l.aO(this.jvl.getPageContext().getPageActivity()) - ((int) this.jvl.getPageContext().getPageActivity().getResources().getDimension(d.e.ds80))) * 9) / 16;
                this.hEE.setLayoutParams(layoutParams);
                al.c(this.jvr, d.f.icon_play_video);
                al.k(this.jvs, d.f.btn_delete_url);
                this.gIk.startLoad(aVar.joK, 10, false);
            } else {
                this.jvq.setVisibility(0);
                this.hEE.setVisibility(8);
                this.jvt.setVisibility(8);
                this.jvu.setVisibility(8);
                this.jvx.setVisibility(0);
                this.jvw.setVisibility(0);
                this.jvn.reset();
                this.jvx.setText(aVar.linkUrl);
                al.j(this.jvx, d.C0236d.cp_cont_b);
            }
            crA();
        }
    }

    public void f(TextWatcher textWatcher) {
        this.jvo.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.jvl != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.jvl.getPageContext(), i);
            }
            al.l(this.mNavigationBar, d.C0236d.cp_bg_line_d);
            al.l(this.btW, d.C0236d.cp_bg_line_d);
            this.jvo.setHintTextColor(al.getColor(d.C0236d.cp_cont_e));
            this.jvo.setTextColor(al.getColor(d.C0236d.cp_cont_f));
            al.l(this.jvq, d.C0236d.cp_bg_line_e);
            al.j(this.jvt, d.C0236d.cp_cont_b);
            al.j(this.jvu, d.C0236d.cp_cont_d);
            al.j(this.jvx, d.C0236d.cp_cont_b);
            al.l(this.jvw, d.C0236d.cp_bg_line_d);
            al.j(this.jvw, d.C0236d.cp_cont_d);
            al.k(this.jvp, d.f.bg_link_invoke);
            al.l(this.jvy, d.C0236d.cp_bg_line_d);
            this.jvz.setHintTextColor(al.getColor(d.C0236d.cp_cont_e));
            al.j(this.jvz, d.C0236d.cp_cont_b);
            al.j(this.jvD, d.C0236d.cp_cont_d);
            al.j(this.jvB, d.C0236d.cp_cont_e);
            al.c(this.jvr, d.f.home_ic_video);
            al.k(this.jvv, d.f.btn_delete_url);
            al.k(this.jvA, d.f.btn_delete_url);
            al.k(this.jvs, d.f.btn_delete_url);
            crA();
        }
    }

    public void crA() {
        boolean z;
        if (StringUtils.isNull(crB())) {
            z = this.jvq.getVisibility() == 0 || this.hEE.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            al.c(this.jvm, d.C0236d.cp_link_tip_a, d.C0236d.s_navbar_title_color);
            this.jvm.setEnabled(true);
            return;
        }
        al.d(this.jvm, d.C0236d.cp_cont_d, 1);
        this.jvm.setEnabled(false);
    }

    public String crB() {
        if (this.jvo == null || this.jvo.getText() == null) {
            return null;
        }
        return this.jvo.getText().toString();
    }

    public View bvV() {
        return this.gDS;
    }

    public View crC() {
        return this.jvm;
    }

    public View getRootView() {
        return this.btW;
    }

    public EditText crD() {
        return this.jvo;
    }

    public View crE() {
        return this.jvv;
    }

    public View crF() {
        return this.jvs;
    }

    public View crG() {
        return this.jvq;
    }

    public View getVideoContainer() {
        return this.hEE;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.jvz.setText(aVar.linkUrl);
            this.jvz.setSelection(aVar.linkUrl.length());
        }
        this.jvz.requestFocus();
        l.c(this.jvl.getActivity(), this.jvz);
        this.jvy.setVisibility(0);
        this.jvC.setVisibility(0);
        this.jvp.setVisibility(8);
    }

    public void crH() {
        this.jvy.setVisibility(8);
        this.jvC.setVisibility(8);
        this.jvp.setVisibility(0);
        l.b(this.jvl.getActivity(), this.jvz);
    }

    public void Z(View.OnClickListener onClickListener) {
        this.jvy.setOnClickListener(onClickListener);
        this.jvC.setOnClickListener(onClickListener);
        this.jvp.setOnClickListener(onClickListener);
    }

    public String crI() {
        if (this.jvz == null || this.jvz.getText() == null) {
            return null;
        }
        return this.jvz.getText().toString();
    }

    public void crJ() {
        if (this.jvD != null) {
            this.jvD.setText(d.j.tip_url_not_match);
            al.j(this.jvD, d.C0236d.cp_other_b);
        }
    }

    public void aa(View.OnClickListener onClickListener) {
        if (this.jvB != null) {
            this.jvB.setOnClickListener(onClickListener);
        }
    }

    public View crK() {
        return this.jvy;
    }

    public void destroy() {
        if (this.jvo != null) {
            this.jvo.addTextChangedListener(null);
        }
        if (this.jvz != null) {
            this.jvz.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.aB(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aV(this.jvl.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.jvl.getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                this.jvl.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.csN.e(null);
        this.csN.hG(d.j.sending);
        this.csN.dJ(true);
    }

    public void closeLoadingDialog() {
        this.csN.dJ(false);
    }
}
