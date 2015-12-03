package com.baidu.tieba.recapp.a;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.base.l;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.ah;
import com.baidu.tieba.tbadkCore.data.n;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private static a dhI;

    public static final a avP() {
        if (dhI == null) {
            synchronized (a.class) {
                if (dhI == null) {
                    dhI = new a();
                }
            }
        }
        return dhI;
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
            Object tag = view.getTag();
            if (tag instanceof BaseAppViewHolder) {
                BaseAppViewHolder baseAppViewHolder = (BaseAppViewHolder) tag;
                n appData = baseAppViewHolder.getAppData();
                int position = baseAppViewHolder.getPosition();
                if (appData != null) {
                    TextView textView = (TextView) view.findViewById(n.f.recommend_btn);
                    com.baidu.tbadk.distribute.a.Bf().a(tbPageContext.getPageActivity(), appData.aCX(), "area_click", "pb", appData.dzx, appData.threadId);
                    com.baidu.tbadk.distribute.a.Bf().a(appData.aCX(), appData.dzx, appData.threadId, "PB", "click", appData.pageNumber);
                    com.baidu.tieba.recapp.report.b.avU().a(com.baidu.tieba.recapp.report.e.a(appData, "click"));
                    TiebaStatic.eventStat(tbPageContext.getPageActivity(), "pb_ck_app", null, 1, "app_name", appData.getPkgName());
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
                            if (!i.iQ() && (view.getContext() instanceof Activity)) {
                                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((Activity) view.getContext());
                                aVar.bN(n.i.frs_network_tips);
                                aVar.a(n.i.alert_yes_button, new b(this, view, appData, position, baseAppViewHolder));
                                aVar.b(n.i.alert_no_button, new c(this));
                                aVar.b(tbPageContext);
                                aVar.tv();
                                return;
                            }
                            com.baidu.tbadk.distribute.a.Bf().a(view.getContext(), appData.aCX(), "btn_download", "pb", appData.dzx, appData.threadId);
                            com.baidu.tbadk.distribute.a.Bf().a(appData.aCX(), appData.dzx, appData.threadId, "PB", "download", appData.pageNumber);
                            textView.setText(n.i.downloading2);
                            baseAppViewHolder.getAppDownloadView().setVisibility(0);
                            ah.a(view.getContext(), appData, position);
                            baseAppViewHolder.refresh();
                            return;
                        case 7:
                            ah.a(view.getContext(), appData, position);
                            baseAppViewHolder.refresh();
                            textView.setText(n.i.downloading2);
                            return;
                    }
                }
            }
        }
    }
}
