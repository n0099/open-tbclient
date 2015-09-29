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
    final /* synthetic */ r cpf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(r rVar) {
        this.cpf = rVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ac acVar;
        boolean z;
        ac acVar2;
        PersonBarActivity ais;
        boolean z2;
        PersonBarActivity ais2;
        PersonBarActivity ais3;
        PersonBarActivity ais4;
        acVar = this.cpf.coP;
        if (acVar.getItem(i) != null) {
            z = this.cpf.coU;
            if (!z) {
                this.cpf.cbp = i;
                acVar2 = this.cpf.coP;
                ForumData forumData = (ForumData) acVar2.getItem(i);
                if (forumData != null) {
                    ais = this.cpf.ais();
                    if (ais != null) {
                        z2 = this.cpf.cnI;
                        if (z2) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            ais3 = this.cpf.ais();
                            this.cpf.ais();
                            ais3.setResult(-1, intent);
                            ais4 = this.cpf.ais();
                            ais4.finish();
                            return;
                        }
                        r rVar = this.cpf;
                        ais2 = this.cpf.ais();
                        rVar.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ais2.getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        }
    }
}
