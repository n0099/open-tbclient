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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.write.e;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class d {
    private View gQA;
    private LinearLayout gQB;
    private LinearLayout gQC;
    private c gQD;
    private TextView gQE;
    private TextView gQF;
    private WriteShareActivity gQG;
    private com.baidu.tbadk.img.b gQH;
    private View gQu;
    private TextView gQx;
    private e gQy;
    private ImageView gQz;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View bgy = null;
    private EditText gQs = null;
    private View gQt = null;
    private LinearLayout gQv = null;
    private EditText gQw = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean gQI = false;
    private int width = 0;
    private int height = 0;

    public d(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.gQG = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.gQH == null) {
            this.gQH = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.gQG.findViewById(d.g.view_navigation_bar);
        this.bgy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gQG.getPageContext().getString(d.j.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gQG.getPageContext().getString(d.j.send_post));
        this.mParent = (RelativeLayout) this.gQG.findViewById(d.g.parent);
        this.gQt = this.gQG.findViewById(d.g.interval_view);
        this.gQu = this.gQG.findViewById(d.g.prefix_interval_view);
        this.gQB = (LinearLayout) this.gQG.findViewById(d.g.post_share_layout);
        this.gQC = (LinearLayout) this.gQG.findViewById(d.g.post_share_content_layout);
        this.gQD = (c) this.gQG.findViewById(d.g.post_share_image);
        this.gQE = (TextView) this.gQG.findViewById(d.g.post_share_title);
        this.gQF = (TextView) this.gQG.findViewById(d.g.post_share_content);
        bsH();
        bsJ();
        this.gQv = (LinearLayout) this.gQG.findViewById(d.g.post_content_container);
        this.gQv.setDrawingCacheEnabled(false);
        this.gQs.setVisibility(0);
        this.gQw.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        bsI();
    }

    public void bsF() {
        this.gQB = (LinearLayout) this.gQG.findViewById(d.g.post_share_layout);
        this.gQD = (c) this.gQG.findViewById(d.g.post_share_image);
        this.gQD.setIsRound(false);
        this.gQD.setDrawBorder(false);
        this.gQD.setAutoChangeStyle(true);
        this.gQD.setRadius(0);
        this.gQE = (TextView) this.gQG.findViewById(d.g.post_share_title);
        this.gQF = (TextView) this.gQG.findViewById(d.g.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.gQD.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.d.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void p(String str, boolean z) {
                        if (z) {
                            if (d.this.gQD.getLoadedWidth() != 0 && d.this.gQD.getLoadedHeight() != 0) {
                                d.this.width = d.this.gQD.getLoadedWidth();
                                d.this.height = d.this.gQD.getLoadedHeight();
                                if (d.this.gQG != null) {
                                    d.this.gQG.getWriteData().setShareSummaryImgWidth(d.this.width);
                                    d.this.gQG.getWriteData().setShareSummaryImgHeight(d.this.height);
                                    d.this.gQI = true;
                                    d.this.bsI();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        d.this.gQI = false;
                        d.this.bsI();
                        if (d.this.gQG != null) {
                            d.this.gQG.vk(d.j.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        d.this.gQI = false;
                        d.this.bsI();
                        if (d.this.gQG != null) {
                            d.this.gQG.vk(d.j.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.gQD.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.gQI = true;
                    bsI();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.gQD.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(k.n(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.aI(ao.Dd().Dj(), ao.Dd().Dk()));
                    this.gQD.setTag(imageFileInfo.toCachedKey(true));
                    if (this.gQH.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.d.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) d.this.gQB.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.gQD.invalidate();
                    }
                }
                this.gQI = true;
                bsI();
            }
            this.mData.setShareSummaryImgType(f.aN(this.mData.getShareSummaryImg()));
            this.gQE.setText(this.mData.getShareSummaryTitle());
            this.gQF.setText(this.mData.getShareSummaryContent());
        }
    }

    private void bsG() {
        this.gQA = this.gQG.findViewById(d.g.post_prefix_layout);
        this.gQx = (TextView) this.gQG.findViewById(d.g.post_prefix);
        this.gQz = (ImageView) this.gQG.findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.gQA.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gQx.setText(prefixs.get(0));
            this.gQG.vl(0);
            this.gQA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.gQx.setVisibility(0);
                    d.this.gQA.setSelected(true);
                    g.showPopupWindowAsDropDown(d.this.gQy, view, l.dip2px(d.this.gQG.getPageContext().getContext(), 15.0f), l.dip2px(d.this.gQG.getPageContext().getContext(), 1.0f));
                    if (d.this.gQG != null) {
                        d.this.gQG.bsE();
                    }
                }
            });
            this.gQz = (ImageView) this.gQG.findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gQz.setVisibility(0);
                this.gQx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.gQx.setSelected(true);
                        g.showPopupWindowAsDropDown(d.this.gQy, view, l.dip2px(d.this.gQG.getPageContext().getContext(), 15.0f), l.dip2px(d.this.gQG.getPageContext().getContext(), 1.0f));
                        if (d.this.gQG != null) {
                            d.this.gQG.bsE();
                        }
                    }
                });
            }
            this.gQy = new e(this.gQG.getPageContext().getContext());
            this.gQy.setMaxHeight(l.dip2px(this.gQG.getPageContext().getContext(), 225.0f));
            this.gQy.setOutsideTouchable(true);
            this.gQy.setFocusable(true);
            this.gQy.setBackgroundDrawable(aj.getDrawable(d.C0141d.cp_bg_line_b));
            this.gQy.a(new e.a() { // from class: com.baidu.tieba.sharewrite.d.5
                @Override // com.baidu.tieba.write.e.a
                public void vm(int i) {
                    d.this.gQG.vl(i);
                    d.this.gQx.setText(d.this.mPrefixData.getPrefixs().get(i));
                    d.this.gQy.setCurrentIndex(i);
                    d.this.bsI();
                    g.a(d.this.gQy, d.this.gQG.getPageContext().getPageActivity());
                }
            });
            this.gQy.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.d.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    d.this.gQA.setSelected(false);
                }
            });
            int color = aj.getColor(d.C0141d.common_color_10097);
            aj.s(this.gQx, d.f.write_prefix_item_selector);
            aj.c(this.gQz, d.f.icon_title_down);
            this.gQx.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.gQG.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.gQG.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                aj.s(textView, d.f.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.gQG.getPageContext().getContext(), this.gQG.getResources().getDimension(d.e.ds6)), 0, l.dip2px(this.gQG.getPageContext().getContext(), this.gQG.getResources().getDimension(d.e.ds22)), 0);
                this.gQy.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.gQG.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.gQG.getPageContext().getContext(), this.gQG.getResources().getDimension(d.e.ds6)), 0, l.dip2px(this.gQG.getPageContext().getContext(), this.gQG.getResources().getDimension(d.e.ds22)), 0);
                }
            }
            this.gQy.setCurrentIndex(0);
            return;
        }
        this.gQA.setVisibility(8);
    }

    protected void bsH() {
        this.gQs = (EditText) this.gQG.findViewById(d.g.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.gQs.setText(this.mData.getTitle());
                this.gQs.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.gQG.getPageContext().getString(d.j.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.gQs.setText(str);
                if (str.length() < 20) {
                    this.gQs.setSelection(str.length());
                } else {
                    this.gQs.setSelection(20);
                }
            }
        }
        this.gQs.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.d.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.bsI();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void bsI() {
        String str = null;
        if (this.mData.getType() == 3) {
            String trim = this.gQs.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.gQG.bsC() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.gQI) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void bsJ() {
        this.gQw = (EditText) this.gQG.findViewById(d.g.post_content);
        this.gQw.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString W = TbFaceManager.Mv().W(this.gQG.getPageContext().getContext(), this.mData.getContent());
            this.gQw.setText(W);
            this.gQw.setSelection(W.length());
        }
        this.gQw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.d.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gQw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.d.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.bsI();
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

    public EditText bsK() {
        return this.gQs;
    }

    public EditText bsL() {
        return this.gQw;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        bsG();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.gQs.setOnFocusChangeListener(onFocusChangeListener);
        this.gQw.setOnFocusChangeListener(onFocusChangeListener);
        this.bgy.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public e bsM() {
        return this.gQy;
    }

    public View bsN() {
        return this.bgy;
    }

    public TextView bsO() {
        return this.mPost;
    }

    public TextView bsP() {
        return this.gQx;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.bgy.setOnClickListener(onClickListener);
    }

    public void R(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void S(View.OnClickListener onClickListener) {
        this.gQv.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.gQG != null) {
            this.gQG.getLayoutMode().aQ(i == 1);
            this.gQG.getLayoutMode().aM(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.gQG.getPageContext(), i);
            aj.e(this.mPost, i);
            aj.t(this.gQt, d.C0141d.cp_bg_line_c);
            aj.t(this.gQu, d.C0141d.cp_bg_line_c);
            aj.t(this.gQs, d.C0141d.cp_cont_g);
            aj.t(this.gQC, d.C0141d.cp_bg_line_e);
            int color = aj.getColor(d.C0141d.cp_cont_b);
            int color2 = aj.getColor(d.C0141d.cp_cont_e);
            this.gQs.setTextColor(color);
            this.gQw.setTextColor(color);
            this.gQE.setTextColor(aj.getColor(d.C0141d.cp_cont_b));
            this.gQF.setTextColor(aj.getColor(d.C0141d.cp_cont_d));
            b(this.gQs, color2);
            b(this.gQw, color2);
            bsI();
        }
    }

    public c bsQ() {
        return this.gQD;
    }
}
