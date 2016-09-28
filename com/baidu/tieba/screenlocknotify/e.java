package com.baidu.tieba.screenlocknotify;

import android.view.View;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import java.util.List;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ ScreenLockActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ScreenLockActivity screenLockActivity) {
        this.this$0 = screenLockActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        List<p> bcy = f.bcw().bcy();
        if (bcy != null && bcy.size() > 0 && (pVar = bcy.get(0)) != null) {
            TiebaStatic.log(new ax("c11704").g(PbActivityConfig.KEY_MSG_ID, pVar.msgId));
        }
        this.this$0.finish();
        f.bcw().fft.bcE();
    }
}
