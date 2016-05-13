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
    private View faf;
    private TextView faj;
    private com.baidu.tieba.write.b fak;
    private ImageView fal;
    private View fam;
    private LinearLayout fan;
    private LinearLayout fao;
    private ShareSDKImageView fap;
    private TextView faq;
    private TextView far;
    private WriteShareActivity fas;
    private com.baidu.tbadk.img.b fat;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View afm = null;
    private EditText fad = null;
    private View fae = null;
    private LinearLayout fag = null;
    private EditText fah = null;
    private TextView fai = null;
    private RelativeLayout bZp = null;
    private boolean fau = false;
    private int width = 0;
    private int height = 0;

    public o(WriteShareActivity writeShareActivity) {
        this.evE = null;
        this.fas = writeShareActivity;
        this.evE = writeShareActivity.aVg();
        if (this.fat == null) {
            this.fat = new com.baidu.tbadk.img.b();
        }
        nq();
    }

    private void nq() {
        this.mNavigationBar = (NavigationBar) this.fas.findViewById(t.g.view_navigation_bar);
        this.afm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.fas.getPageContext().getString(t.j.share_navigationbar_title));
        this.fai = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fas.getPageContext().getString(t.j.send_post));
        this.bZp = (RelativeLayout) this.fas.findViewById(t.g.parent);
        this.fae = this.fas.findViewById(t.g.interval_view);
        this.faf = this.fas.findViewById(t.g.prefix_interval_view);
        this.fan = (LinearLayout) this.fas.findViewById(t.g.post_share_layout);
        this.fao = (LinearLayout) this.fas.findViewById(t.g.post_share_content_layout);
        this.fap = (ShareSDKImageView) this.fas.findViewById(t.g.post_share_image);
        this.faq = (TextView) this.fas.findViewById(t.g.post_share_title);
        this.far = (TextView) this.fas.findViewById(t.g.post_share_content);
        bcp();
        bcr();
        this.fag = (LinearLayout) this.fas.findViewById(t.g.post_content_container);
        this.fag.setDrawingCacheEnabled(false);
        this.fad.setVisibility(0);
        this.fah.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        bcq();
    }

    public void bcn() {
        this.fan = (LinearLayout) this.fas.findViewById(t.g.post_share_layout);
        this.fap = (ShareSDKImageView) this.fas.findViewById(t.g.post_share_image);
        this.fap.setIsRound(false);
        this.fap.setDrawBorder(false);
        this.fap.setAutoChangeStyle(true);
        this.fap.setRadius(0);
        this.faq = (TextView) this.fas.findViewById(t.g.post_share_title);
        this.far = (TextView) this.fas.findViewById(t.g.post_share_content);
        if (this.evE != null) {
            if (this.evE.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.fap.setEvent(new p(this));
            }
            if (this.evE.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.evE.getShareSummaryImg() != null && this.evE.getShareSummaryImg().trim().length() > 0) {
                    this.fap.c(this.evE.getShareSummaryImg(), 10, true);
                } else {
                    this.fau = true;
                    bcq();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.evE.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.fap.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.evE.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(com.baidu.tbadk.core.util.m.a(TbadkCoreApplication.m11getInst().getApp(), Uri.parse(this.evE.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.D(az.ug().um(), az.ug().um()));
                    this.fap.setTag(imageFileInfo.toCachedKey(true));
                    if (this.fat.a(imageFileInfo, new q(this), true) != null) {
                        this.fap.invalidate();
                    }
                }
                this.fau = true;
                bcq();
            }
            this.evE.setShareSummaryImgType(com.baidu.adp.lib.util.e.aF(this.evE.getShareSummaryImg()));
            this.faq.setText(this.evE.getShareSummaryTitle());
            this.far.setText(this.evE.getShareSummaryContent());
        }
    }

    private void bco() {
        this.fam = this.fas.findViewById(t.g.post_prefix_layout);
        this.faj = (TextView) this.fas.findViewById(t.g.post_prefix);
        this.fal = (ImageView) this.fas.findViewById(t.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.fam.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.faj.setText(prefixs.get(0));
            this.fas.qS(0);
            this.fam.setOnClickListener(new r(this));
            this.fal = (ImageView) this.fas.findViewById(t.g.prefix_icon);
            if (size > 1) {
                this.fal.setVisibility(0);
                this.faj.setOnClickListener(new s(this));
            }
            this.fak = new com.baidu.tieba.write.b(this.fas.getPageContext().getContext());
            this.fak.setMaxHeight(com.baidu.adp.lib.util.k.dip2px(this.fas.getPageContext().getContext(), 225.0f));
            this.fak.setOutsideTouchable(true);
            this.fak.setFocusable(true);
            this.fak.setBackgroundDrawable(at.getDrawable(t.d.cp_bg_line_b));
            this.fak.a(new t(this));
            this.fak.setOnDismissListener(new u(this));
            int color = at.getColor(t.d.write_text);
            at.k(this.faj, t.f.write_prefix_item_selector);
            at.c(this.fal, t.f.icon_title_down);
            this.faj.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.fas.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.dip2px(this.fas.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                at.k(textView, t.f.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.k.dip2px(this.fas.getPageContext().getContext(), this.fas.getResources().getDimension(t.e.ds6)), 0, com.baidu.adp.lib.util.k.dip2px(this.fas.getPageContext().getContext(), this.fas.getResources().getDimension(t.e.ds22)), 0);
                this.fak.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(this.fas.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.k.dip2px(this.fas.getPageContext().getContext(), this.fas.getResources().getDimension(t.e.ds6)), 0, com.baidu.adp.lib.util.k.dip2px(this.fas.getPageContext().getContext(), this.fas.getResources().getDimension(t.e.ds22)), 0);
                }
            }
            this.fak.qG(0);
            return;
        }
        this.fam.setVisibility(8);
    }

    protected void bcp() {
        this.fad = (EditText) this.fas.findViewById(t.g.post_title);
        if (this.evE.getType() == 3) {
            if (this.evE.getTitle() != null && this.evE.getTitle().trim().length() > 0) {
                this.fad.setText(this.evE.getTitle());
                this.fad.setSelection(this.evE.getTitle().length());
            } else {
                String str = String.valueOf(this.fas.getPageContext().getString(t.j.share_transfer_thread)) + this.evE.getShareSummaryTitle();
                this.fad.setText(str);
                if (str.length() < 20) {
                    this.fad.setSelection(str.length());
                } else {
                    this.fad.setSelection(20);
                }
            }
        }
        this.fad.addTextChangedListener(new v(this));
    }

    public void bcq() {
        String str = null;
        if (this.evE.getType() == 3) {
            String trim = this.fad.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.fas.bck() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.fau) {
            this.fai.setEnabled(false);
        } else {
            this.fai.setEnabled(true);
        }
    }

    protected void bcr() {
        this.fah = (EditText) this.fas.findViewById(t.g.post_content);
        this.fah.setDrawingCacheEnabled(false);
        if (this.evE.getContent() != null && this.evE.getContent().length() > 0) {
            SpannableString y = TbFaceManager.CH().y(this.fas.getPageContext().getContext(), this.evE.getContent());
            this.fah.setText(y);
            this.fah.setSelection(y.length());
        }
        this.fah.setOnTouchListener(new w(this));
        this.fah.addTextChangedListener(new x(this));
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

    public EditText bcs() {
        return this.fad;
    }

    public EditText aIZ() {
        return this.fah;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        bco();
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.fad.setOnFocusChangeListener(onFocusChangeListener);
        this.fah.setOnFocusChangeListener(onFocusChangeListener);
        this.afm.setOnFocusChangeListener(onFocusChangeListener);
        this.fai.setOnFocusChangeListener(onFocusChangeListener);
    }

    public com.baidu.tieba.write.b bct() {
        return this.fak;
    }

    public View bcu() {
        return this.afm;
    }

    public TextView bcv() {
        return this.fai;
    }

    public TextView bcw() {
        return this.faj;
    }

    public void R(View.OnClickListener onClickListener) {
        this.afm.setOnClickListener(onClickListener);
    }

    public void S(View.OnClickListener onClickListener) {
        this.fai.setOnClickListener(onClickListener);
    }

    public void T(View.OnClickListener onClickListener) {
        this.fag.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.fas != null) {
            this.fas.getLayoutMode().ae(i == 1);
            this.fas.getLayoutMode().x(this.bZp);
            this.mNavigationBar.onChangeSkinType(this.fas.getPageContext(), i);
            at.g(this.fai, i);
            at.l(this.fae, t.d.cp_bg_line_c);
            at.l(this.faf, t.d.cp_bg_line_c);
            at.l(this.fad, t.d.cp_cont_g);
            at.l(this.fao, t.d.cp_bg_line_e);
            int color = at.getColor(t.d.cp_cont_b);
            int color2 = at.getColor(t.d.cp_cont_e);
            this.fad.setTextColor(color);
            this.fah.setTextColor(color);
            this.faq.setTextColor(at.getColor(t.d.cp_cont_b));
            this.far.setTextColor(at.getColor(t.d.cp_cont_d));
            a(this.fad, color2);
            a(this.fah, color2);
            bcq();
        }
    }

    public ShareSDKImageView bcx() {
        return this.fap;
    }
}
