package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class bg implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity ets;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(WriteActivity writeActivity) {
        this.ets = writeActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0064, code lost:
        if (r0.getType() == 4) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4 == r0) goto L24;
     */
    @Override // android.view.View.OnFocusChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        TextView textView;
        com.baidu.tbadk.editortools.k kVar;
        EditText editText3;
        EditText editText4;
        WriteData writeData;
        EditText editText5;
        WriteData writeData2;
        EditText editText6;
        com.baidu.tbadk.editortools.k kVar2;
        EditText editText7;
        WriteData writeData3;
        View view2;
        TextView textView2;
        editText = this.ets.epr;
        if (view != editText) {
            view2 = this.ets.ajk;
            if (view != view2) {
                textView2 = this.ets.epw;
            }
        }
        if (!z) {
            editText2 = this.ets.epr;
            if (view == editText2) {
                textView = this.ets.epx;
                textView.setVisibility(0);
            }
        } else {
            this.ets.etp = true;
            this.ets.aUI();
            kVar = this.ets.ath;
            kVar.Ba();
            Activity activity = this.ets.getActivity();
            editText3 = this.ets.epr;
            com.baidu.adp.lib.util.k.d(activity, editText3);
        }
        editText4 = this.ets.epv;
        if (view == editText4) {
            if (!z) {
                writeData = this.ets.dZC;
                if (writeData.getType() == 0) {
                    editText5 = this.ets.epv;
                    editText5.setHint(t.j.content);
                    return;
                }
                return;
            }
            this.ets.etp = false;
            writeData2 = this.ets.dZC;
            if (writeData2.getType() != 0) {
                writeData3 = this.ets.dZC;
            }
            editText6 = this.ets.epv;
            editText6.setHint((CharSequence) null);
            this.ets.aUI();
            kVar2 = this.ets.ath;
            kVar2.Ba();
            Activity activity2 = this.ets.getActivity();
            editText7 = this.ets.epv;
            com.baidu.adp.lib.util.k.d(activity2, editText7);
        }
    }
}
