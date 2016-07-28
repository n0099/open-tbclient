package com.baidu.tieba.pb.pb.main;

import android.widget.CompoundButton;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fj implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ ew eiu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fj(ew ewVar) {
        this.eiu = ewVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        List list;
        List<com.baidu.tieba.pb.pb.main.b.a> list2;
        String str;
        String str2;
        if (z) {
            this.eiu.ehi = (String) compoundButton.getTag();
            list = this.eiu.efW;
            if (list != null) {
                list2 = this.eiu.efW;
                for (com.baidu.tieba.pb.pb.main.b.a aVar : list2) {
                    String str3 = (String) aVar.getTag();
                    if (str3 != null) {
                        str = this.eiu.ehi;
                        if (str != null) {
                            str2 = this.eiu.ehi;
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
