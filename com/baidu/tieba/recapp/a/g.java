package com.baidu.tieba.recapp.a;

import android.view.View;
import com.baidu.adp.base.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.b.j;
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    private static g bKY;

    public static final g abL() {
        if (bKY != null) {
            return bKY;
        }
        synchronized (g.class) {
            if (bKY == null) {
                bKY = new g();
            }
        }
        return bKY;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof BaseAppViewHolder) {
                j appData = ((BaseAppViewHolder) tag).getAppData();
                if (!ba.isEmpty(appData.agJ().url)) {
                    com.baidu.tbadk.distribute.a.uD().a(view.getContext(), appData.agP(), "btn_click", "pb", appData.Gb, appData.threadId);
                    com.baidu.tbadk.distribute.a.uD().a(appData.agP(), appData.Gb, appData.threadId, "PB", "click");
                    bh.pK().b((TbPageContext) m.D(view.getContext()), new String[]{appData.agJ().url});
                }
            }
        }
    }
}
