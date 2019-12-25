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
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.am;
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
/* loaded from: classes8.dex */
public class c {
    private h jSA;
    private ImageView jSB;
    private View jSC;
    private LinearLayout jSD;
    private LinearLayout jSE;
    private ShareSDKImageView jSF;
    private TextView jSG;
    private TextView jSH;
    private WriteShareActivity jSI;
    private com.baidu.tbadk.img.b jSJ;
    private WriteData jSa;
    private View jSv;
    private TextView jSz;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText jSt = null;
    private View jSu = null;
    private LinearLayout jSw = null;
    private EditText jSx = null;
    private TextView jSy = null;
    private RelativeLayout hmv = null;
    private boolean jSK = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.jSa = null;
        this.jSI = writeShareActivity;
        this.jSa = writeShareActivity.cFi();
        if (this.jSJ == null) {
            this.jSJ = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.jSI.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jSI.getPageContext().getString(R.string.share_navigationbar_title));
        this.jSy = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jSI.getPageContext().getString(R.string.send_post));
        this.hmv = (RelativeLayout) this.jSI.findViewById(R.id.parent);
        this.jSu = this.jSI.findViewById(R.id.interval_view);
        this.jSv = this.jSI.findViewById(R.id.prefix_interval_view);
        this.jSD = (LinearLayout) this.jSI.findViewById(R.id.post_share_layout);
        this.jSE = (LinearLayout) this.jSI.findViewById(R.id.post_share_content_layout);
        this.jSF = (ShareSDKImageView) this.jSI.findViewById(R.id.post_share_image);
        this.jSG = (TextView) this.jSI.findViewById(R.id.post_share_title);
        this.jSH = (TextView) this.jSI.findViewById(R.id.post_share_content);
        cFo();
        cFq();
        this.jSw = (LinearLayout) this.jSI.findViewById(R.id.post_content_container);
        this.jSw.setDrawingCacheEnabled(false);
        this.jSt.setVisibility(0);
        this.jSx.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        cFp();
    }

    public void cFm() {
        this.jSD = (LinearLayout) this.jSI.findViewById(R.id.post_share_layout);
        this.jSF = (ShareSDKImageView) this.jSI.findViewById(R.id.post_share_image);
        this.jSF.setIsRound(false);
        this.jSF.setDrawBorder(false);
        this.jSF.setAutoChangeStyle(true);
        this.jSF.setRadius(0);
        this.jSG = (TextView) this.jSI.findViewById(R.id.post_share_title);
        this.jSH = (TextView) this.jSI.findViewById(R.id.post_share_content);
        if (this.jSa != null) {
            if (this.jSa.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.jSF.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.jSF.getLoadedWidth() != 0 && c.this.jSF.getLoadedHeight() != 0) {
                                c.this.width = c.this.jSF.getLoadedWidth();
                                c.this.height = c.this.jSF.getLoadedHeight();
                                if (c.this.jSI != null) {
                                    c.this.jSI.cFi().setShareSummaryImgWidth(c.this.width);
                                    c.this.jSI.cFi().setShareSummaryImgHeight(c.this.height);
                                    c.this.jSK = true;
                                    c.this.cFp();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.jSK = false;
                        c.this.cFp();
                        if (c.this.jSI != null) {
                            c.this.jSI.BP(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.jSK = false;
                        c.this.cFp();
                        if (c.this.jSI != null) {
                            c.this.jSI.BP(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.jSa.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.jSa.getShareSummaryImg() != null && this.jSa.getShareSummaryImg().trim().length() > 0) {
                    this.jSF.startLoad(this.jSa.getShareSummaryImg(), 10, true);
                } else {
                    this.jSK = true;
                    cFp();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.jSa.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.jSF.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.jSa.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(m.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.jSa.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.aF(ar.aDX().getPostImageSize(), ar.aDX().getPostImageHeightLimit()));
                    this.jSF.setTag(imageFileInfo.toCachedKey(true));
                    if (this.jSJ.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.jSD.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.jSF.invalidate();
                    }
                }
                this.jSK = true;
                cFp();
            }
            this.jSa.setShareSummaryImgType(f.getExtension(this.jSa.getShareSummaryImg()));
            this.jSG.setText(this.jSa.getShareSummaryTitle());
            this.jSH.setText(this.jSa.getShareSummaryContent());
        }
    }

    private void cFn() {
        this.jSC = this.jSI.findViewById(R.id.post_prefix_layout);
        this.jSz = (TextView) this.jSI.findViewById(R.id.post_prefix);
        this.jSB = (ImageView) this.jSI.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.jSC.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.jSz.setText(prefixs.get(0));
            this.jSI.BQ(0);
            this.jSC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.jSz.setVisibility(0);
                    c.this.jSC.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.jSA, view, l.dip2px(c.this.jSI.getPageContext().getContext(), 15.0f), l.dip2px(c.this.jSI.getPageContext().getContext(), 1.0f));
                    if (c.this.jSI != null) {
                        c.this.jSI.cFl();
                    }
                }
            });
            this.jSB = (ImageView) this.jSI.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.jSB.setVisibility(0);
                this.jSz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.jSz.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.jSA, view, l.dip2px(c.this.jSI.getPageContext().getContext(), 15.0f), l.dip2px(c.this.jSI.getPageContext().getContext(), 1.0f));
                        if (c.this.jSI != null) {
                            c.this.jSI.cFl();
                        }
                    }
                });
            }
            this.jSA = new h(this.jSI.getPageContext().getContext());
            this.jSA.setMaxHeight(l.dip2px(this.jSI.getPageContext().getContext(), 225.0f));
            this.jSA.setOutsideTouchable(true);
            this.jSA.setFocusable(true);
            this.jSA.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_c));
            this.jSA.a(new h.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.h.a
                public void BR(int i) {
                    c.this.jSI.BQ(i);
                    c.this.jSz.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.jSA.setCurrentIndex(i);
                    c.this.cFp();
                    g.dismissPopupWindow(c.this.jSA, c.this.jSI.getPageContext().getPageActivity());
                }
            });
            this.jSA.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.jSC.setSelected(false);
                }
            });
            int color = am.getColor(R.color.common_color_10097);
            am.setBackgroundResource(this.jSz, R.drawable.write_prefix_item_selector);
            am.setImageResource(this.jSB, R.drawable.icon_title_down);
            this.jSz.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.jSI.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.jSI.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                am.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.jSI.getPageContext().getContext(), this.jSI.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.jSI.getPageContext().getContext(), this.jSI.getResources().getDimension(R.dimen.ds22)), 0);
                this.jSA.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.jSI.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.jSI.getPageContext().getContext(), this.jSI.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.jSI.getPageContext().getContext(), this.jSI.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.jSA.setCurrentIndex(0);
            return;
        }
        this.jSC.setVisibility(8);
    }

    protected void cFo() {
        this.jSt = (EditText) this.jSI.findViewById(R.id.post_title);
        if (this.jSa.getType() == 3) {
            if (this.jSa.getTitle() != null && this.jSa.getTitle().trim().length() > 0) {
                this.jSt.setText(this.jSa.getTitle());
                this.jSt.setSelection(this.jSa.getTitle().length());
            } else {
                String str = this.jSI.getPageContext().getString(R.string.share_transfer_thread) + this.jSa.getShareSummaryTitle();
                this.jSt.setText(str);
                if (str.length() < 20) {
                    this.jSt.setSelection(str.length());
                } else {
                    this.jSt.setSelection(20);
                }
            }
        }
        this.jSt.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cFp();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void cFp() {
        String str = null;
        if (this.jSa.getType() == 3) {
            String trim = this.jSt.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.jSI.cFj() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.jSa.setIsNoTitle(true);
                    } else {
                        this.jSa.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.jSa.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.jSa.setIsNoTitle(true);
            } else {
                this.jSa.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.jSK) {
            this.jSy.setEnabled(false);
        } else {
            this.jSy.setEnabled(true);
        }
    }

    protected void cFq() {
        this.jSx = (EditText) this.jSI.findViewById(R.id.post_content);
        this.jSx.setDrawingCacheEnabled(false);
        if (this.jSa.getContent() != null && this.jSa.getContent().length() > 0) {
            SpannableString aA = TbFaceManager.aMY().aA(this.jSI.getPageContext().getContext(), this.jSa.getContent());
            this.jSx.setText(aA);
            this.jSx.setSelection(aA.length());
        }
        this.jSx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.jSx.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cFp();
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

    public EditText cFr() {
        return this.jSt;
    }

    public EditText cFs() {
        return this.jSx;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        cFn();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.jSt.setOnFocusChangeListener(onFocusChangeListener);
        this.jSx.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.jSy.setOnFocusChangeListener(onFocusChangeListener);
    }

    public h cFt() {
        return this.jSA;
    }

    public View cFu() {
        return this.mBack;
    }

    public TextView cFv() {
        return this.jSy;
    }

    public TextView cFw() {
        return this.jSz;
    }

    public void ac(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ad(View.OnClickListener onClickListener) {
        this.jSy.setOnClickListener(onClickListener);
    }

    public void ae(View.OnClickListener onClickListener) {
        this.jSw.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.jSI != null) {
            this.jSI.getLayoutMode().setNightMode(i == 1);
            this.jSI.getLayoutMode().onModeChanged(this.hmv);
            this.mNavigationBar.onChangeSkinType(this.jSI.getPageContext(), i);
            am.setTopBarCommonFinishButton(this.jSy, i);
            am.setBackgroundColor(this.jSu, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.jSv, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.jSt, R.color.cp_cont_g);
            am.setBackgroundColor(this.jSE, R.color.cp_bg_line_e);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_e);
            this.jSt.setTextColor(color);
            this.jSx.setTextColor(color);
            this.jSG.setTextColor(am.getColor(R.color.cp_cont_b));
            this.jSH.setTextColor(am.getColor(R.color.cp_cont_d));
            f(this.jSt, color2);
            f(this.jSx, color2);
            cFp();
        }
    }

    public ShareSDKImageView cFx() {
        return this.jSF;
    }
}
