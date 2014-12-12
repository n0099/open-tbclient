package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class FrsOfficalBanner extends LinearLayout {
    private com.baidu.tbadk.coreExtra.view.b Tl;
    private TextView bSx;
    private LinearLayout bSy;
    private Context mContext;
    View.OnClickListener onClickListener;

    public FrsOfficalBanner(Context context) {
        super(context);
        this.onClickListener = new p(this);
        init(context);
    }

    public FrsOfficalBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onClickListener = new p(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.x.frs_offical_banner_view, this);
        this.bSy = (LinearLayout) findViewById(com.baidu.tieba.w.banner_parent);
        this.bSx = (TextView) findViewById(com.baidu.tieba.w.tv_text);
        this.bSy.setOnClickListener(this.onClickListener);
    }

    public void setText(String str) {
        this.bSx.setText(str);
    }

    public void setBannerViewClickListener(com.baidu.tbadk.coreExtra.view.b bVar) {
        this.Tl = bVar;
    }
}
