package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class e implements View.OnFocusChangeListener {
    final /* synthetic */ WriteShareActivity cvN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WriteShareActivity writeShareActivity) {
        this.cvN = writeShareActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r4 == r0.aqG()) goto L19;
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
        qVar = this.cvN.cvy;
        if (qVar != null) {
            qVar2 = this.cvN.cvy;
            if (view != qVar2.aqC()) {
                qVar11 = this.cvN.cvy;
                if (view != qVar11.aqF()) {
                    qVar12 = this.cvN.cvy;
                }
            }
            if (!z) {
                qVar3 = this.cvN.cvy;
                if (view == qVar3.aqC()) {
                    qVar4 = this.cvN.cvy;
                    if (qVar4.aqH() != null) {
                        qVar5 = this.cvN.cvy;
                        qVar5.aqH().setVisibility(0);
                    }
                }
            } else {
                WriteShareActivity writeShareActivity = this.cvN;
                inputMethodManager = this.cvN.mInputManager;
                qVar6 = this.cvN.cvy;
                writeShareActivity.ShowSoftKeyPad(inputMethodManager, qVar6.aqC());
            }
            qVar7 = this.cvN.cvy;
            if (view == qVar7.aqD()) {
                if (z) {
                    qVar10 = this.cvN.cvy;
                    qVar10.aqD().setHint((CharSequence) null);
                } else {
                    qVar8 = this.cvN.cvy;
                    qVar8.aqD().setHint(com.baidu.tieba.y.content);
                }
                WriteShareActivity writeShareActivity2 = this.cvN;
                inputMethodManager2 = this.cvN.mInputManager;
                qVar9 = this.cvN.cvy;
                writeShareActivity2.ShowSoftKeyPad(inputMethodManager2, qVar9.aqC());
            }
        }
    }
}
