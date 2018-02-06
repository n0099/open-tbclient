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
    private View gQJ;
    private TextView gQM;
    private e gQN;
    private ImageView gQO;
    private View gQP;
    private LinearLayout gQQ;
    private LinearLayout gQR;
    private c gQS;
    private TextView gQT;
    private TextView gQU;
    private WriteShareActivity gQV;
    private com.baidu.tbadk.img.b gQW;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View bgK = null;
    private EditText gQH = null;
    private View gQI = null;
    private LinearLayout gQK = null;
    private EditText gQL = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean gQX = false;
    private int width = 0;
    private int height = 0;

    public d(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.gQV = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.gQW == null) {
            this.gQW = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.gQV.findViewById(d.g.view_navigation_bar);
        this.bgK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gQV.getPageContext().getString(d.j.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gQV.getPageContext().getString(d.j.send_post));
        this.mParent = (RelativeLayout) this.gQV.findViewById(d.g.parent);
        this.gQI = this.gQV.findViewById(d.g.interval_view);
        this.gQJ = this.gQV.findViewById(d.g.prefix_interval_view);
        this.gQQ = (LinearLayout) this.gQV.findViewById(d.g.post_share_layout);
        this.gQR = (LinearLayout) this.gQV.findViewById(d.g.post_share_content_layout);
        this.gQS = (c) this.gQV.findViewById(d.g.post_share_image);
        this.gQT = (TextView) this.gQV.findViewById(d.g.post_share_title);
        this.gQU = (TextView) this.gQV.findViewById(d.g.post_share_content);
        bsI();
        bsK();
        this.gQK = (LinearLayout) this.gQV.findViewById(d.g.post_content_container);
        this.gQK.setDrawingCacheEnabled(false);
        this.gQH.setVisibility(0);
        this.gQL.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        bsJ();
    }

    public void bsG() {
        this.gQQ = (LinearLayout) this.gQV.findViewById(d.g.post_share_layout);
        this.gQS = (c) this.gQV.findViewById(d.g.post_share_image);
        this.gQS.setIsRound(false);
        this.gQS.setDrawBorder(false);
        this.gQS.setAutoChangeStyle(true);
        this.gQS.setRadius(0);
        this.gQT = (TextView) this.gQV.findViewById(d.g.post_share_title);
        this.gQU = (TextView) this.gQV.findViewById(d.g.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.gQS.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.d.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void q(String str, boolean z) {
                        if (z) {
                            if (d.this.gQS.getLoadedWidth() != 0 && d.this.gQS.getLoadedHeight() != 0) {
                                d.this.width = d.this.gQS.getLoadedWidth();
                                d.this.height = d.this.gQS.getLoadedHeight();
                                if (d.this.gQV != null) {
                                    d.this.gQV.getWriteData().setShareSummaryImgWidth(d.this.width);
                                    d.this.gQV.getWriteData().setShareSummaryImgHeight(d.this.height);
                                    d.this.gQX = true;
                                    d.this.bsJ();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        d.this.gQX = false;
                        d.this.bsJ();
                        if (d.this.gQV != null) {
                            d.this.gQV.vj(d.j.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        d.this.gQX = false;
                        d.this.bsJ();
                        if (d.this.gQV != null) {
                            d.this.gQV.vj(d.j.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.gQS.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.gQX = true;
                    bsJ();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.gQS.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(k.n(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.aI(ao.De().Dk(), ao.De().Dl()));
                    this.gQS.setTag(imageFileInfo.toCachedKey(true));
                    if (this.gQW.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.d.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) d.this.gQQ.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.gQS.invalidate();
                    }
                }
                this.gQX = true;
                bsJ();
            }
            this.mData.setShareSummaryImgType(f.aN(this.mData.getShareSummaryImg()));
            this.gQT.setText(this.mData.getShareSummaryTitle());
            this.gQU.setText(this.mData.getShareSummaryContent());
        }
    }

    private void bsH() {
        this.gQP = this.gQV.findViewById(d.g.post_prefix_layout);
        this.gQM = (TextView) this.gQV.findViewById(d.g.post_prefix);
        this.gQO = (ImageView) this.gQV.findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.gQP.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gQM.setText(prefixs.get(0));
            this.gQV.vk(0);
            this.gQP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.gQM.setVisibility(0);
                    d.this.gQP.setSelected(true);
                    g.showPopupWindowAsDropDown(d.this.gQN, view, l.dip2px(d.this.gQV.getPageContext().getContext(), 15.0f), l.dip2px(d.this.gQV.getPageContext().getContext(), 1.0f));
                    if (d.this.gQV != null) {
                        d.this.gQV.bsF();
                    }
                }
            });
            this.gQO = (ImageView) this.gQV.findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gQO.setVisibility(0);
                this.gQM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.gQM.setSelected(true);
                        g.showPopupWindowAsDropDown(d.this.gQN, view, l.dip2px(d.this.gQV.getPageContext().getContext(), 15.0f), l.dip2px(d.this.gQV.getPageContext().getContext(), 1.0f));
                        if (d.this.gQV != null) {
                            d.this.gQV.bsF();
                        }
                    }
                });
            }
            this.gQN = new e(this.gQV.getPageContext().getContext());
            this.gQN.setMaxHeight(l.dip2px(this.gQV.getPageContext().getContext(), 225.0f));
            this.gQN.setOutsideTouchable(true);
            this.gQN.setFocusable(true);
            this.gQN.setBackgroundDrawable(aj.getDrawable(d.C0140d.cp_bg_line_b));
            this.gQN.a(new e.a() { // from class: com.baidu.tieba.sharewrite.d.5
                @Override // com.baidu.tieba.write.e.a
                public void vl(int i) {
                    d.this.gQV.vk(i);
                    d.this.gQM.setText(d.this.mPrefixData.getPrefixs().get(i));
                    d.this.gQN.setCurrentIndex(i);
                    d.this.bsJ();
                    g.a(d.this.gQN, d.this.gQV.getPageContext().getPageActivity());
                }
            });
            this.gQN.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.d.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    d.this.gQP.setSelected(false);
                }
            });
            int color = aj.getColor(d.C0140d.common_color_10097);
            aj.s(this.gQM, d.f.write_prefix_item_selector);
            aj.c(this.gQO, d.f.icon_title_down);
            this.gQM.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.gQV.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.gQV.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                aj.s(textView, d.f.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.gQV.getPageContext().getContext(), this.gQV.getResources().getDimension(d.e.ds6)), 0, l.dip2px(this.gQV.getPageContext().getContext(), this.gQV.getResources().getDimension(d.e.ds22)), 0);
                this.gQN.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.gQV.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.gQV.getPageContext().getContext(), this.gQV.getResources().getDimension(d.e.ds6)), 0, l.dip2px(this.gQV.getPageContext().getContext(), this.gQV.getResources().getDimension(d.e.ds22)), 0);
                }
            }
            this.gQN.setCurrentIndex(0);
            return;
        }
        this.gQP.setVisibility(8);
    }

    protected void bsI() {
        this.gQH = (EditText) this.gQV.findViewById(d.g.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.gQH.setText(this.mData.getTitle());
                this.gQH.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.gQV.getPageContext().getString(d.j.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.gQH.setText(str);
                if (str.length() < 20) {
                    this.gQH.setSelection(str.length());
                } else {
                    this.gQH.setSelection(20);
                }
            }
        }
        this.gQH.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.d.7
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
            String trim = this.gQH.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.gQV.bsD() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.gQX) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void bsK() {
        this.gQL = (EditText) this.gQV.findViewById(d.g.post_content);
        this.gQL.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString W = TbFaceManager.Mw().W(this.gQV.getPageContext().getContext(), this.mData.getContent());
            this.gQL.setText(W);
            this.gQL.setSelection(W.length());
        }
        this.gQL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.d.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gQL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.d.9
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
        return this.gQH;
    }

    public EditText bsM() {
        return this.gQL;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        bsH();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.gQH.setOnFocusChangeListener(onFocusChangeListener);
        this.gQL.setOnFocusChangeListener(onFocusChangeListener);
        this.bgK.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public e bsN() {
        return this.gQN;
    }

    public View bsO() {
        return this.bgK;
    }

    public TextView bsP() {
        return this.mPost;
    }

    public TextView bsQ() {
        return this.gQM;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.bgK.setOnClickListener(onClickListener);
    }

    public void R(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void S(View.OnClickListener onClickListener) {
        this.gQK.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.gQV != null) {
            this.gQV.getLayoutMode().aQ(i == 1);
            this.gQV.getLayoutMode().aM(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.gQV.getPageContext(), i);
            aj.e(this.mPost, i);
            aj.t(this.gQI, d.C0140d.cp_bg_line_c);
            aj.t(this.gQJ, d.C0140d.cp_bg_line_c);
            aj.t(this.gQH, d.C0140d.cp_cont_g);
            aj.t(this.gQR, d.C0140d.cp_bg_line_e);
            int color = aj.getColor(d.C0140d.cp_cont_b);
            int color2 = aj.getColor(d.C0140d.cp_cont_e);
            this.gQH.setTextColor(color);
            this.gQL.setTextColor(color);
            this.gQT.setTextColor(aj.getColor(d.C0140d.cp_cont_b));
            this.gQU.setTextColor(aj.getColor(d.C0140d.cp_cont_d));
            b(this.gQH, color2);
            b(this.gQL, color2);
            bsJ();
        }
    }

    public c bsR() {
        return this.gQS;
    }
}
