package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bj;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class f implements bj.a {
    private final /* synthetic */ AtomicBoolean Xz;
    final /* synthetic */ e dNT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, AtomicBoolean atomicBoolean) {
        this.dNT = eVar;
        this.Xz = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bj.a
    public boolean n(View view) {
        if (view instanceof EditText) {
            this.Xz.set(true);
            return true;
        }
        return false;
    }
}
