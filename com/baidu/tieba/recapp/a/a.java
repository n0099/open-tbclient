package com.baidu.tieba.recapp.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.base.l;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.ah;
import com.baidu.tieba.tbadkCore.data.q;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private static a dno;

    public static final a axI() {
        if (dno == null) {
            synchronized (a.class) {
                if (dno == null) {
                    dno = new a();
                }
            }
        }
        return dno;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        if (view != null) {
            if (l.C(com.baidu.adp.base.a.dF().dG()) == null) {
                tbPageContext = null;
            } else {
                tbPageContext = (TbPageContext) l.C(com.baidu.adp.base.a.dF().dG());
            }
            if (tbPageContext != null) {
                if (!i.iE()) {
                    k.showToast(tbPageContext.getPageActivity(), n.j.neterror);
                    return;
                }
                Object tag = view.getTag();
                if (tag instanceof BaseAppViewHolder) {
                    BaseAppViewHolder baseAppViewHolder = (BaseAppViewHolder) tag;
                    q appData = baseAppViewHolder.getAppData();
                    int position = baseAppViewHolder.getPosition();
                    if (appData != null) {
                        a(tbPageContext.getPageActivity(), appData);
                        TiebaStatic.eventStat(tbPageContext.getPageActivity(), "pb_ck_app", null, 1, "app_name", appData.getPkgName());
                        TextView textView = (TextView) view.findViewById(n.g.recommend_btn);
                        switch (baseAppViewHolder.getDownloadData().getStatus()) {
                            case 3:
                                ah.a(view.getContext(), appData);
                                baseAppViewHolder.refresh();
                                return;
                            case 4:
                            case 5:
                            default:
                                return;
                            case 6:
                                if (!i.iR() && (view.getContext() instanceof Activity)) {
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((Activity) view.getContext());
                                    aVar.bG(n.j.frs_network_tips);
                                    aVar.a(n.j.alert_yes_button, new b(this, view, appData, position, baseAppViewHolder));
                                    aVar.b(n.j.alert_no_button, new c(this));
                                    aVar.b(tbPageContext);
                                    aVar.tf();
                                    return;
                                }
                                textView.setText(n.j.downloading2);
                                baseAppViewHolder.getAppDownloadView().setVisibility(0);
                                com.baidu.tbadk.distribute.a.AV().a(view.getContext(), appData.aFk(), "area_download", "pb", appData.dHa, appData.threadId);
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
                                textView.setText(n.j.downloading2);
                                return;
                        }
                    }
                }
            }
        }
    }

    private void a(Context context, q qVar) {
        if (qVar != null) {
            com.baidu.tbadk.distribute.a.AV().a(context, qVar.aFk(), "area_click", "pb", qVar.dHa, qVar.threadId);
            com.baidu.tbadk.distribute.a.AV().a(qVar.aFk(), qVar.dHa, qVar.threadId, "PB", "click", qVar.pageNumber);
            com.baidu.tieba.recapp.report.b.axN().a(com.baidu.tieba.recapp.report.e.a(qVar, "click"));
        }
    }
}
