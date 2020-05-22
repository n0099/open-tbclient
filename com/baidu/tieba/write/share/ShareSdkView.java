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
    private TextView bWU;
    private HeadImageView dRN;
    private TextView dRO;
    private TextView diR;
    private EditText eYz;
    private TbImageView gTv;
    private TextView kaD;
    private View lUc;
    private View lUd;
    private View lUe;
    private TextView lUf;
    private int lUg;
    private int lUh;
    private int lUi;
    private int lUj;
    private int lUk;
    private int lUl;
    private a lUm;
    private View mRootView;
    private int mSkinType;

    /* loaded from: classes2.dex */
    public interface a {
        void fx(String str);
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
        this.kaD = (TextView) findViewById(R.id.share_sdk_forum);
        this.lUc = findViewById(R.id.share_sdk_content_container);
        this.dRN = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.dRO = (TextView) findViewById(R.id.share_sdk_appname);
        this.bWU = (TextView) findViewById(R.id.share_sdk_content);
        this.gTv = (TbImageView) findViewById(R.id.share_sdk_img);
        this.eYz = (EditText) findViewById(R.id.share_sdk_edit);
        this.lUd = findViewById(R.id.share_sdk_content_line);
        this.diR = (TextView) findViewById(R.id.share_sdk_cancel);
        this.lUe = findViewById(R.id.share_sdk_action_line);
        this.lUf = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.diR.setOnClickListener(this);
        this.lUf.setOnClickListener(this);
        this.dRN.setIsRound(true);
        this.dRN.setIsPreDrawBorder(true);
        this.dRN.setDrawBorder(true);
        this.dRN.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.dRN.setDefaultResource(R.color.cp_bg_line_e);
        this.dRN.setRadius(l.getDimens(context, R.dimen.ds70));
        this.gTv.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.lUg = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.lUj = l.getDimens(getContext(), R.dimen.tbds27);
        this.lUk = l.getDimens(getContext(), R.dimen.tbds11);
        this.lUl = l.getDimens(getContext(), R.dimen.tbds36);
        this.lUh = this.lUj;
        this.lUi = this.lUj;
        this.eYz.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.lUg * 2) {
                    if (ShareSdkView.this.lUh != 0) {
                        ShareSdkView.this.lUh = 0;
                        ShareSdkView.this.lUi = ShareSdkView.this.lUk;
                        ShareSdkView.this.eYz.setPadding(ShareSdkView.this.lUl, ShareSdkView.this.lUh, ShareSdkView.this.lUl, ShareSdkView.this.lUi);
                    }
                } else if (editable.length() > ShareSdkView.this.lUg) {
                    if (ShareSdkView.this.lUh != ShareSdkView.this.lUk) {
                        ShareSdkView.this.lUh = ShareSdkView.this.lUk;
                        ShareSdkView.this.lUi = ShareSdkView.this.lUk;
                        ShareSdkView.this.eYz.setPadding(ShareSdkView.this.lUl, ShareSdkView.this.lUh, ShareSdkView.this.lUl, ShareSdkView.this.lUi);
                    }
                } else if (ShareSdkView.this.lUh != ShareSdkView.this.lUj) {
                    ShareSdkView.this.lUh = ShareSdkView.this.lUj;
                    ShareSdkView.this.lUi = ShareSdkView.this.lUj;
                    ShareSdkView.this.eYz.setPadding(ShareSdkView.this.lUl, ShareSdkView.this.lUh, ShareSdkView.this.lUl, ShareSdkView.this.lUi);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.lUm = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.diR) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.lUf && bc.checkUpIsLogin(getContext())) {
            String obj = this.eYz.getText().toString();
            if (this.lUm != null) {
                this.lUm.fx(obj);
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
        this.kaD.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.lTX));
        this.dRN.startLoad(cVar.lTW, 10, false);
        this.dRO.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.bWU.setVisibility(8);
        } else {
            this.bWU.setText(cVar.content);
        }
        this.gTv.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.gTv.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.gTv.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gTv.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.lUm = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.black_alpha30);
            am.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            am.setViewTextColor(this.kaD, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.lUc, R.color.cp_bg_line_e);
            this.dRN.setBorderColor(am.getColor(R.color.cp_cont_g));
            this.dRN.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.dRO, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.bWU, (int) R.color.cp_cont_b);
            this.gTv.setIsNight(this.mSkinType == 1);
            this.eYz.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.eYz.setTextColor(am.getColor(R.color.cp_cont_b));
            am.setBackgroundResource(this.eYz, R.drawable.share_sdk_input_shape_bg);
            am.setBackgroundColor(this.lUd, R.color.cp_bg_line_c);
            am.setViewTextColor(this.diR, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.lUe, R.color.cp_bg_line_c);
            am.setViewTextColor(this.lUf, (int) R.color.cp_link_tip_a);
        }
    }
}
