package com.baidu.tieba.im.widget.invite2GroupView;

import android.widget.Button;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ Invite2GroupView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Invite2GroupView invite2GroupView) {
        this.a = invite2GroupView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Boolean bool) {
        Button button;
        Button button2;
        Boolean bool2 = bool;
        if (bool2 == null) {
            bool2 = false;
        }
        if (bool2.booleanValue()) {
            return;
        }
        button = this.a.d;
        button.setTextColor(this.a.getContext().getResources().getColor(R.color.group_info_join_disable_color));
        button2 = this.a.d;
        button2.setOnClickListener(new e(this));
    }
}
