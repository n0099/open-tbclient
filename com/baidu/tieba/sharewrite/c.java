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
    private View iPm;
    private TextView iPp;
    private h iPq;
    private ImageView iPr;
    private View iPs;
    private LinearLayout iPt;
    private LinearLayout iPu;
    private ShareSDKImageView iPv;
    private TextView iPw;
    private TextView iPx;
    private WriteShareActivity iPy;
    private com.baidu.tbadk.img.b iPz;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View cdY = null;
    private EditText iPk = null;
    private View iPl = null;
    private LinearLayout iPn = null;
    private EditText iPo = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean iPA = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.iPy = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.iPz == null) {
            this.iPz = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.iPy.findViewById(R.id.view_navigation_bar);
        this.cdY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iPy.getPageContext().getString(R.string.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iPy.getPageContext().getString(R.string.send_post));
        this.mParent = (RelativeLayout) this.iPy.findViewById(R.id.parent);
        this.iPl = this.iPy.findViewById(R.id.interval_view);
        this.iPm = this.iPy.findViewById(R.id.prefix_interval_view);
        this.iPt = (LinearLayout) this.iPy.findViewById(R.id.post_share_layout);
        this.iPu = (LinearLayout) this.iPy.findViewById(R.id.post_share_content_layout);
        this.iPv = (ShareSDKImageView) this.iPy.findViewById(R.id.post_share_image);
        this.iPw = (TextView) this.iPy.findViewById(R.id.post_share_title);
        this.iPx = (TextView) this.iPy.findViewById(R.id.post_share_content);
        cjw();
        cjy();
        this.iPn = (LinearLayout) this.iPy.findViewById(R.id.post_content_container);
        this.iPn.setDrawingCacheEnabled(false);
        this.iPk.setVisibility(0);
        this.iPo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        cjx();
    }

    public void cju() {
        this.iPt = (LinearLayout) this.iPy.findViewById(R.id.post_share_layout);
        this.iPv = (ShareSDKImageView) this.iPy.findViewById(R.id.post_share_image);
        this.iPv.setIsRound(false);
        this.iPv.setDrawBorder(false);
        this.iPv.setAutoChangeStyle(true);
        this.iPv.setRadius(0);
        this.iPw = (TextView) this.iPy.findViewById(R.id.post_share_title);
        this.iPx = (TextView) this.iPy.findViewById(R.id.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.iPv.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void O(String str, boolean z) {
                        if (z) {
                            if (c.this.iPv.getLoadedWidth() != 0 && c.this.iPv.getLoadedHeight() != 0) {
                                c.this.width = c.this.iPv.getLoadedWidth();
                                c.this.height = c.this.iPv.getLoadedHeight();
                                if (c.this.iPy != null) {
                                    c.this.iPy.getWriteData().setShareSummaryImgWidth(c.this.width);
                                    c.this.iPy.getWriteData().setShareSummaryImgHeight(c.this.height);
                                    c.this.iPA = true;
                                    c.this.cjx();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.iPA = false;
                        c.this.cjx();
                        if (c.this.iPy != null) {
                            c.this.iPy.Ab(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.iPA = false;
                        c.this.cjx();
                        if (c.this.iPy != null) {
                            c.this.iPy.Ab(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.iPv.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.iPA = true;
                    cjx();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.iPv.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(m.b(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.ai(ar.ail().air(), ar.ail().ais()));
                    this.iPv.setTag(imageFileInfo.toCachedKey(true));
                    if (this.iPz.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.iPt.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.iPv.invalidate();
                    }
                }
                this.iPA = true;
                cjx();
            }
            this.mData.setShareSummaryImgType(f.aZ(this.mData.getShareSummaryImg()));
            this.iPw.setText(this.mData.getShareSummaryTitle());
            this.iPx.setText(this.mData.getShareSummaryContent());
        }
    }

    private void cjv() {
        this.iPs = this.iPy.findViewById(R.id.post_prefix_layout);
        this.iPp = (TextView) this.iPy.findViewById(R.id.post_prefix);
        this.iPr = (ImageView) this.iPy.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.iPs.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iPp.setText(prefixs.get(0));
            this.iPy.Ac(0);
            this.iPs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.iPp.setVisibility(0);
                    c.this.iPs.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.iPq, view, l.dip2px(c.this.iPy.getPageContext().getContext(), 15.0f), l.dip2px(c.this.iPy.getPageContext().getContext(), 1.0f));
                    if (c.this.iPy != null) {
                        c.this.iPy.cjt();
                    }
                }
            });
            this.iPr = (ImageView) this.iPy.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.iPr.setVisibility(0);
                this.iPp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.iPp.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.iPq, view, l.dip2px(c.this.iPy.getPageContext().getContext(), 15.0f), l.dip2px(c.this.iPy.getPageContext().getContext(), 1.0f));
                        if (c.this.iPy != null) {
                            c.this.iPy.cjt();
                        }
                    }
                });
            }
            this.iPq = new h(this.iPy.getPageContext().getContext());
            this.iPq.setMaxHeight(l.dip2px(this.iPy.getPageContext().getContext(), 225.0f));
            this.iPq.setOutsideTouchable(true);
            this.iPq.setFocusable(true);
            this.iPq.setBackgroundDrawable(al.getDrawable(R.color.cp_bg_line_b));
            this.iPq.a(new h.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.h.a
                public void Ad(int i) {
                    c.this.iPy.Ac(i);
                    c.this.iPp.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.iPq.setCurrentIndex(i);
                    c.this.cjx();
                    g.a(c.this.iPq, c.this.iPy.getPageContext().getPageActivity());
                }
            });
            this.iPq.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.iPs.setSelected(false);
                }
            });
            int color = al.getColor(R.color.common_color_10097);
            al.k(this.iPp, R.drawable.write_prefix_item_selector);
            al.c(this.iPr, (int) R.drawable.icon_title_down);
            this.iPp.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.iPy.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.iPy.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                al.k(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.iPy.getPageContext().getContext(), this.iPy.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.iPy.getPageContext().getContext(), this.iPy.getResources().getDimension(R.dimen.ds22)), 0);
                this.iPq.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.iPy.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.iPy.getPageContext().getContext(), this.iPy.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.iPy.getPageContext().getContext(), this.iPy.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.iPq.setCurrentIndex(0);
            return;
        }
        this.iPs.setVisibility(8);
    }

    protected void cjw() {
        this.iPk = (EditText) this.iPy.findViewById(R.id.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.iPk.setText(this.mData.getTitle());
                this.iPk.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.iPy.getPageContext().getString(R.string.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.iPk.setText(str);
                if (str.length() < 20) {
                    this.iPk.setSelection(str.length());
                } else {
                    this.iPk.setSelection(20);
                }
            }
        }
        this.iPk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cjx();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void cjx() {
        String str = null;
        if (this.mData.getType() == 3) {
            String trim = this.iPk.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.iPy.cjr() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.iPA) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void cjy() {
        this.iPo = (EditText) this.iPy.findViewById(R.id.post_content);
        this.iPo.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString al = TbFaceManager.aso().al(this.iPy.getPageContext().getContext(), this.mData.getContent());
            this.iPo.setText(al);
            this.iPo.setSelection(al.length());
        }
        this.iPo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iPo.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cjx();
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

    public EditText cjz() {
        return this.iPk;
    }

    public EditText cjA() {
        return this.iPo;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        cjv();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.iPk.setOnFocusChangeListener(onFocusChangeListener);
        this.iPo.setOnFocusChangeListener(onFocusChangeListener);
        this.cdY.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public h cjB() {
        return this.iPq;
    }

    public View cjC() {
        return this.cdY;
    }

    public TextView cjD() {
        return this.mPost;
    }

    public TextView cjE() {
        return this.iPp;
    }

    public void Y(View.OnClickListener onClickListener) {
        this.cdY.setOnClickListener(onClickListener);
    }

    public void Z(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void aa(View.OnClickListener onClickListener) {
        this.iPn.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.iPy != null) {
            this.iPy.getLayoutMode().setNightMode(i == 1);
            this.iPy.getLayoutMode().onModeChanged(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.iPy.getPageContext(), i);
            al.d(this.mPost, i);
            al.l(this.iPl, R.color.cp_bg_line_c);
            al.l(this.iPm, R.color.cp_bg_line_c);
            al.l(this.iPk, R.color.cp_cont_g);
            al.l(this.iPu, R.color.cp_bg_line_e);
            int color = al.getColor(R.color.cp_cont_b);
            int color2 = al.getColor(R.color.cp_cont_e);
            this.iPk.setTextColor(color);
            this.iPo.setTextColor(color);
            this.iPw.setTextColor(al.getColor(R.color.cp_cont_b));
            this.iPx.setTextColor(al.getColor(R.color.cp_cont_d));
            f(this.iPk, color2);
            f(this.iPo, color2);
            cjx();
        }
    }

    public ShareSDKImageView cjF() {
        return this.iPv;
    }
}
