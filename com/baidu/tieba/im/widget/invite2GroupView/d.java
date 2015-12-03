package com.baidu.tieba.im.widget.invite2GroupView;

import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.util.d<Boolean> {
    private final /* synthetic */ TbPageContext Sn;
    final /* synthetic */ Invite2GroupView bYK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Invite2GroupView invite2GroupView, TbPageContext tbPageContext) {
        this.bYK = invite2GroupView;
        this.Sn = tbPageContext;
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
            textView = this.bYK.bYI;
            textView.setTextColor(this.bYK.getContext().getResources().getColor(n.c.group_info_join_disable_color));
            textView2 = this.bYK.bYI;
            textView2.setOnClickListener(new e(this, this.Sn));
        }
    }
}
