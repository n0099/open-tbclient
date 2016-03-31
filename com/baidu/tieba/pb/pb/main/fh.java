package com.baidu.tieba.pb.pb.main;

import android.widget.CompoundButton;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fh implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ eu dnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fh(eu euVar) {
        this.dnc = euVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        List list;
        List<com.baidu.tieba.pb.pb.main.b.a> list2;
        String str;
        String str2;
        if (z) {
            this.dnc.dlP = (String) compoundButton.getTag();
            list = this.dnc.dkH;
            if (list != null) {
                list2 = this.dnc.dkH;
                for (com.baidu.tieba.pb.pb.main.b.a aVar : list2) {
                    String str3 = (String) aVar.getTag();
                    if (str3 != null) {
                        str = this.dnc.dlP;
                        if (str != null) {
                            str2 = this.dnc.dlP;
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
