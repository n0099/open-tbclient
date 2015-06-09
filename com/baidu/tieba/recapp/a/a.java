package com.baidu.tieba.recapp.a;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.au;
import com.baidu.tieba.tbadkCore.data.i;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private static a cbe;

    public static final a ahj() {
        if (cbe != null) {
            return cbe;
        }
        synchronized (a.class) {
            if (cbe == null) {
                cbe = new a();
            }
        }
        return cbe;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof BaseAppViewHolder) {
                BaseAppViewHolder baseAppViewHolder = (BaseAppViewHolder) tag;
                i appData = baseAppViewHolder.getAppData();
                int position = baseAppViewHolder.getPosition();
                if (appData != null) {
                    com.baidu.tbadk.distribute.a.yY().a(view.getContext(), appData.aoy(), "area_click", "pb", appData.cse, appData.threadId);
                    com.baidu.tbadk.distribute.a.yY().a(appData.aoy(), appData.cse, appData.threadId, "PB", "click");
                    TiebaStatic.eventStat(view.getContext(), "pb_ck_app", null, 1, "app_name", appData.getPkgName());
                    int aou = appData.aou();
                    if (aou == 0) {
                        if (view.getContext() instanceof Activity) {
                            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((Activity) view.getContext());
                            if (!k.iY()) {
                                aVar.bu(t.frs_network_tips);
                            } else if (StringUtils.isNull(appData.aox())) {
                                aVar.bu(t.pb_app_download_ask);
                            } else {
                                aVar.cn(appData.aox());
                            }
                            aVar.a(t.alert_yes_button, new b(this, view, appData, position, baseAppViewHolder));
                            aVar.b(t.alert_no_button, new c(this));
                            aVar.b(view.getContext() instanceof TbPageContextSupport ? ((TbPageContextSupport) view.getContext()).getPageContext() : null);
                            aVar.rL();
                        }
                    } else if (aou == 2) {
                        au.a(view.getContext(), appData);
                        baseAppViewHolder.refresh();
                    }
                }
            }
        }
    }
}
