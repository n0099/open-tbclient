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
import com.baidu.tieba.d;
import com.baidu.tieba.write.d;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class c {
    private ShareSDKImageView gyA;
    private TextView gyB;
    private TextView gyC;
    private WriteShareActivity gyD;
    private com.baidu.tbadk.img.b gyE;
    private View gyr;
    private TextView gyu;
    private d gyv;
    private ImageView gyw;
    private View gyx;
    private LinearLayout gyy;
    private LinearLayout gyz;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View aAn = null;
    private EditText gyp = null;
    private View gyq = null;
    private LinearLayout gys = null;
    private EditText gyt = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean gyF = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.gyD = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.gyE == null) {
            this.gyE = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.gyD.findViewById(d.g.view_navigation_bar);
        this.aAn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gyD.getPageContext().getString(d.k.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gyD.getPageContext().getString(d.k.send_post));
        this.mParent = (RelativeLayout) this.gyD.findViewById(d.g.parent);
        this.gyq = this.gyD.findViewById(d.g.interval_view);
        this.gyr = this.gyD.findViewById(d.g.prefix_interval_view);
        this.gyy = (LinearLayout) this.gyD.findViewById(d.g.post_share_layout);
        this.gyz = (LinearLayout) this.gyD.findViewById(d.g.post_share_content_layout);
        this.gyA = (ShareSDKImageView) this.gyD.findViewById(d.g.post_share_image);
        this.gyB = (TextView) this.gyD.findViewById(d.g.post_share_title);
        this.gyC = (TextView) this.gyD.findViewById(d.g.post_share_content);
        bsP();
        bsR();
        this.gys = (LinearLayout) this.gyD.findViewById(d.g.post_content_container);
        this.gys.setDrawingCacheEnabled(false);
        this.gyp.setVisibility(0);
        this.gyt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        bsQ();
    }

    public void bsN() {
        this.gyy = (LinearLayout) this.gyD.findViewById(d.g.post_share_layout);
        this.gyA = (ShareSDKImageView) this.gyD.findViewById(d.g.post_share_image);
        this.gyA.setIsRound(false);
        this.gyA.setDrawBorder(false);
        this.gyA.setAutoChangeStyle(true);
        this.gyA.setRadius(0);
        this.gyB = (TextView) this.gyD.findViewById(d.g.post_share_title);
        this.gyC = (TextView) this.gyD.findViewById(d.g.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.gyA.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void n(String str, boolean z) {
                        if (z) {
                            if (c.this.gyA.getLoadedWidth() != 0 && c.this.gyA.getLoadedHeight() != 0) {
                                c.this.width = c.this.gyA.getLoadedWidth();
                                c.this.height = c.this.gyA.getLoadedHeight();
                                if (c.this.gyD != null) {
                                    c.this.gyD.getWriteData().setShareSummaryImgWidth(c.this.width);
                                    c.this.gyD.getWriteData().setShareSummaryImgHeight(c.this.height);
                                    c.this.gyF = true;
                                    c.this.bsQ();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.gyF = false;
                        c.this.bsQ();
                        if (c.this.gyD != null) {
                            c.this.gyD.sX(d.k.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.gyF = false;
                        c.this.bsQ();
                        if (c.this.gyD != null) {
                            c.this.gyD.sX(d.k.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.gyA.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.gyF = true;
                    bsQ();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.gyA.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(l.b(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.H(aq.zq().zw(), aq.zq().zx()));
                    this.gyA.setTag(imageFileInfo.toCachedKey(true));
                    if (this.gyE.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.gyy.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.gyA.invalidate();
                    }
                }
                this.gyF = true;
                bsQ();
            }
            this.mData.setShareSummaryImgType(f.aW(this.mData.getShareSummaryImg()));
            this.gyB.setText(this.mData.getShareSummaryTitle());
            this.gyC.setText(this.mData.getShareSummaryContent());
        }
    }

    private void bsO() {
        this.gyx = this.gyD.findViewById(d.g.post_prefix_layout);
        this.gyu = (TextView) this.gyD.findViewById(d.g.post_prefix);
        this.gyw = (ImageView) this.gyD.findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.gyx.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gyu.setText(prefixs.get(0));
            this.gyD.sY(0);
            this.gyx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.gyu.setVisibility(0);
                    c.this.gyx.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.gyv, view, com.baidu.adp.lib.util.l.dip2px(c.this.gyD.getPageContext().getContext(), 15.0f), com.baidu.adp.lib.util.l.dip2px(c.this.gyD.getPageContext().getContext(), 1.0f));
                    if (c.this.gyD != null) {
                        c.this.gyD.bsM();
                    }
                }
            });
            this.gyw = (ImageView) this.gyD.findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gyw.setVisibility(0);
                this.gyu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.gyu.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.gyv, view, com.baidu.adp.lib.util.l.dip2px(c.this.gyD.getPageContext().getContext(), 15.0f), com.baidu.adp.lib.util.l.dip2px(c.this.gyD.getPageContext().getContext(), 1.0f));
                        if (c.this.gyD != null) {
                            c.this.gyD.bsM();
                        }
                    }
                });
            }
            this.gyv = new com.baidu.tieba.write.d(this.gyD.getPageContext().getContext());
            this.gyv.setMaxHeight(com.baidu.adp.lib.util.l.dip2px(this.gyD.getPageContext().getContext(), 225.0f));
            this.gyv.setOutsideTouchable(true);
            this.gyv.setFocusable(true);
            this.gyv.setBackgroundDrawable(al.getDrawable(d.C0141d.cp_bg_line_b));
            this.gyv.a(new d.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.d.a
                public void sZ(int i) {
                    c.this.gyD.sY(i);
                    c.this.gyu.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.gyv.setCurrentIndex(i);
                    c.this.bsQ();
                    g.a(c.this.gyv, c.this.gyD.getPageContext().getPageActivity());
                }
            });
            this.gyv.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.gyx.setSelected(false);
                }
            });
            int color = al.getColor(d.C0141d.common_color_10097);
            al.i(this.gyu, d.f.write_prefix_item_selector);
            al.c(this.gyw, d.f.icon_title_down);
            this.gyu.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.gyD.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.dip2px(this.gyD.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                al.i(textView, d.f.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.gyD.getPageContext().getContext(), this.gyD.getResources().getDimension(d.e.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.gyD.getPageContext().getContext(), this.gyD.getResources().getDimension(d.e.ds22)), 0);
                this.gyv.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.dip2px(this.gyD.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.gyD.getPageContext().getContext(), this.gyD.getResources().getDimension(d.e.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.gyD.getPageContext().getContext(), this.gyD.getResources().getDimension(d.e.ds22)), 0);
                }
            }
            this.gyv.setCurrentIndex(0);
            return;
        }
        this.gyx.setVisibility(8);
    }

    protected void bsP() {
        this.gyp = (EditText) this.gyD.findViewById(d.g.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.gyp.setText(this.mData.getTitle());
                this.gyp.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.gyD.getPageContext().getString(d.k.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.gyp.setText(str);
                if (str.length() < 20) {
                    this.gyp.setSelection(str.length());
                } else {
                    this.gyp.setSelection(20);
                }
            }
        }
        this.gyp.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.bsQ();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void bsQ() {
        String str = null;
        if (this.mData.getType() == 3) {
            String trim = this.gyp.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.gyD.bsK() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.gyF) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void bsR() {
        this.gyt = (EditText) this.gyD.findViewById(d.g.post_content);
        this.gyt.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString U = TbFaceManager.IC().U(this.gyD.getPageContext().getContext(), this.mData.getContent());
            this.gyt.setText(U);
            this.gyt.setSelection(U.length());
        }
        this.gyt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gyt.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.bsQ();
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

    public EditText bsS() {
        return this.gyp;
    }

    public EditText bsT() {
        return this.gyt;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        bsO();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.gyp.setOnFocusChangeListener(onFocusChangeListener);
        this.gyt.setOnFocusChangeListener(onFocusChangeListener);
        this.aAn.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public com.baidu.tieba.write.d bsU() {
        return this.gyv;
    }

    public View bsV() {
        return this.aAn;
    }

    public TextView bsW() {
        return this.mPost;
    }

    public TextView bsX() {
        return this.gyu;
    }

    public void S(View.OnClickListener onClickListener) {
        this.aAn.setOnClickListener(onClickListener);
    }

    public void T(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void U(View.OnClickListener onClickListener) {
        this.gys.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.gyD != null) {
            this.gyD.getLayoutMode().setNightMode(i == 1);
            this.gyD.getLayoutMode().onModeChanged(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.gyD.getPageContext(), i);
            al.d(this.mPost, i);
            al.j(this.gyq, d.C0141d.cp_bg_line_c);
            al.j(this.gyr, d.C0141d.cp_bg_line_c);
            al.j(this.gyp, d.C0141d.cp_cont_g);
            al.j(this.gyz, d.C0141d.cp_bg_line_e);
            int color = al.getColor(d.C0141d.cp_cont_b);
            int color2 = al.getColor(d.C0141d.cp_cont_e);
            this.gyp.setTextColor(color);
            this.gyt.setTextColor(color);
            this.gyB.setTextColor(al.getColor(d.C0141d.cp_cont_b));
            this.gyC.setTextColor(al.getColor(d.C0141d.cp_cont_d));
            b(this.gyp, color2);
            b(this.gyt, color2);
            bsQ();
        }
    }

    public ShareSDKImageView bsY() {
        return this.gyA;
    }
}
