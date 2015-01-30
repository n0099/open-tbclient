package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class FrsOfficalBanner extends LinearLayout {
    private com.baidu.tbadk.coreExtra.view.b TP;
    View.OnClickListener TQ;
    private TextView bUq;
    private LinearLayout bUr;
    private Context mContext;

    public FrsOfficalBanner(Context context) {
        super(context);
        this.TQ = new p(this);
        init(context);
    }

    public FrsOfficalBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TQ = new p(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.ei().inflate(context, com.baidu.tieba.x.frs_offical_banner_view, this);
        this.bUr = (LinearLayout) findViewById(com.baidu.tieba.w.banner_parent);
        this.bUq = (TextView) findViewById(com.baidu.tieba.w.tv_text);
        this.bUr.setOnClickListener(this.TQ);
    }

    public void setText(String str) {
        this.bUq.setText(str);
    }

    public void setBannerViewClickListener(com.baidu.tbadk.coreExtra.view.b bVar) {
        this.TP = bVar;
    }
}
