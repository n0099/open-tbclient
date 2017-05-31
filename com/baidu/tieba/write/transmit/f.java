package com.baidu.tieba.write.transmit;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements x {
    final /* synthetic */ e fWK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.fWK = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void a(View view, v vVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        a aVar;
        boolean z;
        a aVar2;
        a aVar3;
        a aVar4;
        a aVar5;
        if (vVar instanceof TransmitForumData) {
            CheckBox checkBox = (CheckBox) view.findViewById(w.h.transmit_check_box);
            boolean isChecked = checkBox.isChecked();
            aVar = this.fWK.fWI;
            if (aVar != null) {
                aVar5 = this.fWK.fWI;
                z = aVar5.bot();
            } else {
                z = false;
            }
            if (!isChecked && z) {
                aVar4 = this.fWK.fWI;
                aVar4.bou();
            }
            if (isChecked || !z) {
                checkBox.setChecked(checkBox.isChecked() ? false : true);
                ((TransmitForumData) vVar).aaO = checkBox.isChecked();
                aVar2 = this.fWK.fWI;
                if (aVar2 != null) {
                    aVar3 = this.fWK.fWI;
                    aVar3.bov();
                }
            }
        }
    }
}
