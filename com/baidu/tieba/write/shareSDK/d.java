package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class d implements View.OnFocusChangeListener {
    final /* synthetic */ WriteShareActivity dlY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WriteShareActivity writeShareActivity) {
        this.dlY = writeShareActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r4 == r0.aCe()) goto L19;
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
        oVar = this.dlY.dlI;
        if (oVar != null) {
            oVar2 = this.dlY.dlI;
            if (view != oVar2.aCb()) {
                oVar11 = this.dlY.dlI;
                if (view != oVar11.aCd()) {
                    oVar12 = this.dlY.dlI;
                }
            }
            if (!z) {
                oVar3 = this.dlY.dlI;
                if (view == oVar3.aCb()) {
                    oVar4 = this.dlY.dlI;
                    if (oVar4.aCf() != null) {
                        oVar5 = this.dlY.dlI;
                        oVar5.aCf().setVisibility(0);
                    }
                }
            } else {
                WriteShareActivity writeShareActivity = this.dlY;
                inputMethodManager = this.dlY.mInputManager;
                oVar6 = this.dlY.dlI;
                writeShareActivity.ShowSoftKeyPad(inputMethodManager, oVar6.aCb());
            }
            oVar7 = this.dlY.dlI;
            if (view == oVar7.amS()) {
                if (z) {
                    oVar10 = this.dlY.dlI;
                    oVar10.amS().setHint((CharSequence) null);
                } else {
                    oVar8 = this.dlY.dlI;
                    oVar8.amS().setHint(i.h.content);
                }
                WriteShareActivity writeShareActivity2 = this.dlY;
                inputMethodManager2 = this.dlY.mInputManager;
                oVar9 = this.dlY.dlI;
                writeShareActivity2.ShowSoftKeyPad(inputMethodManager2, oVar9.aCb());
            }
        }
    }
}
