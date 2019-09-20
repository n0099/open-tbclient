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
import com.baidu.tbadk.core.util.ar;
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
    private View iZc;
    private TextView iZf;
    private h iZg;
    private ImageView iZh;
    private View iZi;
    private LinearLayout iZj;
    private LinearLayout iZk;
    private ShareSDKImageView iZl;
    private TextView iZm;
    private TextView iZn;
    private WriteShareActivity iZo;
    private com.baidu.tbadk.img.b iZp;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View cgb = null;
    private EditText iZa = null;
    private View iZb = null;
    private LinearLayout iZd = null;
    private EditText iZe = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean iZq = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.iZo = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.iZp == null) {
            this.iZp = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.iZo.findViewById(R.id.view_navigation_bar);
        this.cgb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iZo.getPageContext().getString(R.string.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iZo.getPageContext().getString(R.string.send_post));
        this.mParent = (RelativeLayout) this.iZo.findViewById(R.id.parent);
        this.iZb = this.iZo.findViewById(R.id.interval_view);
        this.iZc = this.iZo.findViewById(R.id.prefix_interval_view);
        this.iZj = (LinearLayout) this.iZo.findViewById(R.id.post_share_layout);
        this.iZk = (LinearLayout) this.iZo.findViewById(R.id.post_share_content_layout);
        this.iZl = (ShareSDKImageView) this.iZo.findViewById(R.id.post_share_image);
        this.iZm = (TextView) this.iZo.findViewById(R.id.post_share_title);
        this.iZn = (TextView) this.iZo.findViewById(R.id.post_share_content);
        cns();
        cnu();
        this.iZd = (LinearLayout) this.iZo.findViewById(R.id.post_content_container);
        this.iZd.setDrawingCacheEnabled(false);
        this.iZa.setVisibility(0);
        this.iZe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        cnt();
    }

    public void cnq() {
        this.iZj = (LinearLayout) this.iZo.findViewById(R.id.post_share_layout);
        this.iZl = (ShareSDKImageView) this.iZo.findViewById(R.id.post_share_image);
        this.iZl.setIsRound(false);
        this.iZl.setDrawBorder(false);
        this.iZl.setAutoChangeStyle(true);
        this.iZl.setRadius(0);
        this.iZm = (TextView) this.iZo.findViewById(R.id.post_share_title);
        this.iZn = (TextView) this.iZo.findViewById(R.id.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.iZl.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void P(String str, boolean z) {
                        if (z) {
                            if (c.this.iZl.getLoadedWidth() != 0 && c.this.iZl.getLoadedHeight() != 0) {
                                c.this.width = c.this.iZl.getLoadedWidth();
                                c.this.height = c.this.iZl.getLoadedHeight();
                                if (c.this.iZo != null) {
                                    c.this.iZo.getWriteData().setShareSummaryImgWidth(c.this.width);
                                    c.this.iZo.getWriteData().setShareSummaryImgHeight(c.this.height);
                                    c.this.iZq = true;
                                    c.this.cnt();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.iZq = false;
                        c.this.cnt();
                        if (c.this.iZo != null) {
                            c.this.iZo.AM(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.iZq = false;
                        c.this.cnt();
                        if (c.this.iZo != null) {
                            c.this.iZo.AM(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.iZl.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.iZq = true;
                    cnt();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.iZl.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(m.d(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.al(ar.ajw().ajC(), ar.ajw().ajD()));
                    this.iZl.setTag(imageFileInfo.toCachedKey(true));
                    if (this.iZp.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.iZj.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.iZl.invalidate();
                    }
                }
                this.iZq = true;
                cnt();
            }
            this.mData.setShareSummaryImgType(f.ba(this.mData.getShareSummaryImg()));
            this.iZm.setText(this.mData.getShareSummaryTitle());
            this.iZn.setText(this.mData.getShareSummaryContent());
        }
    }

    private void cnr() {
        this.iZi = this.iZo.findViewById(R.id.post_prefix_layout);
        this.iZf = (TextView) this.iZo.findViewById(R.id.post_prefix);
        this.iZh = (ImageView) this.iZo.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.iZi.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iZf.setText(prefixs.get(0));
            this.iZo.AN(0);
            this.iZi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.iZf.setVisibility(0);
                    c.this.iZi.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.iZg, view, l.dip2px(c.this.iZo.getPageContext().getContext(), 15.0f), l.dip2px(c.this.iZo.getPageContext().getContext(), 1.0f));
                    if (c.this.iZo != null) {
                        c.this.iZo.cnp();
                    }
                }
            });
            this.iZh = (ImageView) this.iZo.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.iZh.setVisibility(0);
                this.iZf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.iZf.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.iZg, view, l.dip2px(c.this.iZo.getPageContext().getContext(), 15.0f), l.dip2px(c.this.iZo.getPageContext().getContext(), 1.0f));
                        if (c.this.iZo != null) {
                            c.this.iZo.cnp();
                        }
                    }
                });
            }
            this.iZg = new h(this.iZo.getPageContext().getContext());
            this.iZg.setMaxHeight(l.dip2px(this.iZo.getPageContext().getContext(), 225.0f));
            this.iZg.setOutsideTouchable(true);
            this.iZg.setFocusable(true);
            this.iZg.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_c));
            this.iZg.a(new h.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.h.a
                public void AO(int i) {
                    c.this.iZo.AN(i);
                    c.this.iZf.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.iZg.setCurrentIndex(i);
                    c.this.cnt();
                    g.a(c.this.iZg, c.this.iZo.getPageContext().getPageActivity());
                }
            });
            this.iZg.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.iZi.setSelected(false);
                }
            });
            int color = am.getColor(R.color.common_color_10097);
            am.k(this.iZf, R.drawable.write_prefix_item_selector);
            am.c(this.iZh, (int) R.drawable.icon_title_down);
            this.iZf.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.iZo.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.iZo.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                am.k(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.iZo.getPageContext().getContext(), this.iZo.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.iZo.getPageContext().getContext(), this.iZo.getResources().getDimension(R.dimen.ds22)), 0);
                this.iZg.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.iZo.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.iZo.getPageContext().getContext(), this.iZo.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.iZo.getPageContext().getContext(), this.iZo.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.iZg.setCurrentIndex(0);
            return;
        }
        this.iZi.setVisibility(8);
    }

    protected void cns() {
        this.iZa = (EditText) this.iZo.findViewById(R.id.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.iZa.setText(this.mData.getTitle());
                this.iZa.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.iZo.getPageContext().getString(R.string.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.iZa.setText(str);
                if (str.length() < 20) {
                    this.iZa.setSelection(str.length());
                } else {
                    this.iZa.setSelection(20);
                }
            }
        }
        this.iZa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cnt();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void cnt() {
        String str = null;
        if (this.mData.getType() == 3) {
            String trim = this.iZa.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.iZo.cnn() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.iZq) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void cnu() {
        this.iZe = (EditText) this.iZo.findViewById(R.id.post_content);
        this.iZe.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString ak = TbFaceManager.atJ().ak(this.iZo.getPageContext().getContext(), this.mData.getContent());
            this.iZe.setText(ak);
            this.iZe.setSelection(ak.length());
        }
        this.iZe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iZe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cnt();
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

    public EditText cnv() {
        return this.iZa;
    }

    public EditText cnw() {
        return this.iZe;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        cnr();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.iZa.setOnFocusChangeListener(onFocusChangeListener);
        this.iZe.setOnFocusChangeListener(onFocusChangeListener);
        this.cgb.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public h cnx() {
        return this.iZg;
    }

    public View cny() {
        return this.cgb;
    }

    public TextView cnz() {
        return this.mPost;
    }

    public TextView cnA() {
        return this.iZf;
    }

    public void aa(View.OnClickListener onClickListener) {
        this.cgb.setOnClickListener(onClickListener);
    }

    public void ab(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void ac(View.OnClickListener onClickListener) {
        this.iZd.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.iZo != null) {
            this.iZo.getLayoutMode().setNightMode(i == 1);
            this.iZo.getLayoutMode().onModeChanged(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.iZo.getPageContext(), i);
            am.d(this.mPost, i);
            am.l(this.iZb, R.color.cp_bg_line_c);
            am.l(this.iZc, R.color.cp_bg_line_c);
            am.l(this.iZa, R.color.cp_cont_g);
            am.l(this.iZk, R.color.cp_bg_line_e);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_e);
            this.iZa.setTextColor(color);
            this.iZe.setTextColor(color);
            this.iZm.setTextColor(am.getColor(R.color.cp_cont_b));
            this.iZn.setTextColor(am.getColor(R.color.cp_cont_d));
            f(this.iZa, color2);
            f(this.iZe, color2);
            cnt();
        }
    }

    public ShareSDKImageView cnB() {
        return this.iZl;
    }
}
