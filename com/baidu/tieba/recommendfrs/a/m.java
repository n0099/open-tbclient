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
public class m {
    private boolean anu = true;
    private CoverFlowView<com.baidu.tieba.recommendfrs.data.a> cCu;
    private TextView cCv;

    public m(Context context) {
        this.cCu = new CoverFlowView<>(context);
        this.cCu.setDisableParentEvent(true);
        this.cCu.setCoverFlowFactory(new n(this));
        this.cCv = aO(context);
        this.cCu.addView(this.cCv, 1, new FrameLayout.LayoutParams(-1, -2, 80));
    }

    private TextView aO(Context context) {
        TextView textView = new TextView(context);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, context.getResources().getDimensionPixelSize(i.d.ds76)));
        textView.setGravity(16);
        textView.setTextSize(0, context.getResources().getDimensionPixelSize(i.d.fontsize36));
        textView.setPadding(context.getResources().getDimensionPixelSize(i.d.ds30), context.getResources().getDimensionPixelSize(i.d.ds22), 0, context.getResources().getDimensionPixelSize(i.d.ds18));
        textView.setSingleLine(true);
        al.h((View) textView, i.e.recommend_frs_header_title_bg);
        al.b(textView, i.c.cp_cont_g, 1);
        return textView;
    }

    public void a(com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.recommendfrs.data.a> dVar) {
        if (this.cCu != null) {
            this.cCu.setCallback(dVar);
        }
    }

    public void setTitle(String str) {
        if (this.cCv != null) {
            this.cCv.setText(str);
        }
    }

    public com.baidu.tieba.recommendfrs.data.a jR(int i) {
        if (i < 0) {
            return null;
        }
        return this.cCu.bW(i);
    }

    public void setData(List<com.baidu.tieba.recommendfrs.data.a> list) {
        if (list != null && list.size() > 0) {
            if (!this.anu) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.recommendfrs.data.a aVar : list) {
                    com.baidu.tieba.recommendfrs.data.a clone = aVar.clone();
                    clone.kz(null);
                    arrayList.add(clone);
                }
                list = arrayList;
            }
            if (list.size() > 5) {
                list = list.subList(0, 4);
            }
            if (this.cCu != null) {
                this.cCu.setData(list);
            }
        }
    }

    public View getView() {
        return this.cCu;
    }

    public void e(TbPageContext<?> tbPageContext) {
        al.h((View) this.cCv, i.e.recommend_frs_header_title_bg);
        al.b(this.cCv, i.c.cp_cont_g, 1);
        if (this.cCu != null) {
            this.cCu.tf();
        }
    }
}
