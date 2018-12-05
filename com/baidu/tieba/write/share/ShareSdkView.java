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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    private HeadImageView aFm;
    private TextView aFn;
    private TbImageView dOu;
    private int hUA;
    private a hUB;
    private TextView hUp;
    private View hUq;
    private EditText hUr;
    private View hUs;
    private View hUt;
    private TextView hUu;
    private int hUv;
    private int hUw;
    private int hUx;
    private int hUy;
    private int hUz;
    private TextView mCancelView;
    private TextView mContentView;
    private View mRootView;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void xD(String str);
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
        LayoutInflater.from(context).inflate(e.h.share_sdk_view, (ViewGroup) this, true);
        this.mRootView = findViewById(e.g.share_sdk_content_root);
        this.hUp = (TextView) findViewById(e.g.share_sdk_forum);
        this.hUq = findViewById(e.g.share_sdk_content_container);
        this.aFm = (HeadImageView) findViewById(e.g.share_sdk_appicon);
        this.aFn = (TextView) findViewById(e.g.share_sdk_appname);
        this.mContentView = (TextView) findViewById(e.g.share_sdk_content);
        this.dOu = (TbImageView) findViewById(e.g.share_sdk_img);
        this.hUr = (EditText) findViewById(e.g.share_sdk_edit);
        this.hUs = findViewById(e.g.share_sdk_content_line);
        this.mCancelView = (TextView) findViewById(e.g.share_sdk_cancel);
        this.hUt = findViewById(e.g.share_sdk_action_line);
        this.hUu = (TextView) findViewById(e.g.share_sdk_share);
        setOnClickListener(this);
        this.mCancelView.setOnClickListener(this);
        this.hUu.setOnClickListener(this);
        this.aFm.setIsRound(true);
        this.aFm.setIsPreDrawBorder(true);
        this.aFm.setDrawBorder(true);
        this.aFm.setBorderWidth(l.h(context, e.C0210e.tbds1));
        this.aFm.setDefaultResource(e.d.cp_bg_line_e);
        this.aFm.setRadius(l.h(context, e.C0210e.ds70));
        this.dOu.setDefaultBgResource(e.f.pic_share_default_applets);
        this.hUv = (l.aO(getContext()) - l.h(getContext(), e.C0210e.tbds516)) / l.h(getContext(), e.C0210e.tbds45);
        this.hUy = l.h(getContext(), e.C0210e.tbds27);
        this.hUz = l.h(getContext(), e.C0210e.tbds11);
        this.hUA = l.h(getContext(), e.C0210e.tbds36);
        this.hUw = this.hUy;
        this.hUx = this.hUy;
        this.hUr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.hUv * 2) {
                    if (ShareSdkView.this.hUw != 0) {
                        ShareSdkView.this.hUw = 0;
                        ShareSdkView.this.hUx = ShareSdkView.this.hUz;
                        ShareSdkView.this.hUr.setPadding(ShareSdkView.this.hUA, ShareSdkView.this.hUw, ShareSdkView.this.hUA, ShareSdkView.this.hUx);
                    }
                } else if (editable.length() > ShareSdkView.this.hUv) {
                    if (ShareSdkView.this.hUw != ShareSdkView.this.hUz) {
                        ShareSdkView.this.hUw = ShareSdkView.this.hUz;
                        ShareSdkView.this.hUx = ShareSdkView.this.hUz;
                        ShareSdkView.this.hUr.setPadding(ShareSdkView.this.hUA, ShareSdkView.this.hUw, ShareSdkView.this.hUA, ShareSdkView.this.hUx);
                    }
                } else if (ShareSdkView.this.hUw != ShareSdkView.this.hUy) {
                    ShareSdkView.this.hUw = ShareSdkView.this.hUy;
                    ShareSdkView.this.hUx = ShareSdkView.this.hUy;
                    ShareSdkView.this.hUr.setPadding(ShareSdkView.this.hUA, ShareSdkView.this.hUw, ShareSdkView.this.hUA, ShareSdkView.this.hUx);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.hUB = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mCancelView) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.hUu && ba.bJ(getContext())) {
            String obj = this.hUr.getText().toString();
            if (this.hUB != null) {
                this.hUB.xD(obj);
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
        this.hUp.setText(String.format(getResources().getString(e.j.share_sdk_forum), cVar.hUk));
        this.aFm.startLoad(cVar.bGI, 10, false);
        this.aFn.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.mContentView.setVisibility(8);
        } else {
            this.mContentView.setText(cVar.content);
        }
        this.dOu.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.dOu.getLayoutParams();
                layoutParams.height = ((l.aO(ShareSdkView.this.getContext()) - l.h(ShareSdkView.this.getContext(), e.C0210e.tbds408)) * 9) / 16;
                ShareSdkView.this.dOu.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.dOu.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.hUB = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.j(this, e.d.black_alpha30);
            al.i(this.mRootView, e.f.share_sdk_bg);
            al.h(this.hUp, e.d.cp_cont_b);
            al.j(this.hUq, e.d.cp_bg_line_e);
            this.aFm.setBorderColor(al.getColor(e.d.cp_cont_g));
            this.aFm.setIsNight(this.mSkinType == 1);
            al.h(this.aFn, e.d.cp_cont_f);
            al.h(this.mContentView, e.d.cp_cont_b);
            this.dOu.setIsNight(this.mSkinType == 1);
            this.hUr.setHintTextColor(al.getColor(e.d.cp_cont_e));
            this.hUr.setTextColor(al.getColor(e.d.cp_cont_b));
            al.i(this.hUr, e.f.share_sdk_input_shape_bg);
            al.j(this.hUs, e.d.cp_bg_line_c);
            al.h(this.mCancelView, e.d.cp_cont_b);
            al.j(this.hUt, e.d.cp_bg_line_c);
            al.h(this.hUu, e.d.cp_link_tip_a);
        }
    }
}
