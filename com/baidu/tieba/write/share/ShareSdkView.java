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
/* loaded from: classes3.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    private TextView aLN;
    private TextView bIV;
    private HeadImageView clV;
    private TextView clW;
    private TbImageView fds;
    private TextView jPY;
    private View jPZ;
    private EditText jQa;
    private View jQb;
    private View jQc;
    private TextView jQd;
    private int jQe;
    private int jQf;
    private int jQg;
    private int jQh;
    private int jQi;
    private int jQj;
    private a jQk;
    private View mRootView;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void tu(String str);
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
        this.jPY = (TextView) findViewById(R.id.share_sdk_forum);
        this.jPZ = findViewById(R.id.share_sdk_content_container);
        this.clV = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.clW = (TextView) findViewById(R.id.share_sdk_appname);
        this.aLN = (TextView) findViewById(R.id.share_sdk_content);
        this.fds = (TbImageView) findViewById(R.id.share_sdk_img);
        this.jQa = (EditText) findViewById(R.id.share_sdk_edit);
        this.jQb = findViewById(R.id.share_sdk_content_line);
        this.bIV = (TextView) findViewById(R.id.share_sdk_cancel);
        this.jQc = findViewById(R.id.share_sdk_action_line);
        this.jQd = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.bIV.setOnClickListener(this);
        this.jQd.setOnClickListener(this);
        this.clV.setIsRound(true);
        this.clV.setIsPreDrawBorder(true);
        this.clV.setDrawBorder(true);
        this.clV.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.clV.setDefaultResource(R.color.cp_bg_line_e);
        this.clV.setRadius(l.getDimens(context, R.dimen.ds70));
        this.fds.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.jQe = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.jQh = l.getDimens(getContext(), R.dimen.tbds27);
        this.jQi = l.getDimens(getContext(), R.dimen.tbds11);
        this.jQj = l.getDimens(getContext(), R.dimen.tbds36);
        this.jQf = this.jQh;
        this.jQg = this.jQh;
        this.jQa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.jQe * 2) {
                    if (ShareSdkView.this.jQf != 0) {
                        ShareSdkView.this.jQf = 0;
                        ShareSdkView.this.jQg = ShareSdkView.this.jQi;
                        ShareSdkView.this.jQa.setPadding(ShareSdkView.this.jQj, ShareSdkView.this.jQf, ShareSdkView.this.jQj, ShareSdkView.this.jQg);
                    }
                } else if (editable.length() > ShareSdkView.this.jQe) {
                    if (ShareSdkView.this.jQf != ShareSdkView.this.jQi) {
                        ShareSdkView.this.jQf = ShareSdkView.this.jQi;
                        ShareSdkView.this.jQg = ShareSdkView.this.jQi;
                        ShareSdkView.this.jQa.setPadding(ShareSdkView.this.jQj, ShareSdkView.this.jQf, ShareSdkView.this.jQj, ShareSdkView.this.jQg);
                    }
                } else if (ShareSdkView.this.jQf != ShareSdkView.this.jQh) {
                    ShareSdkView.this.jQf = ShareSdkView.this.jQh;
                    ShareSdkView.this.jQg = ShareSdkView.this.jQh;
                    ShareSdkView.this.jQa.setPadding(ShareSdkView.this.jQj, ShareSdkView.this.jQf, ShareSdkView.this.jQj, ShareSdkView.this.jQg);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.jQk = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bIV) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.jQd && bc.checkUpIsLogin(getContext())) {
            String obj = this.jQa.getText().toString();
            if (this.jQk != null) {
                this.jQk.tu(obj);
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
        this.jPY.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.jPT));
        this.clV.startLoad(cVar.jPS, 10, false);
        this.clW.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.aLN.setVisibility(8);
        } else {
            this.aLN.setText(cVar.content);
        }
        this.fds.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.fds.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.fds.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fds.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.jQk = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.black_alpha30);
            am.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            am.setViewTextColor(this.jPY, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.jPZ, R.color.cp_bg_line_e);
            this.clV.setBorderColor(am.getColor(R.color.cp_cont_g));
            this.clV.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.clW, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.aLN, (int) R.color.cp_cont_b);
            this.fds.setIsNight(this.mSkinType == 1);
            this.jQa.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.jQa.setTextColor(am.getColor(R.color.cp_cont_b));
            am.setBackgroundResource(this.jQa, R.drawable.share_sdk_input_shape_bg);
            am.setBackgroundColor(this.jQb, R.color.cp_bg_line_c);
            am.setViewTextColor(this.bIV, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.jQc, R.color.cp_bg_line_c);
            am.setViewTextColor(this.jQd, (int) R.color.cp_link_tip_a);
        }
    }
}
