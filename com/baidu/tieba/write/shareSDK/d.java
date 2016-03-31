package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class d implements View.OnFocusChangeListener {
    final /* synthetic */ WriteShareActivity eJm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WriteShareActivity writeShareActivity) {
        this.eJm = writeShareActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r4 == r0.bac()) goto L19;
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
        oVar = this.eJm.eIW;
        if (oVar != null) {
            oVar2 = this.eJm.eIW;
            if (view != oVar2.aZZ()) {
                oVar11 = this.eJm.eIW;
                if (view != oVar11.bab()) {
                    oVar12 = this.eJm.eIW;
                }
            }
            if (!z) {
                oVar3 = this.eJm.eIW;
                if (view == oVar3.aZZ()) {
                    oVar4 = this.eJm.eIW;
                    if (oVar4.bad() != null) {
                        oVar5 = this.eJm.eIW;
                        oVar5.bad().setVisibility(0);
                    }
                }
            } else {
                WriteShareActivity writeShareActivity = this.eJm;
                inputMethodManager = this.eJm.mInputManager;
                oVar6 = this.eJm.eIW;
                writeShareActivity.ShowSoftKeyPad(inputMethodManager, oVar6.aZZ());
            }
            oVar7 = this.eJm.eIW;
            if (view == oVar7.aII()) {
                if (z) {
                    oVar10 = this.eJm.eIW;
                    oVar10.aII().setHint((CharSequence) null);
                } else {
                    oVar8 = this.eJm.eIW;
                    oVar8.aII().setHint(t.j.content);
                }
                WriteShareActivity writeShareActivity2 = this.eJm;
                inputMethodManager2 = this.eJm.mInputManager;
                oVar9 = this.eJm.eIW;
                writeShareActivity2.ShowSoftKeyPad(inputMethodManager2, oVar9.aZZ());
            }
        }
    }
}
