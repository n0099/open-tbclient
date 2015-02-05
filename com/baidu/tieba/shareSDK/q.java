package com.baidu.tieba.shareSDK;

import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.ShareSDKImageView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.write.ch;
import com.baidu.tieba.z;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class q {
    private View bPH;
    private TextView bPL;
    private ch bPM;
    private ImageView bPN;
    private View bPO;
    private LinearLayout bPP;
    private LinearLayout bPQ;
    private ShareSDKImageView bPR;
    private TextView bPS;
    private TextView bPT;
    private WriteShareActivity bPU;
    private WriteData bPo;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText bPF = null;
    private View bPG = null;
    private LinearLayout bPI = null;
    private EditText bPJ = null;
    private TextView bPK = null;
    private RelativeLayout mParent = null;
    private boolean bPV = false;
    private int width = 0;
    private int height = 0;

    public q(WriteShareActivity writeShareActivity) {
        this.bPo = null;
        this.bPU = writeShareActivity;
        this.bPo = writeShareActivity.Fn();
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.bPU.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bPU.getPageContext().getString(z.share_navigationbar_title));
        this.bPK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.bPU.getPageContext().getString(z.send_post));
        this.mParent = (RelativeLayout) this.bPU.findViewById(com.baidu.tieba.w.parent);
        this.bPG = this.bPU.findViewById(com.baidu.tieba.w.interval_view);
        this.bPH = this.bPU.findViewById(com.baidu.tieba.w.prefix_interval_view);
        this.bPP = (LinearLayout) this.bPU.findViewById(com.baidu.tieba.w.post_share_layout);
        this.bPQ = (LinearLayout) this.bPU.findViewById(com.baidu.tieba.w.post_share_content_layout);
        this.bPR = (ShareSDKImageView) this.bPU.findViewById(com.baidu.tieba.w.post_share_image);
        this.bPS = (TextView) this.bPU.findViewById(com.baidu.tieba.w.post_share_title);
        this.bPT = (TextView) this.bPU.findViewById(com.baidu.tieba.w.post_share_content);
        ade();
        adg();
        this.bPI = (LinearLayout) this.bPU.findViewById(com.baidu.tieba.w.post_content_container);
        this.bPI.setDrawingCacheEnabled(false);
        this.bPF.setVisibility(0);
        this.bPJ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI)});
        adc();
        adf();
    }

    private void adc() {
        this.bPP = (LinearLayout) this.bPU.findViewById(com.baidu.tieba.w.post_share_layout);
        this.bPR = (ShareSDKImageView) this.bPU.findViewById(com.baidu.tieba.w.post_share_image);
        this.bPR.setIsRound(false);
        this.bPR.setDrawBorder(false);
        this.bPR.setAutoChangeStyle(true);
        this.bPR.setRadius(0);
        this.bPS = (TextView) this.bPU.findViewById(com.baidu.tieba.w.post_share_title);
        this.bPT = (TextView) this.bPU.findViewById(com.baidu.tieba.w.post_share_content);
        if (this.bPo != null) {
            this.bPR.setEvent(new r(this));
            if (this.bPo.getShareSummaryImg() != null && this.bPo.getShareSummaryImg().trim().length() > 0) {
                this.bPR.d(this.bPo.getShareSummaryImg(), 10, true);
            } else {
                this.bPV = true;
                adf();
            }
            this.bPo.setShareSummaryImgType(com.baidu.adp.lib.util.commonsio.b.aK(this.bPo.getShareSummaryImg()));
            this.bPS.setText(this.bPo.getShareSummaryTitle());
            this.bPT.setText(this.bPo.getShareSummaryContent());
        }
    }

    private void add() {
        this.bPO = this.bPU.findViewById(com.baidu.tieba.w.post_prefix_layout);
        this.bPL = (TextView) this.bPU.findViewById(com.baidu.tieba.w.post_prefix);
        this.bPN = (ImageView) this.bPU.findViewById(com.baidu.tieba.w.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.bPO.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.bPL.setText(prefixs.get(0));
            this.bPU.hA(0);
            this.bPO.setOnClickListener(new s(this));
            this.bPN = (ImageView) this.bPU.findViewById(com.baidu.tieba.w.prefix_icon);
            if (size > 1) {
                this.bPN.setVisibility(0);
                this.bPL.setOnClickListener(new t(this));
            }
            this.bPM = new ch(this.bPU.getPageContext().getContext());
            this.bPM.setMaxHeight(com.baidu.adp.lib.util.l.dip2px(this.bPU.getPageContext().getContext(), 225.0f));
            this.bPM.setOutsideTouchable(true);
            this.bPM.setFocusable(true);
            this.bPM.setBackgroundDrawable(bc.getDrawable(com.baidu.tieba.t.cp_bg_line_b));
            this.bPM.a(new u(this));
            this.bPM.setOnDismissListener(new v(this));
            int color = bc.getColor(com.baidu.tieba.t.write_text);
            bc.i((View) this.bPL, com.baidu.tieba.v.write_prefix_item_selector);
            bc.c(this.bPN, com.baidu.tieba.v.icon_title_down);
            this.bPL.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.bPU.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.dip2px(this.bPU.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                bc.i((View) textView, com.baidu.tieba.v.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.bPU.getPageContext().getContext(), this.bPU.getResources().getDimension(com.baidu.tieba.u.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.bPU.getPageContext().getContext(), this.bPU.getResources().getDimension(com.baidu.tieba.u.ds22)), 0);
                this.bPM.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.dip2px(this.bPU.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.bPU.getPageContext().getContext(), this.bPU.getResources().getDimension(com.baidu.tieba.u.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.bPU.getPageContext().getContext(), this.bPU.getResources().getDimension(com.baidu.tieba.u.ds22)), 0);
                }
            }
            this.bPM.setCurrentIndex(0);
            return;
        }
        this.bPO.setVisibility(8);
    }

    protected void ade() {
        this.bPF = (EditText) this.bPU.findViewById(com.baidu.tieba.w.post_title);
        if (this.bPo.getType() == 3) {
            if (this.bPo.getTitle() != null && this.bPo.getTitle().trim().length() > 0) {
                this.bPF.setText(this.bPo.getTitle());
                this.bPF.setSelection(this.bPo.getTitle().length());
            } else {
                String str = String.valueOf(this.bPU.getPageContext().getString(z.share_transfer_thread)) + this.bPo.getShareSummaryTitle();
                this.bPF.setText(str);
                if (str.length() < 20) {
                    this.bPF.setSelection(str.length());
                } else {
                    this.bPF.setSelection(20);
                }
            }
        }
        this.bPF.addTextChangedListener(new w(this));
    }

    public void adf() {
        String str = null;
        if (this.bPo.getType() == 3) {
            String trim = this.bPF.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.bPU.acZ() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.bPo.setIsNoTitle(true);
                    } else {
                        this.bPo.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.bPo.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.bPo.setIsNoTitle(true);
            } else {
                this.bPo.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.bPV) {
            this.bPK.setEnabled(false);
        } else {
            this.bPK.setEnabled(true);
        }
    }

    protected void adg() {
        this.bPJ = (EditText) this.bPU.findViewById(com.baidu.tieba.w.post_content);
        this.bPJ.setDrawingCacheEnabled(false);
        if (this.bPo.getContent() != null && this.bPo.getContent().length() > 0) {
            SpannableString E = TbFaceManager.vX().E(this.bPU.getPageContext().getContext(), this.bPo.getContent());
            this.bPJ.setText(E);
            this.bPJ.setSelection(E.length());
        }
        this.bPJ.setOnTouchListener(new x(this));
        this.bPJ.addTextChangedListener(new y(this));
    }

    private void a(EditText editText, int i) {
        Editable text = editText.getText();
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        editText.setText((CharSequence) null);
        editText.setHintTextColor(i);
        editText.setText(text);
        editText.setSelection(selectionStart, selectionEnd);
    }

    public EditText adh() {
        return this.bPF;
    }

    public EditText adi() {
        return this.bPJ;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        add();
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.bPF.setOnFocusChangeListener(onFocusChangeListener);
        this.bPJ.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.bPK.setOnFocusChangeListener(onFocusChangeListener);
    }

    public ch adj() {
        return this.bPM;
    }

    public View adk() {
        return this.mBack;
    }

    public TextView adl() {
        return this.bPK;
    }

    public TextView adm() {
        return this.bPL;
    }

    public void E(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void F(View.OnClickListener onClickListener) {
        this.bPK.setOnClickListener(onClickListener);
    }

    public void G(View.OnClickListener onClickListener) {
        this.bPI.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.bPU != null) {
            this.bPU.getLayoutMode().ab(i == 1);
            this.bPU.getLayoutMode().h(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.bPU.getPageContext(), i);
            bc.g(this.bPK, i);
            bc.j(this.bPG, com.baidu.tieba.t.cp_bg_line_c);
            bc.j(this.bPH, com.baidu.tieba.t.cp_bg_line_c);
            bc.j((View) this.bPF, com.baidu.tieba.t.cp_cont_g);
            bc.j(this.bPQ, com.baidu.tieba.t.cp_bg_line_e);
            int color = bc.getColor(com.baidu.tieba.t.cp_cont_b);
            int color2 = bc.getColor(com.baidu.tieba.t.cp_cont_e);
            this.bPF.setTextColor(color);
            this.bPJ.setTextColor(color);
            this.bPS.setTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_b));
            this.bPT.setTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_d));
            a(this.bPF, color2);
            a(this.bPJ, color2);
            adf();
        }
    }
}
