package com.baidu.tieba.im.widget.invite2GroupView;

import android.widget.Button;
import com.baidu.tieba.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ Invite2GroupView bkr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Invite2GroupView invite2GroupView) {
        this.bkr = invite2GroupView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        Button button;
        Button button2;
        if (bool == null) {
            bool = false;
        }
        if (!bool.booleanValue()) {
            button = this.bkr.bkp;
            button.setTextColor(this.bkr.getContext().getResources().getColor(s.group_info_join_disable_color));
            button2 = this.bkr.bkp;
            button2.setOnClickListener(new e(this));
        }
    }
}
