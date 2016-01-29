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
class ab implements AdapterView.OnItemClickListener {
    final /* synthetic */ s cXR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(s sVar) {
        this.cXR = sVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ad adVar;
        boolean z;
        ad adVar2;
        PersonBarActivity atz;
        boolean z2;
        PersonBarActivity atz2;
        PersonBarActivity atz3;
        PersonBarActivity atz4;
        adVar = this.cXR.cXB;
        if (adVar.getItem(i) != null) {
            z = this.cXR.cXG;
            if (!z) {
                this.cXR.cEJ = i;
                adVar2 = this.cXR.cXB;
                ForumData forumData = (ForumData) adVar2.getItem(i);
                if (forumData != null) {
                    atz = this.cXR.atz();
                    if (atz != null) {
                        z2 = this.cXR.cWu;
                        if (z2) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            atz3 = this.cXR.atz();
                            this.cXR.atz();
                            atz3.setResult(-1, intent);
                            atz4 = this.cXR.atz();
                            atz4.finish();
                            return;
                        }
                        s sVar = this.cXR;
                        atz2 = this.cXR.atz();
                        sVar.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(atz2.getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        }
    }
}
