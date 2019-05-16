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
    private View gUW;
    private TbImageView gZr;
    private RelativeLayout hWl;
    private WriteUrlActivity jNW;
    private TextView jNX;
    private TbImageView jNY;
    private EditText jNZ;
    private View jOa;
    private LinearLayout jOb;
    private ImageView jOc;
    private View jOd;
    private TextView jOe;
    private TextView jOf;
    private View jOg;
    private TextView jOh;
    private TextView jOi;
    private LinearLayout jOj;
    private EditText jOk;
    private View jOl;
    private TextView jOm;
    private FrameLayout jOn;
    private TextView jOo;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.gUW = null;
        this.cAW = null;
        if (writeUrlActivity != null) {
            this.jNW = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.bBg = LayoutInflater.from(this.jNW.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.jNW.setContentView(this.bBg);
            this.mNavigationBar = (NavigationBar) this.bBg.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.gUW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.write_close_selector, R.drawable.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gUW.getLayoutParams();
                layoutParams.leftMargin = l.g(this.jNW.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.gUW != null && (this.gUW.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gUW.getLayoutParams();
                layoutParams2.width = -2;
                this.gUW.setLayoutParams(layoutParams2);
            }
            this.bBg.setOnClickListener(this.mClickListener);
            this.jNX = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            al.f(this.jNX, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.jNX.getLayoutParams();
            layoutParams3.rightMargin = l.g(this.jNW.getActivity(), R.dimen.ds16);
            this.jNX.setLayoutParams(layoutParams3);
            this.jNX.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.jNY = (TbImageView) this.bBg.findViewById(R.id.imageview_picture);
            this.jNY.setDefaultResource(R.drawable.ic_post_url_n);
            this.jNY.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.jNY.setDefaultBgResource(R.color.black_alpha0);
            this.jOb = (LinearLayout) this.bBg.findViewById(R.id.view_picture_publish);
            this.jOb.setOnClickListener(this.mClickListener);
            this.hWl = (RelativeLayout) this.bBg.findViewById(R.id.video_container);
            this.hWl.setOnClickListener(this.mClickListener);
            this.gZr = (TbImageView) this.bBg.findViewById(R.id.video_img_thumbnail);
            this.gZr.setDefaultErrorResource(0);
            this.gZr.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gZr.setDefaultBgResource(R.color.black_alpha0);
            this.jOc = (ImageView) this.bBg.findViewById(R.id.video_img_play);
            this.jOd = this.bBg.findViewById(R.id.video_view_delete);
            this.jOd.setOnClickListener(this.mClickListener);
            this.jOe = (TextView) this.bBg.findViewById(R.id.textview_title);
            this.jOf = (TextView) this.bBg.findViewById(R.id.textview_abstract);
            this.jOg = this.bBg.findViewById(R.id.view_delete);
            this.jOg.setOnClickListener(this.mClickListener);
            this.jOa = this.bBg.findViewById(R.id.icon_invoke_link);
            this.jOa.setOnClickListener(this.mClickListener);
            this.jNZ = (EditText) this.bBg.findViewById(R.id.post_content);
            this.jOh = (TextView) this.bBg.findViewById(R.id.textview_error_tip);
            this.jOi = (TextView) this.bBg.findViewById(R.id.textview_url);
            this.jOj = (LinearLayout) this.bBg.findViewById(R.id.url_edit_container);
            this.jOk = (EditText) this.bBg.findViewById(R.id.url_input);
            this.jOo = (TextView) this.bBg.findViewById(R.id.url_desc);
            this.jOl = this.bBg.findViewById(R.id.url_input_clear);
            this.jOm = (TextView) this.bBg.findViewById(R.id.url_add);
            this.jOm.setEnabled(false);
            this.jOn = (FrameLayout) this.bBg.findViewById(R.id.url_edit_back_view);
            this.jOk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.jOl.setVisibility(8);
                        al.j(k.this.jOm, R.color.cp_cont_e);
                        k.this.jOm.setEnabled(false);
                        return;
                    }
                    k.this.jOl.setVisibility(0);
                    al.j(k.this.jOm, R.color.cp_link_tip_a);
                    k.this.jOm.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.jOo.getText().equals(k.this.jNW.getActivity().getString(R.string.tip_url_not_match))) {
                        k.this.czH();
                    }
                }
            });
            this.jOl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.jOk.setText("");
                    k.this.jOl.setVisibility(8);
                    k.this.jOm.setEnabled(false);
                }
            });
            this.cAW = new com.baidu.tbadk.core.view.b(this.jNW.getPageContext());
            czH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czH() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.jOo.setText(R.string.tip_url_post);
        } else {
            this.jOo.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        al.j(this.jOo, R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.jNW.setIsLoading(z);
        if (z) {
            this.jOb.setVisibility(0);
            this.hWl.setVisibility(8);
            this.jNY.startLoad(null, 10, false);
            this.jOe.setVisibility(8);
            this.jOf.setVisibility(8);
            this.jOh.setVisibility(8);
            this.jOi.setVisibility(0);
            al.j(this.jOi, R.color.cp_cont_f);
            this.jOi.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.jOb.setVisibility(8);
            this.hWl.setVisibility(8);
            czI();
        } else {
            if (aVar.jHp == 1) {
                this.jOb.setVisibility(0);
                this.hWl.setVisibility(8);
                if (aVar.jHo) {
                    this.jNY.startLoad(aVar.jHr, 10, false);
                    this.jOe.setText(aVar.bGx);
                    this.jOf.setText(aVar.bGy);
                    if (ap.nQ(aVar.bGx) > 30) {
                        this.jOe.setMaxLines(2);
                        this.jOf.setMaxLines(1);
                    } else {
                        this.jOe.setMaxLines(1);
                        this.jOf.setMaxLines(2);
                    }
                    this.jOe.setVisibility(0);
                    this.jOf.setVisibility(0);
                    this.jOi.setVisibility(8);
                    this.jOh.setVisibility(8);
                } else {
                    this.jNY.reset();
                    this.jOi.setText(aVar.linkUrl);
                    al.j(this.jOi, R.color.cp_cont_b);
                    this.jOe.setVisibility(8);
                    this.jOf.setVisibility(8);
                    this.jOi.setVisibility(0);
                    this.jOh.setVisibility(0);
                }
            } else if (aVar.jHp == 2) {
                this.jOb.setVisibility(8);
                this.hWl.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.hWl.getLayoutParams();
                layoutParams.height = ((l.af(this.jNW.getPageContext().getPageActivity()) - ((int) this.jNW.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.hWl.setLayoutParams(layoutParams);
                al.c(this.jOc, (int) R.drawable.icon_play_video);
                al.k(this.jOd, R.drawable.btn_delete_url);
                this.gZr.startLoad(aVar.jHu, 10, false);
            } else {
                this.jOb.setVisibility(0);
                this.hWl.setVisibility(8);
                this.jOe.setVisibility(8);
                this.jOf.setVisibility(8);
                this.jOi.setVisibility(0);
                this.jOh.setVisibility(0);
                this.jNY.reset();
                this.jOi.setText(aVar.linkUrl);
                al.j(this.jOi, R.color.cp_cont_b);
            }
            czI();
        }
    }

    public void f(TextWatcher textWatcher) {
        this.jNZ.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.jNW != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.jNW.getPageContext(), i);
            }
            al.l(this.mNavigationBar, R.color.cp_bg_line_d);
            al.l(this.bBg, R.color.cp_bg_line_d);
            this.jNZ.setHintTextColor(al.getColor(R.color.cp_cont_e));
            this.jNZ.setTextColor(al.getColor(R.color.cp_cont_f));
            al.l(this.jOb, R.color.cp_bg_line_e);
            al.j(this.jOe, R.color.cp_cont_b);
            al.j(this.jOf, R.color.cp_cont_d);
            al.j(this.jOi, R.color.cp_cont_b);
            al.l(this.jOh, R.color.cp_bg_line_d);
            al.j(this.jOh, R.color.cp_cont_d);
            al.k(this.jOa, R.drawable.bg_link_invoke);
            al.l(this.jOj, R.color.cp_bg_line_d);
            this.jOk.setHintTextColor(al.getColor(R.color.cp_cont_e));
            al.j(this.jOk, R.color.cp_cont_b);
            al.j(this.jOo, R.color.cp_cont_d);
            al.j(this.jOm, R.color.cp_cont_e);
            al.c(this.jOc, (int) R.drawable.home_ic_video);
            al.k(this.jOg, R.drawable.btn_delete_url);
            al.k(this.jOl, R.drawable.btn_delete_url);
            al.k(this.jOd, R.drawable.btn_delete_url);
            czI();
        }
    }

    public void czI() {
        boolean z;
        if (StringUtils.isNull(czJ())) {
            z = this.jOb.getVisibility() == 0 || this.hWl.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            al.e(this.jNX, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.jNX.setEnabled(true);
            return;
        }
        al.f(this.jNX, R.color.cp_cont_d, 1);
        this.jNX.setEnabled(false);
    }

    public String czJ() {
        if (this.jNZ == null || this.jNZ.getText() == null) {
            return null;
        }
        return this.jNZ.getText().toString();
    }

    public View bDz() {
        return this.gUW;
    }

    public View czK() {
        return this.jNX;
    }

    public View getRootView() {
        return this.bBg;
    }

    public EditText czL() {
        return this.jNZ;
    }

    public View czM() {
        return this.jOg;
    }

    public View czN() {
        return this.jOd;
    }

    public View czO() {
        return this.jOb;
    }

    public View getVideoContainer() {
        return this.hWl;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.jOk.setText(aVar.linkUrl);
            this.jOk.setSelection(aVar.linkUrl.length());
        }
        this.jOk.requestFocus();
        l.c(this.jNW.getActivity(), this.jOk);
        this.jOj.setVisibility(0);
        this.jOn.setVisibility(0);
        this.jOa.setVisibility(8);
    }

    public void czP() {
        this.jOj.setVisibility(8);
        this.jOn.setVisibility(8);
        this.jOa.setVisibility(0);
        l.b(this.jNW.getActivity(), this.jOk);
    }

    public void ac(View.OnClickListener onClickListener) {
        this.jOj.setOnClickListener(onClickListener);
        this.jOn.setOnClickListener(onClickListener);
        this.jOa.setOnClickListener(onClickListener);
    }

    public String czQ() {
        if (this.jOk == null || this.jOk.getText() == null) {
            return null;
        }
        return this.jOk.getText().toString();
    }

    public void czR() {
        if (this.jOo != null) {
            this.jOo.setText(R.string.tip_url_not_match);
            al.j(this.jOo, R.color.cp_other_b);
        }
    }

    public void ad(View.OnClickListener onClickListener) {
        if (this.jOm != null) {
            this.jOm.setOnClickListener(onClickListener);
        }
    }

    public View czS() {
        return this.jOj;
    }

    public void destroy() {
        if (this.jNZ != null) {
            this.jNZ.addTextChangedListener(null);
        }
        if (this.jOk != null) {
            this.jOk.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aI(this.jNW.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.jNW.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.jNW.showToast(errorString);
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
