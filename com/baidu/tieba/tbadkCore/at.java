package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnClickListener {
    final /* synthetic */ U9InfoView bXz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(U9InfoView u9InfoView) {
        this.bXz = u9InfoView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        LinearLayout linearLayout;
        com.baidu.tbadk.core.data.ab abVar;
        Context context;
        com.baidu.tbadk.core.data.ab abVar2;
        com.baidu.tbadk.core.data.y yVar;
        Context context2;
        com.baidu.tbadk.core.data.y yVar2;
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            relativeLayout = this.bXz.bXo;
            if (view != relativeLayout) {
                linearLayout = this.bXz.bXp;
                if (view == linearLayout) {
                    abVar = this.bXz.news_info;
                    if (!TextUtils.isEmpty(abVar.nU())) {
                        bm pV = bm.pV();
                        context = this.bXz.mContext;
                        abVar2 = this.bXz.news_info;
                        pV.b((TbPageContext) com.baidu.adp.base.m.D(context), new String[]{abVar2.nU()});
                        return;
                    }
                    return;
                }
                return;
            }
            yVar = this.bXz.top_code;
            if (!TextUtils.isEmpty(yVar.nO())) {
                bm pV2 = bm.pV();
                context2 = this.bXz.mContext;
                yVar2 = this.bXz.top_code;
                pV2.b((TbPageContext) com.baidu.adp.base.m.D(context2), new String[]{yVar2.nO()});
            }
        }
    }
}
