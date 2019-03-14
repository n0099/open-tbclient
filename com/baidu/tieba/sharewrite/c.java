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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.write.h;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class c {
    private View iwI;
    private TextView iwL;
    private h iwM;
    private ImageView iwN;
    private View iwO;
    private LinearLayout iwP;
    private LinearLayout iwQ;
    private ShareSDKImageView iwR;
    private TextView iwS;
    private TextView iwT;
    private WriteShareActivity iwU;
    private com.baidu.tbadk.img.b iwV;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View bVZ = null;
    private EditText iwG = null;
    private View iwH = null;
    private LinearLayout iwJ = null;
    private EditText iwK = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean iwW = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.iwU = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.iwV == null) {
            this.iwV = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.iwU.findViewById(d.g.view_navigation_bar);
        this.bVZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iwU.getPageContext().getString(d.j.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iwU.getPageContext().getString(d.j.send_post));
        this.mParent = (RelativeLayout) this.iwU.findViewById(d.g.parent);
        this.iwH = this.iwU.findViewById(d.g.interval_view);
        this.iwI = this.iwU.findViewById(d.g.prefix_interval_view);
        this.iwP = (LinearLayout) this.iwU.findViewById(d.g.post_share_layout);
        this.iwQ = (LinearLayout) this.iwU.findViewById(d.g.post_share_content_layout);
        this.iwR = (ShareSDKImageView) this.iwU.findViewById(d.g.post_share_image);
        this.iwS = (TextView) this.iwU.findViewById(d.g.post_share_title);
        this.iwT = (TextView) this.iwU.findViewById(d.g.post_share_content);
        cbs();
        cbu();
        this.iwJ = (LinearLayout) this.iwU.findViewById(d.g.post_content_container);
        this.iwJ.setDrawingCacheEnabled(false);
        this.iwG.setVisibility(0);
        this.iwK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        cbt();
    }

    public void cbq() {
        this.iwP = (LinearLayout) this.iwU.findViewById(d.g.post_share_layout);
        this.iwR = (ShareSDKImageView) this.iwU.findViewById(d.g.post_share_image);
        this.iwR.setIsRound(false);
        this.iwR.setDrawBorder(false);
        this.iwR.setAutoChangeStyle(true);
        this.iwR.setRadius(0);
        this.iwS = (TextView) this.iwU.findViewById(d.g.post_share_title);
        this.iwT = (TextView) this.iwU.findViewById(d.g.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.iwR.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void L(String str, boolean z) {
                        if (z) {
                            if (c.this.iwR.getLoadedWidth() != 0 && c.this.iwR.getLoadedHeight() != 0) {
                                c.this.width = c.this.iwR.getLoadedWidth();
                                c.this.height = c.this.iwR.getLoadedHeight();
                                if (c.this.iwU != null) {
                                    c.this.iwU.getWriteData().setShareSummaryImgWidth(c.this.width);
                                    c.this.iwU.getWriteData().setShareSummaryImgHeight(c.this.height);
                                    c.this.iwW = true;
                                    c.this.cbt();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.iwW = false;
                        c.this.cbt();
                        if (c.this.iwU != null) {
                            c.this.iwU.yX(d.j.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.iwW = false;
                        c.this.cbt();
                        if (c.this.iwU != null) {
                            c.this.iwU.yX(d.j.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.iwR.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.iwW = true;
                    cbt();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.iwR.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(m.b(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.ai(ar.adp().adv(), ar.adp().adw()));
                    this.iwR.setTag(imageFileInfo.toCachedKey(true));
                    if (this.iwV.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.iwP.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.iwR.invalidate();
                    }
                }
                this.iwW = true;
                cbt();
            }
            this.mData.setShareSummaryImgType(f.bp(this.mData.getShareSummaryImg()));
            this.iwS.setText(this.mData.getShareSummaryTitle());
            this.iwT.setText(this.mData.getShareSummaryContent());
        }
    }

    private void cbr() {
        this.iwO = this.iwU.findViewById(d.g.post_prefix_layout);
        this.iwL = (TextView) this.iwU.findViewById(d.g.post_prefix);
        this.iwN = (ImageView) this.iwU.findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.iwO.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iwL.setText(prefixs.get(0));
            this.iwU.yY(0);
            this.iwO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.iwL.setVisibility(0);
                    c.this.iwO.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.iwM, view, l.dip2px(c.this.iwU.getPageContext().getContext(), 15.0f), l.dip2px(c.this.iwU.getPageContext().getContext(), 1.0f));
                    if (c.this.iwU != null) {
                        c.this.iwU.cbp();
                    }
                }
            });
            this.iwN = (ImageView) this.iwU.findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.iwN.setVisibility(0);
                this.iwL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.iwL.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.iwM, view, l.dip2px(c.this.iwU.getPageContext().getContext(), 15.0f), l.dip2px(c.this.iwU.getPageContext().getContext(), 1.0f));
                        if (c.this.iwU != null) {
                            c.this.iwU.cbp();
                        }
                    }
                });
            }
            this.iwM = new h(this.iwU.getPageContext().getContext());
            this.iwM.setMaxHeight(l.dip2px(this.iwU.getPageContext().getContext(), 225.0f));
            this.iwM.setOutsideTouchable(true);
            this.iwM.setFocusable(true);
            this.iwM.setBackgroundDrawable(al.getDrawable(d.C0277d.cp_bg_line_b));
            this.iwM.a(new h.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.h.a
                public void yZ(int i) {
                    c.this.iwU.yY(i);
                    c.this.iwL.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.iwM.setCurrentIndex(i);
                    c.this.cbt();
                    g.a(c.this.iwM, c.this.iwU.getPageContext().getPageActivity());
                }
            });
            this.iwM.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.iwO.setSelected(false);
                }
            });
            int color = al.getColor(d.C0277d.common_color_10097);
            al.k(this.iwL, d.f.write_prefix_item_selector);
            al.c(this.iwN, d.f.icon_title_down);
            this.iwL.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.iwU.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.iwU.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                al.k(textView, d.f.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.iwU.getPageContext().getContext(), this.iwU.getResources().getDimension(d.e.ds6)), 0, l.dip2px(this.iwU.getPageContext().getContext(), this.iwU.getResources().getDimension(d.e.ds22)), 0);
                this.iwM.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.iwU.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.iwU.getPageContext().getContext(), this.iwU.getResources().getDimension(d.e.ds6)), 0, l.dip2px(this.iwU.getPageContext().getContext(), this.iwU.getResources().getDimension(d.e.ds22)), 0);
                }
            }
            this.iwM.setCurrentIndex(0);
            return;
        }
        this.iwO.setVisibility(8);
    }

    protected void cbs() {
        this.iwG = (EditText) this.iwU.findViewById(d.g.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.iwG.setText(this.mData.getTitle());
                this.iwG.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.iwU.getPageContext().getString(d.j.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.iwG.setText(str);
                if (str.length() < 20) {
                    this.iwG.setSelection(str.length());
                } else {
                    this.iwG.setSelection(20);
                }
            }
        }
        this.iwG.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cbt();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void cbt() {
        String str = null;
        if (this.mData.getType() == 3) {
            String trim = this.iwG.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.iwU.cbn() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.iwW) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void cbu() {
        this.iwK = (EditText) this.iwU.findViewById(d.g.post_content);
        this.iwK.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString ax = TbFaceManager.ano().ax(this.iwU.getPageContext().getContext(), this.mData.getContent());
            this.iwK.setText(ax);
            this.iwK.setSelection(ax.length());
        }
        this.iwK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iwK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cbt();
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

    public EditText cbv() {
        return this.iwG;
    }

    public EditText cbw() {
        return this.iwK;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        cbr();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.iwG.setOnFocusChangeListener(onFocusChangeListener);
        this.iwK.setOnFocusChangeListener(onFocusChangeListener);
        this.bVZ.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public h cbx() {
        return this.iwM;
    }

    public View cby() {
        return this.bVZ;
    }

    public TextView cbz() {
        return this.mPost;
    }

    public TextView cbA() {
        return this.iwL;
    }

    public void V(View.OnClickListener onClickListener) {
        this.bVZ.setOnClickListener(onClickListener);
    }

    public void W(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void X(View.OnClickListener onClickListener) {
        this.iwJ.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.iwU != null) {
            this.iwU.getLayoutMode().setNightMode(i == 1);
            this.iwU.getLayoutMode().onModeChanged(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.iwU.getPageContext(), i);
            al.d(this.mPost, i);
            al.l(this.iwH, d.C0277d.cp_bg_line_c);
            al.l(this.iwI, d.C0277d.cp_bg_line_c);
            al.l(this.iwG, d.C0277d.cp_cont_g);
            al.l(this.iwQ, d.C0277d.cp_bg_line_e);
            int color = al.getColor(d.C0277d.cp_cont_b);
            int color2 = al.getColor(d.C0277d.cp_cont_e);
            this.iwG.setTextColor(color);
            this.iwK.setTextColor(color);
            this.iwS.setTextColor(al.getColor(d.C0277d.cp_cont_b));
            this.iwT.setTextColor(al.getColor(d.C0277d.cp_cont_d));
            f(this.iwG, color2);
            f(this.iwK, color2);
            cbt();
        }
    }

    public ShareSDKImageView cbB() {
        return this.iwR;
    }
}
