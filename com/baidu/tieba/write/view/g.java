package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bs;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class g implements bs {
    private final /* synthetic */ AtomicBoolean RO;
    final /* synthetic */ f cAZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, AtomicBoolean atomicBoolean) {
        this.cAZ = fVar;
        this.RO = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bs
    public boolean m(View view) {
        if (view instanceof EditText) {
            this.RO.set(true);
            return true;
        }
        return false;
    }
}
