package com.baidu.tieba.pb.pb.main;

import android.widget.CompoundButton;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fo implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ fa etn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fo(fa faVar) {
        this.etn = faVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        List list;
        List<com.baidu.tieba.pb.pb.main.view.a> list2;
        String str;
        String str2;
        if (z) {
            this.etn.erZ = (String) compoundButton.getTag();
            list = this.etn.eqQ;
            if (list != null) {
                list2 = this.etn.eqQ;
                for (com.baidu.tieba.pb.pb.main.view.a aVar : list2) {
                    String str3 = (String) aVar.getTag();
                    if (str3 != null) {
                        str = this.etn.erZ;
                        if (str != null) {
                            str2 = this.etn.erZ;
                            if (!str3.equals(str2)) {
                                aVar.setChecked(false);
                            }
                        }
                    }
                }
            }
        }
    }
}
