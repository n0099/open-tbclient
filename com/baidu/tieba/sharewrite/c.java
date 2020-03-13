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
    private WriteData jWW;
    private ShareSDKImageView jXA;
    private TextView jXB;
    private TextView jXC;
    private WriteShareActivity jXD;
    private com.baidu.tbadk.img.b jXE;
    private View jXq;
    private TextView jXu;
    private h jXv;
    private ImageView jXw;
    private View jXx;
    private LinearLayout jXy;
    private LinearLayout jXz;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText jXo = null;
    private View jXp = null;
    private LinearLayout jXr = null;
    private EditText jXs = null;
    private TextView jXt = null;
    private RelativeLayout hsl = null;
    private boolean jXF = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.jWW = null;
        this.jXD = writeShareActivity;
        this.jWW = writeShareActivity.cHV();
        if (this.jXE == null) {
            this.jXE = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.jXD.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jXD.getPageContext().getString(R.string.share_navigationbar_title));
        this.jXt = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jXD.getPageContext().getString(R.string.send_post));
        this.hsl = (RelativeLayout) this.jXD.findViewById(R.id.parent);
        this.jXp = this.jXD.findViewById(R.id.interval_view);
        this.jXq = this.jXD.findViewById(R.id.prefix_interval_view);
        this.jXy = (LinearLayout) this.jXD.findViewById(R.id.post_share_layout);
        this.jXz = (LinearLayout) this.jXD.findViewById(R.id.post_share_content_layout);
        this.jXA = (ShareSDKImageView) this.jXD.findViewById(R.id.post_share_image);
        this.jXB = (TextView) this.jXD.findViewById(R.id.post_share_title);
        this.jXC = (TextView) this.jXD.findViewById(R.id.post_share_content);
        cIb();
        cId();
        this.jXr = (LinearLayout) this.jXD.findViewById(R.id.post_content_container);
        this.jXr.setDrawingCacheEnabled(false);
        this.jXo.setVisibility(0);
        this.jXs.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        cIc();
    }

    public void cHZ() {
        this.jXy = (LinearLayout) this.jXD.findViewById(R.id.post_share_layout);
        this.jXA = (ShareSDKImageView) this.jXD.findViewById(R.id.post_share_image);
        this.jXA.setIsRound(false);
        this.jXA.setDrawBorder(false);
        this.jXA.setAutoChangeStyle(true);
        this.jXA.setRadius(0);
        this.jXB = (TextView) this.jXD.findViewById(R.id.post_share_title);
        this.jXC = (TextView) this.jXD.findViewById(R.id.post_share_content);
        if (this.jWW != null) {
            if (this.jWW.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.jXA.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.jXA.getLoadedWidth() != 0 && c.this.jXA.getLoadedHeight() != 0) {
                                c.this.width = c.this.jXA.getLoadedWidth();
                                c.this.height = c.this.jXA.getLoadedHeight();
                                if (c.this.jXD != null) {
                                    c.this.jXD.cHV().setShareSummaryImgWidth(c.this.width);
                                    c.this.jXD.cHV().setShareSummaryImgHeight(c.this.height);
                                    c.this.jXF = true;
                                    c.this.cIc();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.jXF = false;
                        c.this.cIc();
                        if (c.this.jXD != null) {
                            c.this.jXD.Cb(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.jXF = false;
                        c.this.cIc();
                        if (c.this.jXD != null) {
                            c.this.jXD.Cb(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.jWW.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.jWW.getShareSummaryImg() != null && this.jWW.getShareSummaryImg().trim().length() > 0) {
                    this.jXA.startLoad(this.jWW.getShareSummaryImg(), 10, true);
                } else {
                    this.jXF = true;
                    cIc();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.jWW.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.jXA.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.jWW.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(m.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.jWW.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.aJ(ar.aGD().getPostImageSize(), ar.aGD().getPostImageHeightLimit()));
                    this.jXA.setTag(imageFileInfo.toCachedKey(true));
                    if (this.jXE.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.jXy.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.jXA.invalidate();
                    }
                }
                this.jXF = true;
                cIc();
            }
            this.jWW.setShareSummaryImgType(f.getExtension(this.jWW.getShareSummaryImg()));
            this.jXB.setText(this.jWW.getShareSummaryTitle());
            this.jXC.setText(this.jWW.getShareSummaryContent());
        }
    }

    private void cIa() {
        this.jXx = this.jXD.findViewById(R.id.post_prefix_layout);
        this.jXu = (TextView) this.jXD.findViewById(R.id.post_prefix);
        this.jXw = (ImageView) this.jXD.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.jXx.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.jXu.setText(prefixs.get(0));
            this.jXD.Cc(0);
            this.jXx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.jXu.setVisibility(0);
                    c.this.jXx.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.jXv, view, l.dip2px(c.this.jXD.getPageContext().getContext(), 15.0f), l.dip2px(c.this.jXD.getPageContext().getContext(), 1.0f));
                    if (c.this.jXD != null) {
                        c.this.jXD.cHY();
                    }
                }
            });
            this.jXw = (ImageView) this.jXD.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.jXw.setVisibility(0);
                this.jXu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.jXu.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.jXv, view, l.dip2px(c.this.jXD.getPageContext().getContext(), 15.0f), l.dip2px(c.this.jXD.getPageContext().getContext(), 1.0f));
                        if (c.this.jXD != null) {
                            c.this.jXD.cHY();
                        }
                    }
                });
            }
            this.jXv = new h(this.jXD.getPageContext().getContext());
            this.jXv.setMaxHeight(l.dip2px(this.jXD.getPageContext().getContext(), 225.0f));
            this.jXv.setOutsideTouchable(true);
            this.jXv.setFocusable(true);
            this.jXv.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_c));
            this.jXv.a(new h.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.h.a
                public void Cd(int i) {
                    c.this.jXD.Cc(i);
                    c.this.jXu.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.jXv.setCurrentIndex(i);
                    c.this.cIc();
                    g.dismissPopupWindow(c.this.jXv, c.this.jXD.getPageContext().getPageActivity());
                }
            });
            this.jXv.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.jXx.setSelected(false);
                }
            });
            int color = am.getColor(R.color.common_color_10097);
            am.setBackgroundResource(this.jXu, R.drawable.write_prefix_item_selector);
            am.setImageResource(this.jXw, R.drawable.icon_title_down);
            this.jXu.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.jXD.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.jXD.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                am.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.jXD.getPageContext().getContext(), this.jXD.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.jXD.getPageContext().getContext(), this.jXD.getResources().getDimension(R.dimen.ds22)), 0);
                this.jXv.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.jXD.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.jXD.getPageContext().getContext(), this.jXD.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.jXD.getPageContext().getContext(), this.jXD.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.jXv.setCurrentIndex(0);
            return;
        }
        this.jXx.setVisibility(8);
    }

    protected void cIb() {
        this.jXo = (EditText) this.jXD.findViewById(R.id.post_title);
        if (this.jWW.getType() == 3) {
            if (this.jWW.getTitle() != null && this.jWW.getTitle().trim().length() > 0) {
                this.jXo.setText(this.jWW.getTitle());
                this.jXo.setSelection(this.jWW.getTitle().length());
            } else {
                String str = this.jXD.getPageContext().getString(R.string.share_transfer_thread) + this.jWW.getShareSummaryTitle();
                this.jXo.setText(str);
                if (str.length() < 20) {
                    this.jXo.setSelection(str.length());
                } else {
                    this.jXo.setSelection(20);
                }
            }
        }
        this.jXo.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cIc();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void cIc() {
        String str = null;
        if (this.jWW.getType() == 3) {
            String trim = this.jXo.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.jXD.cHW() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.jWW.setIsNoTitle(true);
                    } else {
                        this.jWW.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.jWW.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.jWW.setIsNoTitle(true);
            } else {
                this.jWW.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.jXF) {
            this.jXt.setEnabled(false);
        } else {
            this.jXt.setEnabled(true);
        }
    }

    protected void cId() {
        this.jXs = (EditText) this.jXD.findViewById(R.id.post_content);
        this.jXs.setDrawingCacheEnabled(false);
        if (this.jWW.getContent() != null && this.jWW.getContent().length() > 0) {
            SpannableString aB = TbFaceManager.aPQ().aB(this.jXD.getPageContext().getContext(), this.jWW.getContent());
            this.jXs.setText(aB);
            this.jXs.setSelection(aB.length());
        }
        this.jXs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.jXs.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cIc();
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

    public EditText cIe() {
        return this.jXo;
    }

    public EditText cIf() {
        return this.jXs;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        cIa();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.jXo.setOnFocusChangeListener(onFocusChangeListener);
        this.jXs.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.jXt.setOnFocusChangeListener(onFocusChangeListener);
    }

    public h cIg() {
        return this.jXv;
    }

    public View cIh() {
        return this.mBack;
    }

    public TextView cIi() {
        return this.jXt;
    }

    public TextView cIj() {
        return this.jXu;
    }

    public void ab(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ac(View.OnClickListener onClickListener) {
        this.jXt.setOnClickListener(onClickListener);
    }

    public void ad(View.OnClickListener onClickListener) {
        this.jXr.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.jXD != null) {
            this.jXD.getLayoutMode().setNightMode(i == 1);
            this.jXD.getLayoutMode().onModeChanged(this.hsl);
            this.mNavigationBar.onChangeSkinType(this.jXD.getPageContext(), i);
            am.setTopBarCommonFinishButton(this.jXt, i);
            am.setBackgroundColor(this.jXp, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.jXq, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.jXo, R.color.cp_cont_g);
            am.setBackgroundColor(this.jXz, R.color.cp_bg_line_e);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_e);
            this.jXo.setTextColor(color);
            this.jXs.setTextColor(color);
            this.jXB.setTextColor(am.getColor(R.color.cp_cont_b));
            this.jXC.setTextColor(am.getColor(R.color.cp_cont_d));
            f(this.jXo, color2);
            f(this.jXs, color2);
            cIc();
        }
    }

    public ShareSDKImageView cIk() {
        return this.jXA;
    }
}
