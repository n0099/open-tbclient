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
import com.baidu.tieba.f;
import com.baidu.tieba.write.d;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class c {
    private ImageView gDA;
    private View gDB;
    private LinearLayout gDC;
    private LinearLayout gDD;
    private ShareSDKImageView gDE;
    private TextView gDF;
    private TextView gDG;
    private WriteShareActivity gDH;
    private com.baidu.tbadk.img.b gDI;
    private View gDv;
    private TextView gDy;
    private d gDz;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View aAW = null;
    private EditText gDt = null;
    private View gDu = null;
    private LinearLayout gDw = null;
    private EditText gDx = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean gDJ = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.gDH = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.gDI == null) {
            this.gDI = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.gDH.findViewById(f.g.view_navigation_bar);
        this.aAW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gDH.getPageContext().getString(f.j.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gDH.getPageContext().getString(f.j.send_post));
        this.mParent = (RelativeLayout) this.gDH.findViewById(f.g.parent);
        this.gDu = this.gDH.findViewById(f.g.interval_view);
        this.gDv = this.gDH.findViewById(f.g.prefix_interval_view);
        this.gDC = (LinearLayout) this.gDH.findViewById(f.g.post_share_layout);
        this.gDD = (LinearLayout) this.gDH.findViewById(f.g.post_share_content_layout);
        this.gDE = (ShareSDKImageView) this.gDH.findViewById(f.g.post_share_image);
        this.gDF = (TextView) this.gDH.findViewById(f.g.post_share_title);
        this.gDG = (TextView) this.gDH.findViewById(f.g.post_share_content);
        brT();
        brV();
        this.gDw = (LinearLayout) this.gDH.findViewById(f.g.post_content_container);
        this.gDw.setDrawingCacheEnabled(false);
        this.gDt.setVisibility(0);
        this.gDx.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        brU();
    }

    public void brR() {
        this.gDC = (LinearLayout) this.gDH.findViewById(f.g.post_share_layout);
        this.gDE = (ShareSDKImageView) this.gDH.findViewById(f.g.post_share_image);
        this.gDE.setIsRound(false);
        this.gDE.setDrawBorder(false);
        this.gDE.setAutoChangeStyle(true);
        this.gDE.setRadius(0);
        this.gDF = (TextView) this.gDH.findViewById(f.g.post_share_title);
        this.gDG = (TextView) this.gDH.findViewById(f.g.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.gDE.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void m(String str, boolean z) {
                        if (z) {
                            if (c.this.gDE.getLoadedWidth() != 0 && c.this.gDE.getLoadedHeight() != 0) {
                                c.this.width = c.this.gDE.getLoadedWidth();
                                c.this.height = c.this.gDE.getLoadedHeight();
                                if (c.this.gDH != null) {
                                    c.this.gDH.getWriteData().setShareSummaryImgWidth(c.this.width);
                                    c.this.gDH.getWriteData().setShareSummaryImgHeight(c.this.height);
                                    c.this.gDJ = true;
                                    c.this.brU();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.gDJ = false;
                        c.this.brU();
                        if (c.this.gDH != null) {
                            c.this.gDH.tf(f.j.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.gDJ = false;
                        c.this.brU();
                        if (c.this.gDH != null) {
                            c.this.gDH.tf(f.j.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.gDE.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.gDJ = true;
                    brU();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.gDE.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(l.b(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.I(ar.zu().zA(), ar.zu().zB()));
                    this.gDE.setTag(imageFileInfo.toCachedKey(true));
                    if (this.gDI.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.gDC.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.gDE.invalidate();
                    }
                }
                this.gDJ = true;
                brU();
            }
            this.mData.setShareSummaryImgType(com.baidu.adp.lib.util.f.aZ(this.mData.getShareSummaryImg()));
            this.gDF.setText(this.mData.getShareSummaryTitle());
            this.gDG.setText(this.mData.getShareSummaryContent());
        }
    }

    private void brS() {
        this.gDB = this.gDH.findViewById(f.g.post_prefix_layout);
        this.gDy = (TextView) this.gDH.findViewById(f.g.post_prefix);
        this.gDA = (ImageView) this.gDH.findViewById(f.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.gDB.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gDy.setText(prefixs.get(0));
            this.gDH.tg(0);
            this.gDB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.gDy.setVisibility(0);
                    c.this.gDB.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.gDz, view, com.baidu.adp.lib.util.l.dip2px(c.this.gDH.getPageContext().getContext(), 15.0f), com.baidu.adp.lib.util.l.dip2px(c.this.gDH.getPageContext().getContext(), 1.0f));
                    if (c.this.gDH != null) {
                        c.this.gDH.brQ();
                    }
                }
            });
            this.gDA = (ImageView) this.gDH.findViewById(f.g.prefix_icon);
            if (size > 1) {
                this.gDA.setVisibility(0);
                this.gDy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.gDy.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.gDz, view, com.baidu.adp.lib.util.l.dip2px(c.this.gDH.getPageContext().getContext(), 15.0f), com.baidu.adp.lib.util.l.dip2px(c.this.gDH.getPageContext().getContext(), 1.0f));
                        if (c.this.gDH != null) {
                            c.this.gDH.brQ();
                        }
                    }
                });
            }
            this.gDz = new d(this.gDH.getPageContext().getContext());
            this.gDz.setMaxHeight(com.baidu.adp.lib.util.l.dip2px(this.gDH.getPageContext().getContext(), 225.0f));
            this.gDz.setOutsideTouchable(true);
            this.gDz.setFocusable(true);
            this.gDz.setBackgroundDrawable(am.getDrawable(f.d.cp_bg_line_b));
            this.gDz.a(new d.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.d.a
                public void th(int i) {
                    c.this.gDH.tg(i);
                    c.this.gDy.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.gDz.setCurrentIndex(i);
                    c.this.brU();
                    g.a(c.this.gDz, c.this.gDH.getPageContext().getPageActivity());
                }
            });
            this.gDz.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.gDB.setSelected(false);
                }
            });
            int color = am.getColor(f.d.common_color_10097);
            am.i(this.gDy, f.C0146f.write_prefix_item_selector);
            am.c(this.gDA, f.C0146f.icon_title_down);
            this.gDy.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.gDH.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.dip2px(this.gDH.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                am.i(textView, f.C0146f.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.gDH.getPageContext().getContext(), this.gDH.getResources().getDimension(f.e.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.gDH.getPageContext().getContext(), this.gDH.getResources().getDimension(f.e.ds22)), 0);
                this.gDz.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.dip2px(this.gDH.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.gDH.getPageContext().getContext(), this.gDH.getResources().getDimension(f.e.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.gDH.getPageContext().getContext(), this.gDH.getResources().getDimension(f.e.ds22)), 0);
                }
            }
            this.gDz.setCurrentIndex(0);
            return;
        }
        this.gDB.setVisibility(8);
    }

    protected void brT() {
        this.gDt = (EditText) this.gDH.findViewById(f.g.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.gDt.setText(this.mData.getTitle());
                this.gDt.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.gDH.getPageContext().getString(f.j.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.gDt.setText(str);
                if (str.length() < 20) {
                    this.gDt.setSelection(str.length());
                } else {
                    this.gDt.setSelection(20);
                }
            }
        }
        this.gDt.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.brU();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void brU() {
        String str = null;
        if (this.mData.getType() == 3) {
            String trim = this.gDt.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.gDH.brO() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.gDJ) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void brV() {
        this.gDx = (EditText) this.gDH.findViewById(f.g.post_content);
        this.gDx.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString W = TbFaceManager.IP().W(this.gDH.getPageContext().getContext(), this.mData.getContent());
            this.gDx.setText(W);
            this.gDx.setSelection(W.length());
        }
        this.gDx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gDx.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.brU();
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

    public EditText brW() {
        return this.gDt;
    }

    public EditText brX() {
        return this.gDx;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        brS();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.gDt.setOnFocusChangeListener(onFocusChangeListener);
        this.gDx.setOnFocusChangeListener(onFocusChangeListener);
        this.aAW.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public d brY() {
        return this.gDz;
    }

    public View brZ() {
        return this.aAW;
    }

    public TextView bsa() {
        return this.mPost;
    }

    public TextView bsb() {
        return this.gDy;
    }

    public void U(View.OnClickListener onClickListener) {
        this.aAW.setOnClickListener(onClickListener);
    }

    public void V(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void W(View.OnClickListener onClickListener) {
        this.gDw.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.gDH != null) {
            this.gDH.getLayoutMode().setNightMode(i == 1);
            this.gDH.getLayoutMode().onModeChanged(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.gDH.getPageContext(), i);
            am.d(this.mPost, i);
            am.j(this.gDu, f.d.cp_bg_line_c);
            am.j(this.gDv, f.d.cp_bg_line_c);
            am.j(this.gDt, f.d.cp_cont_g);
            am.j(this.gDD, f.d.cp_bg_line_e);
            int color = am.getColor(f.d.cp_cont_b);
            int color2 = am.getColor(f.d.cp_cont_e);
            this.gDt.setTextColor(color);
            this.gDx.setTextColor(color);
            this.gDF.setTextColor(am.getColor(f.d.cp_cont_b));
            this.gDG.setTextColor(am.getColor(f.d.cp_cont_d));
            b(this.gDt, color2);
            b(this.gDx, color2);
            brU();
        }
    }

    public ShareSDKImageView bsc() {
        return this.gDE;
    }
}
