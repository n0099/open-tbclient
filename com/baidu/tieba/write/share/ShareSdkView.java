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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    private TextView cbI;
    private HeadImageView dYF;
    private TextView dYG;
    private TextView dnB;
    private EditText fjw;
    private TbImageView hgp;
    private TextView kvw;
    private View mRootView;
    private int mSkinType;
    private View mpH;
    private View mpI;
    private View mpJ;
    private TextView mpK;
    private int mpL;
    private int mpM;
    private int mpN;
    private int mpO;
    private int mpP;
    private int mpQ;
    private a mpR;

    /* loaded from: classes2.dex */
    public interface a {
        void fD(String str);
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
        this.kvw = (TextView) findViewById(R.id.share_sdk_forum);
        this.mpH = findViewById(R.id.share_sdk_content_container);
        this.dYF = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.dYG = (TextView) findViewById(R.id.share_sdk_appname);
        this.cbI = (TextView) findViewById(R.id.share_sdk_content);
        this.hgp = (TbImageView) findViewById(R.id.share_sdk_img);
        this.fjw = (EditText) findViewById(R.id.share_sdk_edit);
        this.mpI = findViewById(R.id.share_sdk_content_line);
        this.dnB = (TextView) findViewById(R.id.share_sdk_cancel);
        this.mpJ = findViewById(R.id.share_sdk_action_line);
        this.mpK = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.dnB.setOnClickListener(this);
        this.mpK.setOnClickListener(this);
        this.dYF.setIsRound(true);
        this.dYF.setIsPreDrawBorder(true);
        this.dYF.setDrawBorder(true);
        this.dYF.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.dYF.setDefaultResource(R.color.cp_bg_line_e);
        this.dYF.setRadius(l.getDimens(context, R.dimen.ds70));
        this.hgp.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.mpL = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.mpO = l.getDimens(getContext(), R.dimen.tbds27);
        this.mpP = l.getDimens(getContext(), R.dimen.tbds11);
        this.mpQ = l.getDimens(getContext(), R.dimen.tbds36);
        this.mpM = this.mpO;
        this.mpN = this.mpO;
        this.fjw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.mpL * 2) {
                    if (ShareSdkView.this.mpM != 0) {
                        ShareSdkView.this.mpM = 0;
                        ShareSdkView.this.mpN = ShareSdkView.this.mpP;
                        ShareSdkView.this.fjw.setPadding(ShareSdkView.this.mpQ, ShareSdkView.this.mpM, ShareSdkView.this.mpQ, ShareSdkView.this.mpN);
                    }
                } else if (editable.length() > ShareSdkView.this.mpL) {
                    if (ShareSdkView.this.mpM != ShareSdkView.this.mpP) {
                        ShareSdkView.this.mpM = ShareSdkView.this.mpP;
                        ShareSdkView.this.mpN = ShareSdkView.this.mpP;
                        ShareSdkView.this.fjw.setPadding(ShareSdkView.this.mpQ, ShareSdkView.this.mpM, ShareSdkView.this.mpQ, ShareSdkView.this.mpN);
                    }
                } else if (ShareSdkView.this.mpM != ShareSdkView.this.mpO) {
                    ShareSdkView.this.mpM = ShareSdkView.this.mpO;
                    ShareSdkView.this.mpN = ShareSdkView.this.mpO;
                    ShareSdkView.this.fjw.setPadding(ShareSdkView.this.mpQ, ShareSdkView.this.mpM, ShareSdkView.this.mpQ, ShareSdkView.this.mpN);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.mpR = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dnB) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.mpK && be.checkUpIsLogin(getContext())) {
            String obj = this.fjw.getText().toString();
            if (this.mpR != null) {
                this.mpR.fD(obj);
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
        this.kvw.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.mpC));
        this.dYF.startLoad(cVar.mpB, 10, false);
        this.dYG.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.cbI.setVisibility(8);
        } else {
            this.cbI.setText(cVar.content);
        }
        this.hgp.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.hgp.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.hgp.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.hgp.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.mpR = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            an.setBackgroundColor(this, R.color.black_alpha30);
            an.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            an.setViewTextColor(this.kvw, (int) R.color.cp_cont_b);
            an.setBackgroundColor(this.mpH, R.color.cp_bg_line_e);
            this.dYF.setBorderColor(an.getColor(R.color.cp_cont_g));
            this.dYF.setIsNight(this.mSkinType == 1);
            an.setViewTextColor(this.dYG, (int) R.color.cp_cont_f);
            an.setViewTextColor(this.cbI, (int) R.color.cp_cont_b);
            this.hgp.setIsNight(this.mSkinType == 1);
            this.fjw.setHintTextColor(an.getColor(R.color.cp_cont_e));
            this.fjw.setTextColor(an.getColor(R.color.cp_cont_b));
            an.setBackgroundResource(this.fjw, R.drawable.share_sdk_input_shape_bg);
            an.setBackgroundColor(this.mpI, R.color.cp_bg_line_c);
            an.setViewTextColor(this.dnB, (int) R.color.cp_cont_b);
            an.setBackgroundColor(this.mpJ, R.color.cp_bg_line_c);
            an.setViewTextColor(this.mpK, (int) R.color.cp_link_tip_a);
        }
    }
}
