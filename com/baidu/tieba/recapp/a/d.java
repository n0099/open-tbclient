package com.baidu.tieba.recapp.a;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.k;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.au;
import com.baidu.tieba.tbadkCore.c.i;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    private static d bXE;

    public static final d afF() {
        if (bXE != null) {
            return bXE;
        }
        synchronized (d.class) {
            if (bXE == null) {
                bXE = new d();
            }
        }
        return bXE;
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
                int amH = appData.amH();
                if (amH == 0) {
                    if (!com.baidu.adp.lib.util.k.iI() && (view.getContext() instanceof Activity)) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((Activity) view.getContext());
                        aVar.bw(y.del_post_tip);
                        aVar.bx(y.frs_network_tips);
                        aVar.a(y.alert_yes_button, new e(this, view, appData, position, baseAppViewHolder));
                        aVar.b(y.alert_no_button, new f(this));
                        TbPageContext tbPageContext = null;
                        if (view.getContext() instanceof TbPageContextSupport) {
                            tbPageContext = ((TbPageContextSupport) view.getContext()).getPageContext();
                        }
                        aVar.b(tbPageContext);
                        aVar.re();
                        return;
                    }
                    com.baidu.tbadk.distribute.a.yk().a(view.getContext(), appData.amL(), "btn_download", "pb", appData.cof, appData.threadId);
                    com.baidu.tbadk.distribute.a.yk().a(appData.amL(), appData.cof, appData.threadId, "PB", "download");
                    au.a(view.getContext(), appData, position);
                    baseAppViewHolder.refresh();
                } else if (amH == 2) {
                    au.a(view.getContext(), appData);
                    baseAppViewHolder.refresh();
                }
            }
        }
    }
}
