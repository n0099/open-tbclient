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
    private LinearLayout iwA;
    private ShareSDKImageView iwB;
    private TextView iwC;
    private TextView iwD;
    private WriteShareActivity iwE;
    private com.baidu.tbadk.img.b iwF;
    private View iws;
    private TextView iwv;
    private h iww;
    private ImageView iwx;
    private View iwy;
    private LinearLayout iwz;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View bWb = null;
    private EditText iwq = null;
    private View iwr = null;
    private LinearLayout iwt = null;
    private EditText iwu = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean iwG = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.iwE = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.iwF == null) {
            this.iwF = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.iwE.findViewById(d.g.view_navigation_bar);
        this.bWb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iwE.getPageContext().getString(d.j.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iwE.getPageContext().getString(d.j.send_post));
        this.mParent = (RelativeLayout) this.iwE.findViewById(d.g.parent);
        this.iwr = this.iwE.findViewById(d.g.interval_view);
        this.iws = this.iwE.findViewById(d.g.prefix_interval_view);
        this.iwz = (LinearLayout) this.iwE.findViewById(d.g.post_share_layout);
        this.iwA = (LinearLayout) this.iwE.findViewById(d.g.post_share_content_layout);
        this.iwB = (ShareSDKImageView) this.iwE.findViewById(d.g.post_share_image);
        this.iwC = (TextView) this.iwE.findViewById(d.g.post_share_title);
        this.iwD = (TextView) this.iwE.findViewById(d.g.post_share_content);
        cbo();
        cbq();
        this.iwt = (LinearLayout) this.iwE.findViewById(d.g.post_content_container);
        this.iwt.setDrawingCacheEnabled(false);
        this.iwq.setVisibility(0);
        this.iwu.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        cbp();
    }

    public void cbm() {
        this.iwz = (LinearLayout) this.iwE.findViewById(d.g.post_share_layout);
        this.iwB = (ShareSDKImageView) this.iwE.findViewById(d.g.post_share_image);
        this.iwB.setIsRound(false);
        this.iwB.setDrawBorder(false);
        this.iwB.setAutoChangeStyle(true);
        this.iwB.setRadius(0);
        this.iwC = (TextView) this.iwE.findViewById(d.g.post_share_title);
        this.iwD = (TextView) this.iwE.findViewById(d.g.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.iwB.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void L(String str, boolean z) {
                        if (z) {
                            if (c.this.iwB.getLoadedWidth() != 0 && c.this.iwB.getLoadedHeight() != 0) {
                                c.this.width = c.this.iwB.getLoadedWidth();
                                c.this.height = c.this.iwB.getLoadedHeight();
                                if (c.this.iwE != null) {
                                    c.this.iwE.getWriteData().setShareSummaryImgWidth(c.this.width);
                                    c.this.iwE.getWriteData().setShareSummaryImgHeight(c.this.height);
                                    c.this.iwG = true;
                                    c.this.cbp();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.iwG = false;
                        c.this.cbp();
                        if (c.this.iwE != null) {
                            c.this.iwE.yT(d.j.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.iwG = false;
                        c.this.cbp();
                        if (c.this.iwE != null) {
                            c.this.iwE.yT(d.j.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.iwB.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.iwG = true;
                    cbp();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.iwB.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(m.b(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.ai(ar.adm().ads(), ar.adm().adt()));
                    this.iwB.setTag(imageFileInfo.toCachedKey(true));
                    if (this.iwF.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.iwz.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.iwB.invalidate();
                    }
                }
                this.iwG = true;
                cbp();
            }
            this.mData.setShareSummaryImgType(f.bp(this.mData.getShareSummaryImg()));
            this.iwC.setText(this.mData.getShareSummaryTitle());
            this.iwD.setText(this.mData.getShareSummaryContent());
        }
    }

    private void cbn() {
        this.iwy = this.iwE.findViewById(d.g.post_prefix_layout);
        this.iwv = (TextView) this.iwE.findViewById(d.g.post_prefix);
        this.iwx = (ImageView) this.iwE.findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.iwy.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iwv.setText(prefixs.get(0));
            this.iwE.yU(0);
            this.iwy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.iwv.setVisibility(0);
                    c.this.iwy.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.iww, view, l.dip2px(c.this.iwE.getPageContext().getContext(), 15.0f), l.dip2px(c.this.iwE.getPageContext().getContext(), 1.0f));
                    if (c.this.iwE != null) {
                        c.this.iwE.cbl();
                    }
                }
            });
            this.iwx = (ImageView) this.iwE.findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.iwx.setVisibility(0);
                this.iwv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.iwv.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.iww, view, l.dip2px(c.this.iwE.getPageContext().getContext(), 15.0f), l.dip2px(c.this.iwE.getPageContext().getContext(), 1.0f));
                        if (c.this.iwE != null) {
                            c.this.iwE.cbl();
                        }
                    }
                });
            }
            this.iww = new h(this.iwE.getPageContext().getContext());
            this.iww.setMaxHeight(l.dip2px(this.iwE.getPageContext().getContext(), 225.0f));
            this.iww.setOutsideTouchable(true);
            this.iww.setFocusable(true);
            this.iww.setBackgroundDrawable(al.getDrawable(d.C0277d.cp_bg_line_b));
            this.iww.a(new h.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.h.a
                public void yV(int i) {
                    c.this.iwE.yU(i);
                    c.this.iwv.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.iww.setCurrentIndex(i);
                    c.this.cbp();
                    g.a(c.this.iww, c.this.iwE.getPageContext().getPageActivity());
                }
            });
            this.iww.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.iwy.setSelected(false);
                }
            });
            int color = al.getColor(d.C0277d.common_color_10097);
            al.k(this.iwv, d.f.write_prefix_item_selector);
            al.c(this.iwx, d.f.icon_title_down);
            this.iwv.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.iwE.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.iwE.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                al.k(textView, d.f.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.iwE.getPageContext().getContext(), this.iwE.getResources().getDimension(d.e.ds6)), 0, l.dip2px(this.iwE.getPageContext().getContext(), this.iwE.getResources().getDimension(d.e.ds22)), 0);
                this.iww.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.iwE.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.iwE.getPageContext().getContext(), this.iwE.getResources().getDimension(d.e.ds6)), 0, l.dip2px(this.iwE.getPageContext().getContext(), this.iwE.getResources().getDimension(d.e.ds22)), 0);
                }
            }
            this.iww.setCurrentIndex(0);
            return;
        }
        this.iwy.setVisibility(8);
    }

    protected void cbo() {
        this.iwq = (EditText) this.iwE.findViewById(d.g.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.iwq.setText(this.mData.getTitle());
                this.iwq.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.iwE.getPageContext().getString(d.j.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.iwq.setText(str);
                if (str.length() < 20) {
                    this.iwq.setSelection(str.length());
                } else {
                    this.iwq.setSelection(20);
                }
            }
        }
        this.iwq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cbp();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void cbp() {
        String str = null;
        if (this.mData.getType() == 3) {
            String trim = this.iwq.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.iwE.cbj() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.iwG) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void cbq() {
        this.iwu = (EditText) this.iwE.findViewById(d.g.post_content);
        this.iwu.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString ax = TbFaceManager.anl().ax(this.iwE.getPageContext().getContext(), this.mData.getContent());
            this.iwu.setText(ax);
            this.iwu.setSelection(ax.length());
        }
        this.iwu.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iwu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cbp();
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

    public EditText cbr() {
        return this.iwq;
    }

    public EditText cbs() {
        return this.iwu;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        cbn();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.iwq.setOnFocusChangeListener(onFocusChangeListener);
        this.iwu.setOnFocusChangeListener(onFocusChangeListener);
        this.bWb.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public h cbt() {
        return this.iww;
    }

    public View cbu() {
        return this.bWb;
    }

    public TextView cbv() {
        return this.mPost;
    }

    public TextView cbw() {
        return this.iwv;
    }

    public void V(View.OnClickListener onClickListener) {
        this.bWb.setOnClickListener(onClickListener);
    }

    public void W(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void X(View.OnClickListener onClickListener) {
        this.iwt.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.iwE != null) {
            this.iwE.getLayoutMode().setNightMode(i == 1);
            this.iwE.getLayoutMode().onModeChanged(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.iwE.getPageContext(), i);
            al.d(this.mPost, i);
            al.l(this.iwr, d.C0277d.cp_bg_line_c);
            al.l(this.iws, d.C0277d.cp_bg_line_c);
            al.l(this.iwq, d.C0277d.cp_cont_g);
            al.l(this.iwA, d.C0277d.cp_bg_line_e);
            int color = al.getColor(d.C0277d.cp_cont_b);
            int color2 = al.getColor(d.C0277d.cp_cont_e);
            this.iwq.setTextColor(color);
            this.iwu.setTextColor(color);
            this.iwC.setTextColor(al.getColor(d.C0277d.cp_cont_b));
            this.iwD.setTextColor(al.getColor(d.C0277d.cp_cont_d));
            f(this.iwq, color2);
            f(this.iwu, color2);
            cbp();
        }
    }

    public ShareSDKImageView cbx() {
        return this.iwB;
    }
}
