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
    private LinearLayout iwB;
    private ShareSDKImageView iwC;
    private TextView iwD;
    private TextView iwE;
    private WriteShareActivity iwF;
    private com.baidu.tbadk.img.b iwG;
    private View iwt;
    private TextView iww;
    private h iwx;
    private ImageView iwy;
    private View iwz;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View bWc = null;
    private EditText iwr = null;
    private View iws = null;
    private LinearLayout iwu = null;
    private EditText iwv = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean iwH = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.iwF = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.iwG == null) {
            this.iwG = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.iwF.findViewById(d.g.view_navigation_bar);
        this.bWc = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iwF.getPageContext().getString(d.j.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iwF.getPageContext().getString(d.j.send_post));
        this.mParent = (RelativeLayout) this.iwF.findViewById(d.g.parent);
        this.iws = this.iwF.findViewById(d.g.interval_view);
        this.iwt = this.iwF.findViewById(d.g.prefix_interval_view);
        this.iwA = (LinearLayout) this.iwF.findViewById(d.g.post_share_layout);
        this.iwB = (LinearLayout) this.iwF.findViewById(d.g.post_share_content_layout);
        this.iwC = (ShareSDKImageView) this.iwF.findViewById(d.g.post_share_image);
        this.iwD = (TextView) this.iwF.findViewById(d.g.post_share_title);
        this.iwE = (TextView) this.iwF.findViewById(d.g.post_share_content);
        cbo();
        cbq();
        this.iwu = (LinearLayout) this.iwF.findViewById(d.g.post_content_container);
        this.iwu.setDrawingCacheEnabled(false);
        this.iwr.setVisibility(0);
        this.iwv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        cbp();
    }

    public void cbm() {
        this.iwA = (LinearLayout) this.iwF.findViewById(d.g.post_share_layout);
        this.iwC = (ShareSDKImageView) this.iwF.findViewById(d.g.post_share_image);
        this.iwC.setIsRound(false);
        this.iwC.setDrawBorder(false);
        this.iwC.setAutoChangeStyle(true);
        this.iwC.setRadius(0);
        this.iwD = (TextView) this.iwF.findViewById(d.g.post_share_title);
        this.iwE = (TextView) this.iwF.findViewById(d.g.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.iwC.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void L(String str, boolean z) {
                        if (z) {
                            if (c.this.iwC.getLoadedWidth() != 0 && c.this.iwC.getLoadedHeight() != 0) {
                                c.this.width = c.this.iwC.getLoadedWidth();
                                c.this.height = c.this.iwC.getLoadedHeight();
                                if (c.this.iwF != null) {
                                    c.this.iwF.getWriteData().setShareSummaryImgWidth(c.this.width);
                                    c.this.iwF.getWriteData().setShareSummaryImgHeight(c.this.height);
                                    c.this.iwH = true;
                                    c.this.cbp();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.iwH = false;
                        c.this.cbp();
                        if (c.this.iwF != null) {
                            c.this.iwF.yT(d.j.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.iwH = false;
                        c.this.cbp();
                        if (c.this.iwF != null) {
                            c.this.iwF.yT(d.j.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.iwC.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.iwH = true;
                    cbp();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.iwC.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(m.b(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.ai(ar.adm().ads(), ar.adm().adt()));
                    this.iwC.setTag(imageFileInfo.toCachedKey(true));
                    if (this.iwG.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.iwA.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.iwC.invalidate();
                    }
                }
                this.iwH = true;
                cbp();
            }
            this.mData.setShareSummaryImgType(f.bp(this.mData.getShareSummaryImg()));
            this.iwD.setText(this.mData.getShareSummaryTitle());
            this.iwE.setText(this.mData.getShareSummaryContent());
        }
    }

    private void cbn() {
        this.iwz = this.iwF.findViewById(d.g.post_prefix_layout);
        this.iww = (TextView) this.iwF.findViewById(d.g.post_prefix);
        this.iwy = (ImageView) this.iwF.findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.iwz.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iww.setText(prefixs.get(0));
            this.iwF.yU(0);
            this.iwz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.iww.setVisibility(0);
                    c.this.iwz.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.iwx, view, l.dip2px(c.this.iwF.getPageContext().getContext(), 15.0f), l.dip2px(c.this.iwF.getPageContext().getContext(), 1.0f));
                    if (c.this.iwF != null) {
                        c.this.iwF.cbl();
                    }
                }
            });
            this.iwy = (ImageView) this.iwF.findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.iwy.setVisibility(0);
                this.iww.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.iww.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.iwx, view, l.dip2px(c.this.iwF.getPageContext().getContext(), 15.0f), l.dip2px(c.this.iwF.getPageContext().getContext(), 1.0f));
                        if (c.this.iwF != null) {
                            c.this.iwF.cbl();
                        }
                    }
                });
            }
            this.iwx = new h(this.iwF.getPageContext().getContext());
            this.iwx.setMaxHeight(l.dip2px(this.iwF.getPageContext().getContext(), 225.0f));
            this.iwx.setOutsideTouchable(true);
            this.iwx.setFocusable(true);
            this.iwx.setBackgroundDrawable(al.getDrawable(d.C0277d.cp_bg_line_b));
            this.iwx.a(new h.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.h.a
                public void yV(int i) {
                    c.this.iwF.yU(i);
                    c.this.iww.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.iwx.setCurrentIndex(i);
                    c.this.cbp();
                    g.a(c.this.iwx, c.this.iwF.getPageContext().getPageActivity());
                }
            });
            this.iwx.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.iwz.setSelected(false);
                }
            });
            int color = al.getColor(d.C0277d.common_color_10097);
            al.k(this.iww, d.f.write_prefix_item_selector);
            al.c(this.iwy, d.f.icon_title_down);
            this.iww.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.iwF.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.iwF.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                al.k(textView, d.f.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.iwF.getPageContext().getContext(), this.iwF.getResources().getDimension(d.e.ds6)), 0, l.dip2px(this.iwF.getPageContext().getContext(), this.iwF.getResources().getDimension(d.e.ds22)), 0);
                this.iwx.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.iwF.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.iwF.getPageContext().getContext(), this.iwF.getResources().getDimension(d.e.ds6)), 0, l.dip2px(this.iwF.getPageContext().getContext(), this.iwF.getResources().getDimension(d.e.ds22)), 0);
                }
            }
            this.iwx.setCurrentIndex(0);
            return;
        }
        this.iwz.setVisibility(8);
    }

    protected void cbo() {
        this.iwr = (EditText) this.iwF.findViewById(d.g.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.iwr.setText(this.mData.getTitle());
                this.iwr.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.iwF.getPageContext().getString(d.j.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.iwr.setText(str);
                if (str.length() < 20) {
                    this.iwr.setSelection(str.length());
                } else {
                    this.iwr.setSelection(20);
                }
            }
        }
        this.iwr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
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
            String trim = this.iwr.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.iwF.cbj() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.iwH) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void cbq() {
        this.iwv = (EditText) this.iwF.findViewById(d.g.post_content);
        this.iwv.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString ax = TbFaceManager.anl().ax(this.iwF.getPageContext().getContext(), this.mData.getContent());
            this.iwv.setText(ax);
            this.iwv.setSelection(ax.length());
        }
        this.iwv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iwv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
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
        return this.iwr;
    }

    public EditText cbs() {
        return this.iwv;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        cbn();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.iwr.setOnFocusChangeListener(onFocusChangeListener);
        this.iwv.setOnFocusChangeListener(onFocusChangeListener);
        this.bWc.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public h cbt() {
        return this.iwx;
    }

    public View cbu() {
        return this.bWc;
    }

    public TextView cbv() {
        return this.mPost;
    }

    public TextView cbw() {
        return this.iww;
    }

    public void V(View.OnClickListener onClickListener) {
        this.bWc.setOnClickListener(onClickListener);
    }

    public void W(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void X(View.OnClickListener onClickListener) {
        this.iwu.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.iwF != null) {
            this.iwF.getLayoutMode().setNightMode(i == 1);
            this.iwF.getLayoutMode().onModeChanged(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.iwF.getPageContext(), i);
            al.d(this.mPost, i);
            al.l(this.iws, d.C0277d.cp_bg_line_c);
            al.l(this.iwt, d.C0277d.cp_bg_line_c);
            al.l(this.iwr, d.C0277d.cp_cont_g);
            al.l(this.iwB, d.C0277d.cp_bg_line_e);
            int color = al.getColor(d.C0277d.cp_cont_b);
            int color2 = al.getColor(d.C0277d.cp_cont_e);
            this.iwr.setTextColor(color);
            this.iwv.setTextColor(color);
            this.iwD.setTextColor(al.getColor(d.C0277d.cp_cont_b));
            this.iwE.setTextColor(al.getColor(d.C0277d.cp_cont_d));
            f(this.iwr, color2);
            f(this.iwv, color2);
            cbp();
        }
    }

    public ShareSDKImageView cbx() {
        return this.iwC;
    }
}
