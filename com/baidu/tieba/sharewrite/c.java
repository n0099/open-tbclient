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
    private WriteData jWI;
    private View jXc;
    private TextView jXg;
    private h jXh;
    private ImageView jXi;
    private View jXj;
    private LinearLayout jXk;
    private LinearLayout jXl;
    private ShareSDKImageView jXm;
    private TextView jXn;
    private TextView jXo;
    private WriteShareActivity jXp;
    private com.baidu.tbadk.img.b jXq;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText jXa = null;
    private View jXb = null;
    private LinearLayout jXd = null;
    private EditText jXe = null;
    private TextView jXf = null;
    private RelativeLayout hrX = null;
    private boolean jXr = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.jWI = null;
        this.jXp = writeShareActivity;
        this.jWI = writeShareActivity.cHS();
        if (this.jXq == null) {
            this.jXq = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.jXp.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jXp.getPageContext().getString(R.string.share_navigationbar_title));
        this.jXf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jXp.getPageContext().getString(R.string.send_post));
        this.hrX = (RelativeLayout) this.jXp.findViewById(R.id.parent);
        this.jXb = this.jXp.findViewById(R.id.interval_view);
        this.jXc = this.jXp.findViewById(R.id.prefix_interval_view);
        this.jXk = (LinearLayout) this.jXp.findViewById(R.id.post_share_layout);
        this.jXl = (LinearLayout) this.jXp.findViewById(R.id.post_share_content_layout);
        this.jXm = (ShareSDKImageView) this.jXp.findViewById(R.id.post_share_image);
        this.jXn = (TextView) this.jXp.findViewById(R.id.post_share_title);
        this.jXo = (TextView) this.jXp.findViewById(R.id.post_share_content);
        cHY();
        cIa();
        this.jXd = (LinearLayout) this.jXp.findViewById(R.id.post_content_container);
        this.jXd.setDrawingCacheEnabled(false);
        this.jXa.setVisibility(0);
        this.jXe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        cHZ();
    }

    public void cHW() {
        this.jXk = (LinearLayout) this.jXp.findViewById(R.id.post_share_layout);
        this.jXm = (ShareSDKImageView) this.jXp.findViewById(R.id.post_share_image);
        this.jXm.setIsRound(false);
        this.jXm.setDrawBorder(false);
        this.jXm.setAutoChangeStyle(true);
        this.jXm.setRadius(0);
        this.jXn = (TextView) this.jXp.findViewById(R.id.post_share_title);
        this.jXo = (TextView) this.jXp.findViewById(R.id.post_share_content);
        if (this.jWI != null) {
            if (this.jWI.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.jXm.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.jXm.getLoadedWidth() != 0 && c.this.jXm.getLoadedHeight() != 0) {
                                c.this.width = c.this.jXm.getLoadedWidth();
                                c.this.height = c.this.jXm.getLoadedHeight();
                                if (c.this.jXp != null) {
                                    c.this.jXp.cHS().setShareSummaryImgWidth(c.this.width);
                                    c.this.jXp.cHS().setShareSummaryImgHeight(c.this.height);
                                    c.this.jXr = true;
                                    c.this.cHZ();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.jXr = false;
                        c.this.cHZ();
                        if (c.this.jXp != null) {
                            c.this.jXp.Cb(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.jXr = false;
                        c.this.cHZ();
                        if (c.this.jXp != null) {
                            c.this.jXp.Cb(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.jWI.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.jWI.getShareSummaryImg() != null && this.jWI.getShareSummaryImg().trim().length() > 0) {
                    this.jXm.startLoad(this.jWI.getShareSummaryImg(), 10, true);
                } else {
                    this.jXr = true;
                    cHZ();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.jWI.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.jXm.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.jWI.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(m.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.jWI.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.aJ(ar.aGB().getPostImageSize(), ar.aGB().getPostImageHeightLimit()));
                    this.jXm.setTag(imageFileInfo.toCachedKey(true));
                    if (this.jXq.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.jXk.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.jXm.invalidate();
                    }
                }
                this.jXr = true;
                cHZ();
            }
            this.jWI.setShareSummaryImgType(f.getExtension(this.jWI.getShareSummaryImg()));
            this.jXn.setText(this.jWI.getShareSummaryTitle());
            this.jXo.setText(this.jWI.getShareSummaryContent());
        }
    }

    private void cHX() {
        this.jXj = this.jXp.findViewById(R.id.post_prefix_layout);
        this.jXg = (TextView) this.jXp.findViewById(R.id.post_prefix);
        this.jXi = (ImageView) this.jXp.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.jXj.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.jXg.setText(prefixs.get(0));
            this.jXp.Cc(0);
            this.jXj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.jXg.setVisibility(0);
                    c.this.jXj.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.jXh, view, l.dip2px(c.this.jXp.getPageContext().getContext(), 15.0f), l.dip2px(c.this.jXp.getPageContext().getContext(), 1.0f));
                    if (c.this.jXp != null) {
                        c.this.jXp.cHV();
                    }
                }
            });
            this.jXi = (ImageView) this.jXp.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.jXi.setVisibility(0);
                this.jXg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.jXg.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.jXh, view, l.dip2px(c.this.jXp.getPageContext().getContext(), 15.0f), l.dip2px(c.this.jXp.getPageContext().getContext(), 1.0f));
                        if (c.this.jXp != null) {
                            c.this.jXp.cHV();
                        }
                    }
                });
            }
            this.jXh = new h(this.jXp.getPageContext().getContext());
            this.jXh.setMaxHeight(l.dip2px(this.jXp.getPageContext().getContext(), 225.0f));
            this.jXh.setOutsideTouchable(true);
            this.jXh.setFocusable(true);
            this.jXh.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_c));
            this.jXh.a(new h.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.h.a
                public void Cd(int i) {
                    c.this.jXp.Cc(i);
                    c.this.jXg.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.jXh.setCurrentIndex(i);
                    c.this.cHZ();
                    g.dismissPopupWindow(c.this.jXh, c.this.jXp.getPageContext().getPageActivity());
                }
            });
            this.jXh.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.jXj.setSelected(false);
                }
            });
            int color = am.getColor(R.color.common_color_10097);
            am.setBackgroundResource(this.jXg, R.drawable.write_prefix_item_selector);
            am.setImageResource(this.jXi, R.drawable.icon_title_down);
            this.jXg.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.jXp.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.jXp.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                am.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.jXp.getPageContext().getContext(), this.jXp.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.jXp.getPageContext().getContext(), this.jXp.getResources().getDimension(R.dimen.ds22)), 0);
                this.jXh.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.jXp.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.jXp.getPageContext().getContext(), this.jXp.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.jXp.getPageContext().getContext(), this.jXp.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.jXh.setCurrentIndex(0);
            return;
        }
        this.jXj.setVisibility(8);
    }

    protected void cHY() {
        this.jXa = (EditText) this.jXp.findViewById(R.id.post_title);
        if (this.jWI.getType() == 3) {
            if (this.jWI.getTitle() != null && this.jWI.getTitle().trim().length() > 0) {
                this.jXa.setText(this.jWI.getTitle());
                this.jXa.setSelection(this.jWI.getTitle().length());
            } else {
                String str = this.jXp.getPageContext().getString(R.string.share_transfer_thread) + this.jWI.getShareSummaryTitle();
                this.jXa.setText(str);
                if (str.length() < 20) {
                    this.jXa.setSelection(str.length());
                } else {
                    this.jXa.setSelection(20);
                }
            }
        }
        this.jXa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cHZ();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void cHZ() {
        String str = null;
        if (this.jWI.getType() == 3) {
            String trim = this.jXa.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.jXp.cHT() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.jWI.setIsNoTitle(true);
                    } else {
                        this.jWI.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.jWI.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.jWI.setIsNoTitle(true);
            } else {
                this.jWI.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.jXr) {
            this.jXf.setEnabled(false);
        } else {
            this.jXf.setEnabled(true);
        }
    }

    protected void cIa() {
        this.jXe = (EditText) this.jXp.findViewById(R.id.post_content);
        this.jXe.setDrawingCacheEnabled(false);
        if (this.jWI.getContent() != null && this.jWI.getContent().length() > 0) {
            SpannableString aB = TbFaceManager.aPN().aB(this.jXp.getPageContext().getContext(), this.jWI.getContent());
            this.jXe.setText(aB);
            this.jXe.setSelection(aB.length());
        }
        this.jXe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.jXe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cHZ();
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

    public EditText cIb() {
        return this.jXa;
    }

    public EditText cIc() {
        return this.jXe;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        cHX();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.jXa.setOnFocusChangeListener(onFocusChangeListener);
        this.jXe.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.jXf.setOnFocusChangeListener(onFocusChangeListener);
    }

    public h cId() {
        return this.jXh;
    }

    public View cIe() {
        return this.mBack;
    }

    public TextView cIf() {
        return this.jXf;
    }

    public TextView cIg() {
        return this.jXg;
    }

    public void ab(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ac(View.OnClickListener onClickListener) {
        this.jXf.setOnClickListener(onClickListener);
    }

    public void ad(View.OnClickListener onClickListener) {
        this.jXd.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.jXp != null) {
            this.jXp.getLayoutMode().setNightMode(i == 1);
            this.jXp.getLayoutMode().onModeChanged(this.hrX);
            this.mNavigationBar.onChangeSkinType(this.jXp.getPageContext(), i);
            am.setTopBarCommonFinishButton(this.jXf, i);
            am.setBackgroundColor(this.jXb, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.jXc, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.jXa, R.color.cp_cont_g);
            am.setBackgroundColor(this.jXl, R.color.cp_bg_line_e);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_e);
            this.jXa.setTextColor(color);
            this.jXe.setTextColor(color);
            this.jXn.setTextColor(am.getColor(R.color.cp_cont_b));
            this.jXo.setTextColor(am.getColor(R.color.cp_cont_d));
            f(this.jXa, color2);
            f(this.jXe, color2);
            cHZ();
        }
    }

    public ShareSDKImageView cIh() {
        return this.jXm;
    }
}
