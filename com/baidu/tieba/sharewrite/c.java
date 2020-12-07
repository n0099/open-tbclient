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
    private i nbA;
    private ImageView nbB;
    private View nbC;
    private LinearLayout nbD;
    private LinearLayout nbE;
    private ShareSDKImageView nbF;
    private TextView nbG;
    private TextView nbH;
    private WriteShareActivity nbI;
    private com.baidu.tbadk.img.b nbJ;
    private WriteData nbc;
    private View nbw;
    private TextView nbz;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText nbu = null;
    private View nbv = null;
    private LinearLayout nbx = null;
    private EditText nby = null;
    private TextView lKK = null;
    private RelativeLayout kjE = null;
    private boolean nbK = false;
    private int width = 0;
    private int height = 0;

    public c(WriteShareActivity writeShareActivity) {
        this.nbc = null;
        this.nbI = writeShareActivity;
        this.nbc = writeShareActivity.dcD();
        if (this.nbJ == null) {
            this.nbJ = new com.baidu.tbadk.img.b();
        }
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.nbI.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.nbI.getPageContext().getString(R.string.share_navigationbar_title));
        this.lKK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.nbI.getPageContext().getString(R.string.send_post));
        this.kjE = (RelativeLayout) this.nbI.findViewById(R.id.parent);
        this.nbv = this.nbI.findViewById(R.id.interval_view);
        this.nbw = this.nbI.findViewById(R.id.prefix_interval_view);
        this.nbD = (LinearLayout) this.nbI.findViewById(R.id.post_share_layout);
        this.nbE = (LinearLayout) this.nbI.findViewById(R.id.post_share_content_layout);
        this.nbF = (ShareSDKImageView) this.nbI.findViewById(R.id.post_share_image);
        this.nbG = (TextView) this.nbI.findViewById(R.id.post_share_title);
        this.nbH = (TextView) this.nbI.findViewById(R.id.post_share_content);
        dLE();
        dLG();
        this.nbx = (LinearLayout) this.nbI.findViewById(R.id.post_content_container);
        this.nbx.setDrawingCacheEnabled(false);
        this.nbu.setVisibility(0);
        this.nby.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        dLF();
    }

    public void dLC() {
        this.nbD = (LinearLayout) this.nbI.findViewById(R.id.post_share_layout);
        this.nbF = (ShareSDKImageView) this.nbI.findViewById(R.id.post_share_image);
        this.nbF.setIsRound(false);
        this.nbF.setDrawBorder(false);
        this.nbF.setAutoChangeStyle(true);
        this.nbF.setRadius(0);
        this.nbG = (TextView) this.nbI.findViewById(R.id.post_share_title);
        this.nbH = (TextView) this.nbI.findViewById(R.id.post_share_content);
        if (this.nbc != null) {
            if (this.nbc.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.nbF.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.sharewrite.c.1
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                        if (z) {
                            if (c.this.nbF.getLoadedWidth() != 0 && c.this.nbF.getLoadedHeight() != 0) {
                                c.this.width = c.this.nbF.getLoadedWidth();
                                c.this.height = c.this.nbF.getLoadedHeight();
                                if (c.this.nbI != null) {
                                    c.this.nbI.dcD().setShareSummaryImgWidth(c.this.width);
                                    c.this.nbI.dcD().setShareSummaryImgHeight(c.this.height);
                                    c.this.nbK = true;
                                    c.this.dLF();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        c.this.nbK = false;
                        c.this.dLF();
                        if (c.this.nbI != null) {
                            c.this.nbI.Ky(R.string.share_load_image_fail_tip);
                        }
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                        c.this.nbK = false;
                        c.this.dLF();
                        if (c.this.nbI != null) {
                            c.this.nbI.Ky(R.string.share_load_image_fail_tip);
                        }
                    }
                });
            }
            if (this.nbc.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.nbc.getShareSummaryImg() != null && this.nbc.getShareSummaryImg().trim().length() > 0) {
                    this.nbF.startLoad(this.nbc.getShareSummaryImg(), 10, true);
                } else {
                    this.nbK = true;
                    dLF();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.nbc.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.nbF.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.nbc.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.nbc.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.bi(av.btX().getPostImageSize(), av.btX().getPostImageHeightLimit()));
                    this.nbF.setTag(imageFileInfo.toCachedKey(true));
                    if (this.nbJ.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.sharewrite.c.2
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) c.this.nbD.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true) != null) {
                        this.nbF.invalidate();
                    }
                }
                this.nbK = true;
                dLF();
            }
            this.nbc.setShareSummaryImgType(f.getExtension(this.nbc.getShareSummaryImg()));
            this.nbG.setText(this.nbc.getShareSummaryTitle());
            this.nbH.setText(this.nbc.getShareSummaryContent());
        }
    }

    private void dLD() {
        this.nbC = this.nbI.findViewById(R.id.post_prefix_layout);
        this.nbz = (TextView) this.nbI.findViewById(R.id.post_prefix);
        this.nbB = (ImageView) this.nbI.findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.nbC.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.nbz.setText(prefixs.get(0));
            this.nbI.Kz(0);
            this.nbC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.nbz.setVisibility(0);
                    c.this.nbC.setSelected(true);
                    g.showPopupWindowAsDropDown(c.this.nbA, view, l.dip2px(c.this.nbI.getPageContext().getContext(), 15.0f), l.dip2px(c.this.nbI.getPageContext().getContext(), 1.0f));
                    if (c.this.nbI != null) {
                        c.this.nbI.dLB();
                    }
                }
            });
            this.nbB = (ImageView) this.nbI.findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.nbB.setVisibility(0);
                this.nbz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.nbz.setSelected(true);
                        g.showPopupWindowAsDropDown(c.this.nbA, view, l.dip2px(c.this.nbI.getPageContext().getContext(), 15.0f), l.dip2px(c.this.nbI.getPageContext().getContext(), 1.0f));
                        if (c.this.nbI != null) {
                            c.this.nbI.dLB();
                        }
                    }
                });
            }
            this.nbA = new i(this.nbI.getPageContext().getContext());
            this.nbA.setMaxHeight(l.dip2px(this.nbI.getPageContext().getContext(), 225.0f));
            this.nbA.setOutsideTouchable(true);
            this.nbA.setFocusable(true);
            this.nbA.setBackgroundDrawable(ap.getDrawable(R.color.CAM_X0204));
            this.nbA.a(new i.a() { // from class: com.baidu.tieba.sharewrite.c.5
                @Override // com.baidu.tieba.write.i.a
                public void KA(int i) {
                    c.this.nbI.Kz(i);
                    c.this.nbz.setText(c.this.mPrefixData.getPrefixs().get(i));
                    c.this.nbA.setCurrentIndex(i);
                    c.this.dLF();
                    g.dismissPopupWindow(c.this.nbA, c.this.nbI.getPageContext().getPageActivity());
                }
            });
            this.nbA.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.sharewrite.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.nbC.setSelected(false);
                }
            });
            int color = ap.getColor(R.color.common_color_10097);
            ap.setBackgroundResource(this.nbz, R.drawable.write_prefix_item_selector);
            ap.setImageResource(this.nbB, R.drawable.icon_title_down);
            this.nbz.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.nbI.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.dip2px(this.nbI.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                ap.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.dip2px(this.nbI.getPageContext().getContext(), this.nbI.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.nbI.getPageContext().getContext(), this.nbI.getResources().getDimension(R.dimen.ds22)), 0);
                this.nbA.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = l.dip2px(this.nbI.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.dip2px(this.nbI.getPageContext().getContext(), this.nbI.getResources().getDimension(R.dimen.ds6)), 0, l.dip2px(this.nbI.getPageContext().getContext(), this.nbI.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.nbA.setCurrentIndex(0);
            return;
        }
        this.nbC.setVisibility(8);
    }

    protected void dLE() {
        this.nbu = (EditText) this.nbI.findViewById(R.id.post_title);
        if (this.nbc.getType() == 3) {
            if (this.nbc.getTitle() != null && this.nbc.getTitle().trim().length() > 0) {
                this.nbu.setText(this.nbc.getTitle());
                this.nbu.setSelection(this.nbc.getTitle().length());
            } else {
                String str = this.nbI.getPageContext().getString(R.string.share_transfer_thread) + this.nbc.getShareSummaryTitle();
                this.nbu.setText(str);
                if (str.length() < 20) {
                    this.nbu.setSelection(str.length());
                } else {
                    this.nbu.setSelection(20);
                }
            }
        }
        this.nbu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dLF();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void dLF() {
        String str = null;
        if (this.nbc.getType() == 3) {
            String trim = this.nbu.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.nbI.dLz() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.nbc.setIsNoTitle(true);
                    } else {
                        this.nbc.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.nbc.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.nbc.setIsNoTitle(true);
            } else {
                this.nbc.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.nbK) {
            this.lKK.setEnabled(false);
        } else {
            this.lKK.setEnabled(true);
        }
    }

    protected void dLG() {
        this.nby = (EditText) this.nbI.findViewById(R.id.post_content);
        this.nby.setDrawingCacheEnabled(false);
        if (this.nbc.getContent() != null && this.nbc.getContent().length() > 0) {
            SpannableString aw = TbFaceManager.bDU().aw(this.nbI.getPageContext().getContext(), this.nbc.getContent());
            this.nby.setText(aw);
            this.nby.setSelection(aw.length());
        }
        this.nby.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.sharewrite.c.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.nby.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.sharewrite.c.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.this.dLF();
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

    public EditText dLH() {
        return this.nbu;
    }

    public EditText dLI() {
        return this.nby;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        dLD();
    }

    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        this.nbu.setOnFocusChangeListener(onFocusChangeListener);
        this.nby.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.lKK.setOnFocusChangeListener(onFocusChangeListener);
    }

    public i dLJ() {
        return this.nbA;
    }

    public View dLK() {
        return this.mBack;
    }

    public TextView dLL() {
        return this.lKK;
    }

    public TextView dLM() {
        return this.nbz;
    }

    public void af(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void ag(View.OnClickListener onClickListener) {
        this.lKK.setOnClickListener(onClickListener);
    }

    public void ah(View.OnClickListener onClickListener) {
        this.nbx.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.nbI != null) {
            this.nbI.getLayoutMode().setNightMode(i == 1);
            this.nbI.getLayoutMode().onModeChanged(this.kjE);
            this.mNavigationBar.onChangeSkinType(this.nbI.getPageContext(), i);
            ap.setTopBarCommonFinishButton(this.lKK, i);
            ap.setBackgroundColor(this.nbv, R.color.CAM_X0204);
            ap.setBackgroundColor(this.nbw, R.color.CAM_X0204);
            ap.setBackgroundColor(this.nbu, R.color.CAM_X0111);
            ap.setBackgroundColor(this.nbE, R.color.CAM_X0205);
            int color = ap.getColor(R.color.CAM_X0105);
            int color2 = ap.getColor(R.color.CAM_X0110);
            this.nbu.setTextColor(color);
            this.nby.setTextColor(color);
            this.nbG.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.nbH.setTextColor(ap.getColor(R.color.CAM_X0109));
            g(this.nbu, color2);
            g(this.nby, color2);
            dLF();
        }
    }

    public ShareSDKImageView dLN() {
        return this.nbF;
    }
}
