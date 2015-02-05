package com.baidu.tieba.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class o implements View.OnFocusChangeListener {
    final /* synthetic */ WriteShareActivity bPE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(WriteShareActivity writeShareActivity) {
        this.bPE = writeShareActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r4 == r0.adl()) goto L19;
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
        qVar = this.bPE.bPq;
        if (qVar != null) {
            qVar2 = this.bPE.bPq;
            if (view != qVar2.adh()) {
                qVar11 = this.bPE.bPq;
                if (view != qVar11.adk()) {
                    qVar12 = this.bPE.bPq;
                }
            }
            if (!z) {
                qVar3 = this.bPE.bPq;
                if (view == qVar3.adh()) {
                    qVar4 = this.bPE.bPq;
                    if (qVar4.adm() != null) {
                        qVar5 = this.bPE.bPq;
                        qVar5.adm().setVisibility(0);
                    }
                }
            } else {
                WriteShareActivity writeShareActivity = this.bPE;
                inputMethodManager = this.bPE.mInputManager;
                qVar6 = this.bPE.bPq;
                writeShareActivity.ShowSoftKeyPad(inputMethodManager, qVar6.adh());
            }
            qVar7 = this.bPE.bPq;
            if (view == qVar7.adi()) {
                if (z) {
                    qVar10 = this.bPE.bPq;
                    qVar10.adi().setHint((CharSequence) null);
                } else {
                    qVar8 = this.bPE.bPq;
                    qVar8.adi().setHint(z.content);
                }
                WriteShareActivity writeShareActivity2 = this.bPE;
                inputMethodManager2 = this.bPE.mInputManager;
                qVar9 = this.bPE.bPq;
                writeShareActivity2.ShowSoftKeyPad(inputMethodManager2, qVar9.adh());
            }
        }
    }
}
