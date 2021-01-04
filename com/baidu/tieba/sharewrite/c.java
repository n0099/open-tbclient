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
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes8.dex */
public class c {
    private PostPrefixData mPrefixData;
    private WriteData ngI;
    private View nhc;
    private TextView nhf;
    private i nhg;
    private ImageView nhh;
    private View nhi;
    private LinearLayout nhj;
    private LinearLayout nhk;
    private ShareSDKImageView nhl;
    private TextView nhm;
    private TextView nhn;
    private WriteShareActivity nho;
    private com.baidu.tbadk.img.b nhp;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText nha = null;
    private View nhb = null;
    private LinearLayout nhd = null;
    private EditText nhe = null;
    private TextView lPZ = null;
    private RelativeLayout ltF = null;
    private boolean nhq = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.ngI = null;
        this.nho = writeShareActivity;
        this.ngI = writeShareActivity.dco();
        if (this.nhp == null) {
            this.nhp = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.nho.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.nho.getPageContext().getString(R.string.share_navigationbar_title));
        this.lPZ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.nho.getPageContext().getString(R.string.send_post));
        this.ltF = (RelativeLayout) this.nho.findViewById(R.id.parent);
        this.nhb = this.nho.findViewById(R.id.interval_view);
        this.nhc = this.nho.findViewById(R.id.prefix_interval_view);
        this.nhj = (LinearLayout) this.nho.findViewById(R.id.post_share_layout);
        this.nhk = (LinearLayout) this.nho.findViewById(R.id.post_share_content_layout);
        this.nhl = (ShareSDKImageView) this.nho.findViewById(R.id.post_share_image);
        this.nhm = (TextView) this.nho.findViewById(R.id.post_share_title);
        this.nhn = (TextView) this.nho.findViewById(R.id.post_share_content);
        dLw();
        dLy();
        this.nhd = (LinearLayout) this.nho.findViewById(R.id.post_content_container);
        this.nhd.setDrawingCacheEnabled(false);
        this.nha.setVisibility(0);
        this.nhe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        dLx();
    }

    public void dLu() {
        this.nhj = (LinearLayout) this.nho.findViewById(R.id.post_share_layout);
        this.nhl = (ShareSDKImageView) this.nho.findViewById(R.id.post_share_image);
        this.nhl.setIsRound(false);
        this.nhl.setDrawBorder(false);
        this.nhl.setAutoChangeStyle(true);
        this.nhl.setRadius(0);
        this.nhm = (TextView) this.nho.findViewById(R.id.post_share_title);
        this.nhn = (TextView) this.nho.findViewById(R.id.post_share_content);
        if (this.ngI != null) {
            if (this.ngI.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.nhl.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.nhl.getLoadedWidth() != 0 && c.this.nhl.getLoadedHeight() != 0) {
                                c.this.width = c.this.nhl.getLoadedWidth();
                                c.this.height = c.this.nhl.getLoadedHeight();
                                if (c.this.nho != null) {
                                    c.this.nho.dco().setShareSummaryImgWidth(c.this.width);
                                    c.this.nho.dco().setShareSummaryImgHeight(c.this.height);
                                    c.this.nhq = true;
                                    c.this.dLx();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.nhq = false;
                        c.this.dLx();
                        if (c.this.nho != null) {
                            c.this.nho.Kt(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void onCancel() {
                        c.this.nhq = false;
                        c.this.dLx();
                        if (c.this.nho != null) {
                            c.this.nho.Kt(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.ngI.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.ngI.getShareSummaryImg() != null && this.ngI.getShareSummaryImg().trim().length() > 0) {
                    this.nhl.startLoad(this.ngI.getShareSummaryImg(), 10, true);
                } else {
                    this.nhq = true;
                    dLx();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.ngI.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.nhl.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.ngI.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.ngI.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.bg(au.bwr().getPostImageSize(), au.bwr().getPostImageHeightLimit()));
                    this.nhl.setTag(imageFileInfo.toCachedKey(true));
                    if (this.nhp.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.nhj.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.nhl.invalidate();
                    }
                }
                this.nhq = true;
                dLx();
            }
            this.ngI.setShareSummaryImgType(f.getExtension(this.ngI.getShareSummaryImg()));
            this.nhm.setText(this.ngI.getShareSummaryTitle());
            this.nhn.setText(this.ngI.getShareSummaryContent());
        }
    }

    private void dLv() {
        this.nhi = this.nho.findViewById(R.id.post_prefix_layout);
        this.nhf = (TextView) this.nho.findViewById(R.id.post_prefix);
        this.nhh = (ImageView) this.nho.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.nhi.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.nhf.setText(prefixs.get(0));
            this.nho.Ku(0);
            this.nhi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.nhf.setVisibility(0);
                    c.this.nhi.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.nhg, view, l.dip2px(c.this.nho.getPageContext().getContext(), 15.0f), l.dip2px(c.this.nho.getPageContext().getContext(), 1.0f));
                    if (c.this.nho != null) {
                        c.this.nho.dLt();
                    }
                }
            });
            this.nhh = (ImageView) this.nho.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.nhh.setVisibility(0);
                this.nhf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.nhf.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.nhg, view, l.dip2px(c.this.nho.getPageContext().getContext(), 15.0f), l.dip2px(c.this.nho.getPageContext().getContext(), 1.0f));
                        if (c.this.nho != null) {
                            c.this.nho.dLt();
                        }
                    }
                });
            }
            this.nhg = new i(this.nho.getPageContext().getContext());
            this.nhg.setMaxHeight(l.dip2px(this.nho.getPageContext().getContext(), 225.0f));
            this.nhg.setOutsideTouchable(true);
            this.nhg.setFocusable(true);
            this.nhg.setBackgroundDrawable(ao.getDrawable(R.color.CAM_X0204));
            this.nhg.a(new i.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.i.a
                public void Kv(int i) {
                    c.this.nho.Ku(i);
                    c.this.nhf.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.nhg.setCurrentIndex(i);
                    c.this.dLx();
                    g.dismissPopupWindow(c.this.nhg, c.this.nho.getPageContext().getPageActivity());
                }
            });
            this.nhg.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.nhi.setSelected(false);
                }
            });
            int color = ao.getColor(R.color.common_color_10097);
            ao.setBackgroundResource(this.nhf, R.drawable.write_prefix_item_selector);
            ao.setImageResource(this.nhh, R.drawable.icon_title_down);
            this.nhf.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.nho.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.nho.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ao.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.nho.getPageContext().getContext(), this.nho.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.nho.getPageContext().getContext(), this.nho.getResources().getDimension(R.dimen.ds22)), 0);
                this.nhg.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.nho.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.nho.getPageContext().getContext(), this.nho.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.nho.getPageContext().getContext(), this.nho.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.nhg.setCurrentIndex(0);
            return;
        }
        this.nhi.setVisibility(8);
    }

    protected void dLw() {
        this.nha = (EditText) this.nho.findViewById(R.id.post_title);
        if (this.ngI.getType() == 3) {
            if (this.ngI.getTitle() != null && this.ngI.getTitle().trim().length() > 0) {
                this.nha.setText(this.ngI.getTitle());
                this.nha.setSelection(this.ngI.getTitle().length());
            } else {
                String str = this.nho.getPageContext().getString(R.string.share_transfer_thread) + this.ngI.getShareSummaryTitle();
                this.nha.setText(str);
                if (str.length() < 20) {
                    this.nha.setSelection(str.length());
                } else {
                    this.nha.setSelection(20);
                }
            }
        }
        this.nha.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dLx();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void dLx() {
        String str = null;
        if (this.ngI.getType() == 3) {
            String trim = this.nha.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.nho.dLr() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.ngI.setIsNoTitle(true);
                    } else {
                        this.ngI.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.ngI.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.ngI.setIsNoTitle(true);
            } else {
                this.ngI.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.nhq) {
            this.lPZ.setEnabled(false);
        } else {
            this.lPZ.setEnabled(true);
        }
    }

    protected void dLy() {
        this.nhe = (EditText) this.nho.findViewById(R.id.post_content);
        this.nhe.setDrawingCacheEnabled(false);
        if (this.ngI.getContent() != null && this.ngI.getContent().length() > 0) {
            SpannableString aE = TbFaceManager.bGo().aE(this.nho.getPageContext().getContext(), this.ngI.getContent());
            this.nhe.setText(aE);
            this.nhe.setSelection(aE.length());
        }
        this.nhe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.nhe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dLx();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    private void g(EditText editText, int i) {
        Editable text = editText.getText();
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        editText.setText((CharSequence) null);
        editText.setHintTextColor(i);
        editText.setText(text);
        editText.setSelection(selectionStart, selectionEnd);
    }

    public EditText dLz() {
        return this.nha;
    }

    public EditText dLA() {
        return this.nhe;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        dLv();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.nha.setOnFocusChangeListener(onFocusChangeListener);
        this.nhe.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.lPZ.setOnFocusChangeListener(onFocusChangeListener);
    }

    public i dLB() {
        return this.nhg;
    }

    public View dLC() {
        return this.mBack;
    }

    public TextView dLD() {
        return this.lPZ;
    }

    public TextView dLE() {
        return this.nhf;
    }

    public void ah(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ai(View.OnClickListener onClickListener) {
        this.lPZ.setOnClickListener(onClickListener);
    }

    public void aj(View.OnClickListener onClickListener) {
        this.nhd.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.nho != null) {
            this.nho.getLayoutMode().setNightMode(i == 1);
            this.nho.getLayoutMode().onModeChanged(this.ltF);
            this.mNavigationBar.onChangeSkinType(this.nho.getPageContext(), i);
            ao.setTopBarCommonFinishButton(this.lPZ, i);
            ao.setBackgroundColor(this.nhb, R.color.CAM_X0204);
            ao.setBackgroundColor(this.nhc, R.color.CAM_X0204);
            ao.setBackgroundColor(this.nha, R.color.CAM_X0111);
            ao.setBackgroundColor(this.nhk, R.color.CAM_X0205);
            int color = ao.getColor(R.color.CAM_X0105);
            int color2 = ao.getColor(R.color.CAM_X0110);
            this.nha.setTextColor(color);
            this.nhe.setTextColor(color);
            this.nhm.setTextColor(ao.getColor(R.color.CAM_X0105));
            this.nhn.setTextColor(ao.getColor(R.color.CAM_X0109));
            g(this.nha, color2);
            g(this.nhe, color2);
            dLx();
        }
    }

    public ShareSDKImageView dLF() {
        return this.nhl;
    }
}
