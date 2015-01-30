package com.baidu.tieba.recapp.a;

import android.view.View;
import com.baidu.adp.base.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.b.j;
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    private static g bMJ;

    public static final g acp() {
        if (bMJ != null) {
            return bMJ;
        }
        synchronized (g.class) {
            if (bMJ == null) {
                bMJ = new g();
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
                if (!bf.isEmpty(appData.aho().url)) {
                    com.baidu.tbadk.distribute.a.uU().a(view.getContext(), appData.ahu(), "btn_click", "pb", appData.bYG, appData.threadId);
                    com.baidu.tbadk.distribute.a.uU().a(appData.ahu(), appData.bYG, appData.threadId, "PB", "click");
                    bm.pV().b((TbPageContext) m.D(view.getContext()), new String[]{appData.aho().url});
                }
            }
        }
    }
}
