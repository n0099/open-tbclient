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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.d;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.i;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes23.dex */
public class c {
    private WriteData mMZ;
    private LinearLayout mNA;
    private LinearLayout mNB;
    private ShareSDKImageView mNC;
    private TextView mND;
    private TextView mNE;
    private WriteShareActivity mNF;
    private com.baidu.tbadk.img.b mNG;
    private View mNt;
    private TextView mNw;
    private i mNx;
    private ImageView mNy;
    private View mNz;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText mNr = null;
    private View mNs = null;
    private LinearLayout mNu = null;
    private EditText mNv = null;
    private TextView lwX = null;
    private RelativeLayout jVZ = null;
    private boolean mNH = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mMZ = null;
        this.mNF = writeShareActivity;
        this.mMZ = writeShareActivity.cXs();
        if (this.mNG == null) {
            this.mNG = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.mNF.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mNF.getPageContext().getString(R.string.share_navigationbar_title));
        this.lwX = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mNF.getPageContext().getString(R.string.send_post));
        this.jVZ = (RelativeLayout) this.mNF.findViewById(R.id.parent);
        this.mNs = this.mNF.findViewById(R.id.interval_view);
        this.mNt = this.mNF.findViewById(R.id.prefix_interval_view);
        this.mNA = (LinearLayout) this.mNF.findViewById(R.id.post_share_layout);
        this.mNB = (LinearLayout) this.mNF.findViewById(R.id.post_share_content_layout);
        this.mNC = (ShareSDKImageView) this.mNF.findViewById(R.id.post_share_image);
        this.mND = (TextView) this.mNF.findViewById(R.id.post_share_title);
        this.mNE = (TextView) this.mNF.findViewById(R.id.post_share_content);
        dGq();
        dGs();
        this.mNu = (LinearLayout) this.mNF.findViewById(R.id.post_content_container);
        this.mNu.setDrawingCacheEnabled(false);
        this.mNr.setVisibility(0);
        this.mNv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        dGr();
    }

    public void dGo() {
        this.mNA = (LinearLayout) this.mNF.findViewById(R.id.post_share_layout);
        this.mNC = (ShareSDKImageView) this.mNF.findViewById(R.id.post_share_image);
        this.mNC.setIsRound(false);
        this.mNC.setDrawBorder(false);
        this.mNC.setAutoChangeStyle(true);
        this.mNC.setRadius(0);
        this.mND = (TextView) this.mNF.findViewById(R.id.post_share_title);
        this.mNE = (TextView) this.mNF.findViewById(R.id.post_share_content);
        if (this.mMZ != null) {
            if (this.mMZ.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.mNC.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.mNC.getLoadedWidth() != 0 && c.this.mNC.getLoadedHeight() != 0) {
                                c.this.width = c.this.mNC.getLoadedWidth();
                                c.this.height = c.this.mNC.getLoadedHeight();
                                if (c.this.mNF != null) {
                                    c.this.mNF.cXs().setShareSummaryImgWidth(c.this.width);
                                    c.this.mNF.cXs().setShareSummaryImgHeight(c.this.height);
                                    c.this.mNH = true;
                                    c.this.dGr();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.mNH = false;
                        c.this.dGr();
                        if (c.this.mNF != null) {
                            c.this.mNF.JH(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.mNH = false;
                        c.this.dGr();
                        if (c.this.mNF != null) {
                            c.this.mNF.JH(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mMZ.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mMZ.getShareSummaryImg() != null && this.mMZ.getShareSummaryImg().trim().length() > 0) {
                    this.mNC.startLoad(this.mMZ.getShareSummaryImg(), 10, true);
                } else {
                    this.mNH = true;
                    dGr();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mMZ.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.mNC.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mMZ.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mMZ.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.bg(av.bqC().getPostImageSize(), av.bqC().getPostImageHeightLimit()));
                    this.mNC.setTag(imageFileInfo.toCachedKey(true));
                    if (this.mNG.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.mNA.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.mNC.invalidate();
                    }
                }
                this.mNH = true;
                dGr();
            }
            this.mMZ.setShareSummaryImgType(f.getExtension(this.mMZ.getShareSummaryImg()));
            this.mND.setText(this.mMZ.getShareSummaryTitle());
            this.mNE.setText(this.mMZ.getShareSummaryContent());
        }
    }

    private void dGp() {
        this.mNz = this.mNF.findViewById(R.id.post_prefix_layout);
        this.mNw = (TextView) this.mNF.findViewById(R.id.post_prefix);
        this.mNy = (ImageView) this.mNF.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mNz.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.mNw.setText(prefixs.get(0));
            this.mNF.JI(0);
            this.mNz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mNw.setVisibility(0);
                    c.this.mNz.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.mNx, view, l.dip2px(c.this.mNF.getPageContext().getContext(), 15.0f), l.dip2px(c.this.mNF.getPageContext().getContext(), 1.0f));
                    if (c.this.mNF != null) {
                        c.this.mNF.dGn();
                    }
                }
            });
            this.mNy = (ImageView) this.mNF.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.mNy.setVisibility(0);
                this.mNw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.mNw.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.mNx, view, l.dip2px(c.this.mNF.getPageContext().getContext(), 15.0f), l.dip2px(c.this.mNF.getPageContext().getContext(), 1.0f));
                        if (c.this.mNF != null) {
                            c.this.mNF.dGn();
                        }
                    }
                });
            }
            this.mNx = new i(this.mNF.getPageContext().getContext());
            this.mNx.setMaxHeight(l.dip2px(this.mNF.getPageContext().getContext(), 225.0f));
            this.mNx.setOutsideTouchable(true);
            this.mNx.setFocusable(true);
            this.mNx.setBackgroundDrawable(ap.getDrawable(R.color.CAM_X0204));
            this.mNx.a(new i.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.i.a
                public void JJ(int i) {
                    c.this.mNF.JI(i);
                    c.this.mNw.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.mNx.setCurrentIndex(i);
                    c.this.dGr();
                    g.dismissPopupWindow(c.this.mNx, c.this.mNF.getPageContext().getPageActivity());
                }
            });
            this.mNx.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.mNz.setSelected(false);
                }
            });
            int color = ap.getColor(R.color.common_color_10097);
            ap.setBackgroundResource(this.mNw, R.drawable.write_prefix_item_selector);
            ap.setImageResource(this.mNy, R.drawable.icon_title_down);
            this.mNw.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.mNF.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.mNF.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ap.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.mNF.getPageContext().getContext(), this.mNF.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.mNF.getPageContext().getContext(), this.mNF.getResources().getDimension(R.dimen.ds22)), 0);
                this.mNx.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.mNF.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.mNF.getPageContext().getContext(), this.mNF.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.mNF.getPageContext().getContext(), this.mNF.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.mNx.setCurrentIndex(0);
            return;
        }
        this.mNz.setVisibility(8);
    }

    protected void dGq() {
        this.mNr = (EditText) this.mNF.findViewById(R.id.post_title);
        if (this.mMZ.getType() == 3) {
            if (this.mMZ.getTitle() != null && this.mMZ.getTitle().trim().length() > 0) {
                this.mNr.setText(this.mMZ.getTitle());
                this.mNr.setSelection(this.mMZ.getTitle().length());
            } else {
                String str = this.mNF.getPageContext().getString(R.string.share_transfer_thread) + this.mMZ.getShareSummaryTitle();
                this.mNr.setText(str);
                if (str.length() < 20) {
                    this.mNr.setSelection(str.length());
                } else {
                    this.mNr.setSelection(20);
                }
            }
        }
        this.mNr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dGr();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void dGr() {
        String str = null;
        if (this.mMZ.getType() == 3) {
            String trim = this.mNr.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.mNF.dGl() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.mMZ.setIsNoTitle(true);
                    } else {
                        this.mMZ.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.mMZ.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.mMZ.setIsNoTitle(true);
            } else {
                this.mMZ.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.mNH) {
            this.lwX.setEnabled(false);
        } else {
            this.lwX.setEnabled(true);
        }
    }

    protected void dGs() {
        this.mNv = (EditText) this.mNF.findViewById(R.id.post_content);
        this.mNv.setDrawingCacheEnabled(false);
        if (this.mMZ.getContent() != null && this.mMZ.getContent().length() > 0) {
            SpannableString at = TbFaceManager.bAs().at(this.mNF.getPageContext().getContext(), this.mMZ.getContent());
            this.mNv.setText(at);
            this.mNv.setSelection(at.length());
        }
        this.mNv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.mNv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dGr();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    private void h(EditText editText, int i) {
        Editable text = editText.getText();
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        editText.setText((CharSequence) null);
        editText.setHintTextColor(i);
        editText.setText(text);
        editText.setSelection(selectionStart, selectionEnd);
    }

    public EditText dGt() {
        return this.mNr;
    }

    public EditText dGu() {
        return this.mNv;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        dGp();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.mNr.setOnFocusChangeListener(onFocusChangeListener);
        this.mNv.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.lwX.setOnFocusChangeListener(onFocusChangeListener);
    }

    public i dGv() {
        return this.mNx;
    }

    public View dGw() {
        return this.mBack;
    }

    public TextView dGx() {
        return this.lwX;
    }

    public TextView dGy() {
        return this.mNw;
    }

    public void af(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ag(View.OnClickListener onClickListener) {
        this.lwX.setOnClickListener(onClickListener);
    }

    public void ah(View.OnClickListener onClickListener) {
        this.mNu.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.mNF != null) {
            this.mNF.getLayoutMode().setNightMode(i == 1);
            this.mNF.getLayoutMode().onModeChanged(this.jVZ);
            this.mNavigationBar.onChangeSkinType(this.mNF.getPageContext(), i);
            ap.setTopBarCommonFinishButton(this.lwX, i);
            ap.setBackgroundColor(this.mNs, R.color.CAM_X0204);
            ap.setBackgroundColor(this.mNt, R.color.CAM_X0204);
            ap.setBackgroundColor(this.mNr, R.color.CAM_X0111);
            ap.setBackgroundColor(this.mNB, R.color.CAM_X0205);
            int color = ap.getColor(R.color.CAM_X0105);
            int color2 = ap.getColor(R.color.CAM_X0110);
            this.mNr.setTextColor(color);
            this.mNv.setTextColor(color);
            this.mND.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.mNE.setTextColor(ap.getColor(R.color.CAM_X0109));
            h(this.mNr, color2);
            h(this.mNv, color2);
            dGr();
        }
    }

    public ShareSDKImageView dGz() {
        return this.mNC;
    }
}
