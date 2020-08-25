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
/* loaded from: classes18.dex */
public class c {
    private View lUA;
    private TextView lUD;
    private i lUE;
    private ImageView lUF;
    private View lUG;
    private LinearLayout lUH;
    private LinearLayout lUI;
    private ShareSDKImageView lUJ;
    private TextView lUK;
    private TextView lUL;
    private WriteShareActivity lUM;
    private com.baidu.tbadk.img.b lUN;
    private WriteData lUg;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText lUy = null;
    private View lUz = null;
    private LinearLayout lUB = null;
    private EditText lUC = null;
    private TextView kGp = null;
    private RelativeLayout jfk = null;
    private boolean lUO = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.lUg = null;
        this.lUM = writeShareActivity;
        this.lUg = writeShareActivity.cKZ();
        if (this.lUN == null) {
            this.lUN = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.lUM.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.lUM.getPageContext().getString(R.string.share_navigationbar_title));
        this.kGp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.lUM.getPageContext().getString(R.string.send_post));
        this.jfk = (RelativeLayout) this.lUM.findViewById(R.id.parent);
        this.lUz = this.lUM.findViewById(R.id.interval_view);
        this.lUA = this.lUM.findViewById(R.id.prefix_interval_view);
        this.lUH = (LinearLayout) this.lUM.findViewById(R.id.post_share_layout);
        this.lUI = (LinearLayout) this.lUM.findViewById(R.id.post_share_content_layout);
        this.lUJ = (ShareSDKImageView) this.lUM.findViewById(R.id.post_share_image);
        this.lUK = (TextView) this.lUM.findViewById(R.id.post_share_title);
        this.lUL = (TextView) this.lUM.findViewById(R.id.post_share_content);
        dtg();
        dti();
        this.lUB = (LinearLayout) this.lUM.findViewById(R.id.post_content_container);
        this.lUB.setDrawingCacheEnabled(false);
        this.lUy.setVisibility(0);
        this.lUC.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        dth();
    }

    public void dte() {
        this.lUH = (LinearLayout) this.lUM.findViewById(R.id.post_share_layout);
        this.lUJ = (ShareSDKImageView) this.lUM.findViewById(R.id.post_share_image);
        this.lUJ.setIsRound(false);
        this.lUJ.setDrawBorder(false);
        this.lUJ.setAutoChangeStyle(true);
        this.lUJ.setRadius(0);
        this.lUK = (TextView) this.lUM.findViewById(R.id.post_share_title);
        this.lUL = (TextView) this.lUM.findViewById(R.id.post_share_content);
        if (this.lUg != null) {
            if (this.lUg.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.lUJ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.lUJ.getLoadedWidth() != 0 && c.this.lUJ.getLoadedHeight() != 0) {
                                c.this.width = c.this.lUJ.getLoadedWidth();
                                c.this.height = c.this.lUJ.getLoadedHeight();
                                if (c.this.lUM != null) {
                                    c.this.lUM.cKZ().setShareSummaryImgWidth(c.this.width);
                                    c.this.lUM.cKZ().setShareSummaryImgHeight(c.this.height);
                                    c.this.lUO = true;
                                    c.this.dth();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.lUO = false;
                        c.this.dth();
                        if (c.this.lUM != null) {
                            c.this.lUM.Hq(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.lUO = false;
                        c.this.dth();
                        if (c.this.lUM != null) {
                            c.this.lUM.Hq(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.lUg.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.lUg.getShareSummaryImg() != null && this.lUg.getShareSummaryImg().trim().length() > 0) {
                    this.lUJ.startLoad(this.lUg.getShareSummaryImg(), 10, true);
                } else {
                    this.lUO = true;
                    dth();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.lUg.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.lUJ.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.lUg.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.lUg.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.bg(au.bjr().getPostImageSize(), au.bjr().getPostImageHeightLimit()));
                    this.lUJ.setTag(imageFileInfo.toCachedKey(true));
                    if (this.lUN.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.lUH.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.lUJ.invalidate();
                    }
                }
                this.lUO = true;
                dth();
            }
            this.lUg.setShareSummaryImgType(f.getExtension(this.lUg.getShareSummaryImg()));
            this.lUK.setText(this.lUg.getShareSummaryTitle());
            this.lUL.setText(this.lUg.getShareSummaryContent());
        }
    }

    private void dtf() {
        this.lUG = this.lUM.findViewById(R.id.post_prefix_layout);
        this.lUD = (TextView) this.lUM.findViewById(R.id.post_prefix);
        this.lUF = (ImageView) this.lUM.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.lUG.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.lUD.setText(prefixs.get(0));
            this.lUM.Hr(0);
            this.lUG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.lUD.setVisibility(0);
                    c.this.lUG.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.lUE, view, l.dip2px(c.this.lUM.getPageContext().getContext(), 15.0f), l.dip2px(c.this.lUM.getPageContext().getContext(), 1.0f));
                    if (c.this.lUM != null) {
                        c.this.lUM.dtd();
                    }
                }
            });
            this.lUF = (ImageView) this.lUM.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.lUF.setVisibility(0);
                this.lUD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.lUD.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.lUE, view, l.dip2px(c.this.lUM.getPageContext().getContext(), 15.0f), l.dip2px(c.this.lUM.getPageContext().getContext(), 1.0f));
                        if (c.this.lUM != null) {
                            c.this.lUM.dtd();
                        }
                    }
                });
            }
            this.lUE = new i(this.lUM.getPageContext().getContext());
            this.lUE.setMaxHeight(l.dip2px(this.lUM.getPageContext().getContext(), 225.0f));
            this.lUE.setOutsideTouchable(true);
            this.lUE.setFocusable(true);
            this.lUE.setBackgroundDrawable(ap.getDrawable(R.color.cp_bg_line_c));
            this.lUE.a(new i.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.i.a
                public void Hs(int i) {
                    c.this.lUM.Hr(i);
                    c.this.lUD.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.lUE.setCurrentIndex(i);
                    c.this.dth();
                    g.dismissPopupWindow(c.this.lUE, c.this.lUM.getPageContext().getPageActivity());
                }
            });
            this.lUE.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.lUG.setSelected(false);
                }
            });
            int color = ap.getColor(R.color.common_color_10097);
            ap.setBackgroundResource(this.lUD, R.drawable.write_prefix_item_selector);
            ap.setImageResource(this.lUF, R.drawable.icon_title_down);
            this.lUD.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.lUM.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.lUM.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ap.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.lUM.getPageContext().getContext(), this.lUM.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.lUM.getPageContext().getContext(), this.lUM.getResources().getDimension(R.dimen.ds22)), 0);
                this.lUE.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.lUM.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.lUM.getPageContext().getContext(), this.lUM.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.lUM.getPageContext().getContext(), this.lUM.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.lUE.setCurrentIndex(0);
            return;
        }
        this.lUG.setVisibility(8);
    }

    protected void dtg() {
        this.lUy = (EditText) this.lUM.findViewById(R.id.post_title);
        if (this.lUg.getType() == 3) {
            if (this.lUg.getTitle() != null && this.lUg.getTitle().trim().length() > 0) {
                this.lUy.setText(this.lUg.getTitle());
                this.lUy.setSelection(this.lUg.getTitle().length());
            } else {
                String str = this.lUM.getPageContext().getString(R.string.share_transfer_thread) + this.lUg.getShareSummaryTitle();
                this.lUy.setText(str);
                if (str.length() < 20) {
                    this.lUy.setSelection(str.length());
                } else {
                    this.lUy.setSelection(20);
                }
            }
        }
        this.lUy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dth();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void dth() {
        String str = null;
        if (this.lUg.getType() == 3) {
            String trim = this.lUy.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.lUM.dtb() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.lUg.setIsNoTitle(true);
                    } else {
                        this.lUg.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.lUg.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.lUg.setIsNoTitle(true);
            } else {
                this.lUg.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.lUO) {
            this.kGp.setEnabled(false);
        } else {
            this.kGp.setEnabled(true);
        }
    }

    protected void dti() {
        this.lUC = (EditText) this.lUM.findViewById(R.id.post_content);
        this.lUC.setDrawingCacheEnabled(false);
        if (this.lUg.getContent() != null && this.lUg.getContent().length() > 0) {
            SpannableString ap = TbFaceManager.bsV().ap(this.lUM.getPageContext().getContext(), this.lUg.getContent());
            this.lUC.setText(ap);
            this.lUC.setSelection(ap.length());
        }
        this.lUC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.lUC.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dth();
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

    public EditText dtj() {
        return this.lUy;
    }

    public EditText dtk() {
        return this.lUC;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        dtf();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.lUy.setOnFocusChangeListener(onFocusChangeListener);
        this.lUC.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.kGp.setOnFocusChangeListener(onFocusChangeListener);
    }

    public i dtl() {
        return this.lUE;
    }

    public View dtm() {
        return this.mBack;
    }

    public TextView dtn() {
        return this.kGp;
    }

    public TextView dto() {
        return this.lUD;
    }

    public void ae(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void af(View.OnClickListener onClickListener) {
        this.kGp.setOnClickListener(onClickListener);
    }

    public void ag(View.OnClickListener onClickListener) {
        this.lUB.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.lUM != null) {
            this.lUM.getLayoutMode().setNightMode(i == 1);
            this.lUM.getLayoutMode().onModeChanged(this.jfk);
            this.mNavigationBar.onChangeSkinType(this.lUM.getPageContext(), i);
            ap.setTopBarCommonFinishButton(this.kGp, i);
            ap.setBackgroundColor(this.lUz, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.lUA, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.lUy, R.color.cp_cont_g);
            ap.setBackgroundColor(this.lUI, R.color.cp_bg_line_e);
            int color = ap.getColor(R.color.cp_cont_b);
            int color2 = ap.getColor(R.color.cp_cont_e);
            this.lUy.setTextColor(color);
            this.lUC.setTextColor(color);
            this.lUK.setTextColor(ap.getColor(R.color.cp_cont_b));
            this.lUL.setTextColor(ap.getColor(R.color.cp_cont_d));
            f(this.lUy, color2);
            f(this.lUC, color2);
            dth();
        }
    }

    public ShareSDKImageView dtp() {
        return this.lUJ;
    }
}
