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
import com.baidu.tbadk.core.util.as;
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
    private View iWH;
    private TextView iWK;
    private h iWL;
    private ImageView iWM;
    private View iWN;
    private LinearLayout iWO;
    private LinearLayout iWP;
    private ShareSDKImageView iWQ;
    private TextView iWR;
    private TextView iWS;
    private WriteShareActivity iWT;
    private com.baidu.tbadk.img.b iWU;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View cfi = null;
    private EditText iWF = null;
    private View iWG = null;
    private LinearLayout iWI = null;
    private EditText iWJ = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean iWV = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.iWT = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.iWU == null) {
            this.iWU = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.iWT.findViewById(R.id.view_navigation_bar);
        this.cfi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iWT.getPageContext().getString(R.string.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iWT.getPageContext().getString(R.string.send_post));
        this.mParent = (RelativeLayout) this.iWT.findViewById(R.id.parent);
        this.iWG = this.iWT.findViewById(R.id.interval_view);
        this.iWH = this.iWT.findViewById(R.id.prefix_interval_view);
        this.iWO = (LinearLayout) this.iWT.findViewById(R.id.post_share_layout);
        this.iWP = (LinearLayout) this.iWT.findViewById(R.id.post_share_content_layout);
        this.iWQ = (ShareSDKImageView) this.iWT.findViewById(R.id.post_share_image);
        this.iWR = (TextView) this.iWT.findViewById(R.id.post_share_title);
        this.iWS = (TextView) this.iWT.findViewById(R.id.post_share_content);
        cmF();
        cmH();
        this.iWI = (LinearLayout) this.iWT.findViewById(R.id.post_content_container);
        this.iWI.setDrawingCacheEnabled(false);
        this.iWF.setVisibility(0);
        this.iWJ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        cmG();
    }

    public void cmD() {
        this.iWO = (LinearLayout) this.iWT.findViewById(R.id.post_share_layout);
        this.iWQ = (ShareSDKImageView) this.iWT.findViewById(R.id.post_share_image);
        this.iWQ.setIsRound(false);
        this.iWQ.setDrawBorder(false);
        this.iWQ.setAutoChangeStyle(true);
        this.iWQ.setRadius(0);
        this.iWR = (TextView) this.iWT.findViewById(R.id.post_share_title);
        this.iWS = (TextView) this.iWT.findViewById(R.id.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.iWQ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void P(String str, boolean z) {
                        if (z) {
                            if (c.this.iWQ.getLoadedWidth() != 0 && c.this.iWQ.getLoadedHeight() != 0) {
                                c.this.width = c.this.iWQ.getLoadedWidth();
                                c.this.height = c.this.iWQ.getLoadedHeight();
                                if (c.this.iWT != null) {
                                    c.this.iWT.getWriteData().setShareSummaryImgWidth(c.this.width);
                                    c.this.iWT.getWriteData().setShareSummaryImgHeight(c.this.height);
                                    c.this.iWV = true;
                                    c.this.cmG();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.iWV = false;
                        c.this.cmG();
                        if (c.this.iWT != null) {
                            c.this.iWT.AJ(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.iWV = false;
                        c.this.cmG();
                        if (c.this.iWT != null) {
                            c.this.iWT.AJ(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.iWQ.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.iWV = true;
                    cmG();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.iWQ.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(m.b(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.al(as.ajq().ajw(), as.ajq().ajx()));
                    this.iWQ.setTag(imageFileInfo.toCachedKey(true));
                    if (this.iWU.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.iWO.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.iWQ.invalidate();
                    }
                }
                this.iWV = true;
                cmG();
            }
            this.mData.setShareSummaryImgType(f.ba(this.mData.getShareSummaryImg()));
            this.iWR.setText(this.mData.getShareSummaryTitle());
            this.iWS.setText(this.mData.getShareSummaryContent());
        }
    }

    private void cmE() {
        this.iWN = this.iWT.findViewById(R.id.post_prefix_layout);
        this.iWK = (TextView) this.iWT.findViewById(R.id.post_prefix);
        this.iWM = (ImageView) this.iWT.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.iWN.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iWK.setText(prefixs.get(0));
            this.iWT.AK(0);
            this.iWN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.iWK.setVisibility(0);
                    c.this.iWN.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.iWL, view, l.dip2px(c.this.iWT.getPageContext().getContext(), 15.0f), l.dip2px(c.this.iWT.getPageContext().getContext(), 1.0f));
                    if (c.this.iWT != null) {
                        c.this.iWT.cmC();
                    }
                }
            });
            this.iWM = (ImageView) this.iWT.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.iWM.setVisibility(0);
                this.iWK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.iWK.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.iWL, view, l.dip2px(c.this.iWT.getPageContext().getContext(), 15.0f), l.dip2px(c.this.iWT.getPageContext().getContext(), 1.0f));
                        if (c.this.iWT != null) {
                            c.this.iWT.cmC();
                        }
                    }
                });
            }
            this.iWL = new h(this.iWT.getPageContext().getContext());
            this.iWL.setMaxHeight(l.dip2px(this.iWT.getPageContext().getContext(), 225.0f));
            this.iWL.setOutsideTouchable(true);
            this.iWL.setFocusable(true);
            this.iWL.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_b));
            this.iWL.a(new h.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.h.a
                public void AL(int i) {
                    c.this.iWT.AK(i);
                    c.this.iWK.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.iWL.setCurrentIndex(i);
                    c.this.cmG();
                    g.a(c.this.iWL, c.this.iWT.getPageContext().getPageActivity());
                }
            });
            this.iWL.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.iWN.setSelected(false);
                }
            });
            int color = am.getColor(R.color.common_color_10097);
            am.k(this.iWK, R.drawable.write_prefix_item_selector);
            am.c(this.iWM, (int) R.drawable.icon_title_down);
            this.iWK.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.iWT.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.iWT.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                am.k(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.iWT.getPageContext().getContext(), this.iWT.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.iWT.getPageContext().getContext(), this.iWT.getResources().getDimension(R.dimen.ds22)), 0);
                this.iWL.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.iWT.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.iWT.getPageContext().getContext(), this.iWT.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.iWT.getPageContext().getContext(), this.iWT.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.iWL.setCurrentIndex(0);
            return;
        }
        this.iWN.setVisibility(8);
    }

    protected void cmF() {
        this.iWF = (EditText) this.iWT.findViewById(R.id.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.iWF.setText(this.mData.getTitle());
                this.iWF.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.iWT.getPageContext().getString(R.string.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.iWF.setText(str);
                if (str.length() < 20) {
                    this.iWF.setSelection(str.length());
                } else {
                    this.iWF.setSelection(20);
                }
            }
        }
        this.iWF.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cmG();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void cmG() {
        String str = null;
        if (this.mData.getType() == 3) {
            String trim = this.iWF.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.iWT.cmA() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.mData.setIsNoTitle(true);
                    } else {
                        this.mData.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.mData.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.mData.setIsNoTitle(true);
            } else {
                this.mData.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.iWV) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void cmH() {
        this.iWJ = (EditText) this.iWT.findViewById(R.id.post_content);
        this.iWJ.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString ak = TbFaceManager.atx().ak(this.iWT.getPageContext().getContext(), this.mData.getContent());
            this.iWJ.setText(ak);
            this.iWJ.setSelection(ak.length());
        }
        this.iWJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iWJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cmG();
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

    public EditText cmI() {
        return this.iWF;
    }

    public EditText cmJ() {
        return this.iWJ;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        cmE();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.iWF.setOnFocusChangeListener(onFocusChangeListener);
        this.iWJ.setOnFocusChangeListener(onFocusChangeListener);
        this.cfi.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public h cmK() {
        return this.iWL;
    }

    public View cmL() {
        return this.cfi;
    }

    public TextView cmM() {
        return this.mPost;
    }

    public TextView cmN() {
        return this.iWK;
    }

    public void aa(View.OnClickListener onClickListener) {
        this.cfi.setOnClickListener(onClickListener);
    }

    public void ab(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void ac(View.OnClickListener onClickListener) {
        this.iWI.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.iWT != null) {
            this.iWT.getLayoutMode().setNightMode(i == 1);
            this.iWT.getLayoutMode().onModeChanged(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.iWT.getPageContext(), i);
            am.d(this.mPost, i);
            am.l(this.iWG, R.color.cp_bg_line_c);
            am.l(this.iWH, R.color.cp_bg_line_c);
            am.l(this.iWF, R.color.cp_cont_g);
            am.l(this.iWP, R.color.cp_bg_line_e);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_e);
            this.iWF.setTextColor(color);
            this.iWJ.setTextColor(color);
            this.iWR.setTextColor(am.getColor(R.color.cp_cont_b));
            this.iWS.setTextColor(am.getColor(R.color.cp_cont_d));
            f(this.iWF, color2);
            f(this.iWJ, color2);
            cmG();
        }
    }

    public ShareSDKImageView cmO() {
        return this.iWQ;
    }
}
