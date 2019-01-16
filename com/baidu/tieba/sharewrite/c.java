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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.write.d;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class c {
    private View heW;
    private TextView heZ;
    private d hfa;
    private ImageView hfb;
    private View hfc;
    private LinearLayout hfd;
    private LinearLayout hfe;
    private ShareSDKImageView hff;
    private TextView hfg;
    private TextView hfh;
    private WriteShareActivity hfi;
    private com.baidu.tbadk.img.b hfj;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View aNy = null;
    private EditText heU = null;
    private View heV = null;
    private LinearLayout heX = null;
    private EditText heY = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean hfk = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.hfi = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.hfj == null) {
            this.hfj = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.hfi.findViewById(e.g.view_navigation_bar);
        this.aNy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.hfi.getPageContext().getString(e.j.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hfi.getPageContext().getString(e.j.send_post));
        this.mParent = (RelativeLayout) this.hfi.findViewById(e.g.parent);
        this.heV = this.hfi.findViewById(e.g.interval_view);
        this.heW = this.hfi.findViewById(e.g.prefix_interval_view);
        this.hfd = (LinearLayout) this.hfi.findViewById(e.g.post_share_layout);
        this.hfe = (LinearLayout) this.hfi.findViewById(e.g.post_share_content_layout);
        this.hff = (ShareSDKImageView) this.hfi.findViewById(e.g.post_share_image);
        this.hfg = (TextView) this.hfi.findViewById(e.g.post_share_title);
        this.hfh = (TextView) this.hfi.findViewById(e.g.post_share_content);
        bAB();
        bAD();
        this.heX = (LinearLayout) this.hfi.findViewById(e.g.post_content_container);
        this.heX.setDrawingCacheEnabled(false);
        this.heU.setVisibility(0);
        this.heY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        bAC();
    }

    public void bAz() {
        this.hfd = (LinearLayout) this.hfi.findViewById(e.g.post_share_layout);
        this.hff = (ShareSDKImageView) this.hfi.findViewById(e.g.post_share_image);
        this.hff.setIsRound(false);
        this.hff.setDrawBorder(false);
        this.hff.setAutoChangeStyle(true);
        this.hff.setRadius(0);
        this.hfg = (TextView) this.hfi.findViewById(e.g.post_share_title);
        this.hfh = (TextView) this.hfi.findViewById(e.g.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.hff.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void s(String str, boolean z) {
                        if (z) {
                            if (c.this.hff.getLoadedWidth() != 0 && c.this.hff.getLoadedHeight() != 0) {
                                c.this.width = c.this.hff.getLoadedWidth();
                                c.this.height = c.this.hff.getLoadedHeight();
                                if (c.this.hfi != null) {
                                    c.this.hfi.getWriteData().setShareSummaryImgWidth(c.this.width);
                                    c.this.hfi.getWriteData().setShareSummaryImgHeight(c.this.height);
                                    c.this.hfk = true;
                                    c.this.bAC();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.hfk = false;
                        c.this.bAC();
                        if (c.this.hfi != null) {
                            c.this.hfi.vh(e.j.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.hfk = false;
                        c.this.bAC();
                        if (c.this.hfi != null) {
                            c.this.hfi.vh(e.j.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.hff.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.hfk = true;
                    bAC();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.hff.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(l.b(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.L(aq.Ee().Ek(), aq.Ee().El()));
                    this.hff.setTag(imageFileInfo.toCachedKey(true));
                    if (this.hfj.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.hfd.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.hff.invalidate();
                    }
                }
                this.hfk = true;
                bAC();
            }
            this.mData.setShareSummaryImgType(f.bp(this.mData.getShareSummaryImg()));
            this.hfg.setText(this.mData.getShareSummaryTitle());
            this.hfh.setText(this.mData.getShareSummaryContent());
        }
    }

    private void bAA() {
        this.hfc = this.hfi.findViewById(e.g.post_prefix_layout);
        this.heZ = (TextView) this.hfi.findViewById(e.g.post_prefix);
        this.hfb = (ImageView) this.hfi.findViewById(e.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.hfc.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.heZ.setText(prefixs.get(0));
            this.hfi.vi(0);
            this.hfc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.heZ.setVisibility(0);
                    c.this.hfc.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.hfa, view, com.baidu.adp.lib.util.l.dip2px(c.this.hfi.getPageContext().getContext(), 15.0f), com.baidu.adp.lib.util.l.dip2px(c.this.hfi.getPageContext().getContext(), 1.0f));
                    if (c.this.hfi != null) {
                        c.this.hfi.bAy();
                    }
                }
            });
            this.hfb = (ImageView) this.hfi.findViewById(e.g.prefix_icon);
            if (size > 1) {
                this.hfb.setVisibility(0);
                this.heZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.heZ.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.hfa, view, com.baidu.adp.lib.util.l.dip2px(c.this.hfi.getPageContext().getContext(), 15.0f), com.baidu.adp.lib.util.l.dip2px(c.this.hfi.getPageContext().getContext(), 1.0f));
                        if (c.this.hfi != null) {
                            c.this.hfi.bAy();
                        }
                    }
                });
            }
            this.hfa = new d(this.hfi.getPageContext().getContext());
            this.hfa.setMaxHeight(com.baidu.adp.lib.util.l.dip2px(this.hfi.getPageContext().getContext(), 225.0f));
            this.hfa.setOutsideTouchable(true);
            this.hfa.setFocusable(true);
            this.hfa.setBackgroundDrawable(al.getDrawable(e.d.cp_bg_line_b));
            this.hfa.a(new d.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.d.a
                public void vj(int i) {
                    c.this.hfi.vi(i);
                    c.this.heZ.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.hfa.setCurrentIndex(i);
                    c.this.bAC();
                    g.a(c.this.hfa, c.this.hfi.getPageContext().getPageActivity());
                }
            });
            this.hfa.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.hfc.setSelected(false);
                }
            });
            int color = al.getColor(e.d.common_color_10097);
            al.i(this.heZ, e.f.write_prefix_item_selector);
            al.c(this.hfb, e.f.icon_title_down);
            this.heZ.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.hfi.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.dip2px(this.hfi.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                al.i(textView, e.f.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.hfi.getPageContext().getContext(), this.hfi.getResources().getDimension(e.C0210e.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.hfi.getPageContext().getContext(), this.hfi.getResources().getDimension(e.C0210e.ds22)), 0);
                this.hfa.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.dip2px(this.hfi.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.hfi.getPageContext().getContext(), this.hfi.getResources().getDimension(e.C0210e.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.hfi.getPageContext().getContext(), this.hfi.getResources().getDimension(e.C0210e.ds22)), 0);
                }
            }
            this.hfa.setCurrentIndex(0);
            return;
        }
        this.hfc.setVisibility(8);
    }

    protected void bAB() {
        this.heU = (EditText) this.hfi.findViewById(e.g.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.heU.setText(this.mData.getTitle());
                this.heU.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.hfi.getPageContext().getString(e.j.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.heU.setText(str);
                if (str.length() < 20) {
                    this.heU.setSelection(str.length());
                } else {
                    this.heU.setSelection(20);
                }
            }
        }
        this.heU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.bAC();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void bAC() {
        String str = null;
        if (this.mData.getType() == 3) {
            String trim = this.heU.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.hfi.bAw() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.hfk) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void bAD() {
        this.heY = (EditText) this.hfi.findViewById(e.g.post_content);
        this.heY.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString ak = TbFaceManager.NL().ak(this.hfi.getPageContext().getContext(), this.mData.getContent());
            this.heY.setText(ak);
            this.heY.setSelection(ak.length());
        }
        this.heY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.heY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.bAC();
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

    public EditText bAE() {
        return this.heU;
    }

    public EditText bAF() {
        return this.heY;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        bAA();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.heU.setOnFocusChangeListener(onFocusChangeListener);
        this.heY.setOnFocusChangeListener(onFocusChangeListener);
        this.aNy.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public d bAG() {
        return this.hfa;
    }

    public View bAH() {
        return this.aNy;
    }

    public TextView bAI() {
        return this.mPost;
    }

    public TextView bAJ() {
        return this.heZ;
    }

    public void V(View.OnClickListener onClickListener) {
        this.aNy.setOnClickListener(onClickListener);
    }

    public void W(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void X(View.OnClickListener onClickListener) {
        this.heX.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.hfi != null) {
            this.hfi.getLayoutMode().setNightMode(i == 1);
            this.hfi.getLayoutMode().onModeChanged(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.hfi.getPageContext(), i);
            al.d(this.mPost, i);
            al.j(this.heV, e.d.cp_bg_line_c);
            al.j(this.heW, e.d.cp_bg_line_c);
            al.j(this.heU, e.d.cp_cont_g);
            al.j(this.hfe, e.d.cp_bg_line_e);
            int color = al.getColor(e.d.cp_cont_b);
            int color2 = al.getColor(e.d.cp_cont_e);
            this.heU.setTextColor(color);
            this.heY.setTextColor(color);
            this.hfg.setTextColor(al.getColor(e.d.cp_cont_b));
            this.hfh.setTextColor(al.getColor(e.d.cp_cont_d));
            b(this.heU, color2);
            b(this.heY, color2);
            bAC();
        }
    }

    public ShareSDKImageView bAK() {
        return this.hff;
    }
}
