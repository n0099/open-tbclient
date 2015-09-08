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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.ShareSDKImageView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import com.baidu.tieba.write.write.cb;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o {
    private WriteData cTs;
    private View daZ;
    private TextView dbd;
    private cb dbe;
    private ImageView dbf;
    private View dbg;
    private LinearLayout dbh;
    private LinearLayout dbi;
    private ShareSDKImageView dbj;
    private TextView dbk;
    private TextView dbl;
    private WriteShareActivity dbm;
    private com.baidu.tbadk.img.b dbn;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText daX = null;
    private View daY = null;
    private LinearLayout dba = null;
    private EditText dbb = null;
    private TextView dbc = null;
    private RelativeLayout boe = null;
    private boolean dbo = false;
    private int width = 0;
    private int height = 0;

    public o(WriteShareActivity writeShareActivity) {
        this.cTs = null;
        this.dbm = writeShareActivity;
        this.cTs = writeShareActivity.avr();
        if (this.dbn == null) {
            this.dbn = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.dbm.findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dbm.getPageContext().getString(i.h.share_navigationbar_title));
        this.dbc = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dbm.getPageContext().getString(i.h.send_post));
        this.boe = (RelativeLayout) this.dbm.findViewById(i.f.parent);
        this.daY = this.dbm.findViewById(i.f.interval_view);
        this.daZ = this.dbm.findViewById(i.f.prefix_interval_view);
        this.dbh = (LinearLayout) this.dbm.findViewById(i.f.post_share_layout);
        this.dbi = (LinearLayout) this.dbm.findViewById(i.f.post_share_content_layout);
        this.dbj = (ShareSDKImageView) this.dbm.findViewById(i.f.post_share_image);
        this.dbk = (TextView) this.dbm.findViewById(i.f.post_share_title);
        this.dbl = (TextView) this.dbm.findViewById(i.f.post_share_content);
        ayP();
        ayR();
        this.dba = (LinearLayout) this.dbm.findViewById(i.f.post_content_container);
        this.dba.setDrawingCacheEnabled(false);
        this.daX.setVisibility(0);
        this.dbb.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        ayQ();
    }

    public void ayN() {
        this.dbh = (LinearLayout) this.dbm.findViewById(i.f.post_share_layout);
        this.dbj = (ShareSDKImageView) this.dbm.findViewById(i.f.post_share_image);
        this.dbj.setIsRound(false);
        this.dbj.setDrawBorder(false);
        this.dbj.setAutoChangeStyle(true);
        this.dbj.setRadius(0);
        this.dbk = (TextView) this.dbm.findViewById(i.f.post_share_title);
        this.dbl = (TextView) this.dbm.findViewById(i.f.post_share_content);
        if (this.cTs != null) {
            if (this.cTs.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.dbj.setEvent(new p(this));
            }
            if (this.cTs.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.cTs.getShareSummaryImg() != null && this.cTs.getShareSummaryImg().trim().length() > 0) {
                    this.dbj.d(this.cTs.getShareSummaryImg(), 10, true);
                } else {
                    this.dbo = true;
                    ayQ();
                }
            } else {
                Bitmap N = com.baidu.tbadk.core.util.c.N(this.cTs.getShareLocalImageData());
                if (N != null) {
                    this.dbj.setImageBitmap(N);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.cTs.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(com.baidu.tbadk.core.util.n.a(TbadkCoreApplication.m411getInst().getApp(), Uri.parse(this.cTs.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.J(ar.uK().uQ(), ar.uK().uQ()));
                    this.dbj.setTag(imageFileInfo.toCachedKey(true));
                    if (this.dbn.a(imageFileInfo, new q(this), true) != null) {
                        this.dbj.invalidate();
                    }
                }
                this.dbo = true;
                ayQ();
            }
            this.cTs.setShareSummaryImgType(com.baidu.adp.lib.util.e.aJ(this.cTs.getShareSummaryImg()));
            this.dbk.setText(this.cTs.getShareSummaryTitle());
            this.dbl.setText(this.cTs.getShareSummaryContent());
        }
    }

    private void ayO() {
        this.dbg = this.dbm.findViewById(i.f.post_prefix_layout);
        this.dbd = (TextView) this.dbm.findViewById(i.f.post_prefix);
        this.dbf = (ImageView) this.dbm.findViewById(i.f.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.dbg.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.dbd.setText(prefixs.get(0));
            this.dbm.la(0);
            this.dbg.setOnClickListener(new r(this));
            this.dbf = (ImageView) this.dbm.findViewById(i.f.prefix_icon);
            if (size > 1) {
                this.dbf.setVisibility(0);
                this.dbd.setOnClickListener(new s(this));
            }
            this.dbe = new cb(this.dbm.getPageContext().getContext());
            this.dbe.setMaxHeight(com.baidu.adp.lib.util.k.dip2px(this.dbm.getPageContext().getContext(), 225.0f));
            this.dbe.setOutsideTouchable(true);
            this.dbe.setFocusable(true);
            this.dbe.setBackgroundDrawable(al.getDrawable(i.c.cp_bg_line_b));
            this.dbe.a(new t(this));
            this.dbe.setOnDismissListener(new u(this));
            int color = al.getColor(i.c.write_text);
            al.h((View) this.dbd, i.e.write_prefix_item_selector);
            al.c(this.dbf, i.e.icon_title_down);
            this.dbd.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.dbm.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.dip2px(this.dbm.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                al.h((View) textView, i.e.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.k.dip2px(this.dbm.getPageContext().getContext(), this.dbm.getResources().getDimension(i.d.ds6)), 0, com.baidu.adp.lib.util.k.dip2px(this.dbm.getPageContext().getContext(), this.dbm.getResources().getDimension(i.d.ds22)), 0);
                this.dbe.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(this.dbm.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.k.dip2px(this.dbm.getPageContext().getContext(), this.dbm.getResources().getDimension(i.d.ds6)), 0, com.baidu.adp.lib.util.k.dip2px(this.dbm.getPageContext().getContext(), this.dbm.getResources().getDimension(i.d.ds22)), 0);
                }
            }
            this.dbe.kU(0);
            return;
        }
        this.dbg.setVisibility(8);
    }

    protected void ayP() {
        this.daX = (EditText) this.dbm.findViewById(i.f.post_title);
        if (this.cTs.getType() == 3) {
            if (this.cTs.getTitle() != null && this.cTs.getTitle().trim().length() > 0) {
                this.daX.setText(this.cTs.getTitle());
                this.daX.setSelection(this.cTs.getTitle().length());
            } else {
                String str = String.valueOf(this.dbm.getPageContext().getString(i.h.share_transfer_thread)) + this.cTs.getShareSummaryTitle();
                this.daX.setText(str);
                if (str.length() < 20) {
                    this.daX.setSelection(str.length());
                } else {
                    this.daX.setSelection(20);
                }
            }
        }
        this.daX.addTextChangedListener(new v(this));
    }

    public void ayQ() {
        String str = null;
        if (this.cTs.getType() == 3) {
            String trim = this.daX.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.dbm.ayK() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.cTs.setIsNoTitle(true);
                    } else {
                        this.cTs.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.cTs.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.cTs.setIsNoTitle(true);
            } else {
                this.cTs.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.dbo) {
            this.dbc.setEnabled(false);
        } else {
            this.dbc.setEnabled(true);
        }
    }

    protected void ayR() {
        this.dbb = (EditText) this.dbm.findViewById(i.f.post_content);
        this.dbb.setDrawingCacheEnabled(false);
        if (this.cTs.getContent() != null && this.cTs.getContent().length() > 0) {
            SpannableString H = TbFaceManager.Cr().H(this.dbm.getPageContext().getContext(), this.cTs.getContent());
            this.dbb.setText(H);
            this.dbb.setSelection(H.length());
        }
        this.dbb.setOnTouchListener(new w(this));
        this.dbb.addTextChangedListener(new x(this));
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

    public EditText ayS() {
        return this.daX;
    }

    public EditText akL() {
        return this.dbb;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        ayO();
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.daX.setOnFocusChangeListener(onFocusChangeListener);
        this.dbb.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.dbc.setOnFocusChangeListener(onFocusChangeListener);
    }

    public cb ayT() {
        return this.dbe;
    }

    public View ayU() {
        return this.mBack;
    }

    public TextView ayV() {
        return this.dbc;
    }

    public TextView ayW() {
        return this.dbd;
    }

    public void J(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void K(View.OnClickListener onClickListener) {
        this.dbc.setOnClickListener(onClickListener);
    }

    public void L(View.OnClickListener onClickListener) {
        this.dba.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.dbm != null) {
            this.dbm.getLayoutMode().ad(i == 1);
            this.dbm.getLayoutMode().k(this.boe);
            this.mNavigationBar.onChangeSkinType(this.dbm.getPageContext(), i);
            al.g(this.dbc, i);
            al.i(this.daY, i.c.cp_bg_line_c);
            al.i(this.daZ, i.c.cp_bg_line_c);
            al.i((View) this.daX, i.c.cp_cont_g);
            al.i(this.dbi, i.c.cp_bg_line_e);
            int color = al.getColor(i.c.cp_cont_b);
            int color2 = al.getColor(i.c.cp_cont_e);
            this.daX.setTextColor(color);
            this.dbb.setTextColor(color);
            this.dbk.setTextColor(al.getColor(i.c.cp_cont_b));
            this.dbl.setTextColor(al.getColor(i.c.cp_cont_d));
            a(this.daX, color2);
            a(this.dbb, color2);
            ayQ();
        }
    }

    public ShareSDKImageView ayX() {
        return this.dbj;
    }
}
