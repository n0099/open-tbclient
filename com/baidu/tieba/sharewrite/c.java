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
    private LinearLayout gDA;
    private ShareSDKImageView gDB;
    private TextView gDC;
    private TextView gDD;
    private WriteShareActivity gDE;
    private com.baidu.tbadk.img.b gDF;
    private View gDs;
    private TextView gDv;
    private d gDw;
    private ImageView gDx;
    private View gDy;
    private LinearLayout gDz;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View aAZ = null;
    private EditText gDq = null;
    private View gDr = null;
    private LinearLayout gDt = null;
    private EditText gDu = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean gDG = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.gDE = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.gDF == null) {
            this.gDF = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.gDE.findViewById(d.g.view_navigation_bar);
        this.aAZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gDE.getPageContext().getString(d.j.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gDE.getPageContext().getString(d.j.send_post));
        this.mParent = (RelativeLayout) this.gDE.findViewById(d.g.parent);
        this.gDr = this.gDE.findViewById(d.g.interval_view);
        this.gDs = this.gDE.findViewById(d.g.prefix_interval_view);
        this.gDz = (LinearLayout) this.gDE.findViewById(d.g.post_share_layout);
        this.gDA = (LinearLayout) this.gDE.findViewById(d.g.post_share_content_layout);
        this.gDB = (ShareSDKImageView) this.gDE.findViewById(d.g.post_share_image);
        this.gDC = (TextView) this.gDE.findViewById(d.g.post_share_title);
        this.gDD = (TextView) this.gDE.findViewById(d.g.post_share_content);
        brS();
        brU();
        this.gDt = (LinearLayout) this.gDE.findViewById(d.g.post_content_container);
        this.gDt.setDrawingCacheEnabled(false);
        this.gDq.setVisibility(0);
        this.gDu.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        brT();
    }

    public void brQ() {
        this.gDz = (LinearLayout) this.gDE.findViewById(d.g.post_share_layout);
        this.gDB = (ShareSDKImageView) this.gDE.findViewById(d.g.post_share_image);
        this.gDB.setIsRound(false);
        this.gDB.setDrawBorder(false);
        this.gDB.setAutoChangeStyle(true);
        this.gDB.setRadius(0);
        this.gDC = (TextView) this.gDE.findViewById(d.g.post_share_title);
        this.gDD = (TextView) this.gDE.findViewById(d.g.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.gDB.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void m(String str, boolean z) {
                        if (z) {
                            if (c.this.gDB.getLoadedWidth() != 0 && c.this.gDB.getLoadedHeight() != 0) {
                                c.this.width = c.this.gDB.getLoadedWidth();
                                c.this.height = c.this.gDB.getLoadedHeight();
                                if (c.this.gDE != null) {
                                    c.this.gDE.getWriteData().setShareSummaryImgWidth(c.this.width);
                                    c.this.gDE.getWriteData().setShareSummaryImgHeight(c.this.height);
                                    c.this.gDG = true;
                                    c.this.brT();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.gDG = false;
                        c.this.brT();
                        if (c.this.gDE != null) {
                            c.this.gDE.tf(d.j.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.gDG = false;
                        c.this.brT();
                        if (c.this.gDE != null) {
                            c.this.gDE.tf(d.j.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.gDB.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.gDG = true;
                    brT();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.gDB.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(l.b(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.I(ar.zw().zC(), ar.zw().zD()));
                    this.gDB.setTag(imageFileInfo.toCachedKey(true));
                    if (this.gDF.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.gDz.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.gDB.invalidate();
                    }
                }
                this.gDG = true;
                brT();
            }
            this.mData.setShareSummaryImgType(f.aZ(this.mData.getShareSummaryImg()));
            this.gDC.setText(this.mData.getShareSummaryTitle());
            this.gDD.setText(this.mData.getShareSummaryContent());
        }
    }

    private void brR() {
        this.gDy = this.gDE.findViewById(d.g.post_prefix_layout);
        this.gDv = (TextView) this.gDE.findViewById(d.g.post_prefix);
        this.gDx = (ImageView) this.gDE.findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.gDy.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gDv.setText(prefixs.get(0));
            this.gDE.tg(0);
            this.gDy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.gDv.setVisibility(0);
                    c.this.gDy.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.gDw, view, com.baidu.adp.lib.util.l.dip2px(c.this.gDE.getPageContext().getContext(), 15.0f), com.baidu.adp.lib.util.l.dip2px(c.this.gDE.getPageContext().getContext(), 1.0f));
                    if (c.this.gDE != null) {
                        c.this.gDE.brP();
                    }
                }
            });
            this.gDx = (ImageView) this.gDE.findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gDx.setVisibility(0);
                this.gDv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.gDv.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.gDw, view, com.baidu.adp.lib.util.l.dip2px(c.this.gDE.getPageContext().getContext(), 15.0f), com.baidu.adp.lib.util.l.dip2px(c.this.gDE.getPageContext().getContext(), 1.0f));
                        if (c.this.gDE != null) {
                            c.this.gDE.brP();
                        }
                    }
                });
            }
            this.gDw = new com.baidu.tieba.write.d(this.gDE.getPageContext().getContext());
            this.gDw.setMaxHeight(com.baidu.adp.lib.util.l.dip2px(this.gDE.getPageContext().getContext(), 225.0f));
            this.gDw.setOutsideTouchable(true);
            this.gDw.setFocusable(true);
            this.gDw.setBackgroundDrawable(am.getDrawable(d.C0140d.cp_bg_line_b));
            this.gDw.a(new d.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.d.a
                public void th(int i) {
                    c.this.gDE.tg(i);
                    c.this.gDv.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.gDw.setCurrentIndex(i);
                    c.this.brT();
                    g.a(c.this.gDw, c.this.gDE.getPageContext().getPageActivity());
                }
            });
            this.gDw.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.gDy.setSelected(false);
                }
            });
            int color = am.getColor(d.C0140d.common_color_10097);
            am.i(this.gDv, d.f.write_prefix_item_selector);
            am.c(this.gDx, d.f.icon_title_down);
            this.gDv.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.gDE.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.dip2px(this.gDE.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                am.i(textView, d.f.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.gDE.getPageContext().getContext(), this.gDE.getResources().getDimension(d.e.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.gDE.getPageContext().getContext(), this.gDE.getResources().getDimension(d.e.ds22)), 0);
                this.gDw.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.dip2px(this.gDE.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.gDE.getPageContext().getContext(), this.gDE.getResources().getDimension(d.e.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.gDE.getPageContext().getContext(), this.gDE.getResources().getDimension(d.e.ds22)), 0);
                }
            }
            this.gDw.setCurrentIndex(0);
            return;
        }
        this.gDy.setVisibility(8);
    }

    protected void brS() {
        this.gDq = (EditText) this.gDE.findViewById(d.g.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.gDq.setText(this.mData.getTitle());
                this.gDq.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.gDE.getPageContext().getString(d.j.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.gDq.setText(str);
                if (str.length() < 20) {
                    this.gDq.setSelection(str.length());
                } else {
                    this.gDq.setSelection(20);
                }
            }
        }
        this.gDq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.brT();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void brT() {
        String str = null;
        if (this.mData.getType() == 3) {
            String trim = this.gDq.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.gDE.brN() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.gDG) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void brU() {
        this.gDu = (EditText) this.gDE.findViewById(d.g.post_content);
        this.gDu.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString W = TbFaceManager.IP().W(this.gDE.getPageContext().getContext(), this.mData.getContent());
            this.gDu.setText(W);
            this.gDu.setSelection(W.length());
        }
        this.gDu.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gDu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.brT();
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

    public EditText brV() {
        return this.gDq;
    }

    public EditText brW() {
        return this.gDu;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        brR();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.gDq.setOnFocusChangeListener(onFocusChangeListener);
        this.gDu.setOnFocusChangeListener(onFocusChangeListener);
        this.aAZ.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public com.baidu.tieba.write.d brX() {
        return this.gDw;
    }

    public View brY() {
        return this.aAZ;
    }

    public TextView brZ() {
        return this.mPost;
    }

    public TextView bsa() {
        return this.gDv;
    }

    public void U(View.OnClickListener onClickListener) {
        this.aAZ.setOnClickListener(onClickListener);
    }

    public void V(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void W(View.OnClickListener onClickListener) {
        this.gDt.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.gDE != null) {
            this.gDE.getLayoutMode().setNightMode(i == 1);
            this.gDE.getLayoutMode().onModeChanged(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.gDE.getPageContext(), i);
            am.d(this.mPost, i);
            am.j(this.gDr, d.C0140d.cp_bg_line_c);
            am.j(this.gDs, d.C0140d.cp_bg_line_c);
            am.j(this.gDq, d.C0140d.cp_cont_g);
            am.j(this.gDA, d.C0140d.cp_bg_line_e);
            int color = am.getColor(d.C0140d.cp_cont_b);
            int color2 = am.getColor(d.C0140d.cp_cont_e);
            this.gDq.setTextColor(color);
            this.gDu.setTextColor(color);
            this.gDC.setTextColor(am.getColor(d.C0140d.cp_cont_b));
            this.gDD.setTextColor(am.getColor(d.C0140d.cp_cont_d));
            b(this.gDq, color2);
            b(this.gDu, color2);
            brT();
        }
    }

    public ShareSDKImageView bsb() {
        return this.gDB;
    }
}
