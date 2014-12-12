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
    private static d bKW;

    public static final d abK() {
        if (bKW != null) {
            return bKW;
        }
        synchronized (d.class) {
            if (bKW == null) {
                bKW = new d();
            }
        }
        return bKW;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof BaseAppViewHolder) {
                BaseAppViewHolder baseAppViewHolder = (BaseAppViewHolder) tag;
                j appData = baseAppViewHolder.getAppData();
                int position = baseAppViewHolder.getPosition();
                i.B(view.getContext(), "pb_tb_btc");
                int agL = appData.agL();
                if (agL == 0) {
                    if (!com.baidu.adp.lib.util.i.fh() && (view.getContext() instanceof Activity)) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((Activity) view.getContext());
                        aVar.bs(z.del_post_tip);
                        aVar.bt(z.frs_network_tips);
                        aVar.a(z.alert_yes_button, new e(this, view, appData, position, baseAppViewHolder));
                        aVar.b(z.alert_no_button, new f(this));
                        TbPageContext tbPageContext = null;
                        if (view.getContext() instanceof TbPageContextSupport) {
                            tbPageContext = ((TbPageContextSupport) view.getContext()).getPageContext();
                        }
                        aVar.b(tbPageContext);
                        aVar.nU();
                        return;
                    }
                    com.baidu.tbadk.distribute.a.uD().a(view.getContext(), appData.agP(), "btn_download", "pb", appData.Gb, appData.threadId);
                    com.baidu.tbadk.distribute.a.uD().a(appData.agP(), appData.Gb, appData.threadId, "PB", "download");
                    ar.a(view.getContext(), appData, position);
                    baseAppViewHolder.refresh();
                } else if (agL == 2) {
                    ar.a(view.getContext(), appData);
                    baseAppViewHolder.refresh();
                }
            }
        }
    }
}
