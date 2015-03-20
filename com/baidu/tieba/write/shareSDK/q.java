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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.ShareSDKImageView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.write.cm;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class q {
    private com.baidu.tbadk.img.e cmn;
    private WriteData cpU;
    private View cvQ;
    private TextView cvU;
    private cm cvV;
    private ImageView cvW;
    private View cvX;
    private LinearLayout cvY;
    private LinearLayout cvZ;
    private ShareSDKImageView cwa;
    private TextView cwb;
    private TextView cwc;
    private WriteShareActivity cwd;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText cvO = null;
    private View cvP = null;
    private LinearLayout cvR = null;
    private EditText cvS = null;
    private TextView cvT = null;
    private RelativeLayout aWN = null;
    private boolean cwe = false;
    private int width = 0;
    private int height = 0;

    public q(WriteShareActivity writeShareActivity) {
        this.cpU = null;
        this.cwd = writeShareActivity;
        this.cpU = writeShareActivity.IM();
        if (this.cmn == null) {
            this.cmn = new com.baidu.tbadk.img.e(TbadkCoreApplication.m411getInst().getApp());
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.cwd.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cwd.getPageContext().getString(com.baidu.tieba.y.share_navigationbar_title));
        this.cvT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.cwd.getPageContext().getString(com.baidu.tieba.y.send_post));
        this.aWN = (RelativeLayout) this.cwd.findViewById(com.baidu.tieba.v.parent);
        this.cvP = this.cwd.findViewById(com.baidu.tieba.v.interval_view);
        this.cvQ = this.cwd.findViewById(com.baidu.tieba.v.prefix_interval_view);
        this.cvY = (LinearLayout) this.cwd.findViewById(com.baidu.tieba.v.post_share_layout);
        this.cvZ = (LinearLayout) this.cwd.findViewById(com.baidu.tieba.v.post_share_content_layout);
        this.cwa = (ShareSDKImageView) this.cwd.findViewById(com.baidu.tieba.v.post_share_image);
        this.cwb = (TextView) this.cwd.findViewById(com.baidu.tieba.v.post_share_title);
        this.cwc = (TextView) this.cwd.findViewById(com.baidu.tieba.v.post_share_content);
        aqz();
        aqB();
        this.cvR = (LinearLayout) this.cwd.findViewById(com.baidu.tieba.v.post_content_container);
        this.cvR.setDrawingCacheEnabled(false);
        this.cvO.setVisibility(0);
        this.cvS.setFilters(new InputFilter[]{new InputFilter.LengthFilter(TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI)});
        aqA();
    }

    public void aqx() {
        this.cvY = (LinearLayout) this.cwd.findViewById(com.baidu.tieba.v.post_share_layout);
        this.cwa = (ShareSDKImageView) this.cwd.findViewById(com.baidu.tieba.v.post_share_image);
        this.cwa.setIsRound(false);
        this.cwa.setDrawBorder(false);
        this.cwa.setAutoChangeStyle(true);
        this.cwa.setRadius(0);
        this.cwb = (TextView) this.cwd.findViewById(com.baidu.tieba.v.post_share_title);
        this.cwc = (TextView) this.cwd.findViewById(com.baidu.tieba.v.post_share_content);
        if (this.cpU != null) {
            if (this.cpU.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.cwa.setEvent(new r(this));
            }
            if (this.cpU.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.cpU.getShareSummaryImg() != null && this.cpU.getShareSummaryImg().trim().length() > 0) {
                    this.cwa.c(this.cpU.getShareSummaryImg(), 10, true);
                } else {
                    this.cwe = true;
                    aqA();
                }
            } else {
                Bitmap w = com.baidu.tbadk.core.util.c.w(this.cpU.getShareLocalImageData());
                if (w != null) {
                    this.cwa.setImageBitmap(w);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.cpU.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(com.baidu.tbadk.core.util.o.c(TbadkCoreApplication.m411getInst().getApp(), Uri.parse(this.cpU.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.x(be.sY().te(), be.sY().te()));
                    this.cwa.setTag(imageFileInfo.toCachedKey(true));
                    if (this.cmn.a(imageFileInfo, new s(this), true) != null) {
                        this.cwa.invalidate();
                    }
                }
                this.cwe = true;
                aqA();
            }
            this.cpU.setShareSummaryImgType(com.baidu.adp.lib.util.commonsio.b.aS(this.cpU.getShareSummaryImg()));
            this.cwb.setText(this.cpU.getShareSummaryTitle());
            this.cwc.setText(this.cpU.getShareSummaryContent());
        }
    }

    private void aqy() {
        this.cvX = this.cwd.findViewById(com.baidu.tieba.v.post_prefix_layout);
        this.cvU = (TextView) this.cwd.findViewById(com.baidu.tieba.v.post_prefix);
        this.cvW = (ImageView) this.cwd.findViewById(com.baidu.tieba.v.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.cvX.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.cvU.setText(prefixs.get(0));
            this.cwd.iV(0);
            this.cvX.setOnClickListener(new t(this));
            this.cvW = (ImageView) this.cwd.findViewById(com.baidu.tieba.v.prefix_icon);
            if (size > 1) {
                this.cvW.setVisibility(0);
                this.cvU.setOnClickListener(new u(this));
            }
            this.cvV = new cm(this.cwd.getPageContext().getContext());
            this.cvV.setMaxHeight(com.baidu.adp.lib.util.n.dip2px(this.cwd.getPageContext().getContext(), 225.0f));
            this.cvV.setOutsideTouchable(true);
            this.cvV.setFocusable(true);
            this.cvV.setBackgroundDrawable(ba.getDrawable(com.baidu.tieba.s.cp_bg_line_b));
            this.cvV.a(new v(this));
            this.cvV.setOnDismissListener(new w(this));
            int color = ba.getColor(com.baidu.tieba.s.write_text);
            ba.i((View) this.cvU, com.baidu.tieba.u.write_prefix_item_selector);
            ba.c(this.cvW, com.baidu.tieba.u.icon_title_down);
            this.cvU.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.cwd.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.n.dip2px(this.cwd.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ba.i((View) textView, com.baidu.tieba.u.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.n.dip2px(this.cwd.getPageContext().getContext(), this.cwd.getResources().getDimension(com.baidu.tieba.t.ds6)), 0, com.baidu.adp.lib.util.n.dip2px(this.cwd.getPageContext().getContext(), this.cwd.getResources().getDimension(com.baidu.tieba.t.ds22)), 0);
                this.cvV.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.n.dip2px(this.cwd.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.n.dip2px(this.cwd.getPageContext().getContext(), this.cwd.getResources().getDimension(com.baidu.tieba.t.ds6)), 0, com.baidu.adp.lib.util.n.dip2px(this.cwd.getPageContext().getContext(), this.cwd.getResources().getDimension(com.baidu.tieba.t.ds22)), 0);
                }
            }
            this.cvV.setCurrentIndex(0);
            return;
        }
        this.cvX.setVisibility(8);
    }

    protected void aqz() {
        this.cvO = (EditText) this.cwd.findViewById(com.baidu.tieba.v.post_title);
        if (this.cpU.getType() == 3) {
            if (this.cpU.getTitle() != null && this.cpU.getTitle().trim().length() > 0) {
                this.cvO.setText(this.cpU.getTitle());
                this.cvO.setSelection(this.cpU.getTitle().length());
            } else {
                String str = String.valueOf(this.cwd.getPageContext().getString(com.baidu.tieba.y.share_transfer_thread)) + this.cpU.getShareSummaryTitle();
                this.cvO.setText(str);
                if (str.length() < 20) {
                    this.cvO.setSelection(str.length());
                } else {
                    this.cvO.setSelection(20);
                }
            }
        }
        this.cvO.addTextChangedListener(new x(this));
    }

    public void aqA() {
        String str = null;
        if (this.cpU.getType() == 3) {
            String trim = this.cvO.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.cwd.aqu() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.cpU.setIsNoTitle(true);
                    } else {
                        this.cpU.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.cpU.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.cpU.setIsNoTitle(true);
            } else {
                this.cpU.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.cwe) {
            this.cvT.setEnabled(false);
        } else {
            this.cvT.setEnabled(true);
        }
    }

    protected void aqB() {
        this.cvS = (EditText) this.cwd.findViewById(com.baidu.tieba.v.post_content);
        this.cvS.setDrawingCacheEnabled(false);
        if (this.cpU.getContent() != null && this.cpU.getContent().length() > 0) {
            SpannableString E = TbFaceManager.zr().E(this.cwd.getPageContext().getContext(), this.cpU.getContent());
            this.cvS.setText(E);
            this.cvS.setSelection(E.length());
        }
        this.cvS.setOnTouchListener(new y(this));
        this.cvS.addTextChangedListener(new z(this));
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

    public EditText aqC() {
        return this.cvO;
    }

    public EditText aqD() {
        return this.cvS;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        aqy();
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.cvO.setOnFocusChangeListener(onFocusChangeListener);
        this.cvS.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.cvT.setOnFocusChangeListener(onFocusChangeListener);
    }

    public cm aqE() {
        return this.cvV;
    }

    public View aqF() {
        return this.mBack;
    }

    public TextView aqG() {
        return this.cvT;
    }

    public TextView aqH() {
        return this.cvU;
    }

    public void C(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void D(View.OnClickListener onClickListener) {
        this.cvT.setOnClickListener(onClickListener);
    }

    public void E(View.OnClickListener onClickListener) {
        this.cvR.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.cwd != null) {
            this.cwd.getLayoutMode().X(i == 1);
            this.cwd.getLayoutMode().h(this.aWN);
            this.mNavigationBar.onChangeSkinType(this.cwd.getPageContext(), i);
            ba.g(this.cvT, i);
            ba.j(this.cvP, com.baidu.tieba.s.cp_bg_line_c);
            ba.j(this.cvQ, com.baidu.tieba.s.cp_bg_line_c);
            ba.j((View) this.cvO, com.baidu.tieba.s.cp_cont_g);
            ba.j(this.cvZ, com.baidu.tieba.s.cp_bg_line_e);
            int color = ba.getColor(com.baidu.tieba.s.cp_cont_b);
            int color2 = ba.getColor(com.baidu.tieba.s.cp_cont_e);
            this.cvO.setTextColor(color);
            this.cvS.setTextColor(color);
            this.cwb.setTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_b));
            this.cwc.setTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_d));
            a(this.cvO, color2);
            a(this.cvS, color2);
            aqA();
        }
    }

    public ShareSDKImageView aqI() {
        return this.cwa;
    }
}
