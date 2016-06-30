package com.baidu.tieba.pb.pb.main;

import android.widget.CompoundButton;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ff implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ es dVR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ff(es esVar) {
        this.dVR = esVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        List list;
        List<com.baidu.tieba.pb.pb.main.b.a> list2;
        String str;
        String str2;
        if (z) {
            this.dVR.dUH = (String) compoundButton.getTag();
            list = this.dVR.dTu;
            if (list != null) {
                list2 = this.dVR.dTu;
                for (com.baidu.tieba.pb.pb.main.b.a aVar : list2) {
                    String str3 = (String) aVar.getTag();
                    if (str3 != null) {
                        str = this.dVR.dUH;
                        if (str != null) {
                            str2 = this.dVR.dUH;
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
