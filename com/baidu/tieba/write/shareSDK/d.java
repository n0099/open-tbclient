package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class d implements View.OnFocusChangeListener {
    final /* synthetic */ WriteShareActivity dog;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WriteShareActivity writeShareActivity) {
        this.dog = writeShareActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r4 == r0.aDa()) goto L19;
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
        oVar = this.dog.dnQ;
        if (oVar != null) {
            oVar2 = this.dog.dnQ;
            if (view != oVar2.aCX()) {
                oVar11 = this.dog.dnQ;
                if (view != oVar11.aCZ()) {
                    oVar12 = this.dog.dnQ;
                }
            }
            if (!z) {
                oVar3 = this.dog.dnQ;
                if (view == oVar3.aCX()) {
                    oVar4 = this.dog.dnQ;
                    if (oVar4.aDb() != null) {
                        oVar5 = this.dog.dnQ;
                        oVar5.aDb().setVisibility(0);
                    }
                }
            } else {
                WriteShareActivity writeShareActivity = this.dog;
                inputMethodManager = this.dog.mInputManager;
                oVar6 = this.dog.dnQ;
                writeShareActivity.ShowSoftKeyPad(inputMethodManager, oVar6.aCX());
            }
            oVar7 = this.dog.dnQ;
            if (view == oVar7.anu()) {
                if (z) {
                    oVar10 = this.dog.dnQ;
                    oVar10.anu().setHint((CharSequence) null);
                } else {
                    oVar8 = this.dog.dnQ;
                    oVar8.anu().setHint(i.h.content);
                }
                WriteShareActivity writeShareActivity2 = this.dog;
                inputMethodManager2 = this.dog.mInputManager;
                oVar9 = this.dog.dnQ;
                writeShareActivity2.ShowSoftKeyPad(inputMethodManager2, oVar9.aCX());
            }
        }
    }
}
