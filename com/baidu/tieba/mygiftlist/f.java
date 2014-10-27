package com.baidu.tieba.mygiftlist;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.gift.BuyGiftActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ MyGiftListActivity bsZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MyGiftListActivity myGiftListActivity) {
        this.bsZ = myGiftListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        j jVar;
        z = this.bsZ.mIsHost;
        if (!z) {
            jVar = this.bsZ.bsT;
            long uid = jVar.getUid();
            if (uid != 0) {
                com.baidu.tbadk.core.i.l(this.bsZ, "gift_list_btn");
                this.bsZ.sendMessage(new CustomMessage(2002001, new BuyGiftActivityConfig(this.bsZ, uid)));
            }
        }
    }
}
