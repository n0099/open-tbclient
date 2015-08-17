package com.baidu.tieba.im.widget.invite2GroupView;

import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
import com.baidu.tieba.im.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements g<Boolean> {
    private final /* synthetic */ TbPageContext Sn;
    final /* synthetic */ Invite2GroupView bFn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Invite2GroupView invite2GroupView, TbPageContext tbPageContext) {
        this.bFn = invite2GroupView;
        this.Sn = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        TextView textView;
        TextView textView2;
        if (bool == null) {
            bool = false;
        }
        if (!bool.booleanValue()) {
            textView = this.bFn.bFl;
            textView.setTextColor(this.bFn.getContext().getResources().getColor(i.c.group_info_join_disable_color));
            textView2 = this.bFn.bFl;
            textView2.setOnClickListener(new e(this, this.Sn));
        }
    }
}
