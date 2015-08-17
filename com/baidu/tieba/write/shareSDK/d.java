package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class d implements View.OnFocusChangeListener {
    final /* synthetic */ WriteShareActivity cSj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WriteShareActivity writeShareActivity) {
        this.cSj = writeShareActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r4 == r0.auC()) goto L19;
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
        oVar = this.cSj.cRT;
        if (oVar != null) {
            oVar2 = this.cSj.cRT;
            if (view != oVar2.auy()) {
                oVar11 = this.cSj.cRT;
                if (view != oVar11.auB()) {
                    oVar12 = this.cSj.cRT;
                }
            }
            if (!z) {
                oVar3 = this.cSj.cRT;
                if (view == oVar3.auy()) {
                    oVar4 = this.cSj.cRT;
                    if (oVar4.auD() != null) {
                        oVar5 = this.cSj.cRT;
                        oVar5.auD().setVisibility(0);
                    }
                }
            } else {
                WriteShareActivity writeShareActivity = this.cSj;
                inputMethodManager = this.cSj.mInputManager;
                oVar6 = this.cSj.cRT;
                writeShareActivity.ShowSoftKeyPad(inputMethodManager, oVar6.auy());
            }
            oVar7 = this.cSj.cRT;
            if (view == oVar7.auz()) {
                if (z) {
                    oVar10 = this.cSj.cRT;
                    oVar10.auz().setHint((CharSequence) null);
                } else {
                    oVar8 = this.cSj.cRT;
                    oVar8.auz().setHint(i.C0057i.content);
                }
                WriteShareActivity writeShareActivity2 = this.cSj;
                inputMethodManager2 = this.cSj.mInputManager;
                oVar9 = this.cSj.cRT;
                writeShareActivity2.ShowSoftKeyPad(inputMethodManager2, oVar9.auy());
            }
        }
    }
}
