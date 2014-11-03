package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
import com.baidu.tieba.editortool.TbEditorToolButtonContainer;
/* loaded from: classes.dex */
class bl implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity bUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(WriteActivity writeActivity) {
        this.bUm = writeActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4 == r0) goto L22;
     */
    @Override // android.view.View.OnFocusChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        TextView textView;
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText3;
        EditText editText4;
        WriteData writeData;
        EditText editText5;
        WriteData writeData2;
        TbEditorToolButtonContainer tbEditorToolButtonContainer2;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText6;
        EditText editText7;
        View view2;
        TextView textView2;
        editText = this.bUm.bJG;
        if (view != editText) {
            view2 = this.bUm.Jt;
            if (view != view2) {
                textView2 = this.bUm.bJL;
            }
        }
        if (!z) {
            editText2 = this.bUm.bJG;
            if (view == editText2) {
                textView = this.bUm.bJM;
                textView.setVisibility(0);
            }
        } else {
            this.bUm.bUk = true;
            this.bUm.afu();
            tbEditorToolButtonContainer = this.bUm.bTU;
            tbEditorToolButtonContainer.Bi();
            editorToolComponetContainer = this.bUm.arn;
            editText3 = this.bUm.bJG;
            editorToolComponetContainer.x(editText3);
        }
        editText4 = this.bUm.bJK;
        if (view == editText4) {
            if (!z) {
                writeData = this.bUm.bpJ;
                if (writeData.getType() == 0) {
                    editText5 = this.bUm.bJK;
                    editText5.setHint(com.baidu.tieba.y.content);
                    return;
                }
                return;
            }
            this.bUm.bUk = false;
            writeData2 = this.bUm.bpJ;
            if (writeData2.getType() == 0) {
                editText7 = this.bUm.bJK;
                editText7.setHint((CharSequence) null);
            }
            this.bUm.afu();
            tbEditorToolButtonContainer2 = this.bUm.bTU;
            tbEditorToolButtonContainer2.Bi();
            editorToolComponetContainer2 = this.bUm.arn;
            editText6 = this.bUm.bJK;
            editorToolComponetContainer2.x(editText6);
        }
    }
}
