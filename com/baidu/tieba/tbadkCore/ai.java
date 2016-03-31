package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ U9InfoView eoG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(U9InfoView u9InfoView) {
        this.eoG = u9InfoView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        RelativeLayout relativeLayout;
        LinearLayout linearLayout;
        aw awVar;
        aw awVar2;
        Context context2;
        Context context3;
        aw awVar3;
        at atVar;
        at atVar2;
        Context context4;
        Context context5;
        at atVar3;
        context = this.eoG.mContext;
        if (bl.ad(context) && com.baidu.adp.lib.util.k.jw()) {
            relativeLayout = this.eoG.eow;
            if (view != relativeLayout) {
                linearLayout = this.eoG.eox;
                if (view == linearLayout) {
                    awVar = this.eoG.news_info;
                    if (awVar != null) {
                        awVar2 = this.eoG.news_info;
                        if (!TextUtils.isEmpty(awVar2.uf())) {
                            context2 = this.eoG.mContext;
                            TiebaStatic.eventStat(context2, "info_click", "click", 1, "page", "frs");
                            bg wM = bg.wM();
                            context3 = this.eoG.mContext;
                            awVar3 = this.eoG.news_info;
                            wM.c((TbPageContext) com.baidu.adp.base.l.s(context3), new String[]{awVar3.uf()});
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            atVar = this.eoG.top_code;
            if (atVar != null) {
                atVar2 = this.eoG.top_code;
                if (!TextUtils.isEmpty(atVar2.tX())) {
                    context4 = this.eoG.mContext;
                    TiebaStatic.eventStat(context4, "num_click", "click", 1, new Object[0]);
                    bg wM2 = bg.wM();
                    context5 = this.eoG.mContext;
                    atVar3 = this.eoG.top_code;
                    wM2.c((TbPageContext) com.baidu.adp.base.l.s(context5), new String[]{atVar3.tX()});
                }
            }
        }
    }
}
