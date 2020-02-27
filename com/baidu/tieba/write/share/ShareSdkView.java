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
    private TextView bpo;
    private TextView cyy;
    private HeadImageView ddx;
    private TextView ddy;
    private TbImageView fXg;
    private TextView iWR;
    private View kOX;
    private EditText kOY;
    private View kOZ;
    private View kPa;
    private TextView kPb;
    private int kPc;
    private int kPd;
    private int kPe;
    private int kPf;
    private int kPg;
    private int kPh;
    private a kPi;
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
        this.iWR = (TextView) findViewById(R.id.share_sdk_forum);
        this.kOX = findViewById(R.id.share_sdk_content_container);
        this.ddx = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.ddy = (TextView) findViewById(R.id.share_sdk_appname);
        this.bpo = (TextView) findViewById(R.id.share_sdk_content);
        this.fXg = (TbImageView) findViewById(R.id.share_sdk_img);
        this.kOY = (EditText) findViewById(R.id.share_sdk_edit);
        this.kOZ = findViewById(R.id.share_sdk_content_line);
        this.cyy = (TextView) findViewById(R.id.share_sdk_cancel);
        this.kPa = findViewById(R.id.share_sdk_action_line);
        this.kPb = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.cyy.setOnClickListener(this);
        this.kPb.setOnClickListener(this);
        this.ddx.setIsRound(true);
        this.ddx.setIsPreDrawBorder(true);
        this.ddx.setDrawBorder(true);
        this.ddx.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.ddx.setDefaultResource(R.color.cp_bg_line_e);
        this.ddx.setRadius(l.getDimens(context, R.dimen.ds70));
        this.fXg.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.kPc = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.kPf = l.getDimens(getContext(), R.dimen.tbds27);
        this.kPg = l.getDimens(getContext(), R.dimen.tbds11);
        this.kPh = l.getDimens(getContext(), R.dimen.tbds36);
        this.kPd = this.kPf;
        this.kPe = this.kPf;
        this.kOY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.kPc * 2) {
                    if (ShareSdkView.this.kPd != 0) {
                        ShareSdkView.this.kPd = 0;
                        ShareSdkView.this.kPe = ShareSdkView.this.kPg;
                        ShareSdkView.this.kOY.setPadding(ShareSdkView.this.kPh, ShareSdkView.this.kPd, ShareSdkView.this.kPh, ShareSdkView.this.kPe);
                    }
                } else if (editable.length() > ShareSdkView.this.kPc) {
                    if (ShareSdkView.this.kPd != ShareSdkView.this.kPg) {
                        ShareSdkView.this.kPd = ShareSdkView.this.kPg;
                        ShareSdkView.this.kPe = ShareSdkView.this.kPg;
                        ShareSdkView.this.kOY.setPadding(ShareSdkView.this.kPh, ShareSdkView.this.kPd, ShareSdkView.this.kPh, ShareSdkView.this.kPe);
                    }
                } else if (ShareSdkView.this.kPd != ShareSdkView.this.kPf) {
                    ShareSdkView.this.kPd = ShareSdkView.this.kPf;
                    ShareSdkView.this.kPe = ShareSdkView.this.kPf;
                    ShareSdkView.this.kOY.setPadding(ShareSdkView.this.kPh, ShareSdkView.this.kPd, ShareSdkView.this.kPh, ShareSdkView.this.kPe);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.kPi = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cyy) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.kPb && bc.checkUpIsLogin(getContext())) {
            String obj = this.kOY.getText().toString();
            if (this.kPi != null) {
                this.kPi.dT(obj);
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
        this.iWR.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.kOS));
        this.ddx.startLoad(cVar.kOR, 10, false);
        this.ddy.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.bpo.setVisibility(8);
        } else {
            this.bpo.setText(cVar.content);
        }
        this.fXg.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.fXg.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.fXg.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fXg.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.kPi = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.black_alpha30);
            am.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            am.setViewTextColor(this.iWR, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.kOX, R.color.cp_bg_line_e);
            this.ddx.setBorderColor(am.getColor(R.color.cp_cont_g));
            this.ddx.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.ddy, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.bpo, (int) R.color.cp_cont_b);
            this.fXg.setIsNight(this.mSkinType == 1);
            this.kOY.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.kOY.setTextColor(am.getColor(R.color.cp_cont_b));
            am.setBackgroundResource(this.kOY, R.drawable.share_sdk_input_shape_bg);
            am.setBackgroundColor(this.kOZ, R.color.cp_bg_line_c);
            am.setViewTextColor(this.cyy, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.kPa, R.color.cp_bg_line_c);
            am.setViewTextColor(this.kPb, (int) R.color.cp_link_tip_a);
        }
    }
}
