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
    private TextView kEp;
    private View mRootView;
    private int mSkinType;
    private View mxJ;
    private View mxK;
    private View mxL;
    private TextView mxM;
    private int mxN;
    private int mxO;
    private int mxP;
    private int mxQ;
    private int mxR;
    private int mxS;
    private a mxT;

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
        this.kEp = (TextView) findViewById(R.id.share_sdk_forum);
        this.mxJ = findViewById(R.id.share_sdk_content_container);
        this.eeS = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.eeT = (TextView) findViewById(R.id.share_sdk_appname);
        this.cdm = (TextView) findViewById(R.id.share_sdk_content);
        this.hlZ = (TbImageView) findViewById(R.id.share_sdk_img);
        this.foD = (EditText) findViewById(R.id.share_sdk_edit);
        this.mxK = findViewById(R.id.share_sdk_content_line);
        this.dtx = (TextView) findViewById(R.id.share_sdk_cancel);
        this.mxL = findViewById(R.id.share_sdk_action_line);
        this.mxM = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.dtx.setOnClickListener(this);
        this.mxM.setOnClickListener(this);
        this.eeS.setIsRound(true);
        this.eeS.setIsPreDrawBorder(true);
        this.eeS.setDrawBorder(true);
        this.eeS.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.eeS.setDefaultResource(R.color.cp_bg_line_e);
        this.eeS.setRadius(l.getDimens(context, R.dimen.ds70));
        this.hlZ.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.mxN = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.mxQ = l.getDimens(getContext(), R.dimen.tbds27);
        this.mxR = l.getDimens(getContext(), R.dimen.tbds11);
        this.mxS = l.getDimens(getContext(), R.dimen.tbds36);
        this.mxO = this.mxQ;
        this.mxP = this.mxQ;
        this.foD.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.mxN * 2) {
                    if (ShareSdkView.this.mxO != 0) {
                        ShareSdkView.this.mxO = 0;
                        ShareSdkView.this.mxP = ShareSdkView.this.mxR;
                        ShareSdkView.this.foD.setPadding(ShareSdkView.this.mxS, ShareSdkView.this.mxO, ShareSdkView.this.mxS, ShareSdkView.this.mxP);
                    }
                } else if (editable.length() > ShareSdkView.this.mxN) {
                    if (ShareSdkView.this.mxO != ShareSdkView.this.mxR) {
                        ShareSdkView.this.mxO = ShareSdkView.this.mxR;
                        ShareSdkView.this.mxP = ShareSdkView.this.mxR;
                        ShareSdkView.this.foD.setPadding(ShareSdkView.this.mxS, ShareSdkView.this.mxO, ShareSdkView.this.mxS, ShareSdkView.this.mxP);
                    }
                } else if (ShareSdkView.this.mxO != ShareSdkView.this.mxQ) {
                    ShareSdkView.this.mxO = ShareSdkView.this.mxQ;
                    ShareSdkView.this.mxP = ShareSdkView.this.mxQ;
                    ShareSdkView.this.foD.setPadding(ShareSdkView.this.mxS, ShareSdkView.this.mxO, ShareSdkView.this.mxS, ShareSdkView.this.mxP);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.mxT = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dtx) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.mxM && bf.checkUpIsLogin(getContext())) {
            String obj = this.foD.getText().toString();
            if (this.mxT != null) {
                this.mxT.fB(obj);
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
        this.kEp.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.mxE));
        this.eeS.startLoad(cVar.mxD, 10, false);
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
        this.mxT = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ao.setBackgroundColor(this, R.color.black_alpha30);
            ao.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            ao.setViewTextColor(this.kEp, R.color.cp_cont_b);
            ao.setBackgroundColor(this.mxJ, R.color.cp_bg_line_e);
            this.eeS.setBorderColor(ao.getColor(R.color.cp_cont_g));
            this.eeS.setIsNight(this.mSkinType == 1);
            ao.setViewTextColor(this.eeT, R.color.cp_cont_f);
            ao.setViewTextColor(this.cdm, R.color.cp_cont_b);
            this.hlZ.setIsNight(this.mSkinType == 1);
            this.foD.setHintTextColor(ao.getColor(R.color.cp_cont_e));
            this.foD.setTextColor(ao.getColor(R.color.cp_cont_b));
            ao.setBackgroundResource(this.foD, R.drawable.share_sdk_input_shape_bg);
            ao.setBackgroundColor(this.mxK, R.color.cp_bg_line_c);
            ao.setViewTextColor(this.dtx, R.color.cp_cont_b);
            ao.setBackgroundColor(this.mxL, R.color.cp_bg_line_c);
            ao.setViewTextColor(this.mxM, R.color.cp_link_tip_a);
        }
    }
}
