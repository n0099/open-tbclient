package com.baidu.tieba.write.vcode.newVcode.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.r;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ d gee;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.gee = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        NewVcodeView newVcodeView;
        String str;
        NewVcodeView newVcodeView2;
        String str2;
        NewVcodeView newVcodeView3;
        NewVcodeView newVcodeView4;
        newVcodeView = this.gee.gdX;
        if (newVcodeView != null) {
            str = this.gee.gec;
            if (StringUtils.isNull(str)) {
                newVcodeView3 = this.gee.gdX;
                newVcodeView4 = this.gee.gdX;
                newVcodeView3.showToast(false, newVcodeView4.getContext().getResources().getString(r.j.drag_vcode_error));
                return;
            }
            newVcodeView2 = this.gee.gdX;
            str2 = this.gee.gec;
            newVcodeView2.showToast(false, str2);
        }
    }
}
