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
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ag;
import com.baidu.tieba.tbadkCore.data.q;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    private static d dCv;

    public static final d aEG() {
        if (dCv == null) {
            synchronized (d.class) {
                if (dCv == null) {
                    dCv = new d();
                }
            }
        }
        return dCv;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (!i.iN()) {
                k.showToast(view.getContext(), t.j.neterror);
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
                        com.baidu.tbadk.download.b.Cr().ai(appData.getDownloadUrl(), appData.getPkgName());
                        ((TextView) view).setText(t.j.pb_download_pause);
                        return;
                    case 2:
                    case 4:
                    default:
                        return;
                    case 3:
                        ag.a(view.getContext(), appData);
                        baseAppViewHolder.refresh();
                        return;
                    case 6:
                        if (!i.ja() && (view.getContext() instanceof Activity)) {
                            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((Activity) view.getContext());
                            aVar.bY(t.j.frs_network_tips);
                            aVar.a(t.j.alert_yes_button, new e(this, view, appData, position, baseAppViewHolder));
                            aVar.b(t.j.alert_no_button, new f(this));
                            TbPageContext tbPageContext = null;
                            if (view.getContext() instanceof TbPageContextSupport) {
                                tbPageContext = ((TbPageContextSupport) view.getContext()).getPageContext();
                            } else if (l.C(view.getContext()) instanceof TbPageContext) {
                                tbPageContext = (TbPageContext) l.C(view.getContext());
                            }
                            aVar.b(tbPageContext);
                            aVar.uj();
                            return;
                        }
                        ((TextView) view).setText(t.j.downloading2);
                        baseAppViewHolder.getAppDownloadView().setVisibility(0);
                        com.baidu.tbadk.distribute.a.Cl().a(view.getContext(), appData.aMq(), "btn_download", "pb", appData.dWW, appData.threadId);
                        if (ag.a(view.getContext(), appData.aMq(), position)) {
                            appData.oh(1);
                            TiebaStatic.eventStat(view.getContext(), "pb_dl_app", null, 1, "app_name", appData.getPkgName());
                        }
                        baseAppViewHolder.refresh();
                        return;
                    case 7:
                        if (ag.a(view.getContext(), appData.aMq(), position)) {
                            appData.oh(1);
                            TiebaStatic.eventStat(view.getContext(), "pb_dl_app", null, 1, "app_name", appData.getPkgName());
                        }
                        baseAppViewHolder.refresh();
                        ((TextView) view).setText(t.j.downloading2);
                        return;
                }
            }
        }
    }

    private void a(Context context, q qVar) {
        if (qVar != null) {
            com.baidu.tbadk.distribute.a.Cl().a(context, qVar.aMq(), "btn_click", "pb", qVar.dWW, qVar.threadId);
            com.baidu.tbadk.distribute.a.Cl().a(qVar.aMq(), qVar.dWW, qVar.threadId, "PB", "click", qVar.pageNumber);
            com.baidu.tieba.recapp.report.b.aEK().a(com.baidu.tieba.recapp.report.e.a(qVar, "click"));
        }
    }
}
