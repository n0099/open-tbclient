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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    private TextView cdm;
    private TextView dtx;
    private HeadImageView eeS;
    private TextView eeT;
    private EditText foD;
    private TbImageView hlZ;
    private TextView kEr;
    private View mRootView;
    private int mSkinType;
    private View mxL;
    private View mxM;
    private View mxN;
    private TextView mxO;
    private int mxP;
    private int mxQ;
    private int mxR;
    private int mxS;
    private int mxT;
    private int mxU;
    private a mxV;

    /* loaded from: classes3.dex */
    public interface a {
        void fB(String str);
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
        this.kEr = (TextView) findViewById(R.id.share_sdk_forum);
        this.mxL = findViewById(R.id.share_sdk_content_container);
        this.eeS = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.eeT = (TextView) findViewById(R.id.share_sdk_appname);
        this.cdm = (TextView) findViewById(R.id.share_sdk_content);
        this.hlZ = (TbImageView) findViewById(R.id.share_sdk_img);
        this.foD = (EditText) findViewById(R.id.share_sdk_edit);
        this.mxM = findViewById(R.id.share_sdk_content_line);
        this.dtx = (TextView) findViewById(R.id.share_sdk_cancel);
        this.mxN = findViewById(R.id.share_sdk_action_line);
        this.mxO = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.dtx.setOnClickListener(this);
        this.mxO.setOnClickListener(this);
        this.eeS.setIsRound(true);
        this.eeS.setIsPreDrawBorder(true);
        this.eeS.setDrawBorder(true);
        this.eeS.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.eeS.setDefaultResource(R.color.cp_bg_line_e);
        this.eeS.setRadius(l.getDimens(context, R.dimen.ds70));
        this.hlZ.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.mxP = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.mxS = l.getDimens(getContext(), R.dimen.tbds27);
        this.mxT = l.getDimens(getContext(), R.dimen.tbds11);
        this.mxU = l.getDimens(getContext(), R.dimen.tbds36);
        this.mxQ = this.mxS;
        this.mxR = this.mxS;
        this.foD.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.mxP * 2) {
                    if (ShareSdkView.this.mxQ != 0) {
                        ShareSdkView.this.mxQ = 0;
                        ShareSdkView.this.mxR = ShareSdkView.this.mxT;
                        ShareSdkView.this.foD.setPadding(ShareSdkView.this.mxU, ShareSdkView.this.mxQ, ShareSdkView.this.mxU, ShareSdkView.this.mxR);
                    }
                } else if (editable.length() > ShareSdkView.this.mxP) {
                    if (ShareSdkView.this.mxQ != ShareSdkView.this.mxT) {
                        ShareSdkView.this.mxQ = ShareSdkView.this.mxT;
                        ShareSdkView.this.mxR = ShareSdkView.this.mxT;
                        ShareSdkView.this.foD.setPadding(ShareSdkView.this.mxU, ShareSdkView.this.mxQ, ShareSdkView.this.mxU, ShareSdkView.this.mxR);
                    }
                } else if (ShareSdkView.this.mxQ != ShareSdkView.this.mxS) {
                    ShareSdkView.this.mxQ = ShareSdkView.this.mxS;
                    ShareSdkView.this.mxR = ShareSdkView.this.mxS;
                    ShareSdkView.this.foD.setPadding(ShareSdkView.this.mxU, ShareSdkView.this.mxQ, ShareSdkView.this.mxU, ShareSdkView.this.mxR);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.mxV = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dtx) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.mxO && bf.checkUpIsLogin(getContext())) {
            String obj = this.foD.getText().toString();
            if (this.mxV != null) {
                this.mxV.fB(obj);
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
        this.kEr.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.mxG));
        this.eeS.startLoad(cVar.mxF, 10, false);
        this.eeT.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.cdm.setVisibility(8);
        } else {
            this.cdm.setText(cVar.content);
        }
        this.hlZ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.hlZ.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.hlZ.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.hlZ.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.mxV = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ao.setBackgroundColor(this, R.color.black_alpha30);
            ao.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            ao.setViewTextColor(this.kEr, R.color.cp_cont_b);
            ao.setBackgroundColor(this.mxL, R.color.cp_bg_line_e);
            this.eeS.setBorderColor(ao.getColor(R.color.cp_cont_g));
            this.eeS.setIsNight(this.mSkinType == 1);
            ao.setViewTextColor(this.eeT, R.color.cp_cont_f);
            ao.setViewTextColor(this.cdm, R.color.cp_cont_b);
            this.hlZ.setIsNight(this.mSkinType == 1);
            this.foD.setHintTextColor(ao.getColor(R.color.cp_cont_e));
            this.foD.setTextColor(ao.getColor(R.color.cp_cont_b));
            ao.setBackgroundResource(this.foD, R.drawable.share_sdk_input_shape_bg);
            ao.setBackgroundColor(this.mxM, R.color.cp_bg_line_c);
            ao.setViewTextColor(this.dtx, R.color.cp_cont_b);
            ao.setBackgroundColor(this.mxN, R.color.cp_bg_line_c);
            ao.setViewTextColor(this.mxO, R.color.cp_link_tip_a);
        }
    }
}
