package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class FrsOfficalBanner extends LinearLayout {
    private com.baidu.tbadk.coreExtra.view.b adO;
    View.OnClickListener adP;
    private TextView ckJ;
    private LinearLayout ckK;
    private Context mContext;

    public FrsOfficalBanner(Context context) {
        super(context);
        this.adP = new p(this);
        init(context);
    }

    public FrsOfficalBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adP = new p(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.hH().inflate(context, com.baidu.tieba.w.frs_offical_banner_view, this);
        this.ckK = (LinearLayout) findViewById(com.baidu.tieba.v.banner_parent);
        this.ckJ = (TextView) findViewById(com.baidu.tieba.v.tv_text);
        this.ckK.setOnClickListener(this.adP);
    }

    public void setText(String str) {
        this.ckJ.setText(str);
    }

    public void setBannerViewClickListener(com.baidu.tbadk.coreExtra.view.b bVar) {
        this.adO = bVar;
    }
}
