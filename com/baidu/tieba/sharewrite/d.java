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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.write.e;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class d {
    private View gQK;
    private TextView gQN;
    private e gQO;
    private ImageView gQP;
    private View gQQ;
    private LinearLayout gQR;
    private LinearLayout gQS;
    private c gQT;
    private TextView gQU;
    private TextView gQV;
    private WriteShareActivity gQW;
    private com.baidu.tbadk.img.b gQX;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View bgB = null;
    private EditText gQI = null;
    private View gQJ = null;
    private LinearLayout gQL = null;
    private EditText gQM = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean gQY = false;
    private int width = 0;
    private int height = 0;

    public d(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.gQW = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.gQX == null) {
            this.gQX = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.gQW.findViewById(d.g.view_navigation_bar);
        this.bgB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gQW.getPageContext().getString(d.j.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gQW.getPageContext().getString(d.j.send_post));
        this.mParent = (RelativeLayout) this.gQW.findViewById(d.g.parent);
        this.gQJ = this.gQW.findViewById(d.g.interval_view);
        this.gQK = this.gQW.findViewById(d.g.prefix_interval_view);
        this.gQR = (LinearLayout) this.gQW.findViewById(d.g.post_share_layout);
        this.gQS = (LinearLayout) this.gQW.findViewById(d.g.post_share_content_layout);
        this.gQT = (c) this.gQW.findViewById(d.g.post_share_image);
        this.gQU = (TextView) this.gQW.findViewById(d.g.post_share_title);
        this.gQV = (TextView) this.gQW.findViewById(d.g.post_share_content);
        bsI();
        bsK();
        this.gQL = (LinearLayout) this.gQW.findViewById(d.g.post_content_container);
        this.gQL.setDrawingCacheEnabled(false);
        this.gQI.setVisibility(0);
        this.gQM.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        bsJ();
    }

    public void bsG() {
        this.gQR = (LinearLayout) this.gQW.findViewById(d.g.post_share_layout);
        this.gQT = (c) this.gQW.findViewById(d.g.post_share_image);
        this.gQT.setIsRound(false);
        this.gQT.setDrawBorder(false);
        this.gQT.setAutoChangeStyle(true);
        this.gQT.setRadius(0);
        this.gQU = (TextView) this.gQW.findViewById(d.g.post_share_title);
        this.gQV = (TextView) this.gQW.findViewById(d.g.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.gQT.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.d.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void p(String str, boolean z) {
                        if (z) {
                            if (d.this.gQT.getLoadedWidth() != 0 && d.this.gQT.getLoadedHeight() != 0) {
                                d.this.width = d.this.gQT.getLoadedWidth();
                                d.this.height = d.this.gQT.getLoadedHeight();
                                if (d.this.gQW != null) {
                                    d.this.gQW.getWriteData().setShareSummaryImgWidth(d.this.width);
                                    d.this.gQW.getWriteData().setShareSummaryImgHeight(d.this.height);
                                    d.this.gQY = true;
                                    d.this.bsJ();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        d.this.gQY = false;
                        d.this.bsJ();
                        if (d.this.gQW != null) {
                            d.this.gQW.vk(d.j.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        d.this.gQY = false;
                        d.this.bsJ();
                        if (d.this.gQW != null) {
                            d.this.gQW.vk(d.j.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.gQT.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.gQY = true;
                    bsJ();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.gQT.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(k.n(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.aI(ao.De().Dk(), ao.De().Dl()));
                    this.gQT.setTag(imageFileInfo.toCachedKey(true));
                    if (this.gQX.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.d.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) d.this.gQR.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.gQT.invalidate();
                    }
                }
                this.gQY = true;
                bsJ();
            }
            this.mData.setShareSummaryImgType(f.aN(this.mData.getShareSummaryImg()));
            this.gQU.setText(this.mData.getShareSummaryTitle());
            this.gQV.setText(this.mData.getShareSummaryContent());
        }
    }

    private void bsH() {
        this.gQQ = this.gQW.findViewById(d.g.post_prefix_layout);
        this.gQN = (TextView) this.gQW.findViewById(d.g.post_prefix);
        this.gQP = (ImageView) this.gQW.findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.gQQ.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gQN.setText(prefixs.get(0));
            this.gQW.vl(0);
            this.gQQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.gQN.setVisibility(0);
                    d.this.gQQ.setSelected(true);
                    g.showPopupWindowAsDropDown(d.this.gQO, view, l.dip2px(d.this.gQW.getPageContext().getContext(), 15.0f), l.dip2px(d.this.gQW.getPageContext().getContext(), 1.0f));
                    if (d.this.gQW != null) {
                        d.this.gQW.bsF();
                    }
                }
            });
            this.gQP = (ImageView) this.gQW.findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gQP.setVisibility(0);
                this.gQN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.gQN.setSelected(true);
                        g.showPopupWindowAsDropDown(d.this.gQO, view, l.dip2px(d.this.gQW.getPageContext().getContext(), 15.0f), l.dip2px(d.this.gQW.getPageContext().getContext(), 1.0f));
                        if (d.this.gQW != null) {
                            d.this.gQW.bsF();
                        }
                    }
                });
            }
            this.gQO = new e(this.gQW.getPageContext().getContext());
            this.gQO.setMaxHeight(l.dip2px(this.gQW.getPageContext().getContext(), 225.0f));
            this.gQO.setOutsideTouchable(true);
            this.gQO.setFocusable(true);
            this.gQO.setBackgroundDrawable(aj.getDrawable(d.C0141d.cp_bg_line_b));
            this.gQO.a(new e.a() { // from class: com.baidu.tieba.sharewrite.d.5
                @Override // com.baidu.tieba.write.e.a
                public void vm(int i) {
                    d.this.gQW.vl(i);
                    d.this.gQN.setText(d.this.mPrefixData.getPrefixs().get(i));
                    d.this.gQO.setCurrentIndex(i);
                    d.this.bsJ();
                    g.a(d.this.gQO, d.this.gQW.getPageContext().getPageActivity());
                }
            });
            this.gQO.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.d.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    d.this.gQQ.setSelected(false);
                }
            });
            int color = aj.getColor(d.C0141d.common_color_10097);
            aj.s(this.gQN, d.f.write_prefix_item_selector);
            aj.c(this.gQP, d.f.icon_title_down);
            this.gQN.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.gQW.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.gQW.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                aj.s(textView, d.f.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.gQW.getPageContext().getContext(), this.gQW.getResources().getDimension(d.e.ds6)), 0, l.dip2px(this.gQW.getPageContext().getContext(), this.gQW.getResources().getDimension(d.e.ds22)), 0);
                this.gQO.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.gQW.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.gQW.getPageContext().getContext(), this.gQW.getResources().getDimension(d.e.ds6)), 0, l.dip2px(this.gQW.getPageContext().getContext(), this.gQW.getResources().getDimension(d.e.ds22)), 0);
                }
            }
            this.gQO.setCurrentIndex(0);
            return;
        }
        this.gQQ.setVisibility(8);
    }

    protected void bsI() {
        this.gQI = (EditText) this.gQW.findViewById(d.g.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.gQI.setText(this.mData.getTitle());
                this.gQI.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.gQW.getPageContext().getString(d.j.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.gQI.setText(str);
                if (str.length() < 20) {
                    this.gQI.setSelection(str.length());
                } else {
                    this.gQI.setSelection(20);
                }
            }
        }
        this.gQI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.d.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.bsJ();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void bsJ() {
        String str = null;
        if (this.mData.getType() == 3) {
            String trim = this.gQI.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.gQW.bsD() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.gQY) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void bsK() {
        this.gQM = (EditText) this.gQW.findViewById(d.g.post_content);
        this.gQM.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString W = TbFaceManager.Mw().W(this.gQW.getPageContext().getContext(), this.mData.getContent());
            this.gQM.setText(W);
            this.gQM.setSelection(W.length());
        }
        this.gQM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.d.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gQM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.d.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.bsJ();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    private void b(EditText editText, int i) {
        Editable text = editText.getText();
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        editText.setText((CharSequence) null);
        editText.setHintTextColor(i);
        editText.setText(text);
        editText.setSelection(selectionStart, selectionEnd);
    }

    public EditText bsL() {
        return this.gQI;
    }

    public EditText bsM() {
        return this.gQM;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        bsH();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.gQI.setOnFocusChangeListener(onFocusChangeListener);
        this.gQM.setOnFocusChangeListener(onFocusChangeListener);
        this.bgB.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public e bsN() {
        return this.gQO;
    }

    public View bsO() {
        return this.bgB;
    }

    public TextView bsP() {
        return this.mPost;
    }

    public TextView bsQ() {
        return this.gQN;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.bgB.setOnClickListener(onClickListener);
    }

    public void R(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void S(View.OnClickListener onClickListener) {
        this.gQL.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.gQW != null) {
            this.gQW.getLayoutMode().aQ(i == 1);
            this.gQW.getLayoutMode().aM(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.gQW.getPageContext(), i);
            aj.e(this.mPost, i);
            aj.t(this.gQJ, d.C0141d.cp_bg_line_c);
            aj.t(this.gQK, d.C0141d.cp_bg_line_c);
            aj.t(this.gQI, d.C0141d.cp_cont_g);
            aj.t(this.gQS, d.C0141d.cp_bg_line_e);
            int color = aj.getColor(d.C0141d.cp_cont_b);
            int color2 = aj.getColor(d.C0141d.cp_cont_e);
            this.gQI.setTextColor(color);
            this.gQM.setTextColor(color);
            this.gQU.setTextColor(aj.getColor(d.C0141d.cp_cont_b));
            this.gQV.setTextColor(aj.getColor(d.C0141d.cp_cont_d));
            b(this.gQI, color2);
            b(this.gQM, color2);
            bsJ();
        }
    }

    public c bsR() {
        return this.gQT;
    }
}
