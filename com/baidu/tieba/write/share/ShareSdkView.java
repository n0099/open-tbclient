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
    private HeadImageView aFn;
    private TextView aFo;
    private TbImageView dRi;
    private TextView hXA;
    private View hXB;
    private EditText hXC;
    private View hXD;
    private View hXE;
    private TextView hXF;
    private int hXG;
    private int hXH;
    private int hXI;
    private int hXJ;
    private int hXK;
    private int hXL;
    private a hXM;
    private TextView mCancelView;
    private TextView mContentView;
    private View mRootView;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void xG(String str);
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
        this.hXA = (TextView) findViewById(e.g.share_sdk_forum);
        this.hXB = findViewById(e.g.share_sdk_content_container);
        this.aFn = (HeadImageView) findViewById(e.g.share_sdk_appicon);
        this.aFo = (TextView) findViewById(e.g.share_sdk_appname);
        this.mContentView = (TextView) findViewById(e.g.share_sdk_content);
        this.dRi = (TbImageView) findViewById(e.g.share_sdk_img);
        this.hXC = (EditText) findViewById(e.g.share_sdk_edit);
        this.hXD = findViewById(e.g.share_sdk_content_line);
        this.mCancelView = (TextView) findViewById(e.g.share_sdk_cancel);
        this.hXE = findViewById(e.g.share_sdk_action_line);
        this.hXF = (TextView) findViewById(e.g.share_sdk_share);
        setOnClickListener(this);
        this.mCancelView.setOnClickListener(this);
        this.hXF.setOnClickListener(this);
        this.aFn.setIsRound(true);
        this.aFn.setIsPreDrawBorder(true);
        this.aFn.setDrawBorder(true);
        this.aFn.setBorderWidth(l.h(context, e.C0210e.tbds1));
        this.aFn.setDefaultResource(e.d.cp_bg_line_e);
        this.aFn.setRadius(l.h(context, e.C0210e.ds70));
        this.dRi.setDefaultBgResource(e.f.pic_share_default_applets);
        this.hXG = (l.aO(getContext()) - l.h(getContext(), e.C0210e.tbds516)) / l.h(getContext(), e.C0210e.tbds45);
        this.hXJ = l.h(getContext(), e.C0210e.tbds27);
        this.hXK = l.h(getContext(), e.C0210e.tbds11);
        this.hXL = l.h(getContext(), e.C0210e.tbds36);
        this.hXH = this.hXJ;
        this.hXI = this.hXJ;
        this.hXC.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.hXG * 2) {
                    if (ShareSdkView.this.hXH != 0) {
                        ShareSdkView.this.hXH = 0;
                        ShareSdkView.this.hXI = ShareSdkView.this.hXK;
                        ShareSdkView.this.hXC.setPadding(ShareSdkView.this.hXL, ShareSdkView.this.hXH, ShareSdkView.this.hXL, ShareSdkView.this.hXI);
                    }
                } else if (editable.length() > ShareSdkView.this.hXG) {
                    if (ShareSdkView.this.hXH != ShareSdkView.this.hXK) {
                        ShareSdkView.this.hXH = ShareSdkView.this.hXK;
                        ShareSdkView.this.hXI = ShareSdkView.this.hXK;
                        ShareSdkView.this.hXC.setPadding(ShareSdkView.this.hXL, ShareSdkView.this.hXH, ShareSdkView.this.hXL, ShareSdkView.this.hXI);
                    }
                } else if (ShareSdkView.this.hXH != ShareSdkView.this.hXJ) {
                    ShareSdkView.this.hXH = ShareSdkView.this.hXJ;
                    ShareSdkView.this.hXI = ShareSdkView.this.hXJ;
                    ShareSdkView.this.hXC.setPadding(ShareSdkView.this.hXL, ShareSdkView.this.hXH, ShareSdkView.this.hXL, ShareSdkView.this.hXI);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.hXM = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mCancelView) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.hXF && ba.bJ(getContext())) {
            String obj = this.hXC.getText().toString();
            if (this.hXM != null) {
                this.hXM.xG(obj);
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
        this.hXA.setText(String.format(getResources().getString(e.j.share_sdk_forum), cVar.hXv));
        this.aFn.startLoad(cVar.bGL, 10, false);
        this.aFo.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.mContentView.setVisibility(8);
        } else {
            this.mContentView.setText(cVar.content);
        }
        this.dRi.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.dRi.getLayoutParams();
                layoutParams.height = ((l.aO(ShareSdkView.this.getContext()) - l.h(ShareSdkView.this.getContext(), e.C0210e.tbds408)) * 9) / 16;
                ShareSdkView.this.dRi.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.dRi.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.hXM = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.j(this, e.d.black_alpha30);
            al.i(this.mRootView, e.f.share_sdk_bg);
            al.h(this.hXA, e.d.cp_cont_b);
            al.j(this.hXB, e.d.cp_bg_line_e);
            this.aFn.setBorderColor(al.getColor(e.d.cp_cont_g));
            this.aFn.setIsNight(this.mSkinType == 1);
            al.h(this.aFo, e.d.cp_cont_f);
            al.h(this.mContentView, e.d.cp_cont_b);
            this.dRi.setIsNight(this.mSkinType == 1);
            this.hXC.setHintTextColor(al.getColor(e.d.cp_cont_e));
            this.hXC.setTextColor(al.getColor(e.d.cp_cont_b));
            al.i(this.hXC, e.f.share_sdk_input_shape_bg);
            al.j(this.hXD, e.d.cp_bg_line_c);
            al.h(this.mCancelView, e.d.cp_cont_b);
            al.j(this.hXE, e.d.cp_bg_line_c);
            al.h(this.hXF, e.d.cp_link_tip_a);
        }
    }
}
