package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bb;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class f implements bb.a {
    private final /* synthetic */ AtomicBoolean WG;
    final /* synthetic */ e cSQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, AtomicBoolean atomicBoolean) {
        this.cSQ = eVar;
        this.WG = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bb.a
    public boolean n(View view) {
        if (view instanceof EditText) {
            this.WG.set(true);
            return true;
        }
        return false;
    }
}
