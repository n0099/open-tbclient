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
    private WriteData jWK;
    private View jXe;
    private TextView jXi;
    private h jXj;
    private ImageView jXk;
    private View jXl;
    private LinearLayout jXm;
    private LinearLayout jXn;
    private ShareSDKImageView jXo;
    private TextView jXp;
    private TextView jXq;
    private WriteShareActivity jXr;
    private com.baidu.tbadk.img.b jXs;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText jXc = null;
    private View jXd = null;
    private LinearLayout jXf = null;
    private EditText jXg = null;
    private TextView jXh = null;
    private RelativeLayout hrZ = null;
    private boolean jXt = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.jWK = null;
        this.jXr = writeShareActivity;
        this.jWK = writeShareActivity.cHU();
        if (this.jXs == null) {
            this.jXs = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.jXr.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jXr.getPageContext().getString(R.string.share_navigationbar_title));
        this.jXh = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jXr.getPageContext().getString(R.string.send_post));
        this.hrZ = (RelativeLayout) this.jXr.findViewById(R.id.parent);
        this.jXd = this.jXr.findViewById(R.id.interval_view);
        this.jXe = this.jXr.findViewById(R.id.prefix_interval_view);
        this.jXm = (LinearLayout) this.jXr.findViewById(R.id.post_share_layout);
        this.jXn = (LinearLayout) this.jXr.findViewById(R.id.post_share_content_layout);
        this.jXo = (ShareSDKImageView) this.jXr.findViewById(R.id.post_share_image);
        this.jXp = (TextView) this.jXr.findViewById(R.id.post_share_title);
        this.jXq = (TextView) this.jXr.findViewById(R.id.post_share_content);
        cIa();
        cIc();
        this.jXf = (LinearLayout) this.jXr.findViewById(R.id.post_content_container);
        this.jXf.setDrawingCacheEnabled(false);
        this.jXc.setVisibility(0);
        this.jXg.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        cIb();
    }

    public void cHY() {
        this.jXm = (LinearLayout) this.jXr.findViewById(R.id.post_share_layout);
        this.jXo = (ShareSDKImageView) this.jXr.findViewById(R.id.post_share_image);
        this.jXo.setIsRound(false);
        this.jXo.setDrawBorder(false);
        this.jXo.setAutoChangeStyle(true);
        this.jXo.setRadius(0);
        this.jXp = (TextView) this.jXr.findViewById(R.id.post_share_title);
        this.jXq = (TextView) this.jXr.findViewById(R.id.post_share_content);
        if (this.jWK != null) {
            if (this.jWK.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.jXo.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.jXo.getLoadedWidth() != 0 && c.this.jXo.getLoadedHeight() != 0) {
                                c.this.width = c.this.jXo.getLoadedWidth();
                                c.this.height = c.this.jXo.getLoadedHeight();
                                if (c.this.jXr != null) {
                                    c.this.jXr.cHU().setShareSummaryImgWidth(c.this.width);
                                    c.this.jXr.cHU().setShareSummaryImgHeight(c.this.height);
                                    c.this.jXt = true;
                                    c.this.cIb();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.jXt = false;
                        c.this.cIb();
                        if (c.this.jXr != null) {
                            c.this.jXr.Cb(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.jXt = false;
                        c.this.cIb();
                        if (c.this.jXr != null) {
                            c.this.jXr.Cb(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.jWK.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.jWK.getShareSummaryImg() != null && this.jWK.getShareSummaryImg().trim().length() > 0) {
                    this.jXo.startLoad(this.jWK.getShareSummaryImg(), 10, true);
                } else {
                    this.jXt = true;
                    cIb();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.jWK.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.jXo.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.jWK.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(m.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.jWK.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.aJ(ar.aGD().getPostImageSize(), ar.aGD().getPostImageHeightLimit()));
                    this.jXo.setTag(imageFileInfo.toCachedKey(true));
                    if (this.jXs.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.jXm.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.jXo.invalidate();
                    }
                }
                this.jXt = true;
                cIb();
            }
            this.jWK.setShareSummaryImgType(f.getExtension(this.jWK.getShareSummaryImg()));
            this.jXp.setText(this.jWK.getShareSummaryTitle());
            this.jXq.setText(this.jWK.getShareSummaryContent());
        }
    }

    private void cHZ() {
        this.jXl = this.jXr.findViewById(R.id.post_prefix_layout);
        this.jXi = (TextView) this.jXr.findViewById(R.id.post_prefix);
        this.jXk = (ImageView) this.jXr.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.jXl.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.jXi.setText(prefixs.get(0));
            this.jXr.Cc(0);
            this.jXl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.jXi.setVisibility(0);
                    c.this.jXl.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.jXj, view, l.dip2px(c.this.jXr.getPageContext().getContext(), 15.0f), l.dip2px(c.this.jXr.getPageContext().getContext(), 1.0f));
                    if (c.this.jXr != null) {
                        c.this.jXr.cHX();
                    }
                }
            });
            this.jXk = (ImageView) this.jXr.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.jXk.setVisibility(0);
                this.jXi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.jXi.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.jXj, view, l.dip2px(c.this.jXr.getPageContext().getContext(), 15.0f), l.dip2px(c.this.jXr.getPageContext().getContext(), 1.0f));
                        if (c.this.jXr != null) {
                            c.this.jXr.cHX();
                        }
                    }
                });
            }
            this.jXj = new h(this.jXr.getPageContext().getContext());
            this.jXj.setMaxHeight(l.dip2px(this.jXr.getPageContext().getContext(), 225.0f));
            this.jXj.setOutsideTouchable(true);
            this.jXj.setFocusable(true);
            this.jXj.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_c));
            this.jXj.a(new h.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.h.a
                public void Cd(int i) {
                    c.this.jXr.Cc(i);
                    c.this.jXi.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.jXj.setCurrentIndex(i);
                    c.this.cIb();
                    g.dismissPopupWindow(c.this.jXj, c.this.jXr.getPageContext().getPageActivity());
                }
            });
            this.jXj.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.jXl.setSelected(false);
                }
            });
            int color = am.getColor(R.color.common_color_10097);
            am.setBackgroundResource(this.jXi, R.drawable.write_prefix_item_selector);
            am.setImageResource(this.jXk, R.drawable.icon_title_down);
            this.jXi.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.jXr.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.jXr.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                am.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.jXr.getPageContext().getContext(), this.jXr.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.jXr.getPageContext().getContext(), this.jXr.getResources().getDimension(R.dimen.ds22)), 0);
                this.jXj.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.jXr.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.jXr.getPageContext().getContext(), this.jXr.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.jXr.getPageContext().getContext(), this.jXr.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.jXj.setCurrentIndex(0);
            return;
        }
        this.jXl.setVisibility(8);
    }

    protected void cIa() {
        this.jXc = (EditText) this.jXr.findViewById(R.id.post_title);
        if (this.jWK.getType() == 3) {
            if (this.jWK.getTitle() != null && this.jWK.getTitle().trim().length() > 0) {
                this.jXc.setText(this.jWK.getTitle());
                this.jXc.setSelection(this.jWK.getTitle().length());
            } else {
                String str = this.jXr.getPageContext().getString(R.string.share_transfer_thread) + this.jWK.getShareSummaryTitle();
                this.jXc.setText(str);
                if (str.length() < 20) {
                    this.jXc.setSelection(str.length());
                } else {
                    this.jXc.setSelection(20);
                }
            }
        }
        this.jXc.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cIb();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void cIb() {
        String str = null;
        if (this.jWK.getType() == 3) {
            String trim = this.jXc.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.jXr.cHV() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.jWK.setIsNoTitle(true);
                    } else {
                        this.jWK.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.jWK.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.jWK.setIsNoTitle(true);
            } else {
                this.jWK.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.jXt) {
            this.jXh.setEnabled(false);
        } else {
            this.jXh.setEnabled(true);
        }
    }

    protected void cIc() {
        this.jXg = (EditText) this.jXr.findViewById(R.id.post_content);
        this.jXg.setDrawingCacheEnabled(false);
        if (this.jWK.getContent() != null && this.jWK.getContent().length() > 0) {
            SpannableString aB = TbFaceManager.aPP().aB(this.jXr.getPageContext().getContext(), this.jWK.getContent());
            this.jXg.setText(aB);
            this.jXg.setSelection(aB.length());
        }
        this.jXg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.jXg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cIb();
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

    public EditText cId() {
        return this.jXc;
    }

    public EditText cIe() {
        return this.jXg;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        cHZ();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.jXc.setOnFocusChangeListener(onFocusChangeListener);
        this.jXg.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.jXh.setOnFocusChangeListener(onFocusChangeListener);
    }

    public h cIf() {
        return this.jXj;
    }

    public View cIg() {
        return this.mBack;
    }

    public TextView cIh() {
        return this.jXh;
    }

    public TextView cIi() {
        return this.jXi;
    }

    public void ab(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ac(View.OnClickListener onClickListener) {
        this.jXh.setOnClickListener(onClickListener);
    }

    public void ad(View.OnClickListener onClickListener) {
        this.jXf.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.jXr != null) {
            this.jXr.getLayoutMode().setNightMode(i == 1);
            this.jXr.getLayoutMode().onModeChanged(this.hrZ);
            this.mNavigationBar.onChangeSkinType(this.jXr.getPageContext(), i);
            am.setTopBarCommonFinishButton(this.jXh, i);
            am.setBackgroundColor(this.jXd, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.jXe, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.jXc, R.color.cp_cont_g);
            am.setBackgroundColor(this.jXn, R.color.cp_bg_line_e);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_e);
            this.jXc.setTextColor(color);
            this.jXg.setTextColor(color);
            this.jXp.setTextColor(am.getColor(R.color.cp_cont_b));
            this.jXq.setTextColor(am.getColor(R.color.cp_cont_d));
            f(this.jXc, color2);
            f(this.jXg, color2);
            cIb();
        }
    }

    public ShareSDKImageView cIj() {
        return this.jXo;
    }
}
