package com.baidu.tieba.recapp.a;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.i;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.ar;
import com.baidu.tieba.tbadkCore.b.j;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    private static d bMH;

    public static final d aco() {
        if (bMH != null) {
            return bMH;
        }
        synchronized (d.class) {
            if (bMH == null) {
                bMH = new d();
            }
        }
        return bMH;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof BaseAppViewHolder) {
                BaseAppViewHolder baseAppViewHolder = (BaseAppViewHolder) tag;
                j appData = baseAppViewHolder.getAppData();
                int position = baseAppViewHolder.getPosition();
                i.A(view.getContext(), "pb_tb_btc");
                int ahq = appData.ahq();
                if (ahq == 0) {
                    if (!com.baidu.adp.lib.util.i.fg() && (view.getContext() instanceof Activity)) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((Activity) view.getContext());
                        aVar.bx(z.del_post_tip);
                        aVar.by(z.frs_network_tips);
                        aVar.a(z.alert_yes_button, new e(this, view, appData, position, baseAppViewHolder));
                        aVar.b(z.alert_no_button, new f(this));
                        TbPageContext tbPageContext = null;
                        if (view.getContext() instanceof TbPageContextSupport) {
                            tbPageContext = ((TbPageContextSupport) view.getContext()).getPageContext();
                        }
                        aVar.b(tbPageContext);
                        aVar.nX();
                        return;
                    }
                    com.baidu.tbadk.distribute.a.uU().a(view.getContext(), appData.ahu(), "btn_download", "pb", appData.bYG, appData.threadId);
                    com.baidu.tbadk.distribute.a.uU().a(appData.ahu(), appData.bYG, appData.threadId, "PB", "download");
                    ar.a(view.getContext(), appData, position);
                    baseAppViewHolder.refresh();
                } else if (ahq == 2) {
                    ar.a(view.getContext(), appData);
                    baseAppViewHolder.refresh();
                }
            }
        }
    }
}
