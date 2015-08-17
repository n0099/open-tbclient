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
    final /* synthetic */ r ciI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(r rVar) {
        this.ciI = rVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ac acVar;
        boolean z;
        ac acVar2;
        PersonBarActivity agd;
        boolean z2;
        PersonBarActivity agd2;
        PersonBarActivity agd3;
        PersonBarActivity agd4;
        acVar = this.ciI.cis;
        if (acVar.getItem(i) != null) {
            z = this.ciI.cix;
            if (!z) {
                this.ciI.bWM = i;
                acVar2 = this.ciI.cis;
                ForumData forumData = (ForumData) acVar2.getItem(i);
                if (forumData != null) {
                    agd = this.ciI.agd();
                    if (agd != null) {
                        z2 = this.ciI.chs;
                        if (z2) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            agd3 = this.ciI.agd();
                            this.ciI.agd();
                            agd3.setResult(-1, intent);
                            agd4 = this.ciI.agd();
                            agd4.finish();
                            return;
                        }
                        r rVar = this.ciI;
                        agd2 = this.ciI.agd();
                        rVar.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(agd2.getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        }
    }
}
