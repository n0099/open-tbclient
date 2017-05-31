package com.baidu.tieba.write.vcode.newVcode.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.w;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ d fXd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.fXd = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        NewVcodeView newVcodeView;
        String str;
        NewVcodeView newVcodeView2;
        String str2;
        NewVcodeView newVcodeView3;
        NewVcodeView newVcodeView4;
        newVcodeView = this.fXd.fWZ;
        if (newVcodeView != null) {
            str = this.fXd.mErrorToastOnStart;
            if (StringUtils.isNull(str)) {
                newVcodeView3 = this.fXd.fWZ;
                newVcodeView4 = this.fXd.fWZ;
                newVcodeView3.showToast(false, newVcodeView4.getContext().getResources().getString(w.l.drag_vcode_error));
                return;
            }
            newVcodeView2 = this.fXd.fWZ;
            str2 = this.fXd.mErrorToastOnStart;
            newVcodeView2.showToast(false, str2);
        }
    }
}
