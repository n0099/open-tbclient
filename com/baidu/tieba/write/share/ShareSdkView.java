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
    private TextView bpp;
    private TextView cyz;
    private HeadImageView ddy;
    private TextView ddz;
    private TbImageView fXi;
    private TextView iWT;
    private View kOZ;
    private EditText kPa;
    private View kPb;
    private View kPc;
    private TextView kPd;
    private int kPe;
    private int kPf;
    private int kPg;
    private int kPh;
    private int kPi;
    private int kPj;
    private a kPk;
    private View mRootView;
    private int mSkinType;

    /* loaded from: classes13.dex */
    public interface a {
        void dT(String str);
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
        this.iWT = (TextView) findViewById(R.id.share_sdk_forum);
        this.kOZ = findViewById(R.id.share_sdk_content_container);
        this.ddy = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.ddz = (TextView) findViewById(R.id.share_sdk_appname);
        this.bpp = (TextView) findViewById(R.id.share_sdk_content);
        this.fXi = (TbImageView) findViewById(R.id.share_sdk_img);
        this.kPa = (EditText) findViewById(R.id.share_sdk_edit);
        this.kPb = findViewById(R.id.share_sdk_content_line);
        this.cyz = (TextView) findViewById(R.id.share_sdk_cancel);
        this.kPc = findViewById(R.id.share_sdk_action_line);
        this.kPd = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.cyz.setOnClickListener(this);
        this.kPd.setOnClickListener(this);
        this.ddy.setIsRound(true);
        this.ddy.setIsPreDrawBorder(true);
        this.ddy.setDrawBorder(true);
        this.ddy.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.ddy.setDefaultResource(R.color.cp_bg_line_e);
        this.ddy.setRadius(l.getDimens(context, R.dimen.ds70));
        this.fXi.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.kPe = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.kPh = l.getDimens(getContext(), R.dimen.tbds27);
        this.kPi = l.getDimens(getContext(), R.dimen.tbds11);
        this.kPj = l.getDimens(getContext(), R.dimen.tbds36);
        this.kPf = this.kPh;
        this.kPg = this.kPh;
        this.kPa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.kPe * 2) {
                    if (ShareSdkView.this.kPf != 0) {
                        ShareSdkView.this.kPf = 0;
                        ShareSdkView.this.kPg = ShareSdkView.this.kPi;
                        ShareSdkView.this.kPa.setPadding(ShareSdkView.this.kPj, ShareSdkView.this.kPf, ShareSdkView.this.kPj, ShareSdkView.this.kPg);
                    }
                } else if (editable.length() > ShareSdkView.this.kPe) {
                    if (ShareSdkView.this.kPf != ShareSdkView.this.kPi) {
                        ShareSdkView.this.kPf = ShareSdkView.this.kPi;
                        ShareSdkView.this.kPg = ShareSdkView.this.kPi;
                        ShareSdkView.this.kPa.setPadding(ShareSdkView.this.kPj, ShareSdkView.this.kPf, ShareSdkView.this.kPj, ShareSdkView.this.kPg);
                    }
                } else if (ShareSdkView.this.kPf != ShareSdkView.this.kPh) {
                    ShareSdkView.this.kPf = ShareSdkView.this.kPh;
                    ShareSdkView.this.kPg = ShareSdkView.this.kPh;
                    ShareSdkView.this.kPa.setPadding(ShareSdkView.this.kPj, ShareSdkView.this.kPf, ShareSdkView.this.kPj, ShareSdkView.this.kPg);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.kPk = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cyz) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.kPd && bc.checkUpIsLogin(getContext())) {
            String obj = this.kPa.getText().toString();
            if (this.kPk != null) {
                this.kPk.dT(obj);
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
        this.iWT.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.kOU));
        this.ddy.startLoad(cVar.kOT, 10, false);
        this.ddz.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.bpp.setVisibility(8);
        } else {
            this.bpp.setText(cVar.content);
        }
        this.fXi.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.fXi.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.fXi.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fXi.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.kPk = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.black_alpha30);
            am.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            am.setViewTextColor(this.iWT, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.kOZ, R.color.cp_bg_line_e);
            this.ddy.setBorderColor(am.getColor(R.color.cp_cont_g));
            this.ddy.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.ddz, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.bpp, (int) R.color.cp_cont_b);
            this.fXi.setIsNight(this.mSkinType == 1);
            this.kPa.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.kPa.setTextColor(am.getColor(R.color.cp_cont_b));
            am.setBackgroundResource(this.kPa, R.drawable.share_sdk_input_shape_bg);
            am.setBackgroundColor(this.kPb, R.color.cp_bg_line_c);
            am.setViewTextColor(this.cyz, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.kPc, R.color.cp_bg_line_c);
            am.setViewTextColor(this.kPd, (int) R.color.cp_link_tip_a);
        }
    }
}
