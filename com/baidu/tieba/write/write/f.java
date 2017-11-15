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
public class f {
    private View Ry;
    private com.baidu.tbadk.core.view.a aLW;
    private View dTe;
    private TbImageView ebW;
    private RelativeLayout fbY;
    private FrameLayout gZA;
    private TextView gZB;
    private WriteUrlActivity gZj;
    private TextView gZk;
    private TbImageView gZl;
    private EditText gZm;
    private View gZn;
    private LinearLayout gZo;
    private ImageView gZp;
    private View gZq;
    private TextView gZr;
    private TextView gZs;
    private View gZt;
    private TextView gZu;
    private TextView gZv;
    private LinearLayout gZw;
    private EditText gZx;
    private View gZy;
    private TextView gZz;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;

    public f(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.dTe = null;
        this.aLW = null;
        if (writeUrlActivity != null) {
            this.gZj = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.Ry = LayoutInflater.from(this.gZj.getPageContext().getPageActivity()).inflate(d.h.write_url_activity_layout, (ViewGroup) null);
            this.gZj.setContentView(this.Ry);
            this.mNavigationBar = (NavigationBar) this.Ry.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.dTe = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dTe.getLayoutParams();
                layoutParams.leftMargin = l.f(this.gZj.getActivity(), d.e.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.dTe != null && (this.dTe.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dTe.getLayoutParams();
                layoutParams2.width = -2;
                this.dTe.setLayoutParams(layoutParams2);
            }
            this.Ry.setOnClickListener(this.mClickListener);
            this.gZk = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(d.j.send_post));
            aj.c(this.gZk, d.C0080d.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.gZk.getLayoutParams();
            layoutParams3.rightMargin = l.f(this.gZj.getActivity(), d.e.ds16);
            this.gZk.setLayoutParams(layoutParams3);
            this.gZk.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(d.j.post_new_thread));
            this.gZl = (TbImageView) this.Ry.findViewById(d.g.imageview_picture);
            this.gZl.setDefaultResource(d.f.ic_post_url_n);
            this.gZl.setDefaultErrorResource(d.f.ic_post_url_n);
            this.gZl.setDefaultBgResource(d.C0080d.black_alpha0);
            this.gZo = (LinearLayout) this.Ry.findViewById(d.g.view_picture_publish);
            this.gZo.setOnClickListener(this.mClickListener);
            this.fbY = (RelativeLayout) this.Ry.findViewById(d.g.video_container);
            this.fbY.setOnClickListener(this.mClickListener);
            this.ebW = (TbImageView) this.Ry.findViewById(d.g.video_img_thumbnail);
            this.ebW.setDefaultErrorResource(0);
            this.ebW.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.ebW.setDefaultBgResource(d.C0080d.black_alpha0);
            this.gZp = (ImageView) this.Ry.findViewById(d.g.video_img_play);
            this.gZq = this.Ry.findViewById(d.g.video_view_delete);
            this.gZq.setOnClickListener(this.mClickListener);
            this.gZr = (TextView) this.Ry.findViewById(d.g.textview_title);
            this.gZs = (TextView) this.Ry.findViewById(d.g.textview_abstract);
            this.gZt = this.Ry.findViewById(d.g.view_delete);
            this.gZt.setOnClickListener(this.mClickListener);
            this.gZn = this.Ry.findViewById(d.g.icon_invoke_link);
            this.gZn.setOnClickListener(this.mClickListener);
            this.gZm = (EditText) this.Ry.findViewById(d.g.post_content);
            this.gZu = (TextView) this.Ry.findViewById(d.g.textview_error_tip);
            this.gZv = (TextView) this.Ry.findViewById(d.g.textview_url);
            this.gZw = (LinearLayout) this.Ry.findViewById(d.g.url_edit_container);
            this.gZx = (EditText) this.Ry.findViewById(d.g.url_input);
            this.gZB = (TextView) this.Ry.findViewById(d.g.url_desc);
            this.gZy = this.Ry.findViewById(d.g.url_input_clear);
            this.gZz = (TextView) this.Ry.findViewById(d.g.url_add);
            this.gZz.setEnabled(false);
            this.gZA = (FrameLayout) this.Ry.findViewById(d.g.url_edit_back_view);
            this.gZx.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.f.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        f.this.gZy.setVisibility(8);
                        aj.i(f.this.gZz, d.C0080d.cp_cont_e);
                        f.this.gZz.setEnabled(false);
                        return;
                    }
                    f.this.gZy.setVisibility(0);
                    aj.i(f.this.gZz, d.C0080d.cp_link_tip_a);
                    f.this.gZz.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (f.this.gZB.getText().equals(f.this.gZj.getActivity().getString(d.j.tip_url_not_match))) {
                        f.this.bFz();
                    }
                }
            });
            this.gZy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.gZx.setText("");
                    f.this.gZy.setVisibility(8);
                    f.this.gZz.setEnabled(false);
                }
            });
            this.aLW = new com.baidu.tbadk.core.view.a(this.gZj.getPageContext());
            bFz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFz() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.gZB.setText(d.j.tip_url_post);
        } else {
            this.gZB.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        aj.i(this.gZB, d.C0080d.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.gZj.setIsLoading(z);
        if (z) {
            this.gZo.setVisibility(0);
            this.fbY.setVisibility(8);
            this.gZl.startLoad(null, 10, false);
            this.gZr.setVisibility(8);
            this.gZs.setVisibility(8);
            this.gZu.setVisibility(8);
            this.gZv.setVisibility(0);
            aj.i(this.gZv, d.C0080d.cp_cont_f);
            this.gZv.setText(d.j.tip_url_loading);
        } else if (aVar == null) {
            this.gZo.setVisibility(8);
            this.fbY.setVisibility(8);
            bFA();
        } else {
            if (aVar.gTf == 1) {
                this.gZo.setVisibility(0);
                this.fbY.setVisibility(8);
                if (aVar.gTe) {
                    this.gZl.startLoad(aVar.gTh, 10, false);
                    this.gZr.setText(aVar.WY);
                    this.gZs.setText(aVar.WZ);
                    if (am.dT(aVar.WY) > 30) {
                        this.gZr.setMaxLines(2);
                        this.gZs.setMaxLines(1);
                    } else {
                        this.gZr.setMaxLines(1);
                        this.gZs.setMaxLines(2);
                    }
                    this.gZr.setVisibility(0);
                    this.gZs.setVisibility(0);
                    this.gZv.setVisibility(8);
                    this.gZu.setVisibility(8);
                } else {
                    this.gZl.reset();
                    this.gZv.setText(aVar.linkUrl);
                    aj.i(this.gZv, d.C0080d.cp_cont_b);
                    this.gZr.setVisibility(8);
                    this.gZs.setVisibility(8);
                    this.gZv.setVisibility(0);
                    this.gZu.setVisibility(0);
                }
            } else if (aVar.gTf == 2) {
                this.gZo.setVisibility(8);
                this.fbY.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.fbY.getLayoutParams();
                layoutParams.height = ((l.ac(this.gZj.getPageContext().getPageActivity()) - ((int) this.gZj.getPageContext().getPageActivity().getResources().getDimension(d.e.ds80))) * 9) / 16;
                this.fbY.setLayoutParams(layoutParams);
                aj.c(this.gZp, d.f.icon_play_video);
                aj.j(this.gZq, d.f.btn_delete_url);
                this.ebW.startLoad(aVar.gTk, 10, false);
            } else {
                this.gZo.setVisibility(0);
                this.fbY.setVisibility(8);
                this.gZr.setVisibility(8);
                this.gZs.setVisibility(8);
                this.gZv.setVisibility(0);
                this.gZu.setVisibility(0);
                this.gZl.reset();
                this.gZv.setText(aVar.linkUrl);
                aj.i(this.gZv, d.C0080d.cp_cont_b);
            }
            bFA();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.gZm.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.gZj != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.gZj.getPageContext(), i);
            }
            aj.k(this.mNavigationBar, d.C0080d.cp_bg_line_d);
            aj.k(this.Ry, d.C0080d.cp_bg_line_d);
            this.gZm.setHintTextColor(aj.getColor(d.C0080d.cp_cont_e));
            this.gZm.setTextColor(aj.getColor(d.C0080d.cp_cont_f));
            aj.k(this.gZo, d.C0080d.cp_bg_line_e);
            aj.i(this.gZr, d.C0080d.cp_cont_b);
            aj.i(this.gZs, d.C0080d.cp_cont_d);
            aj.i(this.gZv, d.C0080d.cp_cont_b);
            aj.k(this.gZu, d.C0080d.cp_bg_line_d);
            aj.i(this.gZu, d.C0080d.cp_cont_d);
            aj.j(this.gZn, d.f.bg_link_invoke);
            aj.k(this.gZw, d.C0080d.cp_bg_line_d);
            this.gZx.setHintTextColor(aj.getColor(d.C0080d.cp_cont_e));
            aj.i(this.gZx, d.C0080d.cp_cont_b);
            aj.i(this.gZB, d.C0080d.cp_cont_d);
            aj.i(this.gZz, d.C0080d.cp_cont_e);
            aj.c(this.gZp, d.f.home_ic_video);
            aj.j(this.gZt, d.f.btn_delete_url);
            aj.j(this.gZy, d.f.btn_delete_url);
            aj.j(this.gZq, d.f.btn_delete_url);
            bFA();
        }
    }

    public void bFA() {
        boolean z;
        if (StringUtils.isNull(bFB())) {
            z = this.gZo.getVisibility() == 0 || this.fbY.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            aj.b(this.gZk, d.C0080d.cp_link_tip_a, d.C0080d.s_navbar_title_color);
            this.gZk.setEnabled(true);
            return;
        }
        aj.c(this.gZk, d.C0080d.cp_cont_d, 1);
        this.gZk.setEnabled(false);
    }

    public String bFB() {
        if (this.gZm == null || this.gZm.getText() == null) {
            return null;
        }
        return this.gZm.getText().toString();
    }

    public View aBr() {
        return this.dTe;
    }

    public View bFC() {
        return this.gZk;
    }

    public View getRootView() {
        return this.Ry;
    }

    public EditText bFD() {
        return this.gZm;
    }

    public View brd() {
        return this.gZt;
    }

    public View bFE() {
        return this.gZq;
    }

    public View bFF() {
        return this.gZo;
    }

    public View getVideoContainer() {
        return this.fbY;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.gZx.setText(aVar.linkUrl);
            this.gZx.setSelection(aVar.linkUrl.length());
        }
        this.gZx.requestFocus();
        l.b(this.gZj.getActivity(), this.gZx);
        this.gZw.setVisibility(0);
        this.gZA.setVisibility(0);
        this.gZn.setVisibility(8);
    }

    public void bFG() {
        this.gZw.setVisibility(8);
        this.gZA.setVisibility(8);
        this.gZn.setVisibility(0);
        l.a(this.gZj.getActivity(), this.gZx);
    }

    public void V(View.OnClickListener onClickListener) {
        this.gZw.setOnClickListener(onClickListener);
        this.gZA.setOnClickListener(onClickListener);
        this.gZn.setOnClickListener(onClickListener);
    }

    public String bFH() {
        if (this.gZx == null || this.gZx.getText() == null) {
            return null;
        }
        return this.gZx.getText().toString();
    }

    public void bFI() {
        if (this.gZB != null) {
            this.gZB.setText(d.j.tip_url_not_match);
            aj.i(this.gZB, d.C0080d.cp_other_b);
        }
    }

    public void W(View.OnClickListener onClickListener) {
        if (this.gZz != null) {
            this.gZz.setOnClickListener(onClickListener);
        }
    }

    public View bFJ() {
        return this.gZw;
    }

    public void destroy() {
        if (this.gZm != null) {
            this.gZm.addTextChangedListener(null);
        }
        if (this.gZx != null) {
            this.gZx.addTextChangedListener(null);
        }
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.ua(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ao(this.gZj.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.gZj.getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                this.gZj.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.aLW.c(null);
        this.aLW.da(d.j.sending);
        this.aLW.aE(true);
    }

    public void closeLoadingDialog() {
        this.aLW.aE(false);
    }
}
