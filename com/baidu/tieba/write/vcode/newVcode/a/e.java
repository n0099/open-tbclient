package com.baidu.tieba.write.vcode.newVcode.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.r;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ d fAl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.fAl = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        NewVcodeView newVcodeView;
        String str;
        NewVcodeView newVcodeView2;
        String str2;
        NewVcodeView newVcodeView3;
        NewVcodeView newVcodeView4;
        newVcodeView = this.fAl.fAe;
        if (newVcodeView != null) {
            str = this.fAl.fAj;
            if (StringUtils.isNull(str)) {
                newVcodeView3 = this.fAl.fAe;
                newVcodeView4 = this.fAl.fAe;
                newVcodeView3.showToast(false, newVcodeView4.getContext().getResources().getString(r.j.drag_vcode_error));
                return;
            }
            newVcodeView2 = this.fAl.fAe;
            str2 = this.fAl.fAj;
            newVcodeView2.showToast(false, str2);
        }
    }
}
