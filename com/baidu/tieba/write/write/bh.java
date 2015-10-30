package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class bh implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity dqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity) {
        this.dqi = writeActivity;
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
        com.baidu.tbadk.editortools.j jVar;
        EditText editText3;
        EditText editText4;
        WriteData writeData;
        EditText editText5;
        WriteData writeData2;
        EditText editText6;
        com.baidu.tbadk.editortools.j jVar2;
        EditText editText7;
        WriteData writeData3;
        View view2;
        TextView textView2;
        editText = this.dqi.dmz;
        if (view != editText) {
            view2 = this.dqi.mBack;
            if (view != view2) {
                textView2 = this.dqi.dmE;
            }
        }
        if (!z) {
            editText2 = this.dqi.dmz;
            if (view == editText2) {
                textView = this.dqi.dmF;
                textView.setVisibility(0);
            }
        } else {
            this.dqi.dqf = true;
            this.dqi.aDd();
            jVar = this.dqi.dpD;
            jVar.yX();
            Activity activity = this.dqi.getActivity();
            editText3 = this.dqi.dmz;
            com.baidu.adp.lib.util.k.d(activity, editText3);
        }
        editText4 = this.dqi.dmD;
        if (view == editText4) {
            if (!z) {
                writeData = this.dqi.dbx;
                if (writeData.getType() == 0) {
                    editText5 = this.dqi.dmD;
                    editText5.setHint(i.h.content);
                    return;
                }
                return;
            }
            this.dqi.dqf = false;
            writeData2 = this.dqi.dbx;
            if (writeData2.getType() != 0) {
                writeData3 = this.dqi.dbx;
            }
            editText6 = this.dqi.dmD;
            editText6.setHint((CharSequence) null);
            this.dqi.aDd();
            jVar2 = this.dqi.dpD;
            jVar2.yX();
            Activity activity2 = this.dqi.getActivity();
            editText7 = this.dqi.dmD;
            com.baidu.adp.lib.util.k.d(activity2, editText7);
        }
    }
}
