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
    private WriteData ngH;
    private View nhb;
    private TextView nhe;
    private i nhf;
    private ImageView nhg;
    private View nhh;
    private LinearLayout nhi;
    private LinearLayout nhj;
    private ShareSDKImageView nhk;
    private TextView nhl;
    private TextView nhm;
    private WriteShareActivity nhn;
    private com.baidu.tbadk.img.b nho;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText ngZ = null;
    private View nha = null;
    private LinearLayout nhc = null;
    private EditText nhd = null;
    private TextView lPY = null;
    private RelativeLayout ltF = null;
    private boolean nhp = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.ngH = null;
        this.nhn = writeShareActivity;
        this.ngH = writeShareActivity.dcp();
        if (this.nho == null) {
            this.nho = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.nhn.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.nhn.getPageContext().getString(R.string.share_navigationbar_title));
        this.lPY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.nhn.getPageContext().getString(R.string.send_post));
        this.ltF = (RelativeLayout) this.nhn.findViewById(R.id.parent);
        this.nha = this.nhn.findViewById(R.id.interval_view);
        this.nhb = this.nhn.findViewById(R.id.prefix_interval_view);
        this.nhi = (LinearLayout) this.nhn.findViewById(R.id.post_share_layout);
        this.nhj = (LinearLayout) this.nhn.findViewById(R.id.post_share_content_layout);
        this.nhk = (ShareSDKImageView) this.nhn.findViewById(R.id.post_share_image);
        this.nhl = (TextView) this.nhn.findViewById(R.id.post_share_title);
        this.nhm = (TextView) this.nhn.findViewById(R.id.post_share_content);
        dLx();
        dLz();
        this.nhc = (LinearLayout) this.nhn.findViewById(R.id.post_content_container);
        this.nhc.setDrawingCacheEnabled(false);
        this.ngZ.setVisibility(0);
        this.nhd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        dLy();
    }

    public void dLv() {
        this.nhi = (LinearLayout) this.nhn.findViewById(R.id.post_share_layout);
        this.nhk = (ShareSDKImageView) this.nhn.findViewById(R.id.post_share_image);
        this.nhk.setIsRound(false);
        this.nhk.setDrawBorder(false);
        this.nhk.setAutoChangeStyle(true);
        this.nhk.setRadius(0);
        this.nhl = (TextView) this.nhn.findViewById(R.id.post_share_title);
        this.nhm = (TextView) this.nhn.findViewById(R.id.post_share_content);
        if (this.ngH != null) {
            if (this.ngH.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.nhk.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.nhk.getLoadedWidth() != 0 && c.this.nhk.getLoadedHeight() != 0) {
                                c.this.width = c.this.nhk.getLoadedWidth();
                                c.this.height = c.this.nhk.getLoadedHeight();
                                if (c.this.nhn != null) {
                                    c.this.nhn.dcp().setShareSummaryImgWidth(c.this.width);
                                    c.this.nhn.dcp().setShareSummaryImgHeight(c.this.height);
                                    c.this.nhp = true;
                                    c.this.dLy();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.nhp = false;
                        c.this.dLy();
                        if (c.this.nhn != null) {
                            c.this.nhn.Kt(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void onCancel() {
                        c.this.nhp = false;
                        c.this.dLy();
                        if (c.this.nhn != null) {
                            c.this.nhn.Kt(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.ngH.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.ngH.getShareSummaryImg() != null && this.ngH.getShareSummaryImg().trim().length() > 0) {
                    this.nhk.startLoad(this.ngH.getShareSummaryImg(), 10, true);
                } else {
                    this.nhp = true;
                    dLy();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.ngH.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.nhk.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.ngH.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.ngH.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.bg(au.bws().getPostImageSize(), au.bws().getPostImageHeightLimit()));
                    this.nhk.setTag(imageFileInfo.toCachedKey(true));
                    if (this.nho.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.nhi.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.nhk.invalidate();
                    }
                }
                this.nhp = true;
                dLy();
            }
            this.ngH.setShareSummaryImgType(f.getExtension(this.ngH.getShareSummaryImg()));
            this.nhl.setText(this.ngH.getShareSummaryTitle());
            this.nhm.setText(this.ngH.getShareSummaryContent());
        }
    }

    private void dLw() {
        this.nhh = this.nhn.findViewById(R.id.post_prefix_layout);
        this.nhe = (TextView) this.nhn.findViewById(R.id.post_prefix);
        this.nhg = (ImageView) this.nhn.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.nhh.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.nhe.setText(prefixs.get(0));
            this.nhn.Ku(0);
            this.nhh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.nhe.setVisibility(0);
                    c.this.nhh.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.nhf, view, l.dip2px(c.this.nhn.getPageContext().getContext(), 15.0f), l.dip2px(c.this.nhn.getPageContext().getContext(), 1.0f));
                    if (c.this.nhn != null) {
                        c.this.nhn.dLu();
                    }
                }
            });
            this.nhg = (ImageView) this.nhn.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.nhg.setVisibility(0);
                this.nhe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.nhe.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.nhf, view, l.dip2px(c.this.nhn.getPageContext().getContext(), 15.0f), l.dip2px(c.this.nhn.getPageContext().getContext(), 1.0f));
                        if (c.this.nhn != null) {
                            c.this.nhn.dLu();
                        }
                    }
                });
            }
            this.nhf = new i(this.nhn.getPageContext().getContext());
            this.nhf.setMaxHeight(l.dip2px(this.nhn.getPageContext().getContext(), 225.0f));
            this.nhf.setOutsideTouchable(true);
            this.nhf.setFocusable(true);
            this.nhf.setBackgroundDrawable(ao.getDrawable(R.color.CAM_X0204));
            this.nhf.a(new i.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.i.a
                public void Kv(int i) {
                    c.this.nhn.Ku(i);
                    c.this.nhe.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.nhf.setCurrentIndex(i);
                    c.this.dLy();
                    g.dismissPopupWindow(c.this.nhf, c.this.nhn.getPageContext().getPageActivity());
                }
            });
            this.nhf.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.nhh.setSelected(false);
                }
            });
            int color = ao.getColor(R.color.common_color_10097);
            ao.setBackgroundResource(this.nhe, R.drawable.write_prefix_item_selector);
            ao.setImageResource(this.nhg, R.drawable.icon_title_down);
            this.nhe.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.nhn.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.nhn.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ao.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.nhn.getPageContext().getContext(), this.nhn.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.nhn.getPageContext().getContext(), this.nhn.getResources().getDimension(R.dimen.ds22)), 0);
                this.nhf.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.nhn.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.nhn.getPageContext().getContext(), this.nhn.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.nhn.getPageContext().getContext(), this.nhn.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.nhf.setCurrentIndex(0);
            return;
        }
        this.nhh.setVisibility(8);
    }

    protected void dLx() {
        this.ngZ = (EditText) this.nhn.findViewById(R.id.post_title);
        if (this.ngH.getType() == 3) {
            if (this.ngH.getTitle() != null && this.ngH.getTitle().trim().length() > 0) {
                this.ngZ.setText(this.ngH.getTitle());
                this.ngZ.setSelection(this.ngH.getTitle().length());
            } else {
                String str = this.nhn.getPageContext().getString(R.string.share_transfer_thread) + this.ngH.getShareSummaryTitle();
                this.ngZ.setText(str);
                if (str.length() < 20) {
                    this.ngZ.setSelection(str.length());
                } else {
                    this.ngZ.setSelection(20);
                }
            }
        }
        this.ngZ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dLy();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void dLy() {
        String str = null;
        if (this.ngH.getType() == 3) {
            String trim = this.ngZ.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.nhn.dLs() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.ngH.setIsNoTitle(true);
                    } else {
                        this.ngH.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.ngH.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.ngH.setIsNoTitle(true);
            } else {
                this.ngH.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.nhp) {
            this.lPY.setEnabled(false);
        } else {
            this.lPY.setEnabled(true);
        }
    }

    protected void dLz() {
        this.nhd = (EditText) this.nhn.findViewById(R.id.post_content);
        this.nhd.setDrawingCacheEnabled(false);
        if (this.ngH.getContent() != null && this.ngH.getContent().length() > 0) {
            SpannableString aE = TbFaceManager.bGp().aE(this.nhn.getPageContext().getContext(), this.ngH.getContent());
            this.nhd.setText(aE);
            this.nhd.setSelection(aE.length());
        }
        this.nhd.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.nhd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dLy();
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

    public EditText dLA() {
        return this.ngZ;
    }

    public EditText dLB() {
        return this.nhd;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        dLw();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.ngZ.setOnFocusChangeListener(onFocusChangeListener);
        this.nhd.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.lPY.setOnFocusChangeListener(onFocusChangeListener);
    }

    public i dLC() {
        return this.nhf;
    }

    public View dLD() {
        return this.mBack;
    }

    public TextView dLE() {
        return this.lPY;
    }

    public TextView dLF() {
        return this.nhe;
    }

    public void ah(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ai(View.OnClickListener onClickListener) {
        this.lPY.setOnClickListener(onClickListener);
    }

    public void aj(View.OnClickListener onClickListener) {
        this.nhc.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.nhn != null) {
            this.nhn.getLayoutMode().setNightMode(i == 1);
            this.nhn.getLayoutMode().onModeChanged(this.ltF);
            this.mNavigationBar.onChangeSkinType(this.nhn.getPageContext(), i);
            ao.setTopBarCommonFinishButton(this.lPY, i);
            ao.setBackgroundColor(this.nha, R.color.CAM_X0204);
            ao.setBackgroundColor(this.nhb, R.color.CAM_X0204);
            ao.setBackgroundColor(this.ngZ, R.color.CAM_X0111);
            ao.setBackgroundColor(this.nhj, R.color.CAM_X0205);
            int color = ao.getColor(R.color.CAM_X0105);
            int color2 = ao.getColor(R.color.CAM_X0110);
            this.ngZ.setTextColor(color);
            this.nhd.setTextColor(color);
            this.nhl.setTextColor(ao.getColor(R.color.CAM_X0105));
            this.nhm.setTextColor(ao.getColor(R.color.CAM_X0109));
            g(this.ngZ, color2);
            g(this.nhd, color2);
            dLy();
        }
    }

    public ShareSDKImageView dLG() {
        return this.nhk;
    }
}
