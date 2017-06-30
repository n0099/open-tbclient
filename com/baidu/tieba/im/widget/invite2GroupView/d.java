package com.baidu.tieba.im.widget.invite2GroupView;

import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.util.h;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements h<Boolean> {
    private final /* synthetic */ TbPageContext Qj;
    final /* synthetic */ Invite2GroupView dqw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Invite2GroupView invite2GroupView, TbPageContext tbPageContext) {
        this.dqw = invite2GroupView;
        this.Qj = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.h
    public void onReturnDataInUI(Boolean bool) {
        TextView textView;
        TextView textView2;
        if (bool == null) {
            bool = false;
        }
        if (!bool.booleanValue()) {
            textView = this.dqw.dqu;
            textView.setTextColor(this.dqw.getContext().getResources().getColor(w.e.common_color_10228));
            textView2 = this.dqw.dqu;
            textView2.setOnClickListener(new e(this, this.Qj));
        }
    }
}
