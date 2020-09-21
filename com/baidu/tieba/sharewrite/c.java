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
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.d;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.i;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes23.dex */
public class c {
    private PostPrefixData mPrefixData;
    private WriteData mdW;
    private ShareSDKImageView meA;
    private TextView meB;
    private TextView meC;
    private WriteShareActivity meD;
    private com.baidu.tbadk.img.b meE;
    private View mer;
    private TextView meu;
    private i mev;
    private ImageView mew;
    private View mex;
    private LinearLayout mey;
    private LinearLayout mez;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText mep = null;
    private View meq = null;
    private LinearLayout mes = null;
    private EditText met = null;
    private TextView kOV = null;
    private RelativeLayout jnW = null;
    private boolean meF = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.mdW = null;
        this.meD = writeShareActivity;
        this.mdW = writeShareActivity.cOG();
        if (this.meE == null) {
            this.meE = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.meD.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.meD.getPageContext().getString(R.string.share_navigationbar_title));
        this.kOV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.meD.getPageContext().getString(R.string.send_post));
        this.jnW = (RelativeLayout) this.meD.findViewById(R.id.parent);
        this.meq = this.meD.findViewById(R.id.interval_view);
        this.mer = this.meD.findViewById(R.id.prefix_interval_view);
        this.mey = (LinearLayout) this.meD.findViewById(R.id.post_share_layout);
        this.mez = (LinearLayout) this.meD.findViewById(R.id.post_share_content_layout);
        this.meA = (ShareSDKImageView) this.meD.findViewById(R.id.post_share_image);
        this.meB = (TextView) this.meD.findViewById(R.id.post_share_title);
        this.meC = (TextView) this.meD.findViewById(R.id.post_share_content);
        dxe();
        dxg();
        this.mes = (LinearLayout) this.meD.findViewById(R.id.post_content_container);
        this.mes.setDrawingCacheEnabled(false);
        this.mep.setVisibility(0);
        this.met.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        dxf();
    }

    public void dxc() {
        this.mey = (LinearLayout) this.meD.findViewById(R.id.post_share_layout);
        this.meA = (ShareSDKImageView) this.meD.findViewById(R.id.post_share_image);
        this.meA.setIsRound(false);
        this.meA.setDrawBorder(false);
        this.meA.setAutoChangeStyle(true);
        this.meA.setRadius(0);
        this.meB = (TextView) this.meD.findViewById(R.id.post_share_title);
        this.meC = (TextView) this.meD.findViewById(R.id.post_share_content);
        if (this.mdW != null) {
            if (this.mdW.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.meA.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.meA.getLoadedWidth() != 0 && c.this.meA.getLoadedHeight() != 0) {
                                c.this.width = c.this.meA.getLoadedWidth();
                                c.this.height = c.this.meA.getLoadedHeight();
                                if (c.this.meD != null) {
                                    c.this.meD.cOG().setShareSummaryImgWidth(c.this.width);
                                    c.this.meD.cOG().setShareSummaryImgHeight(c.this.height);
                                    c.this.meF = true;
                                    c.this.dxf();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.meF = false;
                        c.this.dxf();
                        if (c.this.meD != null) {
                            c.this.meD.HT(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.meF = false;
                        c.this.dxf();
                        if (c.this.meD != null) {
                            c.this.meD.HT(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.mdW.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.mdW.getShareSummaryImg() != null && this.mdW.getShareSummaryImg().trim().length() > 0) {
                    this.meA.startLoad(this.mdW.getShareSummaryImg(), 10, true);
                } else {
                    this.meF = true;
                    dxf();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.mdW.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.meA.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.mdW.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.mdW.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.bg(au.bkm().getPostImageSize(), au.bkm().getPostImageHeightLimit()));
                    this.meA.setTag(imageFileInfo.toCachedKey(true));
                    if (this.meE.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.mey.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.meA.invalidate();
                    }
                }
                this.meF = true;
                dxf();
            }
            this.mdW.setShareSummaryImgType(f.getExtension(this.mdW.getShareSummaryImg()));
            this.meB.setText(this.mdW.getShareSummaryTitle());
            this.meC.setText(this.mdW.getShareSummaryContent());
        }
    }

    private void dxd() {
        this.mex = this.meD.findViewById(R.id.post_prefix_layout);
        this.meu = (TextView) this.meD.findViewById(R.id.post_prefix);
        this.mew = (ImageView) this.meD.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mex.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.meu.setText(prefixs.get(0));
            this.meD.HU(0);
            this.mex.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.meu.setVisibility(0);
                    c.this.mex.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.mev, view, l.dip2px(c.this.meD.getPageContext().getContext(), 15.0f), l.dip2px(c.this.meD.getPageContext().getContext(), 1.0f));
                    if (c.this.meD != null) {
                        c.this.meD.dxb();
                    }
                }
            });
            this.mew = (ImageView) this.meD.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.mew.setVisibility(0);
                this.meu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.meu.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.mev, view, l.dip2px(c.this.meD.getPageContext().getContext(), 15.0f), l.dip2px(c.this.meD.getPageContext().getContext(), 1.0f));
                        if (c.this.meD != null) {
                            c.this.meD.dxb();
                        }
                    }
                });
            }
            this.mev = new i(this.meD.getPageContext().getContext());
            this.mev.setMaxHeight(l.dip2px(this.meD.getPageContext().getContext(), 225.0f));
            this.mev.setOutsideTouchable(true);
            this.mev.setFocusable(true);
            this.mev.setBackgroundDrawable(ap.getDrawable(R.color.cp_bg_line_c));
            this.mev.a(new i.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.i.a
                public void HV(int i) {
                    c.this.meD.HU(i);
                    c.this.meu.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.mev.setCurrentIndex(i);
                    c.this.dxf();
                    g.dismissPopupWindow(c.this.mev, c.this.meD.getPageContext().getPageActivity());
                }
            });
            this.mev.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.mex.setSelected(false);
                }
            });
            int color = ap.getColor(R.color.common_color_10097);
            ap.setBackgroundResource(this.meu, R.drawable.write_prefix_item_selector);
            ap.setImageResource(this.mew, R.drawable.icon_title_down);
            this.meu.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.meD.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.meD.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ap.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.meD.getPageContext().getContext(), this.meD.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.meD.getPageContext().getContext(), this.meD.getResources().getDimension(R.dimen.ds22)), 0);
                this.mev.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.meD.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.meD.getPageContext().getContext(), this.meD.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.meD.getPageContext().getContext(), this.meD.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.mev.setCurrentIndex(0);
            return;
        }
        this.mex.setVisibility(8);
    }

    protected void dxe() {
        this.mep = (EditText) this.meD.findViewById(R.id.post_title);
        if (this.mdW.getType() == 3) {
            if (this.mdW.getTitle() != null && this.mdW.getTitle().trim().length() > 0) {
                this.mep.setText(this.mdW.getTitle());
                this.mep.setSelection(this.mdW.getTitle().length());
            } else {
                String str = this.meD.getPageContext().getString(R.string.share_transfer_thread) + this.mdW.getShareSummaryTitle();
                this.mep.setText(str);
                if (str.length() < 20) {
                    this.mep.setSelection(str.length());
                } else {
                    this.mep.setSelection(20);
                }
            }
        }
        this.mep.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dxf();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void dxf() {
        String str = null;
        if (this.mdW.getType() == 3) {
            String trim = this.mep.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.meD.dwZ() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.mdW.setIsNoTitle(true);
                    } else {
                        this.mdW.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.mdW.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.mdW.setIsNoTitle(true);
            } else {
                this.mdW.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.meF) {
            this.kOV.setEnabled(false);
        } else {
            this.kOV.setEnabled(true);
        }
    }

    protected void dxg() {
        this.met = (EditText) this.meD.findViewById(R.id.post_content);
        this.met.setDrawingCacheEnabled(false);
        if (this.mdW.getContent() != null && this.mdW.getContent().length() > 0) {
            SpannableString as = TbFaceManager.bua().as(this.meD.getPageContext().getContext(), this.mdW.getContent());
            this.met.setText(as);
            this.met.setSelection(as.length());
        }
        this.met.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.met.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dxf();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    private void h(EditText editText, int i) {
        Editable text = editText.getText();
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        editText.setText((CharSequence) null);
        editText.setHintTextColor(i);
        editText.setText(text);
        editText.setSelection(selectionStart, selectionEnd);
    }

    public EditText dxh() {
        return this.mep;
    }

    public EditText dxi() {
        return this.met;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        dxd();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.mep.setOnFocusChangeListener(onFocusChangeListener);
        this.met.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.kOV.setOnFocusChangeListener(onFocusChangeListener);
    }

    public i dxj() {
        return this.mev;
    }

    public View dxk() {
        return this.mBack;
    }

    public TextView dxl() {
        return this.kOV;
    }

    public TextView dxm() {
        return this.meu;
    }

    public void ae(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void af(View.OnClickListener onClickListener) {
        this.kOV.setOnClickListener(onClickListener);
    }

    public void ag(View.OnClickListener onClickListener) {
        this.mes.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.meD != null) {
            this.meD.getLayoutMode().setNightMode(i == 1);
            this.meD.getLayoutMode().onModeChanged(this.jnW);
            this.mNavigationBar.onChangeSkinType(this.meD.getPageContext(), i);
            ap.setTopBarCommonFinishButton(this.kOV, i);
            ap.setBackgroundColor(this.meq, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.mer, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.mep, R.color.cp_cont_g);
            ap.setBackgroundColor(this.mez, R.color.cp_bg_line_e);
            int color = ap.getColor(R.color.cp_cont_b);
            int color2 = ap.getColor(R.color.cp_cont_e);
            this.mep.setTextColor(color);
            this.met.setTextColor(color);
            this.meB.setTextColor(ap.getColor(R.color.cp_cont_b));
            this.meC.setTextColor(ap.getColor(R.color.cp_cont_d));
            h(this.mep, color2);
            h(this.met, color2);
            dxf();
        }
    }

    public ShareSDKImageView dxn() {
        return this.meA;
    }
}
