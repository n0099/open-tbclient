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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import com.baidu.tieba.write.view.ShareSDKImageView;
import com.baidu.tieba.write.write.cd;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o {
    private WriteData daX;
    private View dmb;
    private TextView dmf;
    private cd dmg;
    private ImageView dmh;
    private View dmi;
    private LinearLayout dmj;
    private LinearLayout dmk;
    private ShareSDKImageView dml;
    private TextView dmm;
    private TextView dmn;
    private WriteShareActivity dmo;
    private com.baidu.tbadk.img.b dmp;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText dlZ = null;
    private View dma = null;
    private LinearLayout dmc = null;
    private EditText dmd = null;
    private TextView dme = null;
    private RelativeLayout brd = null;
    private boolean dmq = false;
    private int width = 0;
    private int height = 0;

    public o(WriteShareActivity writeShareActivity) {
        this.daX = null;
        this.dmo = writeShareActivity;
        this.daX = writeShareActivity.axE();
        if (this.dmp == null) {
            this.dmp = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.dmo.findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dmo.getPageContext().getString(i.h.share_navigationbar_title));
        this.dme = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dmo.getPageContext().getString(i.h.send_post));
        this.brd = (RelativeLayout) this.dmo.findViewById(i.f.parent);
        this.dma = this.dmo.findViewById(i.f.interval_view);
        this.dmb = this.dmo.findViewById(i.f.prefix_interval_view);
        this.dmj = (LinearLayout) this.dmo.findViewById(i.f.post_share_layout);
        this.dmk = (LinearLayout) this.dmo.findViewById(i.f.post_share_content_layout);
        this.dml = (ShareSDKImageView) this.dmo.findViewById(i.f.post_share_image);
        this.dmm = (TextView) this.dmo.findViewById(i.f.post_share_title);
        this.dmn = (TextView) this.dmo.findViewById(i.f.post_share_content);
        aBY();
        aCa();
        this.dmc = (LinearLayout) this.dmo.findViewById(i.f.post_content_container);
        this.dmc.setDrawingCacheEnabled(false);
        this.dlZ.setVisibility(0);
        this.dmd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        aBZ();
    }

    public void aBW() {
        this.dmj = (LinearLayout) this.dmo.findViewById(i.f.post_share_layout);
        this.dml = (ShareSDKImageView) this.dmo.findViewById(i.f.post_share_image);
        this.dml.setIsRound(false);
        this.dml.setDrawBorder(false);
        this.dml.setAutoChangeStyle(true);
        this.dml.setRadius(0);
        this.dmm = (TextView) this.dmo.findViewById(i.f.post_share_title);
        this.dmn = (TextView) this.dmo.findViewById(i.f.post_share_content);
        if (this.daX != null) {
            if (this.daX.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.dml.setEvent(new p(this));
            }
            if (this.daX.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.daX.getShareSummaryImg() != null && this.daX.getShareSummaryImg().trim().length() > 0) {
                    this.dml.d(this.daX.getShareSummaryImg(), 10, true);
                } else {
                    this.dmq = true;
                    aBZ();
                }
            } else {
                Bitmap N = com.baidu.tbadk.core.util.c.N(this.daX.getShareLocalImageData());
                if (N != null) {
                    this.dml.setImageBitmap(N);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.daX.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(com.baidu.tbadk.core.util.n.a(TbadkCoreApplication.m411getInst().getApp(), Uri.parse(this.daX.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.J(as.uI().uO(), as.uI().uO()));
                    this.dml.setTag(imageFileInfo.toCachedKey(true));
                    if (this.dmp.a(imageFileInfo, new q(this), true) != null) {
                        this.dml.invalidate();
                    }
                }
                this.dmq = true;
                aBZ();
            }
            this.daX.setShareSummaryImgType(com.baidu.adp.lib.util.e.aJ(this.daX.getShareSummaryImg()));
            this.dmm.setText(this.daX.getShareSummaryTitle());
            this.dmn.setText(this.daX.getShareSummaryContent());
        }
    }

    private void aBX() {
        this.dmi = this.dmo.findViewById(i.f.post_prefix_layout);
        this.dmf = (TextView) this.dmo.findViewById(i.f.post_prefix);
        this.dmh = (ImageView) this.dmo.findViewById(i.f.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.dmi.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.dmf.setText(prefixs.get(0));
            this.dmo.lP(0);
            this.dmi.setOnClickListener(new r(this));
            this.dmh = (ImageView) this.dmo.findViewById(i.f.prefix_icon);
            if (size > 1) {
                this.dmh.setVisibility(0);
                this.dmf.setOnClickListener(new s(this));
            }
            this.dmg = new cd(this.dmo.getPageContext().getContext());
            this.dmg.setMaxHeight(com.baidu.adp.lib.util.k.dip2px(this.dmo.getPageContext().getContext(), 225.0f));
            this.dmg.setOutsideTouchable(true);
            this.dmg.setFocusable(true);
            this.dmg.setBackgroundDrawable(am.getDrawable(i.c.cp_bg_line_b));
            this.dmg.a(new t(this));
            this.dmg.setOnDismissListener(new u(this));
            int color = am.getColor(i.c.write_text);
            am.i((View) this.dmf, i.e.write_prefix_item_selector);
            am.c(this.dmh, i.e.icon_title_down);
            this.dmf.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.dmo.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.dip2px(this.dmo.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                am.i((View) textView, i.e.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.k.dip2px(this.dmo.getPageContext().getContext(), this.dmo.getResources().getDimension(i.d.ds6)), 0, com.baidu.adp.lib.util.k.dip2px(this.dmo.getPageContext().getContext(), this.dmo.getResources().getDimension(i.d.ds22)), 0);
                this.dmg.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(this.dmo.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.k.dip2px(this.dmo.getPageContext().getContext(), this.dmo.getResources().getDimension(i.d.ds6)), 0, com.baidu.adp.lib.util.k.dip2px(this.dmo.getPageContext().getContext(), this.dmo.getResources().getDimension(i.d.ds22)), 0);
                }
            }
            this.dmg.lJ(0);
            return;
        }
        this.dmi.setVisibility(8);
    }

    protected void aBY() {
        this.dlZ = (EditText) this.dmo.findViewById(i.f.post_title);
        if (this.daX.getType() == 3) {
            if (this.daX.getTitle() != null && this.daX.getTitle().trim().length() > 0) {
                this.dlZ.setText(this.daX.getTitle());
                this.dlZ.setSelection(this.daX.getTitle().length());
            } else {
                String str = String.valueOf(this.dmo.getPageContext().getString(i.h.share_transfer_thread)) + this.daX.getShareSummaryTitle();
                this.dlZ.setText(str);
                if (str.length() < 20) {
                    this.dlZ.setSelection(str.length());
                } else {
                    this.dlZ.setSelection(20);
                }
            }
        }
        this.dlZ.addTextChangedListener(new v(this));
    }

    public void aBZ() {
        String str = null;
        if (this.daX.getType() == 3) {
            String trim = this.dlZ.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.dmo.aBT() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.daX.setIsNoTitle(true);
                    } else {
                        this.daX.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.daX.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.daX.setIsNoTitle(true);
            } else {
                this.daX.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.dmq) {
            this.dme.setEnabled(false);
        } else {
            this.dme.setEnabled(true);
        }
    }

    protected void aCa() {
        this.dmd = (EditText) this.dmo.findViewById(i.f.post_content);
        this.dmd.setDrawingCacheEnabled(false);
        if (this.daX.getContent() != null && this.daX.getContent().length() > 0) {
            SpannableString G = TbFaceManager.Ce().G(this.dmo.getPageContext().getContext(), this.daX.getContent());
            this.dmd.setText(G);
            this.dmd.setSelection(G.length());
        }
        this.dmd.setOnTouchListener(new w(this));
        this.dmd.addTextChangedListener(new x(this));
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

    public EditText aCb() {
        return this.dlZ;
    }

    public EditText amS() {
        return this.dmd;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        aBX();
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.dlZ.setOnFocusChangeListener(onFocusChangeListener);
        this.dmd.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.dme.setOnFocusChangeListener(onFocusChangeListener);
    }

    public cd aCc() {
        return this.dmg;
    }

    public View aCd() {
        return this.mBack;
    }

    public TextView aCe() {
        return this.dme;
    }

    public TextView aCf() {
        return this.dmf;
    }

    public void K(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void L(View.OnClickListener onClickListener) {
        this.dme.setOnClickListener(onClickListener);
    }

    public void M(View.OnClickListener onClickListener) {
        this.dmc.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.dmo != null) {
            this.dmo.getLayoutMode().ad(i == 1);
            this.dmo.getLayoutMode().k(this.brd);
            this.mNavigationBar.onChangeSkinType(this.dmo.getPageContext(), i);
            am.g(this.dme, i);
            am.j(this.dma, i.c.cp_bg_line_c);
            am.j(this.dmb, i.c.cp_bg_line_c);
            am.j((View) this.dlZ, i.c.cp_cont_g);
            am.j(this.dmk, i.c.cp_bg_line_e);
            int color = am.getColor(i.c.cp_cont_b);
            int color2 = am.getColor(i.c.cp_cont_e);
            this.dlZ.setTextColor(color);
            this.dmd.setTextColor(color);
            this.dmm.setTextColor(am.getColor(i.c.cp_cont_b));
            this.dmn.setTextColor(am.getColor(i.c.cp_cont_d));
            a(this.dlZ, color2);
            a(this.dmd, color2);
            aBZ();
        }
    }

    public ShareSDKImageView aCg() {
        return this.dml;
    }
}
