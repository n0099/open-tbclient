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
    private HeadImageView aAX;
    private TextView aAY;
    private TbImageView dGG;
    private TextView hLA;
    private int hLB;
    private int hLC;
    private int hLD;
    private int hLE;
    private int hLF;
    private int hLG;
    private a hLH;
    private TextView hLv;
    private View hLw;
    private EditText hLx;
    private View hLy;
    private View hLz;
    private TextView mCancelView;
    private TextView mContentView;
    private View mRootView;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void wV(String str);
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
        this.hLv = (TextView) findViewById(e.g.share_sdk_forum);
        this.hLw = findViewById(e.g.share_sdk_content_container);
        this.aAX = (HeadImageView) findViewById(e.g.share_sdk_appicon);
        this.aAY = (TextView) findViewById(e.g.share_sdk_appname);
        this.mContentView = (TextView) findViewById(e.g.share_sdk_content);
        this.dGG = (TbImageView) findViewById(e.g.share_sdk_img);
        this.hLx = (EditText) findViewById(e.g.share_sdk_edit);
        this.hLy = findViewById(e.g.share_sdk_content_line);
        this.mCancelView = (TextView) findViewById(e.g.share_sdk_cancel);
        this.hLz = findViewById(e.g.share_sdk_action_line);
        this.hLA = (TextView) findViewById(e.g.share_sdk_share);
        setOnClickListener(this);
        this.mCancelView.setOnClickListener(this);
        this.hLA.setOnClickListener(this);
        this.aAX.setIsRound(true);
        this.aAX.setIsPreDrawBorder(true);
        this.aAX.setDrawBorder(true);
        this.aAX.setBorderWidth(l.h(context, e.C0175e.tbds1));
        this.aAX.setDefaultResource(e.d.cp_bg_line_e);
        this.aAX.setRadius(l.h(context, e.C0175e.ds70));
        this.dGG.setDefaultBgResource(e.f.pic_share_default_applets);
        this.hLB = (l.aO(getContext()) - l.h(getContext(), e.C0175e.tbds516)) / l.h(getContext(), e.C0175e.tbds45);
        this.hLE = l.h(getContext(), e.C0175e.tbds27);
        this.hLF = l.h(getContext(), e.C0175e.tbds11);
        this.hLG = l.h(getContext(), e.C0175e.tbds36);
        this.hLC = this.hLE;
        this.hLD = this.hLE;
        this.hLx.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.hLB * 2) {
                    if (ShareSdkView.this.hLC != 0) {
                        ShareSdkView.this.hLC = 0;
                        ShareSdkView.this.hLD = ShareSdkView.this.hLF;
                        ShareSdkView.this.hLx.setPadding(ShareSdkView.this.hLG, ShareSdkView.this.hLC, ShareSdkView.this.hLG, ShareSdkView.this.hLD);
                    }
                } else if (editable.length() > ShareSdkView.this.hLB) {
                    if (ShareSdkView.this.hLC != ShareSdkView.this.hLF) {
                        ShareSdkView.this.hLC = ShareSdkView.this.hLF;
                        ShareSdkView.this.hLD = ShareSdkView.this.hLF;
                        ShareSdkView.this.hLx.setPadding(ShareSdkView.this.hLG, ShareSdkView.this.hLC, ShareSdkView.this.hLG, ShareSdkView.this.hLD);
                    }
                } else if (ShareSdkView.this.hLC != ShareSdkView.this.hLE) {
                    ShareSdkView.this.hLC = ShareSdkView.this.hLE;
                    ShareSdkView.this.hLD = ShareSdkView.this.hLE;
                    ShareSdkView.this.hLx.setPadding(ShareSdkView.this.hLG, ShareSdkView.this.hLC, ShareSdkView.this.hLG, ShareSdkView.this.hLD);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.hLH = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mCancelView) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.hLA && ba.bI(getContext())) {
            String obj = this.hLx.getText().toString();
            if (this.hLH != null) {
                this.hLH.wV(obj);
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
        this.hLv.setText(String.format(getResources().getString(e.j.share_sdk_forum), cVar.hLq));
        this.aAX.startLoad(cVar.hLp, 10, false);
        this.aAY.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.mContentView.setVisibility(8);
        } else {
            this.mContentView.setText(cVar.content);
        }
        this.dGG.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.dGG.getLayoutParams();
                layoutParams.height = ((l.aO(ShareSdkView.this.getContext()) - l.h(ShareSdkView.this.getContext(), e.C0175e.tbds408)) * 9) / 16;
                ShareSdkView.this.dGG.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.dGG.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.hLH = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.j(this, e.d.black_alpha30);
            al.i(this.mRootView, e.f.share_sdk_bg);
            al.h(this.hLv, e.d.cp_cont_b);
            al.j(this.hLw, e.d.cp_bg_line_e);
            this.aAX.setBorderColor(al.getColor(e.d.cp_cont_g));
            this.aAX.setIsNight(this.mSkinType == 1);
            al.h(this.aAY, e.d.cp_cont_f);
            al.h(this.mContentView, e.d.cp_cont_b);
            this.dGG.setIsNight(this.mSkinType == 1);
            this.hLx.setHintTextColor(al.getColor(e.d.cp_cont_e));
            this.hLx.setTextColor(al.getColor(e.d.cp_cont_b));
            al.i(this.hLx, e.f.share_sdk_input_shape_bg);
            al.j(this.hLy, e.d.cp_bg_line_c);
            al.h(this.mCancelView, e.d.cp_cont_b);
            al.j(this.hLz, e.d.cp_bg_line_c);
            al.h(this.hLA, e.d.cp_link_tip_a);
        }
    }
}
