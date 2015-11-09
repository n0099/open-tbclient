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
    final /* synthetic */ r cqM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(r rVar) {
        this.cqM = rVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ac acVar;
        boolean z;
        ac acVar2;
        PersonBarActivity aiU;
        boolean z2;
        PersonBarActivity aiU2;
        PersonBarActivity aiU3;
        PersonBarActivity aiU4;
        acVar = this.cqM.cqw;
        if (acVar.getItem(i) != null) {
            z = this.cqM.cqB;
            if (!z) {
                this.cqM.ccb = i;
                acVar2 = this.cqM.cqw;
                ForumData forumData = (ForumData) acVar2.getItem(i);
                if (forumData != null) {
                    aiU = this.cqM.aiU();
                    if (aiU != null) {
                        z2 = this.cqM.cpp;
                        if (z2) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            aiU3 = this.cqM.aiU();
                            this.cqM.aiU();
                            aiU3.setResult(-1, intent);
                            aiU4 = this.cqM.aiU();
                            aiU4.finish();
                            return;
                        }
                        r rVar = this.cqM;
                        aiU2 = this.cqM.aiU();
                        rVar.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(aiU2.getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        }
    }
}
