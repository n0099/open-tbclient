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
    private View anp;
    private com.baidu.tbadk.core.view.d biQ;
    private TextView cPI;
    private View fnM;
    private TbImageView fsg;
    private RelativeLayout got;
    private TextView ieA;
    private WriteUrlActivity iej;
    private TextView iek;
    private TbImageView iel;
    private EditText iem;
    private View ien;
    private LinearLayout ieo;
    private ImageView iep;
    private View ieq;
    private TextView ier;
    private TextView ies;
    private View iet;
    private TextView ieu;
    private LinearLayout iev;
    private EditText iew;
    private View iex;
    private TextView iey;
    private FrameLayout iez;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.fnM = null;
        this.biQ = null;
        if (writeUrlActivity != null) {
            this.iej = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.anp = LayoutInflater.from(this.iej.getPageContext().getPageActivity()).inflate(e.h.write_url_activity_layout, (ViewGroup) null);
            this.iej.setContentView(this.anp);
            this.mNavigationBar = (NavigationBar) this.anp.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.fnM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(e.f.write_close_selector, e.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fnM.getLayoutParams();
                layoutParams.leftMargin = l.h(this.iej.getActivity(), e.C0210e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.fnM != null && (this.fnM.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fnM.getLayoutParams();
                layoutParams2.width = -2;
                this.fnM.setLayoutParams(layoutParams2);
            }
            this.anp.setOnClickListener(this.mClickListener);
            this.iek = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(e.j.send_post));
            al.c(this.iek, e.d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.iek.getLayoutParams();
            layoutParams3.rightMargin = l.h(this.iej.getActivity(), e.C0210e.ds16);
            this.iek.setLayoutParams(layoutParams3);
            this.iek.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(e.j.post_new_thread));
            this.iel = (TbImageView) this.anp.findViewById(e.g.imageview_picture);
            this.iel.setDefaultResource(e.f.ic_post_url_n);
            this.iel.setDefaultErrorResource(e.f.ic_post_url_n);
            this.iel.setDefaultBgResource(e.d.black_alpha0);
            this.ieo = (LinearLayout) this.anp.findViewById(e.g.view_picture_publish);
            this.ieo.setOnClickListener(this.mClickListener);
            this.got = (RelativeLayout) this.anp.findViewById(e.g.video_container);
            this.got.setOnClickListener(this.mClickListener);
            this.fsg = (TbImageView) this.anp.findViewById(e.g.video_img_thumbnail);
            this.fsg.setDefaultErrorResource(0);
            this.fsg.setDefaultBgResource(e.f.pic_bg_video_frs);
            this.fsg.setDefaultBgResource(e.d.black_alpha0);
            this.iep = (ImageView) this.anp.findViewById(e.g.video_img_play);
            this.ieq = this.anp.findViewById(e.g.video_view_delete);
            this.ieq.setOnClickListener(this.mClickListener);
            this.ier = (TextView) this.anp.findViewById(e.g.textview_title);
            this.ies = (TextView) this.anp.findViewById(e.g.textview_abstract);
            this.iet = this.anp.findViewById(e.g.view_delete);
            this.iet.setOnClickListener(this.mClickListener);
            this.ien = this.anp.findViewById(e.g.icon_invoke_link);
            this.ien.setOnClickListener(this.mClickListener);
            this.iem = (EditText) this.anp.findViewById(e.g.post_content);
            this.cPI = (TextView) this.anp.findViewById(e.g.textview_error_tip);
            this.ieu = (TextView) this.anp.findViewById(e.g.textview_url);
            this.iev = (LinearLayout) this.anp.findViewById(e.g.url_edit_container);
            this.iew = (EditText) this.anp.findViewById(e.g.url_input);
            this.ieA = (TextView) this.anp.findViewById(e.g.url_desc);
            this.iex = this.anp.findViewById(e.g.url_input_clear);
            this.iey = (TextView) this.anp.findViewById(e.g.url_add);
            this.iey.setEnabled(false);
            this.iez = (FrameLayout) this.anp.findViewById(e.g.url_edit_back_view);
            this.iew.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.iex.setVisibility(8);
                        al.h(k.this.iey, e.d.cp_cont_e);
                        k.this.iey.setEnabled(false);
                        return;
                    }
                    k.this.iex.setVisibility(0);
                    al.h(k.this.iey, e.d.cp_link_tip_a);
                    k.this.iey.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.ieA.getText().equals(k.this.iej.getActivity().getString(e.j.tip_url_not_match))) {
                        k.this.bRG();
                    }
                }
            });
            this.iex.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.iew.setText("");
                    k.this.iex.setVisibility(8);
                    k.this.iey.setEnabled(false);
                }
            });
            this.biQ = new com.baidu.tbadk.core.view.d(this.iej.getPageContext());
            bRG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRG() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.ieA.setText(e.j.tip_url_post);
        } else {
            this.ieA.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        al.h(this.ieA, e.d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.iej.setIsLoading(z);
        if (z) {
            this.ieo.setVisibility(0);
            this.got.setVisibility(8);
            this.iel.startLoad(null, 10, false);
            this.ier.setVisibility(8);
            this.ies.setVisibility(8);
            this.cPI.setVisibility(8);
            this.ieu.setVisibility(0);
            al.h(this.ieu, e.d.cp_cont_f);
            this.ieu.setText(e.j.tip_url_loading);
        } else if (aVar == null) {
            this.ieo.setVisibility(8);
            this.got.setVisibility(8);
            bRH();
        } else {
            if (aVar.hXN == 1) {
                this.ieo.setVisibility(0);
                this.got.setVisibility(8);
                if (aVar.hXM) {
                    this.iel.startLoad(aVar.hXP, 10, false);
                    this.ier.setText(aVar.ass);
                    this.ies.setText(aVar.ast);
                    if (ao.fV(aVar.ass) > 30) {
                        this.ier.setMaxLines(2);
                        this.ies.setMaxLines(1);
                    } else {
                        this.ier.setMaxLines(1);
                        this.ies.setMaxLines(2);
                    }
                    this.ier.setVisibility(0);
                    this.ies.setVisibility(0);
                    this.ieu.setVisibility(8);
                    this.cPI.setVisibility(8);
                } else {
                    this.iel.reset();
                    this.ieu.setText(aVar.linkUrl);
                    al.h(this.ieu, e.d.cp_cont_b);
                    this.ier.setVisibility(8);
                    this.ies.setVisibility(8);
                    this.ieu.setVisibility(0);
                    this.cPI.setVisibility(0);
                }
            } else if (aVar.hXN == 2) {
                this.ieo.setVisibility(8);
                this.got.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.got.getLayoutParams();
                layoutParams.height = ((l.aO(this.iej.getPageContext().getPageActivity()) - ((int) this.iej.getPageContext().getPageActivity().getResources().getDimension(e.C0210e.ds80))) * 9) / 16;
                this.got.setLayoutParams(layoutParams);
                al.c(this.iep, e.f.icon_play_video);
                al.i(this.ieq, e.f.btn_delete_url);
                this.fsg.startLoad(aVar.hXS, 10, false);
            } else {
                this.ieo.setVisibility(0);
                this.got.setVisibility(8);
                this.ier.setVisibility(8);
                this.ies.setVisibility(8);
                this.ieu.setVisibility(0);
                this.cPI.setVisibility(0);
                this.iel.reset();
                this.ieu.setText(aVar.linkUrl);
                al.h(this.ieu, e.d.cp_cont_b);
            }
            bRH();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.iem.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.iej != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.iej.getPageContext(), i);
            }
            al.j(this.mNavigationBar, e.d.cp_bg_line_d);
            al.j(this.anp, e.d.cp_bg_line_d);
            this.iem.setHintTextColor(al.getColor(e.d.cp_cont_e));
            this.iem.setTextColor(al.getColor(e.d.cp_cont_f));
            al.j(this.ieo, e.d.cp_bg_line_e);
            al.h(this.ier, e.d.cp_cont_b);
            al.h(this.ies, e.d.cp_cont_d);
            al.h(this.ieu, e.d.cp_cont_b);
            al.j(this.cPI, e.d.cp_bg_line_d);
            al.h(this.cPI, e.d.cp_cont_d);
            al.i(this.ien, e.f.bg_link_invoke);
            al.j(this.iev, e.d.cp_bg_line_d);
            this.iew.setHintTextColor(al.getColor(e.d.cp_cont_e));
            al.h(this.iew, e.d.cp_cont_b);
            al.h(this.ieA, e.d.cp_cont_d);
            al.h(this.iey, e.d.cp_cont_e);
            al.c(this.iep, e.f.home_ic_video);
            al.i(this.iet, e.f.btn_delete_url);
            al.i(this.iex, e.f.btn_delete_url);
            al.i(this.ieq, e.f.btn_delete_url);
            bRH();
        }
    }

    public void bRH() {
        boolean z;
        if (StringUtils.isNull(bRI())) {
            z = this.ieo.getVisibility() == 0 || this.got.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            al.b(this.iek, e.d.cp_link_tip_a, e.d.s_navbar_title_color);
            this.iek.setEnabled(true);
            return;
        }
        al.c(this.iek, e.d.cp_cont_d, 1);
        this.iek.setEnabled(false);
    }

    public String bRI() {
        if (this.iem == null || this.iem.getText() == null) {
            return null;
        }
        return this.iem.getText().toString();
    }

    public View aVp() {
        return this.fnM;
    }

    public View bRJ() {
        return this.iek;
    }

    public View getRootView() {
        return this.anp;
    }

    public EditText bRK() {
        return this.iem;
    }

    public View bRL() {
        return this.iet;
    }

    public View bRM() {
        return this.ieq;
    }

    public View bRN() {
        return this.ieo;
    }

    public View getVideoContainer() {
        return this.got;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.iew.setText(aVar.linkUrl);
            this.iew.setSelection(aVar.linkUrl.length());
        }
        this.iew.requestFocus();
        l.c(this.iej.getActivity(), this.iew);
        this.iev.setVisibility(0);
        this.iez.setVisibility(0);
        this.ien.setVisibility(8);
    }

    public void bRO() {
        this.iev.setVisibility(8);
        this.iez.setVisibility(8);
        this.ien.setVisibility(0);
        l.b(this.iej.getActivity(), this.iew);
    }

    public void Z(View.OnClickListener onClickListener) {
        this.iev.setOnClickListener(onClickListener);
        this.iez.setOnClickListener(onClickListener);
        this.ien.setOnClickListener(onClickListener);
    }

    public String bRP() {
        if (this.iew == null || this.iew.getText() == null) {
            return null;
        }
        return this.iew.getText().toString();
    }

    public void bRQ() {
        if (this.ieA != null) {
            this.ieA.setText(e.j.tip_url_not_match);
            al.h(this.ieA, e.d.cp_other_b);
        }
    }

    public void aa(View.OnClickListener onClickListener) {
        if (this.iey != null) {
            this.iey.setOnClickListener(onClickListener);
        }
    }

    public View bRR() {
        return this.iev;
    }

    public void destroy() {
        if (this.iem != null) {
            this.iem.addTextChangedListener(null);
        }
        if (this.iew != null) {
            this.iew.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.al(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aH(this.iej.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.iej.getPageContext().getPageActivity().getString(e.j.sand_fail);
                }
                this.iej.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.biQ.d(null);
        this.biQ.ec(e.j.sending);
        this.biQ.bB(true);
    }

    public void closeLoadingDialog() {
        this.biQ.bB(false);
    }
}
