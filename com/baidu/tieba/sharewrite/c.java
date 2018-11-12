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
    private View gTW;
    private TextView gTZ;
    private d gUa;
    private ImageView gUb;
    private View gUc;
    private LinearLayout gUd;
    private LinearLayout gUe;
    private ShareSDKImageView gUf;
    private TextView gUg;
    private TextView gUh;
    private WriteShareActivity gUi;
    private com.baidu.tbadk.img.b gUj;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View aJu = null;
    private EditText gTU = null;
    private View gTV = null;
    private LinearLayout gTX = null;
    private EditText gTY = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean gUk = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.gUi = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.gUj == null) {
            this.gUj = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.gUi.findViewById(e.g.view_navigation_bar);
        this.aJu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gUi.getPageContext().getString(e.j.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gUi.getPageContext().getString(e.j.send_post));
        this.mParent = (RelativeLayout) this.gUi.findViewById(e.g.parent);
        this.gTV = this.gUi.findViewById(e.g.interval_view);
        this.gTW = this.gUi.findViewById(e.g.prefix_interval_view);
        this.gUd = (LinearLayout) this.gUi.findViewById(e.g.post_share_layout);
        this.gUe = (LinearLayout) this.gUi.findViewById(e.g.post_share_content_layout);
        this.gUf = (ShareSDKImageView) this.gUi.findViewById(e.g.post_share_image);
        this.gUg = (TextView) this.gUi.findViewById(e.g.post_share_title);
        this.gUh = (TextView) this.gUi.findViewById(e.g.post_share_content);
        bxj();
        bxl();
        this.gTX = (LinearLayout) this.gUi.findViewById(e.g.post_content_container);
        this.gTX.setDrawingCacheEnabled(false);
        this.gTU.setVisibility(0);
        this.gTY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        bxk();
    }

    public void bxh() {
        this.gUd = (LinearLayout) this.gUi.findViewById(e.g.post_share_layout);
        this.gUf = (ShareSDKImageView) this.gUi.findViewById(e.g.post_share_image);
        this.gUf.setIsRound(false);
        this.gUf.setDrawBorder(false);
        this.gUf.setAutoChangeStyle(true);
        this.gUf.setRadius(0);
        this.gUg = (TextView) this.gUi.findViewById(e.g.post_share_title);
        this.gUh = (TextView) this.gUi.findViewById(e.g.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.gUf.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void r(String str, boolean z) {
                        if (z) {
                            if (c.this.gUf.getLoadedWidth() != 0 && c.this.gUf.getLoadedHeight() != 0) {
                                c.this.width = c.this.gUf.getLoadedWidth();
                                c.this.height = c.this.gUf.getLoadedHeight();
                                if (c.this.gUi != null) {
                                    c.this.gUi.getWriteData().setShareSummaryImgWidth(c.this.width);
                                    c.this.gUi.getWriteData().setShareSummaryImgHeight(c.this.height);
                                    c.this.gUk = true;
                                    c.this.bxk();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.gUk = false;
                        c.this.bxk();
                        if (c.this.gUi != null) {
                            c.this.gUi.uv(e.j.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.gUk = false;
                        c.this.bxk();
                        if (c.this.gUi != null) {
                            c.this.gUi.uv(e.j.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.gUf.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.gUk = true;
                    bxk();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.gUf.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(l.b(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.K(aq.CN().CT(), aq.CN().CU()));
                    this.gUf.setTag(imageFileInfo.toCachedKey(true));
                    if (this.gUj.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.gUd.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.gUf.invalidate();
                    }
                }
                this.gUk = true;
                bxk();
            }
            this.mData.setShareSummaryImgType(f.bp(this.mData.getShareSummaryImg()));
            this.gUg.setText(this.mData.getShareSummaryTitle());
            this.gUh.setText(this.mData.getShareSummaryContent());
        }
    }

    private void bxi() {
        this.gUc = this.gUi.findViewById(e.g.post_prefix_layout);
        this.gTZ = (TextView) this.gUi.findViewById(e.g.post_prefix);
        this.gUb = (ImageView) this.gUi.findViewById(e.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.gUc.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gTZ.setText(prefixs.get(0));
            this.gUi.uw(0);
            this.gUc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.gTZ.setVisibility(0);
                    c.this.gUc.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.gUa, view, com.baidu.adp.lib.util.l.dip2px(c.this.gUi.getPageContext().getContext(), 15.0f), com.baidu.adp.lib.util.l.dip2px(c.this.gUi.getPageContext().getContext(), 1.0f));
                    if (c.this.gUi != null) {
                        c.this.gUi.bxg();
                    }
                }
            });
            this.gUb = (ImageView) this.gUi.findViewById(e.g.prefix_icon);
            if (size > 1) {
                this.gUb.setVisibility(0);
                this.gTZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.gTZ.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.gUa, view, com.baidu.adp.lib.util.l.dip2px(c.this.gUi.getPageContext().getContext(), 15.0f), com.baidu.adp.lib.util.l.dip2px(c.this.gUi.getPageContext().getContext(), 1.0f));
                        if (c.this.gUi != null) {
                            c.this.gUi.bxg();
                        }
                    }
                });
            }
            this.gUa = new d(this.gUi.getPageContext().getContext());
            this.gUa.setMaxHeight(com.baidu.adp.lib.util.l.dip2px(this.gUi.getPageContext().getContext(), 225.0f));
            this.gUa.setOutsideTouchable(true);
            this.gUa.setFocusable(true);
            this.gUa.setBackgroundDrawable(al.getDrawable(e.d.cp_bg_line_b));
            this.gUa.a(new d.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.d.a
                public void ux(int i) {
                    c.this.gUi.uw(i);
                    c.this.gTZ.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.gUa.setCurrentIndex(i);
                    c.this.bxk();
                    g.a(c.this.gUa, c.this.gUi.getPageContext().getPageActivity());
                }
            });
            this.gUa.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.gUc.setSelected(false);
                }
            });
            int color = al.getColor(e.d.common_color_10097);
            al.i(this.gTZ, e.f.write_prefix_item_selector);
            al.c(this.gUb, e.f.icon_title_down);
            this.gTZ.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.gUi.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.dip2px(this.gUi.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                al.i(textView, e.f.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.gUi.getPageContext().getContext(), this.gUi.getResources().getDimension(e.C0200e.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.gUi.getPageContext().getContext(), this.gUi.getResources().getDimension(e.C0200e.ds22)), 0);
                this.gUa.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.dip2px(this.gUi.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.gUi.getPageContext().getContext(), this.gUi.getResources().getDimension(e.C0200e.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.gUi.getPageContext().getContext(), this.gUi.getResources().getDimension(e.C0200e.ds22)), 0);
                }
            }
            this.gUa.setCurrentIndex(0);
            return;
        }
        this.gUc.setVisibility(8);
    }

    protected void bxj() {
        this.gTU = (EditText) this.gUi.findViewById(e.g.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.gTU.setText(this.mData.getTitle());
                this.gTU.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.gUi.getPageContext().getString(e.j.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.gTU.setText(str);
                if (str.length() < 20) {
                    this.gTU.setSelection(str.length());
                } else {
                    this.gTU.setSelection(20);
                }
            }
        }
        this.gTU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.bxk();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void bxk() {
        String str = null;
        if (this.mData.getType() == 3) {
            String trim = this.gTU.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.gUi.bxe() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.gUk) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void bxl() {
        this.gTY = (EditText) this.gUi.findViewById(e.g.post_content);
        this.gTY.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString aj = TbFaceManager.Mp().aj(this.gUi.getPageContext().getContext(), this.mData.getContent());
            this.gTY.setText(aj);
            this.gTY.setSelection(aj.length());
        }
        this.gTY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gTY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.bxk();
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

    public EditText bxm() {
        return this.gTU;
    }

    public EditText bxn() {
        return this.gTY;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        bxi();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.gTU.setOnFocusChangeListener(onFocusChangeListener);
        this.gTY.setOnFocusChangeListener(onFocusChangeListener);
        this.aJu.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public d bxo() {
        return this.gUa;
    }

    public View bxp() {
        return this.aJu;
    }

    public TextView bxq() {
        return this.mPost;
    }

    public TextView bxr() {
        return this.gTZ;
    }

    public void V(View.OnClickListener onClickListener) {
        this.aJu.setOnClickListener(onClickListener);
    }

    public void W(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void X(View.OnClickListener onClickListener) {
        this.gTX.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.gUi != null) {
            this.gUi.getLayoutMode().setNightMode(i == 1);
            this.gUi.getLayoutMode().onModeChanged(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.gUi.getPageContext(), i);
            al.d(this.mPost, i);
            al.j(this.gTV, e.d.cp_bg_line_c);
            al.j(this.gTW, e.d.cp_bg_line_c);
            al.j(this.gTU, e.d.cp_cont_g);
            al.j(this.gUe, e.d.cp_bg_line_e);
            int color = al.getColor(e.d.cp_cont_b);
            int color2 = al.getColor(e.d.cp_cont_e);
            this.gTU.setTextColor(color);
            this.gTY.setTextColor(color);
            this.gUg.setTextColor(al.getColor(e.d.cp_cont_b));
            this.gUh.setTextColor(al.getColor(e.d.cp_cont_d));
            b(this.gTU, color2);
            b(this.gTY, color2);
            bxk();
        }
    }

    public ShareSDKImageView bxs() {
        return this.gUf;
    }
}
