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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
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
/* loaded from: classes11.dex */
public class c {
    private View lvC;
    private TextView lvG;
    private i lvH;
    private ImageView lvI;
    private View lvJ;
    private LinearLayout lvK;
    private LinearLayout lvL;
    private ShareSDKImageView lvM;
    private TextView lvN;
    private TextView lvO;
    private WriteShareActivity lvP;
    private com.baidu.tbadk.img.b lvQ;
    private WriteData lvi;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText lvA = null;
    private View lvB = null;
    private LinearLayout lvD = null;
    private EditText lvE = null;
    private TextView lvF = null;
    private RelativeLayout iKg = null;
    private boolean lvR = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.lvi = null;
        this.lvP = writeShareActivity;
        this.lvi = writeShareActivity.dew();
        if (this.lvQ == null) {
            this.lvQ = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.lvP.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.lvP.getPageContext().getString(R.string.share_navigationbar_title));
        this.lvF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.lvP.getPageContext().getString(R.string.send_post));
        this.iKg = (RelativeLayout) this.lvP.findViewById(R.id.parent);
        this.lvB = this.lvP.findViewById(R.id.interval_view);
        this.lvC = this.lvP.findViewById(R.id.prefix_interval_view);
        this.lvK = (LinearLayout) this.lvP.findViewById(R.id.post_share_layout);
        this.lvL = (LinearLayout) this.lvP.findViewById(R.id.post_share_content_layout);
        this.lvM = (ShareSDKImageView) this.lvP.findViewById(R.id.post_share_image);
        this.lvN = (TextView) this.lvP.findViewById(R.id.post_share_title);
        this.lvO = (TextView) this.lvP.findViewById(R.id.post_share_content);
        deC();
        deE();
        this.lvD = (LinearLayout) this.lvP.findViewById(R.id.post_content_container);
        this.lvD.setDrawingCacheEnabled(false);
        this.lvA.setVisibility(0);
        this.lvE.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        deD();
    }

    public void deA() {
        this.lvK = (LinearLayout) this.lvP.findViewById(R.id.post_share_layout);
        this.lvM = (ShareSDKImageView) this.lvP.findViewById(R.id.post_share_image);
        this.lvM.setIsRound(false);
        this.lvM.setDrawBorder(false);
        this.lvM.setAutoChangeStyle(true);
        this.lvM.setRadius(0);
        this.lvN = (TextView) this.lvP.findViewById(R.id.post_share_title);
        this.lvO = (TextView) this.lvP.findViewById(R.id.post_share_content);
        if (this.lvi != null) {
            if (this.lvi.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.lvM.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.lvM.getLoadedWidth() != 0 && c.this.lvM.getLoadedHeight() != 0) {
                                c.this.width = c.this.lvM.getLoadedWidth();
                                c.this.height = c.this.lvM.getLoadedHeight();
                                if (c.this.lvP != null) {
                                    c.this.lvP.dew().setShareSummaryImgWidth(c.this.width);
                                    c.this.lvP.dew().setShareSummaryImgHeight(c.this.height);
                                    c.this.lvR = true;
                                    c.this.deD();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.lvR = false;
                        c.this.deD();
                        if (c.this.lvP != null) {
                            c.this.lvP.Ex(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.lvR = false;
                        c.this.deD();
                        if (c.this.lvP != null) {
                            c.this.lvP.Ex(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.lvi.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.lvi.getShareSummaryImg() != null && this.lvi.getShareSummaryImg().trim().length() > 0) {
                    this.lvM.startLoad(this.lvi.getShareSummaryImg(), 10, true);
                } else {
                    this.lvR = true;
                    deD();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.lvi.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.lvM.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.lvi.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.lvi.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.aW(as.aWR().getPostImageSize(), as.aWR().getPostImageHeightLimit()));
                    this.lvM.setTag(imageFileInfo.toCachedKey(true));
                    if (this.lvQ.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.lvK.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.lvM.invalidate();
                    }
                }
                this.lvR = true;
                deD();
            }
            this.lvi.setShareSummaryImgType(f.getExtension(this.lvi.getShareSummaryImg()));
            this.lvN.setText(this.lvi.getShareSummaryTitle());
            this.lvO.setText(this.lvi.getShareSummaryContent());
        }
    }

    private void deB() {
        this.lvJ = this.lvP.findViewById(R.id.post_prefix_layout);
        this.lvG = (TextView) this.lvP.findViewById(R.id.post_prefix);
        this.lvI = (ImageView) this.lvP.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.lvJ.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.lvG.setText(prefixs.get(0));
            this.lvP.Ey(0);
            this.lvJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.lvG.setVisibility(0);
                    c.this.lvJ.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.lvH, view, l.dip2px(c.this.lvP.getPageContext().getContext(), 15.0f), l.dip2px(c.this.lvP.getPageContext().getContext(), 1.0f));
                    if (c.this.lvP != null) {
                        c.this.lvP.dez();
                    }
                }
            });
            this.lvI = (ImageView) this.lvP.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.lvI.setVisibility(0);
                this.lvG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.lvG.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.lvH, view, l.dip2px(c.this.lvP.getPageContext().getContext(), 15.0f), l.dip2px(c.this.lvP.getPageContext().getContext(), 1.0f));
                        if (c.this.lvP != null) {
                            c.this.lvP.dez();
                        }
                    }
                });
            }
            this.lvH = new i(this.lvP.getPageContext().getContext());
            this.lvH.setMaxHeight(l.dip2px(this.lvP.getPageContext().getContext(), 225.0f));
            this.lvH.setOutsideTouchable(true);
            this.lvH.setFocusable(true);
            this.lvH.setBackgroundDrawable(an.getDrawable(R.color.cp_bg_line_c));
            this.lvH.a(new i.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.i.a
                public void Ez(int i) {
                    c.this.lvP.Ey(i);
                    c.this.lvG.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.lvH.setCurrentIndex(i);
                    c.this.deD();
                    g.dismissPopupWindow(c.this.lvH, c.this.lvP.getPageContext().getPageActivity());
                }
            });
            this.lvH.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.lvJ.setSelected(false);
                }
            });
            int color = an.getColor(R.color.common_color_10097);
            an.setBackgroundResource(this.lvG, R.drawable.write_prefix_item_selector);
            an.setImageResource(this.lvI, R.drawable.icon_title_down);
            this.lvG.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.lvP.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.lvP.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                an.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.lvP.getPageContext().getContext(), this.lvP.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.lvP.getPageContext().getContext(), this.lvP.getResources().getDimension(R.dimen.ds22)), 0);
                this.lvH.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.lvP.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.lvP.getPageContext().getContext(), this.lvP.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.lvP.getPageContext().getContext(), this.lvP.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.lvH.setCurrentIndex(0);
            return;
        }
        this.lvJ.setVisibility(8);
    }

    protected void deC() {
        this.lvA = (EditText) this.lvP.findViewById(R.id.post_title);
        if (this.lvi.getType() == 3) {
            if (this.lvi.getTitle() != null && this.lvi.getTitle().trim().length() > 0) {
                this.lvA.setText(this.lvi.getTitle());
                this.lvA.setSelection(this.lvi.getTitle().length());
            } else {
                String str = this.lvP.getPageContext().getString(R.string.share_transfer_thread) + this.lvi.getShareSummaryTitle();
                this.lvA.setText(str);
                if (str.length() < 20) {
                    this.lvA.setSelection(str.length());
                } else {
                    this.lvA.setSelection(20);
                }
            }
        }
        this.lvA.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.deD();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void deD() {
        String str = null;
        if (this.lvi.getType() == 3) {
            String trim = this.lvA.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.lvP.dex() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.lvi.setIsNoTitle(true);
                    } else {
                        this.lvi.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.lvi.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.lvi.setIsNoTitle(true);
            } else {
                this.lvi.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.lvR) {
            this.lvF.setEnabled(false);
        } else {
            this.lvF.setEnabled(true);
        }
    }

    protected void deE() {
        this.lvE = (EditText) this.lvP.findViewById(R.id.post_content);
        this.lvE.setDrawingCacheEnabled(false);
        if (this.lvi.getContent() != null && this.lvi.getContent().length() > 0) {
            SpannableString ak = TbFaceManager.bgy().ak(this.lvP.getPageContext().getContext(), this.lvi.getContent());
            this.lvE.setText(ak);
            this.lvE.setSelection(ak.length());
        }
        this.lvE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.lvE.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.deD();
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

    public EditText deF() {
        return this.lvA;
    }

    public EditText deG() {
        return this.lvE;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        deB();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.lvA.setOnFocusChangeListener(onFocusChangeListener);
        this.lvE.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.lvF.setOnFocusChangeListener(onFocusChangeListener);
    }

    public i deH() {
        return this.lvH;
    }

    public View deI() {
        return this.mBack;
    }

    public TextView deJ() {
        return this.lvF;
    }

    public TextView deK() {
        return this.lvG;
    }

    public void ac(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ad(View.OnClickListener onClickListener) {
        this.lvF.setOnClickListener(onClickListener);
    }

    public void ae(View.OnClickListener onClickListener) {
        this.lvD.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.lvP != null) {
            this.lvP.getLayoutMode().setNightMode(i == 1);
            this.lvP.getLayoutMode().onModeChanged(this.iKg);
            this.mNavigationBar.onChangeSkinType(this.lvP.getPageContext(), i);
            an.setTopBarCommonFinishButton(this.lvF, i);
            an.setBackgroundColor(this.lvB, R.color.cp_bg_line_c);
            an.setBackgroundColor(this.lvC, R.color.cp_bg_line_c);
            an.setBackgroundColor(this.lvA, R.color.cp_cont_g);
            an.setBackgroundColor(this.lvL, R.color.cp_bg_line_e);
            int color = an.getColor(R.color.cp_cont_b);
            int color2 = an.getColor(R.color.cp_cont_e);
            this.lvA.setTextColor(color);
            this.lvE.setTextColor(color);
            this.lvN.setTextColor(an.getColor(R.color.cp_cont_b));
            this.lvO.setTextColor(an.getColor(R.color.cp_cont_d));
            f(this.lvA, color2);
            f(this.lvE, color2);
            deD();
        }
    }

    public ShareSDKImageView deL() {
        return this.lvM;
    }
}
