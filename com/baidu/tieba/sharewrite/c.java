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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.o;
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
    private WriteData nlK;
    private View nme;
    private TextView nmh;
    private i nmi;
    private ImageView nmj;
    private View nmk;
    private LinearLayout nml;
    private LinearLayout nmm;
    private ShareSDKImageView nmn;
    private TextView nmo;
    private TextView nmp;
    private WriteShareActivity nmq;
    private com.baidu.tbadk.img.b nmr;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText nmc = null;
    private View nmd = null;
    private LinearLayout nmf = null;
    private EditText nmg = null;
    private TextView lUq = null;
    private RelativeLayout lxd = null;
    private boolean nms = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.nlK = null;
        this.nmq = writeShareActivity;
        this.nlK = writeShareActivity.dav();
        if (this.nmr == null) {
            this.nmr = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.nmq.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.nmq.getPageContext().getString(R.string.share_navigationbar_title));
        this.lUq = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.nmq.getPageContext().getString(R.string.send_post));
        this.lxd = (RelativeLayout) this.nmq.findViewById(R.id.parent);
        this.nmd = this.nmq.findViewById(R.id.interval_view);
        this.nme = this.nmq.findViewById(R.id.prefix_interval_view);
        this.nml = (LinearLayout) this.nmq.findViewById(R.id.post_share_layout);
        this.nmm = (LinearLayout) this.nmq.findViewById(R.id.post_share_content_layout);
        this.nmn = (ShareSDKImageView) this.nmq.findViewById(R.id.post_share_image);
        this.nmo = (TextView) this.nmq.findViewById(R.id.post_share_title);
        this.nmp = (TextView) this.nmq.findViewById(R.id.post_share_content);
        dJQ();
        dJS();
        this.nmf = (LinearLayout) this.nmq.findViewById(R.id.post_content_container);
        this.nmf.setDrawingCacheEnabled(false);
        this.nmc.setVisibility(0);
        this.nmg.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        dJR();
    }

    public void dJO() {
        this.nml = (LinearLayout) this.nmq.findViewById(R.id.post_share_layout);
        this.nmn = (ShareSDKImageView) this.nmq.findViewById(R.id.post_share_image);
        this.nmn.setIsRound(false);
        this.nmn.setDrawBorder(false);
        this.nmn.setAutoChangeStyle(true);
        this.nmn.setRadius(0);
        this.nmo = (TextView) this.nmq.findViewById(R.id.post_share_title);
        this.nmp = (TextView) this.nmq.findViewById(R.id.post_share_content);
        if (this.nlK != null) {
            if (this.nlK.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.nmn.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.nmn.getLoadedWidth() != 0 && c.this.nmn.getLoadedHeight() != 0) {
                                c.this.width = c.this.nmn.getLoadedWidth();
                                c.this.height = c.this.nmn.getLoadedHeight();
                                if (c.this.nmq != null) {
                                    c.this.nmq.dav().setShareSummaryImgWidth(c.this.width);
                                    c.this.nmq.dav().setShareSummaryImgHeight(c.this.height);
                                    c.this.nms = true;
                                    c.this.dJR();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.nms = false;
                        c.this.dJR();
                        if (c.this.nmq != null) {
                            c.this.nmq.Jg(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void onCancel() {
                        c.this.nms = false;
                        c.this.dJR();
                        if (c.this.nmq != null) {
                            c.this.nmq.Jg(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.nlK.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.nlK.getShareSummaryImg() != null && this.nlK.getShareSummaryImg().trim().length() > 0) {
                    this.nmn.startLoad(this.nlK.getShareSummaryImg(), 10, true);
                } else {
                    this.nms = true;
                    dJR();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.nlK.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.nmn.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.nlK.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(o.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.nlK.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.bd(av.bsS().getPostImageSize(), av.bsS().getPostImageHeightLimit()));
                    this.nmn.setTag(imageFileInfo.toCachedKey(true));
                    if (this.nmr.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.nml.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.nmn.invalidate();
                    }
                }
                this.nms = true;
                dJR();
            }
            this.nlK.setShareSummaryImgType(f.getExtension(this.nlK.getShareSummaryImg()));
            this.nmo.setText(this.nlK.getShareSummaryTitle());
            this.nmp.setText(this.nlK.getShareSummaryContent());
        }
    }

    private void dJP() {
        this.nmk = this.nmq.findViewById(R.id.post_prefix_layout);
        this.nmh = (TextView) this.nmq.findViewById(R.id.post_prefix);
        this.nmj = (ImageView) this.nmq.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.nmk.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.nmh.setText(prefixs.get(0));
            this.nmq.Jh(0);
            this.nmk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.nmh.setVisibility(0);
                    c.this.nmk.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.nmi, view, l.dip2px(c.this.nmq.getPageContext().getContext(), 15.0f), l.dip2px(c.this.nmq.getPageContext().getContext(), 1.0f));
                    if (c.this.nmq != null) {
                        c.this.nmq.dJN();
                    }
                }
            });
            this.nmj = (ImageView) this.nmq.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.nmj.setVisibility(0);
                this.nmh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.nmh.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.nmi, view, l.dip2px(c.this.nmq.getPageContext().getContext(), 15.0f), l.dip2px(c.this.nmq.getPageContext().getContext(), 1.0f));
                        if (c.this.nmq != null) {
                            c.this.nmq.dJN();
                        }
                    }
                });
            }
            this.nmi = new i(this.nmq.getPageContext().getContext());
            this.nmi.setMaxHeight(l.dip2px(this.nmq.getPageContext().getContext(), 225.0f));
            this.nmi.setOutsideTouchable(true);
            this.nmi.setFocusable(true);
            this.nmi.setBackgroundDrawable(ap.getDrawable(R.color.CAM_X0204));
            this.nmi.a(new i.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.i.a
                public void Ji(int i) {
                    c.this.nmq.Jh(i);
                    c.this.nmh.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.nmi.setCurrentIndex(i);
                    c.this.dJR();
                    g.dismissPopupWindow(c.this.nmi, c.this.nmq.getPageContext().getPageActivity());
                }
            });
            this.nmi.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.nmk.setSelected(false);
                }
            });
            int color = ap.getColor(R.color.common_color_10097);
            ap.setBackgroundResource(this.nmh, R.drawable.write_prefix_item_selector);
            ap.setImageResource(this.nmj, R.drawable.icon_title_down);
            this.nmh.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.nmq.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.nmq.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ap.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.nmq.getPageContext().getContext(), this.nmq.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.nmq.getPageContext().getContext(), this.nmq.getResources().getDimension(R.dimen.ds22)), 0);
                this.nmi.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.nmq.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.nmq.getPageContext().getContext(), this.nmq.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.nmq.getPageContext().getContext(), this.nmq.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.nmi.setCurrentIndex(0);
            return;
        }
        this.nmk.setVisibility(8);
    }

    protected void dJQ() {
        this.nmc = (EditText) this.nmq.findViewById(R.id.post_title);
        if (this.nlK.getType() == 3) {
            if (this.nlK.getTitle() != null && this.nlK.getTitle().trim().length() > 0) {
                this.nmc.setText(this.nlK.getTitle());
                this.nmc.setSelection(this.nlK.getTitle().length());
            } else {
                String str = this.nmq.getPageContext().getString(R.string.share_transfer_thread) + this.nlK.getShareSummaryTitle();
                this.nmc.setText(str);
                if (str.length() < 20) {
                    this.nmc.setSelection(str.length());
                } else {
                    this.nmc.setSelection(20);
                }
            }
        }
        this.nmc.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dJR();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void dJR() {
        String str = null;
        if (this.nlK.getType() == 3) {
            String trim = this.nmc.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.nmq.dJL() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.nlK.setIsNoTitle(true);
                    } else {
                        this.nlK.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.nlK.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.nlK.setIsNoTitle(true);
            } else {
                this.nlK.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.nms) {
            this.lUq.setEnabled(false);
        } else {
            this.lUq.setEnabled(true);
        }
    }

    protected void dJS() {
        this.nmg = (EditText) this.nmq.findViewById(R.id.post_content);
        this.nmg.setDrawingCacheEnabled(false);
        if (this.nlK.getContent() != null && this.nlK.getContent().length() > 0) {
            SpannableString aD = TbFaceManager.bCO().aD(this.nmq.getPageContext().getContext(), this.nlK.getContent());
            this.nmg.setText(aD);
            this.nmg.setSelection(aD.length());
        }
        this.nmg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.nmg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dJR();
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

    public EditText dJT() {
        return this.nmc;
    }

    public EditText dJU() {
        return this.nmg;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        dJP();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.nmc.setOnFocusChangeListener(onFocusChangeListener);
        this.nmg.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.lUq.setOnFocusChangeListener(onFocusChangeListener);
    }

    public i dJV() {
        return this.nmi;
    }

    public View dJW() {
        return this.mBack;
    }

    public TextView dJX() {
        return this.lUq;
    }

    public TextView dJY() {
        return this.nmh;
    }

    public void ah(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ai(View.OnClickListener onClickListener) {
        this.lUq.setOnClickListener(onClickListener);
    }

    public void aj(View.OnClickListener onClickListener) {
        this.nmf.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.nmq != null) {
            this.nmq.getLayoutMode().setNightMode(i == 1);
            this.nmq.getLayoutMode().onModeChanged(this.lxd);
            this.mNavigationBar.onChangeSkinType(this.nmq.getPageContext(), i);
            ap.setTopBarCommonFinishButton(this.lUq, i);
            ap.setBackgroundColor(this.nmd, R.color.CAM_X0204);
            ap.setBackgroundColor(this.nme, R.color.CAM_X0204);
            ap.setBackgroundColor(this.nmc, R.color.CAM_X0111);
            ap.setBackgroundColor(this.nmm, R.color.CAM_X0205);
            int color = ap.getColor(R.color.CAM_X0105);
            int color2 = ap.getColor(R.color.CAM_X0110);
            this.nmc.setTextColor(color);
            this.nmg.setTextColor(color);
            this.nmo.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.nmp.setTextColor(ap.getColor(R.color.CAM_X0109));
            g(this.nmc, color2);
            g(this.nmg, color2);
            dJR();
        }
    }

    public ShareSDKImageView dJZ() {
        return this.nmn;
    }
}
