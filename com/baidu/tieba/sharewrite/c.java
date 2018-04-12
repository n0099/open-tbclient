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
    private View glQ;
    private TextView glT;
    private d glU;
    private ImageView glV;
    private View glW;
    private LinearLayout glX;
    private LinearLayout glY;
    private ShareSDKImageView glZ;
    private TextView gma;
    private TextView gmb;
    private WriteShareActivity gmc;
    private com.baidu.tbadk.img.b gmd;
    private WriteData mData;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View asg = null;
    private EditText glO = null;
    private View glP = null;
    private LinearLayout glR = null;
    private EditText glS = null;
    private TextView mPost = null;
    private RelativeLayout mParent = null;
    private boolean gme = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mData = null;
        this.gmc = writeShareActivity;
        this.mData = writeShareActivity.getWriteData();
        if (this.gmd == null) {
            this.gmd = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.gmc.findViewById(d.g.view_navigation_bar);
        this.asg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gmc.getPageContext().getString(d.k.share_navigationbar_title));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gmc.getPageContext().getString(d.k.send_post));
        this.mParent = (RelativeLayout) this.gmc.findViewById(d.g.parent);
        this.glP = this.gmc.findViewById(d.g.interval_view);
        this.glQ = this.gmc.findViewById(d.g.prefix_interval_view);
        this.glX = (LinearLayout) this.gmc.findViewById(d.g.post_share_layout);
        this.glY = (LinearLayout) this.gmc.findViewById(d.g.post_share_content_layout);
        this.glZ = (ShareSDKImageView) this.gmc.findViewById(d.g.post_share_image);
        this.gma = (TextView) this.gmc.findViewById(d.g.post_share_title);
        this.gmb = (TextView) this.gmc.findViewById(d.g.post_share_content);
        bnR();
        bnT();
        this.glR = (LinearLayout) this.gmc.findViewById(d.g.post_content_container);
        this.glR.setDrawingCacheEnabled(false);
        this.glO.setVisibility(0);
        this.glS.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        bnS();
    }

    public void bnP() {
        this.glX = (LinearLayout) this.gmc.findViewById(d.g.post_share_layout);
        this.glZ = (ShareSDKImageView) this.gmc.findViewById(d.g.post_share_image);
        this.glZ.setIsRound(false);
        this.glZ.setDrawBorder(false);
        this.glZ.setAutoChangeStyle(true);
        this.glZ.setRadius(0);
        this.gma = (TextView) this.gmc.findViewById(d.g.post_share_title);
        this.gmb = (TextView) this.gmc.findViewById(d.g.post_share_content);
        if (this.mData != null) {
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.glZ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void n(String str, boolean z) {
                        if (z) {
                            if (c.this.glZ.getLoadedWidth() != 0 && c.this.glZ.getLoadedHeight() != 0) {
                                c.this.width = c.this.glZ.getLoadedWidth();
                                c.this.height = c.this.glZ.getLoadedHeight();
                                if (c.this.gmc != null) {
                                    c.this.gmc.getWriteData().setShareSummaryImgWidth(c.this.width);
                                    c.this.gmc.getWriteData().setShareSummaryImgHeight(c.this.height);
                                    c.this.gme = true;
                                    c.this.bnS();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.gme = false;
                        c.this.bnS();
                        if (c.this.gmc != null) {
                            c.this.gmc.sN(d.k.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.gme = false;
                        c.this.bnS();
                        if (c.this.gmc != null) {
                            c.this.gmc.sN(d.k.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mData.getShareSummaryImg() != null && this.mData.getShareSummaryImg().trim().length() > 0) {
                    this.glZ.startLoad(this.mData.getShareSummaryImg(), 10, true);
                } else {
                    this.gme = true;
                    bnS();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mData.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.glZ.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mData.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(k.b(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mData.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.G(ap.vQ().vW(), ap.vQ().vX()));
                    this.glZ.setTag(imageFileInfo.toCachedKey(true));
                    if (this.gmd.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.glX.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.glZ.invalidate();
                    }
                }
                this.gme = true;
                bnS();
            }
            this.mData.setShareSummaryImgType(f.aK(this.mData.getShareSummaryImg()));
            this.gma.setText(this.mData.getShareSummaryTitle());
            this.gmb.setText(this.mData.getShareSummaryContent());
        }
    }

    private void bnQ() {
        this.glW = this.gmc.findViewById(d.g.post_prefix_layout);
        this.glT = (TextView) this.gmc.findViewById(d.g.post_prefix);
        this.glV = (ImageView) this.gmc.findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.glW.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.glT.setText(prefixs.get(0));
            this.gmc.sO(0);
            this.glW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.glT.setVisibility(0);
                    c.this.glW.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.glU, view2, l.dip2px(c.this.gmc.getPageContext().getContext(), 15.0f), l.dip2px(c.this.gmc.getPageContext().getContext(), 1.0f));
                    if (c.this.gmc != null) {
                        c.this.gmc.bnO();
                    }
                }
            });
            this.glV = (ImageView) this.gmc.findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.glV.setVisibility(0);
                this.glT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        c.this.glT.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.glU, view2, l.dip2px(c.this.gmc.getPageContext().getContext(), 15.0f), l.dip2px(c.this.gmc.getPageContext().getContext(), 1.0f));
                        if (c.this.gmc != null) {
                            c.this.gmc.bnO();
                        }
                    }
                });
            }
            this.glU = new com.baidu.tieba.write.d(this.gmc.getPageContext().getContext());
            this.glU.setMaxHeight(l.dip2px(this.gmc.getPageContext().getContext(), 225.0f));
            this.glU.setOutsideTouchable(true);
            this.glU.setFocusable(true);
            this.glU.setBackgroundDrawable(ak.getDrawable(d.C0126d.cp_bg_line_b));
            this.glU.a(new d.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.d.a
                public void sP(int i) {
                    c.this.gmc.sO(i);
                    c.this.glT.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.glU.setCurrentIndex(i);
                    c.this.bnS();
                    g.a(c.this.glU, c.this.gmc.getPageContext().getPageActivity());
                }
            });
            this.glU.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.glW.setSelected(false);
                }
            });
            int color = ak.getColor(d.C0126d.common_color_10097);
            ak.i(this.glT, d.f.write_prefix_item_selector);
            ak.c(this.glV, d.f.icon_title_down);
            this.glT.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.gmc.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.gmc.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ak.i(textView, d.f.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.gmc.getPageContext().getContext(), this.gmc.getResources().getDimension(d.e.ds6)), 0, l.dip2px(this.gmc.getPageContext().getContext(), this.gmc.getResources().getDimension(d.e.ds22)), 0);
                this.glU.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.gmc.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.gmc.getPageContext().getContext(), this.gmc.getResources().getDimension(d.e.ds6)), 0, l.dip2px(this.gmc.getPageContext().getContext(), this.gmc.getResources().getDimension(d.e.ds22)), 0);
                }
            }
            this.glU.setCurrentIndex(0);
            return;
        }
        this.glW.setVisibility(8);
    }

    protected void bnR() {
        this.glO = (EditText) this.gmc.findViewById(d.g.post_title);
        if (this.mData.getType() == 3) {
            if (this.mData.getTitle() != null && this.mData.getTitle().trim().length() > 0) {
                this.glO.setText(this.mData.getTitle());
                this.glO.setSelection(this.mData.getTitle().length());
            } else {
                String str = this.gmc.getPageContext().getString(d.k.share_transfer_thread) + this.mData.getShareSummaryTitle();
                this.glO.setText(str);
                if (str.length() < 20) {
                    this.glO.setSelection(str.length());
                } else {
                    this.glO.setSelection(20);
                }
            }
        }
        this.glO.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
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
            String trim = this.glO.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.gmc.bnM() == this.mPrefixData.getPrefixs().size() - 1) {
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
        if (str == null || str.length() <= 0 || !this.gme) {
            this.mPost.setEnabled(false);
        } else {
            this.mPost.setEnabled(true);
        }
    }

    protected void bnT() {
        this.glS = (EditText) this.gmc.findViewById(d.g.post_content);
        this.glS.setDrawingCacheEnabled(false);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString R = TbFaceManager.EZ().R(this.gmc.getPageContext().getContext(), this.mData.getContent());
            this.glS.setText(R);
            this.glS.setSelection(R.length());
        }
        this.glS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view2.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.glS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
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
        return this.glO;
    }

    public EditText bnV() {
        return this.glS;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        bnQ();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.glO.setOnFocusChangeListener(onFocusChangeListener);
        this.glS.setOnFocusChangeListener(onFocusChangeListener);
        this.asg.setOnFocusChangeListener(onFocusChangeListener);
        this.mPost.setOnFocusChangeListener(onFocusChangeListener);
    }

    public com.baidu.tieba.write.d bnW() {
        return this.glU;
    }

    public View bnX() {
        return this.asg;
    }

    public TextView bnY() {
        return this.mPost;
    }

    public TextView bnZ() {
        return this.glT;
    }

    public void S(View.OnClickListener onClickListener) {
        this.asg.setOnClickListener(onClickListener);
    }

    public void T(View.OnClickListener onClickListener) {
        this.mPost.setOnClickListener(onClickListener);
    }

    public void U(View.OnClickListener onClickListener) {
        this.glR.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.gmc != null) {
            this.gmc.getLayoutMode().setNightMode(i == 1);
            this.gmc.getLayoutMode().u(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.gmc.getPageContext(), i);
            ak.d(this.mPost, i);
            ak.j(this.glP, d.C0126d.cp_bg_line_c);
            ak.j(this.glQ, d.C0126d.cp_bg_line_c);
            ak.j(this.glO, d.C0126d.cp_cont_g);
            ak.j(this.glY, d.C0126d.cp_bg_line_e);
            int color = ak.getColor(d.C0126d.cp_cont_b);
            int color2 = ak.getColor(d.C0126d.cp_cont_e);
            this.glO.setTextColor(color);
            this.glS.setTextColor(color);
            this.gma.setTextColor(ak.getColor(d.C0126d.cp_cont_b));
            this.gmb.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
            b(this.glO, color2);
            b(this.glS, color2);
            bnS();
        }
    }

    public ShareSDKImageView boa() {
        return this.glZ;
    }
}
