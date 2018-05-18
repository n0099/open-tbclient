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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.write.d;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class c {
    private View gmT;
    private TextView gmW;
    private d gmX;
    private ImageView gmY;
    private View gmZ;
    private LinearLayout gna;
    private LinearLayout gnb;
    private ShareSDKImageView gnc;
    private TextView gnd;
    private TextView gne;
    private WriteShareActivity gnf;
    private com.baidu.tbadk.img.b gng;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View asg = null;
    private EditText gmR = null;
    private View gmS = null;
    private LinearLayout gmU = null;
    private EditText gmV = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean gnh = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.gnf = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.gng == null) {
            this.gng = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.gnf.findViewById(d.g.view_navigation_bar);
        this.asg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gnf.getPageContext().getString(d.k.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gnf.getPageContext().getString(d.k.send_post));
        this.mParent = (RelativeLayout) this.gnf.findViewById(d.g.parent);
        this.gmS = this.gnf.findViewById(d.g.interval_view);
        this.gmT = this.gnf.findViewById(d.g.prefix_interval_view);
        this.gna = (LinearLayout) this.gnf.findViewById(d.g.post_share_layout);
        this.gnb = (LinearLayout) this.gnf.findViewById(d.g.post_share_content_layout);
        this.gnc = (ShareSDKImageView) this.gnf.findViewById(d.g.post_share_image);
        this.gnd = (TextView) this.gnf.findViewById(d.g.post_share_title);
        this.gne = (TextView) this.gnf.findViewById(d.g.post_share_content);
        bnP();
        bnR();
        this.gmU = (LinearLayout) this.gnf.findViewById(d.g.post_content_container);
        this.gmU.setDrawingCacheEnabled(false);
        this.gmR.setVisibility(0);
        this.gmV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        bnQ();
    }

    public void bnN() {
        this.gna = (LinearLayout) this.gnf.findViewById(d.g.post_share_layout);
        this.gnc = (ShareSDKImageView) this.gnf.findViewById(d.g.post_share_image);
        this.gnc.setIsRound(false);
        this.gnc.setDrawBorder(false);
        this.gnc.setAutoChangeStyle(true);
        this.gnc.setRadius(0);
        this.gnd = (TextView) this.gnf.findViewById(d.g.post_share_title);
        this.gne = (TextView) this.gnf.findViewById(d.g.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.gnc.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void n(String str, boolean z) {
                        if (z) {
                            if (c.this.gnc.getLoadedWidth() != 0 && c.this.gnc.getLoadedHeight() != 0) {
                                c.this.width = c.this.gnc.getLoadedWidth();
                                c.this.height = c.this.gnc.getLoadedHeight();
                                if (c.this.gnf != null) {
                                    c.this.gnf.getWriteData().setShareSummaryImgWidth(c.this.width);
                                    c.this.gnf.getWriteData().setShareSummaryImgHeight(c.this.height);
                                    c.this.gnh = true;
                                    c.this.bnQ();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.gnh = false;
                        c.this.bnQ();
                        if (c.this.gnf != null) {
                            c.this.gnf.sL(d.k.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.gnh = false;
                        c.this.bnQ();
                        if (c.this.gnf != null) {
                            c.this.gnf.sL(d.k.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.gnc.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.gnh = true;
                    bnQ();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.gnc.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(k.b(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.G(ap.vP().vV(), ap.vP().vW()));
                    this.gnc.setTag(imageFileInfo.toCachedKey(true));
                    if (this.gng.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.gna.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.gnc.invalidate();
                    }
                }
                this.gnh = true;
                bnQ();
            }
            this.mData.setShareSummaryImgType(f.aK(this.mData.getShareSummaryImg()));
            this.gnd.setText(this.mData.getShareSummaryTitle());
            this.gne.setText(this.mData.getShareSummaryContent());
        }
    }

    private void bnO() {
        this.gmZ = this.gnf.findViewById(d.g.post_prefix_layout);
        this.gmW = (TextView) this.gnf.findViewById(d.g.post_prefix);
        this.gmY = (ImageView) this.gnf.findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.gmZ.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gmW.setText(prefixs.get(0));
            this.gnf.sM(0);
            this.gmZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.gmW.setVisibility(0);
                    c.this.gmZ.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.gmX, view2, l.dip2px(c.this.gnf.getPageContext().getContext(), 15.0f), l.dip2px(c.this.gnf.getPageContext().getContext(), 1.0f));
                    if (c.this.gnf != null) {
                        c.this.gnf.bnM();
                    }
                }
            });
            this.gmY = (ImageView) this.gnf.findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gmY.setVisibility(0);
                this.gmW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        c.this.gmW.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.gmX, view2, l.dip2px(c.this.gnf.getPageContext().getContext(), 15.0f), l.dip2px(c.this.gnf.getPageContext().getContext(), 1.0f));
                        if (c.this.gnf != null) {
                            c.this.gnf.bnM();
                        }
                    }
                });
            }
            this.gmX = new com.baidu.tieba.write.d(this.gnf.getPageContext().getContext());
            this.gmX.setMaxHeight(l.dip2px(this.gnf.getPageContext().getContext(), 225.0f));
            this.gmX.setOutsideTouchable(true);
            this.gmX.setFocusable(true);
            this.gmX.setBackgroundDrawable(ak.getDrawable(d.C0126d.cp_bg_line_b));
            this.gmX.a(new d.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.d.a
                public void sN(int i) {
                    c.this.gnf.sM(i);
                    c.this.gmW.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.gmX.setCurrentIndex(i);
                    c.this.bnQ();
                    g.a(c.this.gmX, c.this.gnf.getPageContext().getPageActivity());
                }
            });
            this.gmX.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.gmZ.setSelected(false);
                }
            });
            int color = ak.getColor(d.C0126d.common_color_10097);
            ak.i(this.gmW, d.f.write_prefix_item_selector);
            ak.c(this.gmY, d.f.icon_title_down);
            this.gmW.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.gnf.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.gnf.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ak.i(textView, d.f.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.gnf.getPageContext().getContext(), this.gnf.getResources().getDimension(d.e.ds6)), 0, l.dip2px(this.gnf.getPageContext().getContext(), this.gnf.getResources().getDimension(d.e.ds22)), 0);
                this.gmX.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.gnf.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.gnf.getPageContext().getContext(), this.gnf.getResources().getDimension(d.e.ds6)), 0, l.dip2px(this.gnf.getPageContext().getContext(), this.gnf.getResources().getDimension(d.e.ds22)), 0);
                }
            }
            this.gmX.setCurrentIndex(0);
            return;
        }
        this.gmZ.setVisibility(8);
    }

    protected void bnP() {
        this.gmR = (EditText) this.gnf.findViewById(d.g.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.gmR.setText(this.mData.getTitle());
                this.gmR.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.gnf.getPageContext().getString(d.k.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.gmR.setText(str);
                if (str.length() < 20) {
                    this.gmR.setSelection(str.length());
                } else {
                    this.gmR.setSelection(20);
                }
            }
        }
        this.gmR.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.bnQ();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void bnQ() {
        String str = null;
        if (this.mData.getType() == 3) {
            String trim = this.gmR.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.gnf.bnK() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.gnh) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void bnR() {
        this.gmV = (EditText) this.gnf.findViewById(d.g.post_content);
        this.gmV.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString R = TbFaceManager.EX().R(this.gnf.getPageContext().getContext(), this.mData.getContent());
            this.gmV.setText(R);
            this.gmV.setSelection(R.length());
        }
        this.gmV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view2.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gmV.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.bnQ();
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

    public EditText bnS() {
        return this.gmR;
    }

    public EditText bnT() {
        return this.gmV;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        bnO();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.gmR.setOnFocusChangeListener(onFocusChangeListener);
        this.gmV.setOnFocusChangeListener(onFocusChangeListener);
        this.asg.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public com.baidu.tieba.write.d bnU() {
        return this.gmX;
    }

    public View bnV() {
        return this.asg;
    }

    public TextView bnW() {
        return this.mPost;
    }

    public TextView bnX() {
        return this.gmW;
    }

    public void S(View.OnClickListener onClickListener) {
        this.asg.setOnClickListener(onClickListener);
    }

    public void T(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void U(View.OnClickListener onClickListener) {
        this.gmU.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.gnf != null) {
            this.gnf.getLayoutMode().setNightMode(i == 1);
            this.gnf.getLayoutMode().u(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.gnf.getPageContext(), i);
            ak.d(this.mPost, i);
            ak.j(this.gmS, d.C0126d.cp_bg_line_c);
            ak.j(this.gmT, d.C0126d.cp_bg_line_c);
            ak.j(this.gmR, d.C0126d.cp_cont_g);
            ak.j(this.gnb, d.C0126d.cp_bg_line_e);
            int color = ak.getColor(d.C0126d.cp_cont_b);
            int color2 = ak.getColor(d.C0126d.cp_cont_e);
            this.gmR.setTextColor(color);
            this.gmV.setTextColor(color);
            this.gnd.setTextColor(ak.getColor(d.C0126d.cp_cont_b));
            this.gne.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
            b(this.gmR, color2);
            b(this.gmV, color2);
            bnQ();
        }
    }

    public ShareSDKImageView bnY() {
        return this.gnc;
    }
}
