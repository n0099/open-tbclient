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
    private View iVD;
    private TextView iVG;
    private h iVH;
    private ImageView iVI;
    private View iVJ;
    private LinearLayout iVK;
    private LinearLayout iVL;
    private ShareSDKImageView iVM;
    private TextView iVN;
    private TextView iVO;
    private WriteShareActivity iVP;
    private com.baidu.tbadk.img.b iVQ;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View cfb = null;
    private EditText iVB = null;
    private View iVC = null;
    private LinearLayout iVE = null;
    private EditText iVF = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean iVR = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.iVP = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.iVQ == null) {
            this.iVQ = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.iVP.findViewById(R.id.view_navigation_bar);
        this.cfb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iVP.getPageContext().getString(R.string.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iVP.getPageContext().getString(R.string.send_post));
        this.mParent = (RelativeLayout) this.iVP.findViewById(R.id.parent);
        this.iVC = this.iVP.findViewById(R.id.interval_view);
        this.iVD = this.iVP.findViewById(R.id.prefix_interval_view);
        this.iVK = (LinearLayout) this.iVP.findViewById(R.id.post_share_layout);
        this.iVL = (LinearLayout) this.iVP.findViewById(R.id.post_share_content_layout);
        this.iVM = (ShareSDKImageView) this.iVP.findViewById(R.id.post_share_image);
        this.iVN = (TextView) this.iVP.findViewById(R.id.post_share_title);
        this.iVO = (TextView) this.iVP.findViewById(R.id.post_share_content);
        cmn();
        cmp();
        this.iVE = (LinearLayout) this.iVP.findViewById(R.id.post_content_container);
        this.iVE.setDrawingCacheEnabled(false);
        this.iVB.setVisibility(0);
        this.iVF.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        cmo();
    }

    public void cml() {
        this.iVK = (LinearLayout) this.iVP.findViewById(R.id.post_share_layout);
        this.iVM = (ShareSDKImageView) this.iVP.findViewById(R.id.post_share_image);
        this.iVM.setIsRound(false);
        this.iVM.setDrawBorder(false);
        this.iVM.setAutoChangeStyle(true);
        this.iVM.setRadius(0);
        this.iVN = (TextView) this.iVP.findViewById(R.id.post_share_title);
        this.iVO = (TextView) this.iVP.findViewById(R.id.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.iVM.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void P(String str, boolean z) {
                        if (z) {
                            if (c.this.iVM.getLoadedWidth() != 0 && c.this.iVM.getLoadedHeight() != 0) {
                                c.this.width = c.this.iVM.getLoadedWidth();
                                c.this.height = c.this.iVM.getLoadedHeight();
                                if (c.this.iVP != null) {
                                    c.this.iVP.getWriteData().setShareSummaryImgWidth(c.this.width);
                                    c.this.iVP.getWriteData().setShareSummaryImgHeight(c.this.height);
                                    c.this.iVR = true;
                                    c.this.cmo();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.iVR = false;
                        c.this.cmo();
                        if (c.this.iVP != null) {
                            c.this.iVP.AH(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.iVR = false;
                        c.this.cmo();
                        if (c.this.iVP != null) {
                            c.this.iVP.AH(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.iVM.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.iVR = true;
                    cmo();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.iVM.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(m.b(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.al(as.ajo().aju(), as.ajo().ajv()));
                    this.iVM.setTag(imageFileInfo.toCachedKey(true));
                    if (this.iVQ.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.iVK.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.iVM.invalidate();
                    }
                }
                this.iVR = true;
                cmo();
            }
            this.mData.setShareSummaryImgType(f.ba(this.mData.getShareSummaryImg()));
            this.iVN.setText(this.mData.getShareSummaryTitle());
            this.iVO.setText(this.mData.getShareSummaryContent());
        }
    }

    private void cmm() {
        this.iVJ = this.iVP.findViewById(R.id.post_prefix_layout);
        this.iVG = (TextView) this.iVP.findViewById(R.id.post_prefix);
        this.iVI = (ImageView) this.iVP.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.iVJ.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iVG.setText(prefixs.get(0));
            this.iVP.AI(0);
            this.iVJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.iVG.setVisibility(0);
                    c.this.iVJ.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.iVH, view, l.dip2px(c.this.iVP.getPageContext().getContext(), 15.0f), l.dip2px(c.this.iVP.getPageContext().getContext(), 1.0f));
                    if (c.this.iVP != null) {
                        c.this.iVP.cmk();
                    }
                }
            });
            this.iVI = (ImageView) this.iVP.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.iVI.setVisibility(0);
                this.iVG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.iVG.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.iVH, view, l.dip2px(c.this.iVP.getPageContext().getContext(), 15.0f), l.dip2px(c.this.iVP.getPageContext().getContext(), 1.0f));
                        if (c.this.iVP != null) {
                            c.this.iVP.cmk();
                        }
                    }
                });
            }
            this.iVH = new h(this.iVP.getPageContext().getContext());
            this.iVH.setMaxHeight(l.dip2px(this.iVP.getPageContext().getContext(), 225.0f));
            this.iVH.setOutsideTouchable(true);
            this.iVH.setFocusable(true);
            this.iVH.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_b));
            this.iVH.a(new h.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.h.a
                public void AJ(int i) {
                    c.this.iVP.AI(i);
                    c.this.iVG.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.iVH.setCurrentIndex(i);
                    c.this.cmo();
                    g.a(c.this.iVH, c.this.iVP.getPageContext().getPageActivity());
                }
            });
            this.iVH.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.iVJ.setSelected(false);
                }
            });
            int color = am.getColor(R.color.common_color_10097);
            am.k(this.iVG, R.drawable.write_prefix_item_selector);
            am.c(this.iVI, (int) R.drawable.icon_title_down);
            this.iVG.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.iVP.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.iVP.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                am.k(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.iVP.getPageContext().getContext(), this.iVP.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.iVP.getPageContext().getContext(), this.iVP.getResources().getDimension(R.dimen.ds22)), 0);
                this.iVH.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.iVP.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.iVP.getPageContext().getContext(), this.iVP.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.iVP.getPageContext().getContext(), this.iVP.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.iVH.setCurrentIndex(0);
            return;
        }
        this.iVJ.setVisibility(8);
    }

    protected void cmn() {
        this.iVB = (EditText) this.iVP.findViewById(R.id.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.iVB.setText(this.mData.getTitle());
                this.iVB.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.iVP.getPageContext().getString(R.string.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.iVB.setText(str);
                if (str.length() < 20) {
                    this.iVB.setSelection(str.length());
                } else {
                    this.iVB.setSelection(20);
                }
            }
        }
        this.iVB.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cmo();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void cmo() {
        String str = null;
        if (this.mData.getType() == 3) {
            String trim = this.iVB.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.iVP.cmi() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.iVR) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void cmp() {
        this.iVF = (EditText) this.iVP.findViewById(R.id.post_content);
        this.iVF.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString ak = TbFaceManager.atv().ak(this.iVP.getPageContext().getContext(), this.mData.getContent());
            this.iVF.setText(ak);
            this.iVF.setSelection(ak.length());
        }
        this.iVF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iVF.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.cmo();
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

    public EditText cmq() {
        return this.iVB;
    }

    public EditText cmr() {
        return this.iVF;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        cmm();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.iVB.setOnFocusChangeListener(onFocusChangeListener);
        this.iVF.setOnFocusChangeListener(onFocusChangeListener);
        this.cfb.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public h cms() {
        return this.iVH;
    }

    public View cmt() {
        return this.cfb;
    }

    public TextView cmu() {
        return this.mPost;
    }

    public TextView cmv() {
        return this.iVG;
    }

    public void aa(View.OnClickListener onClickListener) {
        this.cfb.setOnClickListener(onClickListener);
    }

    public void ab(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void ac(View.OnClickListener onClickListener) {
        this.iVE.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.iVP != null) {
            this.iVP.getLayoutMode().setNightMode(i == 1);
            this.iVP.getLayoutMode().onModeChanged(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.iVP.getPageContext(), i);
            am.d(this.mPost, i);
            am.l(this.iVC, R.color.cp_bg_line_c);
            am.l(this.iVD, R.color.cp_bg_line_c);
            am.l(this.iVB, R.color.cp_cont_g);
            am.l(this.iVL, R.color.cp_bg_line_e);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_e);
            this.iVB.setTextColor(color);
            this.iVF.setTextColor(color);
            this.iVN.setTextColor(am.getColor(R.color.cp_cont_b));
            this.iVO.setTextColor(am.getColor(R.color.cp_cont_d));
            f(this.iVB, color2);
            f(this.iVF, color2);
            cmo();
        }
    }

    public ShareSDKImageView cmw() {
        return this.iVM;
    }
}
