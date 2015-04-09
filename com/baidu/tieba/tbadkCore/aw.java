package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnClickListener {
    final /* synthetic */ U9InfoView cnJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(U9InfoView u9InfoView) {
        this.cnJ = u9InfoView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        LinearLayout linearLayout;
        com.baidu.tbadk.core.data.aa aaVar;
        Context context;
        com.baidu.tbadk.core.data.aa aaVar2;
        com.baidu.tbadk.core.data.x xVar;
        Context context2;
        com.baidu.tbadk.core.data.x xVar2;
        if (com.baidu.adp.lib.util.n.isNetOk()) {
            relativeLayout = this.cnJ.cny;
            if (view != relativeLayout) {
                linearLayout = this.cnJ.cnz;
                if (view == linearLayout) {
                    aaVar = this.cnJ.news_info;
                    if (!TextUtils.isEmpty(aaVar.rb())) {
                        bk tl = bk.tl();
                        context = this.cnJ.mContext;
                        aaVar2 = this.cnJ.news_info;
                        tl.b((TbPageContext) com.baidu.adp.base.m.D(context), new String[]{aaVar2.rb()});
                        return;
                    }
                    return;
                }
                return;
            }
            xVar = this.cnJ.top_code;
            if (!TextUtils.isEmpty(xVar.qV())) {
                bk tl2 = bk.tl();
                context2 = this.cnJ.mContext;
                xVar2 = this.cnJ.top_code;
                tl2.b((TbPageContext) com.baidu.adp.base.m.D(context2), new String[]{xVar2.qV()});
            }
        }
    }
}
