package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class ao implements AdapterView.OnItemClickListener {
    final /* synthetic */ aj bQu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(aj ajVar) {
        this.bQu = ajVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ar arVar;
        ar arVar2;
        ar arVar3;
        PersonFriendActivity adq;
        arVar = this.bQu.bQn;
        if (arVar != null) {
            arVar2 = this.bQu.bQn;
            if (arVar2.getItemViewType(i) == 0) {
                arVar3 = this.bQu.bQn;
                UserData userData = (UserData) arVar3.getItem(i);
                if (userData != null && userData.getUserId() != null) {
                    aj ajVar = this.bQu;
                    adq = this.bQu.adq();
                    ajVar.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(adq.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        }
    }
}
