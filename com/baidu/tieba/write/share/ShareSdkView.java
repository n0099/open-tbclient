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
    private int hLA;
    private int hLB;
    private int hLC;
    private int hLD;
    private int hLE;
    private int hLF;
    private a hLG;
    private TextView hLu;
    private View hLv;
    private EditText hLw;
    private View hLx;
    private View hLy;
    private TextView hLz;
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
        this.hLu = (TextView) findViewById(e.g.share_sdk_forum);
        this.hLv = findViewById(e.g.share_sdk_content_container);
        this.aAX = (HeadImageView) findViewById(e.g.share_sdk_appicon);
        this.aAY = (TextView) findViewById(e.g.share_sdk_appname);
        this.mContentView = (TextView) findViewById(e.g.share_sdk_content);
        this.dGG = (TbImageView) findViewById(e.g.share_sdk_img);
        this.hLw = (EditText) findViewById(e.g.share_sdk_edit);
        this.hLx = findViewById(e.g.share_sdk_content_line);
        this.mCancelView = (TextView) findViewById(e.g.share_sdk_cancel);
        this.hLy = findViewById(e.g.share_sdk_action_line);
        this.hLz = (TextView) findViewById(e.g.share_sdk_share);
        setOnClickListener(this);
        this.mCancelView.setOnClickListener(this);
        this.hLz.setOnClickListener(this);
        this.aAX.setIsRound(true);
        this.aAX.setIsPreDrawBorder(true);
        this.aAX.setDrawBorder(true);
        this.aAX.setBorderWidth(l.h(context, e.C0175e.tbds1));
        this.aAX.setDefaultResource(e.d.cp_bg_line_e);
        this.aAX.setRadius(l.h(context, e.C0175e.ds70));
        this.dGG.setDefaultBgResource(e.f.pic_share_default_applets);
        this.hLA = (l.aO(getContext()) - l.h(getContext(), e.C0175e.tbds516)) / l.h(getContext(), e.C0175e.tbds45);
        this.hLD = l.h(getContext(), e.C0175e.tbds27);
        this.hLE = l.h(getContext(), e.C0175e.tbds11);
        this.hLF = l.h(getContext(), e.C0175e.tbds36);
        this.hLB = this.hLD;
        this.hLC = this.hLD;
        this.hLw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.hLA * 2) {
                    if (ShareSdkView.this.hLB != 0) {
                        ShareSdkView.this.hLB = 0;
                        ShareSdkView.this.hLC = ShareSdkView.this.hLE;
                        ShareSdkView.this.hLw.setPadding(ShareSdkView.this.hLF, ShareSdkView.this.hLB, ShareSdkView.this.hLF, ShareSdkView.this.hLC);
                    }
                } else if (editable.length() > ShareSdkView.this.hLA) {
                    if (ShareSdkView.this.hLB != ShareSdkView.this.hLE) {
                        ShareSdkView.this.hLB = ShareSdkView.this.hLE;
                        ShareSdkView.this.hLC = ShareSdkView.this.hLE;
                        ShareSdkView.this.hLw.setPadding(ShareSdkView.this.hLF, ShareSdkView.this.hLB, ShareSdkView.this.hLF, ShareSdkView.this.hLC);
                    }
                } else if (ShareSdkView.this.hLB != ShareSdkView.this.hLD) {
                    ShareSdkView.this.hLB = ShareSdkView.this.hLD;
                    ShareSdkView.this.hLC = ShareSdkView.this.hLD;
                    ShareSdkView.this.hLw.setPadding(ShareSdkView.this.hLF, ShareSdkView.this.hLB, ShareSdkView.this.hLF, ShareSdkView.this.hLC);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.hLG = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mCancelView) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.hLz && ba.bI(getContext())) {
            String obj = this.hLw.getText().toString();
            if (this.hLG != null) {
                this.hLG.wV(obj);
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
        this.hLu.setText(String.format(getResources().getString(e.j.share_sdk_forum), cVar.hLp));
        this.aAX.startLoad(cVar.hLo, 10, false);
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
        this.hLG = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.j(this, e.d.black_alpha30);
            al.i(this.mRootView, e.f.share_sdk_bg);
            al.h(this.hLu, e.d.cp_cont_b);
            al.j(this.hLv, e.d.cp_bg_line_e);
            this.aAX.setBorderColor(al.getColor(e.d.cp_cont_g));
            this.aAX.setIsNight(this.mSkinType == 1);
            al.h(this.aAY, e.d.cp_cont_f);
            al.h(this.mContentView, e.d.cp_cont_b);
            this.dGG.setIsNight(this.mSkinType == 1);
            this.hLw.setHintTextColor(al.getColor(e.d.cp_cont_e));
            this.hLw.setTextColor(al.getColor(e.d.cp_cont_b));
            al.i(this.hLw, e.f.share_sdk_input_shape_bg);
            al.j(this.hLx, e.d.cp_bg_line_c);
            al.h(this.mCancelView, e.d.cp_cont_b);
            al.j(this.hLy, e.d.cp_bg_line_c);
            al.h(this.hLz, e.d.cp_link_tip_a);
        }
    }
}
