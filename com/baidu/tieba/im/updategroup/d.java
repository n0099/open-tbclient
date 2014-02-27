package com.baidu.tieba.im.updategroup;

import android.content.Intent;
import com.baidu.tieba.im.message.cw;
import com.baidu.tieba.im.message.s;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class d implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ UpdateGroupActivity a;

    public d(UpdateGroupActivity updateGroupActivity) {
        this.a = updateGroupActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(s sVar) {
        a aVar;
        a aVar2;
        if (sVar != null && sVar.w() == 103102) {
            aVar = this.a.c;
            aVar.a(false);
            if (!(sVar instanceof cw)) {
                this.a.showToast(R.string.group_update_fail);
                return;
            }
            cw cwVar = (cw) sVar;
            if (cwVar.l()) {
                UpdateGroupActivity.a(this.a, cwVar.n(), cwVar.m());
                return;
            }
            this.a.showToast(R.string.group_update_success);
            Intent intent = this.a.getIntent();
            aVar2 = this.a.c;
            intent.putExtra("group_text", aVar2.k());
            this.a.setResult(-1, intent);
            this.a.finish();
        }
    }
}
