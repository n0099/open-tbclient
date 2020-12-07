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
/* loaded from: classes3.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    private TextView cRf;
    private HeadImageView eXA;
    private TextView eXB;
    private TextView elj;
    private EditText gmz;
    private TbImageView iyY;
    private View kQg;
    private TextView lYL;
    private View mRootView;
    private int mSkinType;
    private View nXK;
    private View nXL;
    private TextView nXM;
    private int nXN;
    private int nXO;
    private int nXP;
    private int nXQ;
    private int nXR;
    private int nXS;
    private a nXT;

    /* loaded from: classes3.dex */
    public interface a {
        void im(String str);
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
        this.lYL = (TextView) findViewById(R.id.share_sdk_forum);
        this.nXK = findViewById(R.id.share_sdk_content_container);
        this.eXA = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.eXB = (TextView) findViewById(R.id.share_sdk_appname);
        this.cRf = (TextView) findViewById(R.id.share_sdk_content);
        this.iyY = (TbImageView) findViewById(R.id.share_sdk_img);
        this.gmz = (EditText) findViewById(R.id.share_sdk_edit);
        this.kQg = findViewById(R.id.share_sdk_content_line);
        this.elj = (TextView) findViewById(R.id.share_sdk_cancel);
        this.nXL = findViewById(R.id.share_sdk_action_line);
        this.nXM = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.elj.setOnClickListener(this);
        this.nXM.setOnClickListener(this);
        this.eXA.setIsRound(true);
        this.eXA.setIsPreDrawBorder(true);
        this.eXA.setDrawBorder(true);
        this.eXA.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.eXA.setDefaultResource(R.color.CAM_X0205);
        this.eXA.setRadius(l.getDimens(context, R.dimen.ds70));
        this.iyY.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.nXN = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.nXQ = l.getDimens(getContext(), R.dimen.tbds27);
        this.nXR = l.getDimens(getContext(), R.dimen.tbds11);
        this.nXS = l.getDimens(getContext(), R.dimen.tbds36);
        this.nXO = this.nXQ;
        this.nXP = this.nXQ;
        this.gmz.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.nXN * 2) {
                    if (ShareSdkView.this.nXO != 0) {
                        ShareSdkView.this.nXO = 0;
                        ShareSdkView.this.nXP = ShareSdkView.this.nXR;
                        ShareSdkView.this.gmz.setPadding(ShareSdkView.this.nXS, ShareSdkView.this.nXO, ShareSdkView.this.nXS, ShareSdkView.this.nXP);
                    }
                } else if (editable.length() > ShareSdkView.this.nXN) {
                    if (ShareSdkView.this.nXO != ShareSdkView.this.nXR) {
                        ShareSdkView.this.nXO = ShareSdkView.this.nXR;
                        ShareSdkView.this.nXP = ShareSdkView.this.nXR;
                        ShareSdkView.this.gmz.setPadding(ShareSdkView.this.nXS, ShareSdkView.this.nXO, ShareSdkView.this.nXS, ShareSdkView.this.nXP);
                    }
                } else if (ShareSdkView.this.nXO != ShareSdkView.this.nXQ) {
                    ShareSdkView.this.nXO = ShareSdkView.this.nXQ;
                    ShareSdkView.this.nXP = ShareSdkView.this.nXQ;
                    ShareSdkView.this.gmz.setPadding(ShareSdkView.this.nXS, ShareSdkView.this.nXO, ShareSdkView.this.nXS, ShareSdkView.this.nXP);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.nXT = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.elj) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.nXM && bh.checkUpIsLogin(getContext())) {
            String obj = this.gmz.getText().toString();
            if (this.nXT != null) {
                this.nXT.im(obj);
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
        this.lYL.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.nXF));
        this.eXA.startLoad(cVar.nXE, 10, false);
        this.eXB.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.cRf.setVisibility(8);
        } else {
            this.cRf.setText(cVar.content);
        }
        this.iyY.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.iyY.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.iyY.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.iyY.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.nXT = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.black_alpha30);
            ap.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            ap.setViewTextColor(this.lYL, R.color.CAM_X0105);
            ap.setBackgroundColor(this.nXK, R.color.CAM_X0205);
            this.eXA.setBorderColor(ap.getColor(R.color.CAM_X0111));
            this.eXA.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.eXB, R.color.CAM_X0106);
            ap.setViewTextColor(this.cRf, R.color.CAM_X0105);
            this.iyY.setIsNight(this.mSkinType == 1);
            this.gmz.setHintTextColor(ap.getColor(R.color.CAM_X0110));
            this.gmz.setTextColor(ap.getColor(R.color.CAM_X0105));
            ap.setBackgroundResource(this.gmz, R.drawable.share_sdk_input_shape_bg);
            ap.setBackgroundColor(this.kQg, R.color.CAM_X0204);
            ap.setViewTextColor(this.elj, R.color.CAM_X0105);
            ap.setBackgroundColor(this.nXL, R.color.CAM_X0204);
            ap.setViewTextColor(this.nXM, R.color.CAM_X0302);
        }
    }
}
