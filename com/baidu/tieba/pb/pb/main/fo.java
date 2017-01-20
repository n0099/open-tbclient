package com.baidu.tieba.pb.pb.main;

import android.widget.CompoundButton;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fo implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ ez eqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fo(ez ezVar) {
        this.eqf = ezVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        List list;
        List<com.baidu.tieba.pb.pb.main.view.a> list2;
        String str;
        String str2;
        if (z) {
            this.eqf.eoV = (String) compoundButton.getTag();
            list = this.eqf.enO;
            if (list != null) {
                list2 = this.eqf.enO;
                for (com.baidu.tieba.pb.pb.main.view.a aVar : list2) {
                    String str3 = (String) aVar.getTag();
                    if (str3 != null) {
                        str = this.eqf.eoV;
                        if (str != null) {
                            str2 = this.eqf.eoV;
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
