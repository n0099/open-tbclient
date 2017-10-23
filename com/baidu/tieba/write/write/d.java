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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class d {
    private View Rh;
    private com.baidu.tbadk.core.view.a aLe;
    private View.OnClickListener aOR;
    private View dLn;
    private TbImageView dUf;
    private RelativeLayout eSX;
    private WriteUrlActivity gNP;
    private TextView gNQ;
    private TbImageView gNR;
    private EditText gNS;
    private View gNT;
    private LinearLayout gNU;
    private ImageView gNV;
    private View gNW;
    private TextView gNX;
    private TextView gNY;
    private View gNZ;
    private TextView gOa;
    private TextView gOb;
    private LinearLayout gOc;
    private EditText gOd;
    private View gOe;
    private TextView gOf;
    private FrameLayout gOg;
    private TextView gOh;
    private NavigationBar mNavigationBar;

    public d(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.dLn = null;
        this.aLe = null;
        if (writeUrlActivity != null) {
            this.gNP = writeUrlActivity;
            this.aOR = onClickListener;
            this.Rh = LayoutInflater.from(this.gNP.getPageContext().getPageActivity()).inflate(d.j.write_url_activity_layout, (ViewGroup) null);
            this.gNP.setContentView(this.Rh);
            this.mNavigationBar = (NavigationBar) this.Rh.findViewById(d.h.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.dLn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aOR);
            this.mNavigationBar.setmBackImageViewBg(d.g.write_close_selector, d.g.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dLn.getLayoutParams();
                layoutParams.leftMargin = l.f(this.gNP.getActivity(), d.f.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.dLn != null && (this.dLn.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dLn.getLayoutParams();
                layoutParams2.width = -2;
                this.dLn.setLayoutParams(layoutParams2);
            }
            this.Rh.setOnClickListener(this.aOR);
            this.gNQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.l.send_post));
            aj.c(this.gNQ, d.e.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.gNQ.getLayoutParams();
            layoutParams3.rightMargin = l.f(this.gNP.getActivity(), d.f.ds16);
            this.gNQ.setLayoutParams(layoutParams3);
            this.gNQ.setOnClickListener(this.aOR);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.l.post_new_thread));
            this.gNR = (TbImageView) this.Rh.findViewById(d.h.imageview_picture);
            this.gNR.setDefaultResource(d.g.ic_post_url_n);
            this.gNR.setDefaultErrorResource(d.g.ic_post_url_n);
            this.gNR.setDefaultBgResource(d.e.black_alpha0);
            this.gNU = (LinearLayout) this.Rh.findViewById(d.h.view_picture_publish);
            this.gNU.setOnClickListener(this.aOR);
            this.eSX = (RelativeLayout) this.Rh.findViewById(d.h.video_container);
            this.eSX.setOnClickListener(this.aOR);
            this.dUf = (TbImageView) this.Rh.findViewById(d.h.video_img_thumbnail);
            this.dUf.setDefaultErrorResource(0);
            this.dUf.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.dUf.setDefaultBgResource(d.e.black_alpha0);
            this.gNV = (ImageView) this.Rh.findViewById(d.h.video_img_play);
            this.gNW = this.Rh.findViewById(d.h.video_view_delete);
            this.gNW.setOnClickListener(this.aOR);
            this.gNX = (TextView) this.Rh.findViewById(d.h.textview_title);
            this.gNY = (TextView) this.Rh.findViewById(d.h.textview_abstract);
            this.gNZ = this.Rh.findViewById(d.h.view_delete);
            this.gNZ.setOnClickListener(this.aOR);
            this.gNT = this.Rh.findViewById(d.h.icon_invoke_link);
            this.gNT.setOnClickListener(this.aOR);
            this.gNS = (EditText) this.Rh.findViewById(d.h.post_content);
            this.gNS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.d.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    d.this.bBP();
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }
            });
            this.gOa = (TextView) this.Rh.findViewById(d.h.textview_error_tip);
            this.gOb = (TextView) this.Rh.findViewById(d.h.textview_url);
            this.gOc = (LinearLayout) this.Rh.findViewById(d.h.url_edit_container);
            this.gOd = (EditText) this.Rh.findViewById(d.h.url_input);
            this.gOh = (TextView) this.Rh.findViewById(d.h.url_desc);
            this.gOe = this.Rh.findViewById(d.h.url_input_clear);
            this.gOf = (TextView) this.Rh.findViewById(d.h.url_add);
            this.gOf.setEnabled(false);
            this.gOg = (FrameLayout) this.Rh.findViewById(d.h.url_edit_back_view);
            this.gOd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.d.2
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        d.this.gOe.setVisibility(8);
                        aj.i(d.this.gOf, d.e.cp_cont_e);
                        d.this.gOf.setEnabled(false);
                        return;
                    }
                    d.this.gOe.setVisibility(0);
                    aj.i(d.this.gOf, d.e.cp_link_tip_a);
                    d.this.gOf.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (d.this.gOh.getText().equals(d.this.gNP.getActivity().getString(d.l.tip_url_not_match))) {
                        d.this.bBO();
                    }
                }
            });
            this.gOe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.gOd.setText("");
                    d.this.gOe.setVisibility(8);
                    d.this.gOf.setEnabled(false);
                }
            });
            this.aLe = new com.baidu.tbadk.core.view.a(this.gNP.getPageContext());
            bBO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBO() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.gOh.setText(d.l.tip_url_post);
        } else {
            this.gOh.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        aj.i(this.gOh, d.e.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.gNP.setIsLoading(z);
        if (z) {
            this.gNU.setVisibility(0);
            this.eSX.setVisibility(8);
            this.gNR.c(null, 10, false);
            this.gNX.setVisibility(8);
            this.gNY.setVisibility(8);
            this.gOa.setVisibility(8);
            this.gOb.setVisibility(0);
            aj.i(this.gOb, d.e.cp_cont_f);
            this.gOb.setText(d.l.tip_url_loading);
        } else if (aVar == null) {
            this.gNU.setVisibility(8);
            this.eSX.setVisibility(8);
            bBP();
        } else {
            if (aVar.gHZ == 1) {
                this.gNU.setVisibility(0);
                this.eSX.setVisibility(8);
                if (aVar.gHY) {
                    this.gNR.c(aVar.gIb, 10, false);
                    this.gNX.setText(aVar.WH);
                    this.gNY.setText(aVar.WI);
                    if (am.dN(aVar.WH) > 30) {
                        this.gNX.setMaxLines(2);
                        this.gNY.setMaxLines(1);
                    } else {
                        this.gNX.setMaxLines(1);
                        this.gNY.setMaxLines(2);
                    }
                    this.gNX.setVisibility(0);
                    this.gNY.setVisibility(0);
                    this.gOb.setVisibility(8);
                    this.gOa.setVisibility(8);
                } else {
                    this.gNR.reset();
                    this.gOb.setText(aVar.linkUrl);
                    aj.i(this.gOb, d.e.cp_cont_b);
                    this.gNX.setVisibility(8);
                    this.gNY.setVisibility(8);
                    this.gOb.setVisibility(0);
                    this.gOa.setVisibility(0);
                }
            } else if (aVar.gHZ == 2) {
                this.gNU.setVisibility(8);
                this.eSX.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.eSX.getLayoutParams();
                layoutParams.height = ((l.ad(this.gNP.getPageContext().getPageActivity()) - ((int) this.gNP.getPageContext().getPageActivity().getResources().getDimension(d.f.ds80))) * 9) / 16;
                this.eSX.setLayoutParams(layoutParams);
                aj.c(this.gNV, d.g.icon_play_video);
                aj.j(this.gNW, d.g.btn_delete_url);
                this.dUf.c(aVar.gIe, 10, false);
            } else {
                this.gNU.setVisibility(0);
                this.eSX.setVisibility(8);
                this.gNX.setVisibility(8);
                this.gNY.setVisibility(8);
                this.gOb.setVisibility(0);
                this.gOa.setVisibility(0);
                this.gNR.reset();
                this.gOb.setText(aVar.linkUrl);
                aj.i(this.gOb, d.e.cp_cont_b);
            }
            bBP();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gNP != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.gNP.getPageContext(), i);
            }
            aj.k(this.mNavigationBar, d.e.cp_bg_line_d);
            aj.k(this.Rh, d.e.cp_bg_line_d);
            this.gNS.setHintTextColor(aj.getColor(d.e.cp_cont_e));
            this.gNS.setTextColor(aj.getColor(d.e.cp_cont_f));
            aj.k(this.gNU, d.e.cp_bg_line_e);
            aj.i(this.gNX, d.e.cp_cont_b);
            aj.i(this.gNY, d.e.cp_cont_d);
            aj.i(this.gOb, d.e.cp_cont_b);
            aj.k(this.gOa, d.e.cp_bg_line_d);
            aj.i(this.gOa, d.e.cp_cont_d);
            aj.j(this.gNT, d.g.bg_link_invoke);
            aj.k(this.gOc, d.e.cp_bg_line_d);
            this.gOd.setHintTextColor(aj.getColor(d.e.cp_cont_e));
            aj.i(this.gOd, d.e.cp_cont_b);
            aj.i(this.gOh, d.e.cp_cont_d);
            aj.i(this.gOf, d.e.cp_cont_e);
            aj.c(this.gNV, d.g.home_ic_video);
            aj.j(this.gNZ, d.g.btn_delete_url);
            aj.j(this.gOe, d.g.btn_delete_url);
            aj.j(this.gNW, d.g.btn_delete_url);
            bBP();
        }
    }

    public void bBP() {
        boolean z;
        if (StringUtils.isNull(bBQ())) {
            z = this.gNU.getVisibility() == 0 || this.eSX.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            aj.b(this.gNQ, d.e.cp_link_tip_a, d.e.s_navbar_title_color);
            this.gNQ.setEnabled(true);
            return;
        }
        aj.c(this.gNQ, d.e.cp_cont_d, 1);
        this.gNQ.setEnabled(false);
    }

    public String bBQ() {
        if (this.gNS == null || this.gNS.getText() == null) {
            return null;
        }
        return this.gNS.getText().toString();
    }

    public View ayS() {
        return this.dLn;
    }

    public View bBR() {
        return this.gNQ;
    }

    public View getRootView() {
        return this.Rh;
    }

    public View bBS() {
        return this.gNS;
    }

    public View bnO() {
        return this.gNZ;
    }

    public View bBT() {
        return this.gNW;
    }

    public View bBU() {
        return this.gNU;
    }

    public View getVideoContainer() {
        return this.eSX;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.gOd.setText(aVar.linkUrl);
            this.gOd.setSelection(aVar.linkUrl.length());
        }
        this.gOd.requestFocus();
        l.b(this.gNP.getActivity(), this.gOd);
        this.gOc.setVisibility(0);
        this.gOg.setVisibility(0);
        this.gNT.setVisibility(8);
    }

    public void bBV() {
        this.gOc.setVisibility(8);
        this.gOg.setVisibility(8);
        this.gNT.setVisibility(0);
        l.a(this.gNP.getActivity(), this.gOd);
    }

    public void T(View.OnClickListener onClickListener) {
        this.gOc.setOnClickListener(onClickListener);
        this.gOg.setOnClickListener(onClickListener);
        this.gNT.setOnClickListener(onClickListener);
    }

    public String bBW() {
        if (this.gOd == null || this.gOd.getText() == null) {
            return null;
        }
        return this.gOd.getText().toString();
    }

    public void bBX() {
        if (this.gOh != null) {
            this.gOh.setText(d.l.tip_url_not_match);
            aj.i(this.gOh, d.e.cp_other_b);
        }
    }

    public void U(View.OnClickListener onClickListener) {
        if (this.gOf != null) {
            this.gOf.setOnClickListener(onClickListener);
        }
    }

    public View bBY() {
        return this.gOc;
    }

    public void destroy() {
        if (this.gNS != null) {
            this.gNS.addTextChangedListener(null);
        }
        if (this.gOd != null) {
            this.gOd.addTextChangedListener(null);
        }
    }

    public void e(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.tF(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ao(this.gNP.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.gNP.getPageContext().getPageActivity().getString(d.l.error_write);
                }
                this.gNP.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.aLe.c(null);
        this.aLe.da(d.l.sending);
        this.aLe.aG(true);
    }

    public void closeLoadingDialog() {
        this.aLe.aG(false);
    }
}
