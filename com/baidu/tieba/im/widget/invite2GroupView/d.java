package com.baidu.tieba.im.widget.invite2GroupView;

import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.util.f;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements f<Boolean> {
    private final /* synthetic */ TbPageContext LO;
    final /* synthetic */ Invite2GroupView dfU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Invite2GroupView invite2GroupView, TbPageContext tbPageContext) {
        this.dfU = invite2GroupView;
        this.LO = tbPageContext;
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
            textView = this.dfU.GZ;
            textView.setTextColor(this.dfU.getContext().getResources().getColor(r.e.common_color_10228));
            textView2 = this.dfU.GZ;
            textView2.setOnClickListener(new e(this, this.LO));
        }
    }
}
