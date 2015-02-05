package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.tbadkCore.PbEditor.TbEditorToolButtonContainer;
/* loaded from: classes.dex */
class bl implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity cgR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(WriteActivity writeActivity) {
        this.cgR = writeActivity;
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
        editText = this.cgR.bPF;
        if (view != editText) {
            view2 = this.cgR.mBack;
            if (view != view2) {
                textView2 = this.cgR.bPK;
            }
        }
        if (!z) {
            editText2 = this.cgR.bPF;
            if (view == editText2) {
                textView = this.cgR.bPL;
                textView.setVisibility(0);
            }
        } else {
            this.cgR.cgO = true;
            this.cgR.akq();
            tbEditorToolButtonContainer = this.cgR.cgz;
            tbEditorToolButtonContainer.afr();
            editorToolComponetContainer = this.cgR.bWj;
            editText3 = this.cgR.bPF;
            editorToolComponetContainer.X(editText3);
        }
        editText4 = this.cgR.bPJ;
        if (view == editText4) {
            if (!z) {
                writeData = this.cgR.bPo;
                if (writeData.getType() == 0) {
                    editText5 = this.cgR.bPJ;
                    editText5.setHint(com.baidu.tieba.z.write_activity_content);
                    return;
                }
                return;
            }
            this.cgR.cgO = false;
            writeData2 = this.cgR.bPo;
            if (writeData2.getType() == 0) {
                editText7 = this.cgR.bPJ;
                editText7.setHint((CharSequence) null);
            }
            this.cgR.akq();
            tbEditorToolButtonContainer2 = this.cgR.cgz;
            tbEditorToolButtonContainer2.afr();
            editorToolComponetContainer2 = this.cgR.bWj;
            editText6 = this.cgR.bPJ;
            editorToolComponetContainer2.X(editText6);
        }
    }
}
