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
    private static d bMG;

    public static final d acj() {
        if (bMG != null) {
            return bMG;
        }
        synchronized (d.class) {
            if (bMG == null) {
                bMG = new d();
            }
        }
        return bMG;
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
                int ahl = appData.ahl();
                if (ahl == 0) {
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
                        aVar.nQ();
                        return;
                    }
                    com.baidu.tbadk.distribute.a.uO().a(view.getContext(), appData.ahp(), "btn_download", "pb", appData.bYF, appData.threadId);
                    com.baidu.tbadk.distribute.a.uO().a(appData.ahp(), appData.bYF, appData.threadId, "PB", "download");
                    ar.a(view.getContext(), appData, position);
                    baseAppViewHolder.refresh();
                } else if (ahl == 2) {
                    ar.a(view.getContext(), appData);
                    baseAppViewHolder.refresh();
                }
            }
        }
    }
}
