package com.baidu.tieba.recapp.a;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.ar;
import com.baidu.tieba.tbadkCore.b.j;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private static a bMD;

    public static final a acn() {
        if (bMD != null) {
            return bMD;
        }
        synchronized (a.class) {
            if (bMD == null) {
                bMD = new a();
            }
        }
        return bMD;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof BaseAppViewHolder) {
                BaseAppViewHolder baseAppViewHolder = (BaseAppViewHolder) tag;
                j appData = baseAppViewHolder.getAppData();
                int position = baseAppViewHolder.getPosition();
                if (appData != null) {
                    com.baidu.tbadk.distribute.a.uU().a(view.getContext(), appData.ahu(), "area_click", "pb", appData.bYG, appData.threadId);
                    com.baidu.tbadk.distribute.a.uU().a(appData.ahu(), appData.bYG, appData.threadId, "PB", "click");
                    TiebaStatic.eventStat(view.getContext(), "pb_ck_app", null, 1, "app_name", appData.getPkgName());
                    int ahq = appData.ahq();
                    if (ahq == 0) {
                        if (view.getContext() instanceof Activity) {
                            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((Activity) view.getContext());
                            aVar.bx(z.del_post_tip);
                            if (!i.fg()) {
                                aVar.by(z.frs_network_tips);
                            } else if (StringUtils.isNull(appData.aht())) {
                                aVar.by(z.pb_app_download_ask);
                            } else {
                                aVar.bW(appData.aht());
                            }
                            aVar.a(z.alert_yes_button, new b(this, view, appData, position, baseAppViewHolder));
                            aVar.b(z.alert_no_button, new c(this));
                            aVar.b(view.getContext() instanceof TbPageContextSupport ? ((TbPageContextSupport) view.getContext()).getPageContext() : null);
                            aVar.nX();
                        }
                    } else if (ahq == 2) {
                        ar.a(view.getContext(), appData);
                        baseAppViewHolder.refresh();
                    }
                }
            }
        }
    }
}
