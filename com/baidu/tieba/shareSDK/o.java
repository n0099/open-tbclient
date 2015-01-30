package com.baidu.tieba.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class o implements View.OnFocusChangeListener {
    final /* synthetic */ WriteShareActivity bPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(WriteShareActivity writeShareActivity) {
        this.bPF = writeShareActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r4 == r0.adq()) goto L19;
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
        qVar = this.bPF.bPr;
        if (qVar != null) {
            qVar2 = this.bPF.bPr;
            if (view != qVar2.adm()) {
                qVar11 = this.bPF.bPr;
                if (view != qVar11.adp()) {
                    qVar12 = this.bPF.bPr;
                }
            }
            if (!z) {
                qVar3 = this.bPF.bPr;
                if (view == qVar3.adm()) {
                    qVar4 = this.bPF.bPr;
                    if (qVar4.adr() != null) {
                        qVar5 = this.bPF.bPr;
                        qVar5.adr().setVisibility(0);
                    }
                }
            } else {
                WriteShareActivity writeShareActivity = this.bPF;
                inputMethodManager = this.bPF.mInputManager;
                qVar6 = this.bPF.bPr;
                writeShareActivity.ShowSoftKeyPad(inputMethodManager, qVar6.adm());
            }
            qVar7 = this.bPF.bPr;
            if (view == qVar7.adn()) {
                if (z) {
                    qVar10 = this.bPF.bPr;
                    qVar10.adn().setHint((CharSequence) null);
                } else {
                    qVar8 = this.bPF.bPr;
                    qVar8.adn().setHint(z.content);
                }
                WriteShareActivity writeShareActivity2 = this.bPF;
                inputMethodManager2 = this.bPF.mInputManager;
                qVar9 = this.bPF.bPr;
                writeShareActivity2.ShowSoftKeyPad(inputMethodManager2, qVar9.adm());
            }
        }
    }
}
