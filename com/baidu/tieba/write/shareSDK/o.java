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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
import com.baidu.tieba.write.view.ShareSDKImageView;
import com.baidu.tieba.write.write.cg;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o {
    private TextView eJA;
    private TextView eJB;
    private WriteShareActivity eJC;
    private com.baidu.tbadk.img.b eJD;
    private View eJp;
    private TextView eJt;
    private cg eJu;
    private ImageView eJv;
    private View eJw;
    private LinearLayout eJx;
    private LinearLayout eJy;
    private ShareSDKImageView eJz;
    private WriteData esv;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View ajA = null;
    private EditText eJn = null;
    private View eJo = null;
    private LinearLayout eJq = null;
    private EditText eJr = null;
    private TextView eJs = null;
    private RelativeLayout bYK = null;
    private boolean eJE = false;
    private int width = 0;
    private int height = 0;

    public o(WriteShareActivity writeShareActivity) {
        this.esv = null;
        this.eJC = writeShareActivity;
        this.esv = writeShareActivity.aUF();
        if (this.eJD == null) {
            this.eJD = new com.baidu.tbadk.img.b();
        }
        pU();
    }

    private void pU() {
        this.mNavigationBar = (NavigationBar) this.eJC.findViewById(t.g.view_navigation_bar);
        this.ajA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.eJC.getPageContext().getString(t.j.share_navigationbar_title));
        this.eJs = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eJC.getPageContext().getString(t.j.send_post));
        this.bYK = (RelativeLayout) this.eJC.findViewById(t.g.parent);
        this.eJo = this.eJC.findViewById(t.g.interval_view);
        this.eJp = this.eJC.findViewById(t.g.prefix_interval_view);
        this.eJx = (LinearLayout) this.eJC.findViewById(t.g.post_share_layout);
        this.eJy = (LinearLayout) this.eJC.findViewById(t.g.post_share_content_layout);
        this.eJz = (ShareSDKImageView) this.eJC.findViewById(t.g.post_share_image);
        this.eJA = (TextView) this.eJC.findViewById(t.g.post_share_title);
        this.eJB = (TextView) this.eJC.findViewById(t.g.post_share_content);
        aZW();
        aZY();
        this.eJq = (LinearLayout) this.eJC.findViewById(t.g.post_content_container);
        this.eJq.setDrawingCacheEnabled(false);
        this.eJn.setVisibility(0);
        this.eJr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        aZX();
    }

    public void aZU() {
        this.eJx = (LinearLayout) this.eJC.findViewById(t.g.post_share_layout);
        this.eJz = (ShareSDKImageView) this.eJC.findViewById(t.g.post_share_image);
        this.eJz.setIsRound(false);
        this.eJz.setDrawBorder(false);
        this.eJz.setAutoChangeStyle(true);
        this.eJz.setRadius(0);
        this.eJA = (TextView) this.eJC.findViewById(t.g.post_share_title);
        this.eJB = (TextView) this.eJC.findViewById(t.g.post_share_content);
        if (this.esv != null) {
            if (this.esv.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.eJz.setEvent(new p(this));
            }
            if (this.esv.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.esv.getShareSummaryImg() != null && this.esv.getShareSummaryImg().trim().length() > 0) {
                    this.eJz.c(this.esv.getShareSummaryImg(), 10, true);
                } else {
                    this.eJE = true;
                    aZX();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.esv.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.eJz.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.esv.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(com.baidu.tbadk.core.util.m.a(TbadkCoreApplication.m411getInst().getApp(), Uri.parse(this.esv.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.D(az.wz().wF(), az.wz().wF()));
                    this.eJz.setTag(imageFileInfo.toCachedKey(true));
                    if (this.eJD.a(imageFileInfo, new q(this), true) != null) {
                        this.eJz.invalidate();
                    }
                }
                this.eJE = true;
                aZX();
            }
            this.esv.setShareSummaryImgType(com.baidu.adp.lib.util.e.aM(this.esv.getShareSummaryImg()));
            this.eJA.setText(this.esv.getShareSummaryTitle());
            this.eJB.setText(this.esv.getShareSummaryContent());
        }
    }

    private void aZV() {
        this.eJw = this.eJC.findViewById(t.g.post_prefix_layout);
        this.eJt = (TextView) this.eJC.findViewById(t.g.post_prefix);
        this.eJv = (ImageView) this.eJC.findViewById(t.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.eJw.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.eJt.setText(prefixs.get(0));
            this.eJC.qx(0);
            this.eJw.setOnClickListener(new r(this));
            this.eJv = (ImageView) this.eJC.findViewById(t.g.prefix_icon);
            if (size > 1) {
                this.eJv.setVisibility(0);
                this.eJt.setOnClickListener(new s(this));
            }
            this.eJu = new cg(this.eJC.getPageContext().getContext());
            this.eJu.setMaxHeight(com.baidu.adp.lib.util.k.dip2px(this.eJC.getPageContext().getContext(), 225.0f));
            this.eJu.setOutsideTouchable(true);
            this.eJu.setFocusable(true);
            this.eJu.setBackgroundDrawable(at.getDrawable(t.d.cp_bg_line_b));
            this.eJu.a(new t(this));
            this.eJu.setOnDismissListener(new u(this));
            int color = at.getColor(t.d.write_text);
            at.k(this.eJt, t.f.write_prefix_item_selector);
            at.c(this.eJv, t.f.icon_title_down);
            this.eJt.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.eJC.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.dip2px(this.eJC.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                at.k(textView, t.f.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.k.dip2px(this.eJC.getPageContext().getContext(), this.eJC.getResources().getDimension(t.e.ds6)), 0, com.baidu.adp.lib.util.k.dip2px(this.eJC.getPageContext().getContext(), this.eJC.getResources().getDimension(t.e.ds22)), 0);
                this.eJu.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(this.eJC.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.k.dip2px(this.eJC.getPageContext().getContext(), this.eJC.getResources().getDimension(t.e.ds6)), 0, com.baidu.adp.lib.util.k.dip2px(this.eJC.getPageContext().getContext(), this.eJC.getResources().getDimension(t.e.ds22)), 0);
                }
            }
            this.eJu.qr(0);
            return;
        }
        this.eJw.setVisibility(8);
    }

    protected void aZW() {
        this.eJn = (EditText) this.eJC.findViewById(t.g.post_title);
        if (this.esv.getType() == 3) {
            if (this.esv.getTitle() != null && this.esv.getTitle().trim().length() > 0) {
                this.eJn.setText(this.esv.getTitle());
                this.eJn.setSelection(this.esv.getTitle().length());
            } else {
                String str = String.valueOf(this.eJC.getPageContext().getString(t.j.share_transfer_thread)) + this.esv.getShareSummaryTitle();
                this.eJn.setText(str);
                if (str.length() < 20) {
                    this.eJn.setSelection(str.length());
                } else {
                    this.eJn.setSelection(20);
                }
            }
        }
        this.eJn.addTextChangedListener(new v(this));
    }

    public void aZX() {
        String str = null;
        if (this.esv.getType() == 3) {
            String trim = this.eJn.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.eJC.aZR() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.esv.setIsNoTitle(true);
                    } else {
                        this.esv.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.esv.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.esv.setIsNoTitle(true);
            } else {
                this.esv.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.eJE) {
            this.eJs.setEnabled(false);
        } else {
            this.eJs.setEnabled(true);
        }
    }

    protected void aZY() {
        this.eJr = (EditText) this.eJC.findViewById(t.g.post_content);
        this.eJr.setDrawingCacheEnabled(false);
        if (this.esv.getContent() != null && this.esv.getContent().length() > 0) {
            SpannableString x = TbFaceManager.EN().x(this.eJC.getPageContext().getContext(), this.esv.getContent());
            this.eJr.setText(x);
            this.eJr.setSelection(x.length());
        }
        this.eJr.setOnTouchListener(new w(this));
        this.eJr.addTextChangedListener(new x(this));
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

    public EditText aZZ() {
        return this.eJn;
    }

    public EditText aII() {
        return this.eJr;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        aZV();
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.eJn.setOnFocusChangeListener(onFocusChangeListener);
        this.eJr.setOnFocusChangeListener(onFocusChangeListener);
        this.ajA.setOnFocusChangeListener(onFocusChangeListener);
        this.eJs.setOnFocusChangeListener(onFocusChangeListener);
    }

    public cg baa() {
        return this.eJu;
    }

    public View bab() {
        return this.ajA;
    }

    public TextView bac() {
        return this.eJs;
    }

    public TextView bad() {
        return this.eJt;
    }

    public void V(View.OnClickListener onClickListener) {
        this.ajA.setOnClickListener(onClickListener);
    }

    public void W(View.OnClickListener onClickListener) {
        this.eJs.setOnClickListener(onClickListener);
    }

    public void X(View.OnClickListener onClickListener) {
        this.eJq.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.eJC != null) {
            this.eJC.getLayoutMode().ab(i == 1);
            this.eJC.getLayoutMode().x(this.bYK);
            this.mNavigationBar.onChangeSkinType(this.eJC.getPageContext(), i);
            at.g(this.eJs, i);
            at.l(this.eJo, t.d.cp_bg_line_c);
            at.l(this.eJp, t.d.cp_bg_line_c);
            at.l(this.eJn, t.d.cp_cont_g);
            at.l(this.eJy, t.d.cp_bg_line_e);
            int color = at.getColor(t.d.cp_cont_b);
            int color2 = at.getColor(t.d.cp_cont_e);
            this.eJn.setTextColor(color);
            this.eJr.setTextColor(color);
            this.eJA.setTextColor(at.getColor(t.d.cp_cont_b));
            this.eJB.setTextColor(at.getColor(t.d.cp_cont_d));
            a(this.eJn, color2);
            a(this.eJr, color2);
            aZX();
        }
    }

    public ShareSDKImageView bae() {
        return this.eJz;
    }
}
