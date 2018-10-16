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
    private ImageView gSA;
    private View gSB;
    private LinearLayout gSC;
    private LinearLayout gSD;
    private ShareSDKImageView gSE;
    private TextView gSF;
    private TextView gSG;
    private WriteShareActivity gSH;
    private com.baidu.tbadk.img.b gSI;
    private View gSv;
    private TextView gSy;
    private d gSz;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View aIE = null;
    private EditText gSt = null;
    private View gSu = null;
    private LinearLayout gSw = null;
    private EditText gSx = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean gSJ = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.gSH = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.gSI == null) {
            this.gSI = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.gSH.findViewById(e.g.view_navigation_bar);
        this.aIE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gSH.getPageContext().getString(e.j.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gSH.getPageContext().getString(e.j.send_post));
        this.mParent = (RelativeLayout) this.gSH.findViewById(e.g.parent);
        this.gSu = this.gSH.findViewById(e.g.interval_view);
        this.gSv = this.gSH.findViewById(e.g.prefix_interval_view);
        this.gSC = (LinearLayout) this.gSH.findViewById(e.g.post_share_layout);
        this.gSD = (LinearLayout) this.gSH.findViewById(e.g.post_share_content_layout);
        this.gSE = (ShareSDKImageView) this.gSH.findViewById(e.g.post_share_image);
        this.gSF = (TextView) this.gSH.findViewById(e.g.post_share_title);
        this.gSG = (TextView) this.gSH.findViewById(e.g.post_share_content);
        bxN();
        bxP();
        this.gSw = (LinearLayout) this.gSH.findViewById(e.g.post_content_container);
        this.gSw.setDrawingCacheEnabled(false);
        this.gSt.setVisibility(0);
        this.gSx.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        bxO();
    }

    public void bxL() {
        this.gSC = (LinearLayout) this.gSH.findViewById(e.g.post_share_layout);
        this.gSE = (ShareSDKImageView) this.gSH.findViewById(e.g.post_share_image);
        this.gSE.setIsRound(false);
        this.gSE.setDrawBorder(false);
        this.gSE.setAutoChangeStyle(true);
        this.gSE.setRadius(0);
        this.gSF = (TextView) this.gSH.findViewById(e.g.post_share_title);
        this.gSG = (TextView) this.gSH.findViewById(e.g.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.gSE.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void r(String str, boolean z) {
                        if (z) {
                            if (c.this.gSE.getLoadedWidth() != 0 && c.this.gSE.getLoadedHeight() != 0) {
                                c.this.width = c.this.gSE.getLoadedWidth();
                                c.this.height = c.this.gSE.getLoadedHeight();
                                if (c.this.gSH != null) {
                                    c.this.gSH.getWriteData().setShareSummaryImgWidth(c.this.width);
                                    c.this.gSH.getWriteData().setShareSummaryImgHeight(c.this.height);
                                    c.this.gSJ = true;
                                    c.this.bxO();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.gSJ = false;
                        c.this.bxO();
                        if (c.this.gSH != null) {
                            c.this.gSH.uc(e.j.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.gSJ = false;
                        c.this.bxO();
                        if (c.this.gSH != null) {
                            c.this.gSH.uc(e.j.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.gSE.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.gSJ = true;
                    bxO();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.gSE.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(l.b(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.K(aq.CG().CM(), aq.CG().CN()));
                    this.gSE.setTag(imageFileInfo.toCachedKey(true));
                    if (this.gSI.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.gSC.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.gSE.invalidate();
                    }
                }
                this.gSJ = true;
                bxO();
            }
            this.mData.setShareSummaryImgType(f.bp(this.mData.getShareSummaryImg()));
            this.gSF.setText(this.mData.getShareSummaryTitle());
            this.gSG.setText(this.mData.getShareSummaryContent());
        }
    }

    private void bxM() {
        this.gSB = this.gSH.findViewById(e.g.post_prefix_layout);
        this.gSy = (TextView) this.gSH.findViewById(e.g.post_prefix);
        this.gSA = (ImageView) this.gSH.findViewById(e.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.gSB.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gSy.setText(prefixs.get(0));
            this.gSH.ud(0);
            this.gSB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.gSy.setVisibility(0);
                    c.this.gSB.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.gSz, view, com.baidu.adp.lib.util.l.dip2px(c.this.gSH.getPageContext().getContext(), 15.0f), com.baidu.adp.lib.util.l.dip2px(c.this.gSH.getPageContext().getContext(), 1.0f));
                    if (c.this.gSH != null) {
                        c.this.gSH.bxK();
                    }
                }
            });
            this.gSA = (ImageView) this.gSH.findViewById(e.g.prefix_icon);
            if (size > 1) {
                this.gSA.setVisibility(0);
                this.gSy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.gSy.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.gSz, view, com.baidu.adp.lib.util.l.dip2px(c.this.gSH.getPageContext().getContext(), 15.0f), com.baidu.adp.lib.util.l.dip2px(c.this.gSH.getPageContext().getContext(), 1.0f));
                        if (c.this.gSH != null) {
                            c.this.gSH.bxK();
                        }
                    }
                });
            }
            this.gSz = new d(this.gSH.getPageContext().getContext());
            this.gSz.setMaxHeight(com.baidu.adp.lib.util.l.dip2px(this.gSH.getPageContext().getContext(), 225.0f));
            this.gSz.setOutsideTouchable(true);
            this.gSz.setFocusable(true);
            this.gSz.setBackgroundDrawable(al.getDrawable(e.d.cp_bg_line_b));
            this.gSz.a(new d.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.d.a
                public void ue(int i) {
                    c.this.gSH.ud(i);
                    c.this.gSy.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.gSz.setCurrentIndex(i);
                    c.this.bxO();
                    g.a(c.this.gSz, c.this.gSH.getPageContext().getPageActivity());
                }
            });
            this.gSz.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.gSB.setSelected(false);
                }
            });
            int color = al.getColor(e.d.common_color_10097);
            al.i(this.gSy, e.f.write_prefix_item_selector);
            al.c(this.gSA, e.f.icon_title_down);
            this.gSy.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.gSH.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.dip2px(this.gSH.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                al.i(textView, e.f.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.gSH.getPageContext().getContext(), this.gSH.getResources().getDimension(e.C0175e.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.gSH.getPageContext().getContext(), this.gSH.getResources().getDimension(e.C0175e.ds22)), 0);
                this.gSz.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.dip2px(this.gSH.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.gSH.getPageContext().getContext(), this.gSH.getResources().getDimension(e.C0175e.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.gSH.getPageContext().getContext(), this.gSH.getResources().getDimension(e.C0175e.ds22)), 0);
                }
            }
            this.gSz.setCurrentIndex(0);
            return;
        }
        this.gSB.setVisibility(8);
    }

    protected void bxN() {
        this.gSt = (EditText) this.gSH.findViewById(e.g.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.gSt.setText(this.mData.getTitle());
                this.gSt.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.gSH.getPageContext().getString(e.j.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.gSt.setText(str);
                if (str.length() < 20) {
                    this.gSt.setSelection(str.length());
                } else {
                    this.gSt.setSelection(20);
                }
            }
        }
        this.gSt.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.bxO();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void bxO() {
        String str = null;
        if (this.mData.getType() == 3) {
            String trim = this.gSt.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.gSH.bxI() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.gSJ) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void bxP() {
        this.gSx = (EditText) this.gSH.findViewById(e.g.post_content);
        this.gSx.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString al = TbFaceManager.Md().al(this.gSH.getPageContext().getContext(), this.mData.getContent());
            this.gSx.setText(al);
            this.gSx.setSelection(al.length());
        }
        this.gSx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gSx.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.bxO();
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

    public EditText bxQ() {
        return this.gSt;
    }

    public EditText bxR() {
        return this.gSx;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        bxM();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.gSt.setOnFocusChangeListener(onFocusChangeListener);
        this.gSx.setOnFocusChangeListener(onFocusChangeListener);
        this.aIE.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public d bxS() {
        return this.gSz;
    }

    public View bxT() {
        return this.aIE;
    }

    public TextView bxU() {
        return this.mPost;
    }

    public TextView bxV() {
        return this.gSy;
    }

    public void T(View.OnClickListener onClickListener) {
        this.aIE.setOnClickListener(onClickListener);
    }

    public void U(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void V(View.OnClickListener onClickListener) {
        this.gSw.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.gSH != null) {
            this.gSH.getLayoutMode().setNightMode(i == 1);
            this.gSH.getLayoutMode().onModeChanged(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.gSH.getPageContext(), i);
            al.d(this.mPost, i);
            al.j(this.gSu, e.d.cp_bg_line_c);
            al.j(this.gSv, e.d.cp_bg_line_c);
            al.j(this.gSt, e.d.cp_cont_g);
            al.j(this.gSD, e.d.cp_bg_line_e);
            int color = al.getColor(e.d.cp_cont_b);
            int color2 = al.getColor(e.d.cp_cont_e);
            this.gSt.setTextColor(color);
            this.gSx.setTextColor(color);
            this.gSF.setTextColor(al.getColor(e.d.cp_cont_b));
            this.gSG.setTextColor(al.getColor(e.d.cp_cont_d));
            b(this.gSt, color2);
            b(this.gSx, color2);
            bxO();
        }
    }

    public ShareSDKImageView bxW() {
        return this.gSE;
    }
}
