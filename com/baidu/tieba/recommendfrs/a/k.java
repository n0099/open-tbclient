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
    private CoverFlowView<com.baidu.tieba.recommendfrs.data.a> ccA;
    private TextView ccB;
    private List<com.baidu.tieba.recommendfrs.data.a> ccC;
    private boolean ccg;

    public k(Context context) {
        this(context, null);
    }

    public k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ccg = true;
        init();
    }

    private void init() {
        com.baidu.adp.lib.g.b.hr().inflate(getContext(), r.recommend_frs_header_view, this);
        this.ccA = (CoverFlowView) findViewById(q.coverflowview);
        this.ccA.setDisableParentEvent(false);
        this.ccB = (TextView) findViewById(q.covertitle);
        this.ccA.setCoverFlowFactory(new l(this));
    }

    public void setIsShowImage(boolean z) {
        this.ccg = z;
        setData(this.ccC);
    }

    public void setCoverFlowViewCallBack(com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.recommendfrs.data.a> dVar) {
        this.ccA.setCallback(dVar);
    }

    public void setTitle(String str) {
        this.ccB.setText(str);
    }

    public com.baidu.tieba.recommendfrs.data.a io(int i) {
        if (i < 0) {
            return null;
        }
        return this.ccA.bL(i);
    }

    public void setData(List<com.baidu.tieba.recommendfrs.data.a> list) {
        if (list != null && list.size() > 0) {
            this.ccC = new ArrayList(list);
            if (!this.ccg) {
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
            this.ccA.setData(list);
        }
    }

    public void d(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this);
        this.ccA.rU();
    }
}
