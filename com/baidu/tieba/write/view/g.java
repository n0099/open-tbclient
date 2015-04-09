package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bu;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class g implements bu {
    private final /* synthetic */ AtomicBoolean Rp;
    final /* synthetic */ f cwI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, AtomicBoolean atomicBoolean) {
        this.cwI = fVar;
        this.Rp = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bu
    public boolean k(View view) {
        if (view instanceof EditText) {
            this.Rp.set(true);
            return true;
        }
        return false;
    }
}
