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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.d;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.h;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class c {
    private WriteData jVD;
    private View jVX;
    private TextView jWb;
    private h jWc;
    private ImageView jWd;
    private View jWe;
    private LinearLayout jWf;
    private LinearLayout jWg;
    private ShareSDKImageView jWh;
    private TextView jWi;
    private TextView jWj;
    private WriteShareActivity jWk;
    private com.baidu.tbadk.img.b jWl;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText jVV = null;
    private View jVW = null;
    private LinearLayout jVY = null;
    private EditText jVZ = null;
    private TextView jWa = null;
    private RelativeLayout hpY = null;
    private boolean jWm = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.jVD = null;
        this.jWk = writeShareActivity;
        this.jVD = writeShareActivity.cGm();
        if (this.jWl == null) {
            this.jWl = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.jWk.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jWk.getPageContext().getString(R.string.share_navigationbar_title));
        this.jWa = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jWk.getPageContext().getString(R.string.send_post));
        this.hpY = (RelativeLayout) this.jWk.findViewById(R.id.parent);
        this.jVW = this.jWk.findViewById(R.id.interval_view);
        this.jVX = this.jWk.findViewById(R.id.prefix_interval_view);
        this.jWf = (LinearLayout) this.jWk.findViewById(R.id.post_share_layout);
        this.jWg = (LinearLayout) this.jWk.findViewById(R.id.post_share_content_layout);
        this.jWh = (ShareSDKImageView) this.jWk.findViewById(R.id.post_share_image);
        this.jWi = (TextView) this.jWk.findViewById(R.id.post_share_title);
        this.jWj = (TextView) this.jWk.findViewById(R.id.post_share_content);
        cGs();
        cGu();
        this.jVY = (LinearLayout) this.jWk.findViewById(R.id.post_content_container);
        this.jVY.setDrawingCacheEnabled(false);
        this.jVV.setVisibility(0);
        this.jVZ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        cGt();
    }

    public void cGq() {
        this.jWf = (LinearLayout) this.jWk.findViewById(R.id.post_share_layout);
        this.jWh = (ShareSDKImageView) this.jWk.findViewById(R.id.post_share_image);
        this.jWh.setIsRound(false);
        this.jWh.setDrawBorder(false);
        this.jWh.setAutoChangeStyle(true);
        this.jWh.setRadius(0);
        this.jWi = (TextView) this.jWk.findViewById(R.id.post_share_title);
        this.jWj = (TextView) this.jWk.findViewById(R.id.post_share_content);
        if (this.jVD != null) {
            if (this.jVD.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.jWh.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.jWh.getLoadedWidth() != 0 && c.this.jWh.getLoadedHeight() != 0) {
                                c.this.width = c.this.jWh.getLoadedWidth();
                                c.this.height = c.this.jWh.getLoadedHeight();
                                if (c.this.jWk != null) {
                                    c.this.jWk.cGm().setShareSummaryImgWidth(c.this.width);
                                    c.this.jWk.cGm().setShareSummaryImgHeight(c.this.height);
                                    c.this.jWm = true;
                                    c.this.cGt();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.jWm = false;
                        c.this.cGt();
                        if (c.this.jWk != null) {
                            c.this.jWk.BU(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.jWm = false;
                        c.this.cGt();
                        if (c.this.jWk != null) {
                            c.this.jWk.BU(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.jVD.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.jVD.getShareSummaryImg() != null && this.jVD.getShareSummaryImg().trim().length() > 0) {
                    this.jWh.startLoad(this.jVD.getShareSummaryImg(), 10, true);
                } else {
                    this.jWm = true;
                    cGt();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.jVD.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.jWh.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.jVD.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(m.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.jVD.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.aJ(ar.aEq().getPostImageSize(), ar.aEq().getPostImageHeightLimit()));
                    this.jWh.setTag(imageFileInfo.toCachedKey(true));
                    if (this.jWl.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.jWf.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.jWh.invalidate();
                    }
                }
                this.jWm = true;
                cGt();
            }
            this.jVD.setShareSummaryImgType(f.getExtension(this.jVD.getShareSummaryImg()));
            this.jWi.setText(this.jVD.getShareSummaryTitle());
            this.jWj.setText(this.jVD.getShareSummaryContent());
        }
    }

    private void cGr() {
        this.jWe = this.jWk.findViewById(R.id.post_prefix_layout);
        this.jWb = (TextView) this.jWk.findViewById(R.id.post_prefix);
        this.jWd = (ImageView) this.jWk.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.jWe.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.jWb.setText(prefixs.get(0));
            this.jWk.BV(0);
            this.jWe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.jWb.setVisibility(0);
                    c.this.jWe.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.jWc, view, l.dip2px(c.this.jWk.getPageContext().getContext(), 15.0f), l.dip2px(c.this.jWk.getPageContext().getContext(), 1.0f));
                    if (c.this.jWk != null) {
                        c.this.jWk.cGp();
                    }
                }
            });
            this.jWd = (ImageView) this.jWk.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.jWd.setVisibility(0);
                this.jWb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.jWb.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.jWc, view, l.dip2px(c.this.jWk.getPageContext().getContext(), 15.0f), l.dip2px(c.this.jWk.getPageContext().getContext(), 1.0f));
                        if (c.this.jWk != null) {
                            c.this.jWk.cGp();
                        }
                    }
                });
            }
            this.jWc = new h(this.jWk.getPageContext().getContext());
            this.jWc.setMaxHeight(l.dip2px(this.jWk.getPageContext().getContext(), 225.0f));
            this.jWc.setOutsideTouchable(true);
            this.jWc.setFocusable(true);
            this.jWc.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_c));
            this.jWc.a(new h.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.h.a
                public void BW(int i) {
                    c.this.jWk.BV(i);
                    c.this.jWb.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.jWc.setCurrentIndex(i);
                    c.this.cGt();
                    g.dismissPopupWindow(c.this.jWc, c.this.jWk.getPageContext().getPageActivity());
                }
            });
            this.jWc.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.jWe.setSelected(false);
                }
            });
            int color = am.getColor(R.color.common_color_10097);
            am.setBackgroundResource(this.jWb, R.drawable.write_prefix_item_selector);
            am.setImageResource(this.jWd, R.drawable.icon_title_down);
            this.jWb.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.jWk.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.jWk.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                am.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.jWk.getPageContext().getContext(), this.jWk.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.jWk.getPageContext().getContext(), this.jWk.getResources().getDimension(R.dimen.ds22)), 0);
                this.jWc.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.jWk.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.jWk.getPageContext().getContext(), this.jWk.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.jWk.getPageContext().getContext(), this.jWk.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.jWc.setCurrentIndex(0);
            return;
        }
        this.jWe.setVisibility(8);
    }

    protected void cGs() {
        this.jVV = (EditText) this.jWk.findViewById(R.id.post_title);
        if (this.jVD.getType() == 3) {
            if (this.jVD.getTitle() != null && this.jVD.getTitle().trim().length() > 0) {
                this.jVV.setText(this.jVD.getTitle());
                this.jVV.setSelection(this.jVD.getTitle().length());
            } else {
                String str = this.jWk.getPageContext().getString(R.string.share_transfer_thread) + this.jVD.getShareSummaryTitle();
                this.jVV.setText(str);
                if (str.length() < 20) {
                    this.jVV.setSelection(str.length());
                } else {
                    this.jVV.setSelection(20);
                }
            }
        }
        this.jVV.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cGt();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void cGt() {
        String str = null;
        if (this.jVD.getType() == 3) {
            String trim = this.jVV.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.jWk.cGn() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.jVD.setIsNoTitle(true);
                    } else {
                        this.jVD.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.jVD.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.jVD.setIsNoTitle(true);
            } else {
                this.jVD.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.jWm) {
            this.jWa.setEnabled(false);
        } else {
            this.jWa.setEnabled(true);
        }
    }

    protected void cGu() {
        this.jVZ = (EditText) this.jWk.findViewById(R.id.post_content);
        this.jVZ.setDrawingCacheEnabled(false);
        if (this.jVD.getContent() != null && this.jVD.getContent().length() > 0) {
            SpannableString aB = TbFaceManager.aNr().aB(this.jWk.getPageContext().getContext(), this.jVD.getContent());
            this.jVZ.setText(aB);
            this.jVZ.setSelection(aB.length());
        }
        this.jVZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.jVZ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cGt();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    private void f(EditText editText, int i) {
        Editable text = editText.getText();
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        editText.setText((CharSequence) null);
        editText.setHintTextColor(i);
        editText.setText(text);
        editText.setSelection(selectionStart, selectionEnd);
    }

    public EditText cGv() {
        return this.jVV;
    }

    public EditText cGw() {
        return this.jVZ;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        cGr();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.jVV.setOnFocusChangeListener(onFocusChangeListener);
        this.jVZ.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.jWa.setOnFocusChangeListener(onFocusChangeListener);
    }

    public h cGx() {
        return this.jWc;
    }

    public View cGy() {
        return this.mBack;
    }

    public TextView cGz() {
        return this.jWa;
    }

    public TextView cGA() {
        return this.jWb;
    }

    public void ab(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ac(View.OnClickListener onClickListener) {
        this.jWa.setOnClickListener(onClickListener);
    }

    public void ad(View.OnClickListener onClickListener) {
        this.jVY.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.jWk != null) {
            this.jWk.getLayoutMode().setNightMode(i == 1);
            this.jWk.getLayoutMode().onModeChanged(this.hpY);
            this.mNavigationBar.onChangeSkinType(this.jWk.getPageContext(), i);
            am.setTopBarCommonFinishButton(this.jWa, i);
            am.setBackgroundColor(this.jVW, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.jVX, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.jVV, R.color.cp_cont_g);
            am.setBackgroundColor(this.jWg, R.color.cp_bg_line_e);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_e);
            this.jVV.setTextColor(color);
            this.jVZ.setTextColor(color);
            this.jWi.setTextColor(am.getColor(R.color.cp_cont_b));
            this.jWj.setTextColor(am.getColor(R.color.cp_cont_d));
            f(this.jVV, color2);
            f(this.jVZ, color2);
            cGt();
        }
    }

    public ShareSDKImageView cGB() {
        return this.jWh;
    }
}
