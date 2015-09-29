package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ U9InfoView cXZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(U9InfoView u9InfoView) {
        this.cXZ = u9InfoView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        RelativeLayout relativeLayout;
        LinearLayout linearLayout;
        com.baidu.tbadk.core.data.z zVar;
        Context context2;
        Context context3;
        com.baidu.tbadk.core.data.z zVar2;
        com.baidu.tbadk.core.data.w wVar;
        Context context4;
        Context context5;
        com.baidu.tbadk.core.data.w wVar2;
        context = this.cXZ.mContext;
        if (bc.ah(context) && com.baidu.adp.lib.util.k.jd()) {
            relativeLayout = this.cXZ.cXP;
            if (view != relativeLayout) {
                linearLayout = this.cXZ.cXQ;
                if (view == linearLayout) {
                    zVar = this.cXZ.news_info;
                    if (!TextUtils.isEmpty(zVar.sN())) {
                        context2 = this.cXZ.mContext;
                        TiebaStatic.eventStat(context2, "info_click", "click", 1, "page", "frs");
                        ay uV = ay.uV();
                        context3 = this.cXZ.mContext;
                        zVar2 = this.cXZ.news_info;
                        uV.b((TbPageContext) com.baidu.adp.base.l.C(context3), new String[]{zVar2.sN()});
                        return;
                    }
                    return;
                }
                return;
            }
            wVar = this.cXZ.top_code;
            if (!TextUtils.isEmpty(wVar.sH())) {
                context4 = this.cXZ.mContext;
                TiebaStatic.eventStat(context4, "num_click", "click", 1, new Object[0]);
                ay uV2 = ay.uV();
                context5 = this.cXZ.mContext;
                wVar2 = this.cXZ.top_code;
                uV2.b((TbPageContext) com.baidu.adp.base.l.C(context5), new String[]{wVar2.sH()});
            }
        }
    }
}
