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
    private View mGA;
    private TextView mGD;
    private i mGE;
    private ImageView mGF;
    private View mGG;
    private LinearLayout mGH;
    private LinearLayout mGI;
    private ShareSDKImageView mGJ;
    private TextView mGK;
    private TextView mGL;
    private WriteShareActivity mGM;
    private com.baidu.tbadk.img.b mGN;
    private WriteData mGf;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText mGy = null;
    private View mGz = null;
    private LinearLayout mGB = null;
    private EditText mGC = null;
    private TextView lqK = null;
    private RelativeLayout jPs = null;
    private boolean mGO = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mGf = null;
        this.mGM = writeShareActivity;
        this.mGf = writeShareActivity.cVv();
        if (this.mGN == null) {
            this.mGN = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.mGM.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mGM.getPageContext().getString(R.string.share_navigationbar_title));
        this.lqK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mGM.getPageContext().getString(R.string.send_post));
        this.jPs = (RelativeLayout) this.mGM.findViewById(R.id.parent);
        this.mGz = this.mGM.findViewById(R.id.interval_view);
        this.mGA = this.mGM.findViewById(R.id.prefix_interval_view);
        this.mGH = (LinearLayout) this.mGM.findViewById(R.id.post_share_layout);
        this.mGI = (LinearLayout) this.mGM.findViewById(R.id.post_share_content_layout);
        this.mGJ = (ShareSDKImageView) this.mGM.findViewById(R.id.post_share_image);
        this.mGK = (TextView) this.mGM.findViewById(R.id.post_share_title);
        this.mGL = (TextView) this.mGM.findViewById(R.id.post_share_content);
        dDX();
        dDZ();
        this.mGB = (LinearLayout) this.mGM.findViewById(R.id.post_content_container);
        this.mGB.setDrawingCacheEnabled(false);
        this.mGy.setVisibility(0);
        this.mGC.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        dDY();
    }

    public void dDV() {
        this.mGH = (LinearLayout) this.mGM.findViewById(R.id.post_share_layout);
        this.mGJ = (ShareSDKImageView) this.mGM.findViewById(R.id.post_share_image);
        this.mGJ.setIsRound(false);
        this.mGJ.setDrawBorder(false);
        this.mGJ.setAutoChangeStyle(true);
        this.mGJ.setRadius(0);
        this.mGK = (TextView) this.mGM.findViewById(R.id.post_share_title);
        this.mGL = (TextView) this.mGM.findViewById(R.id.post_share_content);
        if (this.mGf != null) {
            if (this.mGf.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.mGJ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.mGJ.getLoadedWidth() != 0 && c.this.mGJ.getLoadedHeight() != 0) {
                                c.this.width = c.this.mGJ.getLoadedWidth();
                                c.this.height = c.this.mGJ.getLoadedHeight();
                                if (c.this.mGM != null) {
                                    c.this.mGM.cVv().setShareSummaryImgWidth(c.this.width);
                                    c.this.mGM.cVv().setShareSummaryImgHeight(c.this.height);
                                    c.this.mGO = true;
                                    c.this.dDY();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.mGO = false;
                        c.this.dDY();
                        if (c.this.mGM != null) {
                            c.this.mGM.IS(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.mGO = false;
                        c.this.dDY();
                        if (c.this.mGM != null) {
                            c.this.mGM.IS(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mGf.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mGf.getShareSummaryImg() != null && this.mGf.getShareSummaryImg().trim().length() > 0) {
                    this.mGJ.startLoad(this.mGf.getShareSummaryImg(), 10, true);
                } else {
                    this.mGO = true;
                    dDY();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mGf.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.mGJ.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mGf.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mGf.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.bg(au.boO().getPostImageSize(), au.boO().getPostImageHeightLimit()));
                    this.mGJ.setTag(imageFileInfo.toCachedKey(true));
                    if (this.mGN.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.mGH.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.mGJ.invalidate();
                    }
                }
                this.mGO = true;
                dDY();
            }
            this.mGf.setShareSummaryImgType(f.getExtension(this.mGf.getShareSummaryImg()));
            this.mGK.setText(this.mGf.getShareSummaryTitle());
            this.mGL.setText(this.mGf.getShareSummaryContent());
        }
    }

    private void dDW() {
        this.mGG = this.mGM.findViewById(R.id.post_prefix_layout);
        this.mGD = (TextView) this.mGM.findViewById(R.id.post_prefix);
        this.mGF = (ImageView) this.mGM.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mGG.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.mGD.setText(prefixs.get(0));
            this.mGM.IT(0);
            this.mGG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mGD.setVisibility(0);
                    c.this.mGG.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.mGE, view, l.dip2px(c.this.mGM.getPageContext().getContext(), 15.0f), l.dip2px(c.this.mGM.getPageContext().getContext(), 1.0f));
                    if (c.this.mGM != null) {
                        c.this.mGM.dDU();
                    }
                }
            });
            this.mGF = (ImageView) this.mGM.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.mGF.setVisibility(0);
                this.mGD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.mGD.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.mGE, view, l.dip2px(c.this.mGM.getPageContext().getContext(), 15.0f), l.dip2px(c.this.mGM.getPageContext().getContext(), 1.0f));
                        if (c.this.mGM != null) {
                            c.this.mGM.dDU();
                        }
                    }
                });
            }
            this.mGE = new i(this.mGM.getPageContext().getContext());
            this.mGE.setMaxHeight(l.dip2px(this.mGM.getPageContext().getContext(), 225.0f));
            this.mGE.setOutsideTouchable(true);
            this.mGE.setFocusable(true);
            this.mGE.setBackgroundDrawable(ap.getDrawable(R.color.cp_bg_line_c));
            this.mGE.a(new i.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.i.a
                public void IU(int i) {
                    c.this.mGM.IT(i);
                    c.this.mGD.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.mGE.setCurrentIndex(i);
                    c.this.dDY();
                    g.dismissPopupWindow(c.this.mGE, c.this.mGM.getPageContext().getPageActivity());
                }
            });
            this.mGE.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.mGG.setSelected(false);
                }
            });
            int color = ap.getColor(R.color.common_color_10097);
            ap.setBackgroundResource(this.mGD, R.drawable.write_prefix_item_selector);
            ap.setImageResource(this.mGF, R.drawable.icon_title_down);
            this.mGD.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.mGM.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.mGM.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ap.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.mGM.getPageContext().getContext(), this.mGM.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.mGM.getPageContext().getContext(), this.mGM.getResources().getDimension(R.dimen.ds22)), 0);
                this.mGE.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.mGM.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.mGM.getPageContext().getContext(), this.mGM.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.mGM.getPageContext().getContext(), this.mGM.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.mGE.setCurrentIndex(0);
            return;
        }
        this.mGG.setVisibility(8);
    }

    protected void dDX() {
        this.mGy = (EditText) this.mGM.findViewById(R.id.post_title);
        if (this.mGf.getType() == 3) {
            if (this.mGf.getTitle() != null && this.mGf.getTitle().trim().length() > 0) {
                this.mGy.setText(this.mGf.getTitle());
                this.mGy.setSelection(this.mGf.getTitle().length());
            } else {
                String str = this.mGM.getPageContext().getString(R.string.share_transfer_thread) + this.mGf.getShareSummaryTitle();
                this.mGy.setText(str);
                if (str.length() < 20) {
                    this.mGy.setSelection(str.length());
                } else {
                    this.mGy.setSelection(20);
                }
            }
        }
        this.mGy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dDY();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void dDY() {
        String str = null;
        if (this.mGf.getType() == 3) {
            String trim = this.mGy.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.mGM.dDS() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.mGf.setIsNoTitle(true);
                    } else {
                        this.mGf.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.mGf.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.mGf.setIsNoTitle(true);
            } else {
                this.mGf.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.mGO) {
            this.lqK.setEnabled(false);
        } else {
            this.lqK.setEnabled(true);
        }
    }

    protected void dDZ() {
        this.mGC = (EditText) this.mGM.findViewById(R.id.post_content);
        this.mGC.setDrawingCacheEnabled(false);
        if (this.mGf.getContent() != null && this.mGf.getContent().length() > 0) {
            SpannableString aw = TbFaceManager.byD().aw(this.mGM.getPageContext().getContext(), this.mGf.getContent());
            this.mGC.setText(aw);
            this.mGC.setSelection(aw.length());
        }
        this.mGC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.mGC.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dDY();
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

    public EditText dEa() {
        return this.mGy;
    }

    public EditText dEb() {
        return this.mGC;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        dDW();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.mGy.setOnFocusChangeListener(onFocusChangeListener);
        this.mGC.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.lqK.setOnFocusChangeListener(onFocusChangeListener);
    }

    public i dEc() {
        return this.mGE;
    }

    public View dEd() {
        return this.mBack;
    }

    public TextView dEe() {
        return this.lqK;
    }

    public TextView dEf() {
        return this.mGD;
    }

    public void ae(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void af(View.OnClickListener onClickListener) {
        this.lqK.setOnClickListener(onClickListener);
    }

    public void ag(View.OnClickListener onClickListener) {
        this.mGB.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.mGM != null) {
            this.mGM.getLayoutMode().setNightMode(i == 1);
            this.mGM.getLayoutMode().onModeChanged(this.jPs);
            this.mNavigationBar.onChangeSkinType(this.mGM.getPageContext(), i);
            ap.setTopBarCommonFinishButton(this.lqK, i);
            ap.setBackgroundColor(this.mGz, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.mGA, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.mGy, R.color.cp_cont_g);
            ap.setBackgroundColor(this.mGI, R.color.cp_bg_line_e);
            int color = ap.getColor(R.color.cp_cont_b);
            int color2 = ap.getColor(R.color.cp_cont_e);
            this.mGy.setTextColor(color);
            this.mGC.setTextColor(color);
            this.mGK.setTextColor(ap.getColor(R.color.cp_cont_b));
            this.mGL.setTextColor(ap.getColor(R.color.cp_cont_d));
            h(this.mGy, color2);
            h(this.mGC, color2);
            dDY();
        }
    }

    public ShareSDKImageView dEg() {
        return this.mGJ;
    }
}
