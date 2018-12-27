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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.write.d;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class c {
    private View hdS;
    private TextView hdV;
    private d hdW;
    private ImageView hdX;
    private View hdY;
    private LinearLayout hdZ;
    private LinearLayout hea;
    private ShareSDKImageView heb;
    private TextView hec;
    private TextView hed;
    private WriteShareActivity hee;
    private com.baidu.tbadk.img.b hef;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View aMW = null;
    private EditText hdQ = null;
    private View hdR = null;
    private LinearLayout hdT = null;
    private EditText hdU = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean heg = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.hee = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.hef == null) {
            this.hef = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.hee.findViewById(e.g.view_navigation_bar);
        this.aMW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.hee.getPageContext().getString(e.j.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hee.getPageContext().getString(e.j.send_post));
        this.mParent = (RelativeLayout) this.hee.findViewById(e.g.parent);
        this.hdR = this.hee.findViewById(e.g.interval_view);
        this.hdS = this.hee.findViewById(e.g.prefix_interval_view);
        this.hdZ = (LinearLayout) this.hee.findViewById(e.g.post_share_layout);
        this.hea = (LinearLayout) this.hee.findViewById(e.g.post_share_content_layout);
        this.heb = (ShareSDKImageView) this.hee.findViewById(e.g.post_share_image);
        this.hec = (TextView) this.hee.findViewById(e.g.post_share_title);
        this.hed = (TextView) this.hee.findViewById(e.g.post_share_content);
        bzS();
        bzU();
        this.hdT = (LinearLayout) this.hee.findViewById(e.g.post_content_container);
        this.hdT.setDrawingCacheEnabled(false);
        this.hdQ.setVisibility(0);
        this.hdU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        bzT();
    }

    public void bzQ() {
        this.hdZ = (LinearLayout) this.hee.findViewById(e.g.post_share_layout);
        this.heb = (ShareSDKImageView) this.hee.findViewById(e.g.post_share_image);
        this.heb.setIsRound(false);
        this.heb.setDrawBorder(false);
        this.heb.setAutoChangeStyle(true);
        this.heb.setRadius(0);
        this.hec = (TextView) this.hee.findViewById(e.g.post_share_title);
        this.hed = (TextView) this.hee.findViewById(e.g.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.heb.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void s(String str, boolean z) {
                        if (z) {
                            if (c.this.heb.getLoadedWidth() != 0 && c.this.heb.getLoadedHeight() != 0) {
                                c.this.width = c.this.heb.getLoadedWidth();
                                c.this.height = c.this.heb.getLoadedHeight();
                                if (c.this.hee != null) {
                                    c.this.hee.getWriteData().setShareSummaryImgWidth(c.this.width);
                                    c.this.hee.getWriteData().setShareSummaryImgHeight(c.this.height);
                                    c.this.heg = true;
                                    c.this.bzT();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.heg = false;
                        c.this.bzT();
                        if (c.this.hee != null) {
                            c.this.hee.ve(e.j.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.heg = false;
                        c.this.bzT();
                        if (c.this.hee != null) {
                            c.this.hee.ve(e.j.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.heb.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.heg = true;
                    bzT();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.heb.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(l.b(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.L(aq.DR().DX(), aq.DR().DY()));
                    this.heb.setTag(imageFileInfo.toCachedKey(true));
                    if (this.hef.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.hdZ.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.heb.invalidate();
                    }
                }
                this.heg = true;
                bzT();
            }
            this.mData.setShareSummaryImgType(f.bp(this.mData.getShareSummaryImg()));
            this.hec.setText(this.mData.getShareSummaryTitle());
            this.hed.setText(this.mData.getShareSummaryContent());
        }
    }

    private void bzR() {
        this.hdY = this.hee.findViewById(e.g.post_prefix_layout);
        this.hdV = (TextView) this.hee.findViewById(e.g.post_prefix);
        this.hdX = (ImageView) this.hee.findViewById(e.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.hdY.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.hdV.setText(prefixs.get(0));
            this.hee.vf(0);
            this.hdY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.hdV.setVisibility(0);
                    c.this.hdY.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.hdW, view, com.baidu.adp.lib.util.l.dip2px(c.this.hee.getPageContext().getContext(), 15.0f), com.baidu.adp.lib.util.l.dip2px(c.this.hee.getPageContext().getContext(), 1.0f));
                    if (c.this.hee != null) {
                        c.this.hee.bzP();
                    }
                }
            });
            this.hdX = (ImageView) this.hee.findViewById(e.g.prefix_icon);
            if (size > 1) {
                this.hdX.setVisibility(0);
                this.hdV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.hdV.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.hdW, view, com.baidu.adp.lib.util.l.dip2px(c.this.hee.getPageContext().getContext(), 15.0f), com.baidu.adp.lib.util.l.dip2px(c.this.hee.getPageContext().getContext(), 1.0f));
                        if (c.this.hee != null) {
                            c.this.hee.bzP();
                        }
                    }
                });
            }
            this.hdW = new d(this.hee.getPageContext().getContext());
            this.hdW.setMaxHeight(com.baidu.adp.lib.util.l.dip2px(this.hee.getPageContext().getContext(), 225.0f));
            this.hdW.setOutsideTouchable(true);
            this.hdW.setFocusable(true);
            this.hdW.setBackgroundDrawable(al.getDrawable(e.d.cp_bg_line_b));
            this.hdW.a(new d.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.d.a
                public void vg(int i) {
                    c.this.hee.vf(i);
                    c.this.hdV.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.hdW.setCurrentIndex(i);
                    c.this.bzT();
                    g.a(c.this.hdW, c.this.hee.getPageContext().getPageActivity());
                }
            });
            this.hdW.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.hdY.setSelected(false);
                }
            });
            int color = al.getColor(e.d.common_color_10097);
            al.i(this.hdV, e.f.write_prefix_item_selector);
            al.c(this.hdX, e.f.icon_title_down);
            this.hdV.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.hee.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.dip2px(this.hee.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                al.i(textView, e.f.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.hee.getPageContext().getContext(), this.hee.getResources().getDimension(e.C0210e.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.hee.getPageContext().getContext(), this.hee.getResources().getDimension(e.C0210e.ds22)), 0);
                this.hdW.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.dip2px(this.hee.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.hee.getPageContext().getContext(), this.hee.getResources().getDimension(e.C0210e.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.hee.getPageContext().getContext(), this.hee.getResources().getDimension(e.C0210e.ds22)), 0);
                }
            }
            this.hdW.setCurrentIndex(0);
            return;
        }
        this.hdY.setVisibility(8);
    }

    protected void bzS() {
        this.hdQ = (EditText) this.hee.findViewById(e.g.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.hdQ.setText(this.mData.getTitle());
                this.hdQ.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.hee.getPageContext().getString(e.j.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.hdQ.setText(str);
                if (str.length() < 20) {
                    this.hdQ.setSelection(str.length());
                } else {
                    this.hdQ.setSelection(20);
                }
            }
        }
        this.hdQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.bzT();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void bzT() {
        String str = null;
        if (this.mData.getType() == 3) {
            String trim = this.hdQ.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.hee.bzN() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.heg) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void bzU() {
        this.hdU = (EditText) this.hee.findViewById(e.g.post_content);
        this.hdU.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString am = TbFaceManager.Nu().am(this.hee.getPageContext().getContext(), this.mData.getContent());
            this.hdU.setText(am);
            this.hdU.setSelection(am.length());
        }
        this.hdU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.hdU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.bzT();
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

    public EditText bzV() {
        return this.hdQ;
    }

    public EditText bzW() {
        return this.hdU;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        bzR();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.hdQ.setOnFocusChangeListener(onFocusChangeListener);
        this.hdU.setOnFocusChangeListener(onFocusChangeListener);
        this.aMW.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public d bzX() {
        return this.hdW;
    }

    public View bzY() {
        return this.aMW;
    }

    public TextView bzZ() {
        return this.mPost;
    }

    public TextView bAa() {
        return this.hdV;
    }

    public void V(View.OnClickListener onClickListener) {
        this.aMW.setOnClickListener(onClickListener);
    }

    public void W(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void X(View.OnClickListener onClickListener) {
        this.hdT.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.hee != null) {
            this.hee.getLayoutMode().setNightMode(i == 1);
            this.hee.getLayoutMode().onModeChanged(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.hee.getPageContext(), i);
            al.d(this.mPost, i);
            al.j(this.hdR, e.d.cp_bg_line_c);
            al.j(this.hdS, e.d.cp_bg_line_c);
            al.j(this.hdQ, e.d.cp_cont_g);
            al.j(this.hea, e.d.cp_bg_line_e);
            int color = al.getColor(e.d.cp_cont_b);
            int color2 = al.getColor(e.d.cp_cont_e);
            this.hdQ.setTextColor(color);
            this.hdU.setTextColor(color);
            this.hec.setTextColor(al.getColor(e.d.cp_cont_b));
            this.hed.setTextColor(al.getColor(e.d.cp_cont_d));
            b(this.hdQ, color2);
            b(this.hdU, color2);
            bzT();
        }
    }

    public ShareSDKImageView bAb() {
        return this.heb;
    }
}
