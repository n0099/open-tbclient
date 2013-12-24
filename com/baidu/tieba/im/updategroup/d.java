package com.baidu.tieba.im.updategroup;

import android.content.Intent;
import com.baidu.tieba.im.message.bw;
import com.baidu.tieba.im.message.n;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ UpdateGroupActivity a;

    public d(UpdateGroupActivity updateGroupActivity) {
        this.a = updateGroupActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(n nVar) {
        a aVar;
        a aVar2;
        if (nVar != null && nVar.t() == 103102) {
            aVar = this.a.c;
            aVar.a(false);
            if (!(nVar instanceof bw)) {
                this.a.showToast(R.string.group_update_fail);
                return;
            }
            bw bwVar = (bw) nVar;
            if (bwVar.i()) {
                this.a.a(bwVar.k(), bwVar.j());
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
