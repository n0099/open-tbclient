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
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    private TextView cRq;
    private TextView epA;
    private HeadImageView fct;
    private TextView fcu;
    private EditText gsr;
    private TbImageView iGG;
    private View kRi;
    private TextView lZu;
    private View mRootView;
    private int mSkinType;
    private View nWa;
    private View nWb;
    private TextView nWc;
    private int nWd;
    private int nWe;
    private int nWf;
    private int nWg;
    private int nWh;
    private int nWi;
    private a nWj;

    /* loaded from: classes7.dex */
    public interface a {
        void gN(String str);
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
        this.lZu = (TextView) findViewById(R.id.share_sdk_forum);
        this.nWa = findViewById(R.id.share_sdk_content_container);
        this.fct = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.fcu = (TextView) findViewById(R.id.share_sdk_appname);
        this.cRq = (TextView) findViewById(R.id.share_sdk_content);
        this.iGG = (TbImageView) findViewById(R.id.share_sdk_img);
        this.gsr = (EditText) findViewById(R.id.share_sdk_edit);
        this.kRi = findViewById(R.id.share_sdk_content_line);
        this.epA = (TextView) findViewById(R.id.share_sdk_cancel);
        this.nWb = findViewById(R.id.share_sdk_action_line);
        this.nWc = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.epA.setOnClickListener(this);
        this.nWc.setOnClickListener(this);
        this.fct.setIsRound(true);
        this.fct.setIsPreDrawBorder(true);
        this.fct.setDrawBorder(true);
        this.fct.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.fct.setDefaultResource(R.color.CAM_X0205);
        this.fct.setRadius(l.getDimens(context, R.dimen.ds70));
        this.iGG.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.nWd = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.nWg = l.getDimens(getContext(), R.dimen.tbds27);
        this.nWh = l.getDimens(getContext(), R.dimen.tbds11);
        this.nWi = l.getDimens(getContext(), R.dimen.tbds36);
        this.nWe = this.nWg;
        this.nWf = this.nWg;
        this.gsr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.nWd * 2) {
                    if (ShareSdkView.this.nWe != 0) {
                        ShareSdkView.this.nWe = 0;
                        ShareSdkView.this.nWf = ShareSdkView.this.nWh;
                        ShareSdkView.this.gsr.setPadding(ShareSdkView.this.nWi, ShareSdkView.this.nWe, ShareSdkView.this.nWi, ShareSdkView.this.nWf);
                    }
                } else if (editable.length() > ShareSdkView.this.nWd) {
                    if (ShareSdkView.this.nWe != ShareSdkView.this.nWh) {
                        ShareSdkView.this.nWe = ShareSdkView.this.nWh;
                        ShareSdkView.this.nWf = ShareSdkView.this.nWh;
                        ShareSdkView.this.gsr.setPadding(ShareSdkView.this.nWi, ShareSdkView.this.nWe, ShareSdkView.this.nWi, ShareSdkView.this.nWf);
                    }
                } else if (ShareSdkView.this.nWe != ShareSdkView.this.nWg) {
                    ShareSdkView.this.nWe = ShareSdkView.this.nWg;
                    ShareSdkView.this.nWf = ShareSdkView.this.nWg;
                    ShareSdkView.this.gsr.setPadding(ShareSdkView.this.nWi, ShareSdkView.this.nWe, ShareSdkView.this.nWi, ShareSdkView.this.nWf);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.nWj = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.epA) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.nWc && bg.checkUpIsLogin(getContext())) {
            String obj = this.gsr.getText().toString();
            if (this.nWj != null) {
                this.nWj.gN(obj);
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
        this.lZu.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.nVV));
        this.fct.startLoad(cVar.nVU, 10, false);
        this.fcu.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.cRq.setVisibility(8);
        } else {
            this.cRq.setText(cVar.content);
        }
        this.iGG.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.iGG.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.iGG.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        this.iGG.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.nWj = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ao.setBackgroundColor(this, R.color.black_alpha30);
            ao.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            ao.setViewTextColor(this.lZu, R.color.CAM_X0105);
            ao.setBackgroundColor(this.nWa, R.color.CAM_X0205);
            this.fct.setBorderColor(ao.getColor(R.color.CAM_X0111));
            this.fct.setIsNight(this.mSkinType == 1);
            ao.setViewTextColor(this.fcu, R.color.CAM_X0106);
            ao.setViewTextColor(this.cRq, R.color.CAM_X0105);
            this.iGG.setIsNight(this.mSkinType == 1);
            this.gsr.setHintTextColor(ao.getColor(R.color.CAM_X0110));
            this.gsr.setTextColor(ao.getColor(R.color.CAM_X0105));
            ao.setBackgroundResource(this.gsr, R.drawable.share_sdk_input_shape_bg);
            ao.setBackgroundColor(this.kRi, R.color.CAM_X0204);
            ao.setViewTextColor(this.epA, R.color.CAM_X0105);
            ao.setBackgroundColor(this.nWb, R.color.CAM_X0204);
            ao.setViewTextColor(this.nWc, R.color.CAM_X0302);
        }
    }
}
