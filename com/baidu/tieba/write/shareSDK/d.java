package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class d implements View.OnFocusChangeListener {
    final /* synthetic */ WriteShareActivity fac;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WriteShareActivity writeShareActivity) {
        this.fac = writeShareActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r4 == r0.bcv()) goto L19;
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
        oVar = this.fac.eZM;
        if (oVar != null) {
            oVar2 = this.fac.eZM;
            if (view != oVar2.bcs()) {
                oVar11 = this.fac.eZM;
                if (view != oVar11.bcu()) {
                    oVar12 = this.fac.eZM;
                }
            }
            if (!z) {
                oVar3 = this.fac.eZM;
                if (view == oVar3.bcs()) {
                    oVar4 = this.fac.eZM;
                    if (oVar4.bcw() != null) {
                        oVar5 = this.fac.eZM;
                        oVar5.bcw().setVisibility(0);
                    }
                }
            } else {
                WriteShareActivity writeShareActivity = this.fac;
                inputMethodManager = this.fac.mInputManager;
                oVar6 = this.fac.eZM;
                writeShareActivity.ShowSoftKeyPad(inputMethodManager, oVar6.bcs());
            }
            oVar7 = this.fac.eZM;
            if (view == oVar7.aIZ()) {
                if (z) {
                    oVar10 = this.fac.eZM;
                    oVar10.aIZ().setHint((CharSequence) null);
                } else {
                    oVar8 = this.fac.eZM;
                    oVar8.aIZ().setHint(t.j.content);
                }
                WriteShareActivity writeShareActivity2 = this.fac;
                inputMethodManager2 = this.fac.mInputManager;
                oVar9 = this.fac.eZM;
                writeShareActivity2.ShowSoftKeyPad(inputMethodManager2, oVar9.bcs());
            }
        }
    }
}
