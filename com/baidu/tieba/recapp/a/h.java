package com.baidu.tieba.recapp.a;

import android.view.View;
import com.baidu.adp.base.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.data.n;
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private static h dhP;

    public static final h avS() {
        if (dhP != null) {
            return dhP;
        }
        synchronized (h.class) {
            if (dhP == null) {
                dhP = new h();
            }
        }
        return dhP;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof BaseAppViewHolder) {
                n appData = ((BaseAppViewHolder) tag).getAppData();
                if (!ax.isEmpty(appData.aCS().url)) {
                    com.baidu.tbadk.distribute.a.Bf().a(view.getContext(), appData.aCX(), "area_click", "pb", appData.dzx, appData.threadId);
                    com.baidu.tbadk.distribute.a.Bf().a(appData.aCX(), appData.dzx, appData.threadId, "PB", "click", appData.pageNumber);
                    com.baidu.tieba.recapp.report.b.avU().a(com.baidu.tieba.recapp.report.e.a(appData, "click"));
                    bf.vD().a((TbPageContext) l.C(view.getContext()), new String[]{appData.aCS().url}, true);
                }
            }
        }
    }
}
