package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class ay implements AdapterView.OnItemClickListener {
    final /* synthetic */ at bCz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(at atVar) {
        this.bCz = atVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bb bbVar;
        bb bbVar2;
        bb bbVar3;
        PersonFriendActivity ZZ;
        bbVar = this.bCz.bCr;
        if (bbVar != null) {
            bbVar2 = this.bCz.bCr;
            if (bbVar2.getItemViewType(i) == 0) {
                bbVar3 = this.bCz.bCr;
                UserData userData = (UserData) bbVar3.getItem(i);
                if (userData != null && userData.getUserId() != null) {
                    at atVar = this.bCz;
                    ZZ = this.bCz.ZZ();
                    atVar.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ZZ, userData.getUserId(), userData.getName_show())));
                }
            }
        }
    }
}
