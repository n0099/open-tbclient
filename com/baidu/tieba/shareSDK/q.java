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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.ShareSDKImageView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.write.ch;
import com.baidu.tieba.z;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class q {
    private WriteData bNF;
    private View bNY;
    private TextView bOc;
    private ch bOd;
    private ImageView bOe;
    private View bOf;
    private LinearLayout bOg;
    private LinearLayout bOh;
    private ShareSDKImageView bOi;
    private TextView bOj;
    private TextView bOk;
    private WriteShareActivity bOl;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText bNW = null;
    private View bNX = null;
    private LinearLayout bNZ = null;
    private EditText bOa = null;
    private TextView bOb = null;
    private RelativeLayout mParent = null;
    private boolean bOm = false;
    private int width = 0;
    private int height = 0;

    public q(WriteShareActivity writeShareActivity) {
        this.bNF = null;
        this.bOl = writeShareActivity;
        this.bNF = writeShareActivity.EV();
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.bOl.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bOl.getPageContext().getString(z.share_navigationbar_title));
        this.bOb = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.bOl.getPageContext().getString(z.send_post));
        this.mParent = (RelativeLayout) this.bOl.findViewById(com.baidu.tieba.w.parent);
        this.bNX = this.bOl.findViewById(com.baidu.tieba.w.interval_view);
        this.bNY = this.bOl.findViewById(com.baidu.tieba.w.prefix_interval_view);
        this.bOg = (LinearLayout) this.bOl.findViewById(com.baidu.tieba.w.post_share_layout);
        this.bOh = (LinearLayout) this.bOl.findViewById(com.baidu.tieba.w.post_share_content_layout);
        this.bOi = (ShareSDKImageView) this.bOl.findViewById(com.baidu.tieba.w.post_share_image);
        this.bOj = (TextView) this.bOl.findViewById(com.baidu.tieba.w.post_share_title);
        this.bOk = (TextView) this.bOl.findViewById(com.baidu.tieba.w.post_share_content);
        acF();
        acH();
        this.bNZ = (LinearLayout) this.bOl.findViewById(com.baidu.tieba.w.post_content_container);
        this.bNZ.setDrawingCacheEnabled(false);
        this.bNW.setVisibility(0);
        this.bOa.setFilters(new InputFilter[]{new InputFilter.LengthFilter(TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI)});
        acD();
        acG();
    }

    private void acD() {
        this.bOg = (LinearLayout) this.bOl.findViewById(com.baidu.tieba.w.post_share_layout);
        this.bOi = (ShareSDKImageView) this.bOl.findViewById(com.baidu.tieba.w.post_share_image);
        this.bOi.setIsRound(false);
        this.bOi.setDrawBorder(false);
        this.bOi.setAutoChangeStyle(true);
        this.bOi.setRadius(0);
        this.bOj = (TextView) this.bOl.findViewById(com.baidu.tieba.w.post_share_title);
        this.bOk = (TextView) this.bOl.findViewById(com.baidu.tieba.w.post_share_content);
        if (this.bNF != null) {
            this.bOi.setEvent(new r(this));
            if (this.bNF.getShareSummaryImg() != null && this.bNF.getShareSummaryImg().trim().length() > 0) {
                this.bOi.d(this.bNF.getShareSummaryImg(), 10, true);
            } else {
                this.bOm = true;
                acG();
            }
            this.bNF.setShareSummaryImgType(com.baidu.adp.lib.util.commonsio.b.aK(this.bNF.getShareSummaryImg()));
            this.bOj.setText(this.bNF.getShareSummaryTitle());
            this.bOk.setText(this.bNF.getShareSummaryContent());
        }
    }

    private void acE() {
        this.bOf = this.bOl.findViewById(com.baidu.tieba.w.post_prefix_layout);
        this.bOc = (TextView) this.bOl.findViewById(com.baidu.tieba.w.post_prefix);
        this.bOe = (ImageView) this.bOl.findViewById(com.baidu.tieba.w.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.bOf.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.bOc.setText(prefixs.get(0));
            this.bOl.hr(0);
            this.bOf.setOnClickListener(new s(this));
            this.bOe = (ImageView) this.bOl.findViewById(com.baidu.tieba.w.prefix_icon);
            if (size > 1) {
                this.bOe.setVisibility(0);
                this.bOc.setOnClickListener(new t(this));
            }
            this.bOd = new ch(this.bOl.getPageContext().getContext());
            this.bOd.setMaxHeight(com.baidu.adp.lib.util.l.dip2px(this.bOl.getPageContext().getContext(), 225.0f));
            this.bOd.setOutsideTouchable(true);
            this.bOd.setFocusable(true);
            this.bOd.setBackgroundDrawable(ax.getDrawable(com.baidu.tieba.t.cp_bg_line_b));
            this.bOd.a(new u(this));
            this.bOd.setOnDismissListener(new v(this));
            int color = ax.getColor(com.baidu.tieba.t.write_text);
            ax.i((View) this.bOc, com.baidu.tieba.v.write_prefix_item_selector);
            ax.c(this.bOe, com.baidu.tieba.v.icon_title_down);
            this.bOc.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.bOl.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.dip2px(this.bOl.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ax.i((View) textView, com.baidu.tieba.v.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.bOl.getPageContext().getContext(), this.bOl.getResources().getDimension(com.baidu.tieba.u.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.bOl.getPageContext().getContext(), this.bOl.getResources().getDimension(com.baidu.tieba.u.ds22)), 0);
                this.bOd.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.dip2px(this.bOl.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.bOl.getPageContext().getContext(), this.bOl.getResources().getDimension(com.baidu.tieba.u.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.bOl.getPageContext().getContext(), this.bOl.getResources().getDimension(com.baidu.tieba.u.ds22)), 0);
                }
            }
            this.bOd.setCurrentIndex(0);
            return;
        }
        this.bOf.setVisibility(8);
    }

    protected void acF() {
        this.bNW = (EditText) this.bOl.findViewById(com.baidu.tieba.w.post_title);
        if (this.bNF.getType() == 3) {
            if (this.bNF.getTitle() != null && this.bNF.getTitle().trim().length() > 0) {
                this.bNW.setText(this.bNF.getTitle());
                this.bNW.setSelection(this.bNF.getTitle().length());
            } else {
                String str = String.valueOf(this.bOl.getPageContext().getString(z.share_transfer_thread)) + this.bNF.getShareSummaryTitle();
                this.bNW.setText(str);
                if (str.length() < 20) {
                    this.bNW.setSelection(str.length());
                } else {
                    this.bNW.setSelection(20);
                }
            }
        }
        this.bNW.addTextChangedListener(new w(this));
    }

    public void acG() {
        String str = null;
        if (this.bNF.getType() == 3) {
            String trim = this.bNW.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.bOl.acA() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.bNF.setIsNoTitle(true);
                    } else {
                        this.bNF.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.bNF.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.bNF.setIsNoTitle(true);
            } else {
                this.bNF.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.bOm) {
            this.bOb.setEnabled(false);
        } else {
            this.bOb.setEnabled(true);
        }
    }

    protected void acH() {
        this.bOa = (EditText) this.bOl.findViewById(com.baidu.tieba.w.post_content);
        this.bOa.setDrawingCacheEnabled(false);
        if (this.bNF.getContent() != null && this.bNF.getContent().length() > 0) {
            SpannableString F = TbFaceManager.vK().F(this.bOl.getPageContext().getContext(), this.bNF.getContent());
            this.bOa.setText(F);
            this.bOa.setSelection(F.length());
        }
        this.bOa.setOnTouchListener(new x(this));
        this.bOa.addTextChangedListener(new y(this));
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

    public EditText acI() {
        return this.bNW;
    }

    public EditText acJ() {
        return this.bOa;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        acE();
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.bNW.setOnFocusChangeListener(onFocusChangeListener);
        this.bOa.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.bOb.setOnFocusChangeListener(onFocusChangeListener);
    }

    public ch acK() {
        return this.bOd;
    }

    public View acL() {
        return this.mBack;
    }

    public TextView acM() {
        return this.bOb;
    }

    public TextView acN() {
        return this.bOc;
    }

    public void D(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void E(View.OnClickListener onClickListener) {
        this.bOb.setOnClickListener(onClickListener);
    }

    public void F(View.OnClickListener onClickListener) {
        this.bNZ.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.bOl != null) {
            this.bOl.getLayoutMode().ab(i == 1);
            this.bOl.getLayoutMode().h(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.bOl.getPageContext(), i);
            ax.g(this.bOb, i);
            ax.j(this.bNX, com.baidu.tieba.t.cp_bg_line_c);
            ax.j(this.bNY, com.baidu.tieba.t.cp_bg_line_c);
            ax.j((View) this.bNW, com.baidu.tieba.t.cp_cont_g);
            ax.j(this.bOh, com.baidu.tieba.t.cp_bg_line_e);
            int color = ax.getColor(com.baidu.tieba.t.cp_cont_b);
            int color2 = ax.getColor(com.baidu.tieba.t.cp_cont_e);
            this.bNW.setTextColor(color);
            this.bOa.setTextColor(color);
            this.bOj.setTextColor(ax.getColor(com.baidu.tieba.t.cp_cont_b));
            this.bOk.setTextColor(ax.getColor(com.baidu.tieba.t.cp_cont_d));
            a(this.bNW, color2);
            a(this.bOa, color2);
            acG();
        }
    }
}
