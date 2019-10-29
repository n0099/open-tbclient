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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    private TextView aMf;
    private TextView bJM;
    private HeadImageView cmN;
    private TextView cmO;
    private TbImageView fej;
    private TextView jQP;
    private View jQQ;
    private EditText jQR;
    private View jQS;
    private View jQT;
    private TextView jQU;
    private int jQV;
    private int jQW;
    private int jQX;
    private int jQY;
    private int jQZ;
    private int jRa;
    private a jRb;
    private View mRootView;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void tu(String str);
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
        LayoutInflater.from(context).inflate(R.layout.share_sdk_view, (ViewGroup) this, true);
        this.mRootView = findViewById(R.id.share_sdk_content_root);
        this.jQP = (TextView) findViewById(R.id.share_sdk_forum);
        this.jQQ = findViewById(R.id.share_sdk_content_container);
        this.cmN = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.cmO = (TextView) findViewById(R.id.share_sdk_appname);
        this.aMf = (TextView) findViewById(R.id.share_sdk_content);
        this.fej = (TbImageView) findViewById(R.id.share_sdk_img);
        this.jQR = (EditText) findViewById(R.id.share_sdk_edit);
        this.jQS = findViewById(R.id.share_sdk_content_line);
        this.bJM = (TextView) findViewById(R.id.share_sdk_cancel);
        this.jQT = findViewById(R.id.share_sdk_action_line);
        this.jQU = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.bJM.setOnClickListener(this);
        this.jQU.setOnClickListener(this);
        this.cmN.setIsRound(true);
        this.cmN.setIsPreDrawBorder(true);
        this.cmN.setDrawBorder(true);
        this.cmN.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.cmN.setDefaultResource(R.color.cp_bg_line_e);
        this.cmN.setRadius(l.getDimens(context, R.dimen.ds70));
        this.fej.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.jQV = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.jQY = l.getDimens(getContext(), R.dimen.tbds27);
        this.jQZ = l.getDimens(getContext(), R.dimen.tbds11);
        this.jRa = l.getDimens(getContext(), R.dimen.tbds36);
        this.jQW = this.jQY;
        this.jQX = this.jQY;
        this.jQR.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.jQV * 2) {
                    if (ShareSdkView.this.jQW != 0) {
                        ShareSdkView.this.jQW = 0;
                        ShareSdkView.this.jQX = ShareSdkView.this.jQZ;
                        ShareSdkView.this.jQR.setPadding(ShareSdkView.this.jRa, ShareSdkView.this.jQW, ShareSdkView.this.jRa, ShareSdkView.this.jQX);
                    }
                } else if (editable.length() > ShareSdkView.this.jQV) {
                    if (ShareSdkView.this.jQW != ShareSdkView.this.jQZ) {
                        ShareSdkView.this.jQW = ShareSdkView.this.jQZ;
                        ShareSdkView.this.jQX = ShareSdkView.this.jQZ;
                        ShareSdkView.this.jQR.setPadding(ShareSdkView.this.jRa, ShareSdkView.this.jQW, ShareSdkView.this.jRa, ShareSdkView.this.jQX);
                    }
                } else if (ShareSdkView.this.jQW != ShareSdkView.this.jQY) {
                    ShareSdkView.this.jQW = ShareSdkView.this.jQY;
                    ShareSdkView.this.jQX = ShareSdkView.this.jQY;
                    ShareSdkView.this.jQR.setPadding(ShareSdkView.this.jRa, ShareSdkView.this.jQW, ShareSdkView.this.jRa, ShareSdkView.this.jQX);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.jRb = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bJM) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.jQU && bc.checkUpIsLogin(getContext())) {
            String obj = this.jQR.getText().toString();
            if (this.jRb != null) {
                this.jRb.tu(obj);
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
        this.jQP.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.jQK));
        this.cmN.startLoad(cVar.jQJ, 10, false);
        this.cmO.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.aMf.setVisibility(8);
        } else {
            this.aMf.setText(cVar.content);
        }
        this.fej.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.fej.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.fej.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fej.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.jRb = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.black_alpha30);
            am.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            am.setViewTextColor(this.jQP, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.jQQ, R.color.cp_bg_line_e);
            this.cmN.setBorderColor(am.getColor(R.color.cp_cont_g));
            this.cmN.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.cmO, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.aMf, (int) R.color.cp_cont_b);
            this.fej.setIsNight(this.mSkinType == 1);
            this.jQR.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.jQR.setTextColor(am.getColor(R.color.cp_cont_b));
            am.setBackgroundResource(this.jQR, R.drawable.share_sdk_input_shape_bg);
            am.setBackgroundColor(this.jQS, R.color.cp_bg_line_c);
            am.setViewTextColor(this.bJM, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.jQT, R.color.cp_bg_line_c);
            am.setViewTextColor(this.jQU, (int) R.color.cp_link_tip_a);
        }
    }
}
