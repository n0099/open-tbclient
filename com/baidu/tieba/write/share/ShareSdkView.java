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
    private TextView cKm;
    private HeadImageView eQl;
    private TextView eQm;
    private TextView eei;
    private EditText ger;
    private TbImageView iog;
    private View kCO;
    private TextView lKN;
    private View mRootView;
    private int mSkinType;
    private View nJE;
    private View nJF;
    private TextView nJG;
    private int nJH;
    private int nJI;
    private int nJJ;
    private int nJK;
    private int nJL;
    private int nJM;
    private a nJN;

    /* loaded from: classes3.dex */
    public interface a {
        void hJ(String str);
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
        this.lKN = (TextView) findViewById(R.id.share_sdk_forum);
        this.nJE = findViewById(R.id.share_sdk_content_container);
        this.eQl = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.eQm = (TextView) findViewById(R.id.share_sdk_appname);
        this.cKm = (TextView) findViewById(R.id.share_sdk_content);
        this.iog = (TbImageView) findViewById(R.id.share_sdk_img);
        this.ger = (EditText) findViewById(R.id.share_sdk_edit);
        this.kCO = findViewById(R.id.share_sdk_content_line);
        this.eei = (TextView) findViewById(R.id.share_sdk_cancel);
        this.nJF = findViewById(R.id.share_sdk_action_line);
        this.nJG = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.eei.setOnClickListener(this);
        this.nJG.setOnClickListener(this);
        this.eQl.setIsRound(true);
        this.eQl.setIsPreDrawBorder(true);
        this.eQl.setDrawBorder(true);
        this.eQl.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.eQl.setDefaultResource(R.color.CAM_X0205);
        this.eQl.setRadius(l.getDimens(context, R.dimen.ds70));
        this.iog.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.nJH = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.nJK = l.getDimens(getContext(), R.dimen.tbds27);
        this.nJL = l.getDimens(getContext(), R.dimen.tbds11);
        this.nJM = l.getDimens(getContext(), R.dimen.tbds36);
        this.nJI = this.nJK;
        this.nJJ = this.nJK;
        this.ger.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.nJH * 2) {
                    if (ShareSdkView.this.nJI != 0) {
                        ShareSdkView.this.nJI = 0;
                        ShareSdkView.this.nJJ = ShareSdkView.this.nJL;
                        ShareSdkView.this.ger.setPadding(ShareSdkView.this.nJM, ShareSdkView.this.nJI, ShareSdkView.this.nJM, ShareSdkView.this.nJJ);
                    }
                } else if (editable.length() > ShareSdkView.this.nJH) {
                    if (ShareSdkView.this.nJI != ShareSdkView.this.nJL) {
                        ShareSdkView.this.nJI = ShareSdkView.this.nJL;
                        ShareSdkView.this.nJJ = ShareSdkView.this.nJL;
                        ShareSdkView.this.ger.setPadding(ShareSdkView.this.nJM, ShareSdkView.this.nJI, ShareSdkView.this.nJM, ShareSdkView.this.nJJ);
                    }
                } else if (ShareSdkView.this.nJI != ShareSdkView.this.nJK) {
                    ShareSdkView.this.nJI = ShareSdkView.this.nJK;
                    ShareSdkView.this.nJJ = ShareSdkView.this.nJK;
                    ShareSdkView.this.ger.setPadding(ShareSdkView.this.nJM, ShareSdkView.this.nJI, ShareSdkView.this.nJM, ShareSdkView.this.nJJ);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.nJN = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eei) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.nJG && bh.checkUpIsLogin(getContext())) {
            String obj = this.ger.getText().toString();
            if (this.nJN != null) {
                this.nJN.hJ(obj);
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
        this.lKN.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.nJz));
        this.eQl.startLoad(cVar.nJy, 10, false);
        this.eQm.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.cKm.setVisibility(8);
        } else {
            this.cKm.setText(cVar.content);
        }
        this.iog.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.iog.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.iog.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.iog.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.nJN = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.black_alpha30);
            ap.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            ap.setViewTextColor(this.lKN, R.color.CAM_X0105);
            ap.setBackgroundColor(this.nJE, R.color.CAM_X0205);
            this.eQl.setBorderColor(ap.getColor(R.color.CAM_X0111));
            this.eQl.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.eQm, R.color.CAM_X0106);
            ap.setViewTextColor(this.cKm, R.color.CAM_X0105);
            this.iog.setIsNight(this.mSkinType == 1);
            this.ger.setHintTextColor(ap.getColor(R.color.CAM_X0110));
            this.ger.setTextColor(ap.getColor(R.color.CAM_X0105));
            ap.setBackgroundResource(this.ger, R.drawable.share_sdk_input_shape_bg);
            ap.setBackgroundColor(this.kCO, R.color.CAM_X0204);
            ap.setViewTextColor(this.eei, R.color.CAM_X0105);
            ap.setBackgroundColor(this.nJF, R.color.CAM_X0204);
            ap.setViewTextColor(this.nJG, R.color.CAM_X0302);
        }
    }
}
