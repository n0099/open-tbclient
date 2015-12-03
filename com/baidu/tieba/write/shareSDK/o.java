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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.n;
import com.baidu.tieba.write.view.ShareSDKImageView;
import com.baidu.tieba.write.write.cf;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o {
    private WriteData dBW;
    private TextView dNA;
    private TextView dNB;
    private WriteShareActivity dNC;
    private com.baidu.tbadk.img.b dND;
    private View dNp;
    private TextView dNt;
    private cf dNu;
    private ImageView dNv;
    private View dNw;
    private LinearLayout dNx;
    private LinearLayout dNy;
    private ShareSDKImageView dNz;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText dNn = null;
    private View dNo = null;
    private LinearLayout dNq = null;
    private EditText dNr = null;
    private TextView dNs = null;
    private RelativeLayout bGY = null;
    private boolean dNE = false;
    private int width = 0;
    private int height = 0;

    public o(WriteShareActivity writeShareActivity) {
        this.dBW = null;
        this.dNC = writeShareActivity;
        this.dBW = writeShareActivity.aEl();
        if (this.dND == null) {
            this.dND = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.dNC.findViewById(n.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dNC.getPageContext().getString(n.i.share_navigationbar_title));
        this.dNs = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dNC.getPageContext().getString(n.i.send_post));
        this.bGY = (RelativeLayout) this.dNC.findViewById(n.f.parent);
        this.dNo = this.dNC.findViewById(n.f.interval_view);
        this.dNp = this.dNC.findViewById(n.f.prefix_interval_view);
        this.dNx = (LinearLayout) this.dNC.findViewById(n.f.post_share_layout);
        this.dNy = (LinearLayout) this.dNC.findViewById(n.f.post_share_content_layout);
        this.dNz = (ShareSDKImageView) this.dNC.findViewById(n.f.post_share_image);
        this.dNA = (TextView) this.dNC.findViewById(n.f.post_share_title);
        this.dNB = (TextView) this.dNC.findViewById(n.f.post_share_content);
        aIr();
        aIt();
        this.dNq = (LinearLayout) this.dNC.findViewById(n.f.post_content_container);
        this.dNq.setDrawingCacheEnabled(false);
        this.dNn.setVisibility(0);
        this.dNr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        aIs();
    }

    public void aIp() {
        this.dNx = (LinearLayout) this.dNC.findViewById(n.f.post_share_layout);
        this.dNz = (ShareSDKImageView) this.dNC.findViewById(n.f.post_share_image);
        this.dNz.setIsRound(false);
        this.dNz.setDrawBorder(false);
        this.dNz.setAutoChangeStyle(true);
        this.dNz.setRadius(0);
        this.dNA = (TextView) this.dNC.findViewById(n.f.post_share_title);
        this.dNB = (TextView) this.dNC.findViewById(n.f.post_share_content);
        if (this.dBW != null) {
            if (this.dBW.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.dNz.setEvent(new p(this));
            }
            if (this.dBW.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.dBW.getShareSummaryImg() != null && this.dBW.getShareSummaryImg().trim().length() > 0) {
                    this.dNz.d(this.dBW.getShareSummaryImg(), 10, true);
                } else {
                    this.dNE = true;
                    aIs();
                }
            } else {
                Bitmap N = com.baidu.tbadk.core.util.c.N(this.dBW.getShareLocalImageData());
                if (N != null) {
                    this.dNz.setImageBitmap(N);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.dBW.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(com.baidu.tbadk.core.util.n.a(TbadkCoreApplication.m411getInst().getApp(), Uri.parse(this.dBW.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.K(ay.vq().vw(), ay.vq().vw()));
                    this.dNz.setTag(imageFileInfo.toCachedKey(true));
                    if (this.dND.a(imageFileInfo, new q(this), true) != null) {
                        this.dNz.invalidate();
                    }
                }
                this.dNE = true;
                aIs();
            }
            this.dBW.setShareSummaryImgType(com.baidu.adp.lib.util.e.aL(this.dBW.getShareSummaryImg()));
            this.dNA.setText(this.dBW.getShareSummaryTitle());
            this.dNB.setText(this.dBW.getShareSummaryContent());
        }
    }

    private void aIq() {
        this.dNw = this.dNC.findViewById(n.f.post_prefix_layout);
        this.dNt = (TextView) this.dNC.findViewById(n.f.post_prefix);
        this.dNv = (ImageView) this.dNC.findViewById(n.f.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.dNw.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.dNt.setText(prefixs.get(0));
            this.dNC.nr(0);
            this.dNw.setOnClickListener(new r(this));
            this.dNv = (ImageView) this.dNC.findViewById(n.f.prefix_icon);
            if (size > 1) {
                this.dNv.setVisibility(0);
                this.dNt.setOnClickListener(new s(this));
            }
            this.dNu = new cf(this.dNC.getPageContext().getContext());
            this.dNu.setMaxHeight(com.baidu.adp.lib.util.k.dip2px(this.dNC.getPageContext().getContext(), 225.0f));
            this.dNu.setOutsideTouchable(true);
            this.dNu.setFocusable(true);
            this.dNu.setBackgroundDrawable(as.getDrawable(n.c.cp_bg_line_b));
            this.dNu.a(new t(this));
            this.dNu.setOnDismissListener(new u(this));
            int color = as.getColor(n.c.write_text);
            as.i((View) this.dNt, n.e.write_prefix_item_selector);
            as.c(this.dNv, n.e.icon_title_down);
            this.dNt.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.dNC.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.dip2px(this.dNC.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                as.i((View) textView, n.e.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.k.dip2px(this.dNC.getPageContext().getContext(), this.dNC.getResources().getDimension(n.d.ds6)), 0, com.baidu.adp.lib.util.k.dip2px(this.dNC.getPageContext().getContext(), this.dNC.getResources().getDimension(n.d.ds22)), 0);
                this.dNu.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(this.dNC.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.k.dip2px(this.dNC.getPageContext().getContext(), this.dNC.getResources().getDimension(n.d.ds6)), 0, com.baidu.adp.lib.util.k.dip2px(this.dNC.getPageContext().getContext(), this.dNC.getResources().getDimension(n.d.ds22)), 0);
                }
            }
            this.dNu.nl(0);
            return;
        }
        this.dNw.setVisibility(8);
    }

    protected void aIr() {
        this.dNn = (EditText) this.dNC.findViewById(n.f.post_title);
        if (this.dBW.getType() == 3) {
            if (this.dBW.getTitle() != null && this.dBW.getTitle().trim().length() > 0) {
                this.dNn.setText(this.dBW.getTitle());
                this.dNn.setSelection(this.dBW.getTitle().length());
            } else {
                String str = String.valueOf(this.dNC.getPageContext().getString(n.i.share_transfer_thread)) + this.dBW.getShareSummaryTitle();
                this.dNn.setText(str);
                if (str.length() < 20) {
                    this.dNn.setSelection(str.length());
                } else {
                    this.dNn.setSelection(20);
                }
            }
        }
        this.dNn.addTextChangedListener(new v(this));
    }

    public void aIs() {
        String str = null;
        if (this.dBW.getType() == 3) {
            String trim = this.dNn.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.dNC.aIm() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.dBW.setIsNoTitle(true);
                    } else {
                        this.dBW.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.dBW.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.dBW.setIsNoTitle(true);
            } else {
                this.dBW.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.dNE) {
            this.dNs.setEnabled(false);
        } else {
            this.dNs.setEnabled(true);
        }
    }

    protected void aIt() {
        this.dNr = (EditText) this.dNC.findViewById(n.f.post_content);
        this.dNr.setDrawingCacheEnabled(false);
        if (this.dBW.getContent() != null && this.dBW.getContent().length() > 0) {
            SpannableString G = TbFaceManager.CW().G(this.dNC.getPageContext().getContext(), this.dBW.getContent());
            this.dNr.setText(G);
            this.dNr.setSelection(G.length());
        }
        this.dNr.setOnTouchListener(new w(this));
        this.dNr.addTextChangedListener(new x(this));
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

    public EditText aIu() {
        return this.dNn;
    }

    public EditText asU() {
        return this.dNr;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        aIq();
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.dNn.setOnFocusChangeListener(onFocusChangeListener);
        this.dNr.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.dNs.setOnFocusChangeListener(onFocusChangeListener);
    }

    public cf aIv() {
        return this.dNu;
    }

    public View aIw() {
        return this.mBack;
    }

    public TextView aIx() {
        return this.dNs;
    }

    public TextView aIy() {
        return this.dNt;
    }

    public void O(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void P(View.OnClickListener onClickListener) {
        this.dNs.setOnClickListener(onClickListener);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.dNq.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.dNC != null) {
            this.dNC.getLayoutMode().af(i == 1);
            this.dNC.getLayoutMode().k(this.bGY);
            this.mNavigationBar.onChangeSkinType(this.dNC.getPageContext(), i);
            as.g(this.dNs, i);
            as.j(this.dNo, n.c.cp_bg_line_c);
            as.j(this.dNp, n.c.cp_bg_line_c);
            as.j((View) this.dNn, n.c.cp_cont_g);
            as.j(this.dNy, n.c.cp_bg_line_e);
            int color = as.getColor(n.c.cp_cont_b);
            int color2 = as.getColor(n.c.cp_cont_e);
            this.dNn.setTextColor(color);
            this.dNr.setTextColor(color);
            this.dNA.setTextColor(as.getColor(n.c.cp_cont_b));
            this.dNB.setTextColor(as.getColor(n.c.cp_cont_d));
            a(this.dNn, color2);
            a(this.dNr, color2);
            aIs();
        }
    }

    public ShareSDKImageView aIz() {
        return this.dNz;
    }
}
