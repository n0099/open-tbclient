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
    private View nmE;
    private TextView nmH;
    private i nmI;
    private ImageView nmJ;
    private View nmK;
    private LinearLayout nmL;
    private LinearLayout nmM;
    private ShareSDKImageView nmN;
    private TextView nmO;
    private TextView nmP;
    private WriteShareActivity nmQ;
    private com.baidu.tbadk.img.b nmR;
    private WriteData nmk;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText nmC = null;
    private View nmD = null;
    private LinearLayout nmF = null;
    private EditText nmG = null;
    private TextView lUF = null;
    private RelativeLayout lxr = null;
    private boolean nmS = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.nmk = null;
        this.nmQ = writeShareActivity;
        this.nmk = writeShareActivity.daC();
        if (this.nmR == null) {
            this.nmR = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.nmQ.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.nmQ.getPageContext().getString(R.string.share_navigationbar_title));
        this.lUF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.nmQ.getPageContext().getString(R.string.send_post));
        this.lxr = (RelativeLayout) this.nmQ.findViewById(R.id.parent);
        this.nmD = this.nmQ.findViewById(R.id.interval_view);
        this.nmE = this.nmQ.findViewById(R.id.prefix_interval_view);
        this.nmL = (LinearLayout) this.nmQ.findViewById(R.id.post_share_layout);
        this.nmM = (LinearLayout) this.nmQ.findViewById(R.id.post_share_content_layout);
        this.nmN = (ShareSDKImageView) this.nmQ.findViewById(R.id.post_share_image);
        this.nmO = (TextView) this.nmQ.findViewById(R.id.post_share_title);
        this.nmP = (TextView) this.nmQ.findViewById(R.id.post_share_content);
        dJY();
        dKa();
        this.nmF = (LinearLayout) this.nmQ.findViewById(R.id.post_content_container);
        this.nmF.setDrawingCacheEnabled(false);
        this.nmC.setVisibility(0);
        this.nmG.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        dJZ();
    }

    public void dJW() {
        this.nmL = (LinearLayout) this.nmQ.findViewById(R.id.post_share_layout);
        this.nmN = (ShareSDKImageView) this.nmQ.findViewById(R.id.post_share_image);
        this.nmN.setIsRound(false);
        this.nmN.setDrawBorder(false);
        this.nmN.setAutoChangeStyle(true);
        this.nmN.setRadius(0);
        this.nmO = (TextView) this.nmQ.findViewById(R.id.post_share_title);
        this.nmP = (TextView) this.nmQ.findViewById(R.id.post_share_content);
        if (this.nmk != null) {
            if (this.nmk.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.nmN.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.nmN.getLoadedWidth() != 0 && c.this.nmN.getLoadedHeight() != 0) {
                                c.this.width = c.this.nmN.getLoadedWidth();
                                c.this.height = c.this.nmN.getLoadedHeight();
                                if (c.this.nmQ != null) {
                                    c.this.nmQ.daC().setShareSummaryImgWidth(c.this.width);
                                    c.this.nmQ.daC().setShareSummaryImgHeight(c.this.height);
                                    c.this.nmS = true;
                                    c.this.dJZ();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.nmS = false;
                        c.this.dJZ();
                        if (c.this.nmQ != null) {
                            c.this.nmQ.Jg(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void onCancel() {
                        c.this.nmS = false;
                        c.this.dJZ();
                        if (c.this.nmQ != null) {
                            c.this.nmQ.Jg(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.nmk.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.nmk.getShareSummaryImg() != null && this.nmk.getShareSummaryImg().trim().length() > 0) {
                    this.nmN.startLoad(this.nmk.getShareSummaryImg(), 10, true);
                } else {
                    this.nmS = true;
                    dJZ();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.nmk.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.nmN.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.nmk.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(o.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.nmk.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.bd(av.bsS().getPostImageSize(), av.bsS().getPostImageHeightLimit()));
                    this.nmN.setTag(imageFileInfo.toCachedKey(true));
                    if (this.nmR.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.nmL.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.nmN.invalidate();
                    }
                }
                this.nmS = true;
                dJZ();
            }
            this.nmk.setShareSummaryImgType(f.getExtension(this.nmk.getShareSummaryImg()));
            this.nmO.setText(this.nmk.getShareSummaryTitle());
            this.nmP.setText(this.nmk.getShareSummaryContent());
        }
    }

    private void dJX() {
        this.nmK = this.nmQ.findViewById(R.id.post_prefix_layout);
        this.nmH = (TextView) this.nmQ.findViewById(R.id.post_prefix);
        this.nmJ = (ImageView) this.nmQ.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.nmK.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.nmH.setText(prefixs.get(0));
            this.nmQ.Jh(0);
            this.nmK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.nmH.setVisibility(0);
                    c.this.nmK.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.nmI, view, l.dip2px(c.this.nmQ.getPageContext().getContext(), 15.0f), l.dip2px(c.this.nmQ.getPageContext().getContext(), 1.0f));
                    if (c.this.nmQ != null) {
                        c.this.nmQ.dJV();
                    }
                }
            });
            this.nmJ = (ImageView) this.nmQ.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.nmJ.setVisibility(0);
                this.nmH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.nmH.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.nmI, view, l.dip2px(c.this.nmQ.getPageContext().getContext(), 15.0f), l.dip2px(c.this.nmQ.getPageContext().getContext(), 1.0f));
                        if (c.this.nmQ != null) {
                            c.this.nmQ.dJV();
                        }
                    }
                });
            }
            this.nmI = new i(this.nmQ.getPageContext().getContext());
            this.nmI.setMaxHeight(l.dip2px(this.nmQ.getPageContext().getContext(), 225.0f));
            this.nmI.setOutsideTouchable(true);
            this.nmI.setFocusable(true);
            this.nmI.setBackgroundDrawable(ap.getDrawable(R.color.CAM_X0204));
            this.nmI.a(new i.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.i.a
                public void Ji(int i) {
                    c.this.nmQ.Jh(i);
                    c.this.nmH.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.nmI.setCurrentIndex(i);
                    c.this.dJZ();
                    g.dismissPopupWindow(c.this.nmI, c.this.nmQ.getPageContext().getPageActivity());
                }
            });
            this.nmI.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.nmK.setSelected(false);
                }
            });
            int color = ap.getColor(R.color.common_color_10097);
            ap.setBackgroundResource(this.nmH, R.drawable.write_prefix_item_selector);
            ap.setImageResource(this.nmJ, R.drawable.icon_title_down);
            this.nmH.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.nmQ.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.nmQ.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ap.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.nmQ.getPageContext().getContext(), this.nmQ.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.nmQ.getPageContext().getContext(), this.nmQ.getResources().getDimension(R.dimen.ds22)), 0);
                this.nmI.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.nmQ.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.nmQ.getPageContext().getContext(), this.nmQ.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.nmQ.getPageContext().getContext(), this.nmQ.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.nmI.setCurrentIndex(0);
            return;
        }
        this.nmK.setVisibility(8);
    }

    protected void dJY() {
        this.nmC = (EditText) this.nmQ.findViewById(R.id.post_title);
        if (this.nmk.getType() == 3) {
            if (this.nmk.getTitle() != null && this.nmk.getTitle().trim().length() > 0) {
                this.nmC.setText(this.nmk.getTitle());
                this.nmC.setSelection(this.nmk.getTitle().length());
            } else {
                String str = this.nmQ.getPageContext().getString(R.string.share_transfer_thread) + this.nmk.getShareSummaryTitle();
                this.nmC.setText(str);
                if (str.length() < 20) {
                    this.nmC.setSelection(str.length());
                } else {
                    this.nmC.setSelection(20);
                }
            }
        }
        this.nmC.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dJZ();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void dJZ() {
        String str = null;
        if (this.nmk.getType() == 3) {
            String trim = this.nmC.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.nmQ.dJT() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.nmk.setIsNoTitle(true);
                    } else {
                        this.nmk.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.nmk.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.nmk.setIsNoTitle(true);
            } else {
                this.nmk.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.nmS) {
            this.lUF.setEnabled(false);
        } else {
            this.lUF.setEnabled(true);
        }
    }

    protected void dKa() {
        this.nmG = (EditText) this.nmQ.findViewById(R.id.post_content);
        this.nmG.setDrawingCacheEnabled(false);
        if (this.nmk.getContent() != null && this.nmk.getContent().length() > 0) {
            SpannableString aD = TbFaceManager.bCO().aD(this.nmQ.getPageContext().getContext(), this.nmk.getContent());
            this.nmG.setText(aD);
            this.nmG.setSelection(aD.length());
        }
        this.nmG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.nmG.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dJZ();
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

    public EditText dKb() {
        return this.nmC;
    }

    public EditText dKc() {
        return this.nmG;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        dJX();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.nmC.setOnFocusChangeListener(onFocusChangeListener);
        this.nmG.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.lUF.setOnFocusChangeListener(onFocusChangeListener);
    }

    public i dKd() {
        return this.nmI;
    }

    public View dKe() {
        return this.mBack;
    }

    public TextView dKf() {
        return this.lUF;
    }

    public TextView dKg() {
        return this.nmH;
    }

    public void ah(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ai(View.OnClickListener onClickListener) {
        this.lUF.setOnClickListener(onClickListener);
    }

    public void aj(View.OnClickListener onClickListener) {
        this.nmF.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.nmQ != null) {
            this.nmQ.getLayoutMode().setNightMode(i == 1);
            this.nmQ.getLayoutMode().onModeChanged(this.lxr);
            this.mNavigationBar.onChangeSkinType(this.nmQ.getPageContext(), i);
            ap.setTopBarCommonFinishButton(this.lUF, i);
            ap.setBackgroundColor(this.nmD, R.color.CAM_X0204);
            ap.setBackgroundColor(this.nmE, R.color.CAM_X0204);
            ap.setBackgroundColor(this.nmC, R.color.CAM_X0111);
            ap.setBackgroundColor(this.nmM, R.color.CAM_X0205);
            int color = ap.getColor(R.color.CAM_X0105);
            int color2 = ap.getColor(R.color.CAM_X0110);
            this.nmC.setTextColor(color);
            this.nmG.setTextColor(color);
            this.nmO.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.nmP.setTextColor(ap.getColor(R.color.CAM_X0109));
            g(this.nmC, color2);
            g(this.nmG, color2);
            dJZ();
        }
    }

    public ShareSDKImageView dKh() {
        return this.nmN;
    }
}
