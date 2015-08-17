package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class bd implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity cUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(WriteActivity writeActivity) {
        this.cUM = writeActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0064, code lost:
        if (r0.getType() == 4) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
        if (r5 == r0) goto L28;
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
        WriteData writeData2;
        EditText editText5;
        EditText editText6;
        WriteData writeData3;
        EditText editText7;
        com.baidu.tbadk.editortools.j jVar2;
        EditText editText8;
        WriteData writeData4;
        View view2;
        TextView textView2;
        editText = this.cUM.cSk;
        if (view != editText) {
            view2 = this.cUM.mBack;
            if (view != view2) {
                textView2 = this.cUM.cSp;
            }
        }
        if (!z) {
            editText2 = this.cUM.cSk;
            if (view == editText2) {
                textView = this.cUM.cSq;
                textView.setVisibility(0);
            }
        } else {
            this.cUM.cUJ = true;
            this.cUM.auX();
            jVar = this.cUM.cUo;
            jVar.zk();
            Activity activity = this.cUM.getActivity();
            editText3 = this.cUM.cSk;
            com.baidu.adp.lib.util.k.d(activity, editText3);
        }
        editText4 = this.cUM.cSo;
        if (view == editText4) {
            if (!z) {
                writeData = this.cUM.cKS;
                if (writeData.getType() != 0) {
                    writeData2 = this.cUM.cKS;
                    if (writeData2.getType() == 4) {
                        editText5 = this.cUM.cSo;
                        editText5.setHint(i.C0057i.write_input_content);
                        return;
                    }
                    return;
                }
                editText6 = this.cUM.cSo;
                editText6.setHint(i.C0057i.content);
                return;
            }
            this.cUM.cUJ = false;
            writeData3 = this.cUM.cKS;
            if (writeData3.getType() != 0) {
                writeData4 = this.cUM.cKS;
            }
            editText7 = this.cUM.cSo;
            editText7.setHint((CharSequence) null);
            this.cUM.auX();
            jVar2 = this.cUM.cUo;
            jVar2.zk();
            Activity activity2 = this.cUM.getActivity();
            editText8 = this.cUM.cSo;
            com.baidu.adp.lib.util.k.d(activity2, editText8);
        }
    }
}
