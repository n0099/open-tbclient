package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class d implements View.OnFocusChangeListener {
    final /* synthetic */ WriteShareActivity fad;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WriteShareActivity writeShareActivity) {
        this.fad = writeShareActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r4 == r0.bco()) goto L19;
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
        oVar = this.fad.eZN;
        if (oVar != null) {
            oVar2 = this.fad.eZN;
            if (view != oVar2.bcl()) {
                oVar11 = this.fad.eZN;
                if (view != oVar11.bcn()) {
                    oVar12 = this.fad.eZN;
                }
            }
            if (!z) {
                oVar3 = this.fad.eZN;
                if (view == oVar3.bcl()) {
                    oVar4 = this.fad.eZN;
                    if (oVar4.bcp() != null) {
                        oVar5 = this.fad.eZN;
                        oVar5.bcp().setVisibility(0);
                    }
                }
            } else {
                WriteShareActivity writeShareActivity = this.fad;
                inputMethodManager = this.fad.mInputManager;
                oVar6 = this.fad.eZN;
                writeShareActivity.ShowSoftKeyPad(inputMethodManager, oVar6.bcl());
            }
            oVar7 = this.fad.eZN;
            if (view == oVar7.aIW()) {
                if (z) {
                    oVar10 = this.fad.eZN;
                    oVar10.aIW().setHint((CharSequence) null);
                } else {
                    oVar8 = this.fad.eZN;
                    oVar8.aIW().setHint(t.j.content);
                }
                WriteShareActivity writeShareActivity2 = this.fad;
                inputMethodManager2 = this.fad.mInputManager;
                oVar9 = this.fad.eZN;
                writeShareActivity2.ShowSoftKeyPad(inputMethodManager2, oVar9.bcl());
            }
        }
    }
}
