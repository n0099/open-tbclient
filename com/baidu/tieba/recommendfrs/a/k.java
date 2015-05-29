package com.baidu.tieba.recommendfrs.a;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k extends FrameLayout {
    private TextView ccA;
    private List<com.baidu.tieba.recommendfrs.data.a> ccB;
    private boolean ccf;
    private CoverFlowView<com.baidu.tieba.recommendfrs.data.a> ccz;

    public k(Context context) {
        this(context, null);
    }

    public k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ccf = true;
        init();
    }

    private void init() {
        com.baidu.adp.lib.g.b.hr().inflate(getContext(), r.recommend_frs_header_view, this);
        this.ccz = (CoverFlowView) findViewById(q.coverflowview);
        this.ccz.setDisableParentEvent(false);
        this.ccA = (TextView) findViewById(q.covertitle);
        this.ccz.setCoverFlowFactory(new l(this));
    }

    public void setIsShowImage(boolean z) {
        this.ccf = z;
        setData(this.ccB);
    }

    public void setCoverFlowViewCallBack(com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.recommendfrs.data.a> dVar) {
        this.ccz.setCallback(dVar);
    }

    public void setTitle(String str) {
        this.ccA.setText(str);
    }

    public com.baidu.tieba.recommendfrs.data.a io(int i) {
        if (i < 0) {
            return null;
        }
        return this.ccz.bL(i);
    }

    public void setData(List<com.baidu.tieba.recommendfrs.data.a> list) {
        if (list != null && list.size() > 0) {
            this.ccB = new ArrayList(list);
            if (!this.ccf) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.recommendfrs.data.a aVar : list) {
                    if (aVar != null) {
                        com.baidu.tieba.recommendfrs.data.a clone = aVar.clone();
                        clone.iZ(null);
                        arrayList.add(clone);
                    }
                }
                list = arrayList;
            }
            if (list.size() > 5) {
                list = list.subList(0, 4);
            }
            this.ccz.setData(list);
        }
    }

    public void d(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this);
        this.ccz.rU();
    }
}
