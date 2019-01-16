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
    private HeadImageView aFP;
    private TextView aFQ;
    private TbImageView dRR;
    private TextView hYH;
    private View hYI;
    private EditText hYJ;
    private View hYK;
    private View hYL;
    private TextView hYM;
    private int hYN;
    private int hYO;
    private int hYP;
    private int hYQ;
    private int hYR;
    private int hYS;
    private a hYT;
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
        this.hYH = (TextView) findViewById(e.g.share_sdk_forum);
        this.hYI = findViewById(e.g.share_sdk_content_container);
        this.aFP = (HeadImageView) findViewById(e.g.share_sdk_appicon);
        this.aFQ = (TextView) findViewById(e.g.share_sdk_appname);
        this.mContentView = (TextView) findViewById(e.g.share_sdk_content);
        this.dRR = (TbImageView) findViewById(e.g.share_sdk_img);
        this.hYJ = (EditText) findViewById(e.g.share_sdk_edit);
        this.hYK = findViewById(e.g.share_sdk_content_line);
        this.mCancelView = (TextView) findViewById(e.g.share_sdk_cancel);
        this.hYL = findViewById(e.g.share_sdk_action_line);
        this.hYM = (TextView) findViewById(e.g.share_sdk_share);
        setOnClickListener(this);
        this.mCancelView.setOnClickListener(this);
        this.hYM.setOnClickListener(this);
        this.aFP.setIsRound(true);
        this.aFP.setIsPreDrawBorder(true);
        this.aFP.setDrawBorder(true);
        this.aFP.setBorderWidth(l.h(context, e.C0210e.tbds1));
        this.aFP.setDefaultResource(e.d.cp_bg_line_e);
        this.aFP.setRadius(l.h(context, e.C0210e.ds70));
        this.dRR.setDefaultBgResource(e.f.pic_share_default_applets);
        this.hYN = (l.aO(getContext()) - l.h(getContext(), e.C0210e.tbds516)) / l.h(getContext(), e.C0210e.tbds45);
        this.hYQ = l.h(getContext(), e.C0210e.tbds27);
        this.hYR = l.h(getContext(), e.C0210e.tbds11);
        this.hYS = l.h(getContext(), e.C0210e.tbds36);
        this.hYO = this.hYQ;
        this.hYP = this.hYQ;
        this.hYJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.hYN * 2) {
                    if (ShareSdkView.this.hYO != 0) {
                        ShareSdkView.this.hYO = 0;
                        ShareSdkView.this.hYP = ShareSdkView.this.hYR;
                        ShareSdkView.this.hYJ.setPadding(ShareSdkView.this.hYS, ShareSdkView.this.hYO, ShareSdkView.this.hYS, ShareSdkView.this.hYP);
                    }
                } else if (editable.length() > ShareSdkView.this.hYN) {
                    if (ShareSdkView.this.hYO != ShareSdkView.this.hYR) {
                        ShareSdkView.this.hYO = ShareSdkView.this.hYR;
                        ShareSdkView.this.hYP = ShareSdkView.this.hYR;
                        ShareSdkView.this.hYJ.setPadding(ShareSdkView.this.hYS, ShareSdkView.this.hYO, ShareSdkView.this.hYS, ShareSdkView.this.hYP);
                    }
                } else if (ShareSdkView.this.hYO != ShareSdkView.this.hYQ) {
                    ShareSdkView.this.hYO = ShareSdkView.this.hYQ;
                    ShareSdkView.this.hYP = ShareSdkView.this.hYQ;
                    ShareSdkView.this.hYJ.setPadding(ShareSdkView.this.hYS, ShareSdkView.this.hYO, ShareSdkView.this.hYS, ShareSdkView.this.hYP);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.hYT = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mCancelView) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.hYM && ba.bJ(getContext())) {
            String obj = this.hYJ.getText().toString();
            if (this.hYT != null) {
                this.hYT.xW(obj);
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
        this.hYH.setText(String.format(getResources().getString(e.j.share_sdk_forum), cVar.hYC));
        this.aFP.startLoad(cVar.bHy, 10, false);
        this.aFQ.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.mContentView.setVisibility(8);
        } else {
            this.mContentView.setText(cVar.content);
        }
        this.dRR.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.dRR.getLayoutParams();
                layoutParams.height = ((l.aO(ShareSdkView.this.getContext()) - l.h(ShareSdkView.this.getContext(), e.C0210e.tbds408)) * 9) / 16;
                ShareSdkView.this.dRR.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.dRR.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.hYT = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.j(this, e.d.black_alpha30);
            al.i(this.mRootView, e.f.share_sdk_bg);
            al.h(this.hYH, e.d.cp_cont_b);
            al.j(this.hYI, e.d.cp_bg_line_e);
            this.aFP.setBorderColor(al.getColor(e.d.cp_cont_g));
            this.aFP.setIsNight(this.mSkinType == 1);
            al.h(this.aFQ, e.d.cp_cont_f);
            al.h(this.mContentView, e.d.cp_cont_b);
            this.dRR.setIsNight(this.mSkinType == 1);
            this.hYJ.setHintTextColor(al.getColor(e.d.cp_cont_e));
            this.hYJ.setTextColor(al.getColor(e.d.cp_cont_b));
            al.i(this.hYJ, e.f.share_sdk_input_shape_bg);
            al.j(this.hYK, e.d.cp_bg_line_c);
            al.h(this.mCancelView, e.d.cp_cont_b);
            al.j(this.hYL, e.d.cp_bg_line_c);
            al.h(this.hYM, e.d.cp_link_tip_a);
        }
    }
}
