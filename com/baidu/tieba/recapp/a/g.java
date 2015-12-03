package com.baidu.tieba.recapp.a;

import android.view.View;
import com.baidu.adp.base.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.data.n;
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    private static g dhO;

    public static final g avR() {
        if (dhO != null) {
            return dhO;
        }
        synchronized (g.class) {
            if (dhO == null) {
                dhO = new g();
            }
        }
        return dhO;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof BaseAppViewHolder) {
                n appData = ((BaseAppViewHolder) tag).getAppData();
                if (!ax.isEmpty(appData.aCS().url)) {
                    com.baidu.tbadk.distribute.a.Bf().a(view.getContext(), appData.aCX(), "btn_click", "pb", appData.dzx, appData.threadId);
                    com.baidu.tbadk.distribute.a.Bf().a(appData.aCX(), appData.dzx, appData.threadId, "PB", "click", appData.pageNumber);
                    com.baidu.tieba.recapp.report.b.avU().a(com.baidu.tieba.recapp.report.e.a(appData, "click"));
                    bf.vD().a((TbPageContext) l.C(view.getContext()), new String[]{appData.aCS().url}, true);
                }
            }
        }
    }
}
