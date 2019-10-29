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
import com.baidu.adp.lib.g.g;
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
/* loaded from: classes6.dex */
public class c {
    private View iYT;
    private TextView iYX;
    private h iYY;
    private ImageView iYZ;
    private WriteData iYy;
    private View iZa;
    private LinearLayout iZb;
    private LinearLayout iZc;
    private ShareSDKImageView iZd;
    private TextView iZe;
    private TextView iZf;
    private WriteShareActivity iZg;
    private com.baidu.tbadk.img.b iZh;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText iYR = null;
    private View iYS = null;
    private LinearLayout iYU = null;
    private EditText iYV = null;
    private TextView iYW = null;
    private RelativeLayout gze = null;
    private boolean iZi = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.iYy = null;
        this.iZg = writeShareActivity;
        this.iYy = writeShareActivity.clc();
        if (this.iZh == null) {
            this.iZh = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.iZg.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iZg.getPageContext().getString(R.string.share_navigationbar_title));
        this.iYW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iZg.getPageContext().getString(R.string.send_post));
        this.gze = (RelativeLayout) this.iZg.findViewById(R.id.parent);
        this.iYS = this.iZg.findViewById(R.id.interval_view);
        this.iYT = this.iZg.findViewById(R.id.prefix_interval_view);
        this.iZb = (LinearLayout) this.iZg.findViewById(R.id.post_share_layout);
        this.iZc = (LinearLayout) this.iZg.findViewById(R.id.post_share_content_layout);
        this.iZd = (ShareSDKImageView) this.iZg.findViewById(R.id.post_share_image);
        this.iZe = (TextView) this.iZg.findViewById(R.id.post_share_title);
        this.iZf = (TextView) this.iZg.findViewById(R.id.post_share_content);
        cli();
        clk();
        this.iYU = (LinearLayout) this.iZg.findViewById(R.id.post_content_container);
        this.iYU.setDrawingCacheEnabled(false);
        this.iYR.setVisibility(0);
        this.iYV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        clj();
    }

    public void clg() {
        this.iZb = (LinearLayout) this.iZg.findViewById(R.id.post_share_layout);
        this.iZd = (ShareSDKImageView) this.iZg.findViewById(R.id.post_share_image);
        this.iZd.setIsRound(false);
        this.iZd.setDrawBorder(false);
        this.iZd.setAutoChangeStyle(true);
        this.iZd.setRadius(0);
        this.iZe = (TextView) this.iZg.findViewById(R.id.post_share_title);
        this.iZf = (TextView) this.iZg.findViewById(R.id.post_share_content);
        if (this.iYy != null) {
            if (this.iYy.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.iZd.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.iZd.getLoadedWidth() != 0 && c.this.iZd.getLoadedHeight() != 0) {
                                c.this.width = c.this.iZd.getLoadedWidth();
                                c.this.height = c.this.iZd.getLoadedHeight();
                                if (c.this.iZg != null) {
                                    c.this.iZg.clc().setShareSummaryImgWidth(c.this.width);
                                    c.this.iZg.clc().setShareSummaryImgHeight(c.this.height);
                                    c.this.iZi = true;
                                    c.this.clj();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.iZi = false;
                        c.this.clj();
                        if (c.this.iZg != null) {
                            c.this.iZg.zu(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.iZi = false;
                        c.this.clj();
                        if (c.this.iZg != null) {
                            c.this.iZg.zu(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.iYy.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.iYy.getShareSummaryImg() != null && this.iYy.getShareSummaryImg().trim().length() > 0) {
                    this.iZd.startLoad(this.iYy.getShareSummaryImg(), 10, true);
                } else {
                    this.iZi = true;
                    clj();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.iYy.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.iZd.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.iYy.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(m.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.iYy.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.ao(ar.amO().getPostImageSize(), ar.amO().getPostImageHeightLimit()));
                    this.iZd.setTag(imageFileInfo.toCachedKey(true));
                    if (this.iZh.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.iZb.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.iZd.invalidate();
                    }
                }
                this.iZi = true;
                clj();
            }
            this.iYy.setShareSummaryImgType(f.getExtension(this.iYy.getShareSummaryImg()));
            this.iZe.setText(this.iYy.getShareSummaryTitle());
            this.iZf.setText(this.iYy.getShareSummaryContent());
        }
    }

    private void clh() {
        this.iZa = this.iZg.findViewById(R.id.post_prefix_layout);
        this.iYX = (TextView) this.iZg.findViewById(R.id.post_prefix);
        this.iYZ = (ImageView) this.iZg.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.iZa.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iYX.setText(prefixs.get(0));
            this.iZg.zv(0);
            this.iZa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.iYX.setVisibility(0);
                    c.this.iZa.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.iYY, view, l.dip2px(c.this.iZg.getPageContext().getContext(), 15.0f), l.dip2px(c.this.iZg.getPageContext().getContext(), 1.0f));
                    if (c.this.iZg != null) {
                        c.this.iZg.clf();
                    }
                }
            });
            this.iYZ = (ImageView) this.iZg.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.iYZ.setVisibility(0);
                this.iYX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.iYX.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.iYY, view, l.dip2px(c.this.iZg.getPageContext().getContext(), 15.0f), l.dip2px(c.this.iZg.getPageContext().getContext(), 1.0f));
                        if (c.this.iZg != null) {
                            c.this.iZg.clf();
                        }
                    }
                });
            }
            this.iYY = new h(this.iZg.getPageContext().getContext());
            this.iYY.setMaxHeight(l.dip2px(this.iZg.getPageContext().getContext(), 225.0f));
            this.iYY.setOutsideTouchable(true);
            this.iYY.setFocusable(true);
            this.iYY.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_c));
            this.iYY.a(new h.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.h.a
                public void zw(int i) {
                    c.this.iZg.zv(i);
                    c.this.iYX.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.iYY.setCurrentIndex(i);
                    c.this.clj();
                    g.dismissPopupWindow(c.this.iYY, c.this.iZg.getPageContext().getPageActivity());
                }
            });
            this.iYY.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.iZa.setSelected(false);
                }
            });
            int color = am.getColor(R.color.common_color_10097);
            am.setBackgroundResource(this.iYX, R.drawable.write_prefix_item_selector);
            am.setImageResource(this.iYZ, R.drawable.icon_title_down);
            this.iYX.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.iZg.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.iZg.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                am.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.iZg.getPageContext().getContext(), this.iZg.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.iZg.getPageContext().getContext(), this.iZg.getResources().getDimension(R.dimen.ds22)), 0);
                this.iYY.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.iZg.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.iZg.getPageContext().getContext(), this.iZg.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.iZg.getPageContext().getContext(), this.iZg.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.iYY.setCurrentIndex(0);
            return;
        }
        this.iZa.setVisibility(8);
    }

    protected void cli() {
        this.iYR = (EditText) this.iZg.findViewById(R.id.post_title);
        if (this.iYy.getType() == 3) {
            if (this.iYy.getTitle() != null && this.iYy.getTitle().trim().length() > 0) {
                this.iYR.setText(this.iYy.getTitle());
                this.iYR.setSelection(this.iYy.getTitle().length());
            } else {
                String str = this.iZg.getPageContext().getString(R.string.share_transfer_thread) + this.iYy.getShareSummaryTitle();
                this.iYR.setText(str);
                if (str.length() < 20) {
                    this.iYR.setSelection(str.length());
                } else {
                    this.iYR.setSelection(20);
                }
            }
        }
        this.iYR.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.clj();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void clj() {
        String str = null;
        if (this.iYy.getType() == 3) {
            String trim = this.iYR.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.iZg.cld() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.iYy.setIsNoTitle(true);
                    } else {
                        this.iYy.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.iYy.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.iYy.setIsNoTitle(true);
            } else {
                this.iYy.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.iZi) {
            this.iYW.setEnabled(false);
        } else {
            this.iYW.setEnabled(true);
        }
    }

    protected void clk() {
        this.iYV = (EditText) this.iZg.findViewById(R.id.post_content);
        this.iYV.setDrawingCacheEnabled(false);
        if (this.iYy.getContent() != null && this.iYy.getContent().length() > 0) {
            SpannableString ah = TbFaceManager.avt().ah(this.iZg.getPageContext().getContext(), this.iYy.getContent());
            this.iYV.setText(ah);
            this.iYV.setSelection(ah.length());
        }
        this.iYV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iYV.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.clj();
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

    public EditText cll() {
        return this.iYR;
    }

    public EditText clm() {
        return this.iYV;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        clh();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.iYR.setOnFocusChangeListener(onFocusChangeListener);
        this.iYV.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.iYW.setOnFocusChangeListener(onFocusChangeListener);
    }

    public h cln() {
        return this.iYY;
    }

    public View clo() {
        return this.mBack;
    }

    public TextView clp() {
        return this.iYW;
    }

    public TextView clq() {
        return this.iYX;
    }

    public void ab(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ac(View.OnClickListener onClickListener) {
        this.iYW.setOnClickListener(onClickListener);
    }

    public void ad(View.OnClickListener onClickListener) {
        this.iYU.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.iZg != null) {
            this.iZg.getLayoutMode().setNightMode(i == 1);
            this.iZg.getLayoutMode().onModeChanged(this.gze);
            this.mNavigationBar.onChangeSkinType(this.iZg.getPageContext(), i);
            am.setTopBarCommonFinishButton(this.iYW, i);
            am.setBackgroundColor(this.iYS, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.iYT, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.iYR, R.color.cp_cont_g);
            am.setBackgroundColor(this.iZc, R.color.cp_bg_line_e);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_e);
            this.iYR.setTextColor(color);
            this.iYV.setTextColor(color);
            this.iZe.setTextColor(am.getColor(R.color.cp_cont_b));
            this.iZf.setTextColor(am.getColor(R.color.cp_cont_d));
            f(this.iYR, color2);
            f(this.iYV, color2);
            clj();
        }
    }

    public ShareSDKImageView clr() {
        return this.iZd;
    }
}
