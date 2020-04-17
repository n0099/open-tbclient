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
/* loaded from: classes2.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    private TextView bNJ;
    private TextView cXI;
    private HeadImageView dDx;
    private TextView dDy;
    private EditText eLX;
    private TbImageView gEH;
    private TextView jIO;
    private View lAK;
    private View lAL;
    private View lAM;
    private TextView lAN;
    private int lAO;
    private int lAP;
    private int lAQ;
    private int lAR;
    private int lAS;
    private int lAT;
    private a lAU;
    private View mRootView;
    private int mSkinType;

    /* loaded from: classes2.dex */
    public interface a {
        void eL(String str);
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
        this.jIO = (TextView) findViewById(R.id.share_sdk_forum);
        this.lAK = findViewById(R.id.share_sdk_content_container);
        this.dDx = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.dDy = (TextView) findViewById(R.id.share_sdk_appname);
        this.bNJ = (TextView) findViewById(R.id.share_sdk_content);
        this.gEH = (TbImageView) findViewById(R.id.share_sdk_img);
        this.eLX = (EditText) findViewById(R.id.share_sdk_edit);
        this.lAL = findViewById(R.id.share_sdk_content_line);
        this.cXI = (TextView) findViewById(R.id.share_sdk_cancel);
        this.lAM = findViewById(R.id.share_sdk_action_line);
        this.lAN = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.cXI.setOnClickListener(this);
        this.lAN.setOnClickListener(this);
        this.dDx.setIsRound(true);
        this.dDx.setIsPreDrawBorder(true);
        this.dDx.setDrawBorder(true);
        this.dDx.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.dDx.setDefaultResource(R.color.cp_bg_line_e);
        this.dDx.setRadius(l.getDimens(context, R.dimen.ds70));
        this.gEH.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.lAO = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.lAR = l.getDimens(getContext(), R.dimen.tbds27);
        this.lAS = l.getDimens(getContext(), R.dimen.tbds11);
        this.lAT = l.getDimens(getContext(), R.dimen.tbds36);
        this.lAP = this.lAR;
        this.lAQ = this.lAR;
        this.eLX.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.lAO * 2) {
                    if (ShareSdkView.this.lAP != 0) {
                        ShareSdkView.this.lAP = 0;
                        ShareSdkView.this.lAQ = ShareSdkView.this.lAS;
                        ShareSdkView.this.eLX.setPadding(ShareSdkView.this.lAT, ShareSdkView.this.lAP, ShareSdkView.this.lAT, ShareSdkView.this.lAQ);
                    }
                } else if (editable.length() > ShareSdkView.this.lAO) {
                    if (ShareSdkView.this.lAP != ShareSdkView.this.lAS) {
                        ShareSdkView.this.lAP = ShareSdkView.this.lAS;
                        ShareSdkView.this.lAQ = ShareSdkView.this.lAS;
                        ShareSdkView.this.eLX.setPadding(ShareSdkView.this.lAT, ShareSdkView.this.lAP, ShareSdkView.this.lAT, ShareSdkView.this.lAQ);
                    }
                } else if (ShareSdkView.this.lAP != ShareSdkView.this.lAR) {
                    ShareSdkView.this.lAP = ShareSdkView.this.lAR;
                    ShareSdkView.this.lAQ = ShareSdkView.this.lAR;
                    ShareSdkView.this.eLX.setPadding(ShareSdkView.this.lAT, ShareSdkView.this.lAP, ShareSdkView.this.lAT, ShareSdkView.this.lAQ);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.lAU = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cXI) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.lAN && bc.checkUpIsLogin(getContext())) {
            String obj = this.eLX.getText().toString();
            if (this.lAU != null) {
                this.lAU.eL(obj);
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
        this.jIO.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.lAF));
        this.dDx.startLoad(cVar.lAE, 10, false);
        this.dDy.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.bNJ.setVisibility(8);
        } else {
            this.bNJ.setText(cVar.content);
        }
        this.gEH.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.gEH.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.gEH.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gEH.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.lAU = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.black_alpha30);
            am.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            am.setViewTextColor(this.jIO, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.lAK, R.color.cp_bg_line_e);
            this.dDx.setBorderColor(am.getColor(R.color.cp_cont_g));
            this.dDx.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.dDy, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.bNJ, (int) R.color.cp_cont_b);
            this.gEH.setIsNight(this.mSkinType == 1);
            this.eLX.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.eLX.setTextColor(am.getColor(R.color.cp_cont_b));
            am.setBackgroundResource(this.eLX, R.drawable.share_sdk_input_shape_bg);
            am.setBackgroundColor(this.lAL, R.color.cp_bg_line_c);
            am.setViewTextColor(this.cXI, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.lAM, R.color.cp_bg_line_c);
            am.setViewTextColor(this.lAN, (int) R.color.cp_link_tip_a);
        }
    }
}
