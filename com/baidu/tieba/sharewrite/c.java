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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.write.d;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class c {
    private View gCk;
    private TextView gCn;
    private d gCo;
    private ImageView gCp;
    private View gCq;
    private LinearLayout gCr;
    private LinearLayout gCs;
    private ShareSDKImageView gCt;
    private TextView gCu;
    private TextView gCv;
    private WriteShareActivity gCw;
    private com.baidu.tbadk.img.b gCx;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View aBf = null;
    private EditText gCi = null;
    private View gCj = null;
    private LinearLayout gCl = null;
    private EditText gCm = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean gCy = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.gCw = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.gCx == null) {
            this.gCx = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.gCw.findViewById(d.g.view_navigation_bar);
        this.aBf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gCw.getPageContext().getString(d.k.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gCw.getPageContext().getString(d.k.send_post));
        this.mParent = (RelativeLayout) this.gCw.findViewById(d.g.parent);
        this.gCj = this.gCw.findViewById(d.g.interval_view);
        this.gCk = this.gCw.findViewById(d.g.prefix_interval_view);
        this.gCr = (LinearLayout) this.gCw.findViewById(d.g.post_share_layout);
        this.gCs = (LinearLayout) this.gCw.findViewById(d.g.post_share_content_layout);
        this.gCt = (ShareSDKImageView) this.gCw.findViewById(d.g.post_share_image);
        this.gCu = (TextView) this.gCw.findViewById(d.g.post_share_title);
        this.gCv = (TextView) this.gCw.findViewById(d.g.post_share_content);
        btp();
        btr();
        this.gCl = (LinearLayout) this.gCw.findViewById(d.g.post_content_container);
        this.gCl.setDrawingCacheEnabled(false);
        this.gCi.setVisibility(0);
        this.gCm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        btq();
    }

    public void btn() {
        this.gCr = (LinearLayout) this.gCw.findViewById(d.g.post_share_layout);
        this.gCt = (ShareSDKImageView) this.gCw.findViewById(d.g.post_share_image);
        this.gCt.setIsRound(false);
        this.gCt.setDrawBorder(false);
        this.gCt.setAutoChangeStyle(true);
        this.gCt.setRadius(0);
        this.gCu = (TextView) this.gCw.findViewById(d.g.post_share_title);
        this.gCv = (TextView) this.gCw.findViewById(d.g.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.gCt.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void n(String str, boolean z) {
                        if (z) {
                            if (c.this.gCt.getLoadedWidth() != 0 && c.this.gCt.getLoadedHeight() != 0) {
                                c.this.width = c.this.gCt.getLoadedWidth();
                                c.this.height = c.this.gCt.getLoadedHeight();
                                if (c.this.gCw != null) {
                                    c.this.gCw.getWriteData().setShareSummaryImgWidth(c.this.width);
                                    c.this.gCw.getWriteData().setShareSummaryImgHeight(c.this.height);
                                    c.this.gCy = true;
                                    c.this.btq();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.gCy = false;
                        c.this.btq();
                        if (c.this.gCw != null) {
                            c.this.gCw.th(d.k.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.gCy = false;
                        c.this.btq();
                        if (c.this.gCw != null) {
                            c.this.gCw.th(d.k.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.gCt.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.gCy = true;
                    btq();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.gCt.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(l.b(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.H(ar.zF().zL(), ar.zF().zM()));
                    this.gCt.setTag(imageFileInfo.toCachedKey(true));
                    if (this.gCx.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.gCr.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.gCt.invalidate();
                    }
                }
                this.gCy = true;
                btq();
            }
            this.mData.setShareSummaryImgType(f.aY(this.mData.getShareSummaryImg()));
            this.gCu.setText(this.mData.getShareSummaryTitle());
            this.gCv.setText(this.mData.getShareSummaryContent());
        }
    }

    private void bto() {
        this.gCq = this.gCw.findViewById(d.g.post_prefix_layout);
        this.gCn = (TextView) this.gCw.findViewById(d.g.post_prefix);
        this.gCp = (ImageView) this.gCw.findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.gCq.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gCn.setText(prefixs.get(0));
            this.gCw.ti(0);
            this.gCq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.gCn.setVisibility(0);
                    c.this.gCq.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.gCo, view, com.baidu.adp.lib.util.l.dip2px(c.this.gCw.getPageContext().getContext(), 15.0f), com.baidu.adp.lib.util.l.dip2px(c.this.gCw.getPageContext().getContext(), 1.0f));
                    if (c.this.gCw != null) {
                        c.this.gCw.btm();
                    }
                }
            });
            this.gCp = (ImageView) this.gCw.findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gCp.setVisibility(0);
                this.gCn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.gCn.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.gCo, view, com.baidu.adp.lib.util.l.dip2px(c.this.gCw.getPageContext().getContext(), 15.0f), com.baidu.adp.lib.util.l.dip2px(c.this.gCw.getPageContext().getContext(), 1.0f));
                        if (c.this.gCw != null) {
                            c.this.gCw.btm();
                        }
                    }
                });
            }
            this.gCo = new com.baidu.tieba.write.d(this.gCw.getPageContext().getContext());
            this.gCo.setMaxHeight(com.baidu.adp.lib.util.l.dip2px(this.gCw.getPageContext().getContext(), 225.0f));
            this.gCo.setOutsideTouchable(true);
            this.gCo.setFocusable(true);
            this.gCo.setBackgroundDrawable(am.getDrawable(d.C0142d.cp_bg_line_b));
            this.gCo.a(new d.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.d.a
                public void tj(int i) {
                    c.this.gCw.ti(i);
                    c.this.gCn.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.gCo.setCurrentIndex(i);
                    c.this.btq();
                    g.a(c.this.gCo, c.this.gCw.getPageContext().getPageActivity());
                }
            });
            this.gCo.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.gCq.setSelected(false);
                }
            });
            int color = am.getColor(d.C0142d.common_color_10097);
            am.i(this.gCn, d.f.write_prefix_item_selector);
            am.c(this.gCp, d.f.icon_title_down);
            this.gCn.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.gCw.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.dip2px(this.gCw.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                am.i(textView, d.f.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.gCw.getPageContext().getContext(), this.gCw.getResources().getDimension(d.e.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.gCw.getPageContext().getContext(), this.gCw.getResources().getDimension(d.e.ds22)), 0);
                this.gCo.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.dip2px(this.gCw.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.gCw.getPageContext().getContext(), this.gCw.getResources().getDimension(d.e.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.gCw.getPageContext().getContext(), this.gCw.getResources().getDimension(d.e.ds22)), 0);
                }
            }
            this.gCo.setCurrentIndex(0);
            return;
        }
        this.gCq.setVisibility(8);
    }

    protected void btp() {
        this.gCi = (EditText) this.gCw.findViewById(d.g.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.gCi.setText(this.mData.getTitle());
                this.gCi.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.gCw.getPageContext().getString(d.k.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.gCi.setText(str);
                if (str.length() < 20) {
                    this.gCi.setSelection(str.length());
                } else {
                    this.gCi.setSelection(20);
                }
            }
        }
        this.gCi.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.btq();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void btq() {
        String str = null;
        if (this.mData.getType() == 3) {
            String trim = this.gCi.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.gCw.btk() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.mData.setIsNoTitle(true);
                    } else {
                        this.mData.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.mData.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.mData.setIsNoTitle(true);
            } else {
                this.mData.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.gCy) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void btr() {
        this.gCm = (EditText) this.gCw.findViewById(d.g.post_content);
        this.gCm.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString U = TbFaceManager.IU().U(this.gCw.getPageContext().getContext(), this.mData.getContent());
            this.gCm.setText(U);
            this.gCm.setSelection(U.length());
        }
        this.gCm.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gCm.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.btq();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    private void b(EditText editText, int i) {
        Editable text = editText.getText();
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        editText.setText((CharSequence) null);
        editText.setHintTextColor(i);
        editText.setText(text);
        editText.setSelection(selectionStart, selectionEnd);
    }

    public EditText bts() {
        return this.gCi;
    }

    public EditText btt() {
        return this.gCm;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        bto();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.gCi.setOnFocusChangeListener(onFocusChangeListener);
        this.gCm.setOnFocusChangeListener(onFocusChangeListener);
        this.aBf.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public com.baidu.tieba.write.d btu() {
        return this.gCo;
    }

    public View btv() {
        return this.aBf;
    }

    public TextView btw() {
        return this.mPost;
    }

    public TextView btx() {
        return this.gCn;
    }

    public void W(View.OnClickListener onClickListener) {
        this.aBf.setOnClickListener(onClickListener);
    }

    public void X(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void Y(View.OnClickListener onClickListener) {
        this.gCl.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.gCw != null) {
            this.gCw.getLayoutMode().setNightMode(i == 1);
            this.gCw.getLayoutMode().onModeChanged(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.gCw.getPageContext(), i);
            am.d(this.mPost, i);
            am.j(this.gCj, d.C0142d.cp_bg_line_c);
            am.j(this.gCk, d.C0142d.cp_bg_line_c);
            am.j(this.gCi, d.C0142d.cp_cont_g);
            am.j(this.gCs, d.C0142d.cp_bg_line_e);
            int color = am.getColor(d.C0142d.cp_cont_b);
            int color2 = am.getColor(d.C0142d.cp_cont_e);
            this.gCi.setTextColor(color);
            this.gCm.setTextColor(color);
            this.gCu.setTextColor(am.getColor(d.C0142d.cp_cont_b));
            this.gCv.setTextColor(am.getColor(d.C0142d.cp_cont_d));
            b(this.gCi, color2);
            b(this.gCm, color2);
            btq();
        }
    }

    public ShareSDKImageView bty() {
        return this.gCt;
    }
}
