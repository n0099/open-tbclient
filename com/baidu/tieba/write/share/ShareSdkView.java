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
    private HeadImageView bVH;
    private TextView bVI;
    private TextView bpQ;
    private TbImageView eUD;
    private EditText jIA;
    private View jIB;
    private View jIC;
    private TextView jID;
    private int jIE;
    private int jIF;
    private int jIG;
    private int jIH;
    private int jII;
    private int jIJ;
    private a jIK;
    private TextView jIy;
    private View jIz;
    private TextView mContentView;
    private View mRootView;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void FS(String str);
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
        this.jIy = (TextView) findViewById(R.id.share_sdk_forum);
        this.jIz = findViewById(R.id.share_sdk_content_container);
        this.bVH = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.bVI = (TextView) findViewById(R.id.share_sdk_appname);
        this.mContentView = (TextView) findViewById(R.id.share_sdk_content);
        this.eUD = (TbImageView) findViewById(R.id.share_sdk_img);
        this.jIA = (EditText) findViewById(R.id.share_sdk_edit);
        this.jIB = findViewById(R.id.share_sdk_content_line);
        this.bpQ = (TextView) findViewById(R.id.share_sdk_cancel);
        this.jIC = findViewById(R.id.share_sdk_action_line);
        this.jID = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.bpQ.setOnClickListener(this);
        this.jID.setOnClickListener(this);
        this.bVH.setIsRound(true);
        this.bVH.setIsPreDrawBorder(true);
        this.bVH.setDrawBorder(true);
        this.bVH.setBorderWidth(l.g(context, R.dimen.tbds1));
        this.bVH.setDefaultResource(R.color.cp_bg_line_e);
        this.bVH.setRadius(l.g(context, R.dimen.ds70));
        this.eUD.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.jIE = (l.af(getContext()) - l.g(getContext(), R.dimen.tbds516)) / l.g(getContext(), R.dimen.tbds45);
        this.jIH = l.g(getContext(), R.dimen.tbds27);
        this.jII = l.g(getContext(), R.dimen.tbds11);
        this.jIJ = l.g(getContext(), R.dimen.tbds36);
        this.jIF = this.jIH;
        this.jIG = this.jIH;
        this.jIA.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.jIE * 2) {
                    if (ShareSdkView.this.jIF != 0) {
                        ShareSdkView.this.jIF = 0;
                        ShareSdkView.this.jIG = ShareSdkView.this.jII;
                        ShareSdkView.this.jIA.setPadding(ShareSdkView.this.jIJ, ShareSdkView.this.jIF, ShareSdkView.this.jIJ, ShareSdkView.this.jIG);
                    }
                } else if (editable.length() > ShareSdkView.this.jIE) {
                    if (ShareSdkView.this.jIF != ShareSdkView.this.jII) {
                        ShareSdkView.this.jIF = ShareSdkView.this.jII;
                        ShareSdkView.this.jIG = ShareSdkView.this.jII;
                        ShareSdkView.this.jIA.setPadding(ShareSdkView.this.jIJ, ShareSdkView.this.jIF, ShareSdkView.this.jIJ, ShareSdkView.this.jIG);
                    }
                } else if (ShareSdkView.this.jIF != ShareSdkView.this.jIH) {
                    ShareSdkView.this.jIF = ShareSdkView.this.jIH;
                    ShareSdkView.this.jIG = ShareSdkView.this.jIH;
                    ShareSdkView.this.jIA.setPadding(ShareSdkView.this.jIJ, ShareSdkView.this.jIF, ShareSdkView.this.jIJ, ShareSdkView.this.jIG);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.jIK = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bpQ) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.jID && bc.cE(getContext())) {
            String obj = this.jIA.getText().toString();
            if (this.jIK != null) {
                this.jIK.FS(obj);
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
        this.jIy.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.jIt));
        this.bVH.startLoad(cVar.jIs, 10, false);
        this.bVI.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.mContentView.setVisibility(8);
        } else {
            this.mContentView.setText(cVar.content);
        }
        this.eUD.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void O(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.eUD.getLayoutParams();
                layoutParams.height = ((l.af(ShareSdkView.this.getContext()) - l.g(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.eUD.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.eUD.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.jIK = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.l(this, R.color.black_alpha30);
            al.k(this.mRootView, R.drawable.share_sdk_bg);
            al.j(this.jIy, R.color.cp_cont_b);
            al.l(this.jIz, R.color.cp_bg_line_e);
            this.bVH.setBorderColor(al.getColor(R.color.cp_cont_g));
            this.bVH.setIsNight(this.mSkinType == 1);
            al.j(this.bVI, R.color.cp_cont_f);
            al.j(this.mContentView, R.color.cp_cont_b);
            this.eUD.setIsNight(this.mSkinType == 1);
            this.jIA.setHintTextColor(al.getColor(R.color.cp_cont_e));
            this.jIA.setTextColor(al.getColor(R.color.cp_cont_b));
            al.k(this.jIA, R.drawable.share_sdk_input_shape_bg);
            al.l(this.jIB, R.color.cp_bg_line_c);
            al.j(this.bpQ, R.color.cp_cont_b);
            al.l(this.jIC, R.color.cp_bg_line_c);
            al.j(this.jID, R.color.cp_link_tip_a);
        }
    }
}
