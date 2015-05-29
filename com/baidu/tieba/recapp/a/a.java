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
    private static a cbd;

    public static final a ahi() {
        if (cbd != null) {
            return cbd;
        }
        synchronized (a.class) {
            if (cbd == null) {
                cbd = new a();
            }
        }
        return cbd;
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
                    com.baidu.tbadk.distribute.a.yX().a(view.getContext(), appData.aox(), "area_click", "pb", appData.csd, appData.threadId);
                    com.baidu.tbadk.distribute.a.yX().a(appData.aox(), appData.csd, appData.threadId, "PB", "click");
                    TiebaStatic.eventStat(view.getContext(), "pb_ck_app", null, 1, "app_name", appData.getPkgName());
                    int aot = appData.aot();
                    if (aot == 0) {
                        if (view.getContext() instanceof Activity) {
                            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((Activity) view.getContext());
                            if (!k.iY()) {
                                aVar.bu(t.frs_network_tips);
                            } else if (StringUtils.isNull(appData.aow())) {
                                aVar.bu(t.pb_app_download_ask);
                            } else {
                                aVar.cn(appData.aow());
                            }
                            aVar.a(t.alert_yes_button, new b(this, view, appData, position, baseAppViewHolder));
                            aVar.b(t.alert_no_button, new c(this));
                            aVar.b(view.getContext() instanceof TbPageContextSupport ? ((TbPageContextSupport) view.getContext()).getPageContext() : null);
                            aVar.rL();
                        }
                    } else if (aot == 2) {
                        au.a(view.getContext(), appData);
                        baseAppViewHolder.refresh();
                    }
                }
            }
        }
    }
}
