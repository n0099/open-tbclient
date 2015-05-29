package com.baidu.tieba.recapp.a;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.k;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.au;
import com.baidu.tieba.tbadkCore.data.i;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    private static d cbh;

    public static final d ahj() {
        if (cbh != null) {
            return cbh;
        }
        synchronized (d.class) {
            if (cbh == null) {
                cbh = new d();
            }
        }
        return cbh;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof BaseAppViewHolder) {
                BaseAppViewHolder baseAppViewHolder = (BaseAppViewHolder) tag;
                i appData = baseAppViewHolder.getAppData();
                int position = baseAppViewHolder.getPosition();
                k.A(view.getContext(), "pb_tb_btc");
                int aot = appData.aot();
                if (aot == 0) {
                    if (!com.baidu.adp.lib.util.k.iY() && (view.getContext() instanceof Activity)) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((Activity) view.getContext());
                        aVar.bu(t.frs_network_tips);
                        aVar.a(t.alert_yes_button, new e(this, view, appData, position, baseAppViewHolder));
                        aVar.b(t.alert_no_button, new f(this));
                        TbPageContext tbPageContext = null;
                        if (view.getContext() instanceof TbPageContextSupport) {
                            tbPageContext = ((TbPageContextSupport) view.getContext()).getPageContext();
                        }
                        aVar.b(tbPageContext);
                        aVar.rL();
                        return;
                    }
                    com.baidu.tbadk.distribute.a.yX().a(view.getContext(), appData.aox(), "btn_download", "pb", appData.csd, appData.threadId);
                    com.baidu.tbadk.distribute.a.yX().a(appData.aox(), appData.csd, appData.threadId, "PB", "download");
                    au.a(view.getContext(), appData, position);
                    baseAppViewHolder.refresh();
                } else if (aot == 2) {
                    au.a(view.getContext(), appData);
                    baseAppViewHolder.refresh();
                }
            }
        }
    }
}
