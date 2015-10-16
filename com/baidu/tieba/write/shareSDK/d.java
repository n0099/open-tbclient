package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class d implements View.OnFocusChangeListener {
    final /* synthetic */ WriteShareActivity dmy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WriteShareActivity writeShareActivity) {
        this.dmy = writeShareActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r4 == r0.aCo()) goto L19;
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
        oVar = this.dmy.dmi;
        if (oVar != null) {
            oVar2 = this.dmy.dmi;
            if (view != oVar2.aCl()) {
                oVar11 = this.dmy.dmi;
                if (view != oVar11.aCn()) {
                    oVar12 = this.dmy.dmi;
                }
            }
            if (!z) {
                oVar3 = this.dmy.dmi;
                if (view == oVar3.aCl()) {
                    oVar4 = this.dmy.dmi;
                    if (oVar4.aCp() != null) {
                        oVar5 = this.dmy.dmi;
                        oVar5.aCp().setVisibility(0);
                    }
                }
            } else {
                WriteShareActivity writeShareActivity = this.dmy;
                inputMethodManager = this.dmy.mInputManager;
                oVar6 = this.dmy.dmi;
                writeShareActivity.ShowSoftKeyPad(inputMethodManager, oVar6.aCl());
            }
            oVar7 = this.dmy.dmi;
            if (view == oVar7.amS()) {
                if (z) {
                    oVar10 = this.dmy.dmi;
                    oVar10.amS().setHint((CharSequence) null);
                } else {
                    oVar8 = this.dmy.dmi;
                    oVar8.amS().setHint(i.h.content);
                }
                WriteShareActivity writeShareActivity2 = this.dmy;
                inputMethodManager2 = this.dmy.mInputManager;
                oVar9 = this.dmy.dmi;
                writeShareActivity2.ShowSoftKeyPad(inputMethodManager2, oVar9.aCl());
            }
        }
    }
}
