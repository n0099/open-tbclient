package com.baidu.tieba.im.widget.invite2GroupView;

import android.widget.Button;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.g;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements g<Boolean> {
    private final /* synthetic */ TbPageContext MF;
    final /* synthetic */ Invite2GroupView brd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Invite2GroupView invite2GroupView, TbPageContext tbPageContext) {
        this.brd = invite2GroupView;
        this.MF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        Button button;
        Button button2;
        if (bool == null) {
            bool = false;
        }
        if (!bool.booleanValue()) {
            button = this.brd.brb;
            button.setTextColor(this.brd.getContext().getResources().getColor(t.group_info_join_disable_color));
            button2 = this.brd.brb;
            button2.setOnClickListener(new e(this, this.MF));
        }
    }
}
