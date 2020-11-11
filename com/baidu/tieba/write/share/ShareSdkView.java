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
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    private TextView cLW;
    private HeadImageView eRk;
    private TextView eRl;
    private TextView efP;
    private EditText geK;
    private TbImageView inr;
    private View kCz;
    private TextView lKv;
    private View mRootView;
    private int mSkinType;
    private View nId;
    private View nIe;
    private TextView nIf;
    private int nIg;
    private int nIh;
    private int nIi;
    private int nIj;
    private int nIk;
    private int nIl;
    private a nIm;

    /* loaded from: classes3.dex */
    public interface a {
        void hP(String str);
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
        this.lKv = (TextView) findViewById(R.id.share_sdk_forum);
        this.nId = findViewById(R.id.share_sdk_content_container);
        this.eRk = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.eRl = (TextView) findViewById(R.id.share_sdk_appname);
        this.cLW = (TextView) findViewById(R.id.share_sdk_content);
        this.inr = (TbImageView) findViewById(R.id.share_sdk_img);
        this.geK = (EditText) findViewById(R.id.share_sdk_edit);
        this.kCz = findViewById(R.id.share_sdk_content_line);
        this.efP = (TextView) findViewById(R.id.share_sdk_cancel);
        this.nIe = findViewById(R.id.share_sdk_action_line);
        this.nIf = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.efP.setOnClickListener(this);
        this.nIf.setOnClickListener(this);
        this.eRk.setIsRound(true);
        this.eRk.setIsPreDrawBorder(true);
        this.eRk.setDrawBorder(true);
        this.eRk.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.eRk.setDefaultResource(R.color.cp_bg_line_e);
        this.eRk.setRadius(l.getDimens(context, R.dimen.ds70));
        this.inr.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.nIg = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.nIj = l.getDimens(getContext(), R.dimen.tbds27);
        this.nIk = l.getDimens(getContext(), R.dimen.tbds11);
        this.nIl = l.getDimens(getContext(), R.dimen.tbds36);
        this.nIh = this.nIj;
        this.nIi = this.nIj;
        this.geK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.nIg * 2) {
                    if (ShareSdkView.this.nIh != 0) {
                        ShareSdkView.this.nIh = 0;
                        ShareSdkView.this.nIi = ShareSdkView.this.nIk;
                        ShareSdkView.this.geK.setPadding(ShareSdkView.this.nIl, ShareSdkView.this.nIh, ShareSdkView.this.nIl, ShareSdkView.this.nIi);
                    }
                } else if (editable.length() > ShareSdkView.this.nIg) {
                    if (ShareSdkView.this.nIh != ShareSdkView.this.nIk) {
                        ShareSdkView.this.nIh = ShareSdkView.this.nIk;
                        ShareSdkView.this.nIi = ShareSdkView.this.nIk;
                        ShareSdkView.this.geK.setPadding(ShareSdkView.this.nIl, ShareSdkView.this.nIh, ShareSdkView.this.nIl, ShareSdkView.this.nIi);
                    }
                } else if (ShareSdkView.this.nIh != ShareSdkView.this.nIj) {
                    ShareSdkView.this.nIh = ShareSdkView.this.nIj;
                    ShareSdkView.this.nIi = ShareSdkView.this.nIj;
                    ShareSdkView.this.geK.setPadding(ShareSdkView.this.nIl, ShareSdkView.this.nIh, ShareSdkView.this.nIl, ShareSdkView.this.nIi);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.nIm = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.efP) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.nIf && bg.checkUpIsLogin(getContext())) {
            String obj = this.geK.getText().toString();
            if (this.nIm != null) {
                this.nIm.hP(obj);
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
        this.lKv.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.nHY));
        this.eRk.startLoad(cVar.nHX, 10, false);
        this.eRl.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.cLW.setVisibility(8);
        } else {
            this.cLW.setText(cVar.content);
        }
        this.inr.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.inr.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.inr.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.inr.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.nIm = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.black_alpha30);
            ap.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            ap.setViewTextColor(this.lKv, R.color.cp_cont_b);
            ap.setBackgroundColor(this.nId, R.color.cp_bg_line_e);
            this.eRk.setBorderColor(ap.getColor(R.color.cp_cont_g));
            this.eRk.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.eRl, R.color.cp_cont_f);
            ap.setViewTextColor(this.cLW, R.color.cp_cont_b);
            this.inr.setIsNight(this.mSkinType == 1);
            this.geK.setHintTextColor(ap.getColor(R.color.cp_cont_e));
            this.geK.setTextColor(ap.getColor(R.color.cp_cont_b));
            ap.setBackgroundResource(this.geK, R.drawable.share_sdk_input_shape_bg);
            ap.setBackgroundColor(this.kCz, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.efP, R.color.cp_cont_b);
            ap.setBackgroundColor(this.nIe, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.nIf, R.color.cp_link_tip_a);
        }
    }
}
