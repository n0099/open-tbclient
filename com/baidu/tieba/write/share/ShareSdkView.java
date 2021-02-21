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
/* loaded from: classes8.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    private TextView cTD;
    private TextView erH;
    private HeadImageView feI;
    private TextView feJ;
    private EditText gvp;
    private TbImageView iMD;
    private View kZy;
    private View mRootView;
    private int mSkinType;
    private TextView miQ;
    private View ogG;
    private View ogH;
    private TextView ogI;
    private int ogJ;
    private int ogK;
    private int ogL;
    private int ogM;
    private int ogN;
    private int ogO;
    private a ogP;

    /* loaded from: classes8.dex */
    public interface a {
        void hm(String str);
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
        this.miQ = (TextView) findViewById(R.id.share_sdk_forum);
        this.ogG = findViewById(R.id.share_sdk_content_container);
        this.feI = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.feJ = (TextView) findViewById(R.id.share_sdk_appname);
        this.cTD = (TextView) findViewById(R.id.share_sdk_content);
        this.iMD = (TbImageView) findViewById(R.id.share_sdk_img);
        this.gvp = (EditText) findViewById(R.id.share_sdk_edit);
        this.kZy = findViewById(R.id.share_sdk_content_line);
        this.erH = (TextView) findViewById(R.id.share_sdk_cancel);
        this.ogH = findViewById(R.id.share_sdk_action_line);
        this.ogI = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.erH.setOnClickListener(this);
        this.ogI.setOnClickListener(this);
        this.feI.setIsRound(true);
        this.feI.setIsPreDrawBorder(true);
        this.feI.setDrawBorder(true);
        this.feI.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.feI.setDefaultResource(R.color.CAM_X0205);
        this.feI.setRadius(l.getDimens(context, R.dimen.ds70));
        this.iMD.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.ogJ = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.ogM = l.getDimens(getContext(), R.dimen.tbds27);
        this.ogN = l.getDimens(getContext(), R.dimen.tbds11);
        this.ogO = l.getDimens(getContext(), R.dimen.tbds36);
        this.ogK = this.ogM;
        this.ogL = this.ogM;
        this.gvp.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.ogJ * 2) {
                    if (ShareSdkView.this.ogK != 0) {
                        ShareSdkView.this.ogK = 0;
                        ShareSdkView.this.ogL = ShareSdkView.this.ogN;
                        ShareSdkView.this.gvp.setPadding(ShareSdkView.this.ogO, ShareSdkView.this.ogK, ShareSdkView.this.ogO, ShareSdkView.this.ogL);
                    }
                } else if (editable.length() > ShareSdkView.this.ogJ) {
                    if (ShareSdkView.this.ogK != ShareSdkView.this.ogN) {
                        ShareSdkView.this.ogK = ShareSdkView.this.ogN;
                        ShareSdkView.this.ogL = ShareSdkView.this.ogN;
                        ShareSdkView.this.gvp.setPadding(ShareSdkView.this.ogO, ShareSdkView.this.ogK, ShareSdkView.this.ogO, ShareSdkView.this.ogL);
                    }
                } else if (ShareSdkView.this.ogK != ShareSdkView.this.ogM) {
                    ShareSdkView.this.ogK = ShareSdkView.this.ogM;
                    ShareSdkView.this.ogL = ShareSdkView.this.ogM;
                    ShareSdkView.this.gvp.setPadding(ShareSdkView.this.ogO, ShareSdkView.this.ogK, ShareSdkView.this.ogO, ShareSdkView.this.ogL);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.ogP = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.erH) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.ogI && bh.checkUpIsLogin(getContext())) {
            String obj = this.gvp.getText().toString();
            if (this.ogP != null) {
                this.ogP.hm(obj);
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
        this.miQ.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.ogB));
        this.feI.startLoad(cVar.eKQ, 10, false);
        this.feJ.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.cTD.setVisibility(8);
        } else {
            this.cTD.setText(cVar.content);
        }
        this.iMD.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.iMD.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.iMD.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        this.iMD.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.ogP = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.black_alpha30);
            ap.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            ap.setViewTextColor(this.miQ, R.color.CAM_X0105);
            ap.setBackgroundColor(this.ogG, R.color.CAM_X0205);
            this.feI.setBorderColor(ap.getColor(R.color.CAM_X0111));
            this.feI.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.feJ, R.color.CAM_X0106);
            ap.setViewTextColor(this.cTD, R.color.CAM_X0105);
            this.iMD.setIsNight(this.mSkinType == 1);
            this.gvp.setHintTextColor(ap.getColor(R.color.CAM_X0110));
            this.gvp.setTextColor(ap.getColor(R.color.CAM_X0105));
            ap.setBackgroundResource(this.gvp, R.drawable.share_sdk_input_shape_bg);
            ap.setBackgroundColor(this.kZy, R.color.CAM_X0204);
            ap.setViewTextColor(this.erH, R.color.CAM_X0105);
            ap.setBackgroundColor(this.ogH, R.color.CAM_X0204);
            ap.setViewTextColor(this.ogI, R.color.CAM_X0302);
        }
    }
}
