package com.baidu.tieba.mygiftlist;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.gift.BuyGiftActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ MyGiftListActivity bto;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MyGiftListActivity myGiftListActivity) {
        this.bto = myGiftListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        j jVar;
        z = this.bto.mIsHost;
        if (!z) {
            jVar = this.bto.bth;
            long uid = jVar.getUid();
            if (uid != 0) {
                com.baidu.tbadk.core.j.l(this.bto, "gift_list_btn");
                this.bto.sendMessage(new CustomMessage(2002001, new BuyGiftActivityConfig(this.bto, uid)));
            }
        }
    }
}
