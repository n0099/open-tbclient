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
    private View ano;
    private com.baidu.tbadk.core.view.d biP;
    private TextView cPH;
    private View fnL;
    private TbImageView fsf;
    private RelativeLayout gos;
    private WriteUrlActivity iei;
    private TextView iej;
    private TbImageView iek;
    private EditText iel;
    private View iem;
    private LinearLayout ien;
    private ImageView ieo;
    private View iep;
    private TextView ieq;
    private TextView ier;
    private View ies;
    private TextView iet;
    private LinearLayout ieu;
    private EditText iev;
    private View iew;
    private TextView iex;
    private FrameLayout iey;
    private TextView iez;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.fnL = null;
        this.biP = null;
        if (writeUrlActivity != null) {
            this.iei = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.ano = LayoutInflater.from(this.iei.getPageContext().getPageActivity()).inflate(e.h.write_url_activity_layout, (ViewGroup) null);
            this.iei.setContentView(this.ano);
            this.mNavigationBar = (NavigationBar) this.ano.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.fnL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(e.f.write_close_selector, e.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fnL.getLayoutParams();
                layoutParams.leftMargin = l.h(this.iei.getActivity(), e.C0210e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.fnL != null && (this.fnL.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fnL.getLayoutParams();
                layoutParams2.width = -2;
                this.fnL.setLayoutParams(layoutParams2);
            }
            this.ano.setOnClickListener(this.mClickListener);
            this.iej = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(e.j.send_post));
            al.c(this.iej, e.d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.iej.getLayoutParams();
            layoutParams3.rightMargin = l.h(this.iei.getActivity(), e.C0210e.ds16);
            this.iej.setLayoutParams(layoutParams3);
            this.iej.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(e.j.post_new_thread));
            this.iek = (TbImageView) this.ano.findViewById(e.g.imageview_picture);
            this.iek.setDefaultResource(e.f.ic_post_url_n);
            this.iek.setDefaultErrorResource(e.f.ic_post_url_n);
            this.iek.setDefaultBgResource(e.d.black_alpha0);
            this.ien = (LinearLayout) this.ano.findViewById(e.g.view_picture_publish);
            this.ien.setOnClickListener(this.mClickListener);
            this.gos = (RelativeLayout) this.ano.findViewById(e.g.video_container);
            this.gos.setOnClickListener(this.mClickListener);
            this.fsf = (TbImageView) this.ano.findViewById(e.g.video_img_thumbnail);
            this.fsf.setDefaultErrorResource(0);
            this.fsf.setDefaultBgResource(e.f.pic_bg_video_frs);
            this.fsf.setDefaultBgResource(e.d.black_alpha0);
            this.ieo = (ImageView) this.ano.findViewById(e.g.video_img_play);
            this.iep = this.ano.findViewById(e.g.video_view_delete);
            this.iep.setOnClickListener(this.mClickListener);
            this.ieq = (TextView) this.ano.findViewById(e.g.textview_title);
            this.ier = (TextView) this.ano.findViewById(e.g.textview_abstract);
            this.ies = this.ano.findViewById(e.g.view_delete);
            this.ies.setOnClickListener(this.mClickListener);
            this.iem = this.ano.findViewById(e.g.icon_invoke_link);
            this.iem.setOnClickListener(this.mClickListener);
            this.iel = (EditText) this.ano.findViewById(e.g.post_content);
            this.cPH = (TextView) this.ano.findViewById(e.g.textview_error_tip);
            this.iet = (TextView) this.ano.findViewById(e.g.textview_url);
            this.ieu = (LinearLayout) this.ano.findViewById(e.g.url_edit_container);
            this.iev = (EditText) this.ano.findViewById(e.g.url_input);
            this.iez = (TextView) this.ano.findViewById(e.g.url_desc);
            this.iew = this.ano.findViewById(e.g.url_input_clear);
            this.iex = (TextView) this.ano.findViewById(e.g.url_add);
            this.iex.setEnabled(false);
            this.iey = (FrameLayout) this.ano.findViewById(e.g.url_edit_back_view);
            this.iev.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.iew.setVisibility(8);
                        al.h(k.this.iex, e.d.cp_cont_e);
                        k.this.iex.setEnabled(false);
                        return;
                    }
                    k.this.iew.setVisibility(0);
                    al.h(k.this.iex, e.d.cp_link_tip_a);
                    k.this.iex.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.iez.getText().equals(k.this.iei.getActivity().getString(e.j.tip_url_not_match))) {
                        k.this.bRG();
                    }
                }
            });
            this.iew.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.iev.setText("");
                    k.this.iew.setVisibility(8);
                    k.this.iex.setEnabled(false);
                }
            });
            this.biP = new com.baidu.tbadk.core.view.d(this.iei.getPageContext());
            bRG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRG() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.iez.setText(e.j.tip_url_post);
        } else {
            this.iez.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        al.h(this.iez, e.d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.iei.setIsLoading(z);
        if (z) {
            this.ien.setVisibility(0);
            this.gos.setVisibility(8);
            this.iek.startLoad(null, 10, false);
            this.ieq.setVisibility(8);
            this.ier.setVisibility(8);
            this.cPH.setVisibility(8);
            this.iet.setVisibility(0);
            al.h(this.iet, e.d.cp_cont_f);
            this.iet.setText(e.j.tip_url_loading);
        } else if (aVar == null) {
            this.ien.setVisibility(8);
            this.gos.setVisibility(8);
            bRH();
        } else {
            if (aVar.hXM == 1) {
                this.ien.setVisibility(0);
                this.gos.setVisibility(8);
                if (aVar.hXL) {
                    this.iek.startLoad(aVar.hXO, 10, false);
                    this.ieq.setText(aVar.asr);
                    this.ier.setText(aVar.ass);
                    if (ao.fV(aVar.asr) > 30) {
                        this.ieq.setMaxLines(2);
                        this.ier.setMaxLines(1);
                    } else {
                        this.ieq.setMaxLines(1);
                        this.ier.setMaxLines(2);
                    }
                    this.ieq.setVisibility(0);
                    this.ier.setVisibility(0);
                    this.iet.setVisibility(8);
                    this.cPH.setVisibility(8);
                } else {
                    this.iek.reset();
                    this.iet.setText(aVar.linkUrl);
                    al.h(this.iet, e.d.cp_cont_b);
                    this.ieq.setVisibility(8);
                    this.ier.setVisibility(8);
                    this.iet.setVisibility(0);
                    this.cPH.setVisibility(0);
                }
            } else if (aVar.hXM == 2) {
                this.ien.setVisibility(8);
                this.gos.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.gos.getLayoutParams();
                layoutParams.height = ((l.aO(this.iei.getPageContext().getPageActivity()) - ((int) this.iei.getPageContext().getPageActivity().getResources().getDimension(e.C0210e.ds80))) * 9) / 16;
                this.gos.setLayoutParams(layoutParams);
                al.c(this.ieo, e.f.icon_play_video);
                al.i(this.iep, e.f.btn_delete_url);
                this.fsf.startLoad(aVar.hXR, 10, false);
            } else {
                this.ien.setVisibility(0);
                this.gos.setVisibility(8);
                this.ieq.setVisibility(8);
                this.ier.setVisibility(8);
                this.iet.setVisibility(0);
                this.cPH.setVisibility(0);
                this.iek.reset();
                this.iet.setText(aVar.linkUrl);
                al.h(this.iet, e.d.cp_cont_b);
            }
            bRH();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.iel.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.iei != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.iei.getPageContext(), i);
            }
            al.j(this.mNavigationBar, e.d.cp_bg_line_d);
            al.j(this.ano, e.d.cp_bg_line_d);
            this.iel.setHintTextColor(al.getColor(e.d.cp_cont_e));
            this.iel.setTextColor(al.getColor(e.d.cp_cont_f));
            al.j(this.ien, e.d.cp_bg_line_e);
            al.h(this.ieq, e.d.cp_cont_b);
            al.h(this.ier, e.d.cp_cont_d);
            al.h(this.iet, e.d.cp_cont_b);
            al.j(this.cPH, e.d.cp_bg_line_d);
            al.h(this.cPH, e.d.cp_cont_d);
            al.i(this.iem, e.f.bg_link_invoke);
            al.j(this.ieu, e.d.cp_bg_line_d);
            this.iev.setHintTextColor(al.getColor(e.d.cp_cont_e));
            al.h(this.iev, e.d.cp_cont_b);
            al.h(this.iez, e.d.cp_cont_d);
            al.h(this.iex, e.d.cp_cont_e);
            al.c(this.ieo, e.f.home_ic_video);
            al.i(this.ies, e.f.btn_delete_url);
            al.i(this.iew, e.f.btn_delete_url);
            al.i(this.iep, e.f.btn_delete_url);
            bRH();
        }
    }

    public void bRH() {
        boolean z;
        if (StringUtils.isNull(bRI())) {
            z = this.ien.getVisibility() == 0 || this.gos.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            al.b(this.iej, e.d.cp_link_tip_a, e.d.s_navbar_title_color);
            this.iej.setEnabled(true);
            return;
        }
        al.c(this.iej, e.d.cp_cont_d, 1);
        this.iej.setEnabled(false);
    }

    public String bRI() {
        if (this.iel == null || this.iel.getText() == null) {
            return null;
        }
        return this.iel.getText().toString();
    }

    public View aVp() {
        return this.fnL;
    }

    public View bRJ() {
        return this.iej;
    }

    public View getRootView() {
        return this.ano;
    }

    public EditText bRK() {
        return this.iel;
    }

    public View bRL() {
        return this.ies;
    }

    public View bRM() {
        return this.iep;
    }

    public View bRN() {
        return this.ien;
    }

    public View getVideoContainer() {
        return this.gos;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.iev.setText(aVar.linkUrl);
            this.iev.setSelection(aVar.linkUrl.length());
        }
        this.iev.requestFocus();
        l.c(this.iei.getActivity(), this.iev);
        this.ieu.setVisibility(0);
        this.iey.setVisibility(0);
        this.iem.setVisibility(8);
    }

    public void bRO() {
        this.ieu.setVisibility(8);
        this.iey.setVisibility(8);
        this.iem.setVisibility(0);
        l.b(this.iei.getActivity(), this.iev);
    }

    public void Z(View.OnClickListener onClickListener) {
        this.ieu.setOnClickListener(onClickListener);
        this.iey.setOnClickListener(onClickListener);
        this.iem.setOnClickListener(onClickListener);
    }

    public String bRP() {
        if (this.iev == null || this.iev.getText() == null) {
            return null;
        }
        return this.iev.getText().toString();
    }

    public void bRQ() {
        if (this.iez != null) {
            this.iez.setText(e.j.tip_url_not_match);
            al.h(this.iez, e.d.cp_other_b);
        }
    }

    public void aa(View.OnClickListener onClickListener) {
        if (this.iex != null) {
            this.iex.setOnClickListener(onClickListener);
        }
    }

    public View bRR() {
        return this.ieu;
    }

    public void destroy() {
        if (this.iel != null) {
            this.iel.addTextChangedListener(null);
        }
        if (this.iev != null) {
            this.iev.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.al(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aH(this.iei.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.iei.getPageContext().getPageActivity().getString(e.j.sand_fail);
                }
                this.iei.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.biP.d(null);
        this.biP.ec(e.j.sending);
        this.biP.bB(true);
    }

    public void closeLoadingDialog() {
        this.biP.bB(false);
    }
}
