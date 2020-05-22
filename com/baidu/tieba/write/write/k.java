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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class k {
    private TbImageView aii;
    private View dyp;
    private com.baidu.tbadk.core.view.a euw;
    private RelativeLayout kba;
    private WriteUrlActivity lZT;
    private TextView lZU;
    private TbImageView lZV;
    private EditText lZW;
    private View lZX;
    private LinearLayout lZY;
    private ImageView lZZ;
    private View.OnClickListener mClickListener;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private View maa;
    private TextView mab;
    private TextView mad;
    private View mae;
    private TextView maf;
    private TextView mag;
    private LinearLayout mah;
    private EditText mai;
    private View maj;
    private TextView mak;
    private FrameLayout mal;
    private TextView mam;

    public k(WriteUrlActivity writeUrlActivity, View.OnClickListener onClickListener) {
        this.mNavigationBar = null;
        this.dyp = null;
        this.euw = null;
        if (writeUrlActivity != null) {
            this.lZT = writeUrlActivity;
            this.mClickListener = onClickListener;
            this.mRoot = LayoutInflater.from(this.lZT.getPageContext().getPageActivity()).inflate(R.layout.write_url_activity_layout, (ViewGroup) null);
            this.lZT.setContentView(this.mRoot);
            this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.dyp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mClickListener);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.aUV().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dyp.getLayoutParams();
                layoutParams.leftMargin = l.getDimens(this.lZT.getActivity(), R.dimen.ds10);
                backImageView.setLayoutParams(layoutParams);
            }
            if (this.dyp != null && (this.dyp.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dyp.getLayoutParams();
                layoutParams2.width = -2;
                this.dyp.setLayoutParams(layoutParams2);
            }
            this.mRoot.setOnClickListener(this.mClickListener);
            this.lZU = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, writeUrlActivity.getResources().getString(R.string.send_post));
            am.setViewTextColor(this.lZU, R.color.cp_link_tip_a, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.lZU.getLayoutParams();
            layoutParams3.rightMargin = l.getDimens(this.lZT.getActivity(), R.dimen.ds16);
            this.lZU.setLayoutParams(layoutParams3);
            this.lZU.setOnClickListener(this.mClickListener);
            this.mNavigationBar.setCenterTextTitle(writeUrlActivity.getResources().getString(R.string.post_new_thread));
            this.lZV = (TbImageView) this.mRoot.findViewById(R.id.imageview_picture);
            this.lZV.setDefaultResource(R.drawable.ic_post_url_n);
            this.lZV.setDefaultErrorResource(R.drawable.ic_post_url_n);
            this.lZV.setDefaultBgResource(R.color.black_alpha0);
            this.lZY = (LinearLayout) this.mRoot.findViewById(R.id.view_picture_publish);
            this.lZY.setOnClickListener(this.mClickListener);
            this.kba = (RelativeLayout) this.mRoot.findViewById(R.id.video_container);
            this.kba.setOnClickListener(this.mClickListener);
            this.aii = (TbImageView) this.mRoot.findViewById(R.id.video_img_thumbnail);
            this.aii.setDefaultErrorResource(0);
            this.aii.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.aii.setDefaultBgResource(R.color.black_alpha0);
            this.lZZ = (ImageView) this.mRoot.findViewById(R.id.video_img_play);
            this.maa = this.mRoot.findViewById(R.id.video_view_delete);
            this.maa.setOnClickListener(this.mClickListener);
            this.mab = (TextView) this.mRoot.findViewById(R.id.textview_title);
            this.mad = (TextView) this.mRoot.findViewById(R.id.textview_abstract);
            this.mae = this.mRoot.findViewById(R.id.view_delete);
            this.mae.setOnClickListener(this.mClickListener);
            this.lZX = this.mRoot.findViewById(R.id.icon_invoke_link);
            this.lZX.setOnClickListener(this.mClickListener);
            this.lZW = (EditText) this.mRoot.findViewById(R.id.post_content);
            this.maf = (TextView) this.mRoot.findViewById(R.id.textview_error_tip);
            this.mag = (TextView) this.mRoot.findViewById(R.id.textview_url);
            this.mah = (LinearLayout) this.mRoot.findViewById(R.id.url_edit_container);
            this.mai = (EditText) this.mRoot.findViewById(R.id.url_input);
            this.mam = (TextView) this.mRoot.findViewById(R.id.url_desc);
            this.maj = this.mRoot.findViewById(R.id.url_input_clear);
            this.mak = (TextView) this.mRoot.findViewById(R.id.url_add);
            this.mak.setEnabled(false);
            this.mal = (FrameLayout) this.mRoot.findViewById(R.id.url_edit_back_view);
            this.mai.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.k.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence == null || charSequence.length() <= 0) {
                        k.this.maj.setVisibility(8);
                        am.setViewTextColor(k.this.mak, (int) R.color.cp_cont_e);
                        k.this.mak.setEnabled(false);
                        return;
                    }
                    k.this.maj.setVisibility(0);
                    am.setViewTextColor(k.this.mak, (int) R.color.cp_link_tip_a);
                    k.this.mak.setEnabled(true);
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (k.this.mam.getText().equals(k.this.lZT.getActivity().getString(R.string.tip_url_not_match))) {
                        k.this.dpp();
                    }
                }
            });
            this.maj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.mai.setText("");
                    k.this.maj.setVisibility(8);
                    k.this.mak.setEnabled(false);
                }
            });
            this.euw = new com.baidu.tbadk.core.view.a(this.lZT.getPageContext());
            dpp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpp() {
        if (StringUtils.isNull(TbadkCoreApplication.getInst().getUrlText())) {
            this.mam.setText(R.string.tip_url_post);
        } else {
            this.mam.setText(TbadkCoreApplication.getInst().getUrlText());
        }
        am.setViewTextColor(this.mam, (int) R.color.cp_cont_d);
    }

    public void a(com.baidu.tieba.write.a.a aVar, boolean z) {
        this.lZT.setIsLoading(z);
        if (z) {
            this.lZY.setVisibility(0);
            this.kba.setVisibility(8);
            this.lZV.startLoad(null, 10, false);
            this.mab.setVisibility(8);
            this.mad.setVisibility(8);
            this.maf.setVisibility(8);
            this.mag.setVisibility(0);
            am.setViewTextColor(this.mag, (int) R.color.cp_cont_f);
            this.mag.setText(R.string.tip_url_loading);
        } else if (aVar == null) {
            this.lZY.setVisibility(8);
            this.kba.setVisibility(8);
            dpq();
        } else {
            if (aVar.lSB == 1) {
                this.lZY.setVisibility(0);
                this.kba.setVisibility(8);
                if (aVar.lSA) {
                    this.lZV.startLoad(aVar.lSD, 10, false);
                    this.mab.setText(aVar.linkTitle);
                    this.mad.setText(aVar.dCN);
                    if (aq.getRealSize(aVar.linkTitle) > 30) {
                        this.mab.setMaxLines(2);
                        this.mad.setMaxLines(1);
                    } else {
                        this.mab.setMaxLines(1);
                        this.mad.setMaxLines(2);
                    }
                    this.mab.setVisibility(0);
                    this.mad.setVisibility(0);
                    this.mag.setVisibility(8);
                    this.maf.setVisibility(8);
                } else {
                    this.lZV.reset();
                    this.mag.setText(aVar.linkUrl);
                    am.setViewTextColor(this.mag, (int) R.color.cp_cont_b);
                    this.mab.setVisibility(8);
                    this.mad.setVisibility(8);
                    this.mag.setVisibility(0);
                    this.maf.setVisibility(0);
                }
            } else if (aVar.lSB == 2) {
                this.lZY.setVisibility(8);
                this.kba.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.kba.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(this.lZT.getPageContext().getPageActivity()) - ((int) this.lZT.getPageContext().getPageActivity().getResources().getDimension(R.dimen.ds80))) * 9) / 16;
                this.kba.setLayoutParams(layoutParams);
                am.setImageResource(this.lZZ, R.drawable.icon_play_video);
                am.setBackgroundResource(this.maa, R.drawable.btn_delete_url);
                this.aii.startLoad(aVar.lSG, 10, false);
            } else {
                this.lZY.setVisibility(0);
                this.kba.setVisibility(8);
                this.mab.setVisibility(8);
                this.mad.setVisibility(8);
                this.mag.setVisibility(0);
                this.maf.setVisibility(0);
                this.lZV.reset();
                this.mag.setText(aVar.linkUrl);
                am.setViewTextColor(this.mag, (int) R.color.cp_cont_b);
            }
            dpq();
        }
    }

    public void e(TextWatcher textWatcher) {
        this.lZW.addTextChangedListener(textWatcher);
    }

    public void onChangeSkinType(int i) {
        if (this.lZT != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.lZT.getPageContext(), i);
            }
            am.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
            this.lZW.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.lZW.setTextColor(am.getColor(R.color.cp_cont_f));
            am.setBackgroundColor(this.lZY, R.color.cp_bg_line_e);
            am.setViewTextColor(this.mab, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.mad, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.mag, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.maf, R.color.cp_bg_line_d);
            am.setViewTextColor(this.maf, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.lZX, R.drawable.bg_link_invoke);
            am.setBackgroundColor(this.mah, R.color.cp_bg_line_d);
            this.mai.setHintTextColor(am.getColor(R.color.cp_cont_e));
            am.setViewTextColor(this.mai, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.mam, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.mak, (int) R.color.cp_cont_e);
            am.setImageResource(this.lZZ, R.drawable.home_ic_video);
            am.setBackgroundResource(this.mae, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.maj, R.drawable.btn_delete_url);
            am.setBackgroundResource(this.maa, R.drawable.btn_delete_url);
            dpq();
        }
    }

    public void dpq() {
        boolean z;
        if (StringUtils.isNull(dpr())) {
            z = this.lZY.getVisibility() == 0 || this.kba.getVisibility() == 0;
        } else {
            z = true;
        }
        if (z) {
            am.setNavbarTitleColor(this.lZU, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.lZU.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.lZU, R.color.cp_cont_d, 1);
        this.lZU.setEnabled(false);
    }

    public String dpr() {
        if (this.lZW == null || this.lZW.getText() == null) {
            return null;
        }
        return this.lZW.getText().toString();
    }

    public View cpj() {
        return this.dyp;
    }

    public View dps() {
        return this.lZU;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public EditText dpt() {
        return this.lZW;
    }

    public View dpu() {
        return this.mae;
    }

    public View dpv() {
        return this.maa;
    }

    public View dpw() {
        return this.lZY;
    }

    public View getVideoContainer() {
        return this.kba;
    }

    public void b(com.baidu.tieba.write.a.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.linkUrl)) {
            this.mai.setText(aVar.linkUrl);
            this.mai.setSelection(aVar.linkUrl.length());
        }
        this.mai.requestFocus();
        l.showSoftKeyPad(this.lZT.getActivity(), this.mai);
        this.mah.setVisibility(0);
        this.mal.setVisibility(0);
        this.lZX.setVisibility(8);
    }

    public void dpx() {
        this.mah.setVisibility(8);
        this.mal.setVisibility(8);
        this.lZX.setVisibility(0);
        l.hideSoftKeyPad(this.lZT.getActivity(), this.mai);
    }

    public void aj(View.OnClickListener onClickListener) {
        this.mah.setOnClickListener(onClickListener);
        this.mal.setOnClickListener(onClickListener);
        this.lZX.setOnClickListener(onClickListener);
    }

    public String dpy() {
        if (this.mai == null || this.mai.getText() == null) {
            return null;
        }
        return this.mai.getText().toString();
    }

    public void dpz() {
        if (this.mam != null) {
            this.mam.setText(R.string.tip_url_not_match);
            am.setViewTextColor(this.mam, (int) R.color.cp_other_b);
        }
    }

    public void ak(View.OnClickListener onClickListener) {
        if (this.mak != null) {
            this.mak.setOnClickListener(onClickListener);
        }
    }

    public View dpA() {
        return this.mah;
    }

    public void destroy() {
        if (this.lZW != null) {
            this.lZW.addTextChangedListener(null);
        }
        if (this.mai != null) {
            this.mai.addTextChangedListener(null);
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            if (AntiHelper.bv(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aX(this.lZT.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.lZT.getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                this.lZT.showToast(errorString);
            }
        }
    }

    public void showLoadingDialog() {
        this.euw.setCancelListener(null);
        this.euw.setTipString(R.string.sending);
        this.euw.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.euw.setDialogVisiable(false);
    }
}
