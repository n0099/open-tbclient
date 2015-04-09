package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class e implements View.OnFocusChangeListener {
    final /* synthetic */ WriteShareActivity cwd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WriteShareActivity writeShareActivity) {
        this.cwd = writeShareActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r4 == r0.aqV()) goto L19;
     */
    @Override // android.view.View.OnFocusChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFocusChange(View view, boolean z) {
        q qVar;
        q qVar2;
        q qVar3;
        q qVar4;
        q qVar5;
        InputMethodManager inputMethodManager;
        q qVar6;
        q qVar7;
        q qVar8;
        InputMethodManager inputMethodManager2;
        q qVar9;
        q qVar10;
        q qVar11;
        q qVar12;
        qVar = this.cwd.cvO;
        if (qVar != null) {
            qVar2 = this.cwd.cvO;
            if (view != qVar2.aqR()) {
                qVar11 = this.cwd.cvO;
                if (view != qVar11.aqU()) {
                    qVar12 = this.cwd.cvO;
                }
            }
            if (!z) {
                qVar3 = this.cwd.cvO;
                if (view == qVar3.aqR()) {
                    qVar4 = this.cwd.cvO;
                    if (qVar4.aqW() != null) {
                        qVar5 = this.cwd.cvO;
                        qVar5.aqW().setVisibility(0);
                    }
                }
            } else {
                WriteShareActivity writeShareActivity = this.cwd;
                inputMethodManager = this.cwd.mInputManager;
                qVar6 = this.cwd.cvO;
                writeShareActivity.ShowSoftKeyPad(inputMethodManager, qVar6.aqR());
            }
            qVar7 = this.cwd.cvO;
            if (view == qVar7.aqS()) {
                if (z) {
                    qVar10 = this.cwd.cvO;
                    qVar10.aqS().setHint((CharSequence) null);
                } else {
                    qVar8 = this.cwd.cvO;
                    qVar8.aqS().setHint(com.baidu.tieba.y.content);
                }
                WriteShareActivity writeShareActivity2 = this.cwd;
                inputMethodManager2 = this.cwd.mInputManager;
                qVar9 = this.cwd.cvO;
                writeShareActivity2.ShowSoftKeyPad(inputMethodManager2, qVar9.aqR());
            }
        }
    }
}
