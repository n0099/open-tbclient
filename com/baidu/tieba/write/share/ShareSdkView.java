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
    private HeadImageView aBM;
    private TextView aBN;
    private TbImageView dHV;
    private TextView hNf;
    private View hNg;
    private EditText hNh;
    private View hNi;
    private View hNj;
    private TextView hNk;
    private int hNl;
    private int hNm;
    private int hNn;
    private int hNo;
    private int hNp;
    private int hNq;
    private a hNr;
    private TextView mCancelView;
    private TextView mContentView;
    private View mRootView;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void xa(String str);
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
        this.hNf = (TextView) findViewById(e.g.share_sdk_forum);
        this.hNg = findViewById(e.g.share_sdk_content_container);
        this.aBM = (HeadImageView) findViewById(e.g.share_sdk_appicon);
        this.aBN = (TextView) findViewById(e.g.share_sdk_appname);
        this.mContentView = (TextView) findViewById(e.g.share_sdk_content);
        this.dHV = (TbImageView) findViewById(e.g.share_sdk_img);
        this.hNh = (EditText) findViewById(e.g.share_sdk_edit);
        this.hNi = findViewById(e.g.share_sdk_content_line);
        this.mCancelView = (TextView) findViewById(e.g.share_sdk_cancel);
        this.hNj = findViewById(e.g.share_sdk_action_line);
        this.hNk = (TextView) findViewById(e.g.share_sdk_share);
        setOnClickListener(this);
        this.mCancelView.setOnClickListener(this);
        this.hNk.setOnClickListener(this);
        this.aBM.setIsRound(true);
        this.aBM.setIsPreDrawBorder(true);
        this.aBM.setDrawBorder(true);
        this.aBM.setBorderWidth(l.h(context, e.C0200e.tbds1));
        this.aBM.setDefaultResource(e.d.cp_bg_line_e);
        this.aBM.setRadius(l.h(context, e.C0200e.ds70));
        this.dHV.setDefaultBgResource(e.f.pic_share_default_applets);
        this.hNl = (l.aO(getContext()) - l.h(getContext(), e.C0200e.tbds516)) / l.h(getContext(), e.C0200e.tbds45);
        this.hNo = l.h(getContext(), e.C0200e.tbds27);
        this.hNp = l.h(getContext(), e.C0200e.tbds11);
        this.hNq = l.h(getContext(), e.C0200e.tbds36);
        this.hNm = this.hNo;
        this.hNn = this.hNo;
        this.hNh.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.hNl * 2) {
                    if (ShareSdkView.this.hNm != 0) {
                        ShareSdkView.this.hNm = 0;
                        ShareSdkView.this.hNn = ShareSdkView.this.hNp;
                        ShareSdkView.this.hNh.setPadding(ShareSdkView.this.hNq, ShareSdkView.this.hNm, ShareSdkView.this.hNq, ShareSdkView.this.hNn);
                    }
                } else if (editable.length() > ShareSdkView.this.hNl) {
                    if (ShareSdkView.this.hNm != ShareSdkView.this.hNp) {
                        ShareSdkView.this.hNm = ShareSdkView.this.hNp;
                        ShareSdkView.this.hNn = ShareSdkView.this.hNp;
                        ShareSdkView.this.hNh.setPadding(ShareSdkView.this.hNq, ShareSdkView.this.hNm, ShareSdkView.this.hNq, ShareSdkView.this.hNn);
                    }
                } else if (ShareSdkView.this.hNm != ShareSdkView.this.hNo) {
                    ShareSdkView.this.hNm = ShareSdkView.this.hNo;
                    ShareSdkView.this.hNn = ShareSdkView.this.hNo;
                    ShareSdkView.this.hNh.setPadding(ShareSdkView.this.hNq, ShareSdkView.this.hNm, ShareSdkView.this.hNq, ShareSdkView.this.hNn);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.hNr = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mCancelView) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.hNk && ba.bG(getContext())) {
            String obj = this.hNh.getText().toString();
            if (this.hNr != null) {
                this.hNr.xa(obj);
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
        this.hNf.setText(String.format(getResources().getString(e.j.share_sdk_forum), cVar.hNa));
        this.aBM.startLoad(cVar.hMZ, 10, false);
        this.aBN.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.mContentView.setVisibility(8);
        } else {
            this.mContentView.setText(cVar.content);
        }
        this.dHV.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.dHV.getLayoutParams();
                layoutParams.height = ((l.aO(ShareSdkView.this.getContext()) - l.h(ShareSdkView.this.getContext(), e.C0200e.tbds408)) * 9) / 16;
                ShareSdkView.this.dHV.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.dHV.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.hNr = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.j(this, e.d.black_alpha30);
            al.i(this.mRootView, e.f.share_sdk_bg);
            al.h(this.hNf, e.d.cp_cont_b);
            al.j(this.hNg, e.d.cp_bg_line_e);
            this.aBM.setBorderColor(al.getColor(e.d.cp_cont_g));
            this.aBM.setIsNight(this.mSkinType == 1);
            al.h(this.aBN, e.d.cp_cont_f);
            al.h(this.mContentView, e.d.cp_cont_b);
            this.dHV.setIsNight(this.mSkinType == 1);
            this.hNh.setHintTextColor(al.getColor(e.d.cp_cont_e));
            this.hNh.setTextColor(al.getColor(e.d.cp_cont_b));
            al.i(this.hNh, e.f.share_sdk_input_shape_bg);
            al.j(this.hNi, e.d.cp_bg_line_c);
            al.h(this.mCancelView, e.d.cp_cont_b);
            al.j(this.hNj, e.d.cp_bg_line_c);
            al.h(this.hNk, e.d.cp_link_tip_a);
        }
    }
}
