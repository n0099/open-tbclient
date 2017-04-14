package com.baidu.tieba.im.widget.invite2GroupView;

import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.util.f;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements f<Boolean> {
    private final /* synthetic */ TbPageContext Rj;
    final /* synthetic */ Invite2GroupView dgL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Invite2GroupView invite2GroupView, TbPageContext tbPageContext) {
        this.dgL = invite2GroupView;
        this.Rj = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    public void onReturnDataInUI(Boolean bool) {
        TextView textView;
        TextView textView2;
        if (bool == null) {
            bool = false;
        }
        if (!bool.booleanValue()) {
            textView = this.dgL.dgJ;
            textView.setTextColor(this.dgL.getContext().getResources().getColor(w.e.common_color_10228));
            textView2 = this.dgL.dgJ;
            textView2.setOnClickListener(new e(this, this.Rj));
        }
    }
}
