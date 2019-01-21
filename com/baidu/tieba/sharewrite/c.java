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
    private View heX;
    private TextView hfa;
    private d hfb;
    private ImageView hfc;
    private View hfd;
    private LinearLayout hfe;
    private LinearLayout hff;
    private ShareSDKImageView hfg;
    private TextView hfh;
    private TextView hfi;
    private WriteShareActivity hfj;
    private com.baidu.tbadk.img.b hfk;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View aNz = null;
    private EditText heV = null;
    private View heW = null;
    private LinearLayout heY = null;
    private EditText heZ = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean hfl = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.hfj = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.hfk == null) {
            this.hfk = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.hfj.findViewById(e.g.view_navigation_bar);
        this.aNz = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.hfj.getPageContext().getString(e.j.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hfj.getPageContext().getString(e.j.send_post));
        this.mParent = (RelativeLayout) this.hfj.findViewById(e.g.parent);
        this.heW = this.hfj.findViewById(e.g.interval_view);
        this.heX = this.hfj.findViewById(e.g.prefix_interval_view);
        this.hfe = (LinearLayout) this.hfj.findViewById(e.g.post_share_layout);
        this.hff = (LinearLayout) this.hfj.findViewById(e.g.post_share_content_layout);
        this.hfg = (ShareSDKImageView) this.hfj.findViewById(e.g.post_share_image);
        this.hfh = (TextView) this.hfj.findViewById(e.g.post_share_title);
        this.hfi = (TextView) this.hfj.findViewById(e.g.post_share_content);
        bAB();
        bAD();
        this.heY = (LinearLayout) this.hfj.findViewById(e.g.post_content_container);
        this.heY.setDrawingCacheEnabled(false);
        this.heV.setVisibility(0);
        this.heZ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        bAC();
    }

    public void bAz() {
        this.hfe = (LinearLayout) this.hfj.findViewById(e.g.post_share_layout);
        this.hfg = (ShareSDKImageView) this.hfj.findViewById(e.g.post_share_image);
        this.hfg.setIsRound(false);
        this.hfg.setDrawBorder(false);
        this.hfg.setAutoChangeStyle(true);
        this.hfg.setRadius(0);
        this.hfh = (TextView) this.hfj.findViewById(e.g.post_share_title);
        this.hfi = (TextView) this.hfj.findViewById(e.g.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.hfg.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void s(String str, boolean z) {
                        if (z) {
                            if (c.this.hfg.getLoadedWidth() != 0 && c.this.hfg.getLoadedHeight() != 0) {
                                c.this.width = c.this.hfg.getLoadedWidth();
                                c.this.height = c.this.hfg.getLoadedHeight();
                                if (c.this.hfj != null) {
                                    c.this.hfj.getWriteData().setShareSummaryImgWidth(c.this.width);
                                    c.this.hfj.getWriteData().setShareSummaryImgHeight(c.this.height);
                                    c.this.hfl = true;
                                    c.this.bAC();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.hfl = false;
                        c.this.bAC();
                        if (c.this.hfj != null) {
                            c.this.hfj.vh(e.j.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.hfl = false;
                        c.this.bAC();
                        if (c.this.hfj != null) {
                            c.this.hfj.vh(e.j.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.hfg.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.hfl = true;
                    bAC();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.hfg.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(l.b(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.L(aq.Ee().Ek(), aq.Ee().El()));
                    this.hfg.setTag(imageFileInfo.toCachedKey(true));
                    if (this.hfk.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.hfe.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.hfg.invalidate();
                    }
                }
                this.hfl = true;
                bAC();
            }
            this.mData.setShareSummaryImgType(f.bp(this.mData.getShareSummaryImg()));
            this.hfh.setText(this.mData.getShareSummaryTitle());
            this.hfi.setText(this.mData.getShareSummaryContent());
        }
    }

    private void bAA() {
        this.hfd = this.hfj.findViewById(e.g.post_prefix_layout);
        this.hfa = (TextView) this.hfj.findViewById(e.g.post_prefix);
        this.hfc = (ImageView) this.hfj.findViewById(e.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.hfd.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.hfa.setText(prefixs.get(0));
            this.hfj.vi(0);
            this.hfd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.hfa.setVisibility(0);
                    c.this.hfd.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.hfb, view, com.baidu.adp.lib.util.l.dip2px(c.this.hfj.getPageContext().getContext(), 15.0f), com.baidu.adp.lib.util.l.dip2px(c.this.hfj.getPageContext().getContext(), 1.0f));
                    if (c.this.hfj != null) {
                        c.this.hfj.bAy();
                    }
                }
            });
            this.hfc = (ImageView) this.hfj.findViewById(e.g.prefix_icon);
            if (size > 1) {
                this.hfc.setVisibility(0);
                this.hfa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.hfa.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.hfb, view, com.baidu.adp.lib.util.l.dip2px(c.this.hfj.getPageContext().getContext(), 15.0f), com.baidu.adp.lib.util.l.dip2px(c.this.hfj.getPageContext().getContext(), 1.0f));
                        if (c.this.hfj != null) {
                            c.this.hfj.bAy();
                        }
                    }
                });
            }
            this.hfb = new d(this.hfj.getPageContext().getContext());
            this.hfb.setMaxHeight(com.baidu.adp.lib.util.l.dip2px(this.hfj.getPageContext().getContext(), 225.0f));
            this.hfb.setOutsideTouchable(true);
            this.hfb.setFocusable(true);
            this.hfb.setBackgroundDrawable(al.getDrawable(e.d.cp_bg_line_b));
            this.hfb.a(new d.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.d.a
                public void vj(int i) {
                    c.this.hfj.vi(i);
                    c.this.hfa.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.hfb.setCurrentIndex(i);
                    c.this.bAC();
                    g.a(c.this.hfb, c.this.hfj.getPageContext().getPageActivity());
                }
            });
            this.hfb.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.hfd.setSelected(false);
                }
            });
            int color = al.getColor(e.d.common_color_10097);
            al.i(this.hfa, e.f.write_prefix_item_selector);
            al.c(this.hfc, e.f.icon_title_down);
            this.hfa.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.hfj.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.dip2px(this.hfj.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                al.i(textView, e.f.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.hfj.getPageContext().getContext(), this.hfj.getResources().getDimension(e.C0210e.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.hfj.getPageContext().getContext(), this.hfj.getResources().getDimension(e.C0210e.ds22)), 0);
                this.hfb.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.dip2px(this.hfj.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.hfj.getPageContext().getContext(), this.hfj.getResources().getDimension(e.C0210e.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.hfj.getPageContext().getContext(), this.hfj.getResources().getDimension(e.C0210e.ds22)), 0);
                }
            }
            this.hfb.setCurrentIndex(0);
            return;
        }
        this.hfd.setVisibility(8);
    }

    protected void bAB() {
        this.heV = (EditText) this.hfj.findViewById(e.g.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.heV.setText(this.mData.getTitle());
                this.heV.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.hfj.getPageContext().getString(e.j.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.heV.setText(str);
                if (str.length() < 20) {
                    this.heV.setSelection(str.length());
                } else {
                    this.heV.setSelection(20);
                }
            }
        }
        this.heV.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
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
            String trim = this.heV.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.hfj.bAw() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.hfl) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void bAD() {
        this.heZ = (EditText) this.hfj.findViewById(e.g.post_content);
        this.heZ.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString ak = TbFaceManager.NL().ak(this.hfj.getPageContext().getContext(), this.mData.getContent());
            this.heZ.setText(ak);
            this.heZ.setSelection(ak.length());
        }
        this.heZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.heZ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
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
        return this.heV;
    }

    public EditText bAF() {
        return this.heZ;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        bAA();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.heV.setOnFocusChangeListener(onFocusChangeListener);
        this.heZ.setOnFocusChangeListener(onFocusChangeListener);
        this.aNz.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public d bAG() {
        return this.hfb;
    }

    public View bAH() {
        return this.aNz;
    }

    public TextView bAI() {
        return this.mPost;
    }

    public TextView bAJ() {
        return this.hfa;
    }

    public void V(View.OnClickListener onClickListener) {
        this.aNz.setOnClickListener(onClickListener);
    }

    public void W(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void X(View.OnClickListener onClickListener) {
        this.heY.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.hfj != null) {
            this.hfj.getLayoutMode().setNightMode(i == 1);
            this.hfj.getLayoutMode().onModeChanged(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.hfj.getPageContext(), i);
            al.d(this.mPost, i);
            al.j(this.heW, e.d.cp_bg_line_c);
            al.j(this.heX, e.d.cp_bg_line_c);
            al.j(this.heV, e.d.cp_cont_g);
            al.j(this.hff, e.d.cp_bg_line_e);
            int color = al.getColor(e.d.cp_cont_b);
            int color2 = al.getColor(e.d.cp_cont_e);
            this.heV.setTextColor(color);
            this.heZ.setTextColor(color);
            this.hfh.setTextColor(al.getColor(e.d.cp_cont_b));
            this.hfi.setTextColor(al.getColor(e.d.cp_cont_d));
            b(this.heV, color2);
            b(this.heZ, color2);
            bAC();
        }
    }

    public ShareSDKImageView bAK() {
        return this.hfg;
    }
}
