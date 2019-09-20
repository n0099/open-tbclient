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
/* loaded from: classes3.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    private HeadImageView bXI;
    private TextView bXJ;
    private TextView brb;
    private TbImageView fby;
    private TextView jTd;
    private View jTe;
    private EditText jTf;
    private View jTg;
    private View jTh;
    private TextView jTi;
    private int jTj;
    private int jTk;
    private int jTl;
    private int jTm;
    private int jTn;
    private int jTo;
    private a jTp;
    private TextView mContentView;
    private View mRootView;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void Hn(String str);
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
        this.jTd = (TextView) findViewById(R.id.share_sdk_forum);
        this.jTe = findViewById(R.id.share_sdk_content_container);
        this.bXI = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.bXJ = (TextView) findViewById(R.id.share_sdk_appname);
        this.mContentView = (TextView) findViewById(R.id.share_sdk_content);
        this.fby = (TbImageView) findViewById(R.id.share_sdk_img);
        this.jTf = (EditText) findViewById(R.id.share_sdk_edit);
        this.jTg = findViewById(R.id.share_sdk_content_line);
        this.brb = (TextView) findViewById(R.id.share_sdk_cancel);
        this.jTh = findViewById(R.id.share_sdk_action_line);
        this.jTi = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.brb.setOnClickListener(this);
        this.jTi.setOnClickListener(this);
        this.bXI.setIsRound(true);
        this.bXI.setIsPreDrawBorder(true);
        this.bXI.setDrawBorder(true);
        this.bXI.setBorderWidth(l.g(context, R.dimen.tbds1));
        this.bXI.setDefaultResource(R.color.cp_bg_line_e);
        this.bXI.setRadius(l.g(context, R.dimen.ds70));
        this.fby.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.jTj = (l.af(getContext()) - l.g(getContext(), R.dimen.tbds516)) / l.g(getContext(), R.dimen.tbds45);
        this.jTm = l.g(getContext(), R.dimen.tbds27);
        this.jTn = l.g(getContext(), R.dimen.tbds11);
        this.jTo = l.g(getContext(), R.dimen.tbds36);
        this.jTk = this.jTm;
        this.jTl = this.jTm;
        this.jTf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.jTj * 2) {
                    if (ShareSdkView.this.jTk != 0) {
                        ShareSdkView.this.jTk = 0;
                        ShareSdkView.this.jTl = ShareSdkView.this.jTn;
                        ShareSdkView.this.jTf.setPadding(ShareSdkView.this.jTo, ShareSdkView.this.jTk, ShareSdkView.this.jTo, ShareSdkView.this.jTl);
                    }
                } else if (editable.length() > ShareSdkView.this.jTj) {
                    if (ShareSdkView.this.jTk != ShareSdkView.this.jTn) {
                        ShareSdkView.this.jTk = ShareSdkView.this.jTn;
                        ShareSdkView.this.jTl = ShareSdkView.this.jTn;
                        ShareSdkView.this.jTf.setPadding(ShareSdkView.this.jTo, ShareSdkView.this.jTk, ShareSdkView.this.jTo, ShareSdkView.this.jTl);
                    }
                } else if (ShareSdkView.this.jTk != ShareSdkView.this.jTm) {
                    ShareSdkView.this.jTk = ShareSdkView.this.jTm;
                    ShareSdkView.this.jTl = ShareSdkView.this.jTm;
                    ShareSdkView.this.jTf.setPadding(ShareSdkView.this.jTo, ShareSdkView.this.jTk, ShareSdkView.this.jTo, ShareSdkView.this.jTl);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.jTp = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.brb) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.jTi && bc.cF(getContext())) {
            String obj = this.jTf.getText().toString();
            if (this.jTp != null) {
                this.jTp.Hn(obj);
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
        this.jTd.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.jSY));
        this.bXI.startLoad(cVar.jSX, 10, false);
        this.bXJ.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.mContentView.setVisibility(8);
        } else {
            this.mContentView.setText(cVar.content);
        }
        this.fby.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.fby.getLayoutParams();
                layoutParams.height = ((l.af(ShareSdkView.this.getContext()) - l.g(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.fby.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fby.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.jTp = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.l(this, R.color.black_alpha30);
            am.k(this.mRootView, R.drawable.share_sdk_bg);
            am.j(this.jTd, R.color.cp_cont_b);
            am.l(this.jTe, R.color.cp_bg_line_e);
            this.bXI.setBorderColor(am.getColor(R.color.cp_cont_g));
            this.bXI.setIsNight(this.mSkinType == 1);
            am.j(this.bXJ, R.color.cp_cont_f);
            am.j(this.mContentView, R.color.cp_cont_b);
            this.fby.setIsNight(this.mSkinType == 1);
            this.jTf.setHintTextColor(am.getColor(R.color.cp_cont_e));
            this.jTf.setTextColor(am.getColor(R.color.cp_cont_b));
            am.k(this.jTf, R.drawable.share_sdk_input_shape_bg);
            am.l(this.jTg, R.color.cp_bg_line_c);
            am.j(this.brb, R.color.cp_cont_b);
            am.l(this.jTh, R.color.cp_bg_line_c);
            am.j(this.jTi, R.color.cp_link_tip_a);
        }
    }
}
