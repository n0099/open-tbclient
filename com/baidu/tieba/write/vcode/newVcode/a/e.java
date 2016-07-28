package com.baidu.tieba.write.vcode.newVcode.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.u;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ d fRQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.fRQ = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        NewVcodeView newVcodeView;
        String str;
        NewVcodeView newVcodeView2;
        String str2;
        NewVcodeView newVcodeView3;
        NewVcodeView newVcodeView4;
        newVcodeView = this.fRQ.fRJ;
        if (newVcodeView != null) {
            str = this.fRQ.fRO;
            if (StringUtils.isNull(str)) {
                newVcodeView3 = this.fRQ.fRJ;
                newVcodeView4 = this.fRQ.fRJ;
                newVcodeView3.showToast(false, newVcodeView4.getContext().getResources().getString(u.j.drag_vcode_error));
                return;
            }
            newVcodeView2 = this.fRQ.fRJ;
            str2 = this.fRQ.fRO;
            newVcodeView2.showToast(false, str2);
        }
    }
}
