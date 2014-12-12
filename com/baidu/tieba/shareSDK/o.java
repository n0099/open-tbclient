package com.baidu.tieba.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class o implements View.OnFocusChangeListener {
    final /* synthetic */ WriteShareActivity bNV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(WriteShareActivity writeShareActivity) {
        this.bNV = writeShareActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r4 == r0.acM()) goto L19;
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
        qVar = this.bNV.bNH;
        if (qVar != null) {
            qVar2 = this.bNV.bNH;
            if (view != qVar2.acI()) {
                qVar11 = this.bNV.bNH;
                if (view != qVar11.acL()) {
                    qVar12 = this.bNV.bNH;
                }
            }
            if (!z) {
                qVar3 = this.bNV.bNH;
                if (view == qVar3.acI()) {
                    qVar4 = this.bNV.bNH;
                    if (qVar4.acN() != null) {
                        qVar5 = this.bNV.bNH;
                        qVar5.acN().setVisibility(0);
                    }
                }
            } else {
                WriteShareActivity writeShareActivity = this.bNV;
                inputMethodManager = this.bNV.mInputManager;
                qVar6 = this.bNV.bNH;
                writeShareActivity.ShowSoftKeyPad(inputMethodManager, qVar6.acI());
            }
            qVar7 = this.bNV.bNH;
            if (view == qVar7.acJ()) {
                if (z) {
                    qVar10 = this.bNV.bNH;
                    qVar10.acJ().setHint((CharSequence) null);
                } else {
                    qVar8 = this.bNV.bNH;
                    qVar8.acJ().setHint(z.content);
                }
                WriteShareActivity writeShareActivity2 = this.bNV;
                inputMethodManager2 = this.bNV.mInputManager;
                qVar9 = this.bNV.bNH;
                writeShareActivity2.ShowSoftKeyPad(inputMethodManager2, qVar9.acI());
            }
        }
    }
}
