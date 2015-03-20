package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class ao implements AdapterView.OnItemClickListener {
    final /* synthetic */ aj bQe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(aj ajVar) {
        this.bQe = ajVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ar arVar;
        ar arVar2;
        ar arVar3;
        PersonFriendActivity adb;
        arVar = this.bQe.bPX;
        if (arVar != null) {
            arVar2 = this.bQe.bPX;
            if (arVar2.getItemViewType(i) == 0) {
                arVar3 = this.bQe.bPX;
                UserData userData = (UserData) arVar3.getItem(i);
                if (userData != null && userData.getUserId() != null) {
                    aj ajVar = this.bQe;
                    adb = this.bQe.adb();
                    ajVar.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(adb.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        }
    }
}
