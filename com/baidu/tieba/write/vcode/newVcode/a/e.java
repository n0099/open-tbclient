package com.baidu.tieba.write.vcode.newVcode.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.r;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ d fIK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.fIK = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        NewVcodeView newVcodeView;
        String str;
        NewVcodeView newVcodeView2;
        String str2;
        NewVcodeView newVcodeView3;
        NewVcodeView newVcodeView4;
        newVcodeView = this.fIK.fIG;
        if (newVcodeView != null) {
            str = this.fIK.mErrorToastOnStart;
            if (StringUtils.isNull(str)) {
                newVcodeView3 = this.fIK.fIG;
                newVcodeView4 = this.fIK.fIG;
                newVcodeView3.showToast(false, newVcodeView4.getContext().getResources().getString(r.l.drag_vcode_error));
                return;
            }
            newVcodeView2 = this.fIK.fIG;
            str2 = this.fIK.mErrorToastOnStart;
            newVcodeView2.showToast(false, str2);
        }
    }
}
