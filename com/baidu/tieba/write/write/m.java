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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes3.dex */
public class m {
    private TbImageView alJ;
    private View epo;
    private com.baidu.tbadk.core.view.a fsa;
    private TextView iOn;
    private RelativeLayout lEW;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private View nJA;
    private TextView nJB;
    private TextView nJC;
    private LinearLayout nJD;
    private EditText nJE;
    private View nJF;
    private TextView nJG;
    private FrameLayout nJH;
    private TextView nJI;
    private WriteUrlActivity nJr;
    private TbImageView nJs;
    private EditText nJt;
    private View nJu;
    private LinearLayout nJv;
    private ImageView nJw;
    private View nJx;
    private TextView nJy;
    private TextView nJz;

    public m(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.epo = null;
        this.fsa = null;
        if (writeUrlActivity != null) {
            this.nJr = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.nJr.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.nJr.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.epo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.boN().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.epo.getLayoutParams();
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.nJr.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.epo != null && (this.epo.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.epo.getLayoutParams();
                layoutParams2.width = -2;
                this.epo.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.iOn = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            ap.setViewTextColor(this.iOn, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.iOn.getLayoutParams();
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.nJr.getActivity(), R.dimen.ds16);
            this.iOn.setLayoutParams(layoutParams3);
            this.iOn.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.nJs = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.nJs.setDefaultResource(R.drawable.ic_post_url_n);
            this.nJs.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.nJs.setDefaultBgResource(R.color.black_alpha0);
            this.nJv = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.nJv.setOnClickListener(this.mClickListener);
            this.lEW = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.lEW.setOnClickListener(this.mClickListener);
            this.alJ = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.alJ.setDefaultErrorResource(0);
            this.alJ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.alJ.setDefaultBgResource(R.color.black_alpha0);
            this.nJw = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.nJx = this.mRoot.findViewById(R.id.video_view_delete);
            this.nJx.setOnClickListener(this.mClickListener);
            this.nJy = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.nJz = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.nJA = this.mRoot.findViewById(R.id.view_delete);
            this.nJA.setOnClickListener(this.mClickListener);
            this.nJu = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.nJu.setOnClickListener(this.mClickListener);
            this.nJt = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.nJB = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.nJC = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.nJD = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.nJE = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.nJI = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.nJF = this.mRoot.findViewById(R.id.url_input_clear);
            this.nJG = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.nJG.setEnabled(false);
            this.nJH = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.nJE.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.m.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        m.this.nJF.setVisibility(8);
                        ap.setViewTextColor(m.this.nJG, R.color.cp_cont_e);
                        m.this.nJG.setEnabled(false);
                        return;
                    }
                    m.this.nJF.setVisibility(0);
                    ap.setViewTextColor(m.this.nJG, R.color.cp_link_tip_a);
                    m.this.nJG.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (m.this.nJI.getText().equals(m.this.nJr.getActivity().getString(R.string.tip_url_not_match))) {
                        m.this.dUe();
                    }
                }
            });
            this.nJF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    m.this.nJE.setText("");
                    m.this.nJF.setVisibility(8);
                    m.this.nJG.setEnabled(false);
                }
            });
            this.fsa = new com.baidu.tbadk.core.view.a(this.nJr.getPageContext());
            dUe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUe() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.nJI.setText(R.string.tip_url_post);
        } else {
            this.nJI.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        ap.setViewTextColor(this.nJI, R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.nJr.setIsLoading(z);
        if (z) {
            this.nJv.setVisibility(0);
            this.lEW.setVisibility(8);
            this.nJs.startLoad(null, 10, false);
            this.nJy.setVisibility(8);
            this.nJz.setVisibility(8);
            this.nJB.setVisibility(8);
            this.nJC.setVisibility(0);
            ap.setViewTextColor(this.nJC, R.color.cp_cont_f);
            this.nJC.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.nJv.setVisibility(8);
            this.lEW.setVisibility(8);
            dUf();
        } else {
            if (aVar.nAJ == 1) {
                this.nJv.setVisibility(0);
                this.lEW.setVisibility(8);
                if (aVar.nAI) {
                    this.nJs.startLoad(aVar.nAL, 10, false);
                    this.nJy.setText(aVar.linkTitle);
                    this.nJz.setText(aVar.evC);
                    if (at.getRealSize(aVar.linkTitle) > 30) {
                        this.nJy.setMaxLines(2);
                        this.nJz.setMaxLines(1);
                    } else {
                        this.nJy.setMaxLines(1);
                        this.nJz.setMaxLines(2);
                    }
                    this.nJy.setVisibility(0);
                    this.nJz.setVisibility(0);
                    this.nJC.setVisibility(8);
                    this.nJB.setVisibility(8);
                } else {
                    this.nJs.reset();
                    this.nJC.setText(aVar.linkUrl);
                    ap.setViewTextColor(this.nJC, R.color.cp_cont_b);
                    this.nJy.setVisibility(8);
                    this.nJz.setVisibility(8);
                    this.nJC.setVisibility(0);
                    this.nJB.setVisibility(0);
                }
            } else if (aVar.nAJ == 2) {
                this.nJv.setVisibility(8);
                this.lEW.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.lEW.getLayoutParams();
                layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(this.nJr.getPageContext().getPageActivity()) - ((int) this.nJr.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.lEW.setLayoutParams(layoutParams);
                ap.setImageResource(this.nJw, R.drawable.icon_play_video);
                ap.setBackgroundResource(this.nJx, R.drawable.btn_delete_url);
                this.alJ.startLoad(aVar.nAO, 10, false);
            } else {
                this.nJv.setVisibility(0);
                this.lEW.setVisibility(8);
                this.nJy.setVisibility(8);
                this.nJz.setVisibility(8);
                this.nJC.setVisibility(0);
                this.nJB.setVisibility(0);
                this.nJs.reset();
                this.nJC.setText(aVar.linkUrl);
                ap.setViewTextColor(this.nJC, R.color.cp_cont_b);
            }
            dUf();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.nJt.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.nJr != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.nJr.getPageContext(), i);
            }
            ap.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
            this.nJt.setHintTextColor(ap.getColor(R.color.cp_cont_e));
            this.nJt.setTextColor(ap.getColor(R.color.cp_cont_f));
            ap.setBackgroundColor(this.nJv, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.nJy, R.color.cp_cont_b);
            ap.setViewTextColor(this.nJz, R.color.cp_cont_d);
            ap.setViewTextColor(this.nJC, R.color.cp_cont_b);
            ap.setBackgroundColor(this.nJB, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.nJB, R.color.cp_cont_d);
            ap.setBackgroundResource(this.nJu, R.drawable.bg_link_invoke);
            ap.setBackgroundColor(this.nJD, R.color.cp_bg_line_d);
            this.nJE.setHintTextColor(ap.getColor(R.color.cp_cont_e));
            ap.setViewTextColor(this.nJE, R.color.cp_cont_b);
            ap.setViewTextColor(this.nJI, R.color.cp_cont_d);
            ap.setViewTextColor(this.nJG, R.color.cp_cont_e);
            ap.setImageResource(this.nJw, R.drawable.home_ic_video);
            ap.setBackgroundResource(this.nJA, R.drawable.btn_delete_url);
            ap.setBackgroundResource(this.nJF, R.drawable.btn_delete_url);
            ap.setBackgroundResource(this.nJx, R.drawable.btn_delete_url);
            dUf();
        }
    }

    public void dUf() {
        boolean z;
        if (StringUtils.isNull(dUg())) {
            z = this.nJv.getVisibility() == 0 || this.lEW.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            ap.setNavbarTitleColor(this.iOn, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.iOn.setEnabled(true);
            return;
        }
        ap.setViewTextColor(this.iOn, R.color.cp_cont_d, 1);
        this.iOn.setEnabled(false);
    }

    public String dUg() {
        if (this.nJt == null || this.nJt.getText() == null) {
            return null;
        }
        return this.nJt.getText().toString();
    }

    public View cSx() {
        return this.epo;
    }

    public View dUh() {
        return this.iOn;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText dUi() {
        return this.nJt;
    }

    public View dUj() {
        return this.nJA;
    }

    public View dUk() {
        return this.nJx;
    }

    public View dUl() {
        return this.nJv;
    }

    public View getVideoContainer() {
        return this.lEW;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.nJE.setText(aVar.linkUrl);
            this.nJE.setSelection(aVar.linkUrl.length());
        }
        this.nJE.requestFocus();
        com.baidu.adp.lib.util.l.showSoftKeyPad(this.nJr.getActivity(), this.nJE);
        this.nJD.setVisibility(0);
        this.nJH.setVisibility(0);
        this.nJu.setVisibility(8);
    }

    public void dUm() {
        this.nJD.setVisibility(8);
        this.nJH.setVisibility(8);
        this.nJu.setVisibility(0);
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this.nJr.getActivity(), this.nJE);
    }

    public void am(View.OnClickListener onClickListener) {
        this.nJD.setOnClickListener(onClickListener);
        this.nJH.setOnClickListener(onClickListener);
        this.nJu.setOnClickListener(onClickListener);
    }

    public String dUn() {
        if (this.nJE == null || this.nJE.getText() == null) {
            return null;
        }
        return this.nJE.getText().toString();
    }

    public void dUo() {
        if (this.nJI != null) {
            this.nJI.setText(R.string.tip_url_not_match);
            ap.setViewTextColor(this.nJI, R.color.cp_other_b);
        }
    }

    public void an(View.OnClickListener onClickListener) {
        if (this.nJG != null) {
            this.nJG.setOnClickListener(onClickListener);
        }
    }

    public View dUp() {
        return this.nJD;
    }

    public void destroy() {
        if (this.nJt != null) {
            this.nJt.addTextChangedListener(null);
        }
        if (this.nJE != null) {
            this.nJE.addTextChangedListener(null);
        }
    }

    public void n(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.bN(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bm(this.nJr.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.nJr.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.nJr.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.fsa.setCancelListener(null);
        this.fsa.setTipString(R.string.sending);
        this.fsa.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.fsa.setDialogVisiable(false);
    }
}
