package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class d implements View.OnFocusChangeListener {
    final /* synthetic */ WriteShareActivity dNm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WriteShareActivity writeShareActivity) {
        this.dNm = writeShareActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r4 == r0.aIx()) goto L19;
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
        oVar = this.dNm.dMW;
        if (oVar != null) {
            oVar2 = this.dNm.dMW;
            if (view != oVar2.aIu()) {
                oVar11 = this.dNm.dMW;
                if (view != oVar11.aIw()) {
                    oVar12 = this.dNm.dMW;
                }
            }
            if (!z) {
                oVar3 = this.dNm.dMW;
                if (view == oVar3.aIu()) {
                    oVar4 = this.dNm.dMW;
                    if (oVar4.aIy() != null) {
                        oVar5 = this.dNm.dMW;
                        oVar5.aIy().setVisibility(0);
                    }
                }
            } else {
                WriteShareActivity writeShareActivity = this.dNm;
                inputMethodManager = this.dNm.mInputManager;
                oVar6 = this.dNm.dMW;
                writeShareActivity.ShowSoftKeyPad(inputMethodManager, oVar6.aIu());
            }
            oVar7 = this.dNm.dMW;
            if (view == oVar7.asU()) {
                if (z) {
                    oVar10 = this.dNm.dMW;
                    oVar10.asU().setHint((CharSequence) null);
                } else {
                    oVar8 = this.dNm.dMW;
                    oVar8.asU().setHint(n.i.content);
                }
                WriteShareActivity writeShareActivity2 = this.dNm;
                inputMethodManager2 = this.dNm.mInputManager;
                oVar9 = this.dNm.dMW;
                writeShareActivity2.ShowSoftKeyPad(inputMethodManager2, oVar9.aIu());
            }
        }
    }
}
