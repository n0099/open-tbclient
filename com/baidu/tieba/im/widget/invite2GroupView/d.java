package com.baidu.tieba.im.widget.invite2GroupView;

import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.util.g;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements g<Boolean> {
    private final /* synthetic */ TbPageContext QC;
    final /* synthetic */ Invite2GroupView dde;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Invite2GroupView invite2GroupView, TbPageContext tbPageContext) {
        this.dde = invite2GroupView;
        this.QC = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        TextView textView;
        TextView textView2;
        if (bool == null) {
            bool = false;
        }
        if (!bool.booleanValue()) {
            textView = this.dde.ddc;
            textView.setTextColor(this.dde.getContext().getResources().getColor(w.e.common_color_10228));
            textView2 = this.dde.ddc;
            textView2.setOnClickListener(new e(this, this.QC));
        }
    }
}
