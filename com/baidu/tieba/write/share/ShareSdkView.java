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
/* loaded from: classes11.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    private TextView ble;
    private HeadImageView cZs;
    private TextView cZt;
    private TextView cuA;
    private TbImageView fVf;
    private TextView iVC;
    private int kOA;
    private int kOB;
    private a kOC;
    private View kOr;
    private EditText kOs;
    private View kOt;
    private View kOu;
    private TextView kOv;
    private int kOw;
    private int kOx;
    private int kOy;
    private int kOz;
    private View mRootView;
    private int mSkinType;

    /* loaded from: classes11.dex */
    public interface a {
        void yo(String str);
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
        this.iVC = (TextView) findViewById(R.id.share_sdk_forum);
        this.kOr = findViewById(R.id.share_sdk_content_container);
        this.cZs = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.cZt = (TextView) findViewById(R.id.share_sdk_appname);
        this.ble = (TextView) findViewById(R.id.share_sdk_content);
        this.fVf = (TbImageView) findViewById(R.id.share_sdk_img);
        this.kOs = (EditText) findViewById(R.id.share_sdk_edit);
        this.kOt = findViewById(R.id.share_sdk_content_line);
        this.cuA = (TextView) findViewById(R.id.share_sdk_cancel);
        this.kOu = findViewById(R.id.share_sdk_action_line);
        this.kOv = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.cuA.setOnClickListener(this);
        this.kOv.setOnClickListener(this);
        this.cZs.setIsRound(true);
        this.cZs.setIsPreDrawBorder(true);
        this.cZs.setDrawBorder(true);
        this.cZs.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.cZs.setDefaultResource(R.color.cp_bg_line_e);
        this.cZs.setRadius(l.getDimens(context, R.dimen.ds70));
        this.fVf.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.kOw = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.kOz = l.getDimens(getContext(), R.dimen.tbds27);
        this.kOA = l.getDimens(getContext(), R.dimen.tbds11);
        this.kOB = l.getDimens(getContext(), R.dimen.tbds36);
        this.kOx = this.kOz;
        this.kOy = this.kOz;
        this.kOs.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.kOw * 2) {
                    if (ShareSdkView.this.kOx != 0) {
                        ShareSdkView.this.kOx = 0;
                        ShareSdkView.this.kOy = ShareSdkView.this.kOA;
                        ShareSdkView.this.kOs.setPadding(ShareSdkView.this.kOB, ShareSdkView.this.kOx, ShareSdkView.this.kOB, ShareSdkView.this.kOy);
                    }
                } else if (editable.length() > ShareSdkView.this.kOw) {
                    if (ShareSdkView.this.kOx != ShareSdkView.this.kOA) {
                        ShareSdkView.this.kOx = ShareSdkView.this.kOA;
                        ShareSdkView.this.kOy = ShareSdkView.this.kOA;
                        ShareSdkView.this.kOs.setPadding(ShareSdkView.this.kOB, ShareSdkView.this.kOx, ShareSdkView.this.kOB, ShareSdkView.this.kOy);
                    }
                } else if (ShareSdkView.this.kOx != ShareSdkView.this.kOz) {
                    ShareSdkView.this.kOx = ShareSdkView.this.kOz;
                    ShareSdkView.this.kOy = ShareSdkView.this.kOz;
                    ShareSdkView.this.kOs.setPadding(ShareSdkView.this.kOB, ShareSdkView.this.kOx, ShareSdkView.this.kOB, ShareSdkView.this.kOy);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.kOC = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cuA) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.kOv && bc.checkUpIsLogin(getContext())) {
            String obj = this.kOs.getText().toString();
            if (this.kOC != null) {
                this.kOC.yo(obj);
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
        this.iVC.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.kOm));
        this.cZs.startLoad(cVar.kOl, 10, false);
        this.cZt.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.ble.setVisibility(8);
        } else {
            this.ble.setText(cVar.content);
        }
        this.fVf.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.fVf.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.fVf.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fVf.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.kOC = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.black_alpha30);
            am.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            am.setViewTextColor(this.iVC, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.kOr, R.color.cp_bg_line_e);
            this.cZs.setBorderColor(am.getColor(R.color.cp_cont_g));
            this.cZs.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.cZt, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.ble, (int) R.color.cp_cont_b);
            this.fVf.setIsNight(this.mSkinType == 1);
            this.kOs.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.kOs.setTextColor(am.getColor(R.color.cp_cont_b));
            am.setBackgroundResource(this.kOs, R.drawable.share_sdk_input_shape_bg);
            am.setBackgroundColor(this.kOt, R.color.cp_bg_line_c);
            am.setViewTextColor(this.cuA, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.kOu, R.color.cp_bg_line_c);
            am.setViewTextColor(this.kOv, (int) R.color.cp_link_tip_a);
        }
    }
}
