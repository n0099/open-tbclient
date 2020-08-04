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
    private WriteData lCB;
    private View lCV;
    private TextView lCZ;
    private i lDa;
    private ImageView lDb;
    private View lDc;
    private LinearLayout lDd;
    private LinearLayout lDe;
    private ShareSDKImageView lDf;
    private TextView lDg;
    private TextView lDh;
    private WriteShareActivity lDi;
    private com.baidu.tbadk.img.b lDj;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText lCT = null;
    private View lCU = null;
    private LinearLayout lCW = null;
    private EditText lCX = null;
    private TextView lCY = null;
    private RelativeLayout iQn = null;
    private boolean lDk = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.lCB = null;
        this.lDi = writeShareActivity;
        this.lCB = writeShareActivity.dhF();
        if (this.lDj == null) {
            this.lDj = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.lDi.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.lDi.getPageContext().getString(R.string.share_navigationbar_title));
        this.lCY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.lDi.getPageContext().getString(R.string.send_post));
        this.iQn = (RelativeLayout) this.lDi.findViewById(R.id.parent);
        this.lCU = this.lDi.findViewById(R.id.interval_view);
        this.lCV = this.lDi.findViewById(R.id.prefix_interval_view);
        this.lDd = (LinearLayout) this.lDi.findViewById(R.id.post_share_layout);
        this.lDe = (LinearLayout) this.lDi.findViewById(R.id.post_share_content_layout);
        this.lDf = (ShareSDKImageView) this.lDi.findViewById(R.id.post_share_image);
        this.lDg = (TextView) this.lDi.findViewById(R.id.post_share_title);
        this.lDh = (TextView) this.lDi.findViewById(R.id.post_share_content);
        dhL();
        dhN();
        this.lCW = (LinearLayout) this.lDi.findViewById(R.id.post_content_container);
        this.lCW.setDrawingCacheEnabled(false);
        this.lCT.setVisibility(0);
        this.lCX.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        dhM();
    }

    public void dhJ() {
        this.lDd = (LinearLayout) this.lDi.findViewById(R.id.post_share_layout);
        this.lDf = (ShareSDKImageView) this.lDi.findViewById(R.id.post_share_image);
        this.lDf.setIsRound(false);
        this.lDf.setDrawBorder(false);
        this.lDf.setAutoChangeStyle(true);
        this.lDf.setRadius(0);
        this.lDg = (TextView) this.lDi.findViewById(R.id.post_share_title);
        this.lDh = (TextView) this.lDi.findViewById(R.id.post_share_content);
        if (this.lCB != null) {
            if (this.lCB.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.lDf.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.lDf.getLoadedWidth() != 0 && c.this.lDf.getLoadedHeight() != 0) {
                                c.this.width = c.this.lDf.getLoadedWidth();
                                c.this.height = c.this.lDf.getLoadedHeight();
                                if (c.this.lDi != null) {
                                    c.this.lDi.dhF().setShareSummaryImgWidth(c.this.width);
                                    c.this.lDi.dhF().setShareSummaryImgHeight(c.this.height);
                                    c.this.lDk = true;
                                    c.this.dhM();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.lDk = false;
                        c.this.dhM();
                        if (c.this.lDi != null) {
                            c.this.lDi.ET(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.lDk = false;
                        c.this.dhM();
                        if (c.this.lDi != null) {
                            c.this.lDi.ET(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.lCB.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.lCB.getShareSummaryImg() != null && this.lCB.getShareSummaryImg().trim().length() > 0) {
                    this.lDf.startLoad(this.lCB.getShareSummaryImg(), 10, true);
                } else {
                    this.lDk = true;
                    dhM();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.lCB.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.lDf.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.lCB.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.lCB.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.aX(at.baS().getPostImageSize(), at.baS().getPostImageHeightLimit()));
                    this.lDf.setTag(imageFileInfo.toCachedKey(true));
                    if (this.lDj.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.lDd.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.lDf.invalidate();
                    }
                }
                this.lDk = true;
                dhM();
            }
            this.lCB.setShareSummaryImgType(f.getExtension(this.lCB.getShareSummaryImg()));
            this.lDg.setText(this.lCB.getShareSummaryTitle());
            this.lDh.setText(this.lCB.getShareSummaryContent());
        }
    }

    private void dhK() {
        this.lDc = this.lDi.findViewById(R.id.post_prefix_layout);
        this.lCZ = (TextView) this.lDi.findViewById(R.id.post_prefix);
        this.lDb = (ImageView) this.lDi.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.lDc.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.lCZ.setText(prefixs.get(0));
            this.lDi.EU(0);
            this.lDc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.lCZ.setVisibility(0);
                    c.this.lDc.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.lDa, view, l.dip2px(c.this.lDi.getPageContext().getContext(), 15.0f), l.dip2px(c.this.lDi.getPageContext().getContext(), 1.0f));
                    if (c.this.lDi != null) {
                        c.this.lDi.dhI();
                    }
                }
            });
            this.lDb = (ImageView) this.lDi.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.lDb.setVisibility(0);
                this.lCZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.lCZ.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.lDa, view, l.dip2px(c.this.lDi.getPageContext().getContext(), 15.0f), l.dip2px(c.this.lDi.getPageContext().getContext(), 1.0f));
                        if (c.this.lDi != null) {
                            c.this.lDi.dhI();
                        }
                    }
                });
            }
            this.lDa = new i(this.lDi.getPageContext().getContext());
            this.lDa.setMaxHeight(l.dip2px(this.lDi.getPageContext().getContext(), 225.0f));
            this.lDa.setOutsideTouchable(true);
            this.lDa.setFocusable(true);
            this.lDa.setBackgroundDrawable(ao.getDrawable(R.color.cp_bg_line_c));
            this.lDa.a(new i.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.i.a
                public void EV(int i) {
                    c.this.lDi.EU(i);
                    c.this.lCZ.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.lDa.setCurrentIndex(i);
                    c.this.dhM();
                    g.dismissPopupWindow(c.this.lDa, c.this.lDi.getPageContext().getPageActivity());
                }
            });
            this.lDa.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.lDc.setSelected(false);
                }
            });
            int color = ao.getColor(R.color.common_color_10097);
            ao.setBackgroundResource(this.lCZ, R.drawable.write_prefix_item_selector);
            ao.setImageResource(this.lDb, R.drawable.icon_title_down);
            this.lCZ.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.lDi.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.lDi.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ao.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.lDi.getPageContext().getContext(), this.lDi.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.lDi.getPageContext().getContext(), this.lDi.getResources().getDimension(R.dimen.ds22)), 0);
                this.lDa.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.lDi.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.lDi.getPageContext().getContext(), this.lDi.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.lDi.getPageContext().getContext(), this.lDi.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.lDa.setCurrentIndex(0);
            return;
        }
        this.lDc.setVisibility(8);
    }

    protected void dhL() {
        this.lCT = (EditText) this.lDi.findViewById(R.id.post_title);
        if (this.lCB.getType() == 3) {
            if (this.lCB.getTitle() != null && this.lCB.getTitle().trim().length() > 0) {
                this.lCT.setText(this.lCB.getTitle());
                this.lCT.setSelection(this.lCB.getTitle().length());
            } else {
                String str = this.lDi.getPageContext().getString(R.string.share_transfer_thread) + this.lCB.getShareSummaryTitle();
                this.lCT.setText(str);
                if (str.length() < 20) {
                    this.lCT.setSelection(str.length());
                } else {
                    this.lCT.setSelection(20);
                }
            }
        }
        this.lCT.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
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
        if (this.lCB.getType() == 3) {
            String trim = this.lCT.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.lDi.dhG() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.lCB.setIsNoTitle(true);
                    } else {
                        this.lCB.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.lCB.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.lCB.setIsNoTitle(true);
            } else {
                this.lCB.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.lDk) {
            this.lCY.setEnabled(false);
        } else {
            this.lCY.setEnabled(true);
        }
    }

    protected void dhN() {
        this.lCX = (EditText) this.lDi.findViewById(R.id.post_content);
        this.lCX.setDrawingCacheEnabled(false);
        if (this.lCB.getContent() != null && this.lCB.getContent().length() > 0) {
            SpannableString al = TbFaceManager.bkj().al(this.lDi.getPageContext().getContext(), this.lCB.getContent());
            this.lCX.setText(al);
            this.lCX.setSelection(al.length());
        }
        this.lCX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.lCX.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
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
        return this.lCT;
    }

    public EditText dhP() {
        return this.lCX;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        dhK();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.lCT.setOnFocusChangeListener(onFocusChangeListener);
        this.lCX.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.lCY.setOnFocusChangeListener(onFocusChangeListener);
    }

    public i dhQ() {
        return this.lDa;
    }

    public View dhR() {
        return this.mBack;
    }

    public TextView dhS() {
        return this.lCY;
    }

    public TextView dhT() {
        return this.lCZ;
    }

    public void ad(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ae(View.OnClickListener onClickListener) {
        this.lCY.setOnClickListener(onClickListener);
    }

    public void af(View.OnClickListener onClickListener) {
        this.lCW.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.lDi != null) {
            this.lDi.getLayoutMode().setNightMode(i == 1);
            this.lDi.getLayoutMode().onModeChanged(this.iQn);
            this.mNavigationBar.onChangeSkinType(this.lDi.getPageContext(), i);
            ao.setTopBarCommonFinishButton(this.lCY, i);
            ao.setBackgroundColor(this.lCU, R.color.cp_bg_line_c);
            ao.setBackgroundColor(this.lCV, R.color.cp_bg_line_c);
            ao.setBackgroundColor(this.lCT, R.color.cp_cont_g);
            ao.setBackgroundColor(this.lDe, R.color.cp_bg_line_e);
            int color = ao.getColor(R.color.cp_cont_b);
            int color2 = ao.getColor(R.color.cp_cont_e);
            this.lCT.setTextColor(color);
            this.lCX.setTextColor(color);
            this.lDg.setTextColor(ao.getColor(R.color.cp_cont_b));
            this.lDh.setTextColor(ao.getColor(R.color.cp_cont_d));
            f(this.lCT, color2);
            f(this.lCX, color2);
            dhM();
        }
    }

    public ShareSDKImageView dhU() {
        return this.lDf;
    }
}
