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
    private HeadImageView awm;
    private TextView awn;
    private TextView cMm;
    private TbImageView dyG;
    private TextView hEi;
    private View hEj;
    private EditText hEk;
    private View hEl;
    private View hEm;
    private TextView hEn;
    private int hEo;
    private int hEp;
    private int hEq;
    private int hEr;
    private int hEs;
    private int hEt;
    private a hEu;
    private TextView mContentView;
    private View mRootView;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void wu(String str);
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
        this.hEi = (TextView) findViewById(e.g.share_sdk_forum);
        this.hEj = findViewById(e.g.share_sdk_content_container);
        this.awm = (HeadImageView) findViewById(e.g.share_sdk_appicon);
        this.awn = (TextView) findViewById(e.g.share_sdk_appname);
        this.mContentView = (TextView) findViewById(e.g.share_sdk_content);
        this.dyG = (TbImageView) findViewById(e.g.share_sdk_img);
        this.hEk = (EditText) findViewById(e.g.share_sdk_edit);
        this.hEl = findViewById(e.g.share_sdk_content_line);
        this.cMm = (TextView) findViewById(e.g.share_sdk_cancel);
        this.hEm = findViewById(e.g.share_sdk_action_line);
        this.hEn = (TextView) findViewById(e.g.share_sdk_share);
        setOnClickListener(this);
        this.cMm.setOnClickListener(this);
        this.hEn.setOnClickListener(this);
        this.awm.setIsRound(true);
        this.awm.setIsPreDrawBorder(true);
        this.awm.setDrawBorder(true);
        this.awm.setBorderWidth(l.h(context, e.C0141e.tbds1));
        this.awm.setDefaultResource(e.d.cp_bg_line_e);
        this.awm.setRadius(l.h(context, e.C0141e.ds70));
        this.dyG.setDefaultBgResource(e.f.pic_share_default_applets);
        this.hEo = (l.aO(getContext()) - l.h(getContext(), e.C0141e.tbds516)) / l.h(getContext(), e.C0141e.tbds45);
        this.hEr = l.h(getContext(), e.C0141e.tbds27);
        this.hEs = l.h(getContext(), e.C0141e.tbds11);
        this.hEt = l.h(getContext(), e.C0141e.tbds36);
        this.hEp = this.hEr;
        this.hEq = this.hEr;
        this.hEk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.hEo * 2) {
                    if (ShareSdkView.this.hEp != 0) {
                        ShareSdkView.this.hEp = 0;
                        ShareSdkView.this.hEq = ShareSdkView.this.hEs;
                        ShareSdkView.this.hEk.setPadding(ShareSdkView.this.hEt, ShareSdkView.this.hEp, ShareSdkView.this.hEt, ShareSdkView.this.hEq);
                    }
                } else if (editable.length() > ShareSdkView.this.hEo) {
                    if (ShareSdkView.this.hEp != ShareSdkView.this.hEs) {
                        ShareSdkView.this.hEp = ShareSdkView.this.hEs;
                        ShareSdkView.this.hEq = ShareSdkView.this.hEs;
                        ShareSdkView.this.hEk.setPadding(ShareSdkView.this.hEt, ShareSdkView.this.hEp, ShareSdkView.this.hEt, ShareSdkView.this.hEq);
                    }
                } else if (ShareSdkView.this.hEp != ShareSdkView.this.hEr) {
                    ShareSdkView.this.hEp = ShareSdkView.this.hEr;
                    ShareSdkView.this.hEq = ShareSdkView.this.hEr;
                    ShareSdkView.this.hEk.setPadding(ShareSdkView.this.hEt, ShareSdkView.this.hEp, ShareSdkView.this.hEt, ShareSdkView.this.hEq);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.hEu = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cMm) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.hEn && ba.bA(getContext())) {
            String obj = this.hEk.getText().toString();
            if (this.hEu != null) {
                this.hEu.wu(obj);
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
        this.hEi.setText(String.format(getResources().getString(e.j.share_sdk_forum), cVar.hEd));
        this.awm.startLoad(cVar.hEc, 10, false);
        this.awn.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.mContentView.setVisibility(8);
        } else {
            this.mContentView.setText(cVar.content);
        }
        this.dyG.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void k(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.dyG.getLayoutParams();
                layoutParams.height = ((l.aO(ShareSdkView.this.getContext()) - l.h(ShareSdkView.this.getContext(), e.C0141e.tbds408)) * 9) / 16;
                ShareSdkView.this.dyG.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.dyG.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.hEu = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.j(this, e.d.black_alpha30);
            al.i(this.mRootView, e.f.share_sdk_bg);
            al.h(this.hEi, e.d.cp_cont_b);
            al.j(this.hEj, e.d.cp_bg_line_e);
            this.awm.setBorderColor(al.getColor(e.d.cp_cont_g));
            this.awm.setIsNight(this.mSkinType == 1);
            al.h(this.awn, e.d.cp_cont_f);
            al.h(this.mContentView, e.d.cp_cont_b);
            this.dyG.setIsNight(this.mSkinType == 1);
            this.hEk.setHintTextColor(al.getColor(e.d.cp_cont_e));
            this.hEk.setTextColor(al.getColor(e.d.cp_cont_b));
            al.i(this.hEk, e.f.share_sdk_input_shape_bg);
            al.j(this.hEl, e.d.cp_bg_line_c);
            al.h(this.cMm, e.d.cp_cont_b);
            al.j(this.hEm, e.d.cp_bg_line_c);
            al.h(this.hEn, e.d.cp_link_tip_a);
        }
    }
}
