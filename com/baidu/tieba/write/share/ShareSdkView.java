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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    private TextView cWc;
    private TextView euo;
    private HeadImageView fhb;
    private TextView fhc;
    private EditText gwY;
    private TbImageView iLn;
    private View kVN;
    private View mRootView;
    private int mSkinType;
    private TextView mec;
    private View oaF;
    private View oaG;
    private TextView oaH;
    private int oaI;
    private int oaJ;
    private int oaK;
    private int oaL;
    private int oaM;
    private int oaN;
    private a oaO;

    /* loaded from: classes8.dex */
    public interface a {
        void hY(String str);
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
        this.mec = (TextView) findViewById(R.id.share_sdk_forum);
        this.oaF = findViewById(R.id.share_sdk_content_container);
        this.fhb = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.fhc = (TextView) findViewById(R.id.share_sdk_appname);
        this.cWc = (TextView) findViewById(R.id.share_sdk_content);
        this.iLn = (TbImageView) findViewById(R.id.share_sdk_img);
        this.gwY = (EditText) findViewById(R.id.share_sdk_edit);
        this.kVN = findViewById(R.id.share_sdk_content_line);
        this.euo = (TextView) findViewById(R.id.share_sdk_cancel);
        this.oaG = findViewById(R.id.share_sdk_action_line);
        this.oaH = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.euo.setOnClickListener(this);
        this.oaH.setOnClickListener(this);
        this.fhb.setIsRound(true);
        this.fhb.setIsPreDrawBorder(true);
        this.fhb.setDrawBorder(true);
        this.fhb.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.fhb.setDefaultResource(R.color.CAM_X0205);
        this.fhb.setRadius(l.getDimens(context, R.dimen.ds70));
        this.iLn.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.oaI = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.oaL = l.getDimens(getContext(), R.dimen.tbds27);
        this.oaM = l.getDimens(getContext(), R.dimen.tbds11);
        this.oaN = l.getDimens(getContext(), R.dimen.tbds36);
        this.oaJ = this.oaL;
        this.oaK = this.oaL;
        this.gwY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.oaI * 2) {
                    if (ShareSdkView.this.oaJ != 0) {
                        ShareSdkView.this.oaJ = 0;
                        ShareSdkView.this.oaK = ShareSdkView.this.oaM;
                        ShareSdkView.this.gwY.setPadding(ShareSdkView.this.oaN, ShareSdkView.this.oaJ, ShareSdkView.this.oaN, ShareSdkView.this.oaK);
                    }
                } else if (editable.length() > ShareSdkView.this.oaI) {
                    if (ShareSdkView.this.oaJ != ShareSdkView.this.oaM) {
                        ShareSdkView.this.oaJ = ShareSdkView.this.oaM;
                        ShareSdkView.this.oaK = ShareSdkView.this.oaM;
                        ShareSdkView.this.gwY.setPadding(ShareSdkView.this.oaN, ShareSdkView.this.oaJ, ShareSdkView.this.oaN, ShareSdkView.this.oaK);
                    }
                } else if (ShareSdkView.this.oaJ != ShareSdkView.this.oaL) {
                    ShareSdkView.this.oaJ = ShareSdkView.this.oaL;
                    ShareSdkView.this.oaK = ShareSdkView.this.oaL;
                    ShareSdkView.this.gwY.setPadding(ShareSdkView.this.oaN, ShareSdkView.this.oaJ, ShareSdkView.this.oaN, ShareSdkView.this.oaK);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.oaO = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.euo) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.oaH && bg.checkUpIsLogin(getContext())) {
            String obj = this.gwY.getText().toString();
            if (this.oaO != null) {
                this.oaO.hY(obj);
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
        this.mec.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.oaA));
        this.fhb.startLoad(cVar.oaz, 10, false);
        this.fhc.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.cWc.setVisibility(8);
        } else {
            this.cWc.setText(cVar.content);
        }
        this.iLn.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.iLn.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.iLn.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        this.iLn.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.oaO = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ao.setBackgroundColor(this, R.color.black_alpha30);
            ao.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            ao.setViewTextColor(this.mec, R.color.CAM_X0105);
            ao.setBackgroundColor(this.oaF, R.color.CAM_X0205);
            this.fhb.setBorderColor(ao.getColor(R.color.CAM_X0111));
            this.fhb.setIsNight(this.mSkinType == 1);
            ao.setViewTextColor(this.fhc, R.color.CAM_X0106);
            ao.setViewTextColor(this.cWc, R.color.CAM_X0105);
            this.iLn.setIsNight(this.mSkinType == 1);
            this.gwY.setHintTextColor(ao.getColor(R.color.CAM_X0110));
            this.gwY.setTextColor(ao.getColor(R.color.CAM_X0105));
            ao.setBackgroundResource(this.gwY, R.drawable.share_sdk_input_shape_bg);
            ao.setBackgroundColor(this.kVN, R.color.CAM_X0204);
            ao.setViewTextColor(this.euo, R.color.CAM_X0105);
            ao.setBackgroundColor(this.oaG, R.color.CAM_X0204);
            ao.setViewTextColor(this.oaH, R.color.CAM_X0302);
        }
    }
}
