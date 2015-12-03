package com.baidu.tieba.recapp.a;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.base.l;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.ah;
import com.baidu.tieba.tbadkCore.data.n;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    private static d dhM;

    public static final d avQ() {
        if (dhM == null) {
            synchronized (d.class) {
                if (dhM == null) {
                    dhM = new d();
                }
            }
        }
        return dhM;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof BaseAppViewHolder) {
                BaseAppViewHolder baseAppViewHolder = (BaseAppViewHolder) tag;
                n appData = baseAppViewHolder.getAppData();
                int position = baseAppViewHolder.getPosition();
                TiebaStatic.log("pb_tb_btc");
                switch (baseAppViewHolder.getDownloadData().getStatus()) {
                    case 1:
                    case 5:
                        com.baidu.tbadk.download.b.Bm().aj(appData.getDownloadUrl(), appData.getPkgName());
                        ((TextView) view).setText(n.i.pb_download_pause);
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
                        if (!i.iQ() && (view.getContext() instanceof Activity)) {
                            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((Activity) view.getContext());
                            aVar.bN(n.i.frs_network_tips);
                            aVar.a(n.i.alert_yes_button, new e(this, view, appData, position, baseAppViewHolder));
                            aVar.b(n.i.alert_no_button, new f(this));
                            TbPageContext tbPageContext = null;
                            if (view.getContext() instanceof TbPageContextSupport) {
                                tbPageContext = ((TbPageContextSupport) view.getContext()).getPageContext();
                            } else if (l.C(view.getContext()) instanceof com.baidu.adp.base.h) {
                                tbPageContext = (TbPageContext) l.C(view.getContext());
                            }
                            aVar.b(tbPageContext);
                            aVar.tv();
                            return;
                        }
                        com.baidu.tbadk.distribute.a.Bf().a(view.getContext(), appData.aCX(), "btn_download", "pb", appData.dzx, appData.threadId);
                        com.baidu.tbadk.distribute.a.Bf().a(appData.aCX(), appData.dzx, appData.threadId, "PB", "download", appData.pageNumber);
                        ((TextView) view).setText(n.i.downloading2);
                        baseAppViewHolder.getAppDownloadView().setVisibility(0);
                        ah.a(view.getContext(), appData, position);
                        baseAppViewHolder.refresh();
                        return;
                    case 7:
                        ah.a(view.getContext(), appData, position);
                        baseAppViewHolder.refresh();
                        ((TextView) view).setText(n.i.downloading2);
                        return;
                }
            }
        }
    }
}
