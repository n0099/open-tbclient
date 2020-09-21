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
    private TextView clp;
    private TextView dFB;
    private HeadImageView eqN;
    private TextView eqO;
    private EditText fDq;
    private TbImageView hFY;
    private TextView lcJ;
    private View mRootView;
    private int mSkinType;
    private View nak;
    private View nal;
    private View nam;
    private TextView nan;
    private int nao;
    private int nap;
    private int naq;
    private int nar;
    private int nas;
    private int nat;
    private a nau;

    /* loaded from: classes3.dex */
    public interface a {
        void hk(String str);
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
        this.lcJ = (TextView) findViewById(R.id.share_sdk_forum);
        this.nak = findViewById(R.id.share_sdk_content_container);
        this.eqN = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.eqO = (TextView) findViewById(R.id.share_sdk_appname);
        this.clp = (TextView) findViewById(R.id.share_sdk_content);
        this.hFY = (TbImageView) findViewById(R.id.share_sdk_img);
        this.fDq = (EditText) findViewById(R.id.share_sdk_edit);
        this.nal = findViewById(R.id.share_sdk_content_line);
        this.dFB = (TextView) findViewById(R.id.share_sdk_cancel);
        this.nam = findViewById(R.id.share_sdk_action_line);
        this.nan = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.dFB.setOnClickListener(this);
        this.nan.setOnClickListener(this);
        this.eqN.setIsRound(true);
        this.eqN.setIsPreDrawBorder(true);
        this.eqN.setDrawBorder(true);
        this.eqN.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.eqN.setDefaultResource(R.color.cp_bg_line_e);
        this.eqN.setRadius(l.getDimens(context, R.dimen.ds70));
        this.hFY.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.nao = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.nar = l.getDimens(getContext(), R.dimen.tbds27);
        this.nas = l.getDimens(getContext(), R.dimen.tbds11);
        this.nat = l.getDimens(getContext(), R.dimen.tbds36);
        this.nap = this.nar;
        this.naq = this.nar;
        this.fDq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.nao * 2) {
                    if (ShareSdkView.this.nap != 0) {
                        ShareSdkView.this.nap = 0;
                        ShareSdkView.this.naq = ShareSdkView.this.nas;
                        ShareSdkView.this.fDq.setPadding(ShareSdkView.this.nat, ShareSdkView.this.nap, ShareSdkView.this.nat, ShareSdkView.this.naq);
                    }
                } else if (editable.length() > ShareSdkView.this.nao) {
                    if (ShareSdkView.this.nap != ShareSdkView.this.nas) {
                        ShareSdkView.this.nap = ShareSdkView.this.nas;
                        ShareSdkView.this.naq = ShareSdkView.this.nas;
                        ShareSdkView.this.fDq.setPadding(ShareSdkView.this.nat, ShareSdkView.this.nap, ShareSdkView.this.nat, ShareSdkView.this.naq);
                    }
                } else if (ShareSdkView.this.nap != ShareSdkView.this.nar) {
                    ShareSdkView.this.nap = ShareSdkView.this.nar;
                    ShareSdkView.this.naq = ShareSdkView.this.nar;
                    ShareSdkView.this.fDq.setPadding(ShareSdkView.this.nat, ShareSdkView.this.nap, ShareSdkView.this.nat, ShareSdkView.this.naq);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.nau = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dFB) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.nan && bg.checkUpIsLogin(getContext())) {
            String obj = this.fDq.getText().toString();
            if (this.nau != null) {
                this.nau.hk(obj);
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
        this.lcJ.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.naf));
        this.eqN.startLoad(cVar.nae, 10, false);
        this.eqO.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.clp.setVisibility(8);
        } else {
            this.clp.setText(cVar.content);
        }
        this.hFY.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.hFY.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.hFY.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.hFY.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.nau = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.black_alpha30);
            ap.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            ap.setViewTextColor(this.lcJ, R.color.cp_cont_b);
            ap.setBackgroundColor(this.nak, R.color.cp_bg_line_e);
            this.eqN.setBorderColor(ap.getColor(R.color.cp_cont_g));
            this.eqN.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.eqO, R.color.cp_cont_f);
            ap.setViewTextColor(this.clp, R.color.cp_cont_b);
            this.hFY.setIsNight(this.mSkinType == 1);
            this.fDq.setHintTextColor(ap.getColor(R.color.cp_cont_e));
            this.fDq.setTextColor(ap.getColor(R.color.cp_cont_b));
            ap.setBackgroundResource(this.fDq, R.drawable.share_sdk_input_shape_bg);
            ap.setBackgroundColor(this.nal, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.dFB, R.color.cp_cont_b);
            ap.setBackgroundColor(this.nam, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.nan, R.color.cp_link_tip_a);
        }
    }
}
