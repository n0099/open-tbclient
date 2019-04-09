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
    private HeadImageView bNV;
    private TextView bNW;
    private TextView bjN;
    private TbImageView eEI;
    private int jpA;
    private int jpB;
    private int jpC;
    private int jpD;
    private a jpE;
    private TextView jps;
    private View jpt;
    private EditText jpu;
    private View jpv;
    private View jpw;
    private TextView jpx;
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
        this.jps = (TextView) findViewById(d.g.share_sdk_forum);
        this.jpt = findViewById(d.g.share_sdk_content_container);
        this.bNV = (HeadImageView) findViewById(d.g.share_sdk_appicon);
        this.bNW = (TextView) findViewById(d.g.share_sdk_appname);
        this.mContentView = (TextView) findViewById(d.g.share_sdk_content);
        this.eEI = (TbImageView) findViewById(d.g.share_sdk_img);
        this.jpu = (EditText) findViewById(d.g.share_sdk_edit);
        this.jpv = findViewById(d.g.share_sdk_content_line);
        this.bjN = (TextView) findViewById(d.g.share_sdk_cancel);
        this.jpw = findViewById(d.g.share_sdk_action_line);
        this.jpx = (TextView) findViewById(d.g.share_sdk_share);
        setOnClickListener(this);
        this.bjN.setOnClickListener(this);
        this.jpx.setOnClickListener(this);
        this.bNV.setIsRound(true);
        this.bNV.setIsPreDrawBorder(true);
        this.bNV.setDrawBorder(true);
        this.bNV.setBorderWidth(l.h(context, d.e.tbds1));
        this.bNV.setDefaultResource(d.C0277d.cp_bg_line_e);
        this.bNV.setRadius(l.h(context, d.e.ds70));
        this.eEI.setDefaultBgResource(d.f.pic_share_default_applets);
        this.jpy = (l.aO(getContext()) - l.h(getContext(), d.e.tbds516)) / l.h(getContext(), d.e.tbds45);
        this.jpB = l.h(getContext(), d.e.tbds27);
        this.jpC = l.h(getContext(), d.e.tbds11);
        this.jpD = l.h(getContext(), d.e.tbds36);
        this.jpz = this.jpB;
        this.jpA = this.jpB;
        this.jpu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.jpy * 2) {
                    if (ShareSdkView.this.jpz != 0) {
                        ShareSdkView.this.jpz = 0;
                        ShareSdkView.this.jpA = ShareSdkView.this.jpC;
                        ShareSdkView.this.jpu.setPadding(ShareSdkView.this.jpD, ShareSdkView.this.jpz, ShareSdkView.this.jpD, ShareSdkView.this.jpA);
                    }
                } else if (editable.length() > ShareSdkView.this.jpy) {
                    if (ShareSdkView.this.jpz != ShareSdkView.this.jpC) {
                        ShareSdkView.this.jpz = ShareSdkView.this.jpC;
                        ShareSdkView.this.jpA = ShareSdkView.this.jpC;
                        ShareSdkView.this.jpu.setPadding(ShareSdkView.this.jpD, ShareSdkView.this.jpz, ShareSdkView.this.jpD, ShareSdkView.this.jpA);
                    }
                } else if (ShareSdkView.this.jpz != ShareSdkView.this.jpB) {
                    ShareSdkView.this.jpz = ShareSdkView.this.jpB;
                    ShareSdkView.this.jpA = ShareSdkView.this.jpB;
                    ShareSdkView.this.jpu.setPadding(ShareSdkView.this.jpD, ShareSdkView.this.jpz, ShareSdkView.this.jpD, ShareSdkView.this.jpA);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.jpE = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bjN) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.jpx && bc.cZ(getContext())) {
            String obj = this.jpu.getText().toString();
            if (this.jpE != null) {
                this.jpE.Eu(obj);
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
        this.jps.setText(String.format(getResources().getString(d.j.share_sdk_forum), cVar.jpn));
        this.bNV.startLoad(cVar.jpm, 10, false);
        this.bNW.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.mContentView.setVisibility(8);
        } else {
            this.mContentView.setText(cVar.content);
        }
        this.eEI.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.eEI.getLayoutParams();
                layoutParams.height = ((l.aO(ShareSdkView.this.getContext()) - l.h(ShareSdkView.this.getContext(), d.e.tbds408)) * 9) / 16;
                ShareSdkView.this.eEI.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.eEI.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.jpE = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.l(this, d.C0277d.black_alpha30);
            al.k(this.mRootView, d.f.share_sdk_bg);
            al.j(this.jps, d.C0277d.cp_cont_b);
            al.l(this.jpt, d.C0277d.cp_bg_line_e);
            this.bNV.setBorderColor(al.getColor(d.C0277d.cp_cont_g));
            this.bNV.setIsNight(this.mSkinType == 1);
            al.j(this.bNW, d.C0277d.cp_cont_f);
            al.j(this.mContentView, d.C0277d.cp_cont_b);
            this.eEI.setIsNight(this.mSkinType == 1);
            this.jpu.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
            this.jpu.setTextColor(al.getColor(d.C0277d.cp_cont_b));
            al.k(this.jpu, d.f.share_sdk_input_shape_bg);
            al.l(this.jpv, d.C0277d.cp_bg_line_c);
            al.j(this.bjN, d.C0277d.cp_cont_b);
            al.l(this.jpw, d.C0277d.cp_bg_line_c);
            al.j(this.jpx, d.C0277d.cp_link_tip_a);
        }
    }
}
