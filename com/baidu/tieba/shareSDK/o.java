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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.ShareSDKImageView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.write.ch;
import com.baidu.tieba.y;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o {
    private View bJA;
    private LinearLayout bJB;
    private LinearLayout bJC;
    private ShareSDKImageView bJD;
    private TextView bJE;
    private TextView bJF;
    private WriteShareActivity bJG;
    private View bJt;
    private TextView bJx;
    private ch bJy;
    private ImageView bJz;
    private WriteData bpv;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View Js = null;
    private EditText bJr = null;
    private View bJs = null;
    private LinearLayout bJu = null;
    private EditText bJv = null;
    private TextView bJw = null;
    private RelativeLayout mParent = null;
    private boolean bJH = false;
    private int width = 0;
    private int height = 0;

    public o(WriteShareActivity writeShareActivity) {
        this.bpv = null;
        this.bJG = writeShareActivity;
        this.bpv = writeShareActivity.EC();
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.bJG.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.Js = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bJG.getString(y.share_navigationbar_title));
        this.bJw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.bJG.getString(y.send_post));
        this.mParent = (RelativeLayout) this.bJG.findViewById(com.baidu.tieba.v.parent);
        this.bJs = this.bJG.findViewById(com.baidu.tieba.v.interval_view);
        this.bJt = this.bJG.findViewById(com.baidu.tieba.v.prefix_interval_view);
        this.bJB = (LinearLayout) this.bJG.findViewById(com.baidu.tieba.v.post_share_layout);
        this.bJC = (LinearLayout) this.bJG.findViewById(com.baidu.tieba.v.post_share_content_layout);
        this.bJD = (ShareSDKImageView) this.bJG.findViewById(com.baidu.tieba.v.post_share_image);
        this.bJE = (TextView) this.bJG.findViewById(com.baidu.tieba.v.post_share_title);
        this.bJF = (TextView) this.bJG.findViewById(com.baidu.tieba.v.post_share_content);
        ach();
        acj();
        this.bJu = (LinearLayout) this.bJG.findViewById(com.baidu.tieba.v.post_content_container);
        this.bJu.setDrawingCacheEnabled(false);
        this.bJr.setVisibility(0);
        this.bJv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI)});
        acf();
        aci();
    }

    private void acf() {
        this.bJB = (LinearLayout) this.bJG.findViewById(com.baidu.tieba.v.post_share_layout);
        this.bJD = (ShareSDKImageView) this.bJG.findViewById(com.baidu.tieba.v.post_share_image);
        this.bJD.setIsRound(false);
        this.bJD.setDrawBorder(false);
        this.bJD.setAutoChangeStyle(true);
        this.bJD.setRadius(0);
        this.bJE = (TextView) this.bJG.findViewById(com.baidu.tieba.v.post_share_title);
        this.bJF = (TextView) this.bJG.findViewById(com.baidu.tieba.v.post_share_content);
        if (this.bpv != null) {
            this.bJD.setEvent(new p(this));
            if (this.bpv.getShareSummaryImg() != null && this.bpv.getShareSummaryImg().trim().length() > 0) {
                this.bJD.c(this.bpv.getShareSummaryImg(), 10, true);
            } else {
                this.bJH = true;
                aci();
            }
            this.bpv.setShareSummaryImgType(com.baidu.adp.lib.util.commonsio.b.aI(this.bpv.getShareSummaryImg()));
            this.bJE.setText(this.bpv.getShareSummaryTitle());
            this.bJF.setText(this.bpv.getShareSummaryContent());
        }
    }

    private void acg() {
        this.bJA = this.bJG.findViewById(com.baidu.tieba.v.post_prefix_layout);
        this.bJx = (TextView) this.bJG.findViewById(com.baidu.tieba.v.post_prefix);
        this.bJz = (ImageView) this.bJG.findViewById(com.baidu.tieba.v.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.bJA.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.bJx.setText(prefixs.get(0));
            this.bJG.hi(0);
            this.bJA.setOnClickListener(new q(this));
            this.bJz = (ImageView) this.bJG.findViewById(com.baidu.tieba.v.prefix_icon);
            if (size > 1) {
                this.bJz.setVisibility(0);
                this.bJx.setOnClickListener(new r(this));
            }
            this.bJy = new ch(this.bJG);
            this.bJy.setMaxHeight(com.baidu.adp.lib.util.m.dip2px(this.bJG, 225.0f));
            this.bJy.setOutsideTouchable(true);
            this.bJy.setFocusable(true);
            this.bJy.setBackgroundDrawable(aw.getDrawable(com.baidu.tieba.s.cp_bg_line_b));
            this.bJy.a(new s(this));
            this.bJy.setOnDismissListener(new t(this));
            int color = aw.getColor(com.baidu.tieba.s.write_text);
            aw.h((View) this.bJx, com.baidu.tieba.u.write_prefix_item_selector);
            aw.c(this.bJz, com.baidu.tieba.u.icon_title_down);
            this.bJx.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.bJG);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.m.dip2px(this.bJG, 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                aw.h((View) textView, com.baidu.tieba.u.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.m.dip2px(this.bJG, this.bJG.getResources().getDimension(com.baidu.tieba.t.ds6)), 0, com.baidu.adp.lib.util.m.dip2px(this.bJG, this.bJG.getResources().getDimension(com.baidu.tieba.t.ds22)), 0);
                this.bJy.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.m.dip2px(this.bJG, 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.m.dip2px(this.bJG, this.bJG.getResources().getDimension(com.baidu.tieba.t.ds6)), 0, com.baidu.adp.lib.util.m.dip2px(this.bJG, this.bJG.getResources().getDimension(com.baidu.tieba.t.ds22)), 0);
                }
            }
            this.bJy.dP(0);
            return;
        }
        this.bJA.setVisibility(8);
    }

    protected void ach() {
        this.bJr = (EditText) this.bJG.findViewById(com.baidu.tieba.v.post_title);
        if (this.bpv.getType() == 3) {
            if (this.bpv.getTitle() != null && this.bpv.getTitle().trim().length() > 0) {
                this.bJr.setText(this.bpv.getTitle());
                this.bJr.setSelection(this.bpv.getTitle().length());
            } else {
                String str = String.valueOf(this.bJG.getString(y.share_transfer_thread)) + this.bpv.getShareSummaryTitle();
                this.bJr.setText(str);
                if (str.length() < 20) {
                    this.bJr.setSelection(str.length());
                } else {
                    this.bJr.setSelection(20);
                }
            }
        }
        this.bJr.addTextChangedListener(new u(this));
    }

    public void aci() {
        String str = null;
        if (this.bpv.getType() == 3) {
            String trim = this.bJr.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.bJG.acc() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.bpv.setIsNoTitle(true);
                    } else {
                        this.bpv.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.bpv.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.bpv.setIsNoTitle(true);
            } else {
                this.bpv.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.bJH) {
            this.bJw.setEnabled(false);
        } else {
            this.bJw.setEnabled(true);
        }
    }

    protected void acj() {
        this.bJv = (EditText) this.bJG.findViewById(com.baidu.tieba.v.post_content);
        this.bJv.setDrawingCacheEnabled(false);
        if (this.bpv.getContent() != null && this.bpv.getContent().length() > 0) {
            SpannableString q = TbFaceManager.sf().q(this.bJG, this.bpv.getContent());
            this.bJv.setText(q);
            this.bJv.setSelection(q.length());
        }
        this.bJv.setOnTouchListener(new v(this));
        this.bJv.addTextChangedListener(new w(this));
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

    public EditText ack() {
        return this.bJr;
    }

    public EditText acl() {
        return this.bJv;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        acg();
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.bJr.setOnFocusChangeListener(onFocusChangeListener);
        this.bJv.setOnFocusChangeListener(onFocusChangeListener);
        this.Js.setOnFocusChangeListener(onFocusChangeListener);
        this.bJw.setOnFocusChangeListener(onFocusChangeListener);
    }

    public ch acm() {
        return this.bJy;
    }

    public View acn() {
        return this.Js;
    }

    public TextView aco() {
        return this.bJw;
    }

    public TextView acp() {
        return this.bJx;
    }

    public void y(View.OnClickListener onClickListener) {
        this.Js.setOnClickListener(onClickListener);
    }

    public void z(View.OnClickListener onClickListener) {
        this.bJw.setOnClickListener(onClickListener);
    }

    public void A(View.OnClickListener onClickListener) {
        this.bJu.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.bJG != null) {
            this.bJG.getLayoutMode().L(i == 1);
            this.bJG.getLayoutMode().h(this.mParent);
            this.mNavigationBar.onChangeSkinType(i);
            aw.f(this.bJw, i);
            aw.i(this.bJs, com.baidu.tieba.s.write_line1);
            aw.i(this.bJt, com.baidu.tieba.s.write_line1);
            aw.i((View) this.bJr, com.baidu.tieba.s.write_title_bg);
            aw.i(this.bJC, com.baidu.tieba.s.cp_bg_line_e);
            int color = aw.getColor(com.baidu.tieba.s.cp_cont_b);
            int color2 = aw.getColor(com.baidu.tieba.s.cp_cont_e);
            this.bJr.setTextColor(color);
            this.bJv.setTextColor(color);
            this.bJE.setTextColor(aw.getColor(com.baidu.tieba.s.cp_cont_b));
            this.bJF.setTextColor(aw.getColor(com.baidu.tieba.s.cp_cont_d));
            a(this.bJr, color2);
            a(this.bJv, color2);
            aci();
        }
    }
}
