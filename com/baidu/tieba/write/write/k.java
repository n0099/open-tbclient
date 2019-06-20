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
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes3.dex */
public class k {
    private View bBg;
    private View bBi;
    private com.baidu.tbadk.core.view.b cAX;
    private TbImageView gZv;
    private RelativeLayout hWp;
    private WriteUrlActivity jOa;
    private TextView jOb;
    private TbImageView jOc;
    private EditText jOd;
    private View jOe;
    private LinearLayout jOf;
    private ImageView jOg;
    private View jOh;
    private TextView jOi;
    private TextView jOj;
    private View jOk;
    private TextView jOl;
    private TextView jOm;
    private LinearLayout jOn;
    private EditText jOo;
    private View jOp;
    private TextView jOq;
    private FrameLayout jOr;
    private TextView jOs;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.bBi = null;
        this.cAX = null;
        if (writeUrlActivity != null) {
            this.jOa = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.bBg = LayoutInflater.from(this.jOa.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.jOa.setContentView(this.bBg);
            this.mNavigationBar = (NavigationBar) this.bBg.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.bBi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.write_close_selector, R.drawable.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bBi.getLayoutParams();
                layoutParams.leftMargin = l.g(this.jOa.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.bBi != null && (this.bBi.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bBi.getLayoutParams();
                layoutParams2.width = -2;
                this.bBi.setLayoutParams(layoutParams2);
            }
            this.bBg.setOnClickListener(this.mClickListener);
            this.jOb = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            al.f(this.jOb, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.jOb.getLayoutParams();
            layoutParams3.rightMargin = l.g(this.jOa.getActivity(), R.dimen.ds16);
            this.jOb.setLayoutParams(layoutParams3);
            this.jOb.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.jOc = (TbImageView) this.bBg.findViewById(R.id.imageview_picture);
            this.jOc.setDefaultResource(R.drawable.ic_post_url_n);
            this.jOc.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.jOc.setDefaultBgResource(R.color.black_alpha0);
            this.jOf = (LinearLayout) this.bBg.findViewById(R.id.view_picture_publish);
            this.jOf.setOnClickListener(this.mClickListener);
            this.hWp = (RelativeLayout) this.bBg.findViewById(R.id.video_container);
            this.hWp.setOnClickListener(this.mClickListener);
            this.gZv = (TbImageView) this.bBg.findViewById(R.id.video_img_thumbnail);
            this.gZv.setDefaultErrorResource(0);
            this.gZv.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gZv.setDefaultBgResource(R.color.black_alpha0);
            this.jOg = (ImageView) this.bBg.findViewById(R.id.video_img_play);
            this.jOh = this.bBg.findViewById(R.id.video_view_delete);
            this.jOh.setOnClickListener(this.mClickListener);
            this.jOi = (TextView) this.bBg.findViewById(R.id.textview_title);
            this.jOj = (TextView) this.bBg.findViewById(R.id.textview_abstract);
            this.jOk = this.bBg.findViewById(R.id.view_delete);
            this.jOk.setOnClickListener(this.mClickListener);
            this.jOe = this.bBg.findViewById(R.id.icon_invoke_link);
            this.jOe.setOnClickListener(this.mClickListener);
            this.jOd = (EditText) this.bBg.findViewById(R.id.post_content);
            this.jOl = (TextView) this.bBg.findViewById(R.id.textview_error_tip);
            this.jOm = (TextView) this.bBg.findViewById(R.id.textview_url);
            this.jOn = (LinearLayout) this.bBg.findViewById(R.id.url_edit_container);
            this.jOo = (EditText) this.bBg.findViewById(R.id.url_input);
            this.jOs = (TextView) this.bBg.findViewById(R.id.url_desc);
            this.jOp = this.bBg.findViewById(R.id.url_input_clear);
            this.jOq = (TextView) this.bBg.findViewById(R.id.url_add);
            this.jOq.setEnabled(false);
            this.jOr = (FrameLayout) this.bBg.findViewById(R.id.url_edit_back_view);
            this.jOo.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.jOp.setVisibility(8);
                        al.j(k.this.jOq, R.color.cp_cont_e);
                        k.this.jOq.setEnabled(false);
                        return;
                    }
                    k.this.jOp.setVisibility(0);
                    al.j(k.this.jOq, R.color.cp_link_tip_a);
                    k.this.jOq.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.jOs.getText().equals(k.this.jOa.getActivity().getString(R.string.tip_url_not_match))) {
                        k.this.czI();
                    }
                }
            });
            this.jOp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.jOo.setText("");
                    k.this.jOp.setVisibility(8);
                    k.this.jOq.setEnabled(false);
                }
            });
            this.cAX = new com.baidu.tbadk.core.view.b(this.jOa.getPageContext());
            czI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czI() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.jOs.setText(R.string.tip_url_post);
        } else {
            this.jOs.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        al.j(this.jOs, R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.jOa.setIsLoading(z);
        if (z) {
            this.jOf.setVisibility(0);
            this.hWp.setVisibility(8);
            this.jOc.startLoad(null, 10, false);
            this.jOi.setVisibility(8);
            this.jOj.setVisibility(8);
            this.jOl.setVisibility(8);
            this.jOm.setVisibility(0);
            al.j(this.jOm, R.color.cp_cont_f);
            this.jOm.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.jOf.setVisibility(8);
            this.hWp.setVisibility(8);
            czJ();
        } else {
            if (aVar.jHt == 1) {
                this.jOf.setVisibility(0);
                this.hWp.setVisibility(8);
                if (aVar.jHs) {
                    this.jOc.startLoad(aVar.jHv, 10, false);
                    this.jOi.setText(aVar.bGy);
                    this.jOj.setText(aVar.bGz);
                    if (ap.nP(aVar.bGy) > 30) {
                        this.jOi.setMaxLines(2);
                        this.jOj.setMaxLines(1);
                    } else {
                        this.jOi.setMaxLines(1);
                        this.jOj.setMaxLines(2);
                    }
                    this.jOi.setVisibility(0);
                    this.jOj.setVisibility(0);
                    this.jOm.setVisibility(8);
                    this.jOl.setVisibility(8);
                } else {
                    this.jOc.reset();
                    this.jOm.setText(aVar.linkUrl);
                    al.j(this.jOm, R.color.cp_cont_b);
                    this.jOi.setVisibility(8);
                    this.jOj.setVisibility(8);
                    this.jOm.setVisibility(0);
                    this.jOl.setVisibility(0);
                }
            } else if (aVar.jHt == 2) {
                this.jOf.setVisibility(8);
                this.hWp.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.hWp.getLayoutParams();
                layoutParams.height = ((l.af(this.jOa.getPageContext().getPageActivity()) - ((int) this.jOa.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.hWp.setLayoutParams(layoutParams);
                al.c(this.jOg, (int) R.drawable.icon_play_video);
                al.k(this.jOh, R.drawable.btn_delete_url);
                this.gZv.startLoad(aVar.jHy, 10, false);
            } else {
                this.jOf.setVisibility(0);
                this.hWp.setVisibility(8);
                this.jOi.setVisibility(8);
                this.jOj.setVisibility(8);
                this.jOm.setVisibility(0);
                this.jOl.setVisibility(0);
                this.jOc.reset();
                this.jOm.setText(aVar.linkUrl);
                al.j(this.jOm, R.color.cp_cont_b);
            }
            czJ();
        }
    }

    public void f(TextWatcher textWatcher) {
        this.jOd.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.jOa != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.jOa.getPageContext(), i);
            }
            al.l(this.mNavigationBar, R.color.cp_bg_line_d);
            al.l(this.bBg, R.color.cp_bg_line_d);
            this.jOd.setHintTextColor(al.getColor(R.color.cp_cont_e));
            this.jOd.setTextColor(al.getColor(R.color.cp_cont_f));
            al.l(this.jOf, R.color.cp_bg_line_e);
            al.j(this.jOi, R.color.cp_cont_b);
            al.j(this.jOj, R.color.cp_cont_d);
            al.j(this.jOm, R.color.cp_cont_b);
            al.l(this.jOl, R.color.cp_bg_line_d);
            al.j(this.jOl, R.color.cp_cont_d);
            al.k(this.jOe, R.drawable.bg_link_invoke);
            al.l(this.jOn, R.color.cp_bg_line_d);
            this.jOo.setHintTextColor(al.getColor(R.color.cp_cont_e));
            al.j(this.jOo, R.color.cp_cont_b);
            al.j(this.jOs, R.color.cp_cont_d);
            al.j(this.jOq, R.color.cp_cont_e);
            al.c(this.jOg, (int) R.drawable.home_ic_video);
            al.k(this.jOk, R.drawable.btn_delete_url);
            al.k(this.jOp, R.drawable.btn_delete_url);
            al.k(this.jOh, R.drawable.btn_delete_url);
            czJ();
        }
    }

    public void czJ() {
        boolean z;
        if (StringUtils.isNull(czK())) {
            z = this.jOf.getVisibility() == 0 || this.hWp.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            al.e(this.jOb, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.jOb.setEnabled(true);
            return;
        }
        al.f(this.jOb, R.color.cp_cont_d, 1);
        this.jOb.setEnabled(false);
    }

    public String czK() {
        if (this.jOd == null || this.jOd.getText() == null) {
            return null;
        }
        return this.jOd.getText().toString();
    }

    public View bDD() {
        return this.bBi;
    }

    public View czL() {
        return this.jOb;
    }

    public View getRootView() {
        return this.bBg;
    }

    public EditText czM() {
        return this.jOd;
    }

    public View czN() {
        return this.jOk;
    }

    public View czO() {
        return this.jOh;
    }

    public View czP() {
        return this.jOf;
    }

    public View getVideoContainer() {
        return this.hWp;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.jOo.setText(aVar.linkUrl);
            this.jOo.setSelection(aVar.linkUrl.length());
        }
        this.jOo.requestFocus();
        l.c(this.jOa.getActivity(), this.jOo);
        this.jOn.setVisibility(0);
        this.jOr.setVisibility(0);
        this.jOe.setVisibility(8);
    }

    public void czQ() {
        this.jOn.setVisibility(8);
        this.jOr.setVisibility(8);
        this.jOe.setVisibility(0);
        l.b(this.jOa.getActivity(), this.jOo);
    }

    public void ac(View.OnClickListener onClickListener) {
        this.jOn.setOnClickListener(onClickListener);
        this.jOr.setOnClickListener(onClickListener);
        this.jOe.setOnClickListener(onClickListener);
    }

    public String czR() {
        if (this.jOo == null || this.jOo.getText() == null) {
            return null;
        }
        return this.jOo.getText().toString();
    }

    public void czS() {
        if (this.jOs != null) {
            this.jOs.setText(R.string.tip_url_not_match);
            al.j(this.jOs, R.color.cp_other_b);
        }
    }

    public void ad(View.OnClickListener onClickListener) {
        if (this.jOq != null) {
            this.jOq.setOnClickListener(onClickListener);
        }
    }

    public View czT() {
        return this.jOn;
    }

    public void destroy() {
        if (this.jOd != null) {
            this.jOd.addTextChangedListener(null);
        }
        if (this.jOo != null) {
            this.jOo.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aI(this.jOa.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.jOa.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.jOa.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.cAX.e(null);
        this.cAX.it(R.string.sending);
        this.cAX.ef(true);
    }

    public void closeLoadingDialog() {
        this.cAX.ef(false);
    }
}
