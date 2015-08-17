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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.ShareSDKImageView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import com.baidu.tieba.write.write.bx;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o {
    private WriteData cKS;
    private com.baidu.tbadk.img.b cSA;
    private View cSm;
    private TextView cSq;
    private bx cSr;
    private ImageView cSs;
    private View cSt;
    private LinearLayout cSu;
    private LinearLayout cSv;
    private ShareSDKImageView cSw;
    private TextView cSx;
    private TextView cSy;
    private WriteShareActivity cSz;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText cSk = null;
    private View cSl = null;
    private LinearLayout cSn = null;
    private EditText cSo = null;
    private TextView cSp = null;
    private RelativeLayout bnG = null;
    private boolean cSB = false;
    private int width = 0;
    private int height = 0;

    public o(WriteShareActivity writeShareActivity) {
        this.cKS = null;
        this.cSz = writeShareActivity;
        this.cKS = writeShareActivity.ard();
        if (this.cSA == null) {
            this.cSA = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.cSz.findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cSz.getPageContext().getString(i.C0057i.share_navigationbar_title));
        this.cSp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.cSz.getPageContext().getString(i.C0057i.send_post));
        this.bnG = (RelativeLayout) this.cSz.findViewById(i.f.parent);
        this.cSl = this.cSz.findViewById(i.f.interval_view);
        this.cSm = this.cSz.findViewById(i.f.prefix_interval_view);
        this.cSu = (LinearLayout) this.cSz.findViewById(i.f.post_share_layout);
        this.cSv = (LinearLayout) this.cSz.findViewById(i.f.post_share_content_layout);
        this.cSw = (ShareSDKImageView) this.cSz.findViewById(i.f.post_share_image);
        this.cSx = (TextView) this.cSz.findViewById(i.f.post_share_title);
        this.cSy = (TextView) this.cSz.findViewById(i.f.post_share_content);
        auv();
        aux();
        this.cSn = (LinearLayout) this.cSz.findViewById(i.f.post_content_container);
        this.cSn.setDrawingCacheEnabled(false);
        this.cSk.setVisibility(0);
        this.cSo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI)});
        auw();
    }

    public void aut() {
        this.cSu = (LinearLayout) this.cSz.findViewById(i.f.post_share_layout);
        this.cSw = (ShareSDKImageView) this.cSz.findViewById(i.f.post_share_image);
        this.cSw.setIsRound(false);
        this.cSw.setDrawBorder(false);
        this.cSw.setAutoChangeStyle(true);
        this.cSw.setRadius(0);
        this.cSx = (TextView) this.cSz.findViewById(i.f.post_share_title);
        this.cSy = (TextView) this.cSz.findViewById(i.f.post_share_content);
        if (this.cKS != null) {
            if (this.cKS.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.cSw.setEvent(new p(this));
            }
            if (this.cKS.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.cKS.getShareSummaryImg() != null && this.cKS.getShareSummaryImg().trim().length() > 0) {
                    this.cSw.d(this.cKS.getShareSummaryImg(), 10, true);
                } else {
                    this.cSB = true;
                    auw();
                }
            } else {
                Bitmap N = com.baidu.tbadk.core.util.c.N(this.cKS.getShareLocalImageData());
                if (N != null) {
                    this.cSw.setImageBitmap(N);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.cKS.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(com.baidu.tbadk.core.util.n.a(TbadkCoreApplication.m411getInst().getApp(), Uri.parse(this.cKS.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.J(ar.uE().uK(), ar.uE().uK()));
                    this.cSw.setTag(imageFileInfo.toCachedKey(true));
                    if (this.cSA.a(imageFileInfo, new q(this), true) != null) {
                        this.cSw.invalidate();
                    }
                }
                this.cSB = true;
                auw();
            }
            this.cKS.setShareSummaryImgType(com.baidu.adp.lib.util.e.aJ(this.cKS.getShareSummaryImg()));
            this.cSx.setText(this.cKS.getShareSummaryTitle());
            this.cSy.setText(this.cKS.getShareSummaryContent());
        }
    }

    private void auu() {
        this.cSt = this.cSz.findViewById(i.f.post_prefix_layout);
        this.cSq = (TextView) this.cSz.findViewById(i.f.post_prefix);
        this.cSs = (ImageView) this.cSz.findViewById(i.f.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.cSt.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.cSq.setText(prefixs.get(0));
            this.cSz.kp(0);
            this.cSt.setOnClickListener(new r(this));
            this.cSs = (ImageView) this.cSz.findViewById(i.f.prefix_icon);
            if (size > 1) {
                this.cSs.setVisibility(0);
                this.cSq.setOnClickListener(new s(this));
            }
            this.cSr = new bx(this.cSz.getPageContext().getContext());
            this.cSr.setMaxHeight(com.baidu.adp.lib.util.k.dip2px(this.cSz.getPageContext().getContext(), 225.0f));
            this.cSr.setOutsideTouchable(true);
            this.cSr.setFocusable(true);
            this.cSr.setBackgroundDrawable(al.getDrawable(i.c.cp_bg_line_b));
            this.cSr.a(new t(this));
            this.cSr.setOnDismissListener(new u(this));
            int color = al.getColor(i.c.write_text);
            al.i((View) this.cSq, i.e.write_prefix_item_selector);
            al.c(this.cSs, i.e.icon_title_down);
            this.cSq.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.cSz.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.dip2px(this.cSz.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                al.i((View) textView, i.e.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.k.dip2px(this.cSz.getPageContext().getContext(), this.cSz.getResources().getDimension(i.d.ds6)), 0, com.baidu.adp.lib.util.k.dip2px(this.cSz.getPageContext().getContext(), this.cSz.getResources().getDimension(i.d.ds22)), 0);
                this.cSr.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(this.cSz.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.k.dip2px(this.cSz.getPageContext().getContext(), this.cSz.getResources().getDimension(i.d.ds6)), 0, com.baidu.adp.lib.util.k.dip2px(this.cSz.getPageContext().getContext(), this.cSz.getResources().getDimension(i.d.ds22)), 0);
                }
            }
            this.cSr.kj(0);
            return;
        }
        this.cSt.setVisibility(8);
    }

    protected void auv() {
        this.cSk = (EditText) this.cSz.findViewById(i.f.post_title);
        if (this.cKS.getType() == 3) {
            if (this.cKS.getTitle() != null && this.cKS.getTitle().trim().length() > 0) {
                this.cSk.setText(this.cKS.getTitle());
                this.cSk.setSelection(this.cKS.getTitle().length());
            } else {
                String str = String.valueOf(this.cSz.getPageContext().getString(i.C0057i.share_transfer_thread)) + this.cKS.getShareSummaryTitle();
                this.cSk.setText(str);
                if (str.length() < 20) {
                    this.cSk.setSelection(str.length());
                } else {
                    this.cSk.setSelection(20);
                }
            }
        }
        this.cSk.addTextChangedListener(new v(this));
    }

    public void auw() {
        String str = null;
        if (this.cKS.getType() == 3) {
            String trim = this.cSk.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.cSz.auq() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.cKS.setIsNoTitle(true);
                    } else {
                        this.cKS.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.cKS.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.cKS.setIsNoTitle(true);
            } else {
                this.cKS.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.cSB) {
            this.cSp.setEnabled(false);
        } else {
            this.cSp.setEnabled(true);
        }
    }

    protected void aux() {
        this.cSo = (EditText) this.cSz.findViewById(i.f.post_content);
        this.cSo.setDrawingCacheEnabled(false);
        if (this.cKS.getContent() != null && this.cKS.getContent().length() > 0) {
            SpannableString H = TbFaceManager.Cd().H(this.cSz.getPageContext().getContext(), this.cKS.getContent());
            this.cSo.setText(H);
            this.cSo.setSelection(H.length());
        }
        this.cSo.setOnTouchListener(new w(this));
        this.cSo.addTextChangedListener(new x(this));
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

    public EditText auy() {
        return this.cSk;
    }

    public EditText auz() {
        return this.cSo;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        auu();
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.cSk.setOnFocusChangeListener(onFocusChangeListener);
        this.cSo.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.cSp.setOnFocusChangeListener(onFocusChangeListener);
    }

    public bx auA() {
        return this.cSr;
    }

    public View auB() {
        return this.mBack;
    }

    public TextView auC() {
        return this.cSp;
    }

    public TextView auD() {
        return this.cSq;
    }

    public void I(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void J(View.OnClickListener onClickListener) {
        this.cSp.setOnClickListener(onClickListener);
    }

    public void K(View.OnClickListener onClickListener) {
        this.cSn.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.cSz != null) {
            this.cSz.getLayoutMode().ad(i == 1);
            this.cSz.getLayoutMode().k(this.bnG);
            this.mNavigationBar.onChangeSkinType(this.cSz.getPageContext(), i);
            al.g(this.cSp, i);
            al.j(this.cSl, i.c.cp_bg_line_c);
            al.j(this.cSm, i.c.cp_bg_line_c);
            al.j((View) this.cSk, i.c.cp_cont_g);
            al.j(this.cSv, i.c.cp_bg_line_e);
            int color = al.getColor(i.c.cp_cont_b);
            int color2 = al.getColor(i.c.cp_cont_e);
            this.cSk.setTextColor(color);
            this.cSo.setTextColor(color);
            this.cSx.setTextColor(al.getColor(i.c.cp_cont_b));
            this.cSy.setTextColor(al.getColor(i.c.cp_cont_d));
            a(this.cSk, color2);
            a(this.cSo, color2);
            auw();
        }
    }

    public ShareSDKImageView auE() {
        return this.cSw;
    }
}
