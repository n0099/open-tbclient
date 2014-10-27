package com.baidu.tieba.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class l implements View.OnFocusChangeListener {
    final /* synthetic */ WriteShareActivity bJq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteShareActivity writeShareActivity) {
        this.bJq = writeShareActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r4 == r0.aco()) goto L19;
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
        oVar = this.bJq.bJe;
        if (oVar != null) {
            oVar2 = this.bJq.bJe;
            if (view != oVar2.ack()) {
                oVar11 = this.bJq.bJe;
                if (view != oVar11.acn()) {
                    oVar12 = this.bJq.bJe;
                }
            }
            if (!z) {
                oVar3 = this.bJq.bJe;
                if (view == oVar3.ack()) {
                    oVar4 = this.bJq.bJe;
                    if (oVar4.acp() != null) {
                        oVar5 = this.bJq.bJe;
                        oVar5.acp().setVisibility(0);
                    }
                }
            } else {
                WriteShareActivity writeShareActivity = this.bJq;
                inputMethodManager = this.bJq.mInputManager;
                oVar6 = this.bJq.bJe;
                writeShareActivity.ShowSoftKeyPad(inputMethodManager, oVar6.ack());
            }
            oVar7 = this.bJq.bJe;
            if (view == oVar7.acl()) {
                if (z) {
                    oVar10 = this.bJq.bJe;
                    oVar10.acl().setHint((CharSequence) null);
                } else {
                    oVar8 = this.bJq.bJe;
                    oVar8.acl().setHint(y.content);
                }
                WriteShareActivity writeShareActivity2 = this.bJq;
                inputMethodManager2 = this.bJq.mInputManager;
                oVar9 = this.bJq.bJe;
                writeShareActivity2.ShowSoftKeyPad(inputMethodManager2, oVar9.ack());
            }
        }
    }
}
