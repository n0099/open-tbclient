package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.df;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class av implements df.a {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.df.a
    public void g(int i, String str, String str2) {
        eu euVar;
        if (StringUtils.isNull(str)) {
            if (i == 0) {
                this.dht.showToast(t.j.upgrage_toast_dialog);
            } else {
                this.dht.showToast(t.j.neterror);
            }
        } else if (i != 0 && !TextUtils.isEmpty(str2)) {
            this.dht.dhn = str2;
            euVar = this.dht.dgF;
            euVar.mc(str);
        } else {
            this.dht.showToast(str);
        }
    }
}
