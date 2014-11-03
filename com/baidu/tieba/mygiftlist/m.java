package com.baidu.tieba.mygiftlist;

import android.view.View;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ k btR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.btR = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        MyGiftListActivity myGiftListActivity;
        String str2;
        String str3;
        MyGiftListActivity myGiftListActivity2;
        MyGiftListActivity myGiftListActivity3;
        str = this.btR.btK;
        if (az.aA(str)) {
            myGiftListActivity2 = this.btR.btr;
            myGiftListActivity3 = this.btR.btr;
            UtilHelper.showToast(myGiftListActivity2, myGiftListActivity3.getResources().getString(y.error_unkown_try_again));
            return;
        }
        myGiftListActivity = this.btR.btr;
        str2 = this.btR.btL;
        str3 = this.btR.btK;
        TbWebViewActivity.startActivity(myGiftListActivity, str2, str3, true, false, true, true, null);
    }
}
