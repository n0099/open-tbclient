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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.ShareSDKImageView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.write.cn;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class q {
    private TextView cAB;
    private cn cAC;
    private ImageView cAD;
    private View cAE;
    private LinearLayout cAF;
    private LinearLayout cAG;
    private ShareSDKImageView cAH;
    private TextView cAI;
    private TextView cAJ;
    private WriteShareActivity cAK;
    private View cAx;
    private com.baidu.tbadk.img.e cqD;
    private WriteData cup;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText cAv = null;
    private View cAw = null;
    private LinearLayout cAy = null;
    private EditText cAz = null;
    private TextView cAA = null;
    private RelativeLayout aZK = null;
    private boolean cAL = false;
    private int width = 0;
    private int height = 0;

    public q(WriteShareActivity writeShareActivity) {
        this.cup = null;
        this.cAK = writeShareActivity;
        this.cup = writeShareActivity.JT();
        if (this.cqD == null) {
            this.cqD = new com.baidu.tbadk.img.e(TbadkCoreApplication.m411getInst().getApp());
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.cAK.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cAK.getPageContext().getString(com.baidu.tieba.t.share_navigationbar_title));
        this.cAA = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.cAK.getPageContext().getString(com.baidu.tieba.t.send_post));
        this.aZK = (RelativeLayout) this.cAK.findViewById(com.baidu.tieba.q.parent);
        this.cAw = this.cAK.findViewById(com.baidu.tieba.q.interval_view);
        this.cAx = this.cAK.findViewById(com.baidu.tieba.q.prefix_interval_view);
        this.cAF = (LinearLayout) this.cAK.findViewById(com.baidu.tieba.q.post_share_layout);
        this.cAG = (LinearLayout) this.cAK.findViewById(com.baidu.tieba.q.post_share_content_layout);
        this.cAH = (ShareSDKImageView) this.cAK.findViewById(com.baidu.tieba.q.post_share_image);
        this.cAI = (TextView) this.cAK.findViewById(com.baidu.tieba.q.post_share_title);
        this.cAJ = (TextView) this.cAK.findViewById(com.baidu.tieba.q.post_share_content);
        asF();
        asH();
        this.cAy = (LinearLayout) this.cAK.findViewById(com.baidu.tieba.q.post_content_container);
        this.cAy.setDrawingCacheEnabled(false);
        this.cAv.setVisibility(0);
        this.cAz.setFilters(new InputFilter[]{new InputFilter.LengthFilter(TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI)});
        asG();
    }

    public void asD() {
        this.cAF = (LinearLayout) this.cAK.findViewById(com.baidu.tieba.q.post_share_layout);
        this.cAH = (ShareSDKImageView) this.cAK.findViewById(com.baidu.tieba.q.post_share_image);
        this.cAH.setIsRound(false);
        this.cAH.setDrawBorder(false);
        this.cAH.setAutoChangeStyle(true);
        this.cAH.setRadius(0);
        this.cAI = (TextView) this.cAK.findViewById(com.baidu.tieba.q.post_share_title);
        this.cAJ = (TextView) this.cAK.findViewById(com.baidu.tieba.q.post_share_content);
        if (this.cup != null) {
            if (this.cup.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.cAH.setEvent(new r(this));
            }
            if (this.cup.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.cup.getShareSummaryImg() != null && this.cup.getShareSummaryImg().trim().length() > 0) {
                    this.cAH.c(this.cup.getShareSummaryImg(), 10, true);
                } else {
                    this.cAL = true;
                    asG();
                }
            } else {
                Bitmap w = com.baidu.tbadk.core.util.c.w(this.cup.getShareLocalImageData());
                if (w != null) {
                    this.cAH.setImageBitmap(w);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.cup.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(com.baidu.tbadk.core.util.o.c(TbadkCoreApplication.m411getInst().getApp(), Uri.parse(this.cup.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.y(bc.tB().tH(), bc.tB().tH()));
                    this.cAH.setTag(imageFileInfo.toCachedKey(true));
                    if (this.cqD.a(imageFileInfo, new s(this), true) != null) {
                        this.cAH.invalidate();
                    }
                }
                this.cAL = true;
                asG();
            }
            this.cup.setShareSummaryImgType(com.baidu.adp.lib.util.commonsio.b.bc(this.cup.getShareSummaryImg()));
            this.cAI.setText(this.cup.getShareSummaryTitle());
            this.cAJ.setText(this.cup.getShareSummaryContent());
        }
    }

    private void asE() {
        this.cAE = this.cAK.findViewById(com.baidu.tieba.q.post_prefix_layout);
        this.cAB = (TextView) this.cAK.findViewById(com.baidu.tieba.q.post_prefix);
        this.cAD = (ImageView) this.cAK.findViewById(com.baidu.tieba.q.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.cAE.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.cAB.setText(prefixs.get(0));
            this.cAK.ju(0);
            this.cAE.setOnClickListener(new t(this));
            this.cAD = (ImageView) this.cAK.findViewById(com.baidu.tieba.q.prefix_icon);
            if (size > 1) {
                this.cAD.setVisibility(0);
                this.cAB.setOnClickListener(new u(this));
            }
            this.cAC = new cn(this.cAK.getPageContext().getContext());
            this.cAC.setMaxHeight(com.baidu.adp.lib.util.n.dip2px(this.cAK.getPageContext().getContext(), 225.0f));
            this.cAC.setOutsideTouchable(true);
            this.cAC.setFocusable(true);
            this.cAC.setBackgroundDrawable(ay.getDrawable(com.baidu.tieba.n.cp_bg_line_b));
            this.cAC.a(new v(this));
            this.cAC.setOnDismissListener(new w(this));
            int color = ay.getColor(com.baidu.tieba.n.write_text);
            ay.i((View) this.cAB, com.baidu.tieba.p.write_prefix_item_selector);
            ay.c(this.cAD, com.baidu.tieba.p.icon_title_down);
            this.cAB.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.cAK.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.n.dip2px(this.cAK.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ay.i((View) textView, com.baidu.tieba.p.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.n.dip2px(this.cAK.getPageContext().getContext(), this.cAK.getResources().getDimension(com.baidu.tieba.o.ds6)), 0, com.baidu.adp.lib.util.n.dip2px(this.cAK.getPageContext().getContext(), this.cAK.getResources().getDimension(com.baidu.tieba.o.ds22)), 0);
                this.cAC.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.n.dip2px(this.cAK.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.n.dip2px(this.cAK.getPageContext().getContext(), this.cAK.getResources().getDimension(com.baidu.tieba.o.ds6)), 0, com.baidu.adp.lib.util.n.dip2px(this.cAK.getPageContext().getContext(), this.cAK.getResources().getDimension(com.baidu.tieba.o.ds22)), 0);
                }
            }
            this.cAC.setCurrentIndex(0);
            return;
        }
        this.cAE.setVisibility(8);
    }

    protected void asF() {
        this.cAv = (EditText) this.cAK.findViewById(com.baidu.tieba.q.post_title);
        if (this.cup.getType() == 3) {
            if (this.cup.getTitle() != null && this.cup.getTitle().trim().length() > 0) {
                this.cAv.setText(this.cup.getTitle());
                this.cAv.setSelection(this.cup.getTitle().length());
            } else {
                String str = String.valueOf(this.cAK.getPageContext().getString(com.baidu.tieba.t.share_transfer_thread)) + this.cup.getShareSummaryTitle();
                this.cAv.setText(str);
                if (str.length() < 20) {
                    this.cAv.setSelection(str.length());
                } else {
                    this.cAv.setSelection(20);
                }
            }
        }
        this.cAv.addTextChangedListener(new x(this));
    }

    public void asG() {
        String str = null;
        if (this.cup.getType() == 3) {
            String trim = this.cAv.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.cAK.asA() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.cup.setIsNoTitle(true);
                    } else {
                        this.cup.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.cup.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.cup.setIsNoTitle(true);
            } else {
                this.cup.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.cAL) {
            this.cAA.setEnabled(false);
        } else {
            this.cAA.setEnabled(true);
        }
    }

    protected void asH() {
        this.cAz = (EditText) this.cAK.findViewById(com.baidu.tieba.q.post_content);
        this.cAz.setDrawingCacheEnabled(false);
        if (this.cup.getContent() != null && this.cup.getContent().length() > 0) {
            SpannableString F = TbFaceManager.Al().F(this.cAK.getPageContext().getContext(), this.cup.getContent());
            this.cAz.setText(F);
            this.cAz.setSelection(F.length());
        }
        this.cAz.setOnTouchListener(new y(this));
        this.cAz.addTextChangedListener(new z(this));
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

    public EditText asI() {
        return this.cAv;
    }

    public EditText asJ() {
        return this.cAz;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        asE();
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.cAv.setOnFocusChangeListener(onFocusChangeListener);
        this.cAz.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.cAA.setOnFocusChangeListener(onFocusChangeListener);
    }

    public cn asK() {
        return this.cAC;
    }

    public View asL() {
        return this.mBack;
    }

    public TextView asM() {
        return this.cAA;
    }

    public TextView asN() {
        return this.cAB;
    }

    public void B(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void C(View.OnClickListener onClickListener) {
        this.cAA.setOnClickListener(onClickListener);
    }

    public void D(View.OnClickListener onClickListener) {
        this.cAy.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.cAK != null) {
            this.cAK.getLayoutMode().ab(i == 1);
            this.cAK.getLayoutMode().j(this.aZK);
            this.mNavigationBar.onChangeSkinType(this.cAK.getPageContext(), i);
            ay.g(this.cAA, i);
            ay.j(this.cAw, com.baidu.tieba.n.cp_bg_line_c);
            ay.j(this.cAx, com.baidu.tieba.n.cp_bg_line_c);
            ay.j((View) this.cAv, com.baidu.tieba.n.cp_cont_g);
            ay.j(this.cAG, com.baidu.tieba.n.cp_bg_line_e);
            int color = ay.getColor(com.baidu.tieba.n.cp_cont_b);
            int color2 = ay.getColor(com.baidu.tieba.n.cp_cont_e);
            this.cAv.setTextColor(color);
            this.cAz.setTextColor(color);
            this.cAI.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_b));
            this.cAJ.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_d));
            a(this.cAv, color2);
            a(this.cAz, color2);
            asG();
        }
    }

    public ShareSDKImageView asO() {
        return this.cAH;
    }
}
