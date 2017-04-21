package com.baidu.tieba.im.widget.invite2GroupView;

import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.util.f;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements f<Boolean> {
    private final /* synthetic */ TbPageContext Rl;
    final /* synthetic */ Invite2GroupView djc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Invite2GroupView invite2GroupView, TbPageContext tbPageContext) {
        this.djc = invite2GroupView;
        this.Rl = tbPageContext;
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
            textView = this.djc.dja;
            textView.setTextColor(this.djc.getContext().getResources().getColor(w.e.common_color_10228));
            textView2 = this.djc.dja;
            textView2.setOnClickListener(new e(this, this.Rl));
        }
    }
}
