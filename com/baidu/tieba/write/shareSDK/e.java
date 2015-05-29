package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class e implements View.OnFocusChangeListener {
    final /* synthetic */ WriteShareActivity cAt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WriteShareActivity writeShareActivity) {
        this.cAt = writeShareActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r4 == r0.asL()) goto L19;
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
        qVar = this.cAt.cAe;
        if (qVar != null) {
            qVar2 = this.cAt.cAe;
            if (view != qVar2.asH()) {
                qVar11 = this.cAt.cAe;
                if (view != qVar11.asK()) {
                    qVar12 = this.cAt.cAe;
                }
            }
            if (!z) {
                qVar3 = this.cAt.cAe;
                if (view == qVar3.asH()) {
                    qVar4 = this.cAt.cAe;
                    if (qVar4.asM() != null) {
                        qVar5 = this.cAt.cAe;
                        qVar5.asM().setVisibility(0);
                    }
                }
            } else {
                WriteShareActivity writeShareActivity = this.cAt;
                inputMethodManager = this.cAt.mInputManager;
                qVar6 = this.cAt.cAe;
                writeShareActivity.ShowSoftKeyPad(inputMethodManager, qVar6.asH());
            }
            qVar7 = this.cAt.cAe;
            if (view == qVar7.asI()) {
                if (z) {
                    qVar10 = this.cAt.cAe;
                    qVar10.asI().setHint((CharSequence) null);
                } else {
                    qVar8 = this.cAt.cAe;
                    qVar8.asI().setHint(com.baidu.tieba.t.content);
                }
                WriteShareActivity writeShareActivity2 = this.cAt;
                inputMethodManager2 = this.cAt.mInputManager;
                qVar9 = this.cAt.cAe;
                writeShareActivity2.ShowSoftKeyPad(inputMethodManager2, qVar9.asH());
            }
        }
    }
}
