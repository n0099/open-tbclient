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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes3.dex */
public class k {
    private View bCe;
    private com.baidu.tbadk.core.view.b cCv;
    private TbImageView hgz;
    private RelativeLayout idC;
    private WriteUrlActivity jWf;
    private TextView jWg;
    private TbImageView jWh;
    private EditText jWi;
    private View jWj;
    private LinearLayout jWk;
    private ImageView jWl;
    private View jWm;
    private TextView jWn;
    private TextView jWo;
    private View jWp;
    private TextView jWq;
    private TextView jWr;
    private LinearLayout jWs;
    private EditText jWt;
    private View jWu;
    private TextView jWv;
    private FrameLayout jWw;
    private TextView jWx;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.bCe = null;
        this.cCv = null;
        if (writeUrlActivity != null) {
            this.jWf = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.jWf.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.jWf.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.bCe = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.write_close_selector, R.drawable.write_close_selector);
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bCe.getLayoutParams();
                layoutParams.leftMargin = l.g(this.jWf.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.bCe != null && (this.bCe.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bCe.getLayoutParams();
                layoutParams2.width = -2;
                this.bCe.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.jWg = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            am.f(this.jWg, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.jWg.getLayoutParams();
            layoutParams3.rightMargin = l.g(this.jWf.getActivity(), R.dimen.ds16);
            this.jWg.setLayoutParams(layoutParams3);
            this.jWg.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.jWh = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.jWh.setDefaultResource(R.drawable.ic_post_url_n);
            this.jWh.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.jWh.setDefaultBgResource(R.color.black_alpha0);
            this.jWk = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.jWk.setOnClickListener(this.mClickListener);
            this.idC = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.idC.setOnClickListener(this.mClickListener);
            this.hgz = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.hgz.setDefaultErrorResource(0);
            this.hgz.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.hgz.setDefaultBgResource(R.color.black_alpha0);
            this.jWl = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.jWm = this.mRoot.findViewById(R.id.video_view_delete);
            this.jWm.setOnClickListener(this.mClickListener);
            this.jWn = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.jWo = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.jWp = this.mRoot.findViewById(R.id.view_delete);
            this.jWp.setOnClickListener(this.mClickListener);
            this.jWj = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.jWj.setOnClickListener(this.mClickListener);
            this.jWi = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.jWq = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.jWr = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.jWs = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.jWt = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.jWx = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.jWu = this.mRoot.findViewById(R.id.url_input_clear);
            this.jWv = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.jWv.setEnabled(false);
            this.jWw = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.jWt.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.jWu.setVisibility(8);
                        am.j(k.this.jWv, R.color.cp_cont_e);
                        k.this.jWv.setEnabled(false);
                        return;
                    }
                    k.this.jWu.setVisibility(0);
                    am.j(k.this.jWv, R.color.cp_link_tip_a);
                    k.this.jWv.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.jWx.getText().equals(k.this.jWf.getActivity().getString(R.string.tip_url_not_match))) {
                        k.this.cDb();
                    }
                }
            });
            this.jWu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.jWt.setText("");
                    k.this.jWu.setVisibility(8);
                    k.this.jWv.setEnabled(false);
                }
            });
            this.cCv = new com.baidu.tbadk.core.view.b(this.jWf.getPageContext());
            cDb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDb() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.jWx.setText(R.string.tip_url_post);
        } else {
            this.jWx.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        am.j(this.jWx, R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.jWf.setIsLoading(z);
        if (z) {
            this.jWk.setVisibility(0);
            this.idC.setVisibility(8);
            this.jWh.startLoad(null, 10, false);
            this.jWn.setVisibility(8);
            this.jWo.setVisibility(8);
            this.jWq.setVisibility(8);
            this.jWr.setVisibility(0);
            am.j(this.jWr, R.color.cp_cont_f);
            this.jWr.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.jWk.setVisibility(8);
            this.idC.setVisibility(8);
            cDc();
        } else {
            if (aVar.jPD == 1) {
                this.jWk.setVisibility(0);
                this.idC.setVisibility(8);
                if (aVar.jPC) {
                    this.jWh.startLoad(aVar.jPF, 10, false);
                    this.jWn.setText(aVar.bHz);
                    this.jWo.setText(aVar.bHA);
                    if (aq.oc(aVar.bHz) > 30) {
                        this.jWn.setMaxLines(2);
                        this.jWo.setMaxLines(1);
                    } else {
                        this.jWn.setMaxLines(1);
                        this.jWo.setMaxLines(2);
                    }
                    this.jWn.setVisibility(0);
                    this.jWo.setVisibility(0);
                    this.jWr.setVisibility(8);
                    this.jWq.setVisibility(8);
                } else {
                    this.jWh.reset();
                    this.jWr.setText(aVar.linkUrl);
                    am.j(this.jWr, R.color.cp_cont_b);
                    this.jWn.setVisibility(8);
                    this.jWo.setVisibility(8);
                    this.jWr.setVisibility(0);
                    this.jWq.setVisibility(0);
                }
            } else if (aVar.jPD == 2) {
                this.jWk.setVisibility(8);
                this.idC.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.idC.getLayoutParams();
                layoutParams.height = ((l.af(this.jWf.getPageContext().getPageActivity()) - ((int) this.jWf.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.idC.setLayoutParams(layoutParams);
                am.c(this.jWl, (int) R.drawable.icon_play_video);
                am.k(this.jWm, R.drawable.btn_delete_url);
                this.hgz.startLoad(aVar.jPI, 10, false);
            } else {
                this.jWk.setVisibility(0);
                this.idC.setVisibility(8);
                this.jWn.setVisibility(8);
                this.jWo.setVisibility(8);
                this.jWr.setVisibility(0);
                this.jWq.setVisibility(0);
                this.jWh.reset();
                this.jWr.setText(aVar.linkUrl);
                am.j(this.jWr, R.color.cp_cont_b);
            }
            cDc();
        }
    }

    public void g(TextWatcher textWatcher) {
        this.jWi.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.jWf != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.jWf.getPageContext(), i);
            }
            am.l(this.mNavigationBar, R.color.cp_bg_line_d);
            am.l(this.mRoot, R.color.cp_bg_line_d);
            this.jWi.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.jWi.setTextColor(am.getColor(R.color.cp_cont_f));
            am.l(this.jWk, R.color.cp_bg_line_e);
            am.j(this.jWn, R.color.cp_cont_b);
            am.j(this.jWo, R.color.cp_cont_d);
            am.j(this.jWr, R.color.cp_cont_b);
            am.l(this.jWq, R.color.cp_bg_line_d);
            am.j(this.jWq, R.color.cp_cont_d);
            am.k(this.jWj, R.drawable.bg_link_invoke);
            am.l(this.jWs, R.color.cp_bg_line_d);
            this.jWt.setHintTextColor(am.getColor(R.color.cp_cont_e));
            am.j(this.jWt, R.color.cp_cont_b);
            am.j(this.jWx, R.color.cp_cont_d);
            am.j(this.jWv, R.color.cp_cont_e);
            am.c(this.jWl, (int) R.drawable.home_ic_video);
            am.k(this.jWp, R.drawable.btn_delete_url);
            am.k(this.jWu, R.drawable.btn_delete_url);
            am.k(this.jWm, R.drawable.btn_delete_url);
            cDc();
        }
    }

    public void cDc() {
        boolean z;
        if (StringUtils.isNull(cDd())) {
            z = this.jWk.getVisibility() == 0 || this.idC.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            am.e(this.jWg, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.jWg.setEnabled(true);
            return;
        }
        am.f(this.jWg, R.color.cp_cont_d, 1);
        this.jWg.setEnabled(false);
    }

    public String cDd() {
        if (this.jWi == null || this.jWi.getText() == null) {
            return null;
        }
        return this.jWi.getText().toString();
    }

    public View bGy() {
        return this.bCe;
    }

    public View cDe() {
        return this.jWg;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText cDf() {
        return this.jWi;
    }

    public View cDg() {
        return this.jWp;
    }

    public View cDh() {
        return this.jWm;
    }

    public View cDi() {
        return this.jWk;
    }

    public View getVideoContainer() {
        return this.idC;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.jWt.setText(aVar.linkUrl);
            this.jWt.setSelection(aVar.linkUrl.length());
        }
        this.jWt.requestFocus();
        l.c(this.jWf.getActivity(), this.jWt);
        this.jWs.setVisibility(0);
        this.jWw.setVisibility(0);
        this.jWj.setVisibility(8);
    }

    public void cDj() {
        this.jWs.setVisibility(8);
        this.jWw.setVisibility(8);
        this.jWj.setVisibility(0);
        l.b(this.jWf.getActivity(), this.jWt);
    }

    public void ae(View.OnClickListener onClickListener) {
        this.jWs.setOnClickListener(onClickListener);
        this.jWw.setOnClickListener(onClickListener);
        this.jWj.setOnClickListener(onClickListener);
    }

    public String cDk() {
        if (this.jWt == null || this.jWt.getText() == null) {
            return null;
        }
        return this.jWt.getText().toString();
    }

    public void cDl() {
        if (this.jWx != null) {
            this.jWx.setText(R.string.tip_url_not_match);
            am.j(this.jWx, R.color.cp_other_b);
        }
    }

    public void af(View.OnClickListener onClickListener) {
        if (this.jWv != null) {
            this.jWv.setOnClickListener(onClickListener);
        }
    }

    public View cDm() {
        return this.jWs;
    }

    public void destroy() {
        if (this.jWi != null) {
            this.jWi.addTextChangedListener(null);
        }
        if (this.jWt != null) {
            this.jWt.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aJ(this.jWf.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.jWf.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.jWf.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.cCv.e(null);
        this.cCv.iz(R.string.sending);
        this.cCv.ej(true);
    }

    public void closeLoadingDialog() {
        this.cCv.ej(false);
    }
}
