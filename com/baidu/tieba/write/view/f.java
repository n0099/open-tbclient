package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bl;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class f implements bl.a {
    private final /* synthetic */ AtomicBoolean RT;
    final /* synthetic */ e faX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, AtomicBoolean atomicBoolean) {
        this.faX = eVar;
        this.RT = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bl.a
    public boolean A(View view) {
        if (view instanceof EditText) {
            this.RT.set(true);
            return true;
        }
        return false;
    }
}
