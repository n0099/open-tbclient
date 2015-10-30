package com.baidu.tieba.person;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class aa implements AdapterView.OnItemClickListener {
    final /* synthetic */ r cpq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(r rVar) {
        this.cpq = rVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ac acVar;
        boolean z;
        ac acVar2;
        PersonBarActivity aio;
        boolean z2;
        PersonBarActivity aio2;
        PersonBarActivity aio3;
        PersonBarActivity aio4;
        acVar = this.cpq.cpa;
        if (acVar.getItem(i) != null) {
            z = this.cpq.cpf;
            if (!z) {
                this.cpq.cbA = i;
                acVar2 = this.cpq.cpa;
                ForumData forumData = (ForumData) acVar2.getItem(i);
                if (forumData != null) {
                    aio = this.cpq.aio();
                    if (aio != null) {
                        z2 = this.cpq.cnT;
                        if (z2) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            aio3 = this.cpq.aio();
                            this.cpq.aio();
                            aio3.setResult(-1, intent);
                            aio4 = this.cpq.aio();
                            aio4.finish();
                            return;
                        }
                        r rVar = this.cpq;
                        aio2 = this.cpq.aio();
                        rVar.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(aio2.getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        }
    }
}
