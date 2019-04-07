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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    private HeadImageView bNU;
    private TextView bNV;
    private TextView bjM;
    private TbImageView eEH;
    private int jpA;
    private int jpB;
    private int jpC;
    private a jpD;
    private TextView jpr;
    private View jps;
    private EditText jpt;
    private View jpu;
    private View jpv;
    private TextView jpw;
    private int jpx;
    private int jpy;
    private int jpz;
    private TextView mContentView;
    private View mRootView;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void Eu(String str);
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
        LayoutInflater.from(context).inflate(d.h.share_sdk_view, (ViewGroup) this, true);
        this.mRootView = findViewById(d.g.share_sdk_content_root);
        this.jpr = (TextView) findViewById(d.g.share_sdk_forum);
        this.jps = findViewById(d.g.share_sdk_content_container);
        this.bNU = (HeadImageView) findViewById(d.g.share_sdk_appicon);
        this.bNV = (TextView) findViewById(d.g.share_sdk_appname);
        this.mContentView = (TextView) findViewById(d.g.share_sdk_content);
        this.eEH = (TbImageView) findViewById(d.g.share_sdk_img);
        this.jpt = (EditText) findViewById(d.g.share_sdk_edit);
        this.jpu = findViewById(d.g.share_sdk_content_line);
        this.bjM = (TextView) findViewById(d.g.share_sdk_cancel);
        this.jpv = findViewById(d.g.share_sdk_action_line);
        this.jpw = (TextView) findViewById(d.g.share_sdk_share);
        setOnClickListener(this);
        this.bjM.setOnClickListener(this);
        this.jpw.setOnClickListener(this);
        this.bNU.setIsRound(true);
        this.bNU.setIsPreDrawBorder(true);
        this.bNU.setDrawBorder(true);
        this.bNU.setBorderWidth(l.h(context, d.e.tbds1));
        this.bNU.setDefaultResource(d.C0277d.cp_bg_line_e);
        this.bNU.setRadius(l.h(context, d.e.ds70));
        this.eEH.setDefaultBgResource(d.f.pic_share_default_applets);
        this.jpx = (l.aO(getContext()) - l.h(getContext(), d.e.tbds516)) / l.h(getContext(), d.e.tbds45);
        this.jpA = l.h(getContext(), d.e.tbds27);
        this.jpB = l.h(getContext(), d.e.tbds11);
        this.jpC = l.h(getContext(), d.e.tbds36);
        this.jpy = this.jpA;
        this.jpz = this.jpA;
        this.jpt.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.jpx * 2) {
                    if (ShareSdkView.this.jpy != 0) {
                        ShareSdkView.this.jpy = 0;
                        ShareSdkView.this.jpz = ShareSdkView.this.jpB;
                        ShareSdkView.this.jpt.setPadding(ShareSdkView.this.jpC, ShareSdkView.this.jpy, ShareSdkView.this.jpC, ShareSdkView.this.jpz);
                    }
                } else if (editable.length() > ShareSdkView.this.jpx) {
                    if (ShareSdkView.this.jpy != ShareSdkView.this.jpB) {
                        ShareSdkView.this.jpy = ShareSdkView.this.jpB;
                        ShareSdkView.this.jpz = ShareSdkView.this.jpB;
                        ShareSdkView.this.jpt.setPadding(ShareSdkView.this.jpC, ShareSdkView.this.jpy, ShareSdkView.this.jpC, ShareSdkView.this.jpz);
                    }
                } else if (ShareSdkView.this.jpy != ShareSdkView.this.jpA) {
                    ShareSdkView.this.jpy = ShareSdkView.this.jpA;
                    ShareSdkView.this.jpz = ShareSdkView.this.jpA;
                    ShareSdkView.this.jpt.setPadding(ShareSdkView.this.jpC, ShareSdkView.this.jpy, ShareSdkView.this.jpC, ShareSdkView.this.jpz);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.jpD = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bjM) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.jpw && bc.cZ(getContext())) {
            String obj = this.jpt.getText().toString();
            if (this.jpD != null) {
                this.jpD.Eu(obj);
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
        this.jpr.setText(String.format(getResources().getString(d.j.share_sdk_forum), cVar.jpm));
        this.bNU.startLoad(cVar.jpl, 10, false);
        this.bNV.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.mContentView.setVisibility(8);
        } else {
            this.mContentView.setText(cVar.content);
        }
        this.eEH.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.eEH.getLayoutParams();
                layoutParams.height = ((l.aO(ShareSdkView.this.getContext()) - l.h(ShareSdkView.this.getContext(), d.e.tbds408)) * 9) / 16;
                ShareSdkView.this.eEH.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.eEH.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.jpD = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.l(this, d.C0277d.black_alpha30);
            al.k(this.mRootView, d.f.share_sdk_bg);
            al.j(this.jpr, d.C0277d.cp_cont_b);
            al.l(this.jps, d.C0277d.cp_bg_line_e);
            this.bNU.setBorderColor(al.getColor(d.C0277d.cp_cont_g));
            this.bNU.setIsNight(this.mSkinType == 1);
            al.j(this.bNV, d.C0277d.cp_cont_f);
            al.j(this.mContentView, d.C0277d.cp_cont_b);
            this.eEH.setIsNight(this.mSkinType == 1);
            this.jpt.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
            this.jpt.setTextColor(al.getColor(d.C0277d.cp_cont_b));
            al.k(this.jpt, d.f.share_sdk_input_shape_bg);
            al.l(this.jpu, d.C0277d.cp_bg_line_c);
            al.j(this.bjM, d.C0277d.cp_cont_b);
            al.l(this.jpv, d.C0277d.cp_bg_line_c);
            al.j(this.jpw, d.C0277d.cp_link_tip_a);
        }
    }
}
