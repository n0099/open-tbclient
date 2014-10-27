package com.baidu.tieba.person;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class v implements AdapterView.OnItemClickListener {
    final /* synthetic */ o bBB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(o oVar) {
        this.bBB = oVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x xVar;
        boolean z;
        x xVar2;
        PersonBarActivity ZM;
        boolean z2;
        PersonBarActivity ZM2;
        PersonBarActivity ZM3;
        PersonBarActivity ZM4;
        xVar = this.bBB.bBt;
        if (xVar.getItem(i) != null) {
            z = this.bBB.bBx;
            if (!z) {
                this.bBB.bAU = i;
                xVar2 = this.bBB.bBt;
                ForumData forumData = (ForumData) xVar2.getItem(i);
                if (forumData != null) {
                    ZM = this.bBB.ZM();
                    if (ZM != null) {
                        z2 = this.bBB.bAN;
                        if (z2) {
                            Intent intent = new Intent();
                            intent.putExtra("bar_name", forumData.getName());
                            intent.putExtra("bar_id", forumData.getId());
                            ZM3 = this.bBB.ZM();
                            this.bBB.ZM();
                            ZM3.setResult(-1, intent);
                            ZM4 = this.bBB.ZM();
                            ZM4.finish();
                            return;
                        }
                        o oVar = this.bBB;
                        ZM2 = this.bBB.ZM();
                        oVar.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ZM2).createNormalCfg(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        }
    }
}
