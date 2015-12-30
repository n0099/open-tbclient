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
    private WriteData dJy;
    private View dUO;
    private TextView dUS;
    private cf dUT;
    private ImageView dUU;
    private View dUV;
    private LinearLayout dUW;
    private LinearLayout dUX;
    private ShareSDKImageView dUY;
    private TextView dUZ;
    private TextView dVa;
    private WriteShareActivity dVb;
    private com.baidu.tbadk.img.b dVc;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText dUM = null;
    private View dUN = null;
    private LinearLayout dUP = null;
    private EditText dUQ = null;
    private TextView dUR = null;
    private RelativeLayout bKF = null;
    private boolean dVd = false;
    private int width = 0;
    private int height = 0;

    public o(WriteShareActivity writeShareActivity) {
        this.dJy = null;
        this.dVb = writeShareActivity;
        this.dJy = writeShareActivity.aGz();
        if (this.dVc == null) {
            this.dVc = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.dVb.findViewById(n.g.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dVb.getPageContext().getString(n.j.share_navigationbar_title));
        this.dUR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dVb.getPageContext().getString(n.j.send_post));
        this.bKF = (RelativeLayout) this.dVb.findViewById(n.g.parent);
        this.dUN = this.dVb.findViewById(n.g.interval_view);
        this.dUO = this.dVb.findViewById(n.g.prefix_interval_view);
        this.dUW = (LinearLayout) this.dVb.findViewById(n.g.post_share_layout);
        this.dUX = (LinearLayout) this.dVb.findViewById(n.g.post_share_content_layout);
        this.dUY = (ShareSDKImageView) this.dVb.findViewById(n.g.post_share_image);
        this.dUZ = (TextView) this.dVb.findViewById(n.g.post_share_title);
        this.dVa = (TextView) this.dVb.findViewById(n.g.post_share_content);
        aKM();
        aKO();
        this.dUP = (LinearLayout) this.dVb.findViewById(n.g.post_content_container);
        this.dUP.setDrawingCacheEnabled(false);
        this.dUM.setVisibility(0);
        this.dUQ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        aKN();
    }

    public void aKK() {
        this.dUW = (LinearLayout) this.dVb.findViewById(n.g.post_share_layout);
        this.dUY = (ShareSDKImageView) this.dVb.findViewById(n.g.post_share_image);
        this.dUY.setIsRound(false);
        this.dUY.setDrawBorder(false);
        this.dUY.setAutoChangeStyle(true);
        this.dUY.setRadius(0);
        this.dUZ = (TextView) this.dVb.findViewById(n.g.post_share_title);
        this.dVa = (TextView) this.dVb.findViewById(n.g.post_share_content);
        if (this.dJy != null) {
            if (this.dJy.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.dUY.setEvent(new p(this));
            }
            if (this.dJy.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.dJy.getShareSummaryImg() != null && this.dJy.getShareSummaryImg().trim().length() > 0) {
                    this.dUY.d(this.dJy.getShareSummaryImg(), 10, true);
                } else {
                    this.dVd = true;
                    aKN();
                }
            } else {
                Bitmap N = com.baidu.tbadk.core.util.c.N(this.dJy.getShareLocalImageData());
                if (N != null) {
                    this.dUY.setImageBitmap(N);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.dJy.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(com.baidu.tbadk.core.util.n.a(TbadkCoreApplication.m411getInst().getApp(), Uri.parse(this.dJy.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.K(ay.va().vg(), ay.va().vg()));
                    this.dUY.setTag(imageFileInfo.toCachedKey(true));
                    if (this.dVc.a(imageFileInfo, new q(this), true) != null) {
                        this.dUY.invalidate();
                    }
                }
                this.dVd = true;
                aKN();
            }
            this.dJy.setShareSummaryImgType(com.baidu.adp.lib.util.e.aL(this.dJy.getShareSummaryImg()));
            this.dUZ.setText(this.dJy.getShareSummaryTitle());
            this.dVa.setText(this.dJy.getShareSummaryContent());
        }
    }

    private void aKL() {
        this.dUV = this.dVb.findViewById(n.g.post_prefix_layout);
        this.dUS = (TextView) this.dVb.findViewById(n.g.post_prefix);
        this.dUU = (ImageView) this.dVb.findViewById(n.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.dUV.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.dUS.setText(prefixs.get(0));
            this.dVb.oj(0);
            this.dUV.setOnClickListener(new r(this));
            this.dUU = (ImageView) this.dVb.findViewById(n.g.prefix_icon);
            if (size > 1) {
                this.dUU.setVisibility(0);
                this.dUS.setOnClickListener(new s(this));
            }
            this.dUT = new cf(this.dVb.getPageContext().getContext());
            this.dUT.setMaxHeight(com.baidu.adp.lib.util.k.dip2px(this.dVb.getPageContext().getContext(), 225.0f));
            this.dUT.setOutsideTouchable(true);
            this.dUT.setFocusable(true);
            this.dUT.setBackgroundDrawable(as.getDrawable(n.d.cp_bg_line_b));
            this.dUT.a(new t(this));
            this.dUT.setOnDismissListener(new u(this));
            int color = as.getColor(n.d.write_text);
            as.i((View) this.dUS, n.f.write_prefix_item_selector);
            as.c(this.dUU, n.f.icon_title_down);
            this.dUS.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.dVb.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.dip2px(this.dVb.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                as.i((View) textView, n.f.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.k.dip2px(this.dVb.getPageContext().getContext(), this.dVb.getResources().getDimension(n.e.ds6)), 0, com.baidu.adp.lib.util.k.dip2px(this.dVb.getPageContext().getContext(), this.dVb.getResources().getDimension(n.e.ds22)), 0);
                this.dUT.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(this.dVb.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.k.dip2px(this.dVb.getPageContext().getContext(), this.dVb.getResources().getDimension(n.e.ds6)), 0, com.baidu.adp.lib.util.k.dip2px(this.dVb.getPageContext().getContext(), this.dVb.getResources().getDimension(n.e.ds22)), 0);
                }
            }
            this.dUT.od(0);
            return;
        }
        this.dUV.setVisibility(8);
    }

    protected void aKM() {
        this.dUM = (EditText) this.dVb.findViewById(n.g.post_title);
        if (this.dJy.getType() == 3) {
            if (this.dJy.getTitle() != null && this.dJy.getTitle().trim().length() > 0) {
                this.dUM.setText(this.dJy.getTitle());
                this.dUM.setSelection(this.dJy.getTitle().length());
            } else {
                String str = String.valueOf(this.dVb.getPageContext().getString(n.j.share_transfer_thread)) + this.dJy.getShareSummaryTitle();
                this.dUM.setText(str);
                if (str.length() < 20) {
                    this.dUM.setSelection(str.length());
                } else {
                    this.dUM.setSelection(20);
                }
            }
        }
        this.dUM.addTextChangedListener(new v(this));
    }

    public void aKN() {
        String str = null;
        if (this.dJy.getType() == 3) {
            String trim = this.dUM.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.dVb.aKH() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.dJy.setIsNoTitle(true);
                    } else {
                        this.dJy.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.dJy.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.dJy.setIsNoTitle(true);
            } else {
                this.dJy.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.dVd) {
            this.dUR.setEnabled(false);
        } else {
            this.dUR.setEnabled(true);
        }
    }

    protected void aKO() {
        this.dUQ = (EditText) this.dVb.findViewById(n.g.post_content);
        this.dUQ.setDrawingCacheEnabled(false);
        if (this.dJy.getContent() != null && this.dJy.getContent().length() > 0) {
            SpannableString G = TbFaceManager.CL().G(this.dVb.getPageContext().getContext(), this.dJy.getContent());
            this.dUQ.setText(G);
            this.dUQ.setSelection(G.length());
        }
        this.dUQ.setOnTouchListener(new w(this));
        this.dUQ.addTextChangedListener(new x(this));
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

    public EditText aKP() {
        return this.dUM;
    }

    public EditText auG() {
        return this.dUQ;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        aKL();
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.dUM.setOnFocusChangeListener(onFocusChangeListener);
        this.dUQ.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.dUR.setOnFocusChangeListener(onFocusChangeListener);
    }

    public cf aKQ() {
        return this.dUT;
    }

    public View aKR() {
        return this.mBack;
    }

    public TextView aKS() {
        return this.dUR;
    }

    public TextView aKT() {
        return this.dUS;
    }

    public void O(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void P(View.OnClickListener onClickListener) {
        this.dUR.setOnClickListener(onClickListener);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.dUP.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.dVb != null) {
            this.dVb.getLayoutMode().ac(i == 1);
            this.dVb.getLayoutMode().k(this.bKF);
            this.mNavigationBar.onChangeSkinType(this.dVb.getPageContext(), i);
            as.g(this.dUR, i);
            as.j(this.dUN, n.d.cp_bg_line_c);
            as.j(this.dUO, n.d.cp_bg_line_c);
            as.j((View) this.dUM, n.d.cp_cont_g);
            as.j(this.dUX, n.d.cp_bg_line_e);
            int color = as.getColor(n.d.cp_cont_b);
            int color2 = as.getColor(n.d.cp_cont_e);
            this.dUM.setTextColor(color);
            this.dUQ.setTextColor(color);
            this.dUZ.setTextColor(as.getColor(n.d.cp_cont_b));
            this.dVa.setTextColor(as.getColor(n.d.cp_cont_d));
            a(this.dUM, color2);
            a(this.dUQ, color2);
            aKN();
        }
    }

    public ShareSDKImageView aKU() {
        return this.dUY;
    }
}
