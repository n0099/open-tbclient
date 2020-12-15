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
/* loaded from: classes24.dex */
public class c {
    private PostPrefixData mPrefixData;
    private TextView nbB;
    private i nbC;
    private ImageView nbD;
    private View nbE;
    private LinearLayout nbF;
    private LinearLayout nbG;
    private ShareSDKImageView nbH;
    private TextView nbI;
    private TextView nbJ;
    private WriteShareActivity nbK;
    private com.baidu.tbadk.img.b nbL;
    private WriteData nbe;
    private View nby;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText nbw = null;
    private View nbx = null;
    private LinearLayout nbz = null;
    private EditText nbA = null;
    private TextView lKM = null;
    private RelativeLayout kjG = null;
    private boolean nbM = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.nbe = null;
        this.nbK = writeShareActivity;
        this.nbe = writeShareActivity.dcE();
        if (this.nbL == null) {
            this.nbL = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.nbK.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.nbK.getPageContext().getString(R.string.share_navigationbar_title));
        this.lKM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.nbK.getPageContext().getString(R.string.send_post));
        this.kjG = (RelativeLayout) this.nbK.findViewById(R.id.parent);
        this.nbx = this.nbK.findViewById(R.id.interval_view);
        this.nby = this.nbK.findViewById(R.id.prefix_interval_view);
        this.nbF = (LinearLayout) this.nbK.findViewById(R.id.post_share_layout);
        this.nbG = (LinearLayout) this.nbK.findViewById(R.id.post_share_content_layout);
        this.nbH = (ShareSDKImageView) this.nbK.findViewById(R.id.post_share_image);
        this.nbI = (TextView) this.nbK.findViewById(R.id.post_share_title);
        this.nbJ = (TextView) this.nbK.findViewById(R.id.post_share_content);
        dLF();
        dLH();
        this.nbz = (LinearLayout) this.nbK.findViewById(R.id.post_content_container);
        this.nbz.setDrawingCacheEnabled(false);
        this.nbw.setVisibility(0);
        this.nbA.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        dLG();
    }

    public void dLD() {
        this.nbF = (LinearLayout) this.nbK.findViewById(R.id.post_share_layout);
        this.nbH = (ShareSDKImageView) this.nbK.findViewById(R.id.post_share_image);
        this.nbH.setIsRound(false);
        this.nbH.setDrawBorder(false);
        this.nbH.setAutoChangeStyle(true);
        this.nbH.setRadius(0);
        this.nbI = (TextView) this.nbK.findViewById(R.id.post_share_title);
        this.nbJ = (TextView) this.nbK.findViewById(R.id.post_share_content);
        if (this.nbe != null) {
            if (this.nbe.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.nbH.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.nbH.getLoadedWidth() != 0 && c.this.nbH.getLoadedHeight() != 0) {
                                c.this.width = c.this.nbH.getLoadedWidth();
                                c.this.height = c.this.nbH.getLoadedHeight();
                                if (c.this.nbK != null) {
                                    c.this.nbK.dcE().setShareSummaryImgWidth(c.this.width);
                                    c.this.nbK.dcE().setShareSummaryImgHeight(c.this.height);
                                    c.this.nbM = true;
                                    c.this.dLG();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.nbM = false;
                        c.this.dLG();
                        if (c.this.nbK != null) {
                            c.this.nbK.Ky(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.nbM = false;
                        c.this.dLG();
                        if (c.this.nbK != null) {
                            c.this.nbK.Ky(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.nbe.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.nbe.getShareSummaryImg() != null && this.nbe.getShareSummaryImg().trim().length() > 0) {
                    this.nbH.startLoad(this.nbe.getShareSummaryImg(), 10, true);
                } else {
                    this.nbM = true;
                    dLG();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.nbe.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.nbH.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.nbe.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.nbe.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.bi(av.btX().getPostImageSize(), av.btX().getPostImageHeightLimit()));
                    this.nbH.setTag(imageFileInfo.toCachedKey(true));
                    if (this.nbL.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.nbF.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.nbH.invalidate();
                    }
                }
                this.nbM = true;
                dLG();
            }
            this.nbe.setShareSummaryImgType(f.getExtension(this.nbe.getShareSummaryImg()));
            this.nbI.setText(this.nbe.getShareSummaryTitle());
            this.nbJ.setText(this.nbe.getShareSummaryContent());
        }
    }

    private void dLE() {
        this.nbE = this.nbK.findViewById(R.id.post_prefix_layout);
        this.nbB = (TextView) this.nbK.findViewById(R.id.post_prefix);
        this.nbD = (ImageView) this.nbK.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.nbE.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.nbB.setText(prefixs.get(0));
            this.nbK.Kz(0);
            this.nbE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.nbB.setVisibility(0);
                    c.this.nbE.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.nbC, view, l.dip2px(c.this.nbK.getPageContext().getContext(), 15.0f), l.dip2px(c.this.nbK.getPageContext().getContext(), 1.0f));
                    if (c.this.nbK != null) {
                        c.this.nbK.dLC();
                    }
                }
            });
            this.nbD = (ImageView) this.nbK.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.nbD.setVisibility(0);
                this.nbB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.nbB.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.nbC, view, l.dip2px(c.this.nbK.getPageContext().getContext(), 15.0f), l.dip2px(c.this.nbK.getPageContext().getContext(), 1.0f));
                        if (c.this.nbK != null) {
                            c.this.nbK.dLC();
                        }
                    }
                });
            }
            this.nbC = new i(this.nbK.getPageContext().getContext());
            this.nbC.setMaxHeight(l.dip2px(this.nbK.getPageContext().getContext(), 225.0f));
            this.nbC.setOutsideTouchable(true);
            this.nbC.setFocusable(true);
            this.nbC.setBackgroundDrawable(ap.getDrawable(R.color.CAM_X0204));
            this.nbC.a(new i.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.i.a
                public void KA(int i) {
                    c.this.nbK.Kz(i);
                    c.this.nbB.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.nbC.setCurrentIndex(i);
                    c.this.dLG();
                    g.dismissPopupWindow(c.this.nbC, c.this.nbK.getPageContext().getPageActivity());
                }
            });
            this.nbC.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.nbE.setSelected(false);
                }
            });
            int color = ap.getColor(R.color.common_color_10097);
            ap.setBackgroundResource(this.nbB, R.drawable.write_prefix_item_selector);
            ap.setImageResource(this.nbD, R.drawable.icon_title_down);
            this.nbB.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.nbK.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.nbK.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ap.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.nbK.getPageContext().getContext(), this.nbK.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.nbK.getPageContext().getContext(), this.nbK.getResources().getDimension(R.dimen.ds22)), 0);
                this.nbC.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.nbK.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.nbK.getPageContext().getContext(), this.nbK.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.nbK.getPageContext().getContext(), this.nbK.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.nbC.setCurrentIndex(0);
            return;
        }
        this.nbE.setVisibility(8);
    }

    protected void dLF() {
        this.nbw = (EditText) this.nbK.findViewById(R.id.post_title);
        if (this.nbe.getType() == 3) {
            if (this.nbe.getTitle() != null && this.nbe.getTitle().trim().length() > 0) {
                this.nbw.setText(this.nbe.getTitle());
                this.nbw.setSelection(this.nbe.getTitle().length());
            } else {
                String str = this.nbK.getPageContext().getString(R.string.share_transfer_thread) + this.nbe.getShareSummaryTitle();
                this.nbw.setText(str);
                if (str.length() < 20) {
                    this.nbw.setSelection(str.length());
                } else {
                    this.nbw.setSelection(20);
                }
            }
        }
        this.nbw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dLG();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void dLG() {
        String str = null;
        if (this.nbe.getType() == 3) {
            String trim = this.nbw.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.nbK.dLA() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.nbe.setIsNoTitle(true);
                    } else {
                        this.nbe.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.nbe.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.nbe.setIsNoTitle(true);
            } else {
                this.nbe.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.nbM) {
            this.lKM.setEnabled(false);
        } else {
            this.lKM.setEnabled(true);
        }
    }

    protected void dLH() {
        this.nbA = (EditText) this.nbK.findViewById(R.id.post_content);
        this.nbA.setDrawingCacheEnabled(false);
        if (this.nbe.getContent() != null && this.nbe.getContent().length() > 0) {
            SpannableString aw = TbFaceManager.bDU().aw(this.nbK.getPageContext().getContext(), this.nbe.getContent());
            this.nbA.setText(aw);
            this.nbA.setSelection(aw.length());
        }
        this.nbA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.nbA.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dLG();
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

    public EditText dLI() {
        return this.nbw;
    }

    public EditText dLJ() {
        return this.nbA;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        dLE();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.nbw.setOnFocusChangeListener(onFocusChangeListener);
        this.nbA.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.lKM.setOnFocusChangeListener(onFocusChangeListener);
    }

    public i dLK() {
        return this.nbC;
    }

    public View dLL() {
        return this.mBack;
    }

    public TextView dLM() {
        return this.lKM;
    }

    public TextView dLN() {
        return this.nbB;
    }

    public void af(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ag(View.OnClickListener onClickListener) {
        this.lKM.setOnClickListener(onClickListener);
    }

    public void ah(View.OnClickListener onClickListener) {
        this.nbz.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.nbK != null) {
            this.nbK.getLayoutMode().setNightMode(i == 1);
            this.nbK.getLayoutMode().onModeChanged(this.kjG);
            this.mNavigationBar.onChangeSkinType(this.nbK.getPageContext(), i);
            ap.setTopBarCommonFinishButton(this.lKM, i);
            ap.setBackgroundColor(this.nbx, R.color.CAM_X0204);
            ap.setBackgroundColor(this.nby, R.color.CAM_X0204);
            ap.setBackgroundColor(this.nbw, R.color.CAM_X0111);
            ap.setBackgroundColor(this.nbG, R.color.CAM_X0205);
            int color = ap.getColor(R.color.CAM_X0105);
            int color2 = ap.getColor(R.color.CAM_X0110);
            this.nbw.setTextColor(color);
            this.nbA.setTextColor(color);
            this.nbI.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.nbJ.setTextColor(ap.getColor(R.color.CAM_X0109));
            g(this.nbw, color2);
            g(this.nbA, color2);
            dLG();
        }
    }

    public ShareSDKImageView dLO() {
        return this.nbH;
    }
}
