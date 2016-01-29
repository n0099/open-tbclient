package com.baidu.tieba.recapp.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.base.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.data.q;
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private static h dCy;

    public static final h aEI() {
        if (dCy != null) {
            return dCy;
        }
        synchronized (h.class) {
            if (dCy == null) {
                dCy = new h();
            }
        }
        return dCy;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof BaseAppViewHolder) {
                q appData = ((BaseAppViewHolder) tag).getAppData();
                if (!aw.isEmpty(appData.aMl().url)) {
                    a(view.getContext(), appData);
                    be.wt().a((TbPageContext) l.C(view.getContext()), new String[]{appData.aMl().url}, true);
                }
            }
        }
    }

    private void a(Context context, q qVar) {
        if (qVar != null) {
            com.baidu.tbadk.distribute.a.Cl().a(context, qVar.aMq(), "area_click", "pb", qVar.dWW, qVar.threadId);
            com.baidu.tbadk.distribute.a.Cl().a(qVar.aMq(), qVar.dWW, qVar.threadId, "PB", "click", qVar.pageNumber);
            com.baidu.tieba.recapp.report.b.aEK().a(com.baidu.tieba.recapp.report.e.a(qVar, "click"));
        }
    }
}
