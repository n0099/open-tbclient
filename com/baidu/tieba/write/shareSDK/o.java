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
import com.baidu.tieba.write.write.cd;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o {
    private WriteData dbx;
    private View dmB;
    private TextView dmF;
    private cd dmG;
    private ImageView dmH;
    private View dmI;
    private LinearLayout dmJ;
    private LinearLayout dmK;
    private ShareSDKImageView dmL;
    private TextView dmM;
    private TextView dmN;
    private WriteShareActivity dmO;
    private com.baidu.tbadk.img.b dmP;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText dmz = null;
    private View dmA = null;
    private LinearLayout dmC = null;
    private EditText dmD = null;
    private TextView dmE = null;
    private RelativeLayout bro = null;
    private boolean dmQ = false;
    private int width = 0;
    private int height = 0;

    public o(WriteShareActivity writeShareActivity) {
        this.dbx = null;
        this.dmO = writeShareActivity;
        this.dbx = writeShareActivity.axO();
        if (this.dmP == null) {
            this.dmP = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.dmO.findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dmO.getPageContext().getString(i.h.share_navigationbar_title));
        this.dmE = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dmO.getPageContext().getString(i.h.send_post));
        this.bro = (RelativeLayout) this.dmO.findViewById(i.f.parent);
        this.dmA = this.dmO.findViewById(i.f.interval_view);
        this.dmB = this.dmO.findViewById(i.f.prefix_interval_view);
        this.dmJ = (LinearLayout) this.dmO.findViewById(i.f.post_share_layout);
        this.dmK = (LinearLayout) this.dmO.findViewById(i.f.post_share_content_layout);
        this.dmL = (ShareSDKImageView) this.dmO.findViewById(i.f.post_share_image);
        this.dmM = (TextView) this.dmO.findViewById(i.f.post_share_title);
        this.dmN = (TextView) this.dmO.findViewById(i.f.post_share_content);
        aCi();
        aCk();
        this.dmC = (LinearLayout) this.dmO.findViewById(i.f.post_content_container);
        this.dmC.setDrawingCacheEnabled(false);
        this.dmz.setVisibility(0);
        this.dmD.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        aCj();
    }

    public void aCg() {
        this.dmJ = (LinearLayout) this.dmO.findViewById(i.f.post_share_layout);
        this.dmL = (ShareSDKImageView) this.dmO.findViewById(i.f.post_share_image);
        this.dmL.setIsRound(false);
        this.dmL.setDrawBorder(false);
        this.dmL.setAutoChangeStyle(true);
        this.dmL.setRadius(0);
        this.dmM = (TextView) this.dmO.findViewById(i.f.post_share_title);
        this.dmN = (TextView) this.dmO.findViewById(i.f.post_share_content);
        if (this.dbx != null) {
            if (this.dbx.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.dmL.setEvent(new p(this));
            }
            if (this.dbx.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.dbx.getShareSummaryImg() != null && this.dbx.getShareSummaryImg().trim().length() > 0) {
                    this.dmL.d(this.dbx.getShareSummaryImg(), 10, true);
                } else {
                    this.dmQ = true;
                    aCj();
                }
            } else {
                Bitmap N = com.baidu.tbadk.core.util.c.N(this.dbx.getShareLocalImageData());
                if (N != null) {
                    this.dmL.setImageBitmap(N);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.dbx.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(com.baidu.tbadk.core.util.n.a(TbadkCoreApplication.m411getInst().getApp(), Uri.parse(this.dbx.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.J(at.uJ().uP(), at.uJ().uP()));
                    this.dmL.setTag(imageFileInfo.toCachedKey(true));
                    if (this.dmP.a(imageFileInfo, new q(this), true) != null) {
                        this.dmL.invalidate();
                    }
                }
                this.dmQ = true;
                aCj();
            }
            this.dbx.setShareSummaryImgType(com.baidu.adp.lib.util.e.aJ(this.dbx.getShareSummaryImg()));
            this.dmM.setText(this.dbx.getShareSummaryTitle());
            this.dmN.setText(this.dbx.getShareSummaryContent());
        }
    }

    private void aCh() {
        this.dmI = this.dmO.findViewById(i.f.post_prefix_layout);
        this.dmF = (TextView) this.dmO.findViewById(i.f.post_prefix);
        this.dmH = (ImageView) this.dmO.findViewById(i.f.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.dmI.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.dmF.setText(prefixs.get(0));
            this.dmO.lR(0);
            this.dmI.setOnClickListener(new r(this));
            this.dmH = (ImageView) this.dmO.findViewById(i.f.prefix_icon);
            if (size > 1) {
                this.dmH.setVisibility(0);
                this.dmF.setOnClickListener(new s(this));
            }
            this.dmG = new cd(this.dmO.getPageContext().getContext());
            this.dmG.setMaxHeight(com.baidu.adp.lib.util.k.dip2px(this.dmO.getPageContext().getContext(), 225.0f));
            this.dmG.setOutsideTouchable(true);
            this.dmG.setFocusable(true);
            this.dmG.setBackgroundDrawable(an.getDrawable(i.c.cp_bg_line_b));
            this.dmG.a(new t(this));
            this.dmG.setOnDismissListener(new u(this));
            int color = an.getColor(i.c.write_text);
            an.i((View) this.dmF, i.e.write_prefix_item_selector);
            an.c(this.dmH, i.e.icon_title_down);
            this.dmF.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.dmO.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.dip2px(this.dmO.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                an.i((View) textView, i.e.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.k.dip2px(this.dmO.getPageContext().getContext(), this.dmO.getResources().getDimension(i.d.ds6)), 0, com.baidu.adp.lib.util.k.dip2px(this.dmO.getPageContext().getContext(), this.dmO.getResources().getDimension(i.d.ds22)), 0);
                this.dmG.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(this.dmO.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.k.dip2px(this.dmO.getPageContext().getContext(), this.dmO.getResources().getDimension(i.d.ds6)), 0, com.baidu.adp.lib.util.k.dip2px(this.dmO.getPageContext().getContext(), this.dmO.getResources().getDimension(i.d.ds22)), 0);
                }
            }
            this.dmG.lL(0);
            return;
        }
        this.dmI.setVisibility(8);
    }

    protected void aCi() {
        this.dmz = (EditText) this.dmO.findViewById(i.f.post_title);
        if (this.dbx.getType() == 3) {
            if (this.dbx.getTitle() != null && this.dbx.getTitle().trim().length() > 0) {
                this.dmz.setText(this.dbx.getTitle());
                this.dmz.setSelection(this.dbx.getTitle().length());
            } else {
                String str = String.valueOf(this.dmO.getPageContext().getString(i.h.share_transfer_thread)) + this.dbx.getShareSummaryTitle();
                this.dmz.setText(str);
                if (str.length() < 20) {
                    this.dmz.setSelection(str.length());
                } else {
                    this.dmz.setSelection(20);
                }
            }
        }
        this.dmz.addTextChangedListener(new v(this));
    }

    public void aCj() {
        String str = null;
        if (this.dbx.getType() == 3) {
            String trim = this.dmz.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.dmO.aCd() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.dbx.setIsNoTitle(true);
                    } else {
                        this.dbx.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.dbx.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.dbx.setIsNoTitle(true);
            } else {
                this.dbx.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.dmQ) {
            this.dmE.setEnabled(false);
        } else {
            this.dmE.setEnabled(true);
        }
    }

    protected void aCk() {
        this.dmD = (EditText) this.dmO.findViewById(i.f.post_content);
        this.dmD.setDrawingCacheEnabled(false);
        if (this.dbx.getContent() != null && this.dbx.getContent().length() > 0) {
            SpannableString G = TbFaceManager.Ce().G(this.dmO.getPageContext().getContext(), this.dbx.getContent());
            this.dmD.setText(G);
            this.dmD.setSelection(G.length());
        }
        this.dmD.setOnTouchListener(new w(this));
        this.dmD.addTextChangedListener(new x(this));
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

    public EditText aCl() {
        return this.dmz;
    }

    public EditText amS() {
        return this.dmD;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        aCh();
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.dmz.setOnFocusChangeListener(onFocusChangeListener);
        this.dmD.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.dmE.setOnFocusChangeListener(onFocusChangeListener);
    }

    public cd aCm() {
        return this.dmG;
    }

    public View aCn() {
        return this.mBack;
    }

    public TextView aCo() {
        return this.dmE;
    }

    public TextView aCp() {
        return this.dmF;
    }

    public void K(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void L(View.OnClickListener onClickListener) {
        this.dmE.setOnClickListener(onClickListener);
    }

    public void M(View.OnClickListener onClickListener) {
        this.dmC.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.dmO != null) {
            this.dmO.getLayoutMode().ad(i == 1);
            this.dmO.getLayoutMode().k(this.bro);
            this.mNavigationBar.onChangeSkinType(this.dmO.getPageContext(), i);
            an.g(this.dmE, i);
            an.j(this.dmA, i.c.cp_bg_line_c);
            an.j(this.dmB, i.c.cp_bg_line_c);
            an.j((View) this.dmz, i.c.cp_cont_g);
            an.j(this.dmK, i.c.cp_bg_line_e);
            int color = an.getColor(i.c.cp_cont_b);
            int color2 = an.getColor(i.c.cp_cont_e);
            this.dmz.setTextColor(color);
            this.dmD.setTextColor(color);
            this.dmM.setTextColor(an.getColor(i.c.cp_cont_b));
            this.dmN.setTextColor(an.getColor(i.c.cp_cont_d));
            a(this.dmz, color2);
            a(this.dmD, color2);
            aCj();
        }
    }

    public ShareSDKImageView aCq() {
        return this.dmL;
    }
}
