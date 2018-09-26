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
    private View gKY;
    private TextView gLb;
    private d gLc;
    private ImageView gLd;
    private View gLe;
    private LinearLayout gLf;
    private LinearLayout gLg;
    private ShareSDKImageView gLh;
    private TextView gLi;
    private TextView gLj;
    private WriteShareActivity gLk;
    private com.baidu.tbadk.img.b gLl;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View aEa = null;
    private EditText gKW = null;
    private View gKX = null;
    private LinearLayout gKZ = null;
    private EditText gLa = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean gLm = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.gLk = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.gLl == null) {
            this.gLl = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.gLk.findViewById(e.g.view_navigation_bar);
        this.aEa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gLk.getPageContext().getString(e.j.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gLk.getPageContext().getString(e.j.send_post));
        this.mParent = (RelativeLayout) this.gLk.findViewById(e.g.parent);
        this.gKX = this.gLk.findViewById(e.g.interval_view);
        this.gKY = this.gLk.findViewById(e.g.prefix_interval_view);
        this.gLf = (LinearLayout) this.gLk.findViewById(e.g.post_share_layout);
        this.gLg = (LinearLayout) this.gLk.findViewById(e.g.post_share_content_layout);
        this.gLh = (ShareSDKImageView) this.gLk.findViewById(e.g.post_share_image);
        this.gLi = (TextView) this.gLk.findViewById(e.g.post_share_title);
        this.gLj = (TextView) this.gLk.findViewById(e.g.post_share_content);
        buy();
        buA();
        this.gKZ = (LinearLayout) this.gLk.findViewById(e.g.post_content_container);
        this.gKZ.setDrawingCacheEnabled(false);
        this.gKW.setVisibility(0);
        this.gLa.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        buz();
    }

    public void buw() {
        this.gLf = (LinearLayout) this.gLk.findViewById(e.g.post_share_layout);
        this.gLh = (ShareSDKImageView) this.gLk.findViewById(e.g.post_share_image);
        this.gLh.setIsRound(false);
        this.gLh.setDrawBorder(false);
        this.gLh.setAutoChangeStyle(true);
        this.gLh.setRadius(0);
        this.gLi = (TextView) this.gLk.findViewById(e.g.post_share_title);
        this.gLj = (TextView) this.gLk.findViewById(e.g.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.gLh.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void k(String str, boolean z) {
                        if (z) {
                            if (c.this.gLh.getLoadedWidth() != 0 && c.this.gLh.getLoadedHeight() != 0) {
                                c.this.width = c.this.gLh.getLoadedWidth();
                                c.this.height = c.this.gLh.getLoadedHeight();
                                if (c.this.gLk != null) {
                                    c.this.gLk.getWriteData().setShareSummaryImgWidth(c.this.width);
                                    c.this.gLk.getWriteData().setShareSummaryImgHeight(c.this.height);
                                    c.this.gLm = true;
                                    c.this.buz();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.gLm = false;
                        c.this.buz();
                        if (c.this.gLk != null) {
                            c.this.gLk.tF(e.j.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.gLm = false;
                        c.this.buz();
                        if (c.this.gLk != null) {
                            c.this.gLk.tF(e.j.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.gLh.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.gLm = true;
                    buz();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.gLh.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(l.b(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.K(aq.Az().AF(), aq.Az().AG()));
                    this.gLh.setTag(imageFileInfo.toCachedKey(true));
                    if (this.gLl.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.gLf.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.gLh.invalidate();
                    }
                }
                this.gLm = true;
                buz();
            }
            this.mData.setShareSummaryImgType(f.bq(this.mData.getShareSummaryImg()));
            this.gLi.setText(this.mData.getShareSummaryTitle());
            this.gLj.setText(this.mData.getShareSummaryContent());
        }
    }

    private void bux() {
        this.gLe = this.gLk.findViewById(e.g.post_prefix_layout);
        this.gLb = (TextView) this.gLk.findViewById(e.g.post_prefix);
        this.gLd = (ImageView) this.gLk.findViewById(e.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.gLe.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gLb.setText(prefixs.get(0));
            this.gLk.tG(0);
            this.gLe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.gLb.setVisibility(0);
                    c.this.gLe.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.gLc, view, com.baidu.adp.lib.util.l.dip2px(c.this.gLk.getPageContext().getContext(), 15.0f), com.baidu.adp.lib.util.l.dip2px(c.this.gLk.getPageContext().getContext(), 1.0f));
                    if (c.this.gLk != null) {
                        c.this.gLk.buv();
                    }
                }
            });
            this.gLd = (ImageView) this.gLk.findViewById(e.g.prefix_icon);
            if (size > 1) {
                this.gLd.setVisibility(0);
                this.gLb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.gLb.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.gLc, view, com.baidu.adp.lib.util.l.dip2px(c.this.gLk.getPageContext().getContext(), 15.0f), com.baidu.adp.lib.util.l.dip2px(c.this.gLk.getPageContext().getContext(), 1.0f));
                        if (c.this.gLk != null) {
                            c.this.gLk.buv();
                        }
                    }
                });
            }
            this.gLc = new d(this.gLk.getPageContext().getContext());
            this.gLc.setMaxHeight(com.baidu.adp.lib.util.l.dip2px(this.gLk.getPageContext().getContext(), 225.0f));
            this.gLc.setOutsideTouchable(true);
            this.gLc.setFocusable(true);
            this.gLc.setBackgroundDrawable(al.getDrawable(e.d.cp_bg_line_b));
            this.gLc.a(new d.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.d.a
                public void tH(int i) {
                    c.this.gLk.tG(i);
                    c.this.gLb.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.gLc.setCurrentIndex(i);
                    c.this.buz();
                    g.a(c.this.gLc, c.this.gLk.getPageContext().getPageActivity());
                }
            });
            this.gLc.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.gLe.setSelected(false);
                }
            });
            int color = al.getColor(e.d.common_color_10097);
            al.i(this.gLb, e.f.write_prefix_item_selector);
            al.c(this.gLd, e.f.icon_title_down);
            this.gLb.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.gLk.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.dip2px(this.gLk.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                al.i(textView, e.f.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.gLk.getPageContext().getContext(), this.gLk.getResources().getDimension(e.C0141e.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.gLk.getPageContext().getContext(), this.gLk.getResources().getDimension(e.C0141e.ds22)), 0);
                this.gLc.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.dip2px(this.gLk.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.gLk.getPageContext().getContext(), this.gLk.getResources().getDimension(e.C0141e.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.gLk.getPageContext().getContext(), this.gLk.getResources().getDimension(e.C0141e.ds22)), 0);
                }
            }
            this.gLc.setCurrentIndex(0);
            return;
        }
        this.gLe.setVisibility(8);
    }

    protected void buy() {
        this.gKW = (EditText) this.gLk.findViewById(e.g.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.gKW.setText(this.mData.getTitle());
                this.gKW.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.gLk.getPageContext().getString(e.j.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.gKW.setText(str);
                if (str.length() < 20) {
                    this.gKW.setSelection(str.length());
                } else {
                    this.gKW.setSelection(20);
                }
            }
        }
        this.gKW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.buz();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void buz() {
        String str = null;
        if (this.mData.getType() == 3) {
            String trim = this.gKW.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.gLk.but() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.gLm) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void buA() {
        this.gLa = (EditText) this.gLk.findViewById(e.g.post_content);
        this.gLa.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString al = TbFaceManager.Kf().al(this.gLk.getPageContext().getContext(), this.mData.getContent());
            this.gLa.setText(al);
            this.gLa.setSelection(al.length());
        }
        this.gLa.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gLa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.buz();
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

    public EditText buB() {
        return this.gKW;
    }

    public EditText buC() {
        return this.gLa;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        bux();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.gKW.setOnFocusChangeListener(onFocusChangeListener);
        this.gLa.setOnFocusChangeListener(onFocusChangeListener);
        this.aEa.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public d buD() {
        return this.gLc;
    }

    public View buE() {
        return this.aEa;
    }

    public TextView buF() {
        return this.mPost;
    }

    public TextView buG() {
        return this.gLb;
    }

    public void T(View.OnClickListener onClickListener) {
        this.aEa.setOnClickListener(onClickListener);
    }

    public void U(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void V(View.OnClickListener onClickListener) {
        this.gKZ.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.gLk != null) {
            this.gLk.getLayoutMode().setNightMode(i == 1);
            this.gLk.getLayoutMode().onModeChanged(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.gLk.getPageContext(), i);
            al.d(this.mPost, i);
            al.j(this.gKX, e.d.cp_bg_line_c);
            al.j(this.gKY, e.d.cp_bg_line_c);
            al.j(this.gKW, e.d.cp_cont_g);
            al.j(this.gLg, e.d.cp_bg_line_e);
            int color = al.getColor(e.d.cp_cont_b);
            int color2 = al.getColor(e.d.cp_cont_e);
            this.gKW.setTextColor(color);
            this.gLa.setTextColor(color);
            this.gLi.setTextColor(al.getColor(e.d.cp_cont_b));
            this.gLj.setTextColor(al.getColor(e.d.cp_cont_d));
            b(this.gKW, color2);
            b(this.gLa, color2);
            buz();
        }
    }

    public ShareSDKImageView buH() {
        return this.gLh;
    }
}
