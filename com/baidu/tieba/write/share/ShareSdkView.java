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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    private HeadImageView bVG;
    private TextView bVH;
    private TextView bpQ;
    private TbImageView eUC;
    private int jIA;
    private int jIB;
    private int jIC;
    private int jID;
    private int jIE;
    private int jIF;
    private a jIG;
    private TextView jIu;
    private View jIv;
    private EditText jIw;
    private View jIx;
    private View jIy;
    private TextView jIz;
    private TextView mContentView;
    private View mRootView;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void FQ(String str);
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
        this.jIu = (TextView) findViewById(R.id.share_sdk_forum);
        this.jIv = findViewById(R.id.share_sdk_content_container);
        this.bVG = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.bVH = (TextView) findViewById(R.id.share_sdk_appname);
        this.mContentView = (TextView) findViewById(R.id.share_sdk_content);
        this.eUC = (TbImageView) findViewById(R.id.share_sdk_img);
        this.jIw = (EditText) findViewById(R.id.share_sdk_edit);
        this.jIx = findViewById(R.id.share_sdk_content_line);
        this.bpQ = (TextView) findViewById(R.id.share_sdk_cancel);
        this.jIy = findViewById(R.id.share_sdk_action_line);
        this.jIz = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.bpQ.setOnClickListener(this);
        this.jIz.setOnClickListener(this);
        this.bVG.setIsRound(true);
        this.bVG.setIsPreDrawBorder(true);
        this.bVG.setDrawBorder(true);
        this.bVG.setBorderWidth(l.g(context, R.dimen.tbds1));
        this.bVG.setDefaultResource(R.color.cp_bg_line_e);
        this.bVG.setRadius(l.g(context, R.dimen.ds70));
        this.eUC.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.jIA = (l.af(getContext()) - l.g(getContext(), R.dimen.tbds516)) / l.g(getContext(), R.dimen.tbds45);
        this.jID = l.g(getContext(), R.dimen.tbds27);
        this.jIE = l.g(getContext(), R.dimen.tbds11);
        this.jIF = l.g(getContext(), R.dimen.tbds36);
        this.jIB = this.jID;
        this.jIC = this.jID;
        this.jIw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.jIA * 2) {
                    if (ShareSdkView.this.jIB != 0) {
                        ShareSdkView.this.jIB = 0;
                        ShareSdkView.this.jIC = ShareSdkView.this.jIE;
                        ShareSdkView.this.jIw.setPadding(ShareSdkView.this.jIF, ShareSdkView.this.jIB, ShareSdkView.this.jIF, ShareSdkView.this.jIC);
                    }
                } else if (editable.length() > ShareSdkView.this.jIA) {
                    if (ShareSdkView.this.jIB != ShareSdkView.this.jIE) {
                        ShareSdkView.this.jIB = ShareSdkView.this.jIE;
                        ShareSdkView.this.jIC = ShareSdkView.this.jIE;
                        ShareSdkView.this.jIw.setPadding(ShareSdkView.this.jIF, ShareSdkView.this.jIB, ShareSdkView.this.jIF, ShareSdkView.this.jIC);
                    }
                } else if (ShareSdkView.this.jIB != ShareSdkView.this.jID) {
                    ShareSdkView.this.jIB = ShareSdkView.this.jID;
                    ShareSdkView.this.jIC = ShareSdkView.this.jID;
                    ShareSdkView.this.jIw.setPadding(ShareSdkView.this.jIF, ShareSdkView.this.jIB, ShareSdkView.this.jIF, ShareSdkView.this.jIC);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.jIG = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bpQ) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.jIz && bc.cE(getContext())) {
            String obj = this.jIw.getText().toString();
            if (this.jIG != null) {
                this.jIG.FQ(obj);
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
        this.jIu.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.jIp));
        this.bVG.startLoad(cVar.jIo, 10, false);
        this.bVH.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.mContentView.setVisibility(8);
        } else {
            this.mContentView.setText(cVar.content);
        }
        this.eUC.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void O(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.eUC.getLayoutParams();
                layoutParams.height = ((l.af(ShareSdkView.this.getContext()) - l.g(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.eUC.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.eUC.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.jIG = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.l(this, R.color.black_alpha30);
            al.k(this.mRootView, R.drawable.share_sdk_bg);
            al.j(this.jIu, R.color.cp_cont_b);
            al.l(this.jIv, R.color.cp_bg_line_e);
            this.bVG.setBorderColor(al.getColor(R.color.cp_cont_g));
            this.bVG.setIsNight(this.mSkinType == 1);
            al.j(this.bVH, R.color.cp_cont_f);
            al.j(this.mContentView, R.color.cp_cont_b);
            this.eUC.setIsNight(this.mSkinType == 1);
            this.jIw.setHintTextColor(al.getColor(R.color.cp_cont_e));
            this.jIw.setTextColor(al.getColor(R.color.cp_cont_b));
            al.k(this.jIw, R.drawable.share_sdk_input_shape_bg);
            al.l(this.jIx, R.color.cp_bg_line_c);
            al.j(this.bpQ, R.color.cp_cont_b);
            al.l(this.jIy, R.color.cp_bg_line_c);
            al.j(this.jIz, R.color.cp_link_tip_a);
        }
    }
}
