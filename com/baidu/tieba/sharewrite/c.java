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
    private WriteData iXH;
    private View iYc;
    private TextView iYg;
    private h iYh;
    private ImageView iYi;
    private View iYj;
    private LinearLayout iYk;
    private LinearLayout iYl;
    private ShareSDKImageView iYm;
    private TextView iYn;
    private TextView iYo;
    private WriteShareActivity iYp;
    private com.baidu.tbadk.img.b iYq;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText iYa = null;
    private View iYb = null;
    private LinearLayout iYd = null;
    private EditText iYe = null;
    private TextView iYf = null;
    private RelativeLayout gyn = null;
    private boolean iYr = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.iXH = null;
        this.iYp = writeShareActivity;
        this.iXH = writeShareActivity.cla();
        if (this.iYq == null) {
            this.iYq = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.iYp.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iYp.getPageContext().getString(R.string.share_navigationbar_title));
        this.iYf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iYp.getPageContext().getString(R.string.send_post));
        this.gyn = (RelativeLayout) this.iYp.findViewById(R.id.parent);
        this.iYb = this.iYp.findViewById(R.id.interval_view);
        this.iYc = this.iYp.findViewById(R.id.prefix_interval_view);
        this.iYk = (LinearLayout) this.iYp.findViewById(R.id.post_share_layout);
        this.iYl = (LinearLayout) this.iYp.findViewById(R.id.post_share_content_layout);
        this.iYm = (ShareSDKImageView) this.iYp.findViewById(R.id.post_share_image);
        this.iYn = (TextView) this.iYp.findViewById(R.id.post_share_title);
        this.iYo = (TextView) this.iYp.findViewById(R.id.post_share_content);
        clg();
        cli();
        this.iYd = (LinearLayout) this.iYp.findViewById(R.id.post_content_container);
        this.iYd.setDrawingCacheEnabled(false);
        this.iYa.setVisibility(0);
        this.iYe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        clh();
    }

    public void cle() {
        this.iYk = (LinearLayout) this.iYp.findViewById(R.id.post_share_layout);
        this.iYm = (ShareSDKImageView) this.iYp.findViewById(R.id.post_share_image);
        this.iYm.setIsRound(false);
        this.iYm.setDrawBorder(false);
        this.iYm.setAutoChangeStyle(true);
        this.iYm.setRadius(0);
        this.iYn = (TextView) this.iYp.findViewById(R.id.post_share_title);
        this.iYo = (TextView) this.iYp.findViewById(R.id.post_share_content);
        if (this.iXH != null) {
            if (this.iXH.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.iYm.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.iYm.getLoadedWidth() != 0 && c.this.iYm.getLoadedHeight() != 0) {
                                c.this.width = c.this.iYm.getLoadedWidth();
                                c.this.height = c.this.iYm.getLoadedHeight();
                                if (c.this.iYp != null) {
                                    c.this.iYp.cla().setShareSummaryImgWidth(c.this.width);
                                    c.this.iYp.cla().setShareSummaryImgHeight(c.this.height);
                                    c.this.iYr = true;
                                    c.this.clh();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.iYr = false;
                        c.this.clh();
                        if (c.this.iYp != null) {
                            c.this.iYp.zt(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.iYr = false;
                        c.this.clh();
                        if (c.this.iYp != null) {
                            c.this.iYp.zt(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.iXH.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.iXH.getShareSummaryImg() != null && this.iXH.getShareSummaryImg().trim().length() > 0) {
                    this.iYm.startLoad(this.iXH.getShareSummaryImg(), 10, true);
                } else {
                    this.iYr = true;
                    clh();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.iXH.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.iYm.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.iXH.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(m.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.iXH.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.am(ar.amM().getPostImageSize(), ar.amM().getPostImageHeightLimit()));
                    this.iYm.setTag(imageFileInfo.toCachedKey(true));
                    if (this.iYq.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.iYk.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.iYm.invalidate();
                    }
                }
                this.iYr = true;
                clh();
            }
            this.iXH.setShareSummaryImgType(f.getExtension(this.iXH.getShareSummaryImg()));
            this.iYn.setText(this.iXH.getShareSummaryTitle());
            this.iYo.setText(this.iXH.getShareSummaryContent());
        }
    }

    private void clf() {
        this.iYj = this.iYp.findViewById(R.id.post_prefix_layout);
        this.iYg = (TextView) this.iYp.findViewById(R.id.post_prefix);
        this.iYi = (ImageView) this.iYp.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.iYj.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iYg.setText(prefixs.get(0));
            this.iYp.zu(0);
            this.iYj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.iYg.setVisibility(0);
                    c.this.iYj.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.iYh, view, l.dip2px(c.this.iYp.getPageContext().getContext(), 15.0f), l.dip2px(c.this.iYp.getPageContext().getContext(), 1.0f));
                    if (c.this.iYp != null) {
                        c.this.iYp.cld();
                    }
                }
            });
            this.iYi = (ImageView) this.iYp.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.iYi.setVisibility(0);
                this.iYg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.iYg.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.iYh, view, l.dip2px(c.this.iYp.getPageContext().getContext(), 15.0f), l.dip2px(c.this.iYp.getPageContext().getContext(), 1.0f));
                        if (c.this.iYp != null) {
                            c.this.iYp.cld();
                        }
                    }
                });
            }
            this.iYh = new h(this.iYp.getPageContext().getContext());
            this.iYh.setMaxHeight(l.dip2px(this.iYp.getPageContext().getContext(), 225.0f));
            this.iYh.setOutsideTouchable(true);
            this.iYh.setFocusable(true);
            this.iYh.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_c));
            this.iYh.a(new h.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.h.a
                public void zv(int i) {
                    c.this.iYp.zu(i);
                    c.this.iYg.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.iYh.setCurrentIndex(i);
                    c.this.clh();
                    g.dismissPopupWindow(c.this.iYh, c.this.iYp.getPageContext().getPageActivity());
                }
            });
            this.iYh.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.iYj.setSelected(false);
                }
            });
            int color = am.getColor(R.color.common_color_10097);
            am.setBackgroundResource(this.iYg, R.drawable.write_prefix_item_selector);
            am.setImageResource(this.iYi, R.drawable.icon_title_down);
            this.iYg.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.iYp.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.iYp.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                am.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.iYp.getPageContext().getContext(), this.iYp.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.iYp.getPageContext().getContext(), this.iYp.getResources().getDimension(R.dimen.ds22)), 0);
                this.iYh.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.iYp.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.iYp.getPageContext().getContext(), this.iYp.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.iYp.getPageContext().getContext(), this.iYp.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.iYh.setCurrentIndex(0);
            return;
        }
        this.iYj.setVisibility(8);
    }

    protected void clg() {
        this.iYa = (EditText) this.iYp.findViewById(R.id.post_title);
        if (this.iXH.getType() == 3) {
            if (this.iXH.getTitle() != null && this.iXH.getTitle().trim().length() > 0) {
                this.iYa.setText(this.iXH.getTitle());
                this.iYa.setSelection(this.iXH.getTitle().length());
            } else {
                String str = this.iYp.getPageContext().getString(R.string.share_transfer_thread) + this.iXH.getShareSummaryTitle();
                this.iYa.setText(str);
                if (str.length() < 20) {
                    this.iYa.setSelection(str.length());
                } else {
                    this.iYa.setSelection(20);
                }
            }
        }
        this.iYa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.clh();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void clh() {
        String str = null;
        if (this.iXH.getType() == 3) {
            String trim = this.iYa.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.iYp.clb() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.iXH.setIsNoTitle(true);
                    } else {
                        this.iXH.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.iXH.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.iXH.setIsNoTitle(true);
            } else {
                this.iXH.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.iYr) {
            this.iYf.setEnabled(false);
        } else {
            this.iYf.setEnabled(true);
        }
    }

    protected void cli() {
        this.iYe = (EditText) this.iYp.findViewById(R.id.post_content);
        this.iYe.setDrawingCacheEnabled(false);
        if (this.iXH.getContent() != null && this.iXH.getContent().length() > 0) {
            SpannableString ah = TbFaceManager.avr().ah(this.iYp.getPageContext().getContext(), this.iXH.getContent());
            this.iYe.setText(ah);
            this.iYe.setSelection(ah.length());
        }
        this.iYe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iYe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.clh();
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

    public EditText clj() {
        return this.iYa;
    }

    public EditText clk() {
        return this.iYe;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        clf();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.iYa.setOnFocusChangeListener(onFocusChangeListener);
        this.iYe.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.iYf.setOnFocusChangeListener(onFocusChangeListener);
    }

    public h cll() {
        return this.iYh;
    }

    public View clm() {
        return this.mBack;
    }

    public TextView cln() {
        return this.iYf;
    }

    public TextView clo() {
        return this.iYg;
    }

    public void ab(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ac(View.OnClickListener onClickListener) {
        this.iYf.setOnClickListener(onClickListener);
    }

    public void ad(View.OnClickListener onClickListener) {
        this.iYd.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.iYp != null) {
            this.iYp.getLayoutMode().setNightMode(i == 1);
            this.iYp.getLayoutMode().onModeChanged(this.gyn);
            this.mNavigationBar.onChangeSkinType(this.iYp.getPageContext(), i);
            am.setTopBarCommonFinishButton(this.iYf, i);
            am.setBackgroundColor(this.iYb, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.iYc, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.iYa, R.color.cp_cont_g);
            am.setBackgroundColor(this.iYl, R.color.cp_bg_line_e);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_e);
            this.iYa.setTextColor(color);
            this.iYe.setTextColor(color);
            this.iYn.setTextColor(am.getColor(R.color.cp_cont_b));
            this.iYo.setTextColor(am.getColor(R.color.cp_cont_d));
            f(this.iYa, color2);
            f(this.iYe, color2);
            clh();
        }
    }

    public ShareSDKImageView clp() {
        return this.iYm;
    }
}
