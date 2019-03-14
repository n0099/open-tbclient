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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    private HeadImageView bNS;
    private TextView bNT;
    private TextView bjJ;
    private TbImageView eEW;
    private TextView jpC;
    private View jpD;
    private EditText jpE;
    private View jpF;
    private View jpG;
    private TextView jpH;
    private int jpI;
    private int jpJ;
    private int jpK;
    private int jpL;
    private int jpM;
    private int jpN;
    private a jpO;
    private TextView mContentView;
    private View mRootView;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void Ev(String str);
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
        LayoutInflater.from(context).inflate(d.h.share_sdk_view, (ViewGroup) this, true);
        this.mRootView = findViewById(d.g.share_sdk_content_root);
        this.jpC = (TextView) findViewById(d.g.share_sdk_forum);
        this.jpD = findViewById(d.g.share_sdk_content_container);
        this.bNS = (HeadImageView) findViewById(d.g.share_sdk_appicon);
        this.bNT = (TextView) findViewById(d.g.share_sdk_appname);
        this.mContentView = (TextView) findViewById(d.g.share_sdk_content);
        this.eEW = (TbImageView) findViewById(d.g.share_sdk_img);
        this.jpE = (EditText) findViewById(d.g.share_sdk_edit);
        this.jpF = findViewById(d.g.share_sdk_content_line);
        this.bjJ = (TextView) findViewById(d.g.share_sdk_cancel);
        this.jpG = findViewById(d.g.share_sdk_action_line);
        this.jpH = (TextView) findViewById(d.g.share_sdk_share);
        setOnClickListener(this);
        this.bjJ.setOnClickListener(this);
        this.jpH.setOnClickListener(this);
        this.bNS.setIsRound(true);
        this.bNS.setIsPreDrawBorder(true);
        this.bNS.setDrawBorder(true);
        this.bNS.setBorderWidth(l.h(context, d.e.tbds1));
        this.bNS.setDefaultResource(d.C0277d.cp_bg_line_e);
        this.bNS.setRadius(l.h(context, d.e.ds70));
        this.eEW.setDefaultBgResource(d.f.pic_share_default_applets);
        this.jpI = (l.aO(getContext()) - l.h(getContext(), d.e.tbds516)) / l.h(getContext(), d.e.tbds45);
        this.jpL = l.h(getContext(), d.e.tbds27);
        this.jpM = l.h(getContext(), d.e.tbds11);
        this.jpN = l.h(getContext(), d.e.tbds36);
        this.jpJ = this.jpL;
        this.jpK = this.jpL;
        this.jpE.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.jpI * 2) {
                    if (ShareSdkView.this.jpJ != 0) {
                        ShareSdkView.this.jpJ = 0;
                        ShareSdkView.this.jpK = ShareSdkView.this.jpM;
                        ShareSdkView.this.jpE.setPadding(ShareSdkView.this.jpN, ShareSdkView.this.jpJ, ShareSdkView.this.jpN, ShareSdkView.this.jpK);
                    }
                } else if (editable.length() > ShareSdkView.this.jpI) {
                    if (ShareSdkView.this.jpJ != ShareSdkView.this.jpM) {
                        ShareSdkView.this.jpJ = ShareSdkView.this.jpM;
                        ShareSdkView.this.jpK = ShareSdkView.this.jpM;
                        ShareSdkView.this.jpE.setPadding(ShareSdkView.this.jpN, ShareSdkView.this.jpJ, ShareSdkView.this.jpN, ShareSdkView.this.jpK);
                    }
                } else if (ShareSdkView.this.jpJ != ShareSdkView.this.jpL) {
                    ShareSdkView.this.jpJ = ShareSdkView.this.jpL;
                    ShareSdkView.this.jpK = ShareSdkView.this.jpL;
                    ShareSdkView.this.jpE.setPadding(ShareSdkView.this.jpN, ShareSdkView.this.jpJ, ShareSdkView.this.jpN, ShareSdkView.this.jpK);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.jpO = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bjJ) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.jpH && bc.cZ(getContext())) {
            String obj = this.jpE.getText().toString();
            if (this.jpO != null) {
                this.jpO.Ev(obj);
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
        this.jpC.setText(String.format(getResources().getString(d.j.share_sdk_forum), cVar.jpx));
        this.bNS.startLoad(cVar.jpw, 10, false);
        this.bNT.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.mContentView.setVisibility(8);
        } else {
            this.mContentView.setText(cVar.content);
        }
        this.eEW.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.eEW.getLayoutParams();
                layoutParams.height = ((l.aO(ShareSdkView.this.getContext()) - l.h(ShareSdkView.this.getContext(), d.e.tbds408)) * 9) / 16;
                ShareSdkView.this.eEW.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.eEW.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.jpO = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.l(this, d.C0277d.black_alpha30);
            al.k(this.mRootView, d.f.share_sdk_bg);
            al.j(this.jpC, d.C0277d.cp_cont_b);
            al.l(this.jpD, d.C0277d.cp_bg_line_e);
            this.bNS.setBorderColor(al.getColor(d.C0277d.cp_cont_g));
            this.bNS.setIsNight(this.mSkinType == 1);
            al.j(this.bNT, d.C0277d.cp_cont_f);
            al.j(this.mContentView, d.C0277d.cp_cont_b);
            this.eEW.setIsNight(this.mSkinType == 1);
            this.jpE.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
            this.jpE.setTextColor(al.getColor(d.C0277d.cp_cont_b));
            al.k(this.jpE, d.f.share_sdk_input_shape_bg);
            al.l(this.jpF, d.C0277d.cp_bg_line_c);
            al.j(this.bjJ, d.C0277d.cp_cont_b);
            al.l(this.jpG, d.C0277d.cp_bg_line_c);
            al.j(this.jpH, d.C0277d.cp_link_tip_a);
        }
    }
}
