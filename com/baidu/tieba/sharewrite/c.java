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
import com.baidu.tieba.write.i;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes11.dex */
public class c {
    private View lbF;
    private TextView lbJ;
    private i lbK;
    private ImageView lbL;
    private View lbM;
    private LinearLayout lbN;
    private LinearLayout lbO;
    private ShareSDKImageView lbP;
    private TextView lbQ;
    private TextView lbR;
    private WriteShareActivity lbS;
    private com.baidu.tbadk.img.b lbT;
    private WriteData lbl;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText lbD = null;
    private View lbE = null;
    private LinearLayout lbG = null;
    private EditText lbH = null;
    private TextView lbI = null;
    private RelativeLayout ita = null;
    private boolean lbU = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.lbl = null;
        this.lbS = writeShareActivity;
        this.lbl = writeShareActivity.daf();
        if (this.lbT == null) {
            this.lbT = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.lbS.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.lbS.getPageContext().getString(R.string.share_navigationbar_title));
        this.lbI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.lbS.getPageContext().getString(R.string.send_post));
        this.ita = (RelativeLayout) this.lbS.findViewById(R.id.parent);
        this.lbE = this.lbS.findViewById(R.id.interval_view);
        this.lbF = this.lbS.findViewById(R.id.prefix_interval_view);
        this.lbN = (LinearLayout) this.lbS.findViewById(R.id.post_share_layout);
        this.lbO = (LinearLayout) this.lbS.findViewById(R.id.post_share_content_layout);
        this.lbP = (ShareSDKImageView) this.lbS.findViewById(R.id.post_share_image);
        this.lbQ = (TextView) this.lbS.findViewById(R.id.post_share_title);
        this.lbR = (TextView) this.lbS.findViewById(R.id.post_share_content);
        dal();
        dan();
        this.lbG = (LinearLayout) this.lbS.findViewById(R.id.post_content_container);
        this.lbG.setDrawingCacheEnabled(false);
        this.lbD.setVisibility(0);
        this.lbH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        dam();
    }

    public void daj() {
        this.lbN = (LinearLayout) this.lbS.findViewById(R.id.post_share_layout);
        this.lbP = (ShareSDKImageView) this.lbS.findViewById(R.id.post_share_image);
        this.lbP.setIsRound(false);
        this.lbP.setDrawBorder(false);
        this.lbP.setAutoChangeStyle(true);
        this.lbP.setRadius(0);
        this.lbQ = (TextView) this.lbS.findViewById(R.id.post_share_title);
        this.lbR = (TextView) this.lbS.findViewById(R.id.post_share_content);
        if (this.lbl != null) {
            if (this.lbl.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.lbP.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.lbP.getLoadedWidth() != 0 && c.this.lbP.getLoadedHeight() != 0) {
                                c.this.width = c.this.lbP.getLoadedWidth();
                                c.this.height = c.this.lbP.getLoadedHeight();
                                if (c.this.lbS != null) {
                                    c.this.lbS.daf().setShareSummaryImgWidth(c.this.width);
                                    c.this.lbS.daf().setShareSummaryImgHeight(c.this.height);
                                    c.this.lbU = true;
                                    c.this.dam();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.lbU = false;
                        c.this.dam();
                        if (c.this.lbS != null) {
                            c.this.lbS.Dv(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.lbU = false;
                        c.this.dam();
                        if (c.this.lbS != null) {
                            c.this.lbS.Dv(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.lbl.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.lbl.getShareSummaryImg() != null && this.lbl.getShareSummaryImg().trim().length() > 0) {
                    this.lbP.startLoad(this.lbl.getShareSummaryImg(), 10, true);
                } else {
                    this.lbU = true;
                    dam();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.lbl.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.lbP.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.lbl.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(m.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.lbl.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.aS(ar.aUX().getPostImageSize(), ar.aUX().getPostImageHeightLimit()));
                    this.lbP.setTag(imageFileInfo.toCachedKey(true));
                    if (this.lbT.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.lbN.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.lbP.invalidate();
                    }
                }
                this.lbU = true;
                dam();
            }
            this.lbl.setShareSummaryImgType(f.getExtension(this.lbl.getShareSummaryImg()));
            this.lbQ.setText(this.lbl.getShareSummaryTitle());
            this.lbR.setText(this.lbl.getShareSummaryContent());
        }
    }

    private void dak() {
        this.lbM = this.lbS.findViewById(R.id.post_prefix_layout);
        this.lbJ = (TextView) this.lbS.findViewById(R.id.post_prefix);
        this.lbL = (ImageView) this.lbS.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.lbM.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.lbJ.setText(prefixs.get(0));
            this.lbS.Dw(0);
            this.lbM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.lbJ.setVisibility(0);
                    c.this.lbM.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.lbK, view, l.dip2px(c.this.lbS.getPageContext().getContext(), 15.0f), l.dip2px(c.this.lbS.getPageContext().getContext(), 1.0f));
                    if (c.this.lbS != null) {
                        c.this.lbS.dai();
                    }
                }
            });
            this.lbL = (ImageView) this.lbS.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.lbL.setVisibility(0);
                this.lbJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.lbJ.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.lbK, view, l.dip2px(c.this.lbS.getPageContext().getContext(), 15.0f), l.dip2px(c.this.lbS.getPageContext().getContext(), 1.0f));
                        if (c.this.lbS != null) {
                            c.this.lbS.dai();
                        }
                    }
                });
            }
            this.lbK = new i(this.lbS.getPageContext().getContext());
            this.lbK.setMaxHeight(l.dip2px(this.lbS.getPageContext().getContext(), 225.0f));
            this.lbK.setOutsideTouchable(true);
            this.lbK.setFocusable(true);
            this.lbK.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_c));
            this.lbK.a(new i.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.i.a
                public void Dx(int i) {
                    c.this.lbS.Dw(i);
                    c.this.lbJ.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.lbK.setCurrentIndex(i);
                    c.this.dam();
                    g.dismissPopupWindow(c.this.lbK, c.this.lbS.getPageContext().getPageActivity());
                }
            });
            this.lbK.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.lbM.setSelected(false);
                }
            });
            int color = am.getColor(R.color.common_color_10097);
            am.setBackgroundResource(this.lbJ, R.drawable.write_prefix_item_selector);
            am.setImageResource(this.lbL, R.drawable.icon_title_down);
            this.lbJ.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.lbS.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.lbS.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                am.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.lbS.getPageContext().getContext(), this.lbS.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.lbS.getPageContext().getContext(), this.lbS.getResources().getDimension(R.dimen.ds22)), 0);
                this.lbK.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.lbS.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.lbS.getPageContext().getContext(), this.lbS.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.lbS.getPageContext().getContext(), this.lbS.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.lbK.setCurrentIndex(0);
            return;
        }
        this.lbM.setVisibility(8);
    }

    protected void dal() {
        this.lbD = (EditText) this.lbS.findViewById(R.id.post_title);
        if (this.lbl.getType() == 3) {
            if (this.lbl.getTitle() != null && this.lbl.getTitle().trim().length() > 0) {
                this.lbD.setText(this.lbl.getTitle());
                this.lbD.setSelection(this.lbl.getTitle().length());
            } else {
                String str = this.lbS.getPageContext().getString(R.string.share_transfer_thread) + this.lbl.getShareSummaryTitle();
                this.lbD.setText(str);
                if (str.length() < 20) {
                    this.lbD.setSelection(str.length());
                } else {
                    this.lbD.setSelection(20);
                }
            }
        }
        this.lbD.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dam();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void dam() {
        String str = null;
        if (this.lbl.getType() == 3) {
            String trim = this.lbD.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.lbS.dag() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.lbl.setIsNoTitle(true);
                    } else {
                        this.lbl.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.lbl.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.lbl.setIsNoTitle(true);
            } else {
                this.lbl.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.lbU) {
            this.lbI.setEnabled(false);
        } else {
            this.lbI.setEnabled(true);
        }
    }

    protected void dan() {
        this.lbH = (EditText) this.lbS.findViewById(R.id.post_content);
        this.lbH.setDrawingCacheEnabled(false);
        if (this.lbl.getContent() != null && this.lbl.getContent().length() > 0) {
            SpannableString ak = TbFaceManager.bet().ak(this.lbS.getPageContext().getContext(), this.lbl.getContent());
            this.lbH.setText(ak);
            this.lbH.setSelection(ak.length());
        }
        this.lbH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.lbH.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dam();
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

    public EditText dao() {
        return this.lbD;
    }

    public EditText dap() {
        return this.lbH;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        dak();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.lbD.setOnFocusChangeListener(onFocusChangeListener);
        this.lbH.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.lbI.setOnFocusChangeListener(onFocusChangeListener);
    }

    public i daq() {
        return this.lbK;
    }

    public View dar() {
        return this.mBack;
    }

    public TextView das() {
        return this.lbI;
    }

    public TextView dat() {
        return this.lbJ;
    }

    public void ac(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ad(View.OnClickListener onClickListener) {
        this.lbI.setOnClickListener(onClickListener);
    }

    public void ae(View.OnClickListener onClickListener) {
        this.lbG.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.lbS != null) {
            this.lbS.getLayoutMode().setNightMode(i == 1);
            this.lbS.getLayoutMode().onModeChanged(this.ita);
            this.mNavigationBar.onChangeSkinType(this.lbS.getPageContext(), i);
            am.setTopBarCommonFinishButton(this.lbI, i);
            am.setBackgroundColor(this.lbE, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.lbF, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.lbD, R.color.cp_cont_g);
            am.setBackgroundColor(this.lbO, R.color.cp_bg_line_e);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_e);
            this.lbD.setTextColor(color);
            this.lbH.setTextColor(color);
            this.lbQ.setTextColor(am.getColor(R.color.cp_cont_b));
            this.lbR.setTextColor(am.getColor(R.color.cp_cont_d));
            f(this.lbD, color2);
            f(this.lbH, color2);
            dam();
        }
    }

    public ShareSDKImageView dau() {
        return this.lbP;
    }
}
