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
/* loaded from: classes13.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    private TextView bpC;
    private TextView cyL;
    private HeadImageView ddY;
    private TextView ddZ;
    private TbImageView fYd;
    private TextView iYG;
    private View kQL;
    private EditText kQM;
    private View kQN;
    private View kQO;
    private TextView kQP;
    private int kQQ;
    private int kQR;
    private int kQS;
    private int kQT;
    private int kQU;
    private int kQV;
    private a kQW;
    private View mRootView;
    private int mSkinType;

    /* loaded from: classes13.dex */
    public interface a {
        void dS(String str);
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
        this.iYG = (TextView) findViewById(R.id.share_sdk_forum);
        this.kQL = findViewById(R.id.share_sdk_content_container);
        this.ddY = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.ddZ = (TextView) findViewById(R.id.share_sdk_appname);
        this.bpC = (TextView) findViewById(R.id.share_sdk_content);
        this.fYd = (TbImageView) findViewById(R.id.share_sdk_img);
        this.kQM = (EditText) findViewById(R.id.share_sdk_edit);
        this.kQN = findViewById(R.id.share_sdk_content_line);
        this.cyL = (TextView) findViewById(R.id.share_sdk_cancel);
        this.kQO = findViewById(R.id.share_sdk_action_line);
        this.kQP = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.cyL.setOnClickListener(this);
        this.kQP.setOnClickListener(this);
        this.ddY.setIsRound(true);
        this.ddY.setIsPreDrawBorder(true);
        this.ddY.setDrawBorder(true);
        this.ddY.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.ddY.setDefaultResource(R.color.cp_bg_line_e);
        this.ddY.setRadius(l.getDimens(context, R.dimen.ds70));
        this.fYd.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.kQQ = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.kQT = l.getDimens(getContext(), R.dimen.tbds27);
        this.kQU = l.getDimens(getContext(), R.dimen.tbds11);
        this.kQV = l.getDimens(getContext(), R.dimen.tbds36);
        this.kQR = this.kQT;
        this.kQS = this.kQT;
        this.kQM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.kQQ * 2) {
                    if (ShareSdkView.this.kQR != 0) {
                        ShareSdkView.this.kQR = 0;
                        ShareSdkView.this.kQS = ShareSdkView.this.kQU;
                        ShareSdkView.this.kQM.setPadding(ShareSdkView.this.kQV, ShareSdkView.this.kQR, ShareSdkView.this.kQV, ShareSdkView.this.kQS);
                    }
                } else if (editable.length() > ShareSdkView.this.kQQ) {
                    if (ShareSdkView.this.kQR != ShareSdkView.this.kQU) {
                        ShareSdkView.this.kQR = ShareSdkView.this.kQU;
                        ShareSdkView.this.kQS = ShareSdkView.this.kQU;
                        ShareSdkView.this.kQM.setPadding(ShareSdkView.this.kQV, ShareSdkView.this.kQR, ShareSdkView.this.kQV, ShareSdkView.this.kQS);
                    }
                } else if (ShareSdkView.this.kQR != ShareSdkView.this.kQT) {
                    ShareSdkView.this.kQR = ShareSdkView.this.kQT;
                    ShareSdkView.this.kQS = ShareSdkView.this.kQT;
                    ShareSdkView.this.kQM.setPadding(ShareSdkView.this.kQV, ShareSdkView.this.kQR, ShareSdkView.this.kQV, ShareSdkView.this.kQS);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.kQW = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cyL) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.kQP && bc.checkUpIsLogin(getContext())) {
            String obj = this.kQM.getText().toString();
            if (this.kQW != null) {
                this.kQW.dS(obj);
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
        this.iYG.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.kQG));
        this.ddY.startLoad(cVar.kQF, 10, false);
        this.ddZ.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.bpC.setVisibility(8);
        } else {
            this.bpC.setText(cVar.content);
        }
        this.fYd.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.fYd.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.fYd.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fYd.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.kQW = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.black_alpha30);
            am.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            am.setViewTextColor(this.iYG, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.kQL, R.color.cp_bg_line_e);
            this.ddY.setBorderColor(am.getColor(R.color.cp_cont_g));
            this.ddY.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.ddZ, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.bpC, (int) R.color.cp_cont_b);
            this.fYd.setIsNight(this.mSkinType == 1);
            this.kQM.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.kQM.setTextColor(am.getColor(R.color.cp_cont_b));
            am.setBackgroundResource(this.kQM, R.drawable.share_sdk_input_shape_bg);
            am.setBackgroundColor(this.kQN, R.color.cp_bg_line_c);
            am.setViewTextColor(this.cyL, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.kQO, R.color.cp_bg_line_c);
            am.setViewTextColor(this.kQP, (int) R.color.cp_link_tip_a);
        }
    }
}
