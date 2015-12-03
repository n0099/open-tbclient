package com.baidu.tieba.pb.pb.main;

import android.widget.CompoundButton;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dj implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ da cGh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(da daVar) {
        this.cGh = daVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        List list;
        List<com.baidu.tieba.pb.pb.main.b.a> list2;
        String str;
        String str2;
        if (z) {
            this.cGh.cFn = (String) compoundButton.getTag();
            list = this.cGh.cEn;
            if (list != null) {
                list2 = this.cGh.cEn;
                for (com.baidu.tieba.pb.pb.main.b.a aVar : list2) {
                    String str3 = (String) aVar.getTag();
                    if (str3 != null) {
                        str = this.cGh.cFn;
                        if (str != null) {
                            str2 = this.cGh.cFn;
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
