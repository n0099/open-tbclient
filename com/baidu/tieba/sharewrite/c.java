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
/* loaded from: classes11.dex */
public class c {
    private WriteData kHI;
    private View kIc;
    private TextView kIg;
    private h kIh;
    private ImageView kIi;
    private View kIj;
    private LinearLayout kIk;
    private LinearLayout kIl;
    private ShareSDKImageView kIm;
    private TextView kIn;
    private TextView kIo;
    private WriteShareActivity kIp;
    private com.baidu.tbadk.img.b kIq;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText kIa = null;
    private View kIb = null;
    private LinearLayout kId = null;
    private EditText kIe = null;
    private TextView kIf = null;
    private RelativeLayout idy = null;
    private boolean kIr = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.kHI = null;
        this.kIp = writeShareActivity;
        this.kHI = writeShareActivity.cSN();
        if (this.kIq == null) {
            this.kIq = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.kIp.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.kIp.getPageContext().getString(R.string.share_navigationbar_title));
        this.kIf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kIp.getPageContext().getString(R.string.send_post));
        this.idy = (RelativeLayout) this.kIp.findViewById(R.id.parent);
        this.kIb = this.kIp.findViewById(R.id.interval_view);
        this.kIc = this.kIp.findViewById(R.id.prefix_interval_view);
        this.kIk = (LinearLayout) this.kIp.findViewById(R.id.post_share_layout);
        this.kIl = (LinearLayout) this.kIp.findViewById(R.id.post_share_content_layout);
        this.kIm = (ShareSDKImageView) this.kIp.findViewById(R.id.post_share_image);
        this.kIn = (TextView) this.kIp.findViewById(R.id.post_share_title);
        this.kIo = (TextView) this.kIp.findViewById(R.id.post_share_content);
        cST();
        cSV();
        this.kId = (LinearLayout) this.kIp.findViewById(R.id.post_content_container);
        this.kId.setDrawingCacheEnabled(false);
        this.kIa.setVisibility(0);
        this.kIe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        cSU();
    }

    public void cSR() {
        this.kIk = (LinearLayout) this.kIp.findViewById(R.id.post_share_layout);
        this.kIm = (ShareSDKImageView) this.kIp.findViewById(R.id.post_share_image);
        this.kIm.setIsRound(false);
        this.kIm.setDrawBorder(false);
        this.kIm.setAutoChangeStyle(true);
        this.kIm.setRadius(0);
        this.kIn = (TextView) this.kIp.findViewById(R.id.post_share_title);
        this.kIo = (TextView) this.kIp.findViewById(R.id.post_share_content);
        if (this.kHI != null) {
            if (this.kHI.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.kIm.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.kIm.getLoadedWidth() != 0 && c.this.kIm.getLoadedHeight() != 0) {
                                c.this.width = c.this.kIm.getLoadedWidth();
                                c.this.height = c.this.kIm.getLoadedHeight();
                                if (c.this.kIp != null) {
                                    c.this.kIp.cSN().setShareSummaryImgWidth(c.this.width);
                                    c.this.kIp.cSN().setShareSummaryImgHeight(c.this.height);
                                    c.this.kIr = true;
                                    c.this.cSU();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.kIr = false;
                        c.this.cSU();
                        if (c.this.kIp != null) {
                            c.this.kIp.CJ(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.kIr = false;
                        c.this.cSU();
                        if (c.this.kIp != null) {
                            c.this.kIp.CJ(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.kHI.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.kHI.getShareSummaryImg() != null && this.kHI.getShareSummaryImg().trim().length() > 0) {
                    this.kIm.startLoad(this.kHI.getShareSummaryImg(), 10, true);
                } else {
                    this.kIr = true;
                    cSU();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.kHI.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.kIm.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.kHI.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(m.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.kHI.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.aO(ar.aOV().getPostImageSize(), ar.aOV().getPostImageHeightLimit()));
                    this.kIm.setTag(imageFileInfo.toCachedKey(true));
                    if (this.kIq.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.kIk.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.kIm.invalidate();
                    }
                }
                this.kIr = true;
                cSU();
            }
            this.kHI.setShareSummaryImgType(f.getExtension(this.kHI.getShareSummaryImg()));
            this.kIn.setText(this.kHI.getShareSummaryTitle());
            this.kIo.setText(this.kHI.getShareSummaryContent());
        }
    }

    private void cSS() {
        this.kIj = this.kIp.findViewById(R.id.post_prefix_layout);
        this.kIg = (TextView) this.kIp.findViewById(R.id.post_prefix);
        this.kIi = (ImageView) this.kIp.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.kIj.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.kIg.setText(prefixs.get(0));
            this.kIp.CK(0);
            this.kIj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.kIg.setVisibility(0);
                    c.this.kIj.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.kIh, view, l.dip2px(c.this.kIp.getPageContext().getContext(), 15.0f), l.dip2px(c.this.kIp.getPageContext().getContext(), 1.0f));
                    if (c.this.kIp != null) {
                        c.this.kIp.cSQ();
                    }
                }
            });
            this.kIi = (ImageView) this.kIp.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.kIi.setVisibility(0);
                this.kIg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.kIg.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.kIh, view, l.dip2px(c.this.kIp.getPageContext().getContext(), 15.0f), l.dip2px(c.this.kIp.getPageContext().getContext(), 1.0f));
                        if (c.this.kIp != null) {
                            c.this.kIp.cSQ();
                        }
                    }
                });
            }
            this.kIh = new h(this.kIp.getPageContext().getContext());
            this.kIh.setMaxHeight(l.dip2px(this.kIp.getPageContext().getContext(), 225.0f));
            this.kIh.setOutsideTouchable(true);
            this.kIh.setFocusable(true);
            this.kIh.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_c));
            this.kIh.a(new h.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.h.a
                public void CL(int i) {
                    c.this.kIp.CK(i);
                    c.this.kIg.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.kIh.setCurrentIndex(i);
                    c.this.cSU();
                    g.dismissPopupWindow(c.this.kIh, c.this.kIp.getPageContext().getPageActivity());
                }
            });
            this.kIh.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.kIj.setSelected(false);
                }
            });
            int color = am.getColor(R.color.common_color_10097);
            am.setBackgroundResource(this.kIg, R.drawable.write_prefix_item_selector);
            am.setImageResource(this.kIi, R.drawable.icon_title_down);
            this.kIg.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.kIp.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.kIp.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                am.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.kIp.getPageContext().getContext(), this.kIp.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.kIp.getPageContext().getContext(), this.kIp.getResources().getDimension(R.dimen.ds22)), 0);
                this.kIh.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.kIp.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.kIp.getPageContext().getContext(), this.kIp.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.kIp.getPageContext().getContext(), this.kIp.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.kIh.setCurrentIndex(0);
            return;
        }
        this.kIj.setVisibility(8);
    }

    protected void cST() {
        this.kIa = (EditText) this.kIp.findViewById(R.id.post_title);
        if (this.kHI.getType() == 3) {
            if (this.kHI.getTitle() != null && this.kHI.getTitle().trim().length() > 0) {
                this.kIa.setText(this.kHI.getTitle());
                this.kIa.setSelection(this.kHI.getTitle().length());
            } else {
                String str = this.kIp.getPageContext().getString(R.string.share_transfer_thread) + this.kHI.getShareSummaryTitle();
                this.kIa.setText(str);
                if (str.length() < 20) {
                    this.kIa.setSelection(str.length());
                } else {
                    this.kIa.setSelection(20);
                }
            }
        }
        this.kIa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cSU();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void cSU() {
        String str = null;
        if (this.kHI.getType() == 3) {
            String trim = this.kIa.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.kIp.cSO() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.kHI.setIsNoTitle(true);
                    } else {
                        this.kHI.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.kHI.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.kHI.setIsNoTitle(true);
            } else {
                this.kHI.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.kIr) {
            this.kIf.setEnabled(false);
        } else {
            this.kIf.setEnabled(true);
        }
    }

    protected void cSV() {
        this.kIe = (EditText) this.kIp.findViewById(R.id.post_content);
        this.kIe.setDrawingCacheEnabled(false);
        if (this.kHI.getContent() != null && this.kHI.getContent().length() > 0) {
            SpannableString av = TbFaceManager.aYl().av(this.kIp.getPageContext().getContext(), this.kHI.getContent());
            this.kIe.setText(av);
            this.kIe.setSelection(av.length());
        }
        this.kIe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.kIe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cSU();
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

    public EditText cSW() {
        return this.kIa;
    }

    public EditText cSX() {
        return this.kIe;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        cSS();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.kIa.setOnFocusChangeListener(onFocusChangeListener);
        this.kIe.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.kIf.setOnFocusChangeListener(onFocusChangeListener);
    }

    public h cSY() {
        return this.kIh;
    }

    public View cSZ() {
        return this.mBack;
    }

    public TextView cTa() {
        return this.kIf;
    }

    public TextView cTb() {
        return this.kIg;
    }

    public void ac(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ad(View.OnClickListener onClickListener) {
        this.kIf.setOnClickListener(onClickListener);
    }

    public void ae(View.OnClickListener onClickListener) {
        this.kId.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.kIp != null) {
            this.kIp.getLayoutMode().setNightMode(i == 1);
            this.kIp.getLayoutMode().onModeChanged(this.idy);
            this.mNavigationBar.onChangeSkinType(this.kIp.getPageContext(), i);
            am.setTopBarCommonFinishButton(this.kIf, i);
            am.setBackgroundColor(this.kIb, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.kIc, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.kIa, R.color.cp_cont_g);
            am.setBackgroundColor(this.kIl, R.color.cp_bg_line_e);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_e);
            this.kIa.setTextColor(color);
            this.kIe.setTextColor(color);
            this.kIn.setTextColor(am.getColor(R.color.cp_cont_b));
            this.kIo.setTextColor(am.getColor(R.color.cp_cont_d));
            f(this.kIa, color2);
            f(this.kIe, color2);
            cSU();
        }
    }

    public ShareSDKImageView cTc() {
        return this.kIm;
    }
}
