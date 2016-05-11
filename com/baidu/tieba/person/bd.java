package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class bd implements AdapterView.OnItemClickListener {
    final /* synthetic */ ay dwQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(ay ayVar) {
        this.dwQ = ayVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bg bgVar;
        bg bgVar2;
        bg bgVar3;
        PersonFriendActivity aBR;
        bgVar = this.dwQ.dwJ;
        if (bgVar != null) {
            bgVar2 = this.dwQ.dwJ;
            if (bgVar2.getItemViewType(i) == 0) {
                bgVar3 = this.dwQ.dwJ;
                UserData userData = (UserData) bgVar3.getItem(i);
                if (userData != null && userData.getUserId() != null) {
                    ay ayVar = this.dwQ;
                    aBR = this.dwQ.aBR();
                    ayVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(aBR.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        }
    }
}
