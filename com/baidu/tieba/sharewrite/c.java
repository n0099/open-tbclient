package com.baidu.tieba.sharewrite;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.d;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.i;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes24.dex */
public class c {
    private View mMA;
    private TextView mMD;
    private i mME;
    private ImageView mMF;
    private View mMG;
    private LinearLayout mMH;
    private LinearLayout mMI;
    private ShareSDKImageView mMJ;
    private TextView mMK;
    private TextView mML;
    private WriteShareActivity mMM;
    private com.baidu.tbadk.img.b mMN;
    private WriteData mMg;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText mMy = null;
    private View mMz = null;
    private LinearLayout mMB = null;
    private EditText mMC = null;
    private TextView lwH = null;
    private RelativeLayout jVp = null;
    private boolean mMO = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mMg = null;
        this.mMM = writeShareActivity;
        this.mMg = writeShareActivity.cXW();
        if (this.mMN == null) {
            this.mMN = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.mMM.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mMM.getPageContext().getString(R.string.share_navigationbar_title));
        this.lwH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mMM.getPageContext().getString(R.string.send_post));
        this.jVp = (RelativeLayout) this.mMM.findViewById(R.id.parent);
        this.mMz = this.mMM.findViewById(R.id.interval_view);
        this.mMA = this.mMM.findViewById(R.id.prefix_interval_view);
        this.mMH = (LinearLayout) this.mMM.findViewById(R.id.post_share_layout);
        this.mMI = (LinearLayout) this.mMM.findViewById(R.id.post_share_content_layout);
        this.mMJ = (ShareSDKImageView) this.mMM.findViewById(R.id.post_share_image);
        this.mMK = (TextView) this.mMM.findViewById(R.id.post_share_title);
        this.mML = (TextView) this.mMM.findViewById(R.id.post_share_content);
        dGz();
        dGB();
        this.mMB = (LinearLayout) this.mMM.findViewById(R.id.post_content_container);
        this.mMB.setDrawingCacheEnabled(false);
        this.mMy.setVisibility(0);
        this.mMC.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        dGA();
    }

    public void dGx() {
        this.mMH = (LinearLayout) this.mMM.findViewById(R.id.post_share_layout);
        this.mMJ = (ShareSDKImageView) this.mMM.findViewById(R.id.post_share_image);
        this.mMJ.setIsRound(false);
        this.mMJ.setDrawBorder(false);
        this.mMJ.setAutoChangeStyle(true);
        this.mMJ.setRadius(0);
        this.mMK = (TextView) this.mMM.findViewById(R.id.post_share_title);
        this.mML = (TextView) this.mMM.findViewById(R.id.post_share_content);
        if (this.mMg != null) {
            if (this.mMg.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.mMJ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.mMJ.getLoadedWidth() != 0 && c.this.mMJ.getLoadedHeight() != 0) {
                                c.this.width = c.this.mMJ.getLoadedWidth();
                                c.this.height = c.this.mMJ.getLoadedHeight();
                                if (c.this.mMM != null) {
                                    c.this.mMM.cXW().setShareSummaryImgWidth(c.this.width);
                                    c.this.mMM.cXW().setShareSummaryImgHeight(c.this.height);
                                    c.this.mMO = true;
                                    c.this.dGA();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.mMO = false;
                        c.this.dGA();
                        if (c.this.mMM != null) {
                            c.this.mMM.Jf(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.mMO = false;
                        c.this.dGA();
                        if (c.this.mMM != null) {
                            c.this.mMM.Jf(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mMg.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mMg.getShareSummaryImg() != null && this.mMg.getShareSummaryImg().trim().length() > 0) {
                    this.mMJ.startLoad(this.mMg.getShareSummaryImg(), 10, true);
                } else {
                    this.mMO = true;
                    dGA();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mMg.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.mMJ.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mMg.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mMg.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.bg(au.bro().getPostImageSize(), au.bro().getPostImageHeightLimit()));
                    this.mMJ.setTag(imageFileInfo.toCachedKey(true));
                    if (this.mMN.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.mMH.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.mMJ.invalidate();
                    }
                }
                this.mMO = true;
                dGA();
            }
            this.mMg.setShareSummaryImgType(f.getExtension(this.mMg.getShareSummaryImg()));
            this.mMK.setText(this.mMg.getShareSummaryTitle());
            this.mML.setText(this.mMg.getShareSummaryContent());
        }
    }

    private void dGy() {
        this.mMG = this.mMM.findViewById(R.id.post_prefix_layout);
        this.mMD = (TextView) this.mMM.findViewById(R.id.post_prefix);
        this.mMF = (ImageView) this.mMM.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mMG.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.mMD.setText(prefixs.get(0));
            this.mMM.Jg(0);
            this.mMG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mMD.setVisibility(0);
                    c.this.mMG.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.mME, view, l.dip2px(c.this.mMM.getPageContext().getContext(), 15.0f), l.dip2px(c.this.mMM.getPageContext().getContext(), 1.0f));
                    if (c.this.mMM != null) {
                        c.this.mMM.dGw();
                    }
                }
            });
            this.mMF = (ImageView) this.mMM.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.mMF.setVisibility(0);
                this.mMD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.mMD.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.mME, view, l.dip2px(c.this.mMM.getPageContext().getContext(), 15.0f), l.dip2px(c.this.mMM.getPageContext().getContext(), 1.0f));
                        if (c.this.mMM != null) {
                            c.this.mMM.dGw();
                        }
                    }
                });
            }
            this.mME = new i(this.mMM.getPageContext().getContext());
            this.mME.setMaxHeight(l.dip2px(this.mMM.getPageContext().getContext(), 225.0f));
            this.mME.setOutsideTouchable(true);
            this.mME.setFocusable(true);
            this.mME.setBackgroundDrawable(ap.getDrawable(R.color.cp_bg_line_c));
            this.mME.a(new i.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.i.a
                public void Jh(int i) {
                    c.this.mMM.Jg(i);
                    c.this.mMD.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.mME.setCurrentIndex(i);
                    c.this.dGA();
                    g.dismissPopupWindow(c.this.mME, c.this.mMM.getPageContext().getPageActivity());
                }
            });
            this.mME.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.mMG.setSelected(false);
                }
            });
            int color = ap.getColor(R.color.common_color_10097);
            ap.setBackgroundResource(this.mMD, R.drawable.write_prefix_item_selector);
            ap.setImageResource(this.mMF, R.drawable.icon_title_down);
            this.mMD.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.mMM.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.mMM.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ap.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.mMM.getPageContext().getContext(), this.mMM.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.mMM.getPageContext().getContext(), this.mMM.getResources().getDimension(R.dimen.ds22)), 0);
                this.mME.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.mMM.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.mMM.getPageContext().getContext(), this.mMM.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.mMM.getPageContext().getContext(), this.mMM.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.mME.setCurrentIndex(0);
            return;
        }
        this.mMG.setVisibility(8);
    }

    protected void dGz() {
        this.mMy = (EditText) this.mMM.findViewById(R.id.post_title);
        if (this.mMg.getType() == 3) {
            if (this.mMg.getTitle() != null && this.mMg.getTitle().trim().length() > 0) {
                this.mMy.setText(this.mMg.getTitle());
                this.mMy.setSelection(this.mMg.getTitle().length());
            } else {
                String str = this.mMM.getPageContext().getString(R.string.share_transfer_thread) + this.mMg.getShareSummaryTitle();
                this.mMy.setText(str);
                if (str.length() < 20) {
                    this.mMy.setSelection(str.length());
                } else {
                    this.mMy.setSelection(20);
                }
            }
        }
        this.mMy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dGA();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void dGA() {
        String str = null;
        if (this.mMg.getType() == 3) {
            String trim = this.mMy.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.mMM.dGu() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.mMg.setIsNoTitle(true);
                    } else {
                        this.mMg.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.mMg.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.mMg.setIsNoTitle(true);
            } else {
                this.mMg.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.mMO) {
            this.lwH.setEnabled(false);
        } else {
            this.lwH.setEnabled(true);
        }
    }

    protected void dGB() {
        this.mMC = (EditText) this.mMM.findViewById(R.id.post_content);
        this.mMC.setDrawingCacheEnabled(false);
        if (this.mMg.getContent() != null && this.mMg.getContent().length() > 0) {
            SpannableString aw = TbFaceManager.bBc().aw(this.mMM.getPageContext().getContext(), this.mMg.getContent());
            this.mMC.setText(aw);
            this.mMC.setSelection(aw.length());
        }
        this.mMC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.mMC.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dGA();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    private void h(EditText editText, int i) {
        Editable text = editText.getText();
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        editText.setText((CharSequence) null);
        editText.setHintTextColor(i);
        editText.setText(text);
        editText.setSelection(selectionStart, selectionEnd);
    }

    public EditText dGC() {
        return this.mMy;
    }

    public EditText dGD() {
        return this.mMC;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        dGy();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.mMy.setOnFocusChangeListener(onFocusChangeListener);
        this.mMC.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.lwH.setOnFocusChangeListener(onFocusChangeListener);
    }

    public i dGE() {
        return this.mME;
    }

    public View dGF() {
        return this.mBack;
    }

    public TextView dGG() {
        return this.lwH;
    }

    public TextView dGH() {
        return this.mMD;
    }

    public void af(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ag(View.OnClickListener onClickListener) {
        this.lwH.setOnClickListener(onClickListener);
    }

    public void ah(View.OnClickListener onClickListener) {
        this.mMB.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.mMM != null) {
            this.mMM.getLayoutMode().setNightMode(i == 1);
            this.mMM.getLayoutMode().onModeChanged(this.jVp);
            this.mNavigationBar.onChangeSkinType(this.mMM.getPageContext(), i);
            ap.setTopBarCommonFinishButton(this.lwH, i);
            ap.setBackgroundColor(this.mMz, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.mMA, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.mMy, R.color.cp_cont_g);
            ap.setBackgroundColor(this.mMI, R.color.cp_bg_line_e);
            int color = ap.getColor(R.color.cp_cont_b);
            int color2 = ap.getColor(R.color.cp_cont_e);
            this.mMy.setTextColor(color);
            this.mMC.setTextColor(color);
            this.mMK.setTextColor(ap.getColor(R.color.cp_cont_b));
            this.mML.setTextColor(ap.getColor(R.color.cp_cont_d));
            h(this.mMy, color2);
            h(this.mMC, color2);
            dGA();
        }
    }

    public ShareSDKImageView dGI() {
        return this.mMJ;
    }
}
