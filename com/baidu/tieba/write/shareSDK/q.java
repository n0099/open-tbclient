package com.baidu.tieba.write.shareSDK;

import android.graphics.Bitmap;
import android.net.Uri;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.ShareSDKImageView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.write.cm;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class q {
    private com.baidu.tbadk.img.e cmD;
    private WriteData cqk;
    private View cwg;
    private TextView cwk;
    private cm cwl;
    private ImageView cwm;
    private View cwn;
    private LinearLayout cwo;
    private LinearLayout cwp;
    private ShareSDKImageView cwq;
    private TextView cwr;
    private TextView cws;
    private WriteShareActivity cwt;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText cwe = null;
    private View cwf = null;
    private LinearLayout cwh = null;
    private EditText cwi = null;
    private TextView cwj = null;
    private RelativeLayout aXd = null;
    private boolean cwu = false;
    private int width = 0;
    private int height = 0;

    public q(WriteShareActivity writeShareActivity) {
        this.cqk = null;
        this.cwt = writeShareActivity;
        this.cqk = writeShareActivity.IS();
        if (this.cmD == null) {
            this.cmD = new com.baidu.tbadk.img.e(TbadkCoreApplication.m411getInst().getApp());
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.cwt.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cwt.getPageContext().getString(com.baidu.tieba.y.share_navigationbar_title));
        this.cwj = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.cwt.getPageContext().getString(com.baidu.tieba.y.send_post));
        this.aXd = (RelativeLayout) this.cwt.findViewById(com.baidu.tieba.v.parent);
        this.cwf = this.cwt.findViewById(com.baidu.tieba.v.interval_view);
        this.cwg = this.cwt.findViewById(com.baidu.tieba.v.prefix_interval_view);
        this.cwo = (LinearLayout) this.cwt.findViewById(com.baidu.tieba.v.post_share_layout);
        this.cwp = (LinearLayout) this.cwt.findViewById(com.baidu.tieba.v.post_share_content_layout);
        this.cwq = (ShareSDKImageView) this.cwt.findViewById(com.baidu.tieba.v.post_share_image);
        this.cwr = (TextView) this.cwt.findViewById(com.baidu.tieba.v.post_share_title);
        this.cws = (TextView) this.cwt.findViewById(com.baidu.tieba.v.post_share_content);
        aqO();
        aqQ();
        this.cwh = (LinearLayout) this.cwt.findViewById(com.baidu.tieba.v.post_content_container);
        this.cwh.setDrawingCacheEnabled(false);
        this.cwe.setVisibility(0);
        this.cwi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI)});
        aqP();
    }

    public void aqM() {
        this.cwo = (LinearLayout) this.cwt.findViewById(com.baidu.tieba.v.post_share_layout);
        this.cwq = (ShareSDKImageView) this.cwt.findViewById(com.baidu.tieba.v.post_share_image);
        this.cwq.setIsRound(false);
        this.cwq.setDrawBorder(false);
        this.cwq.setAutoChangeStyle(true);
        this.cwq.setRadius(0);
        this.cwr = (TextView) this.cwt.findViewById(com.baidu.tieba.v.post_share_title);
        this.cws = (TextView) this.cwt.findViewById(com.baidu.tieba.v.post_share_content);
        if (this.cqk != null) {
            if (this.cqk.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.cwq.setEvent(new r(this));
            }
            if (this.cqk.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.cqk.getShareSummaryImg() != null && this.cqk.getShareSummaryImg().trim().length() > 0) {
                    this.cwq.c(this.cqk.getShareSummaryImg(), 10, true);
                } else {
                    this.cwu = true;
                    aqP();
                }
            } else {
                Bitmap w = com.baidu.tbadk.core.util.c.w(this.cqk.getShareLocalImageData());
                if (w != null) {
                    this.cwq.setImageBitmap(w);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.cqk.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(com.baidu.tbadk.core.util.o.c(TbadkCoreApplication.m411getInst().getApp(), Uri.parse(this.cqk.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.x(be.sY().te(), be.sY().te()));
                    this.cwq.setTag(imageFileInfo.toCachedKey(true));
                    if (this.cmD.a(imageFileInfo, new s(this), true) != null) {
                        this.cwq.invalidate();
                    }
                }
                this.cwu = true;
                aqP();
            }
            this.cqk.setShareSummaryImgType(com.baidu.adp.lib.util.commonsio.b.aS(this.cqk.getShareSummaryImg()));
            this.cwr.setText(this.cqk.getShareSummaryTitle());
            this.cws.setText(this.cqk.getShareSummaryContent());
        }
    }

    private void aqN() {
        this.cwn = this.cwt.findViewById(com.baidu.tieba.v.post_prefix_layout);
        this.cwk = (TextView) this.cwt.findViewById(com.baidu.tieba.v.post_prefix);
        this.cwm = (ImageView) this.cwt.findViewById(com.baidu.tieba.v.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.cwn.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.cwk.setText(prefixs.get(0));
            this.cwt.iY(0);
            this.cwn.setOnClickListener(new t(this));
            this.cwm = (ImageView) this.cwt.findViewById(com.baidu.tieba.v.prefix_icon);
            if (size > 1) {
                this.cwm.setVisibility(0);
                this.cwk.setOnClickListener(new u(this));
            }
            this.cwl = new cm(this.cwt.getPageContext().getContext());
            this.cwl.setMaxHeight(com.baidu.adp.lib.util.n.dip2px(this.cwt.getPageContext().getContext(), 225.0f));
            this.cwl.setOutsideTouchable(true);
            this.cwl.setFocusable(true);
            this.cwl.setBackgroundDrawable(ba.getDrawable(com.baidu.tieba.s.cp_bg_line_b));
            this.cwl.a(new v(this));
            this.cwl.setOnDismissListener(new w(this));
            int color = ba.getColor(com.baidu.tieba.s.write_text);
            ba.i((View) this.cwk, com.baidu.tieba.u.write_prefix_item_selector);
            ba.c(this.cwm, com.baidu.tieba.u.icon_title_down);
            this.cwk.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.cwt.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.n.dip2px(this.cwt.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ba.i((View) textView, com.baidu.tieba.u.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.n.dip2px(this.cwt.getPageContext().getContext(), this.cwt.getResources().getDimension(com.baidu.tieba.t.ds6)), 0, com.baidu.adp.lib.util.n.dip2px(this.cwt.getPageContext().getContext(), this.cwt.getResources().getDimension(com.baidu.tieba.t.ds22)), 0);
                this.cwl.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.n.dip2px(this.cwt.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.n.dip2px(this.cwt.getPageContext().getContext(), this.cwt.getResources().getDimension(com.baidu.tieba.t.ds6)), 0, com.baidu.adp.lib.util.n.dip2px(this.cwt.getPageContext().getContext(), this.cwt.getResources().getDimension(com.baidu.tieba.t.ds22)), 0);
                }
            }
            this.cwl.setCurrentIndex(0);
            return;
        }
        this.cwn.setVisibility(8);
    }

    protected void aqO() {
        this.cwe = (EditText) this.cwt.findViewById(com.baidu.tieba.v.post_title);
        if (this.cqk.getType() == 3) {
            if (this.cqk.getTitle() != null && this.cqk.getTitle().trim().length() > 0) {
                this.cwe.setText(this.cqk.getTitle());
                this.cwe.setSelection(this.cqk.getTitle().length());
            } else {
                String str = String.valueOf(this.cwt.getPageContext().getString(com.baidu.tieba.y.share_transfer_thread)) + this.cqk.getShareSummaryTitle();
                this.cwe.setText(str);
                if (str.length() < 20) {
                    this.cwe.setSelection(str.length());
                } else {
                    this.cwe.setSelection(20);
                }
            }
        }
        this.cwe.addTextChangedListener(new x(this));
    }

    public void aqP() {
        String str = null;
        if (this.cqk.getType() == 3) {
            String trim = this.cwe.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.cwt.aqJ() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.cqk.setIsNoTitle(true);
                    } else {
                        this.cqk.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.cqk.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.cqk.setIsNoTitle(true);
            } else {
                this.cqk.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.cwu) {
            this.cwj.setEnabled(false);
        } else {
            this.cwj.setEnabled(true);
        }
    }

    protected void aqQ() {
        this.cwi = (EditText) this.cwt.findViewById(com.baidu.tieba.v.post_content);
        this.cwi.setDrawingCacheEnabled(false);
        if (this.cqk.getContent() != null && this.cqk.getContent().length() > 0) {
            SpannableString E = TbFaceManager.zx().E(this.cwt.getPageContext().getContext(), this.cqk.getContent());
            this.cwi.setText(E);
            this.cwi.setSelection(E.length());
        }
        this.cwi.setOnTouchListener(new y(this));
        this.cwi.addTextChangedListener(new z(this));
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

    public EditText aqR() {
        return this.cwe;
    }

    public EditText aqS() {
        return this.cwi;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        aqN();
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.cwe.setOnFocusChangeListener(onFocusChangeListener);
        this.cwi.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.cwj.setOnFocusChangeListener(onFocusChangeListener);
    }

    public cm aqT() {
        return this.cwl;
    }

    public View aqU() {
        return this.mBack;
    }

    public TextView aqV() {
        return this.cwj;
    }

    public TextView aqW() {
        return this.cwk;
    }

    public void D(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void E(View.OnClickListener onClickListener) {
        this.cwj.setOnClickListener(onClickListener);
    }

    public void F(View.OnClickListener onClickListener) {
        this.cwh.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.cwt != null) {
            this.cwt.getLayoutMode().X(i == 1);
            this.cwt.getLayoutMode().h(this.aXd);
            this.mNavigationBar.onChangeSkinType(this.cwt.getPageContext(), i);
            ba.g(this.cwj, i);
            ba.j(this.cwf, com.baidu.tieba.s.cp_bg_line_c);
            ba.j(this.cwg, com.baidu.tieba.s.cp_bg_line_c);
            ba.j((View) this.cwe, com.baidu.tieba.s.cp_cont_g);
            ba.j(this.cwp, com.baidu.tieba.s.cp_bg_line_e);
            int color = ba.getColor(com.baidu.tieba.s.cp_cont_b);
            int color2 = ba.getColor(com.baidu.tieba.s.cp_cont_e);
            this.cwe.setTextColor(color);
            this.cwi.setTextColor(color);
            this.cwr.setTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_b));
            this.cws.setTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_d));
            a(this.cwe, color2);
            a(this.cwi, color2);
            aqP();
        }
    }

    public ShareSDKImageView aqX() {
        return this.cwq;
    }
}
