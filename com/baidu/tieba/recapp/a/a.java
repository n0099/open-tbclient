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
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ag;
import com.baidu.tieba.tbadkCore.data.q;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private static a dCr;

    public static final a aEF() {
        if (dCr == null) {
            synchronized (a.class) {
                if (dCr == null) {
                    dCr = new a();
                }
            }
        }
        return dCr;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        if (view != null) {
            if (l.C(com.baidu.adp.base.a.dH().dI()) == null) {
                tbPageContext = null;
            } else {
                tbPageContext = (TbPageContext) l.C(com.baidu.adp.base.a.dH().dI());
            }
            if (tbPageContext != null) {
                if (!i.iN()) {
                    k.showToast(tbPageContext.getPageActivity(), t.j.neterror);
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
                        TextView textView = (TextView) view.findViewById(t.g.recommend_btn);
                        switch (baseAppViewHolder.getDownloadData().getStatus()) {
                            case 3:
                                ag.a(view.getContext(), appData);
                                baseAppViewHolder.refresh();
                                return;
                            case 4:
                            case 5:
                            default:
                                return;
                            case 6:
                                if (!i.ja() && (view.getContext() instanceof Activity)) {
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((Activity) view.getContext());
                                    aVar.bY(t.j.frs_network_tips);
                                    aVar.a(t.j.alert_yes_button, new b(this, view, appData, position, baseAppViewHolder));
                                    aVar.b(t.j.alert_no_button, new c(this));
                                    aVar.b(tbPageContext);
                                    aVar.uj();
                                    return;
                                }
                                textView.setText(t.j.downloading2);
                                baseAppViewHolder.getAppDownloadView().setVisibility(0);
                                com.baidu.tbadk.distribute.a.Cl().a(view.getContext(), appData.aMq(), "area_download", "pb", appData.dWW, appData.threadId);
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
                                textView.setText(t.j.downloading2);
                                return;
                        }
                    }
                }
            }
        }
    }

    private void a(Context context, q qVar) {
        if (qVar != null) {
            com.baidu.tbadk.distribute.a.Cl().a(context, qVar.aMq(), "area_click", "pb", qVar.dWW, qVar.threadId);
            com.baidu.tbadk.distribute.a.Cl().a(qVar.aMq(), qVar.dWW, qVar.threadId, "PB", "click", qVar.pageNumber);
            com.baidu.tieba.recapp.report.b.aEK().a(com.baidu.tieba.recapp.report.e.a(qVar, "click"));
        }
    }
}
