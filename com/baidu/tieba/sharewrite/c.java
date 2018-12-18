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
    private View haO;
    private TextView haR;
    private d haS;
    private ImageView haT;
    private View haU;
    private LinearLayout haV;
    private LinearLayout haW;
    private ShareSDKImageView haX;
    private TextView haY;
    private TextView haZ;
    private WriteShareActivity hba;
    private com.baidu.tbadk.img.b hbb;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View aMU = null;
    private EditText haM = null;
    private View haN = null;
    private LinearLayout haP = null;
    private EditText haQ = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean hbc = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.hba = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.hbb == null) {
            this.hbb = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.hba.findViewById(e.g.view_navigation_bar);
        this.aMU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.hba.getPageContext().getString(e.j.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hba.getPageContext().getString(e.j.send_post));
        this.mParent = (RelativeLayout) this.hba.findViewById(e.g.parent);
        this.haN = this.hba.findViewById(e.g.interval_view);
        this.haO = this.hba.findViewById(e.g.prefix_interval_view);
        this.haV = (LinearLayout) this.hba.findViewById(e.g.post_share_layout);
        this.haW = (LinearLayout) this.hba.findViewById(e.g.post_share_content_layout);
        this.haX = (ShareSDKImageView) this.hba.findViewById(e.g.post_share_image);
        this.haY = (TextView) this.hba.findViewById(e.g.post_share_title);
        this.haZ = (TextView) this.hba.findViewById(e.g.post_share_content);
        bzc();
        bze();
        this.haP = (LinearLayout) this.hba.findViewById(e.g.post_content_container);
        this.haP.setDrawingCacheEnabled(false);
        this.haM.setVisibility(0);
        this.haQ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        bzd();
    }

    public void bza() {
        this.haV = (LinearLayout) this.hba.findViewById(e.g.post_share_layout);
        this.haX = (ShareSDKImageView) this.hba.findViewById(e.g.post_share_image);
        this.haX.setIsRound(false);
        this.haX.setDrawBorder(false);
        this.haX.setAutoChangeStyle(true);
        this.haX.setRadius(0);
        this.haY = (TextView) this.hba.findViewById(e.g.post_share_title);
        this.haZ = (TextView) this.hba.findViewById(e.g.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.haX.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void s(String str, boolean z) {
                        if (z) {
                            if (c.this.haX.getLoadedWidth() != 0 && c.this.haX.getLoadedHeight() != 0) {
                                c.this.width = c.this.haX.getLoadedWidth();
                                c.this.height = c.this.haX.getLoadedHeight();
                                if (c.this.hba != null) {
                                    c.this.hba.getWriteData().setShareSummaryImgWidth(c.this.width);
                                    c.this.hba.getWriteData().setShareSummaryImgHeight(c.this.height);
                                    c.this.hbc = true;
                                    c.this.bzd();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.hbc = false;
                        c.this.bzd();
                        if (c.this.hba != null) {
                            c.this.hba.uR(e.j.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.hbc = false;
                        c.this.bzd();
                        if (c.this.hba != null) {
                            c.this.hba.uR(e.j.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.haX.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.hbc = true;
                    bzd();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.haX.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(l.b(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.L(aq.DR().DX(), aq.DR().DY()));
                    this.haX.setTag(imageFileInfo.toCachedKey(true));
                    if (this.hbb.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.haV.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.haX.invalidate();
                    }
                }
                this.hbc = true;
                bzd();
            }
            this.mData.setShareSummaryImgType(f.bp(this.mData.getShareSummaryImg()));
            this.haY.setText(this.mData.getShareSummaryTitle());
            this.haZ.setText(this.mData.getShareSummaryContent());
        }
    }

    private void bzb() {
        this.haU = this.hba.findViewById(e.g.post_prefix_layout);
        this.haR = (TextView) this.hba.findViewById(e.g.post_prefix);
        this.haT = (ImageView) this.hba.findViewById(e.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.haU.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.haR.setText(prefixs.get(0));
            this.hba.uS(0);
            this.haU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.haR.setVisibility(0);
                    c.this.haU.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.haS, view, com.baidu.adp.lib.util.l.dip2px(c.this.hba.getPageContext().getContext(), 15.0f), com.baidu.adp.lib.util.l.dip2px(c.this.hba.getPageContext().getContext(), 1.0f));
                    if (c.this.hba != null) {
                        c.this.hba.byZ();
                    }
                }
            });
            this.haT = (ImageView) this.hba.findViewById(e.g.prefix_icon);
            if (size > 1) {
                this.haT.setVisibility(0);
                this.haR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.haR.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.haS, view, com.baidu.adp.lib.util.l.dip2px(c.this.hba.getPageContext().getContext(), 15.0f), com.baidu.adp.lib.util.l.dip2px(c.this.hba.getPageContext().getContext(), 1.0f));
                        if (c.this.hba != null) {
                            c.this.hba.byZ();
                        }
                    }
                });
            }
            this.haS = new d(this.hba.getPageContext().getContext());
            this.haS.setMaxHeight(com.baidu.adp.lib.util.l.dip2px(this.hba.getPageContext().getContext(), 225.0f));
            this.haS.setOutsideTouchable(true);
            this.haS.setFocusable(true);
            this.haS.setBackgroundDrawable(al.getDrawable(e.d.cp_bg_line_b));
            this.haS.a(new d.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.d.a
                public void uT(int i) {
                    c.this.hba.uS(i);
                    c.this.haR.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.haS.setCurrentIndex(i);
                    c.this.bzd();
                    g.a(c.this.haS, c.this.hba.getPageContext().getPageActivity());
                }
            });
            this.haS.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.haU.setSelected(false);
                }
            });
            int color = al.getColor(e.d.common_color_10097);
            al.i(this.haR, e.f.write_prefix_item_selector);
            al.c(this.haT, e.f.icon_title_down);
            this.haR.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.hba.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.dip2px(this.hba.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                al.i(textView, e.f.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.hba.getPageContext().getContext(), this.hba.getResources().getDimension(e.C0210e.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.hba.getPageContext().getContext(), this.hba.getResources().getDimension(e.C0210e.ds22)), 0);
                this.haS.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.dip2px(this.hba.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.hba.getPageContext().getContext(), this.hba.getResources().getDimension(e.C0210e.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.hba.getPageContext().getContext(), this.hba.getResources().getDimension(e.C0210e.ds22)), 0);
                }
            }
            this.haS.setCurrentIndex(0);
            return;
        }
        this.haU.setVisibility(8);
    }

    protected void bzc() {
        this.haM = (EditText) this.hba.findViewById(e.g.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.haM.setText(this.mData.getTitle());
                this.haM.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.hba.getPageContext().getString(e.j.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.haM.setText(str);
                if (str.length() < 20) {
                    this.haM.setSelection(str.length());
                } else {
                    this.haM.setSelection(20);
                }
            }
        }
        this.haM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.bzd();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void bzd() {
        String str = null;
        if (this.mData.getType() == 3) {
            String trim = this.haM.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.hba.byX() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.hbc) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void bze() {
        this.haQ = (EditText) this.hba.findViewById(e.g.post_content);
        this.haQ.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString am = TbFaceManager.Nt().am(this.hba.getPageContext().getContext(), this.mData.getContent());
            this.haQ.setText(am);
            this.haQ.setSelection(am.length());
        }
        this.haQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.haQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.bzd();
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

    public EditText bzf() {
        return this.haM;
    }

    public EditText bzg() {
        return this.haQ;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        bzb();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.haM.setOnFocusChangeListener(onFocusChangeListener);
        this.haQ.setOnFocusChangeListener(onFocusChangeListener);
        this.aMU.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public d bzh() {
        return this.haS;
    }

    public View bzi() {
        return this.aMU;
    }

    public TextView bzj() {
        return this.mPost;
    }

    public TextView bzk() {
        return this.haR;
    }

    public void V(View.OnClickListener onClickListener) {
        this.aMU.setOnClickListener(onClickListener);
    }

    public void W(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void X(View.OnClickListener onClickListener) {
        this.haP.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.hba != null) {
            this.hba.getLayoutMode().setNightMode(i == 1);
            this.hba.getLayoutMode().onModeChanged(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.hba.getPageContext(), i);
            al.d(this.mPost, i);
            al.j(this.haN, e.d.cp_bg_line_c);
            al.j(this.haO, e.d.cp_bg_line_c);
            al.j(this.haM, e.d.cp_cont_g);
            al.j(this.haW, e.d.cp_bg_line_e);
            int color = al.getColor(e.d.cp_cont_b);
            int color2 = al.getColor(e.d.cp_cont_e);
            this.haM.setTextColor(color);
            this.haQ.setTextColor(color);
            this.haY.setTextColor(al.getColor(e.d.cp_cont_b));
            this.haZ.setTextColor(al.getColor(e.d.cp_cont_d));
            b(this.haM, color2);
            b(this.haQ, color2);
            bzd();
        }
    }

    public ShareSDKImageView bzl() {
        return this.haX;
    }
}
