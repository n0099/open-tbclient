package com.baidu.tieba.pb.pb.main;

import android.widget.CompoundButton;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fe implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ er egZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fe(er erVar) {
        this.egZ = erVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        List list;
        List<com.baidu.tieba.pb.pb.main.view.a> list2;
        String str;
        String str2;
        if (z) {
            this.egZ.efP = (String) compoundButton.getTag();
            list = this.egZ.eeK;
            if (list != null) {
                list2 = this.egZ.eeK;
                for (com.baidu.tieba.pb.pb.main.view.a aVar : list2) {
                    String str3 = (String) aVar.getTag();
                    if (str3 != null) {
                        str = this.egZ.efP;
                        if (str != null) {
                            str2 = this.egZ.efP;
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
