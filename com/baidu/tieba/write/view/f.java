package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bc;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class f implements bc.a {
    private final /* synthetic */ AtomicBoolean WH;
    final /* synthetic */ e dmF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, AtomicBoolean atomicBoolean) {
        this.dmF = eVar;
        this.WH = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bc.a
    public boolean n(View view) {
        if (view instanceof EditText) {
            this.WH.set(true);
            return true;
        }
        return false;
    }
}
