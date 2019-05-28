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
import com.baidu.tbadk.img.effect.d;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.h;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class c {
    private View iPi;
    private TextView iPl;
    private h iPm;
    private ImageView iPn;
    private View iPo;
    private LinearLayout iPp;
    private LinearLayout iPq;
    private ShareSDKImageView iPr;
    private TextView iPs;
    private TextView iPt;
    private WriteShareActivity iPu;
    private com.baidu.tbadk.img.b iPv;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View cdX = null;
    private EditText iPg = null;
    private View iPh = null;
    private LinearLayout iPj = null;
    private EditText iPk = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean iPw = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.iPu = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.iPv == null) {
            this.iPv = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.iPu.findViewById(R.id.view_navigation_bar);
        this.cdX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iPu.getPageContext().getString(R.string.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iPu.getPageContext().getString(R.string.send_post));
        this.mParent = (RelativeLayout) this.iPu.findViewById(R.id.parent);
        this.iPh = this.iPu.findViewById(R.id.interval_view);
        this.iPi = this.iPu.findViewById(R.id.prefix_interval_view);
        this.iPp = (LinearLayout) this.iPu.findViewById(R.id.post_share_layout);
        this.iPq = (LinearLayout) this.iPu.findViewById(R.id.post_share_content_layout);
        this.iPr = (ShareSDKImageView) this.iPu.findViewById(R.id.post_share_image);
        this.iPs = (TextView) this.iPu.findViewById(R.id.post_share_title);
        this.iPt = (TextView) this.iPu.findViewById(R.id.post_share_content);
        cjv();
        cjx();
        this.iPj = (LinearLayout) this.iPu.findViewById(R.id.post_content_container);
        this.iPj.setDrawingCacheEnabled(false);
        this.iPg.setVisibility(0);
        this.iPk.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        cjw();
    }

    public void cjt() {
        this.iPp = (LinearLayout) this.iPu.findViewById(R.id.post_share_layout);
        this.iPr = (ShareSDKImageView) this.iPu.findViewById(R.id.post_share_image);
        this.iPr.setIsRound(false);
        this.iPr.setDrawBorder(false);
        this.iPr.setAutoChangeStyle(true);
        this.iPr.setRadius(0);
        this.iPs = (TextView) this.iPu.findViewById(R.id.post_share_title);
        this.iPt = (TextView) this.iPu.findViewById(R.id.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.iPr.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void O(String str, boolean z) {
                        if (z) {
                            if (c.this.iPr.getLoadedWidth() != 0 && c.this.iPr.getLoadedHeight() != 0) {
                                c.this.width = c.this.iPr.getLoadedWidth();
                                c.this.height = c.this.iPr.getLoadedHeight();
                                if (c.this.iPu != null) {
                                    c.this.iPu.getWriteData().setShareSummaryImgWidth(c.this.width);
                                    c.this.iPu.getWriteData().setShareSummaryImgHeight(c.this.height);
                                    c.this.iPw = true;
                                    c.this.cjw();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.iPw = false;
                        c.this.cjw();
                        if (c.this.iPu != null) {
                            c.this.iPu.Ab(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.iPw = false;
                        c.this.cjw();
                        if (c.this.iPu != null) {
                            c.this.iPu.Ab(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.iPr.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.iPw = true;
                    cjw();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.iPr.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(m.b(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.ai(ar.ail().air(), ar.ail().ais()));
                    this.iPr.setTag(imageFileInfo.toCachedKey(true));
                    if (this.iPv.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.iPp.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.iPr.invalidate();
                    }
                }
                this.iPw = true;
                cjw();
            }
            this.mData.setShareSummaryImgType(f.aZ(this.mData.getShareSummaryImg()));
            this.iPs.setText(this.mData.getShareSummaryTitle());
            this.iPt.setText(this.mData.getShareSummaryContent());
        }
    }

    private void cju() {
        this.iPo = this.iPu.findViewById(R.id.post_prefix_layout);
        this.iPl = (TextView) this.iPu.findViewById(R.id.post_prefix);
        this.iPn = (ImageView) this.iPu.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.iPo.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iPl.setText(prefixs.get(0));
            this.iPu.Ac(0);
            this.iPo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.iPl.setVisibility(0);
                    c.this.iPo.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.iPm, view, l.dip2px(c.this.iPu.getPageContext().getContext(), 15.0f), l.dip2px(c.this.iPu.getPageContext().getContext(), 1.0f));
                    if (c.this.iPu != null) {
                        c.this.iPu.cjs();
                    }
                }
            });
            this.iPn = (ImageView) this.iPu.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.iPn.setVisibility(0);
                this.iPl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.iPl.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.iPm, view, l.dip2px(c.this.iPu.getPageContext().getContext(), 15.0f), l.dip2px(c.this.iPu.getPageContext().getContext(), 1.0f));
                        if (c.this.iPu != null) {
                            c.this.iPu.cjs();
                        }
                    }
                });
            }
            this.iPm = new h(this.iPu.getPageContext().getContext());
            this.iPm.setMaxHeight(l.dip2px(this.iPu.getPageContext().getContext(), 225.0f));
            this.iPm.setOutsideTouchable(true);
            this.iPm.setFocusable(true);
            this.iPm.setBackgroundDrawable(al.getDrawable(R.color.cp_bg_line_b));
            this.iPm.a(new h.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.h.a
                public void Ad(int i) {
                    c.this.iPu.Ac(i);
                    c.this.iPl.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.iPm.setCurrentIndex(i);
                    c.this.cjw();
                    g.a(c.this.iPm, c.this.iPu.getPageContext().getPageActivity());
                }
            });
            this.iPm.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.iPo.setSelected(false);
                }
            });
            int color = al.getColor(R.color.common_color_10097);
            al.k(this.iPl, R.drawable.write_prefix_item_selector);
            al.c(this.iPn, (int) R.drawable.icon_title_down);
            this.iPl.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.iPu.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.iPu.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                al.k(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.iPu.getPageContext().getContext(), this.iPu.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.iPu.getPageContext().getContext(), this.iPu.getResources().getDimension(R.dimen.ds22)), 0);
                this.iPm.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.iPu.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.iPu.getPageContext().getContext(), this.iPu.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.iPu.getPageContext().getContext(), this.iPu.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.iPm.setCurrentIndex(0);
            return;
        }
        this.iPo.setVisibility(8);
    }

    protected void cjv() {
        this.iPg = (EditText) this.iPu.findViewById(R.id.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.iPg.setText(this.mData.getTitle());
                this.iPg.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.iPu.getPageContext().getString(R.string.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.iPg.setText(str);
                if (str.length() < 20) {
                    this.iPg.setSelection(str.length());
                } else {
                    this.iPg.setSelection(20);
                }
            }
        }
        this.iPg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cjw();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void cjw() {
        String str = null;
        if (this.mData.getType() == 3) {
            String trim = this.iPg.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.iPu.cjq() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.iPw) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void cjx() {
        this.iPk = (EditText) this.iPu.findViewById(R.id.post_content);
        this.iPk.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString al = TbFaceManager.aso().al(this.iPu.getPageContext().getContext(), this.mData.getContent());
            this.iPk.setText(al);
            this.iPk.setSelection(al.length());
        }
        this.iPk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iPk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cjw();
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

    public EditText cjy() {
        return this.iPg;
    }

    public EditText cjz() {
        return this.iPk;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        cju();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.iPg.setOnFocusChangeListener(onFocusChangeListener);
        this.iPk.setOnFocusChangeListener(onFocusChangeListener);
        this.cdX.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public h cjA() {
        return this.iPm;
    }

    public View cjB() {
        return this.cdX;
    }

    public TextView cjC() {
        return this.mPost;
    }

    public TextView cjD() {
        return this.iPl;
    }

    public void Y(View.OnClickListener onClickListener) {
        this.cdX.setOnClickListener(onClickListener);
    }

    public void Z(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void aa(View.OnClickListener onClickListener) {
        this.iPj.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.iPu != null) {
            this.iPu.getLayoutMode().setNightMode(i == 1);
            this.iPu.getLayoutMode().onModeChanged(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.iPu.getPageContext(), i);
            al.d(this.mPost, i);
            al.l(this.iPh, R.color.cp_bg_line_c);
            al.l(this.iPi, R.color.cp_bg_line_c);
            al.l(this.iPg, R.color.cp_cont_g);
            al.l(this.iPq, R.color.cp_bg_line_e);
            int color = al.getColor(R.color.cp_cont_b);
            int color2 = al.getColor(R.color.cp_cont_e);
            this.iPg.setTextColor(color);
            this.iPk.setTextColor(color);
            this.iPs.setTextColor(al.getColor(R.color.cp_cont_b));
            this.iPt.setTextColor(al.getColor(R.color.cp_cont_d));
            f(this.iPg, color2);
            f(this.iPk, color2);
            cjw();
        }
    }

    public ShareSDKImageView cjE() {
        return this.iPr;
    }
}
