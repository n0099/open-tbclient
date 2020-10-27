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
    private TextView cGd;
    private TextView dZY;
    private HeadImageView eLv;
    private TextView eLw;
    private EditText fYS;
    private TbImageView iht;
    private View kwE;
    private TextView lEz;
    private View mRootView;
    private int mSkinType;
    private View nCj;
    private View nCk;
    private TextView nCl;
    private int nCm;
    private int nCn;
    private int nCo;
    private int nCp;
    private int nCq;
    private int nCr;
    private a nCs;

    /* loaded from: classes3.dex */
    public interface a {
        void hI(String str);
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
        this.lEz = (TextView) findViewById(R.id.share_sdk_forum);
        this.nCj = findViewById(R.id.share_sdk_content_container);
        this.eLv = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.eLw = (TextView) findViewById(R.id.share_sdk_appname);
        this.cGd = (TextView) findViewById(R.id.share_sdk_content);
        this.iht = (TbImageView) findViewById(R.id.share_sdk_img);
        this.fYS = (EditText) findViewById(R.id.share_sdk_edit);
        this.kwE = findViewById(R.id.share_sdk_content_line);
        this.dZY = (TextView) findViewById(R.id.share_sdk_cancel);
        this.nCk = findViewById(R.id.share_sdk_action_line);
        this.nCl = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.dZY.setOnClickListener(this);
        this.nCl.setOnClickListener(this);
        this.eLv.setIsRound(true);
        this.eLv.setIsPreDrawBorder(true);
        this.eLv.setDrawBorder(true);
        this.eLv.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.eLv.setDefaultResource(R.color.cp_bg_line_e);
        this.eLv.setRadius(l.getDimens(context, R.dimen.ds70));
        this.iht.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.nCm = (l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds516)) / l.getDimens(getContext(), R.dimen.tbds45);
        this.nCp = l.getDimens(getContext(), R.dimen.tbds27);
        this.nCq = l.getDimens(getContext(), R.dimen.tbds11);
        this.nCr = l.getDimens(getContext(), R.dimen.tbds36);
        this.nCn = this.nCp;
        this.nCo = this.nCp;
        this.fYS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.share.ShareSdkView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > ShareSdkView.this.nCm * 2) {
                    if (ShareSdkView.this.nCn != 0) {
                        ShareSdkView.this.nCn = 0;
                        ShareSdkView.this.nCo = ShareSdkView.this.nCq;
                        ShareSdkView.this.fYS.setPadding(ShareSdkView.this.nCr, ShareSdkView.this.nCn, ShareSdkView.this.nCr, ShareSdkView.this.nCo);
                    }
                } else if (editable.length() > ShareSdkView.this.nCm) {
                    if (ShareSdkView.this.nCn != ShareSdkView.this.nCq) {
                        ShareSdkView.this.nCn = ShareSdkView.this.nCq;
                        ShareSdkView.this.nCo = ShareSdkView.this.nCq;
                        ShareSdkView.this.fYS.setPadding(ShareSdkView.this.nCr, ShareSdkView.this.nCn, ShareSdkView.this.nCr, ShareSdkView.this.nCo);
                    }
                } else if (ShareSdkView.this.nCn != ShareSdkView.this.nCp) {
                    ShareSdkView.this.nCn = ShareSdkView.this.nCp;
                    ShareSdkView.this.nCo = ShareSdkView.this.nCp;
                    ShareSdkView.this.fYS.setPadding(ShareSdkView.this.nCr, ShareSdkView.this.nCn, ShareSdkView.this.nCr, ShareSdkView.this.nCo);
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnShareListener(a aVar) {
        this.nCs = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dZY) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.nCl && bg.checkUpIsLogin(getContext())) {
            String obj = this.fYS.getText().toString();
            if (this.nCs != null) {
                this.nCs.hI(obj);
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
        this.lEz.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.nCe));
        this.eLv.startLoad(cVar.nCd, 10, false);
        this.eLw.setText(cVar.appName);
        if (StringUtils.isNull(cVar.content)) {
            this.cGd.setVisibility(8);
        } else {
            this.cGd.setText(cVar.content);
        }
        this.iht.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.write.share.ShareSdkView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                ViewGroup.LayoutParams layoutParams = ShareSdkView.this.iht.getLayoutParams();
                layoutParams.height = ((l.getEquipmentWidth(ShareSdkView.this.getContext()) - l.getDimens(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
                ShareSdkView.this.iht.setLayoutParams(layoutParams);
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.iht.startLoad(cVar.imageUrl, 42, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.nCs = null;
        super.onDetachedFromWindow();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.black_alpha30);
            ap.setBackgroundResource(this.mRootView, R.drawable.share_sdk_bg);
            ap.setViewTextColor(this.lEz, R.color.cp_cont_b);
            ap.setBackgroundColor(this.nCj, R.color.cp_bg_line_e);
            this.eLv.setBorderColor(ap.getColor(R.color.cp_cont_g));
            this.eLv.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.eLw, R.color.cp_cont_f);
            ap.setViewTextColor(this.cGd, R.color.cp_cont_b);
            this.iht.setIsNight(this.mSkinType == 1);
            this.fYS.setHintTextColor(ap.getColor(R.color.cp_cont_e));
            this.fYS.setTextColor(ap.getColor(R.color.cp_cont_b));
            ap.setBackgroundResource(this.fYS, R.drawable.share_sdk_input_shape_bg);
            ap.setBackgroundColor(this.kwE, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.dZY, R.color.cp_cont_b);
            ap.setBackgroundColor(this.nCk, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.nCl, R.color.cp_link_tip_a);
        }
    }
}
