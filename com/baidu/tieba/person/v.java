package com.baidu.tieba.person;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class v implements AdapterView.OnItemClickListener {
    final /* synthetic */ o bBP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(o oVar) {
        this.bBP = oVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x xVar;
        boolean z;
        x xVar2;
        PersonBarActivity ZO;
        boolean z2;
        PersonBarActivity ZO2;
        PersonBarActivity ZO3;
        PersonBarActivity ZO4;
        xVar = this.bBP.bBH;
        if (xVar.getItem(i) != null) {
            z = this.bBP.bBL;
            if (!z) {
                this.bBP.bBi = i;
                xVar2 = this.bBP.bBH;
                ForumData forumData = (ForumData) xVar2.getItem(i);
                if (forumData != null) {
                    ZO = this.bBP.ZO();
                    if (ZO != null) {
                        z2 = this.bBP.bBb;
                        if (z2) {
                            Intent intent = new Intent();
                            intent.putExtra("bar_name", forumData.getName());
                            intent.putExtra("bar_id", forumData.getId());
                            ZO3 = this.bBP.ZO();
                            this.bBP.ZO();
                            ZO3.setResult(-1, intent);
                            ZO4 = this.bBP.ZO();
                            ZO4.finish();
                            return;
                        }
                        o oVar = this.bBP;
                        ZO2 = this.bBP.ZO();
                        oVar.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ZO2).createNormalCfg(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        }
    }
}
