package com.baidu.tieba.recommendfrs.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class m {
    private boolean alS = true;
    private CoverFlowView<com.baidu.tieba.recommendfrs.data.a> cLq;
    private TextView cLr;

    public m(Context context) {
        this.cLq = new CoverFlowView<>(context);
        this.cLq.setDisableParentEvent(true);
        this.cLq.setCoverFlowFactory(new n(this));
        this.cLr = aM(context);
        this.cLq.addView(this.cLr, 1, new FrameLayout.LayoutParams(-1, -2, 80));
    }

    private TextView aM(Context context) {
        TextView textView = new TextView(context);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, context.getResources().getDimensionPixelSize(i.d.ds76)));
        textView.setGravity(16);
        textView.setTextSize(0, context.getResources().getDimensionPixelSize(i.d.fontsize36));
        textView.setPadding(context.getResources().getDimensionPixelSize(i.d.ds30), context.getResources().getDimensionPixelSize(i.d.ds22), 0, context.getResources().getDimensionPixelSize(i.d.ds18));
        textView.setSingleLine(true);
        an.i((View) textView, i.e.recommend_frs_header_title_bg);
        an.b(textView, i.c.cp_cont_g, 1);
        return textView;
    }

    public void a(com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.recommendfrs.data.a> dVar) {
        if (this.cLq != null) {
            this.cLq.setCallback(dVar);
        }
    }

    public void setTitle(String str) {
        if (this.cLr != null) {
            this.cLr.setText(str);
        }
    }

    public com.baidu.tieba.recommendfrs.data.a kG(int i) {
        if (i < 0) {
            return null;
        }
        return this.cLq.bW(i);
    }

    public void setData(List<com.baidu.tieba.recommendfrs.data.a> list) {
        if (list != null && list.size() > 0) {
            if (!this.alS) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.recommendfrs.data.a aVar : list) {
                    com.baidu.tieba.recommendfrs.data.a clone = aVar.clone();
                    clone.le(null);
                    arrayList.add(clone);
                }
                list = arrayList;
            }
            if (list.size() > 5) {
                list = list.subList(0, 4);
            }
            if (this.cLq != null) {
                this.cLq.setData(list);
            }
        }
    }

    public View getView() {
        return this.cLq;
    }

    public void e(TbPageContext<?> tbPageContext) {
        an.i((View) this.cLr, i.e.recommend_frs_header_title_bg);
        an.b(this.cLr, i.c.cp_cont_g, 1);
        if (this.cLq != null) {
            this.cLq.tc();
        }
    }
}
