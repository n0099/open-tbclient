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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    private TextView cVd;
    private TextView etj;
    private HeadImageView fgh;
    private TextView fgi;
    private EditText gwY;
    private TbImageView iOm;
    private View lbB;
    private View mRootView;
    private int mSkinType;
    private TextView mkS;
    private View oiL;
    private View oiM;
    private TextView oiN;
    private int oiO;
    private int oiP;
    private int oiQ;
    private int oiR;
    private int oiS;
    private int oiT;
    private a oiU;

    /* loaded from: classes7.dex */
    public interface a {
        void hs(String str);
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
        this.mkS = (TextView) findViewById(R.id.share_sdk_forum);
        this.oiL = findViewById(R.id.share_sdk_content_container);
        this.fgh = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.fgi = (TextView) findViewById(R.id.share_sdk_appname);
        this.cVd = (TextView) findViewById(R.id.share_sdk_content);
        this.iOm = (TbImageView) findViewById(R.id.share_sdk_img);
        this.gwY = (EditText) findViewById(R.id.share_sdk_edit);
        this.lbB = findViewById(R.id.share_sdk_content_line);
        this.etj = (TextView) findViewById(R.id.share_sdk_cancel);
        this.oiM = findViewById(R.id.share_sdk_action_line);
        this.oiN = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.etj.setOnClickListener(this);
        this.oiN.setOnClickListener(this);
        this.fgh.setIsRound(true);
        this.fgh.setIsPreDrawBorder(true);
        this.fgh.setDrawBorder(true);
        this.fgh.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.fgh.setDefaultResource(R.color.CAM_X0205);
        this.fgh.setRadius(l.getDimens(context, R.dimen.ds70));
        this.iOm.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.oiO = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.oiR = l.getDimens(getContext(), R.dimen.tbds27);
        this.oiS = l.getDimens(getContext(), R.dimen.tbds11);
        this.oiT = l.getDimens(getContext(), R.dimen.tbds36);
        this.oiP = this.oiR;
        this.oiQ = this.oiR;
        this.gwY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.oiO * 2) {
                    if (ShareSdkView.this.oiP != 0) {
                        ShareSdkView.this.oiP = 0;
                        ShareSdkView.this.oiQ = ShareSdkView.this.oiS;
                        ShareSdkView.this.gwY.setPadding(ShareSdkView.this.oiT, ShareSdkView.this.oiP, ShareSdkView.this.oiT, ShareSdkView.this.oiQ);
                    }
                } else if (editable.length() > ShareSdkView.this.oiO) {
                    if (ShareSdkView.this.oiP != ShareSdkView.this.oiS) {
                        ShareSdkView.this.oiP = ShareSdkView.this.oiS;
                        ShareSdkView.this.oiQ = ShareSdkView.this.oiS;
                        ShareSdkView.this.gwY.setPadding(ShareSdkView.this.oiT, ShareSdkView.this.oiP, ShareSdkView.this.oiT, ShareSdkView.this.oiQ);
                    }
                } else if (ShareSdkView.this.oiP != ShareSdkView.this.oiR) {
                    ShareSdkView.this.oiP = ShareSdkView.this.oiR;
                    ShareSdkView.this.oiQ = ShareSdkView.this.oiR;
                    ShareSdkView.this.gwY.setPadding(ShareSdkView.this.oiT, ShareSdkView.this.oiP, ShareSdkView.this.oiT, ShareSdkView.this.oiQ);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.oiU = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.etj) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.oiN && bh.checkUpIsLogin(getContext())) {
            String obj = this.gwY.getText().toString();
            if (this.oiU != null) {
                this.oiU.hs(obj);
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
        this.mkS.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.oiG));
        this.fgh.startLoad(cVar.eMr, 10, false);
        this.fgi.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.cVd.setVisibility(8);
        } else {
            this.cVd.setText(cVar.content);
        }
        this.iOm.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.iOm.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.iOm.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        this.iOm.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.oiU = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.black_alpha30);
            ap.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            ap.setViewTextColor(this.mkS, R.color.CAM_X0105);
            ap.setBackgroundColor(this.oiL, R.color.CAM_X0205);
            this.fgh.setBorderColor(ap.getColor(R.color.CAM_X0111));
            this.fgh.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.fgi, R.color.CAM_X0106);
            ap.setViewTextColor(this.cVd, R.color.CAM_X0105);
            this.iOm.setIsNight(this.mSkinType == 1);
            this.gwY.setHintTextColor(ap.getColor(R.color.CAM_X0110));
            this.gwY.setTextColor(ap.getColor(R.color.CAM_X0105));
            ap.setBackgroundResource(this.gwY, R.drawable.share_sdk_input_shape_bg);
            ap.setBackgroundColor(this.lbB, R.color.CAM_X0204);
            ap.setViewTextColor(this.etj, R.color.CAM_X0105);
            ap.setBackgroundColor(this.oiM, R.color.CAM_X0204);
            ap.setViewTextColor(this.oiN, R.color.CAM_X0302);
        }
    }
}
