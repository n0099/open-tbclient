package com.baidu.tieba.write.transmit;

import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements w {
    final /* synthetic */ e fOO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.fOO = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.w
    public void a(View view, v vVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        a aVar;
        boolean z;
        a aVar2;
        a aVar3;
        a aVar4;
        a aVar5;
        if (vVar instanceof TransmitForumData) {
            CheckBox checkBox = (CheckBox) view.findViewById(w.h.transmit_check_box);
            boolean isChecked = checkBox.isChecked();
            aVar = this.fOO.fOM;
            if (aVar != null) {
                aVar5 = this.fOO.fOM;
                z = aVar5.bmU();
            } else {
                z = false;
            }
            if (!isChecked && z) {
                aVar4 = this.fOO.fOM;
                aVar4.bmV();
            }
            if (isChecked || !z) {
                checkBox.setChecked(checkBox.isChecked() ? false : true);
                ((TransmitForumData) vVar).aaP = checkBox.isChecked();
                aVar2 = this.fOO.fOM;
                if (aVar2 != null) {
                    aVar3 = this.fOO.fOM;
                    aVar3.bmW();
                }
            }
        }
    }
}
