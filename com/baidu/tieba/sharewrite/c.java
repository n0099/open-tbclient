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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.o;
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
    private View noK;
    private TextView noN;
    private i noO;
    private ImageView noP;
    private View noQ;
    private LinearLayout noR;
    private LinearLayout noS;
    private ShareSDKImageView noT;
    private TextView noU;
    private TextView noV;
    private WriteShareActivity noW;
    private com.baidu.tbadk.img.b noX;
    private WriteData noo;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText noI = null;
    private View noJ = null;
    private LinearLayout noL = null;
    private EditText noM = null;
    private TextView lWH = null;
    private RelativeLayout lzu = null;
    private boolean noY = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.noo = null;
        this.noW = writeShareActivity;
        this.noo = writeShareActivity.daL();
        if (this.noX == null) {
            this.noX = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.noW.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.noW.getPageContext().getString(R.string.share_navigationbar_title));
        this.lWH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.noW.getPageContext().getString(R.string.send_post));
        this.lzu = (RelativeLayout) this.noW.findViewById(R.id.parent);
        this.noJ = this.noW.findViewById(R.id.interval_view);
        this.noK = this.noW.findViewById(R.id.prefix_interval_view);
        this.noR = (LinearLayout) this.noW.findViewById(R.id.post_share_layout);
        this.noS = (LinearLayout) this.noW.findViewById(R.id.post_share_content_layout);
        this.noT = (ShareSDKImageView) this.noW.findViewById(R.id.post_share_image);
        this.noU = (TextView) this.noW.findViewById(R.id.post_share_title);
        this.noV = (TextView) this.noW.findViewById(R.id.post_share_content);
        dKg();
        dKi();
        this.noL = (LinearLayout) this.noW.findViewById(R.id.post_content_container);
        this.noL.setDrawingCacheEnabled(false);
        this.noI.setVisibility(0);
        this.noM.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        dKh();
    }

    public void dKe() {
        this.noR = (LinearLayout) this.noW.findViewById(R.id.post_share_layout);
        this.noT = (ShareSDKImageView) this.noW.findViewById(R.id.post_share_image);
        this.noT.setIsRound(false);
        this.noT.setDrawBorder(false);
        this.noT.setAutoChangeStyle(true);
        this.noT.setRadius(0);
        this.noU = (TextView) this.noW.findViewById(R.id.post_share_title);
        this.noV = (TextView) this.noW.findViewById(R.id.post_share_content);
        if (this.noo != null) {
            if (this.noo.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.noT.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.noT.getLoadedWidth() != 0 && c.this.noT.getLoadedHeight() != 0) {
                                c.this.width = c.this.noT.getLoadedWidth();
                                c.this.height = c.this.noT.getLoadedHeight();
                                if (c.this.noW != null) {
                                    c.this.noW.daL().setShareSummaryImgWidth(c.this.width);
                                    c.this.noW.daL().setShareSummaryImgHeight(c.this.height);
                                    c.this.noY = true;
                                    c.this.dKh();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.noY = false;
                        c.this.dKh();
                        if (c.this.noW != null) {
                            c.this.noW.Jk(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void onCancel() {
                        c.this.noY = false;
                        c.this.dKh();
                        if (c.this.noW != null) {
                            c.this.noW.Jk(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.noo.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.noo.getShareSummaryImg() != null && this.noo.getShareSummaryImg().trim().length() > 0) {
                    this.noT.startLoad(this.noo.getShareSummaryImg(), 10, true);
                } else {
                    this.noY = true;
                    dKh();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.noo.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.noT.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.noo.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(o.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.noo.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.bd(av.bsV().getPostImageSize(), av.bsV().getPostImageHeightLimit()));
                    this.noT.setTag(imageFileInfo.toCachedKey(true));
                    if (this.noX.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.noR.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.noT.invalidate();
                    }
                }
                this.noY = true;
                dKh();
            }
            this.noo.setShareSummaryImgType(f.getExtension(this.noo.getShareSummaryImg()));
            this.noU.setText(this.noo.getShareSummaryTitle());
            this.noV.setText(this.noo.getShareSummaryContent());
        }
    }

    private void dKf() {
        this.noQ = this.noW.findViewById(R.id.post_prefix_layout);
        this.noN = (TextView) this.noW.findViewById(R.id.post_prefix);
        this.noP = (ImageView) this.noW.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.noQ.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.noN.setText(prefixs.get(0));
            this.noW.Jl(0);
            this.noQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.noN.setVisibility(0);
                    c.this.noQ.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.noO, view, l.dip2px(c.this.noW.getPageContext().getContext(), 15.0f), l.dip2px(c.this.noW.getPageContext().getContext(), 1.0f));
                    if (c.this.noW != null) {
                        c.this.noW.dKd();
                    }
                }
            });
            this.noP = (ImageView) this.noW.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.noP.setVisibility(0);
                this.noN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.noN.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.noO, view, l.dip2px(c.this.noW.getPageContext().getContext(), 15.0f), l.dip2px(c.this.noW.getPageContext().getContext(), 1.0f));
                        if (c.this.noW != null) {
                            c.this.noW.dKd();
                        }
                    }
                });
            }
            this.noO = new i(this.noW.getPageContext().getContext());
            this.noO.setMaxHeight(l.dip2px(this.noW.getPageContext().getContext(), 225.0f));
            this.noO.setOutsideTouchable(true);
            this.noO.setFocusable(true);
            this.noO.setBackgroundDrawable(ap.getDrawable(R.color.CAM_X0204));
            this.noO.a(new i.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.i.a
                public void Jm(int i) {
                    c.this.noW.Jl(i);
                    c.this.noN.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.noO.setCurrentIndex(i);
                    c.this.dKh();
                    g.dismissPopupWindow(c.this.noO, c.this.noW.getPageContext().getPageActivity());
                }
            });
            this.noO.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.noQ.setSelected(false);
                }
            });
            int color = ap.getColor(R.color.common_color_10097);
            ap.setBackgroundResource(this.noN, R.drawable.write_prefix_item_selector);
            ap.setImageResource(this.noP, R.drawable.icon_title_down);
            this.noN.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.noW.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.noW.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ap.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.noW.getPageContext().getContext(), this.noW.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.noW.getPageContext().getContext(), this.noW.getResources().getDimension(R.dimen.ds22)), 0);
                this.noO.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.noW.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.noW.getPageContext().getContext(), this.noW.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.noW.getPageContext().getContext(), this.noW.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.noO.setCurrentIndex(0);
            return;
        }
        this.noQ.setVisibility(8);
    }

    protected void dKg() {
        this.noI = (EditText) this.noW.findViewById(R.id.post_title);
        if (this.noo.getType() == 3) {
            if (this.noo.getTitle() != null && this.noo.getTitle().trim().length() > 0) {
                this.noI.setText(this.noo.getTitle());
                this.noI.setSelection(this.noo.getTitle().length());
            } else {
                String str = this.noW.getPageContext().getString(R.string.share_transfer_thread) + this.noo.getShareSummaryTitle();
                this.noI.setText(str);
                if (str.length() < 20) {
                    this.noI.setSelection(str.length());
                } else {
                    this.noI.setSelection(20);
                }
            }
        }
        this.noI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dKh();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void dKh() {
        String str = null;
        if (this.noo.getType() == 3) {
            String trim = this.noI.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.noW.dKb() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.noo.setIsNoTitle(true);
                    } else {
                        this.noo.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.noo.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.noo.setIsNoTitle(true);
            } else {
                this.noo.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.noY) {
            this.lWH.setEnabled(false);
        } else {
            this.lWH.setEnabled(true);
        }
    }

    protected void dKi() {
        this.noM = (EditText) this.noW.findViewById(R.id.post_content);
        this.noM.setDrawingCacheEnabled(false);
        if (this.noo.getContent() != null && this.noo.getContent().length() > 0) {
            SpannableString aD = TbFaceManager.bCR().aD(this.noW.getPageContext().getContext(), this.noo.getContent());
            this.noM.setText(aD);
            this.noM.setSelection(aD.length());
        }
        this.noM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.noM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dKh();
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

    public EditText dKj() {
        return this.noI;
    }

    public EditText dKk() {
        return this.noM;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        dKf();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.noI.setOnFocusChangeListener(onFocusChangeListener);
        this.noM.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.lWH.setOnFocusChangeListener(onFocusChangeListener);
    }

    public i dKl() {
        return this.noO;
    }

    public View dKm() {
        return this.mBack;
    }

    public TextView dKn() {
        return this.lWH;
    }

    public TextView dKo() {
        return this.noN;
    }

    public void ai(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void aj(View.OnClickListener onClickListener) {
        this.lWH.setOnClickListener(onClickListener);
    }

    public void ak(View.OnClickListener onClickListener) {
        this.noL.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.noW != null) {
            this.noW.getLayoutMode().setNightMode(i == 1);
            this.noW.getLayoutMode().onModeChanged(this.lzu);
            this.mNavigationBar.onChangeSkinType(this.noW.getPageContext(), i);
            ap.setTopBarCommonFinishButton(this.lWH, i);
            ap.setBackgroundColor(this.noJ, R.color.CAM_X0204);
            ap.setBackgroundColor(this.noK, R.color.CAM_X0204);
            ap.setBackgroundColor(this.noI, R.color.CAM_X0111);
            ap.setBackgroundColor(this.noS, R.color.CAM_X0205);
            int color = ap.getColor(R.color.CAM_X0105);
            int color2 = ap.getColor(R.color.CAM_X0110);
            this.noI.setTextColor(color);
            this.noM.setTextColor(color);
            this.noU.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.noV.setTextColor(ap.getColor(R.color.CAM_X0109));
            g(this.noI, color2);
            g(this.noM, color2);
            dKh();
        }
    }

    public ShareSDKImageView dKp() {
        return this.noT;
    }
}
