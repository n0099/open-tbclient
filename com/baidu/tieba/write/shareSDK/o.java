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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.u;
import com.baidu.tieba.write.view.ShareSDKImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o {
    private com.baidu.tbadk.img.b bdc;
    private View fFj;
    private TextView fFn;
    private com.baidu.tieba.write.b fFo;
    private ImageView fFp;
    private View fFq;
    private LinearLayout fFr;
    private LinearLayout fFs;
    private ShareSDKImageView fFt;
    private TextView fFu;
    private TextView fFv;
    private WriteShareActivity fFw;
    private WriteData fau;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View afN = null;
    private EditText fFh = null;
    private View fFi = null;
    private LinearLayout fFk = null;
    private EditText fFl = null;
    private TextView fFm = null;
    private RelativeLayout cEz = null;
    private boolean fFx = false;
    private int width = 0;
    private int height = 0;

    public o(WriteShareActivity writeShareActivity) {
        this.fau = null;
        this.fFw = writeShareActivity;
        this.fau = writeShareActivity.bdu();
        if (this.bdc == null) {
            this.bdc = new com.baidu.tbadk.img.b();
        }
        nl();
    }

    private void nl() {
        this.mNavigationBar = (NavigationBar) this.fFw.findViewById(u.g.view_navigation_bar);
        this.afN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.fFw.getPageContext().getString(u.j.share_navigationbar_title));
        this.fFm = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fFw.getPageContext().getString(u.j.send_post));
        this.cEz = (RelativeLayout) this.fFw.findViewById(u.g.parent);
        this.fFi = this.fFw.findViewById(u.g.interval_view);
        this.fFj = this.fFw.findViewById(u.g.prefix_interval_view);
        this.fFr = (LinearLayout) this.fFw.findViewById(u.g.post_share_layout);
        this.fFs = (LinearLayout) this.fFw.findViewById(u.g.post_share_content_layout);
        this.fFt = (ShareSDKImageView) this.fFw.findViewById(u.g.post_share_image);
        this.fFu = (TextView) this.fFw.findViewById(u.g.post_share_title);
        this.fFv = (TextView) this.fFw.findViewById(u.g.post_share_content);
        bkK();
        bkM();
        this.fFk = (LinearLayout) this.fFw.findViewById(u.g.post_content_container);
        this.fFk.setDrawingCacheEnabled(false);
        this.fFh.setVisibility(0);
        this.fFl.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        bkL();
    }

    public void bkI() {
        this.fFr = (LinearLayout) this.fFw.findViewById(u.g.post_share_layout);
        this.fFt = (ShareSDKImageView) this.fFw.findViewById(u.g.post_share_image);
        this.fFt.setIsRound(false);
        this.fFt.setDrawBorder(false);
        this.fFt.setAutoChangeStyle(true);
        this.fFt.setRadius(0);
        this.fFu = (TextView) this.fFw.findViewById(u.g.post_share_title);
        this.fFv = (TextView) this.fFw.findViewById(u.g.post_share_content);
        if (this.fau != null) {
            if (this.fau.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.fFt.setEvent(new p(this));
            }
            if (this.fau.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.fau.getShareSummaryImg() != null && this.fau.getShareSummaryImg().trim().length() > 0) {
                    this.fFt.c(this.fau.getShareSummaryImg(), 10, true);
                } else {
                    this.fFx = true;
                    bkL();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.fau.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.fFt.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.fau.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(com.baidu.tbadk.core.util.m.a(TbadkCoreApplication.m9getInst().getApp(), Uri.parse(this.fau.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.D(bb.uf().ul(), bb.uf().ul()));
                    this.fFt.setTag(imageFileInfo.toCachedKey(true));
                    if (this.bdc.a(imageFileInfo, new q(this), true) != null) {
                        this.fFt.invalidate();
                    }
                }
                this.fFx = true;
                bkL();
            }
            this.fau.setShareSummaryImgType(com.baidu.adp.lib.util.e.aF(this.fau.getShareSummaryImg()));
            this.fFu.setText(this.fau.getShareSummaryTitle());
            this.fFv.setText(this.fau.getShareSummaryContent());
        }
    }

    private void bkJ() {
        this.fFq = this.fFw.findViewById(u.g.post_prefix_layout);
        this.fFn = (TextView) this.fFw.findViewById(u.g.post_prefix);
        this.fFp = (ImageView) this.fFw.findViewById(u.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.fFq.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.fFn.setText(prefixs.get(0));
            this.fFw.sj(0);
            this.fFq.setOnClickListener(new r(this));
            this.fFp = (ImageView) this.fFw.findViewById(u.g.prefix_icon);
            if (size > 1) {
                this.fFp.setVisibility(0);
                this.fFn.setOnClickListener(new s(this));
            }
            this.fFo = new com.baidu.tieba.write.b(this.fFw.getPageContext().getContext());
            this.fFo.setMaxHeight(com.baidu.adp.lib.util.k.dip2px(this.fFw.getPageContext().getContext(), 225.0f));
            this.fFo.setOutsideTouchable(true);
            this.fFo.setFocusable(true);
            this.fFo.setBackgroundDrawable(av.getDrawable(u.d.cp_bg_line_b));
            this.fFo.a(new t(this));
            this.fFo.setOnDismissListener(new u(this));
            int color = av.getColor(u.d.common_color_10097);
            av.k(this.fFn, u.f.write_prefix_item_selector);
            av.c(this.fFp, u.f.icon_title_down);
            this.fFn.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.fFw.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.dip2px(this.fFw.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                av.k(textView, u.f.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.k.dip2px(this.fFw.getPageContext().getContext(), this.fFw.getResources().getDimension(u.e.ds6)), 0, com.baidu.adp.lib.util.k.dip2px(this.fFw.getPageContext().getContext(), this.fFw.getResources().getDimension(u.e.ds22)), 0);
                this.fFo.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(this.fFw.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.k.dip2px(this.fFw.getPageContext().getContext(), this.fFw.getResources().getDimension(u.e.ds6)), 0, com.baidu.adp.lib.util.k.dip2px(this.fFw.getPageContext().getContext(), this.fFw.getResources().getDimension(u.e.ds22)), 0);
                }
            }
            this.fFo.rX(0);
            return;
        }
        this.fFq.setVisibility(8);
    }

    protected void bkK() {
        this.fFh = (EditText) this.fFw.findViewById(u.g.post_title);
        if (this.fau.getType() == 3) {
            if (this.fau.getTitle() != null && this.fau.getTitle().trim().length() > 0) {
                this.fFh.setText(this.fau.getTitle());
                this.fFh.setSelection(this.fau.getTitle().length());
            } else {
                String str = String.valueOf(this.fFw.getPageContext().getString(u.j.share_transfer_thread)) + this.fau.getShareSummaryTitle();
                this.fFh.setText(str);
                if (str.length() < 20) {
                    this.fFh.setSelection(str.length());
                } else {
                    this.fFh.setSelection(20);
                }
            }
        }
        this.fFh.addTextChangedListener(new v(this));
    }

    public void bkL() {
        String str = null;
        if (this.fau.getType() == 3) {
            String trim = this.fFh.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.fFw.bkF() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.fau.setIsNoTitle(true);
                    } else {
                        this.fau.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.fau.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.fau.setIsNoTitle(true);
            } else {
                this.fau.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.fFx) {
            this.fFm.setEnabled(false);
        } else {
            this.fFm.setEnabled(true);
        }
    }

    protected void bkM() {
        this.fFl = (EditText) this.fFw.findViewById(u.g.post_content);
        this.fFl.setDrawingCacheEnabled(false);
        if (this.fau.getContent() != null && this.fau.getContent().length() > 0) {
            SpannableString z = TbFaceManager.CP().z(this.fFw.getPageContext().getContext(), this.fau.getContent());
            this.fFl.setText(z);
            this.fFl.setSelection(z.length());
        }
        this.fFl.setOnTouchListener(new w(this));
        this.fFl.addTextChangedListener(new x(this));
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

    public EditText bkN() {
        return this.fFh;
    }

    public EditText aRU() {
        return this.fFl;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        bkJ();
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.fFh.setOnFocusChangeListener(onFocusChangeListener);
        this.fFl.setOnFocusChangeListener(onFocusChangeListener);
        this.afN.setOnFocusChangeListener(onFocusChangeListener);
        this.fFm.setOnFocusChangeListener(onFocusChangeListener);
    }

    public com.baidu.tieba.write.b bkO() {
        return this.fFo;
    }

    public View bkP() {
        return this.afN;
    }

    public TextView bkQ() {
        return this.fFm;
    }

    public TextView bkR() {
        return this.fFn;
    }

    public void S(View.OnClickListener onClickListener) {
        this.afN.setOnClickListener(onClickListener);
    }

    public void T(View.OnClickListener onClickListener) {
        this.fFm.setOnClickListener(onClickListener);
    }

    public void U(View.OnClickListener onClickListener) {
        this.fFk.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.fFw != null) {
            this.fFw.getLayoutMode().ad(i == 1);
            this.fFw.getLayoutMode().w(this.cEz);
            this.mNavigationBar.onChangeSkinType(this.fFw.getPageContext(), i);
            av.g(this.fFm, i);
            av.l(this.fFi, u.d.cp_bg_line_c);
            av.l(this.fFj, u.d.cp_bg_line_c);
            av.l(this.fFh, u.d.cp_cont_g);
            av.l(this.fFs, u.d.cp_bg_line_e);
            int color = av.getColor(u.d.cp_cont_b);
            int color2 = av.getColor(u.d.cp_cont_e);
            this.fFh.setTextColor(color);
            this.fFl.setTextColor(color);
            this.fFu.setTextColor(av.getColor(u.d.cp_cont_b));
            this.fFv.setTextColor(av.getColor(u.d.cp_cont_d));
            a(this.fFh, color2);
            a(this.fFl, color2);
            bkL();
        }
    }

    public ShareSDKImageView bkS() {
        return this.fFt;
    }
}
