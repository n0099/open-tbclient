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
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    private HeadImageView bWJ;
    private TextView bWK;
    private TextView bqD;
    private TbImageView eZE;
    private View jPA;
    private EditText jPB;
    private View jPC;
    private View jPD;
    private TextView jPE;
    private int jPF;
    private int jPG;
    private int jPH;
    private int jPI;
    private int jPJ;
    private int jPK;
    private a jPL;
    private TextView jPz;
    private TextView mContentView;
    private View mRootView;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void GM(String str);
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
        this.jPz = (TextView) findViewById(R.id.share_sdk_forum);
        this.jPA = findViewById(R.id.share_sdk_content_container);
        this.bWJ = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.bWK = (TextView) findViewById(R.id.share_sdk_appname);
        this.mContentView = (TextView) findViewById(R.id.share_sdk_content);
        this.eZE = (TbImageView) findViewById(R.id.share_sdk_img);
        this.jPB = (EditText) findViewById(R.id.share_sdk_edit);
        this.jPC = findViewById(R.id.share_sdk_content_line);
        this.bqD = (TextView) findViewById(R.id.share_sdk_cancel);
        this.jPD = findViewById(R.id.share_sdk_action_line);
        this.jPE = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.bqD.setOnClickListener(this);
        this.jPE.setOnClickListener(this);
        this.bWJ.setIsRound(true);
        this.bWJ.setIsPreDrawBorder(true);
        this.bWJ.setDrawBorder(true);
        this.bWJ.setBorderWidth(l.g(context, R.dimen.tbds1));
        this.bWJ.setDefaultResource(R.color.cp_bg_line_e);
        this.bWJ.setRadius(l.g(context, R.dimen.ds70));
        this.eZE.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.jPF = (l.af(getContext()) - l.g(getContext(), R.dimen.tbds516)) / l.g(getContext(), R.dimen.tbds45);
        this.jPI = l.g(getContext(), R.dimen.tbds27);
        this.jPJ = l.g(getContext(), R.dimen.tbds11);
        this.jPK = l.g(getContext(), R.dimen.tbds36);
        this.jPG = this.jPI;
        this.jPH = this.jPI;
        this.jPB.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.jPF * 2) {
                    if (ShareSdkView.this.jPG != 0) {
                        ShareSdkView.this.jPG = 0;
                        ShareSdkView.this.jPH = ShareSdkView.this.jPJ;
                        ShareSdkView.this.jPB.setPadding(ShareSdkView.this.jPK, ShareSdkView.this.jPG, ShareSdkView.this.jPK, ShareSdkView.this.jPH);
                    }
                } else if (editable.length() > ShareSdkView.this.jPF) {
                    if (ShareSdkView.this.jPG != ShareSdkView.this.jPJ) {
                        ShareSdkView.this.jPG = ShareSdkView.this.jPJ;
                        ShareSdkView.this.jPH = ShareSdkView.this.jPJ;
                        ShareSdkView.this.jPB.setPadding(ShareSdkView.this.jPK, ShareSdkView.this.jPG, ShareSdkView.this.jPK, ShareSdkView.this.jPH);
                    }
                } else if (ShareSdkView.this.jPG != ShareSdkView.this.jPI) {
                    ShareSdkView.this.jPG = ShareSdkView.this.jPI;
                    ShareSdkView.this.jPH = ShareSdkView.this.jPI;
                    ShareSdkView.this.jPB.setPadding(ShareSdkView.this.jPK, ShareSdkView.this.jPG, ShareSdkView.this.jPK, ShareSdkView.this.jPH);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.jPL = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bqD) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.jPE && bd.cF(getContext())) {
            String obj = this.jPB.getText().toString();
            if (this.jPL != null) {
                this.jPL.GM(obj);
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
        this.jPz.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.jPu));
        this.bWJ.startLoad(cVar.jPt, 10, false);
        this.bWK.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.mContentView.setVisibility(8);
        } else {
            this.mContentView.setText(cVar.content);
        }
        this.eZE.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.eZE.getLayoutParams();
                layoutParams.height = ((l.af(ShareSdkView.this.getContext()) - l.g(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.eZE.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.eZE.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.jPL = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.l(this, R.color.black_alpha30);
            am.k(this.mRootView, R.drawable.share_sdk_bg);
            am.j(this.jPz, R.color.cp_cont_b);
            am.l(this.jPA, R.color.cp_bg_line_e);
            this.bWJ.setBorderColor(am.getColor(R.color.cp_cont_g));
            this.bWJ.setIsNight(this.mSkinType == 1);
            am.j(this.bWK, R.color.cp_cont_f);
            am.j(this.mContentView, R.color.cp_cont_b);
            this.eZE.setIsNight(this.mSkinType == 1);
            this.jPB.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.jPB.setTextColor(am.getColor(R.color.cp_cont_b));
            am.k(this.jPB, R.drawable.share_sdk_input_shape_bg);
            am.l(this.jPC, R.color.cp_bg_line_c);
            am.j(this.bqD, R.color.cp_cont_b);
            am.l(this.jPD, R.color.cp_bg_line_c);
            am.j(this.jPE, R.color.cp_link_tip_a);
        }
    }
}
