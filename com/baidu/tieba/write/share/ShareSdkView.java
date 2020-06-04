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
    private EditText eYK;
    private TbImageView gTG;
    private TextView kbJ;
    private View lVn;
    private View lVo;
    private View lVp;
    private TextView lVq;
    private int lVr;
    private int lVs;
    private int lVt;
    private int lVu;
    private int lVv;
    private int lVw;
    private a lVx;
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
        this.kbJ = (TextView) findViewById(R.id.share_sdk_forum);
        this.lVn = findViewById(R.id.share_sdk_content_container);
        this.dRN = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.dRO = (TextView) findViewById(R.id.share_sdk_appname);
        this.bWU = (TextView) findViewById(R.id.share_sdk_content);
        this.gTG = (TbImageView) findViewById(R.id.share_sdk_img);
        this.eYK = (EditText) findViewById(R.id.share_sdk_edit);
        this.lVo = findViewById(R.id.share_sdk_content_line);
        this.diR = (TextView) findViewById(R.id.share_sdk_cancel);
        this.lVp = findViewById(R.id.share_sdk_action_line);
        this.lVq = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.diR.setOnClickListener(this);
        this.lVq.setOnClickListener(this);
        this.dRN.setIsRound(true);
        this.dRN.setIsPreDrawBorder(true);
        this.dRN.setDrawBorder(true);
        this.dRN.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.dRN.setDefaultResource(R.color.cp_bg_line_e);
        this.dRN.setRadius(l.getDimens(context, R.dimen.ds70));
        this.gTG.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.lVr = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.lVu = l.getDimens(getContext(), R.dimen.tbds27);
        this.lVv = l.getDimens(getContext(), R.dimen.tbds11);
        this.lVw = l.getDimens(getContext(), R.dimen.tbds36);
        this.lVs = this.lVu;
        this.lVt = this.lVu;
        this.eYK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.lVr * 2) {
                    if (ShareSdkView.this.lVs != 0) {
                        ShareSdkView.this.lVs = 0;
                        ShareSdkView.this.lVt = ShareSdkView.this.lVv;
                        ShareSdkView.this.eYK.setPadding(ShareSdkView.this.lVw, ShareSdkView.this.lVs, ShareSdkView.this.lVw, ShareSdkView.this.lVt);
                    }
                } else if (editable.length() > ShareSdkView.this.lVr) {
                    if (ShareSdkView.this.lVs != ShareSdkView.this.lVv) {
                        ShareSdkView.this.lVs = ShareSdkView.this.lVv;
                        ShareSdkView.this.lVt = ShareSdkView.this.lVv;
                        ShareSdkView.this.eYK.setPadding(ShareSdkView.this.lVw, ShareSdkView.this.lVs, ShareSdkView.this.lVw, ShareSdkView.this.lVt);
                    }
                } else if (ShareSdkView.this.lVs != ShareSdkView.this.lVu) {
                    ShareSdkView.this.lVs = ShareSdkView.this.lVu;
                    ShareSdkView.this.lVt = ShareSdkView.this.lVu;
                    ShareSdkView.this.eYK.setPadding(ShareSdkView.this.lVw, ShareSdkView.this.lVs, ShareSdkView.this.lVw, ShareSdkView.this.lVt);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.lVx = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.diR) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.lVq && bc.checkUpIsLogin(getContext())) {
            String obj = this.eYK.getText().toString();
            if (this.lVx != null) {
                this.lVx.fx(obj);
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
        this.kbJ.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.lVi));
        this.dRN.startLoad(cVar.lVh, 10, false);
        this.dRO.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.bWU.setVisibility(8);
        } else {
            this.bWU.setText(cVar.content);
        }
        this.gTG.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.gTG.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.gTG.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gTG.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.lVx = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.black_alpha30);
            am.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            am.setViewTextColor(this.kbJ, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.lVn, R.color.cp_bg_line_e);
            this.dRN.setBorderColor(am.getColor(R.color.cp_cont_g));
            this.dRN.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.dRO, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.bWU, (int) R.color.cp_cont_b);
            this.gTG.setIsNight(this.mSkinType == 1);
            this.eYK.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.eYK.setTextColor(am.getColor(R.color.cp_cont_b));
            am.setBackgroundResource(this.eYK, R.drawable.share_sdk_input_shape_bg);
            am.setBackgroundColor(this.lVo, R.color.cp_bg_line_c);
            am.setViewTextColor(this.diR, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.lVp, R.color.cp_bg_line_c);
            am.setViewTextColor(this.lVq, (int) R.color.cp_link_tip_a);
        }
    }
}
