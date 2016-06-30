package com.baidu.tieba.write.vcode.newVcode.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.u;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ d fFP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.fFP = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        NewVcodeView newVcodeView;
        String str;
        NewVcodeView newVcodeView2;
        String str2;
        NewVcodeView newVcodeView3;
        NewVcodeView newVcodeView4;
        newVcodeView = this.fFP.fFH;
        if (newVcodeView != null) {
            str = this.fFP.fFN;
            if (StringUtils.isNull(str)) {
                newVcodeView3 = this.fFP.fFH;
                newVcodeView4 = this.fFP.fFH;
                newVcodeView3.showToast(false, newVcodeView4.getContext().getResources().getString(u.j.drag_vcode_error));
                return;
            }
            newVcodeView2 = this.fFP.fFH;
            str2 = this.fFP.fFN;
            newVcodeView2.showToast(false, str2);
        }
    }
}
