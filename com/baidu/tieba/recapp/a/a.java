package com.baidu.tieba.recapp.a;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.au;
import com.baidu.tieba.tbadkCore.c.i;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private static a bXA;

    public static final a afE() {
        if (bXA != null) {
            return bXA;
        }
        synchronized (a.class) {
            if (bXA == null) {
                bXA = new a();
            }
        }
        return bXA;
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
                    com.baidu.tbadk.distribute.a.yk().a(view.getContext(), appData.amL(), "area_click", "pb", appData.cof, appData.threadId);
                    com.baidu.tbadk.distribute.a.yk().a(appData.amL(), appData.cof, appData.threadId, "PB", "click");
                    TiebaStatic.eventStat(view.getContext(), "pb_ck_app", null, 1, "app_name", appData.getPkgName());
                    int amH = appData.amH();
                    if (amH == 0) {
                        if (view.getContext() instanceof Activity) {
                            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((Activity) view.getContext());
                            aVar.bw(y.del_post_tip);
                            if (!k.iI()) {
                                aVar.bx(y.frs_network_tips);
                            } else if (StringUtils.isNull(appData.amK())) {
                                aVar.bx(y.pb_app_download_ask);
                            } else {
                                aVar.ca(appData.amK());
                            }
                            aVar.a(y.alert_yes_button, new b(this, view, appData, position, baseAppViewHolder));
                            aVar.b(y.alert_no_button, new c(this));
                            aVar.b(view.getContext() instanceof TbPageContextSupport ? ((TbPageContextSupport) view.getContext()).getPageContext() : null);
                            aVar.re();
                        }
                    } else if (amH == 2) {
                        au.a(view.getContext(), appData);
                        baseAppViewHolder.refresh();
                    }
                }
            }
        }
    }
}
