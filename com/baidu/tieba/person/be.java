package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class be implements AdapterView.OnItemClickListener {
    final /* synthetic */ az efi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(az azVar) {
        this.efi = azVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bh bhVar;
        bh bhVar2;
        bh bhVar3;
        PersonFriendActivity aKM;
        bhVar = this.efi.efb;
        if (bhVar != null) {
            bhVar2 = this.efi.efb;
            if (bhVar2.getItemViewType(i) == 0) {
                bhVar3 = this.efi.efb;
                UserData userData = (UserData) bhVar3.getItem(i);
                if (userData != null && userData.getUserId() != null) {
                    az azVar = this.efi;
                    aKM = this.efi.aKM();
                    azVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(aKM.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        }
    }
}
