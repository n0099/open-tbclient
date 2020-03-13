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
    private TextView bpq;
    private TextView cyA;
    private HeadImageView ddL;
    private TextView ddM;
    private TbImageView fXv;
    private TextView iXf;
    private View kPl;
    private EditText kPm;
    private View kPn;
    private View kPo;
    private TextView kPp;
    private int kPq;
    private int kPr;
    private int kPs;
    private int kPt;
    private int kPu;
    private int kPv;
    private a kPw;
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
        this.iXf = (TextView) findViewById(R.id.share_sdk_forum);
        this.kPl = findViewById(R.id.share_sdk_content_container);
        this.ddL = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.ddM = (TextView) findViewById(R.id.share_sdk_appname);
        this.bpq = (TextView) findViewById(R.id.share_sdk_content);
        this.fXv = (TbImageView) findViewById(R.id.share_sdk_img);
        this.kPm = (EditText) findViewById(R.id.share_sdk_edit);
        this.kPn = findViewById(R.id.share_sdk_content_line);
        this.cyA = (TextView) findViewById(R.id.share_sdk_cancel);
        this.kPo = findViewById(R.id.share_sdk_action_line);
        this.kPp = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.cyA.setOnClickListener(this);
        this.kPp.setOnClickListener(this);
        this.ddL.setIsRound(true);
        this.ddL.setIsPreDrawBorder(true);
        this.ddL.setDrawBorder(true);
        this.ddL.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.ddL.setDefaultResource(R.color.cp_bg_line_e);
        this.ddL.setRadius(l.getDimens(context, R.dimen.ds70));
        this.fXv.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.kPq = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.kPt = l.getDimens(getContext(), R.dimen.tbds27);
        this.kPu = l.getDimens(getContext(), R.dimen.tbds11);
        this.kPv = l.getDimens(getContext(), R.dimen.tbds36);
        this.kPr = this.kPt;
        this.kPs = this.kPt;
        this.kPm.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.kPq * 2) {
                    if (ShareSdkView.this.kPr != 0) {
                        ShareSdkView.this.kPr = 0;
                        ShareSdkView.this.kPs = ShareSdkView.this.kPu;
                        ShareSdkView.this.kPm.setPadding(ShareSdkView.this.kPv, ShareSdkView.this.kPr, ShareSdkView.this.kPv, ShareSdkView.this.kPs);
                    }
                } else if (editable.length() > ShareSdkView.this.kPq) {
                    if (ShareSdkView.this.kPr != ShareSdkView.this.kPu) {
                        ShareSdkView.this.kPr = ShareSdkView.this.kPu;
                        ShareSdkView.this.kPs = ShareSdkView.this.kPu;
                        ShareSdkView.this.kPm.setPadding(ShareSdkView.this.kPv, ShareSdkView.this.kPr, ShareSdkView.this.kPv, ShareSdkView.this.kPs);
                    }
                } else if (ShareSdkView.this.kPr != ShareSdkView.this.kPt) {
                    ShareSdkView.this.kPr = ShareSdkView.this.kPt;
                    ShareSdkView.this.kPs = ShareSdkView.this.kPt;
                    ShareSdkView.this.kPm.setPadding(ShareSdkView.this.kPv, ShareSdkView.this.kPr, ShareSdkView.this.kPv, ShareSdkView.this.kPs);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.kPw = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cyA) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.kPp && bc.checkUpIsLogin(getContext())) {
            String obj = this.kPm.getText().toString();
            if (this.kPw != null) {
                this.kPw.dT(obj);
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
        this.iXf.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.kPg));
        this.ddL.startLoad(cVar.kPf, 10, false);
        this.ddM.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.bpq.setVisibility(8);
        } else {
            this.bpq.setText(cVar.content);
        }
        this.fXv.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.fXv.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.fXv.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fXv.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.kPw = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.black_alpha30);
            am.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            am.setViewTextColor(this.iXf, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.kPl, R.color.cp_bg_line_e);
            this.ddL.setBorderColor(am.getColor(R.color.cp_cont_g));
            this.ddL.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.ddM, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.bpq, (int) R.color.cp_cont_b);
            this.fXv.setIsNight(this.mSkinType == 1);
            this.kPm.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.kPm.setTextColor(am.getColor(R.color.cp_cont_b));
            am.setBackgroundResource(this.kPm, R.drawable.share_sdk_input_shape_bg);
            am.setBackgroundColor(this.kPn, R.color.cp_bg_line_c);
            am.setViewTextColor(this.cyA, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.kPo, R.color.cp_bg_line_c);
            am.setViewTextColor(this.kPp, (int) R.color.cp_link_tip_a);
        }
    }
}
