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
import com.baidu.tbadk.core.util.at;
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
    private View lCT;
    private TextView lCX;
    private i lCY;
    private ImageView lCZ;
    private WriteData lCz;
    private View lDa;
    private LinearLayout lDb;
    private LinearLayout lDc;
    private ShareSDKImageView lDd;
    private TextView lDe;
    private TextView lDf;
    private WriteShareActivity lDg;
    private com.baidu.tbadk.img.b lDh;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText lCR = null;
    private View lCS = null;
    private LinearLayout lCU = null;
    private EditText lCV = null;
    private TextView lCW = null;
    private RelativeLayout iQl = null;
    private boolean lDi = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.lCz = null;
        this.lDg = writeShareActivity;
        this.lCz = writeShareActivity.dhF();
        if (this.lDh == null) {
            this.lDh = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.lDg.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.lDg.getPageContext().getString(R.string.share_navigationbar_title));
        this.lCW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.lDg.getPageContext().getString(R.string.send_post));
        this.iQl = (RelativeLayout) this.lDg.findViewById(R.id.parent);
        this.lCS = this.lDg.findViewById(R.id.interval_view);
        this.lCT = this.lDg.findViewById(R.id.prefix_interval_view);
        this.lDb = (LinearLayout) this.lDg.findViewById(R.id.post_share_layout);
        this.lDc = (LinearLayout) this.lDg.findViewById(R.id.post_share_content_layout);
        this.lDd = (ShareSDKImageView) this.lDg.findViewById(R.id.post_share_image);
        this.lDe = (TextView) this.lDg.findViewById(R.id.post_share_title);
        this.lDf = (TextView) this.lDg.findViewById(R.id.post_share_content);
        dhL();
        dhN();
        this.lCU = (LinearLayout) this.lDg.findViewById(R.id.post_content_container);
        this.lCU.setDrawingCacheEnabled(false);
        this.lCR.setVisibility(0);
        this.lCV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        dhM();
    }

    public void dhJ() {
        this.lDb = (LinearLayout) this.lDg.findViewById(R.id.post_share_layout);
        this.lDd = (ShareSDKImageView) this.lDg.findViewById(R.id.post_share_image);
        this.lDd.setIsRound(false);
        this.lDd.setDrawBorder(false);
        this.lDd.setAutoChangeStyle(true);
        this.lDd.setRadius(0);
        this.lDe = (TextView) this.lDg.findViewById(R.id.post_share_title);
        this.lDf = (TextView) this.lDg.findViewById(R.id.post_share_content);
        if (this.lCz != null) {
            if (this.lCz.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.lDd.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.lDd.getLoadedWidth() != 0 && c.this.lDd.getLoadedHeight() != 0) {
                                c.this.width = c.this.lDd.getLoadedWidth();
                                c.this.height = c.this.lDd.getLoadedHeight();
                                if (c.this.lDg != null) {
                                    c.this.lDg.dhF().setShareSummaryImgWidth(c.this.width);
                                    c.this.lDg.dhF().setShareSummaryImgHeight(c.this.height);
                                    c.this.lDi = true;
                                    c.this.dhM();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.lDi = false;
                        c.this.dhM();
                        if (c.this.lDg != null) {
                            c.this.lDg.ET(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.lDi = false;
                        c.this.dhM();
                        if (c.this.lDg != null) {
                            c.this.lDg.ET(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.lCz.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.lCz.getShareSummaryImg() != null && this.lCz.getShareSummaryImg().trim().length() > 0) {
                    this.lDd.startLoad(this.lCz.getShareSummaryImg(), 10, true);
                } else {
                    this.lDi = true;
                    dhM();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.lCz.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.lDd.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.lCz.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.lCz.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.aX(at.baS().getPostImageSize(), at.baS().getPostImageHeightLimit()));
                    this.lDd.setTag(imageFileInfo.toCachedKey(true));
                    if (this.lDh.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.lDb.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.lDd.invalidate();
                    }
                }
                this.lDi = true;
                dhM();
            }
            this.lCz.setShareSummaryImgType(f.getExtension(this.lCz.getShareSummaryImg()));
            this.lDe.setText(this.lCz.getShareSummaryTitle());
            this.lDf.setText(this.lCz.getShareSummaryContent());
        }
    }

    private void dhK() {
        this.lDa = this.lDg.findViewById(R.id.post_prefix_layout);
        this.lCX = (TextView) this.lDg.findViewById(R.id.post_prefix);
        this.lCZ = (ImageView) this.lDg.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.lDa.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.lCX.setText(prefixs.get(0));
            this.lDg.EU(0);
            this.lDa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.lCX.setVisibility(0);
                    c.this.lDa.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.lCY, view, l.dip2px(c.this.lDg.getPageContext().getContext(), 15.0f), l.dip2px(c.this.lDg.getPageContext().getContext(), 1.0f));
                    if (c.this.lDg != null) {
                        c.this.lDg.dhI();
                    }
                }
            });
            this.lCZ = (ImageView) this.lDg.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.lCZ.setVisibility(0);
                this.lCX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.lCX.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.lCY, view, l.dip2px(c.this.lDg.getPageContext().getContext(), 15.0f), l.dip2px(c.this.lDg.getPageContext().getContext(), 1.0f));
                        if (c.this.lDg != null) {
                            c.this.lDg.dhI();
                        }
                    }
                });
            }
            this.lCY = new i(this.lDg.getPageContext().getContext());
            this.lCY.setMaxHeight(l.dip2px(this.lDg.getPageContext().getContext(), 225.0f));
            this.lCY.setOutsideTouchable(true);
            this.lCY.setFocusable(true);
            this.lCY.setBackgroundDrawable(ao.getDrawable(R.color.cp_bg_line_c));
            this.lCY.a(new i.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.i.a
                public void EV(int i) {
                    c.this.lDg.EU(i);
                    c.this.lCX.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.lCY.setCurrentIndex(i);
                    c.this.dhM();
                    g.dismissPopupWindow(c.this.lCY, c.this.lDg.getPageContext().getPageActivity());
                }
            });
            this.lCY.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.lDa.setSelected(false);
                }
            });
            int color = ao.getColor(R.color.common_color_10097);
            ao.setBackgroundResource(this.lCX, R.drawable.write_prefix_item_selector);
            ao.setImageResource(this.lCZ, R.drawable.icon_title_down);
            this.lCX.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.lDg.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.lDg.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ao.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.lDg.getPageContext().getContext(), this.lDg.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.lDg.getPageContext().getContext(), this.lDg.getResources().getDimension(R.dimen.ds22)), 0);
                this.lCY.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.lDg.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.lDg.getPageContext().getContext(), this.lDg.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.lDg.getPageContext().getContext(), this.lDg.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.lCY.setCurrentIndex(0);
            return;
        }
        this.lDa.setVisibility(8);
    }

    protected void dhL() {
        this.lCR = (EditText) this.lDg.findViewById(R.id.post_title);
        if (this.lCz.getType() == 3) {
            if (this.lCz.getTitle() != null && this.lCz.getTitle().trim().length() > 0) {
                this.lCR.setText(this.lCz.getTitle());
                this.lCR.setSelection(this.lCz.getTitle().length());
            } else {
                String str = this.lDg.getPageContext().getString(R.string.share_transfer_thread) + this.lCz.getShareSummaryTitle();
                this.lCR.setText(str);
                if (str.length() < 20) {
                    this.lCR.setSelection(str.length());
                } else {
                    this.lCR.setSelection(20);
                }
            }
        }
        this.lCR.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dhM();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void dhM() {
        String str = null;
        if (this.lCz.getType() == 3) {
            String trim = this.lCR.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.lDg.dhG() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.lCz.setIsNoTitle(true);
                    } else {
                        this.lCz.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.lCz.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.lCz.setIsNoTitle(true);
            } else {
                this.lCz.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.lDi) {
            this.lCW.setEnabled(false);
        } else {
            this.lCW.setEnabled(true);
        }
    }

    protected void dhN() {
        this.lCV = (EditText) this.lDg.findViewById(R.id.post_content);
        this.lCV.setDrawingCacheEnabled(false);
        if (this.lCz.getContent() != null && this.lCz.getContent().length() > 0) {
            SpannableString al = TbFaceManager.bkj().al(this.lDg.getPageContext().getContext(), this.lCz.getContent());
            this.lCV.setText(al);
            this.lCV.setSelection(al.length());
        }
        this.lCV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.lCV.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dhM();
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

    public EditText dhO() {
        return this.lCR;
    }

    public EditText dhP() {
        return this.lCV;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        dhK();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.lCR.setOnFocusChangeListener(onFocusChangeListener);
        this.lCV.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.lCW.setOnFocusChangeListener(onFocusChangeListener);
    }

    public i dhQ() {
        return this.lCY;
    }

    public View dhR() {
        return this.mBack;
    }

    public TextView dhS() {
        return this.lCW;
    }

    public TextView dhT() {
        return this.lCX;
    }

    public void ad(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ae(View.OnClickListener onClickListener) {
        this.lCW.setOnClickListener(onClickListener);
    }

    public void af(View.OnClickListener onClickListener) {
        this.lCU.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.lDg != null) {
            this.lDg.getLayoutMode().setNightMode(i == 1);
            this.lDg.getLayoutMode().onModeChanged(this.iQl);
            this.mNavigationBar.onChangeSkinType(this.lDg.getPageContext(), i);
            ao.setTopBarCommonFinishButton(this.lCW, i);
            ao.setBackgroundColor(this.lCS, R.color.cp_bg_line_c);
            ao.setBackgroundColor(this.lCT, R.color.cp_bg_line_c);
            ao.setBackgroundColor(this.lCR, R.color.cp_cont_g);
            ao.setBackgroundColor(this.lDc, R.color.cp_bg_line_e);
            int color = ao.getColor(R.color.cp_cont_b);
            int color2 = ao.getColor(R.color.cp_cont_e);
            this.lCR.setTextColor(color);
            this.lCV.setTextColor(color);
            this.lDe.setTextColor(ao.getColor(R.color.cp_cont_b));
            this.lDf.setTextColor(ao.getColor(R.color.cp_cont_d));
            f(this.lCR, color2);
            f(this.lCV, color2);
            dhM();
        }
    }

    public ShareSDKImageView dhU() {
        return this.lDd;
    }
}
