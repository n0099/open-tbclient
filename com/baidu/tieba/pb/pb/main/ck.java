package com.baidu.tieba.pb.pb.main;

import android.widget.CompoundButton;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ cc cly;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cc ccVar) {
        this.cly = ccVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        List list;
        List<com.baidu.tieba.pb.pb.main.b.a> list2;
        String str;
        String str2;
        if (z) {
            this.cly.ckX = (String) compoundButton.getTag();
            list = this.cly.ckb;
            if (list != null) {
                list2 = this.cly.ckb;
                for (com.baidu.tieba.pb.pb.main.b.a aVar : list2) {
                    String str3 = (String) aVar.getTag();
                    if (str3 != null) {
                        str = this.cly.ckX;
                        if (str != null) {
                            str2 = this.cly.ckX;
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
