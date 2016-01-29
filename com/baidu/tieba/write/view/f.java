package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bi;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class f implements bi.a {
    private final /* synthetic */ AtomicBoolean Yp;
    final /* synthetic */ e eql;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, AtomicBoolean atomicBoolean) {
        this.eql = eVar;
        this.Yp = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bi.a
    public boolean A(View view) {
        if (view instanceof EditText) {
            this.Yp.set(true);
            return true;
        }
        return false;
    }
}
