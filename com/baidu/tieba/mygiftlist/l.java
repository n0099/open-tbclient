package com.baidu.tieba.mygiftlist;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
import tbclient.GetGiftMyList.GiftList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AdapterView.OnItemClickListener {
    final /* synthetic */ k btD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.btD = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z;
        g gVar;
        MyGiftListActivity myGiftListActivity;
        MyGiftListActivity myGiftListActivity2;
        com.baidu.tbadk.widget.i iVar;
        z = this.btD.mIsHost;
        if (!z) {
            gVar = this.btD.bty;
            GiftList item = gVar.getItem(i);
            if (item != null && item.sender != null && item.sender.id.longValue() > 0) {
                if (UtilHelper.isNetOk()) {
                    myGiftListActivity2 = this.btD.btc;
                    myGiftListActivity2.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.m251getInst().getApplicationContext(), String.valueOf(item.sender.id), item.sender.name_show)));
                    return;
                }
                myGiftListActivity = this.btD.btc;
                myGiftListActivity.showToast(y.neterror);
                return;
            }
            return;
        }
        iVar = this.btD.btC;
        iVar.dP((String) view.getTag(v.tag_second));
    }
}
