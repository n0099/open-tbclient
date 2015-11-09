package com.baidu.tieba.pb.pb.main;

import android.widget.CompoundButton;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dc implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ ct cmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(ct ctVar) {
        this.cmY = ctVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        List list;
        List<com.baidu.tieba.pb.pb.main.b.a> list2;
        String str;
        String str2;
        if (z) {
            this.cmY.cmw = (String) compoundButton.getTag();
            list = this.cmY.clz;
            if (list != null) {
                list2 = this.cmY.clz;
                for (com.baidu.tieba.pb.pb.main.b.a aVar : list2) {
                    String str3 = (String) aVar.getTag();
                    if (str3 != null) {
                        str = this.cmY.cmw;
                        if (str != null) {
                            str2 = this.cmY.cmw;
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
