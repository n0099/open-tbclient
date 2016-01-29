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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
import com.baidu.tieba.write.view.ShareSDKImageView;
import com.baidu.tieba.write.write.cc;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o {
    private WriteData dZC;
    private View epA;
    private LinearLayout epB;
    private LinearLayout epC;
    private ShareSDKImageView epD;
    private TextView epE;
    private TextView epF;
    private WriteShareActivity epG;
    private com.baidu.tbadk.img.b epH;
    private View ept;
    private TextView epx;
    private cc epy;
    private ImageView epz;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View ajk = null;
    private EditText epr = null;
    private View eps = null;
    private LinearLayout epu = null;
    private EditText epv = null;
    private TextView epw = null;
    private RelativeLayout bOs = null;
    private boolean epI = false;
    private int width = 0;
    private int height = 0;

    public o(WriteShareActivity writeShareActivity) {
        this.dZC = null;
        this.epG = writeShareActivity;
        this.dZC = writeShareActivity.aND();
        if (this.epH == null) {
            this.epH = new com.baidu.tbadk.img.b();
        }
        qD();
    }

    private void qD() {
        this.mNavigationBar = (NavigationBar) this.epG.findViewById(t.g.view_navigation_bar);
        this.ajk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.epG.getPageContext().getString(t.j.share_navigationbar_title));
        this.epw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.epG.getPageContext().getString(t.j.send_post));
        this.bOs = (RelativeLayout) this.epG.findViewById(t.g.parent);
        this.eps = this.epG.findViewById(t.g.interval_view);
        this.ept = this.epG.findViewById(t.g.prefix_interval_view);
        this.epB = (LinearLayout) this.epG.findViewById(t.g.post_share_layout);
        this.epC = (LinearLayout) this.epG.findViewById(t.g.post_share_content_layout);
        this.epD = (ShareSDKImageView) this.epG.findViewById(t.g.post_share_image);
        this.epE = (TextView) this.epG.findViewById(t.g.post_share_title);
        this.epF = (TextView) this.epG.findViewById(t.g.post_share_content);
        aTw();
        aTy();
        this.epu = (LinearLayout) this.epG.findViewById(t.g.post_content_container);
        this.epu.setDrawingCacheEnabled(false);
        this.epr.setVisibility(0);
        this.epv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        aTx();
    }

    public void aTu() {
        this.epB = (LinearLayout) this.epG.findViewById(t.g.post_share_layout);
        this.epD = (ShareSDKImageView) this.epG.findViewById(t.g.post_share_image);
        this.epD.setIsRound(false);
        this.epD.setDrawBorder(false);
        this.epD.setAutoChangeStyle(true);
        this.epD.setRadius(0);
        this.epE = (TextView) this.epG.findViewById(t.g.post_share_title);
        this.epF = (TextView) this.epG.findViewById(t.g.post_share_content);
        if (this.dZC != null) {
            if (this.dZC.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.epD.setEvent(new p(this));
            }
            if (this.dZC.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.dZC.getShareSummaryImg() != null && this.dZC.getShareSummaryImg().trim().length() > 0) {
                    this.epD.d(this.dZC.getShareSummaryImg(), 10, true);
                } else {
                    this.epI = true;
                    aTx();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.dZC.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.epD.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.dZC.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(com.baidu.tbadk.core.util.m.a(TbadkCoreApplication.m411getInst().getApp(), Uri.parse(this.dZC.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.G(ax.wg().wm(), ax.wg().wm()));
                    this.epD.setTag(imageFileInfo.toCachedKey(true));
                    if (this.epH.a(imageFileInfo, new q(this), true) != null) {
                        this.epD.invalidate();
                    }
                }
                this.epI = true;
                aTx();
            }
            this.dZC.setShareSummaryImgType(com.baidu.adp.lib.util.e.aK(this.dZC.getShareSummaryImg()));
            this.epE.setText(this.dZC.getShareSummaryTitle());
            this.epF.setText(this.dZC.getShareSummaryContent());
        }
    }

    private void aTv() {
        this.epA = this.epG.findViewById(t.g.post_prefix_layout);
        this.epx = (TextView) this.epG.findViewById(t.g.post_prefix);
        this.epz = (ImageView) this.epG.findViewById(t.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.epA.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.epx.setText(prefixs.get(0));
            this.epG.pE(0);
            this.epA.setOnClickListener(new r(this));
            this.epz = (ImageView) this.epG.findViewById(t.g.prefix_icon);
            if (size > 1) {
                this.epz.setVisibility(0);
                this.epx.setOnClickListener(new s(this));
            }
            this.epy = new cc(this.epG.getPageContext().getContext());
            this.epy.setMaxHeight(com.baidu.adp.lib.util.k.dip2px(this.epG.getPageContext().getContext(), 225.0f));
            this.epy.setOutsideTouchable(true);
            this.epy.setFocusable(true);
            this.epy.setBackgroundDrawable(ar.getDrawable(t.d.cp_bg_line_b));
            this.epy.a(new t(this));
            this.epy.setOnDismissListener(new u(this));
            int color = ar.getColor(t.d.write_text);
            ar.k(this.epx, t.f.write_prefix_item_selector);
            ar.c(this.epz, t.f.icon_title_down);
            this.epx.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.epG.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.dip2px(this.epG.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ar.k(textView, t.f.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.k.dip2px(this.epG.getPageContext().getContext(), this.epG.getResources().getDimension(t.e.ds6)), 0, com.baidu.adp.lib.util.k.dip2px(this.epG.getPageContext().getContext(), this.epG.getResources().getDimension(t.e.ds22)), 0);
                this.epy.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(this.epG.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.k.dip2px(this.epG.getPageContext().getContext(), this.epG.getResources().getDimension(t.e.ds6)), 0, com.baidu.adp.lib.util.k.dip2px(this.epG.getPageContext().getContext(), this.epG.getResources().getDimension(t.e.ds22)), 0);
                }
            }
            this.epy.py(0);
            return;
        }
        this.epA.setVisibility(8);
    }

    protected void aTw() {
        this.epr = (EditText) this.epG.findViewById(t.g.post_title);
        if (this.dZC.getType() == 3) {
            if (this.dZC.getTitle() != null && this.dZC.getTitle().trim().length() > 0) {
                this.epr.setText(this.dZC.getTitle());
                this.epr.setSelection(this.dZC.getTitle().length());
            } else {
                String str = String.valueOf(this.epG.getPageContext().getString(t.j.share_transfer_thread)) + this.dZC.getShareSummaryTitle();
                this.epr.setText(str);
                if (str.length() < 20) {
                    this.epr.setSelection(str.length());
                } else {
                    this.epr.setSelection(20);
                }
            }
        }
        this.epr.addTextChangedListener(new v(this));
    }

    public void aTx() {
        String str = null;
        if (this.dZC.getType() == 3) {
            String trim = this.epr.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.epG.aTr() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.dZC.setIsNoTitle(true);
                    } else {
                        this.dZC.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.dZC.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.dZC.setIsNoTitle(true);
            } else {
                this.dZC.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.epI) {
            this.epw.setEnabled(false);
        } else {
            this.epw.setEnabled(true);
        }
    }

    protected void aTy() {
        this.epv = (EditText) this.epG.findViewById(t.g.post_content);
        this.epv.setDrawingCacheEnabled(false);
        if (this.dZC.getContent() != null && this.dZC.getContent().length() > 0) {
            SpannableString G = TbFaceManager.Ec().G(this.epG.getPageContext().getContext(), this.dZC.getContent());
            this.epv.setText(G);
            this.epv.setSelection(G.length());
        }
        this.epv.setOnTouchListener(new w(this));
        this.epv.addTextChangedListener(new x(this));
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

    public EditText aTz() {
        return this.epr;
    }

    public EditText aAU() {
        return this.epv;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        aTv();
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.epr.setOnFocusChangeListener(onFocusChangeListener);
        this.epv.setOnFocusChangeListener(onFocusChangeListener);
        this.ajk.setOnFocusChangeListener(onFocusChangeListener);
        this.epw.setOnFocusChangeListener(onFocusChangeListener);
    }

    public cc aTA() {
        return this.epy;
    }

    public View aTB() {
        return this.ajk;
    }

    public TextView aTC() {
        return this.epw;
    }

    public TextView aTD() {
        return this.epx;
    }

    public void T(View.OnClickListener onClickListener) {
        this.ajk.setOnClickListener(onClickListener);
    }

    public void U(View.OnClickListener onClickListener) {
        this.epw.setOnClickListener(onClickListener);
    }

    public void V(View.OnClickListener onClickListener) {
        this.epu.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.epG != null) {
            this.epG.getLayoutMode().ac(i == 1);
            this.epG.getLayoutMode().x(this.bOs);
            this.mNavigationBar.onChangeSkinType(this.epG.getPageContext(), i);
            ar.g(this.epw, i);
            ar.l(this.eps, t.d.cp_bg_line_c);
            ar.l(this.ept, t.d.cp_bg_line_c);
            ar.l(this.epr, t.d.cp_cont_g);
            ar.l(this.epC, t.d.cp_bg_line_e);
            int color = ar.getColor(t.d.cp_cont_b);
            int color2 = ar.getColor(t.d.cp_cont_e);
            this.epr.setTextColor(color);
            this.epv.setTextColor(color);
            this.epE.setTextColor(ar.getColor(t.d.cp_cont_b));
            this.epF.setTextColor(ar.getColor(t.d.cp_cont_d));
            a(this.epr, color2);
            a(this.epv, color2);
            aTx();
        }
    }

    public ShareSDKImageView aTE() {
        return this.epD;
    }
}
