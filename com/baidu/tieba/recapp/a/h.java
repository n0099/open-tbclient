package com.baidu.tieba.recapp.a;

import android.view.View;
import com.baidu.adp.base.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.b.j;
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private static h bMJ;

    public static final h acl() {
        if (bMJ != null) {
            return bMJ;
        }
        synchronized (h.class) {
            if (bMJ == null) {
                bMJ = new h();
            }
        }
        return bMJ;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof BaseAppViewHolder) {
                j appData = ((BaseAppViewHolder) tag).getAppData();
                if (!bf.isEmpty(appData.ahj().url)) {
                    com.baidu.tbadk.distribute.a.uO().a(view.getContext(), appData.ahp(), "area_click", "pb", appData.bYF, appData.threadId);
                    com.baidu.tbadk.distribute.a.uO().a(appData.ahp(), appData.bYF, appData.threadId, "PB", "click");
                    bm.pO().b((TbPageContext) m.D(view.getContext()), new String[]{appData.ahj().url});
                }
            }
        }
    }
}
