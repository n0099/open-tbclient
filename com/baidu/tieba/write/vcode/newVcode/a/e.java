package com.baidu.tieba.write.vcode.newVcode.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ d gbV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.gbV = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        NewVcodeView newVcodeView;
        String str;
        NewVcodeView newVcodeView2;
        String str2;
        NewVcodeView newVcodeView3;
        NewVcodeView newVcodeView4;
        newVcodeView = this.gbV.gbO;
        if (newVcodeView != null) {
            str = this.gbV.gbT;
            if (StringUtils.isNull(str)) {
                newVcodeView3 = this.gbV.gbO;
                newVcodeView4 = this.gbV.gbO;
                newVcodeView3.showToast(false, newVcodeView4.getContext().getResources().getString(t.j.drag_vcode_error));
                return;
            }
            newVcodeView2 = this.gbV.gbO;
            str2 = this.gbV.gbT;
            newVcodeView2.showToast(false, str2);
        }
    }
}
