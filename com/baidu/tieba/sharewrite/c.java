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
    private WriteData kHM;
    private View kIg;
    private TextView kIk;
    private h kIl;
    private ImageView kIm;
    private View kIn;
    private LinearLayout kIo;
    private LinearLayout kIp;
    private ShareSDKImageView kIq;
    private TextView kIr;
    private TextView kIs;
    private WriteShareActivity kIt;
    private com.baidu.tbadk.img.b kIu;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText kIe = null;
    private View kIf = null;
    private LinearLayout kIh = null;
    private EditText kIi = null;
    private TextView kIj = null;
    private RelativeLayout idE = null;
    private boolean kIv = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.kHM = null;
        this.kIt = writeShareActivity;
        this.kHM = writeShareActivity.cSK();
        if (this.kIu == null) {
            this.kIu = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.kIt.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.kIt.getPageContext().getString(R.string.share_navigationbar_title));
        this.kIj = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kIt.getPageContext().getString(R.string.send_post));
        this.idE = (RelativeLayout) this.kIt.findViewById(R.id.parent);
        this.kIf = this.kIt.findViewById(R.id.interval_view);
        this.kIg = this.kIt.findViewById(R.id.prefix_interval_view);
        this.kIo = (LinearLayout) this.kIt.findViewById(R.id.post_share_layout);
        this.kIp = (LinearLayout) this.kIt.findViewById(R.id.post_share_content_layout);
        this.kIq = (ShareSDKImageView) this.kIt.findViewById(R.id.post_share_image);
        this.kIr = (TextView) this.kIt.findViewById(R.id.post_share_title);
        this.kIs = (TextView) this.kIt.findViewById(R.id.post_share_content);
        cSQ();
        cSS();
        this.kIh = (LinearLayout) this.kIt.findViewById(R.id.post_content_container);
        this.kIh.setDrawingCacheEnabled(false);
        this.kIe.setVisibility(0);
        this.kIi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        cSR();
    }

    public void cSO() {
        this.kIo = (LinearLayout) this.kIt.findViewById(R.id.post_share_layout);
        this.kIq = (ShareSDKImageView) this.kIt.findViewById(R.id.post_share_image);
        this.kIq.setIsRound(false);
        this.kIq.setDrawBorder(false);
        this.kIq.setAutoChangeStyle(true);
        this.kIq.setRadius(0);
        this.kIr = (TextView) this.kIt.findViewById(R.id.post_share_title);
        this.kIs = (TextView) this.kIt.findViewById(R.id.post_share_content);
        if (this.kHM != null) {
            if (this.kHM.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.kIq.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.kIq.getLoadedWidth() != 0 && c.this.kIq.getLoadedHeight() != 0) {
                                c.this.width = c.this.kIq.getLoadedWidth();
                                c.this.height = c.this.kIq.getLoadedHeight();
                                if (c.this.kIt != null) {
                                    c.this.kIt.cSK().setShareSummaryImgWidth(c.this.width);
                                    c.this.kIt.cSK().setShareSummaryImgHeight(c.this.height);
                                    c.this.kIv = true;
                                    c.this.cSR();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.kIv = false;
                        c.this.cSR();
                        if (c.this.kIt != null) {
                            c.this.kIt.CJ(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.kIv = false;
                        c.this.cSR();
                        if (c.this.kIt != null) {
                            c.this.kIt.CJ(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.kHM.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.kHM.getShareSummaryImg() != null && this.kHM.getShareSummaryImg().trim().length() > 0) {
                    this.kIq.startLoad(this.kHM.getShareSummaryImg(), 10, true);
                } else {
                    this.kIv = true;
                    cSR();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.kHM.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.kIq.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.kHM.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(m.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.kHM.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.aO(ar.aOS().getPostImageSize(), ar.aOS().getPostImageHeightLimit()));
                    this.kIq.setTag(imageFileInfo.toCachedKey(true));
                    if (this.kIu.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.kIo.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.kIq.invalidate();
                    }
                }
                this.kIv = true;
                cSR();
            }
            this.kHM.setShareSummaryImgType(f.getExtension(this.kHM.getShareSummaryImg()));
            this.kIr.setText(this.kHM.getShareSummaryTitle());
            this.kIs.setText(this.kHM.getShareSummaryContent());
        }
    }

    private void cSP() {
        this.kIn = this.kIt.findViewById(R.id.post_prefix_layout);
        this.kIk = (TextView) this.kIt.findViewById(R.id.post_prefix);
        this.kIm = (ImageView) this.kIt.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.kIn.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.kIk.setText(prefixs.get(0));
            this.kIt.CK(0);
            this.kIn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.kIk.setVisibility(0);
                    c.this.kIn.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.kIl, view, l.dip2px(c.this.kIt.getPageContext().getContext(), 15.0f), l.dip2px(c.this.kIt.getPageContext().getContext(), 1.0f));
                    if (c.this.kIt != null) {
                        c.this.kIt.cSN();
                    }
                }
            });
            this.kIm = (ImageView) this.kIt.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.kIm.setVisibility(0);
                this.kIk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.kIk.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.kIl, view, l.dip2px(c.this.kIt.getPageContext().getContext(), 15.0f), l.dip2px(c.this.kIt.getPageContext().getContext(), 1.0f));
                        if (c.this.kIt != null) {
                            c.this.kIt.cSN();
                        }
                    }
                });
            }
            this.kIl = new h(this.kIt.getPageContext().getContext());
            this.kIl.setMaxHeight(l.dip2px(this.kIt.getPageContext().getContext(), 225.0f));
            this.kIl.setOutsideTouchable(true);
            this.kIl.setFocusable(true);
            this.kIl.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_c));
            this.kIl.a(new h.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.h.a
                public void CL(int i) {
                    c.this.kIt.CK(i);
                    c.this.kIk.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.kIl.setCurrentIndex(i);
                    c.this.cSR();
                    g.dismissPopupWindow(c.this.kIl, c.this.kIt.getPageContext().getPageActivity());
                }
            });
            this.kIl.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.kIn.setSelected(false);
                }
            });
            int color = am.getColor(R.color.common_color_10097);
            am.setBackgroundResource(this.kIk, R.drawable.write_prefix_item_selector);
            am.setImageResource(this.kIm, R.drawable.icon_title_down);
            this.kIk.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.kIt.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.kIt.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                am.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.kIt.getPageContext().getContext(), this.kIt.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.kIt.getPageContext().getContext(), this.kIt.getResources().getDimension(R.dimen.ds22)), 0);
                this.kIl.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.kIt.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.kIt.getPageContext().getContext(), this.kIt.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.kIt.getPageContext().getContext(), this.kIt.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.kIl.setCurrentIndex(0);
            return;
        }
        this.kIn.setVisibility(8);
    }

    protected void cSQ() {
        this.kIe = (EditText) this.kIt.findViewById(R.id.post_title);
        if (this.kHM.getType() == 3) {
            if (this.kHM.getTitle() != null && this.kHM.getTitle().trim().length() > 0) {
                this.kIe.setText(this.kHM.getTitle());
                this.kIe.setSelection(this.kHM.getTitle().length());
            } else {
                String str = this.kIt.getPageContext().getString(R.string.share_transfer_thread) + this.kHM.getShareSummaryTitle();
                this.kIe.setText(str);
                if (str.length() < 20) {
                    this.kIe.setSelection(str.length());
                } else {
                    this.kIe.setSelection(20);
                }
            }
        }
        this.kIe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cSR();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void cSR() {
        String str = null;
        if (this.kHM.getType() == 3) {
            String trim = this.kIe.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.kIt.cSL() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.kHM.setIsNoTitle(true);
                    } else {
                        this.kHM.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.kHM.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.kHM.setIsNoTitle(true);
            } else {
                this.kHM.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.kIv) {
            this.kIj.setEnabled(false);
        } else {
            this.kIj.setEnabled(true);
        }
    }

    protected void cSS() {
        this.kIi = (EditText) this.kIt.findViewById(R.id.post_content);
        this.kIi.setDrawingCacheEnabled(false);
        if (this.kHM.getContent() != null && this.kHM.getContent().length() > 0) {
            SpannableString aj = TbFaceManager.aYj().aj(this.kIt.getPageContext().getContext(), this.kHM.getContent());
            this.kIi.setText(aj);
            this.kIi.setSelection(aj.length());
        }
        this.kIi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.kIi.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cSR();
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

    public EditText cST() {
        return this.kIe;
    }

    public EditText cSU() {
        return this.kIi;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        cSP();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.kIe.setOnFocusChangeListener(onFocusChangeListener);
        this.kIi.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.kIj.setOnFocusChangeListener(onFocusChangeListener);
    }

    public h cSV() {
        return this.kIl;
    }

    public View cSW() {
        return this.mBack;
    }

    public TextView cSX() {
        return this.kIj;
    }

    public TextView cSY() {
        return this.kIk;
    }

    public void ac(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ad(View.OnClickListener onClickListener) {
        this.kIj.setOnClickListener(onClickListener);
    }

    public void ae(View.OnClickListener onClickListener) {
        this.kIh.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.kIt != null) {
            this.kIt.getLayoutMode().setNightMode(i == 1);
            this.kIt.getLayoutMode().onModeChanged(this.idE);
            this.mNavigationBar.onChangeSkinType(this.kIt.getPageContext(), i);
            am.setTopBarCommonFinishButton(this.kIj, i);
            am.setBackgroundColor(this.kIf, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.kIg, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.kIe, R.color.cp_cont_g);
            am.setBackgroundColor(this.kIp, R.color.cp_bg_line_e);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_e);
            this.kIe.setTextColor(color);
            this.kIi.setTextColor(color);
            this.kIr.setTextColor(am.getColor(R.color.cp_cont_b));
            this.kIs.setTextColor(am.getColor(R.color.cp_cont_d));
            f(this.kIe, color2);
            f(this.kIi, color2);
            cSR();
        }
    }

    public ShareSDKImageView cSZ() {
        return this.kIq;
    }
}
