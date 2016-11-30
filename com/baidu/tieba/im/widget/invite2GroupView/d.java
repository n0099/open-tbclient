package com.baidu.tieba.im.widget.invite2GroupView;

import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.util.f;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements f<Boolean> {
    private final /* synthetic */ TbPageContext MD;
    final /* synthetic */ Invite2GroupView dtL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Invite2GroupView invite2GroupView, TbPageContext tbPageContext) {
        this.dtL = invite2GroupView;
        this.MD = tbPageContext;
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
            textView = this.dtL.HQ;
            textView.setTextColor(this.dtL.getContext().getResources().getColor(r.d.common_color_10228));
            textView2 = this.dtL.HQ;
            textView2.setOnClickListener(new e(this, this.MD));
        }
    }
}
