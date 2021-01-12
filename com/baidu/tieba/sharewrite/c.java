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
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes7.dex */
public class c {
    private PostPrefixData mPrefixData;
    private i ncA;
    private ImageView ncB;
    private View ncC;
    private LinearLayout ncD;
    private LinearLayout ncE;
    private ShareSDKImageView ncF;
    private TextView ncG;
    private TextView ncH;
    private WriteShareActivity ncI;
    private com.baidu.tbadk.img.b ncJ;
    private WriteData ncc;
    private View ncw;
    private TextView ncz;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText ncu = null;
    private View ncv = null;
    private LinearLayout ncx = null;
    private EditText ncy = null;
    private TextView lLu = null;
    private RelativeLayout loZ = null;
    private boolean ncK = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.ncc = null;
        this.ncI = writeShareActivity;
        this.ncc = writeShareActivity.cYx();
        if (this.ncJ == null) {
            this.ncJ = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.ncI.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.ncI.getPageContext().getString(R.string.share_navigationbar_title));
        this.lLu = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.ncI.getPageContext().getString(R.string.send_post));
        this.loZ = (RelativeLayout) this.ncI.findViewById(R.id.parent);
        this.ncv = this.ncI.findViewById(R.id.interval_view);
        this.ncw = this.ncI.findViewById(R.id.prefix_interval_view);
        this.ncD = (LinearLayout) this.ncI.findViewById(R.id.post_share_layout);
        this.ncE = (LinearLayout) this.ncI.findViewById(R.id.post_share_content_layout);
        this.ncF = (ShareSDKImageView) this.ncI.findViewById(R.id.post_share_image);
        this.ncG = (TextView) this.ncI.findViewById(R.id.post_share_title);
        this.ncH = (TextView) this.ncI.findViewById(R.id.post_share_content);
        dHF();
        dHH();
        this.ncx = (LinearLayout) this.ncI.findViewById(R.id.post_content_container);
        this.ncx.setDrawingCacheEnabled(false);
        this.ncu.setVisibility(0);
        this.ncy.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        dHG();
    }

    public void dHD() {
        this.ncD = (LinearLayout) this.ncI.findViewById(R.id.post_share_layout);
        this.ncF = (ShareSDKImageView) this.ncI.findViewById(R.id.post_share_image);
        this.ncF.setIsRound(false);
        this.ncF.setDrawBorder(false);
        this.ncF.setAutoChangeStyle(true);
        this.ncF.setRadius(0);
        this.ncG = (TextView) this.ncI.findViewById(R.id.post_share_title);
        this.ncH = (TextView) this.ncI.findViewById(R.id.post_share_content);
        if (this.ncc != null) {
            if (this.ncc.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.ncF.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.ncF.getLoadedWidth() != 0 && c.this.ncF.getLoadedHeight() != 0) {
                                c.this.width = c.this.ncF.getLoadedWidth();
                                c.this.height = c.this.ncF.getLoadedHeight();
                                if (c.this.ncI != null) {
                                    c.this.ncI.cYx().setShareSummaryImgWidth(c.this.width);
                                    c.this.ncI.cYx().setShareSummaryImgHeight(c.this.height);
                                    c.this.ncK = true;
                                    c.this.dHG();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.ncK = false;
                        c.this.dHG();
                        if (c.this.ncI != null) {
                            c.this.ncI.IM(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void onCancel() {
                        c.this.ncK = false;
                        c.this.dHG();
                        if (c.this.ncI != null) {
                            c.this.ncI.IM(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.ncc.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.ncc.getShareSummaryImg() != null && this.ncc.getShareSummaryImg().trim().length() > 0) {
                    this.ncF.startLoad(this.ncc.getShareSummaryImg(), 10, true);
                } else {
                    this.ncK = true;
                    dHG();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.ncc.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.ncF.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.ncc.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.ncc.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.bg(au.bsy().getPostImageSize(), au.bsy().getPostImageHeightLimit()));
                    this.ncF.setTag(imageFileInfo.toCachedKey(true));
                    if (this.ncJ.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.ncD.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.ncF.invalidate();
                    }
                }
                this.ncK = true;
                dHG();
            }
            this.ncc.setShareSummaryImgType(f.getExtension(this.ncc.getShareSummaryImg()));
            this.ncG.setText(this.ncc.getShareSummaryTitle());
            this.ncH.setText(this.ncc.getShareSummaryContent());
        }
    }

    private void dHE() {
        this.ncC = this.ncI.findViewById(R.id.post_prefix_layout);
        this.ncz = (TextView) this.ncI.findViewById(R.id.post_prefix);
        this.ncB = (ImageView) this.ncI.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.ncC.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.ncz.setText(prefixs.get(0));
            this.ncI.IN(0);
            this.ncC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.ncz.setVisibility(0);
                    c.this.ncC.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.ncA, view, l.dip2px(c.this.ncI.getPageContext().getContext(), 15.0f), l.dip2px(c.this.ncI.getPageContext().getContext(), 1.0f));
                    if (c.this.ncI != null) {
                        c.this.ncI.dHC();
                    }
                }
            });
            this.ncB = (ImageView) this.ncI.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.ncB.setVisibility(0);
                this.ncz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.ncz.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.ncA, view, l.dip2px(c.this.ncI.getPageContext().getContext(), 15.0f), l.dip2px(c.this.ncI.getPageContext().getContext(), 1.0f));
                        if (c.this.ncI != null) {
                            c.this.ncI.dHC();
                        }
                    }
                });
            }
            this.ncA = new i(this.ncI.getPageContext().getContext());
            this.ncA.setMaxHeight(l.dip2px(this.ncI.getPageContext().getContext(), 225.0f));
            this.ncA.setOutsideTouchable(true);
            this.ncA.setFocusable(true);
            this.ncA.setBackgroundDrawable(ao.getDrawable(R.color.CAM_X0204));
            this.ncA.a(new i.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.i.a
                public void IO(int i) {
                    c.this.ncI.IN(i);
                    c.this.ncz.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.ncA.setCurrentIndex(i);
                    c.this.dHG();
                    g.dismissPopupWindow(c.this.ncA, c.this.ncI.getPageContext().getPageActivity());
                }
            });
            this.ncA.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.ncC.setSelected(false);
                }
            });
            int color = ao.getColor(R.color.common_color_10097);
            ao.setBackgroundResource(this.ncz, R.drawable.write_prefix_item_selector);
            ao.setImageResource(this.ncB, R.drawable.icon_title_down);
            this.ncz.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.ncI.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.ncI.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ao.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.ncI.getPageContext().getContext(), this.ncI.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.ncI.getPageContext().getContext(), this.ncI.getResources().getDimension(R.dimen.ds22)), 0);
                this.ncA.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.ncI.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.ncI.getPageContext().getContext(), this.ncI.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.ncI.getPageContext().getContext(), this.ncI.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.ncA.setCurrentIndex(0);
            return;
        }
        this.ncC.setVisibility(8);
    }

    protected void dHF() {
        this.ncu = (EditText) this.ncI.findViewById(R.id.post_title);
        if (this.ncc.getType() == 3) {
            if (this.ncc.getTitle() != null && this.ncc.getTitle().trim().length() > 0) {
                this.ncu.setText(this.ncc.getTitle());
                this.ncu.setSelection(this.ncc.getTitle().length());
            } else {
                String str = this.ncI.getPageContext().getString(R.string.share_transfer_thread) + this.ncc.getShareSummaryTitle();
                this.ncu.setText(str);
                if (str.length() < 20) {
                    this.ncu.setSelection(str.length());
                } else {
                    this.ncu.setSelection(20);
                }
            }
        }
        this.ncu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dHG();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void dHG() {
        String str = null;
        if (this.ncc.getType() == 3) {
            String trim = this.ncu.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.ncI.dHA() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.ncc.setIsNoTitle(true);
                    } else {
                        this.ncc.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.ncc.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.ncc.setIsNoTitle(true);
            } else {
                this.ncc.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.ncK) {
            this.lLu.setEnabled(false);
        } else {
            this.lLu.setEnabled(true);
        }
    }

    protected void dHH() {
        this.ncy = (EditText) this.ncI.findViewById(R.id.post_content);
        this.ncy.setDrawingCacheEnabled(false);
        if (this.ncc.getContent() != null && this.ncc.getContent().length() > 0) {
            SpannableString aE = TbFaceManager.bCw().aE(this.ncI.getPageContext().getContext(), this.ncc.getContent());
            this.ncy.setText(aE);
            this.ncy.setSelection(aE.length());
        }
        this.ncy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.ncy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dHG();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    private void g(EditText editText, int i) {
        Editable text = editText.getText();
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        editText.setText((CharSequence) null);
        editText.setHintTextColor(i);
        editText.setText(text);
        editText.setSelection(selectionStart, selectionEnd);
    }

    public EditText dHI() {
        return this.ncu;
    }

    public EditText dHJ() {
        return this.ncy;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        dHE();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.ncu.setOnFocusChangeListener(onFocusChangeListener);
        this.ncy.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.lLu.setOnFocusChangeListener(onFocusChangeListener);
    }

    public i dHK() {
        return this.ncA;
    }

    public View dHL() {
        return this.mBack;
    }

    public TextView dHM() {
        return this.lLu;
    }

    public TextView dHN() {
        return this.ncz;
    }

    public void ah(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ai(View.OnClickListener onClickListener) {
        this.lLu.setOnClickListener(onClickListener);
    }

    public void aj(View.OnClickListener onClickListener) {
        this.ncx.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.ncI != null) {
            this.ncI.getLayoutMode().setNightMode(i == 1);
            this.ncI.getLayoutMode().onModeChanged(this.loZ);
            this.mNavigationBar.onChangeSkinType(this.ncI.getPageContext(), i);
            ao.setTopBarCommonFinishButton(this.lLu, i);
            ao.setBackgroundColor(this.ncv, R.color.CAM_X0204);
            ao.setBackgroundColor(this.ncw, R.color.CAM_X0204);
            ao.setBackgroundColor(this.ncu, R.color.CAM_X0111);
            ao.setBackgroundColor(this.ncE, R.color.CAM_X0205);
            int color = ao.getColor(R.color.CAM_X0105);
            int color2 = ao.getColor(R.color.CAM_X0110);
            this.ncu.setTextColor(color);
            this.ncy.setTextColor(color);
            this.ncG.setTextColor(ao.getColor(R.color.CAM_X0105));
            this.ncH.setTextColor(ao.getColor(R.color.CAM_X0109));
            g(this.ncu, color2);
            g(this.ncy, color2);
            dHG();
        }
    }

    public ShareSDKImageView dHO() {
        return this.ncF;
    }
}
