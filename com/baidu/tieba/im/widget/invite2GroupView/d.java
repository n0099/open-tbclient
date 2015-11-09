package com.baidu.tieba.im.widget.invite2GroupView;

import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.util.d<Boolean> {
    private final /* synthetic */ TbPageContext RY;
    final /* synthetic */ Invite2GroupView bJF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Invite2GroupView invite2GroupView, TbPageContext tbPageContext) {
        this.bJF = invite2GroupView;
        this.RY = tbPageContext;
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
            textView = this.bJF.bJD;
            textView.setTextColor(this.bJF.getContext().getResources().getColor(i.c.group_info_join_disable_color));
            textView2 = this.bJF.bJD;
            textView2.setOnClickListener(new e(this, this.RY));
        }
    }
}
