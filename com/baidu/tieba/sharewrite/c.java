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
    private d gSA;
    private ImageView gSB;
    private View gSC;
    private LinearLayout gSD;
    private LinearLayout gSE;
    private ShareSDKImageView gSF;
    private TextView gSG;
    private TextView gSH;
    private WriteShareActivity gSI;
    private com.baidu.tbadk.img.b gSJ;
    private View gSw;
    private TextView gSz;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View aIE = null;
    private EditText gSu = null;
    private View gSv = null;
    private LinearLayout gSx = null;
    private EditText gSy = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean gSK = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.gSI = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.gSJ == null) {
            this.gSJ = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.gSI.findViewById(e.g.view_navigation_bar);
        this.aIE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gSI.getPageContext().getString(e.j.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gSI.getPageContext().getString(e.j.send_post));
        this.mParent = (RelativeLayout) this.gSI.findViewById(e.g.parent);
        this.gSv = this.gSI.findViewById(e.g.interval_view);
        this.gSw = this.gSI.findViewById(e.g.prefix_interval_view);
        this.gSD = (LinearLayout) this.gSI.findViewById(e.g.post_share_layout);
        this.gSE = (LinearLayout) this.gSI.findViewById(e.g.post_share_content_layout);
        this.gSF = (ShareSDKImageView) this.gSI.findViewById(e.g.post_share_image);
        this.gSG = (TextView) this.gSI.findViewById(e.g.post_share_title);
        this.gSH = (TextView) this.gSI.findViewById(e.g.post_share_content);
        bxN();
        bxP();
        this.gSx = (LinearLayout) this.gSI.findViewById(e.g.post_content_container);
        this.gSx.setDrawingCacheEnabled(false);
        this.gSu.setVisibility(0);
        this.gSy.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        bxO();
    }

    public void bxL() {
        this.gSD = (LinearLayout) this.gSI.findViewById(e.g.post_share_layout);
        this.gSF = (ShareSDKImageView) this.gSI.findViewById(e.g.post_share_image);
        this.gSF.setIsRound(false);
        this.gSF.setDrawBorder(false);
        this.gSF.setAutoChangeStyle(true);
        this.gSF.setRadius(0);
        this.gSG = (TextView) this.gSI.findViewById(e.g.post_share_title);
        this.gSH = (TextView) this.gSI.findViewById(e.g.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.gSF.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void r(String str, boolean z) {
                        if (z) {
                            if (c.this.gSF.getLoadedWidth() != 0 && c.this.gSF.getLoadedHeight() != 0) {
                                c.this.width = c.this.gSF.getLoadedWidth();
                                c.this.height = c.this.gSF.getLoadedHeight();
                                if (c.this.gSI != null) {
                                    c.this.gSI.getWriteData().setShareSummaryImgWidth(c.this.width);
                                    c.this.gSI.getWriteData().setShareSummaryImgHeight(c.this.height);
                                    c.this.gSK = true;
                                    c.this.bxO();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.gSK = false;
                        c.this.bxO();
                        if (c.this.gSI != null) {
                            c.this.gSI.uc(e.j.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.gSK = false;
                        c.this.bxO();
                        if (c.this.gSI != null) {
                            c.this.gSI.uc(e.j.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.gSF.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.gSK = true;
                    bxO();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.gSF.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(l.b(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.K(aq.CG().CM(), aq.CG().CN()));
                    this.gSF.setTag(imageFileInfo.toCachedKey(true));
                    if (this.gSJ.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.gSD.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.gSF.invalidate();
                    }
                }
                this.gSK = true;
                bxO();
            }
            this.mData.setShareSummaryImgType(f.bp(this.mData.getShareSummaryImg()));
            this.gSG.setText(this.mData.getShareSummaryTitle());
            this.gSH.setText(this.mData.getShareSummaryContent());
        }
    }

    private void bxM() {
        this.gSC = this.gSI.findViewById(e.g.post_prefix_layout);
        this.gSz = (TextView) this.gSI.findViewById(e.g.post_prefix);
        this.gSB = (ImageView) this.gSI.findViewById(e.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.gSC.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gSz.setText(prefixs.get(0));
            this.gSI.ud(0);
            this.gSC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.gSz.setVisibility(0);
                    c.this.gSC.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.gSA, view, com.baidu.adp.lib.util.l.dip2px(c.this.gSI.getPageContext().getContext(), 15.0f), com.baidu.adp.lib.util.l.dip2px(c.this.gSI.getPageContext().getContext(), 1.0f));
                    if (c.this.gSI != null) {
                        c.this.gSI.bxK();
                    }
                }
            });
            this.gSB = (ImageView) this.gSI.findViewById(e.g.prefix_icon);
            if (size > 1) {
                this.gSB.setVisibility(0);
                this.gSz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.gSz.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.gSA, view, com.baidu.adp.lib.util.l.dip2px(c.this.gSI.getPageContext().getContext(), 15.0f), com.baidu.adp.lib.util.l.dip2px(c.this.gSI.getPageContext().getContext(), 1.0f));
                        if (c.this.gSI != null) {
                            c.this.gSI.bxK();
                        }
                    }
                });
            }
            this.gSA = new d(this.gSI.getPageContext().getContext());
            this.gSA.setMaxHeight(com.baidu.adp.lib.util.l.dip2px(this.gSI.getPageContext().getContext(), 225.0f));
            this.gSA.setOutsideTouchable(true);
            this.gSA.setFocusable(true);
            this.gSA.setBackgroundDrawable(al.getDrawable(e.d.cp_bg_line_b));
            this.gSA.a(new d.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.d.a
                public void ue(int i) {
                    c.this.gSI.ud(i);
                    c.this.gSz.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.gSA.setCurrentIndex(i);
                    c.this.bxO();
                    g.a(c.this.gSA, c.this.gSI.getPageContext().getPageActivity());
                }
            });
            this.gSA.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.gSC.setSelected(false);
                }
            });
            int color = al.getColor(e.d.common_color_10097);
            al.i(this.gSz, e.f.write_prefix_item_selector);
            al.c(this.gSB, e.f.icon_title_down);
            this.gSz.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.gSI.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.dip2px(this.gSI.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                al.i(textView, e.f.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.gSI.getPageContext().getContext(), this.gSI.getResources().getDimension(e.C0175e.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.gSI.getPageContext().getContext(), this.gSI.getResources().getDimension(e.C0175e.ds22)), 0);
                this.gSA.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.dip2px(this.gSI.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.gSI.getPageContext().getContext(), this.gSI.getResources().getDimension(e.C0175e.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.gSI.getPageContext().getContext(), this.gSI.getResources().getDimension(e.C0175e.ds22)), 0);
                }
            }
            this.gSA.setCurrentIndex(0);
            return;
        }
        this.gSC.setVisibility(8);
    }

    protected void bxN() {
        this.gSu = (EditText) this.gSI.findViewById(e.g.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.gSu.setText(this.mData.getTitle());
                this.gSu.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.gSI.getPageContext().getString(e.j.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.gSu.setText(str);
                if (str.length() < 20) {
                    this.gSu.setSelection(str.length());
                } else {
                    this.gSu.setSelection(20);
                }
            }
        }
        this.gSu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
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
            String trim = this.gSu.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.gSI.bxI() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.gSK) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void bxP() {
        this.gSy = (EditText) this.gSI.findViewById(e.g.post_content);
        this.gSy.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString al = TbFaceManager.Md().al(this.gSI.getPageContext().getContext(), this.mData.getContent());
            this.gSy.setText(al);
            this.gSy.setSelection(al.length());
        }
        this.gSy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gSy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
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
        return this.gSu;
    }

    public EditText bxR() {
        return this.gSy;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        bxM();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.gSu.setOnFocusChangeListener(onFocusChangeListener);
        this.gSy.setOnFocusChangeListener(onFocusChangeListener);
        this.aIE.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public d bxS() {
        return this.gSA;
    }

    public View bxT() {
        return this.aIE;
    }

    public TextView bxU() {
        return this.mPost;
    }

    public TextView bxV() {
        return this.gSz;
    }

    public void T(View.OnClickListener onClickListener) {
        this.aIE.setOnClickListener(onClickListener);
    }

    public void U(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void V(View.OnClickListener onClickListener) {
        this.gSx.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.gSI != null) {
            this.gSI.getLayoutMode().setNightMode(i == 1);
            this.gSI.getLayoutMode().onModeChanged(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.gSI.getPageContext(), i);
            al.d(this.mPost, i);
            al.j(this.gSv, e.d.cp_bg_line_c);
            al.j(this.gSw, e.d.cp_bg_line_c);
            al.j(this.gSu, e.d.cp_cont_g);
            al.j(this.gSE, e.d.cp_bg_line_e);
            int color = al.getColor(e.d.cp_cont_b);
            int color2 = al.getColor(e.d.cp_cont_e);
            this.gSu.setTextColor(color);
            this.gSy.setTextColor(color);
            this.gSG.setTextColor(al.getColor(e.d.cp_cont_b));
            this.gSH.setTextColor(al.getColor(e.d.cp_cont_d));
            b(this.gSu, color2);
            b(this.gSy, color2);
            bxO();
        }
    }

    public ShareSDKImageView bxW() {
        return this.gSF;
    }
}
