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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes3.dex */
public class k {
    private com.baidu.tbadk.core.view.a aVb;
    private View abp;
    private View eFf;
    private TbImageView eJw;
    private RelativeLayout fIF;
    private WriteUrlActivity hvQ;
    private TextView hvR;
    private TbImageView hvS;
    private EditText hvT;
    private View hvU;
    private LinearLayout hvV;
    private ImageView hvW;
    private View hvX;
    private TextView hvY;
    private TextView hvZ;
    private View hwa;
    private TextView hwb;
    private TextView hwc;
    private LinearLayout hwd;
    private EditText hwe;
    private View hwf;
    private TextView hwg;
    private FrameLayout hwh;
    private TextView hwi;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.eFf = null;
        this.aVb = null;
        if (writeUrlActivity != null) {
            this.hvQ = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.abp = LayoutInflater.from(this.hvQ.getPageContext().getPageActivity()).inflate(d.i.write_url_activity_layout, (ViewGroup) null);
            this.hvQ.setContentView(this.abp);
            this.mNavigationBar = (NavigationBar) this.abp.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.eFf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eFf.getLayoutParams();
                layoutParams.leftMargin = l.e(this.hvQ.getActivity(), d.e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.eFf != null && (this.eFf.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eFf.getLayoutParams();
                layoutParams2.width = -2;
                this.eFf.setLayoutParams(layoutParams2);
            }
            this.abp.setOnClickListener(this.mClickListener);
            this.hvR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.k.send_post));
            al.c(this.hvR, d.C0141d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hvR.getLayoutParams();
            layoutParams3.rightMargin = l.e(this.hvQ.getActivity(), d.e.ds16);
            this.hvR.setLayoutParams(layoutParams3);
            this.hvR.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.k.post_new_thread));
            this.hvS = (TbImageView) this.abp.findViewById(d.g.imageview_picture);
            this.hvS.setDefaultResource(d.f.ic_post_url_n);
            this.hvS.setDefaultErrorResource(d.f.ic_post_url_n);
            this.hvS.setDefaultBgResource(d.C0141d.black_alpha0);
            this.hvV = (LinearLayout) this.abp.findViewById(d.g.view_picture_publish);
            this.hvV.setOnClickListener(this.mClickListener);
            this.fIF = (RelativeLayout) this.abp.findViewById(d.g.video_container);
            this.fIF.setOnClickListener(this.mClickListener);
            this.eJw = (TbImageView) this.abp.findViewById(d.g.video_img_thumbnail);
            this.eJw.setDefaultErrorResource(0);
            this.eJw.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.eJw.setDefaultBgResource(d.C0141d.black_alpha0);
            this.hvW = (ImageView) this.abp.findViewById(d.g.video_img_play);
            this.hvX = this.abp.findViewById(d.g.video_view_delete);
            this.hvX.setOnClickListener(this.mClickListener);
            this.hvY = (TextView) this.abp.findViewById(d.g.textview_title);
            this.hvZ = (TextView) this.abp.findViewById(d.g.textview_abstract);
            this.hwa = this.abp.findViewById(d.g.view_delete);
            this.hwa.setOnClickListener(this.mClickListener);
            this.hvU = this.abp.findViewById(d.g.icon_invoke_link);
            this.hvU.setOnClickListener(this.mClickListener);
            this.hvT = (EditText) this.abp.findViewById(d.g.post_content);
            this.hwb = (TextView) this.abp.findViewById(d.g.textview_error_tip);
            this.hwc = (TextView) this.abp.findViewById(d.g.textview_url);
            this.hwd = (LinearLayout) this.abp.findViewById(d.g.url_edit_container);
            this.hwe = (EditText) this.abp.findViewById(d.g.url_input);
            this.hwi = (TextView) this.abp.findViewById(d.g.url_desc);
            this.hwf = this.abp.findViewById(d.g.url_input_clear);
            this.hwg = (TextView) this.abp.findViewById(d.g.url_add);
            this.hwg.setEnabled(false);
            this.hwh = (FrameLayout) this.abp.findViewById(d.g.url_edit_back_view);
            this.hwe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.hwf.setVisibility(8);
                        al.h(k.this.hwg, d.C0141d.cp_cont_e);
                        k.this.hwg.setEnabled(false);
                        return;
                    }
                    k.this.hwf.setVisibility(0);
                    al.h(k.this.hwg, d.C0141d.cp_link_tip_a);
                    k.this.hwg.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.hwi.getText().equals(k.this.hvQ.getActivity().getString(d.k.tip_url_not_match))) {
                        k.this.bJj();
                    }
                }
            });
            this.hwf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.hwe.setText("");
                    k.this.hwf.setVisibility(8);
                    k.this.hwg.setEnabled(false);
                }
            });
            this.aVb = new com.baidu.tbadk.core.view.a(this.hvQ.getPageContext());
            bJj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJj() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.hwi.setText(d.k.tip_url_post);
        } else {
            this.hwi.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        al.h(this.hwi, d.C0141d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.hvQ.setIsLoading(z);
        if (z) {
            this.hvV.setVisibility(0);
            this.fIF.setVisibility(8);
            this.hvS.startLoad(null, 10, false);
            this.hvY.setVisibility(8);
            this.hvZ.setVisibility(8);
            this.hwb.setVisibility(8);
            this.hwc.setVisibility(0);
            al.h(this.hwc, d.C0141d.cp_cont_f);
            this.hwc.setText(d.k.tip_url_loading);
        } else if (aVar == null) {
            this.hvV.setVisibility(8);
            this.fIF.setVisibility(8);
            bJk();
        } else {
            if (aVar.hpY == 1) {
                this.hvV.setVisibility(0);
                this.fIF.setVisibility(8);
                if (aVar.hpX) {
                    this.hvS.startLoad(aVar.hqa, 10, false);
                    this.hvY.setText(aVar.agx);
                    this.hvZ.setText(aVar.agy);
                    if (ao.eJ(aVar.agx) > 30) {
                        this.hvY.setMaxLines(2);
                        this.hvZ.setMaxLines(1);
                    } else {
                        this.hvY.setMaxLines(1);
                        this.hvZ.setMaxLines(2);
                    }
                    this.hvY.setVisibility(0);
                    this.hvZ.setVisibility(0);
                    this.hwc.setVisibility(8);
                    this.hwb.setVisibility(8);
                } else {
                    this.hvS.reset();
                    this.hwc.setText(aVar.linkUrl);
                    al.h(this.hwc, d.C0141d.cp_cont_b);
                    this.hvY.setVisibility(8);
                    this.hvZ.setVisibility(8);
                    this.hwc.setVisibility(0);
                    this.hwb.setVisibility(0);
                }
            } else if (aVar.hpY == 2) {
                this.hvV.setVisibility(8);
                this.fIF.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.fIF.getLayoutParams();
                layoutParams.height = ((l.ah(this.hvQ.getPageContext().getPageActivity()) - ((int) this.hvQ.getPageContext().getPageActivity().getResources().getDimension(d.e.ds80))) * 9) / 16;
                this.fIF.setLayoutParams(layoutParams);
                al.c(this.hvW, d.f.icon_play_video);
                al.i(this.hvX, d.f.btn_delete_url);
                this.eJw.startLoad(aVar.hqd, 10, false);
            } else {
                this.hvV.setVisibility(0);
                this.fIF.setVisibility(8);
                this.hvY.setVisibility(8);
                this.hvZ.setVisibility(8);
                this.hwc.setVisibility(0);
                this.hwb.setVisibility(0);
                this.hvS.reset();
                this.hwc.setText(aVar.linkUrl);
                al.h(this.hwc, d.C0141d.cp_cont_b);
            }
            bJk();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.hvT.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.hvQ != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hvQ.getPageContext(), i);
            }
            al.j(this.mNavigationBar, d.C0141d.cp_bg_line_d);
            al.j(this.abp, d.C0141d.cp_bg_line_d);
            this.hvT.setHintTextColor(al.getColor(d.C0141d.cp_cont_e));
            this.hvT.setTextColor(al.getColor(d.C0141d.cp_cont_f));
            al.j(this.hvV, d.C0141d.cp_bg_line_e);
            al.h(this.hvY, d.C0141d.cp_cont_b);
            al.h(this.hvZ, d.C0141d.cp_cont_d);
            al.h(this.hwc, d.C0141d.cp_cont_b);
            al.j(this.hwb, d.C0141d.cp_bg_line_d);
            al.h(this.hwb, d.C0141d.cp_cont_d);
            al.i(this.hvU, d.f.bg_link_invoke);
            al.j(this.hwd, d.C0141d.cp_bg_line_d);
            this.hwe.setHintTextColor(al.getColor(d.C0141d.cp_cont_e));
            al.h(this.hwe, d.C0141d.cp_cont_b);
            al.h(this.hwi, d.C0141d.cp_cont_d);
            al.h(this.hwg, d.C0141d.cp_cont_e);
            al.c(this.hvW, d.f.home_ic_video);
            al.i(this.hwa, d.f.btn_delete_url);
            al.i(this.hwf, d.f.btn_delete_url);
            al.i(this.hvX, d.f.btn_delete_url);
            bJk();
        }
    }

    public void bJk() {
        boolean z;
        if (StringUtils.isNull(bJl())) {
            z = this.hvV.getVisibility() == 0 || this.fIF.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            al.b(this.hvR, d.C0141d.cp_link_tip_a, d.C0141d.s_navbar_title_color);
            this.hvR.setEnabled(true);
            return;
        }
        al.c(this.hvR, d.C0141d.cp_cont_d, 1);
        this.hvR.setEnabled(false);
    }

    public String bJl() {
        if (this.hvT == null || this.hvT.getText() == null) {
            return null;
        }
        return this.hvT.getText().toString();
    }

    public View aLH() {
        return this.eFf;
    }

    public View bJm() {
        return this.hvR;
    }

    public View getRootView() {
        return this.abp;
    }

    public EditText bJn() {
        return this.hvT;
    }

    public View bJo() {
        return this.hwa;
    }

    public View bJp() {
        return this.hvX;
    }

    public View bJq() {
        return this.hvV;
    }

    public View getVideoContainer() {
        return this.fIF;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.hwe.setText(aVar.linkUrl);
            this.hwe.setSelection(aVar.linkUrl.length());
        }
        this.hwe.requestFocus();
        l.c(this.hvQ.getActivity(), this.hwe);
        this.hwd.setVisibility(0);
        this.hwh.setVisibility(0);
        this.hvU.setVisibility(8);
    }

    public void bJr() {
        this.hwd.setVisibility(8);
        this.hwh.setVisibility(8);
        this.hvU.setVisibility(0);
        l.b(this.hvQ.getActivity(), this.hwe);
    }

    public void W(View.OnClickListener onClickListener) {
        this.hwd.setOnClickListener(onClickListener);
        this.hwh.setOnClickListener(onClickListener);
        this.hvU.setOnClickListener(onClickListener);
    }

    public String bJs() {
        if (this.hwe == null || this.hwe.getText() == null) {
            return null;
        }
        return this.hwe.getText().toString();
    }

    public void bJt() {
        if (this.hwi != null) {
            this.hwi.setText(d.k.tip_url_not_match);
            al.h(this.hwi, d.C0141d.cp_other_b);
        }
    }

    public void X(View.OnClickListener onClickListener) {
        if (this.hwg != null) {
            this.hwg.setOnClickListener(onClickListener);
        }
    }

    public View bJu() {
        return this.hwd;
    }

    public void destroy() {
        if (this.hvT != null) {
            this.hvT.addTextChangedListener(null);
        }
        if (this.hwe != null) {
            this.hwe.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.tE(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ao(this.hvQ.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.hvQ.getPageContext().getPageActivity().getString(d.k.sand_fail);
                }
                this.hvQ.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.aVb.d(null);
        this.aVb.dc(d.k.sending);
        this.aVb.aM(true);
    }

    public void closeLoadingDialog() {
        this.aVb.aM(false);
    }
}
