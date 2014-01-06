package com.baidu.tieba.im.updategroup;

import android.content.Intent;
import com.baidu.tieba.im.message.bz;
import com.baidu.tieba.im.message.o;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ UpdateGroupActivity a;

    public d(UpdateGroupActivity updateGroupActivity) {
        this.a = updateGroupActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(o oVar) {
        a aVar;
        a aVar2;
        if (oVar != null && oVar.u() == 103102) {
            aVar = this.a.c;
            aVar.a(false);
            if (!(oVar instanceof bz)) {
                this.a.showToast(R.string.group_update_fail);
                return;
            }
            bz bzVar = (bz) oVar;
            if (bzVar.i()) {
                this.a.a(bzVar.k(), bzVar.j());
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
