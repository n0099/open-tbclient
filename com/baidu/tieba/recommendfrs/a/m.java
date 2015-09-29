package com.baidu.tieba.recommendfrs.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class m {
    private boolean alM = true;
    private CoverFlowView<com.baidu.tieba.recommendfrs.data.a> cJv;
    private TextView cJw;

    public m(Context context) {
        this.cJv = new CoverFlowView<>(context);
        this.cJv.setDisableParentEvent(true);
        this.cJv.setCoverFlowFactory(new n(this));
        this.cJw = aN(context);
        this.cJv.addView(this.cJw, 1, new FrameLayout.LayoutParams(-1, -2, 80));
    }

    private TextView aN(Context context) {
        TextView textView = new TextView(context);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, context.getResources().getDimensionPixelSize(i.d.ds76)));
        textView.setGravity(16);
        textView.setTextSize(0, context.getResources().getDimensionPixelSize(i.d.fontsize36));
        textView.setPadding(context.getResources().getDimensionPixelSize(i.d.ds30), context.getResources().getDimensionPixelSize(i.d.ds22), 0, context.getResources().getDimensionPixelSize(i.d.ds18));
        textView.setSingleLine(true);
        am.i((View) textView, i.e.recommend_frs_header_title_bg);
        am.b(textView, i.c.cp_cont_g, 1);
        return textView;
    }

    public void a(com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.recommendfrs.data.a> dVar) {
        if (this.cJv != null) {
            this.cJv.setCallback(dVar);
        }
    }

    public void setTitle(String str) {
        if (this.cJw != null) {
            this.cJw.setText(str);
        }
    }

    public com.baidu.tieba.recommendfrs.data.a kq(int i) {
        if (i < 0) {
            return null;
        }
        return this.cJv.bW(i);
    }

    public void setData(List<com.baidu.tieba.recommendfrs.data.a> list) {
        if (list != null && list.size() > 0) {
            if (!this.alM) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.recommendfrs.data.a aVar : list) {
                    com.baidu.tieba.recommendfrs.data.a clone = aVar.clone();
                    clone.kX(null);
                    arrayList.add(clone);
                }
                list = arrayList;
            }
            if (list.size() > 5) {
                list = list.subList(0, 4);
            }
            if (this.cJv != null) {
                this.cJv.setData(list);
            }
        }
    }

    public View getView() {
        return this.cJv;
    }

    public void e(TbPageContext<?> tbPageContext) {
        am.i((View) this.cJw, i.e.recommend_frs_header_title_bg);
        am.b(this.cJw, i.c.cp_cont_g, 1);
        if (this.cJv != null) {
            this.cJv.tc();
        }
    }
}
