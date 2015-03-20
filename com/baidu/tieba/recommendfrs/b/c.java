package com.baidu.tieba.recommendfrs.b;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class c extends FrameLayout {
    private CoverFlowView<com.baidu.tieba.recommendfrs.data.a> bXZ;
    private TextView bYa;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        com.baidu.adp.lib.g.b.hH().inflate(getContext(), w.recommend_frs_header_view, this);
        this.bXZ = (CoverFlowView) findViewById(v.coverflowview);
        this.bXZ.setDisableParentEvent(false);
        this.bYa = (TextView) findViewById(v.covertitle);
        this.bXZ.setCoverFlowFactory(new d(this));
    }

    public void setCoverFlowViewCallBack(com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.recommendfrs.data.a> dVar) {
        this.bXZ.setCallback(dVar);
    }

    public void setTitle(String str) {
        this.bYa.setText(str);
    }

    public void setData(List<com.baidu.tieba.recommendfrs.data.a> list) {
        this.bXZ.setData(list);
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this);
        this.bXZ.rk();
    }
}
