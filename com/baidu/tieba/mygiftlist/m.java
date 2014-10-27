package com.baidu.tieba.mygiftlist;

import android.view.View;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ k btD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.btD = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        MyGiftListActivity myGiftListActivity;
        String str2;
        String str3;
        MyGiftListActivity myGiftListActivity2;
        MyGiftListActivity myGiftListActivity3;
        str = this.btD.btw;
        if (ay.aA(str)) {
            myGiftListActivity2 = this.btD.btc;
            myGiftListActivity3 = this.btD.btc;
            UtilHelper.showToast(myGiftListActivity2, myGiftListActivity3.getResources().getString(y.error_unkown_try_again));
            return;
        }
        myGiftListActivity = this.btD.btc;
        str2 = this.btD.btx;
        str3 = this.btD.btw;
        TbWebViewActivity.startActivity(myGiftListActivity, str2, str3, true, false, true, true, null);
    }
}
