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
import com.baidu.tbadk.core.util.au;
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
/* loaded from: classes24.dex */
public class c {
    private PostPrefixData mPrefixData;
    private WriteData mtA;
    private View mtU;
    private TextView mtX;
    private i mtY;
    private ImageView mtZ;
    private View mua;
    private LinearLayout mub;
    private LinearLayout muc;
    private ShareSDKImageView mud;
    private TextView mue;
    private TextView muf;
    private WriteShareActivity mug;
    private com.baidu.tbadk.img.b muh;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText mtS = null;
    private View mtT = null;
    private LinearLayout mtV = null;
    private EditText mtW = null;
    private TextView leh = null;
    private RelativeLayout jCT = null;
    private boolean mui = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mtA = null;
        this.mug = writeShareActivity;
        this.mtA = writeShareActivity.cSo();
        if (this.muh == null) {
            this.muh = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.mug.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mug.getPageContext().getString(R.string.share_navigationbar_title));
        this.leh = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mug.getPageContext().getString(R.string.send_post));
        this.jCT = (RelativeLayout) this.mug.findViewById(R.id.parent);
        this.mtT = this.mug.findViewById(R.id.interval_view);
        this.mtU = this.mug.findViewById(R.id.prefix_interval_view);
        this.mub = (LinearLayout) this.mug.findViewById(R.id.post_share_layout);
        this.muc = (LinearLayout) this.mug.findViewById(R.id.post_share_content_layout);
        this.mud = (ShareSDKImageView) this.mug.findViewById(R.id.post_share_image);
        this.mue = (TextView) this.mug.findViewById(R.id.post_share_title);
        this.muf = (TextView) this.mug.findViewById(R.id.post_share_content);
        dAP();
        dAR();
        this.mtV = (LinearLayout) this.mug.findViewById(R.id.post_content_container);
        this.mtV.setDrawingCacheEnabled(false);
        this.mtS.setVisibility(0);
        this.mtW.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        dAQ();
    }

    public void dAN() {
        this.mub = (LinearLayout) this.mug.findViewById(R.id.post_share_layout);
        this.mud = (ShareSDKImageView) this.mug.findViewById(R.id.post_share_image);
        this.mud.setIsRound(false);
        this.mud.setDrawBorder(false);
        this.mud.setAutoChangeStyle(true);
        this.mud.setRadius(0);
        this.mue = (TextView) this.mug.findViewById(R.id.post_share_title);
        this.muf = (TextView) this.mug.findViewById(R.id.post_share_content);
        if (this.mtA != null) {
            if (this.mtA.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.mud.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.mud.getLoadedWidth() != 0 && c.this.mud.getLoadedHeight() != 0) {
                                c.this.width = c.this.mud.getLoadedWidth();
                                c.this.height = c.this.mud.getLoadedHeight();
                                if (c.this.mug != null) {
                                    c.this.mug.cSo().setShareSummaryImgWidth(c.this.width);
                                    c.this.mug.cSo().setShareSummaryImgHeight(c.this.height);
                                    c.this.mui = true;
                                    c.this.dAQ();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.mui = false;
                        c.this.dAQ();
                        if (c.this.mug != null) {
                            c.this.mug.Iz(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.mui = false;
                        c.this.dAQ();
                        if (c.this.mug != null) {
                            c.this.mug.Iz(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mtA.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mtA.getShareSummaryImg() != null && this.mtA.getShareSummaryImg().trim().length() > 0) {
                    this.mud.startLoad(this.mtA.getShareSummaryImg(), 10, true);
                } else {
                    this.mui = true;
                    dAQ();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mtA.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.mud.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mtA.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mtA.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.bf(au.bmV().getPostImageSize(), au.bmV().getPostImageHeightLimit()));
                    this.mud.setTag(imageFileInfo.toCachedKey(true));
                    if (this.muh.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.mub.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.mud.invalidate();
                    }
                }
                this.mui = true;
                dAQ();
            }
            this.mtA.setShareSummaryImgType(f.getExtension(this.mtA.getShareSummaryImg()));
            this.mue.setText(this.mtA.getShareSummaryTitle());
            this.muf.setText(this.mtA.getShareSummaryContent());
        }
    }

    private void dAO() {
        this.mua = this.mug.findViewById(R.id.post_prefix_layout);
        this.mtX = (TextView) this.mug.findViewById(R.id.post_prefix);
        this.mtZ = (ImageView) this.mug.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mua.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.mtX.setText(prefixs.get(0));
            this.mug.IA(0);
            this.mua.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mtX.setVisibility(0);
                    c.this.mua.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.mtY, view, l.dip2px(c.this.mug.getPageContext().getContext(), 15.0f), l.dip2px(c.this.mug.getPageContext().getContext(), 1.0f));
                    if (c.this.mug != null) {
                        c.this.mug.dAM();
                    }
                }
            });
            this.mtZ = (ImageView) this.mug.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.mtZ.setVisibility(0);
                this.mtX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.mtX.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.mtY, view, l.dip2px(c.this.mug.getPageContext().getContext(), 15.0f), l.dip2px(c.this.mug.getPageContext().getContext(), 1.0f));
                        if (c.this.mug != null) {
                            c.this.mug.dAM();
                        }
                    }
                });
            }
            this.mtY = new i(this.mug.getPageContext().getContext());
            this.mtY.setMaxHeight(l.dip2px(this.mug.getPageContext().getContext(), 225.0f));
            this.mtY.setOutsideTouchable(true);
            this.mtY.setFocusable(true);
            this.mtY.setBackgroundDrawable(ap.getDrawable(R.color.cp_bg_line_c));
            this.mtY.a(new i.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.i.a
                public void IB(int i) {
                    c.this.mug.IA(i);
                    c.this.mtX.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.mtY.setCurrentIndex(i);
                    c.this.dAQ();
                    g.dismissPopupWindow(c.this.mtY, c.this.mug.getPageContext().getPageActivity());
                }
            });
            this.mtY.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.mua.setSelected(false);
                }
            });
            int color = ap.getColor(R.color.common_color_10097);
            ap.setBackgroundResource(this.mtX, R.drawable.write_prefix_item_selector);
            ap.setImageResource(this.mtZ, R.drawable.icon_title_down);
            this.mtX.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.mug.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.mug.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ap.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.mug.getPageContext().getContext(), this.mug.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.mug.getPageContext().getContext(), this.mug.getResources().getDimension(R.dimen.ds22)), 0);
                this.mtY.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.mug.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.mug.getPageContext().getContext(), this.mug.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.mug.getPageContext().getContext(), this.mug.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.mtY.setCurrentIndex(0);
            return;
        }
        this.mua.setVisibility(8);
    }

    protected void dAP() {
        this.mtS = (EditText) this.mug.findViewById(R.id.post_title);
        if (this.mtA.getType() == 3) {
            if (this.mtA.getTitle() != null && this.mtA.getTitle().trim().length() > 0) {
                this.mtS.setText(this.mtA.getTitle());
                this.mtS.setSelection(this.mtA.getTitle().length());
            } else {
                String str = this.mug.getPageContext().getString(R.string.share_transfer_thread) + this.mtA.getShareSummaryTitle();
                this.mtS.setText(str);
                if (str.length() < 20) {
                    this.mtS.setSelection(str.length());
                } else {
                    this.mtS.setSelection(20);
                }
            }
        }
        this.mtS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dAQ();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void dAQ() {
        String str = null;
        if (this.mtA.getType() == 3) {
            String trim = this.mtS.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.mug.dAK() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.mtA.setIsNoTitle(true);
                    } else {
                        this.mtA.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.mtA.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.mtA.setIsNoTitle(true);
            } else {
                this.mtA.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.mui) {
            this.leh.setEnabled(false);
        } else {
            this.leh.setEnabled(true);
        }
    }

    protected void dAR() {
        this.mtW = (EditText) this.mug.findViewById(R.id.post_content);
        this.mtW.setDrawingCacheEnabled(false);
        if (this.mtA.getContent() != null && this.mtA.getContent().length() > 0) {
            SpannableString av = TbFaceManager.bwK().av(this.mug.getPageContext().getContext(), this.mtA.getContent());
            this.mtW.setText(av);
            this.mtW.setSelection(av.length());
        }
        this.mtW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.mtW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dAQ();
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

    public EditText dAS() {
        return this.mtS;
    }

    public EditText dAT() {
        return this.mtW;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        dAO();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.mtS.setOnFocusChangeListener(onFocusChangeListener);
        this.mtW.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.leh.setOnFocusChangeListener(onFocusChangeListener);
    }

    public i dAU() {
        return this.mtY;
    }

    public View dAV() {
        return this.mBack;
    }

    public TextView dAW() {
        return this.leh;
    }

    public TextView dAX() {
        return this.mtX;
    }

    public void ae(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void af(View.OnClickListener onClickListener) {
        this.leh.setOnClickListener(onClickListener);
    }

    public void ag(View.OnClickListener onClickListener) {
        this.mtV.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.mug != null) {
            this.mug.getLayoutMode().setNightMode(i == 1);
            this.mug.getLayoutMode().onModeChanged(this.jCT);
            this.mNavigationBar.onChangeSkinType(this.mug.getPageContext(), i);
            ap.setTopBarCommonFinishButton(this.leh, i);
            ap.setBackgroundColor(this.mtT, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.mtU, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.mtS, R.color.cp_cont_g);
            ap.setBackgroundColor(this.muc, R.color.cp_bg_line_e);
            int color = ap.getColor(R.color.cp_cont_b);
            int color2 = ap.getColor(R.color.cp_cont_e);
            this.mtS.setTextColor(color);
            this.mtW.setTextColor(color);
            this.mue.setTextColor(ap.getColor(R.color.cp_cont_b));
            this.muf.setTextColor(ap.getColor(R.color.cp_cont_d));
            h(this.mtS, color2);
            h(this.mtW, color2);
            dAQ();
        }
    }

    public ShareSDKImageView dAY() {
        return this.mud;
    }
}
