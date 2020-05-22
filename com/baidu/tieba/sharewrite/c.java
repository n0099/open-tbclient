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
import com.baidu.tieba.write.i;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes11.dex */
public class c {
    private TextView laA;
    private i laB;
    private ImageView laC;
    private View laD;
    private LinearLayout laE;
    private LinearLayout laF;
    private ShareSDKImageView laG;
    private TextView laH;
    private TextView laI;
    private WriteShareActivity laJ;
    private com.baidu.tbadk.img.b laK;
    private WriteData lab;
    private View law;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText lau = null;
    private View lav = null;
    private LinearLayout lax = null;
    private EditText lay = null;
    private TextView laz = null;
    private RelativeLayout isn = null;
    private boolean laL = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.lab = null;
        this.laJ = writeShareActivity;
        this.lab = writeShareActivity.cZP();
        if (this.laK == null) {
            this.laK = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.laJ.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.laJ.getPageContext().getString(R.string.share_navigationbar_title));
        this.laz = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.laJ.getPageContext().getString(R.string.send_post));
        this.isn = (RelativeLayout) this.laJ.findViewById(R.id.parent);
        this.lav = this.laJ.findViewById(R.id.interval_view);
        this.law = this.laJ.findViewById(R.id.prefix_interval_view);
        this.laE = (LinearLayout) this.laJ.findViewById(R.id.post_share_layout);
        this.laF = (LinearLayout) this.laJ.findViewById(R.id.post_share_content_layout);
        this.laG = (ShareSDKImageView) this.laJ.findViewById(R.id.post_share_image);
        this.laH = (TextView) this.laJ.findViewById(R.id.post_share_title);
        this.laI = (TextView) this.laJ.findViewById(R.id.post_share_content);
        cZV();
        cZX();
        this.lax = (LinearLayout) this.laJ.findViewById(R.id.post_content_container);
        this.lax.setDrawingCacheEnabled(false);
        this.lau.setVisibility(0);
        this.lay.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        cZW();
    }

    public void cZT() {
        this.laE = (LinearLayout) this.laJ.findViewById(R.id.post_share_layout);
        this.laG = (ShareSDKImageView) this.laJ.findViewById(R.id.post_share_image);
        this.laG.setIsRound(false);
        this.laG.setDrawBorder(false);
        this.laG.setAutoChangeStyle(true);
        this.laG.setRadius(0);
        this.laH = (TextView) this.laJ.findViewById(R.id.post_share_title);
        this.laI = (TextView) this.laJ.findViewById(R.id.post_share_content);
        if (this.lab != null) {
            if (this.lab.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.laG.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.laG.getLoadedWidth() != 0 && c.this.laG.getLoadedHeight() != 0) {
                                c.this.width = c.this.laG.getLoadedWidth();
                                c.this.height = c.this.laG.getLoadedHeight();
                                if (c.this.laJ != null) {
                                    c.this.laJ.cZP().setShareSummaryImgWidth(c.this.width);
                                    c.this.laJ.cZP().setShareSummaryImgHeight(c.this.height);
                                    c.this.laL = true;
                                    c.this.cZW();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.laL = false;
                        c.this.cZW();
                        if (c.this.laJ != null) {
                            c.this.laJ.Dt(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.laL = false;
                        c.this.cZW();
                        if (c.this.laJ != null) {
                            c.this.laJ.Dt(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.lab.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.lab.getShareSummaryImg() != null && this.lab.getShareSummaryImg().trim().length() > 0) {
                    this.laG.startLoad(this.lab.getShareSummaryImg(), 10, true);
                } else {
                    this.laL = true;
                    cZW();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.lab.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.laG.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.lab.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(m.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.lab.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.aS(ar.aUW().getPostImageSize(), ar.aUW().getPostImageHeightLimit()));
                    this.laG.setTag(imageFileInfo.toCachedKey(true));
                    if (this.laK.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.laE.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.laG.invalidate();
                    }
                }
                this.laL = true;
                cZW();
            }
            this.lab.setShareSummaryImgType(f.getExtension(this.lab.getShareSummaryImg()));
            this.laH.setText(this.lab.getShareSummaryTitle());
            this.laI.setText(this.lab.getShareSummaryContent());
        }
    }

    private void cZU() {
        this.laD = this.laJ.findViewById(R.id.post_prefix_layout);
        this.laA = (TextView) this.laJ.findViewById(R.id.post_prefix);
        this.laC = (ImageView) this.laJ.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.laD.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.laA.setText(prefixs.get(0));
            this.laJ.Du(0);
            this.laD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.laA.setVisibility(0);
                    c.this.laD.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.laB, view, l.dip2px(c.this.laJ.getPageContext().getContext(), 15.0f), l.dip2px(c.this.laJ.getPageContext().getContext(), 1.0f));
                    if (c.this.laJ != null) {
                        c.this.laJ.cZS();
                    }
                }
            });
            this.laC = (ImageView) this.laJ.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.laC.setVisibility(0);
                this.laA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.laA.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.laB, view, l.dip2px(c.this.laJ.getPageContext().getContext(), 15.0f), l.dip2px(c.this.laJ.getPageContext().getContext(), 1.0f));
                        if (c.this.laJ != null) {
                            c.this.laJ.cZS();
                        }
                    }
                });
            }
            this.laB = new i(this.laJ.getPageContext().getContext());
            this.laB.setMaxHeight(l.dip2px(this.laJ.getPageContext().getContext(), 225.0f));
            this.laB.setOutsideTouchable(true);
            this.laB.setFocusable(true);
            this.laB.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_c));
            this.laB.a(new i.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.i.a
                public void Dv(int i) {
                    c.this.laJ.Du(i);
                    c.this.laA.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.laB.setCurrentIndex(i);
                    c.this.cZW();
                    g.dismissPopupWindow(c.this.laB, c.this.laJ.getPageContext().getPageActivity());
                }
            });
            this.laB.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.laD.setSelected(false);
                }
            });
            int color = am.getColor(R.color.common_color_10097);
            am.setBackgroundResource(this.laA, R.drawable.write_prefix_item_selector);
            am.setImageResource(this.laC, R.drawable.icon_title_down);
            this.laA.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.laJ.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.laJ.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                am.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.laJ.getPageContext().getContext(), this.laJ.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.laJ.getPageContext().getContext(), this.laJ.getResources().getDimension(R.dimen.ds22)), 0);
                this.laB.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.laJ.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.laJ.getPageContext().getContext(), this.laJ.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.laJ.getPageContext().getContext(), this.laJ.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.laB.setCurrentIndex(0);
            return;
        }
        this.laD.setVisibility(8);
    }

    protected void cZV() {
        this.lau = (EditText) this.laJ.findViewById(R.id.post_title);
        if (this.lab.getType() == 3) {
            if (this.lab.getTitle() != null && this.lab.getTitle().trim().length() > 0) {
                this.lau.setText(this.lab.getTitle());
                this.lau.setSelection(this.lab.getTitle().length());
            } else {
                String str = this.laJ.getPageContext().getString(R.string.share_transfer_thread) + this.lab.getShareSummaryTitle();
                this.lau.setText(str);
                if (str.length() < 20) {
                    this.lau.setSelection(str.length());
                } else {
                    this.lau.setSelection(20);
                }
            }
        }
        this.lau.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cZW();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void cZW() {
        String str = null;
        if (this.lab.getType() == 3) {
            String trim = this.lau.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.laJ.cZQ() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.lab.setIsNoTitle(true);
                    } else {
                        this.lab.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.lab.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.lab.setIsNoTitle(true);
            } else {
                this.lab.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.laL) {
            this.laz.setEnabled(false);
        } else {
            this.laz.setEnabled(true);
        }
    }

    protected void cZX() {
        this.lay = (EditText) this.laJ.findViewById(R.id.post_content);
        this.lay.setDrawingCacheEnabled(false);
        if (this.lab.getContent() != null && this.lab.getContent().length() > 0) {
            SpannableString ak = TbFaceManager.bes().ak(this.laJ.getPageContext().getContext(), this.lab.getContent());
            this.lay.setText(ak);
            this.lay.setSelection(ak.length());
        }
        this.lay.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.lay.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cZW();
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

    public EditText cZY() {
        return this.lau;
    }

    public EditText cZZ() {
        return this.lay;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        cZU();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.lau.setOnFocusChangeListener(onFocusChangeListener);
        this.lay.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.laz.setOnFocusChangeListener(onFocusChangeListener);
    }

    public i daa() {
        return this.laB;
    }

    public View dab() {
        return this.mBack;
    }

    public TextView dac() {
        return this.laz;
    }

    public TextView dad() {
        return this.laA;
    }

    public void ac(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ad(View.OnClickListener onClickListener) {
        this.laz.setOnClickListener(onClickListener);
    }

    public void ae(View.OnClickListener onClickListener) {
        this.lax.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.laJ != null) {
            this.laJ.getLayoutMode().setNightMode(i == 1);
            this.laJ.getLayoutMode().onModeChanged(this.isn);
            this.mNavigationBar.onChangeSkinType(this.laJ.getPageContext(), i);
            am.setTopBarCommonFinishButton(this.laz, i);
            am.setBackgroundColor(this.lav, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.law, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.lau, R.color.cp_cont_g);
            am.setBackgroundColor(this.laF, R.color.cp_bg_line_e);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_e);
            this.lau.setTextColor(color);
            this.lay.setTextColor(color);
            this.laH.setTextColor(am.getColor(R.color.cp_cont_b));
            this.laI.setTextColor(am.getColor(R.color.cp_cont_d));
            f(this.lau, color2);
            f(this.lay, color2);
            cZW();
        }
    }

    public ShareSDKImageView dae() {
        return this.laG;
    }
}
