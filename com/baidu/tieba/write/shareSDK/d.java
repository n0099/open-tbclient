package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class d implements View.OnFocusChangeListener {
    final /* synthetic */ WriteShareActivity fFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WriteShareActivity writeShareActivity) {
        this.fFg = writeShareActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r4 == r0.bkQ()) goto L19;
     */
    @Override // android.view.View.OnFocusChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFocusChange(View view, boolean z) {
        o oVar;
        o oVar2;
        o oVar3;
        o oVar4;
        o oVar5;
        InputMethodManager inputMethodManager;
        o oVar6;
        o oVar7;
        o oVar8;
        InputMethodManager inputMethodManager2;
        o oVar9;
        o oVar10;
        o oVar11;
        o oVar12;
        oVar = this.fFg.fEQ;
        if (oVar != null) {
            oVar2 = this.fFg.fEQ;
            if (view != oVar2.bkN()) {
                oVar11 = this.fFg.fEQ;
                if (view != oVar11.bkP()) {
                    oVar12 = this.fFg.fEQ;
                }
            }
            if (!z) {
                oVar3 = this.fFg.fEQ;
                if (view == oVar3.bkN()) {
                    oVar4 = this.fFg.fEQ;
                    if (oVar4.bkR() != null) {
                        oVar5 = this.fFg.fEQ;
                        oVar5.bkR().setVisibility(0);
                    }
                }
            } else {
                WriteShareActivity writeShareActivity = this.fFg;
                inputMethodManager = this.fFg.mInputManager;
                oVar6 = this.fFg.fEQ;
                writeShareActivity.ShowSoftKeyPad(inputMethodManager, oVar6.bkN());
            }
            oVar7 = this.fFg.fEQ;
            if (view == oVar7.aRU()) {
                if (z) {
                    oVar10 = this.fFg.fEQ;
                    oVar10.aRU().setHint((CharSequence) null);
                } else {
                    oVar8 = this.fFg.fEQ;
                    oVar8.aRU().setHint(u.j.content);
                }
                WriteShareActivity writeShareActivity2 = this.fFg;
                inputMethodManager2 = this.fFg.mInputManager;
                oVar9 = this.fFg.fEQ;
                writeShareActivity2.ShowSoftKeyPad(inputMethodManager2, oVar9.bkN());
            }
        }
    }
}
