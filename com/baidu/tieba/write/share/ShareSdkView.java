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
    private HeadImageView bNR;
    private TextView bNS;
    private TextView bjI;
    private TbImageView eFa;
    private TextView jpK;
    private View jpL;
    private EditText jpM;
    private View jpN;
    private View jpO;
    private TextView jpP;
    private int jpQ;
    private int jpR;
    private int jpS;
    private int jpT;
    private int jpU;
    private int jpV;
    private a jpW;
    private TextView mContentView;
    private View mRootView;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void Ex(String str);
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
        this.jpK = (TextView) findViewById(d.g.share_sdk_forum);
        this.jpL = findViewById(d.g.share_sdk_content_container);
        this.bNR = (HeadImageView) findViewById(d.g.share_sdk_appicon);
        this.bNS = (TextView) findViewById(d.g.share_sdk_appname);
        this.mContentView = (TextView) findViewById(d.g.share_sdk_content);
        this.eFa = (TbImageView) findViewById(d.g.share_sdk_img);
        this.jpM = (EditText) findViewById(d.g.share_sdk_edit);
        this.jpN = findViewById(d.g.share_sdk_content_line);
        this.bjI = (TextView) findViewById(d.g.share_sdk_cancel);
        this.jpO = findViewById(d.g.share_sdk_action_line);
        this.jpP = (TextView) findViewById(d.g.share_sdk_share);
        setOnClickListener(this);
        this.bjI.setOnClickListener(this);
        this.jpP.setOnClickListener(this);
        this.bNR.setIsRound(true);
        this.bNR.setIsPreDrawBorder(true);
        this.bNR.setDrawBorder(true);
        this.bNR.setBorderWidth(l.h(context, d.e.tbds1));
        this.bNR.setDefaultResource(d.C0236d.cp_bg_line_e);
        this.bNR.setRadius(l.h(context, d.e.ds70));
        this.eFa.setDefaultBgResource(d.f.pic_share_default_applets);
        this.jpQ = (l.aO(getContext()) - l.h(getContext(), d.e.tbds516)) / l.h(getContext(), d.e.tbds45);
        this.jpT = l.h(getContext(), d.e.tbds27);
        this.jpU = l.h(getContext(), d.e.tbds11);
        this.jpV = l.h(getContext(), d.e.tbds36);
        this.jpR = this.jpT;
        this.jpS = this.jpT;
        this.jpM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.jpQ * 2) {
                    if (ShareSdkView.this.jpR != 0) {
                        ShareSdkView.this.jpR = 0;
                        ShareSdkView.this.jpS = ShareSdkView.this.jpU;
                        ShareSdkView.this.jpM.setPadding(ShareSdkView.this.jpV, ShareSdkView.this.jpR, ShareSdkView.this.jpV, ShareSdkView.this.jpS);
                    }
                } else if (editable.length() > ShareSdkView.this.jpQ) {
                    if (ShareSdkView.this.jpR != ShareSdkView.this.jpU) {
                        ShareSdkView.this.jpR = ShareSdkView.this.jpU;
                        ShareSdkView.this.jpS = ShareSdkView.this.jpU;
                        ShareSdkView.this.jpM.setPadding(ShareSdkView.this.jpV, ShareSdkView.this.jpR, ShareSdkView.this.jpV, ShareSdkView.this.jpS);
                    }
                } else if (ShareSdkView.this.jpR != ShareSdkView.this.jpT) {
                    ShareSdkView.this.jpR = ShareSdkView.this.jpT;
                    ShareSdkView.this.jpS = ShareSdkView.this.jpT;
                    ShareSdkView.this.jpM.setPadding(ShareSdkView.this.jpV, ShareSdkView.this.jpR, ShareSdkView.this.jpV, ShareSdkView.this.jpS);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.jpW = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bjI) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.jpP && bc.cZ(getContext())) {
            String obj = this.jpM.getText().toString();
            if (this.jpW != null) {
                this.jpW.Ex(obj);
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
        this.jpK.setText(String.format(getResources().getString(d.j.share_sdk_forum), cVar.jpF));
        this.bNR.startLoad(cVar.jpE, 10, false);
        this.bNS.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.mContentView.setVisibility(8);
        } else {
            this.mContentView.setText(cVar.content);
        }
        this.eFa.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.eFa.getLayoutParams();
                layoutParams.height = ((l.aO(ShareSdkView.this.getContext()) - l.h(ShareSdkView.this.getContext(), d.e.tbds408)) * 9) / 16;
                ShareSdkView.this.eFa.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.eFa.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.jpW = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.l(this, d.C0236d.black_alpha30);
            al.k(this.mRootView, d.f.share_sdk_bg);
            al.j(this.jpK, d.C0236d.cp_cont_b);
            al.l(this.jpL, d.C0236d.cp_bg_line_e);
            this.bNR.setBorderColor(al.getColor(d.C0236d.cp_cont_g));
            this.bNR.setIsNight(this.mSkinType == 1);
            al.j(this.bNS, d.C0236d.cp_cont_f);
            al.j(this.mContentView, d.C0236d.cp_cont_b);
            this.eFa.setIsNight(this.mSkinType == 1);
            this.jpM.setHintTextColor(al.getColor(d.C0236d.cp_cont_e));
            this.jpM.setTextColor(al.getColor(d.C0236d.cp_cont_b));
            al.k(this.jpM, d.f.share_sdk_input_shape_bg);
            al.l(this.jpN, d.C0236d.cp_bg_line_c);
            al.j(this.bjI, d.C0236d.cp_cont_b);
            al.l(this.jpO, d.C0236d.cp_bg_line_c);
            al.j(this.jpP, d.C0236d.cp_link_tip_a);
        }
    }
}
