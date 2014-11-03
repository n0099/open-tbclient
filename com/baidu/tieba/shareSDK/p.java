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
public class p {
    private View bJI;
    private TextView bJM;
    private ch bJN;
    private ImageView bJO;
    private View bJP;
    private LinearLayout bJQ;
    private LinearLayout bJR;
    private ShareSDKImageView bJS;
    private TextView bJT;
    private TextView bJU;
    private WriteShareActivity bJV;
    private WriteData bpJ;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View Jt = null;
    private EditText bJG = null;
    private View bJH = null;
    private LinearLayout bJJ = null;
    private EditText bJK = null;
    private TextView bJL = null;
    private RelativeLayout mParent = null;
    private boolean bJW = false;
    private int width = 0;
    private int height = 0;

    public p(WriteShareActivity writeShareActivity) {
        this.bpJ = null;
        this.bJV = writeShareActivity;
        this.bpJ = writeShareActivity.EE();
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.bJV.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.Jt = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bJV.getString(y.share_navigationbar_title));
        this.bJL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.bJV.getString(y.send_post));
        this.mParent = (RelativeLayout) this.bJV.findViewById(com.baidu.tieba.v.parent);
        this.bJH = this.bJV.findViewById(com.baidu.tieba.v.interval_view);
        this.bJI = this.bJV.findViewById(com.baidu.tieba.v.prefix_interval_view);
        this.bJQ = (LinearLayout) this.bJV.findViewById(com.baidu.tieba.v.post_share_layout);
        this.bJR = (LinearLayout) this.bJV.findViewById(com.baidu.tieba.v.post_share_content_layout);
        this.bJS = (ShareSDKImageView) this.bJV.findViewById(com.baidu.tieba.v.post_share_image);
        this.bJT = (TextView) this.bJV.findViewById(com.baidu.tieba.v.post_share_title);
        this.bJU = (TextView) this.bJV.findViewById(com.baidu.tieba.v.post_share_content);
        ack();
        acm();
        this.bJJ = (LinearLayout) this.bJV.findViewById(com.baidu.tieba.v.post_content_container);
        this.bJJ.setDrawingCacheEnabled(false);
        this.bJG.setVisibility(0);
        this.bJK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI)});
        aci();
        acl();
    }

    private void aci() {
        this.bJQ = (LinearLayout) this.bJV.findViewById(com.baidu.tieba.v.post_share_layout);
        this.bJS = (ShareSDKImageView) this.bJV.findViewById(com.baidu.tieba.v.post_share_image);
        this.bJS.setIsRound(false);
        this.bJS.setDrawBorder(false);
        this.bJS.setAutoChangeStyle(true);
        this.bJS.setRadius(0);
        this.bJT = (TextView) this.bJV.findViewById(com.baidu.tieba.v.post_share_title);
        this.bJU = (TextView) this.bJV.findViewById(com.baidu.tieba.v.post_share_content);
        if (this.bpJ != null) {
            this.bJS.setEvent(new q(this));
            if (this.bpJ.getShareSummaryImg() != null && this.bpJ.getShareSummaryImg().trim().length() > 0) {
                this.bJS.c(this.bpJ.getShareSummaryImg(), 10, true);
            } else {
                this.bJW = true;
                acl();
            }
            this.bpJ.setShareSummaryImgType(com.baidu.adp.lib.util.commonsio.b.aI(this.bpJ.getShareSummaryImg()));
            this.bJT.setText(this.bpJ.getShareSummaryTitle());
            this.bJU.setText(this.bpJ.getShareSummaryContent());
        }
    }

    private void acj() {
        this.bJP = this.bJV.findViewById(com.baidu.tieba.v.post_prefix_layout);
        this.bJM = (TextView) this.bJV.findViewById(com.baidu.tieba.v.post_prefix);
        this.bJO = (ImageView) this.bJV.findViewById(com.baidu.tieba.v.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.bJP.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.bJM.setText(prefixs.get(0));
            this.bJV.hi(0);
            this.bJP.setOnClickListener(new r(this));
            this.bJO = (ImageView) this.bJV.findViewById(com.baidu.tieba.v.prefix_icon);
            if (size > 1) {
                this.bJO.setVisibility(0);
                this.bJM.setOnClickListener(new s(this));
            }
            this.bJN = new ch(this.bJV);
            this.bJN.setMaxHeight(com.baidu.adp.lib.util.m.dip2px(this.bJV, 225.0f));
            this.bJN.setOutsideTouchable(true);
            this.bJN.setFocusable(true);
            this.bJN.setBackgroundDrawable(aw.getDrawable(com.baidu.tieba.s.cp_bg_line_b));
            this.bJN.a(new t(this));
            this.bJN.setOnDismissListener(new u(this));
            int color = aw.getColor(com.baidu.tieba.s.write_text);
            aw.h((View) this.bJM, com.baidu.tieba.u.write_prefix_item_selector);
            aw.c(this.bJO, com.baidu.tieba.u.icon_title_down);
            this.bJM.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.bJV);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.m.dip2px(this.bJV, 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                aw.h((View) textView, com.baidu.tieba.u.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.m.dip2px(this.bJV, this.bJV.getResources().getDimension(com.baidu.tieba.t.ds6)), 0, com.baidu.adp.lib.util.m.dip2px(this.bJV, this.bJV.getResources().getDimension(com.baidu.tieba.t.ds22)), 0);
                this.bJN.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.m.dip2px(this.bJV, 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.m.dip2px(this.bJV, this.bJV.getResources().getDimension(com.baidu.tieba.t.ds6)), 0, com.baidu.adp.lib.util.m.dip2px(this.bJV, this.bJV.getResources().getDimension(com.baidu.tieba.t.ds22)), 0);
                }
            }
            this.bJN.dP(0);
            return;
        }
        this.bJP.setVisibility(8);
    }

    protected void ack() {
        this.bJG = (EditText) this.bJV.findViewById(com.baidu.tieba.v.post_title);
        if (this.bpJ.getType() == 3) {
            if (this.bpJ.getTitle() != null && this.bpJ.getTitle().trim().length() > 0) {
                this.bJG.setText(this.bpJ.getTitle());
                this.bJG.setSelection(this.bpJ.getTitle().length());
            } else {
                String str = String.valueOf(this.bJV.getString(y.share_transfer_thread)) + this.bpJ.getShareSummaryTitle();
                this.bJG.setText(str);
                if (str.length() < 20) {
                    this.bJG.setSelection(str.length());
                } else {
                    this.bJG.setSelection(20);
                }
            }
        }
        this.bJG.addTextChangedListener(new v(this));
    }

    public void acl() {
        String str = null;
        if (this.bpJ.getType() == 3) {
            String trim = this.bJG.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.bJV.acf() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.bpJ.setIsNoTitle(true);
                    } else {
                        this.bpJ.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.bpJ.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.bpJ.setIsNoTitle(true);
            } else {
                this.bpJ.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.bJW) {
            this.bJL.setEnabled(false);
        } else {
            this.bJL.setEnabled(true);
        }
    }

    protected void acm() {
        this.bJK = (EditText) this.bJV.findViewById(com.baidu.tieba.v.post_content);
        this.bJK.setDrawingCacheEnabled(false);
        if (this.bpJ.getContent() != null && this.bpJ.getContent().length() > 0) {
            SpannableString q = TbFaceManager.sh().q(this.bJV, this.bpJ.getContent());
            this.bJK.setText(q);
            this.bJK.setSelection(q.length());
        }
        this.bJK.setOnTouchListener(new w(this));
        this.bJK.addTextChangedListener(new x(this));
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

    public EditText acn() {
        return this.bJG;
    }

    public EditText aco() {
        return this.bJK;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        acj();
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.bJG.setOnFocusChangeListener(onFocusChangeListener);
        this.bJK.setOnFocusChangeListener(onFocusChangeListener);
        this.Jt.setOnFocusChangeListener(onFocusChangeListener);
        this.bJL.setOnFocusChangeListener(onFocusChangeListener);
    }

    public ch acp() {
        return this.bJN;
    }

    public View acq() {
        return this.Jt;
    }

    public TextView acr() {
        return this.bJL;
    }

    public TextView acs() {
        return this.bJM;
    }

    public void y(View.OnClickListener onClickListener) {
        this.Jt.setOnClickListener(onClickListener);
    }

    public void z(View.OnClickListener onClickListener) {
        this.bJL.setOnClickListener(onClickListener);
    }

    public void A(View.OnClickListener onClickListener) {
        this.bJJ.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.bJV != null) {
            this.bJV.getLayoutMode().L(i == 1);
            this.bJV.getLayoutMode().h(this.mParent);
            this.mNavigationBar.onChangeSkinType(i);
            aw.f(this.bJL, i);
            aw.i(this.bJH, com.baidu.tieba.s.write_line1);
            aw.i(this.bJI, com.baidu.tieba.s.write_line1);
            aw.i((View) this.bJG, com.baidu.tieba.s.write_title_bg);
            aw.i(this.bJR, com.baidu.tieba.s.cp_bg_line_e);
            int color = aw.getColor(com.baidu.tieba.s.cp_cont_b);
            int color2 = aw.getColor(com.baidu.tieba.s.cp_cont_e);
            this.bJG.setTextColor(color);
            this.bJK.setTextColor(color);
            this.bJT.setTextColor(aw.getColor(com.baidu.tieba.s.cp_cont_b));
            this.bJU.setTextColor(aw.getColor(com.baidu.tieba.s.cp_cont_d));
            a(this.bJG, color2);
            a(this.bJK, color2);
            acl();
        }
    }
}
