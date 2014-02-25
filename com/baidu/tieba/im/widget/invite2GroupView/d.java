package com.baidu.tieba.im.widget.invite2GroupView;

import android.widget.Button;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ Invite2GroupView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Invite2GroupView invite2GroupView) {
        this.a = invite2GroupView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        Button button;
        Button button2;
        if (bool == null) {
            bool = false;
        }
        if (!bool.booleanValue()) {
            button = this.a.d;
            button.setTextColor(this.a.getContext().getResources().getColor(R.color.group_info_join_disable_color));
            button2 = this.a.d;
            button2.setOnClickListener(new e(this));
        }
    }
}
