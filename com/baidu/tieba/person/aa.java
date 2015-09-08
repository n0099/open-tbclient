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
    final /* synthetic */ r cjC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(r rVar) {
        this.cjC = rVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ac acVar;
        boolean z;
        ac acVar2;
        PersonBarActivity agt;
        boolean z2;
        PersonBarActivity agt2;
        PersonBarActivity agt3;
        PersonBarActivity agt4;
        acVar = this.cjC.cjm;
        if (acVar.getItem(i) != null) {
            z = this.cjC.cjr;
            if (!z) {
                this.cjC.bXD = i;
                acVar2 = this.cjC.cjm;
                ForumData forumData = (ForumData) acVar2.getItem(i);
                if (forumData != null) {
                    agt = this.cjC.agt();
                    if (agt != null) {
                        z2 = this.cjC.cim;
                        if (z2) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            agt3 = this.cjC.agt();
                            this.cjC.agt();
                            agt3.setResult(-1, intent);
                            agt4 = this.cjC.agt();
                            agt4.finish();
                            return;
                        }
                        r rVar = this.cjC;
                        agt2 = this.cjC.agt();
                        rVar.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(agt2.getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        }
    }
}
