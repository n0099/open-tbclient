package com.baidu.tieba.person;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class ae implements AdapterView.OnItemClickListener {
    final /* synthetic */ v bSc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(v vVar) {
        this.bSc = vVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ag agVar;
        boolean z;
        ag agVar2;
        PersonBarActivity aem;
        boolean z2;
        PersonBarActivity aem2;
        PersonBarActivity aem3;
        PersonBarActivity aem4;
        agVar = this.bSc.bRN;
        if (agVar.getItem(i) != null) {
            z = this.bSc.bRS;
            if (!z) {
                this.bSc.bGT = i;
                agVar2 = this.bSc.bRN;
                ForumData forumData = (ForumData) agVar2.getItem(i);
                if (forumData != null) {
                    aem = this.bSc.aem();
                    if (aem != null) {
                        z2 = this.bSc.bQP;
                        if (z2) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            aem3 = this.bSc.aem();
                            this.bSc.aem();
                            aem3.setResult(-1, intent);
                            aem4 = this.bSc.aem();
                            aem4.finish();
                            return;
                        }
                        v vVar = this.bSc;
                        aem2 = this.bSc.aem();
                        vVar.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(aem2.getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        }
    }
}
