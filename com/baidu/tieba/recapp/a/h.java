package com.baidu.tieba.recapp.a;

import android.view.View;
import com.baidu.adp.base.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.c.i;
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private static h bXr;

    public static final h afs() {
        if (bXr != null) {
            return bXr;
        }
        synchronized (h.class) {
            if (bXr == null) {
                bXr = new h();
            }
        }
        return bXr;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof BaseAppViewHolder) {
                i appData = ((BaseAppViewHolder) tag).getAppData();
                if (!bd.isEmpty(appData.amq().url)) {
                    com.baidu.tbadk.distribute.a.ye().a(view.getContext(), appData.amw(), "area_click", "pb", appData.cnP, appData.threadId);
                    com.baidu.tbadk.distribute.a.ye().a(appData.amw(), appData.cnP, appData.threadId, "PB", "click");
                    bk.tl().b((TbPageContext) m.D(view.getContext()), new String[]{appData.amq().url});
                }
            }
        }
    }
}
