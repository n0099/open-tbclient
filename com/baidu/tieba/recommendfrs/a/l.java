package com.baidu.tieba.recommendfrs.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l {
    private CoverFlowView<com.baidu.tieba.recommendfrs.data.a> ctY;
    private TextView ctZ;
    private boolean cti = true;

    public l(Context context) {
        this.ctY = new CoverFlowView<>(context);
        this.ctY.setDisableParentEvent(true);
        this.ctY.setCoverFlowFactory(new m(this));
        this.ctZ = aL(context);
        this.ctY.addView(this.ctZ, 1, new FrameLayout.LayoutParams(-1, -2, 80));
    }

    private TextView aL(Context context) {
        TextView textView = new TextView(context);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, context.getResources().getDimensionPixelSize(i.d.ds76)));
        textView.setGravity(16);
        textView.setTextSize(0, context.getResources().getDimensionPixelSize(i.d.fontsize36));
        textView.setPadding(context.getResources().getDimensionPixelSize(i.d.ds30), context.getResources().getDimensionPixelSize(i.d.ds22), 0, context.getResources().getDimensionPixelSize(i.d.ds18));
        textView.setSingleLine(true);
        al.i((View) textView, i.e.recommend_frs_header_title_bg);
        al.b(textView, i.c.cp_cont_g, 1);
        return textView;
    }

    public void a(com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.recommendfrs.data.a> dVar) {
        if (this.ctY != null) {
            this.ctY.setCallback(dVar);
        }
    }

    public void setTitle(String str) {
        if (this.ctZ != null) {
            this.ctZ.setText(str);
        }
    }

    public com.baidu.tieba.recommendfrs.data.a jh(int i) {
        if (i < 0) {
            return null;
        }
        return this.ctY.bT(i);
    }

    public void setData(List<com.baidu.tieba.recommendfrs.data.a> list) {
        if (list != null && list.size() > 0) {
            if (!this.cti) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.recommendfrs.data.a aVar : list) {
                    com.baidu.tieba.recommendfrs.data.a clone = aVar.clone();
                    clone.jU(null);
                    arrayList.add(clone);
                }
                list = arrayList;
            }
            if (list.size() > 5) {
                list = list.subList(0, 4);
            }
            if (this.ctY != null) {
                this.ctY.setData(list);
            }
        }
    }

    public View getView() {
        return this.ctY;
    }

    public void e(TbPageContext<?> tbPageContext) {
        al.i((View) this.ctZ, i.e.recommend_frs_header_title_bg);
        al.b(this.ctZ, i.c.cp_cont_g, 1);
        if (this.ctY != null) {
            this.ctY.ta();
        }
    }
}
