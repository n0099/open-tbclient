package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class bh implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity gfs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity) {
        this.gfs = writeActivity;
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
        editText = this.gfs.fiX;
        if (view != editText) {
            view2 = this.gfs.ajw;
            if (view != view2) {
                textView2 = this.gfs.fjc;
            }
        }
        if (!z) {
            editText2 = this.gfs.fiX;
            if (view == editText2) {
                textView = this.gfs.fjd;
                textView.setVisibility(0);
            }
        } else {
            this.gfs.gfo = true;
            this.gfs.bti();
            lVar = this.gfs.auk;
            lVar.AS();
            Activity activity = this.gfs.getActivity();
            editText3 = this.gfs.fiX;
            com.baidu.adp.lib.util.k.c(activity, editText3);
        }
        editText4 = this.gfs.fjb;
        if (view == editText4) {
            if (!z) {
                writeData = this.gfs.fiE;
                if (writeData.getType() == 0) {
                    editText5 = this.gfs.fjb;
                    editText5.setHint(t.j.write_input_content);
                    return;
                }
                return;
            }
            this.gfs.gfo = false;
            writeData2 = this.gfs.fiE;
            if (writeData2.getType() != 0) {
                writeData3 = this.gfs.fiE;
            }
            editText6 = this.gfs.fjb;
            editText6.setHint((CharSequence) null);
            this.gfs.bti();
            lVar2 = this.gfs.auk;
            lVar2.AS();
            Activity activity2 = this.gfs.getActivity();
            editText7 = this.gfs.fjb;
            com.baidu.adp.lib.util.k.c(activity2, editText7);
        }
    }
}
