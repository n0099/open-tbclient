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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes3.dex */
public class k {
    private View Tl;
    private com.baidu.tbadk.core.view.a aNc;
    private View esG;
    private TbImageView ewS;
    private RelativeLayout fwf;
    private WriteUrlActivity hiR;
    private TextView hiS;
    private TbImageView hiT;
    private EditText hiU;
    private View hiV;
    private LinearLayout hiW;
    private ImageView hiX;
    private View hiY;
    private TextView hiZ;
    private TextView hja;
    private View hjb;
    private TextView hjc;
    private TextView hjd;
    private LinearLayout hje;
    private EditText hjf;
    private View hjg;
    private TextView hjh;
    private FrameLayout hji;
    private TextView hjj;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.esG = null;
        this.aNc = null;
        if (writeUrlActivity != null) {
            this.hiR = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.Tl = LayoutInflater.from(this.hiR.getPageContext().getPageActivity()).inflate(d.i.write_url_activity_layout, (ViewGroup) null);
            this.hiR.setContentView(this.Tl);
            this.mNavigationBar = (NavigationBar) this.Tl.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.esG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.esG.getLayoutParams();
                layoutParams.leftMargin = l.e(this.hiR.getActivity(), d.e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.esG != null && (this.esG.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.esG.getLayoutParams();
                layoutParams2.width = -2;
                this.esG.setLayoutParams(layoutParams2);
            }
            this.Tl.setOnClickListener(this.mClickListener);
            this.hiS = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.k.send_post));
            ak.c(this.hiS, d.C0126d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hiS.getLayoutParams();
            layoutParams3.rightMargin = l.e(this.hiR.getActivity(), d.e.ds16);
            this.hiS.setLayoutParams(layoutParams3);
            this.hiS.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.k.post_new_thread));
            this.hiT = (TbImageView) this.Tl.findViewById(d.g.imageview_picture);
            this.hiT.setDefaultResource(d.f.ic_post_url_n);
            this.hiT.setDefaultErrorResource(d.f.ic_post_url_n);
            this.hiT.setDefaultBgResource(d.C0126d.black_alpha0);
            this.hiW = (LinearLayout) this.Tl.findViewById(d.g.view_picture_publish);
            this.hiW.setOnClickListener(this.mClickListener);
            this.fwf = (RelativeLayout) this.Tl.findViewById(d.g.video_container);
            this.fwf.setOnClickListener(this.mClickListener);
            this.ewS = (TbImageView) this.Tl.findViewById(d.g.video_img_thumbnail);
            this.ewS.setDefaultErrorResource(0);
            this.ewS.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.ewS.setDefaultBgResource(d.C0126d.black_alpha0);
            this.hiX = (ImageView) this.Tl.findViewById(d.g.video_img_play);
            this.hiY = this.Tl.findViewById(d.g.video_view_delete);
            this.hiY.setOnClickListener(this.mClickListener);
            this.hiZ = (TextView) this.Tl.findViewById(d.g.textview_title);
            this.hja = (TextView) this.Tl.findViewById(d.g.textview_abstract);
            this.hjb = this.Tl.findViewById(d.g.view_delete);
            this.hjb.setOnClickListener(this.mClickListener);
            this.hiV = this.Tl.findViewById(d.g.icon_invoke_link);
            this.hiV.setOnClickListener(this.mClickListener);
            this.hiU = (EditText) this.Tl.findViewById(d.g.post_content);
            this.hjc = (TextView) this.Tl.findViewById(d.g.textview_error_tip);
            this.hjd = (TextView) this.Tl.findViewById(d.g.textview_url);
            this.hje = (LinearLayout) this.Tl.findViewById(d.g.url_edit_container);
            this.hjf = (EditText) this.Tl.findViewById(d.g.url_input);
            this.hjj = (TextView) this.Tl.findViewById(d.g.url_desc);
            this.hjg = this.Tl.findViewById(d.g.url_input_clear);
            this.hjh = (TextView) this.Tl.findViewById(d.g.url_add);
            this.hjh.setEnabled(false);
            this.hji = (FrameLayout) this.Tl.findViewById(d.g.url_edit_back_view);
            this.hjf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.hjg.setVisibility(8);
                        ak.h(k.this.hjh, d.C0126d.cp_cont_e);
                        k.this.hjh.setEnabled(false);
                        return;
                    }
                    k.this.hjg.setVisibility(0);
                    ak.h(k.this.hjh, d.C0126d.cp_link_tip_a);
                    k.this.hjh.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.hjj.getText().equals(k.this.hiR.getActivity().getString(d.k.tip_url_not_match))) {
                        k.this.bEg();
                    }
                }
            });
            this.hjg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    k.this.hjf.setText("");
                    k.this.hjg.setVisibility(8);
                    k.this.hjh.setEnabled(false);
                }
            });
            this.aNc = new com.baidu.tbadk.core.view.a(this.hiR.getPageContext());
            bEg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEg() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.hjj.setText(d.k.tip_url_post);
        } else {
            this.hjj.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        ak.h(this.hjj, d.C0126d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.hiR.setIsLoading(z);
        if (z) {
            this.hiW.setVisibility(0);
            this.fwf.setVisibility(8);
            this.hiT.startLoad(null, 10, false);
            this.hiZ.setVisibility(8);
            this.hja.setVisibility(8);
            this.hjc.setVisibility(8);
            this.hjd.setVisibility(0);
            ak.h(this.hjd, d.C0126d.cp_cont_f);
            this.hjd.setText(d.k.tip_url_loading);
        } else if (aVar == null) {
            this.hiW.setVisibility(8);
            this.fwf.setVisibility(8);
            bEh();
        } else {
            if (aVar.hcZ == 1) {
                this.hiW.setVisibility(0);
                this.fwf.setVisibility(8);
                if (aVar.hcY) {
                    this.hiT.startLoad(aVar.hdb, 10, false);
                    this.hiZ.setText(aVar.Yv);
                    this.hja.setText(aVar.Yw);
                    if (an.ek(aVar.Yv) > 30) {
                        this.hiZ.setMaxLines(2);
                        this.hja.setMaxLines(1);
                    } else {
                        this.hiZ.setMaxLines(1);
                        this.hja.setMaxLines(2);
                    }
                    this.hiZ.setVisibility(0);
                    this.hja.setVisibility(0);
                    this.hjd.setVisibility(8);
                    this.hjc.setVisibility(8);
                } else {
                    this.hiT.reset();
                    this.hjd.setText(aVar.linkUrl);
                    ak.h(this.hjd, d.C0126d.cp_cont_b);
                    this.hiZ.setVisibility(8);
                    this.hja.setVisibility(8);
                    this.hjd.setVisibility(0);
                    this.hjc.setVisibility(0);
                }
            } else if (aVar.hcZ == 2) {
                this.hiW.setVisibility(8);
                this.fwf.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.fwf.getLayoutParams();
                layoutParams.height = ((l.af(this.hiR.getPageContext().getPageActivity()) - ((int) this.hiR.getPageContext().getPageActivity().getResources().getDimension(d.e.ds80))) * 9) / 16;
                this.fwf.setLayoutParams(layoutParams);
                ak.c(this.hiX, d.f.icon_play_video);
                ak.i(this.hiY, d.f.btn_delete_url);
                this.ewS.startLoad(aVar.hde, 10, false);
            } else {
                this.hiW.setVisibility(0);
                this.fwf.setVisibility(8);
                this.hiZ.setVisibility(8);
                this.hja.setVisibility(8);
                this.hjd.setVisibility(0);
                this.hjc.setVisibility(0);
                this.hiT.reset();
                this.hjd.setText(aVar.linkUrl);
                ak.h(this.hjd, d.C0126d.cp_cont_b);
            }
            bEh();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.hiU.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.hiR != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hiR.getPageContext(), i);
            }
            ak.j(this.mNavigationBar, d.C0126d.cp_bg_line_d);
            ak.j(this.Tl, d.C0126d.cp_bg_line_d);
            this.hiU.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
            this.hiU.setTextColor(ak.getColor(d.C0126d.cp_cont_f));
            ak.j(this.hiW, d.C0126d.cp_bg_line_e);
            ak.h(this.hiZ, d.C0126d.cp_cont_b);
            ak.h(this.hja, d.C0126d.cp_cont_d);
            ak.h(this.hjd, d.C0126d.cp_cont_b);
            ak.j(this.hjc, d.C0126d.cp_bg_line_d);
            ak.h(this.hjc, d.C0126d.cp_cont_d);
            ak.i(this.hiV, d.f.bg_link_invoke);
            ak.j(this.hje, d.C0126d.cp_bg_line_d);
            this.hjf.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
            ak.h(this.hjf, d.C0126d.cp_cont_b);
            ak.h(this.hjj, d.C0126d.cp_cont_d);
            ak.h(this.hjh, d.C0126d.cp_cont_e);
            ak.c(this.hiX, d.f.home_ic_video);
            ak.i(this.hjb, d.f.btn_delete_url);
            ak.i(this.hjg, d.f.btn_delete_url);
            ak.i(this.hiY, d.f.btn_delete_url);
            bEh();
        }
    }

    public void bEh() {
        boolean z;
        if (StringUtils.isNull(bEi())) {
            z = this.hiW.getVisibility() == 0 || this.fwf.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            ak.b(this.hiS, d.C0126d.cp_link_tip_a, d.C0126d.s_navbar_title_color);
            this.hiS.setEnabled(true);
            return;
        }
        ak.c(this.hiS, d.C0126d.cp_cont_d, 1);
        this.hiS.setEnabled(false);
    }

    public String bEi() {
        if (this.hiU == null || this.hiU.getText() == null) {
            return null;
        }
        return this.hiU.getText().toString();
    }

    public View aGO() {
        return this.esG;
    }

    public View bEj() {
        return this.hiS;
    }

    public View getRootView() {
        return this.Tl;
    }

    public EditText bEk() {
        return this.hiU;
    }

    public View bEl() {
        return this.hjb;
    }

    public View bEm() {
        return this.hiY;
    }

    public View bEn() {
        return this.hiW;
    }

    public View getVideoContainer() {
        return this.fwf;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.hjf.setText(aVar.linkUrl);
            this.hjf.setSelection(aVar.linkUrl.length());
        }
        this.hjf.requestFocus();
        l.c(this.hiR.getActivity(), this.hjf);
        this.hje.setVisibility(0);
        this.hji.setVisibility(0);
        this.hiV.setVisibility(8);
    }

    public void bEo() {
        this.hje.setVisibility(8);
        this.hji.setVisibility(8);
        this.hiV.setVisibility(0);
        l.b(this.hiR.getActivity(), this.hjf);
    }

    public void W(View.OnClickListener onClickListener) {
        this.hje.setOnClickListener(onClickListener);
        this.hji.setOnClickListener(onClickListener);
        this.hiV.setOnClickListener(onClickListener);
    }

    public String bEp() {
        if (this.hjf == null || this.hjf.getText() == null) {
            return null;
        }
        return this.hjf.getText().toString();
    }

    public void bEq() {
        if (this.hjj != null) {
            this.hjj.setText(d.k.tip_url_not_match);
            ak.h(this.hjj, d.C0126d.cp_other_b);
        }
    }

    public void X(View.OnClickListener onClickListener) {
        if (this.hjh != null) {
            this.hjh.setOnClickListener(onClickListener);
        }
    }

    public View bEr() {
        return this.hje;
    }

    public void destroy() {
        if (this.hiU != null) {
            this.hiU.addTextChangedListener(null);
        }
        if (this.hjf != null) {
            this.hjf.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.tt(postWriteCallBackData.getErrorCode())) {
                AntiHelper.am(this.hiR.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.hiR.getPageContext().getPageActivity().getString(d.k.sand_fail);
                }
                this.hiR.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.aNc.d(null);
        this.aNc.cZ(d.k.sending);
        this.aNc.aI(true);
    }

    public void closeLoadingDialog() {
        this.aNc.aI(false);
    }
}
