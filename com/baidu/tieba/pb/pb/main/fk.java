package com.baidu.tieba.pb.pb.main;

import android.widget.CompoundButton;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fk implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ ex ewH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fk(ex exVar) {
        this.ewH = exVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        List list;
        List<com.baidu.tieba.pb.pb.main.b.a> list2;
        String str;
        String str2;
        if (z) {
            this.ewH.evx = (String) compoundButton.getTag();
            list = this.ewH.euk;
            if (list != null) {
                list2 = this.ewH.euk;
                for (com.baidu.tieba.pb.pb.main.b.a aVar : list2) {
                    String str3 = (String) aVar.getTag();
                    if (str3 != null) {
                        str = this.ewH.evx;
                        if (str != null) {
                            str2 = this.ewH.evx;
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
