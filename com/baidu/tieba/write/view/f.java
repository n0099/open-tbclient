package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bn;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class f implements bn.a {
    private final /* synthetic */ AtomicBoolean Sl;
    final /* synthetic */ e fGA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, AtomicBoolean atomicBoolean) {
        this.fGA = eVar;
        this.Sl = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bn.a
    public boolean z(View view) {
        if (view instanceof EditText) {
            this.Sl.set(true);
            return true;
        }
        return false;
    }
}
