package com.baidu.tieba.recapp.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.base.l;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.ah;
import com.baidu.tieba.tbadkCore.data.q;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    private static d dns;

    public static final d axJ() {
        if (dns == null) {
            synchronized (d.class) {
                if (dns == null) {
                    dns = new d();
                }
            }
        }
        return dns;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (!i.iE()) {
                k.showToast(view.getContext(), n.j.neterror);
                return;
            }
            Object tag = view.getTag();
            if (tag instanceof BaseAppViewHolder) {
                BaseAppViewHolder baseAppViewHolder = (BaseAppViewHolder) tag;
                q appData = baseAppViewHolder.getAppData();
                int position = baseAppViewHolder.getPosition();
                a(view.getContext(), appData);
                TiebaStatic.log("pb_tb_btc");
                switch (baseAppViewHolder.getDownloadData().getStatus()) {
                    case 1:
                    case 5:
                        com.baidu.tbadk.download.b.Bb().ai(appData.getDownloadUrl(), appData.getPkgName());
                        ((TextView) view).setText(n.j.pb_download_pause);
                        return;
                    case 2:
                    case 4:
                    default:
                        return;
                    case 3:
                        ah.a(view.getContext(), appData);
                        baseAppViewHolder.refresh();
                        return;
                    case 6:
                        if (!i.iR() && (view.getContext() instanceof Activity)) {
                            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((Activity) view.getContext());
                            aVar.bG(n.j.frs_network_tips);
                            aVar.a(n.j.alert_yes_button, new e(this, view, appData, position, baseAppViewHolder));
                            aVar.b(n.j.alert_no_button, new f(this));
                            TbPageContext tbPageContext = null;
                            if (view.getContext() instanceof TbPageContextSupport) {
                                tbPageContext = ((TbPageContextSupport) view.getContext()).getPageContext();
                            } else if (l.C(view.getContext()) instanceof com.baidu.adp.base.h) {
                                tbPageContext = (TbPageContext) l.C(view.getContext());
                            }
                            aVar.b(tbPageContext);
                            aVar.tf();
                            return;
                        }
                        ((TextView) view).setText(n.j.downloading2);
                        baseAppViewHolder.getAppDownloadView().setVisibility(0);
                        com.baidu.tbadk.distribute.a.AV().a(view.getContext(), appData.aFk(), "btn_download", "pb", appData.dHa, appData.threadId);
                        if (ah.a(view.getContext(), appData.aFk(), position)) {
                            appData.mW(1);
                            TiebaStatic.eventStat(view.getContext(), "pb_dl_app", null, 1, "app_name", appData.getPkgName());
                        }
                        baseAppViewHolder.refresh();
                        return;
                    case 7:
                        if (ah.a(view.getContext(), appData.aFk(), position)) {
                            appData.mW(1);
                            TiebaStatic.eventStat(view.getContext(), "pb_dl_app", null, 1, "app_name", appData.getPkgName());
                        }
                        baseAppViewHolder.refresh();
                        ((TextView) view).setText(n.j.downloading2);
                        return;
                }
            }
        }
    }

    private void a(Context context, q qVar) {
        if (qVar != null) {
            com.baidu.tbadk.distribute.a.AV().a(context, qVar.aFk(), "btn_click", "pb", qVar.dHa, qVar.threadId);
            com.baidu.tbadk.distribute.a.AV().a(qVar.aFk(), qVar.dHa, qVar.threadId, "PB", "click", qVar.pageNumber);
            com.baidu.tieba.recapp.report.b.axN().a(com.baidu.tieba.recapp.report.e.a(qVar, "click"));
        }
    }
}
