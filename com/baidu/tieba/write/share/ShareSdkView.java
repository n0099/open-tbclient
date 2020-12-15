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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    private TextView cRf;
    private HeadImageView eXA;
    private TextView eXB;
    private TextView elj;
    private EditText gmB;
    private TbImageView iza;
    private View kQi;
    private TextView lYN;
    private View mRootView;
    private int mSkinType;
    private View nXM;
    private View nXN;
    private TextView nXO;
    private int nXP;
    private int nXQ;
    private int nXR;
    private int nXS;
    private int nXT;
    private int nXU;
    private a nXV;

    /* loaded from: classes3.dex */
    public interface a {
        void im(String str);
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
        this.lYN = (TextView) findViewById(R.id.share_sdk_forum);
        this.nXM = findViewById(R.id.share_sdk_content_container);
        this.eXA = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.eXB = (TextView) findViewById(R.id.share_sdk_appname);
        this.cRf = (TextView) findViewById(R.id.share_sdk_content);
        this.iza = (TbImageView) findViewById(R.id.share_sdk_img);
        this.gmB = (EditText) findViewById(R.id.share_sdk_edit);
        this.kQi = findViewById(R.id.share_sdk_content_line);
        this.elj = (TextView) findViewById(R.id.share_sdk_cancel);
        this.nXN = findViewById(R.id.share_sdk_action_line);
        this.nXO = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.elj.setOnClickListener(this);
        this.nXO.setOnClickListener(this);
        this.eXA.setIsRound(true);
        this.eXA.setIsPreDrawBorder(true);
        this.eXA.setDrawBorder(true);
        this.eXA.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.eXA.setDefaultResource(R.color.CAM_X0205);
        this.eXA.setRadius(l.getDimens(context, R.dimen.ds70));
        this.iza.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.nXP = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.nXS = l.getDimens(getContext(), R.dimen.tbds27);
        this.nXT = l.getDimens(getContext(), R.dimen.tbds11);
        this.nXU = l.getDimens(getContext(), R.dimen.tbds36);
        this.nXQ = this.nXS;
        this.nXR = this.nXS;
        this.gmB.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.nXP * 2) {
                    if (ShareSdkView.this.nXQ != 0) {
                        ShareSdkView.this.nXQ = 0;
                        ShareSdkView.this.nXR = ShareSdkView.this.nXT;
                        ShareSdkView.this.gmB.setPadding(ShareSdkView.this.nXU, ShareSdkView.this.nXQ, ShareSdkView.this.nXU, ShareSdkView.this.nXR);
                    }
                } else if (editable.length() > ShareSdkView.this.nXP) {
                    if (ShareSdkView.this.nXQ != ShareSdkView.this.nXT) {
                        ShareSdkView.this.nXQ = ShareSdkView.this.nXT;
                        ShareSdkView.this.nXR = ShareSdkView.this.nXT;
                        ShareSdkView.this.gmB.setPadding(ShareSdkView.this.nXU, ShareSdkView.this.nXQ, ShareSdkView.this.nXU, ShareSdkView.this.nXR);
                    }
                } else if (ShareSdkView.this.nXQ != ShareSdkView.this.nXS) {
                    ShareSdkView.this.nXQ = ShareSdkView.this.nXS;
                    ShareSdkView.this.nXR = ShareSdkView.this.nXS;
                    ShareSdkView.this.gmB.setPadding(ShareSdkView.this.nXU, ShareSdkView.this.nXQ, ShareSdkView.this.nXU, ShareSdkView.this.nXR);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.nXV = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.elj) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.nXO && bh.checkUpIsLogin(getContext())) {
            String obj = this.gmB.getText().toString();
            if (this.nXV != null) {
                this.nXV.im(obj);
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
        this.lYN.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.nXH));
        this.eXA.startLoad(cVar.nXG, 10, false);
        this.eXB.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.cRf.setVisibility(8);
        } else {
            this.cRf.setText(cVar.content);
        }
        this.iza.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.iza.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.iza.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.iza.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.nXV = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.black_alpha30);
            ap.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            ap.setViewTextColor(this.lYN, R.color.CAM_X0105);
            ap.setBackgroundColor(this.nXM, R.color.CAM_X0205);
            this.eXA.setBorderColor(ap.getColor(R.color.CAM_X0111));
            this.eXA.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.eXB, R.color.CAM_X0106);
            ap.setViewTextColor(this.cRf, R.color.CAM_X0105);
            this.iza.setIsNight(this.mSkinType == 1);
            this.gmB.setHintTextColor(ap.getColor(R.color.CAM_X0110));
            this.gmB.setTextColor(ap.getColor(R.color.CAM_X0105));
            ap.setBackgroundResource(this.gmB, R.drawable.share_sdk_input_shape_bg);
            ap.setBackgroundColor(this.kQi, R.color.CAM_X0204);
            ap.setViewTextColor(this.elj, R.color.CAM_X0105);
            ap.setBackgroundColor(this.nXN, R.color.CAM_X0204);
            ap.setViewTextColor(this.nXO, R.color.CAM_X0302);
        }
    }
}
