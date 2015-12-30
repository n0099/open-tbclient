package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class d implements View.OnFocusChangeListener {
    final /* synthetic */ WriteShareActivity dUL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WriteShareActivity writeShareActivity) {
        this.dUL = writeShareActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r4 == r0.aKS()) goto L19;
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
        oVar = this.dUL.dUv;
        if (oVar != null) {
            oVar2 = this.dUL.dUv;
            if (view != oVar2.aKP()) {
                oVar11 = this.dUL.dUv;
                if (view != oVar11.aKR()) {
                    oVar12 = this.dUL.dUv;
                }
            }
            if (!z) {
                oVar3 = this.dUL.dUv;
                if (view == oVar3.aKP()) {
                    oVar4 = this.dUL.dUv;
                    if (oVar4.aKT() != null) {
                        oVar5 = this.dUL.dUv;
                        oVar5.aKT().setVisibility(0);
                    }
                }
            } else {
                WriteShareActivity writeShareActivity = this.dUL;
                inputMethodManager = this.dUL.mInputManager;
                oVar6 = this.dUL.dUv;
                writeShareActivity.ShowSoftKeyPad(inputMethodManager, oVar6.aKP());
            }
            oVar7 = this.dUL.dUv;
            if (view == oVar7.auG()) {
                if (z) {
                    oVar10 = this.dUL.dUv;
                    oVar10.auG().setHint((CharSequence) null);
                } else {
                    oVar8 = this.dUL.dUv;
                    oVar8.auG().setHint(n.j.content);
                }
                WriteShareActivity writeShareActivity2 = this.dUL;
                inputMethodManager2 = this.dUL.mInputManager;
                oVar9 = this.dUL.dUv;
                writeShareActivity2.ShowSoftKeyPad(inputMethodManager2, oVar9.aKP());
            }
        }
    }
}
