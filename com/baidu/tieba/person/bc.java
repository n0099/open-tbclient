package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class bc implements AdapterView.OnItemClickListener {
    final /* synthetic */ ax cPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(ax axVar) {
        this.cPw = axVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        PersonFriendActivity aoW;
        bfVar = this.cPw.cPo;
        if (bfVar != null) {
            bfVar2 = this.cPw.cPo;
            if (bfVar2.getItemViewType(i) == 0) {
                bfVar3 = this.cPw.cPo;
                UserData userData = (UserData) bfVar3.getItem(i);
                if (userData != null && userData.getUserId() != null) {
                    ax axVar = this.cPw;
                    aoW = this.cPw.aoW();
                    axVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(aoW.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        }
    }
}
