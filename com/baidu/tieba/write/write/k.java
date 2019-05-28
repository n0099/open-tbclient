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
    private com.baidu.tbadk.core.view.b cAW;
    private View gUZ;
    private TbImageView gZu;
    private RelativeLayout hWo;
    private WriteUrlActivity jNX;
    private TextView jNY;
    private TbImageView jNZ;
    private EditText jOa;
    private View jOb;
    private LinearLayout jOc;
    private ImageView jOd;
    private View jOe;
    private TextView jOf;
    private TextView jOg;
    private View jOh;
    private TextView jOi;
    private TextView jOj;
    private LinearLayout jOk;
    private EditText jOl;
    private View jOm;
    private TextView jOn;
    private FrameLayout jOo;
    private TextView jOp;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.gUZ = null;
        this.cAW = null;
        if (writeUrlActivity != null) {
            this.jNX = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.bBg = LayoutInflater.from(this.jNX.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.jNX.setContentView(this.bBg);
            this.mNavigationBar = (NavigationBar) this.bBg.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.gUZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.write_close_selector, R.drawable.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gUZ.getLayoutParams();
                layoutParams.leftMargin = l.g(this.jNX.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.gUZ != null && (this.gUZ.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gUZ.getLayoutParams();
                layoutParams2.width = -2;
                this.gUZ.setLayoutParams(layoutParams2);
            }
            this.bBg.setOnClickListener(this.mClickListener);
            this.jNY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            al.f(this.jNY, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.jNY.getLayoutParams();
            layoutParams3.rightMargin = l.g(this.jNX.getActivity(), R.dimen.ds16);
            this.jNY.setLayoutParams(layoutParams3);
            this.jNY.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.jNZ = (TbImageView) this.bBg.findViewById(R.id.imageview_picture);
            this.jNZ.setDefaultResource(R.drawable.ic_post_url_n);
            this.jNZ.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.jNZ.setDefaultBgResource(R.color.black_alpha0);
            this.jOc = (LinearLayout) this.bBg.findViewById(R.id.view_picture_publish);
            this.jOc.setOnClickListener(this.mClickListener);
            this.hWo = (RelativeLayout) this.bBg.findViewById(R.id.video_container);
            this.hWo.setOnClickListener(this.mClickListener);
            this.gZu = (TbImageView) this.bBg.findViewById(R.id.video_img_thumbnail);
            this.gZu.setDefaultErrorResource(0);
            this.gZu.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gZu.setDefaultBgResource(R.color.black_alpha0);
            this.jOd = (ImageView) this.bBg.findViewById(R.id.video_img_play);
            this.jOe = this.bBg.findViewById(R.id.video_view_delete);
            this.jOe.setOnClickListener(this.mClickListener);
            this.jOf = (TextView) this.bBg.findViewById(R.id.textview_title);
            this.jOg = (TextView) this.bBg.findViewById(R.id.textview_abstract);
            this.jOh = this.bBg.findViewById(R.id.view_delete);
            this.jOh.setOnClickListener(this.mClickListener);
            this.jOb = this.bBg.findViewById(R.id.icon_invoke_link);
            this.jOb.setOnClickListener(this.mClickListener);
            this.jOa = (EditText) this.bBg.findViewById(R.id.post_content);
            this.jOi = (TextView) this.bBg.findViewById(R.id.textview_error_tip);
            this.jOj = (TextView) this.bBg.findViewById(R.id.textview_url);
            this.jOk = (LinearLayout) this.bBg.findViewById(R.id.url_edit_container);
            this.jOl = (EditText) this.bBg.findViewById(R.id.url_input);
            this.jOp = (TextView) this.bBg.findViewById(R.id.url_desc);
            this.jOm = this.bBg.findViewById(R.id.url_input_clear);
            this.jOn = (TextView) this.bBg.findViewById(R.id.url_add);
            this.jOn.setEnabled(false);
            this.jOo = (FrameLayout) this.bBg.findViewById(R.id.url_edit_back_view);
            this.jOl.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.jOm.setVisibility(8);
                        al.j(k.this.jOn, R.color.cp_cont_e);
                        k.this.jOn.setEnabled(false);
                        return;
                    }
                    k.this.jOm.setVisibility(0);
                    al.j(k.this.jOn, R.color.cp_link_tip_a);
                    k.this.jOn.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.jOp.getText().equals(k.this.jNX.getActivity().getString(R.string.tip_url_not_match))) {
                        k.this.czJ();
                    }
                }
            });
            this.jOm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.jOl.setText("");
                    k.this.jOm.setVisibility(8);
                    k.this.jOn.setEnabled(false);
                }
            });
            this.cAW = new com.baidu.tbadk.core.view.b(this.jNX.getPageContext());
            czJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czJ() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.jOp.setText(R.string.tip_url_post);
        } else {
            this.jOp.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        al.j(this.jOp, R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.jNX.setIsLoading(z);
        if (z) {
            this.jOc.setVisibility(0);
            this.hWo.setVisibility(8);
            this.jNZ.startLoad(null, 10, false);
            this.jOf.setVisibility(8);
            this.jOg.setVisibility(8);
            this.jOi.setVisibility(8);
            this.jOj.setVisibility(0);
            al.j(this.jOj, R.color.cp_cont_f);
            this.jOj.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.jOc.setVisibility(8);
            this.hWo.setVisibility(8);
            czK();
        } else {
            if (aVar.jHq == 1) {
                this.jOc.setVisibility(0);
                this.hWo.setVisibility(8);
                if (aVar.jHp) {
                    this.jNZ.startLoad(aVar.jHs, 10, false);
                    this.jOf.setText(aVar.bGx);
                    this.jOg.setText(aVar.bGy);
                    if (ap.nQ(aVar.bGx) > 30) {
                        this.jOf.setMaxLines(2);
                        this.jOg.setMaxLines(1);
                    } else {
                        this.jOf.setMaxLines(1);
                        this.jOg.setMaxLines(2);
                    }
                    this.jOf.setVisibility(0);
                    this.jOg.setVisibility(0);
                    this.jOj.setVisibility(8);
                    this.jOi.setVisibility(8);
                } else {
                    this.jNZ.reset();
                    this.jOj.setText(aVar.linkUrl);
                    al.j(this.jOj, R.color.cp_cont_b);
                    this.jOf.setVisibility(8);
                    this.jOg.setVisibility(8);
                    this.jOj.setVisibility(0);
                    this.jOi.setVisibility(0);
                }
            } else if (aVar.jHq == 2) {
                this.jOc.setVisibility(8);
                this.hWo.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.hWo.getLayoutParams();
                layoutParams.height = ((l.af(this.jNX.getPageContext().getPageActivity()) - ((int) this.jNX.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.hWo.setLayoutParams(layoutParams);
                al.c(this.jOd, (int) R.drawable.icon_play_video);
                al.k(this.jOe, R.drawable.btn_delete_url);
                this.gZu.startLoad(aVar.jHv, 10, false);
            } else {
                this.jOc.setVisibility(0);
                this.hWo.setVisibility(8);
                this.jOf.setVisibility(8);
                this.jOg.setVisibility(8);
                this.jOj.setVisibility(0);
                this.jOi.setVisibility(0);
                this.jNZ.reset();
                this.jOj.setText(aVar.linkUrl);
                al.j(this.jOj, R.color.cp_cont_b);
            }
            czK();
        }
    }

    public void f(TextWatcher textWatcher) {
        this.jOa.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.jNX != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.jNX.getPageContext(), i);
            }
            al.l(this.mNavigationBar, R.color.cp_bg_line_d);
            al.l(this.bBg, R.color.cp_bg_line_d);
            this.jOa.setHintTextColor(al.getColor(R.color.cp_cont_e));
            this.jOa.setTextColor(al.getColor(R.color.cp_cont_f));
            al.l(this.jOc, R.color.cp_bg_line_e);
            al.j(this.jOf, R.color.cp_cont_b);
            al.j(this.jOg, R.color.cp_cont_d);
            al.j(this.jOj, R.color.cp_cont_b);
            al.l(this.jOi, R.color.cp_bg_line_d);
            al.j(this.jOi, R.color.cp_cont_d);
            al.k(this.jOb, R.drawable.bg_link_invoke);
            al.l(this.jOk, R.color.cp_bg_line_d);
            this.jOl.setHintTextColor(al.getColor(R.color.cp_cont_e));
            al.j(this.jOl, R.color.cp_cont_b);
            al.j(this.jOp, R.color.cp_cont_d);
            al.j(this.jOn, R.color.cp_cont_e);
            al.c(this.jOd, (int) R.drawable.home_ic_video);
            al.k(this.jOh, R.drawable.btn_delete_url);
            al.k(this.jOm, R.drawable.btn_delete_url);
            al.k(this.jOe, R.drawable.btn_delete_url);
            czK();
        }
    }

    public void czK() {
        boolean z;
        if (StringUtils.isNull(czL())) {
            z = this.jOc.getVisibility() == 0 || this.hWo.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            al.e(this.jNY, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.jNY.setEnabled(true);
            return;
        }
        al.f(this.jNY, R.color.cp_cont_d, 1);
        this.jNY.setEnabled(false);
    }

    public String czL() {
        if (this.jOa == null || this.jOa.getText() == null) {
            return null;
        }
        return this.jOa.getText().toString();
    }

    public View bDC() {
        return this.gUZ;
    }

    public View czM() {
        return this.jNY;
    }

    public View getRootView() {
        return this.bBg;
    }

    public EditText czN() {
        return this.jOa;
    }

    public View czO() {
        return this.jOh;
    }

    public View czP() {
        return this.jOe;
    }

    public View czQ() {
        return this.jOc;
    }

    public View getVideoContainer() {
        return this.hWo;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.jOl.setText(aVar.linkUrl);
            this.jOl.setSelection(aVar.linkUrl.length());
        }
        this.jOl.requestFocus();
        l.c(this.jNX.getActivity(), this.jOl);
        this.jOk.setVisibility(0);
        this.jOo.setVisibility(0);
        this.jOb.setVisibility(8);
    }

    public void czR() {
        this.jOk.setVisibility(8);
        this.jOo.setVisibility(8);
        this.jOb.setVisibility(0);
        l.b(this.jNX.getActivity(), this.jOl);
    }

    public void ac(View.OnClickListener onClickListener) {
        this.jOk.setOnClickListener(onClickListener);
        this.jOo.setOnClickListener(onClickListener);
        this.jOb.setOnClickListener(onClickListener);
    }

    public String czS() {
        if (this.jOl == null || this.jOl.getText() == null) {
            return null;
        }
        return this.jOl.getText().toString();
    }

    public void czT() {
        if (this.jOp != null) {
            this.jOp.setText(R.string.tip_url_not_match);
            al.j(this.jOp, R.color.cp_other_b);
        }
    }

    public void ad(View.OnClickListener onClickListener) {
        if (this.jOn != null) {
            this.jOn.setOnClickListener(onClickListener);
        }
    }

    public View czU() {
        return this.jOk;
    }

    public void destroy() {
        if (this.jOa != null) {
            this.jOa.addTextChangedListener(null);
        }
        if (this.jOl != null) {
            this.jOl.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aI(this.jNX.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.jNX.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.jNX.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.cAW.e(null);
        this.cAW.it(R.string.sending);
        this.cAW.ef(true);
    }

    public void closeLoadingDialog() {
        this.cAW.ef(false);
    }
}
