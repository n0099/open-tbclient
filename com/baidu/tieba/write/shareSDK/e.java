package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class e implements View.OnFocusChangeListener {
    final /* synthetic */ WriteShareActivity cAu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WriteShareActivity writeShareActivity) {
        this.cAu = writeShareActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r4 == r0.asM()) goto L19;
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
        qVar = this.cAu.cAf;
        if (qVar != null) {
            qVar2 = this.cAu.cAf;
            if (view != qVar2.asI()) {
                qVar11 = this.cAu.cAf;
                if (view != qVar11.asL()) {
                    qVar12 = this.cAu.cAf;
                }
            }
            if (!z) {
                qVar3 = this.cAu.cAf;
                if (view == qVar3.asI()) {
                    qVar4 = this.cAu.cAf;
                    if (qVar4.asN() != null) {
                        qVar5 = this.cAu.cAf;
                        qVar5.asN().setVisibility(0);
                    }
                }
            } else {
                WriteShareActivity writeShareActivity = this.cAu;
                inputMethodManager = this.cAu.mInputManager;
                qVar6 = this.cAu.cAf;
                writeShareActivity.ShowSoftKeyPad(inputMethodManager, qVar6.asI());
            }
            qVar7 = this.cAu.cAf;
            if (view == qVar7.asJ()) {
                if (z) {
                    qVar10 = this.cAu.cAf;
                    qVar10.asJ().setHint((CharSequence) null);
                } else {
                    qVar8 = this.cAu.cAf;
                    qVar8.asJ().setHint(com.baidu.tieba.t.content);
                }
                WriteShareActivity writeShareActivity2 = this.cAu;
                inputMethodManager2 = this.cAu.mInputManager;
                qVar9 = this.cAu.cAf;
                writeShareActivity2.ShowSoftKeyPad(inputMethodManager2, qVar9.asI());
            }
        }
    }
}
