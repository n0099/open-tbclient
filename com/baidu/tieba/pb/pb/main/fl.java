package com.baidu.tieba.pb.pb.main;

import android.widget.CompoundButton;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fl implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ ey eCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fl(ey eyVar) {
        this.eCT = eyVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        List list;
        List<com.baidu.tieba.pb.pb.main.view.a> list2;
        String str;
        String str2;
        if (z) {
            this.eCT.eBJ = (String) compoundButton.getTag();
            list = this.eCT.eAB;
            if (list != null) {
                list2 = this.eCT.eAB;
                for (com.baidu.tieba.pb.pb.main.view.a aVar : list2) {
                    String str3 = (String) aVar.getTag();
                    if (str3 != null) {
                        str = this.eCT.eBJ;
                        if (str != null) {
                            str2 = this.eCT.eBJ;
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
