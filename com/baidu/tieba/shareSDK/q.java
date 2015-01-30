package com.baidu.tieba.shareSDK;

import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.ShareSDKImageView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.write.ch;
import com.baidu.tieba.z;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class q {
    private View bPI;
    private TextView bPM;
    private ch bPN;
    private ImageView bPO;
    private View bPP;
    private LinearLayout bPQ;
    private LinearLayout bPR;
    private ShareSDKImageView bPS;
    private TextView bPT;
    private TextView bPU;
    private WriteShareActivity bPV;
    private WriteData bPp;
    private PostPrefixData mPrefixData;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private EditText bPG = null;
    private View bPH = null;
    private LinearLayout bPJ = null;
    private EditText bPK = null;
    private TextView bPL = null;
    private RelativeLayout mParent = null;
    private boolean bPW = false;
    private int width = 0;
    private int height = 0;

    public q(WriteShareActivity writeShareActivity) {
        this.bPp = null;
        this.bPV = writeShareActivity;
        this.bPp = writeShareActivity.Ft();
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.bPV.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bPV.getPageContext().getString(z.share_navigationbar_title));
        this.bPL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.bPV.getPageContext().getString(z.send_post));
        this.mParent = (RelativeLayout) this.bPV.findViewById(com.baidu.tieba.w.parent);
        this.bPH = this.bPV.findViewById(com.baidu.tieba.w.interval_view);
        this.bPI = this.bPV.findViewById(com.baidu.tieba.w.prefix_interval_view);
        this.bPQ = (LinearLayout) this.bPV.findViewById(com.baidu.tieba.w.post_share_layout);
        this.bPR = (LinearLayout) this.bPV.findViewById(com.baidu.tieba.w.post_share_content_layout);
        this.bPS = (ShareSDKImageView) this.bPV.findViewById(com.baidu.tieba.w.post_share_image);
        this.bPT = (TextView) this.bPV.findViewById(com.baidu.tieba.w.post_share_title);
        this.bPU = (TextView) this.bPV.findViewById(com.baidu.tieba.w.post_share_content);
        adj();
        adl();
        this.bPJ = (LinearLayout) this.bPV.findViewById(com.baidu.tieba.w.post_content_container);
        this.bPJ.setDrawingCacheEnabled(false);
        this.bPG.setVisibility(0);
        this.bPK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI)});
        adh();
        adk();
    }

    private void adh() {
        this.bPQ = (LinearLayout) this.bPV.findViewById(com.baidu.tieba.w.post_share_layout);
        this.bPS = (ShareSDKImageView) this.bPV.findViewById(com.baidu.tieba.w.post_share_image);
        this.bPS.setIsRound(false);
        this.bPS.setDrawBorder(false);
        this.bPS.setAutoChangeStyle(true);
        this.bPS.setRadius(0);
        this.bPT = (TextView) this.bPV.findViewById(com.baidu.tieba.w.post_share_title);
        this.bPU = (TextView) this.bPV.findViewById(com.baidu.tieba.w.post_share_content);
        if (this.bPp != null) {
            this.bPS.setEvent(new r(this));
            if (this.bPp.getShareSummaryImg() != null && this.bPp.getShareSummaryImg().trim().length() > 0) {
                this.bPS.d(this.bPp.getShareSummaryImg(), 10, true);
            } else {
                this.bPW = true;
                adk();
            }
            this.bPp.setShareSummaryImgType(com.baidu.adp.lib.util.commonsio.b.aK(this.bPp.getShareSummaryImg()));
            this.bPT.setText(this.bPp.getShareSummaryTitle());
            this.bPU.setText(this.bPp.getShareSummaryContent());
        }
    }

    private void adi() {
        this.bPP = this.bPV.findViewById(com.baidu.tieba.w.post_prefix_layout);
        this.bPM = (TextView) this.bPV.findViewById(com.baidu.tieba.w.post_prefix);
        this.bPO = (ImageView) this.bPV.findViewById(com.baidu.tieba.w.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.bPP.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.bPM.setText(prefixs.get(0));
            this.bPV.hA(0);
            this.bPP.setOnClickListener(new s(this));
            this.bPO = (ImageView) this.bPV.findViewById(com.baidu.tieba.w.prefix_icon);
            if (size > 1) {
                this.bPO.setVisibility(0);
                this.bPM.setOnClickListener(new t(this));
            }
            this.bPN = new ch(this.bPV.getPageContext().getContext());
            this.bPN.setMaxHeight(com.baidu.adp.lib.util.l.dip2px(this.bPV.getPageContext().getContext(), 225.0f));
            this.bPN.setOutsideTouchable(true);
            this.bPN.setFocusable(true);
            this.bPN.setBackgroundDrawable(bc.getDrawable(com.baidu.tieba.t.cp_bg_line_b));
            this.bPN.a(new u(this));
            this.bPN.setOnDismissListener(new v(this));
            int color = bc.getColor(com.baidu.tieba.t.write_text);
            bc.i((View) this.bPM, com.baidu.tieba.v.write_prefix_item_selector);
            bc.c(this.bPO, com.baidu.tieba.v.icon_title_down);
            this.bPM.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this.bPV.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.dip2px(this.bPV.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                bc.i((View) textView, com.baidu.tieba.v.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.bPV.getPageContext().getContext(), this.bPV.getResources().getDimension(com.baidu.tieba.u.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.bPV.getPageContext().getContext(), this.bPV.getResources().getDimension(com.baidu.tieba.u.ds22)), 0);
                this.bPN.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.dip2px(this.bPV.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.l.dip2px(this.bPV.getPageContext().getContext(), this.bPV.getResources().getDimension(com.baidu.tieba.u.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(this.bPV.getPageContext().getContext(), this.bPV.getResources().getDimension(com.baidu.tieba.u.ds22)), 0);
                }
            }
            this.bPN.setCurrentIndex(0);
            return;
        }
        this.bPP.setVisibility(8);
    }

    protected void adj() {
        this.bPG = (EditText) this.bPV.findViewById(com.baidu.tieba.w.post_title);
        if (this.bPp.getType() == 3) {
            if (this.bPp.getTitle() != null && this.bPp.getTitle().trim().length() > 0) {
                this.bPG.setText(this.bPp.getTitle());
                this.bPG.setSelection(this.bPp.getTitle().length());
            } else {
                String str = String.valueOf(this.bPV.getPageContext().getString(z.share_transfer_thread)) + this.bPp.getShareSummaryTitle();
                this.bPG.setText(str);
                if (str.length() < 20) {
                    this.bPG.setSelection(str.length());
                } else {
                    this.bPG.setSelection(20);
                }
            }
        }
        this.bPG.addTextChangedListener(new w(this));
    }

    public void adk() {
        String str = null;
        if (this.bPp.getType() == 3) {
            String trim = this.bPG.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.bPV.ade() == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.bPp.setIsNoTitle(true);
                    } else {
                        this.bPp.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.bPp.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.bPp.setIsNoTitle(true);
            } else {
                this.bPp.setIsNoTitle(false);
                str = "1";
            }
        }
        if (str == null || str.length() <= 0 || !this.bPW) {
            this.bPL.setEnabled(false);
        } else {
            this.bPL.setEnabled(true);
        }
    }

    protected void adl() {
        this.bPK = (EditText) this.bPV.findViewById(com.baidu.tieba.w.post_content);
        this.bPK.setDrawingCacheEnabled(false);
        if (this.bPp.getContent() != null && this.bPp.getContent().length() > 0) {
            SpannableString E = TbFaceManager.wd().E(this.bPV.getPageContext().getContext(), this.bPp.getContent());
            this.bPK.setText(E);
            this.bPK.setSelection(E.length());
        }
        this.bPK.setOnTouchListener(new x(this));
        this.bPK.addTextChangedListener(new y(this));
    }

    private void a(EditText editText, int i) {
        Editable text = editText.getText();
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        editText.setText((CharSequence) null);
        editText.setHintTextColor(i);
        editText.setText(text);
        editText.setSelection(selectionStart, selectionEnd);
    }

    public EditText adm() {
        return this.bPG;
    }

    public EditText adn() {
        return this.bPK;
    }

    public void a(PostPrefixData postPrefixData) {
        this.mPrefixData = postPrefixData;
        adi();
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.bPG.setOnFocusChangeListener(onFocusChangeListener);
        this.bPK.setOnFocusChangeListener(onFocusChangeListener);
        this.mBack.setOnFocusChangeListener(onFocusChangeListener);
        this.bPL.setOnFocusChangeListener(onFocusChangeListener);
    }

    public ch ado() {
        return this.bPN;
    }

    public View adp() {
        return this.mBack;
    }

    public TextView adq() {
        return this.bPL;
    }

    public TextView adr() {
        return this.bPM;
    }

    public void E(View.OnClickListener onClickListener) {
        this.mBack.setOnClickListener(onClickListener);
    }

    public void F(View.OnClickListener onClickListener) {
        this.bPL.setOnClickListener(onClickListener);
    }

    public void G(View.OnClickListener onClickListener) {
        this.bPJ.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.bPV != null) {
            this.bPV.getLayoutMode().ab(i == 1);
            this.bPV.getLayoutMode().h(this.mParent);
            this.mNavigationBar.onChangeSkinType(this.bPV.getPageContext(), i);
            bc.g(this.bPL, i);
            bc.j(this.bPH, com.baidu.tieba.t.cp_bg_line_c);
            bc.j(this.bPI, com.baidu.tieba.t.cp_bg_line_c);
            bc.j((View) this.bPG, com.baidu.tieba.t.cp_cont_g);
            bc.j(this.bPR, com.baidu.tieba.t.cp_bg_line_e);
            int color = bc.getColor(com.baidu.tieba.t.cp_cont_b);
            int color2 = bc.getColor(com.baidu.tieba.t.cp_cont_e);
            this.bPG.setTextColor(color);
            this.bPK.setTextColor(color);
            this.bPT.setTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_b));
            this.bPU.setTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_d));
            a(this.bPG, color2);
            a(this.bPK, color2);
            adk();
        }
    }
}
