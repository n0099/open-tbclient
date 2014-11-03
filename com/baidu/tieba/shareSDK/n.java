package com.baidu.tieba.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class n implements View.OnFocusChangeListener {
    final /* synthetic */ WriteShareActivity bJF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(WriteShareActivity writeShareActivity) {
        this.bJF = writeShareActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r4 == r0.acr()) goto L19;
     */
    @Override // android.view.View.OnFocusChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFocusChange(View view, boolean z) {
        p pVar;
        p pVar2;
        p pVar3;
        p pVar4;
        p pVar5;
        InputMethodManager inputMethodManager;
        p pVar6;
        p pVar7;
        p pVar8;
        InputMethodManager inputMethodManager2;
        p pVar9;
        p pVar10;
        p pVar11;
        p pVar12;
        pVar = this.bJF.bJs;
        if (pVar != null) {
            pVar2 = this.bJF.bJs;
            if (view != pVar2.acn()) {
                pVar11 = this.bJF.bJs;
                if (view != pVar11.acq()) {
                    pVar12 = this.bJF.bJs;
                }
            }
            if (!z) {
                pVar3 = this.bJF.bJs;
                if (view == pVar3.acn()) {
                    pVar4 = this.bJF.bJs;
                    if (pVar4.acs() != null) {
                        pVar5 = this.bJF.bJs;
                        pVar5.acs().setVisibility(0);
                    }
                }
            } else {
                WriteShareActivity writeShareActivity = this.bJF;
                inputMethodManager = this.bJF.mInputManager;
                pVar6 = this.bJF.bJs;
                writeShareActivity.ShowSoftKeyPad(inputMethodManager, pVar6.acn());
            }
            pVar7 = this.bJF.bJs;
            if (view == pVar7.aco()) {
                if (z) {
                    pVar10 = this.bJF.bJs;
                    pVar10.aco().setHint((CharSequence) null);
                } else {
                    pVar8 = this.bJF.bJs;
                    pVar8.aco().setHint(y.content);
                }
                WriteShareActivity writeShareActivity2 = this.bJF;
                inputMethodManager2 = this.bJF.mInputManager;
                pVar9 = this.bJF.bJs;
                writeShareActivity2.ShowSoftKeyPad(inputMethodManager2, pVar9.acn());
            }
        }
    }
}
