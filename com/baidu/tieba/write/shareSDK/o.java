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
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o {
    private WriteData evE;
    private View fag;
    private TextView fak;
    private com.baidu.tieba.write.b fal;
    private ImageView fam;
    private View fan;
    private LinearLayout fao;
    private LinearLayout fap;
    private ShareSDKImageView faq;
    private TextView far;
    private TextView fas;
    private WriteShareActivity fat;
    private com.baidu.tbadk.img.b fau;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View afm = null;
    private EditText fae = null;
    private View faf = null;
    private LinearLayout fah = null;
    private EditText fai = null;
    private TextView faj = null;
    private RelativeLayout bZp = null;
    private boolean fav = false;
    private int width = 0;
    private int height = 0;

    public o(WriteShareActivity writeShareActivity) {
        this.evE = null;
        this.fat = writeShareActivity;
        this.evE = writeShareActivity.aVa();
        if (this.fau == null) {
            this.fau = new com.baidu.tbadk.img.b();
        }
        nq();
    }

    private void nq() {
        this.mNavigationBar = (NavigationBar) this.fat.findViewById(t.g.view_navigation_bar);
        this.afm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.fat.getPageContext().getString(t.j.share_navigationbar_title));
        this.faj = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fat.getPageContext().getString(t.j.send_post));
        this.bZp = (RelativeLayout) this.fat.findViewById(t.g.parent);
        this.faf = this.fat.findViewById(t.g.interval_view);
        this.fag = this.fat.findViewById(t.g.prefix_interval_view);
        this.fao = (LinearLayout) this.fat.findViewById(t.g.post_share_layout);
        this.fap = (LinearLayout) this.fat.findViewById(t.g.post_share_content_layout);
        this.faq = (ShareSDKImageView) this.fat.findViewById(t.g.post_share_image);
        this.far = (TextView) this.fat.findViewById(t.g.post_share_title);
        this.fas = (TextView) this.fat.findViewById(t.g.post_share_content);
        bci();
        bck();
        this.fah = (LinearLayout) this.fat.findViewById(t.g.post_content_container);
        this.fah.setDrawingCacheEnabled(false);
        this.fae.setVisibility(0);
        this.fai.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        bcj();
    }

    public void bcg() {
        this.fao = (LinearLayout) this.fat.findViewById(t.g.post_share_layout);
        this.faq = (ShareSDKImageView) this.fat.findViewById(t.g.post_share_image);
        this.faq.setIsRound(false);
        this.faq.setDrawBorder(false);
        this.faq.setAutoChangeStyle(true);
        this.faq.setRadius(0);
        this.far = (TextView) this.fat.findViewById(t.g.post_share_title);
        this.fas = (TextView) this.fat.findViewById(t.g.post_share_content);
        if (this.evE != null) {
            if (this.evE.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.faq.setEvent(new p(this));
            }
            if (this.evE.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.evE.getShareSummaryImg() != null && this.evE.getShareSummaryImg().trim().length() > 0) {
                    this.faq.c(this.evE.getShareSummaryImg(), 10, true);
                } else {
                    this.fav = true;
                    bcj();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.evE.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.faq.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.evE.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(com.baidu.tbadk.core.util.m.a(TbadkCoreApplication.m11getInst().getApp(), Uri.parse(this.evE.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.D(az.uf().ul(), az.uf().ul()));
                    this.faq.setTag(imageFileInfo.toCachedKey(true));
                    if (this.fau.a(imageFileInfo, new q(this), true) != null) {
                        this.faq.invalidate();
                    }
                }
                this.fav = true;
                bcj();
            }
            this.evE.setShareSummaryImgType(com.baidu.adp.lib.util.e.aF(this.evE.getShareSummaryImg()));
            this.far.setText(this.evE.getShareSummaryTitle());
            this.fas.setText(this.evE.getShareSummaryContent());
        }
    }

    private void bch() {
        this.fan = this.fat.findViewById(t.g.post_prefix_layout);
        this.fak = (TextView) this.fat.findViewById(t.g.post_prefix);
        this.fam = (ImageView) this.fat.findViewById(t.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.fan.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.fak.setText(prefixs.get(0));
            this.fat.qT(0);
            this.fan.setOnClickListener(new r(this));
            this.fam = (ImageView) this.fat.findViewById(t.g.prefix_icon);
            if (size > 1) {
                this.fam.setVisibility(0);
                this.fak.setOnClickListener(new s(this));
            }
            this.fal = new com.baidu.tieba.write.b(this.fat.getPageContext().getContext());
            this.fal.setMaxHeight(com.baidu.adp.lib.util.k.dip2px(this.fat.getPageContext().getContext(), 225.0f));
            this.fal.setOutsideTouchable(true);
            this.fal.setFocusable(true);
            this.fal.setBackgroundDrawable(at.getDrawable(t.d.cp_bg_line_b));
            this.fal.a(new t(this));
            this.fal.setOnDismissListener(new u(this));
            int color = at.getColor(t.d.write_text);
            at.k(this.fak, t.f.write_prefix_item_selector);
            at.c(this.fam, t.f.icon_title_down);
            this.fak.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.fat.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.dip2px(this.fat.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                at.k(textView, t.f.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.k.dip2px(this.fat.getPageContext().getContext(), this.fat.getResources().getDimension(t.e.ds6)), 0, com.baidu.adp.lib.util.k.dip2px(this.fat.getPageContext().getContext(), this.fat.getResources().getDimension(t.e.ds22)), 0);
                this.fal.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(this.fat.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.k.dip2px(this.fat.getPageContext().getContext(), this.fat.getResources().getDimension(t.e.ds6)), 0, com.baidu.adp.lib.util.k.dip2px(this.fat.getPageContext().getContext(), this.fat.getResources().getDimension(t.e.ds22)), 0);
                }
            }
            this.fal.qH(0);
            return;
        }
        this.fan.setVisibility(8);
    }

    protected void bci() {
        this.fae = (EditText) this.fat.findViewById(t.g.post_title);
        if (this.evE.getType() == 3) {
            if (this.evE.getTitle() != null && this.evE.getTitle().trim().length() > 0) {
                this.fae.setText(this.evE.getTitle());
                this.fae.setSelection(this.evE.getTitle().length());
            } else {
                String str = String.valueOf(this.fat.getPageContext().getString(t.j.share_transfer_thread)) + this.evE.getShareSummaryTitle();
                this.fae.setText(str);
                if (str.length() < 20) {
                    this.fae.setSelection(str.length());
                } else {
                    this.fae.setSelection(20);
                }
            }
        }
        this.fae.addTextChangedListener(new v(this));
    }

    public void bcj() {
        String str = null;
        if (this.evE.getType() == 3) {
            String trim = this.fae.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.fat.bcd() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.evE.setIsNoTitle(true);
                    } else {
                        this.evE.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.evE.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.evE.setIsNoTitle(true);
            } else {
                this.evE.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.fav) {
            this.faj.setEnabled(false);
        } else {
            this.faj.setEnabled(true);
        }
    }

    protected void bck() {
        this.fai = (EditText) this.fat.findViewById(t.g.post_content);
        this.fai.setDrawingCacheEnabled(false);
        if (this.evE.getContent() != null && this.evE.getContent().length() > 0) {
            SpannableString y = TbFaceManager.CG().y(this.fat.getPageContext().getContext(), this.evE.getContent());
            this.fai.setText(y);
            this.fai.setSelection(y.length());
        }
        this.fai.setOnTouchListener(new w(this));
        this.fai.addTextChangedListener(new x(this));
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

    public EditText bcl() {
        return this.fae;
    }

    public EditText aIW() {
        return this.fai;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        bch();
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.fae.setOnFocusChangeListener(onFocusChangeListener);
        this.fai.setOnFocusChangeListener(onFocusChangeListener);
        this.afm.setOnFocusChangeListener(onFocusChangeListener);
        this.faj.setOnFocusChangeListener(onFocusChangeListener);
    }

    public com.baidu.tieba.write.b bcm() {
        return this.fal;
    }

    public View bcn() {
        return this.afm;
    }

    public TextView bco() {
        return this.faj;
    }

    public TextView bcp() {
        return this.fak;
    }

    public void R(View.OnClickListener onClickListener) {
        this.afm.setOnClickListener(onClickListener);
    }

    public void S(View.OnClickListener onClickListener) {
        this.faj.setOnClickListener(onClickListener);
    }

    public void T(View.OnClickListener onClickListener) {
        this.fah.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.fat != null) {
            this.fat.getLayoutMode().ae(i == 1);
            this.fat.getLayoutMode().x(this.bZp);
            this.mNavigationBar.onChangeSkinType(this.fat.getPageContext(), i);
            at.g(this.faj, i);
            at.l(this.faf, t.d.cp_bg_line_c);
            at.l(this.fag, t.d.cp_bg_line_c);
            at.l(this.fae, t.d.cp_cont_g);
            at.l(this.fap, t.d.cp_bg_line_e);
            int color = at.getColor(t.d.cp_cont_b);
            int color2 = at.getColor(t.d.cp_cont_e);
            this.fae.setTextColor(color);
            this.fai.setTextColor(color);
            this.far.setTextColor(at.getColor(t.d.cp_cont_b));
            this.fas.setTextColor(at.getColor(t.d.cp_cont_d));
            a(this.fae, color2);
            a(this.fai, color2);
            bcj();
        }
    }

    public ShareSDKImageView bcq() {
        return this.faq;
    }
}
