package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class d implements View.OnFocusChangeListener {
    final /* synthetic */ WriteShareActivity epq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WriteShareActivity writeShareActivity) {
        this.epq = writeShareActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r4 == r0.aTC()) goto L19;
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
        oVar = this.epq.epa;
        if (oVar != null) {
            oVar2 = this.epq.epa;
            if (view != oVar2.aTz()) {
                oVar11 = this.epq.epa;
                if (view != oVar11.aTB()) {
                    oVar12 = this.epq.epa;
                }
            }
            if (!z) {
                oVar3 = this.epq.epa;
                if (view == oVar3.aTz()) {
                    oVar4 = this.epq.epa;
                    if (oVar4.aTD() != null) {
                        oVar5 = this.epq.epa;
                        oVar5.aTD().setVisibility(0);
                    }
                }
            } else {
                WriteShareActivity writeShareActivity = this.epq;
                inputMethodManager = this.epq.mInputManager;
                oVar6 = this.epq.epa;
                writeShareActivity.ShowSoftKeyPad(inputMethodManager, oVar6.aTz());
            }
            oVar7 = this.epq.epa;
            if (view == oVar7.aAU()) {
                if (z) {
                    oVar10 = this.epq.epa;
                    oVar10.aAU().setHint((CharSequence) null);
                } else {
                    oVar8 = this.epq.epa;
                    oVar8.aAU().setHint(t.j.content);
                }
                WriteShareActivity writeShareActivity2 = this.epq;
                inputMethodManager2 = this.epq.mInputManager;
                oVar9 = this.epq.epa;
                writeShareActivity2.ShowSoftKeyPad(inputMethodManager2, oVar9.aTz());
            }
        }
    }
}
