package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class bh implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity eNd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity) {
        this.eNd = writeActivity;
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
        editText = this.eNd.eJn;
        if (view != editText) {
            view2 = this.eNd.ajA;
            if (view != view2) {
                textView2 = this.eNd.eJs;
            }
        }
        if (!z) {
            editText2 = this.eNd.eJn;
            if (view == editText2) {
                textView = this.eNd.eJt;
                textView.setVisibility(0);
            }
        } else {
            this.eNd.eNa = true;
            this.eNd.bbj();
            lVar = this.eNd.atG;
            lVar.BD();
            Activity activity = this.eNd.getActivity();
            editText3 = this.eNd.eJn;
            com.baidu.adp.lib.util.k.d(activity, editText3);
        }
        editText4 = this.eNd.eJr;
        if (view == editText4) {
            if (!z) {
                writeData = this.eNd.esv;
                if (writeData.getType() == 0) {
                    editText5 = this.eNd.eJr;
                    editText5.setHint(t.j.content);
                    return;
                }
                return;
            }
            this.eNd.eNa = false;
            writeData2 = this.eNd.esv;
            if (writeData2.getType() != 0) {
                writeData3 = this.eNd.esv;
            }
            editText6 = this.eNd.eJr;
            editText6.setHint((CharSequence) null);
            this.eNd.bbj();
            lVar2 = this.eNd.atG;
            lVar2.BD();
            Activity activity2 = this.eNd.getActivity();
            editText7 = this.eNd.eJr;
            com.baidu.adp.lib.util.k.d(activity2, editText7);
        }
    }
}
