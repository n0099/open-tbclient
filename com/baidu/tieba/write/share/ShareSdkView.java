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
/* loaded from: classes10.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    private TextView bkp;
    private HeadImageView cZi;
    private TextView cZj;
    private TextView cun;
    private TbImageView fRV;
    private TextView iRU;
    private View kKL;
    private EditText kKM;
    private View kKN;
    private View kKO;
    private TextView kKP;
    private int kKQ;
    private int kKR;
    private int kKS;
    private int kKT;
    private int kKU;
    private int kKV;
    private a kKW;
    private View mRootView;
    private int mSkinType;

    /* loaded from: classes10.dex */
    public interface a {
        void yj(String str);
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
        this.iRU = (TextView) findViewById(R.id.share_sdk_forum);
        this.kKL = findViewById(R.id.share_sdk_content_container);
        this.cZi = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.cZj = (TextView) findViewById(R.id.share_sdk_appname);
        this.bkp = (TextView) findViewById(R.id.share_sdk_content);
        this.fRV = (TbImageView) findViewById(R.id.share_sdk_img);
        this.kKM = (EditText) findViewById(R.id.share_sdk_edit);
        this.kKN = findViewById(R.id.share_sdk_content_line);
        this.cun = (TextView) findViewById(R.id.share_sdk_cancel);
        this.kKO = findViewById(R.id.share_sdk_action_line);
        this.kKP = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.cun.setOnClickListener(this);
        this.kKP.setOnClickListener(this);
        this.cZi.setIsRound(true);
        this.cZi.setIsPreDrawBorder(true);
        this.cZi.setDrawBorder(true);
        this.cZi.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.cZi.setDefaultResource(R.color.cp_bg_line_e);
        this.cZi.setRadius(l.getDimens(context, R.dimen.ds70));
        this.fRV.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.kKQ = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.kKT = l.getDimens(getContext(), R.dimen.tbds27);
        this.kKU = l.getDimens(getContext(), R.dimen.tbds11);
        this.kKV = l.getDimens(getContext(), R.dimen.tbds36);
        this.kKR = this.kKT;
        this.kKS = this.kKT;
        this.kKM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.kKQ * 2) {
                    if (ShareSdkView.this.kKR != 0) {
                        ShareSdkView.this.kKR = 0;
                        ShareSdkView.this.kKS = ShareSdkView.this.kKU;
                        ShareSdkView.this.kKM.setPadding(ShareSdkView.this.kKV, ShareSdkView.this.kKR, ShareSdkView.this.kKV, ShareSdkView.this.kKS);
                    }
                } else if (editable.length() > ShareSdkView.this.kKQ) {
                    if (ShareSdkView.this.kKR != ShareSdkView.this.kKU) {
                        ShareSdkView.this.kKR = ShareSdkView.this.kKU;
                        ShareSdkView.this.kKS = ShareSdkView.this.kKU;
                        ShareSdkView.this.kKM.setPadding(ShareSdkView.this.kKV, ShareSdkView.this.kKR, ShareSdkView.this.kKV, ShareSdkView.this.kKS);
                    }
                } else if (ShareSdkView.this.kKR != ShareSdkView.this.kKT) {
                    ShareSdkView.this.kKR = ShareSdkView.this.kKT;
                    ShareSdkView.this.kKS = ShareSdkView.this.kKT;
                    ShareSdkView.this.kKM.setPadding(ShareSdkView.this.kKV, ShareSdkView.this.kKR, ShareSdkView.this.kKV, ShareSdkView.this.kKS);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.kKW = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cun) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.kKP && bc.checkUpIsLogin(getContext())) {
            String obj = this.kKM.getText().toString();
            if (this.kKW != null) {
                this.kKW.yj(obj);
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
        this.iRU.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.kKG));
        this.cZi.startLoad(cVar.kKF, 10, false);
        this.cZj.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.bkp.setVisibility(8);
        } else {
            this.bkp.setText(cVar.content);
        }
        this.fRV.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.fRV.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.fRV.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fRV.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.kKW = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.black_alpha30);
            am.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            am.setViewTextColor(this.iRU, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.kKL, R.color.cp_bg_line_e);
            this.cZi.setBorderColor(am.getColor(R.color.cp_cont_g));
            this.cZi.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.cZj, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.bkp, (int) R.color.cp_cont_b);
            this.fRV.setIsNight(this.mSkinType == 1);
            this.kKM.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.kKM.setTextColor(am.getColor(R.color.cp_cont_b));
            am.setBackgroundResource(this.kKM, R.drawable.share_sdk_input_shape_bg);
            am.setBackgroundColor(this.kKN, R.color.cp_bg_line_c);
            am.setViewTextColor(this.cun, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.kKO, R.color.cp_bg_line_c);
            am.setViewTextColor(this.kKP, (int) R.color.cp_link_tip_a);
        }
    }
}
