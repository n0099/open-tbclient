package com.baidu.tieba.write.share;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    private HeadImageView aFQ;
    private TextView aFR;
    private TbImageView dRS;
    private TextView hYI;
    private View hYJ;
    private EditText hYK;
    private View hYL;
    private View hYM;
    private TextView hYN;
    private int hYO;
    private int hYP;
    private int hYQ;
    private int hYR;
    private int hYS;
    private int hYT;
    private a hYU;
    private TextView mCancelView;
    private TextView mContentView;
    private View mRootView;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void xW(String str);
    }

    public ShareSdkView(Context context) {
        super(context);
        this.mSkinType = 3;
        init(context);
    }

    public ShareSdkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        init(context);
    }

    public ShareSdkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(16);
        LayoutInflater.from(context).inflate(e.h.share_sdk_view, (ViewGroup) this, true);
        this.mRootView = findViewById(e.g.share_sdk_content_root);
        this.hYI = (TextView) findViewById(e.g.share_sdk_forum);
        this.hYJ = findViewById(e.g.share_sdk_content_container);
        this.aFQ = (HeadImageView) findViewById(e.g.share_sdk_appicon);
        this.aFR = (TextView) findViewById(e.g.share_sdk_appname);
        this.mContentView = (TextView) findViewById(e.g.share_sdk_content);
        this.dRS = (TbImageView) findViewById(e.g.share_sdk_img);
        this.hYK = (EditText) findViewById(e.g.share_sdk_edit);
        this.hYL = findViewById(e.g.share_sdk_content_line);
        this.mCancelView = (TextView) findViewById(e.g.share_sdk_cancel);
        this.hYM = findViewById(e.g.share_sdk_action_line);
        this.hYN = (TextView) findViewById(e.g.share_sdk_share);
        setOnClickListener(this);
        this.mCancelView.setOnClickListener(this);
        this.hYN.setOnClickListener(this);
        this.aFQ.setIsRound(true);
        this.aFQ.setIsPreDrawBorder(true);
        this.aFQ.setDrawBorder(true);
        this.aFQ.setBorderWidth(l.h(context, e.C0210e.tbds1));
        this.aFQ.setDefaultResource(e.d.cp_bg_line_e);
        this.aFQ.setRadius(l.h(context, e.C0210e.ds70));
        this.dRS.setDefaultBgResource(e.f.pic_share_default_applets);
        this.hYO = (l.aO(getContext()) - l.h(getContext(), e.C0210e.tbds516)) / l.h(getContext(), e.C0210e.tbds45);
        this.hYR = l.h(getContext(), e.C0210e.tbds27);
        this.hYS = l.h(getContext(), e.C0210e.tbds11);
        this.hYT = l.h(getContext(), e.C0210e.tbds36);
        this.hYP = this.hYR;
        this.hYQ = this.hYR;
        this.hYK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.hYO * 2) {
                    if (ShareSdkView.this.hYP != 0) {
                        ShareSdkView.this.hYP = 0;
                        ShareSdkView.this.hYQ = ShareSdkView.this.hYS;
                        ShareSdkView.this.hYK.setPadding(ShareSdkView.this.hYT, ShareSdkView.this.hYP, ShareSdkView.this.hYT, ShareSdkView.this.hYQ);
                    }
                } else if (editable.length() > ShareSdkView.this.hYO) {
                    if (ShareSdkView.this.hYP != ShareSdkView.this.hYS) {
                        ShareSdkView.this.hYP = ShareSdkView.this.hYS;
                        ShareSdkView.this.hYQ = ShareSdkView.this.hYS;
                        ShareSdkView.this.hYK.setPadding(ShareSdkView.this.hYT, ShareSdkView.this.hYP, ShareSdkView.this.hYT, ShareSdkView.this.hYQ);
                    }
                } else if (ShareSdkView.this.hYP != ShareSdkView.this.hYR) {
                    ShareSdkView.this.hYP = ShareSdkView.this.hYR;
                    ShareSdkView.this.hYQ = ShareSdkView.this.hYR;
                    ShareSdkView.this.hYK.setPadding(ShareSdkView.this.hYT, ShareSdkView.this.hYP, ShareSdkView.this.hYT, ShareSdkView.this.hYQ);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.hYU = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mCancelView) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.hYN && ba.bJ(getContext())) {
            String obj = this.hYK.getText().toString();
            if (this.hYU != null) {
                this.hYU.xW(obj);
            }
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        }
    }

    public void setData(c cVar) {
        if (cVar == null && getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
            return;
        }
        this.hYI.setText(String.format(getResources().getString(e.j.share_sdk_forum), cVar.hYD));
        this.aFQ.startLoad(cVar.bHz, 10, false);
        this.aFR.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.mContentView.setVisibility(8);
        } else {
            this.mContentView.setText(cVar.content);
        }
        this.dRS.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.dRS.getLayoutParams();
                layoutParams.height = ((l.aO(ShareSdkView.this.getContext()) - l.h(ShareSdkView.this.getContext(), e.C0210e.tbds408)) * 9) / 16;
                ShareSdkView.this.dRS.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.dRS.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.hYU = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.j(this, e.d.black_alpha30);
            al.i(this.mRootView, e.f.share_sdk_bg);
            al.h(this.hYI, e.d.cp_cont_b);
            al.j(this.hYJ, e.d.cp_bg_line_e);
            this.aFQ.setBorderColor(al.getColor(e.d.cp_cont_g));
            this.aFQ.setIsNight(this.mSkinType == 1);
            al.h(this.aFR, e.d.cp_cont_f);
            al.h(this.mContentView, e.d.cp_cont_b);
            this.dRS.setIsNight(this.mSkinType == 1);
            this.hYK.setHintTextColor(al.getColor(e.d.cp_cont_e));
            this.hYK.setTextColor(al.getColor(e.d.cp_cont_b));
            al.i(this.hYK, e.f.share_sdk_input_shape_bg);
            al.j(this.hYL, e.d.cp_bg_line_c);
            al.h(this.mCancelView, e.d.cp_cont_b);
            al.j(this.hYM, e.d.cp_bg_line_c);
            al.h(this.hYN, e.d.cp_link_tip_a);
        }
    }
}
