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
/* loaded from: classes11.dex */
public class c {
    private View jYS;
    private TextView jYW;
    private h jYX;
    private ImageView jYY;
    private View jYZ;
    private WriteData jYy;
    private LinearLayout jZa;
    private LinearLayout jZb;
    private ShareSDKImageView jZc;
    private TextView jZd;
    private TextView jZe;
    private WriteShareActivity jZf;
    private com.baidu.tbadk.img.b jZg;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText jYQ = null;
    private View jYR = null;
    private LinearLayout jYT = null;
    private EditText jYU = null;
    private TextView jYV = null;
    private RelativeLayout htL = null;
    private boolean jZh = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.jYy = null;
        this.jZf = writeShareActivity;
        this.jYy = writeShareActivity.cIp();
        if (this.jZg == null) {
            this.jZg = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.jZf.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jZf.getPageContext().getString(R.string.share_navigationbar_title));
        this.jYV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jZf.getPageContext().getString(R.string.send_post));
        this.htL = (RelativeLayout) this.jZf.findViewById(R.id.parent);
        this.jYR = this.jZf.findViewById(R.id.interval_view);
        this.jYS = this.jZf.findViewById(R.id.prefix_interval_view);
        this.jZa = (LinearLayout) this.jZf.findViewById(R.id.post_share_layout);
        this.jZb = (LinearLayout) this.jZf.findViewById(R.id.post_share_content_layout);
        this.jZc = (ShareSDKImageView) this.jZf.findViewById(R.id.post_share_image);
        this.jZd = (TextView) this.jZf.findViewById(R.id.post_share_title);
        this.jZe = (TextView) this.jZf.findViewById(R.id.post_share_content);
        cIv();
        cIx();
        this.jYT = (LinearLayout) this.jZf.findViewById(R.id.post_content_container);
        this.jYT.setDrawingCacheEnabled(false);
        this.jYQ.setVisibility(0);
        this.jYU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        cIw();
    }

    public void cIt() {
        this.jZa = (LinearLayout) this.jZf.findViewById(R.id.post_share_layout);
        this.jZc = (ShareSDKImageView) this.jZf.findViewById(R.id.post_share_image);
        this.jZc.setIsRound(false);
        this.jZc.setDrawBorder(false);
        this.jZc.setAutoChangeStyle(true);
        this.jZc.setRadius(0);
        this.jZd = (TextView) this.jZf.findViewById(R.id.post_share_title);
        this.jZe = (TextView) this.jZf.findViewById(R.id.post_share_content);
        if (this.jYy != null) {
            if (this.jYy.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.jZc.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.jZc.getLoadedWidth() != 0 && c.this.jZc.getLoadedHeight() != 0) {
                                c.this.width = c.this.jZc.getLoadedWidth();
                                c.this.height = c.this.jZc.getLoadedHeight();
                                if (c.this.jZf != null) {
                                    c.this.jZf.cIp().setShareSummaryImgWidth(c.this.width);
                                    c.this.jZf.cIp().setShareSummaryImgHeight(c.this.height);
                                    c.this.jZh = true;
                                    c.this.cIw();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.jZh = false;
                        c.this.cIw();
                        if (c.this.jZf != null) {
                            c.this.jZf.Cj(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.jZh = false;
                        c.this.cIw();
                        if (c.this.jZf != null) {
                            c.this.jZf.Cj(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.jYy.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.jYy.getShareSummaryImg() != null && this.jYy.getShareSummaryImg().trim().length() > 0) {
                    this.jZc.startLoad(this.jYy.getShareSummaryImg(), 10, true);
                } else {
                    this.jZh = true;
                    cIw();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.jYy.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.jZc.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.jYy.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(m.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.jYy.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.aK(ar.aGH().getPostImageSize(), ar.aGH().getPostImageHeightLimit()));
                    this.jZc.setTag(imageFileInfo.toCachedKey(true));
                    if (this.jZg.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.jZa.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.jZc.invalidate();
                    }
                }
                this.jZh = true;
                cIw();
            }
            this.jYy.setShareSummaryImgType(f.getExtension(this.jYy.getShareSummaryImg()));
            this.jZd.setText(this.jYy.getShareSummaryTitle());
            this.jZe.setText(this.jYy.getShareSummaryContent());
        }
    }

    private void cIu() {
        this.jYZ = this.jZf.findViewById(R.id.post_prefix_layout);
        this.jYW = (TextView) this.jZf.findViewById(R.id.post_prefix);
        this.jYY = (ImageView) this.jZf.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.jYZ.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.jYW.setText(prefixs.get(0));
            this.jZf.Ck(0);
            this.jYZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.jYW.setVisibility(0);
                    c.this.jYZ.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.jYX, view, l.dip2px(c.this.jZf.getPageContext().getContext(), 15.0f), l.dip2px(c.this.jZf.getPageContext().getContext(), 1.0f));
                    if (c.this.jZf != null) {
                        c.this.jZf.cIs();
                    }
                }
            });
            this.jYY = (ImageView) this.jZf.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.jYY.setVisibility(0);
                this.jYW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.jYW.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.jYX, view, l.dip2px(c.this.jZf.getPageContext().getContext(), 15.0f), l.dip2px(c.this.jZf.getPageContext().getContext(), 1.0f));
                        if (c.this.jZf != null) {
                            c.this.jZf.cIs();
                        }
                    }
                });
            }
            this.jYX = new h(this.jZf.getPageContext().getContext());
            this.jYX.setMaxHeight(l.dip2px(this.jZf.getPageContext().getContext(), 225.0f));
            this.jYX.setOutsideTouchable(true);
            this.jYX.setFocusable(true);
            this.jYX.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_c));
            this.jYX.a(new h.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.h.a
                public void Cl(int i) {
                    c.this.jZf.Ck(i);
                    c.this.jYW.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.jYX.setCurrentIndex(i);
                    c.this.cIw();
                    g.dismissPopupWindow(c.this.jYX, c.this.jZf.getPageContext().getPageActivity());
                }
            });
            this.jYX.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.jYZ.setSelected(false);
                }
            });
            int color = am.getColor(R.color.common_color_10097);
            am.setBackgroundResource(this.jYW, R.drawable.write_prefix_item_selector);
            am.setImageResource(this.jYY, R.drawable.icon_title_down);
            this.jYW.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.jZf.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.jZf.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                am.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.jZf.getPageContext().getContext(), this.jZf.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.jZf.getPageContext().getContext(), this.jZf.getResources().getDimension(R.dimen.ds22)), 0);
                this.jYX.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.jZf.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.jZf.getPageContext().getContext(), this.jZf.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.jZf.getPageContext().getContext(), this.jZf.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.jYX.setCurrentIndex(0);
            return;
        }
        this.jYZ.setVisibility(8);
    }

    protected void cIv() {
        this.jYQ = (EditText) this.jZf.findViewById(R.id.post_title);
        if (this.jYy.getType() == 3) {
            if (this.jYy.getTitle() != null && this.jYy.getTitle().trim().length() > 0) {
                this.jYQ.setText(this.jYy.getTitle());
                this.jYQ.setSelection(this.jYy.getTitle().length());
            } else {
                String str = this.jZf.getPageContext().getString(R.string.share_transfer_thread) + this.jYy.getShareSummaryTitle();
                this.jYQ.setText(str);
                if (str.length() < 20) {
                    this.jYQ.setSelection(str.length());
                } else {
                    this.jYQ.setSelection(20);
                }
            }
        }
        this.jYQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cIw();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void cIw() {
        String str = null;
        if (this.jYy.getType() == 3) {
            String trim = this.jYQ.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.jZf.cIq() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.jYy.setIsNoTitle(true);
                    } else {
                        this.jYy.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.jYy.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.jYy.setIsNoTitle(true);
            } else {
                this.jYy.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.jZh) {
            this.jYV.setEnabled(false);
        } else {
            this.jYV.setEnabled(true);
        }
    }

    protected void cIx() {
        this.jYU = (EditText) this.jZf.findViewById(R.id.post_content);
        this.jYU.setDrawingCacheEnabled(false);
        if (this.jYy.getContent() != null && this.jYy.getContent().length() > 0) {
            SpannableString aB = TbFaceManager.aPU().aB(this.jZf.getPageContext().getContext(), this.jYy.getContent());
            this.jYU.setText(aB);
            this.jYU.setSelection(aB.length());
        }
        this.jYU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.jYU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cIw();
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

    public EditText cIy() {
        return this.jYQ;
    }

    public EditText cIz() {
        return this.jYU;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        cIu();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.jYQ.setOnFocusChangeListener(onFocusChangeListener);
        this.jYU.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.jYV.setOnFocusChangeListener(onFocusChangeListener);
    }

    public h cIA() {
        return this.jYX;
    }

    public View cIB() {
        return this.mBack;
    }

    public TextView cIC() {
        return this.jYV;
    }

    public TextView cID() {
        return this.jYW;
    }

    public void ab(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ac(View.OnClickListener onClickListener) {
        this.jYV.setOnClickListener(onClickListener);
    }

    public void ad(View.OnClickListener onClickListener) {
        this.jYT.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.jZf != null) {
            this.jZf.getLayoutMode().setNightMode(i == 1);
            this.jZf.getLayoutMode().onModeChanged(this.htL);
            this.mNavigationBar.onChangeSkinType(this.jZf.getPageContext(), i);
            am.setTopBarCommonFinishButton(this.jYV, i);
            am.setBackgroundColor(this.jYR, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.jYS, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.jYQ, R.color.cp_cont_g);
            am.setBackgroundColor(this.jZb, R.color.cp_bg_line_e);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_e);
            this.jYQ.setTextColor(color);
            this.jYU.setTextColor(color);
            this.jZd.setTextColor(am.getColor(R.color.cp_cont_b));
            this.jZe.setTextColor(am.getColor(R.color.cp_cont_d));
            f(this.jYQ, color2);
            f(this.jYU, color2);
            cIw();
        }
    }

    public ShareSDKImageView cIE() {
        return this.jZc;
    }
}
