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
    private View iPg;
    private TextView iPj;
    private h iPk;
    private ImageView iPl;
    private View iPm;
    private LinearLayout iPn;
    private LinearLayout iPo;
    private ShareSDKImageView iPp;
    private TextView iPq;
    private TextView iPr;
    private WriteShareActivity iPs;
    private com.baidu.tbadk.img.b iPt;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View cdX = null;
    private EditText iPe = null;
    private View iPf = null;
    private LinearLayout iPh = null;
    private EditText iPi = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean iPu = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.iPs = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.iPt == null) {
            this.iPt = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.iPs.findViewById(R.id.view_navigation_bar);
        this.cdX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iPs.getPageContext().getString(R.string.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iPs.getPageContext().getString(R.string.send_post));
        this.mParent = (RelativeLayout) this.iPs.findViewById(R.id.parent);
        this.iPf = this.iPs.findViewById(R.id.interval_view);
        this.iPg = this.iPs.findViewById(R.id.prefix_interval_view);
        this.iPn = (LinearLayout) this.iPs.findViewById(R.id.post_share_layout);
        this.iPo = (LinearLayout) this.iPs.findViewById(R.id.post_share_content_layout);
        this.iPp = (ShareSDKImageView) this.iPs.findViewById(R.id.post_share_image);
        this.iPq = (TextView) this.iPs.findViewById(R.id.post_share_title);
        this.iPr = (TextView) this.iPs.findViewById(R.id.post_share_content);
        cjt();
        cjv();
        this.iPh = (LinearLayout) this.iPs.findViewById(R.id.post_content_container);
        this.iPh.setDrawingCacheEnabled(false);
        this.iPe.setVisibility(0);
        this.iPi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        cju();
    }

    public void cjr() {
        this.iPn = (LinearLayout) this.iPs.findViewById(R.id.post_share_layout);
        this.iPp = (ShareSDKImageView) this.iPs.findViewById(R.id.post_share_image);
        this.iPp.setIsRound(false);
        this.iPp.setDrawBorder(false);
        this.iPp.setAutoChangeStyle(true);
        this.iPp.setRadius(0);
        this.iPq = (TextView) this.iPs.findViewById(R.id.post_share_title);
        this.iPr = (TextView) this.iPs.findViewById(R.id.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.iPp.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void O(String str, boolean z) {
                        if (z) {
                            if (c.this.iPp.getLoadedWidth() != 0 && c.this.iPp.getLoadedHeight() != 0) {
                                c.this.width = c.this.iPp.getLoadedWidth();
                                c.this.height = c.this.iPp.getLoadedHeight();
                                if (c.this.iPs != null) {
                                    c.this.iPs.getWriteData().setShareSummaryImgWidth(c.this.width);
                                    c.this.iPs.getWriteData().setShareSummaryImgHeight(c.this.height);
                                    c.this.iPu = true;
                                    c.this.cju();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.iPu = false;
                        c.this.cju();
                        if (c.this.iPs != null) {
                            c.this.iPs.Ab(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.iPu = false;
                        c.this.cju();
                        if (c.this.iPs != null) {
                            c.this.iPs.Ab(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.iPp.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.iPu = true;
                    cju();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.iPp.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(m.b(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.ai(ar.ail().air(), ar.ail().ais()));
                    this.iPp.setTag(imageFileInfo.toCachedKey(true));
                    if (this.iPt.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.iPn.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.iPp.invalidate();
                    }
                }
                this.iPu = true;
                cju();
            }
            this.mData.setShareSummaryImgType(f.aZ(this.mData.getShareSummaryImg()));
            this.iPq.setText(this.mData.getShareSummaryTitle());
            this.iPr.setText(this.mData.getShareSummaryContent());
        }
    }

    private void cjs() {
        this.iPm = this.iPs.findViewById(R.id.post_prefix_layout);
        this.iPj = (TextView) this.iPs.findViewById(R.id.post_prefix);
        this.iPl = (ImageView) this.iPs.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.iPm.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iPj.setText(prefixs.get(0));
            this.iPs.Ac(0);
            this.iPm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.iPj.setVisibility(0);
                    c.this.iPm.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.iPk, view, l.dip2px(c.this.iPs.getPageContext().getContext(), 15.0f), l.dip2px(c.this.iPs.getPageContext().getContext(), 1.0f));
                    if (c.this.iPs != null) {
                        c.this.iPs.cjq();
                    }
                }
            });
            this.iPl = (ImageView) this.iPs.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.iPl.setVisibility(0);
                this.iPj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.iPj.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.iPk, view, l.dip2px(c.this.iPs.getPageContext().getContext(), 15.0f), l.dip2px(c.this.iPs.getPageContext().getContext(), 1.0f));
                        if (c.this.iPs != null) {
                            c.this.iPs.cjq();
                        }
                    }
                });
            }
            this.iPk = new h(this.iPs.getPageContext().getContext());
            this.iPk.setMaxHeight(l.dip2px(this.iPs.getPageContext().getContext(), 225.0f));
            this.iPk.setOutsideTouchable(true);
            this.iPk.setFocusable(true);
            this.iPk.setBackgroundDrawable(al.getDrawable(R.color.cp_bg_line_b));
            this.iPk.a(new h.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.h.a
                public void Ad(int i) {
                    c.this.iPs.Ac(i);
                    c.this.iPj.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.iPk.setCurrentIndex(i);
                    c.this.cju();
                    g.a(c.this.iPk, c.this.iPs.getPageContext().getPageActivity());
                }
            });
            this.iPk.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.iPm.setSelected(false);
                }
            });
            int color = al.getColor(R.color.common_color_10097);
            al.k(this.iPj, R.drawable.write_prefix_item_selector);
            al.c(this.iPl, (int) R.drawable.icon_title_down);
            this.iPj.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.iPs.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.iPs.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                al.k(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.iPs.getPageContext().getContext(), this.iPs.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.iPs.getPageContext().getContext(), this.iPs.getResources().getDimension(R.dimen.ds22)), 0);
                this.iPk.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.iPs.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.iPs.getPageContext().getContext(), this.iPs.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.iPs.getPageContext().getContext(), this.iPs.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.iPk.setCurrentIndex(0);
            return;
        }
        this.iPm.setVisibility(8);
    }

    protected void cjt() {
        this.iPe = (EditText) this.iPs.findViewById(R.id.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.iPe.setText(this.mData.getTitle());
                this.iPe.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.iPs.getPageContext().getString(R.string.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.iPe.setText(str);
                if (str.length() < 20) {
                    this.iPe.setSelection(str.length());
                } else {
                    this.iPe.setSelection(20);
                }
            }
        }
        this.iPe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cju();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void cju() {
        String str = null;
        if (this.mData.getType() == 3) {
            String trim = this.iPe.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.iPs.cjo() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.iPu) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void cjv() {
        this.iPi = (EditText) this.iPs.findViewById(R.id.post_content);
        this.iPi.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString al = TbFaceManager.aso().al(this.iPs.getPageContext().getContext(), this.mData.getContent());
            this.iPi.setText(al);
            this.iPi.setSelection(al.length());
        }
        this.iPi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iPi.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cju();
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

    public EditText cjw() {
        return this.iPe;
    }

    public EditText cjx() {
        return this.iPi;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        cjs();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.iPe.setOnFocusChangeListener(onFocusChangeListener);
        this.iPi.setOnFocusChangeListener(onFocusChangeListener);
        this.cdX.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public h cjy() {
        return this.iPk;
    }

    public View cjz() {
        return this.cdX;
    }

    public TextView cjA() {
        return this.mPost;
    }

    public TextView cjB() {
        return this.iPj;
    }

    public void Y(View.OnClickListener onClickListener) {
        this.cdX.setOnClickListener(onClickListener);
    }

    public void Z(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void aa(View.OnClickListener onClickListener) {
        this.iPh.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.iPs != null) {
            this.iPs.getLayoutMode().setNightMode(i == 1);
            this.iPs.getLayoutMode().onModeChanged(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.iPs.getPageContext(), i);
            al.d(this.mPost, i);
            al.l(this.iPf, R.color.cp_bg_line_c);
            al.l(this.iPg, R.color.cp_bg_line_c);
            al.l(this.iPe, R.color.cp_cont_g);
            al.l(this.iPo, R.color.cp_bg_line_e);
            int color = al.getColor(R.color.cp_cont_b);
            int color2 = al.getColor(R.color.cp_cont_e);
            this.iPe.setTextColor(color);
            this.iPi.setTextColor(color);
            this.iPq.setTextColor(al.getColor(R.color.cp_cont_b));
            this.iPr.setTextColor(al.getColor(R.color.cp_cont_d));
            f(this.iPe, color2);
            f(this.iPi, color2);
            cju();
        }
    }

    public ShareSDKImageView cjC() {
        return this.iPp;
    }
}
