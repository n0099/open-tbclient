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
    private static h cbl;

    public static final h ahm() {
        if (cbl != null) {
            return cbl;
        }
        synchronized (h.class) {
            if (cbl == null) {
                cbl = new h();
            }
        }
        return cbl;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof BaseAppViewHolder) {
                i appData = ((BaseAppViewHolder) tag).getAppData();
                if (!bb.isEmpty(appData.aos().url)) {
                    com.baidu.tbadk.distribute.a.yY().a(view.getContext(), appData.aoy(), "area_click", "pb", appData.cse, appData.threadId);
                    com.baidu.tbadk.distribute.a.yY().a(appData.aoy(), appData.cse, appData.threadId, "PB", "click");
                    bi.tO().b((TbPageContext) n.D(view.getContext()), new String[]{appData.aos().url});
                }
            }
        }
    }
}
