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
    private View amM;
    private com.baidu.tbadk.core.view.d bib;
    private View fka;
    private TbImageView fos;
    private RelativeLayout gky;
    private WriteUrlActivity hZN;
    private TextView hZO;
    private TbImageView hZP;
    private EditText hZQ;
    private View hZR;
    private LinearLayout hZS;
    private ImageView hZT;
    private View hZU;
    private TextView hZV;
    private TextView hZW;
    private View hZX;
    private TextView hZY;
    private TextView hZZ;
    private LinearLayout iaa;
    private EditText iab;
    private View iac;
    private TextView iad;
    private FrameLayout iae;
    private TextView iaf;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.fka = null;
        this.bib = null;
        if (writeUrlActivity != null) {
            this.hZN = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.amM = LayoutInflater.from(this.hZN.getPageContext().getPageActivity()).inflate(e.h.write_url_activity_layout, (ViewGroup) null);
            this.hZN.setContentView(this.amM);
            this.mNavigationBar = (NavigationBar) this.amM.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.fka = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(e.f.write_close_selector, e.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fka.getLayoutParams();
                layoutParams.leftMargin = l.h(this.hZN.getActivity(), e.C0210e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.fka != null && (this.fka.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fka.getLayoutParams();
                layoutParams2.width = -2;
                this.fka.setLayoutParams(layoutParams2);
            }
            this.amM.setOnClickListener(this.mClickListener);
            this.hZO = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(e.j.send_post));
            al.c(this.hZO, e.d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hZO.getLayoutParams();
            layoutParams3.rightMargin = l.h(this.hZN.getActivity(), e.C0210e.ds16);
            this.hZO.setLayoutParams(layoutParams3);
            this.hZO.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(e.j.post_new_thread));
            this.hZP = (TbImageView) this.amM.findViewById(e.g.imageview_picture);
            this.hZP.setDefaultResource(e.f.ic_post_url_n);
            this.hZP.setDefaultErrorResource(e.f.ic_post_url_n);
            this.hZP.setDefaultBgResource(e.d.black_alpha0);
            this.hZS = (LinearLayout) this.amM.findViewById(e.g.view_picture_publish);
            this.hZS.setOnClickListener(this.mClickListener);
            this.gky = (RelativeLayout) this.amM.findViewById(e.g.video_container);
            this.gky.setOnClickListener(this.mClickListener);
            this.fos = (TbImageView) this.amM.findViewById(e.g.video_img_thumbnail);
            this.fos.setDefaultErrorResource(0);
            this.fos.setDefaultBgResource(e.f.pic_bg_video_frs);
            this.fos.setDefaultBgResource(e.d.black_alpha0);
            this.hZT = (ImageView) this.amM.findViewById(e.g.video_img_play);
            this.hZU = this.amM.findViewById(e.g.video_view_delete);
            this.hZU.setOnClickListener(this.mClickListener);
            this.hZV = (TextView) this.amM.findViewById(e.g.textview_title);
            this.hZW = (TextView) this.amM.findViewById(e.g.textview_abstract);
            this.hZX = this.amM.findViewById(e.g.view_delete);
            this.hZX.setOnClickListener(this.mClickListener);
            this.hZR = this.amM.findViewById(e.g.icon_invoke_link);
            this.hZR.setOnClickListener(this.mClickListener);
            this.hZQ = (EditText) this.amM.findViewById(e.g.post_content);
            this.hZY = (TextView) this.amM.findViewById(e.g.textview_error_tip);
            this.hZZ = (TextView) this.amM.findViewById(e.g.textview_url);
            this.iaa = (LinearLayout) this.amM.findViewById(e.g.url_edit_container);
            this.iab = (EditText) this.amM.findViewById(e.g.url_input);
            this.iaf = (TextView) this.amM.findViewById(e.g.url_desc);
            this.iac = this.amM.findViewById(e.g.url_input_clear);
            this.iad = (TextView) this.amM.findViewById(e.g.url_add);
            this.iad.setEnabled(false);
            this.iae = (FrameLayout) this.amM.findViewById(e.g.url_edit_back_view);
            this.iab.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.iac.setVisibility(8);
                        al.h(k.this.iad, e.d.cp_cont_e);
                        k.this.iad.setEnabled(false);
                        return;
                    }
                    k.this.iac.setVisibility(0);
                    al.h(k.this.iad, e.d.cp_link_tip_a);
                    k.this.iad.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.iaf.getText().equals(k.this.hZN.getActivity().getString(e.j.tip_url_not_match))) {
                        k.this.bQi();
                    }
                }
            });
            this.iac.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.iab.setText("");
                    k.this.iac.setVisibility(8);
                    k.this.iad.setEnabled(false);
                }
            });
            this.bib = new com.baidu.tbadk.core.view.d(this.hZN.getPageContext());
            bQi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQi() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.iaf.setText(e.j.tip_url_post);
        } else {
            this.iaf.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        al.h(this.iaf, e.d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.hZN.setIsLoading(z);
        if (z) {
            this.hZS.setVisibility(0);
            this.gky.setVisibility(8);
            this.hZP.startLoad(null, 10, false);
            this.hZV.setVisibility(8);
            this.hZW.setVisibility(8);
            this.hZY.setVisibility(8);
            this.hZZ.setVisibility(0);
            al.h(this.hZZ, e.d.cp_cont_f);
            this.hZZ.setText(e.j.tip_url_loading);
        } else if (aVar == null) {
            this.hZS.setVisibility(8);
            this.gky.setVisibility(8);
            bQj();
        } else {
            if (aVar.hTu == 1) {
                this.hZS.setVisibility(0);
                this.gky.setVisibility(8);
                if (aVar.hTt) {
                    this.hZP.startLoad(aVar.hTw, 10, false);
                    this.hZV.setText(aVar.arP);
                    this.hZW.setText(aVar.arQ);
                    if (ao.fI(aVar.arP) > 30) {
                        this.hZV.setMaxLines(2);
                        this.hZW.setMaxLines(1);
                    } else {
                        this.hZV.setMaxLines(1);
                        this.hZW.setMaxLines(2);
                    }
                    this.hZV.setVisibility(0);
                    this.hZW.setVisibility(0);
                    this.hZZ.setVisibility(8);
                    this.hZY.setVisibility(8);
                } else {
                    this.hZP.reset();
                    this.hZZ.setText(aVar.linkUrl);
                    al.h(this.hZZ, e.d.cp_cont_b);
                    this.hZV.setVisibility(8);
                    this.hZW.setVisibility(8);
                    this.hZZ.setVisibility(0);
                    this.hZY.setVisibility(0);
                }
            } else if (aVar.hTu == 2) {
                this.hZS.setVisibility(8);
                this.gky.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.gky.getLayoutParams();
                layoutParams.height = ((l.aO(this.hZN.getPageContext().getPageActivity()) - ((int) this.hZN.getPageContext().getPageActivity().getResources().getDimension(e.C0210e.ds80))) * 9) / 16;
                this.gky.setLayoutParams(layoutParams);
                al.c(this.hZT, e.f.icon_play_video);
                al.i(this.hZU, e.f.btn_delete_url);
                this.fos.startLoad(aVar.hTz, 10, false);
            } else {
                this.hZS.setVisibility(0);
                this.gky.setVisibility(8);
                this.hZV.setVisibility(8);
                this.hZW.setVisibility(8);
                this.hZZ.setVisibility(0);
                this.hZY.setVisibility(0);
                this.hZP.reset();
                this.hZZ.setText(aVar.linkUrl);
                al.h(this.hZZ, e.d.cp_cont_b);
            }
            bQj();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.hZQ.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.hZN != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hZN.getPageContext(), i);
            }
            al.j(this.mNavigationBar, e.d.cp_bg_line_d);
            al.j(this.amM, e.d.cp_bg_line_d);
            this.hZQ.setHintTextColor(al.getColor(e.d.cp_cont_e));
            this.hZQ.setTextColor(al.getColor(e.d.cp_cont_f));
            al.j(this.hZS, e.d.cp_bg_line_e);
            al.h(this.hZV, e.d.cp_cont_b);
            al.h(this.hZW, e.d.cp_cont_d);
            al.h(this.hZZ, e.d.cp_cont_b);
            al.j(this.hZY, e.d.cp_bg_line_d);
            al.h(this.hZY, e.d.cp_cont_d);
            al.i(this.hZR, e.f.bg_link_invoke);
            al.j(this.iaa, e.d.cp_bg_line_d);
            this.iab.setHintTextColor(al.getColor(e.d.cp_cont_e));
            al.h(this.iab, e.d.cp_cont_b);
            al.h(this.iaf, e.d.cp_cont_d);
            al.h(this.iad, e.d.cp_cont_e);
            al.c(this.hZT, e.f.home_ic_video);
            al.i(this.hZX, e.f.btn_delete_url);
            al.i(this.iac, e.f.btn_delete_url);
            al.i(this.hZU, e.f.btn_delete_url);
            bQj();
        }
    }

    public void bQj() {
        boolean z;
        if (StringUtils.isNull(bQk())) {
            z = this.hZS.getVisibility() == 0 || this.gky.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            al.b(this.hZO, e.d.cp_link_tip_a, e.d.s_navbar_title_color);
            this.hZO.setEnabled(true);
            return;
        }
        al.c(this.hZO, e.d.cp_cont_d, 1);
        this.hZO.setEnabled(false);
    }

    public String bQk() {
        if (this.hZQ == null || this.hZQ.getText() == null) {
            return null;
        }
        return this.hZQ.getText().toString();
    }

    public View aUc() {
        return this.fka;
    }

    public View bQl() {
        return this.hZO;
    }

    public View getRootView() {
        return this.amM;
    }

    public EditText bQm() {
        return this.hZQ;
    }

    public View bQn() {
        return this.hZX;
    }

    public View bQo() {
        return this.hZU;
    }

    public View bQp() {
        return this.hZS;
    }

    public View getVideoContainer() {
        return this.gky;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.iab.setText(aVar.linkUrl);
            this.iab.setSelection(aVar.linkUrl.length());
        }
        this.iab.requestFocus();
        l.c(this.hZN.getActivity(), this.iab);
        this.iaa.setVisibility(0);
        this.iae.setVisibility(0);
        this.hZR.setVisibility(8);
    }

    public void bQq() {
        this.iaa.setVisibility(8);
        this.iae.setVisibility(8);
        this.hZR.setVisibility(0);
        l.b(this.hZN.getActivity(), this.iab);
    }

    public void Z(View.OnClickListener onClickListener) {
        this.iaa.setOnClickListener(onClickListener);
        this.iae.setOnClickListener(onClickListener);
        this.hZR.setOnClickListener(onClickListener);
    }

    public String bQr() {
        if (this.iab == null || this.iab.getText() == null) {
            return null;
        }
        return this.iab.getText().toString();
    }

    public void bQs() {
        if (this.iaf != null) {
            this.iaf.setText(e.j.tip_url_not_match);
            al.h(this.iaf, e.d.cp_other_b);
        }
    }

    public void aa(View.OnClickListener onClickListener) {
        if (this.iad != null) {
            this.iad.setOnClickListener(onClickListener);
        }
    }

    public View bQt() {
        return this.iaa;
    }

    public void destroy() {
        if (this.hZQ != null) {
            this.hZQ.addTextChangedListener(null);
        }
        if (this.iab != null) {
            this.iab.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.ai(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aJ(this.hZN.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.hZN.getPageContext().getPageActivity().getString(e.j.sand_fail);
                }
                this.hZN.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.bib.d(null);
        this.bib.ec(e.j.sending);
        this.bib.bA(true);
    }

    public void closeLoadingDialog() {
        this.bib.bA(false);
    }
}
