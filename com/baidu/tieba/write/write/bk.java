package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class bk implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity feb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(WriteActivity writeActivity) {
        this.feb = writeActivity;
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
        com.baidu.tbadk.editortools.l lVar;
        EditText editText3;
        EditText editText4;
        WriteData writeData;
        EditText editText5;
        WriteData writeData2;
        EditText editText6;
        com.baidu.tbadk.editortools.l lVar2;
        EditText editText7;
        WriteData writeData3;
        View view2;
        TextView textView2;
        editText = this.feb.fae;
        if (view != editText) {
            view2 = this.feb.afm;
            if (view != view2) {
                textView2 = this.feb.faj;
            }
        }
        if (!z) {
            editText2 = this.feb.fae;
            if (view == editText2) {
                textView = this.feb.fak;
                textView.setVisibility(0);
            }
        } else {
            this.feb.fdY = true;
            this.feb.bdw();
            lVar = this.feb.apy;
            lVar.zx();
            Activity activity = this.feb.getActivity();
            editText3 = this.feb.fae;
            com.baidu.adp.lib.util.k.b(activity, editText3);
        }
        editText4 = this.feb.fai;
        if (view == editText4) {
            if (!z) {
                writeData = this.feb.evE;
                if (writeData.getType() == 0) {
                    editText5 = this.feb.fai;
                    editText5.setHint(t.j.content);
                    return;
                }
                return;
            }
            this.feb.fdY = false;
            writeData2 = this.feb.evE;
            if (writeData2.getType() != 0) {
                writeData3 = this.feb.evE;
            }
            editText6 = this.feb.fai;
            editText6.setHint((CharSequence) null);
            this.feb.bdw();
            lVar2 = this.feb.apy;
            lVar2.zx();
            Activity activity2 = this.feb.getActivity();
            editText7 = this.feb.fai;
            com.baidu.adp.lib.util.k.b(activity2, editText7);
        }
    }
}
