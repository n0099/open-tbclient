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
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    private HeadImageView bWP;
    private TextView bWQ;
    private TextView bqD;
    private TbImageView eZS;
    private TextView jQG;
    private View jQH;
    private EditText jQI;
    private View jQJ;
    private View jQK;
    private TextView jQL;
    private int jQM;
    private int jQN;
    private int jQO;
    private int jQP;
    private int jQQ;
    private int jQR;
    private a jQS;
    private TextView mContentView;
    private View mRootView;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void GN(String str);
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
        this.jQG = (TextView) findViewById(R.id.share_sdk_forum);
        this.jQH = findViewById(R.id.share_sdk_content_container);
        this.bWP = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.bWQ = (TextView) findViewById(R.id.share_sdk_appname);
        this.mContentView = (TextView) findViewById(R.id.share_sdk_content);
        this.eZS = (TbImageView) findViewById(R.id.share_sdk_img);
        this.jQI = (EditText) findViewById(R.id.share_sdk_edit);
        this.jQJ = findViewById(R.id.share_sdk_content_line);
        this.bqD = (TextView) findViewById(R.id.share_sdk_cancel);
        this.jQK = findViewById(R.id.share_sdk_action_line);
        this.jQL = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.bqD.setOnClickListener(this);
        this.jQL.setOnClickListener(this);
        this.bWP.setIsRound(true);
        this.bWP.setIsPreDrawBorder(true);
        this.bWP.setDrawBorder(true);
        this.bWP.setBorderWidth(l.g(context, R.dimen.tbds1));
        this.bWP.setDefaultResource(R.color.cp_bg_line_e);
        this.bWP.setRadius(l.g(context, R.dimen.ds70));
        this.eZS.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.jQM = (l.af(getContext()) - l.g(getContext(), R.dimen.tbds516)) / l.g(getContext(), R.dimen.tbds45);
        this.jQP = l.g(getContext(), R.dimen.tbds27);
        this.jQQ = l.g(getContext(), R.dimen.tbds11);
        this.jQR = l.g(getContext(), R.dimen.tbds36);
        this.jQN = this.jQP;
        this.jQO = this.jQP;
        this.jQI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.jQM * 2) {
                    if (ShareSdkView.this.jQN != 0) {
                        ShareSdkView.this.jQN = 0;
                        ShareSdkView.this.jQO = ShareSdkView.this.jQQ;
                        ShareSdkView.this.jQI.setPadding(ShareSdkView.this.jQR, ShareSdkView.this.jQN, ShareSdkView.this.jQR, ShareSdkView.this.jQO);
                    }
                } else if (editable.length() > ShareSdkView.this.jQM) {
                    if (ShareSdkView.this.jQN != ShareSdkView.this.jQQ) {
                        ShareSdkView.this.jQN = ShareSdkView.this.jQQ;
                        ShareSdkView.this.jQO = ShareSdkView.this.jQQ;
                        ShareSdkView.this.jQI.setPadding(ShareSdkView.this.jQR, ShareSdkView.this.jQN, ShareSdkView.this.jQR, ShareSdkView.this.jQO);
                    }
                } else if (ShareSdkView.this.jQN != ShareSdkView.this.jQP) {
                    ShareSdkView.this.jQN = ShareSdkView.this.jQP;
                    ShareSdkView.this.jQO = ShareSdkView.this.jQP;
                    ShareSdkView.this.jQI.setPadding(ShareSdkView.this.jQR, ShareSdkView.this.jQN, ShareSdkView.this.jQR, ShareSdkView.this.jQO);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.jQS = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bqD) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.jQL && bd.cF(getContext())) {
            String obj = this.jQI.getText().toString();
            if (this.jQS != null) {
                this.jQS.GN(obj);
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
        this.jQG.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.jQB));
        this.bWP.startLoad(cVar.jQA, 10, false);
        this.bWQ.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.mContentView.setVisibility(8);
        } else {
            this.mContentView.setText(cVar.content);
        }
        this.eZS.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.eZS.getLayoutParams();
                layoutParams.height = ((l.af(ShareSdkView.this.getContext()) - l.g(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.eZS.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.eZS.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.jQS = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.l(this, R.color.black_alpha30);
            am.k(this.mRootView, R.drawable.share_sdk_bg);
            am.j(this.jQG, R.color.cp_cont_b);
            am.l(this.jQH, R.color.cp_bg_line_e);
            this.bWP.setBorderColor(am.getColor(R.color.cp_cont_g));
            this.bWP.setIsNight(this.mSkinType == 1);
            am.j(this.bWQ, R.color.cp_cont_f);
            am.j(this.mContentView, R.color.cp_cont_b);
            this.eZS.setIsNight(this.mSkinType == 1);
            this.jQI.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.jQI.setTextColor(am.getColor(R.color.cp_cont_b));
            am.k(this.jQI, R.drawable.share_sdk_input_shape_bg);
            am.l(this.jQJ, R.color.cp_bg_line_c);
            am.j(this.bqD, R.color.cp_cont_b);
            am.l(this.jQK, R.color.cp_bg_line_c);
            am.j(this.jQL, R.color.cp_link_tip_a);
        }
    }
}
