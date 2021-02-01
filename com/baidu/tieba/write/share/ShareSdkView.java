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
    private EditText gvb;
    private TbImageView iMp;
    private View kZk;
    private View mRootView;
    private int mSkinType;
    private TextView miB;
    private View ogg;
    private View ogh;
    private TextView ogi;
    private int ogj;
    private int ogk;
    private int ogl;
    private int ogm;
    private int ogn;
    private int ogo;
    private a ogp;

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
        this.miB = (TextView) findViewById(R.id.share_sdk_forum);
        this.ogg = findViewById(R.id.share_sdk_content_container);
        this.feI = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.feJ = (TextView) findViewById(R.id.share_sdk_appname);
        this.cTD = (TextView) findViewById(R.id.share_sdk_content);
        this.iMp = (TbImageView) findViewById(R.id.share_sdk_img);
        this.gvb = (EditText) findViewById(R.id.share_sdk_edit);
        this.kZk = findViewById(R.id.share_sdk_content_line);
        this.erH = (TextView) findViewById(R.id.share_sdk_cancel);
        this.ogh = findViewById(R.id.share_sdk_action_line);
        this.ogi = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.erH.setOnClickListener(this);
        this.ogi.setOnClickListener(this);
        this.feI.setIsRound(true);
        this.feI.setIsPreDrawBorder(true);
        this.feI.setDrawBorder(true);
        this.feI.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.feI.setDefaultResource(R.color.CAM_X0205);
        this.feI.setRadius(l.getDimens(context, R.dimen.ds70));
        this.iMp.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.ogj = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.ogm = l.getDimens(getContext(), R.dimen.tbds27);
        this.ogn = l.getDimens(getContext(), R.dimen.tbds11);
        this.ogo = l.getDimens(getContext(), R.dimen.tbds36);
        this.ogk = this.ogm;
        this.ogl = this.ogm;
        this.gvb.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.ogj * 2) {
                    if (ShareSdkView.this.ogk != 0) {
                        ShareSdkView.this.ogk = 0;
                        ShareSdkView.this.ogl = ShareSdkView.this.ogn;
                        ShareSdkView.this.gvb.setPadding(ShareSdkView.this.ogo, ShareSdkView.this.ogk, ShareSdkView.this.ogo, ShareSdkView.this.ogl);
                    }
                } else if (editable.length() > ShareSdkView.this.ogj) {
                    if (ShareSdkView.this.ogk != ShareSdkView.this.ogn) {
                        ShareSdkView.this.ogk = ShareSdkView.this.ogn;
                        ShareSdkView.this.ogl = ShareSdkView.this.ogn;
                        ShareSdkView.this.gvb.setPadding(ShareSdkView.this.ogo, ShareSdkView.this.ogk, ShareSdkView.this.ogo, ShareSdkView.this.ogl);
                    }
                } else if (ShareSdkView.this.ogk != ShareSdkView.this.ogm) {
                    ShareSdkView.this.ogk = ShareSdkView.this.ogm;
                    ShareSdkView.this.ogl = ShareSdkView.this.ogm;
                    ShareSdkView.this.gvb.setPadding(ShareSdkView.this.ogo, ShareSdkView.this.ogk, ShareSdkView.this.ogo, ShareSdkView.this.ogl);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.ogp = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.erH) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.ogi && bh.checkUpIsLogin(getContext())) {
            String obj = this.gvb.getText().toString();
            if (this.ogp != null) {
                this.ogp.hm(obj);
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
        this.miB.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.ogb));
        this.feI.startLoad(cVar.eKQ, 10, false);
        this.feJ.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.cTD.setVisibility(8);
        } else {
            this.cTD.setText(cVar.content);
        }
        this.iMp.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.iMp.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.iMp.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        this.iMp.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.ogp = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.black_alpha30);
            ap.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            ap.setViewTextColor(this.miB, R.color.CAM_X0105);
            ap.setBackgroundColor(this.ogg, R.color.CAM_X0205);
            this.feI.setBorderColor(ap.getColor(R.color.CAM_X0111));
            this.feI.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.feJ, R.color.CAM_X0106);
            ap.setViewTextColor(this.cTD, R.color.CAM_X0105);
            this.iMp.setIsNight(this.mSkinType == 1);
            this.gvb.setHintTextColor(ap.getColor(R.color.CAM_X0110));
            this.gvb.setTextColor(ap.getColor(R.color.CAM_X0105));
            ap.setBackgroundResource(this.gvb, R.drawable.share_sdk_input_shape_bg);
            ap.setBackgroundColor(this.kZk, R.color.CAM_X0204);
            ap.setViewTextColor(this.erH, R.color.CAM_X0105);
            ap.setBackgroundColor(this.ogh, R.color.CAM_X0204);
            ap.setViewTextColor(this.ogi, R.color.CAM_X0302);
        }
    }
}
