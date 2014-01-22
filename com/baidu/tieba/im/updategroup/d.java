package com.baidu.tieba.im.updategroup;

import android.content.Intent;
import com.baidu.tieba.im.message.cn;
import com.baidu.tieba.im.message.q;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ UpdateGroupActivity a;

    public d(UpdateGroupActivity updateGroupActivity) {
        this.a = updateGroupActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(q qVar) {
        a aVar;
        a aVar2;
        if (qVar != null && qVar.w() == 103102) {
            aVar = this.a.c;
            aVar.a(false);
            if (!(qVar instanceof cn)) {
                this.a.showToast(R.string.group_update_fail);
                return;
            }
            cn cnVar = (cn) qVar;
            if (cnVar.k()) {
                this.a.a(cnVar.m(), cnVar.l());
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
