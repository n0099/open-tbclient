package com.baidu.tieba.mygiftlist;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g btf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.btf = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MyGiftListActivity myGiftListActivity;
        MyGiftListActivity myGiftListActivity2;
        if (UtilHelper.isNetOk()) {
            myGiftListActivity2 = this.btf.btc;
            myGiftListActivity2.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.m251getInst().getApplicationContext(), String.valueOf((Long) view.getTag(v.tag_first)), (String) view.getTag(v.tag_second))));
            return;
        }
        myGiftListActivity = this.btf.btc;
        myGiftListActivity.showToast(y.neterror);
    }
}
