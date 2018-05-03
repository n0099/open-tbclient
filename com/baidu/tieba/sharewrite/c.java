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
    private View glN;
    private TextView glQ;
    private d glR;
    private ImageView glS;
    private View glT;
    private LinearLayout glU;
    private LinearLayout glV;
    private ShareSDKImageView glW;
    private TextView glX;
    private TextView glY;
    private WriteShareActivity glZ;
    private com.baidu.tbadk.img.b gma;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View asg = null;
    private EditText glL = null;
    private View glM = null;
    private LinearLayout glO = null;
    private EditText glP = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean gmb = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.glZ = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.gma == null) {
            this.gma = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.glZ.findViewById(d.g.view_navigation_bar);
        this.asg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.glZ.getPageContext().getString(d.k.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.glZ.getPageContext().getString(d.k.send_post));
        this.mParent = (RelativeLayout) this.glZ.findViewById(d.g.parent);
        this.glM = this.glZ.findViewById(d.g.interval_view);
        this.glN = this.glZ.findViewById(d.g.prefix_interval_view);
        this.glU = (LinearLayout) this.glZ.findViewById(d.g.post_share_layout);
        this.glV = (LinearLayout) this.glZ.findViewById(d.g.post_share_content_layout);
        this.glW = (ShareSDKImageView) this.glZ.findViewById(d.g.post_share_image);
        this.glX = (TextView) this.glZ.findViewById(d.g.post_share_title);
        this.glY = (TextView) this.glZ.findViewById(d.g.post_share_content);
        bnR();
        bnT();
        this.glO = (LinearLayout) this.glZ.findViewById(d.g.post_content_container);
        this.glO.setDrawingCacheEnabled(false);
        this.glL.setVisibility(0);
        this.glP.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        bnS();
    }

    public void bnP() {
        this.glU = (LinearLayout) this.glZ.findViewById(d.g.post_share_layout);
        this.glW = (ShareSDKImageView) this.glZ.findViewById(d.g.post_share_image);
        this.glW.setIsRound(false);
        this.glW.setDrawBorder(false);
        this.glW.setAutoChangeStyle(true);
        this.glW.setRadius(0);
        this.glX = (TextView) this.glZ.findViewById(d.g.post_share_title);
        this.glY = (TextView) this.glZ.findViewById(d.g.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.glW.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void n(String str, boolean z) {
                        if (z) {
                            if (c.this.glW.getLoadedWidth() != 0 && c.this.glW.getLoadedHeight() != 0) {
                                c.this.width = c.this.glW.getLoadedWidth();
                                c.this.height = c.this.glW.getLoadedHeight();
                                if (c.this.glZ != null) {
                                    c.this.glZ.getWriteData().setShareSummaryImgWidth(c.this.width);
                                    c.this.glZ.getWriteData().setShareSummaryImgHeight(c.this.height);
                                    c.this.gmb = true;
                                    c.this.bnS();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.gmb = false;
                        c.this.bnS();
                        if (c.this.glZ != null) {
                            c.this.glZ.sM(d.k.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.gmb = false;
                        c.this.bnS();
                        if (c.this.glZ != null) {
                            c.this.glZ.sM(d.k.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.glW.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.gmb = true;
                    bnS();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.glW.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(k.b(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.G(ap.vQ().vW(), ap.vQ().vX()));
                    this.glW.setTag(imageFileInfo.toCachedKey(true));
                    if (this.gma.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.glU.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.glW.invalidate();
                    }
                }
                this.gmb = true;
                bnS();
            }
            this.mData.setShareSummaryImgType(f.aK(this.mData.getShareSummaryImg()));
            this.glX.setText(this.mData.getShareSummaryTitle());
            this.glY.setText(this.mData.getShareSummaryContent());
        }
    }

    private void bnQ() {
        this.glT = this.glZ.findViewById(d.g.post_prefix_layout);
        this.glQ = (TextView) this.glZ.findViewById(d.g.post_prefix);
        this.glS = (ImageView) this.glZ.findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.glT.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.glQ.setText(prefixs.get(0));
            this.glZ.sN(0);
            this.glT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.glQ.setVisibility(0);
                    c.this.glT.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.glR, view2, l.dip2px(c.this.glZ.getPageContext().getContext(), 15.0f), l.dip2px(c.this.glZ.getPageContext().getContext(), 1.0f));
                    if (c.this.glZ != null) {
                        c.this.glZ.bnO();
                    }
                }
            });
            this.glS = (ImageView) this.glZ.findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.glS.setVisibility(0);
                this.glQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        c.this.glQ.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.glR, view2, l.dip2px(c.this.glZ.getPageContext().getContext(), 15.0f), l.dip2px(c.this.glZ.getPageContext().getContext(), 1.0f));
                        if (c.this.glZ != null) {
                            c.this.glZ.bnO();
                        }
                    }
                });
            }
            this.glR = new com.baidu.tieba.write.d(this.glZ.getPageContext().getContext());
            this.glR.setMaxHeight(l.dip2px(this.glZ.getPageContext().getContext(), 225.0f));
            this.glR.setOutsideTouchable(true);
            this.glR.setFocusable(true);
            this.glR.setBackgroundDrawable(ak.getDrawable(d.C0126d.cp_bg_line_b));
            this.glR.a(new d.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.d.a
                public void sO(int i) {
                    c.this.glZ.sN(i);
                    c.this.glQ.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.glR.setCurrentIndex(i);
                    c.this.bnS();
                    g.a(c.this.glR, c.this.glZ.getPageContext().getPageActivity());
                }
            });
            this.glR.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.glT.setSelected(false);
                }
            });
            int color = ak.getColor(d.C0126d.common_color_10097);
            ak.i(this.glQ, d.f.write_prefix_item_selector);
            ak.c(this.glS, d.f.icon_title_down);
            this.glQ.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.glZ.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.glZ.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ak.i(textView, d.f.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.glZ.getPageContext().getContext(), this.glZ.getResources().getDimension(d.e.ds6)), 0, l.dip2px(this.glZ.getPageContext().getContext(), this.glZ.getResources().getDimension(d.e.ds22)), 0);
                this.glR.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.glZ.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.glZ.getPageContext().getContext(), this.glZ.getResources().getDimension(d.e.ds6)), 0, l.dip2px(this.glZ.getPageContext().getContext(), this.glZ.getResources().getDimension(d.e.ds22)), 0);
                }
            }
            this.glR.setCurrentIndex(0);
            return;
        }
        this.glT.setVisibility(8);
    }

    protected void bnR() {
        this.glL = (EditText) this.glZ.findViewById(d.g.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.glL.setText(this.mData.getTitle());
                this.glL.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.glZ.getPageContext().getString(d.k.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.glL.setText(str);
                if (str.length() < 20) {
                    this.glL.setSelection(str.length());
                } else {
                    this.glL.setSelection(20);
                }
            }
        }
        this.glL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.bnS();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void bnS() {
        String str = null;
        if (this.mData.getType() == 3) {
            String trim = this.glL.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.glZ.bnM() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.gmb) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void bnT() {
        this.glP = (EditText) this.glZ.findViewById(d.g.post_content);
        this.glP.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString R = TbFaceManager.EZ().R(this.glZ.getPageContext().getContext(), this.mData.getContent());
            this.glP.setText(R);
            this.glP.setSelection(R.length());
        }
        this.glP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view2.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.glP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.bnS();
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

    public EditText bnU() {
        return this.glL;
    }

    public EditText bnV() {
        return this.glP;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        bnQ();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.glL.setOnFocusChangeListener(onFocusChangeListener);
        this.glP.setOnFocusChangeListener(onFocusChangeListener);
        this.asg.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public com.baidu.tieba.write.d bnW() {
        return this.glR;
    }

    public View bnX() {
        return this.asg;
    }

    public TextView bnY() {
        return this.mPost;
    }

    public TextView bnZ() {
        return this.glQ;
    }

    public void S(View.OnClickListener onClickListener) {
        this.asg.setOnClickListener(onClickListener);
    }

    public void T(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void U(View.OnClickListener onClickListener) {
        this.glO.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.glZ != null) {
            this.glZ.getLayoutMode().setNightMode(i == 1);
            this.glZ.getLayoutMode().u(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.glZ.getPageContext(), i);
            ak.d(this.mPost, i);
            ak.j(this.glM, d.C0126d.cp_bg_line_c);
            ak.j(this.glN, d.C0126d.cp_bg_line_c);
            ak.j(this.glL, d.C0126d.cp_cont_g);
            ak.j(this.glV, d.C0126d.cp_bg_line_e);
            int color = ak.getColor(d.C0126d.cp_cont_b);
            int color2 = ak.getColor(d.C0126d.cp_cont_e);
            this.glL.setTextColor(color);
            this.glP.setTextColor(color);
            this.glX.setTextColor(ak.getColor(d.C0126d.cp_cont_b));
            this.glY.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
            b(this.glL, color2);
            b(this.glP, color2);
            bnS();
        }
    }

    public ShareSDKImageView boa() {
        return this.glW;
    }
}
