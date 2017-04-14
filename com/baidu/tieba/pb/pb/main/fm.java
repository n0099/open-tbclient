package com.baidu.tieba.pb.pb.main;

import android.widget.CompoundButton;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fm implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ ey erv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fm(ey eyVar) {
        this.erv = eyVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        List list;
        List<com.baidu.tieba.pb.pb.main.view.a> list2;
        String str;
        String str2;
        if (z) {
            this.erv.eqi = (String) compoundButton.getTag();
            list = this.erv.eoZ;
            if (list != null) {
                list2 = this.erv.eoZ;
                for (com.baidu.tieba.pb.pb.main.view.a aVar : list2) {
                    String str3 = (String) aVar.getTag();
                    if (str3 != null) {
                        str = this.erv.eqi;
                        if (str != null) {
                            str2 = this.erv.eqi;
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
