package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class FrsOfficalBanner extends LinearLayout {
    private com.baidu.tbadk.coreExtra.view.b afa;
    View.OnClickListener afb;
    private TextView cpa;
    private LinearLayout cpb;
    private Context mContext;

    public FrsOfficalBanner(Context context) {
        super(context);
        this.afb = new p(this);
        init(context);
    }

    public FrsOfficalBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afb = new p(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.hr().inflate(context, com.baidu.tieba.r.frs_offical_banner_view, this);
        this.cpb = (LinearLayout) findViewById(com.baidu.tieba.q.banner_parent);
        this.cpa = (TextView) findViewById(com.baidu.tieba.q.tv_text);
        this.cpb.setOnClickListener(this.afb);
    }

    public void setText(String str) {
        this.cpa.setText(str);
    }

    public void setBannerViewClickListener(com.baidu.tbadk.coreExtra.view.b bVar) {
        this.afa = bVar;
    }
}
