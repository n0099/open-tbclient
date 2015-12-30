package com.baidu.tieba.recapp.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.base.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.data.q;
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private static h dnv;

    public static final h axL() {
        if (dnv != null) {
            return dnv;
        }
        synchronized (h.class) {
            if (dnv == null) {
                dnv = new h();
            }
        }
        return dnv;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof BaseAppViewHolder) {
                q appData = ((BaseAppViewHolder) tag).getAppData();
                if (!ax.isEmpty(appData.aFf().url)) {
                    a(view.getContext(), appData);
                    bf.vn().a((TbPageContext) l.C(view.getContext()), new String[]{appData.aFf().url}, true);
                }
            }
        }
    }

    private void a(Context context, q qVar) {
        if (qVar != null) {
            com.baidu.tbadk.distribute.a.AV().a(context, qVar.aFk(), "area_click", "pb", qVar.dHa, qVar.threadId);
            com.baidu.tbadk.distribute.a.AV().a(qVar.aFk(), qVar.dHa, qVar.threadId, "PB", "click", qVar.pageNumber);
            com.baidu.tieba.recapp.report.b.axN().a(com.baidu.tieba.recapp.report.e.a(qVar, "click"));
        }
    }
}
