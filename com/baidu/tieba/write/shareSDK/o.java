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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import com.baidu.tieba.write.view.ShareSDKImageView;
import com.baidu.tieba.write.write.cf;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o {
    private WriteData ddI;
    private View doj;
    private TextView don;
    private cf doo;
    private ImageView dop;
    private View doq;
    private LinearLayout dor;
    private LinearLayout dos;
    private ShareSDKImageView dot;
    private TextView dou;
    private TextView dov;
    private WriteShareActivity dow;
    private com.baidu.tbadk.img.b dox;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText doh = null;
    private View doi = null;
    private LinearLayout dok = null;
    private EditText dol = null;
    private TextView dom = null;
    private RelativeLayout brS = null;
    private boolean doy = false;
    private int width = 0;
    private int height = 0;

    public o(WriteShareActivity writeShareActivity) {
        this.ddI = null;
        this.dow = writeShareActivity;
        this.ddI = writeShareActivity.ayT();
        if (this.dox == null) {
            this.dox = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.dow.findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dow.getPageContext().getString(i.h.share_navigationbar_title));
        this.dom = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dow.getPageContext().getString(i.h.send_post));
        this.brS = (RelativeLayout) this.dow.findViewById(i.f.parent);
        this.doi = this.dow.findViewById(i.f.interval_view);
        this.doj = this.dow.findViewById(i.f.prefix_interval_view);
        this.dor = (LinearLayout) this.dow.findViewById(i.f.post_share_layout);
        this.dos = (LinearLayout) this.dow.findViewById(i.f.post_share_content_layout);
        this.dot = (ShareSDKImageView) this.dow.findViewById(i.f.post_share_image);
        this.dou = (TextView) this.dow.findViewById(i.f.post_share_title);
        this.dov = (TextView) this.dow.findViewById(i.f.post_share_content);
        aCU();
        aCW();
        this.dok = (LinearLayout) this.dow.findViewById(i.f.post_content_container);
        this.dok.setDrawingCacheEnabled(false);
        this.doh.setVisibility(0);
        this.dol.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        aCV();
    }

    public void aCS() {
        this.dor = (LinearLayout) this.dow.findViewById(i.f.post_share_layout);
        this.dot = (ShareSDKImageView) this.dow.findViewById(i.f.post_share_image);
        this.dot.setIsRound(false);
        this.dot.setDrawBorder(false);
        this.dot.setAutoChangeStyle(true);
        this.dot.setRadius(0);
        this.dou = (TextView) this.dow.findViewById(i.f.post_share_title);
        this.dov = (TextView) this.dow.findViewById(i.f.post_share_content);
        if (this.ddI != null) {
            if (this.ddI.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.dot.setEvent(new p(this));
            }
            if (this.ddI.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.ddI.getShareSummaryImg() != null && this.ddI.getShareSummaryImg().trim().length() > 0) {
                    this.dot.d(this.ddI.getShareSummaryImg(), 10, true);
                } else {
                    this.doy = true;
                    aCV();
                }
            } else {
                Bitmap N = com.baidu.tbadk.core.util.c.N(this.ddI.getShareLocalImageData());
                if (N != null) {
                    this.dot.setImageBitmap(N);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.ddI.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(com.baidu.tbadk.core.util.n.a(TbadkCoreApplication.m411getInst().getApp(), Uri.parse(this.ddI.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.J(at.uK().uQ(), at.uK().uQ()));
                    this.dot.setTag(imageFileInfo.toCachedKey(true));
                    if (this.dox.a(imageFileInfo, new q(this), true) != null) {
                        this.dot.invalidate();
                    }
                }
                this.doy = true;
                aCV();
            }
            this.ddI.setShareSummaryImgType(com.baidu.adp.lib.util.e.aH(this.ddI.getShareSummaryImg()));
            this.dou.setText(this.ddI.getShareSummaryTitle());
            this.dov.setText(this.ddI.getShareSummaryContent());
        }
    }

    private void aCT() {
        this.doq = this.dow.findViewById(i.f.post_prefix_layout);
        this.don = (TextView) this.dow.findViewById(i.f.post_prefix);
        this.dop = (ImageView) this.dow.findViewById(i.f.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.doq.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.don.setText(prefixs.get(0));
            this.dow.mf(0);
            this.doq.setOnClickListener(new r(this));
            this.dop = (ImageView) this.dow.findViewById(i.f.prefix_icon);
            if (size > 1) {
                this.dop.setVisibility(0);
                this.don.setOnClickListener(new s(this));
            }
            this.doo = new cf(this.dow.getPageContext().getContext());
            this.doo.setMaxHeight(com.baidu.adp.lib.util.k.dip2px(this.dow.getPageContext().getContext(), 225.0f));
            this.doo.setOutsideTouchable(true);
            this.doo.setFocusable(true);
            this.doo.setBackgroundDrawable(an.getDrawable(i.c.cp_bg_line_b));
            this.doo.a(new t(this));
            this.doo.setOnDismissListener(new u(this));
            int color = an.getColor(i.c.write_text);
            an.i((View) this.don, i.e.write_prefix_item_selector);
            an.c(this.dop, i.e.icon_title_down);
            this.don.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.dow.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.dip2px(this.dow.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                an.i((View) textView, i.e.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.k.dip2px(this.dow.getPageContext().getContext(), this.dow.getResources().getDimension(i.d.ds6)), 0, com.baidu.adp.lib.util.k.dip2px(this.dow.getPageContext().getContext(), this.dow.getResources().getDimension(i.d.ds22)), 0);
                this.doo.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(this.dow.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.k.dip2px(this.dow.getPageContext().getContext(), this.dow.getResources().getDimension(i.d.ds6)), 0, com.baidu.adp.lib.util.k.dip2px(this.dow.getPageContext().getContext(), this.dow.getResources().getDimension(i.d.ds22)), 0);
                }
            }
            this.doo.lZ(0);
            return;
        }
        this.doq.setVisibility(8);
    }

    protected void aCU() {
        this.doh = (EditText) this.dow.findViewById(i.f.post_title);
        if (this.ddI.getType() == 3) {
            if (this.ddI.getTitle() != null && this.ddI.getTitle().trim().length() > 0) {
                this.doh.setText(this.ddI.getTitle());
                this.doh.setSelection(this.ddI.getTitle().length());
            } else {
                String str = String.valueOf(this.dow.getPageContext().getString(i.h.share_transfer_thread)) + this.ddI.getShareSummaryTitle();
                this.doh.setText(str);
                if (str.length() < 20) {
                    this.doh.setSelection(str.length());
                } else {
                    this.doh.setSelection(20);
                }
            }
        }
        this.doh.addTextChangedListener(new v(this));
    }

    public void aCV() {
        String str = null;
        if (this.ddI.getType() == 3) {
            String trim = this.doh.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.dow.aCP() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.ddI.setIsNoTitle(true);
                    } else {
                        this.ddI.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.ddI.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.ddI.setIsNoTitle(true);
            } else {
                this.ddI.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.doy) {
            this.dom.setEnabled(false);
        } else {
            this.dom.setEnabled(true);
        }
    }

    protected void aCW() {
        this.dol = (EditText) this.dow.findViewById(i.f.post_content);
        this.dol.setDrawingCacheEnabled(false);
        if (this.ddI.getContent() != null && this.ddI.getContent().length() > 0) {
            SpannableString G = TbFaceManager.BU().G(this.dow.getPageContext().getContext(), this.ddI.getContent());
            this.dol.setText(G);
            this.dol.setSelection(G.length());
        }
        this.dol.setOnTouchListener(new w(this));
        this.dol.addTextChangedListener(new x(this));
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

    public EditText aCX() {
        return this.doh;
    }

    public EditText anu() {
        return this.dol;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        aCT();
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.doh.setOnFocusChangeListener(onFocusChangeListener);
        this.dol.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.dom.setOnFocusChangeListener(onFocusChangeListener);
    }

    public cf aCY() {
        return this.doo;
    }

    public View aCZ() {
        return this.mBack;
    }

    public TextView aDa() {
        return this.dom;
    }

    public TextView aDb() {
        return this.don;
    }

    public void K(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void L(View.OnClickListener onClickListener) {
        this.dom.setOnClickListener(onClickListener);
    }

    public void M(View.OnClickListener onClickListener) {
        this.dok.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.dow != null) {
            this.dow.getLayoutMode().ad(i == 1);
            this.dow.getLayoutMode().k(this.brS);
            this.mNavigationBar.onChangeSkinType(this.dow.getPageContext(), i);
            an.g(this.dom, i);
            an.j(this.doi, i.c.cp_bg_line_c);
            an.j(this.doj, i.c.cp_bg_line_c);
            an.j((View) this.doh, i.c.cp_cont_g);
            an.j(this.dos, i.c.cp_bg_line_e);
            int color = an.getColor(i.c.cp_cont_b);
            int color2 = an.getColor(i.c.cp_cont_e);
            this.doh.setTextColor(color);
            this.dol.setTextColor(color);
            this.dou.setTextColor(an.getColor(i.c.cp_cont_b));
            this.dov.setTextColor(an.getColor(i.c.cp_cont_d));
            a(this.doh, color2);
            a(this.dol, color2);
            aCV();
        }
    }

    public ShareSDKImageView aDc() {
        return this.dot;
    }
}
