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
public class i implements x {
    final /* synthetic */ h ghL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.ghL = hVar;
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
            aVar = this.ghL.ghJ;
            if (aVar != null) {
                aVar5 = this.ghL.ghJ;
                z = aVar5.bsR();
            } else {
                z = false;
            }
            if (!isChecked && z) {
                aVar4 = this.ghL.ghJ;
                aVar4.bsS();
            }
            if (isChecked || !z) {
                checkBox.setChecked(checkBox.isChecked() ? false : true);
                ((TransmitForumData) vVar).aaP = checkBox.isChecked();
                aVar2 = this.ghL.ghJ;
                if (aVar2 != null) {
                    aVar3 = this.ghL.ghJ;
                    aVar3.bsT();
                }
            }
        }
    }
}
