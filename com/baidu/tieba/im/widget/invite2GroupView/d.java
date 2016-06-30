package com.baidu.tieba.im.widget.invite2GroupView;

import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.util.g;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements g<Boolean> {
    private final /* synthetic */ TbPageContext Kq;
    final /* synthetic */ Invite2GroupView cYa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Invite2GroupView invite2GroupView, TbPageContext tbPageContext) {
        this.cYa = invite2GroupView;
        this.Kq = tbPageContext;
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
            textView = this.cYa.Fb;
            textView.setTextColor(this.cYa.getContext().getResources().getColor(u.d.common_color_10228));
            textView2 = this.cYa.Fb;
            textView2.setOnClickListener(new e(this, this.Kq));
        }
    }
}
