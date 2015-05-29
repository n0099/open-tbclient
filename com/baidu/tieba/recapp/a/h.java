package com.baidu.tieba.recapp.a;

import android.view.View;
import com.baidu.adp.base.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.data.i;
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private static h cbk;

    public static final h ahl() {
        if (cbk != null) {
            return cbk;
        }
        synchronized (h.class) {
            if (cbk == null) {
                cbk = new h();
            }
        }
        return cbk;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof BaseAppViewHolder) {
                i appData = ((BaseAppViewHolder) tag).getAppData();
                if (!bb.isEmpty(appData.aor().url)) {
                    com.baidu.tbadk.distribute.a.yX().a(view.getContext(), appData.aox(), "area_click", "pb", appData.csd, appData.threadId);
                    com.baidu.tbadk.distribute.a.yX().a(appData.aox(), appData.csd, appData.threadId, "PB", "click");
                    bi.tO().b((TbPageContext) n.D(view.getContext()), new String[]{appData.aor().url});
                }
            }
        }
    }
}
