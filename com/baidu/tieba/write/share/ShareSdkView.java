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
    private TextView cjk;
    private TextView dDw;
    private HeadImageView eot;
    private TextView eou;
    private EditText fAa;
    private TbImageView hyQ;
    private TextView kTY;
    private View mQa;
    private View mQb;
    private View mQc;
    private TextView mQd;
    private int mQe;
    private int mQf;
    private int mQg;
    private int mQh;
    private int mQi;
    private int mQj;
    private a mQk;
    private View mRootView;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void gW(String str);
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
        this.kTY = (TextView) findViewById(R.id.share_sdk_forum);
        this.mQa = findViewById(R.id.share_sdk_content_container);
        this.eot = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.eou = (TextView) findViewById(R.id.share_sdk_appname);
        this.cjk = (TextView) findViewById(R.id.share_sdk_content);
        this.hyQ = (TbImageView) findViewById(R.id.share_sdk_img);
        this.fAa = (EditText) findViewById(R.id.share_sdk_edit);
        this.mQb = findViewById(R.id.share_sdk_content_line);
        this.dDw = (TextView) findViewById(R.id.share_sdk_cancel);
        this.mQc = findViewById(R.id.share_sdk_action_line);
        this.mQd = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.dDw.setOnClickListener(this);
        this.mQd.setOnClickListener(this);
        this.eot.setIsRound(true);
        this.eot.setIsPreDrawBorder(true);
        this.eot.setDrawBorder(true);
        this.eot.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.eot.setDefaultResource(R.color.cp_bg_line_e);
        this.eot.setRadius(l.getDimens(context, R.dimen.ds70));
        this.hyQ.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.mQe = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.mQh = l.getDimens(getContext(), R.dimen.tbds27);
        this.mQi = l.getDimens(getContext(), R.dimen.tbds11);
        this.mQj = l.getDimens(getContext(), R.dimen.tbds36);
        this.mQf = this.mQh;
        this.mQg = this.mQh;
        this.fAa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.mQe * 2) {
                    if (ShareSdkView.this.mQf != 0) {
                        ShareSdkView.this.mQf = 0;
                        ShareSdkView.this.mQg = ShareSdkView.this.mQi;
                        ShareSdkView.this.fAa.setPadding(ShareSdkView.this.mQj, ShareSdkView.this.mQf, ShareSdkView.this.mQj, ShareSdkView.this.mQg);
                    }
                } else if (editable.length() > ShareSdkView.this.mQe) {
                    if (ShareSdkView.this.mQf != ShareSdkView.this.mQi) {
                        ShareSdkView.this.mQf = ShareSdkView.this.mQi;
                        ShareSdkView.this.mQg = ShareSdkView.this.mQi;
                        ShareSdkView.this.fAa.setPadding(ShareSdkView.this.mQj, ShareSdkView.this.mQf, ShareSdkView.this.mQj, ShareSdkView.this.mQg);
                    }
                } else if (ShareSdkView.this.mQf != ShareSdkView.this.mQh) {
                    ShareSdkView.this.mQf = ShareSdkView.this.mQh;
                    ShareSdkView.this.mQg = ShareSdkView.this.mQh;
                    ShareSdkView.this.fAa.setPadding(ShareSdkView.this.mQj, ShareSdkView.this.mQf, ShareSdkView.this.mQj, ShareSdkView.this.mQg);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.mQk = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dDw) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.mQd && bg.checkUpIsLogin(getContext())) {
            String obj = this.fAa.getText().toString();
            if (this.mQk != null) {
                this.mQk.gW(obj);
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
        this.kTY.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.mPV));
        this.eot.startLoad(cVar.mPU, 10, false);
        this.eou.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.cjk.setVisibility(8);
        } else {
            this.cjk.setText(cVar.content);
        }
        this.hyQ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.hyQ.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.hyQ.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.hyQ.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.mQk = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.black_alpha30);
            ap.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            ap.setViewTextColor(this.kTY, R.color.cp_cont_b);
            ap.setBackgroundColor(this.mQa, R.color.cp_bg_line_e);
            this.eot.setBorderColor(ap.getColor(R.color.cp_cont_g));
            this.eot.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.eou, R.color.cp_cont_f);
            ap.setViewTextColor(this.cjk, R.color.cp_cont_b);
            this.hyQ.setIsNight(this.mSkinType == 1);
            this.fAa.setHintTextColor(ap.getColor(R.color.cp_cont_e));
            this.fAa.setTextColor(ap.getColor(R.color.cp_cont_b));
            ap.setBackgroundResource(this.fAa, R.drawable.share_sdk_input_shape_bg);
            ap.setBackgroundColor(this.mQb, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.dDw, R.color.cp_cont_b);
            ap.setBackgroundColor(this.mQc, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.mQd, R.color.cp_link_tip_a);
        }
    }
}
