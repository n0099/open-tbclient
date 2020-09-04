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
/* loaded from: classes18.dex */
public class c {
    private View lUP;
    private TextView lUS;
    private i lUT;
    private ImageView lUU;
    private View lUV;
    private LinearLayout lUW;
    private LinearLayout lUX;
    private ShareSDKImageView lUY;
    private TextView lUZ;
    private WriteData lUv;
    private TextView lVa;
    private WriteShareActivity lVb;
    private com.baidu.tbadk.img.b lVc;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText lUN = null;
    private View lUO = null;
    private LinearLayout lUQ = null;
    private EditText lUR = null;
    private TextView kGw = null;
    private RelativeLayout jfq = null;
    private boolean lVd = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.lUv = null;
        this.lVb = writeShareActivity;
        this.lUv = writeShareActivity.cLa();
        if (this.lVc == null) {
            this.lVc = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.lVb.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.lVb.getPageContext().getString(R.string.share_navigationbar_title));
        this.kGw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.lVb.getPageContext().getString(R.string.send_post));
        this.jfq = (RelativeLayout) this.lVb.findViewById(R.id.parent);
        this.lUO = this.lVb.findViewById(R.id.interval_view);
        this.lUP = this.lVb.findViewById(R.id.prefix_interval_view);
        this.lUW = (LinearLayout) this.lVb.findViewById(R.id.post_share_layout);
        this.lUX = (LinearLayout) this.lVb.findViewById(R.id.post_share_content_layout);
        this.lUY = (ShareSDKImageView) this.lVb.findViewById(R.id.post_share_image);
        this.lUZ = (TextView) this.lVb.findViewById(R.id.post_share_title);
        this.lVa = (TextView) this.lVb.findViewById(R.id.post_share_content);
        dtl();
        dtn();
        this.lUQ = (LinearLayout) this.lVb.findViewById(R.id.post_content_container);
        this.lUQ.setDrawingCacheEnabled(false);
        this.lUN.setVisibility(0);
        this.lUR.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        dtm();
    }

    public void dtj() {
        this.lUW = (LinearLayout) this.lVb.findViewById(R.id.post_share_layout);
        this.lUY = (ShareSDKImageView) this.lVb.findViewById(R.id.post_share_image);
        this.lUY.setIsRound(false);
        this.lUY.setDrawBorder(false);
        this.lUY.setAutoChangeStyle(true);
        this.lUY.setRadius(0);
        this.lUZ = (TextView) this.lVb.findViewById(R.id.post_share_title);
        this.lVa = (TextView) this.lVb.findViewById(R.id.post_share_content);
        if (this.lUv != null) {
            if (this.lUv.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.lUY.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.lUY.getLoadedWidth() != 0 && c.this.lUY.getLoadedHeight() != 0) {
                                c.this.width = c.this.lUY.getLoadedWidth();
                                c.this.height = c.this.lUY.getLoadedHeight();
                                if (c.this.lVb != null) {
                                    c.this.lVb.cLa().setShareSummaryImgWidth(c.this.width);
                                    c.this.lVb.cLa().setShareSummaryImgHeight(c.this.height);
                                    c.this.lVd = true;
                                    c.this.dtm();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.lVd = false;
                        c.this.dtm();
                        if (c.this.lVb != null) {
                            c.this.lVb.Hq(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.lVd = false;
                        c.this.dtm();
                        if (c.this.lVb != null) {
                            c.this.lVb.Hq(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.lUv.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.lUv.getShareSummaryImg() != null && this.lUv.getShareSummaryImg().trim().length() > 0) {
                    this.lUY.startLoad(this.lUv.getShareSummaryImg(), 10, true);
                } else {
                    this.lVd = true;
                    dtm();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.lUv.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.lUY.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.lUv.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.lUv.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.bg(au.bjr().getPostImageSize(), au.bjr().getPostImageHeightLimit()));
                    this.lUY.setTag(imageFileInfo.toCachedKey(true));
                    if (this.lVc.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.lUW.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.lUY.invalidate();
                    }
                }
                this.lVd = true;
                dtm();
            }
            this.lUv.setShareSummaryImgType(f.getExtension(this.lUv.getShareSummaryImg()));
            this.lUZ.setText(this.lUv.getShareSummaryTitle());
            this.lVa.setText(this.lUv.getShareSummaryContent());
        }
    }

    private void dtk() {
        this.lUV = this.lVb.findViewById(R.id.post_prefix_layout);
        this.lUS = (TextView) this.lVb.findViewById(R.id.post_prefix);
        this.lUU = (ImageView) this.lVb.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.lUV.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.lUS.setText(prefixs.get(0));
            this.lVb.Hr(0);
            this.lUV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.lUS.setVisibility(0);
                    c.this.lUV.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.lUT, view, l.dip2px(c.this.lVb.getPageContext().getContext(), 15.0f), l.dip2px(c.this.lVb.getPageContext().getContext(), 1.0f));
                    if (c.this.lVb != null) {
                        c.this.lVb.dti();
                    }
                }
            });
            this.lUU = (ImageView) this.lVb.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.lUU.setVisibility(0);
                this.lUS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.lUS.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.lUT, view, l.dip2px(c.this.lVb.getPageContext().getContext(), 15.0f), l.dip2px(c.this.lVb.getPageContext().getContext(), 1.0f));
                        if (c.this.lVb != null) {
                            c.this.lVb.dti();
                        }
                    }
                });
            }
            this.lUT = new i(this.lVb.getPageContext().getContext());
            this.lUT.setMaxHeight(l.dip2px(this.lVb.getPageContext().getContext(), 225.0f));
            this.lUT.setOutsideTouchable(true);
            this.lUT.setFocusable(true);
            this.lUT.setBackgroundDrawable(ap.getDrawable(R.color.cp_bg_line_c));
            this.lUT.a(new i.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.i.a
                public void Hs(int i) {
                    c.this.lVb.Hr(i);
                    c.this.lUS.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.lUT.setCurrentIndex(i);
                    c.this.dtm();
                    g.dismissPopupWindow(c.this.lUT, c.this.lVb.getPageContext().getPageActivity());
                }
            });
            this.lUT.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.lUV.setSelected(false);
                }
            });
            int color = ap.getColor(R.color.common_color_10097);
            ap.setBackgroundResource(this.lUS, R.drawable.write_prefix_item_selector);
            ap.setImageResource(this.lUU, R.drawable.icon_title_down);
            this.lUS.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.lVb.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.lVb.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ap.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.lVb.getPageContext().getContext(), this.lVb.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.lVb.getPageContext().getContext(), this.lVb.getResources().getDimension(R.dimen.ds22)), 0);
                this.lUT.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.lVb.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.lVb.getPageContext().getContext(), this.lVb.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.lVb.getPageContext().getContext(), this.lVb.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.lUT.setCurrentIndex(0);
            return;
        }
        this.lUV.setVisibility(8);
    }

    protected void dtl() {
        this.lUN = (EditText) this.lVb.findViewById(R.id.post_title);
        if (this.lUv.getType() == 3) {
            if (this.lUv.getTitle() != null && this.lUv.getTitle().trim().length() > 0) {
                this.lUN.setText(this.lUv.getTitle());
                this.lUN.setSelection(this.lUv.getTitle().length());
            } else {
                String str = this.lVb.getPageContext().getString(R.string.share_transfer_thread) + this.lUv.getShareSummaryTitle();
                this.lUN.setText(str);
                if (str.length() < 20) {
                    this.lUN.setSelection(str.length());
                } else {
                    this.lUN.setSelection(20);
                }
            }
        }
        this.lUN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dtm();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void dtm() {
        String str = null;
        if (this.lUv.getType() == 3) {
            String trim = this.lUN.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.lVb.dtg() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.lUv.setIsNoTitle(true);
                    } else {
                        this.lUv.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.lUv.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.lUv.setIsNoTitle(true);
            } else {
                this.lUv.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.lVd) {
            this.kGw.setEnabled(false);
        } else {
            this.kGw.setEnabled(true);
        }
    }

    protected void dtn() {
        this.lUR = (EditText) this.lVb.findViewById(R.id.post_content);
        this.lUR.setDrawingCacheEnabled(false);
        if (this.lUv.getContent() != null && this.lUv.getContent().length() > 0) {
            SpannableString ap = TbFaceManager.bsW().ap(this.lVb.getPageContext().getContext(), this.lUv.getContent());
            this.lUR.setText(ap);
            this.lUR.setSelection(ap.length());
        }
        this.lUR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.lUR.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dtm();
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

    public EditText dto() {
        return this.lUN;
    }

    public EditText dtp() {
        return this.lUR;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        dtk();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.lUN.setOnFocusChangeListener(onFocusChangeListener);
        this.lUR.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.kGw.setOnFocusChangeListener(onFocusChangeListener);
    }

    public i dtq() {
        return this.lUT;
    }

    public View dtr() {
        return this.mBack;
    }

    public TextView dts() {
        return this.kGw;
    }

    public TextView dtt() {
        return this.lUS;
    }

    public void ae(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void af(View.OnClickListener onClickListener) {
        this.kGw.setOnClickListener(onClickListener);
    }

    public void ag(View.OnClickListener onClickListener) {
        this.lUQ.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.lVb != null) {
            this.lVb.getLayoutMode().setNightMode(i == 1);
            this.lVb.getLayoutMode().onModeChanged(this.jfq);
            this.mNavigationBar.onChangeSkinType(this.lVb.getPageContext(), i);
            ap.setTopBarCommonFinishButton(this.kGw, i);
            ap.setBackgroundColor(this.lUO, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.lUP, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.lUN, R.color.cp_cont_g);
            ap.setBackgroundColor(this.lUX, R.color.cp_bg_line_e);
            int color = ap.getColor(R.color.cp_cont_b);
            int color2 = ap.getColor(R.color.cp_cont_e);
            this.lUN.setTextColor(color);
            this.lUR.setTextColor(color);
            this.lUZ.setTextColor(ap.getColor(R.color.cp_cont_b));
            this.lVa.setTextColor(ap.getColor(R.color.cp_cont_d));
            f(this.lUN, color2);
            f(this.lUR, color2);
            dtm();
        }
    }

    public ShareSDKImageView dtu() {
        return this.lUY;
    }
}
