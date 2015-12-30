package com.baidu.tieba.im.widget.invite2GroupView;

import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.util.d<Boolean> {
    private final /* synthetic */ TbPageContext SL;
    final /* synthetic */ Invite2GroupView ccK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Invite2GroupView invite2GroupView, TbPageContext tbPageContext) {
        this.ccK = invite2GroupView;
        this.SL = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        TextView textView;
        TextView textView2;
        if (bool == null) {
            bool = false;
        }
        if (!bool.booleanValue()) {
            textView = this.ccK.ccI;
            textView.setTextColor(this.ccK.getContext().getResources().getColor(n.d.group_info_join_disable_color));
            textView2 = this.ccK.ccI;
            textView2.setOnClickListener(new e(this, this.SL));
        }
    }
}
