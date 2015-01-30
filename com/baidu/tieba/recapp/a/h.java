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
    private static h bMK;

    public static final h acq() {
        if (bMK != null) {
            return bMK;
        }
        synchronized (h.class) {
            if (bMK == null) {
                bMK = new h();
            }
        }
        return bMK;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof BaseAppViewHolder) {
                j appData = ((BaseAppViewHolder) tag).getAppData();
                if (!bf.isEmpty(appData.aho().url)) {
                    com.baidu.tbadk.distribute.a.uU().a(view.getContext(), appData.ahu(), "area_click", "pb", appData.bYG, appData.threadId);
                    com.baidu.tbadk.distribute.a.uU().a(appData.ahu(), appData.bYG, appData.threadId, "PB", "click");
                    bm.pV().b((TbPageContext) m.D(view.getContext()), new String[]{appData.aho().url});
                }
            }
        }
    }
}
