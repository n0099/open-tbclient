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
    private WriteData jVI;
    private View jWc;
    private TextView jWg;
    private h jWh;
    private ImageView jWi;
    private View jWj;
    private LinearLayout jWk;
    private LinearLayout jWl;
    private ShareSDKImageView jWm;
    private TextView jWn;
    private TextView jWo;
    private WriteShareActivity jWp;
    private com.baidu.tbadk.img.b jWq;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText jWa = null;
    private View jWb = null;
    private LinearLayout jWd = null;
    private EditText jWe = null;
    private TextView jWf = null;
    private RelativeLayout hpY = null;
    private boolean jWr = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.jVI = null;
        this.jWp = writeShareActivity;
        this.jVI = writeShareActivity.cGo();
        if (this.jWq == null) {
            this.jWq = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.jWp.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jWp.getPageContext().getString(R.string.share_navigationbar_title));
        this.jWf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jWp.getPageContext().getString(R.string.send_post));
        this.hpY = (RelativeLayout) this.jWp.findViewById(R.id.parent);
        this.jWb = this.jWp.findViewById(R.id.interval_view);
        this.jWc = this.jWp.findViewById(R.id.prefix_interval_view);
        this.jWk = (LinearLayout) this.jWp.findViewById(R.id.post_share_layout);
        this.jWl = (LinearLayout) this.jWp.findViewById(R.id.post_share_content_layout);
        this.jWm = (ShareSDKImageView) this.jWp.findViewById(R.id.post_share_image);
        this.jWn = (TextView) this.jWp.findViewById(R.id.post_share_title);
        this.jWo = (TextView) this.jWp.findViewById(R.id.post_share_content);
        cGu();
        cGw();
        this.jWd = (LinearLayout) this.jWp.findViewById(R.id.post_content_container);
        this.jWd.setDrawingCacheEnabled(false);
        this.jWa.setVisibility(0);
        this.jWe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        cGv();
    }

    public void cGs() {
        this.jWk = (LinearLayout) this.jWp.findViewById(R.id.post_share_layout);
        this.jWm = (ShareSDKImageView) this.jWp.findViewById(R.id.post_share_image);
        this.jWm.setIsRound(false);
        this.jWm.setDrawBorder(false);
        this.jWm.setAutoChangeStyle(true);
        this.jWm.setRadius(0);
        this.jWn = (TextView) this.jWp.findViewById(R.id.post_share_title);
        this.jWo = (TextView) this.jWp.findViewById(R.id.post_share_content);
        if (this.jVI != null) {
            if (this.jVI.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.jWm.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.jWm.getLoadedWidth() != 0 && c.this.jWm.getLoadedHeight() != 0) {
                                c.this.width = c.this.jWm.getLoadedWidth();
                                c.this.height = c.this.jWm.getLoadedHeight();
                                if (c.this.jWp != null) {
                                    c.this.jWp.cGo().setShareSummaryImgWidth(c.this.width);
                                    c.this.jWp.cGo().setShareSummaryImgHeight(c.this.height);
                                    c.this.jWr = true;
                                    c.this.cGv();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.jWr = false;
                        c.this.cGv();
                        if (c.this.jWp != null) {
                            c.this.jWp.BU(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.jWr = false;
                        c.this.cGv();
                        if (c.this.jWp != null) {
                            c.this.jWp.BU(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.jVI.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.jVI.getShareSummaryImg() != null && this.jVI.getShareSummaryImg().trim().length() > 0) {
                    this.jWm.startLoad(this.jVI.getShareSummaryImg(), 10, true);
                } else {
                    this.jWr = true;
                    cGv();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.jVI.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.jWm.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.jVI.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(m.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.jVI.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.aJ(ar.aEq().getPostImageSize(), ar.aEq().getPostImageHeightLimit()));
                    this.jWm.setTag(imageFileInfo.toCachedKey(true));
                    if (this.jWq.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.jWk.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.jWm.invalidate();
                    }
                }
                this.jWr = true;
                cGv();
            }
            this.jVI.setShareSummaryImgType(f.getExtension(this.jVI.getShareSummaryImg()));
            this.jWn.setText(this.jVI.getShareSummaryTitle());
            this.jWo.setText(this.jVI.getShareSummaryContent());
        }
    }

    private void cGt() {
        this.jWj = this.jWp.findViewById(R.id.post_prefix_layout);
        this.jWg = (TextView) this.jWp.findViewById(R.id.post_prefix);
        this.jWi = (ImageView) this.jWp.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.jWj.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.jWg.setText(prefixs.get(0));
            this.jWp.BV(0);
            this.jWj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.jWg.setVisibility(0);
                    c.this.jWj.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.jWh, view, l.dip2px(c.this.jWp.getPageContext().getContext(), 15.0f), l.dip2px(c.this.jWp.getPageContext().getContext(), 1.0f));
                    if (c.this.jWp != null) {
                        c.this.jWp.cGr();
                    }
                }
            });
            this.jWi = (ImageView) this.jWp.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.jWi.setVisibility(0);
                this.jWg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.jWg.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.jWh, view, l.dip2px(c.this.jWp.getPageContext().getContext(), 15.0f), l.dip2px(c.this.jWp.getPageContext().getContext(), 1.0f));
                        if (c.this.jWp != null) {
                            c.this.jWp.cGr();
                        }
                    }
                });
            }
            this.jWh = new h(this.jWp.getPageContext().getContext());
            this.jWh.setMaxHeight(l.dip2px(this.jWp.getPageContext().getContext(), 225.0f));
            this.jWh.setOutsideTouchable(true);
            this.jWh.setFocusable(true);
            this.jWh.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_c));
            this.jWh.a(new h.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.h.a
                public void BW(int i) {
                    c.this.jWp.BV(i);
                    c.this.jWg.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.jWh.setCurrentIndex(i);
                    c.this.cGv();
                    g.dismissPopupWindow(c.this.jWh, c.this.jWp.getPageContext().getPageActivity());
                }
            });
            this.jWh.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.jWj.setSelected(false);
                }
            });
            int color = am.getColor(R.color.common_color_10097);
            am.setBackgroundResource(this.jWg, R.drawable.write_prefix_item_selector);
            am.setImageResource(this.jWi, R.drawable.icon_title_down);
            this.jWg.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.jWp.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.jWp.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                am.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.jWp.getPageContext().getContext(), this.jWp.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.jWp.getPageContext().getContext(), this.jWp.getResources().getDimension(R.dimen.ds22)), 0);
                this.jWh.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.jWp.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.jWp.getPageContext().getContext(), this.jWp.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.jWp.getPageContext().getContext(), this.jWp.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.jWh.setCurrentIndex(0);
            return;
        }
        this.jWj.setVisibility(8);
    }

    protected void cGu() {
        this.jWa = (EditText) this.jWp.findViewById(R.id.post_title);
        if (this.jVI.getType() == 3) {
            if (this.jVI.getTitle() != null && this.jVI.getTitle().trim().length() > 0) {
                this.jWa.setText(this.jVI.getTitle());
                this.jWa.setSelection(this.jVI.getTitle().length());
            } else {
                String str = this.jWp.getPageContext().getString(R.string.share_transfer_thread) + this.jVI.getShareSummaryTitle();
                this.jWa.setText(str);
                if (str.length() < 20) {
                    this.jWa.setSelection(str.length());
                } else {
                    this.jWa.setSelection(20);
                }
            }
        }
        this.jWa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cGv();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void cGv() {
        String str = null;
        if (this.jVI.getType() == 3) {
            String trim = this.jWa.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.jWp.cGp() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.jVI.setIsNoTitle(true);
                    } else {
                        this.jVI.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.jVI.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.jVI.setIsNoTitle(true);
            } else {
                this.jVI.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.jWr) {
            this.jWf.setEnabled(false);
        } else {
            this.jWf.setEnabled(true);
        }
    }

    protected void cGw() {
        this.jWe = (EditText) this.jWp.findViewById(R.id.post_content);
        this.jWe.setDrawingCacheEnabled(false);
        if (this.jVI.getContent() != null && this.jVI.getContent().length() > 0) {
            SpannableString aB = TbFaceManager.aNr().aB(this.jWp.getPageContext().getContext(), this.jVI.getContent());
            this.jWe.setText(aB);
            this.jWe.setSelection(aB.length());
        }
        this.jWe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.jWe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cGv();
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

    public EditText cGx() {
        return this.jWa;
    }

    public EditText cGy() {
        return this.jWe;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        cGt();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.jWa.setOnFocusChangeListener(onFocusChangeListener);
        this.jWe.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.jWf.setOnFocusChangeListener(onFocusChangeListener);
    }

    public h cGz() {
        return this.jWh;
    }

    public View cGA() {
        return this.mBack;
    }

    public TextView cGB() {
        return this.jWf;
    }

    public TextView cGC() {
        return this.jWg;
    }

    public void ab(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ac(View.OnClickListener onClickListener) {
        this.jWf.setOnClickListener(onClickListener);
    }

    public void ad(View.OnClickListener onClickListener) {
        this.jWd.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.jWp != null) {
            this.jWp.getLayoutMode().setNightMode(i == 1);
            this.jWp.getLayoutMode().onModeChanged(this.hpY);
            this.mNavigationBar.onChangeSkinType(this.jWp.getPageContext(), i);
            am.setTopBarCommonFinishButton(this.jWf, i);
            am.setBackgroundColor(this.jWb, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.jWc, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.jWa, R.color.cp_cont_g);
            am.setBackgroundColor(this.jWl, R.color.cp_bg_line_e);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_e);
            this.jWa.setTextColor(color);
            this.jWe.setTextColor(color);
            this.jWn.setTextColor(am.getColor(R.color.cp_cont_b));
            this.jWo.setTextColor(am.getColor(R.color.cp_cont_d));
            f(this.jWa, color2);
            f(this.jWe, color2);
            cGv();
        }
    }

    public ShareSDKImageView cGD() {
        return this.jWm;
    }
}
