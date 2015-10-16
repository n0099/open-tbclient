package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bd;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class f implements bd.a {
    private final /* synthetic */ AtomicBoolean WJ;
    final /* synthetic */ e dnf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, AtomicBoolean atomicBoolean) {
        this.dnf = eVar;
        this.WJ = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bd.a
    public boolean n(View view) {
        if (view instanceof EditText) {
            this.WJ.set(true);
            return true;
        }
        return false;
    }
}
