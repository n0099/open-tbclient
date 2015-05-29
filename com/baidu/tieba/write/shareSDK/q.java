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
    private TextView cAA;
    private cn cAB;
    private ImageView cAC;
    private View cAD;
    private LinearLayout cAE;
    private LinearLayout cAF;
    private ShareSDKImageView cAG;
    private TextView cAH;
    private TextView cAI;
    private WriteShareActivity cAJ;
    private View cAw;
    private com.baidu.tbadk.img.e cqC;
    private WriteData cuo;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText cAu = null;
    private View cAv = null;
    private LinearLayout cAx = null;
    private EditText cAy = null;
    private TextView cAz = null;
    private RelativeLayout aZJ = null;
    private boolean cAK = false;
    private int width = 0;
    private int height = 0;

    public q(WriteShareActivity writeShareActivity) {
        this.cuo = null;
        this.cAJ = writeShareActivity;
        this.cuo = writeShareActivity.JS();
        if (this.cqC == null) {
            this.cqC = new com.baidu.tbadk.img.e(TbadkCoreApplication.m411getInst().getApp());
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.cAJ.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cAJ.getPageContext().getString(com.baidu.tieba.t.share_navigationbar_title));
        this.cAz = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.cAJ.getPageContext().getString(com.baidu.tieba.t.send_post));
        this.aZJ = (RelativeLayout) this.cAJ.findViewById(com.baidu.tieba.q.parent);
        this.cAv = this.cAJ.findViewById(com.baidu.tieba.q.interval_view);
        this.cAw = this.cAJ.findViewById(com.baidu.tieba.q.prefix_interval_view);
        this.cAE = (LinearLayout) this.cAJ.findViewById(com.baidu.tieba.q.post_share_layout);
        this.cAF = (LinearLayout) this.cAJ.findViewById(com.baidu.tieba.q.post_share_content_layout);
        this.cAG = (ShareSDKImageView) this.cAJ.findViewById(com.baidu.tieba.q.post_share_image);
        this.cAH = (TextView) this.cAJ.findViewById(com.baidu.tieba.q.post_share_title);
        this.cAI = (TextView) this.cAJ.findViewById(com.baidu.tieba.q.post_share_content);
        asE();
        asG();
        this.cAx = (LinearLayout) this.cAJ.findViewById(com.baidu.tieba.q.post_content_container);
        this.cAx.setDrawingCacheEnabled(false);
        this.cAu.setVisibility(0);
        this.cAy.setFilters(new InputFilter[]{new InputFilter.LengthFilter(TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI)});
        asF();
    }

    public void asC() {
        this.cAE = (LinearLayout) this.cAJ.findViewById(com.baidu.tieba.q.post_share_layout);
        this.cAG = (ShareSDKImageView) this.cAJ.findViewById(com.baidu.tieba.q.post_share_image);
        this.cAG.setIsRound(false);
        this.cAG.setDrawBorder(false);
        this.cAG.setAutoChangeStyle(true);
        this.cAG.setRadius(0);
        this.cAH = (TextView) this.cAJ.findViewById(com.baidu.tieba.q.post_share_title);
        this.cAI = (TextView) this.cAJ.findViewById(com.baidu.tieba.q.post_share_content);
        if (this.cuo != null) {
            if (this.cuo.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.cAG.setEvent(new r(this));
            }
            if (this.cuo.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.cuo.getShareSummaryImg() != null && this.cuo.getShareSummaryImg().trim().length() > 0) {
                    this.cAG.c(this.cuo.getShareSummaryImg(), 10, true);
                } else {
                    this.cAK = true;
                    asF();
                }
            } else {
                Bitmap w = com.baidu.tbadk.core.util.c.w(this.cuo.getShareLocalImageData());
                if (w != null) {
                    this.cAG.setImageBitmap(w);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.cuo.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(com.baidu.tbadk.core.util.o.c(TbadkCoreApplication.m411getInst().getApp(), Uri.parse(this.cuo.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.y(bc.tB().tH(), bc.tB().tH()));
                    this.cAG.setTag(imageFileInfo.toCachedKey(true));
                    if (this.cqC.a(imageFileInfo, new s(this), true) != null) {
                        this.cAG.invalidate();
                    }
                }
                this.cAK = true;
                asF();
            }
            this.cuo.setShareSummaryImgType(com.baidu.adp.lib.util.commonsio.b.bc(this.cuo.getShareSummaryImg()));
            this.cAH.setText(this.cuo.getShareSummaryTitle());
            this.cAI.setText(this.cuo.getShareSummaryContent());
        }
    }

    private void asD() {
        this.cAD = this.cAJ.findViewById(com.baidu.tieba.q.post_prefix_layout);
        this.cAA = (TextView) this.cAJ.findViewById(com.baidu.tieba.q.post_prefix);
        this.cAC = (ImageView) this.cAJ.findViewById(com.baidu.tieba.q.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.cAD.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.cAA.setText(prefixs.get(0));
            this.cAJ.ju(0);
            this.cAD.setOnClickListener(new t(this));
            this.cAC = (ImageView) this.cAJ.findViewById(com.baidu.tieba.q.prefix_icon);
            if (size > 1) {
                this.cAC.setVisibility(0);
                this.cAA.setOnClickListener(new u(this));
            }
            this.cAB = new cn(this.cAJ.getPageContext().getContext());
            this.cAB.setMaxHeight(com.baidu.adp.lib.util.n.dip2px(this.cAJ.getPageContext().getContext(), 225.0f));
            this.cAB.setOutsideTouchable(true);
            this.cAB.setFocusable(true);
            this.cAB.setBackgroundDrawable(ay.getDrawable(com.baidu.tieba.n.cp_bg_line_b));
            this.cAB.a(new v(this));
            this.cAB.setOnDismissListener(new w(this));
            int color = ay.getColor(com.baidu.tieba.n.write_text);
            ay.i((View) this.cAA, com.baidu.tieba.p.write_prefix_item_selector);
            ay.c(this.cAC, com.baidu.tieba.p.icon_title_down);
            this.cAA.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.cAJ.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.n.dip2px(this.cAJ.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ay.i((View) textView, com.baidu.tieba.p.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.n.dip2px(this.cAJ.getPageContext().getContext(), this.cAJ.getResources().getDimension(com.baidu.tieba.o.ds6)), 0, com.baidu.adp.lib.util.n.dip2px(this.cAJ.getPageContext().getContext(), this.cAJ.getResources().getDimension(com.baidu.tieba.o.ds22)), 0);
                this.cAB.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.n.dip2px(this.cAJ.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.n.dip2px(this.cAJ.getPageContext().getContext(), this.cAJ.getResources().getDimension(com.baidu.tieba.o.ds6)), 0, com.baidu.adp.lib.util.n.dip2px(this.cAJ.getPageContext().getContext(), this.cAJ.getResources().getDimension(com.baidu.tieba.o.ds22)), 0);
                }
            }
            this.cAB.setCurrentIndex(0);
            return;
        }
        this.cAD.setVisibility(8);
    }

    protected void asE() {
        this.cAu = (EditText) this.cAJ.findViewById(com.baidu.tieba.q.post_title);
        if (this.cuo.getType() == 3) {
            if (this.cuo.getTitle() != null && this.cuo.getTitle().trim().length() > 0) {
                this.cAu.setText(this.cuo.getTitle());
                this.cAu.setSelection(this.cuo.getTitle().length());
            } else {
                String str = String.valueOf(this.cAJ.getPageContext().getString(com.baidu.tieba.t.share_transfer_thread)) + this.cuo.getShareSummaryTitle();
                this.cAu.setText(str);
                if (str.length() < 20) {
                    this.cAu.setSelection(str.length());
                } else {
                    this.cAu.setSelection(20);
                }
            }
        }
        this.cAu.addTextChangedListener(new x(this));
    }

    public void asF() {
        String str = null;
        if (this.cuo.getType() == 3) {
            String trim = this.cAu.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.cAJ.asz() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.cuo.setIsNoTitle(true);
                    } else {
                        this.cuo.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.cuo.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.cuo.setIsNoTitle(true);
            } else {
                this.cuo.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.cAK) {
            this.cAz.setEnabled(false);
        } else {
            this.cAz.setEnabled(true);
        }
    }

    protected void asG() {
        this.cAy = (EditText) this.cAJ.findViewById(com.baidu.tieba.q.post_content);
        this.cAy.setDrawingCacheEnabled(false);
        if (this.cuo.getContent() != null && this.cuo.getContent().length() > 0) {
            SpannableString F = TbFaceManager.Ak().F(this.cAJ.getPageContext().getContext(), this.cuo.getContent());
            this.cAy.setText(F);
            this.cAy.setSelection(F.length());
        }
        this.cAy.setOnTouchListener(new y(this));
        this.cAy.addTextChangedListener(new z(this));
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

    public EditText asH() {
        return this.cAu;
    }

    public EditText asI() {
        return this.cAy;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        asD();
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.cAu.setOnFocusChangeListener(onFocusChangeListener);
        this.cAy.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.cAz.setOnFocusChangeListener(onFocusChangeListener);
    }

    public cn asJ() {
        return this.cAB;
    }

    public View asK() {
        return this.mBack;
    }

    public TextView asL() {
        return this.cAz;
    }

    public TextView asM() {
        return this.cAA;
    }

    public void B(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void C(View.OnClickListener onClickListener) {
        this.cAz.setOnClickListener(onClickListener);
    }

    public void D(View.OnClickListener onClickListener) {
        this.cAx.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.cAJ != null) {
            this.cAJ.getLayoutMode().ab(i == 1);
            this.cAJ.getLayoutMode().j(this.aZJ);
            this.mNavigationBar.onChangeSkinType(this.cAJ.getPageContext(), i);
            ay.g(this.cAz, i);
            ay.j(this.cAv, com.baidu.tieba.n.cp_bg_line_c);
            ay.j(this.cAw, com.baidu.tieba.n.cp_bg_line_c);
            ay.j((View) this.cAu, com.baidu.tieba.n.cp_cont_g);
            ay.j(this.cAF, com.baidu.tieba.n.cp_bg_line_e);
            int color = ay.getColor(com.baidu.tieba.n.cp_cont_b);
            int color2 = ay.getColor(com.baidu.tieba.n.cp_cont_e);
            this.cAu.setTextColor(color);
            this.cAy.setTextColor(color);
            this.cAH.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_b));
            this.cAI.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_d));
            a(this.cAu, color2);
            a(this.cAy, color2);
            asF();
        }
    }

    public ShareSDKImageView asN() {
        return this.cAG;
    }
}
