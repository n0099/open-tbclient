package com.baidu.tieba.recapp.a;

import android.view.View;
import com.baidu.adp.base.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.c.i;
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    private static g bXG;

    public static final g afG() {
        if (bXG != null) {
            return bXG;
        }
        synchronized (g.class) {
            if (bXG == null) {
                bXG = new g();
            }
        }
        return bXG;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof BaseAppViewHolder) {
                i appData = ((BaseAppViewHolder) tag).getAppData();
                if (!bd.isEmpty(appData.amF().url)) {
                    com.baidu.tbadk.distribute.a.yk().a(view.getContext(), appData.amL(), "btn_click", "pb", appData.cof, appData.threadId);
                    com.baidu.tbadk.distribute.a.yk().a(appData.amL(), appData.cof, appData.threadId, "PB", "click");
                    bk.tl().b((TbPageContext) m.D(view.getContext()), new String[]{appData.amF().url});
                }
            }
        }
    }
}
