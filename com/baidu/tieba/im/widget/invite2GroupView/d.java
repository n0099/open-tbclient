package com.baidu.tieba.im.widget.invite2GroupView;

import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.g;
import com.baidu.tieba.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements g<Boolean> {
    private final /* synthetic */ TbPageContext Nn;
    final /* synthetic */ Invite2GroupView boC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Invite2GroupView invite2GroupView, TbPageContext tbPageContext) {
        this.boC = invite2GroupView;
        this.Nn = tbPageContext;
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
            textView = this.boC.boA;
            textView.setTextColor(this.boC.getContext().getResources().getColor(s.group_info_join_disable_color));
            textView2 = this.boC.boA;
            textView2.setOnClickListener(new e(this, this.Nn));
        }
    }
}
