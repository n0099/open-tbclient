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
    private View gDR;
    private TbImageView gIj;
    private RelativeLayout hED;
    private WriteUrlActivity juS;
    private TextView juT;
    private TbImageView juU;
    private EditText juV;
    private View juW;
    private LinearLayout juX;
    private ImageView juY;
    private View juZ;
    private TextView jva;
    private TextView jvb;
    private View jvc;
    private TextView jvd;
    private TextView jve;
    private LinearLayout jvf;
    private EditText jvg;
    private View jvh;
    private TextView jvi;
    private FrameLayout jvj;
    private TextView jvk;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.gDR = null;
        this.csN = null;
        if (writeUrlActivity != null) {
            this.juS = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.btW = LayoutInflater.from(this.juS.getPageContext().getPageActivity()).inflate(d.h.write_url_activity_layout, (ViewGroup) null);
            this.juS.setContentView(this.btW);
            this.mNavigationBar = (NavigationBar) this.btW.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.gDR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gDR.getLayoutParams();
                layoutParams.leftMargin = l.h(this.juS.getActivity(), d.e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.gDR != null && (this.gDR.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gDR.getLayoutParams();
                layoutParams2.width = -2;
                this.gDR.setLayoutParams(layoutParams2);
            }
            this.btW.setOnClickListener(this.mClickListener);
            this.juT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.j.send_post));
            al.d(this.juT, d.C0236d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.juT.getLayoutParams();
            layoutParams3.rightMargin = l.h(this.juS.getActivity(), d.e.ds16);
            this.juT.setLayoutParams(layoutParams3);
            this.juT.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.j.post_new_thread));
            this.juU = (TbImageView) this.btW.findViewById(d.g.imageview_picture);
            this.juU.setDefaultResource(d.f.ic_post_url_n);
            this.juU.setDefaultErrorResource(d.f.ic_post_url_n);
            this.juU.setDefaultBgResource(d.C0236d.black_alpha0);
            this.juX = (LinearLayout) this.btW.findViewById(d.g.view_picture_publish);
            this.juX.setOnClickListener(this.mClickListener);
            this.hED = (RelativeLayout) this.btW.findViewById(d.g.video_container);
            this.hED.setOnClickListener(this.mClickListener);
            this.gIj = (TbImageView) this.btW.findViewById(d.g.video_img_thumbnail);
            this.gIj.setDefaultErrorResource(0);
            this.gIj.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.gIj.setDefaultBgResource(d.C0236d.black_alpha0);
            this.juY = (ImageView) this.btW.findViewById(d.g.video_img_play);
            this.juZ = this.btW.findViewById(d.g.video_view_delete);
            this.juZ.setOnClickListener(this.mClickListener);
            this.jva = (TextView) this.btW.findViewById(d.g.textview_title);
            this.jvb = (TextView) this.btW.findViewById(d.g.textview_abstract);
            this.jvc = this.btW.findViewById(d.g.view_delete);
            this.jvc.setOnClickListener(this.mClickListener);
            this.juW = this.btW.findViewById(d.g.icon_invoke_link);
            this.juW.setOnClickListener(this.mClickListener);
            this.juV = (EditText) this.btW.findViewById(d.g.post_content);
            this.jvd = (TextView) this.btW.findViewById(d.g.textview_error_tip);
            this.jve = (TextView) this.btW.findViewById(d.g.textview_url);
            this.jvf = (LinearLayout) this.btW.findViewById(d.g.url_edit_container);
            this.jvg = (EditText) this.btW.findViewById(d.g.url_input);
            this.jvk = (TextView) this.btW.findViewById(d.g.url_desc);
            this.jvh = this.btW.findViewById(d.g.url_input_clear);
            this.jvi = (TextView) this.btW.findViewById(d.g.url_add);
            this.jvi.setEnabled(false);
            this.jvj = (FrameLayout) this.btW.findViewById(d.g.url_edit_back_view);
            this.jvg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.jvh.setVisibility(8);
                        al.j(k.this.jvi, d.C0236d.cp_cont_e);
                        k.this.jvi.setEnabled(false);
                        return;
                    }
                    k.this.jvh.setVisibility(0);
                    al.j(k.this.jvi, d.C0236d.cp_link_tip_a);
                    k.this.jvi.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.jvk.getText().equals(k.this.juS.getActivity().getString(d.j.tip_url_not_match))) {
                        k.this.crp();
                    }
                }
            });
            this.jvh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.jvg.setText("");
                    k.this.jvh.setVisibility(8);
                    k.this.jvi.setEnabled(false);
                }
            });
            this.csN = new com.baidu.tbadk.core.view.b(this.juS.getPageContext());
            crp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crp() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.jvk.setText(d.j.tip_url_post);
        } else {
            this.jvk.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        al.j(this.jvk, d.C0236d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.juS.setIsLoading(z);
        if (z) {
            this.juX.setVisibility(0);
            this.hED.setVisibility(8);
            this.juU.startLoad(null, 10, false);
            this.jva.setVisibility(8);
            this.jvb.setVisibility(8);
            this.jvd.setVisibility(8);
            this.jve.setVisibility(0);
            al.j(this.jve, d.C0236d.cp_cont_f);
            this.jve.setText(d.j.tip_url_loading);
        } else if (aVar == null) {
            this.juX.setVisibility(8);
            this.hED.setVisibility(8);
            crq();
        } else {
            if (aVar.jom == 1) {
                this.juX.setVisibility(0);
                this.hED.setVisibility(8);
                if (aVar.jol) {
                    this.juU.startLoad(aVar.joo, 10, false);
                    this.jva.setText(aVar.bzg);
                    this.jvb.setText(aVar.bzh);
                    if (ap.mH(aVar.bzg) > 30) {
                        this.jva.setMaxLines(2);
                        this.jvb.setMaxLines(1);
                    } else {
                        this.jva.setMaxLines(1);
                        this.jvb.setMaxLines(2);
                    }
                    this.jva.setVisibility(0);
                    this.jvb.setVisibility(0);
                    this.jve.setVisibility(8);
                    this.jvd.setVisibility(8);
                } else {
                    this.juU.reset();
                    this.jve.setText(aVar.linkUrl);
                    al.j(this.jve, d.C0236d.cp_cont_b);
                    this.jva.setVisibility(8);
                    this.jvb.setVisibility(8);
                    this.jve.setVisibility(0);
                    this.jvd.setVisibility(0);
                }
            } else if (aVar.jom == 2) {
                this.juX.setVisibility(8);
                this.hED.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.hED.getLayoutParams();
                layoutParams.height = ((l.aO(this.juS.getPageContext().getPageActivity()) - ((int) this.juS.getPageContext().getPageActivity().getResources().getDimension(d.e.ds80))) * 9) / 16;
                this.hED.setLayoutParams(layoutParams);
                al.c(this.juY, d.f.icon_play_video);
                al.k(this.juZ, d.f.btn_delete_url);
                this.gIj.startLoad(aVar.jor, 10, false);
            } else {
                this.juX.setVisibility(0);
                this.hED.setVisibility(8);
                this.jva.setVisibility(8);
                this.jvb.setVisibility(8);
                this.jve.setVisibility(0);
                this.jvd.setVisibility(0);
                this.juU.reset();
                this.jve.setText(aVar.linkUrl);
                al.j(this.jve, d.C0236d.cp_cont_b);
            }
            crq();
        }
    }

    public void f(TextWatcher textWatcher) {
        this.juV.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.juS != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.juS.getPageContext(), i);
            }
            al.l(this.mNavigationBar, d.C0236d.cp_bg_line_d);
            al.l(this.btW, d.C0236d.cp_bg_line_d);
            this.juV.setHintTextColor(al.getColor(d.C0236d.cp_cont_e));
            this.juV.setTextColor(al.getColor(d.C0236d.cp_cont_f));
            al.l(this.juX, d.C0236d.cp_bg_line_e);
            al.j(this.jva, d.C0236d.cp_cont_b);
            al.j(this.jvb, d.C0236d.cp_cont_d);
            al.j(this.jve, d.C0236d.cp_cont_b);
            al.l(this.jvd, d.C0236d.cp_bg_line_d);
            al.j(this.jvd, d.C0236d.cp_cont_d);
            al.k(this.juW, d.f.bg_link_invoke);
            al.l(this.jvf, d.C0236d.cp_bg_line_d);
            this.jvg.setHintTextColor(al.getColor(d.C0236d.cp_cont_e));
            al.j(this.jvg, d.C0236d.cp_cont_b);
            al.j(this.jvk, d.C0236d.cp_cont_d);
            al.j(this.jvi, d.C0236d.cp_cont_e);
            al.c(this.juY, d.f.home_ic_video);
            al.k(this.jvc, d.f.btn_delete_url);
            al.k(this.jvh, d.f.btn_delete_url);
            al.k(this.juZ, d.f.btn_delete_url);
            crq();
        }
    }

    public void crq() {
        boolean z;
        if (StringUtils.isNull(crr())) {
            z = this.juX.getVisibility() == 0 || this.hED.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            al.c(this.juT, d.C0236d.cp_link_tip_a, d.C0236d.s_navbar_title_color);
            this.juT.setEnabled(true);
            return;
        }
        al.d(this.juT, d.C0236d.cp_cont_d, 1);
        this.juT.setEnabled(false);
    }

    public String crr() {
        if (this.juV == null || this.juV.getText() == null) {
            return null;
        }
        return this.juV.getText().toString();
    }

    public View bvU() {
        return this.gDR;
    }

    public View crs() {
        return this.juT;
    }

    public View getRootView() {
        return this.btW;
    }

    public EditText crt() {
        return this.juV;
    }

    public View cru() {
        return this.jvc;
    }

    public View crv() {
        return this.juZ;
    }

    public View crw() {
        return this.juX;
    }

    public View getVideoContainer() {
        return this.hED;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.jvg.setText(aVar.linkUrl);
            this.jvg.setSelection(aVar.linkUrl.length());
        }
        this.jvg.requestFocus();
        l.c(this.juS.getActivity(), this.jvg);
        this.jvf.setVisibility(0);
        this.jvj.setVisibility(0);
        this.juW.setVisibility(8);
    }

    public void crx() {
        this.jvf.setVisibility(8);
        this.jvj.setVisibility(8);
        this.juW.setVisibility(0);
        l.b(this.juS.getActivity(), this.jvg);
    }

    public void Z(View.OnClickListener onClickListener) {
        this.jvf.setOnClickListener(onClickListener);
        this.jvj.setOnClickListener(onClickListener);
        this.juW.setOnClickListener(onClickListener);
    }

    public String cry() {
        if (this.jvg == null || this.jvg.getText() == null) {
            return null;
        }
        return this.jvg.getText().toString();
    }

    public void crz() {
        if (this.jvk != null) {
            this.jvk.setText(d.j.tip_url_not_match);
            al.j(this.jvk, d.C0236d.cp_other_b);
        }
    }

    public void aa(View.OnClickListener onClickListener) {
        if (this.jvi != null) {
            this.jvi.setOnClickListener(onClickListener);
        }
    }

    public View crA() {
        return this.jvf;
    }

    public void destroy() {
        if (this.juV != null) {
            this.juV.addTextChangedListener(null);
        }
        if (this.jvg != null) {
            this.jvg.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.aB(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aV(this.juS.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.juS.getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                this.juS.showToast(errorString);
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
